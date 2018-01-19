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
	<c:forEach items="${vo.psOtCheckContent }" var="pocc">
        <!-- 二楼电话线路、数据线路配线线架 -->
        <td>
            <c:choose>
                <c:when test="${pocc.fsTlDlwrCheckResult eq 'INNORMAL'}">
                    <font>${pocc.fsTlDlwrCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.fsTlDlwrCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.fsTlDlwrRemarks }</td>
        <!-- 三楼电话线路、数据线路配线线架 -->
        <td>
            <c:choose>
                <c:when test="${pocc.ftTlDlwrCheckResult eq 'INNORMAL'}">
                    <font>${pocc.ftTlDlwrCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.ftTlDlwrCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.ftTlDlwrRemarks }</td>
        <!-- 四楼电话线路、数据线路配线线架 -->
        <td>
            <c:choose>
                <c:when test="${pocc.ffoTlDlwrCheckResult eq 'INNORMAL'}">
                    <font>${pocc.ffoTlDlwrCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.ffoTlDlwrCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.ffoTlDlwrRemarks }</td>
        <!-- 五楼电话线路、数据线路配线线架 -->
        <td>
            <c:choose>
                <c:when test="${pocc.ffiTlDlwrCheckResult eq 'INNORMAL'}">
                    <font>${pocc.ffiTlDlwrCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.ffiTlDlwrCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.ffiTlDlwrRemarks }</td>
        <!-- 六楼电话线路、数据线路配线线架 -->
        <td>
            <c:choose>
                <c:when test="${pocc.fsiTlDlwrCheckResult eq 'INNORMAL'}">
                    <font>${pocc.fsiTlDlwrCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.fsiTlDlwrCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.fsiTlDlwrRemarks }</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_pds_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/psotduty/slhpds/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_dcp_del']}">
			<a href="${rootUrl}duty/psotduty/dcp/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_pds_update']}">
		<a href="${rootUrl}duty/psotduty/slhpds/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>