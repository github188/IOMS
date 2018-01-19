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
		<dd>通信基地-TES-TES网管工作站主备状态</dd>
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
		<th scope="col">${vo.tes081.value}</th>
		<th scope="col">${vo.tes281.value}</th>
		<th scope="col">${vo.tes381.value}</th>
		<th scope="col">${vo.tes481.value}</th>
	</tr>
	<c:if test="${view eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="4">${vo.auditRemark}</td>
		</tr>
	</c:if>
	<c:if test="${audit eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="4"><textarea id="auditRemark" name="auditRemark"
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