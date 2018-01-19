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
	<td>${vo.oduName}</td> --%>
	<td>${vo.oduType}</td>
	<td>${vo.oduPower}</td>
	<td>${vo.lanchMidFreq}</td>
	<td>${vo.receiveMidMinus}</td>
	<td>${vo.lanchPlusMinus}</td>
	<td>${vo.receivePlusMinus}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['odumng_view']}">
			<a href="${rootUrl }basedata/satellite/odu/view.do?id=${vo.id}"
				class="my_view {boxwidth:550,boxheight:280}">查看</a>
		</sec:authorize></td>
</tr>
