<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style>
<!--
	.tdWidth{
		width: 100%;
	}
-->
</style>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>雷达业务路由器(${atmDayRoute.area.value})</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th width="10%" scope="col">序号</th>
		<th width="60%" colspan="2" scope="col">检查项目</th>
		<th width="30%" scope="col">状态结果</th>
	</tr>
	<tr>
		<th width="10%" scope="row">1</th>
		<td colspan="2">远程访问(telnet)</td>
		<td><c:if test="${view eq 1 or audit eq 1}">
				${atmDayRoute.telnet.value}
			</c:if> <c:if test="${view eq 0}">
				<select id="telnet" name="telnet">
					<option value="${atmDayRoute.telnet }">${atmDayRoute.telnet.value }</option>
					<c:forEach items="${statusResults}" var="vo">
						<c:if test="${atmDayRoute.telnet.value != vo.value }">
							<option value="${vo}">${vo.value}</option>
						</c:if>
					</c:forEach>
				</select>
			</c:if></td>
	</tr>
	<tr>
		<th width="10%" scope="row">2</th>
		<td colspan="2">CPU利用率(100%)</td>
		<td><c:if test="${view eq 1 or audit eq 1}">
				${atmDayRoute.cpu}
			</c:if> <c:if test="${view eq 0}">
				<form:input path="cpu" value="${atmDayRoute.cpu}" />
			</c:if></td>
	</tr>
	<tr>
		<th width="10%" rowspan="8" scope="row">3</th>
		<td width="30%" rowspan="8"><p>业务数据传输情况</p>
			<p>(tx_pkts更新)</p></td>
		<td width="30%">${atmDayRoute.atmDaySons[0].name.value}</td>
		<td><c:if test="${view eq 1 or audit eq 1}">
				${atmDayRoute.atmDaySons[0].result.value}
			</c:if> <c:if test="${view eq 0}">
				<select id="${fn:toLowerCase(atmDayRoute.atmDaySons[0].name)}"
					name="${fn:toLowerCase(atmDayRoute.atmDaySons[0].name)}">
					<option value="${atmDayRoute.atmDaySons[0].result }">${atmDayRoute.atmDaySons[0].result.value }</option>
					<c:forEach items="${haveNoStatus}" var="vo">
						<c:if
							test="${atmDayRoute.atmDaySons[0].result.value != vo.value }">
							<option value="${vo}">${vo.value}</option>
						</c:if>
					</c:forEach>
				</select>
			</c:if></td>
	</tr>
	<c:forEach items="${atmDayRoute.atmDaySons }" var="atmDaySon"
		varStatus="status">
		<c:if test="${status.index ne 0}">
			<tr>
				<td width="30%">${atmDaySon.name.value}</td>
				<td><c:if test="${view eq 1 or audit eq 1}">
							${atmDaySon.result.value}
					</c:if> <c:if test="${view eq 0}">
						<select id="${fn:toLowerCase(atmDaySon.name)}"
							name="${fn:toLowerCase(atmDaySon.name)}">
							<option value="${atmDaySon.result }">${atmDaySon.result.value }</option>
							<c:forEach items="${haveNoStatus}" var="vo">
								<c:if test="${atmDaySon.result.value != vo.value }">
									<option value="${vo}">${vo.value}</option>
								</c:if>
							</c:forEach>
						</select>
					</c:if></td>
			</tr>
		</c:if>
	</c:forEach>
	<tr>
		<th scope="row">4</th>
		<td width="30%">备注</td>
		<td colspan="2"><c:if test="${view eq 1 or audit eq 1}">
				${atmDayRoute.remark}
			</c:if> <c:if test="${view eq 0}">
				<textarea id="wkzxbz" name="wkzxbz" rows="5" class="tdWidth" 
					placeholder="内容不能超过100个字">${atmDayRoute.remark}</textarea>
			</c:if></td>
	</tr>
	<c:if test="${view eq 1}">
		<tr>
			<th scope="row">5</th>
			<td width="30%">审核备注</td>
			<td colspan="2">${atmDayRoute.auditRemark}</td>

		</tr>
	</c:if>
	<c:if
		test="${vo.creater.name ne currentUser.name and empty vo.auditer and audit eq 1}">
		<tr>
			<th scope="row">5</th>
			<td width="30%">审核备注</td>
			<td colspan="2"><textarea id="auditRemark" name="auditRemark"
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