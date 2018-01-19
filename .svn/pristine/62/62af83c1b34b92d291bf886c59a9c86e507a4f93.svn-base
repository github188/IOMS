<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<head>
<title>卫星采集参数配置</title>
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

		jQuery.validator
				.addMethod(
						"largerThan",
						function(value, element, param) {
							var small = parseFloat($(param).val());
							return small < parseFloat(value);
						},
						"&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp;上限值应大于下限值");

		jQuery.validator
				.addMethod(
						"doubles",
						function(value, element, param) {
							var exp = /^[-|+]?\d+(\.\d+)?$/;
							if (this.optional(element) || (exp.test(value))) {
								if (value.indexOf(".") < 0) {
									return true;
								}
								if ((value.length - value.indexOf(".") - 1) > param) {
									return false;
								} else {
									return true;
								}
							} else {
								return false;
							}
						},
						"&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入浮点数，小数点后保留{0}位");

		$("#addForm").validate({
			rules : {
				tesTxPowerStandard : {
					doubles : 2,
					max : -0.01,
					min : -99.99,
					required : true
				},
				kuRxLevelTopLimit : {
					doubles : 1,
					required : true,
					max : 99.9,
					min : -99.9,
					largerThan : '#kuRxLevelLowerLimit'
				},
				kuRxLevelLowerLimit : {
					doubles : 1,
					max : 99.9,
					min : -99.9,
					required : true
				},
				kuEbNoTopLimit : {
					doubles : 2,
					max : 99.99,
					min : 0,
					required : true
				},
				kuNetworkStatusStandard : {
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
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>

								<div class="mtab">
									<form:form modelAttribute="pageModel" id="addForm"
										name="addForm"
										action="${rootUrl }basedata/param/config.do"
										method="post">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr class="title">
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />参数列表</td>
												<td class="td2"><%@ include
														file="/WEB-INF/jsp/noteInfo.jsp"%></td>
											</tr>

											<tr class="title">
												<th colspan="2" class="td3">卫星参数</th>
											</tr>
											<tr>
												<th width="30%">TES 功率标准</th>
												<td><form:input path="tesTxPowerStandard" size="32"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">KU RxLevel上限</th>
												<td><form:input path="kuRxLevelTopLimit" size="32"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">KU RxLevel下限</th>
												<td><form:input path="kuRxLevelLowerLimit" size="32"
														cssStyle="width:140px" /></td>
											</tr>
											<tr>
												<th width="30%">KU Eb/No标准值</th>
												<td><form:input path="kuEbNoTopLimit" size="32"
														cssStyle="width:140px" /></td>
											</tr>

											<tr>
												<th width="30%">KU 状态标准值</th>
												<td><form:select path="kuNetworkStatusStandard"
														cssStyle="width:150px">
														<form:option value="UP">UP</form:option>
														<form:option value="DOWN">DOWN</form:option>
													</form:select></td>
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