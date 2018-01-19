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
				<th colspan="15">内容检查</th>
				<th colspan="45">市供电参数</th>
				<th colspan="8">零地电压和零线电流测量</th>
				<th colspan="28">系统连接检查</th>
				<th rowspan="4">存在问题</th>
				<th rowspan="4">建议</th>
				<th rowspan="4">结果</th>
				<th rowspan="4">操作人</th>
				<th rowspan="4">操作</th>
			</tr>
			<tr>
				<th colspan="3">环境</th>
				<th colspan="10">外观</th>
				<th colspan="2">告警</th>
				<th colspan="12">相电压</th>
				<th colspan="12">线电压</th>
				<th colspan="12">电流</th>
				<th colspan="9">功率</th>
				<th colspan="2">输入端零地电压</th>
				<th colspan="2">输出端零地电压</th>
				<th colspan="4">零线电流</th>
				<th colspan="2">UPS内部连接端子是否牢固</th>
				<th colspan="2">UPS风扇运转是否正常	</th>
				<th colspan="2">UPS内部板卡是否牢固</th>
				<th colspan="2">UPS连接导线是否无过热现象</th>
				<th colspan="2">UPS运行声音是否正常</th>
				<th colspan="2">电池连接端子是否牢固</th>
				<th colspan="2">UPS至配电柜的输入和输出导线是否完好</th>
				<th colspan="2">电池组直流母线是否完好</th>
				<th colspan="2">配电柜内连接端子是否牢固</th>
				<th colspan="2">配电柜仪表及指示灯是否正常</th>
				<th colspan="2">各断路器是否无发热及杂声现象</th>
				<th colspan="2">到负载端的连接导线是否无发热</th>
				<th colspan="2">到负载端的各回路电流是否在安全运行范围之内</th>
				<th colspan="2">到负载端的各插座是否运行正常</th>
			</tr>
			<tr>
				<th rowspan="2">环境温度是否可调</th>
				<th rowspan="2">环境温度</th>
				<th rowspan="2">环境湿度</th>
				<th rowspan="2">设备外观是否完好</th>
				<th rowspan="2">UPS及电池柜的散热是否正常</th>
				<th rowspan="2">设备外壳对地是否有电压</th>
				<th rowspan="2">UPS运行声音是否正常</th>
				<th rowspan="2">UPS界面显示是否正常</th>
				<th rowspan="2">房间内空气是否流通</th>
				<th rowspan="2">电池无漏夜现象</th>
				<th rowspan="2">UPS出风口是否干净</th>
				<th rowspan="2">电池表面是否干净</th>
				<th rowspan="2">连接端子无腐蚀氧化</th>
				<th rowspan="2">UPS是否有当前故障告警</th>
				<th rowspan="2">UPS是否有重要历史告警</th>
				<th colspan="4">A-N</th>
				<th colspan="4">B-N</th>
				<th colspan="4">C-N</th>
				<th colspan="4">A-B</th>
				<th colspan="4">A-C</th>
				<th colspan="4">B-C</th>
				<th colspan="4">A相</th>
				<th colspan="4">B相</th>
				<th colspan="4">C相</th>
				<th colspan="3">A相</th>
				<th colspan="3">B相</th>
				<th colspan="3">C相</th>
				<th rowspan="2">实际测量值</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">实际测量值</th>
				<th rowspan="2">测试结果</th>
				<th colspan="2">输入端</th>
				<th colspan="2">输出端</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
				<th rowspan="2">测试结果</th>
				<th rowspan="2">备注</th>
			</tr>
			<tr>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>实际测量输入</th>
				<th>实际测量输出</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>计算值</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>计算值</th>
				<th>备注</th>
				<th>界面显示输出</th>
				<th>计算值</th>
				<th>备注</th>
				<th>实际测量值</th>
				<th>测试结果</th>
				<th>实际测量值</th>
				<th>测试结果</th>
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

