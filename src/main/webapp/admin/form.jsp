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
<meta charset="utf-8">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-select.min.css">
<link rel="stylesheet" type="text/css"
	href="css/awesome-bootstrap-checkbox.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
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
					<span class="page-title red"><h3>用户&作业管理</h3> </span>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title"><h4>用户管理</h4> </span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">添加班级</div>
						<form action="gradeAdd" method="post" class="form-vertical">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputEmail1">班级</label> <input type="text"
										name="gname" class="form-control" id="exampleInputEmail1"
										placeholder="请输入班级名称">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">人数</label> <input
										type="text" name="gtotal" class="form-control"
										id="exampleInputPassword1" value="">
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">添加</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">添加课表图片</div>
						<form action="school_timetableAdd" method="post"
							class="form-vertical" enctype="multipart/form-data">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="stgid">
										<c:choose>
											<c:when test="${sessionScope['admin']['agid'] == 0 }">
												<c:forEach items="${grades }" var="grade">
													<option value="${grade['gid'] }">${grade['gname']}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="${grade['gid'] }">${grade['gname'] }</option>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">学期：</label> <select
										name="stsemester">
										<option value="1">大一上学期</option>
										<option value="2">大一下学期</option>
										<option value="3">大二上学期</option>
										<option value="4">大二下学期</option>
										<option value="5">大三上学期</option>
										<option value="6">大三下学期</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputFile">相关文件</label> <input name="file"
										type="file" id="exampleInputFile">
									<p class="help-block">请选择作业的原文件</p>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">添加</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<c:if test="${sessionScope['admin']['agid'] == 0 }">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				  <div class="content-block">
					<div class="block-title">添加学委</div>
					<form action="adminAdd" method="post" class="form-vertical">
						<div class="block-content">
							<div class="form-group">
								<label for="exampleInputEmail1">学委账号</label> <input type="text"
									name="account" class="form-control" id="exampleInputEmail1"
									placeholder="请输入学号">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">密码</label> <input type="text"
									name="apwd" class="form-control" id="exampleInputPassword1"
									value="123456">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">姓名</label> <input type="text"
									name="aname" class="form-control" id="exampleInputPassword1"
									value="">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">班级：</label> <select
									name="agid">
									<c:forEach items="${grades }" var="grade">
										<option value="${grade['gid'] }">${grade['gname'] }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="block-footer">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">添加</button>
								<button type="reset" class="btn btn-default">取消</button>
							</div>
						</div>
					</form>
				  </div>
				 </div>
				</c:if>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">添加学生</div>
						<form action="studentAdd" method="post" class="form-vertical" enctype="multipart/form-data">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputEmail1">学号</label> <input type="text"
										name="snumber" class="form-control" id="exampleInputEmail1"
										placeholder="请输入学号">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">密码</label> <input
										type="text" name="spwd" class="form-control"
										id="exampleInputPassword1" value="123456">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">姓名</label> <input
										type="text" name="sname" class="form-control"
										id="exampleInputPassword1" value="">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="sgid">
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
									<label for="exampleInputFile">相关文件</label> 
									<input name="excelFile" type="file" id="exampleInputFile">
									<p class="help-block">请选择要导入的学生表(请使用97-2003版本的Excel表)</p>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">注册</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title"><h4>作业模块</h4> </span>
				</div>
			</div>
			<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="content-block">
					<div class="block-title">添加老师</div>
					<form action="teacherAdd" method="post" class="form-vertical">
						<div class="block-content">
							<div class="form-group">
								<label for="exampleInputEmail1">初始账号</label> <input type="text"
									name="taccount" class="form-control" id="exampleInputEmail1"
									placeholder="请输入学号">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">密码</label> <input type="text"
									name="tpwd" class="form-control" id="exampleInputPassword1"
									value="123456">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">姓名</label> <input type="text"
									name="tname" class="form-control" id="exampleInputPassword1"
									value="">
							</div>
						</div>
						<div class="block-footer">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">添加</button>
								<button type="reset" class="btn btn-default">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">添加课程</div>
						<form action="subjectAdd" method="post" class="form-vertical">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputPassword1">学期：</label>
									<select	name="sjsemester">
										<option value="1">大一上学期</option>
										<option value="2">大一下学期</option>
										<option value="3">大二上学期</option>
										<option value="4">大二下学期</option>
										<option value="5">大三上学期</option>
										<option value="6">大三下学期</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">名称</label> <input type="text"
										name="sjname" class="form-control" id="exampleInputEmail1"
										placeholder="请输入课程名称">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">科任老师：</label> <select
										name="sjtid">
										<c:forEach items="${teachers }" var="teacher">
											<option value="${teacher['tid'] }">${teacher['tname']
												}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="sjgid">
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
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">添加</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<%-- <c:if test="${sessionScope['admin']['agid'] != 0 }"></c:if> --%>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="content-block">
					<div class="block-title">添加笔记</div>
					<form action="noteAdd" method="post" class="form-vertical">
						<div class="block-content">
							<div class="form-group">
									<label for="exampleInputPassword1">所属课程：</label> <select
										name="nsjid">
										<c:forEach items="${subjects }" var="sj">
											<option value="${sj['sjid'] }">${sj['sjname'] }</option>
										</c:forEach>
									</select>
							</div>
							<div class="form-group">
									<label for="exampleInputPassword1">所属作业：</label> <select
										name="nwid">
											<option value="0">无</option>
										<c:forEach items="${works }" var="work">
											<option value="${work['wid'] }">${work['wname'] }</option>
										</c:forEach>
									</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">标题</label> <input type="text"
									name="ntitle" class="form-control" id="exampleInputPassword1">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">周数</label> <input type="text"
									name="nweek" class="form-control" id="exampleInputPassword1"
									value="">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">来源</label> <input type="text"
									name="nfrom" class="form-control" id="exampleInputPassword1"
									value="">
							</div>
							<div class="form-group">
									<label for="exampleInputPassword1">内容</label>
									<textarea name="ncontent" class="form-control" rows="3"></textarea>
							</div>
						</div>
						<div class="block-footer">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">添加</button>
								<button type="reset" class="btn btn-default">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
				<!-- 发布作业 -->
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">发布作业</div>
						<form action="workAdd" method="post" class="form-vertical"
							enctype="multipart/form-data">
							<div class="block-content">
								<div class="form-group">
									<label for="exampleInputPassword1">班级：</label> <select
										name="lgid">
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
									<label for="exampleInputPassword1">作业名称</label> <input
										name="lname" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="作业名称">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">第几周的作业</label> <input
										name="lweek" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="周数">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">所属课程：</label> <select
										name="lsjid">
										<c:forEach items="${subjects }" var="sj">
											<option value="${sj['sjid'] }">${sj['sjname'] }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">作业类型：</label> <select
										name="ltype">
										<option value="个人">个人</option>
										<option value="团队">团队</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">内容</label>
									<textarea name="lcontent" class="form-control" rows="3"></textarea>
								</div>
								<div class="form-group">
									<label for="exampleInputFile">相关文件</label> <input name="file"
										type="file" id="exampleInputFile">
									<p class="help-block">请选择作业的原文件</p>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">发布</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<span class="page-title"><h4>公告</h4> </span>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="content-block">
						<div class="block-title">发布公告</div>
						<form action="noticeAdd" method="post" class="form-vertical"
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
									<label for="exampleInputPassword1">公告类型：</label> <select
										name="ntype">
										<option value="1">作业公告</option>
										<option value="2">考试公告</option>
										<option value="3">课程公告</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">紧急事件：</label> <select
										name="nemergency">
										<option value="1">是</option>
										<option value="0" selected="selected">否</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">标题</label> <input
										name="ntitle" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="请输入标题"> <input
										name="naid" value="${sessionScope['admin']['aid'] }"
										type="hidden">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">来源</label> <input
										name="nfrom" type="text" class="form-control"
										id="exampleInputPassword1" placeholder="请输入来源" value="${admin.aname}">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">内容</label>
									<textarea name="ncontent" class="form-control" rows="3"></textarea>
								</div>
							</div>
							<div class="block-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary">发布</button>
									<button type="reset" class="btn btn-default">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

</html>
