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
 <script src="${rootUrl }ueditor/ueditor.config.js" type="text/javascript" charset="utf-8" ></script>
 <script src="${rootUrl }ueditor/ueditor.all.js"  type="text/javascript" charset="utf-8" ></script>
 <script  src="${rootUrl }ueditor/zh-cn.js"  type="text/javascript" charset="utf-8" ></script>

<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
//实例化编辑器
var ue = UE.getEditor('editor');
var ue = UE.getEditor('editor', {
    initialContent : ''
});
//英文，数字，纯中文,下划线
jQuery.validator
		.addMethod(
				"title",
				function(value, element) {
					var exp = /^[0-9A-Z_a-z\u4e00-\u9fa5]+$/;
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;只能输入数字,中文,大小写英文,下划线");
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				title : {
					required : true,
					title:true,
					maxlength : 30
				},
				
				content : {
					required : true,
					maxlength : 500
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});

		$("#submit").click(function() {
			 $("#content").attr("value",UE.getEditor('editor').getContent());//填充内容
			 $("#addForm").attr("action","${rootUrl }publicnotice/pn/add.do");
			 $("#addForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#delay").click(function() { 
			$("#content").attr("value",UE.getEditor('editor').getContent());//填充内容
			 $("#addForm").attr("action","${rootUrl }publicnotice/pn/delay.dox");
			$("#addForm").trigger("submit");
			//window.location.href = "${rootUrl }publicnotice/pn/add.dox";
		
});
	});
</script>
</head>
<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm" action="#" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>通知公告--新增</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>通知公告</h1>
			<table style="width:650px;margin-left:10px" border="0"  >
				<tr>
					<th width="30%"><font color="red">(*)</font>栏目:</th>
					<td><form:select path="columns" cssStyle="width:135px">
						<form:options items="${newsColumnEnum}" itemLabel="value" />
					</form:select>
					</td>
					<th width="33%"><font color="red">(*)</font>标题:</th>
					<td><form:input path="title" /></td>
					<th width="33%"><font color="red">(*)</font>提交人:</th>
					<td><form:input path="createUser" readonly="true" value="${createUser}" /></td>
				</tr>
				<tr>
					<td colspan="6" align="left">请在下面填写内容:</td>
				</tr>
				<tr>
					<td colspan="6">
					<form:hidden  path="content" />
					<span id="editor" style="height:400px" ></span>
					</td>
				</tr>
				<tr align="center">
					<td colspan="6" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<a href="#none" id="submit">提交</a>
						</span>
						<span class="btn">
							<a href="#none" id="delay">暂存</a>
						</span>
						<span class="btn">
							<a href="#none" class="reset" onclick="addForm.reset();">重置</a>
						</span>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	
</body>
</html>