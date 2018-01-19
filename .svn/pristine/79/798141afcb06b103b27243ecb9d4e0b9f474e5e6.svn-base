<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>TES网管数据库状态--添加</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th scope="col">网管系统在线数据库为Caac0831</th>
		<th scope="col"><p>
				<input type="radio" name="dataState" id="dataState" value="normal"
					checked="checked" /> 正常 <input type="radio" name="dataState"
					id="dataState" value="unnormal" /> 异常 <br />
			</p></th>
		<th scope="col">数据库名称是否为Caac0831 如果是，表示数据库状态正常</th>
		<th scope="col">登陆TES网管工作站查看数据库名称</th>
	</tr>
</table>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>TES网管进程状态--添加</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="4" scope="col">网管工作站进程</th>
		<th scope="col">081</th>
		<th scope="col"><input type="radio" name="PROCESS_STATE081"
			id="PROCESS_STATE081" value="normal" checked="checked" /> 正常 <input
			type="radio" name="PROCESS_STATE081" id="PROCESS_STATE081"
			value="unnormal" /> 异常</th>
		<th rowspan="4" scope="col">ALL NCP PROCESSES ARE OPEARTIONAL</th>
		<th rowspan="4" scope="col">DEC Term 中使用Check proc 命令</th>
	</tr>
	<tr>
		<th scope="col">281</th>
		<th scope="col"><input type="radio" name="PROCESS_STATE281"
			id="PROCESS_STATE281" value="normal" checked="checked" /> 正常 <input
			type="radio" name="PROCESS_STATE281" id="PROCESS_STATE281"
			value="unnormal" /> 异常</th>
	</tr>
	<tr>
		<th scope="col">381</th>
		<th scope="col"><input type="radio" name="PROCESS_STATE381"
			id="PROCESS_STATE381" value="normal" checked="checked" /> 正常 <input
			type="radio" name="PROCESS_STATE381" id="PROCESS_STATE381"
			value="unnormal" /> 异常</th>
	</tr>
	<tr>
		<th scope="col">481</th>
		<th scope="col"><input type="radio" name="PROCESS_STATE481"
			id="PROCESS_STATE481" value="normal" checked="checked" /> 正常 <input
			type="radio" name="PROCESS_STATE481" id="PROCESS_STATE481"
			value="unnormal" /> 异常</th>
	</tr>
</table>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管工作站连通性</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="4" scope="col">网管工作站进程</th>
		<th scope="col">081丢包率(%)</th>
		<th scope="col"><input name="packetLoss081" id="packetLoss081" /></th>
		<th rowspan="4" scope="col">0%</th>
		<th rowspan="4" scope="col">UCX窗口Ping四台工作站10个数据包。081/281/381/481IP地址分别为172.16.100.8（21/31/41）</th>
	</tr>
	<tr>
		<th scope="col">281丢包率(%)</th>
		<th scope="col"><input name="packetLoss281" id="packetLoss281" /></th>
	</tr>
	<tr>
		<th scope="col">381丢包率(%)</th>
		<th scope="col"><input name="packetLoss381" id="packetLoss381" /></th>
	</tr>
	<tr>
		<th scope="col">481丢包率(%)</th>
		<th scope="col"><input name="packetLoss481" id="packetLoss481" /></th>
	</tr>
</table>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES DecServer 连通性</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="3" scope="col">DECServer工作状态连通性</th>
		<th scope="col">08a</th>
		<th scope="col"><input type="radio" name="decServerCon08A"
			id="decServerCon08A" value="normal" checked="checked" /> 正常 <input
			type="radio" name="decServerCon08A" id="decServerCon08A"
			value="unnormal" /> 异常</th>
		<th rowspan="3" scope="col">Console connected</th>
		<th rowspan="3" scope="col"><p>DEC</p>
			<p>Term中使用 connect 命令</p></th>
	</tr>
	<tr>
		<th scope="col">08b</th>
		<th scope="col"><input type="radio" name="decServerCon08B"
			id="decServerCon08B" value="normal" checked="checked" /> 正常 <input
			type="radio" name="decServerCon08B" id="decServerCon08B"
			value="unnormal" /> 异常</th>
	</tr>
	<tr>
		<th scope="col">08c</th>
		<th scope="col"><input type="radio" name="decServerCon08C"
			id="decServerCon08C" value="normal" checked="checked" /> 正常 <input
			type="radio" name="decServerCon08C" id="decServerCon08C"
			value="unnormal" /> 异常</th>
	</tr>
