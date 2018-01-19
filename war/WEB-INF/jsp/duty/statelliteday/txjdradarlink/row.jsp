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
	<td>${vo.equipName.value }</td>

	<td><c:choose>
			<c:when test="${vo.linkStateSHA ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateSHA.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateSHA.value }
		    </c:otherwise>
		</c:choose></td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td><c:choose>
			<c:when test="${vo.linkStatePEK ne 'NORMAL'}">
				<font color="red"> ${vo.linkStatePEK.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStatePEK.value }
				    	</c:otherwise>
		</c:choose></td>
	<td>&nbsp;</td>
	<td><c:choose>
			<c:when test="${vo.linkStateSHE ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateSHE.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateSHE.value }
				    	</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.linkStateSIA ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateSIA.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateSIA.value }
				    	</c:otherwise>
		</c:choose></td>
	<td>&nbsp;</td>
	<td><c:choose>
			<c:when test="${vo.linkStateCAN ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateCAN.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateCAN.value }
				    	</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.linkStateURC ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateURC.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateURC.value }
				    	</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.linkStateHAK ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateHAK.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateHAK.value }
				    	</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.linkStateCTU ne 'NORMAL'}">
				<font color="red"> ${vo.linkStateCTU.value }</font>
			</c:when>
			<c:otherwise>
				    	 ${vo.linkStateCTU.value }
				    	</c:otherwise>
		</c:choose></td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_txjdradarlink_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:500}"
				href="${rootUrl}duty/statelliteday/txjdradarlink/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_txjdradarlink_del']}">
			<a
				href="${rootUrl}duty/statelliteday/txjdradarlink/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_txjdradarlink_update']}">
				<a
					href="${rootUrl}duty/statelliteday/txjdradarlink/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:500}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>