<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.equip.satellite.bureau.value}</td>
	<td>${vo.tesNodeCode}</td>
	<td>${vo.equip.satellite.siteName}</td>
	<td>${vo.equip.satellite.siteCode}</td>
	<td>${vo.info}</td>

	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['tesnodemng_view']}">
			<a href="${rootUrl}basedata/tes/node/view.do?id=${vo.id}"
				class="my_view {boxwidth:800,boxheight:500}">查看</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['tesnodemng_mod']}">
			<a href="${rootUrl }basedata/tes/node/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:330}">修改</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['tesnodemng_del']}">
			<a href="${rootUrl }basedata/tes/node/del.do?id=${vo.id}"
				confirm_message="本操作将同步删除该节点的业务、用户定制内容以及相关的天线、ODU、衰减器配置,你确定要删除此节点？"
				class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
