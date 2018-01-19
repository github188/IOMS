<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>ups设备检查</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<th colspan="3">设备名称</th>
		<th colspan="3">
			<form:select path="name" cssStyle="width:200px">
				<c:forEach items="${slhUpsName}" var="vo">
					<option value="${vo.value}">${vo.value}</option>
				</c:forEach>
			</form:select>
		</th>
	</tr>
	<tr>
		<th width="15%" rowspan="15">巡检内容</th>
		<th width="30%" rowspan="3" colspan="2">环境</th>
		<th width="30%" colspan="2">环境温度是否可调</th>
		<td width="25%">
			<c:choose>
				<c:when test="${not empty upsCheck.upsContentCheck}">
					${upsCheck.upsContentCheck.atIsAdjustable.value}
				</c:when>
				<c:otherwise>
					<select id="atIsAdjustable" name="atIsAdjustable">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
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
		<th width="30%" rowspan="10" colspan="2">外观</th>
		<th width="30%" colspan="2">设备外观是否完好</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.eaIsIntact.value}
				</c:when>
				<c:otherwise>
					<select id="eaIsIntact" name="eaIsIntact">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS及电池柜的散热是否正常</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.radiateIsNormal.value}
				</c:when>
				<c:otherwise>
					<select id="radiateIsNormal" name="radiateIsNormal">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">设备外壳对地是否有电压</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.esGroundVoltage.value}
				</c:when>
				<c:otherwise>
					<select id="esGroundVoltage" name="esGroundVoltage">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS运行声音是否正常</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.upsRvIsNormal.value}
				</c:when>
				<c:otherwise>
					<select id="upsRvIsNormal" name="upsRvIsNormal">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS界面显示是否正常</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.upsUidisIsNormal.value}
				</c:when>
				<c:otherwise>
					<select id="upsUidisIsNormal" name="upsUidisIsNormal">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">房间内空气是否流通</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.raIsFlow.value}
				</c:when>
				<c:otherwise>
					<select id="raIsFlow" name="raIsFlow">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">电池无漏夜现象</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.batLeakage.value}
				</c:when>
				<c:otherwise>
					<select id="batLeakage" name="batLeakage">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS出风口是否干净</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.upsOutletIsClean.value}
				</c:when>
				<c:otherwise>
					<select id="upsOutletIsClean" name="upsOutletIsClean">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">电池表面是否干净</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.batSurfaceIsClean.value}
				</c:when>
				<c:otherwise>
					<select id="batSurfaceIsClean" name="batSurfaceIsClean">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">连接端子无腐蚀氧化</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.connCo.value}
				</c:when>
				<c:otherwise>
					<select id="connCo" name="connCo">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" rowspan="2" colspan="2">告警</th>
		<th width="30%" colspan="2">UPS是否有当前故障告警</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.upsCurFAlarm.value}
				</c:when>
				<c:otherwise>
					<select id="upsCurFAlarm" name="upsCurFAlarm">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="30%" colspan="2">UPS是否有重要历史告警</th>
		<td>
			<c:choose>
				<c:when test="${not empty upsCheck}">
					${upsCheck.upsContentCheck.upsHisFAlarm.value}
				</c:when>
				<c:otherwise>
					<select id="upsHisFAlarm" name="upsHisFAlarm">
						<c:forEach items="${checkresult}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<!-- 系统测量 -->
	<tr><th width="100%" colspan="6">系统测量</th></tr>
	<tr>
		<th width="15%" rowspan="2">市供电参数</th>
		<th width="30" colspan="2">界面显示值</th>
		<th width="30" colspan="2">实际测量值</th>
		<th width="25" rowspan="2">备注</th>
	</tr>
	<tr>
		<th width="15%">输入</th>
		<th width="15%">输出</th>
		<th width="15%">输入</th>
		<th width="15%">输出</th>
	</tr>
	<tr>
		<th width="15%" rowspan="3">相电压(V)</th>
		<td width="15%">A-N</td>
		<td width="15%"><form:input path="pvANDisOutValue" /></td>
		<td width="15%"><form:input path="pvANMeaInValue"/></td>
		<td width="15%"><form:input path="pvANMeaOutValue"/></td>
		<td width="25%"><form:input path="pvANRemark"/></td>
	</tr>
	<tr>
		<td width="15%">B-N</td>
		<td width="15%"><form:input path="pvBNDisOutValue" /></td>
		<td width="15%"><form:input path="pvBNMeaInValue"/></td>
		<td width="15%"><form:input path="pvBNMeaOutValue"/></td>
		<td width="25%"><form:input path="pvBNRemark"/></td>
	</tr>
	<tr>
		<td width="15%">C-N</td>
		<td width="15%"><form:input path="pvCNDisOutValue" /></td>
		<td width="15%"><form:input path="pvCNMeaInValue"/></td>
		<td width="15%"><form:input path="pvCNMeaOutValue"/></td>
		<td width="25%"><form:input path="pvCNRemark"/></td>
	</tr>
	<tr>
		<th width="15%" rowspan="3">线电压(V)</th>
		<td width="15%">A-B</td>
		<td width="15%"><form:input path="lvABDisOutValue" /></td>
		<td width="15%"><form:input path="lvABMeaInValue"/></td>
		<td width="15%"><form:input path="lvABMeaOutValue"/></td>
		<td width="25%"><form:input path="lvABRemark"/></td>
	</tr>
	<tr>
		<td width="15%">A-C</td>
		<td width="15%"><form:input path="lvACDisOutValue" /></td>
		<td width="15%"><form:input path="lvACMeaInValue"/></td>
		<td width="15%"><form:input path="lvACMeaOutValue"/></td>
		<td width="25%"><form:input path="lvACRemark"/></td>
	</tr>
	<tr>
		<td width="15%">B-C</td>
		<td width="15%"><form:input path="lvBCDisOutValue" /></td>
		<td width="15%"><form:input path="lvBCMeaInValue"/></td>
		<td width="15%"><form:input path="lvBCMeaOutValue"/></td>
		<td width="25%"><form:input path="lvBCRemark"/></td>
	</tr>
	<tr>
		<th width="15%" rowspan="3">电流(A)</th>
		<td width="15%">A相</td>
		<td width="15%"><form:input path="pcADisOutValue" /></td>
		<td width="15%"><form:input path="pcAMeaInValue"/></td>
		<td width="15%"><form:input path="pcAMeaOutValue"/></td>
		<td width="25%"><form:input path="pcARemark"/></td>
	</tr>
	<tr>
		<td width="15%">B相</td>
		<td width="15%"><form:input path="pcBDisOutValue" /></td>
		<td width="15%"><form:input path="pcBMeaInValue"/></td>
		<td width="15%"><form:input path="pcBMeaOutValue"/></td>
		<td width="25%"><form:input path="pcBRemark"/></td>
	</tr>
	<tr>
		<td width="15%">C相</td>
		<td width="15%"><form:input path="pcCDisOutValue" /></td>
		<td width="15%"><form:input path="pcCMeaInValue"/></td>
		<td width="15%"><form:input path="pcCMeaOutValue"/></td>
		<td width="25%"><form:input path="pcCRemark"/></td>
	</tr>
	<tr>
		<th width="15%" rowspan="3">功率(KVA)百分比</th>
		<td width="15%">A相</td>
		<td width="15%"><form:input path="ppADisOutValue" /></td>
		<td width="15%">计算值：</td>
		<td width="15%"><form:input path="ppAMeaCalValue"/></td>
		<td width="25%"><form:input path="ppARemark"/></td>
	</tr>
	<tr>
		<td width="15%">B相</td>
		<td width="15%"><form:input path="ppBDisOutValue" /></td>
		<td width="15%">计算值：</td>
		<td width="15%"><form:input path="ppBMeaCalValue"/></td>
		<td width="25%"><form:input path="ppBRemark"/></td>
	</tr>
	<tr>
		<td width="15%">C相</td>
		<td width="15%"><form:input path="ppCDisOutValue" /></td>
		<td width="15%">计算值：</td>
		<td width="15%"><form:input path="ppCMeaCalValue"/></td>
		<td width="25%"><form:input path="ppCRemark"/></td>
	</tr>
	<!-- 零地电压及零线电流测量 -->
	<tr><th width="100%" colspan="6">零地电压及零线电流测量</th></tr>
	<tr>
		<th colspan="2">内容</th>
		<th colspan="2">测试结果</th>
		<th colspan="2">备注</th>
	</tr>
	<tr>
		<td colspan="2">输入端零地电压(V)</td>
		<td colspan="2"><form:input path="zgvInputResult"/></td>
		<td colspan="2"><form:input path="zgvInputRemark"/></td>
	</tr>
	<tr>
		<td colspan="2">输出端零地电压(V)</td>
		<td colspan="2"><form:input path="zgvOutputResult"/></td>
		<td colspan="2"><form:input path="zgvOutputRemark"/></td>
	</tr>
	<tr>
		<td rowspan="2">零线电流测量(A)</td>
		<td>输入端：</td>
		<td colspan="2"><form:input path="zlcInputResult"/></td>
		<td colspan="2"><form:input path="zlcInputRemark"/></td>
	</tr>
	<tr>
		<td>输出端：</td>
		<td colspan="2"><form:input path="zlcOutputResult"/></td>
		<td colspan="2"><form:input path="zlcOutputRemark"/></td>
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
			<td><form:input path="number" value="21" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="22" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="23" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="24" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="25" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="26" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="27" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="28" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="29" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="30" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
		<tr>
			<td><form:input path="number" value="31" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
	<tr>
			<td><form:input path="number" value="32" readonly="true" cssStyle="text-align:center"/></td>
			<td><form:input path="termialV"/></td>
			<td colspan="2"><form:input path="interR"/></td>
			<td colspan="2"><form:input path="remarks"/></td>
	</tr>
	<!-- 系统连接检查 -->
	<tr><th width="100%" colspan="6">系统连接检查</th></tr>
	<tr>
		<th>序号</th>
		<th>内容</th>
		<th colspan="2">测试结果</th>
		<th colspan="2">备注</th>
	</tr>
	<tr>
		<td>1</td>
		<td>UPS内部连接端子是否牢固</td>
		<td colspan="2"><form:input path="upsIcTr"/></td>
		<td colspan="2"><form:input path="upsIcRemark"/></td>
	</tr>
	<tr>
		<td>2</td>
		<td>UPS风扇运转是否正常</td>
		<td colspan="2"><form:input path="upsFRunTr"/></td>
		<td colspan="2"><form:input path="upsFRunRemark"/></td>
	</tr>
	<tr>
		<td>3</td>
		<td>UPS内部板卡是否牢固</td>
		<td colspan="2"><form:input path="upsIbFirmTr"/></td>
		<td colspan="2"><form:input path="upsIbFirmRemark"/></td>
	</tr>
	<tr>
		<td>4</td>
		<td>UPS连接导线是否无过热现象</td>
		<td colspan="2"><form:input path="upsCwOhTr"/></td>
		<td colspan="2"><form:input path="upsCwOhRemark"/></td>
	</tr>
	<tr>
		<td>5</td>
		<td>UPS运行声音是否正常</td>
		<td colspan="2"><form:input path="upsRvTr"/></td>
		<td colspan="2"><form:input path="upsRvRemark"/></td>
	</tr>
	<tr>
		<td>6</td>
		<td>电池连接端子是否牢固</td>
		<td colspan="2"><form:input path="batCTr"/></td>
		<td colspan="2"><form:input path="batCRemark"/></td>
	</tr>
	<tr>
		<td>7</td>
		<td>UPS至配电柜的输入和输出导线是否完好</td>
		<td colspan="2"><form:input path="upsPdcIowTr"/></td>
		<td colspan="2"><form:input path="upsPdcIowRemark"/></td>
	</tr>
	<tr>
		<td>8</td>
		<td>电池组直流母线是否完好</td>
		<td colspan="2"><form:input path="bpdbTr"/></td>
		<td colspan="2"><form:input path="bpdbRemark"/></td>
	</tr>
	<tr>
		<td>9</td>
		<td>配电柜内连接端子是否牢固</td>
		<td colspan="2"><form:input path="pdcCTr"/></td>
		<td colspan="2"><form:input path="pdcCRemark"/></td>
	</tr>
	<tr>
		<td>10</td>
		<td>配电柜仪表及指示灯是否正常</td>
		<td colspan="2"><form:input path="pdcMIlTr"/></td>
		<td colspan="2"><form:input path="pdcMIlRemark"/></td>
	</tr>
	<tr>
		<td>11</td>
		<td>各断路器是否无发热及杂声现象</td>
		<td colspan="2"><form:input path="bfnTr"/></td>
		<td colspan="2"><form:input path="bfnRemark"/></td>
	</tr>
	<tr>
		<td>12</td>
		<td>到负载端的连接导线是否无发热</td>
		<td colspan="2"><form:input path="ltCwFTr"/></td>
		<td colspan="2"><form:input path="ltCwFRemark"/></td>
	</tr>
	<tr>
		<td>13</td>
		<td>到负载端的各回路电流是否在安全运行范围之内</td>
		<td colspan="2"><form:input path="ltLcTr"/></td>
		<td colspan="2"><form:input path="ltLcRemark"/></td>
	</tr>
	<tr>
		<td>14</td>
		<td>到负载端的各插座是否运行正常</td>
		<td colspan="2"><form:input path="ltSTr"/></td>
		<td colspan="2"><form:input path="ltSRemark"/></td>
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