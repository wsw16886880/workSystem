package com.worksystem.utils;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author wsw16
 */
public class ServletUtils {
    /**
     * 将设置的信息转发到指定的页面中
     *
     * @param uri
     * @param msg
     */
    public static void transpond(String uri, String name, String msg,
                                 HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute(name, msg);
            request.getRequestDispatcher(uri).forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("转发失败！");
        }
    }

	/**
	 * 将设置的信息转发到指定的页面中，ssm
	 * @param modelMap
	 * @param uri
	 * @param name
	 * @param msg
	 * @return
	 */
    public static String transpond(ModelMap modelMap, String uri, String name, String msg) {
        modelMap.addAttribute(name, msg);
        return uri;
    }

    /**
     * 设置request和response的编码为utf-8
     *
     * @throws UnsupportedEncodingException
     */
    public static void setEncoding(HttpServletRequest request,
                                   HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }

    /**
     * 判断结果是否正确
     *
     * @param modelAndView 响应
     * @param result       结果
     * @param condition    判断条件
     * @param smsg         返回页面的正确消息
     * @param emsg         返回页面的错误消息
     * @param url          成功后将要跳转的地址
     * @throws IOException
     * @throws ServletException
     */
    public static void judgeGoto(ModelAndView modelAndView, int result, int condition, String smsg, String emsg,
                                 String url) throws ServletException, IOException {
        if (result > condition) {
            HTMLUtils.success(modelAndView, smsg, url);
        } else {
            HTMLUtils.error(modelAndView, emsg);
        }
    }

    /**
     * 限制进入页面
     *
     * @param session  session
     * @param restrict 被限制的账号在session中的名称
     * @param msg      限制提示信息
     * @throws IOException
     * @throws ServletException
     */
    public static boolean restrictTeacher(HttpSession session, ModelAndView modelAndView, String restrict, String msg) throws ServletException, IOException {
        if ((session.getAttribute(restrict) != null)) {
            HTMLUtils.error(modelAndView, msg);
            return true;
        }
        return false;
    }
}
