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
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>${vo.checkEquip.value }${vo.checkType.value}详情</dd>
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
					<th colspan="1">设备名称</th>
					<th colspan="2">${vo.checkEquip.value }</th>
				</tr>
				<tr>
					<c:choose>
						<c:when
							test="${vo.checkEquip eq 'TxjdOutTesEquip' or vo.checkEquip eq 'MhjOutTesEquip'}">
							<th width="30%" rowspan="7"><font color="red">(*)</font>巡检内容</th>
						</c:when>
						<c:otherwise>
							<th width="30%" rowspan="5"><font color="red">(*)</font>巡检内容</th>
						</c:otherwise>
					</c:choose>
					<th width="30%">ODU主用侧</th>
					<th width="30%"><c:choose>
							<c:when test="${vo.oduOnSide eq 'A'}">
								<input name="oduOnSide" id="oduOnSide" value="A" type="radio"
									checked="checked" disabled="disabled" />A <input
									name="oduOnSide" id="oduOnSide" value="B" type="radio"
									disabled="disabled" />B
			</c:when>
							<c:otherwise>
								<input name="oduOnSide" id="oduOnSide" value="A" type="radio"
									disabled="disabled" />A <input name="oduOnSide" id="oduOnSide"
									value="B" type="radio" checked="checked" disabled="disabled" />B
			</c:otherwise>
						</c:choose></th>
				</tr>
				<c:choose>
					<c:when
						test="${vo.checkEquip eq 'TxjdOutTesEquip' or vo.checkEquip eq 'MhjOutTesEquip'}">
						<tr>
							<th width="30%">底噪电平</th>
							<th width="30%"><input name="oduLevel" id="oduLevel"
								type="hidden" />${vo.oduLevel}</th>
						</tr>
						<tr>
							<th width="30%">OCC载噪比</th>
							<th width="30%"><input name="occCarrNoise" id="occCarrNoise"
								type="hidden" />${vo.occCarrNoise}</th>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th width="30%">ODU 主用侧底噪电平（dB）</th>
							<th width="30%"><input name="oduLevel" id="oduLevel"
								type="hidden" />${vo.oduLevel}</th>
						</tr>
						<tr>
							<th width="30%">0号载波载噪比（dB）</th>
							<th width="30%"><input name="occCarrNoise" id="occCarrNoise"
								type="hidden" />${vo.occCarrNoise}</th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th width="30%">ODU风扇状态</th>
					<th width="30%"><c:choose>
							<c:when test="${vo.blowerState eq 'normal'}">
								<input name="blowerState" id="blowerState" value="normal"
									type="radio" checked="checked" disabled="disabled" />正常 <input
									name="blowerState" id="blowerState" value="unnormal"
									type="radio" disabled="disabled" />异常
			</c:when>
							<c:otherwise>
								<input name="blowerState" id="blowerState" value="normal"
									type="radio" disabled="disabled" />正常 <input
									name="blowerState" id="blowerState" value="unnormal"
									type="radio" checked="checked" disabled="disabled" />异常
			</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">电缆连接与接头防水</th>
					<th width="30%"><c:choose>
							<c:when test="${vo.linkState eq 'normal'}">
								<input name="linkState" id="linkState" value="normal"
									type="radio" checked="checked" disabled="disabled" />正常 <input
									name="linkState" id="linkState" value="unnormal" type="radio"
									disabled="disabled" />异常
			</c:when>
							<c:otherwise>
								<input name="linkState" id="linkState" value="normal"
									type="radio" disabled="disabled" />正常 <input name="linkState"
									id="linkState" value="unnormal" type="radio" checked="checked"
									disabled="disabled" />异常
			</c:otherwise>
						</c:choose></th>
				</tr>

				<c:if
					test="${vo.checkEquip eq 'TxjdOutTesEquip' or vo.checkEquip eq 'MhjOutTesEquip'}">
					<tr>
						<th width="30%">A路温度</th>
						<th width="30%"><input name="temperatureA" id="temperatureA"
							type="hidden" />${vo.temperatureA}</th>
					</tr>
					<tr>
						<th width="30%">B路温度</th>
						<th width="30%"><input name="temperatureB" id="temperatureB"
							type="hidden" />${vo.temperatureB}</th>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>