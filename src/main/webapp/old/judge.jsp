<%@page import="cn.my.work.utils.CookieUtils"%>
<%@page import="cn.my.work.utils.JsUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	if(CookieUtils.getCookie("cksid", request) == "") {
		JsUtils.jsGo(response.getWriter(), "你还没有登录，请登录！", "login");
	}
 %>