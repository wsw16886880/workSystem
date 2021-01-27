<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	交个作业
</title><link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../../Style/ks.css" rel="stylesheet" type="text/css" /><link rel="stylesheet" type="text/css" href="../../Style/notice.css"/>
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    
<script type="text/javascript">
    function showMsg(msg, obj) {
        jBox.tip(msg);
        $("#" + obj).focus();
    }

    function modifySystemMsgeStatus(smid, smtype) {
        var result = false;
        studentInfo.modifySystemMesgeStatus(smid, smtype, function (data) {
            var result = $.parseJSON(data);
            if ((String(result.ok) == "true")) {
                jBox.alert("成功标记为已读！", "提示");
                setTimeout(function () {
                    window.location.reload();
                }, 1500);
            }
            else {
                $.jBox.error(result.message, '提示');
            }
        });
        return result;
    }
</script>
</head>
<body>

    <%@ include file="../../header.jsp" %>
    <div class="page">
        <div class="box mtop">
            <%@ include file="../../left.jsp" %>
            <div class="rightbox">
                
<h2 class="mbx">我的信息 &gt; 公告</h2>
<div class="morebt">
    
<%@include file="../../myInfoHeader.jsp" %>

</div>
<div class="cztable">
	<div class="title">${notice['ntitle'] }</div>
	<div class="message"><span>来源：${notice['nfrom'] }</span><span>作者：${notice['nfrom'] }</span>
	<span>时间：<fmt:formatDate value="${notice['ndate'] }" pattern="yyyy-MM-dd HH:mm:ss"/> </span></div>
	<div class="content">
		${notice['ncontent'] }
	</div>
	
</div>


            </div>
        </div>
    </div>
    <%@ include file="../../footer.jsp"%>
</body>
<script type="text/javascript">
	var select = document.getElementById("selectNtype");
	var inputNtype = document.getElementById("inputNtype");
	select.onchange = function() {
		inputNtype.value = select.getElementsByTagName("option")[select.selectedIndex].value;
		console.log(inputNtype)
	}
</script>
</html>
