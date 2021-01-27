package com.worksystem.utils;

import com.worksystem.entity.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wsw16
 */
public class CheckWXUtils {
    public JsonResult checkLogin(HttpServletRequest request) {
        // 获取token
        String token = request.getParameter("token") != null ? request
                .getParameter("token") : "";
        // 获取session
        HttpSession session = request.getSession();

        // 判断此次的sessionid和登录时的sessionid是不是同一个
        JsonResult jsonResult = new JsonResult();
        if (session.getAttribute("token") != null
                && token.equals(session.getAttribute("token").toString())) {
            // 已登录
            jsonResult.setCode(0);
        } else {
            // 未登录
            jsonResult.setCode(-1);
            jsonResult.setMessage("请登录！");
        }
        return jsonResult;
    }
}
