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
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		//预加载数据
		for (var i = 1; i <= 4; i++) {
			var noiseHtm = "#occ" + i + "Noise";
			var peakHtm = "#occ" + i + "Peak";
			var noiseStatusHtm = "#occ" + i + "NoiseStatus";
			var peakStatusHtm = "#occ" + i + "PeakStatus";
			var noise = $(noiseHtm).val();
			var peak = $(peakHtm).val();
			noise = parseFloat(noise);
			peak = parseFloat(peak);
			//验证状态
			if (noise > 15) {
				$(noiseStatusHtm).append(
						"<font color='red'>" + noise + "</font>");
			} else {
				$(noiseStatusHtm).append(noise);
			}
			if (peak > 15) {
				$(peakStatusHtm)
						.append("<font color='red'>" + peak + "</font>");
			} else {
				$(peakStatusHtm).append(peak);
			}
		}
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>通信基地TES OCC状态自检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="2">设备名称</th>
					<th colspan="3">${checkData.equipName.value }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="8">巡检内容</th>
					<th width="20%" rowspan="2">OCC1(dBm)</th>
					<th width="20%" rowspan="1">底噪</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ1Noise }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ1NoiseStatus">
						<input type="hidden" value="${checkData.occ1Noise}" name="occ1Noise" id="occ1Noise" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="1">峰值</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ1Peak }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ1PeakStatus">
						<input type="hidden" value="${checkData.occ1Peak}" name="occ1Peak" id="occ1Peak" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="2">OCC2(dBm)</th>
					<th width="20%" rowspan="1">底噪</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ2Noise }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ2NoiseStatus">
						<input type="hidden" value="${checkData.occ2Noise}" name="occ2Noise" id="occ2Noise" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="1">峰值</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ2Peak }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ2PeakStatus">
						<input type="hidden" value="${checkData.occ2Peak}" name="occ2Peak" id="occ2Peak" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="2">OCC3(dBm)</th>
					<th width="20%" rowspan="1">底噪</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ3Noise }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ3NoiseStatus">
						<input type="hidden" value="${checkData.occ3Noise}" name="occ3Noise" id="occ3Noise" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="1">峰值</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ3Peak }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ3PeakStatus">
						<input type="hidden" value="${checkData.occ3Peak}" name="occ3Peak" id="occ3Peak" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="2">OCC4(dBm)</th>
					<th width="20%" rowspan="1">底噪</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ4Noise }</th>
				</tr>
				<%-- <tr>
					<th width="20%">状态</th>
					<th id="occ4NoiseStatus">
						<input type="hidden" value="${checkData.occ4Noise}" name="occ4Noise" id="occ4Noise" />
					</th>
				</tr> --%>
				<tr>
					<th width="20%" rowspan="1">峰值</th>
					<th width="20%">检测值</th>
					<th width="20%">${checkData.occ4Peak }</th>
				</tr>
				<%-- 				<tr>
					<th width="20%">状态</th>
					<th id="occ4PeakStatus">
						<input type="hidden" value="${checkData.occ4Peak}" name="occ4Peak" id="occ4Peak" />
					</th>
				</tr>
 --%>
			</table>
		</div>
	</div>
</body>
</html>