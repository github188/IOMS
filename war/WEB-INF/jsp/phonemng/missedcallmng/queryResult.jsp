<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
		    <th>选择</th>
			<th>状态</th>
			<th>联系人姓名</th>
			<th>联系人公司</th>
			<th>联系人所属地区</th>
			<th>打入时间</th>
			<th>未接电话</th>
			<th>所属区域</th>
			<th>值班工程师</th>
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
	