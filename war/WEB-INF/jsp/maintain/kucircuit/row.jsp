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
<c:if test="${!vo.kuService.complete}">
	<tr class="red">
</c:if>
<c:if test="${vo.kuService.complete}">
	<tr>
</c:if>

<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
<td>${vo.kuService.bureau.value}</td>
<td>${vo.kuService.serviceName}</td>
<td>${vo.kuService.code}</td>


<td>${vo.kuService.circuitTypeDetail}</td>
<td>${vo.kuService.rateType.value }</td>
<td>${vo.kuService.configTime}</td>


<td>${vo.kuService.txNode.kuNodeCode }</td>
<td>${vo.kuService.txNode.equip.satellite.siteName }</td>
<td>${vo.kuService.txNode.kuNodeNo }</td>
<td>${vo.kuService.txGib }</td>
<td>${vo.kuService.txChan }</td>

<td>${vo.kuService.rxNode.kuNodeCode }</td>
<td>${vo.kuService.rxNode.equip.satellite.siteName }</td>
<td>${vo.kuService.rxNode.kuNodeNo }</td>
<td>${vo.kuService.rxGib }</td>
<td>${vo.kuService.rxChan }</td>
<td>${vo.kuService.memo }</td>

<td>${vo.kuService.circuitInfo }</td>
<td>${vo.kuService.usage }</td>
<td>${vo.kuService.crm }</td>

<td id="changeType">${vo.kuService.serviceChangeType.value }</td>
<td><fmt:formatDate value="${vo.kuService.recordTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
<td class="tdbtn"><sec:authorize
		ifAnyGranted="${jspAuthorities['kucircuit_view']}">
		<a href="${rootUrl }maintain/kucircuit/view.do?id=${vo.id}"
			class="my_view {boxwidth:850,boxheight:460}">查看</a>
	</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kucircuit_mod']}">
		<a href="${rootUrl }maintain/kucircuit/mod.do?id=${vo.id}"
			class="my_edit {boxwidth:850,boxheight:590}">修改</a>
	</sec:authorize> <sec:authorize ifAnyGranted="${jspAuthorities['kucircuit_del']}">
		<a href="${rootUrl }maintain/kucircuit/del.do?id=${vo.id}"
			confirm_message="你确定要删除此业务？" class="my_remove">删除</a>
	</sec:authorize></td>
</tr>
