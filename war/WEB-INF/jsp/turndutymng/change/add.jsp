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
	$("#addForm").validate({
		rules : {
			remark : {
				required : true,
				maxlength : 500
			}
		},
		submitHandler : function(form) {
			parent.addSubmit(form);
		}
	});

	$(".close").click(function() {
		parent.$.nyroModalRemove();
		window.top.location.reload();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
		window.top.location.reload();
	});
	$("#submit").click(function() {
		$("#addForm").trigger("submit");

	});


});
</script>
</head>

<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }turndutymng/change/add.do" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>交接班记录:编辑</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			 
			<table style="width:710px;margin-left:10px" border="0"  >
				<tr>
					<th>值班人:</th>
					<td >
					  ${username}
					 
					</td>
				</tr>
				<tr>
					<th>值班角色：</th>
					<td>
					   ${userrole}
					  
					</td>
				</tr>
				<tr>
					<th>值班地点：</th>
					<td >
					  ${userplace}
					
					</td>
				</tr>
				<tr>
					<th>内容:</th>
					<td><textarea id="remark" name="remark" rows="10" cols="100" style="width:80%" text=""></textarea></td>
				</tr>
				
				<tr align="center">
					<td colspan="2" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<c:if test="${isflag!='NO' }">
							<a href="#none" id="submit">提交</a>
							</c:if>
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