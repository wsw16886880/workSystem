<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar">
        <div class="menu-control toggle-sidebar">
            <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i>作业管理</a>
            <i class="fa fa-bars navicon"></i>
        </div>
        <ul class="menu">
                        <li class="submenu">
                <a href="index?act=" <c:if test="${action=='index' }">class="active"</c:if> >
                    <div>
                        <i class="menu-icon fa fa-th-large"></i>
                        <span class="menu-title">主页</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="index?act=element" <c:if test="${action=='element' }">class="active"</c:if> >
                    <div>
                        <i class="menu-icon fa fa-desktop"></i>
                        <span class="menu-title">未定义功能</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="index?act=table" <c:if test="${action=='table' }">class="active"</c:if>>
                    <div>
                        <i class="menu-icon fa fa-table"></i>
                        <span class="menu-title">班级信息管理</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="index?act=form" <c:if test="${action=='form' }">class="active"</c:if>>
                    <div>
                        <i class="menu-icon fa fa-file-text-o"></i>
                        <span class="menu-title">用户&作业管理</span>
                    </div>
                </a>
            </li>

            <li class="submenu">
                <a href="index?act=message" <c:if test="${action=='message' }">class="active"</c:if>>
                    <div>
                        <i class="menu-icon fa fa-slack"></i>
                        <span class="menu-title">留言板</span>
                    </div>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="login">
                            <div>
                                <i class="menu-icon fa fa-sign-in"></i>
                                <span class="menu-sub-title">登录</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="index?act=register" <c:if test="${action=='register' }">class="active"</c:if> >
                            <div>
                                <i class="menu-icon fa fa-pencil-square-o"></i>
                                <span class="menu-sub-title">注册</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="submenu">
                <a href="index?act=note" <c:if test="${action=='note' }">class="active"</c:if>>
                    <div>
                        <i class="menu-icon fa fa-slack"></i>
                        <span class="menu-title">笔记列表</span>
                    </div>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="login">
                            <div>
                                <i class="menu-icon fa fa-sign-in"></i>
                                <span class="menu-sub-title">登录</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="index?act=register" <c:if test="${action=='register' }">class="active"</c:if> >
                            <div>
                                <i class="menu-icon fa fa-pencil-square-o"></i>
                                <span class="menu-sub-title">注册</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="submenu dropdown" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                    <div>
                        <i class="menu-icon fa fa-magic"></i>
                        <span class="menu-title">数据统计</span>
                    </div>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#" >
                            <div>
                                <i class="menu-icon fa fa-bar-chart"></i>
                                <span class="menu-sub-title">Dashboard</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
