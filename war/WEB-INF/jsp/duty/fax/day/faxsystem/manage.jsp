<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>转报巡检-日检</title>
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
<script src="${rootUrl }js/left-tree-menu.js" type="text/javascript"></script>
<script type="text/javascript">
	var $tabs;
	$(function() {
		$tabs = $("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : false,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				1 : {
					sorter : 'text',
				},
				2 : {
					sorter : 'text',
				},
				3 : {
					sorter : 'text',
				},
				4 : {
					sorter : 'text',
				},
				5 : {
					sorter : 'text',
				},
				6 : {
					sorter : 'text',
				}
			}
		});
		$("#tabs").tabs({
			select : function(event, ui) {
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
		loadCount('PROCESS');
		loadCount('HARDWARE');
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));
	});
	var rootUrl = '${rootUrl }';
	function loadCount(optType) {
		if(optType=='PROCESS'){
		
			$("#title").html("转报系统硬件检查");
		}
	    if(optType=='HARDWARE'){
			
			$("#title").html("转报系统进程检查");
		}
		$.ajax({
					optType : "GET",
					//url : "${rootUrl}tempcircuit/count.dox",
					data : {
						optType : optType
					},
					dataType : "json",
					success : function(result) {
						$("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result + "</div>");
					}
				});
	}
	function change(optType) {
		$("#optType").val(optType);
		loadCount('PROCESS');
		loadCount('HARDWARE');

		var q = $("#queryResult");
		//页面查询条件控制

	}
</script>

</head>

<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<!-- LOGO -->
	<div id="boxmain">
		<!-- 左侧菜单 -->
		<%@ include file="/WEB-INF/jsp/duty/menu/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">转报系统日检</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}duty/fax/day/faxsystem/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />


									<div class="bclear"></div>
									<div class="boxbtn">
										<a href="${rootUrl}duty/fax/day/faxsystem/add.do"
											class="my_add {boxwidth:1200,boxheight:1000} btn"> <img
											src="${rootUrl}images/btn/new.gif" />添加
										</a>
									</div>
									<div class="bclear"></div>
									<div class="boxbtn">
										<div id="info" class="info" style="height: 50px">

											<table style="width: 100%">
												<tr>
													<td colspan="2">操&nbsp&nbsp作&nbsp&nbsp人： <form:input
															path="operator" size="15" maxlength="50"
															cssStyle="width:120px" /> 审&nbsp&nbsp核&nbsp&nbsp人： <form:input
															path="username" size="15" maxlength="50"
															cssStyle="width:120px" />
													</td>
												</tr>
												<tr>
													<td colspan="2">&nbsp;</td>
												</tr>
												<tr>
													<td>巡检时间： <form:input
															cssStyle="width:180px ; color:#000" path="startOptTime"
															cssClass="inputDate" readonly="true"
															onfocus="WdatePicker({el:$dp.$('startOptTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endOptTime\\')}'});" />
														<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('startOptTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endOptTime\')}'});"
														style="cursor: pointer;" />&nbsp&nbsp&nbsp&nbsp&nbsp至&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
														<form:input cssStyle="width:180px ; color:#000"
															path="endOptTime" cssClass="inputDate" readonly="true"
															onfocus="WdatePicker({el:$dp.$('endOptTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startOptTime\\')}'});" />
														<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('endOptTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startOptTime\')}'});"
														style="cursor: pointer;" />





													</td>
													<td><a href="#none" class="btn" id="queryButton">查询</a>
														<a href="#none" class="btn" onclick="listForm.reset();">重置</a>
													</td>
												</tr>

											</table>




										</div>


									</div>
									<div class="bclear"></div>
									<div class="bclear"></div>
									<div id="tabs">
										<ul>
											<li id="HARDWARE" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('HARDWARE');">转报系统硬件检查</a></li>
											<li id="PROCESS" style="position: relative;"><a
												id="queryButton" href="#tabs-1" onclick="change('PROCESS');">转报系统进程检查</a></li>

										</ul>
										<div id="tabs-1">

											<div class="clear"></div>

											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />转报系统巡检</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<!--查询结果-->
												<div id="queryResult"></div>
												<!--查询结果-->
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
	<input id="pro" value='fax' style="display: none"></input>
	<input id="kind" value='day' style="display: none"></input>
	<input id="item" value='item_faxsystem' style="display: none"></input>
</body>