<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>短信发送</title>
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<style type="text/css">
.mtab table th {
	border: 1px solid #95BDD7;
	background: #EFF0F2;
	height: 25px;
	color: #1F83B7;
	text-align: right;
	font-size: 13px;
	font-weight: normal;
}

.mtab table td {
	border: 1px solid #95BDD7;
	color: #1F83B7;
	height: 25px;
	font-size: 13px;
	color: #000;
	padding-left: 2px;
	text-align: left;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		$("#submit").click(function() {
			if ($("#mobile").val() == "") {
				alert("电话不能为空！");
				return;
			}
			if ($("#content").val() == "") {
				alert("内容不能为空！");
				return;
			}
			$("#doningNote").show();
			$("#addForm").trigger("submit");
		});
		$("#connect").click(function() {
			$("#doningNote").show();
			$.ajax({
				url : "${rootUrl }systemmng/sms/connect.dox",
				type : "GET",
				success : function(result) {
					alert(result);
					$("#doningNote").hide();
				}
			});

		});

		$("#close").click(function() {
			$("#doningNote").show();
			$.ajax({
				url : "${rootUrl }systemmng/sms/close.dox",
				type : "GET",
				success : function(result) {
					alert(result);
					$("#doningNote").hide();
				}
			});

		});

		$("#status").click(function() {
			$("#doningNote").show();
			$.ajax({
				url : "${rootUrl }systemmng/sms/status.dox",
				type : "GET",
				success : function(result) {
					alert(result);
					$("#doningNote").hide();
				}
			});

		});
	});
</script>


</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<!-- LOGO -->

	<div id="boxmain">
		<!-- 左侧菜单 -->
		<%@ include file="/WEB-INF/jsp/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">短信发送</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>

								<div class="mtab">
									<div id="doningNote" style="display: none">
										<img src="${rootUrl }images/doing.gif" />正在处理中。。。
									</div>
									<form:form modelAttribute="pageModel" id="addForm"
										name="addForm" action="${rootUrl }systemmng/sms/send.do"
										method="post">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">

											<tr class="title">
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />短信发送</td>
												<td class="td2"><%@ include
														file="/WEB-INF/jsp/noteInfo.jsp"%></td>
											</tr>

											<tr>
												<th width="30%">手机号</th>
												<td><form:input path="mobile" size="32"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">短信内容</th>
												<td><form:textarea path="content" size="32"
														cssStyle="width:140px" /></td>
											</tr>
										</table>

										<div class="boxbtn">

											<div class="btn">
												<a href="#none" id="submit">发送</a>
											</div>
											<div class="btn">
												<a href="#none" id="connect">连接</a>
											</div>
											<div class="btn">
												<a href="#none" id="close">断开</a>
											</div>
											<div class="btn">
												<a href="#none" id="status">状态</a>
											</div>

										</div>
										<br />
										<br />
									</form:form>

								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>