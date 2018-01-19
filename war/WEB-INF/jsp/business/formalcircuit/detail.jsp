<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css"/>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
	
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		$.ajaxSetup({
			cache : false
		});
		
		$(".close").click(function(){
			parent.$.nyroModalRemove();
		});
		
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
		if(applyType == "ATM正式电路"){
			$("#atm1").show();
			$("#atm2").show();
			$("#atm3").show();
			if(applyOpttype == "变更"){
				$("#atm4").show();
			}
		}
		if(applyType == "KU正式电路"){
			$("#ku1").show();
			$("#ku2").show();
			$("#ku3").show();
			if(applyOpttype == "变更"){
				$("#ku4").show();
			}
		}
		if(applyType == "TES正式电路"){
			$("#tes1").show();
			$("#tes2").show();
			$("#tes3").show();
			if(applyOpttype == "变更"){
				$("#tes4").show();
			}
		}
		if(applyType == "PES正式电路"){
			$("#pes1").show();
			$("#pes2").show();
			$("#pes3").show();
			if(applyOpttype == "变更"){
				$("#pes4").show();
			}
		}
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>正式电路申请信息详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<%@include file="innerDetail.jsp"%>
		</div>
			<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="close">关闭</a>
			</div>
		</div>
		<br></br>
	</div>
