<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link href="${rootUrl }css/goal-thermometer.css" rel="stylesheet" type="text/css"/>

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts-more.js"
	 type="text/javascript"></script>
<script type="text/javascript">
var currentAmount = 50;
var rooturl = '${rootUrl }';
</script>
<script type="text/javascript" src="${rootUrl }js/goal-thermometer.js"></script>
<script type="text/javascript">
//加载节点运行环境
function loadEnv(){
	$.ajax({
		type : "GET",
		url : "${rootUrl}atmnodedetail/queryEnvRuninfo.dox",
		data : "nodeCode=" + $('#nodeCode').val(),
		dataType : "json",
		success : function(result) {
			var temperature;
			var topArr = new Array();
			var bottomArr = new Array();
			var fanArr = new Array();
			for(var i=0;i<result.length;i++){
				var envAlarmType = result[i].nodeEnvAlarmType;
				if(envAlarmType=="Temperature"){
					temperature = result[i].nodeEnvValue;
				}else if(envAlarmType.indexOf("Top Fan Tray")!=-1){
					topArr.push(result[i]);
				}else if(envAlarmType.indexOf("Bottom Fan Tray")!=-1){
					bottomArr.push(result[i]);
				}else if(envAlarmType.indexOf("Fan Tray")!=-1){
					fanArr.push(result[i]);
				}
			}
			//显示温度计的数值
			if(temperature){
		        var inputnum = parseInt(temperature);
		        currentAmount = inputnum;
		        determineImageSet();
			}else{
		        currentAmount = 0;
		        determineImageSet();
			}
			//8850机箱top风扇布局
			$.each(topArr,function(key,val){
				var envUnit = val.nodeEnvUnit;
				var isAlarm = val.isAlarm;
				//alert(isAlarm);
				if(isAlarm){
					$("#imgt"+key).attr("src","${rootUrl }images/FAN_ALARM.png");
				}else{
					$("#imgt"+key).attr("src","${rootUrl }images/FAN_NORMAL.png");
				}
			});
			//8850机箱bottom风扇布局
			$.each(bottomArr,function(key,val){
				var envUnit = val.nodeEnvUnit;
				var isAlarm = val.isAlarm;
				if(isAlarm){
					$("#imgb"+key).attr("src","${rootUrl }images/FAN_ALARM.png");
				}else{
					$("#imgb"+key).attr("src","${rootUrl }images/FAN_NORMAL.png");
				}
			});
			//8830机箱风扇布局
			$.each(fanArr,function(key,val){
				var envUnit = val.nodeEnvUnit;
				var isAlarm = val.isAlarm;
				if(isAlarm){
					$("#img"+key).attr("src","${rootUrl }images/FAN_ALARM.png");
				}else{
					$("#img"+key).attr("src","${rootUrl }images/FAN_NORMAL.png");
				}
			});
		}
	});
}
//加载电压数值
function loadVoltage(){
	$.ajax({
		type : "GET",
		url : "${rootUrl}atmnodedetail/queryEnvRuninfo.dox",
		data : "nodeCode=" + $('#nodeCode').val(),
		dataType : "json",
		success : function(result) {
			var inputV1;
			var inputV2; 
			var inputV3;
			for(var i=0;i<result.length;i++){
				var envAlarmType = result[i].nodeEnvAlarmType;
				var nodeCode = result[i].nodeCode;
				if(envAlarmType.indexOf("+5V Input")!=-1){
					inputV1 = result[i].nodeEnvValue;
				}else if(envAlarmType.indexOf("+3.3V Input")!=-1){
					inputV2 = result[i].nodeEnvValue;
				}
				if(nodeCode.indexOf("8850")!=-1){
					if(envAlarmType.indexOf("+2.5V Input")!=-1){
						inputV3 = result[i].nodeEnvValue;
					}
				}
			}
			if(inputV3){
				$("#8850dianya").highcharts({
					  chart: {
					        type: 'gauge',
					        plotBorderWidth: 1,
					        plotBackgroundColor: {
					        	linearGradient: {x1:0,y1:0,x2:0,y2:1},
					        	stops: [
					        	        [0,'#FFF4C6'],
					        	        [0.3,'#FFFFFF'],
					        	        [1,'#FFF4C6']
					        	   ]
					        },
					        height: 160,
					        width: 472
					    },
					    title:{
					    	text:"节点电压"
					    },
					    pane: [{
					        startAngle: -40,
					        endAngle: 40,
					        background: null,
					        center: ['16%', '128%'],
					        size: 160
					    }, {
					    	startAngle: -40,
					    	endAngle: 40,
					    	background: null,
					        center: ['49%', '128%'],
					        size: 160
					    }, {
					    	startAngle: -40,
					    	endAngle: 40,
					    	background: null,
					        center: ['83%', '128%'],
					        size: 160
					    }],	    		        
						credits:{
							enabled:false
						},
					    yAxis: [{
					        min: 0,
					        max: 10,
					        minorTickPosition: 'outside',
					        tickPosition: 'outside',
					        labels: {
					        	rotation: 'auto',
					        	distance: 20
					        },
					        plotBands: [{
					        	from: 8,
					        	to: 10,
					        	color: '#C02316',
					        	innerRadius: '100%',
					        	outerRadius: '105%'
					        }],
					        pane: 0,
					        title: {
					        	text: "+5V Input",
					        	y: -20
					        }
					    }, {
					        min: 0,
					        max: 10,
					        minorTickPosition: 'outside',
					        tickPosition: 'outside',
					        labels: {
					        	rotation: 'auto',
					        	distance: 20
					        },
					        plotBands: [{
					        	from: 8,
					        	to: 10,
					        	color: '#C02316',
					        	innerRadius: '100%',
					        	outerRadius: '105%'
					        }],
					        pane: 1,
					        title: {
					        	text: "+3.3V Input",
					        	y: -20
					        }
					    }, {
					        min: 0,
					        max: 10,
					        minorTickPosition: 'outside',
					        tickPosition: 'outside',
					        labels: {
					        	rotation: 'auto',
					        	distance: 20
					        },
					        plotBands: [{
					        	from: 8,
					        	to: 10,
					        	color: '#C02316',
					        	innerRadius: '100%',
					        	outerRadius: '105%'
					        }],
					        pane: 2,
					        title: {
					        	text: "+2.5V Input",
					        	y: -20
					        }
					    }],
					    plotOptions: {
					    	gauge: {
					    		dataLabels: {
					    			enabled: false
					    		},
					    		dial: {
					    			radius: '100%'
					    		}
					    	}
					    },
					    series: [{
					        data: [parseFloat(inputV1)],
					        yAxis: 0
					    }, {
					        data: [parseFloat(inputV2)],
					        yAxis: 1
					    },{
					    	data: [parseFloat(inputV3)],
					    	yAxis: 2
					    }]
					});
			}else{
				$("#8830dianya").highcharts({
					  chart: {
					        type: 'gauge',
					        plotBorderWidth: 1,
					        plotBackgroundColor: {
					        	linearGradient: {x1:0,y1:0,x2:0,y2:1},
					        	stops: [
					        	        [0,'#FFF4C6'],
					        	        [0.3,'#FFFFFF'],
					        	        [1,'#FFF4C6']
					        	   ]
					        },
					        height: 160,
					        width: 472
					    },
					    title:{
					    	text:"节点电压"
					    },
					    pane: [{
					        startAngle: -40,
					        endAngle: 40,
					        background: null,
					        center: ['25%', '128%'],
					        size: 160
					    }, {
					    	startAngle: -40,
					    	endAngle: 40,
					    	background: null,
					        center: ['75%', '128%'],
					        size: 160
					    }],	    		        
						credits:{
							enabled:false
						},
					    yAxis: [{
					        min: 0,
					        max: 10,
					        minorTickPosition: 'outside',
					        tickPosition: 'outside',
					        labels: {
					        	rotation: 'auto',
					        	distance: 20
					        },
					        plotBands: [{
					        	from: 8,
					        	to: 10,
					        	color: '#C02316',
					        	innerRadius: '100%',
					        	outerRadius: '105%'
					        }],
					        pane: 0,
					        title: {
					        	text: "+5V Input",
					        	y: -20
					        }
					    }, {
					        min: 0,
					        max: 10,
					        minorTickPosition: 'outside',
					        tickPosition: 'outside',
					        labels: {
					        	rotation: 'auto',
					        	distance: 20
					        },
					        plotBands: [{
					        	from: 8,
					        	to: 10,
					        	color: '#C02316',
					        	innerRadius: '100%',
					        	outerRadius: '105%'
					        }],
					        pane: 1,
					        title: {
					        	text: "+3.3V Input",
					        	y: -20
					        }
					    }],
					    plotOptions: {
					    	gauge: {
					    		dataLabels: {
					    			enabled: false
					    		},
					    		dial: {
					    			radius: '100%'
					    		}
					    	}
					    },
					    series: [{
					        data: [parseFloat(inputV1)],
					        yAxis: 0
					    }, {
					        data: [parseFloat(inputV2)],
					        yAxis: 1
					    }]
					});
			}
			
		}
	});
}
//加载节点告警信息
function loadAlarmInfo(){
	$.ajax({
		type : "POST",
		url:"${rootUrl}networkstat/atmAlarmDetail.dox",
		data : "nodeCode="+$('#nodeCode').val(),
		dataType : "json",
		success : function(dataStatus){
			var minorArr = new Array();
			var majorArr = new Array();
			var criticalArr = new Array();
			var catagoryArr = new Array();
			$.each(dataStatus,function(key,val){
				catagoryArr.push(val.nodeAlarmType.value);
				minorArr.push(val.nodeMinorSum);
				majorArr.push(val.nodeMajorSum);
				criticalArr.push(val.nodeCriticalSum);
			});
			var chart = new Highcharts.Chart(
					{
						chart : {
							renderTo : 'container',
							type : 'column',
							borderWidth : 0, //设置图表边框宽度
							plotBorderWidth : 1,//主图表边框宽度
							shadow : true
							//	margin : [ 40, 85, 30, 60 ],
						},
						title : {
							text : '<b>告警信息</b>'
						},
						xAxis : {
							categories : catagoryArr,
							labels : {
								allowPointSelect : true,
								rotation : -45,
								aligh : 'center',
								//step : 1,
								y : 15,
								x : 10,
								//allowPointSelect : true,
								//cursor : 'pointer',
								formatter : function() {
									//alert("aaa");
									return '<a href="javascript:alert(\'hello\')">'
											+ this.value + '</a>';
								}
							},
							lineWidth : 1
						//基线宽度
						},
						yAxis : {
							min : 0, //不显示负数
							allowDecimals : false,//不显示小数
							lineWidth : 1, //基线宽度
							tickInterval : 2,//Y轴值按5来等分
							//type : 'logarithmic',
							title : {
								text : '告警数量',
							},
							stackLabels : {
								enabled : true,
								style : {
									fontWeight : 'bold',
									color : (Highcharts.theme && Highcharts.theme.textColor)
											|| 'gray'
								}
							}
						},
						legend : {
							enabled : true,
							align : 'right',
							verticalAlign : 'middle',
							layout : 'vertical',
							/* y : 20,
							 x : -100,
							 floating : true, */
							backgroundColor : (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid)
									|| 'white',
							borderColor : '#CCC',
							borderWidth : 1,
							shadow : true
						},
						tooltip : {
							formatter : function() {
								return '<b>' + this.x + '</b><br/>'
										+ this.series.name + ': ' + this.y;
								//+ '<br/>' + 'Total: '
								//+ this.point.stackTotal;
							}
						},
						plotOptions : {
							column : {
							//	colorByPoint : true,//使不同的柱状图显示不同的颜色
							//	cursor : 'pointer',//鼠标放在柱状图上面显示手型
								stacking : 'normal',//将数字显示在对应柱状图的顶部
								dataLabels : {
									enabled : false,
									color : (Highcharts.theme && Highcharts.theme.dataLabelsColor)
											|| 'white',
									style : {
										textShadow : '0 0 3px black, 0 0 3px black'
									}
								}
						},
							series : {
								borderWidth : 1,
								dataLabels : {
									enabled : false,//默认为false，即默认不显示数值
									//color:'#666',//字体颜色
									align:'center',//居柱子中间
								//  format: '{point.y:.1f}%'
								}
							}
						},
						credits : {
							enabled : false  //去除右下角的官方超链
						},
						series : [ {
							name : 'Critical',
							data : criticalArr
						}, {
							name : 'Major',
							data : majorArr
						}, {
							name : 'Minor',
							data : minorArr
						} ]
					});
		}
	});
}
$(function() {
	$.ajaxSetup({
		cache : false
	});
	loadAlarmInfo();
	loadEnv();
	loadVoltage();
	var nodeCode = $("#nodeCode").val();
	if(nodeCode.indexOf("8850")!=-1){
		$("#8850fan").show();//8850风扇图片等信息区域显示
		$("#8850pic").show();
		$("#8850dy").show();
		$("#8830fan").hide();//8830风扇图片等信息区域隐藏
		$("#8830pic").hide();
		$("#8830dy").hide();
	}else{
		$("#8830fan").show();
		$("#8830pic").show();
		$("#8830dy").show();
		$("#8850fan").hide();//8850风扇图片等信息区域显示
		$("#8850pic").hide();
		$("#8850dy").hide();
	}
	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#alarmDetailButton").nyroModal({
		forceType : "iframe",
		minWidth : 1000,
		minHeight : 450,
		closeButton : null
	});
});
</script>
</head>
<body>
<form:form modelAttribute="pageModel" id="modForm" name="modForm">
	<form:hidden id="nodeCode" path="nodeCode" />
	<div class="window">
		<dl class="title">
			<dd>告警详情</dd>
			<dt>
				<a href="#none" class="close"> <img
					src="${rootUrl }images/close.png" alt="关闭" />
				</a>
			</dt>
		</dl>
		<table cellpadding="0" cellspacing="0" border="0" style="padding:0 0 10px;">
				<tr>
					<td style="height:auto;padding:1px;" class="td1" colspan="2">
						<div class="mtab" style="width: auto; height: auto;">
							<table width="450" border="0" cellspacing="0" cellpadding="0" style="margin: 0px"
								class="title">
								<tr>
									<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />节点告警信息</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			<tr>
				<td valign="top" >
					<div class="mtab" style="width: 470px; height: 220px; overflow: auto;">
						<table id="dataTable" border="0" cellspacing="0"
							cellpadding="2" class="tablesorter" style="table-layout: fixed;margin: 0px;width:100%">
							<thead>
								<tr>
									<th width="20%">Alarm Type</th>
									<th width="10%">Critical</th>
									<th width="10%">Major</th>
									<th width="10%">Minor</th>
									<th width="20%">是否告警</th>
									<th width="20%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${atmpagn}" var="vo"
									varStatus="voStatus">
									<tr>
										<td>${vo.nodeAlarmType.value }</td>
										<td>${vo.nodeCriticalSum }</td>
										<td>${vo.nodeMajorSum}</td>
										<td>${vo.nodeMinorSum}</td>
										<td>${vo.isAlarm.value }</td>
										<td class="tdbtn">
											<c:choose>
												<c:when test="${vo.nodeAlarmType=='Environment' || vo.nodeAlarmType=='Card' }">
													<a href="#" onclick="javascript:alert('请在下方查找对应告警的详情信息!');">详情</a>
												</c:when>
												<c:otherwise>
													<a href="#" onclick="javascript:alert('欲了解详情,请联系北京网控中心!');">详情</a>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</td>
				<td>
					<div class="minfo">
						<div class="bl">
							<div class="br">
								<div id="lmsx">
									<div id="container" style="width: 450px;height: 220px"></div>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td style="height:auto;padding:1px;" class="td1" colspan="2">
					<div class="mtab" style="width: auto; height: auto;">
						<table width="450" border="0" cellspacing="0" cellpadding="0" style="margin: 0px"
							class="title">
							<tr>
								<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />运行环境</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="mtab"
						style="width: 470px; height: 300px; overflow: auto;">
						<table id="dataTable" border="0" cellspacing="0"
							cellpadding="2" class="tablesorter" style="wtable-layout: fixed;margin: 0px;width:100%">
							<thead>
								<tr>
									<th data-options="20%">Alarm Type</th>
									<th data-options="10%">Unit</th>
									<th data-options="10%">Threshold</th>
									<th data-options="10%">DataType</th>
									<th data-options="20%">Value</th>
									<th data-options="20%">State</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${envpagn}" var="vo" varStatus="voStatus">
									<tr>
										<td>${vo.nodeEnvAlarmType }</td>
										<td>${vo.nodeEnvUnit }</td>
										<td>${vo.nodeEnvThreshold}</td>
										<td>${vo.nodeEnvDataType}</td>
										<td>${vo.nodeEnvValue}</td>
										<td>${vo.nodeEnvState}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</td>
				<td>
					<%@include file="nodepic.jsp" %>
				</td>
			</tr>
			<tr>
				<td style="height:auto;padding:1px;" class="td1" colspan="2">
					<div class="mtab" style="width: auto; height: auto;">
						<table width="450" border="0" cellspacing="0" cellpadding="0" style="margin: 0px"
							class="title">
							<tr>
								<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />板卡告警</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="mtab"
						style="width: 950px; height: 200px; overflow: auto;">
						<table id="dataTable" border="0" cellspacing="0"
							cellpadding="2" class="tablesorter" style="table-layout: fixed;margin: 0px;width:100%">
							<thead>
								<tr>
									<th rowspan="2">槽位号</th>
									<th rowspan="2">CardType</th>
									<th colspan="3">告警等级</th>
									<th rowspan="2">是否告警</th>
									<th rowspan="2">操作</th>
								</tr>
								<tr>
									<th width="15%">Critical</th>
									<th width="15%">Major</th>
									<th width="15%">Minor</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cardpagn}" var="vo"
									varStatus="voStatus">
									<tr>
										<td>${vo.cardSlot }</td>
										<td>${vo.cardType }</td>
										<td>${vo.cardCriticalSum}</td>
										<td>${vo.cardMajorSum}</td>
										<td>${vo.cardMinorSum}</td>
										<td>${vo.isAlarm=='true'?'告警':'正常' }</td>
										<td class="tdbtn">
											 <a id="alarmDetailButton" href="${rootUrl}networkstat/getAtmCardAlarmDetail.dox?cardId=${vo.card.id}">详情</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</td>
