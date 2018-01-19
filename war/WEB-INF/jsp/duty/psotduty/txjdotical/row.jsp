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
        <!-- 设备运行环境 -->
        <td>
            <c:choose>
                <c:when test="${pocc.eoeFanCheckResult eq 'INNORMAL'}">
                    <font>${pocc.eoeFanCheckResult.value}</font>
                </c:when>
                <c:otherwise>
                    ${pocc.eoeFanCheckResult.value}
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.eoeFanRemarks }</td>
        <td>${pocc.eoeTemCheckResult }</td>
        <td>${pocc.eoeTemRemarks }</td>
        <td>${pocc.eoeHumCheckResult }</td>
        <td>${pocc.eoeHumRemarks }</td>
        <!-- 设备指示灯状态 -->
        <td>
            <c:choose>
                <c:when test="${pocc.disCheckResult eq 'INNORMAL' }">
                    <font>${pocc.disCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.disCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.disRemarks }</td>
        <!-- 板卡运行状态 -->
        <td>
            <c:choose>
                <c:when test="${pocc.crsCheckResult eq 'INNORMAL' }">
                    <font>${pocc.crsCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.crsCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.crsRemarks }</td>
        <!-- 设备线缆连接 -->
        <td>
            <c:choose>
                <c:when test="${pocc.dlccCheckResult eq 'LOOSE' }">
                    <font>${pocc.dlccCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.dlccCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.dlccRemarks }</td>
        <!-- 电源供电连接 -->
        <td>
            <c:choose>
                <c:when test="${pocc.pscCheckResult eq 'LOOSE' }">
                    <font>${pocc.pscCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.pscCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.pscRemarks }</td>
        <c:if test="${vo.checkType eq 'QUARTER' }">
            <!--接地保护 -->
            <td>
                <c:choose>
                    <c:when test="${pocc.gpCheckResult eq 'INNORMAL' }">
                        <font>${pocc.gpCheckResult.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${pocc.gpCheckResult.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${pocc.gpRemarks }</td>
            <!--DDF、ODF架接头 -->
            <td>
                <c:choose>
                    <c:when test="${pocc.ddfOdfCheckResult eq 'LOOSE' }">
                        <font>${pocc.ddfOdfCheckResult.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${pocc.ddfOdfCheckResult.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${pocc.ddfOdfRemarks }</td>
            <!--光缆使用情况 -->
            <td>
                <c:choose>
                    <c:when test="${pocc.ocuCheckResult eq 'UNFREE' }">
                        <font>${pocc.ocuCheckResult.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${pocc.ocuCheckResult.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${pocc.ocuRemarks }</td>
            <!--光纤标识 -->
            <td>
                <c:choose>
                    <c:when test="${pocc.ofcCheckResult eq 'UNPASTE' }">
                        <font>${pocc.ofcCheckResult.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${pocc.ofcCheckResult.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${pocc.ofcRemarks }</td>
            <!--设备清洁/除尘 -->
            <td>
                <c:choose>
                    <c:when test="${pocc.ecCheckResult eq 'No' }">
                        <font>${pocc.ecCheckResult.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${pocc.ecCheckResult.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${pocc.ecRemarks }</td>
        </c:if>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_txjdotical_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/psotduty/txjdotical/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_dcp_del']}">
			<a href="${rootUrl}duty/psotduty/dcp/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_txjdotical_update']}">
		<a href="${rootUrl}duty/psotduty/txjdotical/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>