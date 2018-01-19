<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	table th {
		white-space: nowrap;
	}
	table td{
		white-space: nowrap;
	}
	table{
		empty-cells: show;
		border-collapse: collapse;
		table-layout: auto;
	}
-->
</style>
<script type="text/javascript">
	$(function() {
		
	});
	var rootUrl = '${rootUrl }';
</script>
<div style="width:100%; overflow: scroll;">
	<table id="dataTable"  border="0" cellspacing="0"
		cellpadding="2" class="tablesorter">
		<thead>
			<tr>
				<th width="7%" rowspan="3">时间</th>
				<th width="4.8%" rowspan="3">转报同步1</th>
				<th width="4.8%" rowspan="3">转报同步2</th>
				<th width="4.8%" rowspan="3">基地总局异步1</th>
				<th width="4.8%" rowspan="3">基地总局异步2</th>
				<th width="4.8%" rowspan="3">基地双井</th>
				<th width="4.8%" rowspan="3">十里河1</th>
				<th width="4.8%" rowspan="3">十里河2</th>
				<th width="4.8%" rowspan="3">十里河3</th>
				<th width="4.8%" rowspan="3">十里河4</th>
				<th width="4.8%" rowspan="3">十里河同步1</th>
				<th width="4.8%" rowspan="3">十里河同步2</th>
				<th width="4.8%" rowspan="3">总局异步2（11201）</th>
				<th width="4.8%" rowspan="3">总局异步3（11202）</th>
				<th width="4.8%" rowspan="3">双井1</th>
				<th width="4.8%" rowspan="3">双井2</th>
				<th width="7%" rowspan="3">创建情况</th>
				<th width="7%" rowspan="3">审核情况</th>
				<th width="7%" rowspan="3">操作</th>
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
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>


