<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
    <td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td> 
	<td>${fn:escapeXml(vo.bureau.value)}</td>
	<td>${fn:escapeXml(vo.atmNodeSeq)}</td>
	<td>${vo.atmNodeNameCn}</td>
	<td>${vo.atmNodeCode}</td>
	<td>${vo.atmNodeIp}</td>
	<%-- <td class="tdbtn">
	<sec:authorize
			ifAnyGranted="${jspAuthorities['atmnodemng_view']}">
			<a href="${rootUrl }basedata/atm/node/view.do?id=${vo.id}"
				class="my_view{boxwidth:850,boxheight:200}">查看</a>
	</sec:authorize> --%>
		<%-- <sec:authorize ifAnyGranted="${jspAuthorities['atmnodemng_mod']}">
			<a href="${rootUrl }basedata/atm/node/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:330}">修改</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['atmnodemng_del']}">
			<a href="${rootUrl }basedata/atm/node/del.do?id=${vo.id}"
				confirm_message="你确定要删除此节点？" class="my_remove">删除</a>
		</sec:authorize></td> --%>
</tr>
