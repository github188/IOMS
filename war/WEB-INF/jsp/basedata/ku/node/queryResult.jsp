<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr><th width="5%">序号</th>
			<th width="10%">区域</th>
			<th width="5%">子网类型</th>
			<th width="5%">节点号</th>
			<th width="5%">节点ID</th>
			<th width="5%">是否空管局</th>
			
			<th width="5%">站点名称</th>
			<th width="5%">站点代码</th>

			<th width="5%">机箱类型</th>
			<th width="5%">有无频谱仪</th>
			
			<th width="5%">板卡总数</th>
			<th width="5%">板卡配置</th>
			
			<th width="10%">上线状态</th>
			<th width="10%">未上线原因</th>
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
