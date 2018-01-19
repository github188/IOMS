<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
 $("table").find("tr").each(function(){
	$(this).find("#changeType").each(function(){
		var type = $(this).text();
		switch (type){
			case '新增':$(this).css("background-color","#3399ff");
				break;
			case '变化':$(this).css("background-color","orange");
				break;
			case '正常'://$(this).css("background-color","#33ff66");
				break;
			case '删除':$(this).css("background-color","#ff3300");
				break;
		}
	});
	
//alert($(this).find("#changeType").text());
});  

</script>
<tr>
    
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.service.serviceName}</td>
	
	<td>${vo.service.localNode.atmNodeCode}</td>
	<td>${vo.service.localPort }</td>
	<td>${vo.service.localPortDLCIVPIVCI }</td>
	
	<td>${vo.service.remoteNode.atmNodeCode}</td>
	<td>${vo.service.remotePort }</td>
	<td>${vo.service.remotePortDLCIVPIVCI }</td>
	
	<td>${vo.service.serviceCir }</td>
	<td>${vo.service.serviceClass }</td>
	<td id="changeType">${vo.service.serviceChangeType.value }</td>
	<c:choose>
		<c:when test="${vo.isAlarm eq false }">
			<td>正常</td>
		</c:when>
		<c:otherwise>
			<td style="background-color:#ff3300">异常</td>
		</c:otherwise>
	</c:choose>
	<td><fmt:formatDate value="${vo.service.recordTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
	<td class="tdbtn" width="60px"><sec:authorize
			ifAnyGranted="${jspAuthorities['atmservicemng_view']}">
			<a href="${rootUrl }basedata/atm/service/view.do?id=${vo.service.id}"
				class="my_view {boxwidth:850,boxheight:380}">查看</a>
		</sec:authorize> 
		<sec:authorize
			ifAnyGranted="${jspAuthorities['atmservicemng_mod']}">
			<a href="${rootUrl }basedata/atm/service/mod.do?id=${vo.service.id}"
				class="my_edit {boxwidth:850,boxheight:380}">修改</a>
		</sec:authorize> </td>
</tr>
