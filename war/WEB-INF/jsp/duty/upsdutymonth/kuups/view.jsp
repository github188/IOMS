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
			<dd>ups巡检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="3">设备名称</th>
					<th colspan="3">${upsCheck.name }</th>
				</tr>
				<tr>
					<th width="15%" rowspan="19"><font color="red">(*)</font>巡检内容</th>
					<th width="30%" rowspan="3" colspan="2">环境</th>
					<th width="30%" colspan="2">环境温度是否可调</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.atIsAdjustable.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">环境温度(℃)</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.temperature }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">环境湿度</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.humidity }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" rowspan="4" colspan="2">外观</th>
					<th width="30%" colspan="2">设备外观是否完好</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.eaIsIntact.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">UPS及电池柜的散热是否正常</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.radiateIsNormal.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">电池无漏夜现象</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.batLeakage.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">连接端子无腐蚀氧化</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.connCo.value }</p>
						</c:forEach>
					</td>
				</tr>
				<!-- 输入系统 -->
				<tr>
					<th width="30%" rowspan="7" colspan="2">输入系统</th>
					<th width="30%" colspan="2">输入电压L-N</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputVLN }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输入电压L-地</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputVLD }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输入电压N-地</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputVND }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输入电流</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputCurrent }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">负载量</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.loadCapacity }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">空开温度</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputAirTemperature }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">线缆温度</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.inputCableTemperature }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" rowspan="5" colspan="2"></th>
					<th width="30%" colspan="2">输出电压L-N</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.outputVLN }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输出电压L-地</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.outputVLD }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输出电压N-地</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.outputVND }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">输出电流</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.outputCurrent }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">空开温度</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.outputAirTemperature }</p>
						</c:forEach>
					</td>
				</tr>
				<!-- 电池测量 -->
				<tr><th width="100%" colspan="6"><font color="red">(*)</font>电池测量</th></tr>
				<tr>
					<th>电池序号</th>
					<th>端电压(V)</th>
					<th colspan="2">内阻</th>
					<th colspan="2">备注</th>
				</tr>
				<%-- <c:set var="num" value="${0 }"></c:set> --%>
				<c:forEach items="${upsCheck.batteryMeasure }" var="bm">
					<tr>
						<td>${bm.number }</td>
						<%-- <c:set var="num" value="${num+1 }"></c:set> --%>
						<td>${bm.termialV }</td>
						<td colspan="2">${bm.interR }</td>
						<td colspan="2">${bm.remarks }</td>
					</tr>
				</c:forEach>
				<tr>
					<th colspan="1">存在问题</th>
					<td colspan="5">${upsCheck.problem }</td>
				</tr>
				<tr>
					<th colspan="1">建议</th>
					<td colspan="5">${upsCheck.suggestion }</td>
				</tr>
				<tr>
					<th colspan="1">结果</th>
					<td colspan="5">${upsCheck.result }</td>
				</tr>
				<tr>
					<th>操作人：</th>
					<td colspan="2">${upsCheck.operator.name }</td>
					<th>巡检时间：</th>
					<td colspan="2">
						<fmt:formatDate value="${upsCheck.checkTime}" type="both" 
						pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr> 
			</table>
		</div>
	</div>
</body>
</html>