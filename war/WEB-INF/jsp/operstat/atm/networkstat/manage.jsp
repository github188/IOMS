<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM网络统计</title>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jquery/themes/default/style.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js"
	type="text/javascript"></script>
<script type="text/javascript">

	$(function() {
		//初始化ATM全网设备统计右侧表格数据
		$.ajax({
			url : "${rootUrl}networkstat/atmEquip.dox",
			data : "bureau=ZBAA",
			dataTye : "html",
			success : function(msg) {
				$('#atmEquip').html(msg);
			},
			error : function(msg){
				$('#atmEquip').html(msg);
			}
		});
		//初始化ATM全网业务统计右侧表格数据
		$.ajax({
			url : "${rootUrl}networkstat/atmService.dox",
			data : "bureau=ZBAA",
			dataTye : "html",
			success : function(msg) {
				$('#atmService').html(msg);
			},
			error : function(msg){
				$('#atmService').html(msg);
			}
		});
		//初始化ATM全网告警统计右侧表格数据
 		$.ajax({
			url : "${rootUrl}networkstat/atmAlarm.dox",
			data : "bureau=ZBAA",
			dataTye : "html",
			success : function(msg) {
				$('#atmAlarm').html(msg);
			},
			error : function(msg){
				$('#atmAlarm').html(msg);
			}
		});
		//初始化ATM全网端口统计右侧表格数据
  		$.ajax({
			url : "${rootUrl}networkstat/atmPnni.dox",
			data : "bureau=ZBAA",
			dataTye : "html",
			success : function(msg) {
				$('#atmPort').html(msg);
			},
			error : function(msg){
				$('#atmPort').html(msg);
			}
		});
 		//初始化ATM全网带宽统计表格数据
 		$.ajax({
			url : "${rootUrl}networkstat/atmBand.dox",
			dataTye : "html",
			success : function(msg) {
				$('#atmBand').html(msg);
			},
			error : function(msg){
				$('#atmBand').html(msg);
			}
		});
		
	//Atm全网设备统计柱状图
	$.ajax({
		url:"${rootUrl}networkstat/initAtmEquip.dox",
		dataType : "json",
		success : function(dataStatus){
			var bureauArr = new Array();
		    var numArr = new Array();
		    $.each(dataStatus,function(key,val){
		    	bureauArr.push(val.bureau);
		    	numArr.push(val.count);
		    });
		var chart = new Highcharts.Chart({
			chart : {
				renderTo : 'container',
				type : 'column',
				borderWidth : 0, //设置图表边框宽度
				plotBorderWidth : 1,//主图表边框宽度
				shadow : true,
			//	margin : [ 40, 85, 60, 60 ],
				width : 550
			},
			title : {
				text : '<b>ATM数据网节点统计</b>'
			},
			xAxis : {
				categories : bureauArr,
				labels : {
					allowPointSelect : true,
					rotation : -45,
					aligh : 'center',
					//step : 1,
					y : 15,
					x : 10,
					//allowPointSelect : true,
					//cursor : 'pointer',
					formatter : function(){
						//alert("aaa");
						return '<a href="javascript:alert(\'hello\')">'+this.value+'</a>';
					}
				},
				lineWidth : 1	//基线宽度
			},
			yAxis : {
				min : 0,	//不显示负数
				allowDecimals : false,//不显示小数
				lineWidth : 1, //基线宽度
				tickInterval : 2,//Y轴值按5来等分
				//type : 'logarithmic',
				title : {
					text : '节点数量',
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
				enabled : false,
				align : 'right',
				verticalAlign : 'middle',
/* 				y : 20,
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
				}
			},
			plotOptions : {
				column : {
					colorByPoint : true,//使不同的柱状图显示不同的颜色
					cursor : 'pointer',//鼠标放在柱状图上面显示手型
					stacking : 'normal',//将数字显示在对应柱状图的顶部
					point : {
						events : {
							click : function(event) {
								//★添加跳转代码★                     
								//alert(event.point.category);
								var bureauName = event.point.category;
								var bureauValue;
								switch (bureauName) {
								case "新疆":
									bureauValue = "ZWWW";
									break;
								case "西北":
									bureauValue = "ZLXY";
									break;
								case "西南":
									bureauValue = "ZUUU";
									break;
								case "华北":
									bureauValue = "ZBAA";
									break;
								case "华东":
									bureauValue = "ZSSS";
									break;
								case "中南":
									bureauValue = "ZGGG";
									break;
								case "东北":
									bureauValue = "ZYTX";
									break;
								case "北京网控中心":
									bureauValue = "ZBBB";
									break;
								case "上海网控中心":
									bureauValue = "ZSPD";
									break;
								case "境外":
									bureauValue = "OVERSEAS";
									break;
								default:
									bureauValue = "错误";
								};
								$.ajax({
									url : "${rootUrl}networkstat/atmEquip.dox",
									data : "bureau="
											+ bureauValue,
									dataTye : "html",
									success : function(msg) {
										$('#atmEquip').html(msg);
									},
									error : function(msg){
										$('#atmEquip').html(msg);
									}
								});
							}
						}
					},
					dataLabels : { //dataLables的功能感觉应该是设置柱形图上面的文字
						enabled : false,
						rotation : -90,
						y:25,
						color:'#f4f4f4',
						formatter: function(){
							return Highcharts.numberFormat(this.y,0);
						},
						x : 10,
						style:{
							fontWeight: 'bold'
						}
						//color : (Highcharts.theme && Highcharts.theme.dataLabelsColor)
							//	|| 'white'
					}
				}
			},
			credits : {
				enabled : false //去掉右下角的Highcharts官网链接
			},
			series : [ {
				name : '节点数量',
				data : numArr
			} ]
		});
		}
	});
		
	//ATM全网业务统计（堆叠柱状图）
	$.ajax({
		url:"${rootUrl}networkstat/initAtmService.dox",
		dataType : "json",
		success : function(dataStatus){
			//alert(dataStatus.length);
			    var bureauArr = new Array();//管局数组
			    var serviceTypeArr = new Array();//服务类别数组
			    var typeNumObjArr = new Array(); //服务类别与其对应数量的object的数组
				$.each(dataStatus, function(key, val) {
					var bureau = val.bureau;
					var serviceType = val.serviceType;
					var count = val.count;
					//alert(key+"-->"+val.bureau+"-"+val.serviceType+"-"+val.count);
					var flag = false;
					var typeFlag = false;
					for(var i=0;i<bureauArr.length;i++){//判断管局数组中是否已经包含该管局名称
						if(bureauArr[i]==bureau){
							flag = true;					
						}
					}
					for(var i=0;i<serviceTypeArr.length;i++){//判断服务类别数组中是否已经包含该服务类别
						if(serviceTypeArr[i]==serviceType){
							typeFlag = true;					
						}
					}
					if(!flag){
						//管局数组中未包含该管局信息
						bureauArr.push(bureau);	
					}
					var index = bureauArr.length;
					//开始循环下一个管局
					if(!flag && index>1){
						var newIndex = index-1;
						for(var i=0;i<typeNumObjArr.length;i++){
							if(typeNumObjArr[i].data.length!=newIndex){
								typeNumObjArr[i].data.push(0);
							}
						}
					}
					if(!typeFlag){
						//服务类别数组中未包含该服务类别信息
						serviceTypeArr.push(serviceType);
						//如果第二个管局之后出现新的服务类别
						//alert("index:"+index);
						if(index > 1){
							var dataArr = new Array();
							//当前管局中新出现的类别在之前的管局中数量为0
							for(var i=1;i<index;i++){
								dataArr.push(0);
							}
							//将当前管局该类别数量添加到数组中
							dataArr.push(count);
							var obj = new Object();
							obj.name=serviceType;
							obj.data=dataArr;
							typeNumObjArr.push(obj);
						}else{
							//第一个管局所拥有的服务类别
							var dataArr = new Array();
							dataArr.push(count);
							var obj = new Object();
							obj.name=serviceType;
							obj.data=dataArr;
							typeNumObjArr.push(obj);
						}
					}else{
						//包含该服务类别
						for(var i=0;i<typeNumObjArr.length;i++){
							if(typeNumObjArr[i].name==serviceType){
								typeNumObjArr[i].data.push(count);
							}
						}
					}
				});
/*  				for(var i=0;i<typeNumObjArr.length;i++){
					alert(typeNumObjArr[i].name+"->"+typeNumObjArr[i].data);
				}  */
/* 				var obj = new Object();
				obj.name="其他";
				obj.data=otherNumArr;
				serviceTypeArr.push(obj); */
				//alert(serviceTypeArr[0].data);
/* 				[{
					name : '其它',
					data : otherNumArr
				} ] */
		$('#stackedContainerBusi')
				.highcharts(
						{
							chart : {
								type : 'column',
								borderWidth : 0, //设置图表边框宽度
								plotBorderWidth : 1,//主图表边框宽度
								shadow : true,
							//	margin : [ 40, 85, 30, 60 ],
								width : 550
							},
							title : {
								text : '<b>ATM数据网业务统计</b>'
							},
							subtitle : {
							//  text: '子标题。。。。'
							},
							xAxis : {
								categories : bureauArr,
								labels : {
									allowPointSelect : true,
									rotation : -45,
									aligh : 'center',
									//step : 1,
									y : 15,
									x : 10,
									//allowPointSelect : true,
									//cursor : 'pointer',
									formatter : function(){
										//alert("aaa");
										return '<a href="javascript:alert(\'hello\')">'+this.value+'</a>';
									}
								},
								lineWidth : 1 //基线宽度
							},
							yAxis : {
								min : 0,	//不显示负数
								allowDecimals : false,//不显示小数
								lineWidth : 1, //基线宽度
								tickInterval : 30,//Y轴值按30来等分
								title : {
									text : '业务数量'
								},
							//	type : 'logarithmic',
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
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
/* 								floating : true, //集合x,y实现位置浮动
								x : -10,
								y : 60, */
								backgroundColor : (Highcharts.theme && Highcharts.theme.background2)
										|| 'white',
								borderColor : '#CCC',
								borderWidth : 1,
								shadow : true //显示阴影
							},
							tooltip : {
								//	shadow ：true, //提示框阴影,默认为true
								formatter : function() {
									return '<b>' + this.x + '</b><br/>'
											+ this.series.name + ': ' + this.y;
									//+ '<br/>' + 'Total: '
									//+ this.point.stackTotal;
								}
							},
							exporting : { //导出
								enabled : true,
								filename : 'ssss'
							},
							plotOptions : {
								column : {
									stacking : 'normal',
									cursor : 'pointer',//鼠标放在柱状图上面显示手型
									//allowPointSelect : true,
									point : {
										events : {
											click : function(event) {
												//★添加跳转代码★                     
											//	alert(event.point.category);
												var bureauName = event.point.category;
												var bureauValue;
												switch (bureauName) {
												case "新疆":
													bureauValue = "ZWWW";
													break;
												case "西北":
													bureauValue = "ZLXY";
													break;
												case "西南":
													bureauValue = "ZUUU";
													break;
												case "华北":
													bureauValue = "ZBAA";
													break;
												case "华东":
													bureauValue = "ZSSS";
													break;
												case "中南":
													bureauValue = "ZGGG";
													break;
												case "东北":
													bureauValue = "ZYTX";
													break;
												case "北京网控中心":
													bureauValue = "ZBBB";
													break;
												case "上海网控中心":
													bureauValue = "ZSPD";
													break;
												case "境外":
													bureauValue = "OVERSEAS";
													break;
												default:
													bureauValue = "错误";
												};
											//	alert(bureauValue);
												$.ajax({
															url : "${rootUrl}networkstat/atmService.dox",
															data : "bureau="
																	+ bureauValue,
															dataTye : "html",
															success : function(msg) {
																$('#atmService').html(msg);
															},
															error : function(msg){
																$('#atmService').html(msg);
															}
														});

											}
										}
									},
									dataLabels : {
										enabled : true,
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
								enabled : false
							},
							series : typeNumObjArr
						});
		},
		error: function(msg){
			
			alert(msg);
		}
	});
	
	//ATM全网端口统计（堆叠柱状图）
	$.ajax({
		url:"${rootUrl}networkstat/initAtmPnni.dox",
		dataType : "json",
		success : function(dataStatus){
			var bureauArr = new Array();
			var AXSMT1E1Arr = new Array();
			var AXSMOC3Arr = new Array();
			var AXSMXGArr = new Array();
			var AXSMT3E3Arr = new Array();
			var PXM155Arr = new Array();
			var PXMT1E1Arr = new Array();
			var FRSMArr = new Array(); 
			var CESMArr = new Array();
			var MPSMArr = new Array();
			var MPSMFRMArr = new Array();
			$.each(dataStatus,function(key,val){
				var bureau = val.bureau;
				var portType = val.type.name;
				var count = val.totalCount;
				var flag = false;
				for(var i=0;i<bureauArr.length;i++){
					if(bureauArr[i]==bureau){
						flag = true;					
					}
				}
				if(!flag){
					bureauArr.push(val.bureau);
					var newIndex = bureauArr.length-1;
					AXSMT1E1Arr[newIndex]=0;
					AXSMOC3Arr[newIndex]=0;
					AXSMXGArr[newIndex]=0;
					AXSMT3E3Arr[newIndex]=0;
					PXM155Arr[newIndex]=0;
					PXMT1E1Arr[newIndex]=0;
					FRSMArr[newIndex]=0; 
					CESMArr[newIndex]=0;
					MPSMArr[newIndex]=0;
					MPSMFRMArr[newIndex]=0;
					switch (portType){
					case "AXSMT1E1":
						AXSMT1E1Arr[newIndex]=count;
						break;
					case "AXSMOC3":
						AXSMOC3Arr[newIndex]=count;
						break;
					case "AXSMXG":
						AXSMXGArr[newIndex]=count;
						break;
					case "AXSMT3E3":
						AXSMT3E3Arr[newIndex]=count;
						break;
					case "PXM155":
						PXM155Arr[newIndex]=count;
						break;
					case "PXMT1E1":
						PXMT1E1Arr[newIndex]=count;
						break;
					case "FRSM":
						FRSMArr[newIndex]=count;
						break;
					case "CESM":
						CESMArr[newIndex]=count;
						break;
					case "MPSM":
						MPSMArr[newIndex]=count;
						break;
					case "MPSMFRM":
						MPSMFRMArr[newIndex]=count;
						break;
					default:
				}
				}else{
					var newIndex = bureauArr.length-1;
					switch (portType){
					case "AXSMT1E1":
						AXSMT1E1Arr[newIndex]=count;
						break;
					case "AXSMOC3":
						AXSMOC3Arr[newIndex]=count;
						break;
					case "AXSMXG":
						AXSMXGArr[newIndex]=count;
						break;
					case "AXSMT3E3":
						AXSMT3E3Arr[newIndex]=count;
						break;
					case "PXM155":
						PXM155Arr[newIndex]=count;
						break;
					case "PXMT1E1":
						PXMT1E1Arr[newIndex]=count;
						break;
					case "FRSM":
						FRSMArr[newIndex]=count;
						break;
					case "CESM":
						CESMArr[newIndex]=count;
						break;
					case "MPSM":
						MPSMArr[newIndex]=count;
						break;
					case "MPSMFRM":
						MPSMFRMArr[newIndex]=count;
						break;
						default:
					}
				}
			});
		//	alert(bureauArr);
		//	alert(axsmArr);
		//	alert(frsmArr);
			$('#stackedContainerPort')
				.highcharts(
						{
							chart : {
								type : 'column',
								borderWidth : 0, //设置图表边框宽度
								plotBorderWidth : 1,//主图表边框宽度
								shadow : true,
								//margin : [ 40, 140, 30, 60 ],
								width : 550
							},
							title : {
								text : '<b>ATM数据网端口统计</b>'
							},
							subtitle : {
							//  text: '子标题。。。。'
							},
							xAxis : {
								categories : bureauArr,
								labels : {
									allowPointSelect : true,
									rotation : -45,
									aligh : 'center',
									//step : 1,
									y : 15,
									x : 10,
									//allowPointSelect : true,
									//cursor : 'pointer',
									formatter : function(){
										//alert("aaa");
										return '<a href="javascript:alert(\'hello\')">'+this.value+'</a>';
									}
								},
								lineWidth : 1	//基线宽度
							},
							yAxis : {
								min : 0,	//不显示负数
								allowDecimals : false,//不显示小数
								lineWidth : 1, //基线宽度
								tickInterval : 50,//Y轴值按5来等分
								title : {
									text : '端口数量'
								},
								stackLabels : {
									enabled : true,//控制柱形顶端的数字是否显示
									style : {
										fontWeight : 'bold',
										color : (Highcharts.theme && Highcharts.theme.textColor)
												|| 'gray'
									}
								}
							},
							legend : {
								layout : 'vertical',//竖直显示，默认是水平显示
								align : 'right',	//图例说明在区域的右边，默认是在中间
								verticalAlign : 'middle',//竖直方向居中，默认是在底部
/* 								floating : true, //集合x,y实现位置浮动
								x : 0,
								y : 60, */
								backgroundColor : (Highcharts.theme && Highcharts.theme.background2)
										|| 'white',
								borderColor : '#CCC',
								borderWidth : 1,
								shadow : true	//显示阴影
							},
							tooltip : {
								//	shadow ：true, //提示框阴影,默认为true
								formatter : function() {
									return '<b>' + this.x + '</b><br/>'
											+ this.series.name + ': ' + this.y;
								}
							},
							exporting : { //导出(好像不管用)
								enabled : true,
								filename : 'ssss'
							},
							plotOptions : {
								column : {
									stacking : 'normal', //控制堆叠方式
									cursor : 'pointer',  //鼠标放在柱状图上面显示手型
									//	allowPointSelect : true, //是否允许选中
									point : {
										events : {
											click : function(event) {
												//★添加跳转代码★                     
												var bureauName = event.point.category;
												var bureauValue;
												switch (bureauName) {
												case "新疆":
													bureauValue = "ZWWW";
													break;
												case "西北":
													bureauValue = "ZLXY";
													break;
												case "西南":
													bureauValue = "ZUUU";
													break;
												case "华北":
													bureauValue = "ZBAA";
													break;
												case "华东":
													bureauValue = "ZSSS";
													break;
												case "中南":
													bureauValue = "ZGGG";
													break;
												case "东北":
													bureauValue = "ZYTX";
													break;
												case "北京网控中心":
													bureauValue = "ZBBB";
													break;
												case "上海网控中心":
													bureauValue = "ZSPD";
													break;
												case "境外":
													bureauValue = "OVERSEAS";
													break;
												default:
													bureauValue = "错误";
												};
												$.ajax({
															url : "${rootUrl}networkstat/atmPnni.dox",
															data : "bureau="
																	+ bureauValue,
															dataTye : "html",
															success : function(msg) {
																$('#atmPort').html(msg);
															},
															error : function(msg){
																$('#atmPort').html(msg);
															}
													});
											}
										}
									},
									dataLabels : { //不知道这个dataLabels是干什么用的
										enabled : false,
										color : (Highcharts.theme && Highcharts.theme.dataLabelsColor)
												|| 'white',
										style : {
											textShadow : '0 0 3px black, 0 0 3px black'
										}
									}
								},
								series : {
									borderWidth : 1, //柱子上面不同堆叠区域之间的边框宽度
									dataLabels : {
										enabled : false,          //默认为false，即默认不显示数值
										//color:'#666',            //各堆叠区域上面字体颜色
										align:'center',            //居柱子中间
									    //format: '{point.y:.1f}%' //各堆叠区域上面字体显示风格
									}
								}
							},
							credits : {
								enabled : false   //隐藏右下角的官方链接
							},
							series : [ {
											name : 'AXSMT1E1',
											data : AXSMT1E1Arr
										},{
											name : 'AXSMOC3',
											data : AXSMOC3Arr
										},{
											name : 'AXSMXG',
											data : AXSMXGArr
										},{
											name : 'AXSMT3E3',
											data : AXSMT3E3Arr
										}, {
											name : 'PXM155',
											data : PXM155Arr
										},{
											name : 'PXMT1E1',
											data : PXMT1E1Arr
										}, {
											name : 'FRSM',
											data : FRSMArr
										}, {
											name : 'CESM',
											data : CESMArr
										} , {
											name : 'MPSM',
											data : MPSMArr
										}, {
											name : 'MPSMFRM',
											data : MPSMFRMArr
							}]
				});
			}
		});
		
		//ATM数据网全网告警统计（饼状图）
		$.ajax({
			url:"${rootUrl}networkstat/initAtmAlarm.dox",
			dataType : "json",
			success : function(dataStatus){
				
				$('#pieContainerAlarm').highcharts({
					chart : {
						plotBackgroundColor : null,
						plotBorderWidth : null,
						plotShadow : false,
						shadow : true,
						width : 550
					},
					title : {
						text : '<b>ATM数据网告警统计</b>'
					},
					tooltip : {
						//shadow : true,
						useHTML : true,
						headerFormat : '<table border="0" cellspacing="0" cellpadding="0"><thead><tr>'
						+'<th style="border-bottom:1px solid #6678b1;color:#039;text-align:left;font-size:13px" colspan=3>{point.key}</th>'
						+'</tr></thead>',
						pointFormat : '<tbody><tr>'
								+ '<td style="background-color:red">严重:{point.critical}</td>'
								+ '<td style="background-color:#FFCC33">主要:{point.major}</td>'
								+ '<td style="background-color:#FFFF00">一般:{point.minor}</td>'
								+ '</tr>',
						footerFormat : '</tbody></table>'
					},
					plotOptions : {
						pie : {
							allowPointSelect : true,
							cursor : 'pointer',
							point : {
								events : {
									click : function(event) {
										//★添加跳转代码★                     
										var bureau = event.point.value;
										 $.ajax({
													url : "${rootUrl}networkstat/atmAlarm.dox",
													data : "bureau="
															+ bureau,
													dataTye : "html",
													success : function(msg) {
														$('#atmAlarm').html(msg);
													},
													error : function(msg){
														$('#atmAlarm').html(msg);
													}
												}); 
									}
								}
							},
							dataLabels : {
								enabled : true,
								//format: '<b>{point.name}</b>: {point.percentage:.1f} %',
								format : '<b>{point.name}:</b>{point.y}个',
								style : {
									color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
											|| 'black'
								}
							}
						}
					},
					exporting : {
						enabled : true
					//设置导出按钮可用
					},
					credits : {
						enabled : false
					},
					series : [ {
						type : 'pie',
						name : '严重',
						data :dataStatus
					} ]
				});				
			}
		});
	});
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
						<span class="bold">ATM数据网节点统计</span>
					</div>
				</div>
				<div class="minfo" style="overflow :auto">
				<!--place-->
				<table>
					<tr>
						<td>
							<div class="br">
								<div id="lmsx">
									<div id="container" style="width: 560px; height: 300px" align="center"></div>
								</div>
							</div>
						</td>
						<td>
							<div class="mtab" style="width: 525px; height: 300px;overflow:auto;">
								<div style="margin:7px 0" id="atmEquip"></div>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<!--place-->
				
				<div id="boxplace">
					<div class="place">
						<span class="bold">ATM数据网业务统计</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo" style="overflow :auto">
				<table>
					<tr>
						<td>
							<div class="br">
								<div id="lmsx">
									<div id="stackedContainerBusi" style="width: 560px; height: 300px" align="center"></div>
								</div>
							</div>
						</td>
						<td>
							<div class="mtab" style="width: 525px; height: 300px;overflow:auto;">
								<div style="margin:7px 0" id="atmService"></div>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">ATM数据网端口统计</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo" style="overflow :auto">
				<table>
					<tr>
						<td>
							<div class="br">
								<div id="lmsx">
									<div id="stackedContainerPort" style="width: 560px; height: 300px" align="center"></div>
								</div>
							</div>
						</td>
						<td>
							<div class="mtab" style="width: 525px; height: 300px;overflow:auto;">
								<div style="margin:7px 0" id="atmPort"></div>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">ATM数据网告警统计</span>
					</div>
				</div>
				<div class="minfo" style="overflow :auto">
				<table>
					<tr>
						<td>
							<div class="br">
								<div id="lmsx">
									<div id="pieContainerAlarm"	style="width: 560px; height: 300px" align="center"></div>
								</div>
							</div>
						</td>
						<td>
							<div class="mtab" style="width: 525px; height: 300px;overflow:auto;">
							 	<div style="margin:7px 0" id="atmAlarm"></div>
							</div>
						</td>
					</tr>
				</table>
				</div>
				<!--place-->
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">ATM数据网带宽统计</span>
					</div>
				</div>
				<div class="minfo" style="overflow :auto">
				<div class="mtab" style="width: 1090px; height: 300px;overflow:auto;" align="center">
				 	<div style="margin:7px 0" id="atmBand"></div>
				</div>
				</div>
				<!--place-->
			</div>
		</div>
		<!-- 内容页 -->
	</div>
	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>