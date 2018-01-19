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
        <!-- 本月线路运行情况 -->
        <td>${pocc.monthLrs }</td>
        <!-- 本月线路运行情况 -->
        <td>${pocc.monthLas }</td>
        <!-- 本月线路运行情况 -->
        <td>${pocc.monthLcs }</td>
        <!-- 本月线路运行情况 -->
        <td>${pocc.monthLfs }</td>
        <!-- 本月线路运行情况 -->
        <td>${pocc.monthLcsc }</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_ncc_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/psotduty/ncc/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_dcp_del']}">
			<a href="${rootUrl}duty/psotduty/dcp/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['psot_check_ncc_update']}">
		<a href="${rootUrl}duty/psotduty/ncc/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>