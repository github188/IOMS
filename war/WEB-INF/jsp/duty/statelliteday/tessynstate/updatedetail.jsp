<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES查看网管同步状态--更新</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col">TES081</th>
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
		<td><form:input path="syn081cu" value="${synstate.syn081cu}" /></td>
		<td><form:input path="syn081ckt" value="${synstate.syn081ckt}" /></td>
		<td><form:input path="syn081hg" value="${synstate.syn081hg}" /></td>
		<td><form:input path="syn081dd" value="${synstate.syn081dd}" /></td>
		<td><form:input path="syn081router"
				value="${synstate.syn081router}" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col">TES281</th>
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
		<td><form:input path="syn281cu" value="${synstate.syn281cu}" /></td>
		<td><form:input path="syn281ckt" value="${synstate.syn281ckt}" /></td>
		<td><form:input path="syn281hg" value="${synstate.syn281hg}" /></td>
		<td><form:input path="syn281dd" value="${synstate.syn281dd}" /></td>
		<td><form:input path="syn281router"
				value="${synstate.syn281router}" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col">TES381</th>
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
		<td><form:input path="syn381cu" value="${synstate.syn381cu}" /></td>
		<td><form:input path="syn381ckt" value="${synstate.syn381ckt}" /></td>
		<td><form:input path="syn381hg" value="${synstate.syn381hg}" /></td>
		<td><form:input path="syn381dd" value="${synstate.syn381dd}" /></td>
		<td><form:input path="syn381router"
				value="${synstate.syn381router}" /></td>
	</tr>
	<tr>
		<th rowspan="2" scope="col">检查项目</th>
		<th colspan="5" scope="col">TES481</th>
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
		<td><form:input path="syn481cu" value="${synstate.syn481cu}" /></td>
		<td><form:input path="syn481ckt" value="${synstate.syn481ckt}" /></td>
		<td><form:input path="syn481hg" value="${synstate.syn481hg}" /></td>
		<td><form:input path="syn481dd" value="${synstate.syn481dd}" /></td>
		<td><form:input path="syn481router"
				value="${synstate.syn481router}" /></td>
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
