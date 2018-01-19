<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
$(function(){
	$(".pnniButton").nyroModal({
		forceType : "iframe",
		minWidth : 800,
		minHeight : 530,
		closeButton : null
	});
});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th>区域</th>
			<th>板卡类型</th>
			<th>端口数量【在用数量/总数】</th>
			<th>操作</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>

