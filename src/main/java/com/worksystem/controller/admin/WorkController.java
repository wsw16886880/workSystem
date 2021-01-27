package com.worksystem.controller.admin;

import com.worksystem.entity.*;
import com.worksystem.service.GradeService;
import com.worksystem.service.LateService;
import com.worksystem.service.SubjectService;
import com.worksystem.service.WorkService;
import com.worksystem.utils.HTMLUtils;
import com.worksystem.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"admin", "teacher"})
public class WorkController {

    private final WorkService workService;

    private final LateService lateService;

    private final GradeService gradeService;

    private final SubjectService subjectService;

    @Autowired
    public WorkController(WorkService workService, LateService lateService, GradeService gradeService, SubjectService subjectService) {
        this.workService = workService;
        this.lateService = lateService;
        this.gradeService = gradeService;
        this.subjectService = subjectService;
    }

    @PostMapping("/workAdd")
    public String workAdd(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin,
                          @RequestParam("file") MultipartFile resourceFile, Late late, HttpSession session) {
        // 创建文件上传工具
        UploadUtils uploadUtils = new UploadUtils(session.getServletContext(), resourceFile, "sourcefile/");

        //初始化数据
        Work work = new Work();
        // 判断是否有上传文件，如果没有上传文件，则不执行上传文件相关代码，如果上传文件，则保存文件，设置wfile
        if (!resourceFile.isEmpty()) {
            // 保存文件，获取保存文件时的名称，用键值对方法获取， 键：getOriginalFilename()
            Map<String, String> path = uploadUtils.upload();
            work.setWfile(path.get(resourceFile.getOriginalFilename()));
        }

        //数据判断
        if (late.getLname().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业名称不能为空！");
        }
        if (late.getLweek() == null || late.getLweek() == 0) {
            return HTMLUtils.error(modelMap, "周数不能为空！");
        }
        if (late.getLtype().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业类型不能为空！");
        }
        if (late.getLcontent().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业内容不能为空！");
        }

        //获取班级总人数
        int gtotal = gradeService.selectByPrimaryKey(late.getLgid()).getGtotal();

        // 封装work数据
        work.setWgid(late.getLgid());
        work.setWname(late.getLname());
        work.setWsjid(late.getLsjid());
        work.setWeek(late.getLweek());
        work.setWtype(late.getLtype());
        work.setWdate(new Date(System.currentTimeMillis()));
        work.setWcontent(late.getLcontent());
        //添加work
        int result = workService.insertSelective(work);

        // 封装页面未提交过来的late数据
        Subject subject = subjectService.selectByPrimaryKey(late.getLsjid());
        late.setIssubmit("否");
        late.setLdate(new Date(System.currentTimeMillis()));
        // 截止时间：发布时间+6天
        late.setLedate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 6)));
        late.setLwid(work.getWid());
        // 课程名称
        late.setLsjname(subject.getSjname());
        // 课程老师的tid
        late.setLtid(subject.getSjtid());

        //添加late
        result += lateService.insertBatch(late, late.getLgid());
        if (result < gtotal) {
            return HTMLUtils.error(modelMap, "添加失败！");
        } else {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        }
    }

    @GetMapping("/workList")
    public String workList(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, @SessionAttribute(value = "teacher", required = false) Teacher teacher) {
        // 初始化参数
        List<Map<String, Object>> works;
        // 判断登录用户类型
        if (admin != null) {
            if (admin.getAgid() == 0) {
                works = workService.selectAllFewTable();
            } else {
                works = workService.selectFewTableByGid(admin.getAgid());
            }
            modelMap.addAttribute("works", works);
            return "/admin/table";
        } else if (teacher != null) {
            modelMap.addAttribute("works", workService.selectFewTableByTid(teacher.getTid()));
            return "/admin/teachertable";
        } else {
            return HTMLUtils.error(modelMap, "请登录！", "../../adminlogin/login");
        }
    }

    @GetMapping("/workModify")
    public String getWorkModify(ModelMap modelMap,  @SessionAttribute(value = "admin", required = false) Admin admin, @SessionAttribute(value = "teacher", required = false) Teacher teacher, Integer wid, Integer wgid) {
        // 获取work单条数据，存入modelMap
        modelMap.addAttribute("work", workService.selectByPrimaryKey(wid));
        if (admin != null) {
            if (admin.getAgid() == 0) {
                //超级管理员
                // 查询所有班级
                modelMap.addAttribute("grades", gradeService.selectAll());
                // 获取所有班级的subject所有数据，存入modelMap
                modelMap.addAttribute("subjects", subjectService.selectAll());
            } else {
                //学委
                // 获取自己班级的subject所有数据，存入modelMap
                modelMap.addAttribute("subjects", subjectService.selectByGid(admin.getAgid()));
                // 获取自己班级的数据
                modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(wgid));
            }
        } else if (teacher != null) {
            // 获取班级数据
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(wgid));
            // 获取自己所教授的课程
            modelMap.addAttribute("subjects", subjectService.selectByTid(teacher.getTid()));
        }
        return "/admin/workModify";
    }

    @PostMapping("/workModify")
    public String workModify(ModelMap modelMap, MultipartFile resourceFile, Work work, HttpSession session) {
        // 创建文件工具对象
        UploadUtils uploadUtils = new UploadUtils(session.getServletContext(), resourceFile, "sourcefile/");

        // 判断是否有文件上传
        if (resourceFile != null) {
            // 删除原文件
            uploadUtils.deleteFile(work.getWfile());
            // 保存文件
            Map<String, String> path = uploadUtils.upload();
            // 把新文件存储的名称保存在work对象中
            work.setWfile(path.get(resourceFile.getOriginalFilename()));
        }

        // 数据判断
        if (work.getWname().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业名称不能为空！");
        }
        if (work.getWeek() == null || work.getWeek() <= 0) {
            return HTMLUtils.error(modelMap, "周数不能为空！");
        }
        if (work.getWtype().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业类型不能为空！");
        }
        if (work.getWcontent().isEmpty()) {
            return HTMLUtils.error(modelMap, "作业内容不能为空！");
        }

        // 封装数据
        Late late = new Late();
        late.setLwid(work.getWid());
        late.setLname(work.getWname());
        late.setLsjid(work.getWsjid());
        late.setLweek(work.getWeek());
        late.setLtype(work.getWtype());
        late.setLsjname(subjectService.selectByPrimaryKey(work.getWsjid()).getSjname());
        late.setLcontent(work.getWcontent());

        //连接数据库
        int result = workService.updateByPrimaryKeySelective(work);
        result += lateService.updateByWidSelective(late);

        // 判断是否修改成功
        if (result > 1) {
            return HTMLUtils.success(modelMap, "修改成功！", "workList?wid=" + work.getWid());
        } else {
            return HTMLUtils.error(modelMap, "修改失败！");
        }
    }

    @GetMapping("/workDelete")
    public String workDelete(ModelMap modelMap, Integer wid, String wfile, HttpSession session) {
        // 数据判断
        if (wid == null || wid == 0) {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
        // 删除作业源文件
        if (!wfile.isEmpty()) {
            UploadUtils.deleteFile(wfile, session.getServletContext().getRealPath("/sourcefile"));
        }

        // 连接数据库，删除数据
        int result = workService.deleteByPrimaryKey(wid);
        result += lateService.deleteByWid(wid);

        // 获取作业总数
        int lateCount = (int) lateService.countByWid(wid);
        // 判断是否删除成功
        if (result > lateCount) {
            return HTMLUtils.success(modelMap, "删除成功！", "workList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }

    @GetMapping("/clearZipFile")
    public String clearZipFile(ModelMap modelMap) {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String zipFilePath = servletContext.getRealPath("/zip");
        // 清除文件
        boolean result = UploadUtils.recurisonDeleteFile(new File(zipFilePath));
        // 判断删除是否成功
        if(result) {
            return HTMLUtils.success(modelMap, "清除成功！", "index?act=table");
        } else {
            return HTMLUtils.error(modelMap, "清除失败！无文件夹或需要手动删除");
        }
    }
}
