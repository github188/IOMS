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
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		//表单验证
		$("#modForm").validate({
			rules : {
				spare1 : {
					required : true,
					maxlength : 100
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}/* ,
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
				//flag = true;
			} */
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
		//防止重复提交
	
		$("#submit").click(function() {
			
           
			//防止重复提交标志位
			 $("#modForm").ajaxSubmit({
				    beforeSubmit : validateAddForm,
				    dataType : "json",
					success : function(data, status, xhr) {
					
						if (data.success == true) {
							alert("离岗成功");
							parent.$.nyroModalRemove();
						
						    window.top.location.reload();
							
						
                        
						} else {
							alert("离岗成功");
							parent.$.nyroModalRemove();
							window.top.location.reload();
						}
					},
					error: function (xmlHttpRequest, error) { 
						alert(error);
						parent.$.nyroModalRemove();
						window.top.location.reload();
                    } 
				})
			
		});

	});

	function validateAddForm(formData, jqForm, options) {
		return $("#modForm").valid();
	}
</script>
</head>

<body style="overflow-x: hidden" >

      
 
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }turndutymng/change/mngleave.do" method="post">
		<form:hidden path="signTime" id="signTime" />
		
		<div class="window"
			style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px">
			<dl class="title">
				<dd>代离岗</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>

			<table style="width: 650px; margin-left: 10px" border="0">
				<tr>
					<th width="70px">工程师姓名:</th>
					<td>${pageModel.userinfo.name}<form:hidden path="id" /></td>
				</tr>
				<tr>
					<th width="70px">值班角色：</th>
					<td>
					  ${pageModel.dutyRole.value}
					</td>
				</tr>
				<tr>
					<th width="70px">值班地点：</th>
					<td>
					  ${pageModel.dutyPlace.value}
					</td>
				</tr>
				<tr>
					<th width="70px">签到时间:</th>
					<td>
					 
					  <fmt:formatDate value="${pageModel.signTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					
				</tr>
                <tr>
					<th width="70px">离岗时间:</th>
					<td>
					   <input id="leaveTime" name="leaveTime" style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;" maxlength="25" class="Wdate"
						onfocus="WdatePicker({el:$dp.$('faultTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" />
					</td>
					
				</tr>
				<tr>
					<th width="70px">备注信息:</th>
					<td>
					   <textarea id="spare1" name="spare1" rows="10" cols="100" style="width:80%" >${pageModel.spare1}</textarea>
					</td>
					
				</tr>
				<tr align="center">
					<td colspan="2" align="center" valign="middle"><span
						class="btn" style="margin-left: 280px"> <a href="#none"
							id="submit">提交</a>
					</span> <span class="btn"> <a href="#none" id="goback"
							class="goback">取消</a>
					</span></td>
				</tr>
			</table>
		
	</form:form>
</div>
</body>
</html>