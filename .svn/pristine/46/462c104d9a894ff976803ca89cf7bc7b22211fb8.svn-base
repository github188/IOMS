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
	$("#modForm").validate({
		rules : {
			contactName : {
				required : true,
				maxlength : 10,
				description : true
			},
			telNumber : {
				required : true,
				phoneAndMobile : true
			},
			companyInfo : {
				required : true,
				maxlength : 50
			},
			contactPlace : {
				required : true,
				maxlength : 20
			},
			remark : {
				maxlength : 50
			}
		},
		submitHandler : function(form) {
			parent.editSubmit(form);
		}
	});

	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#submit").click(function() {
		 $("#modForm").attr("action", "${rootUrl }phonemng/contactsmng/mod.do");
         $("#modForm").trigger("submit");
         $("#modForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("联系人修改成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("联系人修改失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				}
			})
	
	});


});
</script>
</head>

<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="#" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>编辑联系人</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			 
			<table style="width:710px;margin-left:10px" border="0"  >
				<tr>
					<th>联系人姓名</th>
					<td >
					
					 ${pageModel.contactName}
					 <form:hidden path="id" />
					</td>
					<th>联系电话：</th>
					<td>
					   ${pageModel.telNumber}
					  
					</td>
				</tr>
				<tr>
					<th>所在地址：</th>
					<td >
					 <form:input path="contactPlace" id="contactPlace" />
					</td>
					<th>
					   所属单位
					</th>
					<td>
					  <form:input path="companyInfo" id="companyInfo" />
					</td>
				</tr>
				<tr>
				  <td style="text-align: center;" colspan="4">备注</td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="4">
					
					<textarea id="remark" name="remark" rows="10" cols="100" style="width:80%" text="">${pageModel.remark}</textarea>
					</td>
	
				</tr>
				<tr align="center">
					<td colspan="4" align="center" valign="middle">
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