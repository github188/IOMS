<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.currentTaskName}"></c:set>
	<td>${vo.faultType.name }</td>
	<td>${vo.faultKey }</td>
	<td>${vo.contactPerson }</td>
	<td>
		<fmt:formatDate value="${vo.faultTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.faultStatus.name}</td>
	<td>
		<fmt:formatDate value="${vo.updateTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
		<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${tn}</a>
	</td>
	<td class="tdbtn" >
		<c:if test="${message=='TAKE'}">
			<a class="my_edit {boxwidth:1000,boxheight:270}" href="${rootUrl}techsupport/fault/deal/take.do?id=${vo.id}&faultdeclarepi=${pi}">接单</a>
		</c:if>
		<%-- 值班员角色可以做的操作 --%>
		<c:if test="${message=='DUTY_SOLVE'}">
			<c:choose>
				<%-- 如果故障申报处理状态为值班员解决重启，则只能进行移交和分配的操作 --%>
				<c:when test="${vo.faultStatus=='SOLVED_OPEN' }">
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/dutytransfer.do?role=duty&id=${vo.id}&faultdeclarepi=${pi}">移交</a>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/dutyassign.do?id=${vo.id}&faultdeclarepi=${pi}">分配</a>
				</c:when>
				<c:otherwise>
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}techsupport/fault/deal/change.do?id=${vo.id}&faultdeclarepi=${pi}">转咨询</a>
					<a class="my_edit {boxwidth:1000,boxheight:800}" href="${rootUrl}techsupport/fault/deal/solve.do?id=${vo.id}&faultdeclarepi=${pi}">解决</a><br/>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/dutytransfer.do?role=duty&id=${vo.id}&faultdeclarepi=${pi}">移交</a>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/dutyassign.do?id=${vo.id}&faultdeclarepi=${pi}">分配</a>
				</c:otherwise>
			</c:choose>
			<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/fault/deal/detail.do?id=${vo.id}">详情</a>
		</c:if>
		<%-- 值班经理的操作和值班员的一样了，但是移交略有不同，值班经理不能移交给自己，但是值班员可以移交给所有的值班经理 --%>
		<c:if test="${message=='MANAGER_SOLVE'}">
			<c:choose>
				<%-- 如果故障申报处理状态为值班经理解决重启，则只能进行移交和分配的操作 --%>
				<c:when test="${vo.faultStatus=='SOLVED_OPEN' }">
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/managertransfer.do?role=dutymanager&id=${vo.id}&faultdeclarepi=${pi}">移交</a>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/managerassign.do?id=${vo.id}&faultdeclarepi=${pi}">分配</a>
				</c:when>
				<c:otherwise>
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}techsupport/fault/deal/change.do?id=${vo.id}&faultdeclarepi=${pi}">转咨询</a>
					<a class="my_edit {boxwidth:1000,boxheight:800}" href="${rootUrl}techsupport/fault/deal/solve.do?id=${vo.id}&faultdeclarepi=${pi}">解决</a><br/>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/managertransfer.do?role=dutymanager&id=${vo.id}&faultdeclarepi=${pi}">移交</a>
					<a class="my_edit {boxwidth:900,boxheight:310}" href="${rootUrl}techsupport/fault/deal/managerassign.do?id=${vo.id}&faultdeclarepi=${pi}">分配</a>
				</c:otherwise>
			</c:choose>
			<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/fault/deal/detail.do?id=${vo.id}">详情</a>
			
		</c:if>
				
		<c:if test="${message=='ENGINEER_SOLVE'}">
			<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/fault/deal/detail.do?id=${vo.id}">详情</a>
			<a class="my_edit {boxwidth:1000,boxheight:800}" href="${rootUrl}techsupport/fault/deal/resolve.do?id=${vo.id}&faultdeclarepi=${pi}">解决</a>
		</c:if>
		
		<c:if test="${message=='CONFIRMWARN'}">
			<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/fault/deal/detail.do?id=${vo.id}">详情</a>
			<a class="my_edit {boxwidth:900,boxheight:350}" href="${rootUrl}techsupport/fault/deal/confirmwarn.do?id=${vo.id}&faultdeclarepi=${pi}">确认提醒</a>
		</c:if>
	</td>
</tr>
