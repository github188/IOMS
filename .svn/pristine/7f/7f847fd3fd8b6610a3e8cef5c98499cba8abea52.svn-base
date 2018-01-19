<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th rowspan="2">序号</th>
			<th rowspan="2">业务名称</th>
			<th colspan="3">本地节点</th>
			<th colspan="3">远端节点</th>
			<th rowspan="2">速率（kbps）</th>
			<th rowspan="2">服务等级</th>
			<th rowspan="2">状态</th>
			<th rowspan="2">操作</th>
		</tr>
		<tr>
		  <th>节点名称</th>
		  <th>端口号</th>
		  <th>dlci/ vpi.vci</th>
		  
		  <th>节点名称</th>
		  <th>端口号</th>
		  <th>dlci/ vpi.vci</th>
		</tr>
	</thead>
<tbody>
	 <c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
	 		<%@ include file="detailRow.jsp"%>	
	 </c:forEach>
</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount }"></div>

