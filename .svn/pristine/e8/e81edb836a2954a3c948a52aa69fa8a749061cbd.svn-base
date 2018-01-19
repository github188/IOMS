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
	 jQuery.validator.addMethod("bandWidthPool", function(value, element) { var
		exp = /^[0-9A-Z-_]{1,20}$/; return this.optional(element) ||
		 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
			+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入20位以内数字、-、_、大写英文");
		 
	
	 jQuery.validator.addMethod("rate", function(value, element) { var
		 exp = /^([1-9]\d*|0)(\.\d+)?$/;
	 
	 
	 return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入10位以内整数、浮点数");		 
		
	 jQuery.validator.addMethod("tesNodeCode", function(value, element) { var
			exp = /^[0-9A-Z]{4}$/; return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入4位数字0-9及大写英文字母");
	
	 jQuery.validator.addMethod("cu", function(value, element) { var
			exp = /^[1-9][0-4]?$/; return this.optional(element) ||
			 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字1-14");
			 
	 jQuery.validator.addMethod(
				"tesMemo",
				function(value, element) {					
					var exp = /^[0-9a-z_A-Z-`=\/\[\];',.\~!@#$%^&*()_+|{}:"<>?？。\u4e00-\u9fa5\uFE30-\uFFA0\s(\（|\）|\！|\，|\《|\》|\{|\}|\【|\】|\“|\”|\·|\、|\：|\；|\‘|\’|\……|\_|\-|\#|\@|\%|\^|\&|\*|\,|\.|\/|\\|\;|\'|\"|\:|\;|\[|\])+]+$/;
	
					return this.optional(element) || (exp.test(value));
				},
				"&nbsp;<img src='"
						+ baseUrl
						+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,标点符号,空白符");

	 
		$.ajaxSetup({
			cache : false
		});
		
		$("#addForm").validate({
			rules : {
				activeNodeCode : {
				//	tesNodeCode:true,
					required : true
				},
				passiveNodeCode : {
					tesNodeCode:true,
					required : true
				},
				activeSlot : {
					cu:true,
					required : true
				},
				passiveSlot : {
					cu:true,
					required : true
				},			
				bandWidthPool : {
					bandWidthPool:true,
					required : true//,										
					//maxlength : 20
				}, 
				circuitName : {
					required : true,
					maxlength : 20,
					kuServiceCode : true,
					remote : '${rootUrl}basedata/checkTesService.dox'
				},
				
				rate: {
					rate:true,
					required : true,										
					maxlength : 10
				}, 				
				info : {
					tesMemo : true,
					maxlength : 50
				},
				serviceMemo:{
					tesMemo : true,
					maxlength : 500
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		$("#submit")
				.click(
						function() {
							/* if ( $("#activeNodeCode").val().trim() != "") {

								$
										.ajax({
											url : "${rootUrl}basedata/tesNodeExist.dox?tesNodeCode="
													+ $("#activeNodeCode").val(),
											async : false,
											success : function(result) {
												$("label[for='activeNodeCode']")
														.remove();
												if (result.indexOf("false") >= 0) {
													$("#activeNodeCode")
															.after(
																	"<label class='error' for='activeNodeCode' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 节点不存在!</label>");
												}
											}
										});
							} */
							/* if ( $("#passiveNodeCode").val().trim() != "") {
								$
										.ajax({
											url : "${rootUrl}basedata/tesNodeExist.dox?tesNodeCode="
													+ $("#passiveNodeCode").val(),
											async : false,
											success : function(result) {
												$("label[for='passiveNodeCode']")
														.remove();
												if (result.indexOf("false") >= 0) {
													$("#passiveNodeCode")
															.after(
																	"<label class='error' for='passiveNodeCode' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 节点不存在!</label>");
												}
											}
										});
							} */
							/* if ($("label[for='activeNodeCode']").length > 0) {
								return;
							} */
						/* 	if ($("label[for='passiveNodeCode']").length > 0) {
								return;
							}
							
							if ($("#activeNodeId").val() == null
									|| $("#activeNodeId").val() == "") {
								$("#activeNodeCode").val("");
							}
							if ($("#activeNodeId").val() == null
									|| $("#activeNodeId").val() == "") {
								$("#activeNodeCode").val("");
							} */
							
							
							$("#addForm").trigger("submit");
						});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		
		
		
		
		
		
		$("#activeNodeCode").autocomplete({
			minLength: 1, 
           // autoFocus: true, 
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
                    		$("#activeNodeCode").val("");
							//$("#activeNodeId").val("");
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
					$("#activeNodeCode").val("");
					//$("#activeNodeId").val("");
				} 
			 	else
			    {
					$.ajax({
                    url: "${rootUrl}basedata/tesSlot.dox",
                    dataType: "json",
                    data: {
                    	term : $("#activeNodeCode").val()//request.term
                    },
                    success: function(data) {
                    	$("#activeSlot").empty();
                    	$("#activeSlot").append("<option value=''>-请选择-</option>"); 
                    	if (data == null || data == [] || data == "") {                 		
							return;
						}
                    	else{                    		
                    		$.each(data,function(i,n){	                    		
	                    		$("#activeSlot").append("<option value="+n.cu+">"+n.cu+"</option>"); 
	                    	})
                    	}             	
                  }
               });  					
           }
          }, 

        /*   blur: function(event, ui) { 
        		alert($("#activeNodeCode").val());	
        		$("#activeSlot").empty();
        },  */
          
　　　　　 select: function(event, ui) { 	
				$("#activeNodeCode").val(ui.item.value);
				//$("#activeNodeId").val(ui.item.name);	
            }
        });			
		
		
 		$("#passiveNodeCode").autocomplete({
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
                    		$("#passiveNodeCode").val("");
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
					$("#passiveNodeCode").val("");
					//$("#passiveNodeId").val("");
				} 
			 	else
			    {
					$.ajax({
                    url: "${rootUrl}basedata/tesSlot.dox",
                    dataType: "json",
                    data: {
                    	term : $("#passiveNodeCode").val()//request.term
                    },
                    success: function(data) {
                    	$("#passiveSlot").empty();
                    	$("#passiveSlot").append("<option value=''>-请选择-</option>"); 
                    	if (data == null || data == [] || data == "") {                 		
							return;
						}
                    	else{                    		
                    		$.each(data,function(i,n){	                    		
	                    		$("#passiveSlot").append("<option value="+n.cu+">"+n.cu+"</option>"); 
	                    	})
                    	}             	
                  }
               });  					
           }
          }, 

　　　　　 select: function(event, ui) { 	
				$("#passiveNodeCode").val(ui.item.value);
				//$("#passiveNodeId").val(ui.item.name);	
            }
        });			 
		
		
	});
</script>


</head>
<body>
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/tes/service/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>数据管理--TES业务--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>TES业务信息</h1>
			<table>
				<tr>
					<th width="20%"><font color="red">(*)</font>电路名:</th>
					<td width="30%"><form:input path="circuitName"
							cssStyle="width:300px" /></td>

				</tr>
				<%-- 	<tr>
					<th width="20%"><font color="red">(*)</font>主叫端节点:</th>
					<td><form:input path="activeNodeCode" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>被叫端节点:</th>
					<td><form:input path="passiveNodeCode" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
				</tr> --%>
				<tr>
					<th width="20%"><font color="red">(*)</font>主叫端机箱号:</th>
					<td><form:input path="activeNodeCode"
							class="text ui-widget-content" cssStyle="width:100px" /> <input
						type="hidden" id="activeNodeId" name="activeNodeId" /></td>
					<th width="20%"><font color="red">(*)</font>被叫端机箱号:</th>
					<td><form:input path="passiveNodeCode"
							class="text ui-widget-content" cssStyle="width:100px" /> <input
						type="hidden" id="passiveNodeId" name="passiveNodeId" /></td>

				</tr>
				<%-- <tr>
					<th width="20%"><font color="red">(*)</font>主叫端节点:</th>
					<td><form:input path="activeNodeCode" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>被叫端节点:</th>
					<td><form:input path="passiveNodeCode" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
							
				</tr>
				 --%>
				<tr>
					<th width="20%"><font color="red">(*)</font>主叫端槽位号:</th>
					<td><form:select path="activeSlot" cssStyle="width:100px">
							<form:option value="">-请选择-</form:option>
						</form:select></td>

					<th width="20%"><font color="red">(*)</font>被叫端槽位号:</th>
					<td><form:select path="passiveSlot" cssStyle="width:100px">
							<form:option value="">-请选择-</form:option>
						</form:select></td>
				</tr>

				<%-- 
				<tr>
					<th width="20%"><font color="red">(*)</font>主叫端槽号:</th>
					<td><form:input path="activeSlot" cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>被叫端槽号:</th>
					<td><form:input path="passiveSlot" cssStyle="width:100px" /></td> 
				</tr>
--%>
				<tr>
					<th width="20%"><font color="red">(*)</font>同异步:</th>
					<td width="30%"><form:select path="sync"
							cssStyle="width:105px">
							<form:option value="SYNC">SYNC</form:option>
							<form:option value="ASYNC">ASYNC</form:option>
						</form:select></td>
					<th width="20%"><font color="red">(*)</font>电路速率(kbps):</th>
					<td width="30%"><form:input path="rate" cssStyle="width:100px" /></td>
				</tr>

				<tr>
					<th width="20%"><font color="red">(*)</font>频带池:</th>
					<td width="30%"><form:input path="bandWidthPool"
							cssStyle="width:100px" /></td>
					<%-- <th width="20%"><font color="red">(*)</font>所属地区:</th>
					<td width="30%"><form:select path="bureau"
							cssStyle="width:105px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td> --%>
				</tr>

				<tr>
					<th width="20%">收端信息:</th>
					<td colspan="3"><form:textarea path="serviceMemo"
							cssStyle="width:470px" /></td>
				</tr>
				<tr>
					<th width="20%">备注:</th>
					<td colspan="3"><form:textarea path="info"
							cssStyle="width:470px" /></td>
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