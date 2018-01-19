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
<body style="overflow-x: hidden">
	<div class="window">
		<dl class="title">
			<dd>TES业务管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;">
		</div>

		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">TES业务信息</th>
				</tr>

				<tr>
					<th width="20%">电路名</th>
					<td colspan="3">${pageModel.circuitName}</td>
				</tr>
				<tr>
					<th width="20%">主叫端站点名称</th>
					<td width="30%">${fn:escapeXml(pageModel.activeNode.equip.satellite.siteName)}</td>
					<th width="20%">被叫端站点名称</th>
					<td width="30%">${fn:escapeXml(pageModel.passiveNode.equip.satellite.siteName)}</td>
				</tr>
				<tr>
					<th width="20%">主叫端站点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.activeNode.equip.satellite.siteCode)}</td>
					<th width="20%">被叫端站点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.passiveNode.equip.satellite.siteCode)}</td>
				</tr>
				<tr>
					<th width="20%">主叫端机箱号</th>
					<td width="30%">${fn:escapeXml(pageModel.activeNode.tesNodeCode)}</td>
					<th width="20%">被叫端机箱号</th>
					<td width="30%">${fn:escapeXml(pageModel.passiveNode.tesNodeCode)}</td>
				</tr>
				<tr>
					<th width="20%">主叫端槽位号</th>
					<td width="30%">${pageModel.activeSlot}</td>
					<th width="20%">被叫端槽位号</th>
					<td width="30%">${pageModel.passiveSlot}</td>
				</tr>
				
				<tr>
					<th width="20%">同异步</th>
					<td width="30%">${pageModel.sync}</td>
					
					<th width="20%">电路速率(kbps)</th>
					<td width="30%">${pageModel.rate}</td>
					
				</tr>
					<tr>					
					<th width="20%">频带池</th>
					<td colspan="3">${pageModel.bandWidthPool}</td>
				</tr>
				<tr>
					<th width="20%">收端信息</th>
					<td colspan="3">${pageModel.serviceMemo}</td>
				</tr>
				<tr>
					<th width="20%">配置用户</th>
					<td width="30%">${pageModel.optUser.name}</td>
					<th width="20%">配置时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.optTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<th width="20%">用户备注</th>
					<td colspan="3">${pageModel.clientInfo}</td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.info}</td>
				</tr>
			</table>
			
		</div>
		<br />
		<!-- end 详情内容-->
	</div>
</body>
</html>