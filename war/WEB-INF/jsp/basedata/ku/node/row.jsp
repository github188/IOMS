<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.equip.bureau.value}</td>
	<!-- 新加子网 dyl add -->
	<td>${fn:escapeXml(vo.subnetType.value)}</td>
	
	<td>${fn:escapeXml(vo.kuNodeNo)}</td>
	<td>${fn:escapeXml(vo.kuNodeCode)}</td>
	<td><c:if test="${vo.caac==true}">是</c:if> <c:if
			test="${vo.caac==false}">否</c:if></td>
	<td>${vo.equip.satellite.siteName}</td>
	<td>${vo.equip.satellite.siteCode}</td>

	<td>${vo.type}</td>
	<td><c:if test="${vo.instrument==true}">有</c:if> <c:if
			test="${vo.instrument==false}">无</c:if></td>

	<td>${vo.cardCount}</td>
	<td>${vo.cardConfig}</td>

	<td>${vo.status}</td>
	<td>${vo.statusInfo}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['kunodemng_view']}">
			<a href="${rootUrl }basedata/ku/node/view.do?id=${vo.id}"
				class="my_view {boxwidth:800,boxheight:500}">查看</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kunodemng_mod']}">
			<a href="${rootUrl }basedata/ku/node/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:610}">修改</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kunodemng_del']}">
			<a href="${rootUrl }basedata/ku/node/del.do?id=${vo.id}"
				confirm_message="本操作将同步删除该节点的业务、用户定制内容以及相关的天线、ODU、衰减器配置,你确定要删除此节点？"
				class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
