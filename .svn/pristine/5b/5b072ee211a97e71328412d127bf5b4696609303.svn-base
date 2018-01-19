<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	table th {
		white-space: nowrap;
	}
	table td{
		white-space: nowrap;
	}
	table{
		empty-cells: show;
		border-collapse: collapse;
		table-layout: auto;
	}
-->
</style>
<div style="width: 100%; overflow: scroll;">
	<table id="dataTable" class="table table-bordered">
		<thead>
			<tr>
				<th>设备名称</th>
				<th colspan="8">转报系统主机</th>
				<th colspan="3">转报系统备机</th>
				<th colspan="2">主用智能集中器A进程检查</th>
				<th colspan="2">主用智能集中器B进程检查</th>
				<th colspan="2">备用智能集中器A进程检查</th>
				<th colspan="2">备用智能集中器B进程检查</th>
				  <th  rowspan="2">创建情况</th>
			    <th  rowspan="2">审核情况</th>
			    <th  rowspan="2">操作</th>
			</tr>
			<tr>
				<th>巡检时间</th>
				<th>库操作进程</th>
				<th>双机进程</th>
				<th>IP进程</th>
				<th>R25进程</th>
				<th>异步进程</th>
				<th>帧中继进程</th>
				<th>matip进程</th>
				<th>数据库进程</th>
				<th>库操作进程</th>
				<th>双机进程</th>
				<th>数据库进程</th>
				<th>IP连接进程</th>
				<th>串口通信进程</th>
				<th>IP连接进程</th>
				<th>串口通信进程</th>
				<th>IP连接进程</th>
				<th>串口通信进程</th>
				<th>IP连接进程</th>
				<th>串口通信进程</th>
			  
			</tr>
			
		</thead>
		<tbody>
		<c:if test="${pagn.totalCount==0}">
				<td colspan="20">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>
