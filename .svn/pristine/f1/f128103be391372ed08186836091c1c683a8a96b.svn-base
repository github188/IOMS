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


<script>
	$(function() {
		$("#oaEndTime1").val(new Date().Format("yyyy-MM-dd"));
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
					required : true,
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
		//避免重复提交
		var flag = true;
		$("#submit").click(function() {
			//获取延迟超时时间长度
			var timeOutSeconds = getTimeOutSeconds();
			if(flag == false){
				alert("正在提交，请稍后!");
				return;	
			}
			var transferType = $("#transferType").val();
			if (transferType == "DEPT") {
				var nextHanleUser = $("#nextHanleUser").val();
				if (nextHanleUser == null || nextHanleUser == "") {
					alert("必须填写具体移交人");
					return;
				}
				var oaEndTime = $("#oaEndTime").val();
				if (oaEndTime == null || oaEndTime == "") {
					alert("必须选择要求完成时间");
					return;
				}
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

		if ($("#transferType option:selected").val() == "NOT") {
			$("#title1").text('');
			$("#dept_type").hide();
			$("#person_sel").hide();
			$("#title2").text('');
			$("#success_time").hide();
			$("#transfer").hide();
		}
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
	/**
	 * 异步加载部门和具体移交人
	 */
	function changeShow(type) {
		var userDeptId = $("#userDeptId").val();
		var faultId = $("#faultId").val();
		var currentHandleUser = $("#currentHandleUser").val();
		if (type == "NOT") {
			$("#transfer").hide();
			$("#success_time").hide();
		} else {
			$("#transfer").show();
			$
					.ajax({
						type : "GET",
						url : "${rootUrl}phonemng/ajaxFaultTransfer.dox",
						data : {
							type : type,
							faultId : faultId
						},
						dataType : "json",
						success : function(result) {
							if (type == "STATION" || type == "CTO") {
								$("#success_time").hide();
								$("#dept1").hide();
								$("#dept2").hide();
								$("#title2").text('具体移交人');
								$("#transferUser1").show();
								$("#transferUser2").show();
								$("#nextHanleUser option").remove();
								//移交人列表
								var htm = "";
								for (var i = 0; i < result.length; i++) {
									if (currentHandleUser != result[i].id) {
										htm += "<option value='"+ result[i].id +"'>"
												+ result[i].name + "</option>";
									}
								}
								$("#nextHanleUser").append(htm);
							} else {
								$("#dept1").show();
								$("#dept2").show();
								$("#transferUser1").show();
								$("#transferUser2").show();
								$("#title1").text('移交部门');
								$("#title2").text('具体移交人');
								$("#oaDeptId option").remove();
								//移交部门列表
								var htm = "";
								for (var i = 0; i < result.length; i++) {
									if (result[i].id != userDeptId) {
										htm += "<option value='"+ result[i].id + "," + result[i].parentInfo + "," + result[i].deptType.name +"'>"
												+ result[i].deptName
												+ "</option>";
									}
								}
								$("#oaDeptId").append(htm);
								$("#nextHanleUser option").remove();
								$("#success_time").show();
								//预加载第一个部门的员工数据
								if (result[0].id != userDeptId) {
									changeUser(result[0].id + ","
											+ result[0].parentInfo + ","
											+ result[0].deptType.name);
								} else {
									changeUser(result[1].id + ","
											+ result[1].parentInfo + ","
											+ result[1].deptType.name);
								}
							}
						}
					});
		}
	}
	/**
	 * 异步加载部门人员
	 */
	function changeUser(dept) {
		var userDeptId = $("#userDeptId").val();
		var str = dept.split(",");
		deptId = str[0];
		if (str[1] != "0" || (str[1] == "0" && str[2] == "DEPT")) {
			var currentHandleUser = $("#currentHandleUser").val();
			$.ajax({
				type : "GET",
				url : "${rootUrl}phonemng/ajaxDeptUser.dox",
				data : {
					deptId : deptId
				},
				dataType : "json",
				success : function(result) {
					if (str[1] == "0" && str[2] == "DEPT") {
						$("#oaDeptSecondId").remove();
					}
					$("#nextHanleUser option").remove();
					//移交人列表
					var htm = "";
					for (var i = 0; i < result.length; i++) {
						if (currentHandleUser != result[i].id) {
							htm += "<option value='"+ result[i].id +"'>"
									+ result[i].name + "</option>";
						}
					}
					$("#nextHanleUser").append(htm);
				}
			});
		} else {
			$("#oaDeptSecondId").remove();
			//异步加载二级部门
			$
					.ajax({
						type : "GET",
						url : "${rootUrl}phonemng/ajaxSecondDept.dox",
						data : {
							parentInfo : deptId
						},
						dataType : "json",
						success : function(result) {
							$("#nextHanleUser option").remove();
							$("#oaDeptSecondId").remove();
							//移交人列表
							var htm = "<select id='oaDeptSecondId' name='oaDeptSecondId' style='width: 133px;height:22px;' onchange='changeUser(this.value)'>";
							for (var i = 0; i < result.length; i++) {
								if (result[i].id != userDeptId) {
									htm += "<option value='"+ result[i].id + "," + result[i].parentInfo + "," + result[i].deptType.name +"'>"
											+ result[i].deptName + "</option>";
								}
							}
							htm += "</select>";
							$("#dept2").append(htm);
						}
					});
		}
	}
	
	//第一处理人暂存处理
	function faultTemporary(){
		var timeOutSeconds = getTimeOutSeconds();
		var faultId = $("#faultId").val();
		//var faultDesc = $("#faultDesc").val();
		var handleDesc = $("#handleDesc").val();
		var remark = $("#remark").val();
		$.ajax({
			type : "POST",
			url : "${rootUrl}faultmng/faultTemporary.do",
			data : {
				faultId : faultId,
				//faultDesc : faultDesc,
				handleDesc : handleDesc,
				remark :  remark
			},
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
		});
	}
</script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style>
th {
	background-color: #DDDDDD;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}

td {
	word-break: break-all;
}
</style>
</head>

<body style="overflow-x: hidden">
	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px">
		<dl class="title">
			<dd>事件处理</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a> <input type="hidden"
					id="userDeptId" name="userDeptId"
					value="${currentUser.deptinfo.id }" />
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>事件单详情</dd>
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
					<c:if test="${handles.handleType ne 'FAULTTEMPRARY' }">
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
				</c:forEach>
			</table>
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>当前处理</dd>
				</dl>
			</div>
			<form:form id="addForm" name="addForm"
				action="${rootUrl }phonemng/callcenter/faulthandle.do" method="post">
				<input type="hidden" name="faultId" id="faultId"
					value="${fault.id }" />
				<input type="hidden" name="currentHandleUser" id="currentHandleUser"
					value="${fault.firstHandelUser.id}" />
				<table width="100%">
					<tr>
						<th>处理人</th>
						<td>${fault.currentHandleUser}</td>
						<th>移交类别</th>
						<td><select id="transferType" name="transferType"
							style="width: 133px; height: 22px;"
							onchange="changeShow(this.value)">
								<c:forEach items="${transferTypes}" var="transferType">
									<option value="${transferType }">${transferType.value }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr id="transfer">
						<th id="dept1"><span id="title1">移交部门</span></th>
						<td id="dept2"><select id="oaDeptId" name="oaDeptId"
							style="width: 133px; height: 22px;"
							onchange="changeUser(this.value)"></select></td>
						<th id="transferUser1"><span id="title2">具体移交人</span></th>
						<td id="transferUser2"><select id="nextHanleUser"
							name="nextHanleUser" style="width: 133px; height: 22px;"></select></td>
					</tr>
					<tr id="success_time">
						<th><span id="title1">要求完成时间</span></th>
						<td><input readonly="true" id="oaEndTime" name="oaEndTime"
							style="padding: 4px 2px 0px 2px; height: 16px; border: 1px solid #B8B8B8;"
							maxlength="25" class="Wdate"
							onfocus="WdatePicker({el:$dp.$('oaEndTime'),dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'oaEndTime1\')}'})" />
							<input type="hidden" readonly="true" id="oaEndTime1" name="oaEndTime1"
							size="15" maxlength="18" class='Wdate'
							onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'oaEndTime\')}'})" />
						</td>
						<th></th>
						<td></td>
					</tr>
					<%-- <tr>
						<td style="text-align: center;" colspan="4">事件描述</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								id="faultDesc" name="faultDesc" rows="3" cols="90">${handle.faultDesc }</textarea></td>
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
					<tr align="center">
						<td colspan="4" align="center" valign="middle"><span
							class="btn" style="margin-left: 290px"> <a href="#none"
								id="temporary" onclick = "faultTemporary()">暂存</a>
						</span><span
							class="btn"> <a href="#none"
								id="submit">提交</a>
						</span> <span class="btn"> <a href="#none" id="goback"
								class="goback">取消</a>
						</span></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>