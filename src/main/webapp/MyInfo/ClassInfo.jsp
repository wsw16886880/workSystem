<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>交个作业</title>
<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
<script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../Script/Common.js" type="text/javascript"></script>
<script src="../Script/Data.js" type="text/javascript"></script>
<script src="../Script/ajaxUtils.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
	//学生投诉异议
	function onSaveProblem() {
		var studentId = $("#studentId").val();
		var workAssess = $('input[name="workAssess"]:checked').val();
		var problemContent = $("#problemContent").val();
		var problemType = $('input[name="problemType"]:checked').val();
		var problemTypeStr = "学生";
		switch (problemType) {
		case "4":
			problemTypeStr += "提问";
			break;
		case "3":
			problemTypeStr += "意见";
			break;
		case "1":
			problemTypeStr += "投诉";
			break;
		default:
			break;
		}

		if (problemContent.length <= 0) {
			jBox.tip("请填写问题反馈的内容！");
			return false;
		} else {
			problemContent = "工作评价：" + workAssess + "，" + problemContent;
			StudentCompain.insertCompain(studentId, problemTypeStr,
					problemType, problemContent, function(data) {
						var obj = $.parseJSON(data);
						if (obj.ok == true) {
							jBox.alert(obj.message, "提示");
							setTimeout(function() {
								window.location.reload();
							}, 1500);
						} else {
							jBox.tip(obj.message);
						}
					});
		}
	}
</script>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="page">
		<div class="box mtop">
			<%@ include file="../left.jsp"%>
			<div class="rightbox">


				<h2 class="mbx">我的信息 &gt; 班级信息&nbsp;&nbsp;&nbsp;</h2>
				<div class="morebt">


					<%@include file="../../myInfoHeader.jsp"%>

				</div>
				<div class="cztable">

					<div class="item ">
						<div>
						<label for="exampleInputPassword1">学期：</label>
						 <select id="sel" name="stsemester">
							<option value="1">大一上学期</option>
							<option value="2">大一下学期</option>
							<option value="3">大二上学期</option>
							<option value="4">大二下学期</option>
							<option value="5">大三上学期</option>
							<option value="6">大三下学期</option>
						</select>
						<a id="check" href="javascript:;" style="font-size: 14px;">&nbsp;&nbsp;查询</a>
						</div>
						 <a id="down" href="<c:url value='/school_timetable/'/>${st}" download="课表 .jpg">
						<img id="timetable" src="<c:url value='/school_timetable/'/>${st}" alt="课表图片">
						</a>

					</div>

				</div>

			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
<script type="text/javascript">
	var sel = document.getElementById("sel");
	var a = document.getElementById("check");
	var img = document.getElementById("timetable");
	var down = document.getElementById("down");
	var params;
	sel.onchange = function() {
		/* a.href = "<c:url value='/MyInfo/school_timetable'/>?stsemester="+(sel.selectedIndex+1); */
		params = "stsemester="+(sel.selectedIndex+1);
	}
	
	var cellback = function(date) {
		img.src="<c:url value='/school_timetable/'/>"+date;
		down.href = "<c:url value='/school_timetable/'/>"+date;
	}
	
	a.onclick = function() {
		ajax("POST", "<c:url value='/MyInfo/school_timetable'/>", true, params, cellback, "text");
	}
</script>
</html>
