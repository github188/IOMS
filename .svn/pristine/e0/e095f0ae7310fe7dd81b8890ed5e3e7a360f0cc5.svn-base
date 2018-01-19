<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管工作站主备状态--更新</dd>
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
		<th scope="col"><select id="tes081" name="tes081">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<c:choose>
						<c:when test="${vo.tes081 eq txjdMainResult }">
							<option value="${txjdMainResult }" selected="selected">${txjdMainResult.value }</option>
						</c:when>
						<c:otherwise>
							<option value="${txjdMainResult }">${txjdMainResult.value }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></th>
		<th rowspan="4" scope="col">ALL NCP PROCESSES ARE OPEARTIONAL</th>
		<th rowspan="4" scope="col">DEC Term 中使用Check proc 命令</th>
	</tr>
	<tr>
		<th scope="col">281</th>
		<th scope="col"><select id="tes281" name="tes281">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<c:choose>
						<c:when test="${vo.tes281 eq txjdMainResult }">
							<option value="${txjdMainResult }" selected="selected">${txjdMainResult.value }</option>
						</c:when>
						<c:otherwise>
							<option value="${txjdMainResult }">${txjdMainResult.value }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></th>
	</tr>
	<tr>
		<th scope="col">381</th>
		<th scope="col"><select id="tes381" name="tes381">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<c:choose>
						<c:when test="${vo.tes381 eq txjdMainResult }">
							<option value="${txjdMainResult }" selected="selected">${txjdMainResult.value }</option>
						</c:when>
						<c:otherwise>
							<option value="${txjdMainResult }">${txjdMainResult.value }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></th>
	</tr>
	<tr>
		<th scope="col">481</th>
		<th scope="col"><select id="tes481" name="tes481">
				<c:forEach items="${txjdMainResults }" var="txjdMainResult">
					<c:choose>
						<c:when test="${vo.tes481 eq txjdMainResult }">
							<option value="${txjdMainResult }" selected="selected">${txjdMainResult.value }</option>
						</c:when>
						<c:otherwise>
							<option value="${txjdMainResult }">${txjdMainResult.value }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></th>
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
