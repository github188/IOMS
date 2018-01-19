<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td style="width: 15%">${model.id}</td>
	<td style="width: 15%">${fn:escapeXml(model.name) }</td>
	<td style="width:10%">${model.type.value}</td>
	<td>${fn:escapeXml(model.url) }</td>
	<td style="width: 5%">${model.list}</td>
	<td class="tdbtn" width="15%"><sec:authorize
			ifAnyGranted="${jspAuthorities['resourcemng_mod']}">
			<a href="${rootUrl }acl/resource/mod.do?id=${model.id}"
				class="my_edit">修改</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['resourcemng_del']}">
			<a href="${rootUrl }acl/resource/del.do?id=${model.id}"
				confirm_message="确定要删除吗?" class="my_remove">删除</a>
		</sec:authorize></td>

</tr>