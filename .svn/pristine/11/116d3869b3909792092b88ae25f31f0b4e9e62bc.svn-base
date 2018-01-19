<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table id="dataTable" width="98%" border="0" cellspacing="0" cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th rowspan="2">序号</th>
			<th rowspan="2">告警类型</th>
			<th colspan="3">告警等级</th>
		</tr>
		<tr>
			<th width="18%">Critical</th>
			<th width="18%">Major</th>
			<th width="18%">Minor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="detailRow.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"	pagecount="${pagn.pageCount }"></div>

