<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		$(".tipsTr").tooltip();
	});
</script>
<tr class="tipsTr" title="备注：${vo.info}">
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td> 
	<td>${vo.site.bureau.value}</td>
	<td>${vo.site.siteName}</td>
	<td>${vo.site.siteCode}</td>
	<td>${vo.site.type}</td>
	<%-- <td>${vo.antenna.antennaCode}</td>

	<td>${vo.name}</td> --%>
	<td>${fn:escapeXml(vo.solidLanch)}</td>
	<td>${fn:escapeXml(vo.solidReceive)}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['attenuatormng_view']}">
			<a
				href="${rootUrl }basedata/satellite/attenuator/view.do?id=${vo.id}"
				class="my_view {boxwidth:550,boxheight:240}">查看</a>
		</sec:authorize></td>
</tr>

