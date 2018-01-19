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
	<form:form modelAttribute="pageModel" id="modForm" name="modForm" action="#" method="post">
		<form:hidden path="id" />
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>通知公告:修改</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>通知公告</h1>${pageModel.status.value }
			<table style="width:650px;margin-left:10px" border="0"  >
				<tr>
					<th width="70px"><font color="red">(*)</font>栏目:</th>
					<td colspan="2" ><form:select path="columns" cssStyle="width:135px">
						<form:options items="${newsColumnEnum}" itemLabel="value" />
					</form:select>
					</td>
					<th width="70px"><font color="red">(*)</font>标题:</th>
					<td colspan="2" ><form:input path="title" /></td>
				</tr>
				<tr>
					<th width="70px"><font color="red">(*)</font>提交人:</th>
					<td colspan="5" >${pageModel.createUser.name}
					<input type="hidden" name="createUser" readonly="true" value="${pageModel.createUser.loginName}" /></td>
				</tr>
				<tr>
					<td colspan="6" align="left">请在下面填写内容:</td>
				</tr>
				<tr>
					<td colspan="6">
					<form:hidden  path="content" />
					<span id="editor" style="height:400px"></span>
					</td>
				</tr>
				<tr align="center">
					<td colspan="6" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<a href="#none" id="submit">提交</a>
						</span>
						<span class="btn">
							<a href="#none" id="none">草稿</a>
						</span>
						<span class="btn">
							<a href="#none" id="reset" class="reset" onclick="modForm.reset();">重置</a>
						</span>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	<script type="text/javascript">
	    //实例化编辑器
	    var content = "${pageModel.content}";
        var ue = UE.getEditor('editor');
        ue.addListener('ready',function(){
            ue.setContent(content);
        });
        var isSub = true;
        $(function() {
            $.ajaxSetup({
                cache : false
            });
            $("#modForm").validate({
    			rules : {
    			    columns : {
    					required : true
    				},title : {
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
    					parent.editSubmit(form);
    			    }
    			}
    		});
    		$(".close").click(function() {
    			parent.$.nyroModalRemove();
    		});
        	$("#submit").click(function() {
                isSub=true;
                $("#content").attr("value", UE.getEditor('editor').getContent());//填充内容
                //$("#pass").attr("value",true);
                $("#modForm").attr("action", "${rootUrl }news/modify.do");
                $("#modForm").trigger("submit");
            });
            $("#none").click(function() {
                isSub=false;
                $("#content").attr("value", UE.getEditor('editor').getContent());//填充内容
                $("#modForm").attr("action", "${rootUrl }news/noneModify.do");
                $("#modForm").trigger("submit");
            });

            $("#reset").click(function() {
                $("#content").attr("value", "");
                UE.getEditor('editor').setContent("${pageModel.content}");
            });
        });
    </script>
	
</body>
</html>