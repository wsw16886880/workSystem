<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<%@ include file="judge.jsp" %>
<head>
    <title>作业管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
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
    <%@ include file="left.jsp" %>
    <div class="content-container">
        <%@ include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title red"><h3>学委更改</h3></span>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">学委</div>
                        <form action="adminModify" method="post" class="form-vertical" enctype="">
                            <div class="block-content">
                                <div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="agid">
										<c:choose>
											<c:when test="${sessionScope['admin']['agid'] == 0 }">
												<c:forEach items="${grades }" var="grade">
													<option value="${grade['gid'] }"  <c:if test="${grade['gid'] == admin['agid'] }">selected="selected"</c:if> >${grade['gname']
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
								    <label for="exampleInputPassword1">账号：</label>
                                    <input name="account" type="text" value="${admin['account'] }" class="form-control" id="exampleInputPassword1" placeholder="学委登录账号">
								</div>
								<div class="form-group">
                                    <label for="exampleInputPassword1">密码</label>
                                    <input name="apwd" type="text" value="${admin['apwd'] }" class="form-control" id="exampleInputPassword1" placeholder="登录密码">
                                </div>
                                    <input name="aid" type="hidden" value="${admin['aid'] }" class="form-control">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">姓名：</label>
                                    <input name="aname" type="text" value="${admin['aname'] }" class="form-control" id="exampleInputPassword1" placeholder="学委姓名">
                                </div>
                            </div>
                            <div class="block-footer">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">更改</button>
                                    <button type="reset" class="btn btn-default" onclick="history.back()">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                <%@ include file="footer.jsp" %>
                </div>
</body>

</html>
