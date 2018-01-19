<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
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
</style>
<script type="text/javascript">
	var rootUrl = '${rootUrl }';
</script>
<div style="width: 100%; overflow: scroll;">
	<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
		class="tablesorter">
		<thead>
			<tr>
				<th rowspan="2" scope="col">巡检时间</th>
				<th rowspan="2" scope="col">巡检内容</th>
				<th colspan="5" scope="col">TES081</th>
				<th colspan="5" scope="col">TES281</th>
				<th colspan="5" scope="col">TES381</th>
				<th colspan="5" scope="col">TES481</th>
				<th rowspan="2" scope="col">创建情况</th>
				<th rowspan="2" scope="col">审核情况</th>
				<th rowspan="2" scope="col">操作</th>
			</tr>
			<tr>
				<th scope="col">CU</th>
				<th scope="col">CKT</th>
				<th scope="col">HG</th>
				<th scope="col">DD</th>
				<th scope="col">ROUTE</th>
				<th scope="col">CU</th>
				<th scope="col">CKT</th>
				<th scope="col">HG</th>
				<th scope="col">DD</th>
				<th scope="col">ROUTE</th>
				<th scope="col">CU</th>
				<th scope="col">CKT</th>
				<th scope="col">HG</th>
				<th scope="col">DD</th>
				<th scope="col">ROUTE</th>
				<th scope="col">CU</th>
				<th scope="col">CKT</th>
				<th scope="col">HG</th>
				<th scope="col">DD</th>
				<th scope="col">ROUTE</th>
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

