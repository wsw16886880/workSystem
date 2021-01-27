<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="judge.jsp" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link href="css/work.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/work.js"></script>
<title>作业</title>
</head>

<body>
	<%@include file="header.jsp"%>
	<div id="content">
		<div class="week">
			<span>第<select name="weeks" id="sweeks" onChange="selected(this)">
					<option value="all">All</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">8</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
			</select>周</span>
			<form action='<c:url value="/workList"/>' method="post">
				<input id="sid" type="hidden" name="sid" value="${sessionScope['student']['sid'] }" /> 
				<input id="week" type="hidden" name="week" value="All" />
				<input type="submit" value="查找" />
			</form>
		</div>
		<table id="table" cellspacing="0" border="1">
			<tr style="background-color: rgba(199,255,255,1.00);">
				<th class="list">序号</th>
				<th class="list">姓名</th>
				<th id="stunum" class="list">学号</th>
				<th class="list">已交</th>
				<th class="list">周</th>
				<th class="list">课程</th>
				<th class="list">作业名称</th>
				<th class="list">类型</th>
				<th class="content">内容</th>
				<th class="list">截止时间</th>
			</tr>
			<c:forEach items="${requestScope['lates'] }" var="late" varStatus="vs">
				<c:choose>
					<c:when test="${vs['count']%2==1 }">
						<c:set var="class" value="one" />
					</c:when>
					<c:otherwise>
						<c:set var="class" value="two" />
					</c:otherwise>
				</c:choose>
				<tr class="${pageScope['class'] }">
					<td class="list">${vs['count']}</td>
					<td class="list">${late['lsname'] }</td>
					<td id="stunum" class="list">${late['lsnumber'] }</td>
					<td class="list">
				   <form class="issubmit" action="file" method="post" enctype="multipart/form-data">${late['issubmit']}
					<input id="sid" type="hidden" name="sid" value="${late['lsid'] }" />
					<input id="lweek" type="hidden" name="lweek" value="${late['lweek'] }" />
					<input id="lname" type="hidden" name="lname" value="${late['lname'] }" />
					<input id="lwid" type="hidden" name="lwid" value="${late['lwid'] }" />
				   </form>
					</td>
					<td class="list">${late['lweek'] }</td>
					<td class="list">${late['lsubject'] }</td>
					<td class="list">${late['lname'] }</td>
					<td class="list">${late['ltype'] }</td>
					<td class="content">${late['lcontent'] }
					<br/>
					<a href="download?wid=${late.lwid }" style="color: red;">下载源文件</a>
					</td>
					<td class="list">${late['ldate'] }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		addIssubmit();
	</script>
</body>
</html>
