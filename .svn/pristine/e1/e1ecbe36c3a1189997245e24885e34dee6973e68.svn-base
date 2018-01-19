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
<script src="${rootUrl }ueditor/ueditor.config.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$("#addForm1").hide();
		
		$.ajaxSetup({
			cache : false
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
		
		//表单验证
		$("#addForm").validate({
            	rules : {
	            	/* faultDesc : {
	                	//required : true,
	                    maxlength : 500
	                }, */
	                handleDesc : {
	                	required : true,
	                    maxlength : 500
	                },
	                remark : {
	                	maxlength : 500
	                }
	            },
	            submitHandler : function(form) {
	                parent.addSubmit(form);
	            }
	        });
		var flag = true;
		$("#submit").click(function() {
			//获取延迟超时时间长度
			var timeOutSeconds = getTimeOutSeconds();
			if(flag == false){
				alert("正在提交，请稍后!");
				return;	
			}
			//表单验证
			var validStatus = $("#addForm").valid();
			//防止重复提交标志位
			if(validStatus == true){
				flag = false;
				$('input,select,textarea',$('#addForm')).prop('readonly',true);
			}else{
				flag = true;
			}
			$("#addForm1").hide();
			$("#addForm").show();
			$("#submitType").val("submit");
			$("#addForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				timeout : timeOutSeconds, 
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("处理成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("处理失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				},
				error: function (xmlHttpRequest, error) { 
					alert("请求超时");
					parent.$.nyroModalRemove();
					window.top.location.reload();
                }
			})
		});
		var flag1 = true;
		$("#engineersubmit").click(function() {
			//获取延迟超时时间长度
			var timeOutSeconds = getTimeOutSeconds();
			if(flag1 == false){
				alert("正在提交，请稍后!");
				return;	
			}
			//表单验证
			var validStatus = $("#addForm").valid();
			//防止重复提交标志位
			if(validStatus == true){
				flag1 = false;
				$('input,select,textarea',$('#addForm')).prop('readonly',true);
			}else{
				flag1 = true;
			}
			$("#addForm1").hide();
			$("#addForm").show();
			$("#submitType").val("engineersubmit");
			$("#addForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				timeout : timeOutSeconds, 
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("处理成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("处理失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				},
				error: function (xmlHttpRequest, error) { 
					alert("请求超时");
					parent.$.nyroModalRemove();
					window.top.location.reload();
                }
			})
		});
		var flag2 = true;
		$("#antcleadersubmit").click(function() {
			//获取延迟超时时间长度
			var timeOutSeconds = getTimeOutSeconds();
			if(flag2 == false){
				alert("正在提交，请稍后!");
				return;	
			}
			//表单验证
			var validStatus = $("#addForm").valid();
			//防止重复提交标志位
			if(validStatus == true){
				flag2 = false;
				$('input,select,textarea',$('#addForm')).prop('readonly',true);
			}else{
				flag2 = true;
			}
			$("#addForm1").hide();
			$("#addForm").show();
			$("#submitType").val("antcleadersubmit");
			$("#addForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				timeout : timeOutSeconds, 
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("处理成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("处理失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				},
				error: function (xmlHttpRequest, error) { 
					alert("请求超时");
					parent.$.nyroModalRemove();
					window.top.location.reload();
                }
			})
		});
		
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
	function validateAddForm1(formData, jqForm, options) {
		return $("#addForm1").valid();
	}
	function errfunction(){
		alert("技术工程师未完成，无法提交");
	}
	function temporary(){
		//var faultDesc = $("#faultDesc").val();
		var handleDesc = $("#handleDesc").val();
		var remark = $("#remark").val();
		var faultId = $("#faultId").val();
		//$(".faultDesc1").val(faultDesc);
		$(".handleDesc1").val(handleDesc);
		$(".remark1").val(remark);
		$(".submitType1").val("temporary");
		$(".faultId1").val(faultId);
		$("#addForm").hide();
		$("#addForm1").show();
		$("#addForm1").validate({
        	rules : {
            	/* faultDesc : {
                    maxlength : 500
                }, */
                handleDesc : {
                    maxlength : 500
                },
                remark : {
                	maxlength : 500
                }
            },
            submitHandler : function(form) {
                parent.addSubmit(form);
            }
        });
		$("#addForm1").ajaxSubmit({
			beforeSubmit : validateAddForm1,
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("处理成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("处理失败");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				}
			}
		})
	}
	
	//部门经理退回事件单给技术工程师
	function backengineer(){
		var handles = document.getElementsByName("handleId");
		//需退回的事件单处置记录ID
		var handlesIds = "";
		for(var i = 0 ; i < handles.length ; i++){
			if(handles[i].checked){
				handlesIds += handles[i].value + ",";
			}
		}
		//验证是否选中退回事件单
		var handleIds = handlesIds.split(",");
		if(handleIds.length == 1){
			alert("请选中需退回的事件单");
			return;
		}
		//事件单ID
		var faultId = $("#faultId").val();
		//退回原因等
		//var faultDesc = $("#faultDesc").val();
		var handleDesc = $("#handleDesc").val();
		var remark = $("#remark").val();
		$.ajax({
			type : "POST",
			url : "${rootUrl}faultmng/fault/backEngineer.do",
			data: {
				handlesIds : handlesIds,
				faultId : faultId,
				//faultDesc : faultDesc,
				handleDesc : handleDesc,
				remark : remark
			},
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("修改成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("修改失败");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				}
			}
		});
	}
