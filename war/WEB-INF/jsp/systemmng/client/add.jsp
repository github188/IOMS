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
	<script type="text/javascript">
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
	
	                    }
                    }else{
                    	$("#newCompany").empty();
                   	 	$("#newCompany").append("<option value='' >请选择</option>");
                    	alert("无法注册！该区域没有单位！");
                    }
                	/* if(roleName != "localManager"){////职位级别为单位工程师时，显示上级领导下拉框，增加表格验证
                		$("#pClient").show();
                		$("#pClientID").show();
	                    $("#pClientID").html("<option value='' selected='selected'>请选择</option>");
	                    if(response.length > 0){
		                    for ( var i = 0; i < response.length; i++) {
		                        $("#pClientID").append("<option value='"+response[i].id+"' >" + response[i].name + "</option>");
		
		                    }
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
        } else {
            $("#pClientID").html("<option value='' selected='selected'>请选择</option>");
        }
    }
		
    $(function() {
    	//生成6位随机密码
    	var rc = "";
		rc = rc + getRandomChar();
		for (var idx = 1; idx < 6; ++idx) {
		rc = rc + getRandomChar();
		}
		//展示到密码框中
		$("#password").val(rc);
        
		$.ajaxSetup({
            cache : false
        });

        $("#addForm").validate({
            rules : {
                name : {
                    required : true,
                    maxlength : 10
                },
                age : {
                    digits : true,
                    range : [ 1, 99 ]
                },
                bureau : {
                    required : true
                },
                mobilephone : {
                   
                    mobile : true
                },
                phone : {
                	phone : true
                },
                email : {
                    email : true,
                    remote : "${rootUrl}systemmng/client/checkEmail.dox?r=" + Math.random()
                },
                loginName : {
                    rangelength : [ 3, 15 ],
                    required : true,
                    remote : "${rootUrl}systemmng/client/checkClient.dox?r=" + Math.random()
                },
                password : {
                    required : true 
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
                parent.addSubmit(form);
            },
            errorPlacement : function(error, element) {
                error.appendTo(element.parent("td").next("td")[0]);
            }
        });

        $(".close").click(function() {
            parent.$.nyroModalRemove();
        });

        $("#submit").click(function() {
        	
        	var valueCell = $("#cell").val();
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
        	//判断上级领导是否选择
        	
			$("#roleName").parent().next().empty();
			var value1 = $("#roleName").val();
			
			if(value1==""){
				$("#roleName").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");	
				return false;
			}
            $("#addForm").attr("action", "${rootUrl }systemmng/client/add.do");
            $("#addForm").trigger("submit");
        });
    });
	</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="addForm" name="addForm" action="#" method="post">
		<div class="window" style="height:510px">
			<dl class="title">
				<dd>客户--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>客户信息</h1>
			<center>
				<hr style="width: 80%" />
			</center>
			<table width="96%">
				<tr>
					<th width="20%"><font color="red">(*)</font>姓名:</th>
					<td style="width: 15%"><form:input path="name" /></td>
					<td style="width: 15%"></td>
					<th width="10%"><font color="red">(*)</font>性别:</th>
					<td style="width: 15%"><input type="radio" name="sex"
						checked="checked"  value="MALE" />男&nbsp;&nbsp; <input
							type="radio" name="sex" value="FEMALE" />女 </td>
					<td></td>
				</tr>
				<tr>
					<th width="10%"><font color="red">(*)</font>所属区域:</th>
					<td><select id="bureau" onchange="ajaxCompany()" name="bureau"
						style="width: 100%">
							<option value="" selected="selected">请选择</option>
							<c:forEach items="${bureaus }" var="vo">
								<option value="${vo }">${vo.value }</option>
							</c:forEach>

					</select></td>
					<td></td>
					<th width="20%">年龄:</th>
					<td><form:input path="age" /></td>
					<td></td>
				</tr>
				<tr>
					<th id="nCompany" style="padding: 0"><font color="red">(*)</font>单位名称：</th>
					<td><select id="newCompany" name="newCompany.id" style="width: 100%">
						<option value="">请选择</option>
					</select></td>
					<td></td>
					<th><font color="red">(*)</font>职位级别:</th>
					<td><select id="roleName" name="role.name" style="width: 100%">
							<option value="" selected="selected">请选择</option>
							<c:forEach items="${roles}" var="vo">
								<c:if test="${vo != 'aaTempUser'}">
									<option value="${vo }">
											${vo.name }
									</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<th width="20%">座机号码:</th>
					<td><form:input id="phone" path="phone"/></td>
					<td></td>
					<th width="10%">手机号码:</th>
					<td><form:input id="cell" path="mobilephone" /></td>
					<td></td>
				</tr>
				<tr>

					<th>个人邮箱：</th>
					<td><form:input path="email" /></td>
					<td></td>
					<th><font color="red">(*)</font>用户名：</th>
					<td><form:input path="loginName" /></td>
					<td></td>
				</tr>
				<tr>
					<th><font color="red">(*)</font>密码：</th>
					<td><form:input path="password" id="password" readonly="true"/></td>
					<td><font color="red">请记住随机密码，均为大写英文字母</font></td>
					<th width="20%">部门:</th>
					<td><form:input id="branch" path="branch"/></td>
					<td></td>
				</tr>
				<tr>
					<th width="20%">职务:</th>
					<td><form:input id="job" path="job"/></td>
					<td></td>
					<th width="10%">传真:</th>
					<td><form:input id="fax" path="fax" /></td>
					<td></td>
				</tr>
				<tr>
					<th>备注：</th>
					<td colspan="4"><form:textarea path="info" rows="5"
							cssStyle="width:100%" /></td>
					<td></td>
				</tr>
				
			</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>