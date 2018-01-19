<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>卫星工具借用--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="4" scope="col">借用工具登记表</th>
	</tr>
	<tr>
		<th scope="row">序号</th>
		<td>工具名称</td>
		<td>数量</td>
		<td>备注</td>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td><form:input path="name1" value="${tool.name1 }" /></td>
		<td><form:input path="num1" value="${ tool.num1}" /></td>
		<td><form:input path="remark1" value="${ tool.remark1}" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td><form:input path="name2" value="${ tool.name2}" /></td>
		<td><form:input path="num2" value="${ tool.num2}" /></td>
		<td><form:input path="remark2" value="${ tool.remark2}" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td><form:input path="name3" value="${ tool.name3}" /></td>
		<td><form:input path="num3" value="${ tool.num3}" /></td>
		<td><form:input path="remark3" value="${ tool.remark3}" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td><form:input path="name4" value="${ tool.name4}" /></td>
		<td><form:input path="num4" value="${ tool.num4}" /></td>
		<td><form:input path="remark4" value="${ tool.remark4}" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td><form:input path="name5" value="${ tool.name5}" /></td>
		<td><form:input path="num5" value="${ tool.num5}" /></td>
		<td><form:input path="remark5" value="${ tool.remark5}" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td><form:input path="name6" value="${ tool.name6}" /></td>
		<td><form:input path="num6" value="${ tool.num6}" /></td>
		<td><form:input path="remark6" value="${ tool.remark6}" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td><form:input path="name7" value="${ tool.name7}" /></td>
		<td><form:input path="num7" value="${ tool.num7}" /></td>
		<td><form:input path="remark7" value="${ tool.remark7}" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td><form:input path="name8" value="${ tool.name8}" /></td>
		<td><form:input path="num8" value="${ tool.num8}" /></td>
		<td><form:input path="remark8" value="${ tool.remark8}" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td><form:input path="name9" value="${ tool.name9}" /></td>
		<td><form:input path="num9" value="${ tool.num9}" /></td>
		<td><form:input path="remark9" value="${ tool.remark9}" /></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td><form:input path="name10" value="${tool.name10 }" /></td>
		<td><form:input path="num10" value="${ tool.num10}" /></td>
		<td><form:input path="remark10" value="${ tool.remark10}" /></td>
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
