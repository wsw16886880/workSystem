<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wenjunHappy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#pp{
			color: red;
			font-size: 72px;
		}
		#divv{
			width: 50%;
			margin-right: auto;
			margin-left: auto;
			margin: auto;
		}
	</style>
  </head>
  
  <body>
    <p id="pp">好吧，沙雕文俊，生日快乐哈哈哈哈哈哈</p>
	<div id="divv"><img src="img/666/666.jpg" alt="生日快乐" width="50%" ></div>
  </body>
</html>
