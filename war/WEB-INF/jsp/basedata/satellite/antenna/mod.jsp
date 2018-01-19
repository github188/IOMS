<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});

		jQuery.validator
				.addMethod(
						"antennaCode",
						function(value, element) {
							var exp = /^[0-9A-Z-_]{1,20}$/;
							return this.optional(element) || (exp.test(value));
						},
						"&nbsp;<img src='" + baseUrl
					+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入20位以内数字,大写英文,-,_");

		jQuery.validator
				.addMethod(
						"tesMemo",
						function(value, element) {
							var exp = /^[0-9a-z_A-Z-`=\/\[\];',.\~!@#$%^&*()_+|{}:"<>?？。\u4e00-\u9fa5\uFE30-\uFFA0\s(\（|\）|\！|\，|\《|\》|\{|\}|\【|\】|\“|\”|\·|\、|\：|\；|\‘|\’|\……|\_|\-|\#|\@|\%|\^|\&|\*|\,|\.|\/|\\|\;|\'|\"|\:|\;|\[|\])+]+$/;

							return this.optional(element) || (exp.test(value));
						},
						"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,标点符号,空白符");

		$("#modForm")
				.validate(
						{
							rules : {
								antennaCode : {
									antennaCode : true,
									required : true,
									maxlength : 20,
									remote : '${rootUrl}basedata/checkAntenna.dox?excludeId='
											+ $("#id").val()
								},

								info : {
									tesMemo : true,
									maxlength : 50
								}
							},
							submitHandler : function(form) {
								parent.editSubmit(form);
							}
						});
		$("#submit").click(function() {
			$("#modForm").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }basedata/satellite/antenna/mod.do" method="post">
		<form:hidden path="id" />

		<div class="window">
			<dl class="title">
				<dd>数据管理--卫星天线--修改</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>卫星天线信息</h1>
			<table width="96%">
				<tr>
					<th width="20%">站点名称：</th>
					<td width="30%">${fn:escapeXml(pageModel.site.siteName)}</td>
					<th width="20%">站点代码：</th>
					<td width="30%">${fn:escapeXml(pageModel.site.siteCode)}</td>
				</tr>
				<tr>
					<th width="20%">区域：</th>
					<td width="30%">${pageModel.site.bureau.value}</td>
					<th width="20%">站点类型：</th>
					<td width="30%">${pageModel.site.type}</td>
				</tr>
				<tr>
					<th width="20%">天线尺寸：</th>
					<td width="30%">${pageModel.antennaSize}</td>
					<th width="20%">海拔：</th>
					<td width="30%">${pageModel.elevation}</td>

				</tr>
				<tr>
					<th width="20%">站点纬度：</th>
					<td width="30%">${pageModel.latitude}</td>
					<th width="20%">站点经度：</th>
					<td width="30%">${pageModel.longitude}</td>
				</tr>
				<tr>
					<th width="20%">方位角(度)：</th>
					<td width="30%">${pageModel.positionAngle}</td>
					<th width="20%">俯仰角(度)：</th>
					<td width="30%">${pageModel.pitchingAngle}</td>
				</tr>
				<tr>
					<th width="20%">备件情况：</th>
					<td colspan="3">${pageModel.spare}</td>
				</tr>
				<tr>
					<th width="20%">天线情况：</th>
					<td colspan="3">${pageModel.antennaDesc}</td>
				</tr>
				<tr>
					<th width="20%">备注：</th>
					<td colspan="3"><form:textarea cols="100" path="info" /></td>
				</tr>
			</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>