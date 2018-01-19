<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
table th {
	white-space: nowrap;
}

table td {
	white-space: nowrap;
}

table {
	empty-cells: show;
	border-collapse: collapse;
	table-layout: auto;
}
</style>
<script type="text/javascript">
	/* $(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	}); */
	var rootUrl = '${rootUrl }';
</script>
<div style="width: 100%; overflow: scroll;">
	<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
		class="tablesorter">
		<thead>
			<tr>
				<th width="19" rowspan="2" scope="col">巡检时间</th>
				<th width="35" rowspan="2" scope="col">巡检内容</th>
				<th width="110" colspan="3" scope="col">北京网控中心TES</th>
				<th width="88" colspan="3" scope="col">北京网控中心PES</th>
				<th width="35" colspan="3" scope="col">北京网控中心Ku子网1网管</th>
				<th width="114" colspan="3" scope="col">北京网控中心Ku子网2网管</th>
				<th width="62" colspan="3" scope="col">北京网控中心Ku子网3网管</th>
				<th width="80" colspan="3" scope="col">北京网控中心帧中继网Ku站</th>
				<th width="45" colspan="3" scope="col">北京网控中心境外站</th>
				<th width="47" colspan="3" scope="col">十里河ku站</th>
				<th width="75" colspan="3" scope="col"><p>民航局</p>
					<p>TES站</p></th>
				<th width="119" colspan="3" scope="col">民航局ku站</th>
				<th width="245" colspan="3" scope="col">汇总</th>
				<th width="93" rowspan="2" scope="col">操作人</th>
				<th width="56" rowspan="2" scope="col">操作</th>
			</tr>
			<tr>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">业务电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
				<th scope="col">合计电路</th>
				<th scope="col">故障电路</th>
				<th scope="col">备注</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="29">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }"
		pagecount="${pagn.pageCount}"></div>
</div>

