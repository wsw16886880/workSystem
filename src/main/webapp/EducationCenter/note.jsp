<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="stylesheet" type="text/css" href="../Style/notice.css"/>
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
<script src="../Script/Base.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
	function confirmStatus(bid) {
		if (confirm("确定确认无误吗？") == true) {
			senateCenter.modifyStudentBookStatus(bid, 2, function(data) {
				var result = $.parseJSON(data);
				if ((String(result.ok) == "true")) {
					jBox.alert(result.message, "提示");
					setTimeout(function() {
						window.location.reload();
					}, 1500);
				} else {
					jBox.tip(result.message);
				}
			});
		}
	}

	function submitObjection(bid) {
		var mtitle = "书籍有异议";
		var html = "<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>异议内容：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

		var submit = function(v, h, f) {
			if (f.objeCont == '' || f.objeCont.length > 80) {
				$.jBox.tip("请您输入异议内容，且不超过80个字！", 'error', {
					focusId : "objeCont"
				}); // 关闭设置 objeCont 为焦点
				return false;
			}

			StudentCompain.insertCompain('', mtitle, 2, f.objeCont, function(
					data) {
				var obj = $.parseJSON(data);
				var resultObj = false;
				if (obj.ok) {
					senateCenter.modifyStudentBookStatus(bid, 3,
							function(data) {
								var result = $.parseJSON(data);
								if ((String(result.ok) == "true")) {
									jBox.alert("成功提交异议！", "提示");
									setTimeout(function() {
										window.location.reload();
									}, 1500);
								} else {
									jBox.tip("提交异议失败！");
									return false;
								}
							});
				} else {
					jBox.tip("提交异议失败！");
				}
			});
		};

		$.jBox(html, {
			title : "提交异议",
			submit : submit
		});
	}
</script>
</head>
<body>

	<%@ include file="../header.jsp"%>
	<div class="page">
		<div class="box mtop">
			<%@ include file="../left.jsp"%>
			<div class="rightbox">

				<h2 class="mbx">教务中心 &gt; 我的作业</h2>
				<%@include file="../educationCenterHeader.jsp"%>
				<div class="cztable">
					<div class="title">${note['ntitle'] }</div>
					<div class="message">
						<span>所属课程：${relate['sjname'] }</span><span>所属作业：${relate['wname'] }</span> <span>时间：<fmt:formatDate value="${note['ndate'] }" pattern="yyyy-MM-dd"/></span>
					</div>
					<div class="content">${note['ncontent'] }</div>

				</div>

			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
	<script type="text/javascript">
		/**
		 * 查看学生是否交作业，如果交了，显示是，未交，显示一个提交文件的input和提交的按钮
		 */
		function addIssubmit() {
			//获取学生是否交作业
			var issubmits = document.getElementsByClassName("issubmit");
			//遍历是否为空
			for ( var i = 0; i < issubmits.length; i++) {
				//为空则添加提交文件的input
				if (issubmits[i].firstChild.nodeValue.trim() == '否') {
					//创建input文件选择框
					var inputFile = document.createElement("input");
					inputFile.type = "file";
					inputFile.name = "zuoye";
					//创建提交按钮
					var inputSubmit = document.createElement("input");
					inputSubmit.value = "提交作业";
					inputSubmit.type = "submit";
					//将2个按钮添加进单元格中，通过class=issubmit这个条件可以直接获取单元格
					var issubmit = issubmits[i];
					issubmit.style.color = "red";
					// issubmit.innerHTML = "";
					issubmit.appendChild(inputFile);
					issubmit.appendChild(inputSubmit);
				}
			}
		}

		/**
		 * 将选择的周数添加到参数中
		 */
		function selected(weeks) {
			//拿到选项的索引
			var index = weeks.selectedIndex;
			//获取索引所在的option的value
			var value = weeks.options[index].value;
			//获取传参数的对应的input
			var inputWeek = document.getElementById("week");
			//传值
			inputWeek.value = value;
		}

		//调用检查作业方法
		addIssubmit();
	</script>
</body>
</html>
