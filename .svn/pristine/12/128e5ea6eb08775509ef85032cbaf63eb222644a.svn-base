<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>故障申报处理</title>
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

<script type="text/javascript">
var $tabs;
	$(function() {
		//Tab分页功能实现必须添加的部分
		$tabs = $("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable:true,//是否使用页面排序功能
			sortConfig:{  //页面排序的配置
				0: {sorter: "text"}, 
				6: {sorter: false},
				7: {sorter: false}
			},
			//Tab页内操作元素结束后的回调函数
			popupRemoveCallback:function(){
				loadTask1();
				loadTask2();
				loadTask3();
				loadTask4();
				loadTask5();
			}
		});
		
		//进入页面 统计不同Tab页待操作的记录条数
		loadTask1();
		loadTask2();
		loadTask3();
		loadTask4();
		loadTask5();
		
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select',parseInt(index));
		
		//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
		$("#tabs").tabs({
			select:function(event,ui){
/* 				alert(ui.index);
				alert(ui.panel);
				alert(ui.tab); */
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
	});
	function loadTask1() {
		$.ajax({
					type : "GET",
					url : "${rootUrl}techsupport/fault/deal/ajaxLoad.dox",
					data : {
						type : 'TAKE'
					},
					dataType : "json",
					success : function(result) {
						$("#take1")
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result.totalCount + "</div>");
					}
				});
	}
	function loadTask2(){
		$.ajax({
			type : "GET",
			url : "${rootUrl}techsupport/fault/deal/ajaxLoad.dox",
			data : {
				type : 'DUTY_SOLVE'
			},
			dataType : "json",
			success : function(result) {
				
				$("#take2")
						.append(
								"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
										+ result.totalCount + "</div>");
			}
		});
	}
	function loadTask3(){
		$.ajax({
					type : "GET",
					url : "${rootUrl}techsupport/fault/deal/ajaxLoad.dox",
					data : {
						type : 'MANAGER_SOLVE'
					},
					dataType : "json",
					success : function(result) {
						
						$("#take3")
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result.totalCount + "</div>");
					}
				});
	}
	function loadTask4(){
		$.ajax({
			type : "GET",
			url : "${rootUrl}techsupport/fault/deal/ajaxLoad.dox",
			data : {
				type : 'ENGINEER_SOLVE'
			},
			dataType : "json",
			success : function(result) {
				
				$("#take4")
						.append(
								"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
										+ result.totalCount + "</div>");
			}
		});
	}
	function loadTask5(){
		$.ajax({
			type : "GET",
			url : "${rootUrl}techsupport/fault/deal/ajaxLoad.dox",
			data : {
				type : 'CONFIRMWARN'
			},
			dataType : "json",
			success : function(result) {
				$("#take5")
						.append(
								"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
										+ result.totalCount + "</div>");
			}
		});
	}
	
	//点击某个Tab页时更新所有Tab页中的待处理条数
	function change(optType) {
		$("#optType").val(optType);
 	 	loadTask1();
		loadTask2();
		loadTask3();
		loadTask4();
		loadTask5();
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
						<span class="bold">故障申报处理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>

								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}techsupport/fault/deal/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="optType" path="optType"/>

									<!-- 查询条件 -->
									<form:hidden id="index" path="index"/>
									<div id="tabs" style="padding-bottom:23px">
										<ul>
											<sec:authorize ifAnyGranted="${jspAuthorities['take_tab']}">
												<li id="take1" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('TAKE');">接单 </a></li>
											</sec:authorize>
											<sec:authorize ifAnyGranted="${jspAuthorities['duty_solve_tab']}">
												<li id="take2" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('DUTY_SOLVE');">值班员解决</a>
												</li>
											</sec:authorize>
											<%-- <sec:authorize ifAnyGranted="${jspAuthorities['change']}">
												<li id="take3" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('CHANGE');">转咨询</a>
												</li>
											</sec:authorize>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['dutytransfer']}">
												<li id="take4" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('DUTYTRANSFER');">值班员移交</a></li>
											</sec:authorize>
											<sec:authorize ifAnyGranted="${jspAuthorities['dutyassign']}">
												<li id="take5" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('DUTYASSIGN');">值班员分配</a></li>
											</sec:authorize> --%>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['manager_solve_tab']}">
												<li id="take3" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('MANAGER_SOLVE');">值班经理解决</a></li>
											</sec:authorize>
	<%-- 										<sec:authorize
												ifAnyGranted="${jspAuthorities['managerassign']}">
												<li id="take7" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('MANAGERASSIGN');">值班经理分配</a></li>
											</sec:authorize> --%>
											<sec:authorize ifAnyGranted="${jspAuthorities['engineer_solve_tab']}">
												<li id="take4" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('ENGINEER_SOLVE');">工程师解决</a></li>
											</sec:authorize>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['confirmwarn_tab']}">
												<li id="take5" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('CONFIRMWARN');">确认提醒</a></li>
											</sec:authorize>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />故障申报处理列表</td>
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
</body>
</html>