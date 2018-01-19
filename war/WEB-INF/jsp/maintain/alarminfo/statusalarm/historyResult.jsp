<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" style="table-layout: fixed; word-warp: break-word; word-break: break-all; overflow: auto;">
	<thead>
		<tr>
		    <th style="width:30px">序号</th>
			<th style="width:140px">节点名称</th>
			<th style="width:110px">站点名称</th>
			<th style="width:90px">站点代码</th>
			<th style="width:90px">设备名称</th>
			<th style="width:90px">设备类型</th>
			<th style="width:90px">告警类型</th>
			<th style="width:90px">严重程度</th>
			<th style="width:140px">开始时间</th>
			<th style="width:140px">结束时间</th>
			<th style="width:140px">相应次数</th>
			<th style="width:140px">记录时间</th>
			<th style="width:140px">告警信息</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="historyrow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>