</script>
<style>
th {
	background-color: #DDDDDD;
	text-align: center ! important;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}

td {
	word-break:break-all;
}
</style>
</head>

<body style="overflow-x: hidden">

	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px;">
		<dl class="title">
			<dd>非第一处理人事件处理</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>事件处理记录</dd>
				</dl>
			</div>
			<table width="100%">
				<tr>
					<th>事件单编号</th>
					<td colspan="3">${fault.faultNumber }</td>
				</tr>
				<tr>
					<th>申告电话</th>
					<td>${fault.telephoneNumber }</td>
					<th>申告联系人</th>
					<td>${fault.contactsName }</td>
				</tr>
				<tr>
					<th>所属单位</th>
					<td>${fault.faultCompany }</td>
										<th>事件类别</th>
					<td>${fault.eventType.value }</td>
				</tr>
				<c:if test="${fault.eventType.value ne 'ENVIRONMENT' and  fault.eventType.value ne 'OTHER'}">
					<tr>
						<th>是否有备份</th>
						<td>
							<c:if test="${fault.backups eq 'yes' }">
								是
							</c:if>
							<c:if test="${fault.backups eq 'no' }">
								否
							</c:if>
						</td>
						<th>是否需立即恢复</th>
						<td>
							<c:if test="${fault.renew eq 'yes' }">
								是
							</c:if>
							<c:if test="${fault.renew eq 'no' }">
								否
							</c:if>
						</td>
					</tr>
				</c:if>
				<c:if test="${fault.eventType.value eq 'ATM'}">
					<tr>
						<th>业务类型</th>
						<td>
							<c:if test="${fault.serviceType eq 'airControl' }">
								空管
							</c:if>
							<c:if test="${fault.serviceType eq 'officeWork' }">
								办公
							</c:if>
						</td>
						<th>&nbsp;</th>
						<td>&nbsp;</td>
					</tr>
				</c:if>
				<tr>
					<th>事件等级</th>
					<td>${fault.faultLevel }级</td>
					<th>事件发生时间</th>
					<td><fmt:formatDate value="${fault.faultTime }" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th>事件发生地址</th>
					<td>${fault.faultArea }</td>
					<th>事件单创建时间</th>
					<td><fmt:formatDate value="${fault.createTime }" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th>第一处理人</th>
					<td>${fault.firstHandelUser.name }</td>
					<th>坐席电话</th>
					<td>${fault.stationPhone }</td>
				</tr>
				<tr>
					<th>事件单来源</th>
					<td>${fault.source.value }</td>
					<th>&nbsp;</th>
					<td>&nbsp;</td>
				</tr>
			</table>

			<c:if test="${deptBool eq true}">
				<div>
					<span style="color: red;">部门经理需要退回技术工程师重新处理时，选中灰色背景记录的复选框即并点击退回技术工程师即可</span>
				</div>
			</c:if>
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>已完成处理记录描述</dd>
				</dl>
			</div>
			<table width="100%">
				<tr>
					<th style="width: 15%">提交时间</th>
					<th style="width: 10%">状态</th>
					<th width="10%">处理人</th>
					<th width="10%">下一个处理人</th>
					<th width="20%">事件描述</th>
					<th width="20%">处理过程</th>
					<th width="15%">备注</th>
				</tr>
				<c:forEach items="${faultHandles}" var="handles"
					varStatus="voStatus">
					<c:if test="${handles.handleType ne 'ENGINEER' && handles.handleType ne 'CACHE' && handles.handleType ne 'FAULTTEMPRARY' }">
						<tr>
							<td><fmt:formatDate value="${handles.operatTime }"
									type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${handles.handleType.value }</td>
							<td>${handles.operator.name }</td>
							<td>${handles.nextHanleUser }</td>
							<td>${handles.faultDesc }</td>
							<td>${handles.handleDesc }</td>
							<td>${handles.remark }</td>
						</tr>
					</c:if>
					<c:if test="${handles.handleType eq 'ENGINEER' && deptBool eq false  && handles.handleType ne 'FAULTTEMPRARY' }">
						<tr>
							<td><fmt:formatDate value="${handles.operatTime }"
									type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${handles.handleType.value }</td>
							<td>${handles.operator.name }</td>
							<td>${handles.nextHanleUser }</td>
							<td>${handles.faultDesc }</td>
							<td>${handles.handleDesc }</td>
							<td>${handles.remark }</td>
						</tr>
					</c:if>
					<c:if test="${handles.handleType eq 'ENGINEER' && deptBool eq true}">
						<tr bgcolor="gray">
							<td><input type="checkbox" id="handleId" name="handleId" value="${ handles.id}"/><fmt:formatDate value="${handles.operatTime }"
									type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${handles.handleType.value }</td>
							<td>${handles.operator.name }</td>
							<td>${handles.nextHanleUser }</td>
							<td>${handles.faultDesc }</td>
							<td>${handles.handleDesc }</td>
							<td>${handles.remark }</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>当前处理</dd>
				</dl>
			</div>
			<form:form id="addForm" name="addForm"
				action="${rootUrl }faultmng/fault/handle.do" method="post">
				<input id="faultId" name="faultId" value="${fault.id }"
					type="hidden" />
				<input type="hidden" name="submitType" id="submitType"/>
				<table width="100%">
					<tr>
						<th>处理人</th>
						<td>${currentHandleUser }</td>
					</tr>
					<%-- <tr>
						<td style="text-align: center;" colspan="4">事件描述</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4">
							<textarea id="faultDesc" name="faultDesc" rows="3" cols="90">${handle.faultDesc }</textarea>
						</td>
					</tr> --%>
					<tr>
						<td style="text-align: center;" colspan="4">处理过程</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								id="handleDesc" name="handleDesc" rows="3" cols="90">${handle.handleDesc }</textarea></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4">备注</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								id="remark" name="remark" rows="3" cols="90">${handle.remark }</textarea></td>
					</tr>
				</table>
			</form:form>
			<form:form id="addForm1" name="addForm1"
				action="${rootUrl }faultmng/fault/handle.do" method="post">
				<input class="faultId1" id="faultId" name="faultId" value="${fault.id }"
					type="hidden" />
				<input class="submitType1" type="hidden" name="submitType" id="submitType"/>
				<table width="100%">
					<tr>
						<th>处理人</th>
						<td>${currentHandleUser }</td>
					</tr>
					<%-- <tr>
						<td style="text-align: center;" colspan="4">事件描述</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4">
							<textarea class="faultDesc1" id="faultDesc" name="faultDesc" rows="3" cols="90">${handle.faultDesc }</textarea>
						</td>
					</tr> --%>
					<tr>
						<td style="text-align: center;" colspan="4">处理过程</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								 class="handleDesc1" id="handleDesc" name="handleDesc" rows="3" cols="90">${handle.handleDesc }</textarea></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4">备注</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								 class="remark1" id="remark" name="remark" rows="3" cols="90">${handle.remark }</textarea></td>
					</tr>
				</table>
			</form:form>
			<div>
				<table width="100%">
					<tr align="center">
						<td colspan="4" align="center" valign="middle">
							<c:if test="${fault.faultStatus eq 'ASSIGNOK' && deptBool eq false}">
								<span class="btn" style="margin-left: 300px"> <a href="#none" id="temporary" onclick="temporary()">暂存</a></span>
								<span class="btn"> <a href="#none" id="engineersubmit">提交</a></span> 
							</c:if>
							<c:if test="${fault.faultStatus eq 'ASSIGNOK' && deptBool eq true}">
								<c:if test="${successEngineer eq true }">
									<span class="btn" style="margin-left: 300px"> <a href="#none" id="antcleadersubmit">提交</a></span> 
								</c:if>
								<c:if test="${successEngineer eq false }">
									<span class="btn" style="margin-left: 300px"> <a href="#none" id="" onclick="errfunction()">提交</a></span> 
								</c:if>
							</c:if>
							<c:if test="${fault.faultStatus ne 'ASSIGNOK'}">
								<c:if test="${deptBool eq true }">
									<span class="btn" style="margin-left: 250px"> <a href="#none" id="" onclick="backengineer()">退回技术工程师</a></span> 
									<span class="btn"> <a href="#none" id="submit">提交</a></span> 
								</c:if>
								<c:if test="${deptBool eq false }">
									<span class="btn" style="margin-left: 300px"> <a href="#none" id="submit">提交</a></span> 
								</c:if>
							</c:if>
							<span class="btn"> <a href="#none" id="goback" class="goback">取消</a></span>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>