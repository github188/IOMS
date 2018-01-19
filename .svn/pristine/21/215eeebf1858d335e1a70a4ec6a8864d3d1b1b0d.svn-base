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
 <script src="../../ueditor/ueditor.config.js" type="text/javascript" charset="utf-8" ></script>
 <script src="../../ueditor/ueditor.all.js"  type="text/javascript" charset="utf-8" ></script>
 <script  src="../../ueditor/zh-cn.js"  type="text/javascript" charset="utf-8" ></script>

<script type="text/javascript">
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
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;只能输入数字,中文,小写英文,下划线");
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#delayForm").validate({
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
				parent.editSubmit(form);
			}
		});
		$("#submit").click(function() {
			 $("#content").attr("value",UE.getEditor('editor').getContent());//填充内容
			 $("#delayForm").attr("action","${rootUrl }publicnotice/pn/add.do");
			 $("#delayForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#delay").click(function() { 
			$("#content").attr("value",UE.getEditor('editor').getContent());//填充内容
			 $("#delayForm").attr("action","${rootUrl }publicnotice/pn/delay.dox");
			 $("#delayForm").trigger("submit");
});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="delayForm" name="delayForm"
		action="#" method="post">
		<form:hidden path="id" />
		<%-- <form:hidden path="equipId" /> --%>
		<div class="window">
			<dl class="title">
				<dd>通知公告--继续申请</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>通知公告</h1>
			<table width="100%">
				 <tr>
					<th width="40%"><font color="red">(*)</font>栏目:</th>
					<td><form:select path="columns" cssStyle="width:135px">
							<form:options items="${pnNoticeColumnEnum}" itemLabel="value" />
						</form:select></td>
				</tr> 
					<tr>
					<th width="20%"><font color="red">(*)</font>标题:</th>
					<td><form:input path="title" /></td>
				</tr>
				<tr>
				<th width="40%">请添加公告内容:</th>
				<td><form:hidden  path="content" /></td>
				</tr> 
			</table>
				 <div>
     <script id="editor" type="text/plain" style="width:800;height:500px">
 ${pageModel.content}
</script>
      <script type="text/javascript">

    //实例化编辑器

   var ue = UE.getEditor('editor'); 
    
</script>
</div> 	
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">提交</a>
				</div>
				<div class="btn">
					<a href="#none" id="delay">缓存</a>
				</div>
				<!-- <div class="btn">
					<a href="#none" class="reset" onclick="delayForm.reset();">重置</a>
				</div> -->
			</div>
			<br />
		</div>


	</form:form>
</body>
</html>