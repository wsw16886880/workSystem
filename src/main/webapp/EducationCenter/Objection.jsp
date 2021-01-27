<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>
			交个作业
		</title>
		<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
		<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
		<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
		<script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="../Script/Common.js" type="text/javascript"></script>
		<script src="../Script/Data.js" type="text/javascript"></script>
		<script src="../Script/ajaxUtils.js" type="text/javascript" charset="utf-8"></script>

		<script type="text/javascript">
			function showMsg(msg, obj) {
				jBox.tip(msg);
				$("#" + obj).focus();
			}
		</script>
	</head>
	<body>

		<%@ include file="../header.jsp" %>
		<div class="page">
			<div class="box mtop">
				<%@ include file="../left.jsp" %>
				<div class="rightbox">

					<h2 class="mbx">教务中心 &gt; 课程笔记</h2>
					<div class="morebt">

						<%@include file="../educationCenterHeader.jsp" %>

					</div>
					<div class="cztable">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<div>
								<form action="noteList" method="post">
									<select name="nsjid" id="selectNsjid">
										<option value="0">所有课程</option>
										<c:forEach items="${subjects }" var="subject">
											<option value="${subject['sjid'] }">${subject['sjname'] }</option>
										</c:forEach>
									</select>
									<select name="nweek" id="selectNweek">
										<option value="-1">==请选择周数==</option>
									</select>
									<input type="submit" value="查询">
								</form>
							</div>
							<tr>
								<th style="text-align:center;" width="5%">序号</th>
								<th style="text-align:center;" width="10%">所属课程</th>
								<th width="15%">所属作业</th>
								<th width="20%">标题</th>
								<th style="text-align:center;" width="5%">周</th>
								<th style="text-align:center;" width="13%">发布时间</th>
							</tr>
							<c:forEach items="${notes }" var="note" varStatus="vs">
							<tr style="height: 28px" class="tdbg" align="center">
								<!-- <td colspan="13" align="left" style="color: Red; font-weight:bold;">未找到异议信息!</td> -->
								<td style="text-align:center;" width="5%">${vs['count'] }</td>
								<td style="text-align:center;" width="10%">${note['sjname'] }</td>
								<td width="15%">${note['wname'] }</td>
								<td width="20%"><a href="note?nid=${note['nid']}">${note['ntitle'] }</a></td>
								<td style="text-align:center;" width="5%">${note['nweek'] }</td>
								<td style="text-align:center;" width="13%"><fmt:formatDate
										value="${note['ndate'] }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							</c:forEach>
						</table>
					</div>



				</div>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
	</body>
	<script type="text/javascript">
		var selectNsjid = document.getElementById("selectNsjid"); // 课程
		var selectNweek = document.getElementById("selectNweek"); // 周数

		var cellback = function(date) {

			/*
			1. 删除所有节点
			2. 创建option
			3. 添加文本
			4. 添加进selectNweek中
			*/
		   var weekOptionArray = selectNweek.getElementsByTagName("option");
			while (weekOptionArray.length > 1) {
				selectNweek.removeChild(weekOptionArray[1]);
			}

			var notes = date;

			for (var i = 0; i < notes.length; i++) {
				var option = document.createElement("option");
				option.value = notes[i].nweek;
				var textNode = document.createTextNode(notes[i].nweek);
				option.appendChild(textNode);
				
				selectNweek.appendChild(option);
			}

			
		};

		// 设置监听
		selectNsjid.onchange = function() {
			var params = "nsjid=" + selectNsjid[selectNsjid.selectedIndex].value;
			console.log(params);
			ajax("POST", "<c:url value='/EducationCenter/note' />", true, params, cellback, "json"); 
		};
	</script>
</html>
