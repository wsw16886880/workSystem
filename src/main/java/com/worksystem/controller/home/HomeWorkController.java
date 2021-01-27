package com.worksystem.controller.home;

import com.worksystem.entity.JsonResult;
import com.worksystem.entity.Late;
import com.worksystem.service.LateService;
import com.worksystem.service.MessageService;
import com.worksystem.service.WorkService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/EducationCenter")
public class HomeWorkController {

    private final WorkService workService;

    private final LateService lateService;

    private final MessageService messageService;

    public HomeWorkController(WorkService workService, MessageService messageService, LateService lateService) {
        this.workService = workService;
        this.messageService = messageService;
        this.lateService = lateService;
    }

    @GetMapping("/work")
    public String work(ModelMap modelMap, Integer wid, @CookieValue("cksgid") Integer mgid, Integer pno) {
        // 数据判断
        if (wid == 0) {
            return HTMLUtils.error(modelMap, "wid错误！");
        }

        modelMap.addAttribute("work", workService.selectOneMoreTableExampleByWid(wid));

        // 转发
        return "/EducationCenter/work";
    }

    /**
     *  jsonp格式
     *  Map<String, Object> workMap = workService.selectOneMoreTableExampleByWid(wid);
     *  // 创建jsonp封装数据对象
     *  JSONPObject jsonp = new JSONPObject(callback, workMap);
     *  // 返回数据
     *  return jsonp;
     * @param wid
     * @return
     */
    @GetMapping("/work/{wid}")
    @ResponseBody
    public Object work(@PathVariable("wid") Integer wid) {
        JsonResult jsonResult = new JsonResult();
        Map<String, Object> workMap = workService.selectOneMoreTableExampleByWid(wid);
        jsonResult.setCode(0);
        jsonResult.setData(workMap);
        return jsonResult;
    }

    @PostMapping("/work")
    public String work(ModelMap modelMap, Integer sid, Integer lweek) {
        return "/EducationCenter/work";
    }

    /**
     * jsonp格式
     * JSONPObject jsonp = new JSONPObject(callback, jsonResult);
     * JSONPObject jsonp = new JSONPObject(callback, late);// jsonp格式
     * return jsonp;
     * @param sid
     * @param studyYear
     * @return
     */
    @GetMapping("/works/{sid}")
    @ResponseBody
    public JsonResult workList(@PathVariable("sid") Integer sid, Integer studyYear) {
        JsonResult jsonResult = new JsonResult();
        // 查询数据
        List<Map<String, Object>> lates = lateService.selectMoreTableBySemester(sid, studyYear);
        // 封装数据
        jsonResult.setCode(0);
        jsonResult.setData(lates);
        // 返回数据
        return jsonResult;
    }

    @PostMapping("/workList")
    public String workList(ModelMap modelMap, @CookieValue("cksid") Integer sid, Integer week) {
        List<Late> late;
        // 查询数据
        late = lateService.selectBySidAndWeed(sid, week);
        // 判断作业是否为空
        if (late == null) {
            modelMap.addAttribute("WorkRuntimeException", "暂无作业");
            return "/EducationCenter/Book";
        }
        // 将作业数据存储到modelMap中
        modelMap.addAttribute("lates", late);
        /// 转发
        return "/EducationCenter/Book";
    }
}
