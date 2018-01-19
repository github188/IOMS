<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
			<th width="10%">设备名称</th>
			<th width="10%">站点名称</th>
			<th width="7%">站点区域</th>
			<th width="20%">告警信息</th>
			<th width="13%">创建时间</th>
			<th width="20%">当前状态信息</th>
			<th width="13%">更新时间</th>
			<th width="7%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="rowAlarm.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>
