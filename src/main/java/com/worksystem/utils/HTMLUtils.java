package com.worksystem.utils;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HTMLUtils {

    public static ModelAndView error(ModelAndView modelAndView, String msg) {
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("url", "JavaScript:history.back()");
        modelAndView.setViewName("info");
        return modelAndView;
    }

    public static String error(ModelMap modelMap, String msg, String url) {
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("url", url);
        return "/info";
    }

    public static void error(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("msg", msg);
        request.setAttribute("url", "JavaScript:history.back()");
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

    public static String error(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("url", "JavaScript:history.back()");
        return "/info";
    }

    public static String success(ModelMap modelMap, String msg, String url) {
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("url", url);
        return "/info";
    }

    public static void success(ModelAndView modelAndView, String msg, String url) {
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("url", url);
        modelAndView.setViewName("info");
    }
}
