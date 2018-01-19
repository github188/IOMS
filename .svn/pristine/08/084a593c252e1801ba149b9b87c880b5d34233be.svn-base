<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2">
	<thead>
		<tr>
			<th>序号</th>
			<th>故障类型</th>
			<th>故障摘要</th>
			<th>申报人员</th>
			<th>故障时间</th>
			<th>处理状态</th>
			<th>处理时间</th>
			<th style="width: 15%">操作</th>
		</tr>
	</thead>
	<tbody>
<%-- 		<c:if test="${null!=message}">
			<td colspan="8">${message }</td>
		</c:if> --%>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>