<%-- 	<form:form modelAttribute="pageModel" id="modForm" name="modForm">
		<div class="window">
			<dl class="title">
				<dd>正式电路申请信息详情</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<br />
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
			<input type="hidden" id="applyOpttype" value="${m.formalCircuit.applyOpttype.value}"/>
		            <input type="hidden" id="applyType" value="${m.formalCircuit.applyBaseInfo.applyType.value}"/>
				<table id="tb_desc" width="100%">
						<tr>
							<td width="15%" colspan="2">申请单位：</td>
							<td width="30%" colspan="4">${m.formalCircuit.applyBaseInfo.applyCom}</td>
							<td width="15%" colspan="2">联系人/联系电话：</td>
							<td width="40%" colspan="5">${m.formalCircuit.applyBaseInfo.applyLinkman}/${m.formalCircuit.applyBaseInfo.applyPhone}</td>
						</tr>
						<tr>
							<td width="15%" colspan="2">申请类型：</td>
							<td width="30%" colspan="4">${m.formalCircuit.applyOpttype.value}</td>
							<td width="15%" colspan="2">申请单位签字/盖章：</td>
							<td width="40%" colspan="5">${m.formalCircuit.applySign}</td>
						</tr>
						<tr>
							<td width="15%" colspan="2">任务名称：</td>
							<td width="30%" colspan="4">${m.formalCircuit.taskName}</td>
							<td width="15%" colspan="2">申请时间：</td>
							<td width="40%" colspan="5"><fmt:formatDate value="${m.formalCircuit.applyBaseInfo.applyTime.time}"
												type="date" pattern="yyyy-MM-dd" /></td>
						</tr>
						<c:choose>
						<c:when test="${not empty formalCircuitATMs && m.formalCircuit.applyBaseInfo.applyType.value =='ATM正式电路'}">
							<tr id="atm1">
				            <td width="7%" rowspan="2" class="t_title">编号</td>
				            <td width="7%" rowspan="2" class="t_title">业务名称</td>
				            <td width="30%" colspan="4" class="t_title" style="text-align: center">本端参数</td>
				            <td width="30%" colspan="4" class="t_title" style="text-align: center">对端参数</td>
				            <td width="7%" rowspan="2" class="t_title">电路速率</td>
				            <td width="7%" rowspan="2" class="t_title">服务类型</td>
				            <td width="7%" rowspan="2" class="t_title">开通时间</td>
			             </tr>
			             <tr id="atm2">
				            <td width="7%" class="t_title">节点名称</td>
				            <td width="7%" class="t_title">端口号</td>
				            <td width="7%" class="t_title">端口速率</td>
				            <td width="7%" class="t_title">VPI.VCI或DLC</td>
				            <td width="7%" class="t_title">节点名称</td>
				            <td width="7%" class="t_title">端口号</td>
				            <td width="7%" class="t_title">端口速率</td>
				            <td width="7%" class="t_title">VPI.VCI或DLC</td>
			             </tr>
							<c:forEach items="${formalCircuitATMs}" var="formalCircuitATM"> 
							<tr>
							 <td>${formalCircuitATM.identifier}</td>
			                 <td>${formalCircuitATM.businessName}</td>
			                 <td>${formalCircuitATM.txNodeName}</td>
			                 <td>${formalCircuitATM.txPort}</td>
			                 <td>${formalCircuitATM.txPortSpeed}</td>
			                 <td>${formalCircuitATM.txVpiDlci}</td>
			                 <td>${formalCircuitATM.rxNodeName}</td>
			                 <td>${formalCircuitATM.rxPort}</td>
			                 <td>${formalCircuitATM.rxPortSpeed}</td>
			                 <td>${formalCircuitATM.rxVpiDlci}</td>
			                 <td>${formalCircuitATM.circuitSpeed}</td>
			                 <td>${formalCircuitATM.serviceType}</td>
			                 <td><fmt:formatDate value="${formalCircuitATM.openTime.time}"
												type="date" pattern="yyyy-MM-dd" /></td>
							</tr>
							</c:forEach>
									</c:when>
						</c:choose>
						<c:choose>
						<c:when test="${not empty formalCircuitKUs && m.formalCircuit.applyBaseInfo.applyType.value =='KU正式电路'}">
							 <tr id="ku1">
				             <td width="7%" rowspan="2" class="t_title">编号</td>
				             <td width="7%" rowspan="2" colspan="2" class="t_title">业务名称</td>
				             <td width="30%" colspan="3" class="t_title" style="text-align: center">本端参数</td>
				             <td width="30%" colspan="3" class="t_title" style="text-align: center">对端参数</td>
				             <td width="7%" rowspan="2" class="t_title">电路速率</td>
				             <td width="7%" rowspan="2" class="t_title">通信方式</td>
				             <td width="7%" rowspan="2" colspan="2" class="t_title">开通时间</td>
			             </tr>
			             <tr id="ku2">
				             <td width="7%" class="t_title">站点名</td>
				             <td width="7%" class="t_title">机箱号</td>
				             <td width="7%" class="t_title">槽位号</td>
				             <td width="7%" class="t_title">站点名</td>
				             <td width="7%" class="t_title">机箱号</td>
				             <td width="7%" class="t_title">槽位号</td>
			             </tr> 
							<c:forEach items="${formalCircuitKUs}" var="formalCircuitKU"> 
							<tr>
							 <td>${formalCircuitKU.identifier}</td>
			                 <td  colspan="2">${formalCircuitKU.businessName}</td>
			                 <td>${formalCircuitKU.txNodeNum}</td>
			                 <td>${formalCircuitKU.txSlotNum}</td>
			                 <td>${formalCircuitKU.txPortNum}</td>
			                 <td>${formalCircuitKU.rxNodeNum}</td>
			                 <td>${formalCircuitKU.rxSlotNum}</td>
			                 <td>${formalCircuitKU.rxPortNum}</td>
			                 <td>${formalCircuitKU.circuitSpeed}</td>
			                 <td>${formalCircuitKU.communicateWay.value}</td>
			                 <td  colspan="2"><fmt:formatDate value="${formalCircuitKU.openTime.time}"
												type="date" pattern="yyyy-MM-dd" /></td>
							</tr>
							</c:forEach>
									</c:when>
						</c:choose>
						<c:choose>
						<c:when test="${not empty formalCircuitTESs && m.formalCircuit.applyBaseInfo.applyType.value =='TES正式电路'}">
							 <tr id="tes1">
				             <td width="7%" rowspan="2" class="t_title">编号</td>
				             <td width="7%" rowspan="2" colspan="2" class="t_title">业务名称</td>
				             <td width="30%" colspan="3" class="t_title" style="text-align: center">本端参数</td>
				             <td width="30%" colspan="3" class="t_title" style="text-align: center">对端参数</td>
				             <td width="7%" rowspan="2" class="t_title">电路速率</td>
				             <td width="7%" rowspan="2" class="t_title">通信方式</td>
				             <td width="7%" rowspan="2" colspan="2" class="t_title">开通时间</td>
			             </tr>
			             <tr id="tes2">
				             <td width="7%" class="t_title">节点号</td>
				             <td width="7%" class="t_title">槽位号</td>
				             <td width="7%" class="t_title">端口号</td>
				             <td width="7%" class="t_title">节点号</td>
				             <td width="7%" class="t_title">槽位号</td>
				             <td width="7%" class="t_title">端口号</td>
			             </tr>
							<c:forEach items="${formalCircuitTESs}" var="formalCircuitTES"> 
							<tr>
							 <td>${formalCircuitTES.identifier}</td>
			                 <td colspan="2">${formalCircuitTES.businessName}</td>
			                 <td>${formalCircuitTES.txSiteName}</td>
			                 <td>${formalCircuitTES.txCaseNum}</td>
			                 <td>${formalCircuitTES.txSlotNum}</td>
			                 <td>${formalCircuitTES.rxSiteName}</td>
			                 <td>${formalCircuitTES.rxCaseNum}</td>
			                 <td>${formalCircuitTES.rxSlotNum}</td>
			                 <td>${formalCircuitTES.circuitSpeed}</td>
			                 <td>${formalCircuitTES.communicateWay.value}</td>
			                 <td colspan="2">
			                 <fmt:formatDate value="${formalCircuitTES.openTime.time}"
												type="date" pattern="yyyy-MM-dd" /></td>
							</tr>
							</c:forEach>
									</c:when>
						</c:choose>
			              <tr>
							<td width="15%" colspan="2">申请备注：</td>
							<td width="85%" colspan="11">${m.formalCircuit.applyRemark}</td>
						</tr>
			 		</table>
				<div id="tabs" style="margin: 10px 20px 0px;padding:0px">
					<ul>
						<li><a href="#tabs-2">审批详情</a></li>
					</ul>
					<div id="tabs-2">
						<table width="100%" style="margin:0px auto">
							<tbody>
								<c:choose>
									<c:when test="${approveInfos.size()!=0}">
										<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
											<tr>
												<th width="100%" style="text-align: left;">
													<fmt:formatDate	value="${vo.approveTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
													<span style="font-weight:bolder;font-size: 13px">&nbsp;公司:</span>${vo.company==null?'无':vo.company }<span style="font-weight:bolder;font-size: 13px">&nbsp;审批人:</span>${vo.username }
													<span style="font-weight:bolder;font-size: 13px">&nbsp;审批类别:</span>${vo.approveType.value }		
												</th>
											</tr>
											<tr>
												<td width="100%" style="height: auto; text-align: left;">
													${vo.approveRemark}
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<th width="100%" style="text-align:center;">还没有审批信息！</th>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form:form> --%>
</body>
</html>