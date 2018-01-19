<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="5%">序号</th>
			<th width="5%">区域</th>
			<th width="10%">站点名称</th>
			<th width="10%">站点代码</th>
			<th width="5%">站点类型</th>
			<!-- <th width="5%">天线代码</th> -->
			<th width="5%">天线尺寸</th>
			<th width="5%">站点纬度</th>
			<th width="5%">站点经度</th>
			<th width="5%">方位角(度)</th>
			<th width="5%">俯仰角（度）</th>
			<th width="5%">海拔</th>
			<th>操作</th>
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


