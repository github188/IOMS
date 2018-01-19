<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style>
font {
	color: red;
	font-weight: bold;
}

.tdWidth {
	width: 100%;
}
</style>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES查看网管同步状态</dd>
	</dl>
</div>
<table width="100%" border="0">
	<c:forEach items="${vo.txjdSynResults}" var="txjdSynReslut">
		<tr>
			<th rowspan="2" scope="col">检查项目</th>
			<th colspan="5" scope="col">${txjdSynReslut.equipName.value }</th>
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
			<td>${txjdSynReslut.cu }</td>
			<td>${txjdSynReslut.ckt }</td>
			<td>${txjdSynReslut.hg }</td>
			<td>${txjdSynReslut.dd }</td>
			<td>${txjdSynReslut.route }</td>
		</tr>
	</c:forEach>
	<c:if test="${view eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="5">${vo.auditRemark}</td>
		</tr>
	</c:if>
	<c:if test="${audit eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="5"><textarea id="auditRemark" name="auditRemark"
					rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
		</tr>
	</c:if>
</table>
<div class="boxbtn">
	<c:if test="${view eq 0 or audit eq 1}">
		<div class="btn">
			<a href="#none" id="submit">保存</a>
		</div>
	</c:if>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>