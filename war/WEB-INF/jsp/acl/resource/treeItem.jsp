<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<c:forEach items="${list}" var="appResource">
	<c:choose>
		<c:when test="${appResource.hasChild}">
			<li id="${appResource.type }_${appResource.id }" class="closed"><a
				href="#">${appResource.name }</a></li>
		</c:when>
		<c:otherwise>
			<li id="${appResource.type}_${appResource.id }" class="leaf"><a
				href="#">${appResource.name }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>
