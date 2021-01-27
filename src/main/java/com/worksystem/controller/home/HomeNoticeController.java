package com.worksystem.controller.home;

import com.worksystem.entity.JsonResult;
import com.worksystem.entity.Notice;
import com.worksystem.service.NoticeService;
import com.worksystem.utils.HTMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/User/StudentInfor")
public class HomeNoticeController {

    private final NoticeService noticeService;

    @Autowired
    public HomeNoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice/{nid}")
    @ResponseBody
    public JsonResult getNotice(@PathVariable("nid") Integer nid) {
        JsonResult jsonResult = new JsonResult();
        Notice notice = noticeService.selectByPrimaryKey(nid);
        jsonResult.setCode(0);
        jsonResult.setData(notice);
        return jsonResult;
    }

    @GetMapping("/notices")
    @ResponseBody
    public JsonResult getNotices(Integer sgid, Integer ntype){
        JsonResult jsonResult = new JsonResult();
        if(ntype==0) {
            // 获取该班级的全部公告
            List<Map<String, Object>> maps = noticeService.selectNoticeAndGradeByNgid(sgid);

            // 封装要返回的数据
            jsonResult.setCode(0);
            jsonResult.setData(maps);
        } else {
            // 获取该班级的指定类型的公告
            // 封装要查找的条件
            Notice notice = new Notice();
            notice.setNgid(sgid);
            notice.setNtype(ntype);

            List<Map<String, Object>> maps = noticeService.selectNoticeAndGradeByNgidAndNtype(notice);

            // 封装要返回的数据
            jsonResult.setCode(0);
            jsonResult.setData(maps);
        }
        return jsonResult;
    }

    @GetMapping("/notice")
    public String notice(ModelMap modelMap, Integer nid) {
        //数据判断
        if(nid == 0) {
            return HTMLUtils.error(modelMap, "id出错！");
        }

        // 连接数据库，将数据保存到request中
        modelMap.addAttribute("notice", noticeService.selectByPrimaryKey(nid));

        // 转发
        return "/User/StudentInfor/notice";
    }

    @GetMapping("/noticeList")
    public String noticeList(ModelMap modelMap, @CookieValue("cksgid")Integer sgid) {
        // 连接数据库获取数据保存到数据模型中
        modelMap.addAttribute("notices", noticeService.selectNoticeAndGradeByNgid(sgid));
        // 转发
        return "/User/StudentInfor/systemMsge";
    }

    @PostMapping("/noticeList")
    public String noticeList(ModelMap modelMap, @CookieValue("cksgid") Integer sgid, Integer ntype) {
        // 数据判断
        if (ntype == 0) {
            modelMap.addAttribute("notices", noticeService.selectNoticeAndGradeByNgid(sgid));
        } else {
            // 封装数据
            Notice notice = new Notice();
            notice.setNgid(sgid);
            notice.setNtype(ntype);

            // 连接数据库获取数据，将数据保存到request中
            modelMap.addAttribute("notices", noticeService.selectNoticeAndGradeByNgidAndNtype(notice));
        }

        // 转发
        return "/User/StudentInfor/systemMsge";
    }
}
