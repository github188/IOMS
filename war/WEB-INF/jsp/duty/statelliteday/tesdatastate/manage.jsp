<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>卫星日检</title>
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
				
				/* loadTask('txjdprostate');
				loadTask('txjddatastate');
				loadTask('txjdmainstate');
				loadTask('txjdworkcon');
				loadTask('txjddeccon');
				loadTask('txjdsynstate');
				loadTask('txjdconwork');
				loadTask('txjdlinkstate');
				loadTask('txjdRadarlink');
				loadTask('dsPesTesLink');
				loadTask('slhodustate'); */
			}
		});
		//进入页面 统计不同Tab页待操作的记录条数
		    	/* loadTask('txjddatastate');
		    	loadTask('txjdprostate');
				loadTask('txjdmainstate');
				loadTask('txjdworkcon');
				loadTask('txjddeccon');
				loadTask('txjdsynstate');
				loadTask('txjdconwork');
				loadTask('txjdlinkstate');
				loadTask('slhequstate');
				loadTask('slhnetconstate');
				loadTask('slhjdjjstate');
				loadTask('slhprostate');
				loadTask('slhdatastate');
				loadTask('slhzpjjstate');
				loadTask('txjdRadarlink');
				loadTask('dsPesTesLink');
				loadTask('slhodustate'); */
			
				
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
					url : "${rootUrl}duty/statelliteday/tesdatastate/ajaxLoad.dox",
					dataType : "json",
					 data : {
						optType : optType,
					},  
					success : function(result) {
						   /* alert(optType);
				      	 alert(result.totalCount); */   
						  $("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
							 					+ result.length + "</div>"); 
					}
				});  
		
	}    
  function change(optType) {
	  
		$("#optType").val(optType);
		if(optType=='txjddatastate'){
			$.ajax({
				type : "post",
				url : "${rootUrl}duty/statelliteday/tesdatastate/manage.do",
				dataType : "json",
				data : {
					optType : optType
				}
			});
			/* loadTask('txjddatastate');
			loadTask('txjdprostate');
			loadTask('txjdmainstate');
			loadTask('txjdworkcon');
			loadTask('txjddeccon');
			loadTask('txjdsynstate');
			loadTask('txjdconwork');
			loadTask('txjdlinkstate');
			loadTask('txjdRadarlink');
			loadTask('dsPesTesLink');
			loadTask('slhodustate'); */
		    
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
						<span class="bold">卫星日检</span>
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
									action="${rootUrl}duty/statelliteday/tesdatastate/manage.do"
									method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<li id="txjddatastate" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjddatastate');">通信基地TES网管数据库</a></li>
											<li id="txjdprostate" style="position: relation"><a
												id="queryButton" href="#tabs-2"
												onclick="change('txjdprostate');">通信基地TES网管进程</a></li>
											<li id="txjdworkcon" style="position: relation"><a
												id="queryButton" href="#tabs-4"
												onclick="change('txjdworkcon');">通信基地TES网管工作站连通性</a></li>
											<li id="txjddeccon" style="position: relation"><a
												id="queryButton" href="#tabs-5"
												onclick="change('txjddeccon');">通信基地TES DecServer连通性</a></li>
											<li id="txjdconwork" style="position: relation"><a
												id="queryButton" href="#tabs-7"
												onclick="change('txjdconwork');">通信基地TES控制信道</a></li>
											<li id="txjdsynstate" style="position: relation"><a
												id="queryButton" href="#tabs-6"
												onclick="change('txjdsynstate');">通信基地TES网管同步状态</a></li>
											<li id="txjdmainstate" style="position: relation"><a
												id="queryButton" href="#tabs-3"
												onclick="change('txjdmainstate');">通信基地TES网管主备状态</a></li>
											<li id="txjdlinkstate" style="position: relation"><a
												id="queryButton" href="#tabs-8"
												onclick="change('txjdlinkstate');">通信基地TES链路</a></li>

											<!-- dyl add 由自检转为定检 -->
											<li id="txjdRadarlink" style="position: relation"><a
												id="queryButton" href="#tabs-15"
												onclick="change('txjdRadarlink');">通信基地TES雷达广播链路状态</a></li>
											<!-- dyl add 由自检转为定检 -->
											<li id="slhodustate" style="position: relation"><a
												id="queryButton" href="#tabs-17"
												onclick="change('slhodustate');">十里河PES主站ODU</a></li>
											<!-- dyl add 由自检转为定检 结束-->

											<li id="slhdatastate" style="position: relation"><a
												id="queryButton" href="#tabs-9"
												onclick="change('slhdatastate');">十里河PES网管数据库</a></li>
											<li id="slhprostate" style="position: relation"><a
												id="queryButton" href="#tabs-13"
												onclick="change('slhprostate');">十里河PES网管进程</a></li>
											<li id="slhnetconstate" style="position: relation"><a
												id="queryButton" href="#tabs-12"
												onclick="change('slhnetconstate');">十里河PES网管连通性</a></li>
											<li id="slhequstate" style="position: relation"><a
												id="queryButton" href="#tabs-10"
												onclick="change('slhequstate');">十里河PES网管设备</a></li>
											<li id="slhzpjjstate" style="position: relation"><a
												id="queryButton" href="#tabs-14"
												onclick="change('slhzpjjstate');">十里河PES中频机架</a></li>
											<li id="slhjdjjstate" style="position: relation"><a
												id="queryButton" href="#tabs-11"
												onclick="change('slhjdjjstate');">十里河PES基带机架</a></li>

											<!-- dyl add 由自检转为定检 -->
											<li id="dsPesTesLink" style="position: relation"><a
												id="queryButton" href="#tabs-16"
												onclick="change('dsPesTesLink');">东四民航局TES链路状态</a></li>
											<!-- dyl add 由自检转为定检 结束-->

										</ul>
										<div>
											<!--添加按钮-->
											<div id="tabs-1"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sate_check_txjddatestate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesdatastate/add.do?optType=txjddatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdprostate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesprostate/add.do?optType=txjdprostate"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdmainstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesmainstate/add.do?optType=txjdmainstate"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdworkcon_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesworkcon/add.do?optType=txjdworkcon"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjddeccon_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesdeccon/add.do?optType=txjddeccon"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdsynstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tessynstate/add.do?optType=txjdsynstate"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdconwork_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/tesconwork/add.do?optType=txjdconwork"
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
														ifAnyGranted="${jspAuthorities['sate_check_txjdlinkstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/teslinkstate/add.do?optType=txjdconwork"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhdatastate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhdatastate/add.do?optType=slhdatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhequstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhequstate/add.do?optType=slhdatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhjdjjstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhjdjjstate/add.do?optType=slhdatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhnetcon_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhnetconstate/add.do?optType=slhdatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhprostate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhprostate/add.do?optType=slhdatastate"
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
														ifAnyGranted="${jspAuthorities['sate_check_slhzpjjstate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/slhzpjjstate/add.do?optType=slhdatastate"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-15"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sate_check_txjdradarlink_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/txjdradarlink/add.do?optType=txjdRadarlink"
																class="my_add {boxwidth:1000,boxheight:500} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</c:if>
											</div>
											<div id="tabs-16"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<c:if
													test="${isflag eq 'yes' or currentUser.id eq 'admin' }">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['sate_check_dspesteslink_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/dsPesTesLink/add.do?optType=dsPesTesLink"
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
														ifAnyGranted="${jspAuthorities['sate_check_odustate_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}/duty/statelliteday/odustate/add.do?optType=slhodustate"
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













































