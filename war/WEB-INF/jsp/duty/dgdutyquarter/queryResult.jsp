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
				<th rowspan="4">巡检时间</th>
				<th rowspan="4">设备名称</th>
				<th colspan="74">内容检查</th>
				<th rowspan="4">操作人</th>
				<th rowspan="4">操作</th>
			</tr>
			<tr>
				<th colspan="2">环境</th>
				<th colspan="2">机体加热</th>
				<th colspan="2">发动机控制板示灯</th>
				<th colspan="2">机房温湿度</th>
				<th colspan="2">发动机运转检查</th>
				<th colspan="2">1号ATS</th>
				<th colspan="2">2号ATS</th>
				<th colspan="2">各单位切换护头</th>
				<th colspan="2">电缆检测</th>
				<th colspan="2">润滑压力</th>
				<th colspan="2">燃油压力</th>
				<th colspan="2">机油系统</th>
				<th colspan="2">冷却系统</th>
				<th colspan="2">燃料系统</th>
				<th colspan="2">蓄电池液</th>
				<th colspan="2">各个皮带</th>
				<th colspan="2">空气系统</th>
				<th colspan="2">散热器百叶窗</th>
				<th colspan="2">自动开关</th>
				<th colspan="2">启动电池电压(V)</th>
				<th colspan="2">柴油压力(bar)</th>
				<th colspan="2">机油压力(bar)</th>
				<th colspan="2">功率因数</th>
				<th colspan="2">发动机转速 (r/min)</th>
				<th colspan="2">发动机水温   (℃)</th>
				<th colspan="6">相电压(V)</th>
				<th colspan="6">线电压(V)</th>
				<th colspan="6">电流(A)</th>
				<th colspan="6">功率(KW)</th>
			</tr>
			<tr>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th rowspan="2">巡检结果</th>
				<th rowspan="2">检查状况</th>
				<th colspan="2">A-N</th>
				<th colspan="2">B-N</th>
				<th colspan="2">C-N</th>
				<th colspan="2">A-B</th>
				<th colspan="2">A-C</th>
				<th colspan="2">B-C</th>
				<th colspan="2">A相</th>
				<th colspan="2">B相</th>
				<th colspan="2">C相</th>
				<th colspan="2">A相</th>
				<th colspan="2">B相</th>
				<th colspan="2">C相</th>
			</tr>
			<tr>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
				<th>巡检结果</th>
				<th>检查状况</th>
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

