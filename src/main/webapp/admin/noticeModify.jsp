<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<%@ include file="judge.jsp"%>
<head>
<title>作业管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-select.min.css">
<link rel="stylesheet" type="text/css"
	href="css/awesome-bootstrap-checkbox.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body class="flat-blue sidebar-collapse">
	<%@ include file="left.jsp"%>
	<div class="content-container">
		<%@ include file="header.jsp"%>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title red"><h3>公告更改</h3>
					</span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">公告</div>
						<form action="noticeModify" method="post" class="form-vertical"
							enctype="">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="ngid">
										<c:choose>
											<c:when test="${sessionScope['admin']['agid'] == 0 }">
												<c:forEach items="${grades }" var="grade">
													<option value="${grade['gid'] }">${grade['gname']
														}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="${grade['gid'] }">${grade['gname'] }</option>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">公告类型：</label>
									 <select name="ntype">
										<option value="1" <c:if test="${notice['ntype'] == 1 }"> selected="selected"</c:if>>作业公告</option>
										<option value="2" <c:if test="${notice['ntype'] == 2 }"> selected="selected"</c:if>>考试公告</option>
										<option value="3" <c:if test="${notice['ntype'] == 3 }"> selected="selected"</c:if>>课程公告</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">紧急事件：</label>
									 <select name="nemergency">
										<option value="1" <c:if test="${notice['nemergency'] == 1 }"> selected="selected"</c:if>>是</option>
										<option value="0" <c:if test="${notice['nemergency'] == 0 }"> selected="selected"</c:if>>否</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">标题</label> <input
										name="ntitle" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="请输入标题" value="${notice['ntitle'] }"> 
										<%-- <input name="naid" value="${sessionScope['admin']['aid'] }"
										type="hidden"> --%>
										<input name="nid" type="hidden" class="form-control"
										id="exampleInputPassword1" placeholder="请输入来源" value="${notice['nid'] }">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">来源</label> <input
										name="nfrom" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="请输入来源" value="${notice['nfrom'] }">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">内容</label>
									<textarea name="ncontent" class="form-control" rows="3">${notice['ncontent'] }</textarea>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">修改</button>
									<button type="reset" class="btn btn-default" onclick="history.back()">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
</body>

</html>
