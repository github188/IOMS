<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#dataTable").tablesorter();
	});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: fixed;">
	<thead>
		<tr>
			
			<th >栏目</th>
			<th >标题</th>
			<th >创建者</th>
			<th >创建时间</th>
			<th >状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pnnoticelist}" var="pnnoticelist" varStatus="pnnoticeStatus">
			<c:set var="task" value="${pnnoticelist.task }" />
			<%@ include file="pressrow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<%-- <div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div> --%>
