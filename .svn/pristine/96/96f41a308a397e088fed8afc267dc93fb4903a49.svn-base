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
				<th width="52" rowspan="2" scope="col">巡检时间</th>
				<th width="27" rowspan="2" scope="col">巡检内容</th>
				<th width="42" colspan="3" scope="col">1</th>
				<th width="42" colspan="3" scope="col">2</th>
				<th width="42" colspan="3" scope="col">3</th>
				<th width="42" colspan="3" scope="col">4</th>
				<th width="42" colspan="3" scope="col">5</th>
				<th width="42" colspan="3" scope="col">6</th>
				<th width="42" colspan="3" scope="col">7</th>
				<th width="42" colspan="3" scope="col">8</th>
				<th width="42" colspan="3" scope="col">9</th>
				<th width="42" colspan="3" scope="col">10</th>
				<th width="86" rowspan="2" scope="col">操作人</th>
				<th width="30" rowspan="2" scope="col">操作</th>
			</tr>
			<tr>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
				<th scope="col">工具名称</th>
				<th scope="col">数量</th>
				<th scope="col">备注</th>
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

