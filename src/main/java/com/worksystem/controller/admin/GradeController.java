package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Grade;
import com.worksystem.entity.SchoolTimetable;
import com.worksystem.entity.Teacher;
import com.worksystem.service.GradeService;
import com.worksystem.service.SchoolTimetableService;
import com.worksystem.utils.HTMLUtils;
import com.worksystem.utils.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class GradeController {

    private final GradeService gradeService;

    private final SchoolTimetableService schoolTimetableService;

    public GradeController(GradeService gradeService, SchoolTimetableService schoolTimetableService) {
        this.gradeService = gradeService;
        this.schoolTimetableService = schoolTimetableService;
    }

    @PostMapping("/gradeAdd")
    public String gradeAdd(ModelMap modelMap, @SessionAttribute(value = "admin", required = false)Admin admin, Grade grade) {
        // 限制老师账号权限
        if (admin != null) {
            if(admin.getAgid() != 0){
                return HTMLUtils.error(modelMap, "您没有更改班级的权限！请与管理员联系！");
            }
        }

        //判断数据
        if(grade.getGname().isEmpty()) {
            return HTMLUtils.error(modelMap, "班级名称不能为空！");
        }
        if(grade.getGtotal() == null || grade.getGtotal() <= 0) {
            return HTMLUtils.error(modelMap, "班级人数不能为0或小于0！");
        }

        // 连接数据库，添加班级
        int result = gradeService.insertSelective(grade);

        // 判断是否添加成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/gradeList")
    public String gradeList(ModelMap modelMap, RedirectAttributes attr, HttpSession session) {
        Admin admin = null;
        Teacher teacher = null;
        List<Grade> grades = null;
        //判断登录账号类型
        if (session.getAttribute("admin") != null) {
            admin = (Admin) session.getAttribute("admin");
            //连接数据库获取属性
            Grade grade = null;
            // 0 为管理员
            if (admin.getAgid() == 0) {
                // 获取班级数据
                grades = gradeService.selectAll();
                modelMap.addAttribute("grades", grades);
            } else {
                grade = gradeService.selectByPrimaryKey(admin.getAgid());
                modelMap.addAttribute("grades", grade);
            }
            // 拼接 url 参数
            attr.addAttribute("act", "table");
            // 转发，直接转发到相应界面，不经过中转（因为尚未解决）
            return "/admin/table";
        } else if (session.getAttribute("teacher") != null) {
            teacher = (Teacher) session.getAttribute("teacher");
            modelMap.addAttribute("grades", gradeService.selectByTid(teacher));
            // 拼接 url 参数
            attr.addAttribute("act", "teachertable");
            // 转发，直接转发到相应界面，不经过中转（因为尚未解决）
            return "/admin/teachertable";
        }
        // else
        return HTMLUtils.error(modelMap, "请登录！", "login");
    }

    @GetMapping("/gradeModify")
    public String gradeModify(ModelMap modelMap, Integer gid) {
        modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(gid));
        modelMap.addAttribute("sts", schoolTimetableService.selectByStgid(gid));
        return "/admin/gradeModify";
    }

    @PostMapping("/gradeModify")
    public String gradeModify(ModelMap modelMap, Grade grade,String stfile, SchoolTimetable schoolTimetable, MultipartFile file, HttpSession session) {
        // 数据判断
        if (grade.getGtotal() == null || grade.getGtotal() == 0) {
            return HTMLUtils.error(modelMap, "班级人数不能为空或者负数！");
        }
        if (grade.getGname() == null || grade.getGname().isEmpty()) {
            return HTMLUtils.error(modelMap, "班级名不能为空！");
        }
        if (grade.getGtotal() == null) {
            return HTMLUtils.error(modelMap, "班级人数不能为空！");
        }

        // 作为判断是否更改成功的依据
        int result = 0;
        try {
            // 获取上下文对象
            ServletContext servletContext = session.getServletContext();
            // 文件存储路径
            String uploadPath = "school_timetable/";
            // 创建文件上传对象
            UploadUtils uploadUtils = new UploadUtils(servletContext, file, uploadPath);
            // 判断上传文件是否为空
            if (!file.isEmpty()) {
                // 判断文件类型是否为 图片
                if (uploadUtils.isImageType(file.getInputStream(), "image")) {
                    // 判断有没有原图片，不管有没有原图片，都删除原图片
                    uploadUtils.deleteFile(schoolTimetable.getStfile());
                    // 保存文件
                    Map<String, String> path = uploadUtils.upload();
                    if (path.size() > 0) {
                        System.out.println("保存图片成功！");
                    } else {
                        System.out.println("保存图片失败！");
                    }
                    // 更改图表对象数据
                    schoolTimetable.setStgid(grade.getGid());
                    schoolTimetable.setStfile(path.get(file.getOriginalFilename()));

                    // 连接数据库，更改数据
                    if(stfile != null || !stfile.isEmpty()) {
                        result += schoolTimetableService.insert(schoolTimetable);
                    } else {
                        schoolTimetable.setStid(schoolTimetableService.selectByExample(schoolTimetable).get(0).getStid());
                        result += schoolTimetableService.updateByExample(schoolTimetable);
                    }
                } else {
                    return HTMLUtils.error(modelMap, "上传的文件不是图片！");
                }
            } else {
                // 没有课表图片要更改，直接更改班级数据
                result = gradeService.updateByPrimaryKey(grade);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return HTMLUtils.error(modelMap, "出现未知错误！");
        }

        // 判断是否更改成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "gradeList");
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }
    }

    @GetMapping("/gradeDelete")
    public String gradeDelete(ModelMap modelMap, Integer gid, @SessionAttribute("admin") Admin admin) {

        if(admin.getAgid() != 0) {
            return HTMLUtils.error(modelMap, "学委不能删除班级！");
        }
        // 数据判断
        if(gid == null) {
            return HTMLUtils.error(modelMap, "id有误！");
        }

        // 删除数据
        int result = gradeService.deleteByPrimaryKey(gid);

        // 判断是否删除成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "gradeList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }

}
