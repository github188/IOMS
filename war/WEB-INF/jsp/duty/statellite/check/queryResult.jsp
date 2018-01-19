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
				<th rowspan="2">巡检时间</th>
				<th rowspan="2">巡检内容</th>
				<th rowspan="2">实际数量合计</th>
				<th colspan="3">频谱仪<br />Agilent E4440A
				</th>
				<th colspan="3">频谱仪<br />HP8593E
				</th>
				<th colspan="3">频谱仪<br />HP8563E
				</th>
				<th colspan="3">便携频谱仪<br />Anritsu MS2724B
				</th>
				<th colspan="3">信号源<br />Agilent 4437B
				</th>
				<th colspan="3">信号源<br />Agilent 8251A
				</th>
				<th colspan="3">网络分析仪<br /> Agilent 8720ES
				</th>
				<th colspan="3">噪声分析仪<br />Agilent N8975A
				</th>
				<th colspan="3">矢量分析仪<br /> Agilent 89441A
				</th>
				<th colspan="3">功率计<br /> Agilent E4416A
				</th>
				<th colspan="3">交换/控制器 <br />Agilent 3499A
				</th>
				<th colspan="3">衰减/切换器 <br />11713B
				</th>
				<th colspan="3">LAN/GPIB <br />Gateway Agilent E5810A
				</th>
				<th colspan="3">频率计<br />Anritsu MF2412C
				</th>
				<th colspan="3">模拟转发器 <br />TAMPA Microwave
				</th>
				<th colspan="3">宽带接收机<br /> HP70004
				</th>
				<th colspan="3">协议分析仪<br />CTC HCT7000
				</th>
				<th colspan="3">协议分析仪<br />CTC HCT6000
				</th>
				<th colspan="3">协议分析仪<br />ACTERNA E1&Data Tester
				</th>
				<th colspan="3">TA-VB02型<br />2M误码测试仪
				</th>
				<th colspan="3">示波器<br />Tektronix DPO7104
				</th>
				<th colspan="3">实时频谱仪<br /> Tektronix RSA6106A
				</th>
				<th colspan="3">频谱仪<br />Agilent 4407B
				</th>
				<th colspan="3">Ku网管软件<br />StreamView软件
				</th>
				<th colspan="3">Ku网管<br />Soloris操作系统光盘
				</th>
				<th colspan="3">TES系统网管<br />操作系统软件OpenVMS
				</th>
				<th rowspan="2">操作人</th>
				<th rowspan="2">操作</th>
			</tr>
			<tr>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
				<th>备注</th>
				<th>实际数量</th>
				<th>所在位置</th>
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
	<div class="pager" totalcount="${pagn.totalCount }"
		pagecount="${pagn.pageCount}"></div>
</div>

