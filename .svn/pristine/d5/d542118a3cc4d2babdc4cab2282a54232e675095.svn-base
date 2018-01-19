<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" >
	<thead>
    <tr>
		
		<th>值班人</th>
		<th>值班角色</th>
		<th>值班地点</th>
		<th>记录内容</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
    </thead>
	<tbody>
		<c:forEach items="${listshift}" var="vo"  >
		  <%@ include file="shift/row.jsp"%>
		</c:forEach>
	</tbody>
</table>
