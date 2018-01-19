<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#dataTable").tablesorter();
	});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: fixed;margin-left:0px;">
	<thead>
		<tr>
			
			<th style="width:5%">序号</th>
			<th style="width:5%">操作</th>
			<th style="width:15%">区域</th>
			<th style="width:15%;">型号</th>
			<th style="width:15%">设备号</th>
			<th style="width:15%">站点名称</th>
			<th style="width:15%">网络类型</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${equipList}" var="vo" varStatus="voStatus">
			<tr>
				<td>${voStatus.count}</td>
				
				<td><input type="checkbox" name="equip"  onclick="changeEquip(this)" /><input type="hidden" name="equipIDSelect" id="${vo.id}" value="${vo.id }" />  </td>
				<td>${vo.bureau.value}</td>
				<td>${vo.model}</td>
				<td>${vo.name}</td>
				<td>${vo.satellite.siteName}</td>
				<td>${vo.type.name}</td>
			
			</tr>
		</c:forEach>
	</tbody>
</table>

