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
		<th rowspan="4" scope="col">网管工作站连通性</th>
		<th scope="col">081丢包率(%)</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.packetLoss081 eq '0'}">
	${vo.packetLoss081}
	</c:when>
				<c:otherwise>
					<font>${vo.packetLoss081}</font>
				</c:otherwise>
			</c:choose></th>
		<th rowspan="4" scope="col">0%</th>
		<th rowspan="4" scope="col">UCX窗口Ping四台工作站10个数据包。081/281/381/481IP地址分别为172.16.100.8（21/31/41）</th>
	</tr>
	<tr>
		<th scope="col">281丢包率(%)</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.packetLoss281 eq '0'}">
	${vo.packetLoss281}
	</c:when>
				<c:otherwise>
					<font>${vo.packetLoss281}</font>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">381丢包率(%)</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.packetLoss381 eq '0'}">
	${vo.packetLoss381}
	</c:when>
				<c:otherwise>
					<font>${vo.packetLoss381}</font>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">481丢包率(%)</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.packetLoss481 eq '0'}">
	${vo.packetLoss481}
	</c:when>
				<c:otherwise>
					<font>${vo.packetLoss481}</font>
				</c:otherwise>
			</c:choose></th>
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