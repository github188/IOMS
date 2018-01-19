<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>柴油发电机巡检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="2">设备名称</th>
					<th colspan="2">${dgCheck.name }</th>
				</tr>
				<tr>
					<th width="30%" colspan="2">内容</th>
					<th width="40%">巡检结果</th>
					<th width="30%">检查状况</th>
				</tr>
				<!-- 环境 -->
				<c:forEach items="${dgCheck.dgCheckContent }" var="dcc">
					<tr>
						<th width="30%" colspan="2">环境</th>
						<td width="40%">${dcc.enCheckResult.value }</td>
						<td width="30%">${dcc.enRemarks }</td>
					</tr>
					<!-- 机体加热 -->
					<tr>
						<th width="30%" colspan="2">机体加热</th>
						<td width="40%">${dcc.bhCheckResult.value }</td>
						<td width="30%">${dcc.bhRemarks }</td>
					</tr>
					<!-- 发动机控制板示灯 -->
					<tr>
						<th width="30%" colspan="2">发动机控制板示灯</th>
						<td width="40%">${dcc.ecpiCheckResult.value }</td>
						<td width="30%">${dcc.ecpiRemarks }</td>
					</tr>
					<!-- 机房温湿度 -->
					<tr>
						<th width="30%" colspan="2">机房温湿度</th>
						<td width="40%">${dcc.rmhCheckResult.value }</td>
						<td width="30%">${dcc.rmhRemarks }</td>
					</tr>
					<!--发动机运转检查  -->
					<tr>
						<th width="30%" colspan="2">发动机运转检查</th>
						<td width="40%">${dcc.ercCheckResult.value }</td>
						<td width="30%">${dcc.ercRemarks }</td>
					</tr>
					<c:if test="${dgCheck.checkType eq 'QUARTER' or dgCheck.checkType eq 'YEAR'}">
						<!-- 1号ATS -->
						<tr>
							<th width="30%" colspan="2">1号ATS</th>
							<td width="40%">${dcc.atsNumoneCheckResult.value }</td>
							<td width="30%">${dcc.atsNumoneRemarks }</td>
						</tr>
						<!-- 2号ATS -->
						<tr>
							<th width="30%" colspan="2">2号ATS</th>
							<td width="40%">${dcc.atsNumtwoCheckResult.value }</td>
							<td width="30%">${dcc.atsNumtwoRemarks }</td>
						</tr>
						<!-- 各单位切换护头 -->
						<tr>
							<th width="30%" colspan="2">各单位切换护头</th>
							<td width="40%">${dcc.ushCheckResult.value }</td>
							<td width="30%">${dcc.ushRemarks }</td>
						</tr>
						<!-- 电缆检测 -->
						<tr>
							<th width="30%" colspan="2">电缆检测</th>
							<td width="40%">${dcc.cableTestResult.value }</td>
							<td width="30%">${dcc.cableTestRemarks }</td>
						</tr>
					</c:if>
					<!--润滑压力  -->
					<tr>
						<th width="30%" colspan="2">润滑压力</th>
						<td width="40%">${dcc.lpCheckResult.value }</td>
						<td width="30%">${dcc.lpRemarks }</td>
					</tr>
					<!--燃油压力  -->
					<tr>
						<th width="30%" colspan="2">燃油压力</th>
						<td width="40%">${dcc.fpCheckResult.value }</td>
						<td width="30%">${dcc.fpRemarks }</td>
					</tr>
					<!-- 机油系统 -->
					<tr>
						<th width="30%" colspan="2">机油系统</th>
						<td width="40%">${dcc.osCheckResult.value }</td>
						<td width="30%">${dcc.osRemarks }</td>
					</tr>
					<!-- 冷却系统 -->
					<tr>
						<th width="30%" colspan="2">冷却系统</th>
						<td width="40%">${dcc.csCheckResult.value }</td>
						<td width="30%">${dcc.csRemarks }</td>
					</tr>
					<!--燃料系统  -->
					<tr>
						<th width="30%" colspan="2">燃料系统</th>
						<td width="40%">${dcc.fsCheckResult.value }</td>
						<td width="30%">${dcc.fsRemarks }</td>
					</tr>
					<!-- 蓄电池液 -->
					<tr>
						<th width="30%" colspan="2">蓄电池液</th>
						<td width="40%">${dcc.blCheckResult.value }</td>
						<td width="30%">${dcc.blRemarks }</td>
					</tr>
					<!-- 各个皮带 -->
					<tr>
						<th width="30%" colspan="2">各个皮带</th>
						<td width="40%">${dcc.ebCheckResult.value }</td>
						<td width="30%">${dcc.ebRemarks }</td>
					</tr>
					<!--空气系统  -->
					<tr>
						<th width="30%" colspan="2">空气系统</th>
						<td width="40%">${dcc.asCheckResult.value }</td>
						<td width="30%">${dcc.asRemarks }</td>
					</tr>
					<!--散热器百叶窗  -->
					<tr>
						<th width="30%" colspan="2">散热器百叶窗</th>
						<td width="40%">${dcc.rsCheckResult.value }</td>
						<td width="30%">${dcc.rsRemarks }</td>
					</tr>
					<!-- 自动开关 -->
					<tr>
						<th width="30%" colspan="2">自动开关</th>
						<td width="40%">${dcc.autosCheckResult.value }</td>
						<td width="30%">${dcc.autosRemarks }</td>
					</tr>
					<!-- 启动电池电压（V） -->
					<tr>
						<th width="30%" colspan="2">启动电池电压(V)</th>
						<td width="40%">${dcc.sbvCheckResult }</td>
						<td width="30%">${dcc.sbvRemarks }</td>
					</tr>
					<!-- 柴油压力(bar) -->
					<tr>
						<th width="30%" colspan="2">柴油压力(bar)</th>
						<td width="40%">${dcc.dopCheckResult }</td>
						<td width="30%">${dcc.dopRemarks }</td>
					</tr>
					<!--机油压力 (bar)  -->
					<tr>
						<th width="30%" colspan="2">机油压力(bar)</th>
						<td width="40%">${dcc.opCheckResult }</td>
						<td width="30%">${dcc.opRemarks }</td>
					</tr>
					<!--功率因数  -->
					<tr>
						<th width="30%" colspan="2">功率因数</th>
						<td width="40%">${dcc.pfCheckResult }</td>
						<td width="30%">${dcc.pfRemarks }</td>
					</tr>
					<!-- 发动机转速 (r/min) -->
					<tr>
						<th width="30%" colspan="2">发动机转速 (r/min)</th>
						<td width="40%">${dcc.epCheckResult }</td>
						<td width="30%">${dcc.epRemarks }</td>
					</tr>
					<!--发动机水温   (℃)  -->
					<tr>
						<th width="30%" colspan="2">发动机水温 (℃)</th>
						<td width="40%">${dcc.ewtCheckResult }</td>
						<td width="30%">${dcc.ewtRemarks }</td>
					</tr>
					<!-- 相电压(V) -->
					<tr>
						<th width="20%" rowspan="3">相电压(V)</th>
						<th width="10%">A-N</th>
						<td width="40%">${dcc.pvANCheckResult }</td>
						<td width="30%">${dcc.pvANRemarks }</td>
					</tr>
					<tr>
						<th width="10%">B-N</th>
						<td width="40%">${dcc.pvBNCheckResult }</td>
						<td width="30%">${dcc.pvBNRemarks }</td>
					</tr>
					<tr>
						<th width="10%">C-N</th>
						<td width="40%">${dcc.pvCNCheckResult }</td>
						<td width="30%">${dcc.pvCNRemarks }</td>
					</tr>
					
					<!-- 线电压(V) -->
					<tr>
						<th width="20%" rowspan="3">线电压(V)</th>
						<th width="10%">A-B</th>
						<td width="40%">${dcc.lvABCheckResult }</td>
						<td width="30%">${dcc.lvABRemarks }</td>
					</tr>
					<tr>
						<th width="10%">A-C</th>
						<td width="40%">${dcc.lvACCheckResult }</td>
						<td width="30%">${dcc.lvACRemarks }</td>
					</tr>
					<tr>
						<th width="10%">B-C</th>
						<td width="40%">${dcc.lvBCCheckResult }</td>
						<td width="30%">${dcc.lvBCRemarks }</td>
					</tr>
					<!-- 电流(A) -->
					<tr>
						<th width="20%" rowspan="3">电流(A)</th>
						<th width="10%">A相</th>
						<td width="40%">${dcc.caCheckResult }</td>
						<td width="30%">${dcc.caRemarks }</td>
					</tr>
					<tr>
						<th width="10%">B相</th>
						<td width="40%">${dcc.cbCheckResult }</td>
						<td width="30%">${dcc.cbRemarks }</td>
					</tr>
					<tr>
						<th width="10%">C相</th>
						<td width="40%">${dcc.ccCheckResult }</td>
						<td width="30%">${dcc.ccRemarks }</td>
					</tr>
					<!-- 功率(KW) -->
					<tr>
						<th width="20%" rowspan="3">功率(KW)</th>
						<th width="10%">A相</th>
						<td width="40%">${dcc.paCheckResult }</td>
						<td width="30%">${dcc.paRemarks }</td>
					</tr>
					<tr>
						<th width="10%">B相</th>
						<td width="40%">${dcc.pbCheckResult }</td>
						<td width="30%">${dcc.pbRemarks }</td>
					</tr>
					<tr>
						<th width="10%">C相</th>
						<td width="40%">${dcc.pcCheckResult }</td>
						<td width="30%">${dcc.pcRemarks }</td>
					</tr>
				</c:forEach>
				<tr>
					<th >操作人：</th>
					<td width="25%" >${dgCheck.operator.name }</td>
					<th >巡检时间：</th>
					<td >
						<fmt:formatDate value="${dgCheck.checkTime}" type="both" 
						pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr> 
			</table>
		</div>
	</div>
</body>
</html>