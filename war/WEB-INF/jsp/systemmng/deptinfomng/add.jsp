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
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
	<script src="${rootUrl }ueditor/ueditor.config.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script>
$(function() {
	$.ajaxSetup({
		cache : false
	});
	$("#addForm")
	.validate(
			{
				rules : {
					
				},
				submitHandler : function(form) {
				
					parent.addSubmit(form);
				}
			});

	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#submit").click(function() {
		$("#addForm").trigger("submit");

	});


});
</script>
</head>

<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }systemmng/deptinfomng/add.do" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>添加部门</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			 
			<table style="width:710px;margin-left:10px" border="0"  >
				<tr>
					<th>部门类别</th>
					<td >
					  <form:select path="deptType">
							<c:forEach var="types" items="${types}"
								varStatus="loop">
								<option value="${types}"/>${types.value}
							</c:forEach>
						</form:select>
					
					</td>
				</tr>
				<tr>
					<th>父级部门</th>
					<td >
					<form:select path="parentInfo">
							<form:option value="">全部</form:option>
							<form:options items="${parents}" itemLabel="deptName" itemValue="id"/>
						</form:select>
					
					</td>
				</tr>
				<tr>
					<th>部门编号:</th>
					<td >
					 <form:input path="deptNumberOa" id="deptNumberOa" />
					</td>
				</tr>
				<tr>
					<th>部门名称：</th>
					<td>
					  <form:input path="deptName" id="deptName" />
					</td>
				</tr>
				
			
				<tr align="center">
					<td colspan="2" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<a href="#none" id="submit">提交</a>
						</span>
						
						<span class="btn">
							<a href="#none" id="goback" class="goback">取消</a>
						</span>
					</td>
				</tr>
			</table>
		</div>

</form:form>
	
</body>
</html>