<%@page import="cn.my.work.utils.JsUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="judge.jsp" %>
<div id="header">
	 <p>欢迎${sessionScope['student']['sname'] }来到作业查询系统</p>
	</div>
	<div id="title">
	 <ul id="title_ul">
	 	<li class="title_first"><a href="index">主页</a></li>
	 	<li class="title_first">
			<a href="work">作业</a><!-- TODO -->
		<ul class="title_second">
		 	<li><a href="">网页美术基础</a></li>
		 	<li><a href="">计算机维护与维修</a></li>
		 	<li><a href="">计算机网络基础</a></li>
		 	<li><a href="">移动开发基础</a></li>
		 	<li><a href="">大学生创新创业与就业指导</a>（二）</li>
		 </ul> 
		 </li>
	 	<li  class="title_first">null
		 <ul  class="title_second">
		 	<li><a href="">网页美术基础</a></li>
		 	<li><a href="">计算机维护与维修</a></li>
		 	<li><a href="">计算机网络基础</a></li>
		 	<li><a href="">移动开发基础</a></li>
		 	<li><a href="">大学生创新创业与就业指导</a>（二）</li>
		 </ul> 
		 </li>
	 </ul>
	</div>