<!-- 				<td>
					<table style="width: 50%;margin: 0 auto;border-collapse: collapse;" border="1">
						<tr class='blue'>
							<td width='50px' style="text-align: center;font-size: 13px;font-weight: bold;">严重</td>
							<td id="critical" width='50px'></td>
						</tr>
						<tr class='red'>
							<td width='50px' style="text-align: center;font-size: 13px;font-weight: bold;">主要</td>
							<td id="major" width='50px'></td>
						</tr>
						<tr class='yellow'>
							<td width='50px' style="text-align: center;font-size: 13px;font-weight: bold;">一般</td>
							<td id="normal" width='50px'></td>
						</tr>
					</table>
				</td> -->
			</tr>
			<tr>
				<td style="height:auto;padding:1px;" class="td1" colspan="2">
					<div class="mtab" style="width: auto; height: auto;">
						<table width="450" border="0" cellspacing="0" cellpadding="0" style="margin: 0px"
							class="title">
							<tr>
								<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />业务告警</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="mtab" style="width: 950; height: auto; overflow: auto;">
						<table id="dataTable" border="0" cellspacing="0"
							cellpadding="2" class="tablesorter" style="table-layout: fixed;margin: 0px;width:100%">
								<thead>
									<tr>
										<th rowspan="2">序号</th>
										<th rowspan="2">业务名称</th>
										<th colspan="3">本地节点</th>
										<th colspan="3">远端节点</th>
										<th rowspan="2">速率（kbps）</th>
										<th rowspan="2">服务等级</th>
										<th rowspan="2">状态</th>
										<th rowspan="2">详情</th>
									</tr>
									<tr>
									  <th>节点名称</th>
									  <th>端口号</th>
									  <th>dlci/ vpi.vci</th>
									  
									  <th>节点名称</th>
									  <th>端口号</th>
									  <th>dlci/ vpi.vci</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${servicepagn}" var="vo"
										varStatus="voStatus">
										<tr>
											<td>${voStatus.index+1 }</td>
											<td>${vo.service.serviceName}</td>
											
											<td>${vo.service.localNodeNameCn}</td>
											<td>${vo.service.localPort }</td>
											<td>${vo.service.localPortDLCIVPIVCI }</td>
											
											<td>${vo.service.remoteNodeNameCn}</td>
											<td>${vo.service.remotePort }</td>
											<td>${vo.service.remotePortDLCIVPIVCI }</td>
											
											<td>${vo.service.serviceCir }</td>
											<td>${vo.service.serviceClass }</td>
											<td>${vo.isAlarm=='true'?'告警':'正常'}</td>
											<td class="tdbtn">
												<a id="alarmDetailButton" href="${rootUrl }basedata/atm/service/view.do?id=${vo.service.id}" >详情</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
	</form:form>
</body>
</html>