<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
$(function(){
	$(".serviceButton").nyroModal({
		forceType : "iframe",
		minWidth : 1850,
		minHeight : 530,
		closeButton : null
	});
});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="20%">区域</th>
			<th width="50%">业务类型</th>
			<th width="10%">数量</th>
			<th width="10%">操作</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>

