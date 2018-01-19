<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>卫星巡检</title>
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
				 /* loadTask('cir'); 
				 loadTask('forward');
				 loadTask('kuequ');
				 loadTask('kusys');
				 loadTask('qequ');
				 loadTask('sp');
				 loadTask('tescheck');
				 loadTask('tesequ');
				 loadTask('tool');
				 loadTask('TxjdOutTesEquip');
				 loadTask('TxjdOutKuEquip');
				 loadTask('MhjOutTesEquip');
				 loadTask('SlhOutKuEquip');
				 loadTask('check'); */

			}
		});
		//进入页面 统计不同Tab页待操作的记录条数
		    	/* loadTask('cir'); 
				 loadTask('forward');
				 loadTask('kuequ');
				 loadTask('kusys');
				 loadTask('qequ');
				 loadTask('sp');
				 loadTask('tescheck');
				 loadTask('tesequ');
				 loadTask('mhjtesequ');
				 loadTask('mhjkucheck');
				 loadTask('tool');
				 loadTask('slhkucheck');
				 loadTask('wh');
				 loadTask('TxjdOutTesEquip');
				 loadTask('TxjdOutKuEquip');
				 loadTask('MhjOutTesEquip');
				 loadTask('SlhOutKuEquip');
				 loadTask('check'); */
				
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select',parseInt(index));
		
		//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
		$("#tabs").tabs({
			select:function(event,ui){
	/* 			alert(ui.index);
				alert(ui.panel);
				alert(ui.tab); */
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
	});
 function loadTask(optType) {
	 var checkType = $("#checkType").val();
		$.ajax({
					type : "GET",
					url : "${rootUrl}duty/statellite/tool/ajaxLoad.dox",
					dataType : "json",
					data : {
						optType : optType,
						checkType : checkType
					},
					success : function(result) {
						$("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result.length + "</div>");
					}
				});  
	}  
 
 
 function change(optType) {
		var checkType = $("#checkType").val();
		$("#optType").val(optType);
		if(optType=='wkzx'){
			$.ajax({
				type : "post",
				url : "${rootUrl}duty/statellite/tool/manage.do",
				dataType : "json",
				data : {
					optType : optType,
					checkType : checkType
				}
			}); 
		   // loadTask('wkzx');
		    
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
						<c:if test="${checkType eq 'MONTH' }">
							<span class="bold">卫星月检</span>
						</c:if>
						<c:if test="${checkType eq 'QUARTER' }">
							<span class="bold">卫星季检</span>
						</c:if>
						<c:if test="${checkType eq 'YEAR' }">
							<span class="bold">卫星年检</span>
						</c:if>
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
									action="${rootUrl}duty/statellite/tool/manage.do" method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<input type="hidden" id="checkType" name="checkType"
										value="${checkType }" />

									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<li id="tool" style="position: relation"><a
												id="queryButton" href="#tabs-1" onclick="change('tool');">
													卫星工具借用</a></li>
											<li id="qequ" style="position: relation"><a
												id="queryButton" href="#tabs-2" onclick="change('qequ');">
													运行设备检查</a></li>
											<li id="sp" style="position: relation"><a
												id="queryButton" href="#tabs-3" onclick="change('sp');">
													备品备件检查</a></li>
											<c:if test="${checkType eq 'QUARTER' or checkType eq 'YEAR'}">
												<li id="check" style="position: relation"><a
													id="queryButton" href="#tabs-15" onclick="change('check');">
														仪器仪表清查</a></li>
											</c:if>
											<li id="cir" style="position: relation"><a
												id="queryButton" href="#tabs-4" onclick="change('cir');">
													业务电路检查</a></li>
											<li id="forward" style="position: relation"><a
												id="queryButton" href="#tabs-5" onclick="change('forward');">卫星转发器频带资源使用统计</a></li>
											<li id="tesequ" style="position: relation"><a
												id="queryButton" href="#tabs-6" onclick="change('tesequ');">
													通讯基地TES室内设备</a></li>
											<li id="tescheck" style="position: relation"><a
												id="queryButton" href="#tabs-7"
												onclick="change('tescheck');"> 通信基地TES网管系统检查</a></li>
											<li id="kuequ" style="position: relation"><a
												id="queryButton" href="#tabs-8" onclick="change('kuequ');">
													通信基地KU室内设备检查</a></li>
											<li id="kusys" style="position: relation"><a
												id="queryButton" href="#tabs-9" onclick="change('kusys');">
													通信基地KU网管系统维护</a></li>
											<li id="mhjtesequ" style="position: relation"><a
												id="queryButton" href="#tabs-10"
												onclick="change('mhjtesequ');"> 民航局TES室内设备</a></li>
											<li id="mhjkucheck" style="position: relation"><a
												id="queryButton" href="#tabs-11"
												onclick="change('mhjkucheck');"> 民航局KU室内设备检查</a></li>
											<li id="slhkucheck" style="position: relation"><a
												id="queryButton" href="#tabs-12"
												onclick="change('slhkucheck');"> 十里河KU室内设备检查</a></li>
											<!----------------- 段衍林 add 卫星自检部分 开始 --------------------->
											<li id="TxjdOutTesEquip" style="position: relation"><a
												id="queryButton" href="#tabs-16"
												onclick="change('TxjdOutTesEquip');"> 通信基地TES室外设备</a></li>
											<li id="TxjdOutKuEquip" style="position: relation"><a
												id="queryButton" href="#tabs-17"
												onclick="change('TxjdOutKuEquip');"> 通信基地KU室外设备</a></li>
											<c:if test="${checkType eq 'QUARTER' or checkType eq 'YEAR'}">

												<li id="MhjOutTesEquip" style="position: relation"><a
													id="queryButton" href="#tabs-18"
													onclick="change('MhjOutTesEquip');">民航局TES室外设备</a></li>
												<li id="SlhOutKuEquip" style="position: relation"><a
													id="queryButton" href="#tabs-19"
													onclick="change('SlhOutKuEquip');">十里河KU室外设备</a></li>
											</c:if>
											<!----------------- 段衍林 add 卫星自检部分 结束 --------------------->
											<li id="wh" style="position: relation"><a
												id="queryButton" href="#tabs-13" onclick="change('wh');">
													维护总结</a></li>

										</ul>
										<div>
											<!--添加按钮-->
											<div id="tabs-1"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_tool_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/tool/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-2"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_qequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/qequ/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-3"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_sp_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/sp/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-4"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_cir_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/cir/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-5"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_forward_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/forward/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-6"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_tesequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/tesequ/add.do?checkType=${checkType}&optType=tesequ"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-7"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_tescheck_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/tescheck/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-8"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_kuequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/ku/add.do?checkType=${checkType}&optType=kuequ"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-9"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_kusys_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/kusys/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-10"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_mhjtesequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/tesequ/add.do?checkType=${checkType}&optType=mhjtesequ"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>

											<div id="tabs-11"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_kuequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/ku/add.do?checkType=${checkType}&optType=mhjkucheck"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>

											</div>

											<div id="tabs-12"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_kuequ_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/ku/add.do?checkType=${checkType}&optType=slhkucheck"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-13"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_wh_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/wh/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-14"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_info_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/info/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<c:if test="${checkType eq 'QUARTER' or checkType eq 'YEAR'}">
												<div id="tabs-15"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<c:if
														test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
														<sec:authorize
															ifAnyGranted="${jspAuthorities['sta_check_check_add']}">
															<div class="boxbtn">
																<a
																	href="${rootUrl}duty/statellite/check/add.do?checkType=${checkType}"
																	class="my_add {boxwidth:1000,boxheight:700} btn"><img
																	src="${rootUrl}images/btn/new.gif" />添加</a>
															</div>
															<div class="bclear"></div>
														</sec:authorize>
													</c:if>
												</div>
											</c:if>

											<!----------------- 段衍林 add 卫星自检部分tab 开始 --------------------->
											<div id="tabs-16"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_outside_equip_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/outsideequip/add.do?checkType=${checkType}&optType=TxjdOutTesEquip"
																class="my_add {boxwidth:1000,boxheight:500} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-17"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sta_check_outside_equip_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/statellite/outsideequip/add.do?checkType=${checkType}&optType=TxjdOutKuEquip"
																class="my_add {boxwidth:1000,boxheight:500} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<c:if test="${checkType eq 'QUARTER' or checkType eq 'YEAR'}">
												<div id="tabs-18"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<c:if
														test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
														<sec:authorize
															ifAnyGranted="${jspAuthorities['sta_check_outside_equip_add']}">
															<div class="boxbtn">
																<a
																	href="${rootUrl}duty/statellite/outsideequip/add.do?checkType=${checkType}&optType=MhjOutTesEquip"
																	class="my_add {boxwidth:1000,boxheight:500} btn"><img
																	src="${rootUrl}images/btn/new.gif" />添加</a>
															</div>
															<div class="bclear"></div>
														</sec:authorize>
													</c:if>
												</div>
												<div id="tabs-19"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<c:if
														test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
														<sec:authorize
															ifAnyGranted="${jspAuthorities['sta_check_outside_equip_add']}">
															<div class="boxbtn">
																<a
																	href="${rootUrl}duty/statellite/outsideequip/add.do?checkType=${checkType}&optType=SlhOutKuEquip"
																	class="my_add {boxwidth:1000,boxheight:500} btn"><img
																	src="${rootUrl}images/btn/new.gif" />添加</a>
															</div>
															<div class="bclear"></div>
														</sec:authorize>
													</c:if>
												</div>
											</c:if>
											<!----------------- 段衍林 add 卫星自检部分 结束 --------------------->
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
												<div id="info1" class="info" style="height: 50px">
													<!-- 根据optType选择显示相应的设备名称 -->
													操&nbsp&nbsp作&nbsp&nbsp人：
													<form:input path="operator" size="15" maxlength="50"
														cssStyle="width:190px" />
													<div class="bclear"></div>
													巡检时间：
													<form:input cssStyle="width:190px ; color:#000"
														path="startTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
														style="cursor: pointer;" />&nbsp&nbsp&nbsp&nbsp&nbsp至&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
													<form:input cssStyle="width:190px ; color:#000"
														path="endTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
														style="cursor: pointer;" />
												</div>
												<br /> <br /> <a href="#none" class="sbtn"
													id="queryButton">查询</a> <a href="#none" class="sbtn"
													onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />卫星巡检</td>
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













































