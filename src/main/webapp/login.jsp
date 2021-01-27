<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录_作业系统</title>
	<link href="css/login.css" type="text/css" rel="stylesheet">
</head>

<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="login_banner">
			<img src="img/login/banner.jpg" style="opacity: 1">
			<img src="img/login/banner.jpg" style="opacity: 0">
			<img src="img/login/banner.jpg" style="opacity: 0">
		</div>
		<div id="login_wrap_form">
			<div id="title">
				<p>账号登录</p>
			</div>
			<div id="fo">
				<form action='<c:url value="/login"/>' method="post">
					<input id="text" type="text" name="snumber" placeholder="请输入学号"/>
					<p style="color:red;">${requestScope['StudentRuntimeException'] }</p>
					<br>
					<span>${sn}</span>
					<input id="password" type="password" name="spwd" placeholder="请输入密码"/>
					<span>${sp}</span>
					<br>
					<input id="submit" type="submit" value="登录">
				</form>
				<p id="wjmm"><a href="">忘记密码</a></p>
				<p id="ljzc"><a href="">立即注册</a></p>
			</div>
			<div></div>
		</div>
	</div>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
