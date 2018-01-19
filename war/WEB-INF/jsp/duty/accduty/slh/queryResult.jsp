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
<!-- 			<th rowspan="3">巡检时间</th>
				<th rowspan="3">设备名称</th> -->
                <c:if test="${checkType eq 'MONTH' }">
                    <th rowspan="3">巡检时间</th>
                    <th rowspan="3">设备名称</th>
                    <th colspan="24">维护内容</th>
                    <th colspan="27">数据记录</th>
                    <th rowspan="3">操作人</th>
                    <th rowspan="3">操作</th>
                </c:if>
                <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR'}">
                    <th rowspan="4">巡检时间</th>
                    <th rowspan="4">设备名称</th>
                    <th colspan="32">维护内容</th>
                    <th colspan="33" rowspan="2">数据记录</th>
                    <th rowspan="4">操作人</th>
                    <th rowspan="4">操作</th>
                </c:if>
<!-- 			<th rowspan="3">操作人</th>
				<th rowspan="3">操作</th> -->
			</tr>
            <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR'}">
                <tr>
                    <th colspan="10">制冷系统</th>
                    <th colspan="4">室外冷凝设备</th>
                    <th colspan="4">除湿系统</th>
                    <th colspan="6">加湿系统</th>
                    <th colspan="8">电气系统</th>
                </tr>
            </c:if>
			<tr>
                <c:if test="${checkType eq 'MONTH' }">
                    <th colspan="2">主风机转动</th>
                    <th colspan="2">过滤网</th>
                    <th colspan="2">凝结水盘和凝结水管</th>
                    <th colspan="2">蒸发器翅片</th>
                    <th colspan="2">设备内部、外部表面</th>
                    <th colspan="2">设备周围环境</th>
                    <th colspan="2">水盘</th>
                    <th colspan="2">上下排水管线路、水滤网</th>
                    <th colspan="2">加湿器水位和水漂</th>
                    <th colspan="2">空调出风口风速</th>
                    <th colspan="2">空调出风口温度</th>
                    <th colspan="2">空调总接线电压、电流、空调内部压缩机<br/>主风机、室外机电流</th>
                </c:if>
                <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
                    <th colspan="2">视镜</th>
                    <th colspan="2">吸排气压力</th>
                    <th colspan="2">制冷管</th>
                    <th colspan="2">压缩机工作电流</th>
                    <th colspan="2">室外空调机组内制冷剂压力</th>
                    <th colspan="2">电机轴承及风扇</th>
                    <th colspan="2">冷凝器散热翅片</th>
                    <th colspan="2">水盘</th>
                    <th colspan="2">储水盒、排水管</th>
                    <th colspan="2">水盘和水漂</th>
                    <th colspan="2">空调加湿情况</th>
                    <th colspan="2">加湿器工作电流</th>
                    <th colspan="2">供电电气线路</th>
                    <th colspan="2">接线</th>
                    <th colspan="2">电气控制部分</th>
                    <th colspan="2">所有继电器触点、电气元件</th>
                </c:if>
                    <th colspan="3">总电压</th>
                    <th colspan="3">总电流</th>
                    <th colspan="3">1号压缩机电流</th>
                    <th colspan="3">2号压缩机电流</th>
                    <th colspan="3">主风机电流</th>
                    <th colspan="3">室外机电流</th>
                <c:if test="${checkType eq 'MONTH' }">
                    <th colspan="3">加湿器电流</th>
                </c:if>
                    <th colspan="3">出风口温湿度</th>
                    <th colspan="3">出风口风速</th>
                <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
                    <th colspan="3">加湿器电流A</th>
                    <th colspan="3">加湿器电流B</th>
                    <th colspan="3">加湿器电流c</th>
                </c:if>
			</tr>
			<tr>
				<th>运行状态</th>
				<th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <th>运行状态</th>
                <th>备注</th>
                <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
                    <th>运行状态</th>
                    <th>备注</th>
                    <th>运行状态</th>
                    <th>备注</th>
                    <th>运行状态</th>
                    <th>备注</th>
                    <th>运行状态</th>
                    <th>备注</th>
                </c:if>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <th>数值</th>
                <th>状态</th>
                <th>备注</th>
                <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
                    <th>数值</th>
                    <th>状态</th>
                    <th>备注</th>
                    <th>数值</th>
                    <th>状态</th>
                    <th>备注</th>
                </c:if>
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

