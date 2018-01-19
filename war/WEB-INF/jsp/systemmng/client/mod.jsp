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
	<script src="${rootUrl }js/randomPsw.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script>
function ajaxCompany() {
	var bureau = $("#bureau").val();
	//var roleName = $("#roleName").val();
	if ("" != bureau) {
		/* $("#pClientID").removeAttr("disabled");
		if (roleName == "areaManager") {
			$("#pClientID").attr("disabled", "disabled");
			return;
		} */
		var url = "${rootUrl}systemmng/client/getCompany.dox?r=" + Math.random();
        $.ajax({
            url : url,
            type : "GET",//get请求
            async : false,//同步加载数据
            data : "bureau=" + bureau,
            dataType : "json",//返回json格式
            success : function(response) {
            	$("#newCompany").html("<option value='' selected='selected'>请选择</option>");
            	if(response.length > 0){
                    for ( var i = 0; i < response.length; i++) {
                        $("#newCompany").append("<option value='"+response[i].id+"' >" + response[i].company + "</option>");
                        $("option[value='"+$("#nCompanyName").val()+"']").attr("selected","selected");
                    }
                }else{
                	 $("#newCompany").empty();
                	 $("#newCompany").append("<option value='' >请选择</option>");
                	alert("无法注册！该区域没有单位！");
                }
            	/* if(roleName == "user"){////职位级别为单位工程师时，显示上级领导下拉框，增加表格验证
            		$("#pClient").show();
            		$("#pClientID").show();
                    $("#pClientID").html("<option value='' selected='selected'>请选择</option>");
                    if(response.length > 0){
	                    for ( var i = 0; i < response.length; i++) {
	                        $("#pClientID").append("<option value='"+response[i].id+"' >" + response[i].name + "</option>");
	                    	
	                    }
	                    $("option[value='"+$("#pClientName").val()+"']").attr("selected","selected");
                    }else{//若无上级领导，弹出窗口提示
                    	alert("无法注册！请确认上级领导是否已经注册！");
                    }
            	}else{ //职位级别为单位领导时，隐藏上级领导下拉框，取消表格验证
					$("#pClient").hide();
					$("#pClientID").hide();
					$("#pClientID").val("");
					$("#pClientID").parent().next().empty();
				} */
            }
        });
    } /* else {
        $("#pClientID").html("<option value='' selected='selected'>请选择</option>");
    } */
}
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("option[value='"+ $("#roleName1").val() +"']").attr("selected","selected");
		ajaxCompany();
		$("#modForm").validate({
			rules : {
					name : {
	                    required : true,
	                    maxlength : 10
	                },
	                age : {
	                    digits : true,
	                    range : [ 1, 99 ]
	                },
	               /*  bureau : {
	                    required : true
	                },
	                company : {
	                    required : true,
	                    maxlength : 50
	                }, */
	                address : {
	                    maxlength : 200
	                },
	                postcode : {
	                    zipcode : true
	                },
	                mobilephone : {
	                    mobile : true
	                },
	                phone : {
	                	phone : true
	                },
	                email : {
	                    email : true,
	                    //remote : "${rootUrl}systemmng/client/checkEmail.dox?r=" + Math.random()
	                },
	                info : {
	                    maxlength : 100
	                },
	                job : {
	                    maxlength : 16
	                },
	                fax : {
	                	phone : true
	                },
	                branch : {
	                    maxlength : 16
	                }
				},
				
				submitHandler : function(form) {
					parent.editSubmit(form);
				},
	            errorPlacement : function(error, element) {
	                error.appendTo(element.parent("td").next("td")[0]);
	            } 
			});
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
		$("#submit").click(function(){
			var valueCell = $("#mobilephone").val();
        	var valuePhone = $("#phone").val();
        	if(valueCell == "" && valuePhone == ""){
        		alert("座机号码与手机号码至少填一项");
        		return false;
        	}
        	//判断单位是否选择
        	var valueCompany = $("#newCompany").val();
        	if(valueCompany == ""){
        		alert("单位名称为必选项");
        		return false;
        	}
			
			//判断职位级别是否选择
			
			/* if(value1==""){
				$("#roleName1").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");	
				return false;
			} */
			$("#modForm").validate();
			$("#modForm").attr("action", "${rootUrl }systemmng/client/mod.do");
			$("#modForm").trigger("submit");
		});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="#" method="post">
		<form:hidden path="id" />
		<dl class="title">
			<dd>客户信息--更改</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="window" >
			<table width="100%">
				<tr>
					<th colspan="6"
						style="color: gray; width: 100%; text-align: center;">客户信息</th>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>姓名:</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="name" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="20%"><font color="red">(*)</font>性别:</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">
					
					<form:radiobutton path="sex" value="MALE" />男
					<form:radiobutton path="sex" value="FEMALE" />女
					
					</td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%">年龄:</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="age" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="20%"><font color="red">(*)</font>角色:</th>
					<form:hidden id="roleName" path="role.name" />
					<td id="roleName1" width="15%" style="word-break:break-all;word-wrap:break-word;" >${pageModel.role.info}</td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>所属区域:</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">
						<form:select id="bureau" onchange="ajaxCompany()" path="bureau"
							style="width: 100%" >
								<%-- <c:forEach items="${bureaus }" var="vo">
									<option value="${vo }">${vo.value }</option>
								</c:forEach> --%>
								<form:options items="${bureaus}" /> 
						</form:select>
					</td> 
					<td width="15%"></td>
					<th width="20%"><font color="red">(*)</font>单位名称：</th>
					<form:hidden id="nCompanyName" path="newCompany.id" />
					<td  width="15%" style="word-break:break-all;word-wrap:break-word;">
						<form:select id="newCompany" path="company" style="width: 100%">
							<option value="">请选择</option>
						</form:select>
					</td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%">单位地址:</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">${pageModel.newCompany.address}</td>
					<td width="15%"></td>
					<th width="20%">单位邮编：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">${pageModel.newCompany.postcode}</td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%">手机号码：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input id="mobilephone" color="black" path="mobilephone" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="20%">座机号码：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input id="phone" color="black" path="phone" style="width: 97%"></form:input></td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%">职务：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input id="job" color="black" path="job" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="20%">传真：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input id="fax" color="black" path="fax" style="width: 97%"></form:input></td>
					<td width="15%"></td>
				</tr>
				<tr>
				    <th width="20%">部门：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input id="branch" color="black" path="branch" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="20%">个人邮箱：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="email" style="width: 97%"></form:input></td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="20%">登录名：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">${pageModel.loginName}</td>
					<td width="15%"></td>
					<th width="20%">状态：</th>
					<td width="15%" style="word-break:break-all;word-wrap:break-word;">${pageModel.status.value}</td>
					<td width="15%"></td>
				</tr>
				
				<tr>	
					<th width="20%">审核理由：</th>
					<td colspan="4" style="word-break:break-all;word-wrap:break-word;">${pageModel.auditReason}</td>
					<td width="15%"></td>
				</tr>
				
				<tr style="height:50px">
					<th width="20%">备注：</th>
					<td colspan="4" style="word-break:break-all;word-wrap:break-word;"><form:textarea color="black" path="info" style="width: 97%;"></form:textarea></td>
					<td width="15%"></td>
				</tr>
			</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="closeButton">取消</a>
				</div>
			</div>
			<br />
		</div>
		<!-- end 详情内容-->
		</form:form>
</body>
</html>