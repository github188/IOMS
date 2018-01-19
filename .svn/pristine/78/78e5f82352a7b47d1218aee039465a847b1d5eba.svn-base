<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>备品备件检查--更新</dd>
	</dl>
</div>
<table border="1">
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
		<td><form:input path="sys" value="${vo.sys }" /></td>
		<td><form:input path="name" value="${vo.name }" /></td>
		<td><form:input path="sn" value="${vo.sn }" /></td>
		<td><form:input path="address" value="${vo.address }" /></td>
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
