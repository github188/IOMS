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
			<th>ifNum</th>
			<th>Line/Path Num</th>
			<th>Admin Stat</th>
			<th>Oper Stat</th>
			<th>if Type</th>
			<th>SCT In Use</th>
			<th>DS0 Start(Num)</th>
			<th>Port Speed(kbps)</th>
			<th>ESR</th>
			<th>Signaling Type</th>
			<th>ELMISt</th>
			<th>FRF12Frg</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="mpsmfrRow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>

