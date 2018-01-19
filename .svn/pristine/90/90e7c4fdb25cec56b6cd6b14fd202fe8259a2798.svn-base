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
<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2">
	<thead>
		<tr>
			<th width="3%" data-options="3%">序号</th>
			<th width="5%" data-options="5%">申请编号</th>
			<th width="10%" data-options="5%">申请人</th>
			<th width="20%" data-options="15%">申请单位</th>
			<th width="6%" data-options="6%">联系人</th>
			<th width="10%" data-options="15%">联系电话</th>
			<th width="13%" data-options="10%">申请时间</th>
			<th width="10%" data-options="20%">申请类别</th>
			<th width="13%" data-options="10%">当前状态</th>
			<th width="10%" data-options="10%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${pagn.totalCount==0}">
			<td colspan="9">记录为空！</td>
		</c:if>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>
