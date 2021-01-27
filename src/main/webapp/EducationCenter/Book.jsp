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
</title><link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="../Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <script src="../Script/Base.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">

        function confirmStatus(bid) {
            if (confirm("确定确认无误吗？") == true) {
                senateCenter.modifyStudentBookStatus(bid, 2, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        jBox.alert(result.message, "提示");
                        setTimeout(function () {
                            window.location.reload();
                        }, 1500);
                    }
                    else {
                        jBox.tip(result.message);
                    }
                });
            }
        }

        function submitObjection(bid) {
            var mtitle = "书籍有异议";
            var html = "<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>异议内容：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

            var submit = function (v, h, f) {
                if (f.objeCont == '' || f.objeCont.length > 80) {
                    $.jBox.tip("请您输入异议内容，且不超过80个字！", 'error', { focusId: "objeCont" }); // 关闭设置 objeCont 为焦点
                    return false;
                }

                StudentCompain.insertCompain('', mtitle, 2, f.objeCont, function (data) {
                    var obj = $.parseJSON(data);
                    var resultObj = false;
                    if (obj.ok) {
                        senateCenter.modifyStudentBookStatus(bid, 3, function (data) {
                            var result = $.parseJSON(data);
                            if ((String(result.ok) == "true")) {
                                jBox.alert("成功提交异议！", "提示");
                                setTimeout(function () {
                                    window.location.reload();
                                }, 1500);
                            }
                            else {
                                jBox.tip("提交异议失败！");
                                return false;
                            }
                        });
                    }
                    else {
                        jBox.tip("提交异议失败！");
                    }
                });
            };

            $.jBox(html, { title: "提交异议", submit: submit });
        }
    </script>
</head>
<body>

    <%@ include file="../header.jsp" %>
    <div class="page">
        <div class="box mtop">
            <%@ include file="../left.jsp" %>
            <div class="rightbox">
                
    <h2 class="mbx">
        教务中心 &gt; 我的作业</h2>
	<%@include file="../educationCenterHeader.jsp" %>
    <div class="cztable">
    <div class="week">
			<span>第<select name="weeks" id="sweeks" onChange="selected(this)">
					<option value="0">All</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
			</select>周</span>
			<form action='<c:url value="/EducationCenter/workList"/>' method="post">
				<input id="week" type="hidden" name="week" value="0" />
				<input type="submit" value="查找" />
			</form>
		</div>
        <div class="tis red">
            注：请及时交作业！！！！！！
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                        序号
                    </th>
                    <th scope="col">
                        作业名称
                    </th>
                     <th scope="col">
                        学号
                    </th>
                    <th scope="col">
                        已交
                    </th>
                    <th scope="col">
                        周
                    </th>
                    <th scope="col">
                        课程
                    </th>
                    <th scope="col">
                        类型
                    </th>
                    <th scope="col">
                        内容
                    </th>
                    <th scope="col">
                        截止时间
                    </th>
                </tr>
                <c:forEach items="${lates }" var="late" varStatus="vs">
                <tr align="center">
                    <td>
                        ${vs['count'] }
                    </td>
                    <td>
                       <a href="<c:url value='/EducationCenter/work?wid='/>${late['lwid']}"> ${late['lname'] }</a>
                    </td>
                    
                    <td>${late['lsnumber'] }</td>
                    
                    <td class="issubmit">&nbsp;
                    <form class="issubmit" action="file" method="post" enctype="multipart/form-data">${late['issubmit']}
					<input id="sid" type="hidden" name="sid" value="${late['lsid'] }" />
					<input id="lweek" type="hidden" name="lweek" value="${late['lweek'] }" />
					<input id="lname" type="hidden" name="lname" value="${late['lname'] }" />
					<input id="lwid" type="hidden" name="lwid" value="${late['lwid'] }" />
				   </form>
<%--                重新提交--%>
                    <c:if test="${late['issubmit'] == '是'}">
                        <button class="resubmitBt">重新提交</button>
                    </c:if>
                    <form class="resubmitForm" action="resubmitFile" method="post" enctype="multipart/form-data">
                        <input type="file" name="zuoye"/>
                        <input type="submit" value="提交作业"/>
                        <input id="sid" type="hidden" name="sid" value="${late['lsid'] }" />
                        <input id="lweek" type="hidden" name="lweek" value="${late['lweek'] }" />
                        <input id="lname" type="hidden" name="lname" value="${late['lname'] }" />
                        <input id="lwid" type="hidden" name="lwid" value="${late['lwid'] }" />
                    </form>
                    </td>
                     <td>&nbsp;
                        ${late['lweek'] }
                    </td>
                     <td>&nbsp;
                      	${late['lsjname'] }
                    </td>
                     <td>&nbsp;
                        ${late['ltype'] }
                    </td>
                     <td>&nbsp;
                        ${late['lcontent'] }
						<a href="download?wid=${late.lwid }">下载源文件</a>
                    </td>
                     <td>&nbsp;
                         <fmt:formatDate value="${late['ledate'] }" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

            </div>
        </div>
    </div>
    <%@ include file="../footer.jsp"%>
    <script type="text/javascript">
    /**
 * 查看学生是否交作业，如果交了，显示是，未交，显示一个提交文件的input和提交的按钮
 */
function addIssubmit() {
	//获取学生是否交作业
	var issubmits = document.getElementsByClassName("issubmit");
	//遍历是否为空
	for (var i = 0; i < issubmits.length; i++) {
		//为空则添加提交文件的input
		if (issubmits[i].firstChild.nodeValue.trim() == '否') {
			//创建input文件选择框
			var inputFile = document.createElement("input");
			inputFile.type = "file";
			inputFile.name = "zuoye";
			//创建提交按钮
			var inputSubmit = document.createElement("input");
			inputSubmit.value = "提交作业";
			inputSubmit.type = "submit";
			//将2个按钮添加进单元格中，通过class=issubmit这个条件可以直接获取单元格
			var issubmit = issubmits[i];
			issubmit.style.color = "red";
			// issubmit.innerHTML = "";
			issubmit.appendChild(inputFile);
			issubmit.appendChild(inputSubmit);
		}
	}
}

/**
 * 将选择的周数添加到参数中
 */
function selected(weeks){
	//拿到选项的索引
	var index = weeks.selectedIndex;
	//获取索引所在的option的value
	var value = weeks.options[index].value;
	//获取传参数的对应的input
	var inputWeek = document.getElementById("week");
	//传值
	inputWeek.value = value;
}

$(document).ready(function () {
    // 隐藏所有的重新提交的表单
    $(".resubmitForm").hide()
    $(".resubmitBt").click(function () {
        // 隐藏所有重新提交的表单
        $(".resubmitForm").hide()
        // 显示所有重新提交按钮
        $(".resubmitBt").show()
        // 显示当前按钮下面的重新提交表单
        $(this).next().show();
        // 隐藏按钮
        $(this).hide()
    })
})



//调用检查作业方法
addIssubmit();
</script>
</body>
</html>
