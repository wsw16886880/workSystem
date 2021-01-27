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
                    <span class="page-title"><h4>笔记列表&nbsp;<a href="noteList">查看所有科目笔记</a></h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">总表</div>
                        <div class="block-content">
                        	<c:choose>
                        	 <c:when test="${empty notes }">
                        	 	<table class="table table-hover table-bordered">
                        	 </c:when>
                        	 <c:otherwise>
                             	<table id="example" class="table table-striped" cellspacing="0" width="100%">
                        	 </c:otherwise>
                        	</c:choose>
                                <thead>
                                    <tr>
                                        <th>所属课程</th>
                                        <th>所属作业</th>
                                        <th>标题</th>
                                        <th>发布周</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${notes }" var="note">
                                    <tr>
                                        <td>${note['sjname'] }</td>
                                        <td><c:if test="${note['wname'] == '' }">无</c:if>
                                        <c:if test="${note['wname'] != '' }">${note['wname'] }</c:if></td>
                                        <td>${note['ntitle'] }</td>
                                        <td>${note['nweek'] }</td>
                                        <td><a href="noteDelete?nid=${note['nid'] }" onclick="return confirm('真的要删除吗？')"><img src="images/icon_delete.gif" />删除</a>
                                            <a href="noteModify?nid=${note['nid'] }"><img src="images/icon_edit.gif" />修改</a>
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

