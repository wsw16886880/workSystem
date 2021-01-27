package com.worksystem.controller.admin;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Subject;
import com.worksystem.service.GradeService;
import com.worksystem.service.SubjectService;
import com.worksystem.service.TeacherService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class SubjectController {

    private final SubjectService subjectService;
    private final GradeService gradeService;
    private final TeacherService teacherService;

    public SubjectController(SubjectService subjectService, GradeService gradeService, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.gradeService = gradeService;
        this.teacherService = teacherService;
    }

    @PostMapping("/subjectAdd")
    public String subjectAdd(ModelMap modelMap, Subject subject) {
        // 判断数据
        if(subject.getSjname().isEmpty()) {
            return HTMLUtils.error(modelMap, "课程名称不能为空！");
        }

        // 添加老师名字
        subject.setSjtname(teacherService.selectByPrimaryKey(subject.getSjtid()).getTname());

        // 连接数据库，添加数据
        int result = subjectService.insert(subject);

        // 判断添加是否成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "添加成功！", "form");
        } else {
            return HTMLUtils.error(modelMap, "添加失败！");
        }
    }

    @GetMapping("/subjectList")
    public String subjectList(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin) {
        if (admin.getAgid() == 0) {
            modelMap.addAttribute("subjects", subjectService.selectSubjectAndGrade());
        } else {
            modelMap.addAttribute("subjects", subjectService.selectByGid(admin.getAgid()));
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(admin.getAgid()));
        }
        return "/admin/table";
    }

    @GetMapping("/subjectModify")
    public String subjectModify(ModelMap modelMap, @SessionAttribute(value = "admin", required = false) Admin admin, Integer sjid) {
        //数据判断
        if (sjid == null || sjid == 0) {
            return HTMLUtils.error(modelMap, "id出错！");
        }
        //连接数据库获取数据
        if(admin.getAgid() == 0) {
            modelMap.addAttribute("grades", gradeService.selectAll());
        } else {
            modelMap.addAttribute("grade", gradeService.selectByPrimaryKey(admin.getAgid()));
        }
        modelMap.addAttribute("teachers",teacherService.selectAll());
        modelMap.addAttribute("subject", subjectService.selectByPrimaryKey(sjid));
        return "/admin/subjectModify";
    }

    @PostMapping("/subjectModify")
    public String subjectModify(ModelMap modelMap, Subject subject, Integer sjid){
        // 数据判断
        if(subject.getSjname()==null||subject.getSjname().isEmpty()) {
            return HTMLUtils.error(modelMap, "课程名称格式错误！");
        }
        // 更改数据
        int result = subjectService.updateByPrimaryKey(subject, sjid);
        // 判断是否更改成功
        if (result > 0) {
            return HTMLUtils.success(modelMap, "更改成功！", "subjectList");
        } else {
            return HTMLUtils.error(modelMap, "更改失败！");
        }
    }

    @GetMapping("/subjectDelete")
    public String subjectDelete(ModelMap modelMap, Integer sjid) {
        //判断数据
        if(sjid == 0) {
            return HTMLUtils.error(modelMap, "删除错误！");
        }
        //连接数据库删除subject记录
        int result = subjectService.deleteByPrimaryKey(sjid);
        // 判断删除是否成功
        if(result > 0) {
            return HTMLUtils.success(modelMap, "删除成功！", "subjectList");
        } else {
            return HTMLUtils.error(modelMap, "删除失败！");
        }
    }
}
