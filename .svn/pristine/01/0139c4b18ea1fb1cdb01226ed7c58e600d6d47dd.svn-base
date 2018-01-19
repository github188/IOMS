<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	});
	var rootUrl = '${rootUrl }';
	
	
</script>
<c:if test="${alarmsCount!='0' }">
<div style="width:100%;" id="alarmDiv">
<div style="width:100%;border-bottom:2px solid #FF8C00;text-align:left">
  <span style="color:#FF8C00;font-size:14px">阈值告警信息</span>
</div>
<div style="width:100%;height:5px;"></div>
<table id="dataTable1" width="100%" border="0" cellspacing="0" cellpadding="2" 
class="table table-bordered">
	<thead>
		<tr>
			<th width="15%">设备名称</th>
			<th width="12%">设备类型</th>
			<th width="12%">站点名称</th>
			<th width="8%">站点区域</th>
			<th width="30%">告警信息</th>
			<th width="15%">创建时间</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		
	
	<c:forEach items="${faultAlarms}" var="voAlarm">
		<%@ include file="rowAlarm.jsp"%>
	</c:forEach>
	
	</tbody>
</table>
</div>
</c:if>
<div style="width:100%;border-bottom:2px solid #5CACEE;text-align:left">
  <span style="color:#5CACEE;font-size:14px">故障单信息</span>
</div>
<div style="width:100%;height:5px;"></div>
<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2" 
class="table table-bordered">
	<thead>
		<tr>
			<th>来源</th>
			<th>事件编号</th>
			<th>申告人</th>
			<th>申告时间</th>
			<th>申告电话</th>
			<th>事件发生地址</th>
			<th>当前处理人</th>
			<th>事件类别</th>
			<th>事件级别</th>
			<th>当前状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		
	
	<c:forEach items="${faultInformations}" var="vo">
		<%@ include file="row.jsp"%>
	</c:forEach>
	
	</tbody>
</table>


