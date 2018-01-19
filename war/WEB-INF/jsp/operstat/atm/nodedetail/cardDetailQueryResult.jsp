<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%"border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
		<thead>
			<tr>
				<th>槽位号</th>
				<th>CardFrontType</th>
				<th>CardFrontSerial</th>
				<th>CardBackUpperType</th>
				<th>CardBackUpperSerial</th>
				<th>CardBackLowerType</th>
				<th>CardBackLowerSerial</th>
				<th>CardBackType</th>
				<th>CardBackSerial</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="9">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="cardDetailRow.jsp"%>
			</c:forEach>
		</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
