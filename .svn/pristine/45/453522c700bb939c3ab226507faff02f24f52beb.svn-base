<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${rootUrl }css/window.css" rel="stylesheet" type="text/css" />
<script src="${rootUrl }js/sha-1.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$.ajaxSetup ({ cache: false}); 
	$("#addForm").validate({
		rules:{
			title:{required:true, maxlength:50},
			content:{required:true,maxlength:1000},
			userNames:{required:true}
		},
		 submitHandler: function(form) {
			 if(window.confirm("你确定要发送消息吗?")){
				parent.addSubmit(form);
			 }
		}
	});
	$('.closeButton').click(function(){
		parent.$.nyroModalRemove();
	});
	
	$('#saveButton').click(function(){
			$('#addForm').submit();		
	});
	
	$('#clearButton').click(function(){
		$("#userIds,#userNames").val("");
		
	});
	
	$("#userButton").nyroModal({forceType:"iframe",minWidth:700,minHeight:600,closeButton:null});//避免冲突
	
	
	
});

function setUserInfo(userId,userName,loginName){
	var userIds=$("#userIds").val();
	var userNames=$("#userNames").val();
	if(userIds.length>0){
		userIds+=","+userId;
		userNames+=","+userName;
	}else{
		userIds=userId;
		userNames=userName;
	}
	$("#userIds").val(userIds);
	$("#userNames").val(userNames);
}
</script>

<style type="text/css">
  table td{font-size: 20px;font-weight: bold;}
  table th{font-size: 20px;}
  input,textarea{font-size: 20px;font-weight: bold;}
</style>

</head>

<body>
<div class="window" style="min-height: 540px">
<form:form modelAttribute="sendMessage" id="addForm" name="addForm" action="${rootUrl }system/message/send/send.do" method="post">
	<dl class="title">
		<dd>发送消息管理--发送消息</dd>
		<dt><a href="#none" class="closeButton"><img src="${rootUrl }images/error_fuck.png" alt="关闭"/></a></dt>
	</dl>
	<h1>发送消息</h1>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <th  >标题：</th>
	    <td><form:input path="title" cssStyle="width:400px" /></td>
	  </tr>
	  
	  <tr>
	    <th>内容：</th>
	    <td>
	    	<form:textarea path="content"  cssStyle="width:400px"   rows="6"/>
	    </td>
	  </tr>
	  <tr><td  colspan="2"></td> </tr>
	 <tr>
	    <th>接收人：</th>
	    <td>
	    	<input type="hidden" name="userIds" id="userIds" />
	    	<textarea  name="userNames" id="userNames"   style="width:400px" rows="6" readonly="readonly" ></textarea>
	    	<a id="userButton" name="userButton"  href="${rootUrl }system/user/userSelect.do" ><img src="${rootUrl}images/find.png" title="选择人员" alt="选择具体人员" border="0" style="vertical-align:top;"/> </a>
	    </td>
	  </tr>
	</table>
<div class="boxbtn" style="width: 200px">
	<div class="btn"><a href="#none" id="clearButton">清空</a></div>
	<div class="btn"><a href="#none" id="saveButton">确认</a></div>
	<div class="btn"><a href="#none" class="closeButton">取消</a></div>
</div>
</form:form>
<br />
</div>
</body>
</html>