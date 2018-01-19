<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter"
	style="table-layout: fixed; word-warp: break-word; word-break: break-all; overflow: auto;">
	<thead>
		<tr>
			<th style="width:115px">区域</th>			
			<th style="width:130px">节点代码</th>
			<th style="width:115px">slot</th>
			<th style="width:115px">AlarmStatus</th>
			<th style="width:115px">运行时间</th>
			<th style="width:115px">F/B CardState</th>
			<th style="width:125px">FrontType</th>
			<th style="width:115px">FrontSerial</th>
			<th style="width:115px">BackUpperType</th>
			<th style="width:115px">BackUpperSerial</th>
			<th style="width:115px">BackLowerType</th>
			<th style="width:115px">BackLowerSerial</th>
			<th style="width:115px">BackType</th>
			<th style="width:115px">BackSerial</th>
			<th style="width:125px">记录时间</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>

	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>
