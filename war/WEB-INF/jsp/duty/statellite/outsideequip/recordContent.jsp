<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>${checkEquip.value }月检</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>${checkEquip.value }季检</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>${checkEquip.value }年检</dd>
		</c:if>
	</dl>
</div>
<table width="100%" border="1">

	<tr>
		<th colspan="1">设备名称</th>
		<th colspan="2">${checkEquip.value }</th>
	</tr>
	<tr>
		<c:choose>
			<c:when
				test="${optType eq 'TxjdOutTesEquip' or optType eq 'MhjOutTesEquip'}">
				<th width="30%" rowspan="7">巡检内容</th>
			</c:when>
			<c:otherwise>
				<th width="30%" rowspan="5">巡检内容</th>
			</c:otherwise>
		</c:choose>
		<th width="30%">ODU主用侧</th>
		<th width="30%"><input name="oduOnSide" id="oduOnSide" value="A"
			type="radio" checked="checked" />A <input name="oduOnSide"
			id="oduOnSide" value="B" type="radio" />B</th>
	</tr>
	<c:choose>
		<c:when
			test="${optType eq 'TxjdOutTesEquip' or optType eq 'MhjOutTesEquip'}">
			<tr>
				<th width="30%">底噪电平(dBm)</th>
				<th width="30%"><input name="oduLevel" id="oduLevel"
					type="text" /></th>
			</tr>
			<tr>
				<th width="30%">OCC载噪比(dB)</th>
				<th width="30%"><input name="occCarrNoise" id="occCarrNoise"
					type="text" /></th>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<th width="30%">ODU 主用侧底噪电平（dB）</th>
				<th width="30%"><input name="oduLevel" id="oduLevel"
					type="text" /></th>
			</tr>
			<tr>
				<th width="30%">0号载波载噪比（dB）</th>
				<th width="30%"><input name="occCarrNoise" id="occCarrNoise"
					type="text" /></th>
			</tr>
		</c:otherwise>
	</c:choose>
	<tr>
		<th width="30%">ODU风扇状态</th>
		<th width="30%"><input name="blowerState" id="blowerState"
			value="normal" type="radio" checked="checked" />正常 <input
			name="blowerState" id="blowerState" value="unnormal" type="radio" />异常</th>
	</tr>
	<tr>
		<th width="30%">电缆连接与接头防水</th>
		<th width="30%"><input name="linkState" id="linkState"
			value="normal" type="radio" checked="checked" />正常 <input
			name="linkState" id="v" value="unnormal" type="radio" />异常</th>
	</tr>

	<c:if
		test="${optType eq 'TxjdOutTesEquip' or optType eq 'MhjOutTesEquip'}">
		<tr>
			<th width="30%">A路温度</th>
			<th width="30%"><input name="temperatureA" id="temperatureA"
				type="text" /></th>
		</tr>
		<tr>
			<th width="30%">B路温度</th>
			<th width="30%"><input name="temperatureB" id="temperatureB"
				type="text" /></th>
		</tr>
	</c:if>
</table>

<div class="boxbtn">
	<c:if test="${!view}">
		<div class="btn">
			<a href="#none" id="submit">保存</a>
		</div>
	</c:if>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>