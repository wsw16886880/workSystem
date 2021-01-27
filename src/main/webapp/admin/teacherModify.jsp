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
                    <span class="page-title red"><h3>老师更改</h3></span>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">老师</div>
                        <form action="teacherModify" method="post" class="form-vertical" enctype="">
                            <div class="block-content">
                            	<div class="form-group">
								    <label for="exampleInputPassword1">账号：</label>
                                    <input name="taccount" type="text" value="${teacher['taccount'] }" class="form-control" id="exampleInputPassword1" placeholder="作业名称">
								</div>
								<div class="form-group">
                                    <label for="exampleInputPassword1">密码</label>
                                    <input name="tpwd" type="text" value="${teacher['tpwd'] }" class="form-control" id="exampleInputPassword1" placeholder="作业名称">
                                </div>
                                    <input name="tid" type="hidden" value="${teacher['tid'] }" class="form-control" id="exampleInputPassword1" placeholder="作业名称">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">姓名：</label>
                                    <input name="tname" type="text" value="${teacher['tname'] }" class="form-control" id="exampleInputPassword1" placeholder="作业名称">
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
