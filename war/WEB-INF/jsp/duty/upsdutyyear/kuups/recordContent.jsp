<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>ups设备检查</dd>
	</dl>
</div>
<table style="width: 100%" >
	<tr>
		<th colspan="3">设备名称</th>
		<th colspan="3">
			<form:select path="name" cssStyle="width:200px">
				<c:forEach items="${kuUpsName}" var="vo">
					<option value="${vo.value}">${vo.value}</option>
				</c:forEach>
			</form:select>
		</th>
	</tr>
	<tr>
		<th width="15%" rowspan="20">巡检内容</th>
		<th width="30%" rowspan="3" colspan="2">环境</th>
		<th width="30%" colspan="2">环境温度是否可调</th>
		<td width="25%">
			<select id="atIsAdjustable" name="atIsAdjustable">
				<c:forEach items="${checkResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">环境温度(℃)</th>
		<td width="25%"><form:input  path="temperature" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">环境湿度</th>
		<td width="25%"><form:input  path="humidity" /></td>
	</tr>
	<tr>
		<th width="30%" rowspan="4" colspan="2">外观</th>
		<th width="30%" colspan="2">设备外观是否完好</th>
		<td>
			<select id="eaIsIntact" name="eaIsIntact">
				<c:forEach items="${checkResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS及电池柜的散热是否正常</th>
		<td>
			<select id="radiateIsNormal" name="radiateIsNormal">
				<c:forEach items="${checkResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">电池无漏夜现象</th>
		<td>
			<select id="batLeakage" name="batLeakage">
				<c:forEach items="${checkResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">连接端子无腐蚀氧化</th>
		<td>
			<select id="connCo" name="connCo">
				<c:forEach items="${checkResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th width="30%" rowspan="7" colspan="2">输入系统</th>
		<th width="30%" colspan="2">输入电压L-N</th>
		<td width="25%"><form:input  path="inputVLN" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输入电压L-地</th>
		<td width="25%"><form:input  path="inputVLD" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输入电压N-地</th>
		<td width="25%"><form:input  path="inputVND" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输入电流</th>
		<td width="25%"><form:input  path="inputCurrent" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">负载量</th>
		<td width="25%"><form:input  path="loadCapacity" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">空开温度</th>
		<td width="25%"><form:input  path="inputAirTemperature" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">线缆温度</th>
		<td width="25%"><form:input  path="inputCableTemperature" /></td>
	</tr>
	<tr>
		<th width="30%" rowspan="5" colspan="2">输出系统</th>
		<th width="30%" colspan="2">输出电压L-N</th>
		<td width="25%"><form:input  path="outputVLN" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输出电压L-地</th>
		<td width="25%"><form:input  path="outputVLD" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输出电压N-地</th>
		<td width="25%"><form:input  path="outputVND" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">输出电流</th>
		<td width="25%"><form:input  path="outputCurrent" /></td>
	</tr>
	<tr>
		<th width="30%" colspan="2">空开温度</th>
		<td width="25%"><form:input  path="outputAirTemperature" /></td>
	</tr>
	<tr>
		<th width="60%" colspan="4">设备除尘</th>
		<td>
			<select id="equipDustRemoval" name="equipDustRemoval">
				<c:forEach items="${contentCheckResult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<!-- 电池测量 -->
	<tr><th width="100%" colspan="6">电池测量</th></tr>
	<tr>
		<th>电池序号</th>
		<th>端电压(V)</th>
		<th colspan="2">内阻</th>
		<th colspan="2">备注</th>
	</tr>
	<tr>
		<td><form:input path="number" value="1" readonly="true" cssStyle="text-align:center"/></td>
		<td><form:input path="termialV"/></td>
		<td colspan="2"><form:input path="interR"/></td>
		<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="2" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="3" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="4" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="5" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="6" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="7" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="8" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="9" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="10" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="11" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="12" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="13" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="14" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="15" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="16" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="17" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="18" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="19" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="20" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
	<tr>
		<th colspan="1">存在问题</th>
		<td colspan="5"><form:textarea cols="150" path="problem"/></td>
	</tr>
	<tr>
		<th colspan="1">建议</th>
		<td colspan="5"><form:textarea cols="150" path="suggestion"/></td>
	</tr>
	<tr>
		<th colspan="1">结果</th>
		<td colspan="5"><form:textarea cols="150" path="result"/></td>
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