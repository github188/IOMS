<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.kuNodeNo)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.bureau.value)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.siteName)}</td> 
	<td class="rxLevel">${fn:escapeXml(vo.rxLevel)}</td>
	<%-- <c:choose>
		<c:when test="${vo.rxLevel ge satelparam.kuRxLevelLowerLimit and vo.rxLevel le satelparam.kuRxLevelTopLimit}">
			<td>	
		</c:when>
		<c:otherwise>
			<td style="background:#ff3300">
		</c:otherwise>
	</c:choose>
		${vo.rxLevel}
	</td> --%>
	<td class="ebNo">	
		${fn:escapeXml(vo.ebno)}
	</td>
	<td>
	<fmt:formatDate value="${vo.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
</tr>
<script type="text/javascript">
	$(function(){
		
		$(".rxLevel").each(function(i){
			//将数据转换成float格式
			var rxLevel = $.trim($(this).text());
			rxLevel = parseFloat((rxLevel));
			var top = parseFloat(${satelparam.kuRxLevelTopLimit});
			var lower = parseFloat(${satelparam.kuRxLevelLowerLimit});
			if(rxLevel > top || rxLevel < lower){
				$(this).css("background","#f30");
			}
		});
		
		$(".ebNo").each(function(i){
			var ebno = $.trim($(this).text());
			ebno = parseFloat((ebno));
			if(ebno<'${satelparam.kuEbNoTopLimit}'){
				$(this).css("background","#f30");
			}
		});
	});
</script>