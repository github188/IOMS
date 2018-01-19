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
	<c:forEach items="${vo.txjdSynResults }" var="txjdSynReslut">
		<tr>
			<th rowspan="2" scope="col">检查项目</th>
			<th colspan="5" scope="col">${txjdSynReslut.equipName.value }<input
				name="serial" id="serial" value="${txjdSynReslut.serial }"
				type="hidden" /><input name="equipName" id="equipName"
				value="${txjdSynReslut.equipName }" type="hidden" /></th>
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
			<td><input name="cu" id="cu" value="${txjdSynReslut.cu }" /></td>
			<td><input name="ckt" id="ckt" value="${txjdSynReslut.ckt }" /></td>
			<td><input name="hg" id="hg" value="${txjdSynReslut.hg }" /></td>
			<td><input name="dd" id="dd" value="${txjdSynReslut.dd }" /></td>
			<td><input name="route" id="route"
				value="${txjdSynReslut.route }" /></td>
		</tr>
	</c:forEach>
	<tr>
		<td>审核备注</td>
		<td colspan="5">${vo.auditRemark}</td>
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
