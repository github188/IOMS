<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<div>
	<%@ include file="/WEB-INF/jsp/noteInfo.jsp"%>
	<table id="my_resultData">
		<%@ include file="row.jsp"%>
	</table>
	<label id="result_id" >
	<c:choose>
		<c:when test="${empty model}">${param.id}</c:when>
		<c:otherwise>
			${model.type }_${model.id }
		</c:otherwise> 
	</c:choose>
	</label>
	
	<label id="result_menuId">${pid }</label>
	<label id="result_name">${fn:escapeXml(model.name) }</label>
</div>