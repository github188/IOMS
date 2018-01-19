<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter" style="table-layout: inherit;">
	<!-- 板卡 -->
	<c:if test="${message=='CARD' }">
		<thead>
			<tr>
		  	  <th>Slot</th>
			  <th>F/B CardState</th>
			  <th>AlarmStatus</th>
			  <th>CardRunTime</th>
			  <th>FrontType</th>
			  <th>FrontSerial</th>
			  <th>BackUpperType</th>
			  <th>BackUpperSerial</th>
			  <th>BackLowerType</th>
			  <th>BackLowerSerial</th>
			  <th>BackType</th>
			  <th>BackSerial</th>
			</tr>
		</thead>
			<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="12">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="cardRow.jsp"%>
			</c:forEach>
		</tbody>
	</c:if>
	<!-- 业务 -->
	<c:if test="${message=='BUSINESS' }">
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
			<c:if test="${pagn.totalCount==0}">
				<td colspan="16">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="serviceRow.jsp"%>
			</c:forEach>
		</tbody>
	</c:if>
	<!-- 中继 -->
	<c:if test="${message=='BANDWIDTH' }">
		<thead>
		<tr>
			<th data-options="5%">本端节点</th>
			<th data-options="10%">本地PN端口</th>
			<th data-options="20%">对端节点</th>
			<th data-options="20%">最大带宽(Mbps)</th>
			<th data-options="20%">可用带宽(Kbps)</th>
			<th>带宽利用率</th>
		</tr>
		</thead>
			<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="6">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="bandRow.jsp"%>
			</c:forEach>
		</tbody>
	</c:if>
	<!-- 运行 -->
	<c:if test="${message=='PORT' }">
		<thead>
		<tr>
			<th>序号</th>
			<th>节点代码</th>
			<th>槽 位号</th>
			<th>端口号</th>
			<th>状态</th>
        </tr>
		</thead>
			<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="5">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="pnniRow.jsp"%>
			</c:forEach>
		</tbody>
	</c:if>
</table>
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
