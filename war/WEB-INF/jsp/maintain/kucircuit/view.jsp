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
<body style="overflow-x:hidden">
	<div class="window">
		<dl class="title">
			<dd>KU业务管理--查看</dd>
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
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">KU业务信息</th>
				</tr>
				<tr>
					<th width="20%">区域</th>
					<td width="30%">${pageModel.kuService.bureau.value}</td>
					<th width="20%">电路名</th>
					<td width="30%">${pageModel.kuService.code}</td>
				</tr>
				<tr>
					<th width="20%">PAMA/DAMA</th>
					<td width="30%">${pageModel.kuService.circuitType}</td>
					<th width="20%">电路类型</th>
					<td width="30%">${pageModel.kuService.circuitTypeDetail}</td>
				</tr>
				<tr>
					<th width="20%">电路速率</th>
					<td width="30%">${pageModel.kuService.rateType.value}</td>
					<th width="20%">配置时间</th>
					<td width="30%">${pageModel.kuService.configTime}</td>
				</tr>
				<tr>
					<th width="20%">发端节点名</th>
					<td width="30%">${fn:escapeXml(pageModel.kuService.txNode.kuNodeCode )}</td>
					<th width="20%">收端节点名</th>
					<td width="30%">${fn:escapeXml(pageModel.kuService.rxNode.kuNodeCode)}</td>
				</tr>
				<tr>
					<th width="20%">发端节点号</th>
					<td width="30%">${fn:escapeXml(pageModel.kuService.txNode.kuNodeNo )}</td>
					<th width="20%">收端节点号</th>
					<td width="30%">${fn:escapeXml(pageModel.kuService.rxNode.kuNodeNo)}</td>
				</tr>
				<tr>
					<th width="20%">发端槽号</th>
					<td width="30%">${pageModel.kuService.txGib}</td>
					<th width="20%">收端槽号</th>
					<td width="30%">${pageModel.kuService.rxGib}</td>
				</tr>
				<tr>
					<th width="20%">发端端口</th>
					<td width="30%">${pageModel.kuService.txChan}</td>
					<th width="20%">收端端口</th>
					<td width="30%">${pageModel.kuService.rxChan}</td>
				</tr>
				<tr>
					<th width="20%">纠错</th>
					<td width="30%">${pageModel.kuService.fec}</td>
					<th width="20%">业务类型</th>
					<td width="30%">${pageModel.kuService.serviceType}</td>

				</tr>

				<tr>
					<th width="20%">载波</th>
					<td width="30%">${pageModel.kuService.cxr}</td>
					<th width="20%">起始点</th>
					<td width="30%">${pageModel.kuService.start}</td>
				</tr>
				<tr>
					<th width="20%">修改人</th>
					<td width="30%">${pageModel.kuService.optUser.name}</td>
					<th width="20%">修改时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.kuService.optTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
				    <th width="20%">设备名称</th>
					<td width="30%">${pageModel.equip.name}</td>
					<th width="20%">记录时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.kuService.recordTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th width="20%">用户备注</th>
					<td colspan="3">${pageModel.kuService.clientInfo}</td>
				</tr>
				<tr>
					<th width="20%">电路情况</th>
					<td colspan="3">${pageModel.kuService.circuitInfo}</td>
				</tr>
				<tr>
					<th width="20%">使用情况</th>
					<td colspan="3">${pageModel.kuService.usage}</td>
				</tr>
				<tr>
					<th width="20%">CRM情况</th>
					<td colspan="3">${pageModel.kuService.crm}</td>
				</tr>
				<tr>
					<th width="20%">收端信息</th>
					<td colspan="3">${pageModel.kuService.memo}</td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.kuService.info}</td>
				</tr>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>