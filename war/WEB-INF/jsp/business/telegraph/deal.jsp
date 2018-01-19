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
				atncRountAddr : {
					required : true,
					rangelength : [ 7, 15 ]
				},
				atncConfigPeople : {
					required : true,
					maxlength : 12
				},
				atncConnectionCondition : {
					required : true
				},
				allocatedAddr : {
					required : true,
					rangelength : [ 7, 15 ]
				},
				operTime : {
					required : true
				},
				connectionCondition : {
					required : true,
					maxlength : 13
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
			$("#solveForm").trigger("submit");
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
		
		$(".stat").click(function() {
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
			
		var status = $("#status").val();	//角色名
		if($.trim(status) == $.trim("assist_config")) {
			$("input[name='approveStat']").each(function(i){
				var $this = $(this);
				if($this.val() == '0') {
					var span = $this.next("span")[0];
					span.remove();
					$this.attr("style","display: none;");
				}
			});
		}
		
        var stat = $("#stat").val();
		
		if($.trim(stat) == 'fundmanager_confirm'){
			$("#submit").text("确认");
			$("#approveRemark").val("确认");
		}
		
		if($.trim(stat) == 'generalmanager_approve'){
			$("#approveRemark").val("");
		}
		
		if($.trim(stat) == 'atnc_test'){
			$("#submit").text("测试完成");
			$(".boxbtn").attr("style","width:120px");
		}
		
		$(":radio[name='approveStat']").click(function(){
			var operType = $(this).val();
			var name = $(this).attr("name");	
			var role = $("#role").val();	//角色名
			var status = $("#status").val();	//当前任务状态

			if($.trim(status) == 'csleader_review'){
				if(operType == 1){
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
				}
			}
			if(operType == 1){
				//同意或配置
				$(".config").show();
				$("#transfer2").show();
				$(".config2").show();
				$("#checktype").hide();
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
					$(".config2").show();
					if($.trim(status) == 'engineer_audit') {
						$("#submit").text("审核");
					} else {
						$("#submit").text("配置");
					}
				} 
			} else{
				//退回或移交
				$("#transfer2").hide();
				$(".config").show();
				$(".config2").hide();
				$("#checktype").show();
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
					if($.trim(status) == 'engineer_audit') {
						$("#submit").text("审核");
					} else {
						$(".config2").hide();
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
				<dd>转报地址处理</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
				<%@include file="innerDetail.jsp"%>
				<form:form modelAttribute="pageModel" id="solveForm" name="solveForm"
					action="${rootUrl }telegraph/deal.do" method="post">
					<form:hidden path="id"/>
					<form:hidden path="pid" />
					<div style="margin: 10px 20px 0px;padding:0px">
					<dl class="title">
						<dd>转报地址处理</dd>
					</dl>
					</div>
					<table width="96%">
						<input id="role" type="hidden" value="${role}" />
						<input id="status" type="hidden" value="${teleGraph.approveStat }" />
						<input type="hidden" id="stat" value="${teleGraph.approveStat}" />
						<%--审核的工程师 --%>
						<input id="lastUser" name="lastUser" type="hidden" value="${lastUser}" />
							<c:if test="${fn:contains(role, '|csStaff|')}">
								<c:if test="${teleGraph.approveStat eq 'csstaff_audit' }">
									<tr>
										<td width="15%">序号</td>
										<td width="10%">使用地点</td>
										<td width="20%">申请时间</td>
										<td width="15%">期望启用时间</td>
										<c:choose>
											<c:when test="${teleGraphApplys[0].teleGraph.teleApplyType.value == '新增'}">
												<td width="15%">地址</td>
											</c:when>
											<c:otherwise>
												<td width="15%">原地址(变更/注销时填写)</td>
											</c:otherwise>
										</c:choose>
										<td width="15%">终端连接情况(本地空管/SITA/其他)</td>
										<td width="15%">申请用途</td>
									</tr>
									<c:forEach items="${teleGraphApplys}" var="t" varStatus="status">
										<tr>
											<td width="15%">${t.identify}</td>
											<td width="10%">${t.userArea}</td>
											<td width="20%"><fmt:formatDate	value="${t.applyTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td width="15%"><fmt:formatDate	value="${t.useTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<c:choose>
												<c:when test="${t.teleGraph.addressType.value eq '8X' and t.teleGraph.teleApplyType eq 'create'}">
													<td width="15%">
														<input id="originalAddr" name="originalAddr" type="text" style="width: 150px;"/>
													</td>
												</c:when>
												<c:otherwise>
													<td width="15%">${t.originalAddr}</td>
												</c:otherwise>
											</c:choose>
											<td width="15%">${t.connection.value}</td>
											<td width="15%">${t.usage.value}</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${teleGraph.approveStat eq 'csstaff_deal' and not empty bureaus}">
									<tr>
										<th width="20%" align="right">请选择需要跨区配置的管局：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:checkboxes items="${bureaus}" path="bureau" delimiter="&nbsp"/>
										</td>
									</tr>
								</c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|csLeader|')}">
								<c:if test="${teleGraph.approveStat eq 'csleader_review'}">
									<tr>
										<th width="20%" align="right">请选择审批类别（客服审核）：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="approveStat" value="1"/>天航信内部流程通过
											<form:radiobutton path="approveStat" value="0" checked="checked"/>天航信内部流程退回
										</td>
									</tr>
									<tr id="checktype">
										<th width="20%" align="right">退回给：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="backUser" value="退回客服" checked="checked" />客服专员
											<form:radiobutton path="backUser" value="用印审批"/>申请用户
										</td>
									</tr>
									<tr id="transfer2" style="display: none;">
										<th width="20%" align="right">请选择是否同意（用户申请）：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="agreeStat" class="apply" value="1"/>同意用户申请
											<form:radiobutton path="agreeStat" class="apply" value="0" checked="checked"/>不同意用户申请
										</td>
									</tr>
									<%-- <tr id="transfer2">
										<th width="20%" align="right">请选择客服专员：<span style="color: red">(*)</span></th>
											<td colspan="6">
												<form:select path="csStaff" cssStyle="width:35%">
													<form:option value="">请选择</form:option>
													<c:forEach var="e" items="${csStaffs}" varStatus="engineer">
														<form:option value="${e.id }">${e.name }</form:option>
													</c:forEach>
												</form:select>
											</td>
										</th>
									</tr> --%>
								</c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|manager|')}">
								<c:if test="${teleGraph.approveStat eq 'generalmanager_approve'}">
									<tr>
										<th width="20%" align="right">请选择审批类别：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="approveStat" class="stat" value="1"/>同意用户申请
											<form:radiobutton path="approveStat" class="stat" value="0" checked="checked"/>不同意用户申请
										</td>
									</tr>
								</c:if>
							</c:if>
							<c:if test="${fn:contains(role, '|fundmanager|')}">
							</c:if>
							<c:if test="${fn:contains(role, '|atncLeader|')}">
								<c:if test="${teleGraph.approveStat eq 'atncleader_approve'}">
									<tr class="transfer">
										<th width="20%" align="right">请选择配置工程师：<span style="color: red">(*)</span></th>
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
								<c:if test="${teleGraph.approveStat eq 'atncleader_audit'}">
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
							</c:if>
							<c:if test="${fn:contains(role, '|engineer|')}">
								<c:if test="${teleGraph.approveStat eq 'engineer_config' or teleGraph.approveStat eq 'assist_config'}">
									<tr>
										<th width="20%" align="right">请选择操作类别：<span style="color: red">(*)</span></th>
										<td colspan="6">
											<form:radiobutton path="approveStat" value="1"/><span>配置</span>
											<form:radiobutton path="approveStat" value="0"/><span>移交</span>
										</td>
									</tr>
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
									<tr class="config2">
										<th width="20%" align="right">请进行配置：<span style="color: red">(*)</span></th>
										<td colspan="3">路由地址</td>
										<td colspan="2">配置人</td>
										<td>终端连接情况</td>
									</tr>
									<c:forEach items="${teleGraphApplys}" var="t" varStatus="status">
										<tr class="config2">
											<td width="15%">
												${t.identify}
												<input id="identifier" name="identifier" type="hidden" value="${t.identify}"/>
											</td>
											<td width="15%" colspan="3">
												<input id="atncRountAddr" name="atncRountAddr" type="text" style="width: 150px;"/>
											</td>
											<td width="20%" colspan="2">
												<input id="atncConfigPeople" name="atncConfigPeople" type="text" readonly="readonly"
												style="width: 150px;" value="${user.name}"/>
											</td>
											<td width="15%">
												<input id="atncConnectionCondition" name="atncConnectionCondition" type="text" readonly="readonly"
												style="width: 150px;" value="${t.connection.value}"/>
											</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${teleGraph.approveStat == 'atnc_test'}">
										<tr class="config2">
											<th width="20%" align="right">请进行配置：<span style="color: red">(*)</span></th>
											<td colspan="3">分配的通信路由地址</td>
											<td colspan="2">经办人</td>
										</tr>
										<c:forEach items="${teleGraphApplys}" var="t" varStatus="status">
											<tr class="config2">
												<td width="15%">
													${t.identify}
												</td>
												<td width="15%" colspan="3">
													<c:choose>
														<c:when test="${t.teleGraph.teleApplyType eq 'create' and t.teleGraph.addressType eq'E8X' }">
															<input id="allocatedAddr" name="allocatedAddr" type="text" value="${t.allocatedAddr }"
															readonly="readonly" style="width: 150px;" />
														</c:when>
														<c:otherwise>
															<input id="allocatedAddr" name="allocatedAddr" type="text" value="${teleGraphConfigs[status.index].atncRountAddr }"
															readonly="readonly" style="width: 150px;" />	
														</c:otherwise>
													</c:choose>
												</td>
												<td width="20%" colspan="2">
													<input id="operPeople" name="operPeople" type="text" readonly="readonly"
													style="width: 150px;" value="${user.name}"/>
												</td>
												<%-- <td width="20%" colspan="3">
													<input style="width: 120px" id='operTime'
													name='operTime' class="inputDate" readonly="readonly"
													onfocus="WdatePicker({el:$dp.$('atncConfigTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('atncConfigTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'}});"
														style="cursor: pointer;" />
												</td> --%>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${teleGraph.approveStat eq 'engineer_audit' }">
										<th width="20%" align="right">请选择审批类别：<span style="color: red">(*)</span></th>
										<td width="60%" colspan="6">
											<form:radiobutton path="approveStat" class="apply2" value="1"/>天航信内部流程通过
											<form:radiobutton path="approveStat" class="apply2" value="0" checked="checked"/>天航信内部流程退回
										</td>
									</c:if>
							</c:if>
						<tr class="config">
							<th width="20%" align="right">备注：<span style="color: red">(*)</span></th>
							<td colspan="6">
								<form:textarea id="approveRemark" path="approveRemark" rows="8" style="width:500px;resize:none;"/>
							</td>
						</tr>
					</table>
					<div class="boxbtn">
						<div class="btn">
							<c:choose>
								<c:when test="${role == 'csStaff' }">
									<c:choose>
										<c:when test="${teleGraph.approveStat eq 'csstaff_audit'}">
											<a href="#none" id="submit">审核</a>
										</c:when>
										<c:otherwise>
											<a href="#none" id="submit">办理</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${role == 'engineer' }">
									<c:choose>
										<c:when test="${teleGraph.approveStat eq 'engineer_audit'}">
											<a href="#none" id="submit">审核</a>
										</c:when>
										<c:otherwise>
											<a href="#none" id="submit">配置</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${teleGraph.approveStat eq 'fundmanager_confirm'}">
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