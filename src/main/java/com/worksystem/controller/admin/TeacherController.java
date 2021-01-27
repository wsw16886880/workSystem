package com.worksystem.controller.admin;

import com.worksystem.entity.Teacher;
import com.worksystem.service.TeacherService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacherAdd")
    public String teacherAdd(ModelMap modelMap, Teacher teacher) {
        //判断数据
        if(teacher.getTaccount().isEmpty()) {
            return HTMLUtils.error(modelMap, "初始账号不能为空！");
        }
        if(teacher.getTpwd().isEmpty()) {
            return HTMLUtils.error(modelMap, "密码不能为空！");
        }
        if(teacher.getTname().isEmpty()) {
            return HTMLUtils.error(modelMap, "姓名不能为空！");
        }

        //连接数据库
        int result = teacherService.insert(teacher);

        // 判断添加是否成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/teacherList")
    public String teacherList(ModelMap modelMap) {
        // 连接数据库查询所有老师数据并返回
        modelMap.addAttribute("teachers", teacherService.selectAll());
        return "/admin/table";
    }

    @GetMapping("/teacherModify")
    public String getTeacherModify(ModelMap modelMap, Integer tid) {
        // 判断数据
        if (tid == 0) {
            return HTMLUtils.error(modelMap, "删除错误！");
        }

        modelMap.addAttribute("teacher",teacherService.selectByPrimaryKey(tid));
        return "/admin/teacherModify";
    }

    @PostMapping("/teacherModify")
    public String postTeacherModify(ModelMap modelMap, Teacher teacher) {
        //数据判断
        if (teacher.getTid() == 0) {
            return HTMLUtils.error(modelMap, "id错误！");
        }
        if (teacher.getTaccount().isEmpty()) {
            return HTMLUtils.error(modelMap, "账号不能为空！");
        }
        if (teacher.getTpwd().isEmpty()) {
            return HTMLUtils.error(modelMap, "密码不能为空！");
        }
        if (teacher.getTname().isEmpty()) {
            return HTMLUtils.error(modelMap, "姓名不能为空！");
        }

        //连接数据库，更改数据
        int result = teacherService.updateByPrimaryKey(teacher);

        // 判断更改是否成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "teacherList");
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }
    }

    @GetMapping("/teacherDelete")
    public String teacherDelete(ModelMap modelMap, Integer tid) {
        // 判断数据
        if (tid == 0) {
            return HTMLUtils.error(modelMap, "删除错误！");
        }

        //连接数据库删除数据
        int result = teacherService.deleteByPrimaryKey(tid);

        // 判断删除是否成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "teacherList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }
}
