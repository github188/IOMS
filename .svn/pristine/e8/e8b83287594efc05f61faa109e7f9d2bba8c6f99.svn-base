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
				<th width="19" rowspan="3" scope="col">巡检时间</th>
				<th width="19" rowspan="3" scope="col">巡检内容</th>
				<th colspan="34" scope="col">子网1</th>
				<th colspan="34" scope="col">子网2</th>
				<th colspan="34" scope="col">子网3</th>
				<th colspan="34" scope="col">子网4</th>
				<th colspan="51" scope="col">帧中继网</th>
				<th width="19" rowspan="3" scope="col">操作人</th>
				<th width="186" rowspan="3" scope="col">操作</th>
			</tr>
			<tr>
				<th colspan="17" scope="col">0号节点</th>
				<th colspan="17" scope="col">1号节点</th>
				<th colspan="17" scope="col">0号节点</th>
				<th colspan="17" scope="col">1号节点</th>
				<th colspan="17" scope="col">0号节点</th>
				<th colspan="17" scope="col">1号节点</th>
				<th colspan="17" scope="col">0号节点</th>
				<th colspan="17" scope="col">1号节点</th>
				<th colspan="17" scope="col">0号节点</th>
				<th colspan="17" scope="col">1号节点</th>
				<th colspan="17" scope="col">7号节点</th>
			</tr>
			<tr>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>


				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">备注</th>

				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
				<th scope="col">槽位号</th>
				<th scope="col">板卡类型</th>
				<th scope="col">使用端口</th>
				<th scope="col">剩余端口</th>
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

