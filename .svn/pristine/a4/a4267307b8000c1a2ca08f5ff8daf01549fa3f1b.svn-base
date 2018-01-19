<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地境外站主站CDM570状态自检添加</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">通信基地-境外站-主站CDM570</th>
	</tr>
	<tr>
		<th width="25%" rowspan="8">巡检内容</th>
		<th width="25%" rowspan="4">主机</th>
		<th width="25%">Tx Traffic灯</th>
		<th width="25%"><input type="radio" name="masterTxResult"
			id="masterTxResult" value="on" />长亮 <input type="radio"
			name="masterTxResult" id="masterTxResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">Rx Traffic灯</th>
		<th width="25%"><input type="radio" name="masterRxResult"
			id="masterRxResult" value="on" />长亮 <input type="radio"
			name="masterRxResult" id="masterRxResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">OnLine灯</th>
		<th width="25%"><input type="radio" name="masterOnlineResult"
			id="masterOnlineResult" value="on" />长亮 <input type="radio"
			name="masterOnlineResult" id="masterOnlineResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">Eb/No</th>
		<th width="25%"><input type="text" name="masterEbResult"
			id="masterEbResult" /></th>
	</tr>
	<tr>
		<th width="25%" rowspan="4">备机</th>
		<th width="25%">Tx Traffic灯</th>
		<th width="25%"><input type="radio" name="slaveTxResult"
			id="slaveTxResult" value="on" />长亮 <input type="radio"
			name="slaveTxResult" id="slaveTxResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">Rx Traffic灯</th>
		<th width="25%"><input type="radio" name="slaveRxResult"
			id="slaveRxResult" value="on" />长亮 <input type="radio"
			name="slaveRxResult" id="slaveRxResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">OnLine灯</th>
		<th width="25%"><input type="radio" name="slaveOnlineResult"
			id="slaveOnlineResult" value="on" />长亮 <input type="radio"
			name="slaveOnlineResult" id="slaveOnlineResult" value="off" />不亮</th>
	</tr>
	<tr>
		<th width="25%">Eb/No</th>
		<th width="25%"><input type="text" name="slaveEbResult"
			id="slaveEbResult" /></th>
	</tr>
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