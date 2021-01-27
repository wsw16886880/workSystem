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
                    <span class="page-title red"><h3>表格</h3></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>所带班级&nbsp;<a href="gradeList">查看详情</a></h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">任课班级</div>
                        <div class="block-content">
                            <c:choose>
                        	 <c:when test="${empty grades }">
                        	 	<table class="table table-hover table-bordered">
                        	 </c:when>
                        	 <c:otherwise>
                             	<table id="example" class="table table-striped" cellspacing="0" width="100%">
                        	 </c:otherwise>
                        	</c:choose>
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>班级</th>
                                        <th>人数</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                	<c:when test="${not empty sessionScope['teacher']}">
                                	  <c:forEach items="${grades }" var="grade" varStatus="vs">
<%--		                                <c:forEach items="${grade }" var="g">--%>
		                                    <tr>
		                                        <th scope="row">${vs['count'] }</th>
		                                        <td>${grade['gname'] }</td>
		                                        <td>${grade['gtotal'] }</td>
		                                        <td><a href="#" onclick="alert('暂无权限删除!')"><img src="images/icon_delete.gif" />删除</a>
		                                        <a href="#"  onclick="alert('暂无权限修改!')"><img src="images/icon_edit.gif" />修改</a>
		                                        </td>
		                                    </tr>
<%--		                                </c:forEach>--%>
		                              </c:forEach>
	                                </c:when>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
			<div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>作业&nbsp;<a href="workList">查看详情</a></h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">作业表</div>
                        <div class="block-content">
                            <c:choose>
                        	 <c:when test="${empty works }">
                        	 	<table class="table table-hover table-bordered">
                        	 </c:when>
                        	 <c:otherwise>
                             	<table id="example" class="table table-striped" cellspacing="0" width="100%">
                        	 </c:otherwise>
                        	</c:choose>
                                <thead>
                                    <tr>
                                        <th>班级</th>
                                        <th>作业名称</th>
                                        <th>类型</th>
                                        <th>交作业人数</th>
                                        <th>未交人数</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
	                               	 <c:if test="${not empty works}">
	                               	   <c:forEach items="${works }" var="work">
<%--	                               	 	<c:forEach items="${work }" var="w">--%>
		                                    <tr>
		                                        <th scope="row">${work['gname'] }</th>
		                                        <td>${work['wname'] }</td>
		                                        <td>${work['wtype'] }</td>
		                                        <td>${work['wtotal'] }</td>
		                                        <td>
		                                         <c:if test="${work['gtotal']-work['wtotal'] == 0 }">已交齐</c:if>
		                                         <c:if test="${work['gtotal']-work['wtotal'] != 0 }">${work['gtotal']-work['wtotal'] }</c:if>
		                                        </td>
		                                        <td>
		                                        <a href="workModify?wid=${work['wid'] }&wgid=${work['wgid']}"><img src="images/icon_edit.gif" />修改</a>
		                                        <a href="lateList"><img src="images/search.png" width="16px" />查看详情</a>
		                                        <a href="lateDownload?lwid=${work['wid'] }&lweek=${work['week']}"><img src="images/download.png" width="16px" />下载作业</a>
		                                        </td>
		                                    </tr>
<%--		                                </c:forEach>--%>
		                               </c:forEach>
		                              </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>作业上交情况&nbsp;<a href="lateList">查看详情</a></h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">总表</div>
                        <div class="block-content">
                        	<c:choose>
                        	 <c:when test="${empty lates }">
                        	 	<table class="table table-hover table-bordered">
                        	 </c:when>
                        	 <c:otherwise>
                             	<table id="example" class="table table-striped" cellspacing="0" width="100%">
                        	 </c:otherwise>
                        	</c:choose>
                                <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>学号</th>
                                        <th>作业</th>
                                        <th>周</th>
                                        <th>已交</th>
                                        <th>提交时间</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${lates }" var="late">
                                    <tr>
                                        <td>${late['lsname'] }</td>
                                        <td>${late['lsnumber'] }</td>
                                        <td>${late['lname'] }</td>
                                        <td>${late['lweek'] }</td>
                                        <td>${late['issubmit'] }</td>
                                        <td>${late['ldate'] }</td>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
