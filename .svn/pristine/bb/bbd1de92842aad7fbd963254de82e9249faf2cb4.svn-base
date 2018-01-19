<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
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
	$(function() {
		$("#tabs").tabs();
		$.ajaxSetup({
			cache : false
		});
		$("#replyForm").validate({
			rules : {
				descInfo : {
					required : true,
					maxlength : 1000
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
			}
		});

		$("#submit").click(function() {
			$("#replyForm").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
<%@include file="innerdetail.jsp" %>
	<form:form modelAttribute="pageModel" id="replyForm" name="replyForm"
		action="${rootUrl }techsupport/consult/deal/reply.do" method="post">
		<form:hidden path="id" />
		<div class="window">
			<dl class="title">
				<dd>技术咨询回复</dd>
			</dl>
			<h1></h1>
			<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
				<table width="100%">
					<tr>
						<th width="15%" style="text-align: right;">咨询回复：<span style="color: red">(*)</span></th>
						<td><form:textarea path="descInfo" rows="8" 
								cssStyle="width:650px" /></td>
						<td style="text-align:center;" width="200px"></td>
					</tr>
				</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">回复</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br /><br />
		</div>
	</form:form>
</body>
</html>