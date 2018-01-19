<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>备品备件月检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>备品备件季检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>备品备件年检--添加</dd>
		</c:if>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="4" scope="col">卫星系统备件清查记录表</th>
	</tr>
	<tr>
		<td width="25%">所属系统</td>
		<td width="25%">设备名称</td>
		<td width="25%">序列号（SN）</td>
		<td width="25%">存储位置</td>
	</tr>
	<tr>
		<td><form:input path="sys" /></td>
		<td><form:input path="name" /></td>
		<td><form:input path="sn" /></td>
		<td><form:input path="address" /></td>
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