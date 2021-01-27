package com.worksystem.interceptor;

import com.alibaba.fastjson.JSON;
import com.worksystem.entity.JsonResult;
import com.worksystem.utils.CheckWXUtils;
import com.worksystem.utils.CookieUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wsw16
 */
public class HomeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("getServletPath======" + request.getServletPath());
//        System.out.println("getRequestURL======" + request.getRequestURL());
//        System.out.println("getRequestURI======" + request.getRequestURI());
//        System.out.println("getContextPath======" + request.getContextPath());
        String form = request.getParameter("form");
        if (form != null || "app".equalsIgnoreCase(form)) {
            // 微信
            JsonResult jsonResult = new JsonResult();
            CheckWXUtils checkWXUtils = new CheckWXUtils();
            if (checkWXUtils.checkLogin(request).getCode() == 0) {
                return true;
            } else {
                // 未登录
                jsonResult.setCode(-1);
                jsonResult.setMessage("请登录！");
                String json = JSON.toJSONString(jsonResult);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(json);
                return false;
            }
        } else {
            // web
            String cksid = CookieUtils.getCookie("cksid", request);
            if (cksid == null || cksid.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            } else {
                return true;
            }
        }
    }
}
