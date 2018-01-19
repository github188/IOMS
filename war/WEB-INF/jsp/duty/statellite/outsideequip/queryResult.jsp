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
				<th>巡检时间</th>
				<th>巡检内容</th>
				<th>ODU主用侧</th>
				<c:choose>
					<c:when
						test="${optType eq 'TxjdOutTesEquip' or optType eq 'MhjOutTesEquip'}">
						<th>底噪电平(dBm)</th>
						<th>OCC载噪比(dB)</th>
					</c:when>
					<c:otherwise>
						<th>ODU 主用侧底噪电平（dB）</th>
						<th>0号载波载噪比（dB）</th>
					</c:otherwise>
				</c:choose>
				<th>ODU风扇状态</th>
				<th>电缆连接与接头防水</th>
				<c:if
					test="${optType eq 'TxjdOutTesEquip' or optType eq 'MhjOutTesEquip'}">
					<th>A路温度</th>
					<th>B路温度</th>
				</c:if>
				<th>操作人</th>
				<th>操作</th>
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

