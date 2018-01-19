<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>柴油发电机设备月检记录添加</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">
			<form:select path="name" cssStyle="width:200px">
				<c:forEach items="${dgName}" var="vo">
					<option value="${vo.value}">${vo.value}</option>
				</c:forEach>
			</form:select>
		</th>
	</tr>
	<tr>
		<th width="30%" colspan="2">内容</th>
		<th width="40%">巡检结果</th>
		<th width="30%">检查状况</th>
	</tr>
	<!-- 环境 -->
	<tr>
		<th width="30%" colspan="2">环境</th>
		<td width="40%">
			<select id="enCheckResult" name="enCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="enRemarks" /></td>
	</tr>
	<!-- 机体加热 -->
	<tr>
		<th width="30%" colspan="2">机体加热</th>
		<td width="40%">
			<select id="bhCheckResult" name="bhCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="bhRemarks" /></td>
	</tr>
	<!-- 发动机控制板示灯 -->
	<tr>
		<th width="30%" colspan="2">发动机控制板示灯</th>
		<td width="40%">
			<select id="ecpiCheckResult" name="ecpiCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="ecpiRemarks" /></td>
	</tr>
	<!-- 机房温湿度 -->
	<tr>
		<th width="30%" colspan="2">机房温湿度</th>
		<td width="40%">
			<select id="rmhCheckResult" name="rmhCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="rmhRemarks" /></td>
	</tr>
	<!--发动机运转检查  -->
	<tr>
		<th width="30%" colspan="2">发动机运转检查</th>
		<td width="40%">
			<select id="ercCheckResult" name="ercCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="ercRemarks" /></td>
	</tr>
	<!--润滑压力  -->
	<tr>
		<th width="30%" colspan="2">润滑压力</th>
		<td width="40%">
			<select id="lpCheckResult" name="lpCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="lpRemarks" /></td>
	</tr>
	<!--燃油压力  -->
	<tr>
		<th width="30%" colspan="2">燃油压力</th>
		<td width="40%">
			<select id="fpCheckResult" name="fpCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="fpRemarks" /></td>
	</tr>
	<!-- 机油系统 -->
	<tr>
		<th width="30%" colspan="2">机油系统</th>
		<td width="40%">
			<select id="osCheckResult" name="osCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="osRemarks" /></td>
	</tr>
	<!-- 冷却系统 -->
	<tr>
		<th width="30%" colspan="2">冷却系统</th>
		<td width="40%">
			<select id="csCheckResult" name="csCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="csRemarks" /></td>
	</tr>
	<!--燃料系统  -->
	<tr>
		<th width="30%" colspan="2">燃料系统</th>
		<td width="40%">
			<select id="fsCheckResult" name="fsCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="fsRemarks" /></td>
	</tr>
	<!-- 蓄电池液 -->
	<tr>
		<th width="30%" colspan="2">蓄电池液</th>
		<td width="40%">
			<select id="blCheckResult" name="blCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="blRemarks" /></td>
	</tr>
	<!-- 各个皮带 -->
	<tr>
		<th width="30%" colspan="2">各个皮带</th>
		<td width="40%">
			<select id="ebCheckResult" name="ebCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="ebRemarks" /></td>
	</tr>
	<!--空气系统  -->
	<tr>
		<th width="30%" colspan="2">空气系统</th>
		<td width="40%">
			<select id="asCheckResult" name="asCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="asRemarks" /></td>
	</tr>
	<!--散热器百叶窗  -->
	<tr>
		<th width="30%" colspan="2">散热器百叶窗</th>
		<td width="40%">
			<select id="rsCheckResult" name="rsCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="rsRemarks" /></td>
	</tr>
	<!-- 自动开关 -->
	<tr>
		<th width="30%" colspan="2">自动开关</th>
		<td width="40%">
			<select id="autosCheckResult" name="autosCheckResult">
				<c:forEach items="${checkresult}" var="vo">
					<option value="${vo}">${vo.value}</option>
				</c:forEach>
			</select>
		</td>
		<td width="30%"><form:input  path="autosRemarks" /></td>
	</tr>
	<!-- 启动电池电压（V） -->
	<tr>
		<th width="30%" colspan="2">启动电池电压(V)</th>
		<td width="40%"><form:input  path="sbvCheckResult" /></td>
		<td width="30%"><form:input  path="sbvRemarks" /></td>
	</tr>
	<!-- 柴油压力(bar) -->
	<tr>
		<th width="30%" colspan="2">柴油压力(bar)</th>
		<td width="40%"><form:input  path="dopCheckResult" /></td>
		<td width="30%"><form:input  path="dopRemarks" /></td>
	</tr>
	<!--机油压力 (bar)  -->
	<tr>
		<th width="30%" colspan="2">机油压力(bar)</th>
		<td width="40%"><form:input  path="opCheckResult" /></td>
		<td width="30%"><form:input  path="opRemarks" /></td>
	</tr>
	<!--功率因数  -->
	<tr>
		<th width="30%" colspan="2">功率因数</th>
		<td width="40%"><form:input  path="pfCheckResult" /></td>
		<td width="30%"><form:input  path="pfRemarks" /></td>
	</tr>
	<!-- 发动机转速 (r/min) -->
	<tr>
		<th width="30%" colspan="2">发动机转速 (r/min)</th>
		<td width="40%"><form:input  path="epCheckResult" /></td>
		<td width="30%"><form:input  path="epRemarks" /></td>
	</tr>
	<!--发动机水温   (℃)  -->
	<tr>
		<th width="30%" colspan="2">发动机水温 (℃)</th>
		<td width="40%"><form:input  path="ewtCheckResult" /></td>
		<td width="30%"><form:input  path="ewtRemarks" /></td>
	</tr>
	<!-- 相电压(V) -->
	<tr>
		<th width="20%" rowspan="3">相电压(V)</th>
		<th width="10%">A-N</th>
		<td width="40%"><form:input  path="pvANCheckResult" /></td>
		<td width="30%"><form:input  path="pvANRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">B-N</th>
		<td width="40%"><form:input  path="pvBNCheckResult" /></td>
		<td width="30%"><form:input  path="pvBNRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">C-N</th>
		<td width="40%"><form:input  path="pvCNCheckResult" /></td>
		<td width="30%"><form:input  path="pvCNRemarks" /></td>
	</tr>
	
	<!-- 线电压(V) -->
	<tr>
		<th width="20%" rowspan="3">线电压(V)</th>
		<th width="10%">A-B</th>
		<td width="40%"><form:input  path="lvABCheckResult" /></td>
		<td width="30%"><form:input  path="lvABRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">A-C</th>
		<td width="40%"><form:input  path="lvACCheckResult" /></td>
		<td width="30%"><form:input  path="lvACRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">B-C</th>
		<td width="40%"><form:input  path="lvBCCheckResult" /></td>
		<td width="30%"><form:input  path="lvBCRemarks" /></td>
	</tr>
	<!-- 电流(A) -->
	<tr>
		<th width="20%" rowspan="3">电流(A)</th>
		<th width="10%">A相</th>
		<td width="40%"><form:input  path="caCheckResult" /></td>
		<td width="30%"><form:input  path="caRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">B相</th>
		<td width="40%"><form:input  path="cbCheckResult" /></td>
		<td width="30%"><form:input  path="cbRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">C相</th>
		<td width="40%"><form:input  path="ccCheckResult" /></td>
		<td width="30%"><form:input  path="ccRemarks" /></td>
	</tr>
	<!-- 功率(KW) -->
	<tr>
		<th width="20%" rowspan="3">功率(KW)</th>
		<th width="10%">A相</th>
		<td width="40%"><form:input  path="paCheckResult" /></td>
		<td width="30%"><form:input  path="paRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">B相</th>
		<td width="40%"><form:input  path="pbCheckResult" /></td>
		<td width="30%"><form:input  path="pbRemarks" /></td>
	</tr>
	<tr>
		<th width="10%">C相</th>
		<td width="40%"><form:input  path="pcCheckResult" /></td>
		<td width="30%"><form:input  path="pcRemarks" /></td>
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