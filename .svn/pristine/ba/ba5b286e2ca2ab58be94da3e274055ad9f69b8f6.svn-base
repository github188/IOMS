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
			
			<th style="width:5%">序号</th>
			<th style="width:12%">手机号</th>
			<th style="width:20%">邮箱</th>
			<th style="width:10%">发送状态</th>
			<th style="width:12%">发送类型</th>
			<th style="width:12%">发送时间</th>
			<th>信息</th>
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
