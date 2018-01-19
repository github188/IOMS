<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地境外站主站CDM570状态巡检--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">通信基地境外站主站CDM570</th>
	</tr>
	<tr>
		<th width="25%" rowspan="8">巡检内容</th>
		<th width="25%" rowspan="4">主机</th>
		<th width="25%">Tx Traffic灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.masterTxResult eq 'on' }">
					<input type="radio" name="masterTxResult" id="masterTxResult"
						value="on" checked="checked" />长亮 <input type="radio"
						name="masterTxResult" id="masterTxResult" value="off" />不亮
		
		</c:when>
				<c:when test="${vo.masterTxResult eq 'off' }">
					<input type="radio" name="masterTxResult" id="masterTxResult"
						value="on" />长亮 <input type="radio" name="masterTxResult"
						id="masterTxResult" value="off" checked="checked" />不亮
		</c:when>
				<c:otherwise>
				<input type="radio" name="masterTxResult" id="masterTxResult"
					value="on" />长亮 <input type="radio" name="masterTxResult"
					id="masterTxResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">Rx Traffic灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.masterRxResult eq 'on' }">
					<input type="radio" name="masterRxResult" id="masterRxResult"
						value="on" checked="checked" />长亮 <input type="radio"
						name="masterRxResult" id="masterRxResult" value="off" />不亮
		
		</c:when>
				<c:when test="${vo.masterRxResult eq 'off' }">
					<input type="radio" name="masterRxResult" id="masterRxResult"
						value="on" />长亮 <input type="radio" name="masterRxResult"
						id="masterRxResult" value="off" checked="checked" />不亮
		</c:when>
				<c:otherwise>
				<input type="radio" name="masterRxResult" id="masterRxResult"
					value="on" />长亮 <input type="radio" name="masterRxResult"
					id="masterRxResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">OnLine灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.masterOnlineResult eq 'on' }">
					<input type="radio" name="masterOnlineResult"
						id="masterOnlineResult" value="on" checked="checked" />长亮 <input
						type="radio" name="masterOnlineResult" id="masterOnlineResult"
						value="off" />不亮
		
		</c:when>
				<c:when test="${vo.masterOnlineResult eq 'off' }">
					<input type="radio" name="masterOnlineResult"
						id="masterOnlineResult" value="on" />长亮 <input type="radio"
						name="masterOnlineResult" id="masterOnlineResult" value="off"
						checked="checked" />不亮
		</c:when>
				<c:otherwise>
				<input type="radio" name="masterOnlineResult"
					id="masterOnlineResult" value="on" />长亮 <input type="radio"
					name="masterOnlineResult" id="masterOnlineResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">Eb/No</th>
		<th width="25%"><input type="text" name="masterEbResult"
			id="masterEbResult" value="${vo.masterEbResult}" /></th>
	</tr>
	<tr>
		<th width="25%" rowspan="4">备机</th>
		<th width="25%">Tx Traffic灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.slaveTxResult eq 'on' }">
					<input type="radio" name="slaveTxResult"
						id="slaveTxResult" value="on" checked="checked" />长亮 <input
						type="radio" name="slaveTxResult" id="slaveTxResult"
						value="off" />不亮
		
		</c:when>
				<c:when test="${vo.slaveTxResult eq 'off' }">
					<input type="radio" name="slaveTxResult"
						id="slaveTxResult" value="on" />长亮 <input type="radio"
						name="slaveTxResult" id="slaveTxResult" value="off"
						checked="checked" />不亮
		</c:when>
				<c:otherwise>
				<input type="radio" name="slaveTxResult"
					id="slaveTxResult" value="on" />长亮 <input type="radio"
					name="slaveTxResult" id="slaveTxResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">Rx Traffic灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.slaveRxResult eq 'on' }">
					<input type="radio" name="slaveRxResult"
						id="slaveRxResult" value="on" checked="checked" />长亮 <input
						type="radio" name="slaveRxResult" id="slaveRxResult"
						value="off" />不亮
		
		</c:when>
				<c:when test="${vo.slaveRxResult eq 'off' }">
					<input type="radio" name="slaveRxResult"
						id="slaveRxResult" value="on" />长亮 <input type="radio"
						name="slaveRxResult" id="slaveRxResult" value="off"
						checked="checked" />不亮
		</c:when>
				<c:otherwise>
				<input type="radio" name="slaveRxResult"
					id="slaveRxResult" value="on" />长亮 <input type="radio"
					name="slaveRxResult" id="slaveRxResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">OnLine灯</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.slaveOnlineResult eq 'on' }">
					<input type="radio" name="slaveOnlineResult"
						id="slaveOnlineResult" value="on" checked="checked" />长亮 <input
						type="radio" name="slaveOnlineResult" id="slaveOnlineResult"
						value="off" />不亮
		
		</c:when>
				<c:when test="${vo.slaveOnlineResult eq 'off' }">
					<input type="radio" name="slaveOnlineResult"
						id="slaveOnlineResult" value="on" />长亮 <input type="radio"
						name="slaveOnlineResult" id="slaveOnlineResult" value="off"
						checked="checked" />不亮
		</c:when>
				<c:otherwise>
					<input type="radio" name="slaveOnlineResult" id="slaveOnlineResult"
						value="on" />长亮 <input type="radio" name="slaveOnlineResult"
						id="slaveOnlineResult" value="off" />不亮
				</c:otherwise>
		</c:choose></th>
	</tr>
	<tr>
		<th width="25%">Eb/No</th>
		<th width="25%"><input type="text" name="slaveEbResult"
			id="slaveEbResult" value="${vo.slaveEbResult }"/></th>
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
