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
				<th width="13%" rowspan="3" scope="col">巡检时间</th>
				<th width="11%" rowspan="3" scope="col">巡检内容</th>
				<th colspan="4" scope="col">1007机箱</th>
				<th colspan="4" scope="col">1008机箱</th>
				<th colspan="4" scope="col">1009机箱</th>
				<th colspan="4" scope="col">100A机箱</th>
				<th colspan="4" scope="col">100F机箱</th>
				<th colspan="4" scope="col">1011机箱</th>
				<th width="2%" rowspan="3" scope="col">操作人</th>
				<th width="2%" rowspan="3" scope="col">操作</th>
			</tr>
			<tr>
				<th width="5%" scope="col">1</th>
				<th width="5%" scope="col">2</th>
				<th width="2%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
				<th width="2%" scope="col">1</th>
				<th width="3%" scope="col">2</th>
				<th width="3%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
				<th width="3%" scope="col">1</th>
				<th width="3%" scope="col">2</th>
				<th width="2%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
				<th width="2%" scope="col">1</th>
				<th width="1%" scope="col">2</th>
				<th width="1%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
				<th width="3%" scope="col">1</th>
				<th width="3%" scope="col">2</th>
				<th width="2%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
				<th width="2%" scope="col">1</th>
				<th width="3%" scope="col">2</th>
				<th width="3%" scope="col">3</th>
				<th width="4%" scope="col">4</th>
			</tr>

			<tr>
				<th scope="col">&nbsp;</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">俄罗斯</th>
				<th scope="col">沈阳 PYB</th>
				<th scope="col">广州PQB</th>
				<th scope="col">上海PSA</th>
				<th scope="col">乌鲁木齐PUA</th>
				<th scope="col">首都机场PBK</th>
				<th scope="col">首尔</th>
				<th scope="col">平壤PGA</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">&nbsp;</th>
				<th scope="col">成都PIA</th>
				<th scope="col">168A</th>
				<th scope="col">168B</th>
				<th scope="col">169</th>
				<th scope="col">外蒙833</th>
				<th scope="col">乌兰巴托</th>
				<th scope="col">昆明PKB</th>
				<th scope="col">西安PXB</th>
				<th scope="col">&nbsp;</th>
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

