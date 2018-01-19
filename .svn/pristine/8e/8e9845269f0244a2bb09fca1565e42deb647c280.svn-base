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
			<th width="10%">故障类型</th>
			<th width="20%">故障关键字</th>
			<th width="10%">申报人员</th>
			<th width="10%">故障时间</th>
			<th width="10%">处理状态</th>
			<th width="10%">处理时间</th>
			<th width="12%">流程查看</th>
			<th width="18%">操作</th>
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
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
