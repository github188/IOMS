<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: fixed;">
	<thead>
		<tr>
			<th data-options="5%">咨询类型</th>
			<th data-options="20%">咨询关键字</th>
			<th data-options="10%">咨询人员</th>
			<th data-options="20%">咨询时间</th>
			<th data-options="10%">处理状态</th>
			<th data-options="20%">处理时间</th>
			<th data-options="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${pagn.totalCount==0}">
			<td colspan="7">记录为空！</td>
		</c:if>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
