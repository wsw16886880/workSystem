package com.worksystem.controller.home;

import com.worksystem.entity.JsonResult;
import com.worksystem.service.SchoolTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/MyInfo")
public class HomeSchoolTimetableController {

    private final SchoolTimetableService schoolTimetableService;

    @Autowired
    public HomeSchoolTimetableController(SchoolTimetableService schoolTimetableService) {
        this.schoolTimetableService = schoolTimetableService;
    }

    @GetMapping("/schedul")
    @ResponseBody
    public JsonResult getSchedule(Integer sgid, Integer stsemester){
        JsonResult jsonResult = new JsonResult();
        String schedul = schoolTimetableService.selectStfileByGidAndStse(sgid, stsemester);
        jsonResult.setCode(0);
        jsonResult.setData(schedul);
        return jsonResult;
    }

    @GetMapping("/school_timetable")
    public String getSchool_timetable(ModelMap modelMap, @CookieValue("cksgid") Integer sgid) {
        // 获取第一个学期的图片参数
        modelMap.addAttribute("st", schoolTimetableService.selectStfileByGidAndStse(sgid, 1));
        // 转发
        return "/MyInfo/ClassInfo";
    }

    @PostMapping("/school_timetable")
    public void postSchool_timetable(ModelMap modelMap, @CookieValue("cksgid") Integer sgid, Integer stsemester, HttpServletResponse response) {
        // 返回图片地址
        try {
            System.out.println(schoolTimetableService.selectStfileByGidAndStse(sgid, stsemester));
            response.getWriter().print(schoolTimetableService.selectStfileByGidAndStse(sgid, stsemester));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
