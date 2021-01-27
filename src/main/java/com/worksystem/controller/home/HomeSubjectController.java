package com.worksystem.controller.home;

import com.worksystem.entity.JsonResult;
import com.worksystem.entity.Subject;
import com.worksystem.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wsw16
 */
@Controller
public class HomeSubjectController {

    private final SubjectService subjectService;

    public HomeSubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     *
     * @param studyYear 要查询该学年的课程
     * @param sgid 班级id
     * @return
     */
    @GetMapping("/subjects")
    @ResponseBody
    public JsonResult appGetSubjectList(Integer studyYear, Integer sgid){
        // 从数据库中获取并返回json
        List<Subject> subjectBySjgidSjsemester = subjectService.getSubjectBySjgidSjsemester(studyYear, sgid);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setData(subjectBySjgidSjsemester);
        return jsonResult;
    }

}
