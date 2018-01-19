<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
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
-->
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
				<th rowspan="3">巡检时间</th>
				<th rowspan="3">巡检内容</th>
				<th colspan="6">ODU温度</th>
				<th colspan="8">ODU参数</th>
				<th rowspan="2" colspan="2">ODU状态</th>
				<th colspan="10">KU网管工作站状态</th>

				<th colspan="8">子网1的0号节点</th>
				<th colspan="10">子网1时钟参考节点</th>

				<th colspan="6">子网2的0号节点</th>
				<th colspan="10">子网2时钟参考节点</th>

				<th colspan="6">子网3的0号节点</th>
				<th colspan="10">子网3时钟参考节点</th>

				<th colspan="6">子网4的0号节点</th>
				<th colspan="10">子网4时钟参考节点</th>

				<th rowspan="2" colspan="2">FR小网0号载波频谱</th>
				<th colspan="10">FR小网时钟参考节点</th>
				<th rowspan="3">操作人</th>
				<th rowspan="3">操作</th>
			</tr>
			<tr>
				<th colspan="3">ODU_A</th>
				<th colspan="3">ODU_B</th>
				<th colspan="4">ODU_A</th>
				<th colspan="4">ODU_B</th>

				<th colspan="2">子网1</th>
				<th colspan="2">子网2</th>
				<th colspan="2">子网3</th>
				<th colspan="2">子网4</th>
				<th colspan="2">FR小网</th>

				<th colspan="2">收0号节点(dB)</th>
				<th colspan="2">收1号节点(dB)</th>
				<th colspan="2">收民航局130号节点(dB)</th>
				<th colspan="2">载波频谱(dBm)</th>
				<th colspan="5">主时钟</th>
				<th colspan="5">备时钟</th>

				<th colspan="2">收0号节点(dB)</th>
				<th colspan="2">收1号节点(dB)</th>
				<th colspan="2">载波频谱(dBm)</th>
				<th colspan="5">主时钟</th>
				<th colspan="5">备时钟</th>

				<th colspan="2">收0号节点(dB)</th>
				<th colspan="2">收1号节点(dB)</th>
				<th colspan="2">载波频谱(dBm)</th>
				<th colspan="5">主时钟</th>
				<th colspan="5">备时钟</th>

				<th colspan="2">收0号节点(dB)</th>
				<th colspan="2">收1号节点(dB)</th>
				<th colspan="2">载波频谱(dBm)</th>
				<th colspan="5">主时钟</th>
				<th colspan="5">备时钟</th>

				<th colspan="5">主时钟</th>
				<th colspan="5">备时钟</th>

			</tr>
			<tr>
				<th>UCT</th>
				<th>DCT</th>
				<th>MCT</th>
				<th>UCT</th>
				<th>DCT</th>
				<th>MCT</th>
				<th>UCF(MHz)</th>
				<th>UCA(dB)</th>
				<th>DCF(MHz)</th>
				<th>DCA(dB)</th>
				<th>UCF(MHz)</th>
				<th>UCA(dB)</th>
				<th>DCF(MHz)</th>
				<th>DCA(dB)</th>
				<th>ODU_A</th>
				<th>ODU_B</th>
				<th>工作站状态</th>
				<th>在线MAP图</th>
				<th>工作站状态</th>
				<th>在线MAP图</th>
				<th>工作站状态</th>
				<th>在线MAP图</th>
				<th>工作站状态</th>
				<th>在线MAP图</th>

				<th>工作站状态</th>
				<th>在线MAP图</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>峰值</th>
				<th>底噪</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>峰值</th>
				<th>底噪</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL(dB)</th>
				<th>Eb/No(dB)</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>峰值</th>
				<th>底噪</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL(dB)</th>
				<th>Eb/No(dB)</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>峰值</th>
				<th>底噪</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL(dB)</th>
				<th>Eb/No(dB)</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL</th>
				<th>Eb/No</th>
				<th>峰值</th>
				<th>底噪</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL(dB)</th>
				<th>Eb/No(dB)</th>
				<th>节点号</th>
				<th>天气</th>
				<th>状态</th>
				<th>RX LvL(dB)</th>
				<th>Eb/No(dB)</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="108">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }"
		pagecount="${pagn.pageCount}"></div>
</div>

