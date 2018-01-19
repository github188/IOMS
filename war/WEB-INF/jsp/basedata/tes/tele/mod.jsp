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

<script type="text/javascript">
	$(function() {
		jQuery.validator.addMethod("cu", function(value, element) { var
			exp = /^([1-9]|1[0-4]|14)$/; return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入1-14");
			 
	 jQuery.validator.addMethod("tesNodeCode", function(value, element) { var
			exp = /^[0-9A-Z]{4}$/; return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入4位数字0-9及大写英文字母");
	 jQuery.validator.addMethod("phoneNum", function(value, element) { var
			exp = /^[0-9]{1,5}$/; return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入5位以内数字");
			 	 	 	 
	
		
		$.ajaxSetup({
			cache : false
		});
		$("#modForm").validate({
			rules : {
				tesNodeCode : {
					required : true,
					tesNodeCode:true
				
				},
				cu : {
					cu:true,
					required : true
				},				
				phoneNum : {	
					phoneNum: true,
					required : true
				},
						
				info : {
					memo : true,
					maxlength : 50
				}
				
			},
			submitHandler : function(form) {
				parent.editSubmit(form);
			}
		});
		$("#submit").click(function() {
			 /* if ($("#tesNodeCode").val().trim() != "") {
					$
							.ajax({
								url : "${rootUrl}basedata/tesNodeExist.dox?tesNodeCode="
										+ $("#tesNodeCode").val(),
								async : false,
								success : function(result) {
									$("label[for='tesNodeCode']")
											.remove();
									if (result.indexOf("false") >= 0) {
										$("#tesNodeCode")
												.after(
														"<label class='error' for='tesNodeCode' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 机箱号不存在!</label>");
									}
								}
							});
				} 
				 if ($("label[for='tesNodeCode']").length > 0) {
						return;
					} */
			$("#modForm").trigger("submit");
		});		
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});	
		
		$("#tesNodeCode").autocomplete({
			minLength: 1, 
            //autoFocus: true, 
            delay: 500 ,
            source: function(request, response) {
                $.ajax({
                    url: "${rootUrl}basedata/tesNodecode.dox",
                    dataType: "json",
                    data: {
                    	term : request.term
                    },
                    success: function(data) {
                    	if (data == null || data == [] || data == "") {
                    		$("#tesNodeCode").val("");
							//$("#passiveNodeId").val("");
							return;
						}
                        response($.map(data, function(item) {
                            return { 
                            	value : item.tesNodeCode,
								name : item.id,
								
                            }
                        }));
                    }
                });
            },
           change: function(event, ui) { 
				if (!ui.item) { 
					$("#tesNodeCode").val("");
					//$("#passiveNodeId").val("");
				} 
			 	else
			    {
					$.ajax({
                    url: "${rootUrl}basedata/tesSlot.dox",
                    dataType: "json",
                    data: {
                    	term : $("#tesNodeCode").val()//request.term
                    },
                    success: function(data) {
                    	$("#cu").empty();
                    	$("#cu").append("<option value=''>-请选择-</option>"); 
                    	if (data == null || data == [] || data == "") {                 		
							return;
						}
                    	else{     
                    		$.each(data,function(i,n){	    
                    			/*if (i == 0 && checkedValue == null) {
									checkedValue = value.siteCode;
								}
								 $("#siteCode").append("<option value="
										+ value.siteCode + ">" + value.siteCode
										+ "(" + value.siteName + ")"
										+ "</option>"); 
								 */
	                    		$("#cu").append("<option value="+n.cu+">"+n.cu+"</option>"); 
	                    	})
                    	}             	
                  }
               });  					
           }
          }, 

　　　　　 select: function(event, ui) { 	
				$("#tesNodeCode").val(ui.item.value);
				//$("#passiveNodeId").val(ui.item.name);	
            }
        });		
	});

</script>

</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }basedata/tes/tele/mod.do" method="post">
		<form:hidden path="id" />
		<div class="window">
			<dl class="title">
				<dd>数据管理--TES卫星电话--修改</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>TES卫星电话信息</h1>
			<table style="margin: auto">
				<tr>
					<th width="20%"><font color="red">(*)</font>电话号码:</th>
					<td><form:input path="phoneNum" /></td>
				</tr>

				<tr>
					<th width="20%"><font color="red">(*)</font>机箱号:</th>
					<td><form:input path="tesNodeCode" /> <form:hidden
							path="tesNodeId" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>槽位号:</th>
					<td><form:select path="cu" cssStyle="width:100px">
							<form:options items="${pageModel.cus}" />
							<%-- <form:option value="${pageModel.cu}">${pageModel.cus}
							</form:option> --%>
						</form:select></td>
				</tr>
				<tr>
					<th width="20%">备注:</th>
					<td><form:textarea path="info" cssStyle="width:135px" /></td>
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