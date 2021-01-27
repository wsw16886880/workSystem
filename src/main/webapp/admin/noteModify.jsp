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
					<span class="page-title red"><h3>笔记更改</h3> </span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">添加笔记</div>
						<form action="noteModify" method="post" class="form-vertical">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputPassword1">所属课程：</label> <select
										name="nsjid">
										<c:forEach items="${subjects }" var="sj">
											<option value="${sj['sjid'] }" <c:if test="${note['nsjid'] == sj['sjid'] }">selected="selected"</c:if> >${sj['sjname'] }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">所属作业：</label> <select
										name="nwid">
										<option value="0">无</option>
										<c:forEach items="${works }" var="work">
											<option value="${work['wid'] }" <c:if test="${note['nwid'] == work['wid'] }">selected="selected"</c:if> >${work['wname'] }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">标题</label> <input
										type="text" name="ntitle" class="form-control"
										id="exampleInputPassword1" value="${note['ntitle'] }">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">周数</label> <input
										type="text" name="nweek" class="form-control"
										id="exampleInputPassword1" value="${note['nweek'] }">
									<input type="hidden" name="nid" value="${note['nid'] }">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">来源</label> <input
										type="text" name="nfrom" class="form-control"
										id="exampleInputPassword1" value="${note['nfrom'] }">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">内容</label>
									<textarea name="ncontent" class="form-control" rows="3">${note['ncontent'] }</textarea>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">添加</button>
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
