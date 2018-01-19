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


	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
	});
	
	//表单验证
	$("#modForm").validate({
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
	
	var flag = true;
	$("#submit").click(function() {
		/* $("#modForm").trigger("submit");
		parent.$.nyroModalRemove(); */
		if(flag == false){
			return;	
		}
		flag = false;
		$("#modForm").ajaxSubmit({
			beforeSubmit : validateAddForm,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("修改成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("修改失败");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				}
			}
		})
	});
});

function validateAddForm(formData, jqForm, options) {
	return $("#modForm").valid();
}
</script>
</head>

<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }turndutymng/change/mod.do" method="post">
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
					  ${pageModel.creater.name}
					 <form:hidden path="id" />
					 
					
					</td>
				</tr>
				<tr>
					<th>值班角色：</th>
					<td>
					   ${pageModel.dutyRoles.value}
					  
					</td>
				</tr>
				<tr>
					<th>值班地点：</th>
					<td >
					  ${pageModel.dutyPlaces.value}
					
					</td>
				</tr>
				<tr>
					<th>内容:</th>
					<td><textarea id="remark" name="remark" rows="10" cols="100" style="width:80%" >${pageModel.remark}</textarea></td>
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