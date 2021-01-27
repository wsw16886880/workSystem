<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>作业管理后台登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

    <div class="container">
        <div class="login-box">
                <div class="title"><h3>作业管理后台登录</h3></div>
                <div class="progress hidden" id="login-progress">
                          <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                            验证中......
                          </div>
                        </div>
                    <div class="alert alert-success hidden" id="login-message" role="alert">
                      <i class="fa fa-check">登录成功！正在加载......</i> 
                    </div>
                <div class="box">
                    <form action="login" method="post" id="" >
                        <div class="control">
                            <div class="label">管理员账号</div>
                            <input name="account" type="text" class="form-control" value="" />
                        </div>
                        <div class="control">
                            <div class="label">密码</div>
                            <input name="apwd" type="password" class="form-control" value="" />
                        </div>
						<div class="control" style="margin: 0 auto;text-align: center;">
							<select name="atype">
								<option value="0" style="color: black;">超级管理员</option>
								<option value="1" style="color: black;">学委</option>
								<option value="2" style="color: black;">老师</option>
							</select>
						</div>
                        <div class="login-button">
                            <input type="submit" class="btn btn-orange" value="Login">
                        </div>
                    </form>
                </div>
                <div class="info-box">
                   <span class="text-left"><a href="#">注册账号</a></span>
                   <span class="text-right"><a href="#">忘记密码？</a></span>
                   <div class="clear-both"></div>
                </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function() {
            $("#login-form").submit(function() {
                $("#login-progress").removeClass("hidden");

                setTimeout(function(){
                    $("#login-progress").addClass("hidden");
                    $("#login-message").removeClass("hidden");
                    setTimeout(function(){
                        window.location.assign("index.jsp")
                    },1000);
                },1000);
                return false;
            });
        });
    </script>
    <%@ include file="../footer.jsp" %>
</body>

</html>
