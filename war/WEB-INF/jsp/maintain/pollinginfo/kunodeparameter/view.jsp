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
			<dd>Modem板卡详情--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->		

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
	<table id="dataTable" width="100%" border="0" cellspacing="0"
	       cellpadding="2" class="tablesorter">
	            <tr>
				<th colspan="12"
						style="color: gray; width: 100%; text-align: center;">Modem板卡详情</th>
				</tr>
				<tr>
					<th width="30%">Node Number：</th>
					<td width="20%">${fn:escapeXml(pageModel.nodeNumber)}</td>
					<th width="30%">Bit Rate：</th>
					<td width="20%">${fn:escapeXml(pageModel.bitRate)} bps</td>
				</tr>
				<tr>
					<th width="30%">Node Name：</th>
					<td width="20%">${fn:escapeXml(pageModel.nodeName)}</td>
					<th width="30%">Frame Time：</th>
					<td width="20%">${fn:escapeXml(pageModel.frameTime)} ms</td>
				</tr>
				<tr>
					<th width="30%">Local Latitude(Deg/Min/Sec N/S)：</th>
					<td width="20%">${fn:escapeXml(pageModel.localLatitudeDeg)}/${fn:escapeXml(pageModel.localLatitudeMin)}/${fn:escapeXml(pageModel.localLatitudeSec)}
					                ${fn:escapeXml(pageModel.localLatitudeNS)}</td>
					<th width="30%">Frame Size(Symbols)：</th>
					<td width="20%">${fn:escapeXml(pageModel.frameSize)}</td>
				</tr>
				<tr>
					<th width="30%">Local Longitude(Deg/Min/Sec E/W)：</th>
					<td width="20%">${fn:escapeXml(pageModel.localLongitudeDeg)}/${fn:escapeXml(pageModel.localLongitudeMin)}/${fn:escapeXml(pageModel.localLongitudeSec)}
					                ${fn:escapeXml(pageModel.localLongitudeEW)}</td>
					<th width="30%">Superframe Size：</th>
					<td width="20%">${fn:escapeXml(pageModel.superframeSize)}</td>
				</tr>
				<tr>
					<th width="30%">Local Elevation：</th>
					<td width="20%">${fn:escapeXml(pageModel.localElevation)}</td>
					<th width="30%">CSCs Per Frame：</th>
					<td width="20%">${fn:escapeXml(pageModel.cscsPerFrame)}</td>
				</tr>
				<tr>
					<th width="30%">satellite Longitude(Deg/Min/Sec E/W)：</th>
					<td width="20%">${fn:escapeXml(pageModel.satelliteLongitudeDeg)}/${fn:escapeXml(pageModel.satelliteLongitudeMin)}/${fn:escapeXml(pageModel.satelliteLongitudeSec)}
					                ${fn:escapeXml(pageModel.satelliteLongitudeEW)}</td>
					<th width="30%">Maximun Nodes In Network：</th>
					<td width="20%">${fn:escapeXml(pageModel.maximunNodesInNetwork)}</td>
				</tr>
				<tr>
					<th width="30%">Auto Range Calculation：</th>
					<td width="20%">${fn:escapeXml(pageModel.autoRangeCalculation)}</td>
					<th width="30%">Code Version：</th>
					<td width="20%">${fn:escapeXml(pageModel.codeVersion)}</td>
				</tr>
				<tr>
					<th width="30%">Nominal Frame Delay(Frames)：</th>
					<td width="20%">${fn:escapeXml(pageModel.nominalFrameDelay)}</td>
					<th width="30%">Rom Version：</th>
					<td width="20%">${fn:escapeXml(pageModel.romVersion)}</td>
				</tr>
				<tr>
					<th width="30%">Nominal Phase Offset(Symbols)：</th>
					<td width="20%">${fn:escapeXml(pageModel.nominalPhaseOffset)}</td>
					<th width="30%">Flash Version：</th>
					<td width="20%">${fn:escapeXml(pageModel.flashVersion)}</td>
				</tr>
				<tr>
					<th width="30%">Manual Frame Delay(Frames)：</th>
					<td width="20%">${fn:escapeXml(pageModel.manualFrameDelay)}</td>
					<th width="30%">Manual Phase Offset(Symbols)：</th>
					<td width="20%">${fn:escapeXml(pageModel.manualPhaseOffset)}</td>
				</tr>
				<tr>
					<th width="30%">Redundant Chassis：</th>
					<td width="20%">${fn:escapeXml(pageModel.redundantChassis)}</td>
				</tr>
    </table>
			<br/>
		</div>
		<!-- end 详情内容-->
	</div>
	<button style="width: 60px; height: 36px;" class="closeButton">关闭</button>
</body>
</html>