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
				<th rowspan="2" scope="col">巡检时间</th>
				<th rowspan="2" scope="col">巡检内容</th>
				<th colspan="6" scope="col">1</th>
				<th colspan="8" scope="col">2</th>
				<th colspan="2" scope="col">3</th>
				<th colspan="2" scope="col">4</th>
				<th width="4%" rowspan="2" scope="col">操作人</th>
				<th width="8%" rowspan="2" scope="col">操作</th>
			</tr>
			<tr>
				<th scope="col">子网1网管工作站状态</th>
				<th scope="col">子网2网管工作站状态</th>
				<th scope="col">子网3网管工作站状态</th>
				<th scope="col">子网4网管工作站状态</th>
				<th scope="col">备注</th>
				<th scope="col">帧中继网管工作站状态</th>
				<th scope="col">子网1网管工作站数据备份至磁带</th>
				<th scope="col">子网2网管工作站数据备份至磁带</th>
				<th scope="col">子网3网管工作站数据备份至磁带</th>
				<th scope="col">子网4网管工作站数据备份至磁带</th>
				<th scope="col">帧中继网网管工作站数据备份至磁带</th>
				<th scope="col">备注</th>
				<th scope="col">备份磁带存放位置</th>
				<th scope="col">备注</th>
				<th scope="col">网管工作站除尘</th>
				<th scope="col">备注</th>
				<th scope="col">转发器底噪电平（切空图查看）(dBm)</th>
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

