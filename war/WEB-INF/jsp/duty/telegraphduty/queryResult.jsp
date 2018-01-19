<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<script type="text/javascript">
	$(function() {
		
	});
	var rootUrl = '${rootUrl }';
</script>
<div style="width:100%; overflow: scroll;">
	<table id="dataTable"  border="0" cellspacing="0"
		cellpadding="2" class="tablesorter">
		<thead>
			<tr>
				<th width="7%" rowspan="3">时间</th>
				<th width="16%" colspan="4">转报主机状态</th>
				<th width="16%" colspan="5">同步器接入状态</th>
				<th width="20%" colspan="8">智能集中器状态</th>
				<th width="20%" colspan="8">异步接入器状态</th>
				<th width="7%" rowspan="3">创建情况</th>
				<th width="7%" rowspan="3">审核情况</th>
				<th width="7%" rowspan="3">操作</th>
			</tr>
			<tr>
				<th width="8%" colspan="2">A(192.168.11.1)</th>
				<th width="8%" colspan="2">B(192.168.11.2)</th>
				<th width="5%" colspan="2">A(192.168.11.8)</th>
				<th width="5%" colspan="2">B(192.168.11.9)</th>
				<th width="6%" rowspan="2">同步进程（17个）</th>
				<th width="5%" colspan="2">A(192.168.11.11)</th>
				<th width="5%" colspan="2">B(192.168.11.12)</th>
				<th width="5%" colspan="2">A(192.168.11.13)</th>
				<th width="5%" colspan="2">B(192.168.11.14)</th>
				<th width="2%" rowspan="2">接入器1</th>
				<th width="2%" rowspan="2">接入器2</th>
				<th width="2%" rowspan="2">接入器3</th>
				<th width="2%" rowspan="2">接入器4</th>
				<th width="2%" rowspan="2">接入器5</th>
				<th width="2%" rowspan="2">接入器6</th>
				<th width="4%" rowspan="2">串口通信进程（2个）</th>
				<th width="4%" rowspan="2">IP联接进程（1个）</th>
			</tr>
			<tr>
				<th width="4%">冗余状态</th>
				<th width="4%">工作状态</th>
				<th width="4%">冗余状态</th>
				<th width="4%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
				<th width="2.5%">冗余状态</th>
				<th width="2.5%">工作状态</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="29">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>


