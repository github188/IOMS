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
	<td>通信基地TES链路工作状态</td>
	<td><c:choose>
			<c:when test="${vo.link10071 eq 'INNORMAL'}">
				<font>${vo.link10071.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10071.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10072 eq 'INNORMAL'}">
				<font>${vo.link10072.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10072.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10073 eq 'INNORMAL'}">
				<font>${vo.link10073.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10073.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10074 eq 'INNORMAL'}">
				<font>${vo.link10074.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10074.value} 
                    </c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.link10081 eq 'INNORMAL'}">
				<font>${vo.link10081.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10081.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10082 eq 'INNORMAL'}">
				<font>${vo.link10082.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10082.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10083 eq 'INNORMAL'}">
				<font>${vo.link10083.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10083.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10084 eq 'INNORMAL'}">
				<font>${vo.link10084.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10084.value} 
                    </c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.link10091 eq 'INNORMAL'}">
				<font>${vo.link10091.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10091.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10092 eq 'INNORMAL'}">
				<font>${vo.link10092.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10092.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10093 eq 'INNORMAL'}">
				<font>${vo.link10093.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10093.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link10094 eq 'INNORMAL'}">
				<font>${vo.link10094.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link10094.value} 
                    </c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.link100a1 eq 'INNORMAL'}">
				<font>${vo.link100a1.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100a1.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100a2 eq 'INNORMAL'}">
				<font>${vo.link100a2.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100a2.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100a3 eq 'INNORMAL'}">
				<font>${vo.link100a3.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100a3.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100a4 eq 'INNORMAL'}">
				<font>${vo.link100a4.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100a4.value} 
                    </c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.link100f1 eq 'INNORMAL'}">
				<font>${vo.link100f1.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100f1.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100f2 eq 'INNORMAL'}">
				<font>${vo.link100f2.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100f2.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100f3 eq 'INNORMAL'}">
				<font>${vo.link100f3.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100f3.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100f4 eq 'INNORMAL'}">
				<font>${vo.link100f4.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100f4.value} 
                    </c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.link100111 eq 'INNORMAL'}">
				<font>${vo.link100111.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100111.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100112 eq 'INNORMAL'}">
				<font>${vo.link100112.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100112.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100113 eq 'INNORMAL'}">
				<font>${vo.link100113.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100113.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.link100114 eq 'INNORMAL'}">
				<font>${vo.link100114.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.link100114.value} 
                    </c:otherwise>
		</c:choose></td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_teslinkstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/teslinkstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_teslinkstae_del']}">
			<a
				href="${rootUrl}duty/statelliteday/teslinkstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_teslinkstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/teslinkstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>