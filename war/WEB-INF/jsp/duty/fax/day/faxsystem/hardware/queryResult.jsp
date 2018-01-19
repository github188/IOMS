<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div style="width:100%; overflow: scroll;">
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
<table id="dataTable"  class="table table-bordered">
	<thead>
		<tr>
			
			<th rowspan="3">巡检时间</th>
			<th colspan="4">转报主机状态</th>
			<th colspan="4">同步接入器状态</th>
			<th colspan="8">智能集中器状态</th>
			<th colspan="6" rowspan="2">异步接入器状态</th>
			<th  rowspan="3">创建情况</th>
			<th  rowspan="3">审核情况</th>
			<th  rowspan="3">操作</th>
		</tr>
		<tr>
			<th colspan="2">A(192.168.11.1)</th>
			<th colspan="2">B(192.168.11.2)</th>
			<th colspan="2">A(192.168.11.8)</th>
			<th colspan="2">B(192.168.11.9)</th>
			<th colspan="2">A(192.168.11.11)</th>
			<th colspan="2">B(192.168.11.12)</th>
			<th colspan="2">A(192.168.11.13)</th>
			<th colspan="2">B(192.168.11.14)</th>
		</tr>
		<tr>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>冗余状态</th>
			<th>工作状态</th>
			<th>接入器1</th>
			<th>接入器2</th>
			<th>接入器3</th>
			<th>接入器4</th>
			<th>接入器5</th>
			<th>接入器6</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${pagn.totalCount==0}">
				<td colspan="26">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>
