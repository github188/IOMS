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
		<dd>通信基地TES DecServer连通性</dd>
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
		<th rowspan="3" scope="col">DECServer工作状态连通性</th>
		<th scope="col">08a</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08A eq 'unnormal'}">
					<font>${vo.decServerCon08A.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.decServerCon08A.value} 
                    </c:otherwise>
			</c:choose></th>
		<th rowspan="3" scope="col">Console connected</th>
		<th rowspan="3" scope="col"><p>DEC</p>
			<p>Term中使用 connect 命令</p></th>
	</tr>
	<tr>
		<th scope="col">08b</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08B eq 'unnormal'}">
					<font>${vo.decServerCon08B.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.decServerCon08B.value} 
                    </c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">08c</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08C eq 'unnormal'}">
					<font>${vo.decServerCon08C.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.decServerCon08C.value} 
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