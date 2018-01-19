<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th>区域</th>
			<th>设备节点</th>
			<th>槽 位</th>
			<th>SLOT_NUM</th>
			<th>LINE_NUM</th>
			<th>PORT_ROW_STATE</th>
			<th>PORT_NUM_SLOTS</th>
			<th>PORT_DS0_CONFIG_BITMAP</th>
			<th>PORT_SPEED</th>
			<th>PORT_TYPE</th>
			<th>PORT_STATE</th>
			<th>PORT_NUM</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="cesmRow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>

