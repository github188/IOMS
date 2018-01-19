<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>ups设备检查</dd>
	</dl>
</div>
<table style="width: 100%">
	<tr>
		<th colspan="3">设备名称</th>
		<th colspan="3">${upsCheck.name }</th>
	</tr>
	<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
		<tr>
			<th width="15%" rowspan="20"><font color="red">(*)</font>巡检内容</th>
			<th width="30%" rowspan="3" colspan="2">环境</th>
			<th width="30%" colspan="2">环境温度是否可调</th>
			<td width="25%">
				<select id="atIsAdjustable" name="atIsAdjustable">
					<option value="${ucc.atIsAdjustable }">${ucc.atIsAdjustable.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.atIsAdjustable.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">环境温度(℃)</th>
			<td width="25%"><input id="temperature" name="temperature" value="${ucc.temperature }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">环境湿度</th>
			<td width="25%"><input id="humidity" name="humidity" value="${ucc.humidity }"/></td>
		</tr>
		<tr>
			<th width="30%" rowspan="4" colspan="2">外观</th>
			<th width="30%" colspan="2">设备外观是否完好</th>
			<td width="25%">
				<select id="eaIsIntact" name="eaIsIntact">
					<option value="${ucc.eaIsIntact }">${ucc.eaIsIntact.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.eaIsIntact.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">UPS及电池柜的散热是否正常</th>
			<td width="25%">
				<select id="radiateIsNormal" name="radiateIsNormal">
					<option value="${ucc.radiateIsNormal }">${ucc.radiateIsNormal.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.radiateIsNormal.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">电池无漏夜现象</th>
			<td width="25%">
				<select id="batLeakage" name="batLeakage">
					<option value="${ucc.batLeakage }">${ucc.batLeakage.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.batLeakage.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">连接端子无腐蚀氧化</th>
			<td width="25%">
				<select id="connCo" name="connCo">
					<option value="${ucc.connCo }">${ucc.connCo.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.connCo.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<!-- 输入系统 -->
		<tr>
			<th width="30%" rowspan="7" colspan="2">输入系统</th>
			<th width="30%" colspan="2">输入电压L-N</th>
			<td width="25%"><input id="inputVLN" name="inputVLN" value="${ucc.inputVLN }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输入电压L-地</th>
			<td width="25%"><input id="inputVLD" name="inputVLD" value="${ucc.inputVLD }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输入电压N-地</th>
			<td width="25%"><input id="inputVND" name="inputVND" value="${ucc.inputVND }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输入电流</th>
			<td width="25%"><input id="inputCurrent" name="inputCurrent" value="${ucc.inputCurrent }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">负载量</th>
			<td width="25%"><input id="loadCapacity" name="loadCapacity" value="${ucc.loadCapacity }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">空开温度</th>
			<td width="25%"><input id="inputAirTemperature" name="inputAirTemperature" value="${ucc.inputAirTemperature }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">线缆温度</th>
			<td width="25%"><input id="inputCableTemperature" name="inputCableTemperature" value="${ucc.inputCableTemperature }" /></td>
		</tr>
		<!-- 输出系统 -->
		<tr>
			<th width="30%" rowspan="5" colspan="2">输出系统</th>
			<th width="30%" colspan="2">输出电压L-N</th>
			<td width="25%"><input id="outputVLN" name="outputVLN" value="${ucc.outputVLN }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输出电压L-地</th>
			<td width="25%"><input id="outputVLD" name="outputVLD" value="${ucc.outputVLD }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输出电压N-地</th>
			<td width="25%"><input id="outputVND" name="outputVND" value="${ucc.outputVND }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">输出电流</th>
			<td width="25%"><input id="outputCurrent" name="outputCurrent" value="${ucc.outputCurrent }" /></td>
		</tr>
		<tr>
			<th width="30%" colspan="2">空开温度</th>
			<td width="25%"><input id="outputAirTemperature" name="outputAirTemperature" value="${ucc.outputAirTemperature }" /></td>
		</tr>
		<tr>
			<th width="60%" colspan="4">设备除尘化</th>
			<td width="25%">
				<select id="equipDustRemoval" name="equipDustRemoval">
					<option value="${ucc.equipDustRemoval }">${ucc.equipDustRemoval.value }</option>
					<c:forEach items="${contentCheckResult}" var="vo">
						<c:if test="${ucc.equipDustRemoval.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
	</c:forEach>
	<!-- 电池测量 -->
		<!-- 电池测量 -->
		<tr><th width="100%" colspan="6"><font color="red">(*)</font>电池测量</th></tr>
		<tr>
			<th>电池序号</th>
			<th>端电压(V)</th>
			<th colspan="2">内阻</th>
			<th colspan="2">备注</th>
		</tr>
		<%-- <c:set var="num" value="${0 }"></c:set> --%>
		<c:forEach items="${upsCheck.batteryMeasure }" var="bm">
			<tr>
				<td>${bm.number }</td>
				<%-- <c:set var="num" value="${num+1 }"></c:set> --%>
				<td><input id="termialV" name="termialV" value="${bm.termialV }"/></td>
				<td colspan="2"><input id="interR" name="interR" value="${bm.interR }"/></td>
				<td colspan="2"><input id="remarks" name="remarks" value="${bm.remarks }"/></td>
			</tr>
		</c:forEach>
	<tr>
		<th colspan="1">存在问题</th>
		<td colspan="5"><textarea cols="150" id="problem" name="problem">${upsCheck.problem }</textarea></td>
	</tr>
	<tr>
		<th colspan="1">建议</th>
		<td colspan="5"><textarea cols="150" id="suggestion" name="suggestion">${upsCheck.suggestion }</textarea></td>
	</tr>
	<tr>
		<th colspan="1">结果</th>
		<td colspan="5"><textarea cols="150" id="result" name="result">${upsCheck.result }</textarea></td>
	</tr>
	<tr>
		<th>操作人：</th>
		<td colspan="2">${upsCheck.operator.name }</td>
		<th>巡检时间：</th>
		<td colspan="2">
			<fmt:formatDate value="${upsCheck.checkTime}" type="both" 
					pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
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