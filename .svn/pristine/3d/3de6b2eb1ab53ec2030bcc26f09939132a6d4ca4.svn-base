<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${vo.circuitName}</td>
	<td>${vo.activeNode.equip.satellite.siteName}</td>
	<td>${vo.activeNode.equip.satellite.siteCode}</td>
	<td>${vo.activeNode.tesNodeCode}</td>
	<td>${vo.activeSlot}</td>	
	<td>${vo.passiveNode.equip.satellite.siteName}</td>
	<td>${vo.passiveNode.equip.satellite.siteCode}</td>
	<td>${vo.passiveNode.tesNodeCode}</td>
	<td>${vo.passiveSlot}</td>
	<td>${vo.rate}</td>
	<td>${vo.bandWidthPool}</td>
	<td>${vo.sync}</td>
	<td>${vo.serviceMemo }</td>
	<td>${vo.info}</td>	
	<td class="tdbtn">
		<sec:authorize ifAnyGranted="${jspAuthorities['tesservice_mod']}">
			<a href="${rootUrl }operstat/tes/service/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:368}">修改</a>
		</sec:authorize> 
	</td>
</tr>
