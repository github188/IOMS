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
			<dd>ATM业务管理--查看</dd>
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
						style="color: gray; width: 100%; text-align: center;">ATM业务信息</th>
  </tr>
				<tr>
				  <th colspan="2">业务名称：<font color="black">${fn:escapeXml(pageModel.serviceName)}</font></th>
  				  <th colspan="2">业务类型：<font color="black">${pageModel.atmType.serviceType}</font></th>
  				  
  </tr>
				<tr>
				  <th colspan="2">本地节点</th>
				  <th colspan="2">远端节点</th>
  </tr>
				<tr>
					<th width="20%">节点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.localNode.atmNodeCode )}</td>
					<th width="20%">节点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.remoteNode.atmNodeCode)}</td>
				</tr>
				<tr>
					<th width="20%">端口号</th>
					<td width="30%">${pageModel.localPort}</td>
					<th width="20%">端口号</th>
					<td width="30%">${pageModel.remotePort}</td>
				</tr>
				<tr>
					<th width="20%">端口速率（kbps）</th>
					<td width="30%">${pageModel.localPortCir}</td>
					<th width="20%">端口速率（kbps）</th>
					<td width="30%">${pageModel.remotePortCir}</td>
				</tr>

				<tr>
					<th width="20%">端口时钟类型</th>
					<td width="30%">${pageModel.localPortClockType}</td>
					<th width="20%">端口时钟类型</th>
					<td width="30%">${pageModel.remotePortClockType}</td>
				</tr>
				<tr>
					<th width="20%">dlci/ vpi.vci</th>
					<td width="30%">${pageModel.localPortDLCIVPIVCI}</td>
					<th width="20%">dlci/ vpi.vci</th>
					<td width="30%">${pageModel.remotePortDLCIVPIVCI}</td>
				</tr>
				<tr>
					<th width="20%">接入设备</th>
					<td width="30%">${pageModel.localConnEquip}</td>
					<th width="20%">接入设备</th>
					<td width="30%">${pageModel.remoteConnEquip}</td>
				</tr>
				<tr>
					<th width="20%">速率（kbps）</th>
					<td colspan="1">${pageModel.serviceCir}</td>
					<th width="20%">采集状态</th>
					<td colspan="1">${pageModel.serviceChangeType.value}</td>
				</tr>
				<tr>
					<th width="20%">服务等级</th>
					<td colspan="3">${pageModel.serviceClass}</td>
				</tr>
				<tr>
					<th width="20%">有/无备用</th>
					<td colspan="3">${pageModel.serviceStandbyInfo}</td>
				</tr>
				<tr>
					<th width="20%">电路主备关系说明</th>
					<td colspan="3">${pageModel.serviceMsInfo}</td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.serviceRemark}</td>
				</tr>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>