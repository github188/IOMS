<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style>
<!--
.tdWidth {
	width: 100%;
}
-->
</style>
<c:forEach begin="1" end="2" varStatus="status">
	<div style="margin: 10px 20px 0px; padding: 0px">
		<dl class="title">
			<c:if test="${status.index eq 1}">
				<dd>雷达业务路由器(北京网控中心)</dd>
			</c:if>
			<c:if test="${status.index eq 2}">
				<dd>雷达业务路由器(民航局空管局)</dd>
			</c:if>
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
			<td><select id="telnet" name="telnet">
					<c:forEach items="${statusResults}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<th width="10%" scope="row">2</th>
			<td colspan="2">CPU利用率(100%)</td>
			<td><form:input path="cpu" /></td>
		</tr>
		<tr>
			<th width="10%" rowspan="8" scope="row">3</th>
			<td width="30%" rowspan="8"><p>业务数据传输情况</p>
				<p>(tx_pkts更新)</p></td>
			<td width="30%">成都</td>
			<td><select id="chengdu" name="chengdu">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">广州</td>
			<td><select id="guangzhou" name="guangzhou">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">首都机场</td>
			<td><select id="shoudu" name="shoudu">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">上海</td>
			<td><select id="shanghai" name="shanghai">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">沈阳</td>
			<td><select id="shenyang" name="shenyang">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">西安</td>
			<td><select id="xian" name="xian">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">乌鲁木齐</td>
			<td><select id="wulumuqi" name="wulumuqi">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td width="30%">三亚</td>
			<td><select id="sanya" name="sanya">
					<c:forEach items="${haveNoStatus}" var="vo">
						<option value="${vo}">${vo.value}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<th scope="row">4</th>
			<td width="30%">备注</td>
			<td colspan="2"><textarea id="wkzxbz" name="wkzxbz" rows="5"
					class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
		</tr>
	</table>
	<div style="margin: 10px 20px 10px; padding: 0px"></div>
</c:forEach>


<div class="boxbtn">
	<div class="btn">
		<a href="#none" id="submit">保存</a>
	</div>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>