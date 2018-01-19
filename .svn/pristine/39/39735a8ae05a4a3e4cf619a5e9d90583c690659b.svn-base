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
<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2" 
class="table table-bordered">
	<thead>
		<tr>
			<th>事件编号</th>
			<th>申告人</th>
			<th>申告时间</th>
			<th>申告电话</th>
			<th>事件发生地址</th>
			<th>当前处理人</th>
			<th>事件类别</th>
			<th>事件级别</th>
			<th>事件单来源</th>
			<th>事件描述</th>
			<th>当前状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${optType ne 'COMPLETEFAULT' && optType ne 'EVALUATE' }">
			<c:forEach items="${faultInformations}" var="vo">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</c:if>
		<c:if test="${optType eq 'COMPLETEFAULT' || optType eq 'EVALUATE'}">
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<c:if test="${optType eq 'COMPLETEFAULT' || optType eq 'EVALUATE' }">
			<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>
</c:if>
