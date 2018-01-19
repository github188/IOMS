<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<script type="text/javascript">
	$(function() {
		$("#classifyBtn").hide();
		$("#dataTable").tablesorter();
		for (var i = 0; i < callActiveSelectIds.length; i++) {
			$("#activeCheck_" + callActiveSelectIds[i]).attr("checked",
					"checked");
		}
	});
</script>
<table width="100%">
	<tr>
		<td align="left"><a href="#" class="sbtn" id="selectBtn" onclick="allSel()">全选/反选</a>
			<a  id="classifyBtn" href="${rootUrl }phonemng/querymng/classify.do?ids=" 
			class="my_add {boxwidth:750,boxheight:340} btn" >归类</a></td>
	</tr>
</table>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
			<th>选择</th>
			<th>类别</th>
			<th>主叫电话</th>
			<th>被叫电话</th>
			<th>打入时间</th>
			<th>摘机时间</th>
			<th>通话结束时间</th>
			<th>通话时长</th>
			<th>主叫地区</th>
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

