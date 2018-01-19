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
				<th rowspan="3" scope="col">巡检时间</th>
				<th rowspan="3" scope="col">巡检内容</th>
				<th colspan="15" scope="col">中星10号C-8B</th>
				<th colspan="5" scope="col">亚洲4号-K-8V</th>
				<th rowspan="3" scope="col">操作人</th>
				<th rowspan="3" scope="col">操作</th>
			</tr>
			<tr>
				<th colspan="5" scope="col">TES系统</th>
				<th colspan="5" scope="col">PES系统</th>
				<th colspan="5" scope="col">COMTECH系统</th>
				<th colspan="5" scope="col">Vsat Plus II系统</th>
			</tr>
			<tr>
				<th scope="col">总宽带(MHz)</th>
				<th scope="col">已用宽带(MHz)</th>
				<th scope="col">剩余宽带(MHz)</th>
				<th scope="col">转发器底噪电平(dBm)</th>
				<th scope="col">转发器增益档(dB)</th>
				<th scope="col">总宽带(MHz)</th>
				<th scope="col">已用宽带(MHz)</th>
				<th scope="col">剩余宽带(MHz)</th>
				<th scope="col">转发器底噪电平(dBm)</th>
				<th scope="col">转发器增益档(dB)</th>
				<th scope="col">总宽带(MHz)</th>
				<th scope="col">已用宽带(MHz)</th>
				<th scope="col">剩余宽带(MHz)</th>
				<th scope="col">转发器底噪电平(dBm)</th>
				<th scope="col">转发器增益档(dB)</th>
				<th scope="col">总宽带(MHz)</th>
				<th scope="col">已用宽带(MHz)</th>
				<th scope="col">剩余宽带(MHz)</th>
				<th scope="col">转发器底噪电平(dBm)</th>
				<th scope="col">转发器增益档(dB)</th>
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

