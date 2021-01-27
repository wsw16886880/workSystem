<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta name="description" content="Free Flat Admin Bootstrap Themes">
    <meta name="author" content="Charuwit Nodthaisong">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" type="text/css" href="css/select2.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/Chart.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>

<body class="flat-blue sidebar-collapse">
    <%@ include file="left.jsp" %>
    <div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="未知">未知</a></div>
    <div class="content-container wrap">
        <%@ include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title red"><h2>数据统计</h2></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">

                    <ol class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</a>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block red">
                            <div class="block-content">
                                <span class="banner-icon fa-stack fa-3x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-inbox fa-stack-1x fa-inverse"></i>
                                </span>
                                <div class="banner-content">
                                    <div class="title">50</div>
                                    <div class="sub-title">New Mails</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block yellow">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-comments fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">23</div>
                                    <div class="sub-title">New Message</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block green">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-tags fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">280</div>
                                    <div class="sub-title">Product View</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block blue">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-share-alt fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">16</div>
                                    <div class="sub-title">Share</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="banner-block white">
                        <div class="block-content">
                            <div class="block-title">Orders</div>
                            <canvas id="dashboard-order-chart" style="padding:10px 30px 10px 10px;"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="banner-block white">
                        <div class="block-content">
                            <div class="block-title">Stats</div>
                            <div class="row">
                                <div class="col-md-9">
                                    <canvas id="dashboard-stat-chart" style="padding:10px 30px 10px 10px;"></canvas>
                                </div>

                                <div class="col-md-3">
                                    <div id="dashboard-stat-chart-legend" class="pie-legend"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-comments-o"></i> Last Message</h3>
                        </div>
                        <div class="panel-body no-padding">
                            <ul class="message-list">
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">12 min ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>

                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">15 min ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">2 hour ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">1 day ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#" id="message-load-more">
                                    <li class="text-center load-more">
                                        <i class="fa fa-refresh"></i> load more..
                                    </li>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-users"></i> New Users</h3>
                        </div>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>

</html>
