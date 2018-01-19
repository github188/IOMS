<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
$(function(){
	$(".alarmButton").nyroModal({
		forceType : "iframe",
		minWidth : 1000,
		minHeight : 750,
		closeButton : null
	});
});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: fixed;">
	<thead>
		<tr>
			<th rowspan="2" width="20%">区域</th>
			<th rowspan="2" width="30%">节点代码</th>
			<th colspan="3">告警等级</th>
			<th rowspan="2" width="20%">详情</th>
		</tr>
		<tr>
			<th width="10%">Critical</th>
			<th width="10%">Major</th>
			<th width="10%">Minor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
