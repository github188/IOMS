<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	table th {
		white-space: nowrap;
	}
	table td{
		white-space: nowrap;
	}
	table{
		empty-cells: show;
		border-collapse: collapse;
		table-layout: auto;
	}
-->
</style>
<script type="text/javascript">
	/* $(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	}); */
	var rootUrl = '${rootUrl }';
</script> 
<div style="width:100%; overflow: scroll;">
	<table id="dataTable"  border="0" cellspacing="0"
		cellpadding="2" class="tablesorter">
		<thead>
			<tr>
				<th rowspan="3">巡检时间</th>
				<th rowspan="3">设备名称</th>
                <th colspan="10">巡检内容</th>
				<th rowspan="3">操作人</th>
				<th rowspan="3">操作</th>
			</tr>
             <tr>
                <th colspan="2">二楼电话线路、数据线路配线线架</th>
                <th colspan="2">三楼电话线路、数据线路配线线架</th>
                <th colspan="2">四楼电话线路、数据线路配线线架</th>
                <th colspan="2">五楼电话线路、数据线路配线线架</th>
                <th colspan="2">六楼电话线路、数据线路配线线架</th>
            </tr> 
            <tr>
                <th>结果记录</th>
                <th>备注</th>
                <th>结果记录</th>
                <th>备注</th>
                <th>结果记录</th>
                <th>备注</th>
                <th>结果记录</th>
                <th>备注</th>
                <th>结果记录</th>
                <th>备注</th>
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
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>

