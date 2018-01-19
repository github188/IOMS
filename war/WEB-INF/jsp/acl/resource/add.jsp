<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm")
				.validate(
						{
							rules : {
								id : {
									required : true,
									maxlength : 32,
									resourceId : true,
									remote : '${rootUrl}acl/resource/checkId.dox'
								},
								name : {
									required : true,
									maxlength : 10,
									description:true
								},
								url : {
									uri:true,
									required : false,
									maxlength : 200
								},
								list : {
									required : true,
									digits : true,
									min : 1,
									max : 99
								}
							},
							submitHandler : function(form) {
								if ($("#type").val() == "URL") {
									if ($("#url").val() == null
											|| $("#url").val().trim() == "") {
										if ($("#urlCheck").html()
												.indexOf("URL") > 0) {
											return;
										}
										var row = "<font color='red' id='msg'>添加操作必须添加URL！</font>";
										$(row).appendTo($("#urlCheck"));
										return;
									} else {
										$("").appendTo($("#urlCheck"));
									}
								}
								if ($("#type").val() == "COLUMN") {
									if ($("#url").val() == null
											|| $("#url").val().trim() == "") {
										if ($("#urlCheck").html()
												.indexOf("COLUMN") > 0) {
											return;
										}
										var row = "<font color='red' id='msg'>添加子菜单必须添加URL！</font>";
										$(row).appendTo($("#urlCheck"));
										return;
									} else {
										$("").appendTo($("#urlCheck"));
									}
								}
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
		action="${rootUrl }acl/resource/add.do" method="post">
		<form:hidden path="type" />
		<form:hidden path="pid" />
		<div class="window" style="height: 390px">
			<dl class="title">
				<dd>资源--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>资源信息</h1>
			<table width="100%">
				<tr>
					<th width="20%">资源ID:</th>
					<td><form:input path="id" size="32" width="32" /></td>
				</tr>
				<tr>
					<th width="20%">资源名:</th>
					<td><form:input path="name" size="32" width="32" /></td>
				</tr>
				<tr>
					<th width="20%">资源URL:</th>
					<td><form:textarea path="url" rows="5" cols="30" />
						<div id="urlCheck"></div></td>
				</tr>

				<tr>
					<th width="20%">排序号：</th>
					<td><form:input path="list" size="32" /></td>
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