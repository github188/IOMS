<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM节点详情</title>

<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jquery/themes/default/style.css" />
<link href="${rootUrl }css/goal-thermometer.css" rel="stylesheet" type="text/css"/>

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js" type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts-more.js" type="text/javascript"></script>

<script type="text/javascript">
var currentAmount = 50;
var rooturl = '${rootUrl }';
</script>
<script type="text/javascript" src="${rootUrl }js/goal-thermometer.js"></script>
<script type="text/javascript">
	function loadAjax(nodeCode) {
		$.ajax({
					type : "POST",
					url : "${rootUrl}networkstat/atmAlarmDetail.dox",
					data : "nodeCode=" + nodeCode,
					dataType : "json",
					success : function(dataStatus) {
						var minorArr = [];
						var majorArr = [];
						var criticalArr = [];
						var catagoryArr = new Array();
						$.each(dataStatus, function(key, val) {
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
													+ this.series.name + ': '
													+ this.y;
											//+ '<br/>' + 'Total: '
											//+ this.point.stackTotal;
										}
									},
									plotOptions : {
										column : {
											//	colorByPoint : true,//使不同的柱状图显示不同的颜色
											//	cursor : 'pointer',//鼠标放在柱状图上面显示手型
											stacking : 'normal',//将数字显示在对应柱状图的顶部
											dataLabels : { //dataLables的功能感觉应该是设置柱形图上面的文字
												enabled : false,
												rotation : -90,
												y : 25,
												color : '#f4f4f4',
												formatter : function() {
													return Highcharts
															.numberFormat(
																	this.y, 0);
												},
												x : 10,
												style : {
													fontWeight : 'bold'
												}
											}
										}
									},
									credits : {
										enabled : false
									},
									series : [ {
										name : '严重',
										data : criticalArr
									}, {
										name : '一般',
										data : majorArr
									}, {
										name : '轻微',
										data : minorArr
									} ]
								});
					}
				});
		
	}
	
	//加载电压数值
	function loadVoltage(nodeCode){
		$.ajax({
			type : "GET",
			url : "${rootUrl}atmnodedetail/queryEnvRuninfo.dox",
			data : "nodeCode=" + nodeCode,
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
						        height: 170,
						        width: 570
						    },
						    title:{
						    	text:"节点电压"
						    },
						    pane: [{
						        startAngle: -40,
						        endAngle: 40,
						        background: null,
						        center: ['17%', '128%'],
						        size: 180
						    }, {
						    	startAngle: -40,
						    	endAngle: 40,
						    	background: null,
						        center: ['50%', '128%'],
						        size: 180
						    }, {
						    	startAngle: -40,
						    	endAngle: 40,
						    	background: null,
						        center: ['83%', '128%'],
						        size: 180
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
						        height: 170,
						        width: 570
						    },
						    title:{
						    	text:"节点电压"
						    },
						    pane: [{
						        startAngle: -40,
						        endAngle: 40,
						        background: null,
						        center: ['25%', '128%'],
						        size: 180
						    }, {
						    	startAngle: -40,
						    	endAngle: 40,
						    	background: null,
						        center: ['75%', '128%'],
						        size: 180
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
	
	//加载节点详情
	function loadDetail(nodeCode) {
		$.ajax({
			type : "GET",
			url : "${rootUrl}atmnodedetail/queryNodeDetail.dox",
			data : "nodeCode=" + nodeCode,
			dataType : "json",
			success : function(result) {
				if(result){
					$("#atmNodeCode").text(result.atmNodeCode);
					$("#atmNodeNameCn").text(result.atmNodeNameCn);
					$("#nodeIp").text(result.atmNodeIp);
					$("#bureauName").text(result.bureau);
					$("#chassisSerial").text(result.atmNodeChassisSerial);
					$("#chassisType").text(result.atmNodeChassisType)
				}
			}
		});
	}

	//加载节点运行环境
	function loadEnv(nodeCode){
		$.ajax({
			type : "GET",
			url : "${rootUrl}atmnodedetail/queryEnvRuninfo.dox",
			data : "nodeCode=" + nodeCode,
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
					}else if(envAlarmType=="Top Fan Tray"){
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
	var $tabs;
	$(function() {
		var nodeCodeSelected = $('#nodeCode').val();
		var nodeCode = $.trim(nodeCodeSelected);
		if(nodeCode==""){
			listForm.reset();
			nodeCodeSelected = $('#nodeCode').val();
			nodeCode = $.trim(nodeCodeSelected);
		}
		//Tab分页功能实现必须添加的部分
		$tabs = $("#tabs").tabs();
		loadAjax(nodeCode);
		loadDetail(nodeCode);
		loadEnv(nodeCode);
		loadVoltage(nodeCode);
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true
		});
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		//首次进入该页面index的值为空，则选中第一个tab页
		if(index==""){
			$tabs.tabs('select', 0);
		}else{
			$tabs.tabs('select', parseInt(index));
		}
		//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
		$("#tabs").tabs({
			select : function(event, ui) {
				var index = ui.index;
				$("#index").val(index);
			}
		});
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
		//页面上方的查询按钮事件
		$("#search").click(function() {
			var nodeCodeSelected = $('#nodeCode').val();
			var nodeCode = $.trim(nodeCodeSelected);
			if(nodeCode==""){
				alert("ATM节点代码不能为空！");
				return;
			}
			var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
 			if(index==3){
				//如果当前tab页位于告警下
				change("ALARM");
			} 
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
			loadAjax(nodeCode);
			loadDetail(nodeCode);
			loadEnv(nodeCode);
			loadVoltage(nodeCode);
			$("#queryResult").manage({
				pagerUrl : true,
				add : true,
				edit : true,
				update : true,
				view : true,
				remove : true
			});
		});
	});
	
	//区分不同tab的操作
	function change(optType) {
		if (optType == 'ALARM') {
			$("#bottomQueryBox").hide();
			$.ajax({
				type : "post",
				url : "${rootUrl}atmnodedetail/queryDetailType.dox",
				data : "optType=ALARM&nodeCode=" + $('#nodeCode').val(),
				dataType : "html",
				success : function(msg) {
					$('#alarmResult').html(msg);
				}
			});
		} else if(optType == 'PORT'){
			$("#bottomQueryBox").show();
			$("#optType").val(optType);
		} else {
			$("#bottomQueryBox").hide();
			$("#optType").val(optType);
		}
	}
	
</script>

</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<!-- LOGO -->
	<div id="boxmain">
		<!-- 左侧菜单 -->
		<%@ include file="/WEB-INF/jsp/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">ATM节点详情</span>
					</div>
				</div>

				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}atmnodedetail/queryDetailType.dox"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info" style="height: 30px">
											ATM节点号：
											<form:input type="text" path="nodeCode" value="${atmNode.atmNodeCode }" class="text ui-widget-content"/>
										</div>
										<a href="#none" class="sbtn" id="search">查询</a>
										<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="clear"></div>
									<table border="0" width="auto" style="height: auto;margin:0 auto;">
										<tr>
											<td rowspan="2" style="padding:1px 2px">
												<div id="boxplace">
													<div class="place">
														<span class="bold">节点视图</span>
													</div>
												</div>
												<div style="padding:2px 0px">
													<%@include file="nodepic.jsp" %>
												</div>
											</td>
											<td style="padding:1px 2px">
												<div id="boxplace">
													<div class="place">
														<span class="bold">节点信息</span>
													</div>
												</div>
												<div class="mtab" style="padding:2px 0px">
													<table bgcolor="white" cellspacing="0" border="0"
														cellpadding="0"
														style="table-layout: inherit; width: 443px; height: 120px">
														<tr>
															<th width="30%">节点代码：</th>
															<td width="70%"><div id="atmNodeCode" /></td>
														</tr>
														<tr>
															<th>节点名称：</th>
															<td><div id="atmNodeNameCn" /></td>
														</tr>
														<tr>
															<th>ATM0地址：</th>
															<td><div id="nodeIp" /></td>
														</tr>
														<tr>
															<th>区域：</th>
															<td><div id="bureauName" /></td>
														</tr>
														<tr>
															<th>机箱序列号：</th>
															<td><div id="chassisSerial" /></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
										<tr>
											<td style="padding:2px 2px">
												<div id="boxplace">
													<div class="place">
														<span class="bold">告警统计</span>
													</div>
												</div>
												<div id="lmsx">
													<div id="container" style="width: 443px; height: 210px"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<div id="tabs" style="padding-bottom: 23px">
													<ul>
														<li id="take0"><a id="queryButton" href="#tabs-1"
															onclick="change('CARD');">板卡</a></li>
														<li id="take3"><a href="#tabs-2"
															onclick="change('ALARM');">告警详情</a></li>
														<li id="take2"><a id="queryButton" href="#tabs-1"
															onclick="change('BANDWIDTH');">中继</a></li>
														<li id="take1"><a id="queryButton" href="#tabs-1"
															onclick="change('BUSINESS');">业务</a></li>
														<li id="take4"><a id="queryButton" href="#tabs-1"
															onclick="change('PORT');">端口</a></li>
													</ul>
													<div id="tabs-1">
														<!-- 查询条件 -->
														<div class="boxbtn" id="bottomQueryBox" style="display: none">
															<div class="info" style="height: 30px">
															板卡类型: <form:select path="portType" cssStyle="width:140px">
																	<c:forEach var="vo" items="${cardTypeDetail}">
																		<c:if test="${vo.value!='NA' }">
																			<form:option value="${vo.value}">${vo.value}</form:option>
																		</c:if>
																	</c:forEach>
																</form:select>
															</div>
															<a href="#none" class="sbtn" id="queryButton">查询</a> 
														</div>
														<div class="clear"></div>
														<div class="mtab">
															<!--查询结果-->
															<div id="queryResult"></div>
															<!--查询结果-->
														</div>
													</div>
													<div id="tabs-2">
														<div id="alarmResult"></div>
													</div>
												</div>
											</td>
										</tr>
									</table>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
	<script type="text/javascript">
    	$("#nodeCode").autocomplete({
    		minLength: 1, 
    	    autoFocus: true, 
    	    delay: 200 ,
    	    source: function(request, response) {
    	        $.ajax({
    	            url: "${rootUrl}atmnodedetail/nodeCodeSelect.dox",
    	            dataType: "json",
    	            data: {
    	            	atmNodeCodeLike : request.term.toUpperCase()
    	            }, 
    	            success: function(data) {
    	                response($.map(data, function(item) {
    	                    return {
    	                    	value : item.atmNodeCode,
    							name : item.atmNodeCode,
    							code : item.atmNodeCode
    	                    }
    	                }));
    	            }
    	        });
    	    }
    	});
    </script>
</body>
</html>