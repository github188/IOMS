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
			<dd>电路配置明细--TES话音--查看</dd>
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
					<td colspan="5" style="text-align: left;">${tempCircuit.applyCompany}</td>
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
					<th>发端节点:</th>
					<td style="text-align: left;" colspan="3">${tempCircuit.aEquip.name}</td>
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
						<th>节点名称:</th>
						<td colspan="5" style="text-align: left;">${fn:escapeXml(tempcircuitDetail.name)}</td>
					</tr>
					<tr>
						<th>机箱号:</th>
						<td colspan="2" style="text-align: left;">${fn:escapeXml(tempcircuitDetail.boxNumber)}</td>
						<th>槽位号:</th>
						<td colspan="2" style="text-align: left;">${tempcircuitDetail.slotNumber}</td>
					</tr>
					<tr>
						<th>电话号码:</th>
						<td colspan="2" style="text-align: left;">${tempcircuitDetail.teleNumber}</td>
						<th>频带池:</th>
						<td colspan="2" style="text-align: left;">${tempcircuitDetail.freqPool}</td>
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