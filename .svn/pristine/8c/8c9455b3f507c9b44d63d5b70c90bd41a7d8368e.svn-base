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
		<fmt:formatDate value="${vo.checkTime}" type="both" 
			pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.name }</td>
	<c:forEach items="${vo.upsContentCheck }" var="ucc">
		<td>
			<c:choose>
				<c:when test="${ucc.atIsAdjustable eq 'INNORMAL'}">
					<font>${ucc.atIsAdjustable.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.atIsAdjustable.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.temperature }</td>
		<td>${ucc.humidity }</td>
		<td>
			<c:choose>
				<c:when test="${ucc.eaIsIntact eq 'INNORMAL'}">
					<font>${ucc.eaIsIntact.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.eaIsIntact.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.radiateIsNormal eq 'INNORMAL'}">
					<font>${ucc.radiateIsNormal.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.radiateIsNormal.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.batLeakage eq 'INNORMAL'}">
					<font>${ucc.batLeakage.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.batLeakage.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.connCo eq 'INNORMAL'}">
					<font>${ucc.connCo.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.connCo.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.inputVLN }</td>
		<td>${ucc.inputVLD }</td>
		<td>${ucc.inputVND }</td>
		<td>${ucc.inputCurrent }</td>
		<td>${ucc.loadCapacity }</td>
		<td>${ucc.inputAirTemperature }</td>
		<td>${ucc.inputCableTemperature }</td>
		<td>${ucc.outputVLN }</td>
		<td>${ucc.outputVLD }</td>
		<td>${ucc.outputVND }</td>
		<td>${ucc.outputCurrent }</td>
		<td>${ucc.outputAirTemperature }</td>
		<td>
			<c:choose>
				<c:when test="${ucc.equipDustRemoval eq 'No'}">
					<font>${ucc.equipDustRemoval.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.equipDustRemoval.value}
				</c:otherwise>
			</c:choose>
		</td>
	</c:forEach>
	<!-- 电池测量 -->
	<%-- <c:set var="num" value="${0 }"></c:set> --%>
	<c:forEach items="${vo.batteryMeasure }" var="bm">
		<td>${bm.number }</td>
		<%-- <c:set var="num" value="${num+1 }"></c:set> --%>
		<td>${bm.termialV }</td>
		<td>${bm.interR }</td>
		<td>${bm.remarks}</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.problem }</td>
	<td>${vo.suggestion }</td>
	<td>${vo.result }</td>
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['kuups_check_year_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/upsdutyyear/kuups/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kuups_check_year_del']}">
			<a href="${rootUrl}duty/upsdutyyear/kuups/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kuups_check_year_update']}">
		<a href="${rootUrl}duty/upsdutyyear/kuups/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>