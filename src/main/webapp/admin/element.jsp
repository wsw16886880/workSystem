<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

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
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.css"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>

<body class="flat-blue sidebar-collapse">
    <%@ include file="left.jsp" %>
    <div class="content-container">
        <%@ include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title red"><h3>UI Elements</h3></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Button</div>
                        <div class="block-content">
                            <div class="margin-bottom">
                                <!-- Standard button -->
                                <button type="button" class="btn btn-lg btn-default">Default</button>

                                <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                                <button type="button" class="btn btn-lg btn-primary">Primary</button>

                                <!-- Indicates a successful or positive action -->
                                <button type="button" class="btn btn-lg btn-success">Success</button>

                                <!-- Contextual button for informational alert messages -->
                                <button type="button" class="btn btn-lg btn-info">Info</button>

                                <!-- Indicates caution should be taken with this action -->
                                <button type="button" class="btn btn-lg btn-warning">Warning</button>

                                <!-- Indicates a dangerous or potentially negative action -->
                                <button type="button" class="btn btn-lg btn-danger">Danger</button>

                                <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
                                <button type="button" class="btn btn-lg btn-link">Link</button>
                            </div>
                            <div class="margin-bottom">
                                <!-- Standard button -->
                                <button type="button" class="btn btn-default">Default</button>

                                <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                                <button type="button" class="btn btn-primary">Primary</button>

                                <!-- Indicates a successful or positive action -->
                                <button type="button" class="btn btn-success">Success</button>

                                <!-- Co


                                ntextual button for informational alert messages -->
                                <button type="button" class="btn btn-info">Info</button>

                                <!-- Indicates caution should be taken with this action -->
                                <button type="button" class="btn btn-warning">Warning</button>

                                <!-- Indicates a dangerous or potentially negative action -->
                                <button type="button" class="btn btn-danger">Danger</button>

                                <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
                                <button type="button" class="btn btn-link">Link</button>
                            </div>
                            <div class="margin-bottom">
                                <!-- Standard button -->
                                <button type="button" class="btn btn-sm btn-default">Default</button>

                                <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                                <button type="button" class="btn btn-sm btn-primary">Primary</button>

                                <!-- Indicates a successful or positive action -->
                                <button type="button" class="btn btn-sm btn-success">Success</button>

                                <!-- Contextual button for informational alert messages -->
                                <button type="button" class="btn btn-sm btn-info">Info</button>

                                <!-- Indicates caution should be taken with this action -->
                                <button type="button" class="btn btn-sm btn-warning">Warning</button>

                                <!-- Indicates a dangerous or potentially negative action -->
                                <button type="button" class="btn btn-sm btn-danger">Danger</button>

                                <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
                                <button type="button" class="btn btn-sm btn-link">Link</button>
                            </div>
                            <div>
                                <!-- Standard button -->
                                <button type="button" class="btn btn-xs btn-default">Default</button>

                                <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                                <button type="button" class="btn btn-xs btn-primary">Primary</button>

                                <!-- Indicates a successful or positive action -->
                                <button type="button" class="btn btn-xs btn-success">Success</button>

                                <!-- Contextual button for informational alert messages -->
                                <button type="button" class="btn btn-xs btn-info">Info</button>

                                <!-- Indicates caution should be taken with this action -->
                                <button type="button" class="btn btn-xs btn-warning">Warning</button>

                                <!-- Indicates a dangerous or potentially negative action -->
                                <button type="button" class="btn btn-xs btn-danger">Danger</button>

                                <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
                                <button type="button" class="btn btn-xs btn-link">Link</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Alert</div>
                        <div class="block-content">
                            <div class="margin-bottom">
                                <div class="alert alert-success" role="alert">
                                    <strong>Well done!</strong> You successfully read this important alert message.
                                </div>
                            </div>

                            <div class="margin-bottom">
                                <div class="alert alert-info">
                                    <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
                                </div>
                            </div>

                            <div class="margin-bottom">
                                <div class="alert alert-warning">
                                    <strong>Warning!</strong> Best check yo self, you're not looking too good.
                                </div>
                            </div>
                            <div class="alert alert-danger">
                                <strong>Oh snap!</strong> Change a few things up and try submitting again.
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Progress bar</div>
                        <div class="block-content">
                            <div class="progress">
                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% Complete (success)</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                    <span class="sr-only">20% Complete</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                    <span class="sr-only">60% Complete (warning)</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                    <span class="sr-only">80% Complete (danger)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Progress bar with Striped & Stack</div>
                        <div class="block-content">
                            <div class="progress">
                                <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% Complete (success)</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                    <span class="sr-only">20% Complete</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                    <span class="sr-only">60% Complete (warning)</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                    <span class="sr-only">80% Complete (danger)</span>
                                </div>
                            </div>
                            <div class="progress">
                                <div class="progress-bar progress-bar-success" style="width: 35%">
                                    <span class="sr-only">35% Complete (success)</span>
                                </div>
                                <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
                                    <span class="sr-only">20% Complete (warning)</span>
                                </div>
                                <div class="progress-bar progress-bar-danger" style="width: 10%">
                                    <span class="sr-only">10% Complete (danger)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Modal</div>
                        <div class="block-content">
                            <div class="margin-bottom">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>

                                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="myLargeModalLabel">Large modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Send message</button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>

                                <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Send message</button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                            </div>

                            <div class="margin-bottom">
                                <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-default">Default modal</button>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-primary">Primary modal</button>
                                <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-info">Info modal</button>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target=".bs-example-modal-warning">Warning modal</button>
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-danger">Danger modal</button>

                                <div class="modal fade bs-example-modal-default" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>

                                <div class="modal fade modal-primary bs-example-modal-primary" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <div class="modal fade modal-info bs-example-modal-info" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <div class="modal fade modal-warning bs-example-modal-warning" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <div class="modal fade modal-danger bs-example-modal-danger" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog modal-sm">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="fa fa-times"></i></span>
                                                </button>
                                                <h4 class="modal-title" id="mySmallModalLabel">Small modal</h4>
                                            </div>
                                            <div class="modal-body">
                                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Button Group</div>
                        <div class="block-content">
                            <div class="margin-bottom">
                                <div class="btn-group btn-group-lg" role="group" aria-label="Large button group">
                                    <button type="button" class="btn btn-default">Left</button>
                                    <button type="button" class="btn btn-default">Middle</button>
                                    <button type="button" class="btn btn-default">Right</button>
                                </div>
                            </div>
                            <div class="margin-bottom">
                                <div class="btn-group" role="group" aria-label="Default button group">
                                    <button type="button" class="btn btn-default">Left</button>
                                    <button type="button" class="btn btn-default">Middle</button>
                                    <button type="button" class="btn btn-default">Right</button>
                                </div>
                            </div>
                            <div class="margin-bottom">
                                <div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                                    <button type="button" class="btn btn-default">Left</button>
                                    <button type="button" class="btn btn-default">Middle</button>
                                    <button type="button" class="btn btn-default">Right</button>
                                </div>
                            </div>
                            <div>
                                <div class="btn-group btn-group-xs" role="group" aria-label="Extra-small button group">
                                    <button type="button" class="btn btn-default">Left</button>
                                    <button type="button" class="btn btn-default">Middle</button>
                                    <button type="button" class="btn btn-default">Right</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Button Dropdown</div>
                        <div class="block-content">
                            <div class="margin-bottom">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Default <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Primary <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Success <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Info <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Warning <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Danger <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                            </div>
                            <div>

                                <div class="btn-group">
                                    <button type="button" class="btn btn-default">Default</button>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary">Primary</button>
                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success">Success</button>
                                    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-info">Info</button>
                                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-warning">Warning</button>
                                    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                                <div class="btn-group">
                                    <button type="button" class="btn btn-danger">Danger</button>
                                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /btn-group -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>Breadcrumbs</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li><a href="#">Library</a>
                        </li>
                        <li class="active">Data</li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>Panel</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 col-sm-6 col-xs-12">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel title</h3>
                        </div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>Panel with Table</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel</h3>
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
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel</h3>
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
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel</h3>
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
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <h3 class="panel-title">Panel</h3>
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
