<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>

	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>

	<td>${vo.circuitName}</td>

	<td>${vo.activeNode.equip.satellite.siteName}</td>
	<td>${vo.activeNode.equip.satellite.siteCode}</td>
	<td>${vo.activeNode.tesNodeCode}</td>
	<td>${vo.activeSlot}</td>

	<td>${vo.passiveNode.equip.satellite.siteName}</td>
	<td>${vo.passiveNode.equip.satellite.siteCode}</td>
	<td>${vo.passiveNode.tesNodeCode}</td>
	<td>${vo.passiveSlot}</td>
	<td>${vo.sync}</td>
	<td>${vo.rate}</td>
	<td>${vo.bandWidthPool}</td>


	<td>${vo.serviceMemo}</td>

	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['tesservicemng_view']}">
			<a href="${rootUrl }basedata/tes/service/view.do?id=${vo.id}"
				class="my_view {boxwidth:850,boxheight:380}">查看</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['tesservicemng_mod']}">
			<a href="${rootUrl }basedata/tes/service/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:350}">修改</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['tesservicemng_del']}">
			<a href="${rootUrl }basedata/tes/service/del.do?id=${vo.id}"
				confirm_message="你确定要删除此业务？" class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
