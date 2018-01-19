<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TES网络运行状态</title>
<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jquery/themes/default/style.css" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css" type="text/css" rel="stylesheet" />

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
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js" type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js" type="text/javascript"></script>


<script type="text/javascript">
	var sType = '${optType}';
	$(function() {
		$("#tabs").tabs();
		$("#queryResult").manage({
			pageForm : '#listForm',
			pagerButton : '#queryButton',
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			searchCallback:createStatChart,
			popupRemoveCallback:function(){
				tooldef(sType);
			}
		});
		tooldef(sType);
	});
	function createStatChart(){
		createChart();
	}
	function tooldef(optType){
	    if(optType=='STAT'){
		    $('#info1').show();
		    $('#info2').hide();
		    $('#info3').hide();
		}
		if(optType=='NODE'){
		    $('#info1').hide();
		    $('#info2').show();
		    $('#info3').hide();
		}
		if(optType=='LOG'){
		    $('#info1').show();
		    $('#info2').hide();
		    $('#info3').show();
		}
	}
	function change(optType) {
		$("#optType").val(optType);
		tooldef(optType);
		$("#startStatTime").val('');
		$("#endStatTime").val('');
		$("#circuitNameLike").val('');
		$("#activeNodeCodeLike").val('');
		$("#passiveNodeCodeLike").val('');
		$("#tesnode").val('');
		$("#cu").val('');
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
						<span class="bold">TES网络运行状态</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}operstat/tes/tab/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<div class="clear"></div>
									<div id="tabs">
										<ul >
											<sec:authorize ifAnyGranted="${jspAuthorities['tesstat']}">
											<li style="position: relative;"><a
												id="queryButton" href="#tabs-1" 
												onclick="change('STAT');" >TES异常状态统计</a>
											</li>
											</sec:authorize>
											<li style="position: relative;"><a
												id="queryButton" href="#tabs-1" 
												onclick="change('NODE');" >配置TES电路备注</a>
											</li>
											<li style="position: relative;"><a
												id="queryButton" href="#tabs-1" 
												onclick="change('LOG');" >TES历史日志</a>
											</li>
											<sec:authorize ifAnyGranted="${jspAuthorities['tesnode']}"></sec:authorize>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div id="searchTool" class="boxbtn" >
												<div class="info" id='info1'>
													采集时间：
													<input readonly="true" id="startStatTime" name="startStatTime" size="15" maxlength="18" class='Wdate' onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endStatTime\')}'})"/>-
													<input readonly="true" id="endStatTime" name="endStatTime" size="15" maxlength="18" class='Wdate' onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startStatTime\')}'})" />
													记录数：
													<select name="pageSize">
														<option value="10">10</option>
														<option value="20">20</option>
														<option value="50">50</option>
														<option value="100">100</option>
													</select>
												</div>
												<div class="info" id='info2'>
													电路名：
													<form:input path="circuitNameLike" size="10" maxlength="50" />
													主叫机箱号：
													<form:input path="activeNodeCodeLike" size="10" maxlength="50" />
													被叫机箱号：
													<form:input path="passiveNodeCodeLike" size="10" maxlength="50" />
		
												</div>
												<div class="info" id='info3'>
													机箱号：
													<form:input path="tesnode" size="10" maxlength="50" />
													槽位号：
													<form:input path="cu" size="10" maxlength="50" />
												</div>
												<a href="#none" class="sbtn" id="queryButton">查询</a> 
												<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />信息记录</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<div id="queryResult"></div>
											</div>
											<br />
											<br />
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