<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
<!--
	font {
		color: red;
		font-weight: bold;
	}
-->
</style>
<tr>
	<td>
		<fmt:formatDate value="${vo.createTime.time }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.hostAReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.hostAWork eq 'NA'}">
				<font>${vo.hostAWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.hostAWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.hostBReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.hostBWork eq 'NA'}">
				<font>${vo.hostBWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.hostBWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.synapAReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.synapAWork eq 'NA'}">
				<font>${vo.synapAWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.synapAWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.synapBReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.synapBWork eq 'NA'}">
				<font>${vo.synapBWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.synapBWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.synProcess eq 'NA'}">
				<font>${vo.synProcess.value}</font>
			</c:when>
			<c:otherwise>
				${vo.synProcess.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.collAReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.collAWork eq 'NA'}">
				<font>${vo.collAWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.collAWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.collBReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.collBWork eq 'NA'}">
				<font>${vo.collBWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.collBWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.collCReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.collCWork eq 'NA'}">
				<font>${vo.collCWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.collCWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.collDReduncdancy.value}</td>
	<td>
		<c:choose>
			<c:when test="${vo.collDWork eq 'NA'}">
				<font>${vo.collDWork.value}</font>
			</c:when>
			<c:otherwise>
				${vo.collDWork.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp1 eq 'NA'}">
				<font>${vo.asyapAp1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp2 eq 'NA'}">
				<font>${vo.asyapAp2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp3 eq 'NA'}">
				<font>${vo.asyapAp3.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp3.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp4 eq 'NA'}">
				<font>${vo.asyapAp4.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp4.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp5 eq 'NA'}">
				<font>${vo.asyapAp5.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp5.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapAp6 eq 'NA'}">
				<font>${vo.asyapAp6.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapAp6.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapSpProcess eq 'NA'}">
				<font>${vo.asyapSpProcess.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapSpProcess.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.asyapIpProcess eq 'NA'}">
				<font>${vo.asyapIpProcess.value}</font>
			</c:when>
			<c:otherwise>
				${vo.asyapIpProcess.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		${vo.creater.name}<br/>
		<fmt:formatDate value="${vo.createTime.time }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
		${vo.auditer.name}<br/>
		<fmt:formatDate value="${vo.auditTime.time }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn" >
		<sec:authorize ifAnyGranted="${jspAuthorities['telegraph_check_audit']}">
			<c:if test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}duty/telegraphduty/audit.do?id=${vo.id}">审核</a><br>
			</c:if>
			<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}duty/telegraphduty/view.do?id=${vo.id}">查看</a><br>
		</sec:authorize>
	</td>
</tr>
