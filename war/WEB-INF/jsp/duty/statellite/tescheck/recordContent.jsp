<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>通信基地TES网管系统月检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>通信基地TES网管系统季检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>通信基地TES网管系统年检--添加</dd>
		</c:if>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="4" scope="col">北京网控中心TES站网管系统检查</th>
	</tr>
	<tr>
		<th width="26%" scope="row">序号</th>
		<td width="29%">检查内容</td>
		<td width="20%">结果记录</td>
		<td width="25%">备注</td>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>主用网管工作站切换广州</td>
		<td><label> <input type="radio" name="recordGz"
				value="NORMAL" checked="checked" /> 正常
		</label> <label> <input type="radio" name="recordGz" value="INNORMAL" />
				异常
		</label></td>
		<td><form:input path="recordGzBz" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>网管工作站本地手动切换</td>
		<td><label> <input type="radio" name="recordManual"
				value="NORMAL" checked="checked" /> 正常
		</label> <label> <input type="radio" name="recordManual"
				value="INNORMAL" /> 异常
		</label></td>
		<td><form:input path="recordManualBz" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>网管工作站切回北京</td>
		<td><label> <input type="radio" name="recordBj"
				value="NORMAL" checked="checked" /> 正常
		</label> <label> <input type="radio" name="recordBj" value="INNORMAL" />
				异常
		</label></td>
		<td><form:input path="recordBjBz" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>网管工作站备份情况</td>
		<td><form:input path="recordBf" /></td>
		<td><form:input path="recordBfBz" /></td>
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