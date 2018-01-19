<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
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
		 <c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
		 		<%@ include file="detailRow.jsp"%>	
		 </c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount}"></div>

