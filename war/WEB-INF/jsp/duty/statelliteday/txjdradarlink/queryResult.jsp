<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
table th {
	/*white-space: nowrap;*/
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
				<th rowspan="3">巡检时间</th>
				<th rowspan="3">巡检内容</th>
				<th colspan="4" width="240px;">100C</th>
				<th colspan="4" width="240px;">100D</th>
				<th colspan="4" width="240px;">100E</th>
				<th colspan="4" width="240px;">1010</th>
				<th rowspan="3">操作人</th>
				<th rowspan="3">操作</th>
			</tr>
			<tr>
				<th width="60px;">1</th>
				<th width="60px;">2</th>
				<th width="60px;">3</th>
				<th width="60px;">4</th>
				
				<th width="60px;">1</th>
				<th width="60px;">2</th>
				<th width="60px;">3</th>
				<th width="60px;">4</th>
				
				<th width="60px;">1</th>
				<th width="60px;">2</th>
				<th width="60px;">3</th>
				<th width="60px;">4</th>
				
				<th width="60px;">1</th>
				<th width="60px;">2</th>
				<th width="60px;">3</th>
				<th width="60px;">4</th>
			</tr>
			<tr>
				<th>上海雷达引接</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>首都机场雷达引接</th>
				<th>&nbsp;</th>
				<th>沈阳雷达引接</th>
				<th>西安雷达引接</th>
				<th>&nbsp;</th>
				<th>广州雷达引接</th>
				<th>乌鲁木齐雷达引接</th>
				<th>海口雷达引接</th>
				<th>成都雷达引接</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
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

