package com.worksystem.controller.admin;

import com.worksystem.entity.SchoolTimetable;
import com.worksystem.service.SchoolTimetableService;
import com.worksystem.utils.HTMLUtils;
import com.worksystem.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
public class SchoolTimetableController {

    @Autowired
    private SchoolTimetableService schoolTimetableService;

    @PostMapping("/school_timetableAdd")
    public String school_timetableAdd(ModelMap modelMap, MultipartFile file, SchoolTimetable schoolTimetable, HttpSession session) {
        // 检查数据库中是否有图片，有则报错，没有就什么都不执行
        if (schoolTimetableService.check(schoolTimetable.getStgid(), schoolTimetable.getStsemester()) > 0) {
            return HTMLUtils.error(modelMap, "课表图已存在！");
        }

        // 创建上传对象
        UploadUtils uploadUtils = new UploadUtils(session.getServletContext(), file, "school_timetable/");

        // 判断文件是否上传
        if(!file.isEmpty()) {
            try {
                // 判断是不是图片
                if(uploadUtils.isImageType(file.getInputStream(), "image")) {
                    // 获取保存的文件名称
                    Map<String, String> path = uploadUtils.upload();
                    if (path.size() > 0) {
                        System.out.println("保存图片成功！");

                        // 封装数据
                        schoolTimetable.setStfile(path.get(file.getOriginalFilename()));
                    } else {
                        System.out.println("保存图片失败！");
                        return HTMLUtils.error(modelMap, "保存图片失败！"+path.get(file.getOriginalFilename()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return HTMLUtils.error(modelMap, "出现未知错误！");
            }

            // 连接数据库，插入数据
            int result = schoolTimetableService.insert(schoolTimetable);

            // 判断数据是否添加成功
            if (result > 0) {
                return HTMLUtils.success(modelMap, "添加成功！", "form");
            } else {
                return HTMLUtils.error(modelMap, "添加失败！");
            }

        } else {
            return HTMLUtils.error(modelMap, "请上传文件！");
        }
    }

    @PostMapping("/school_timetableDelete")
    public void school_timetableDelete(Integer gid, SchoolTimetable schoolTimetable, HttpServletResponse response, HttpSession session) {
        int result = 0;
        PrintWriter writer = null;
        try {
            // 删除图片
            if(!schoolTimetable.getStfile().isEmpty()) {
                UploadUtils.deleteFile(schoolTimetable.getStfile(), session.getServletContext().getRealPath("/")+"school_timetable");
            }
            // 封装数据
            schoolTimetable.setStgid(gid);
            // 删除数据库中的记录
            result = schoolTimetableService.deleteByExample(schoolTimetable);
            // 给页面返回结果
            writer = response.getWriter();
            writer.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
