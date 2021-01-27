<%@ page import="com.worksystem.utils.CookieUtils" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String sid = CookieUtils.getCookie("cksid", ((HttpServletRequest) request));
		if(sid == null || sid.isEmpty()) {
			((HttpServletResponse) response).sendRedirect("login");
		}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>交个作业</title>
<link rel="stylesheet" type="text/css" href="Style/index.css"/>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="Style/ks.css" rel="stylesheet" type="text/css" />
<script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="Script/Common.js" type="text/javascript"></script>
<script src="Script/Data.js" type="text/javascript"></script>


<script src="Script/changeOption.js" type="text/javascript"></script>
<script src="Script/rl.js" type="text/javascript"></script>
</head>
<body>
	<div class="background"></div>
	<div class="popup">
			<img src="images/exit.png" alt="关闭" id="exit">
			有紧急通知！！！！！
			<a href="" id="details">点击查看详情</a>
		</div>
	<%@ include file="header.jsp"%>
	<div class="page">
		<div class="box mtop">
			<%@ include file="left.jsp"%>
			<div class="rightbox">
				<h2 class="mbx">我的学习中心&nbsp;&nbsp;&nbsp;&nbsp;</h2>

				<div class="dhbg">
					<div class="dh1" style="margin: 0 27px 15px 0;">
						<div class="dhwz">
							<p>
								您共有 <span class="red">0</span>条通知信息 <span class="red">0 </span>条未读
							</p>
							<p>
								共有 <span class="red">0 </span>条短信息、 <span class="red">0</span>个投诉、
								<span class="red"> 0 </span>个异议
							</p>
							<p>
								有 <span class="red">0</span>个投诉、<span class="red">0 </span>个异议、<span
									class="red">0</span>条短信息未处理
							</p>
							<div class="btright">
								<a href="#"> <img
									src="images/Student/default/bt_bzr.jpg" alt="给班主任发消息"
									width="121" height="25" />
								</a>
							</div>
						</div>
					</div>
					<div class="dh2">
						<div class="dhwz">
							<p>
								你有 <span class="red">0</span> 门课程要考 <a
									href="#" class="red">查看报考计划</a>
							</p>
							<p>
								你已经通过 <span class="red">0 </span>门课程&nbsp;共有 <span class="red">0</span>
								门 <a href="#" class="red">查看成绩</a>
							</p>
							<p>
								已经发放了 <span class="red">0 </span>本书籍 <a
									href="#" class="red">查看书籍情况</a>
							</p>
							<div class="btright">
								<a href="#"> <img
									src="images/Student/default/bt_jw.jpg" alt="进入教务中心" width="121"
									height="25" />
								</a>
							</div>
						</div>
					</div>
					<div class="dh3" style="margin: 0 27px 15px 0;">
						<div class="dhwz">
							<p>
								<a
									href="#">模拟考试</a>
							</p>
							<p>
								<a
									href="#">章节练习</a>
							</p>
							<p>
								<a
									href="#">网上作业</a>
							</p>
							<div class="btright">
								<a
									href="#">
									<img src="images/Student/default/bt_ks.jpg" alt="进入考试中心"
									width="121" height="25" />
								</a>
							</div>
						</div>
					</div>
					<div class="dh4">
						<div class="dhwz">
							<p>
								你应交<span class="blue">0</span> 元，实缴 <span class="green">0</span>元
							</p>
							<p>
								欠费 <span class="red">0</span> 元
							</p>
							<p>
								你总共有<span class="red">0</span> 条财务记录需要确定
							</p>

							<div class="btright">
								<a href="#"> <img
									src="images/Student/default/bt_cw.jpg" alt="进入财务中心" width="121"
									height="25" />
								</a>
							</div>
						</div>
					</div>
				</div>

<%--				<div class="xxlc">--%>
<%--					<strong class="lcbt">学历历程</strong>--%>
<%--				</div>--%>
<%--				<div class="lcbiao">--%>
<%--					<div class="lctime">2014-05-01</div>--%>
<%--					<div class="lctime">2014-05-02</div>--%>
<%--					<div class="lctime">2014-05-03</div>--%>
<%--					<div class="lctime2">2014-05-04</div>--%>
<%--					<div class="lctime">2014-05-05</div>--%>
<%--					<div class="lctime">2014-05-06</div>--%>
<%--					<div class="lctime">2014-05-07</div>--%>
<%--				</div>--%>
<%--				<div class="xxjl">--%>

<%--					<div align="center">--%>
<%--						<span> 18:10 登陆系统 <a></a> </span>--%>
<%--					</div>--%>


<%--					<div align="center">--%>
<%--						<span> 18:09 登陆系统 <a></a> </span>--%>
<%--					</div>--%>


<%--					<div align="center">--%>
<%--						<span> 18:06 登陆系统 <a></a> </span>--%>
<%--					</div>--%>


<%--					<div align="center">--%>
<%--						<span> 11:19 登陆系统 <a></a> </span>--%>
<%--					</div>--%>


<%--				</div>--%>

			</div>
		</div>
		
		
	</div>
	<%@ include file="footer.jsp"%>
	<div style="text-align:center;"></div>
<script type="text/javascript">
//<c:url value='/User/StudentInfor/notice?nid='/>${notice}
	var popup = document.getElementsByClassName("popup")[0];
	var background = document.getElementsByClassName("background")[0];
	var details = document.getElementById("details");
		if(${notice } > 0) {
			popup.style.display = "block";
			background.style.display = "block";
			window.i++;
			details.href = "<c:url value='/User/StudentInfor/notice?nid='/>${notice }";
		}
		
	// 关闭全屏通知
	var exit = document.getElementById("exit");
	exit.onclick = function() {
		popup.style.display = "none";
		background.style.display = "none";
	};
</script>
</body>
</html>
