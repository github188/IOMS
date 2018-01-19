<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!-- <script type="text/javascript">
	$(function() {
		$("#dataTable").tablesorter();
	});
</script> -->
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="5%">序号</th>
			<th>电路名</th>
			<th>主叫端站点名称</th>
			<th>主叫端站点代码</th>
			<th>主叫端机箱号</th>
			<th>主叫端槽位号</th>
			<th>被叫端站点名称</th>
			<th>被叫端站点代码</th>
			<th>被叫端机箱号</th>
			<th>被叫端槽位号</th>
			<th>同异步</th>
			<th>电路速率（kbps）</th>
			<th>频带池</th>
			<th>收端信息</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>
