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
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#checktype").hide();
		$.ajaxSetup({
			cache : false
		});
		$("#formalForm").validate({
			rules : {
				approveRemark : {
					required : true,
					maxlength : 300
				},
				approveStat : {
					required : true
				},
				engineer : {
					required : true
				},
				csStaff : {
					required : true
				},
				//正式电路ATM验证条件
				ATMConfTxNodeName :{
					required : true,
					maxlength : 16
				},
				ATMConfTxSlodNum:{
					required : true,
					maxlength : 16
				},
				ATMConfTxPort :{
					required : true,
					maxlength : 16
				},
				ATMConfTxVpiDlci:{
					required : true,
					maxlength : 16
				},	
				ATMConfRxNodeName:{
					required : true,
					maxlength : 16
				},
				ATMConfRxSlodNum:{
					required : true,
					maxlength : 16
				},	
				ATMConfRxPort:{
					required : true,
					maxlength : 16
				},
				ATMConfRxVpiDlci:{
					required : true,
					maxlength : 16
				},	
				ATMConfSpeed:{
					required : true,
					maxlength : 16
				},	
				ATMConfServiceType:{
					required : true,
					maxlength : 16
				},
				ATMConfUsage:{
					required : true,
					maxlength : 16
				},
				ATMConfNo:{
					required : true,
					maxlength : 16
				},
				//正式电路KU验证条件
				KUConfTxSiteName : {
					required : true,
					maxlength : 16
				},
				KUConfTxNode : {
					required : true,
					maxlength : 16
				},
				KUConfTxSlot : {
					required : true,
					maxlength : 16
				},
				KUConfTxPlot : {
					required : true,
					maxlength : 16
				},
				KUConfRxSiteName : {
					required : true,
					maxlength : 16
				},
				KUConfRxNode : {
					required : true,
					maxlength : 16
				},
				KUConfRxSlot : {
					required : true,
					maxlength : 16
				},
				KUConfRxPlot : {
					required : true,
					maxlength : 16
				},
				KUConfSpeed : {
					required : true,
					maxlength : 16
				},
				KUConfUsage :{
					required : true,
					maxlength : 16
				},
				KUConfTxInterface : {
					required : true,
					maxlength : 16
				},
				KUConfRxInterface : {
					required : true,
					maxlength : 16
				},
				KUConfCircuitName : {
					required : true,
					maxlength : 16
				},
				KUConfNo : {
					required : true,
					maxlength : 16
				},
				//正式电路TES验证条件
				TESConfTxSiteName : {
					required : true,
					maxlength : 16
				},
				TESConfTxCaseNum : {
					required : true,
					maxlength : 16
				},
				TESConfTxSlotNum : {
					required : true,
					maxlength : 16
				},
				TESConfRxSiteName : {
					required : true,
					maxlength : 16
				},
				TESConfRxCaseNum : {
					required : true,
					maxlength : 16
				},
				TESConfRxSlotNum : {
					required : true,
					maxlength : 16
				},
				TESConfSpeed : {
					required : true,
					maxlength : 16
				},
				TESConfUsage : {
					required : true,
					maxlength : 16
				},
				TESConfTxInterface : {
					required : true,
					maxlength : 16
				},
				TESConfRxInterface : {
					required : true,
					maxlength : 16
				},
				TESConfCircuitName : {
					required : true,
					maxlength : 16
				},
				TESConfNo : {
					required : true,
					maxlength : 16
				},
				//正式电路PES验证条件
				PESConfTxSiteName : {
					required : true,
					maxlength : 16
				},
				PESConfTxCaseNum : {
					required : true,
					maxlength : 16
				},
				PESConfTxSlotNum : {
					required : true,
					maxlength : 16
				},
				PESConfTxPortNum : {
					required : true,
					maxlength : 16
				},
				PESConfRxSiteName : {
					required : true,
					maxlength : 16
				},
				PESConfRxCaseNum : {
					required : true,
					maxlength : 16
				},
				PESConfRxSlotNum : {
					required : true,
					maxlength : 16
				},
				PESConfRxPortNum : {
					required : true,
					maxlength : 16
				},
				PESConfSpeed : {
					required : true,
					maxlength : 16
				},
				PESConfUsage : {
					required : true,
					maxlength : 16
				},
				PESConfTxInterface : {
					required : true,
					maxlength : 16
				},
				PESConfRxInterface : {
					required : true,
					maxlength : 16
				},
				PESConfCircuitName : {
					required : true,
					maxlength : 16
				},
				PESConfNo : {
					required : true,
					maxlength : 16
				},
				apply : {
					required : true
				},
				auditEngineer : {
					required : true
				},
				//配置备注
				confRemark : {
					required : true,
					maxlength : 100
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
			errorPlacement : function(error, element) {
				//error.appendTo(element.parent("td").next("td")[0]);
				error.appendTo(element.parent("td"));
			}
		});

		$("#submit").click(function() {
			$("#formalForm").trigger("submit");
			$("#innerDetail").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		
		$(".apply").click(function() {
			if($(this).val() == '0'){
				$("#approveRemark").val("");
			}else{
				$("#approveRemark").val("同意");
			}
		});
		
		$(".apply2").click(function() {
			if($(this).val() == '0'){
				$("#approveRemark").val("");
			}else{
				$("#approveRemark").val("审核通过");
			}
		});
		
		var stat = $("#stat").val();
		
		if($.trim(stat) == 'fundmanager_approve'){
			$("#submit").text("确认");
			$("#approveRemark").val("确认");
		}
		if($.trim(stat) == 'csleader_approve'){
			$("#checktype").show();
			$("#checkapply").hide();
		}
		if($.trim(stat) == 'atncleader_approve'){
			$("#checkapply").hide();
		}
		if($.trim(stat) == 'generalmanager_approve'){
			$("#approveRemark").val("");
		}
		
		
		$(".stat").click(function() {
			if($(this).val() == '0'){
				$("#approveRemark").val("");
			}else{
				$("#approveRemark").val("同意");
			}
			var operType = $(this).val();
			var name = $(this).attr("name");
			var role = $("#role").val();	//角色名
			if($.trim(stat) == 'atncleader_approve'){
				$("#approveRemark").val("");
				if($(this).val() == '0'){
					$("#checkapply").hide();
				}else{
					$("#checkapply").show();
					$(".apply").each(function (){
						if($(this).attr("checked")=='checked'){
							if($(this).val() == '0'){
								$("#approveRemark").val("");
							}else{
								$("#approveRemark").val("同意");
							}
						}
					})
				}
			}
		});

		var stat = $("#stat").val();
		if (stat == "csstaff_deal" || stat == "engineer_config") {
			$("#chooseflag").hide();
		}
		if($.trim(stat) == $.trim("assist_config")) {
			$("input[name='approveStat']").each(function(i){
				var $this = $(this);
				if($this.val() == '0') {
					var span = $this.next("span")[0];
					span.remove();
					$this.attr("style","display: none;");
				}
			});
		}
		$("#atm1").hide();
		$("#atm2").hide();
		$("#atm3").hide();
		$("#atm4").hide();
		$("#ku1").hide();
		$("#ku2").hide();
		$("#ku3").hide();
		$("#ku4").hide();
		$("#tes1").hide();
		$("#tes2").hide();
		$("#tes3").hide();
		$("#tes4").hide();
		$("#pes1").hide();
		$("#pes2").hide();
		$("#pes3").hide();
		$("#pes4").hide();
		var applyOpttype = $("#applyOpttype").val();
		var applyType = $("#applyType").val();
		if (applyType == "ATM正式电路") {
			$("#atm1").show();
			$("#atm2").show();
			$("#atm3").show();
			if (applyOpttype == "变更") {
				$("#atm4").show();
			}
		}
		if (applyType == "KU正式电路") {
			$("#ku1").show();
			$("#ku2").show();
			$("#ku3").show();
			if (applyOpttype == "变更") {
				$("#ku4").show();
			}
		}
		if (applyType == "TES正式电路") {
			$("#tes1").show();
			$("#tes2").show();
			$("#tes3").show();
			if (applyOpttype == "变更") {
				$("#tes4").show();
			}
		}
		if (applyType == "PES正式电路") {
			$("#pes1").show();
			$("#pes2").show();
			$("#pes3").show();
			if (applyOpttype == "变更") {
				$("#pes4").show();
			}
		}
		
		$(":radio").click(function() {
			var operType = $(this).val();
			var name = $(this).attr("name");	
			var role = $("#role").val();	//角色名
			//alert(name + "="+operType+":" + role);
			if(name != "apply"){
				if (operType == 1) {
					//同意或配置
					$(".config").show();
					$(".config2").show();
					$("#transfer2").show();
					if($.trim(role) == 'atncLeader') {
						$(".transfer").show();
					} else{
						$(".transfer").hide();
					}
					if($.trim(role) == 'csLeader' || $.trim(role) == 'atncLeader') {
						$("#submit").text("审批");
					} else if($.trim(role) == 'csStaff') {
						$("#submit").text("办理");
					} else if($.trim(role) == 'engineer') {
						if($.trim(stat) == 'engineer_audit') {
							$("#submit").text("审核");
						} else {
							$("#submit").text("配置");
						}
					} 
				} else {
					//退回或移交
					$(".config").show();
					$(".config2").hide();
					$("#transfer2").hide();
					if($.trim(role) == 'atncLeader') {
						$(".transfer").hide();
					} else{
						$(".transfer").show();
					}
					if($.trim(role) == 'csLeader' || $.trim(role) == 'atncLeader') {
						$("#submit").text("审批");
					} else if($.trim(role) == 'csStaff') {
						$("#submit").text("办理");
					} else if($.trim(role) == 'engineer') {
						if($.trim(stat) == 'engineer_audit') {
							$("#submit").text("审核");
						} else {
							$("#submit").text("移交");
						}
					}
				}
			}
		});
	});
	
	function dealcheck(reason){
		var reason = $(reason).val();
		if(reason == true){
			$("#checktype").hide();
			$("#checkapply").show();
			$(".apply").each(function (){
				if($(this).attr("checked")=='checked'){
					if($(this).val() == '0'){
						$("#approveRemark").val("");
					}else{
						$("#approveRemark").val("同意");
					}
				}
			})
		}else{
			$("#approveRemark").val("");
			$("#checktype").show();
			$("#checkapply").hide();
		}
	}
	function doclick(reason){
		var reason = $(reason).val();
		if(reason == true){
			$("#checkapply").show();
		}else{
			$("#checkapply").hide();
		}
	}
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>正式电路申请处理</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
				<form:form modelAttribute="pageModel" id="formalForm"
					name="formalForm" action="${rootUrl }formalcircuit/deal.do" method="post">
					<%@include file="innerDetail.jsp"%>
					<form:hidden path="formalCircuit.id" />
					<form:hidden path="pid" />
					<input type="hidden" name="fid" value="${m.formalCircuit.id}" />
					<input type="hidden" id="stat" value="${m.formalCircuit.approveStat}" />
					<input type="hidden" id="role" value="${role}" />
					<div style="margin: 10px 20px 0px;padding:0px">
					<dl class="title">
						<dd>正式电路处理</dd>
					</dl>
					</div>
					<table width="100%" style="margin: 0px auto">
							<c:if test="${fn:contains(role, '|csStaff|')}">
							    <c:if test="${m.formalCircuit.approveStat eq 'csstaff_deal' and not empty bureaus}">
									<tr>
										<th width="20%" align="right">请选择需要跨区配置的管局：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:checkboxes items="${bureaus}" path="bureau" delimiter="&nbsp"/>
										</td>
									</tr>
							    </c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|csLeader|')}">
								<c:if test="${m.formalCircuit.approveStat eq 'csleader_approve' }">
									 <tr>
										<th width="20%" align="right">请选择审批类别：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="approveStat" value="1" onclick = "dealcheck(this)"/>天航信内部流程通过
											<form:radiobutton path="approveStat" value="0" onclick = "dealcheck(this)" checked="checked"/>天航信内部流程退回
										</td>
									</tr>
									<tr id = "checktype">
										<th width="20%" align="right">退回给：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="reason" value="退回客服" checked="checked"/>客服专员
											<form:radiobutton path="reason" value="退回网控"/>技术工程部领导
											<form:radiobutton path="reason" value="用印审批"/>申请用户
										</td>
									</tr>
									<tr id = "checkapply">
										<th width="20%" align="right">请选择是否同意(用户申请)：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="apply" class="apply" value="1"/>同意用户申请
											<form:radiobutton path="apply" class="apply" value="0" checked="checked"/>不同意用户申请
										</td>
									</tr>
								</c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|atncLeader|')}">
							    <c:if test="${m.formalCircuit.approveStat eq 'atncleader_firstdeal'}">
							    <tr class="transfer">
										<th width="20%" align="right">请选择审核工程师：<span style="color: red">(*)</span></th>
										<td colspan="6">
											<form:select path="auditEngineer" cssStyle="width:35%">
												<form:option value="">请选择</form:option>
												<c:forEach var="e" items="${engineers}" varStatus="engineer">
													<form:option value="${e.id }">${e.name }</form:option>
												</c:forEach>
											</form:select>
										</td>
									</tr>
							    </c:if>
							    <c:if test="${m.formalCircuit.approveStat eq 'atncleader_seconddeal'}">
							        <tr class="transfer">
										<th width="20%" align="right">请选择工程师：<span style="color: red">(*)</span></th>
										<td colspan="6">
											<form:select path="engineer" cssStyle="width:35%">
												<form:option value="">请选择</form:option>
												<c:forEach var="e" items="${engineers}" varStatus="engineer">
													<form:option value="${e.id }">${e.name }</form:option>
												</c:forEach>
											</form:select>
										</td>
									</tr>
								</c:if>
								<c:if test="${m.formalCircuit.approveStat eq 'atncleader_thirddeal'}">
									<tr class="transfer">
										<th width="20%" align="right">请选择审核工程师：<span style="color: red">(*)</span></th>
										<td colspan="6">
											<form:select path="auditEngineer" cssStyle="width:35%">
												<form:option value="">请选择</form:option>
												<c:forEach var="e" items="${engineers}" varStatus="engineer">
													<form:option value="${e.id }">${e.name }</form:option>
												</c:forEach>
											</form:select>
										</td>
									</tr>
							    </c:if>
							    <c:if test="${m.formalCircuit.approveStat eq 'atncleader_approve'}">
							       <tr id="chooseflag">
									    <th width="30%" align="right">
										   <span style="font-size: 13px">请选择审批类别<span style="color: red">*</span>：</span>
									    </th>
									        <td width="70%" colspan="6">
										    <form:radiobutton path="approveStat" class="stat" value="1" onclick="doclick(this)"/>天航信内部流程通过
										    <form:radiobutton path="approveStat" class="stat" value="0" onclick="doclick(this)" checked="checked"/>天航信内部流程退回
									    </td>
								    </tr>
							        <tr id = "checkapply">
										<th width="20%" align="right">请选择是否同意(用户申请)：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="apply" class="apply" value="1"/>同意用户申请
											<form:radiobutton path="apply" class="apply" value="0" checked="checked"/>不同意用户申请
										</td>
									</tr>
							    </c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|engineer|')}">
							    <c:if test="${m.formalCircuit.approveStat eq 'engineer_config'}">
								<tr>
									<th width="20%" align="right">请选择操作类别：<span style="color: red">(*)</span></th>
									<td colspan="7">
										<form:radiobutton path="approveStat" value="1"/><span>配置</span>
										<form:radiobutton path="approveStat" value="0"/><span>移交</span>
									</td>
								</tr>
								<%@include file="config.jsp"%>
								<tr class="transfer" style="display: none">
									<th width="20%" align="right">请选择协助人：<span style="color: red">(*)</span></th>
									<td colspan="6">
										<form:select path="engineer" cssStyle="width:35%">
											<form:option value="">请选择</form:option>
											<c:forEach var="e" items="${engineers}" varStatus="engineer">
												<form:option value="${e.id }">${e.name }</form:option>
											</c:forEach>
										</form:select>
									</td>
								</tr>
							    </c:if>
							    <c:if test="${m.formalCircuit.approveStat eq 'engineer_transfer'}">
								<%@include file="config.jsp"%>
								<tr class="transfer" style="display: none">
									<th width="20%" align="right">请选择协助人：<span style="color: red">(*)</span></th>
									<td colspan="6">
										<form:select path="engineer" cssStyle="width:35%">
											<form:option value="">请选择</form:option>
											<c:forEach var="e" items="${engineers}" varStatus="engineer">
												<form:option value="${e.id }">${e.name }</form:option>
											</c:forEach>
										</form:select>
									</td>
								</tr>
							    </c:if>
							    <c:if test="${m.formalCircuit.approveStat eq 'engineer_secondaudit'}">
								<tr id="chooseflag">
									<th width="30%" align="right">
										<span style="font-size: 13px">请选择审批类别<span style="color: red">*</span>：</span>
									</th>
									<td width="70%" colspan="6">
										<form:radiobutton path="approveStat" class="apply2" value="1"/>天航信内部流程通过
										<form:radiobutton path="approveStat" class="apply2" value="0" checked="checked"/>天航信内部流程退回
									</td>
								</tr>
							    </c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|fundmanager|')}">
							</c:if>
							<c:if  test="${fn:contains(role, '|manager|')}">
							    <c:if test="${m.formalCircuit.approveStat eq 'generalmanager_approve' }">
								<tr id="chooseflag">
									<th width="30%" align="right">
										<span style="font-size: 13px">请选择审批类别<span style="color: red">*</span>：</span>
									</th>
									<td width="70%" colspan="6">
										<form:radiobutton path="approveStat" class="stat" value="1"/>同意用户申请
										<form:radiobutton path="approveStat" class="stat" value="0" checked="checked"/>不同意用户申请
									</td>
								</tr>
								</c:if>
							</c:if>
						<tr class="config">
							<th width="20%" align="right">备注：<span style="color: red">(*)</span></th>
							<td colspan="7">
								<form:textarea id="approveRemark" path="approveRemark" rows="8" style="width:500px;resize:none;" />
							</td>
						</tr>
					</table>
					<div class="boxbtn">
						<div class="btn">
							<c:choose>
							    <c:when test="${role == 'csStaff' }">
									<a href="#none" id="submit">办理</a>
								</c:when>
								<c:when test="${role == 'atncLeader'}">
									<a href="#none" id="submit">提交</a>
								</c:when>
								<c:when test="${role == 'engineer'}">
									<c:choose>
										<c:when test="${m.formalCircuit.approveStat eq 'engineer_firstaudit' || m.formalCircuit.approveStat eq 'engineer_secondaudit'}">
											<a href="#none" id="submit">审核</a>
										</c:when>
										<c:otherwise>
											<a href="#none" id="submit">配置</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${role == 'fundmanager'}">
											<a href="#none" id="submit">确认</a>
										</c:when>
										<c:otherwise>
											<a href="#none" id="submit">审批</a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="btn">
							<a href="#none" class="close">取消</a>
						</div>
					</div>
					<br></br>
				</form:form>
		</div>
	</div>
</body>
</html>