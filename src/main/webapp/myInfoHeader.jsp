<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="<c:url value='/MyInfo/studentInfo'/>">个人资料</a> </li>
    <li><a class="tab2" onclick="" href="<c:url value='/MyInfo/school_timetable'/>">班级课程</a></li>
    <li><a class="tab2" onclick="" href="<c:url value='/User/StudentInfor/Letter.jsp'/>">短信息</a></li>
    <li><a class="tab2" onclick="" href="<c:url value='/User/StudentInfor/noticeList'/>">公告<span style="color:#ff0000; padding-left:5px;" id="unreadSysMsgCount"></span></a></li>
</ul>