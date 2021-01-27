package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.service.GradeService;
import com.worksystem.service.SubjectService;
import com.worksystem.service.TeacherService;
import com.worksystem.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class FormController {

    private final GradeService gradeService;

    private final SubjectService subjectService;

    private final WorkService workService;

    private final TeacherService teacherService;

    @Autowired
    public FormController(GradeService gradeService, SubjectService subjectService, WorkService workService, TeacherService teacherService) {
        this.gradeService = gradeService;
        this.subjectService = subjectService;
        this.workService = workService;
        this.teacherService = teacherService;
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap, @ModelAttribute("admin") Admin admin) {
        if (admin.getAgid() == 0) {
            // 管理员需要的数据
            modelMap.addAttribute("grades", gradeService.selectAll());
            modelMap.addAttribute("subjects", subjectService.selectAll());
            modelMap.addAttribute("works", workService.selectAllFewTable());
        } else {
            // 学委需要的数据
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(admin.getAgid()));
            modelMap.addAttribute("subjects", subjectService.selectByGid(admin.getAgid()));
            modelMap.addAttribute("works", workService.selectFewTableByGid(admin.getAgid()));
        }
        modelMap.addAttribute("teachers", teacherService.selectAll());
        return "/admin/form";
    }
}
