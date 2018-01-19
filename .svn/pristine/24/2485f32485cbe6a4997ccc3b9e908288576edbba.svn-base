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
jQuery.validator
.addMethod(
"atmCode",
function(value, element) {
	var exp = /^[A-Z]{4}-[A-Z]{3}[0-9]{4}-[0-9]{2}$/;
	return this.optional(element) || (exp.test(value));
},
"&nbsp;<img src='"
		+ baseUrl
		+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;格式XXXX-XXXSSSS-SS，X大写英文，S数字");
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				atmNodeSeq : {
					required : true,
					digits : true
				},
		        atmNodeNameCn : {
					required : true,
					chinese : true,
				},
				atmNodeCode : {
					required : true,
					atmCode : true,
					remote:'${rootUrl}basedata/checkAtmNode.dox'
				},
				atmNodeIp : {
					required : true,
					ip : true,
					remote:'${rootUrl}basedata/checkAtmNode.dox'
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});

		$("#submit").click(function() {
			$("#addForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/atm/node/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>数据管理--ATM节点--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>ATM节点信息</h1>
			<table width="96%">
				<tr>
					<th width="20%"><font color="red">(*)</font>区域:</th>
					<td><form:select path="bureau" cssStyle="width:135px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>区内序号:</th>
					<td><form:input path="atmNodeSeq" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>节点地点</th>
					<td><form:input path="atmNodeNameCn" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>节点代码:</th>
					<td><form:input path="atmNodeCode" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>ATM0地址:</th>
					<td><form:input path="atmNodeIp" /></td>
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