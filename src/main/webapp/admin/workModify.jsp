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
                    <span class="page-title red"><h3>作业更改</h3></span>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">作业</div>
                        <form action="workModify" method="post" class="form-vertical" enctype="multipart/form-data">
                            <div class="block-content">
                            	<div class="form-group">
								    <label for="exampleInputPassword1">班级：</label>
								    <select name="wgid">
								     <c:choose>
									     <c:when test="${sessionScope['admin']['agid'] == 0 }">
									      <c:forEach items="${grades }" var="grade">
									       <option value="${grade['gid'] }">${grade['gname'] }</option>
									      </c:forEach>
									     </c:when>
									     <c:otherwise>
									       <option value="${grade['gid'] }">${grade['gname'] }</option>
									     </c:otherwise>
									 </c:choose>
								    </select>
								</div>
                                    <input name="wid" type="hidden" value="${work['wid'] }" class="form-control" id="exampleInputPassword1" placeholder="作业名称">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">作业名称</label>
                                    <input name="wname" type="text" value='${work['wname'] }' class="form-control" id="exampleInputPassword1" placeholder="作业名称">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">第几周的作业</label>
                                    <input name="week" type="text" value="${work['week'] }" class="form-control" id="exampleInputPassword1" placeholder="周数">
                                </div>
                                <div class="form-group">
								    <label for="exampleInputPassword1">所属课程：</label>
								    <select name="wsjid">
								    
								     <c:forEach items="${subjects }" var="sj">
								      <option value="${sj['sjid'] }" <c:if test="${work['wsjid'] == sj['sjid'] }">selected="selected"</c:if>>${sj['sjname'] }</option>
								     </c:forEach>
								    </select>
								</div>
                                <!-- <div class="form-group">
                                    <label for="exampleInputPassword1">老师</label>
                                    <input name="wtid" type="text" value="1" class="form-control" id="exampleInputPassword1" placeholder="老师名称">
                                </div> -->
                                <div class="form-group">
                                    <label for="exampleInputPassword1">课程类型</label>
                                    <input name="wtype" type="text" value="${work['wtype'] }" class="form-control" id="exampleInputPassword1" placeholder="个人/团队">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">作业内容</label>
                                    <input name="wcontent" type="text" value="${work['wcontent'] }" class="form-control" id="exampleInputPassword1" placeholder="请输入作业内容">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputFile">相关文件</label>
                                    <input name="resourceFile" type="file" id="exampleInputFile" id="exampleInputFile">
                                    <input name="wfile" type="hidden" value="${work['wfile'] }">
                                    <p class="help-block">
                                    	<c:choose>
                                    		<c:when test="${!empty work['wfile'] }">${work['wname'] }${work['wfile'] }</c:when>
                                    		<c:otherwise>请选择作业的原文件</c:otherwise>
                                    	</c:choose>
                                    </p>
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
