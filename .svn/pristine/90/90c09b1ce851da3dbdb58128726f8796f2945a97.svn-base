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
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#modForm").validate({
			rules : {
				siteName : {
					required : true,
					chinese  : true
				},
				siteCode : {
					required : true,
					kuServiceCode : true,
					minlength : 3,
					maxlength : 10,
					remote : '${rootUrl}basedata/satellite/site/checkSiteCode.dox?siteId='+$("#id").val() 
				},
				
				info : {
					memo : true,
					maxlength : 50
				}
			},
			submitHandler : function(form) {
				parent.editSubmit(form);
			}
		});
		$("#submit").click(function() {
			$("#modForm").trigger("submit");
			//var d = parent;
			parent.location.reload();
			//debugger;
		});
		
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }publicnotice/pn/applyPress.do" method="post">
		<form:hidden path="id" />
	<form:hidden path="processInstanceId" /> 
		<div class="window">
			<dl class="title">
				<dd>通知公告--发布</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>通知公告</h1>
			<table width="100%">
				<tr>
					<th width="40%">栏目:</th>
					<td>${fn:escapeXml(pageModel.columns.value)}</td>
				</tr> 
					<tr>
					<th width="20%"></font>标题:</th>
					<td>${fn:escapeXml(pageModel.title)}</td>
				</tr>
					 <tr>
				<th width="40%">内容:</th>
				<br></br>
				<td>${pageModel.content}</td>
				</tr> 

			</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">发布</a>
				</div>
			</div>
			<br />
		</div>
			<br />
		</div>


	</form:form>
</body>
</html>