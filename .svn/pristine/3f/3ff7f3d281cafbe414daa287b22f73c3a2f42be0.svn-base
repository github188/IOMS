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
			<th>SlotNum</th>
			<th>PortLineNum</th>
			<th>PortNum</th>
			<th>PortRowStatus</th>
			<th>PortSpeed</th>
			<th>EQServ Ratio</th>
			<th>SignalType</th>
			<th>T391</th>
			<th>T392</th>
			<th>N391</th>
			<th>N392</th>
			<th>N393</th>
			<th>Type</th>
			<th>Alarm</th>
			<th>ELMI</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="frsmRow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>

