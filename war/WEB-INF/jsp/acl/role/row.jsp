<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${fn:escapeXml(vo.name)}</td>
	<td>${fn:escapeXml(vo.info)}</td>
	<td>${vo.system.value}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['rolemng_mod']}">
			<a href="${rootUrl }acl/role/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:500,boxheight:250}">修改</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['rolemng_del']}">
			<a href="${rootUrl }acl/role/del.do?id=${vo.id}"
				confirm_message="你确定要删除此角色？" class="my_remove">删除</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['rolemng_conf']}">
			<a href="${rootUrl }acl/role/conf.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:700}">配置</a>
		</sec:authorize></td>
</tr>
