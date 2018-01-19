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
			<dd>ODU详情--查看</dd>
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
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">ODU</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">+12v：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.v12)}</td>
					<th colspan="1" style=" width: 17%; text-align: center;">FAN：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.fan)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">5 Volt Supplies</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">Neg：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.neg5vSupply)}</td>
					<th colspan="1" style=" width: 17%; text-align: center;">Pos：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.pos5vSupply)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Synthesizer</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">FTLLock：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.ftllock)}</td>
					<th colspan="1" style=" width: 17%; text-align: center;">FTLPLL：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.ftlpll)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">PA Supplies</th>
				</tr>
				<tr>
					<th width="16%">PA1：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa1)}</td>
					<th width="16%">PA2：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa2)}</td>
					<th width="16%">PA3：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa3)}</td>
				</tr>
				<tr>
					<th width="16%">PA4：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa4)}</td>
					<th width="16%">PA5：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa5)}</td>
					<th width="16%">PA6：</th>
					<td width="16%">${fn:escapeXml(pageModel.pa6)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Odu Uplink</th>
				</tr>
				<tr>
					<th style=" width: 17%; text-align: center;">TX Request：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.txRequest)}</td>
					<th style=" width: 17%; text-align: center;">STATUS：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.status)}</td>
					<th style=" width: 17%; text-align: center;">Model：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.model)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Tx channel</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">ch：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.txChannel)}</td>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.txChannelMhz)}</td>
					<th colspan="1" style=" width: 17%; text-align: center;">(MHz)</th>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Tx Gain</th>
				</tr>
				<tr>
					<th colspan="2" style=" width: 33%; text-align: center;">gain：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.txGain)}</td>
					<th colspan="2" style=" width: 33%; text-align: center;">(dB)</th>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Tx Parameters</th>
				</tr>
				<tr>
					<th style=" width: 17%; text-align: center;">Input：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.txInput)} dBm</td>
					<th style=" width: 17%; text-align: center;">Output：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.txOutput)} dBm</td>
					<th style=" width: 17%; text-align: center;">Peak Output：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.txPeakOutput)} dBm</td>
				</tr>
				<tr>
				    <th colspan="1" style=" width: 17%; text-align: center;">PA Temp：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.txPaTemp)} deg.C</td>
					<th colspan="1" style=" width: 17%; text-align: center;">TX Mute：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.txMute)}</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Synthesizer</th>
				</tr>
				<tr>
					<th style=" width: 17%; text-align: center;">TXLock：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.synTxLock)}</td>
					<th style=" width: 17%; text-align: center;">TXPLL：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.synTxpll)} V</td>
					<th style=" width: 17%; text-align: center;">TXOPLL：</th>
					<td style=" width: 17%; text-align: center;">${fn:escapeXml(pageModel.synTxopll)} V</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Rx channel</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">ch：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.rxChannel)}</td>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.rxChannelMhz)}</td>
					<th colspan="1" style=" width: 17%; text-align: center;">(MHz)</th>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Rx Gain</th>
				</tr>
				<tr>
					<th colspan="2" style=" width: 33%; text-align: center;">gain：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.rxGain)}</td>
					<th colspan="2" style=" width: 33%; text-align: center;">(dB)</th>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Rx Parameters</th>
				</tr>
				<tr>
					<th colspan="1" style=" width: 17%; text-align: center;">IFPowerOut:</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.rxIfPowerOut)} dBm</td>
					<th colspan="1" style=" width: 17%; text-align: center;">LNB：</th>
					<td colspan="2" style=" width: 33%; text-align: center;">${fn:escapeXml(pageModel.rxLnb)} V</td>
				</tr>
				<tr>
				<th colspan="6" style="color: gray; width: 100%; text-align: center;">Synthesizer</th>
				</tr>
				<tr>
					<th colspan="1" width="17%">RX Lock：</th>
					<td colspan="2" style=" width: 33%; text-align: center;" width="20%">${fn:escapeXml(pageModel.synRx)}</td>
					<th colspan="1" width="17%">RXPLL：</th>
					<td colspan="2" style=" width: 33%; text-align: center;" width="20%">${fn:escapeXml(pageModel.synRxpll)} V</td>
				</tr>
    </table>
			<br/>
		</div>
		<!-- end 详情内容-->
	</div>
	<button style="width: 60px; height: 36px;" class="closeButton">关闭</button>
</body>
</html>