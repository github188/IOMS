<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/windows.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


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

<script type="text/javascript">
	$(function() {

		$("#queryResult").manage({
			pagerUrl : true,
			view : true,
			add : true,
			edit : true,
			remove : true,
			sortable : false,
			noteInfo : "#errInfo"
		});
		$("#listForm").validate({
			rules : {
				kuRxLevelTopQM : {
					digit : true,
					maxlength : 10
				},
				kuRxLevelLowQM : {
					digit : true,
					maxlength : 10
				}
			},
			submitHandler : function() {
				parent.searchSubmit();
			}
		});

		$
				.ajax({

					url : "${rootUrl}operstat/ku/node/chart.dox?id="
							+ $("#kuNodeStatusStatId").val(),
					dataType : "json",
					success : function(dataStatus) {

						var normaldata = new Array();
						var overdata = new Array();
						normaldata.push(dataStatus.statusNormal);
						normaldata.push(dataStatus.rxLevelNormal);
						normaldata.push(dataStatus.ebnoNormal);
						overdata.push(dataStatus.statusOver);
						overdata.push(dataStatus.rxLevelOver);
						overdata.push(dataStatus.ebnoOver);

						$("#statDate").html("记录时间:" + dataStatus.statDate);

						$('#nodeStatChart')
								.highcharts(
										{
											chart : {
												type : 'column'
											},
											title : {
												text : '统计'
											},
											xAxis : {
												categories : [ 'Status',
														'RxLevel', 'Eb/No' ]
											},
											yAxis : {
												min : 0,
												step : 1,
												title : {
													text : '节点个数'
												}
											},
											credits : {
												enabled : false
											},
											tooltip : {
												headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
												pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
														+ '<td style="padding:0"><b>{point.y} </b></td></tr>',
												footerFormat : '</table>',
												shared : true,
												useHTML : true
											},
											plotOptions : {
												column : {
													pointPadding : 0.2,
													borderWidth : 0
												}
											},
											series : [ {
												name : '正常节点数',
												data : normaldata

											}, {
												name : '异常节点数',
												data : overdata

											} ]
										});
					}
				});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
	function check(){
		var rl = $("#kuRxLevelLowQM").val();
		var rt = $("#kuRxLevelTopQM").val();
		if(true == ((rl-rt)>0)){
			alert("输入的上限值小于下限值，请核对后再查询！")
			listForm.reset();
		}
		var el = $("#KuEbNoLowQM").val();
		var et = $("#KuEbNoTopQM").val();
		if(true == ((el-et)>0)){
			alert("输入的上限值小于下限值，请核对后再查询！")
			listForm.reset();
		}
	}
</script>



</head>
<body style="overflow-x: hidden">
	<div class="window">
		<script src="${rootUrl }js/highchart/highcharts.js"
			type="text/javascript"></script>
		<script src="${rootUrl }js/highchart/highcharts-more.js"
			type="text/javascript"></script>


		<!-- 内容页 -->

		<div id="main">
			<!--place-->
			<div id="boxplace">
				<div class="place">
					<span class="bold">KU节点运行状态 </span> <span style="float: right"><a
						href="#none" class="close"><img
							src="${rootUrl }images/close.png" alt="关闭" /></a></span>

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
								name="listForm" action="${rootUrl}operstat/ku/node/manage.do"
								method="post">
								<!-- 查询条件 -->
								<div class="boxbtn">
									<div class="info">
										节点号：
										<form:input path="kuNodeNoLike" cssStyle="width:100px;" />
										Status：
										<form:select path="kuStatusStandardQM" cssStyle="width:100px;">
											<form:option value="">全部</form:option>
											<form:option value="UP">UP</form:option>
											<form:option value="DOWN">DOWN</form:option>
										</form:select>
										RxLevel：
										<form:input id="kuRxLevelLowQM" path="kuRxLevelLowQM" cssStyle="width:100px;" />
										至
										<form:input id="kuRxLevelTopQM" path="kuRxLevelTopQM" cssStyle="width:100px;"/>
										<div class="clear"></div>
										Eb/No：&nbsp;
										<form:input path="KuEbNoLowQM" cssStyle="width:100px;" />
										至
										<form:input path="KuEbNoTopQM" cssStyle="width:100px;" />
										<form:hidden path="kuNodeStatusStatId" />
										<div class="bclear"></div>
										<div class="bclear"></div>
									</div>
									<a href="#none" class="sbtn" id="queryButton" onclick = check()>查询</a> <a
										href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
								</div>
								<div class="bclear"></div>
								<!-- 查询条件 -->
								<div id="nodeStatChart"
									style="min-width: 100px; height: 300px; margin: 0 auto"></div>
								<div class="mtab">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										class="title">
										<tr>
											<td class="td1" style="width: 180px;"><img
												src="${rootUrl}images/pl1.gif" alt="" />KU运行统计列表</td>
											<td class="td1" style="width: 280px; align: right;"
												id="statDate"></td>
											<td class="td2" id="errInfo"></td>
										</tr>
									</table>
									<!--查询结果-->

									<div id="queryResult"></div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 内容页 -->
	</div>
</body>
</html>