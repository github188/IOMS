<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$("table").find("tr").each(function() {
		$(this).find("#changeType").each(function() {
			var type = $(this).text();
			switch (type) {
			case '新增':
				$(this).css("background-color", "green");
				break;
			case '变化':
				$(this).css("background-color", "orange");
				break;
			case '正常'://$(this).css("background-color","#33ff66");
				break;
			case '删除':
				$(this).css("background-color", "gray");
				break;
			}
		});

		//alert($(this).find("#changeType").text());
	});
</script>
<c:if test="${!vo.complete}">
	<tr class="red">
</c:if>
<c:if test="${vo.complete}">
	<tr>
</c:if>

<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
<td>${vo.bureau.value}</td>
<td>${vo.serviceName}</td>
<td>${vo.code}</td>


<td>${vo.circuitTypeDetail}</td>
<td>${vo.rateType.value }</td>
<td>${vo.configTime}</td>


<td>${vo.txNode.kuNodeCode }</td>
<td>${vo.txNode.equip.satellite.siteName }</td>
<td>${vo.txNode.subnetType.value }</td>
<td>${vo.txNode.kuNodeNo }</td>
<td>${vo.txGib }</td>
<td>${vo.txChan }</td>

<td>${vo.rxNode.kuNodeCode }</td>
<td>${vo.rxNode.equip.satellite.siteName }</td>
<td>${vo.rxNode.subnetType.value }</td>
<td>${vo.rxNode.kuNodeNo }</td>
<td>${vo.rxGib }</td>
<td>${vo.rxChan }</td>
<td>${vo.memo }</td>

<td>${vo.circuitInfo }</td>
<td>${vo.usage }</td>
<td>${vo.crm }</td>

<td id="changeType">${vo.serviceChangeType.value }</td>
<td><fmt:formatDate value="${vo.recordTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
<!-- 
<td width="5%">${vo.circuitInfo }</td>
<td width="5%">${vo.serviceType }</td>
<td width="5%">${vo.crm }</td>
<td width="5%">${vo.usage }</td>
<td width="5%">${vo.info }</td> 
-->
<td class="tdbtn"><sec:authorize
		ifAnyGranted="${jspAuthorities['kuservicemng_view']}">
		<a href="${rootUrl }basedata/ku/service/view.do?id=${vo.id}"
			class="my_view {boxwidth:850,boxheight:460}">查看</a>
	</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kuservicemng_mod']}">
		<a href="${rootUrl }basedata/ku/service/mod.do?id=${vo.id}"
			class="my_edit {boxwidth:850,boxheight:590}">修改</a>
	</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kuservicemng_del']}">
		<a href="${rootUrl }basedata/ku/service/del.do?id=${vo.id}"
			confirm_message="你确定要删除此业务？" class="my_remove">删除</a>
	</sec:authorize></td>
</tr>
