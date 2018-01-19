<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th width="15%">名称</th>
			<th width="15%">节点号</th>
			<th width="20%">配置用户</th>
			<th width="20%">发短信用户</th>
			<th width="15%">区域</th>
			<th width="15%">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${equips}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<%-- <div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div> --%>
