<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${vo.bureau.value}</td>
	<td>${vo.company}</td>
	<td>${vo.address}</td>
	<td>${vo.postcode}</td>
	
	<td class="tdbtn">
        <sec:authorize
			ifAnyGranted="${jspAuthorities['client_mod']}">
			<a href="${rootUrl }systemmng/clientcompany/mod.do?id=${vo.id}"
				class="my_view {boxwidth:800,boxheight:240}">修改</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['client_del']}">
				<a href="${rootUrl }systemmng/clientcompany/del.do?id=${vo.id}"
					 class="my_remove">删除</a>
		</sec:authorize>
	</td>

</tr>
