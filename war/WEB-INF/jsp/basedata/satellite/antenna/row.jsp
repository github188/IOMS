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
	<%-- <td>${vo.antennaCode}</td> --%>
	<td>${vo.antennaSize}</td>
	<td>${vo.latitude}</td>
	<td>${vo.longitude}</td>
	<td>${vo.positionAngle}</td>
	<td>${vo.pitchingAngle}</td>
	<td>${vo.elevation}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['antennamng_view']}">
			<a href="${rootUrl}basedata/satellite/antenna/view.do?id=${vo.id}"
				class="my_view {boxwidth:550,boxheight:350}">查看</a>
		</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['antennamng_mod']}">
			<a href="${rootUrl }basedata/satellite/antenna/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:500}">修改</a>
		</sec:authorize></td>
</tr>