<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />

<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
	//大写英文，数字，纯中文
	jQuery.validator
			.addMethod(
					"sSoleName",
					function(value, element) {
						value = value.replace(/\s+/g, "");
						var exp = /^[0-9A-Z\u4e00-\u9fa5]+$/;
						return this.optional(element) || (exp.test(value));
					},
					"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入50位以内的空格,数字、中文、大写英文");
	jQuery.validator
			.addMethod(
					"memow",
					function(value, element) {
						var exp = /^[0-9a-z_A-Z\u4e00-\u9fa5\uFE30-\uFFA0\s(\（|\）|\！|\？|\。|\，|\《|\》|\{|\}|\【|\】|\“|\”|\·|\、|\：|\；|\‘|\’|\……|\_|\-|\#|\@|\%|\^|\&|\*|\,|\.|\/|\\|\;|\'|\"|\:|\;|\[|\])+]+$/;
						return this.optional(element) || (exp.test(value));
					},
					"&nbsp;<img src='"
				+ baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,标点符号,空白符");

	jQuery.validator
			.addMethod(
					"siteCode",
					function(value, element) {
						var exp = /^[A-Z0-9\-]+$/;
						return this.optional(element) || (exp.test(value));
					},
					"&nbsp;<img src='" + baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,大写英文,-");// 请输入4位数字0-9,大写英文

	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm")
				.validate(
						{
							rules : {
								siteName : {
									required : true,
									maxlength : 50,
									sSoleName : true
								},
								siteCode : {
									required : true,
									siteCode : true,
									minlength : 3,
									maxlength : 10,
									remote : '${rootUrl}basedata/satellite/site/checkSiteCode.dox'
								},

								info : {
									maxlength : 50
								}
							},
							submitHandler : function(form) {
								parent.addSubmit(form);
							}
						});

		$("#submit").click(function() {
			/* if ($("#siteId").val() == null
					|| $("#siteId").val() == "") {
				$("#siteCode").val("");
			} */

			$("#addForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/satellite/site/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>卫星站点管理--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>卫星站点信息</h1>
			<table width="96%">
				<tr>
					<th width="25%"><font color="red">(*)</font>区域:</th>
					<td><form:select path="bureau" cssStyle="width:135px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="25%"><font color="red">(*)</font>站点中文名称:</th>
					<td><form:input path="siteName" class="text ui-widget-content" />
						<!-- 	<input type="hidden" id="siteId" name="siteId" />--></td>
				</tr>
				<tr>
					<th width="25%"><font color="red">(*)</font>站点代码:</th>
					<td><form:input path="siteCode" /></td>
				</tr>
				<tr>
					<th width="25%"><font color="red">(*)</font>类型:</th>
					<td><form:select path="type" cssStyle="width:135px">
							<form:option value="TES">TES</form:option>
							<form:option value="KU">KU</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th width="25%">备注信息:</th>
					<td><form:input path="info" /></td>
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