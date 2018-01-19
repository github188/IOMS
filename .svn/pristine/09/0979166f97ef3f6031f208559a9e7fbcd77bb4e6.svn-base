<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!--  <script type="text/javascript">
	 $(function() {
		$("#dataTable").tablesorter();
	}); class="tablesorter"
	
		
</script>    -->
<table id="dataTable" width="800px" border="0" cellspacing="0"
	cellpadding="2">
	<thead>
		<tr>
			<th width="5%">序号</th>
			<th>业务名称</th>
			<th>本端节点代码</th>
			<th>本端端口号</th>
			<th>本端dlci/ vpi.vci</th>
			<th>对端节点代码</th>
			<th>对端端口号</th>
			<th>对端dlci/ vpi.vci</th>
			<th>速率（kbps）</th>
			<th>服务等级</th>
			<th>采集状态</th>
			<th>业务状态</th>
			<th>记录时间</th>
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
