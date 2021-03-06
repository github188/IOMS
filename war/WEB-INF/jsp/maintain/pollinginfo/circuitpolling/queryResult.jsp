<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" style="table-layout: fixed; word-warp: break-word; word-break: break-all; overflow: auto;">
	<thead>
		<tr>
			<th style="width:30px">序号</th>
			<th style="width:60px">所属地区</th>
			<th style="width:60px">业务名称</th>
			<th style="width:60px">电路名</th>
			<th style="width:60px">物理线路</th>
			<th style="width:60px">业务通断</th>
			<th style="width:80px">瞬时误码率</th>
			<th style="width:80px">累计误码率</th>
			<th style="width:80px">电路类型</th>
			<th style="width:150px">电路速率</th>
			<th style="width:140px">配置时间</th>
			<th style="width:70px">发端节点名</th>
			<th style="width:100px">发端站点</th>
			<th style="width:70px">发端节点号</th>
			<th style="width:70px">发端槽位号</th>
			<th style="width:70px">发端端口号</th>
			<th style="width:70px">收端节点名</th>
			<th style="width:100px">收端站点</th>
			<th style="width:70px">收端节点号</th>
			<th style="width:70px">收端槽位号</th>
			<th style="width:70px">收端端口号</th>
			<th style="width:150px">收端信息</th>
			<th style="width:140px">采集时间</th>
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