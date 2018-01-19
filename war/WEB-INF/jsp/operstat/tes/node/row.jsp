<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr 
<c:if test="${vo.power!='正常'}">
	style="background: red;"
</c:if>
 >
    <td>${fn:escapeXml(vo.bureau.value)}</td>
	<td><div title='${fn:escapeXml(vo.code)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.code)}</div></td>
	<td>${fn:escapeXml(vo.chassis)}</td>
	<td>${fn:escapeXml(vo.cu)}</td>
	<td>${fn:escapeXml(vo.model)}</td>
	<c:if test="${fn:escapeXml(vo.power) eq '正常'}">
		<td></td>
	</c:if>
	<c:if test="${fn:escapeXml(vo.power) ne '正常'}">
		<td>${fn:escapeXml(vo.power)}</td>
	</c:if>
	<td><div title='${fn:escapeXml(vo.info)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.info)}</div></td>
	<td class="tdbtn">
		<a href="${rootUrl }operstat/tes/node/find.dox?tesnode=${vo.chassis}&tescu=${vo.cu}"
			class="my_edit {boxwidth:700,boxheight:650}">历史信息</a>
	</td>
</tr>
