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
		<dd>通信基地TES网管数据库状态</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th scope="col">网管系统在线数据库为Caac0831</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.dataState eq 'unnormal'}">
					<font>${vo.dataState.value} </font>
				</c:when>
				<c:otherwise>
                        ${vo.dataState.value} 
                    </c:otherwise>
			</c:choose></th>
		<th scope="col">数据库名称是否为Caac0831 如果是，表示数据库状态正常</th>
		<th scope="col">登陆TES网管工作站查看数据库名称</th>
	</tr>
	<c:if test="${view eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="3">${vo.auditRemark}</td>
		</tr>
	</c:if>
	<c:if test="${audit eq 1}">
		<tr>
			<td>审核备注</td>
			<td colspan="3"><textarea id="auditRemark" name="auditRemark"
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