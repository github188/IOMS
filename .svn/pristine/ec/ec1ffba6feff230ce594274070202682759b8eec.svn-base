<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
			<th width="10%">值班人</th>
			<th width="10%">值班角色</th>
			<th width="10%">值班地点</th>
			
			<th width="20%">记录内容</th>
			<th width="10%">创建时间</th>
			<th width="10%">最后操作人</th>
			<th width="15%">最后操作时间</th>
			
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
	