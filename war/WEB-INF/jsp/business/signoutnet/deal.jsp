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
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		//控制类
		var dealType = $("#dealTypeNow").val();
		if (dealType == "signoutnet_atm") {
			$(".config").remove();
		} else {
			$(".config2").remove();
		}

		$.ajaxSetup({
			cache : false
		});
		$("#solveForm").validate({
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
				auditEngineer : {
					required : true
				},
				csStaff : {
					required : true
				},
				node : {
					required : true,
					maxlength : 20
				},
				mediumFrequency : {
					required : true,
					maxlength : 20
				},
				emissionFrequency : {
					required : true,
					maxlength : 20
				},
				receiveFrequency : {
					required : true,
					maxlength : 20
				},
				placeATM : {
					required : true,
					maxlength : 16
				},
				placeATMO : {
					required : true,
					maxlength : 16
				},
				connectivity : {
					required : true
				},
				nodemng : {
					required : true
				},
				confRemark : {
					required : true,
					maxlength : 200
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td"));
			}
		});

		$("#submit").click(function() {
			$("#submit").attr("disabled", "true");
			$("#solveForm").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

		$(".apply").click(function() {
			if ($(this).val() == '0') {
				$("#approveRemark").val("");
			} else {
				$("#approveRemark").val("同意");
			}
		});

		$(".apply2").click(function() {
			if ($(this).val() == '0') {
				$("#approveRemark").val("");
			} else {
				$("#approveRemark").val("审核通过");
			}
		});

		var stat = $("#stat").val();
		$(".stat").click(
				function() {
					if ($(this).val() == '0') {
						$("#approveRemark").val("");
					} else {
						$("#approveRemark").val("同意");
					}
					if ($.trim(stat) == 'atncleader_review'
							|| $.trim(stat) == 'csleader_review') {
						$("#approveRemark").val("");
						if ($(this).val() == '0') {
							$("#checkapply").hide();
						} else {
							$("#checkapply").show();
							$(".apply").each(function() {
								if ($(this).attr("checked") == 'checked') {
									if ($(this).val() == '0') {
										$("#approveRemark").val("");
									} else {
										$("#approveRemark").val("同意");
									}
								}
							})
						}
					}
				});

		if ($.trim(stat) == $.trim("assist_config")) {
			$("input[name='approveStat']").each(function(i) {
				var $this = $(this);
				if ($this.val() == '0') {
					var span = $this.next("span")[0];
					span.remove();
					$this.attr("style", "display: none;");
				}
			});
		}

		var stat = $("#stat").val();

		if ($.trim(stat) == 'fundmanager_confirm') {
			$("#submit").text("确认");
			$("#approveRemark").val("确认");
		}
		if ($.trim(stat) == 'netmanager_approve'
				|| $.trim(stat) == 'leader_approve'
				|| $.trim(stat) == 'marketmanager_approve') {
			$("#approveRemark").val("");
		}

		$(":radio[name='approveStat']").click(
				function() {
					var approveStat = $(this).val();
					//signoutnet_atm
					var dealType = $("#dealTypeNow").val();
					var name = $(this).attr("name");
					var role = $("#role").val(); //角色名
					if (approveStat == 1) {
						//配置、网控领导退回
						$("#transfer").hide();
						$(".transfer1").show();
						$("#transfer2").show();
						$("#checktype").hide();
						if (dealType == "signoutnet_atm") {
							$(".config2").show();
						} else {
							$(".config").show();
						}
						if ($.trim(role) == 'csLeader'
								|| $.trim(role) == 'atncLeader') {
							$("#submit").text("审批");
						} else if ($.trim(role) == 'csStaff') {
							$("#submit").text("办理");
						} else if ($.trim(role) == 'engineer') {
							if ($.trim(stat) == 'engineer_audit') {
								$("#submit").text("审核");
							} else {
								$("#submit").text("配置");
							}
						}
					} else {
						if (dealType == "signoutnet_atm") {
							$(".config2").hide();
						} else {
							$(".config").hide();
						}
						//移交、网控领导通过
						$("#transfer").show();
						$(".transfer1").hide();
						$("#transfer2").hide();
						$("#checktype").show();
						if ($.trim(role) == 'csLeader'
								|| $.trim(role) == 'atncLeader') {
							$("#submit").text("审批");
						} else if ($.trim(role) == 'csStaff') {
							$("#submit").text("办理");
						} else if ($.trim(role) == 'engineer') {
							if ($.trim(stat) == 'engineer_audit') {
								$("#submit").text("审核");
							} else {
								$("#submit").text("移交");
							}
						}
					}
				});
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>通信网退网处理</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<%@include file="innerDetail.jsp"%>
			<form:form modelAttribute="pageModel" id="solveForm" name="solveForm"
				action="${rootUrl }signoutnet/deal.do" method="POST">
				<form:hidden path="id" />
				<form:hidden path="pid" />
				<input type="hidden" id="stat" value="${signoutNet.approveStat}" />
				<input type="hidden" id="dealTypeNow" value="${signoutNet.dealType}" />
				<input type="hidden" id="role" value="${role}" />
				<div style="margin: 10px 20px 0px; padding: 0px">
					<dl class="title">
						<dd>通信网退网处理</dd>
					</dl>
				</div>
				<table width="96%">
					<c:if test="${fn:contains(role, '|csStaff|')}">
					</c:if>
					<c:if test="${fn:contains(role, '|csLeader|')}">
						<c:if test="${signoutNet.approveStat eq 'csleader_review'}">
							<tr>
								<th width="20%" align="right">请选择审批类别（客服审核）：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="approveStat" class="stat" value="1" />天航信内部流程通过 <form:radiobutton
										path="approveStat" class="stat" value="0" checked="checked" />天航信内部流程退回
								</td>
							</tr>
							<tr id="checktype">
								<th width="20%" align="right">退回给：<span style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="backUser" value="退回客服" checked="checked" />客服专员 <form:radiobutton
										path="backUser" value="退回网控" />网控领导 <form:radiobutton
										path="backUser" value="用印审批" />申请用户</td>
							</tr>
							<tr id="transfer2" style="display: none;">
								<th width="20%" align="right">请选择是否同意（用户申请）：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="agreeStat" class="apply" value="1" />同意用户申请 <form:radiobutton
										path="agreeStat" class="apply" value="0" checked="checked" />不同意用户申请
								</td>
							</tr>
						</c:if>
					</c:if>
					<c:if test="${fn:contains(role, '|atncLeader|')}">
						<c:if test="${signoutNet.approveStat eq 'atncleader_firstdeal'}">
							<tr class="transfer1">
								<th width="20%" align="right">请选择审核工程师：<span
									style="color: red">(*)</span></th>
								<td colspan="4"><form:select path="auditEngineer"
										cssStyle="width:35%">
										<form:option value="">请选择</form:option>
										<c:forEach var="e" items="${engineers}" varStatus="engineer">
											<form:option value="${e.id }">${e.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
						</c:if>
						<c:if test="${signoutNet.approveStat eq 'atncleader_review'}">
							<tr>
								<th width="20%" align="right">请选择审批类别：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="approveStat" class="stat" value="1" />天航信内部流程通过 <form:radiobutton
										path="approveStat" class="stat" value="0" checked="checked" />天航信内部流程退回
								</td>
							</tr>
							<tr id="transfer2" style="display: none;">
								<th width="20%" align="right">请选择是否同意(用户申请)：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="agreeStat" class="apply" value="1" />同意用户申请 <form:radiobutton
										path="agreeStat" class="apply" value="0" checked="checked" />不同意用户申请
								</td>
							</tr>
						</c:if>
						<c:if test="${signoutNet.approveStat eq 'atncleader_approve' }">
							<tr class="transfer1">
								<th width="20%" align="right">请选择配置工程师：<span
									style="color: red">(*)</span></th>
								<td colspan="4"><form:select path="engineer"
										cssStyle="width:35%">
										<form:option value="">请选择</form:option>
										<c:forEach var="e" items="${engineers}" varStatus="engineer">
											<form:option value="${e.id }">${e.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
						</c:if>
						<c:if test="${signoutNet.approveStat eq 'atncleader_audit' }">
							<tr class="transfer1">
								<th width="20%" align="right">请选择审核工程师：<span
									style="color: red">(*)</span></th>
								<td colspan="4"><form:select path="auditEngineer"
										cssStyle="width:35%">
										<form:option value="">请选择</form:option>
										<c:forEach var="e" items="${engineers}" varStatus="engineer">
											<form:option value="${e.id }">${e.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
						</c:if>
					</c:if>
					<c:if test="${fn:contains(role, '|netmanager|')}">
						<c:if test="${signoutNet.approveStat eq 'netmanager_approve' }">
							<tr id="transfer2">
								<th width="20%" align="right">请选择是否同意(用户申请)：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="agreeStat" class="apply" value="1" />同意用户申请 <form:radiobutton
										path="agreeStat" class="apply" value="0" checked="checked" />不同意用户申请
								</td>
							</tr>
						</c:if>
					</c:if>
					<c:if test="${fn:contains(role, '|manager|')}">
						<c:if test="${signoutNet.approveStat eq 'marketmanager_approve' }">
							<tr id="transfer2">
								<th width="20%" align="right">请选择是否同意(用户申请)：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="agreeStat" class="apply" value="1" />同意用户申请 <form:radiobutton
										path="agreeStat" class="apply" value="0" checked="checked" />不同意用户申请
								</td>
							</tr>
						</c:if>
					</c:if>
					<c:if test="${fn:contains(role, '|leader|')}">
						<c:if test="${signoutNet.approveStat eq 'leader_approve' }">
							<tr>
								<th width="20%" align="right">请选择审批类别：<span
									style="color: red">(*)</span></th>
								<td width="60%" colspan="4"><form:radiobutton
										path="approveStat" class="stat" value="1" />同意用户申请 <form:radiobutton
										path="approveStat" class="stat" value="0" checked="checked" />不同意用户申请
								</td>
							</tr>
						</c:if>
					</c:if>
					<c:if test="${fn:contains(role, '|fundmanager|')}">
					</c:if>
					<c:if test="${fn:contains(role, '|engineer|')}">
						<c:if
							test="${signoutNet.approveStat eq 'engineer_config' or signoutNet.approveStat eq 'assist_config'}">
							<tr>
								<th width="20%" align="right">请选择操作类别：<span
									style="color: red">(*)</span></th>
								<td colspan="4"><form:radiobutton path="approveStat"
										value="1" /><span>配置</span> <form:radiobutton
										path="approveStat" value="0" /><span>移交</span></td>
							</tr>
							<tr id="transfer" style="display: none">
								<th width="20%" align="right">请选择协助人：<span
									style="color: red">(*)</span></th>
								<td colspan="4"><form:select path="engineer"
										cssStyle="width:35%">
										<form:option value="">请选择</form:option>
										<c:forEach var="e" items="${engineers}" varStatus="engineer">
											<form:option value="${e.id }">${e.name }</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<c:choose>
								<c:when test="${signoutNet.dealType ne 'signoutnet_atm'}">
									<!-- ku卫星配置 -->
									<tr class="config">
										<th width="20%" align="right">请进行配置：<span
											style="color: red">(*)</span></th>
										<td>节点号</td>
										<td>0号载波中频频点</td>
										<td>射频发射频率</td>
										<td>射频接收频率</td>
									</tr>
									<tr class="config">
										<th width="20%" align="right">1</th>
										<td><input id="node" name="node" type="text"
											style="width: 130px;" /></td>
										<td><input id="mediumFrequency" name="mediumFrequency"
											type="text" style="width: 130px;" /></td>
										<td><input id="emissionFrequency"
											name="emissionFrequency" type="text" style="width: 130px;" /></td>
										<td><input id="receiveFrequency" name="receiveFrequency"
											type="text" style="width: 130px;" /></td>
									</tr>
									<!-- ku卫星配置结束 -->
								</c:when>
								<c:otherwise>
									<!-- 通信网退网配置 -->
									<tr class="config2">
										<td width="40%" colspan="2">ATM地址/广域网地址</td>
										<td width="60%" colspan="3"><input type="text"
											name="placeATM" id="placeATM" /></td>
									</tr>
									<tr class="config2">
										<td width="40%" colspan="2">ATM0地址/Loopback地址</td>
										<td width="60%" colspan="3"><input type="text"
											name="placeATMO" id="placeATMO" /></td>
									</tr>
									<tr class="config2">
										<td width="30%" colspan="1">中继连通性</td>
										<td width="30%" colspan="2"><input id="connectivity"
											name="connectivity" type="radio" value="1"
											style="width: 30px;" checked="checked" />正常 <input
											id="connectivity" name="connectivity" value="0" type="radio"
											style="width: 30px" />异常</td>
										<td width="40%" colspan="2">ATM节点中继的Pn端口状态为twoWayInside或IP节点中继端口状态为UP，视为连通性正常</td>
									</tr>
									<tr class="config2">
										<td width="30%" colspan="1">节点是否正常管理</td>
										<td width="30%" colspan="2"><input id="nodemng"
											name="nodemng" type="radio" value="1" style="width: 30px;"
											checked="checked" />正常 <input id="nodemng" name="nodemng"
											value="0" type="radio" style="width: 30px" />异常</td>
										<td width="40%" colspan="2">通过网管软件或其他网内设备能teInet节点并可以进行访问控制，视为管理正常</td>
									</tr>
									<tr class="config2">
										<td width="30%" colspan="1">配置备注：<span style="color: red">(*)</span></td>
										<td colspan="4"><textarea id="confRemark"
												name="confRemark" rows="4" style="width: 500px;"></textarea></td>
									</tr>
									<!-- 通信网退网配置结束 -->
								</c:otherwise>
							</c:choose>
						</c:if>
						<c:if test="${signoutNet.approveStat eq 'engineer_audit' }">
							<th width="20%" align="right">请选择审批类别：<span
								style="color: red">(*)</span></th>
							<td width="60%" colspan="4"><form:radiobutton
									path="approveStat" class="apply2" value="1" />天航信内部流程通过 <form:radiobutton
									path="approveStat" class="apply2" value="0" checked="checked" />天航信内部流程退回
							</td>
						</c:if>
					</c:if>
					<tr id="config">
						<th width="20%" align="right">备注：<span style="color: red">(*)</span></th>
						<td colspan="4"><form:textarea id="approveRemark"
								path="approveRemark" rows="8" style="width:500px;resize:none;" /></td>
					</tr>
				</table>
				<div class="boxbtn">
					<div class="btn">
						<c:choose>
							<c:when test="${role == 'csStaff' }">
								<a href="#none" id="submit">办理</a>
							</c:when>
							<c:when test="${role == 'engineer' }">
								<c:choose>
									<c:when
										test="${signoutNet.approveStat eq 'engineer_firstaudit' or signoutNet.approveStat eq 'engineer_audit'}">
										<a href="#none" id="submit">审核</a>
									</c:when>
									<c:otherwise>
										<a href="#none" id="submit">配置</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when
										test="${signoutNet.approveStat eq 'fundmanager_confirm'}">
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