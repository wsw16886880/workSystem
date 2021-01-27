<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
*{ margin:0; padding:0;}
#wrap{ width:600px; border:1px solid #CCC; border-radius:5px; margin:100px auto;}
#wrap h1{ background:#333; line-height:50px; text-align:center; font-size:18px; color:#FFF;}
#wrap p{ text-align:center; line-height:30px; font-size:16px;}
</style>
</head>

<body>
<div id="wrap">
	<h1>${msg}</h1>
	<p id="infotext">自动后退：3秒</p>
    <p><a href="${url}">后退</a></p>
</div>
<script language="javascript">
var url="${url}";
var t=setInterval(show,1000);
var i=3;
console.log(location.href)
function show(){
	document.getElementById("infotext").innerHTML="自动后退："+i+"秒";
	i--;
	if(i==0){
		clearInterval(t);
		location.href=url;
	}
}
</script>
</body>
</html>

