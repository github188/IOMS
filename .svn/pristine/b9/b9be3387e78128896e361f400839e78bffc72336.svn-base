<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<head>
<title>系统参数配置</title>
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


		$("#addForm").validate({
			rules : {
				clientNoticeType : {
					required : true
				},
				tempCircuitNotice : {
					digits : true,
					min : 1,
					max : 999,
					required : true
				},
				techConsultClose : {
					digits : true,
					min : 1,
					max : 999,
					required : true
				},
				busiStatTopLimit : {
					DLCIVPIVCI : true,
					min : 0,
					maxlength : 4,
					required : true
				},
				busiStatLowerLimit : {
					DLCIVPIVCI : true,
					min : 0,
					maxlength : 4,
					required : true
				},
				ftpLinkAlarmMin : {
					digits : true,
					min : 0,
					max : 1440,
					required : true
				}
			}

		});
		$("#submit").click(function() {
			$("#addForm").trigger("submit");
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
						<span class="bold">系统参数配置</span>
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
									<form:form modelAttribute="pageModel" id="addForm"
										name="addForm"
										action="${rootUrl }systemmng/systemparam/config.do"
										method="post">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr class="title">
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />参数列表</td>
												<td class="td2"><%@ include
														file="/WEB-INF/jsp/noteInfo.jsp"%></td>
											</tr>

											<tr class="title">
												<th colspan="2" class="td3">业务模块参数</th>
											</tr>
											<tr>
												<th width="30%">客户通告类型</th>
												<td><form:select path="clientNoticeType"
														cssStyle="width:150px">
														<form:options items="${clientNoticeTypes}"
															itemLabel="value" />
													</form:select></td>
											</tr>
											<tr>
												<th width="30%">临时电路逾期提醒(天)</th>
												<td><form:input path="tempCircuitNotice"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">技术咨询关闭时间(小时)</th>
												<td><form:input path="techConsultClose"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">业务通段上限</th>
												<td><form:input path="busiStatTopLimit"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">业务通段下限</th>
												<td><form:input path="busiStatLowerLimit"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">站点告警时间（分钟）</th>
												<td><form:input path="ftpLinkAlarmMin"
														cssStyle="width:140px" /></td>
											</tr>
										</table>

										<div class="boxbtn">
											<div class="btn">
												<a href="#none" id="submit">配置</a>
											</div>

										</div>

									</form:form>
									</br>
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