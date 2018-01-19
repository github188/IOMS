<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>卫星日检（自检）</title>
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
	$(function() {
		//Tab分页功能实现必须添加的部分
		var $tabs = $("#tabs").tabs();
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
			}
		});
		//进入页面 统计不同Tab页待操作的记录条数
		//loadTask('txjdTesOCC');
		//loadTask('txjdTesODU');
		//loadTask('txjdKu');
		//loadTask('txjdOverseaMain');
		/* loadTask('txjdOverseaCDM');
		//loadTask('txjdOverseaHW'); */
		//loadTask('slhPES');
		//loadTask('dsODU');
		
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select',parseInt(index));
		
		//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
		$("#tabs").tabs({
			select:function(event,ui){
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
	});
    function loadTask(optType) {
        $.ajax({
                    type : "GET",
                    url : "${rootUrl}duty/satellitedayauto/ajaxLoad.dox",
                    dataType : "json",
                    data : {
                        optType : optType
                    },
                    success : function(result) {
                        $("#" + optType)
                                .append(
                                        "<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
                                                + result + "</div>");
                    }
                }); 
    }
	//点击某个Tab页时更新所有Tab页中的待处理条数
	function change(optType) {
		$("#optType").val(optType);
		//loadTask('txjdTesOCC');
		//loadTask('txjdTesODU');
		//loadTask('txjdKu');
		//loadTask('txjdOverseaMain');
		/* loadTask('txjdOverseaCDM');
		loadTask('txjdOverseaHW'); */
		//loadTask('slhPES');
		//loadTask('dsODU');
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
						<span class="bold">卫星日检（自检）</span>
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
									action="${rootUrl}duty/satellitedayauto/manage.do"
									method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<li id="txjdTesOCC" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdTesOCC');">通信基地TES OCC</a></li>
											<li id="txjdTesODU" style="position: relative;"><a
												id="queryButton" href="#tabs-2"
												onclick="change('txjdTesODU');">通信基地TES ODU</a></li>
											<li id="txjdKu" style="position: relative;"><a
												id="queryButton" href="#tabs-3" onclick="change('txjdKu');">通信基地KU卫星</a></li>
											<li id="txjdOverseaMain" style="position: relative;"><a
												id="queryButton" href="#tabs-4"
												onclick="change('txjdOverseaMain');">通信基地境外站主站载波</a></li>
											<li id="txjdOverseaCDM" style="position: relative;"><a
												id="queryButton" href="#tabs-5"
												onclick="change('txjdOverseaCDM');">通信基地境外站主站CDM570</a></li>
											<li id="txjdOverseaHW" style="position: relative;"><a
												id="queryButton" href="#tabs-6"
												onclick="change('txjdOverseaHW');">通信基地境外站主站华为路由器</a></li>
											<!-- <li id="txjdTesLink" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdTesLink');">通信基地-TES链路</a></li>
											<li id="txjdRadarLink" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdRadarLink');">通信基地雷达广播TES链路</a></li> -->
											<li id="slhPES" style="position: relative;"><a
												id="queryButton" href="#tabs-7" onclick="change('slhPES');">十里河PES出境载波状态</a></li>
											<!-- <li id="slhODU" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('slhODU');">十里河-PES主站ODU状态</a></li>
											<li id="dsPES" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('dsPES');">东四-PES-TES链路工作状态</a></li> -->
											<li id="dsODU" style="position: relative;"><a
												id="queryButton" href="#tabs-8" onclick="change('dsODU');">东四PES-TES民航局ODU状态</a></li>
										</ul>
										<div>
											<div id="tabs-1"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_tesocc_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/tesocc/add.do?optType=txjdTesOCC"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-2"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_tesodu_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/tesodu/add.do?optType=txjdTesODU"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-3"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<%-- <sec:authorize
													ifAnyGranted="${jspAuthorities['satellite_auto_tesocc_add']}">
													<div class="boxbtn">
														<a href="${rootUrl}duty/satellitedayauto/tesocc/add.do"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize> --%>
											</div>
											<div id="tabs-4"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_main_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/main/add.do?optType=txjdOverseaMain"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-5"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_overseacdm_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/overseacdm/add.do?optType=txjdOverseaCDM"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-6"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_overseahw_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/overseahw/add.do?optType=txjdOverseaHW"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-7"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_slhpes_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/slhpes/add.do?optType=slhPES"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-8"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['satellite_auto_dsodu_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/satellitedayauto/dsodu/add.do?optType=dsODU"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
												<div id="info1" class="info" style="height: 50px">
													<!-- 根据optType选择显示相应的设备名称 -->
													<%-- 操&nbsp;&nbsp;作&nbsp;&nbsp;人：
													<form:input path="operator" size="15" maxlength="50" />
                                                    <input id="operator" name="operator"  maxlength="50" 
                                                           style="width:190px"/> --%>
													巡检时间：
													<form:input cssStyle="width:190px ; color:#000"
														path="startTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
														style="cursor: pointer;" />&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;
													<form:input cssStyle="width:190px ; color:#000"
														path="endTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
														style="cursor: pointer;" />
												</div>
												<div>
													<a href="#none" class="sbtn" id="queryButton">&nbsp;&nbsp;查询</a>
													<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
												</div>
											</div>
										</div>
									</div>
								</form:form>
								<div class="bclear"></div>
								<!-- 查询条件 -->

								<div class="mtab">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										class="title">
										<tr>
											<td class="td1"><img src="${rootUrl}images/pl1.gif"
												alt="" />卫星日检自检</td>
											<td class="td2" id="noteInfo"></td>
										</tr>
									</table>
									<!--查询结果-->
									<div id="queryResult"></div>
									<!--查询结果-->
								</div>
							</div>
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