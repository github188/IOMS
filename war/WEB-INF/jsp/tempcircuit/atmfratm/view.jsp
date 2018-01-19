<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />

<script>
	$(function() {
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>业务开通明细--FR/ATM--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<!--begin 详情内容-->
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="6"
						style="color: gray; width: 100%; text-align: center;">电路申请信息</th>
				</tr>
				<tr>
					<th>申请单位:</th>
					<td colspan="5">${tempCircuit.applyCompany}</td>
				</tr>
				<tr>
					<th width="15%">联系人:</th>
					<td style="text-align: left;" width="25%">${tempCircuit.linkMan}</td>
					<th width="15%">联系人电话:</th>
					<td style="text-align: left;" width="25%">${tempCircuit.linkPhone}</td>
					<th width="15%">联系人Email:</th>
					<td style="text-align: left;" width="25%">${tempCircuit.linkEmail}</td>
				</tr>
				<tr>
					<th>电路类型：</th>
					<td style="text-align: left;">${tempCircuit.circuitType.name}</td>
					<th>计划开通时间:</th>
					<td style="text-align: left;"><fmt:formatDate
							value="${tempCircuit.planOpenTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
					<th>电路到期时间:</th>
					<td style="text-align: left;"><fmt:formatDate
							value="${tempCircuit.planEndTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<th>申请时间:</th>
					<td style="text-align: left;"><fmt:formatDate
							value="${tempCircuit.recordTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
					<th>本端节点:</th>
					<td style="text-align: left;">${tempCircuit.aEquip.code}</td>
					<th>对端节点:</th>
					<td style="text-align: left;">${tempCircuit.zEquip.code}</td>
				</tr>
				<tr>
					<th>备注信息：</th>
					<td colspan="5" style="text-align: left;"><textarea
							style="width: 100%" rows="5">${tempCircuit.circuitInfo}</textarea></td>
				</tr>
				<c:if
					test="${tempCircuit.circuitStatus == 'DONE' || tempCircuit.circuitStatus == 'ACKDELETED'}">
					<tr>
						<th colspan="6"
							style="color: gray; width: 100%; text-align: center;">电路明细信息</th>
					</tr>
					<tr>
						<th>业务名称:</th>
						<td colspan="5" style="text-align: left;">${fn:escapeXml(tempcircuitDetail.businessName)}</td>
					</tr>
					<tr>
						<th>本端节点:</th>
						<td colspan="5" style="text-align: left;">${tempcircuitDetail.localNodeName}</td>
					</tr>
					<tr>
						<th>本端槽位号:</th>
						<td style="text-align: left;">${tempcircuitDetail.localNodeSlot}</td>
						<th>本端端口号:</th>
						<td style="text-align: left;">${tempcircuitDetail.localNodePort}</td>
						<th>本端端口速率（kbps）:</th>
						<td style="text-align: left;">${tempcircuitDetail.localNodePortRate}</td>
					</tr>
					<tr>
						<th>对端节点:</th>
						<td colspan="5" style="text-align: left;">${tempcircuitDetail.oppositeNodeName}</td>
					</tr>
					<tr>
						<th>对端槽位号:</th>
						<td style="text-align: left;">${tempcircuitDetail.oppositeNodeSlot}</td>
						<th>对端端口号:</th>
						<td style="text-align: left;">${tempcircuitDetail.oppositeNodePort}</td>
						<th>对端端口速率（kbps）:</th>
						<td style="text-align: left;">${tempcircuitDetail.oppositeNodePortRate}</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<th>QoS类型:</th>
						<td colspan="2" style="text-align: left;">${tempcircuitDetail.qosType}</td>
						<th>业务速率:</th>
						<td colspan="2" style="text-align: left;">${tempcircuitDetail.businessRate}</td>
					</tr>
					<tr>
						<th>备注信息:</th>
						<td colspan="5" style="text-align: left;"><textarea
								style="width: 100%" rows="10">${tempcircuitDetail.remark}</textarea></td>
					</tr>
				</c:if>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
		<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="closeButton">关闭</a>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
	</div>
</body>
</html>