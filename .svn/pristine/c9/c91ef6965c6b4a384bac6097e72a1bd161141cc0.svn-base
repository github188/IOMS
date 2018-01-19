<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="7%">记录时间</th>
			<th width="8%">Status标准值</th>
			<th width="8%">Status异常节点个数</th>
			<th width="8%">RxLevel标准值</th>
			<th width="10%">RxLevel异常节点个数</th>
			<th width="8%">Eb/No标准值</th>
			<th width="10%">Eb/No异常节点个数</th>
			<th width="10%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>