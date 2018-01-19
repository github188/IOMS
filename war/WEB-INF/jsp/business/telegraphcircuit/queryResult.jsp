<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	});
	var rootUrl = '${rootUrl }';
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: fixed;">
	<thead>
		<tr>
			<th data-options="5%">申请人</th>
			<th data-options="20%">申请单位</th>
			<th data-options="10%">联系人</th>
			<th data-options="20%">联系电话</th>
			<th data-options="5%">申请类型</th>
			<th data-options="10%">申请时间</th>
			<!-- <th data-options="20%">审批状态</th> -->
			<th data-options="32%">审批进度</th>
			<th data-options="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${pagn.totalCount==0}">
			<td colspan="8">记录为空！</td>
		</c:if>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>
