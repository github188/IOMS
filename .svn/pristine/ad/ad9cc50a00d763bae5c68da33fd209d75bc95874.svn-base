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
				<th colspan="20">内容检查</th>
				<th colspan="80">电池测量</th>
				<th rowspan="3">存在问题</th>
				<th rowspan="3">建议</th>
				<th rowspan="3">结果</th>
				<th rowspan="3">操作人</th>
				<th rowspan="3">操作</th>
			</tr>
			<tr>
				<th colspan="3">环境</th>
				<th colspan="4">外观</th>
				<th colspan="7">输入系统</th>
				<th colspan="5">输出系统</th>
				<th rowspan="2">设备除尘</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
				<th rowspan="2">电池序号</th>
				<th rowspan="2">端电压</th>
				<th rowspan="2">内阻</th>
				<th rowspan="2">备注</th>	
			</tr>
			<tr>
				<th>环境温度是否可调</th>
				<th>环境温度</th>
				<th>环境湿度</th>
				<th>设备外观是否完好</th>
				<th>UPS及电池柜的散热是否正常</th>
				<th>电池无漏夜现象</th>
				<th>连接端子无腐蚀氧化</th>
				<th>输入电压L-N</th>
				<th>输入电压L-地</th>
				<th>输入电压N-地</th>
				<th>输入电流</th>
				<th>负载量</th>
				<th>空开温度</th>
				<th>线缆温度</th>
				<th>输出电压L-N</th>
				<th>输出电压L-地</th>
				<th>输出电压N-地</th>
				<th>输出电流</th>
				<th>空开温度</th>
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

