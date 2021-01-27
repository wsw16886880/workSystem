package com.worksystem.controller.home;

import com.worksystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wsw16
 */
@Controller
public class HomeIndexController {

    private final NoticeService noticeService;

    @Autowired
    public HomeIndexController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }


    @GetMapping("/index")
    public String index(ModelMap modelMap, @CookieValue(value = "cksid", required = false) String cksid, @CookieValue("cksgid") Integer sgid) {
        //判断是否登录，如果sessoin为空，代表无session，也就是还没有登录，重定向到login
//        if (cksid == null || cksid.isEmpty()) { 这个功能放到拦截器上
//            JsUtils.jsGo(response.getWriter(), "你还没有登录，请登录！", "login");
//            return;
//        }

        //获取公告数据
        modelMap.addAttribute("notice", noticeService.selectNemergencyByGid(sgid));

        // 转发
        return "/index";
    }
}
