<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>未接电话管理</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css"
	type="text/css" rel="stylesheet" />

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
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<!-- hty -->
<script src="${rootUrl }js/echarts/echarts.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
<script type="text/javascript">
	$(function() {
		$("#callendTime").val(new Date().Format("yyyy-MM-dd"));
		$("#date1").hide();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			boxwidth : "600",
			boxheight : "600",
			sortable : true,//是否使用页面排序功能
			sortConfig : { //页面排序的配置
				0 : {
					sorter : "text"
				}
			}
		});
		$("#leave").click(function() {
			$("#date1").show();
			$("#leave").hide();
		});
		//
		$("#queryButton").click(function() {
			var stime=$("#ringingTime").val();
			var etime=$("#pickupTime").val();
			
			$.ajax({
				url:"${rootUrl}phonemng/callcontrol/initCallCount.dox?stime="+stime+"&etime="+etime+"",
				success : function(dataStatus){
					var map = eval("("+dataStatus+")"); 
					intAllCharts(map);
		
					$.ajax({
						url:"${rootUrl}phonemng/callcontrol/initLineCount.dox?stime="+stime+"&etime="+etime+"",
						success : function(dataStatus){
							var map1 = eval("("+dataStatus+")"); 
						
							initLineCharts(map1);
						}
					});
				}
			});
		});
		//////////////////////////////////////////charts1
		$.ajax({
			url:"${rootUrl}phonemng/callcontrol/initCallCount.dox?stime=&etime=",
			success : function(dataStatus){
				  var map = eval("("+dataStatus+")"); 
				  intAllCharts(map);
			       
			}
		});//  ./ajax 
		///////////////////////////////////////pie
		var type=$("#sel_type").val();
		var name=$("#userName").val();
		$.ajax({
			url:"${rootUrl}phonemng/callcontrol/pie.dox?name="+name+"&type="+type+"&date="+$("#callendTime").val()+"",
			success : function(dataStatus){
				  var map = eval("("+dataStatus+")"); 
				  initPieCharts(map);
			       
			}
		});//  ./ajax 
		$("#select_pie").click(function() {
			var type1=$("#sel_type").val();
			var name1=$("#userName").val();
			var date1=$("#callendTime").val();
			$.ajax({
				url:"${rootUrl}phonemng/callcontrol/pie.dox?name="+name1+"&type="+type1+"&date="+date1+"",
				success : function(dataStatus){
					var map = eval("("+dataStatus+")"); 
					initPieCharts(map);
				}
			});
		});
		/////////////////////////////////////////////chart2
		
		/////////////////////////////////////////////Line
		$.ajax({
			url:"${rootUrl}phonemng/callcontrol/initLineCount.dox?stime=&etime=",
			success : function(dataStatus){
				  var map = eval("("+dataStatus+")"); 
				  initLineCharts(map);
			       
			}
		});// ./ajax 
		/////////////////////////////////////////////Line-end
		
	});
	var rootUrl = '${rootUrl }';
	function initLineCharts(map){
		    var myChart = echarts.init(document.getElementById('chart3'));
			var dataval = new Array();
	        var dataname= new Array();
			
	        $.each(map, function(key,
					val) {
	        	dataval.push(val);
	        	dataname.push(key);
            });
			option3 = {
				tooltip: {
					trigger: 'axis',
					position: function (pt) {
						return [pt[0], '10%'];
					}
				},
				title: {
					left: 'center',
					text: '工程师通话时长统计',
				},
				legend: {
					top: 'bottom',
					data:['通话时长']
				},
				toolbox: {
					feature: {
						dataZoom: {
							yAxisIndex: 'none'
						},
						restore: {},
						saveAsImage: {}
					}
				},
				xAxis: {
					type: 'category',
					
					data: dataname
				},
				yAxis: {
					type: 'value',
					boundaryGap: [0, '100%']
				},
				dataZoom: [{
					type: 'inside',
					start: 0,
					end: 100
				}, {
					start: 0,
					end: 10,
					handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
					handleSize: '80%',
					handleStyle: {
						color: '#fff',
						shadowBlur: 3,
						shadowColor: 'rgba(0, 0, 0, 0.6)',
						shadowOffsetX: 2,
						shadowOffsetY: 2
					}
				}],
				series: [
					{
						name:'通话时间（秒）',
						type:'line',
						smooth:true,
						symbol: 'none',
						sampling: 'average',
						itemStyle: {
							normal: {
								color: 'rgb(255, 70, 131)'
							}
						},
						areaStyle: {
							normal: {
								color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
									offset: 0,
									color: 'rgb(255, 158, 68)'
								}, {
									offset: 1,
									color: 'rgb(255, 70, 131)'
								}])
							}
						},
						data: dataval
					}
				]
			};
	myChart.setOption(option3);
	}
	
	function initPieCharts(map){
		
		var datatitle=new Array();
        var dataval=new Array();
       
        //拆外层
        $.each(map, function(key,
					val) {
	         datatitle.push(key);
	         dataval.push(jQuery.parseJSON('{"value":'+val+',"name":"'+key+'"}'));
       	 
        });


        //var dataobj=jQuery.parseJSON(dataval);//jQuery.parseJson(dataval);
        
        var obj = jQuery.parseJSON('{"未接":"0","正常来电":"0","外呼":"2","转接":"3"}');
        //alert(dataval);
		  var myChart = echarts.init(document.getElementById('chart2'));
			option = {
				title : {
					text: '个人统计',
					x:'center'
				},
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					left: 'left',
					data: datatitle
				},
				series : [
					{
						name: '个人统计',
						type: 'pie',
						radius : '55%',
						center: ['50%', '60%'],
						data:dataval,
						itemStyle: {
							emphasis: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: 'rgba(0, 0, 0, 0.5)'
							}
						}
					}
				]
			};
	        myChart.setOption(option);
	}
	function intAllCharts(map){
		var dataname=new Array();
        var dataval="";
        //拆外层
        $.each(map, function(key,
					val) {
       	 dataname.push(key);
       	 dataval=val;
        });
        //拆内层
        var notdail="";
        var normol="";
        var dailout="";
        var transfer="";
        var i=0;
        $.each(dataval, function(key,
					val) {
    	       if(key=="未接"){
    	    	  notdail=val;
    	       }
    	       if(key=="正常来电"){
    	    	  normol=val;
    	       }
    	       if(key=="外呼"){
    	    	  dailout=val;
   	       }
        	   if(key=="转接"){
        		  transfer=val;
      	       }
        });
        //alert(notdail);
        /////////////////////////////////////charts
		 var myChart = echarts.init(document.getElementById('chart1'));
			//app.title = '堆叠条形图';

			option1 = {
				title : {
					text: '电话类型',
					subtext: '个数统计',
					x:'center'
				},
				tooltip : {
					trigger: 'axis',
					axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
					left: 'left',
					data: ['未接', '正常来电','外呼','转接']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis:  {
					type: 'value'
				},
				yAxis: {
					type: 'category',
					data: dataname
				},
				series: [
					{
						name: '未接',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: notdail
					},
					{
						name: '正常来电',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: normol
					},
					{
						name: '外呼',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: dailout
					},
					{
						name: '转接',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: transfer
					}
				]
			};
			 myChart.setOption(option1);
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
						<span class="bold">统计</span>
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
								<div class="bclear"></div>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}phonemng/callcontrol/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div>
									  	<iframe
										src="${rootUrl}js/edb_monitor/phoneBar/softphone.html"
										height="620px" style="width: 100%" frameborder="0"></iframe>
									</div>
									<div class="boxbtn">
										<div class="info">
										
											时间：
											  <input readonly="true" id="ringingTime"
											name="ringingTime" size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'pickupTime\')}'})">至
											
											<input readonly="true" id="pickupTime" name="pickupTime"
											size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({minDate:'#F{$dp.$D(\'ringingTime\')}'})">

										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

									<div class="mtab1">
										 <!-- 
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />图表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table> --> 
										<div class="panel panel-default">
										   <div class="panel-heading">
										             图表
										   </div>
										   <div class="panel-body">
										        <div class="row">
										           <div class="col-md-12">
										              <div style="width:100%;height:400px;" id="chart1"></div>
										           </div>
										        </div>
										        <div class="row">
										           <div class="col-md-12">
										              <div style="width:100%;height:400px;" id="chart3"></div>
										           </div>
										        </div>
										        <div class="row">
										           <div class="col-md-4">
										              <div class="panel panel-default">
										                   <div class="panel-body">
										                      <table width="100%">
										                        <tr>
										                           <td colspan="2">
										                              <br/>
										                           </td>
										                         </tr>
										                        <tr>
										                          <td style="width:25%" class="text-right">
										                                                                       工程师：
										                          </td>
										                          <td>
										                            <form:select path="userName" id="userName" style="width:90%;height:26px">
												                        <form:options items="${names}" />
												                      </form:select>
										                          </td>
										                        </tr>
										                         <tr>
										                           <td colspan="2">
										                              <br/>
										                           </td>
										                         </tr>
										                        <tr>
										                           <td style="width:25%" class="text-right">
										                                                                       时间：
										                          </td>
										                          <td>
										                           <input readonly="true" id="callendTime" style="width:89%"
																		name="callendTime" size="15" maxlength="18" class="Wdate"
																		onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'pickupTime\')}'})">
										                          </td>
										                        </tr>
										                        <tr>
										                           <td colspan="2">
										                              <br/>
										                           </td>
										                         </tr>
										                         <tr>
										                           <td style="width:25%" class="text-right">
										                                                                      类型：
										                          </td>
										                          <td>
										                             <select id="sel_type" style="height:26px;">
										                               <option value="0">按个数</option>
										                               <option value="1">按通话时间</option>
										                             </select>
										                          </td>
										                        </tr>
										                        <tr>
										                           <td colspan="2">
										                              <br/>
										                           </td>
										                         </tr>
										                         <tr>
										                           <td colspan="2"  >
										                              <a href="#" class="btn" id="select_pie" >查询</a>
										                           </td>
										                         </tr>
										                      </table><!-- /.table -->
										                      
										                   </div><!-- /.panel-body -->
										               </div><!-- /.panel -->
										           </div><!-- /.col-md-4 -->
										           <div class="col-md-8" style="width:64.99999999%">
										               <div style="width:100%;height:400px;" id="chart2"></div>
										               
										           </div>
										        </div>
										   </div>
										</div>
										<!--查询结果-->
										
										<!--查询结果-->
									  
									</div><!-- /.mtab -->
								</form:form>
							</div><!-- /.lmsx -->
						</div><!-- /.br -->
					</div><!-- /.bl -->
				</div><!-- /.minfo -->
			</div><!-- /.main -->
		</div><!-- /.boxright -->
		<!-- 内容页 -->
	</div>




	

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>

	<!-- 版权页 -->
</body>
</html>