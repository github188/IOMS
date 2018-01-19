<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	.t_title{
		text-align: center;
	}
	textarea.configInfo {
		float:left;
		width:650px;
		resize:none;
	}
-->
</style>
<script type="text/javascript">
</script>
<c:choose>
	<c:when test="${not empty formalCircuitATMs && m.formalCircuit.applyBaseInfo.applyType =='formalcircuit_atm'}">
		<tr class="config2">
			<th width="10%" align="right" rowspan="${3+formalCircuitATMs.size()}">请进行配置：<span style="color: red">(*)</span></th>
			<td width="10%" rowspan="2">编号</td>
			<td width="35%" colspan="2">本端参数</td>
			<td width="35%" colspan="2">对端参数</td>
			<td width="10%" rowspan="2">电路编号</td>
		</tr>
		<tr class="config2">
			<td width="35%" colspan="2">信令类型</td>
			<td width="35%" colspan="2">信令类型</td>
		</tr>
		<c:forEach items="${formalCircuitATMs}" var="formalCircuitATM">
			<tr class="config2">
			    <td width="10%">${formalCircuitATM.identifier}</td>
				<td width="35%" colspan="2"><select name='ATMConfTxSignal'>
						<option value='Q933a'>Q933a</option>
						<option value='UNI'>UNI</option>
						<option value='NNI'>NNI</option>
						<option value='ZTC'>帧透传</option>
				</select></td>
				<td width="35%" colspan="2"><select name='ATMConfRxSignal'>
						<option value='Q933a'>Q933a</option>
						<option value='UNI'>UNI</option>
						<option value='NNI'>NNI</option>
						<option value='ZTC'>帧透传</option>
				</select></td>
				<td width="10%"><input type="text" name="ATMConfNo"/></td>
			</tr>
		</c:forEach>
		<tr class="config2">
			<td width="10%">备注信息</td>
			<td width="90%" colspan="5"><textarea class="configInfo" id="confRemark" name="confRemark" rows="4"></textarea></td>
		</tr>
	</c:when>
	<c:when test="${not empty formalCircuitKUs && m.formalCircuit.applyBaseInfo.applyType =='formalcircuit_ku'}">
		<tr class="config2">
			<th width="10%" align="right" rowspan="${3+formalCircuitKUs.size()}">请进行配置：<span style="color: red">(*)</span></th>
			<td width="10%" rowspan="2">编号</td>
			<td width="28%" colspan="2">本端参数</td>
			<td width="28%" colspan="2">对端参数</td>
			<td width="12%" rowspan="2">电路名称</td>
			<td width="12%" rowspan="2">电路编号</td>
		</tr>
		<tr class="config2">
			<td width="14%">卡类型</td>
			<td width="14%">接口类型</td>
			<td width="14%">卡类型</td>
			<td width="14%">接口类型</td>
		</tr>
		<c:forEach items="${formalCircuitKUs}" var="formalCircuitKU">
			<tr class="config2">
			    <td width="10%">${formalCircuitKU.identifier}</td>
				<td width="14%"><select name='KUConfTxCard'>
						<option value='HD'>高速数据板</option>
						<option value='FR'>帧中继板</option>
						<option value='E1'>E1</option>
						<option value='DLM'>DLM</option>
						<option value='VOICE'>VOICE</option>
				</select></td>
				<td width="14%"><input type="text" name="KUConfTxInterface"/></td>
				<td width="14%"><select name='KUConfRxCard'>
						<option value='HD'>高速数据板</option>
						<option value='FR'>帧中继板</option>
						<option value='E1'>E1</option>
						<option value='DLM'>DLM</option>
						<option value='VOICE'>VOICE</option>
				</select></td>
				<td width="14%"><input type="text" name="KUConfRxInterface"/></td>
				<td width="12%"><input type="text" name="KUConfCircuitName"/></td>
				<td width="12%"><input type="text" name="KUConfNo"/></td>
			</tr>
		</c:forEach>
		<tr class="config2">
			<td width="10%">备注信息</td>
			<td width="90%" colspan="6"><textarea class="configInfo" id="confRemark" name="confRemark" rows="4"></textarea></td>
		</tr>
	</c:when>
	<c:when test="${not empty formalCircuitTESs && m.formalCircuit.applyBaseInfo.applyType =='formalcircuit_tes'}">
		<tr class="config2">
			<th width="10%" align="right" rowspan="${3+formalCircuitTESs.size()}">请进行配置：<span style="color: red">(*)</span></th>
			<td width="10%" rowspan="2">编号</td>
			<td width="18%">本端参数</td>
			<td width="18%">对端参数</td>
			<td width="14%" rowspan="2">时钟方式</td>
			<td width="15%" rowspan="2">电路名称</td>
			<td width="15%" rowspan="2" colspan="2">电路编号</td>
		</tr>
		<tr class="config2">
			<td width="18%">接口类型</td>
			<td width="18%">接口类型</td>
		</tr>
		<c:forEach items="${formalCircuitTESs}" var="formalCircuitTES">
			<tr class="config2">
			    <td width="10%">${formalCircuitTES.identifier}</td>
				<td width="18%"><input type="text" name="TESConfTxInterface"/></td>
				<td width="18%"><input type="text" name="TESConfRxInterface"/></td>
				<td width="14%"><input type="text" name="TESConfClock"/></td>
				<td width="15%"><input type="text" name="TESConfCircuitName"/></td>
				<td width="15%" colspan="2"><input type="text" name="TESConfNo"/></td>
			</tr>
		</c:forEach>
		<tr class="config2">
			<td width="10%">备注信息</td>
			<td width="90%" colspan="6"><textarea class="configInfo" id="confRemark" name="confRemark" rows="4"></textarea></td>
		</tr>
	</c:when>
	
	<c:when test="${not empty formalCircuitPESs && m.formalCircuit.applyBaseInfo.applyType =='formalcircuit_pes'}">
		<tr class="config2">
			<th width="10%" align="right" rowspan="${3+formalCircuitPESs.size()}">请进行配置：<span style="color: red">(*)</span></th>
			<td width="10%" rowspan="2">编号</td>
			<td width="18%">本端参数</td>
			<td width="18%">对端参数</td>
			<td width="15%" rowspan="2">电路名称</td>
			<td width="15%" rowspan="2" colspan="2">电路编号</td>
		</tr>
		<tr class="config2">
			<td width="18%">接口类型</td>
			<td width="18%">接口类型</td>
		</tr>
		<c:forEach items="${formalCircuitPESs}" var="formalCircuitPES">
			<tr class="config2">
			    <td width="10%">${formalCircuitPES.identifier}</td>
				<td width="18%"><input type="text" name="PESConfTxInterface"/></td>
				<td width="18%"><input type="text" name="PESConfRxInterface"/></td>
				<td width="15%"><input type="text" name="PESConfCircuitName"/></td>
				<td width="15%" colspan="2"><input type="text" name="PESConfNo"/></td>
			</tr>
		</c:forEach>
		<tr class="config2">
			<td width="10%">备注信息</td>
			<td width="90%" colspan="6"><textarea class="configInfo" id="confRemark" name="confRemark" rows="4"></textarea></td>
		</tr>
	</c:when>
</c:choose>