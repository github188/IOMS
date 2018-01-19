<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	window.onload = function(){
	    subFn = function(){
	        var startTime = $('#startTime').val();
	        startTime = new Date(startTime.replace(/-/g,"/"));
	        var endTime = $('#endTime').val();
	        endTime = new Date(endTime.replace(/-/g,"/"));
	        var subTime = (endTime - startTime)/1000/60;
	        $('#durationTime').val(subTime);
	    }
	}
</script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>ups设备检查</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<th colspan="3">设备名称</th>
		<th colspan="3">${upsCheck.name }</th>
	</tr>
	<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
		<tr>
			<th width="15%" rowspan="15"><font color="red">(*)</font>巡检内容</th>
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
			<th width="30%" rowspan="10" colspan="2">外观</th>
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
			<th width="30%" colspan="2">设备外壳对地是否有电压</th>
			<td width="25%">
				<select id="esGroundVoltage" name="esGroundVoltage">
					<option value="${ucc.esGroundVoltage }">${ucc.esGroundVoltage.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.esGroundVoltage.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">UPS运行声音是否正常</th>
			<td width="25%">
				<select id="upsRvIsNormal" name="upsRvIsNormal">
					<option value="${ucc.upsRvIsNormal }">${ucc.upsRvIsNormal.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.upsRvIsNormal.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">UPS界面显示是否正常</th>
			<td width="25%">
				<select id="upsUidisIsNormal" name="upsUidisIsNormal">
					<option value="${ucc.upsUidisIsNormal }">${ucc.upsUidisIsNormal.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.upsUidisIsNormal.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">房间内空气是否流通</th>
			<td width="25%">
				<select id="raIsFlow" name="raIsFlow">
					<option value="${ucc.raIsFlow }">${ucc.raIsFlow.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.raIsFlow.value != vo.value }">
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
			<th width="30%" colspan="2">UPS出风口是否干净</th>
			<td width="25%">
				<select id="upsOutletIsClean" name="upsOutletIsClean">
					<option value="${ucc.upsOutletIsClean }">${ucc.upsOutletIsClean.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.upsOutletIsClean.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
			<tr>
			<th width="30%" colspan="2">电池表面是否干净</th>
			<td width="25%">
				<select id="batSurfaceIsClean" name="batSurfaceIsClean">
					<option value="${ucc.batSurfaceIsClean }">${ucc.batSurfaceIsClean.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.batSurfaceIsClean.value != vo.value }">
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
		<tr>
			<th width="30%" rowspan="2" colspan="2">告警</th>
			<th width="30%" colspan="2">UPS是否有当前故障告警</th>
			<td width="25%">
				<select id="upsCurFAlarm" name="upsCurFAlarm">
					<option value="${ucc.upsCurFAlarm }">${ucc.upsCurFAlarm.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.upsCurFAlarm.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="30%" colspan="2">UPS是否有重要历史告警</th>
			<td width="25%">
				<select id="upsHisFAlarm" name="upsHisFAlarm">
					<option value="${ucc.upsHisFAlarm }">${ucc.upsHisFAlarm.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${ucc.upsHisFAlarm.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th width="60%" colspan="4">设备除尘</th>
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
		<!-- 系统测量 -->
		<c:forEach items="${upsCheck.systemMeasure }" var="sm">
			<tr><th width="100%" colspan="6"><font color="red">(*)</font>系统测量</th></tr>
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
				<td width="15%"><input id="pvANDisOutValue" name="pvANDisOutValue" value="${sm.pvANDisOutValue }"/></td>
				<td width="15%"><input id="pvANMeaInValue" name="pvANMeaInValue" value="${sm.pvANMeaInValue }"/></td>
				<td width="15%"><input id="pvANMeaOutValue" name="pvANMeaOutValue" value="${sm.pvANMeaOutValue }"/></td>
				<td width="25%"><input id="pvANRemark" name="pvANRemark" value="${sm.pvANRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">B-N</td>
				<td width="15%"><input id="pvBNDisOutValue" name="pvBNDisOutValue" value="${sm.pvBNDisOutValue }"/></td>
				<td width="15%"><input id="pvBNMeaInValue" name="pvBNMeaInValue" value="${sm.pvBNMeaInValue }"/></td>
				<td width="15%"><input id="pvBNMeaOutValue" name="pvBNMeaOutValue" value="${sm.pvBNMeaOutValue }"/></td>
				<td width="25%"><input id="pvBNRemark" name="pvBNRemark" value="${sm.pvBNRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">C-N</td>
				<td width="15%"><input id="pvCNDisOutValue" name="pvCNDisOutValue" value="${sm.pvCNDisOutValue }"/></td>
				<td width="15%"><input id="pvCNMeaInValue" name="pvCNMeaInValue"  value="${sm.pvCNMeaInValue }"/></td>
				<td width="15%"><input id="pvCNMeaOutValue" name="pvCNMeaOutValue" value="${sm.pvCNMeaOutValue }"/></td>
				<td width="25%"><input id="pvCNRemark" name="pvCNRemark" value="${sm.pvCNRemark }"/></td>
			</tr>
			<tr>
				<th width="15%" rowspan="3">线电压(V)</th>
				<td width="15%">A-B</td>
				<td width="15%"><input id="lvABDisOutValue" name="lvABDisOutValue" value="${sm.lvABDisOutValue }"/></td>
				<td width="15%"><input id="lvABMeaInValue" name="lvABMeaInValue" value="${sm.lvABMeaInValue }"/></td>
				<td width="15%"><input id="lvABMeaOutValue" name="lvABMeaOutValue" value="${sm.lvABMeaOutValue }"/></td>
				<td width="25%"><input id="lvABRemark" name="lvABRemark" value="${sm.lvABRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">A-C</td>
				<td width="15%"><input id="lvACDisOutValue" name="lvACDisOutValue" value="${sm.lvACDisOutValue }"/></td>
				<td width="15%"><input id="lvACMeaInValue" name="lvACMeaInValue" value="${sm.lvACMeaInValue }"/></td>
				<td width="15%"><input id="lvACMeaOutValue" name="lvACMeaOutValue" value="${sm.lvACMeaOutValue }"/></td>
				<td width="25%"><input id="lvACRemark" name="lvACRemark" value="${sm.lvACRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">B-C</td>
				<td width="15%"><input id="lvBCDisOutValue" name="lvBCDisOutValue" value="${sm.lvBCDisOutValue }"/></td>
				<td width="15%"><input id="lvBCMeaInValue" name="lvBCMeaInValue" value="${sm.lvBCMeaInValue }"/></td>
				<td width="15%"><input id="lvBCMeaOutValue" name="lvBCMeaOutValue" value="${sm.lvBCMeaOutValue }"/></td>
				<td width="25%"><input id="lvBCRemark" name="lvBCRemark" value="${sm.lvBCRemark }"/></td>
			</tr>
			<tr>
				<th width="15%" rowspan="3">电流(A)</th>
				<td width="15%">A相</td>
				<td width="15%"><input id="pcADisOutValue" name="pcADisOutValue" value="${sm.pcADisOutValue }"/></td>
				<td width="15%"><input id="pcAMeaInValue" name="pcAMeaInValue" value="${sm.pcAMeaInValue }"/></td>
				<td width="15%"><input id="pcAMeaOutValue" name="pcAMeaOutValue" value="${sm.pcAMeaOutValue }"/></td>
				<td width="25%"><input id="pcARemark" name="pcARemark" value="${sm.pcARemark }"/></td>
			</tr>
			<tr>
				<td width="15%">B相</td>
				<td width="15%"><input id="pcBDisOutValue" name="pcBDisOutValue" value="${sm.pcBDisOutValue }"/></td>
				<td width="15%"><input id="pcBMeaInValue" name="pcBMeaInValue" value="${sm.pcBMeaInValue }"/></td>
				<td width="15%"><input id="pcBMeaOutValue"  name="pcBMeaOutValue" value="${sm.pcBMeaOutValue }"/></td>
				<td width="25%"><input id="pcBRemark" name="pcBRemark" value="${sm.pcBRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">C相</td>
				<td width="15%"><input id="pcCDisOutValue" name="pcCDisOutValue" value="${sm.pcCDisOutValue }"/></td>
				<td width="15%"><input id="pcCMeaInValue"  name="pcCMeaInValue" value="${sm.pcCMeaInValue }"/></td>
				<td width="15%"><input id="pcCMeaOutValue" name="pcCMeaOutValue" value="${sm.pcCMeaOutValue }"/></td>
				<td width="25%"><input id="pcCRemark" name="pcCRemark" value="${sm.pcCRemark }"/></td>
			</tr>
			<tr>
				<th width="15%" rowspan="3">功率(KVA)百分比</th>
				<td width="15%">A相</td>
				<td width="15%"><input id="ppADisOutValue" name="ppADisOutValue" value="${sm.ppADisOutValue }"/></td>
				<td width="15%">计算值：</td>
				<td width="15%"><input id="ppAMeaCalValue" name="ppAMeaCalValue" value="${sm.ppAMeaCalValue }"/></td>
				<td width="25%"><input id="ppARemark"  name="ppARemark" value="${sm.ppARemark }"/></td>
			</tr>
			<tr>
				<td width="15%">B相</td>
				<td width="15%"><input id="ppBDisOutValue" name="ppBDisOutValue" value="${sm.ppBDisOutValue }"/></td>
				<td width="15%">计算值：</td>
				<td width="15%"><input id="ppBMeaCalValue"  name="ppBMeaCalValue" value="${sm.ppBMeaCalValue }"/></td>
				<td width="25%"><input id="ppBRemark"  name="ppBRemark" value="${sm.ppBRemark }"/></td>
			</tr>
			<tr>
				<td width="15%">C相</td>
				<td width="15%"><input id="ppCDisOutValue" name="ppCDisOutValue" value="${sm.ppCDisOutValue }"/></td>
				<td width="15%">计算值：</td>
				<td width="15%"><input id="ppCMeaCalValue" name="ppCMeaCalValue" value="${sm.ppCMeaCalValue }"/></td>
				<td width="25%"><input id="ppCRemark"  name="ppCRemark" value="${sm.ppCRemark }"/></td>
			</tr>
		</c:forEach>
		<!-- 零地电压及零线电流测试 -->
		<c:forEach items="${upsCheck.zgvZlcMeasure }" var="zzm">
			<tr><th width="100%" colspan="6"><font color="red">(*)</font>零地电压及零线电流测量</th></tr>
			<tr>
				<th colspan="2">内容</th>
				<th colspan="2">实际测量值</th>
				<th colspan="2">测试结果</th>
			</tr>
			<tr>
				<td colspan="2">输入端零地电压(V)</td>
				<td colspan="2"><input id="zgvInputMeasure" name="zgvInputMeasure" value="${zzm.zgvInputMeasure }"/></td>
				<td colspan="2"><input id="zgvInputResult" name="zgvInputResult" value="${zzm.zgvInputResult }"/></td>
			</tr>
			<tr>
				<td colspan="2">输出端零地电压(V)</td>
				<td colspan="2"><input id="zgvOutputMeasure" name="zgvOutputMeasure" value="${zzm.zgvOutputMeasure }"/></td>
				<td colspan="2"><input id="zgvOutputResult" name="zgvOutputResult" value="${zzm.zgvOutputResult }"/></td>
			</tr>
			<tr>
				<td rowspan="2">零线电流测量(A)</td>
				<td>输入端：</td>
				<td colspan="2"><input id="zlcInputMeasure"  name="zlcInputMeasure" value="${zzm.zlcInputMeasure }"/></td>
				<td colspan="2"><input id="zlcInputResult" name="zlcInputResult" value="${zzm.zlcInputResult }"/></td>
			</tr>
			<tr>
				<td>输出端：</td>
				<td colspan="2"><input id="zlcOutputMeasure" name="zlcOutputMeasure" value="${zzm.zlcOutputMeasure }"/></td>
				<td colspan="2"><input id="zlcOutputResult" name="zlcOutputResult" value="${zzm.zlcOutputResult }"/></td>
			</tr>
		</c:forEach>
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
		<!-- 放电测试 -->
		<tr><th width="100%" colspan="6"><font color="red">(*)</font>放电测试</th></tr>
		<c:forEach items="${upsCheck.dischargeTest }" var="dt">
			<tr>
				<td colspan="2">放电开始时间：
					<form:input cssStyle="width:120px" path="startTime" value="${dt.startTime}"
						cssClass="inputDate" readonly="true"
						onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}', onpicked:function(){subFn();}});" />
					<img src="${rootUrl}images/datePicker.gif"
				 		onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}', onpicked:function(){subFn();}});"
				 		style="cursor: pointer;" />
				</td>
				<td colspan="2">放电结束时间
					<form:input cssStyle="width:120px" path="endTime" value="${dt.endTime}"
						cssClass="inputDate" readonly="true"
						onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}', onpicked:function(){subFn();}});" />
					<img src="${rootUrl}images/datePicker.gif"
				 		onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}', onpicked:function(){subFn();}});"
				 		style="cursor: pointer;" />
				</td>
				<td colspan="2">放电持续时间：<form:input id="durationTime" path="durationTime" value="${dt.durationTime }" onFocus="subFn()"/></td>
			</tr>
			<tr>
				<td colspan="2">放电前总电压： <form:input path="preTotalV" value="${dt.preTotalV }"/></td>
				<td colspan="2">放电终止总电压：<form:input path="endTotalV" value="${dt.endTotalV }"/></td>
				<td colspan="2">电池充电电流：<form:input path="batChargingC" value="${dt.batChargingC }"/></td>
			</tr>
			<tr>
				<th>放电时间(分钟)</th>
				<th>电池总电压</th>
				<th>放电电流</th>
				<th>单节最高电压</th>
				<th>单节最低电压</th>
				<th>备注</th>
		    </tr>
	        <c:forEach items="${dt.dischargeProcess }" var="dp">
	            <tr>
	            	<td><form:input path="dsTime" value="${dp.dsTime }"/></td>
	            	<td><form:input path="batTotalV" value="${dp.batTotalV }"/></td>
	            	<td><form:input path="dsCurrent" value="${dp.dsCurrent }"/></td>
	            	<td><form:input path="singleMaxV" value="${dp.singleMaxV }"/></td>
	            	<td><form:input path="singleMinV" value="${dp.singleMinV }"/></td>
	            	<td><form:input path="remark" value="${dp.remark }"/></td>
	            </tr>
	         </c:forEach>
		</c:forEach>
		<!-- 系统连接检查 -->
		<tr><th width="100%" colspan="6"><font color="red">(*)</font>系统连接检查</th></tr>
		<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
			<tr>
				<th>序号</th>
				<th>内容</th>
				<th colspan="2">测试结果</th>
				<th colspan="2">备注</th>
			</tr>
			<tr>
				<td>1</td>
				<td>UPS内部连接端子是否牢固</td>
				<td colspan="2"><input id="upsIcTr" name="upsIcTr" value="${scm.upsIcTr }"/></td>
				<td colspan="2"><input id="upsIcRemark" name="upsIcRemark" value="${scm.upsIcRemark }"/></td>
			</tr>
			<tr>
				<td>2</td>
				<td>UPS风扇运转是否正常</td>
				<td colspan="2"><input id="upsFRunTr" name="upsFRunTr" value="${scm.upsFRunTr }"/></td>
				<td colspan="2"><input id="upsFRunRemark" name="upsFRunRemark" value="${scm.upsFRunRemark }"/></td>
			</tr>
			<tr>
				<td>3</td>
				<td>UPS内部板卡是否牢固</td>
				<td colspan="2"><input id="upsIbFirmTr" name="upsIbFirmTr" value="${scm.upsIbFirmTr }"/></td>
				<td colspan="2"><input id="upsIbFirmRemark" name="upsIbFirmRemark" value="${scm.upsIbFirmRemark }"/></td>
			</tr>
			<tr>
				<td>4</td>
				<td>UPS连接导线是否无过热现象</td>
				<td colspan="2"><input id="upsCwOhTr" name="upsCwOhTr" value="${scm.upsCwOhTr }"/></td>
				<td colspan="2"><input id="upsCwOhRemark" name="upsCwOhRemark" value="${scm.upsCwOhRemark }"/></td>
			</tr>
			<tr>
				<td>5</td>
				<td>UPS运行声音是否正常</td>
				<td colspan="2"><input id="upsRvTr" name="upsRvTr" value="${scm.upsRvTr }"/></td>
				<td colspan="2"><input id="upsRvRemark" name="upsRvRemark" value="${scm.upsRvRemark }"/></td>
			</tr>
			<tr>
				<td>6</td>
				<td>电池连接端子是否牢固</td>
				<td colspan="2"><input id="batCTr" name="batCTr" value="${scm.batCTr }"/></td>
				<td colspan="2"><input id="batCRemark" name="batCRemark" value="${scm.batCRemark }"/></td>
			</tr>
			<tr>
				<td>7</td>
				<td>UPS至配电柜的输入和输出导线是否完好</td>
				<td colspan="2"><input id="upsPdcIowTr" name="upsPdcIowTr" value="${scm.upsPdcIowTr }"/></td>
				<td colspan="2"><input id="upsPdcIowRemark" name="upsPdcIowRemark" value="${scm.upsPdcIowRemark }"/></td>
			</tr>
			<tr>
				<td>8</td>
				<td>电池组直流母线是否完好</td>
				<td colspan="2"><input id="bpdbTr" name="bpdbTr" value="${scm.bpdbTr }"/></td>
				<td colspan="2"><input id="bpdbRemark" name="bpdbRemark" value="${scm.bpdbRemark }"/></td>
			</tr>
			<tr>
				<td>9</td>
				<td>配电柜内连接端子是否牢固</td>
				<td colspan="2"><input id="pdcCTr" name="pdcCTr" value="${scm.pdcCTr }"/></td>
				<td colspan="2"><input id="pdcCRemark" name="pdcCRemark" value="${scm.pdcCRemark }"/></td>
			</tr>
			<tr>
				<td>10</td>
				<td>配电柜仪表及指示灯是否正常</td>
				<td colspan="2"><input id="pdcMIlTr" name="pdcMIlTr" value="${scm.pdcMIlTr }"/></td>
				<td colspan="2"><input id="pdcMIlRemark" name="pdcMIlRemark" value="${scm.pdcMIlRemark }"/></td>
			</tr>
			<tr>
				<td>11</td>
				<td>各断路器是否无发热及杂声现象</td>
				<td colspan="2"><input id="bfnTr" name="bfnTr" value="${scm.bfnTr }"/></td>
				<td colspan="2"><input id="bfnRemark" name="bfnRemark" value="${scm.bfnRemark }"/></td>
			</tr>
			<tr>
				<td>12</td>
				<td>到负载端的连接导线是否无发热</td>
				<td colspan="2"><input id="ltCwFTr" name="ltCwFTr" value="${scm.ltCwFTr }"/></td>
				<td colspan="2"><input id="ltCwFRemark" name="ltCwFRemark" value="${scm.ltCwFRemark }"/></td>
			</tr>
			<tr>
				<td>13</td>
				<td>到负载端的各回路电流是否在安全运行范围之内</td>
				<td colspan="2"><input id="ltLcTr" name="ltLcTr" value="${scm.ltLcTr }"/></td>
				<td colspan="2"><input id="ltLcRemark" name="ltLcRemark" value="${scm.ltLcRemark }"/></td>
			</tr>
			<tr>
				<td>14</td>
				<td>到负载端的各插座是否运行正常</td>
				<td colspan="2"><input id="ltSTr" name="ltSTr" value="${scm.ltSTr }"/></td>
				<td colspan="2"><input id="ltSRemark" name="ltSRemark" value="${scm.ltSRemark }"/></td>
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
