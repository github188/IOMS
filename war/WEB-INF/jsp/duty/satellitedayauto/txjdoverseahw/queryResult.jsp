<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
table th {
	white-space: nowrap;
}

table td {
	white-space: nowrap;
}

table {
	empty-cells: show;
	border-collapse: collapse;
	table-layout: auto;
}
-->
</style>
<script type="text/javascript">
	/* $(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	}); */
	var rootUrl = '${rootUrl }';
</script>
<div style="width: 100%; overflow: scroll;">
	<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
		class="tablesorter">
		<thead>
			<tr>
				<th rowspan="2">巡检时间</th>
				<th rowspan="2">巡检内容</th>
				<th colspan="3">AR2240设备状态</th>
				<th colspan="2">AR2240--异步转报TCP状态</th>
				<th colspan="4">AR2240--话音状态(LoopBack地址)</th>
				<th rowspan="2">操作人</th>
				<th rowspan="2">操作</th>
			</tr>
			<tr>
				<th>CPU利用率</th>
				<th>加德满都中继端口状态</th>
				<th>仰光中继端口状态</th>

				<th>尼泊尔</th>
				<th>仰光</th>

				<th>加德满都</th>
				<th>仰光</th>
				<th>昆明</th>
				<th>拉萨</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="29">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }"
		pagecount="${pagn.pageCount}"></div>
</div>

