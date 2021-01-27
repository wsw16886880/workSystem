package com.worksystem.controller.admin;

import com.worksystem.utils.HTMLUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author wsw16
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "act", required = false, defaultValue = "") String act, HttpSession session, RedirectAttributes attr) {
        ModelAndView modelAndView = new ModelAndView();
        if (act.equalsIgnoreCase("register")) {
            attr.addAttribute("action", "register");
            modelAndView.setViewName("/admin/register");
        } else if (act.equalsIgnoreCase("form")) {
            // 对老师账号进行限制
            if(session.getAttribute("teacher") != null) {
                return HTMLUtils.error(modelAndView,"该功能暂时未对老师开放哦~");
            }
            attr.addAttribute("action", "form");
            modelAndView.setViewName("redirect:/admin/form");
        } else if (act.equalsIgnoreCase("table")) {
            attr.addAttribute("action", "table");
            // 对老师账号进行限制
            if (session.getAttribute("teacher") != null) {
                modelAndView.setViewName("/admin/teachertable");
            } else {
                modelAndView.setViewName("/admin/table");
            }
        } else if (act.equalsIgnoreCase("element")) {
            // 对老师账号进行限制
            if(session.getAttribute("teacher") != null) {
                return HTMLUtils.error(modelAndView,"该功能暂时未对老师开放哦~");
            }
            attr.addAttribute("action", "element");
            modelAndView.setViewName("/admin/element");
        } else if (act.equalsIgnoreCase("custom-dashboard")) {
            // 对老师账号进行限制
            if(session.getAttribute("teacher") != null) {
                return HTMLUtils.error(modelAndView,"该功能暂时未对老师开放哦~");
            }
            attr.addAttribute("action", "custom-dashboard");
            modelAndView.setViewName("/admin/custom-dashboard");
        } else if (act.equalsIgnoreCase("teachertable")) {
            attr.addAttribute("action", "table");
            modelAndView.setViewName("/admin/teachertable");
        } else if (act.equalsIgnoreCase("message")) {
            // 对老师账号进行限制
            if(session.getAttribute("teacher") != null) {
                return HTMLUtils.error(modelAndView,"该功能暂时未对老师开放哦~");
            }
            attr.addAttribute("action", "message");
            modelAndView.setViewName("/admin/message");
        } else if (act.equalsIgnoreCase("note")) {
            // 对老师账号进行限制
            if(session.getAttribute("teacher") != null) {
                return HTMLUtils.error(modelAndView,"该功能暂时未对老师开放哦~");
            }
            attr.addAttribute("action", "note");
            modelAndView.setViewName("/admin/note");
        } else {
            attr.addAttribute("action", "index");
            modelAndView.setViewName("/admin/index");
        }
        return modelAndView;
    }
}
