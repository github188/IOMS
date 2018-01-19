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
</head>
<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm" action="#" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>通知公告:添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>通知公告</h1>
			<table style="width:650px;margin-left:10px" border="0"  >
				<tr>
					<th width="70px"><font color="red">(*)</font>栏目:</th>
					<td ><form:select path="columns" cssStyle="width:135px">
						<form:options items="${newsColumnEnum}" itemLabel="value" />
					</form:select>
					</td>
				</tr>
				<tr>
					<th width="70px"><font color="red">(*)</font>标题:</th>
					<td ><form:input path="title" style="width:100%" /></td>
				</tr>
				<tr>
					<th width="70px"><font color="red">(*)</font>提交人:</th>
					<td >${createName}
					<input type="hidden" name="createUser" value="${createUser}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="left">请在下面填写内容:</td>
				</tr>
				<tr>
					<td colspan="2" >
					<form:hidden  path="content" />
					<span id="editor" style="height:400px" ></span>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<a href="#none" id="submit">提交</a>
						</span>
						<span class="btn">
							<a href="#none" id="none">草稿</a>
						</span>
						<span class="btn">
							<a href="#none" id="reset" class="reset" onclick="addForm.reset();">重置</a>
						</span>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	<script type="text/javascript">
	    //实例化编辑器
        var ue = UE.getEditor('editor');
        var ue = UE.getEditor('editor', {
            initialContent : ''
        });
        var isSub = true;
        $(function() {
            /*$.ajaxSetup({
                cache : false
            });*/
            $("#addForm").validate({
    			rules : {
    			    columns : {
    					required : true
    				},
    				title : {
    					required : true,
    					maxlength : 30,
    					description:true
    				},
    				createUser:{
    					required : true
    				},
    				content:{
    				    required : true
    				}
    			},
    			submitHandler : function(form) {
    			    if(isSub==true){
        				parent.popupRemoveSubmit(form);
    			    }else{
    					parent.addSubmit(form);
    			    }
    				//parent.location.reload();
    			}
    		});
    		$(".close").click(function() {
    			parent.$.nyroModalRemove(this.parent);
    		});
            $("#submit").click(function() {
                isSub=true;
                $("#content").attr("value", UE.getEditor('editor').getContent());//填充内容
                $("#addForm").attr("action", "${rootUrl }news/add.do");
                $("#addForm").trigger("submit");
            });
            $("#none").click(function() {
                isSub=false;
                $("#content").attr("value", UE.getEditor('editor').getContent());//填充内容
                $("#addForm").attr("action", "${rootUrl }news/none.do");
                $("#addForm").trigger("submit");
            });

            $("#reset").click(function() {
                $("#content").attr("value", "");
                UE.getEditor('editor').setContent("");
            });
        });
    </script>
	
</body>
</html>