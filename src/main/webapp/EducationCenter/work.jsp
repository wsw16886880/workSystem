<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>
			交个作业
		</title>
		<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
		<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
		<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="../Style/notice.css" />
		<script src="../js/vue.js" type="text/javascript"></script>
		<script src="../js/vue-resource-1.3.4.js"></script>
		<script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="../Script/Common.js" type="text/javascript"></script>
		<script src="../Script/Data.js" type="text/javascript"></script>
		<script src="../Script/Base.js" type="text/javascript"></script>
		<script language="javascript" type="text/javascript">
			function confirmStatus(bid) {
				if (confirm("确定确认无误吗？") == true) {
					senateCenter.modifyStudentBookStatus(bid, 2, function(data) {
						var result = $.parseJSON(data);
						if ((String(result.ok) == "true")) {
							jBox.alert(result.message, "提示");
							setTimeout(function() {
								window.location.reload();
							}, 1500);
						} else {
							jBox.tip(result.message);
						}
					});
				}
			}

			function submitObjection(bid) {
				var mtitle = "书籍有异议";
				var html =
					"<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>异议内容：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

				var submit = function(v, h, f) {
					if (f.objeCont == '' || f.objeCont.length > 80) {
						$.jBox.tip("请您输入异议内容，且不超过80个字！", 'error', {
							focusId: "objeCont"
						}); // 关闭设置 objeCont 为焦点
						return false;
					}

					StudentCompain.insertCompain('', mtitle, 2, f.objeCont, function(data) {
						var obj = $.parseJSON(data);
						var resultObj = false;
						if (obj.ok) {
							senateCenter.modifyStudentBookStatus(bid, 3, function(data) {
								var result = $.parseJSON(data);
								if ((String(result.ok) == "true")) {
									jBox.alert("成功提交异议！", "提示");
									setTimeout(function() {
										window.location.reload();
									}, 1500);
								} else {
									jBox.tip("提交异议失败！");
									return false;
								}
							});
						} else {
							jBox.tip("提交异议失败！");
						}
					});
				};

				$.jBox(html, {
					title: "提交异议",
					submit: submit
				});
			}
		</script>
	</head>
	<body>

		<%@ include file="../header.jsp" %>
		<div id="pa" class="page" style="height: 100%; padding-bottom: 80px;">
			<div class="box mtop">
				<%@ include file="../left.jsp" %>
				<div class="rightbox">

					<h2 class="mbx">
						教务中心 &gt; 我的作业</h2>
					<%@include file="../educationCenterHeader.jsp" %>
					<div class="cztable">
						<div class="title">${work['wname'] }</div>
						<div class="message"><span>班级：${work['gname'] }</span><span>课程：${work['sjname'] }</span><span>第${work['week'] }周</span>
							<span>时间：${work['wdate'] }</span></div>
						<div class="content">
							${work['wcontent'] }
						</div>

					</div>
					<div class="message_board">
						<span>留言板</span>
<%--					<c:forEach items="${messages }" var="message">--%>
<%--					<div class="cztable">--%>
<%--						<table width="100%" cellpadding="0" cellspacing="0">--%>
<%--							<tr><td>${message['sname'] }</td></tr>--%>
<%--							<tr><td>留言内容：${message['mcontent'] }</td></tr>--%>
<%--							<tr><td>留言时间：	${message['mtime'] }</td></tr>--%>
<%--						</table>--%>
<%--					</div>--%>
<%--					</c:forEach>--%>
						<div class="cztable" v-for="(message, index) in msgList" :key="index">
							<table width="100%" cellpadding="0" cellspacing="0">
								<tr><td>{{message.sname}}</td></tr>
								<tr><td>留言内容：{{message.mcontent}}</td></tr>
								<tr><td>留言时间：	{{message.mtime | dateFormat}}</td></tr>
							</table>
						</div>
					</div>
					<div class="page_a">
<%--						${nav}--%>
                        <a v-for="pno in pageCount" :key="pno" href.prevent @click="getMessageList({pno:pno,wid:wid})">{{pno}}</a>
					</div>
					<div class="cztable">
						<h2 class="mbx">留个言，多说话，不要冷冷清清的</h2>
						<form action="messageAdd" method="post">
							<table width="100%" cellpadding="0" cellspacing="0">
								<tr>
									<td width="15%" align="right">
										<div align="right">信息内容： </div>
									</td>
									<td><textarea name="mcontent" cols="80" rows="5" id="Ccontent" class="input_2"></textarea></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<div align="center">
											<input type="hidden" name="wid" value="${work['wid'] }" />
											<input type="submit" value="提交" onclick="saveClick('7c50f70a-775b-4aef-8bf2-5010ec612c0d')" class="input2" />
											<input type="submit" value="返回" onclick="returnIndex()" class="input2" />
										</div>
									</td>
								</tr>
							</table>
						</form>
					</div>

				</div>
			</div>
			<%@ include file="../footer.jsp"%>
		</div>

	</body>
	<script>
		var vm = new Vue({
			el: '#pa',
			data: {
				wid:${work['wid']},
                pno: 1,
				pageCount:0,
				total:0,
				msgList: [],
				// serverURL: 'http://localhost:8080/workSystem/EducationCenter/'
				serverURL: 'https://www.worksystem.top/worksystem/EducationCenter/'
			},
			methods: {
				getMessageList(params) {
					// 判断是否需要初始化
					if(params == null) {
						params = {
							pno : this.pno,
						    wid : this.wid
						};
					}
					this.$http.get(this.serverURL+'messageList?wid='+params.wid+'&pno='+params.pno).then(res=>{
						this.msgList = res.body.data.pageResult
						this.pageCount = res.body.data.pageCount
						this.total = res.body.data.total
					})
				}
			},
			created() {
				this.getMessageList(null);
			},
			filters: {
				dateFormat(dateStr) {
					let date = new Date(dateStr);

					// 获取年月日
					let y = date.getFullYear();
					let m = date.getMonth();
					let d = date.getDate();
					// 不适用模板字符串`${y}年${m}月${d}日`
					return y+"年"+m+"月"+d+"日";
				}
			}
		})
	</script>
</html>
