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
        <!-- 当前主用 -->
        <td>${pocc.cmuCheckResult.value }</td>
        <td>${pocc.cmuRemarks }</td>
        <!-- A机主控板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.mcbaCheckResult eq 'INNORMAL' }">
                    <font>${pocc.mcbaCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.mcbaCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.mcbaRemarks }</td>
        <!-- A机1号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cba1CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cba1CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cba1CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cba1Remarks }</td>
        <!-- A机2号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cba2CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cba2CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cba2CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cba2Remarks }</td>
        <!-- A机3号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cba3CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cba3CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cba3CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cba3Remarks }</td>
        <!-- A机E1板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbae1CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbae1CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbae1CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbae1Remarks }</td>
        <!-- B机主控板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.mcbbCheckResult eq 'INNORMAL' }">
                    <font>${pocc.mcbbCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.mcbbCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.mcbbRemarks }</td>
        <!-- B机1号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb1v35CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb1v35CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb1v35CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb1v35Remarks }</td>
        <!-- B机2号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb2v35CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb2v35CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb2v35CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb2v35Remarks }</td>
        <!-- B机3号v.35板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb3v35CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb3v35CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb3v35CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb3v35Remarks }</td>
        <!-- B机1号v.24板卡-->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb1v24CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb1v24CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb1v24CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb1v24Remarks }</td>
        <!-- B机2号v.24板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb2v24CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb2v24CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb2v24CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb2v24Remarks }</td>
        <!-- B机3号v.24板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbb3v24CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbb3v24CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbb3v24CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbb3v24Remarks }</td>
        <!-- B机E1板卡 -->
        <td>
            <c:choose>
                <c:when test="${pocc.cbbe1CheckResult eq 'INNORMAL' }">
                    <font>${pocc.cbbe1CheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.cbbe1CheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.cbbe1Remarks }</td>
        <!-- V.35接口连接 -->
        <td>
            <c:choose>
                <c:when test="${pocc.v35icCheckResult eq 'LOOSE' }">
                    <font>${pocc.v35icCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.v35icCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.v35icRemarks }</td>
        <!-- V.24接口连接 -->
        <td>
            <c:choose>
                <c:when test="${pocc.v24icCheckResult eq 'LOOSE' }">
                    <font>${pocc.v24icCheckResult.value }</font>
                </c:when>
                <c:otherwise>
                    ${pocc.v24icCheckResult.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${pocc.v24icRemarks }</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_ddn_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/psotduty/ddn/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_dcp_del']}">
			<a href="${rootUrl}duty/psotduty/dcp/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_ddn_update']}">
		<a href="${rootUrl}duty/psotduty/ddn/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>