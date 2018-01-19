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
	<td>
		<c:choose>
			<c:when test="${vo.synapAp1 eq 'NA'}">
				<font>${vo.synapAp1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.synapAp1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.synapAp2 eq 'NA'}">
				<font>${vo.synapAp2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.synapAp2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.jdzjAsyapAp1 eq 'NA'}">
				<font>${vo.jdzjAsyapAp1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.jdzjAsyapAp1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.jdzjAsyapAp2 eq 'NA'}">
				<font>${vo.jdzjAsyapAp2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.jdzjAsyapAp2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.jdsj eq 'NA'}">
				<font>${vo.jdsj.value}</font>
			</c:when>
			<c:otherwise>
				${vo.jdsj.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slh1 eq 'NA'}">
				<font>${vo.slh1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slh1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slh2 eq 'NA'}">
				<font>${vo.slh2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slh2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slh3 eq 'NA'}">
				<font>${vo.slh3.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slh3.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slh4 eq 'NA'}">
				<font>${vo.slh4.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slh4.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slhSynapAp1 eq 'NA'}">
				<font>${vo.slhSynapAp1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slhSynapAp1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.slhSynapAp2 eq 'NA'}">
				<font>${vo.slhSynapAp2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.slhSynapAp2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.zjAsyapAp2 eq 'NA'}">
				<font>${vo.zjAsyapAp2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.zjAsyapAp2.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.zjAsyapAp3 eq 'NA'}">
				<font>${vo.zjAsyapAp3.value}</font>
			</c:when>
			<c:otherwise>
				${vo.zjAsyapAp3.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.sj1 eq 'NA'}">
				<font>${vo.sj1.value}</font>
			</c:when>
			<c:otherwise>
				${vo.sj1.value}
			</c:otherwise>
		</c:choose>
	</td>
	<td>
		<c:choose>
			<c:when test="${vo.sj2 eq 'NA'}">
				<font>${vo.sj2.value}</font>
			</c:when>
			<c:otherwise>
				${vo.sj2.value}
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
		<sec:authorize ifAnyGranted="${jspAuthorities['vg_check_audit']}">
			<c:if test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}duty/vgduty/audit.do?id=${vo.id}">审核</a><br>
			</c:if>
			<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}duty/vgduty/view.do?id=${vo.id}">查看</a><br>
		</sec:authorize>
	</td>
</tr>
