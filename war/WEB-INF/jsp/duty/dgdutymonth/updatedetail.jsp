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
		<th colspan="2">设备名称</th>
		<th colspan="2">${dgCheck.name }</th>
	</tr>
	<tr>
		<th width="30%" colspan="2">内容</th>
		<th width="40%">巡检结果</th>
		<th width="30%">检查状况</th>
	</tr>
	<c:forEach items="${dgCheck.dgCheckContent }" var="dcc">
		<!-- 环境 -->
		<tr>
			<th width="30%" colspan="2">环境</th>
			<td width="40%">
				<select id="enCheckResult" name="enCheckResult">
					<option value="${dcc.enCheckResult }">${dcc.enCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.enCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="enRemarks" value="${dcc.enRemarks }"/>
			</td>
		</tr>
		<!--机体加热  -->
		<tr>
			<th width="30%" colspan="2">机体加热 </th>
			<td width="40%">
				<select id="bhCheckResult" name="bhCheckResult">
					<option value="${dcc.bhCheckResult }">${dcc.bhCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.bhCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="bhRemarks" value="${dcc.bhRemarks }"/>
			</td>
		</tr>
		<!--发动机控制板示灯  -->
		<tr>
			<th width="30%" colspan="2">发动机控制板示灯</th>
			<td width="40%">
				<select id="ecpiCheckResult" name="ecpiCheckResult">
					<option value="${dcc.ecpiCheckResult }">${dcc.ecpiCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.ecpiCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="ecpiRemarks" value="${dcc.ecpiRemarks }"/>
			</td>
		</tr>
		<!-- 机房温湿度 -->
		<tr>
			<th width="30%" colspan="2">机房温湿度</th>
			<td width="40%">
				<select id="rmhCheckResult" name="rmhCheckResult">
					<option value="${dcc.rmhCheckResult }">${dcc.rmhCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.rmhCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="rmhRemarks" value="${dcc.rmhRemarks }"/>
			</td>
		</tr>
		<!-- 发动机运转检查 -->
		<tr>
			<th width="30%" colspan="2">发动机运转检查</th>
			<td width="40%">
				<select id="ercCheckResult" name="ercCheckResult">
					<option value="${dcc.ercCheckResult }">${dcc.ercCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.ercCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="ercRemarks" value="${dcc.ercRemarks }"/>
			</td>
		</tr>
		<c:if test="${dgCheck.checkType eq 'QUARTER' or dgCheck.checkType eq 'YEAR' }">
			<!--1号ATS  -->
			<tr>
				<th width="30%" colspan="2">1号ATS</th>
				<td width="40%">
					<select id="atsNumoneCheckResult" name="atsNumoneCheckResult">
						<option value="${dcc.atsNumoneCheckResult }">${dcc.atsNumoneCheckResult.value }</option>
						<c:forEach items="${checkresult}" var="vo">
							<c:if test="${dcc.atsNumoneCheckResult.value != vo.value }">
								<option value="${vo }">${vo.value }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td width="30%">
					<form:input path="atsNumoneRemarks" value="${dcc.atsNumoneRemarks }"/>
				</td>
			</tr>
			<!-- 2号ATS -->
			<tr>
				<th width="30%" colspan="2">2号ATS</th>
				<td width="40%">
					<select id="atsNumtwoCheckResult" name="atsNumtwoCheckResult">
						<option value="${dcc.atsNumtwoCheckResult }">${dcc.atsNumtwoCheckResult.value }</option>
						<c:forEach items="${checkresult}" var="vo">
							<c:if test="${dcc.atsNumtwoCheckResult.value != vo.value }">
								<option value="${vo }">${vo.value }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td width="30%">
					<form:input path="atsNumtwoRemarks" value="${dcc.atsNumtwoRemarks }"/>
				</td>
			</tr>
			<!--各单位切换护头  -->
			<tr>
				<th width="30%" colspan="2">各单位切换护头</th>
				<td width="40%">
					<select id="ushCheckResult" name="ushCheckResult">
						<option value="${dcc.ushCheckResult }">${dcc.ushCheckResult.value }</option>
						<c:forEach items="${checkresult}" var="vo">
							<c:if test="${dcc.ushCheckResult.value != vo.value }">
								<option value="${vo }">${vo.value }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td width="30%">
					<form:input path="ushRemarks" value="${dcc.ushRemarks }"/>
				</td>
			</tr>
			<!-- 电缆检测 -->
			<tr>
				<th width="30%" colspan="2">电缆检测</th>
				<td width="40%">
					<select id="cableTestResult" name="cableTestResult">
						<option value="${dcc.cableTestResult }">${dcc.cableTestResult.value }</option>
						<c:forEach items="${checkresult}" var="vo">
							<c:if test="${dcc.cableTestResult.value != vo.value }">
								<option value="${vo }">${vo.value }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<td width="30%">
					<form:input path="cableTestRemarks" value="${dcc.cableTestRemarks }"/>
				</td>
			</tr>
		</c:if>
		<!--润滑压力  -->
		<tr>
			<th width="30%" colspan="2">润滑压力</th>
			<td width="40%">
				<select id="lpCheckResult" name="lpCheckResult">
					<option value="${dcc.lpCheckResult }">${dcc.lpCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.lpCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="lpRemarks" value="${dcc.lpRemarks }"/>
			</td>
		</tr>
		<!-- 燃油压力 -->
		<tr>
			<th width="30%" colspan="2">燃油压力</th>
			<td width="40%">
				<select id="fpCheckResult" name="fpCheckResult">
					<option value="${dcc.fpCheckResult }">${dcc.fpCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.fpCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="fpRemarks" value="${dcc.fpRemarks }"/>
			</td>
		</tr>
		<!--机油系统  -->
		<tr>
			<th width="30%" colspan="2">环境</th>
			<td width="40%">
				<select id="osCheckResult" name="osCheckResult">
					<option value="${dcc.osCheckResult }">${dcc.osCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.osCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="osRemarks" value="${dcc.osRemarks }"/>
			</td>
		</tr>
		<!--冷却系统  -->
		<tr>
			<th width="30%" colspan="2">冷却系统</th>
			<td width="40%">
				<select id="csCheckResult" name="csCheckResult">
					<option value="${dcc.csCheckResult }">${dcc.csCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.csCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="csRemarks" value="${dcc.csRemarks }"/>
			</td>
		</tr>
		<!--燃料系统  -->
		<tr>
			<th width="30%" colspan="2">燃料系统</th>
			<td width="40%">
				<select id="fsCheckResult" name="fsCheckResult">
					<option value="${dcc.fsCheckResult }">${dcc.fsCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.fsCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="fsRemarks" value="${dcc.fsRemarks }"/>
			</td>
		</tr>
		<!--蓄电池液  -->
		<tr>
			<th width="30%" colspan="2">蓄电池液</th>
			<td width="40%">
				<select id="blCheckResult" name="blCheckResult">
					<option value="${dcc.blCheckResult }">${dcc.blCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.blCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="blRemarks" value="${dcc.blRemarks }"/>
			</td>
		</tr>
		<!-- 各个皮带 -->
		<tr>
			<th width="30%" colspan="2">各个皮带</th>
			<td width="40%">
				<select id="ebCheckResult" name="ebCheckResult">
					<option value="${dcc.ebCheckResult }">${dcc.ebCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.ebCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="ebRemarks" value="${dcc.ebRemarks }"/>
			</td>
		</tr>
		<!-- 空气系统 -->
		<tr>
			<th width="30%" colspan="2">空气系统</th>
			<td width="40%">
				<select id="asCheckResult" name="asCheckResult">
					<option value="${dcc.asCheckResult }">${dcc.asCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.asCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="asRemarks" value="${dcc.asRemarks }"/>
			</td>
		</tr>
		<!--散热器百叶窗  -->
		<tr>
			<th width="30%" colspan="2">散热器百叶窗</th>
			<td width="40%">
				<select id="rsCheckResult" name="rsCheckResult">
					<option value="${dcc.rsCheckResult }">${dcc.rsCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.rsCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="rsRemarks" value="${dcc.rsRemarks }"/>
			</td>
		</tr>
		<!-- 自动开关 -->
		<tr>
			<th width="30%" colspan="2">自动开关</th>
			<td width="40%">
				<select id="autosCheckResult" name="autosCheckResult">
					<option value="${dcc.autosCheckResult }">${dcc.autosCheckResult.value }</option>
					<c:forEach items="${checkresult}" var="vo">
						<c:if test="${dcc.autosCheckResult.value != vo.value }">
							<option value="${vo }">${vo.value }</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td width="30%">
				<form:input path="autosRemarks" value="${dcc.autosRemarks }"/>
			</td>
		</tr>
		<!-- 启动电池电压（V） -->
		<tr>
			<th width="30%" colspan="2">启动电池电压(V)</th>
			<td width="40%"><form:input  path="sbvCheckResult" value="${dcc.sbvCheckResult }"/></td>
			<td width="30%"><form:input  path="sbvRemarks" value="${dcc.sbvRemarks }"/></td>
		</tr>
		<!-- 柴油压力(bar) -->
		<tr>
			<th width="30%" colspan="2">柴油压力(bar)</th>
			<td width="40%"><form:input  path="dopCheckResult" value="${dcc.dopCheckResult }"/></td>
			<td width="30%"><form:input  path="dopRemarks" value="${dcc.dopRemarks }"/></td>
		</tr>
		<!--机油压力 (bar)  -->
		<tr>
			<th width="30%" colspan="2">机油压力(bar)</th>
			<td width="40%"><form:input  path="opCheckResult" value="${dcc.opCheckResult }"/></td>
			<td width="30%"><form:input  path="opRemarks" value="${dcc.opRemarks }"/></td>
		</tr>
		<!--功率因数  -->
		<tr>
			<th width="30%" colspan="2">功率因数</th>
			<td width="40%"><form:input  path="pfCheckResult" value="${dcc.pfCheckResult }"/></td>
			<td width="30%"><form:input  path="pfRemarks" value="${dcc.pfRemarks }"/></td>
		</tr>
		<!-- 发动机转速 (r/min) -->
		<tr>
			<th width="30%" colspan="2">发动机转速 (r/min)</th>
			<td width="40%"><form:input  path="epCheckResult" value="${dcc.epCheckResult }"/></td>
			<td width="30%"><form:input  path="epRemarks" value="${dcc.epRemarks }"/></td>
		</tr>
		<!--发动机水温   (℃)  -->
		<tr>
			<th width="30%" colspan="2">发动机水温 (℃)</th>
			<td width="40%"><form:input  path="ewtCheckResult" value="${dcc.ewtCheckResult }"/></td>
			<td width="30%"><form:input  path="ewtRemarks" value="${dcc.ewtRemarks }"/></td>
		</tr>
		<!-- 相电压(V) -->
		<tr>
			<th width="20%" rowspan="3">相电压(V)</th>
			<th width="10%">A-N</th>
			<td width="40%"><form:input  path="pvANCheckResult" value="${dcc.pvANCheckResult }"/></td>
			<td width="30%"><form:input  path="pvANRemarks" value="${dcc.pvANRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">B-N</th>
			<td width="40%"><form:input  path="pvBNCheckResult" value="${dcc.pvBNCheckResult }"/></td>
			<td width="30%"><form:input  path="pvBNRemarks" value="${dcc.pvBNRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">C-N</th>
			<td width="40%"><form:input  path="pvCNCheckResult" value="${dcc.pvCNCheckResult }"/></td>
			<td width="30%"><form:input  path="pvCNRemarks" value="${dcc.pvCNRemarks }"/></td>
		</tr>
		
		<!-- 线电压(V) -->
		<tr>
			<th width="20%" rowspan="3">线电压(V)</th>
			<th width="10%">A-B</th>
			<td width="40%"><form:input  path="lvABCheckResult" value="${dcc.lvABCheckResult }"/></td>
			<td width="30%"><form:input  path="lvABRemarks" value="${dcc.lvABRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">A-C</th>
			<td width="40%"><form:input  path="lvACCheckResult" value="${dcc.lvACCheckResult }"/></td>
			<td width="30%"><form:input  path="lvACRemarks" value="${dcc.lvACRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">B-C</th>
			<td width="40%"><form:input  path="lvBCCheckResult" value="${dcc.lvBCCheckResult }"/></td>
			<td width="30%"><form:input  path="lvBCRemarks" value="${dcc.lvBCRemarks }"/></td>
		</tr>
		<!-- 电流(A) -->
		<tr>
			<th width="20%" rowspan="3">电流(A)</th>
			<th width="10%">A相</th>
			<td width="40%"><form:input  path="caCheckResult" value="${dcc.caCheckResult }"/></td>
			<td width="30%"><form:input  path="caRemarks" value="${dcc.caRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">B相</th>
			<td width="40%"><form:input  path="cbCheckResult" value="${dcc.cbCheckResult }"/></td>
			<td width="30%"><form:input  path="cbRemarks" value="${dcc.cbRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">C相</th>
			<td width="40%"><form:input  path="ccCheckResult" value="${dcc.ccCheckResult }"/></td>
			<td width="30%"><form:input  path="ccRemarks" value="${dcc.ccRemarks }"/></td>
		</tr>
		<!-- 功率(KW) -->
		<tr>
			<th width="20%" rowspan="3">功率(KW)</th>
			<th width="10%">A相</th>
			<td width="40%"><form:input  path="paCheckResult" value="${dcc.paCheckResult }"/></td>
			<td width="30%"><form:input  path="paRemarks" value="${dcc.paRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">B相</th>
			<td width="40%"><form:input  path="pbCheckResult" value="${dcc.pbCheckResult }"/></td>
			<td width="30%"><form:input  path="pbRemarks" value="${dcc.pbRemarks }"/></td>
		</tr>
		<tr>
			<th width="10%">C相</th>
			<td width="40%"><form:input  path="pcCheckResult" value="${dcc.pcCheckResult }"/></td>
			<td width="30%"><form:input  path="pcRemarks" value="${dcc.pcRemarks }"/></td>
		</tr>
	</c:forEach>
	<tr>
		<th >操作人：</th>
		<td width="25%" >${dgCheck.operator.name }</td>
		<th >巡检时间：</th>
		<td >
			<fmt:formatDate value="${dgCheck.checkTime}" type="both" 
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
