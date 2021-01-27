<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<style type="text/css">
		#pics{
			float: left;
		}
		#pics li{
			list-style: none;
			position: absolute;
		}
	</style>

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
                    <span class="page-title red"><h3>班级更改</h3></span>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">班级</div>
                        <form action="gradeModify" method="post" class="form-vertical" enctype="multipart/form-data">
                            <div class="block-content">
                            	<input name="gid" type="hidden" value="${grade['gid'] }"/>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">班级名称</label>
                                    <input name="gname" type="text" value="${grade['gname'] }" class="form-control" id="exampleInputPassword1" placeholder="班级名称">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">人数</label>
                                    <input name="gtotal" type="text" value="${grade['gtotal'] }" class="form-control" id="exampleInputPassword1" placeholder="人数">
                                </div>
                                <div class="form-group">
									<label for="exampleInputPassword1">学期：</label> 
									<select	id="sel" name="stsemester" onchange="change(this)">
											<option value="1">大一上学期</option>
											<option value="2">大一下学期</option>
											<option value="3">大二上学期</option>
											<option value="4">大二下学期</option>
											<option value="5">大三上学期</option>
											<option value="6">大三下学期</option>
									</select>
									<button id="de" type="button"><img src="images/icon_delete.gif" />删除该学期的课表图</button>
								</div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1" style="float: left;">课表图片：</label>
									<ul id="pics">
											<c:set var="i" value="1"/>
										<c:forEach items="${sts }" var="st" varStatus="vs">
											<c:forEach varStatus="v" begin="1" end="${st['stsemester']}">
												<c:if test="${v['count'] >= i }">
												<c:if test="${st['stsemester'] != v['count']}">
													<li style="display: none;">
														<div style="width: 100px;height: 120px;" >
															<img class="imgfile" src="<c:url value=""/>" alt="无课表" style="width: 100%;height: 100%;" >
														</div>
													</li>
												</c:if>
												<c:if test="${st['stsemester'] == v['count']}">
													<c:if test="${vs['count'] == 1 }"></c:if>
													<li style="display: none;">
														<div style="width: 100px;height: 120px;" >
															<img class="imgfile" src="<c:url value="/school_timetable/${st['stfile']}"/>" alt="课程表" style="width: 100%;height: 100%;" >
														</div>
													</li>
												</c:if>
												<c:set var="i" value="${i+1 }"/>
												</c:if>
											</c:forEach>
												<%-- <c:if test="${vs['count'] == 1 && vs['count'] == st['stsemester']}">
													<li style="display: block;">
														<div style="width: 100px;height: 120px;" >
															<img class="imgfile" src="<c:url value="/school_timetable/${st['stfile']}"/>" alt="课程表" style="width: 100%;height: 100%;" >
														</div>
													</li>
												</c:if>
												<c:if test="${vs['count'] > 1  && vs['count'] == st['stsemester']}">
													<li style="display: none;">
														<div style="width: 100px;height: 120px;" >
															<img class="imgfile" src="<c:url value="/school_timetable/${st['stfile']}"/>" alt="课程表" style="width: 100%;height: 100%;" >
														</div>
													</li>
												</c:if> --%>
										</c:forEach>
									</ul>
                                    <input id="stf" name="stfile" type="hidden" value="">
									<div style="width: 100px;height: 120px;	">
									</div>
                                    <input name="file" type="file" id="exampleInputFile">
                                    <p class="help-block">
                                    	<c:choose>
                                    		<c:when test="${not empty st}"></c:when>
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
<script type="text/javascript">
	window.onload = function() {
	//更改stfile
		var select = document.getElementById("sel");
		var lis = document.getElementById("pics").children;
		var stfile = document.getElementById("stf");
		if(lis.length == 0){
			return;
		}
		let src = lis[0].getElementsByClassName("imgfile")[0].src;
		stfile.value = src.substr(src.lastIndexOf("/")+1);
		
		//设置大一上学期的图片为显示
		lis[0].style.display = "block";
		
		var budel = document.getElementById("de");
		budel.onclick = function() {
			if(!confirm('真的要删除吗？')){
				return;
			}
		
			//ajax局部刷新删除课表图片
			//获取 异步 对象
			var xmlHttp = createXMLHttpRequest();
			//打开与服务器的连接
			xmlHttp.open("post", "<c:url value='/admin/school_timetableDelete' />", true);
			//设置Content-Type
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//发送请求
			//指定请求体
			xmlHttp.send("gid=${grade['gid'] }&stfile="+stfile.value+"&stsemester="+(select.selectedIndex+1));
			//设置监听器
			xmlHttp.onreadystatechange = function() {
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					if(text == "1"){
						alert("删除成功！");
						lis[select.selectedIndex].getElementsByClassName("imgfile")[0].src = ";"
						stfile.value = "";
					} else {
						alert("删除失败！");
					}
				}
			}
		}
	}
	function change(sl) {
		//更改删除课表图参数
		//var del = document.getElementById("del");
		//del.href = "school_timetableDelete?gid=${grade['gid'] }&stsemester="+(sl.selectedIndex+1);

		lis = document.getElementById("pics").children;
		stfile = document.getElementById("stf");
		var index = 0;
		if(lis[sl.selectedIndex]==null) {
			stfile.value = "";
		}
		for (let l in lis) {
			if(index>lis.length-1){
				return;
			}
			if(index == sl.selectedIndex) {
				lis[l].style.display = "block";
 				let src = lis[l].getElementsByClassName("imgfile")[0].src;
 				stfile.value = src.substr(src.lastIndexOf("/")+1);
			}
			else
				lis[l].style.display = "none";
			index++;
		}
	}
	
	function createXMLHttpRequest() {
		try{
			return new XMLHttpRequest();
		}catch(e){
			try{
				return new ActiveXObject("Msxml2.XMLHttp");//ie6
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHttp");//ie5 and 以下
				}catch(e){
					throw e;
				}
			}
		}
	}
</script>
</html>