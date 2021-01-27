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
                    <span class="page-title"><h4>留言列表&nbsp;<a href="messageList">查看所有科目留言</a></h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">总表</div>
                        <div class="block-content">
                        	<c:choose>
                        	 <c:when test="${empty messages }">
                        	 	<table class="table table-hover table-bordered">
                        	 </c:when>
                        	 <c:otherwise>
                             	<table id="example" class="table table-striped" cellspacing="0" width="100%">
                        	 </c:otherwise>
                        	</c:choose>
                                <thead>
                                    <tr>
                                        <th>作业名称</th>
                                        <th>班级</th>
                                        <th>学号</th>
                                        <th>姓名</th>
                                        <th>留言内容</th>
                                        <th>留言时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${messages }" var="message">
                                    <tr>
                                        <td>${message['wname'] }</td>
                                        <td>${message['gname'] }</td>
                                        <td>${message['snumber'] }</td>
                                        <td>${message['sname'] }</td>
                                        <td>${message['mcontent'] }</td>
                                        <td>${message['mtime'] }</td>
                                        <td><a href="messageDelete?mid=${message['mid'] }" onclick="return confirm('真的要删除吗？')"><img src="images/icon_delete.gif" />删除</a>
                                                </td>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    <%@ include file="footer.jsp" %>
    </div>
    <script type="text/javascript">
    $(function() {
        $('#example').DataTable();
    });
    </script>
</body>

</html>

