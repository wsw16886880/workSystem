package com.worksystem.interceptor;

import com.worksystem.entity.Admin;
import com.worksystem.entity.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wsw16
 */
public class AdminInterceptor implements HandlerInterceptor {

    /**
     * controller方法执行之前拦截
     * 判断是否有登录账号，如果没有登录账号，则跳转到账号登录界面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (admin == null && teacher == null) {
            response.sendRedirect(request.getContextPath()+"/adminlogin/login");
            return false;
        } else {
            return true;
        }
    }
}
