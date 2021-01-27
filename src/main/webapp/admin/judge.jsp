<%@ page language="java" import="com.worksystem.utils.JsUtils" pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("admin") == null && session.getAttribute("teacher") == null) {
		JsUtils.jsGo(response.getWriter(), "你还没有登录，请登录！", "login");
	}
 %>