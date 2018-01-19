<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />

<script>
	$(function() {
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
		$.ajax({
			url : '${rootUrl}operstat/ku/service/chart.do?ids='
					+ $('#ids').val(),
			dataType : 'json',
			type : "POST",
			success : function(response) {
				$(function() {
					var chart = new Highcharts.Chart({
						chart : {
							renderTo : 'cxrChart',//放置图表的容器  
							plotBackgroundColor : null,
							plotBorderWidth : null,
							defaultSeriesType : 'line', //图表类型line, spline, area, areaspline, column, bar, pie , scatter   
							width : 850,
							height : 580,
						},
						credits : {
							enabled : false
						},
						title : {
							text : 'KU电路配置载波图',
							x : -20
						//center
						},
						xAxis : {
							min : 0,
							lineWidth : 2,
							title : {
								text : '时间'
							},
						},
						yAxis : {
							min : -1,
							max : 31,
							step : 1,
							lineWidth : 2,
							title : {
								text : '载波'
							},
							labels : {
								step : 1,
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ],
							categories : []
						},
						tooltip : {
							formatter : function() {
								return '<b>电路编码:' + this.series.name
										+ '</b><br/> <b>载波:' + this.y
										+ '</b><br/><b>时间:' + this.x + '</b>';
							}

						},
						plotOptions : {
							line : {
								lineWidth: 4,
								marker : {
									enabled : false
								}
							}
						},
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'top',
							x : -10,
							y : 100,
							borderWidth : 0
						},
						series : response
					});
				});
			}
		});
	});
</script>
</head>
<body>
	<script src="${rootUrl }js/highchart/highcharts.js"
		type="text/javascript"></script>
	<input type="hidden" id="ids" value="${ids }" />
	<div class="window">
		<dl class="title">
			<dd>KU电路配置载波图</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div id="cxrChart"
			style="min-width: 850px; height: 600px; margin: 0 auto"></div>
		<div id="555" style="position: relative;">
			<font color="red">注：若该条业务无生成载波图所需相关信息，则显示在-1处。</font>
		</div>
	</div>
</body>
</html>