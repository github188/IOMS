<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<c:if test="${!vo.complete}">
	<tr class="red">
</c:if>
<c:if test="${vo.complete}">
	<tr>
</c:if>

<td><input type="checkbox" name="checkSerive" value="${vo.id }" /></td>
<td>${vo.bureau.value}</td>
<td>${vo.code}</td>


<td>${vo.circuitTypeDetail}</td>
<td>${vo.rateType.value }</td>
<td>${vo.configTime}</td>


<td>${vo.txNode.kuNodeCode }</td>
<td>${vo.txNode.equip.satellite.siteName }</td>
<td>${vo.txNode.kuNodeNo }</td>
<td>${vo.txGib }</td>
<td>${vo.txChan }</td>

<td>${vo.rxNode.kuNodeCode }</td>
<td>${vo.rxNode.equip.satellite.siteName }</td>
<td>${vo.rxNode.kuNodeNo }</td>
<td>${vo.rxGib }</td>
<td>${vo.rxChan }</td>
<td style="width:150px">${vo.memo }</td>
<td id="changeType">${vo.serviceChangeType.value }</td>
<td><fmt:formatDate value="${vo.recordTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
<td class="tdbtn"><sec:authorize
		ifAnyGranted="${jspAuthorities['kuservicemng_view']}">
		<a href="${rootUrl }basedata/ku/service/view.do?id=${vo.id}"
			class="my_view {boxwidth:850,boxheight:460}">查看</a>
	</sec:authorize></td>

<!-- 
<td width="5%">${vo.circuitInfo }</td>
<td width="5%">${vo.serviceType }</td>
<td width="5%">${vo.crm }</td>
<td width="5%">${vo.usage }</td>
<td width="5%">${vo.info }</td> 
-->
</tr>
