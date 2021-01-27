<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
    交个作业
</title><link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
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
	
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<div>
			<form action="noticeList" method="post" >
			<select name="ntype" id="selectNtype">
				<option value="0">所有公告</option>
				<option value="1">作业公告</option>
				<option value="2">考试公告</option>
				<option value="3">课程公告</option>
			</select>
			<input type="hidden" id="inputNtype" name="ntype" value="0">
			<input type="submit" value="查询">
			</form>
		</div>
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                        类型
                    </th>
                    <th scope="col">
                        标题
                    </th>
                    <th scope="col">
                        内容
                    </th>
                     <th scope="col">
                        时间
                    </th>
                    
                </tr>
                <c:forEach items="${notices }" var="notice">
                <tr align="center">
                    <td>
                        <c:choose>
                        	<c:when test="${notice['ntype'] == 1 }">【作业】</c:when>
                        	<c:when test="${notice['ntype'] == 2 }">【考试】</c:when>
                        	<c:when test="${notice['ntype'] == 3 }">【课程】</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <a href="notice?nid=${notice['nid'] }">${notice['ntitle'] }</a>
                    </td>
                    <td>
                       	${notice['ncontent'] }
                    </td>
                    
                    <td>
                        ${notice['ndate'] }
                    </tr>
                    
                   
                    
                </tr>
                </c:forEach>
                
                
            </tbody>
        </table>
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
