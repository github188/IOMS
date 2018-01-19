<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KU网络运行统计</title>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jquery/themes/default/style.css" />
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
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js"
	type="text/javascript"></script>


<script type="text/javascript">
	function createStatChart(){
		if($("#kuStatType").val()!="STAT"){
			return;
		}
		var yCatigories = [];
		var datas1 = [];
		var datas2 = [];
		var datas3 = [];
		$("#queryResult tbody tr").each(function(){
			yCatigories.push($(this).find("td").eq(0).html());
			datas1.push(parseInt($(this).find("td").eq(2).html()));
			datas2.push(parseInt($(this).find("td").eq(4).html()));
			datas3.push(parseInt($(this).find("td").eq(6).html()));
		});
		var r_yCatigories = [];
		var r_datas1 = [];
		var r_datas2 = [];
		var r_datas3 = [];
		for(var i=yCatigories.length-1;i>=0;i--){
			r_yCatigories.push(yCatigories[i]);
			r_datas1.push(datas1[i]);
			r_datas2.push(datas2[i]);
			r_datas3.push(datas3[i]);
		}
		$(function() {
			var chart = new Highcharts.Chart({
				chart : {
					renderTo : 'netStatChart',//放置图表的容器  
					plotBackgroundColor : null,
					plotBorderWidth : null,
					defaultSeriesType : 'line' //图表类型line, spline, area, areaspline, column, bar, pie , scatter   
				},

				title : {
					text : 'KU网络运行统计图',
					x : -20
				//center 
				},
				xAxis : {
					tickInterval : 3,
					categories : r_yCatigories,
					labels : {
						rotation : -60,
					}

				},
				yAxis : {
					title : {
						text : '异常节点个数'
					},
					min:0,
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [ {
					name : 'Status',
					data : r_datas1
				}, {
					name : 'RxLevel',
					data : r_datas2
				}, {
					name : 'Eb/No',
					data : r_datas3
				} ],
				credits : {
					enabled : false
				},
				plotOptions : {
					series : {
						cursor : 'pointer',
						events : {
							click : function(event) {
								alert(this.name + ":"
										+ event.point.y + "");
							}
						}
					}
				}
			});
		});
	}
	$(function() {
		$("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			view:true,
			add : true,
			edit : true,
			remove : true,
			boxwidth : "500",
			boxheight : "250",
			sortable : false,
			searchCallback:createStatChart,
		});
		$("#serviceChartBtn").click(
				function() {
					if ($(":checkbox:checked").length == 0) {
						alert("请选择业务");
						$("#serviceChartBtn").attr("href","");
						//this.$.nyroModalRemove();
						return;
					}
					if ($(":checkbox:checked").length > 101) {
						alert("最多只能选择100条，您选择了" + $(":checkbox:checked").length
								+ "条");
						$("#serviceChartBtn").attr("href","");
						//this.$.nyroModalRemove();
						return;
					}
					var idsStr = "";

					$(":checkbox:checked").each(function(index, item) {
						idsStr = idsStr + $(this).val() + ",";

					});
					$("#serviceChartBtn").attr(
							"href",
							"${rootUrl }operstat/ku/service/chart.do?ids="
									+ idsStr);
				});
		changeTab($("#kuStatType").val());
	});
	function changeTab(optType){
	    if(optType=='STAT'){
	    	$("#statQM").show();
	    	$("#cxrChartBtn").hide();
	    	$("#serviceQM").hide();
	    	$("#netStatChart").show();
	    	$("#listForm").attr("action","${rootUrl}operstat/ku/stat/manage.do");
		}
		if(optType=='SERVICE'){
			$("#statQM").hide();
			$("#cxrChartBtn").show();
	    	$("#serviceQM").show();
			$("#netStatChart").hide();
			$("#listForm").attr("action","${rootUrl}operstat/ku/service/manage.do");
		}
	}
</script>



</head>
<body>
	<script src="${rootUrl }js/highchart/highcharts.js"
		type="text/javascript"></script>
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
						<span class="bold">KU网络运行统计</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<input type="hidden" id="kuStatType" value="${kuStatType}" />
								<div class="clear"></div>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}operstat/ku/stat/manage.do"
									method="post">
									<!-- 查询条件 -->

									<div id="tabs">
										<ul>
											<sec:authorize ifAnyGranted="${jspAuthorities['tesstat']}">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['kunodestatusstat']}">
													<li id="take2" style="position: relative;"><a
														id="queryButton" href="#tabs-1"
														onclick="changeTab('STAT');">KU网络运行统计</a></li>
												</sec:authorize>
											</sec:authorize>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['kuserviceinfo']}">
												<li id="take3" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="changeTab('SERVICE');">KU电路配置</a></li>
											</sec:authorize>
											<sec:authorize ifAnyGranted="${jspAuthorities['tesnode']}">
											</sec:authorize>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<div class="boxbtn">
												<div class="info">
													<div class="info" id="statQM">
														日期：
														<form:input cssStyle="width:150px" path="startTime"
															cssClass="inputDate" readonly="true"
															onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
														<img src="${rootUrl}images/datePicker.gif"
															onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
															style="cursor: pointer;" /> 至
														<form:input cssStyle="width:150px" path="endTime"
															cssClass="inputDate" readonly="true"
															onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
														<img src="${rootUrl}images/datePicker.gif"
															onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
															style="cursor: pointer;" />
													</div>
													<div class="info" id="serviceQM">
														电路名：
														<form:input path="codeLike" size="10" maxlength="50" />
														发端节点号：
														<form:input path="txNodeNoLike" size="10" maxlength="50" />
														收端节点号：
														<form:input path="rxNodeNoLike" size="10" maxlength="50" />
														电路速率：
														<form:select path="rateType" cssStyle="width:105px">
															<form:option value="">-请选择-</form:option>
															<form:options items="${kuServiceRateTypes}"
																itemLabel="value" />
														</form:select>
														<div class="bclear"></div>
														完&nbsp;&nbsp;&nbsp;&nbsp;整：
														<form:select path="complete" style="width:75px;">
															<form:option value="">-请选择-</form:option>
															<form:option value="true">是</form:option>
															<form:option value="false">否</form:option>

														</form:select>
														每页显示条数：
														<form:select path="pageSize">
															<form:option value="10">10</form:option>
															<form:option value="20">20</form:option>
															<form:option value="50">50</form:option>
															<form:option value="100">100</form:option>
														</form:select>
													</div>

												</div>
												<div class="bclear"></div>
												<a href="#none" class="sbtn" id="queryButton">查询</a> <a
													href="#none" class="sbtn" onclick="listForm.reset();">重置</a>

												<sec:authorize
													ifAnyGranted="${jspAuthorities['kuservice_cxrchart']}">
													<div id="cxrChartBtn">
														<a href="#" id="serviceChartBtn"
															class="my_view{boxwidth:880,boxheight:700} btn"><img
															src="${rootUrl}images/btn/fb.gif" />载波图</a>
													</div>
												</sec:authorize>

											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->

											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1" style="width: 180px;"><img
															src="${rootUrl}images/pl1.gif" alt="" />KU运行统计列表</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<!--查询结果-->
												<div id="netStatChart"
													style="min-width: 400px; height: 300px; margin: 0 auto"></div>

												<div id="queryResult" style="overflow:auto;border-right:1px solid #95BDD7;border-left:1px solid #95BDD7"></div>
												<!--查询结果-->
												<br /> <br />
											</div>
										</div>
									</div>
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
</body>
</html>