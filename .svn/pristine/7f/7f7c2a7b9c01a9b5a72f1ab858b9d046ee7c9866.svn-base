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
					<th width="15%" rowspan="15"><font color="red">(*)</font>巡检内容</th>
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
					<th width="30%" rowspan="10" colspan="2">外观</th>
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
					<th width="30%" colspan="2">设备外壳对地是否有电压</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.esGroundVoltage.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">UPS运行声音是否正常</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.upsRvIsNormal.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">UPS界面显示是否正常</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.upsUidisIsNormal.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">房间内空气是否流通</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.raIsFlow.value }</p>
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
					<th width="30%" colspan="2">UPS出风口是否干净</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.upsOutletIsClean.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">电池表面是否干净</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.batSurfaceIsClean.value }</p>
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
				<tr>
					<th width="30%" rowspan="2" colspan="2">告警</th>
					<th width="30%" colspan="2">UPS是否有当前故障告警</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.upsCurFAlarm.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th width="30%" colspan="2">UPS是否有重要历史告警</th>
					<td width="25%">
						<c:forEach items="${upsCheck.upsContentCheck }" var="ucc">
							<p>${ucc.upsHisFAlarm.value }</p>
						</c:forEach>
					</td>
				</tr>
				<tr><th width="100%" colspan="6"><font color="red">(*)</font>系统测量</th></tr>
				<tr>
					<th width="15%" rowspan="2">市供电参数</th>
					<th width="30" colspan="2">界面显示值</th>
					<th width="30" colspan="2">实际测量值</th>
					<th width="25" rowspan="2">备注</th>
				</tr>
				<tr>
					<th width="15%">输入</th>
					<th width="15%">输出</th>
					<th width="15%">输入</th>
					<th width="15%">输出</th>
				</tr>
				<tr>
					<th width="15%" rowspan="3">相电压(V)</th>
					<td width="15%">A-N</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pvANDisOutValue }</td>
						<td width="15%">${sm.pvANMeaInValue }</td>
						<td width="15%">${sm.pvANMeaOutValue }</td>
						<td width="15%">${sm.pvANRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">B-N</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pvBNDisOutValue }</td>
						<td width="15%">${sm.pvBNMeaInValue }</td>
						<td width="15%">${sm.pvBNMeaOutValue }</td>
						<td width="15%">${sm.pvBNRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">C-N</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pvCNDisOutValue }</td>
						<td width="15%">${sm.pvCNMeaInValue }</td>
						<td width="15%">${sm.pvCNMeaOutValue }</td>
						<td width="15%">${sm.pvCNRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<th width="15%" rowspan="3">线电压(V)</th>
					<td width="15%">A-B</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.lvABDisOutValue }</td>
						<td width="15%">${sm.lvABMeaInValue }</td>
						<td width="15%">${sm.lvABMeaOutValue }</td>
						<td width="15%">${sm.lvABRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">A-C</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.lvACDisOutValue }</td>
						<td width="15%">${sm.lvACMeaInValue }</td>
						<td width="15%">${sm.lvACMeaOutValue }</td>
						<td width="15%">${sm.lvACRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">B-C</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.lvBCDisOutValue }</td>
						<td width="15%">${sm.lvBCMeaInValue }</td>
						<td width="15%">${sm.lvBCMeaOutValue }</td>
						<td width="15%">${sm.lvBCRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<th width="15%" rowspan="3">电流(A)</th>
					<td width="15%">A相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pcADisOutValue }</td>
						<td width="15%">${sm.pcAMeaInValue }</td>
						<td width="15%">${sm.pcAMeaOutValue }</td>
						<td width="15%">${sm.pcARemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">B相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pcBDisOutValue }</td>
						<td width="15%">${sm.pcBMeaInValue }</td>
						<td width="15%">${sm.pcBMeaOutValue }</td>
						<td width="15%">${sm.pcBRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">C相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.pcCDisOutValue }</td>
						<td width="15%">${sm.pcCMeaInValue }</td>
						<td width="15%">${sm.pcCMeaOutValue }</td>
						<td width="15%">${sm.pcCRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<th width="15%" rowspan="3">功率(KVA)百分比</th>
					<td width="15%">A相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.ppADisOutValue }</td>
						<td width="15%">计算值：</td>
						<td width="15%">${sm.ppAMeaCalValue }</td>
						<td width="15%">${sm.ppARemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">B相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.ppBDisOutValue }</td>
						<td width="15%">计算值：</td>
						<td width="15%">${sm.ppBMeaCalValue }</td>
						<td width="15%">${sm.ppBRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td width="15%">C相</td>
					<c:forEach items="${upsCheck.systemMeasure }" var="sm">
						<td width="15%">${sm.ppCDisOutValue }</td>
						<td width="15%">计算值：</td>
						<td width="15%">${sm.ppCMeaCalValue }</td>
						<td width="15%">${sm.ppCRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<th width="100%" colspan="6"><font color="red">(*)</font>零地电压及零线电流测量</th>
				</tr>
				<tr>
					<th colspan="2">内容</th>
					<th colspan="2">实际测量值</th>
					<th colspan="2">测试结果</th>
				</tr>
				<tr>
					<td colspan="2">输入端零地电压(V)</td>
					<c:forEach items="${upsCheck.zgvZlcMeasure }" var="zzm">
						<td colspan="2">${zzm.zgvInputMeasure }</td>
						<td colspan="2">${zzm.zgvInputResult }</td>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="2">输出端零地电压(V)</td>
					<c:forEach items="${upsCheck.zgvZlcMeasure }" var="zzm">
						<td colspan="2">${zzm.zgvOutputMeasure }</td>
						<td colspan="2">${zzm.zgvOutputResult }</td>
					</c:forEach>
				</tr>
				<tr>
					<td rowspan="2">零线电流测量(A)</td>
					<td>输入端：</td>
					<c:forEach items="${upsCheck.zgvZlcMeasure }" var="zzm">
						<td colspan="2">${zzm.zlcInputMeasure }</td>
						<td colspan="2">${zzm.zlcInputResult }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>输出端：</td>
					<c:forEach items="${upsCheck.zgvZlcMeasure }" var="zzm">
						<td colspan="2">${zzm.zlcOutputMeasure }</td>
						<td colspan="2">${zzm.zlcOutputResult }</td>
					</c:forEach>
				</tr>
<%-- 				<tr><th width="100%" colspan="6"><font color="red">(*)</font>电池测量</th></tr>
				<tr>
					<th>电池序号</th>
					<th>端电压(V)</th>
					<th colspan="2">内阻</th>
					<th colspan="2">备注</th>
				</tr>
				<c:set var="num" value="${0 }"></c:set>
				<c:forEach items="${upsCheck.batteryMeasure }" var="bm">
					<tr>
						<td>${num+1 }</td>
						<c:set var="num" value="${num+1 }"></c:set>
						<td>${bm.termialV }</td>
						<td colspan="2">${bm.interR }</td>
						<td colspan="2">${bm.remarks }</td>
					</tr>
				</c:forEach> --%>
				<c:forEach items="${upsCheck.dischargeTest }" var="dt">
					<tr><th width="100%" colspan="6"><font color="red">(*)</font>放电测试</th></tr>
					<tr>
						<td colspan="2">放电开始时间：
							<fmt:formatDate value="${dt.startTime}" type="both" 
							pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td colspan="2">放电结束时间
							<fmt:formatDate value="${dt.endTime}" type="both" 
							pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td colspan="2">放电持续时间(分钟)：${dt.durationTime }</td>
					</tr>
					<tr>
						<td colspan="2">放电前总电压：${dt.preTotalV }</td>
						<td colspan="2">放电终止总电压：${dt.endTotalV }</td>
						<td colspan="2">电池充电电流：${dt.batChargingC }</td>
					</tr>
					<tr>
						<th>放电时间(分钟)</th>
						<th>电池总电压</th>
						<th>放电电流</th>
						<th>单节最高电压</th>
						<th>单节最低电压</th>
						<th>备注</th>
		            </tr>
	            	<c:forEach items="${dt.dischargeProcess }" var="dp">
	            		<tr>
	            			<td>${dp.dsTime }</td>
	            			<td>${dp.batTotalV }</td>
	            			<td>${dp.dsCurrent }</td>
	            			<td>${dp.singleMaxV }</td>
	            			<td>${dp.singleMinV }</td>
	            			<td>${dp.remark }</td>
	            		</tr>
	            	</c:forEach>
				</c:forEach>
				<tr><th width="100%" colspan="6"><font color="red">(*)</font>系统连接检查</th></tr>
				<tr>
					<th>序号</th>
					<th>内容</th>
					<th colspan="2">测试结果</th>
					<th colspan="2">备注</th>
				</tr> 
				<tr>
					<td>1</td>
					<td>UPS内部连接端子是否牢固</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsIcTr }</td>
						<td colspan="2">${scm.upsIcRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>2</td>
					<td>UPS风扇运转是否正常</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsFRunTr }</td>
						<td colspan="2">${scm.upsFRunRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>3</td>
					<td>UPS内部板卡是否牢固</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsIbFirmTr }</td>
						<td colspan="2">${scm.upsIbFirmRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>4</td>
					<td>UPS连接导线是否无过热现象</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsCwOhTr }</td>
						<td colspan="2">${scm.upsCwOhRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>5</td>
					<td>UPS运行声音是否正常</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsRvTr }</td>
						<td colspan="2">${scm.upsRvRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>6</td>
					<td>电池连接端子是否牢固</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.batCTr }</td>
						<td colspan="2">${scm.batCRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>7</td>
					<td>UPS至配电柜的输入和输出导线是否完好</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.upsPdcIowTr }</td>
						<td colspan="2">${scm.upsPdcIowRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>8</td>
					<td>电池组直流母线是否完好</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.bpdbTr }</td>
						<td colspan="2">${scm.bpdbRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>9</td>
					<td>配电柜内连接端子是否牢固</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.pdcCTr }</td>
						<td colspan="2">${scm.pdcCRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>10</td>
					<td>配电柜仪表及指示灯是否正常</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.pdcMIlTr }</td>
						<td colspan="2">${scm.pdcMIlRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>11</td>
					<td>各断路器是否无发热及杂声现象</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.bfnTr }</td>
						<td colspan="2">${scm.bfnRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>12</td>
					<td>到负载端的连接导线是否无发热</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.ltCwFTr }</td>
						<td colspan="2">${scm.ltCwFRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>13</td>
					<td>到负载端的各回路电流是否在安全运行范围之内</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.ltLcTr }</td>
						<td colspan="2">${scm.ltLcRemark }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>14</td>
					<td>到负载端的各插座是否运行正常</td>
					<c:forEach items="${upsCheck.systemConnMeasure }" var="scm">
						<td colspan="2">${scm.ltSTr }</td>
						<td colspan="2">${scm.ltSRemark }</td>
					</c:forEach>
				</tr>
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