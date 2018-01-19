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
                <th colspan="40">巡检内容</th>
				<th rowspan="4">操作人</th>
				<th rowspan="4">操作</th>
			</tr>
             <tr>
                <th colspan="6">设备运行环境</th>
                <th rowspan="2" colspan="2">设备指示灯状态</th>
                <th rowspan="2" colspan="2">当前主用</th>
                <th colspan="26">前面板状态</th>
                <th colspan="4">后面板状态</th>
            </tr> 
            <tr>
                <th colspan="2">风扇</th>
                <th colspan="2">温度</th>
                <th colspan="2">湿度</th>
                <th colspan="2">A机主控板卡</th>
                <th colspan="2">A机1号v.35板卡</th>
                <th colspan="2">A机2号v.35板卡</th>
                <th colspan="2">A机3号v.35板卡</th>
                <th colspan="2">A机E1板卡</th>
                <th colspan="2">B机主控板卡</th>
                <th colspan="2">B机1号v.35板卡</th>
                <th colspan="2">B机2号v.35板卡</th>
                <th colspan="2">B机3号v.35板卡</th>
                <th colspan="2">B机1号v.24板卡</th>
                <th colspan="2">B机2号v.24板卡</th>
                <th colspan="2">B机3号v.24板卡</th>
                <th colspan="2">B机E1板卡</th>
                <th colspan="2">V.35接口连接</th>
                <th colspan="2">V.24接口连接</th>
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