</table>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES查看网管同步状态</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col">TES081<input name="serial"
			id="serial" value="1" type="hidden" /><input name="equipName"
			id="equipName" value="TES081" type="hidden" /></th>
	</tr>
	<tr>
		<td>CU</td>
		<td>CKT</td>
		<td>HG</td>
		<td>DD</td>
		<td>ROUTE</td>
	</tr>
	<tr>
		<td>项目结果</td>
		<td><input name="cu" id="cu" /></td>
		<td><input name="ckt" id="ckt" /></td>
		<td><input name="hg" id="hg" /></td>
		<td><input name="dd" id="dd" /></td>
		<td><input name="route" id="route" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col"><input name="serial" id="serial"
			value="2" type="hidden" /><input name="equipName" id="equipName"
			value="TES281" type="hidden" />TES281</th>
	</tr>
	<tr>
		<td>CU</td>
		<td>CKT</td>
		<td>HG</td>
		<td>DD</td>
		<td>ROUTE</td>
	</tr>
	<tr>
		<td>项目结果</td>
		<td><input name="cu" id="cu" /></td>
		<td><input name="ckt" id="ckt" /></td>
		<td><input name="hg" id="hg" /></td>
		<td><input name="dd" id="dd" /></td>
		<td><input name="route" id="route" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col"><input name="serial" id="serial"
			value="3" type="hidden" /><input name="equipName" id="equipName"
			value="TES381" type="hidden" />TES381</th>
	</tr>
	<tr>
		<td>CU</td>
		<td>CKT</td>
		<td>HG</td>
		<td>DD</td>
		<td>ROUTE</td>
	</tr>
	<tr>
		<td>项目结果</td>
		<td><input name="cu" id="cu" /></td>
		<td><input name="ckt" id="ckt" /></td>
		<td><input name="hg" id="hg" /></td>
		<td><input name="dd" id="dd" /></td>
		<td><input name="route" id="route" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col"><input name="serial" id="serial"
			value="4" type="hidden" /><input name="equipName" id="equipName"
			value="TES481" type="hidden" />TES481</th>
	</tr>
	<tr>
		<td>CU</td>
		<td>CKT</td>
		<td>HG</td>
		<td>DD</td>
		<td>ROUTE</td>
	</tr>
	<tr>
		<td>项目结果</td>
		<td><input name="cu" id="cu" /></td>
		<td><input name="ckt" id="ckt" /></td>
		<td><input name="hg" id="hg" /></td>
		<td><input name="dd" id="dd" /></td>
		<td><input name="route" id="route" /></td>
	</tr>
</table>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管工作站主备状态</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">巡检内容</th>
		<th scope="col">TES081</th>
		<th scope="col">TES281</th>
		<th scope="col">TES381</th>
		<th scope="col">TES481</th>
	</tr>
	<tr>
		<th scope="col">巡检结果</th>
		<th scope="col"><select id="tes081" name="tes081">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<option value="${txjdMainResult }">${txjdMainResult.value }</option>
				</c:forEach>
		</select></th>
		<th scope="col"><select id="tes281" name="tes281">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<option value="${txjdMainResult }">${txjdMainResult.value }</option>
				</c:forEach>
		</select></th>
		<th scope="col"><select id="tes381" name="tes381">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<option value="${txjdMainResult }">${txjdMainResult.value }</option>
				</c:forEach>
		</select></th>
		<th scope="col"><select id="tes481" name="tes481">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<option value="${txjdMainResult }">${txjdMainResult.value }</option>
				</c:forEach>
		</select></th>
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