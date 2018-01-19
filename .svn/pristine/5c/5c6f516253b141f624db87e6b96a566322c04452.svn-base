<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
.fontRed {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.hostReduncdancyStatusA.value}</td>
	<td><c:choose>
			<c:when test="${vo.hostWorkStatusA eq 'NA'}">
				<font class="fontRed">${vo.hostWorkStatusA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostWorkStatusA.value}
				</c:otherwise>
		</c:choose></td>
	<td>${vo.hostReduncdancyStatusB.value}</td>
	<td><c:choose>
			<c:when test="${vo.hostWorkStatusB eq 'NA'}">
				<font class="fontRed">${vo.hostWorkStatusB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostWorkStatusB.value}
				</c:otherwise>
		</c:choose></td>
	<td>${vo.synReduncdancyStatusA.value}</td>
	<td><c:choose>
			<c:when test="${vo.synWorkStatusA eq 'NA'}">
				<font class="fontRed">${vo.synWorkStatusA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.synWorkStatusA.value}
				</c:otherwise>
		</c:choose></td>
	<td>${vo.synReduncdancyStatusB.value}</td>
	<td><c:choose>
			<c:when test="${vo.synWorkStatusB eq 'NA'}">
				<font class="fontRed">${vo.synWorkStatusB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.synWorkStatusB.value}
				</c:otherwise>
		</c:choose></td>

	<td>${vo.iReduncdancyStatusA.value}</td>

	<td><c:choose>
			<c:when test="${vo.iWorkStatusA eq 'NA'}">
				<font class="fontRed">${vo.iWorkStatusA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.iWorkStatusA.value}
				</c:otherwise>
		</c:choose></td>

	<td>${vo.iReduncdancyStatusB.value}</td>

	<td><c:choose>
			<c:when test="${vo.iWorkStatusB eq 'NA'}">
				<font class="fontRed">${vo.iWorkStatusB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.iWorkStatusB.value}
				</c:otherwise>
		</c:choose></td>

	<td>${vo.iReduncdancyStatusC.value}</td>

	<td><c:choose>
			<c:when test="${vo.iWorkStatusC eq 'NA'}">
				<font class="fontRed">${vo.iWorkStatusC.value}</font>
			</c:when>
			<c:otherwise>
					${vo.iWorkStatusC.value}
				</c:otherwise>
		</c:choose></td>

	<td>${vo.iReduncdancyStatusD.value}</td>

	<td><c:choose>
			<c:when test="${vo.iWorkStatusD eq 'NA'}">
				<font class="fontRed">${vo.iWorkStatusD.value}</font>
			</c:when>
			<c:otherwise>
					${vo.iWorkStatusD.value}
				</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.asynAccess1 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess1.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess1.value}
				</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.asynAccess2 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess2.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess2.value}
				</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.asynAccess3 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess3.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess3.value}
				</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.asynAccess4 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess4.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess4.value}
				</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.asynAccess5 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess5.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess5.value}
				</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.asynAccess6 eq 'NA'}">
				<font class="fontRed">${vo.asynAccess6.value}</font>
			</c:when>
			<c:otherwise>
					${vo.asynAccess6.value}
				</c:otherwise>
		</c:choose></td>

	<td>${vo.creater.name}<br></br> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.judgeUser.name}<br></br> <fmt:formatDate
			value="${vo.judgeTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>

	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_hardware_view']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/view.do?id=${vo.id}"
				id="viewRecord" class="my_edit {boxwidth:1000,boxheight:700}">查看</a>
		</sec:authorize> <c:if test="${vo.judgeState eq 'WAIT'}">
			<c:if test="${currentUser.name !=vo.creater.name}">
				<sec:authorize
					ifAnyGranted="${jspAuthorities['faxsystem_hardware_judge']}">
					<a href="${rootUrl}duty/fax/day/faxsystem/judge.do?id=${vo.id}"
						id="judgeRecord" class="my_edit {boxwidth:1200,boxheight:1000}">审核</a>
				</sec:authorize>
			</c:if>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_hardware_mod']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/mod.do?id=${vo.id}"
				id="modRecord" class="my_edit {boxwidth:1200,boxheight:1000}">修改</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_hardware_del']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
