<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<c:if
		test="${(vo.role.name=='aaTempUser' and vo.status eq 'REGISTED') eq 'true'}">

		<td style="background-color: orange;">${vo.bureau.value}</td>
		<td style="background-color: orange;">${vo.name}</td>
		<td style="background-color: orange;">${vo.role.info}</td>
		<td style="background-color: orange;">${vo.newCompany.company}</td>
		<td style="background-color: orange;">${vo.status.value}</td>
		<td style="background-color: orange;"><c:if
				test="${vo.blocking ne 'true'}">
				未冻结
			</c:if> <c:if test="${vo.blocking eq 'true'}">
				已冻结
			</c:if></td>
		<td style="word-wrap: break-word; background-color: orange;">${vo.info}</td>
		<td class="tdbtn" style="background-color: orange;">
	</c:if>
	<c:if
		test="${(vo.role.name=='aaTempUser' and vo.status eq 'REGISTED') ne 'true'}">

		<td>${vo.bureau.value}</td>
		<td>${vo.name}</td>
		<td>${vo.role.info}</td>
		<td>${vo.newCompany.company}</td>
		<td>${vo.status.value}</td>
		<td><c:if test="${vo.blocking ne 'true'}">
				未冻结
			</c:if> <c:if test="${vo.blocking eq 'true'}">
				已冻结
			</c:if></td>
		<td style="word-wrap: break-word">${vo.info}</td>
		<td class="tdbtn">
	</c:if>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_view']}">
		<a href="${rootUrl }systemmng/client/view.do?id=${vo.id}"
			class="my_view {boxwidth:1000,boxheight:390}">查看</a>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_mod']}">
		<a href="${rootUrl }systemmng/client/mod.do?id=${vo.id}"
			class="my_view {boxwidth:1000,boxheight:500}">修改</a>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_audit']}">
		<c:if test="${vo.status=='REGISTED' }">
			<a
				href="${rootUrl }systemmng/client/audit.do?id=${vo.id}&bureau=${vo.bureau}"
				class="my_edit {boxwidth:1000,boxheight:440}">审批</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_block']}">
		<c:if test="${vo.blocking ne 'true' }">
			<a href="${rootUrl }systemmng/client/block.do?id=${vo.id}"
				confirm_message="你确定同意冻结此用户？" class="my_update">冻结</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_unblock']}">
		<c:if test="${vo.blocking eq 'true' }">
			<a href="${rootUrl }systemmng/client/unBlock.do?id=${vo.id}"
				confirm_message="你确定同意解锁此用户？" class="my_update">解锁</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_del']}">
		<c:if test="${vo.status!='PASSED' && vo.status!='APPLYOFF'}">
			<a href="${rootUrl }systemmng/client/del.do?id=${vo.id}"
				confirm_message="你确定要删除此用户？" class="my_remove">删除</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_disable_agree']}">
		<c:if test="${vo.status=='APPLYOFF'}">
			<a href="${rootUrl }systemmng/client/disableAgree.do?id=${vo.id}"
				confirm_message="你确定同意注销此用户？" class="my_update">确认注销</a>
		</c:if>
	</sec:authorize>
	<sec:authorize
		ifAnyGranted="${jspAuthorities['client_satellite_config']}">
		<c:if test="${vo.status=='PASSED'}">
			<a
				href="${rootUrl }systemmng/client/satelliteConfig.do?id=${vo.id}&bureau=${vo.bureau}"
				class="my_edit {boxwidth:1000,boxheight:530}">配置卫星</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_atm_config']}">
		<c:if test="${vo.status=='PASSED'}">
			<a
				href="${rootUrl }systemmng/client/atmConfig.do?id=${vo.id}&bureau=${vo.bureau}"
				class="my_edit {boxwidth:1000,boxheight:530}">配置ATM</a>
		</c:if>
	</sec:authorize>
	<sec:authorize ifAnyGranted="${jspAuthorities['client_resetpwd']}">
		<c:if test="${vo.status=='PASSED'}">
			<a href="${rootUrl }systemmng/client/resetpwd.do?id=${vo.id}"
				confirm_message="你确定要对此用户重置密码？重置后为123456。" class="my_update">重置密码</a>
		</c:if>
	</sec:authorize>
	</td>
</tr>
