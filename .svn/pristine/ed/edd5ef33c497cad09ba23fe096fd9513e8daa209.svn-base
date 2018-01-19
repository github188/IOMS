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
<script type="text/javascript">
	function checkNode(){
		var subnetType = $("#subnetType").val();
		var kuNodeNo = $("#kuNodeNo").val();
		if(kuNodeNo != null && kuNodeNo != ""){
			$.ajax({
	            url: "${rootUrl}basedata/checkKuNode.dox",
	            dataType: "json",
	            data: {
	            	subnetType : subnetType,
	            	kuNodeNo : kuNodeNo
	            },
	            success: function(data) {
	            	if (data == false) {
	            		alert("该子网下此节点号已存在");
	            		$("#kuNodeNoFlag").val("false");
					}else{
	            		$("#kuNodeNoFlag").val("true");
					}
	            }
	        });
		}
	}
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				kuNodeNo : {
					required : true,
					digits : true,
					min : 0,
					max : 999
					//remote:'${rootUrl}basedata/checkKuNode.dox'
				},
				kuNodeCode : {
					required : true,
					kuNodeCode : true,
					maxlength : 20,
					//remote:'${rootUrl}basedata/checkKuNode.dox'
				},
				siteCode : {
					required : true
				},
				cardCount : {
					digits : true,
					min : 0,
					max : 99
				},
				cardConfig : {
					englishName : true,
					maxlength : 50
				},
				instrument : {
					required : true
				},
				status : {
					maxlength : 50
				},
				statusInfo : {
					maxlength : 50
				},
				info : {
					maxlength : 50
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});

		$("#submit").click(function() {
			if ($("#siteId").val() == null
					|| $("#siteId").val() == "") {
				$("#siteCode").val("");
			}
			checkNode();
			var flag = $("#kuNodeNoFlag").val();
			if(flag == "false"){
				return;
			}else{
				$("#addForm").trigger("submit");
			}
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

		//卫星站自动填充
			$("#siteCode").autocomplete({
					minLength: 2, 
	                autoFocus: true, 
	                delay: 500 ,
	                source: function(request, response) {
	                    $.ajax({
	                        url: "${rootUrl}basedata/sitecode.dox",
	                        dataType: "json",
	                        data: {
	                        	term : request.term,
	                        	bureau:$("#bureau").val(),
	                        },
	                        success: function(data) {
	                        	if (data == null || data == [] || data == "") {
	                        		$("#siteCode").val("");
	    							$("#siteId").val("");
	    							return;
	    						}
	                            response($.map(data, function(item) {
	                                return { 
	                                	value : item.siteName+"-"+item.siteCode,
	    								name : item.id,
	    								code:item.siteCode,
	    								
	                                }
	                            }));
	                        }
	                    });
	                },
	               change: function(event, ui) { 
	    				if (!ui.item) { 
	    					$("#siteCode").val("");
							$("#siteId").val("");
	    				} 
	              }, 
	　　　　　　　　　 select: function(event, ui) {
		 				//主动为出发城市及代码赋值
						$("#siteCode").val(ui.item.code);
						$("#siteId").val(ui.item.name);
						
	                }
	                
	            });
		
	});
</script>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/ku/node/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>数据管理--KU节点--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>KU节点信息</h1>
			<table width="96%">
				<tr>
					<th width="20%"><font color="red">(*)</font>子网类型:</th>
					<td><form:select path="subnetType" cssStyle="width:135px">
							<form:options items="${subnetTypes}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>节点号:</th>
					<td><input id="kuNodeNoFlag" name="kuNodeNoFlag" type="hidden" />
						<form:input path="kuNodeNo" onblur="checkNode()" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>节点ID:</th>
					<td><form:input path="kuNodeCode" /></td>
				</tr>
				<!--		<tr>
					<th width="20%"><font color="red">(*)</font>区域:</th>
					<td><form:select path="bureau" cssStyle="width:135px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td>
				</tr>-->
				<tr>
					<th width="20%"><font color="red">(*)</font>卫星站:</th>
					<td><form:input path="siteCode" class="text ui-widget-content" />
						<input type="hidden" id="siteId" name="siteId" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>是否空管局:</th>
					<td><form:select path="caac" cssStyle="width:135px">
							<form:option value="false">否</form:option>
							<form:option value="true">是</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>机箱类型:</th>
					<td><form:select path="type" cssStyle="width:135px">
							<form:options items="${equipTypes}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>有无频谱仪:</th>
					<td><form:select path="instrument" cssStyle="width:135px">
							<form:option value="false">无</form:option>
							<form:option value="true">有</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th width="20%">板卡总数:</th>
					<td><form:input path="cardCount" /></td>
				</tr>
				<tr>
					<th width="20%">板卡配置:</th>
					<td><form:textarea path="cardConfig" cssStyle="width:135px" /></td>
				</tr>

				<tr>
					<th width="20%">上线状态:</th>
					<td><form:textarea path="status" cssStyle="width:135px" /></td>
				</tr>
				<tr>
					<th width="20%">未上线原因:</th>
					<td><form:textarea path="statusInfo" cssStyle="width:135px" /></td>
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