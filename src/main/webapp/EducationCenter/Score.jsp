<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

        function confirmStatus(sid, examtime, stype) {
            if (confirm("确定确认无误吗？") == true) {
                senateCenter.modifyStudentScoreStatus(sid, examtime, stype, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        jBox.alert(result.message, "提示");
                        setTimeout(function () {
                            window.location.reload();
                        }, 1500);
                    }
                    else {
                        $.jBox.error(result.message, '提示');
                    }
                });
            }
        }

        function submitObjection(objId, examtime) {
            var mtitle = "成绩有异议";
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
                        senateCenter.modifyStudentScoreStatus(objId, examtime, 3, function (data) {
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
        教务中心 &gt; 我的成绩</h2>
    <%@include file="../educationCenterHeader.jsp" %>
    <div class="cztable">
        <div class="tis red">
            注：请仔细核对自己的考试成绩，如正确请点击“确定无误”，如不正确请点击“有异议”。</div>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr>
                    <th scope="col" style="width: 100px;">&nbsp;
                        
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            00015</div>
                        <div class="wzx">
                            英语（二）</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            03708</div>
                        <div class="wzx">
                            中国近现代史纲要</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            03709</div>
                        <div class="wzx">
                            马克思主义基本原理概论</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            00169</div>
                        <div class="wzx">
                            房地产法</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            00261</div>
                        <div class="wzx">
                            行政法学</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            00167</div>
                        <div class="wzx">
                            劳动法</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            07945</div>
                        <div class="wzx">
                            企业与公司法学</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            07946</div>
                        <div class="wzx">
                            税法原理</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            07947</div>
                        <div class="wzx">
                            金融法概论</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            06909</div>
                        <div class="wzx">
                            行政诉讼法</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            07944</div>
                        <div class="wzx">
                            经济法学原理</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            07948</div>
                        <div class="wzx">
                            环境法学</div>
                    </th>
                    
                    <th scope="col" valign="top">
                        <div class="wzx1">
                            10301</div>
                        <div class="wzx">
                            经济法毕业论文</div>
                    </th>
                    
                    <th scope="col" style="width: 100px;">
                        操作
                    </th>
                </tr>
                
                <tr align="center">
                    <td colspan="15">
                        <div style="color: #ff0000; font-weight: bold;">
                            未找到成绩信息!</div>
                    </td>
                </tr>
                
            </tbody>
        </table>
        
    </div>

            </div>
        </div>
    </div>
    <%@ include file="../footer.jsp"%>
</body>
</html>
