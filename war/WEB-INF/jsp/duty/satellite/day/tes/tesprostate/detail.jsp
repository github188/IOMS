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
		<dd>通信基地TES网管进程状态</dd>
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
		<th scope="col"><c:choose>
				<c:when test="${vo.PROCESS_STATE081 eq 'unnormal'}">
					<font>${vo.PROCESS_STATE081.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.PROCESS_STATE081.value} 
                    </c:otherwise>
			</c:choose></th>
		<th rowspan="4" scope="col">ALL NCP PROCESSES ARE OPEARTIONAL</th>
		<th rowspan="4" scope="col">DEC Term 中使用Check proc 命令</th>
	</tr>
	<tr>
		<th scope="col">281</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.PROCESS_STATE281 eq 'unnormal'}">
					<font>${vo.PROCESS_STATE281.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.PROCESS_STATE281.value} 
                    </c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">381</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.PROCESS_STATE381 eq 'unnormal'}">
					<font>${vo.PROCESS_STATE381.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.PROCESS_STATE381.value} 
                    </c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">481</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.PROCESS_STATE481 eq 'unnormal'}">
					<font>${vo.PROCESS_STATE481.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.PROCESS_STATE481.value} 
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