<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
            showUnreadSysMsgCount();
        });

        //我的信息头部选项卡
        function setStudMsgHeadTabCheck() {
            var currentUrl = window.location.href;
            currentUrl = currentUrl.toLowerCase();
            var asmhm = "";
            $("#ulStudMsgHeadTab li").each(function () {
                asmhm = $(this).find('a').attr("href").toLowerCase();
                if (currentUrl.indexOf(asmhm) > 0) {
                    $(this).find('a').attr("class", "tab1");
                    return;
                }
            });
        }

        //显示未读系统信息
        function showUnreadSysMsgCount() {
            var unreadSysMsgCount = "0";
            if (Number(unreadSysMsgCount) > 0) {
                $("#unreadSysMsgCount").html("(" + unreadSysMsgCount + ")");
            }
        }
        
        //退出
        function loginOut() {
            if (confirm("确定退出吗？")) {
                        window.location = "<c:url value='/outLogin'/>";
                        i=0;
                    }
                    else {
                        jBox.alert("退出失败！", "提示", new { buttons: { "确定": true} });
                    }
        }
        //更改报考类别
        function changeCateory(thisObj, id) {
            var oldCateoryId = $("#cateoryId").val();
            var cateoryId = "";
            if (id != null) {
                cateoryId = id;
            }
            else {
                cateoryId = thisObj.val();
            }
            var studentId = $("#studentId").val();
            if (cateoryId.length <= 0) {
                jBox.tip("报考类别不能为空！");
                if (id == null) {
                    thisObj.val(oldCateoryId);
                }
            }
            else {
                studentInfo.changeStudentCateory(cateoryId, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        window.location.href = "/Index.aspx";
                    }
                    else {
                        jBox.tip(result.message);
                    }
                });
            }
        }
    </script>
<div class="banner">
	<fmt:requestEncoding value="UTF-8"/>
	<div class="bgh">
		<div class="page">
			<div id="logo">
				<a href="<c:url value='/index'/>"> <img src="<c:url value="#"/> "
					alt="" width="165" height="48" /> </a>
			</div>
			<div class="topxx">
				<span id="header_name"></span> <a href="<c:url value='/MyInfo/studentInfo'/>">我的信息</a> <a
					href="<c:url value='/User/StudentInfor/noticeList'/>"> 通知</a> <a
					href="<c:url value='/User/Account/ChangePasswd.jsp'/>">密码修改</a> <a
					onclick="loginOut()" href="javascript:">安全退出</a>
			</div>
			<div class="blog_nav">
				<ul>
					<li><a href="<c:url value='/MyInfo/studentInfo'/>">我的信息</a>
					</li>
					<li><a href="<c:url value='//EducationCenter/toworkList'/>">我的作业</a>
					</li>
					<li><a href="<c:url value='/MyInfo/school_timetable'/>">班级课程</a>
					</li>
					<li><a href="<c:url value='/User/StudentInfor/noticeList'/>">学院通知</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var header_name = document.getElementById("header_name");
	        var hname = decodeURIComponent("${cookie['cksname']['value'] }","UTF-8");
			header_name.innerHTML = hname+"，欢迎您！";
</script>