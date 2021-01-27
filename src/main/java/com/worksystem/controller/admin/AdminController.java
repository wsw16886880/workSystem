package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.service.AdminService;
import com.worksystem.service.GradeService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    private final GradeService gradeService;

    @Autowired
    public AdminController(AdminService adminService, GradeService gradeService) {
        this.adminService = adminService;
        this.gradeService = gradeService;
    }

    @GetMapping("/outAdmin")
    public String outAdmin(HttpSession session) {
        // 清除session
        session.invalidate();
        return "redirect:/adminlogin/login";
    }

    @GetMapping("/adminList")
    public String adminList(ModelMap modelMap) {
        //连接数据库获取数据传输到页面中
        modelMap.addAttribute("admins", adminService.selectAllAndGname());
        return "/admin/table";
    }

    @PostMapping("/adminAdd")
    public String adminAdd(ModelMap modelMap, Admin admin) {
        // 数据判断
        if (admin.getAccount().isEmpty()) {
            HTMLUtils.error(modelMap, "学委账号不能为空！");
        }
        if (admin.getApwd().isEmpty()) {
            HTMLUtils.error(modelMap, "学委密码不能为空！");
        }
        if (admin.getAname().isEmpty()) {
            HTMLUtils.error(modelMap, "学委姓名不能为空！");
        }

        // 连接数据库，添加数据
        int result = adminService.insertSelective(admin);
        // 判断数据是否添加成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/adminModify")
    public String adminModify(ModelMap modelMap, Integer aid) {
        //连接数据库获取数据保存到request中
        modelMap.addAttribute("admin", adminService.selectByPrimaryKey(aid));
        modelMap.addAttribute("grades", gradeService.selectAll());
        return "/admin/adminModify";
    }

    @GetMapping("/adminDelete")
    public String adminDelete(ModelMap modelMap, Integer aid) {
        // 连接数据库，删除数据
        int result = adminService.deleteByPrimaryKey(aid);
        // 判断是否删除成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "adminList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }

    @PostMapping("/adminModify")
    public String adminModify(ModelMap modelMap, Admin admin, Integer aid){
        // 数据判断
        if(admin.getAccount()==null||admin.getAccount().isEmpty()) {
            return HTMLUtils.error(modelMap, "账号格式错误！");
        }
        if(admin.getApwd()==null||admin.getApwd().isEmpty()) {
            return HTMLUtils.error(modelMap, "密码格式错误！");
        }
        if(admin.getAname()==null||admin.getAname().isEmpty()) {
            return HTMLUtils.error(modelMap, "姓名格式错误！");
        }
        // 更改数据
        int result = adminService.updateByPrimaryKey(admin, aid);
        // 判断是否更改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "adminList");
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }
    }
}
