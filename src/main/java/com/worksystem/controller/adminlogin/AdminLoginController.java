package com.worksystem.controller.adminlogin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Teacher;
import com.worksystem.service.AdminService;
import com.worksystem.service.TeacherService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author xq
 */
@Controller
@RequestMapping("/adminlogin")
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;


    @GetMapping(value = "/login")
    public String login() {
        return "adminlogin/login";
    }

    @PostMapping(value = "/login")
    public ModelAndView login(int atype, Admin admin, HttpSession session) {
        // 创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 数据判断
        if (admin.getAccount().isEmpty()) {
            return HTMLUtils.error(modelAndView, "账号不能为空！");
        }
        if (admin.getApwd().isEmpty()) {
            return HTMLUtils.error(modelAndView, "密码不能为空！");
        }

        // 判断登录管理员类型,0为超级管理员,1学委,2老师
        if (atype != 2) {
            Admin loginAdmin = null;
            loginAdmin = adminService.selectByAccount(admin);
            if (loginAdmin == null) {
                return HTMLUtils.error(modelAndView, "账号或密码错误");
            }
            if (loginAdmin.getAgid() != 0 && atype == 0) {
                return HTMLUtils.error(modelAndView, "您不是超级管理员！");
            }

            // 将账号存入 session
            session.setAttribute("admin", loginAdmin);
        } else {
            // 临时对象
            Teacher teacher = new Teacher();
            teacher.setTaccount(admin.getAccount());
            teacher.setTpwd(admin.getApwd());
            // 判断账号
            Teacher loginteacher = null;
            loginteacher = teacherService.selectByTaccount(teacher);
            if (loginteacher.getTaccount() == null) {
                return HTMLUtils.error(modelAndView, "账号或密码错误");
            }

            // 将账号存入 session
            session.setAttribute("teacher", loginteacher);
        }
        // 重定向页面
        modelAndView.setViewName("redirect:/admin/index");
        return modelAndView;
    }
}
