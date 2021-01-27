package com.worksystem.controller.home;

import com.worksystem.entity.Student;
import com.worksystem.service.StudentService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wsw16
 */
@Controller
public class HomeStudentController {

    private final StudentService studentService;

    @Autowired
    public HomeStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/MyInfo/studentInfo")
    public String studentInfo(ModelMap modelMap, @CookieValue("cksid") Integer sid) {
        //连接数据库，获取数据保存
        modelMap.addAttribute("student", studentService.selectByPrimaryKey(sid));
        //转发
        return "/MyInfo/Index";
    }

    @PostMapping("/studentInfoModify")
    public String studentInfoModify(ModelMap modelMap, @CookieValue("cksid")Integer sid, Student student) {
        // 数据判断，不能包含中文和除_以外的所有字符
        String totalReg = ".{6,16}";
        String chineseReg = "[\u4e00-\u9fa5]+";
        if (student.getSpwd().isEmpty()) {
            return HTMLUtils.error(modelMap, "密码不能为空！");
        }
        if (!student.getSpwd().matches(totalReg)) {
            return HTMLUtils.error(modelMap, "密码不符合长度限制！");
        }
        if (student.getSpwd().matches(chineseReg)) {
            return HTMLUtils.error(modelMap, "密码不能包含中文！");
        }

        // 封装数据
        student.setSid(sid);

        // 连接数据库，更改密码
        int result = studentService.updateByPrimaryKeySelective(student);

        // 判断是否更改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "更改密码成功！", "MyInfo/studentInfo");
        } else {
            return HTMLUtils.error(modelMap, "更改密码失败！");
        }
    }


}
