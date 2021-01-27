<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="leftbox">
	<div class="l_nav2">
		<div class="ta1">
			<strong>个人中心</strong>
			<div class="leftbgbt"></div>
		</div>
		<div class="cdlist">
			<div>
				<a href="<c:url value='/MyInfo/studentInfo'/>">我的信息</a>
			</div>
			<div>
				<a href="<c:url value='/MyInfo/school_timetable'/>">班级课程 </a>
			</div>
			<div>
				<a href="<c:url value='/User/StudentInfor/Letter.jsp'/>">短信息</a>
			</div>
			<div>
				<a href="<c:url value='/User/StudentInfor/noticeList'/>">学院通知</a>
			</div>
		</div>
		<div class="ta1">
			<strong>教务中心</strong>
			<div class="leftbgbt2"></div>
		</div>
		<div class="cdlist">
			<div>
				<a href="<c:url value='/EducationCenter/Score.jsp'/>">我的成绩</a>
			</div>
			<div>
				<a href="<c:url value='/EducationCenter/toworkList'/>">我的作业</a>
			</div>
			<div>
				<a href="<c:url value='/EducationCenter/noteList'/>">课程笔记</a>
			</div>
		</div>
		<div class="ta1">
			<strong>教学系统</strong>
			<div class="leftbgbt2"></div>
		</div>
	</div>
</div>