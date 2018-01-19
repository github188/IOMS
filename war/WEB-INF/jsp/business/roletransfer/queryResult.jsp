<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="10%">授权人</th>
			<th width="20%">被授权人</th>
			<!-- <th width="20%">登录名</th>
			<th width="20%">当前角色</th>
			<th width="10%">授权角色</th>
			<th width="15%">授权时间</th> -->
			<th width="20%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty pagn}">
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</c:if>
		<c:if test="${not empty users}">
			<c:forEach items="${users}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<c:if test="${not empty pagn}">
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</c:if>
