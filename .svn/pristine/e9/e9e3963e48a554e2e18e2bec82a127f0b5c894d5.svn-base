<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />

<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
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
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>

<script type="text/javascript">
//与当前时间的对比
jQuery.validator.addMethod(
		"compareDate",
		function(value, element,params) {
			var curDate = new Date();
			var dateStr = value.replace(/-/g,"/");
			var preDate = new Date(dateStr);
			return false;
		},"&nbsp;<img src='/images/validator/check_n.gif' width=16 height=16>&nbsp;预估确认时间不能小于当前时间");
				
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#confirmWarnForm").validate({
			//errorClass: none;
			//调试模式
			debug:true,
			//隐藏表单不被验证
			ignore : ":hidden",
			rules : {
				descInfo : {
					required : true,
					maxlength : 1000
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
/* 			highlight: function(element, errorClass) {  //针对验证的表单设置高亮
			    $(element).addClass(errorClass);
			},
			success: function(label) {
                label.addClass("valid").text("Ok!");  
  			 }, */
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
			}
		});

		$("#submit").click(function() {
			//如果确认时间输入框处于可见状态，则进行判断
			if($("#confirm_time").is(":visible")){
				$("#confirmTime").parent().next().empty();
				var value1 = $("#descInfo").val();
				var value = $("#confirmTime").val();
				if(value==""){
					if(value1==""){
						$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");	
					}else{
						$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");
						return false;
					}
				}
				var curDate = new Date();
				var dateStr = value.replace(/-/g,"/");
				var preDate = new Date(dateStr);
				if(preDate<curDate){
					$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;预估确认时间不能小于当前时间");
					return false;
				}
			}
			$("#confirmWarnForm").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		
		$("#finish").click(function(){
			$("#confirm_time").hide();
		});
		
		$("#nofinish").click(function(){
			$("#confirm_time").show();
		});
		
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="confirmWarnForm" name="confirmWarnForm"
		action="${rootUrl }techsupport/fault/deal/confirmwarn.do" method="post">
		<form:hidden path="id" />
		<form:hidden path="faultdeclarepi" />
		<div class="window">
			<dl class="title">
				<dd>确认提醒</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1></h1>
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
				<table width="100%">
					<tr>
	    			   <th width="20%" style="text-align: right;"><span style="font-size: 13px">请选择：<span style="color: red">(*)</span></span></th>
						<td width="250px" style="text-align: center;">
							<input id="finish" type=radio name="userConfirm"
								value="true"/>结单
		    				<input id="nofinish" type=radio name="userConfirm"
								value="false" checked="checked"/>未结单
						</td>
					</tr>
					<tr>
						<th width="20%" style="text-align: right;">备注信息：<span style="color: red">(*)</span></th>
						<td><form:textarea path="descInfo" rows="8"
								cssStyle="width:500px" /></td>
						<td style="text-align:center" width="100px"></td>
					</tr>
					<tr id="confirm_time">
						<th style="text-align: right;">用户下次确认时间：<span style="color: red">(*)</span></th>
						<td>
							<form:input cssStyle="width:400px" path="confirmTime" readonly="true" cssClass="inputDate"
									onfocus="WdatePicker({el:$dp.$('confirmTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
								<img src="${rootUrl}images/datePicker.gif"
								onclick="WdatePicker({el:$dp.$('confirmTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'});"
								style="cursor: pointer;" />
						</td>
						<td style="text-align:center" width="100px"></td>
					</tr>
				</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">确定</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br /> <br />
		</div>
	</form:form>
</body>
</html>