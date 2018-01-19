<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>通信基地KU网管系统维护</td>
	<td><c:choose>
			<c:when test="${vo.net1Workstate eq 'INNORMAL'}">
				<font>${vo.net1Workstate.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net1Workstate.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net2Workstate eq 'INNORMAL'}">
				<font>${vo.net2Workstate.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net2Workstate.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net3Workstate eq 'INNORMAL'}">
				<font>${vo.net3Workstate.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net3Workstate.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net4Workstate eq 'INNORMAL'}">
				<font>${vo.net4Workstate.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net4Workstate.value}
		                    </c:otherwise>
		</c:choose></td>
	<td>${vo.subnetWorkRemark}</td>
	<td><c:choose>
			<c:when test="${vo.netzWorkstate eq 'INNORMAL'}">
				<font>${vo.netzWorkstate.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.netzWorkstate.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net1WorkstateBf eq 'INNORMAL'}">
				<font>${vo.net1WorkstateBf.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net1WorkstateBf.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net2WorkstateBf eq 'INNORMAL'}">
				<font>${vo.net2WorkstateBf.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net2WorkstateBf.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net3WorkstateBf eq 'INNORMAL'}">
				<font>${vo.net3WorkstateBf.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net3WorkstateBf.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net4WorkstateBf eq 'INNORMAL'}">
				<font>${vo.net4WorkstateBf.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.net4WorkstateBf.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.netzWorkstateBf eq 'INNORMAL'}">
				<font>${vo.netzWorkstateBf.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.netzWorkstateBf.value}
		                    </c:otherwise>
		</c:choose></td>
	<td>${vo.subnetDataRemark}</td>
	<td>${vo.tapeLocate}</td>
	<td>${vo.tapeLocateRemark}</td>
	<td><c:choose>
			<c:when test="${vo.workDust eq 'COMPLETE'}">
	                             完成		   </c:when>
			<c:otherwise>
				<font>未完成 </font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.workDustRemark}</td>
	<td>${vo.forward}</td>
	<td>${vo.forwardRemark}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_kusys_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/kusys/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_kusys_del']}">
			<a href="${rootUrl}duty/statellite/kusys/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_kusys_update']}">
				<a href="${rootUrl}duty/statellite/kusys/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>