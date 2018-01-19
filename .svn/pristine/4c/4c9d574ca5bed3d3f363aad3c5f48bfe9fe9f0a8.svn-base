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
<script src="${rootUrl }js/left-tree-menu.js" type="text/javascript">
</script>
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
			}
		});
				
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
  function change(optType) {
	  
		$("#optType").val(optType);
		if(optType=='txjddatastate'){
			$.ajax({
				type : "post",
				url : "${rootUrl}duty/satellite/day/tes/manage.do",
				dataType : "json",
				data : {
					optType : optType
				}
			});
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
		<%-- <%@ include file="/WEB-INF/jsp/left.jsp"%> --%>
		<%@ include file="/WEB-INF/jsp/duty/menu/left.jsp"%>
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
									action="${rootUrl}duty/satellite/day/tes/manage.do"
									method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<li id="txjddatastate" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjddatastate');">TES网管数据库</a></li>
											<li id="txjdprostate" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdprostate');">TES网管进程</a></li>
											<li id="txjdworkcon" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdworkcon');">TES网管工作站连通性</a></li>
											<li id="txjddeccon" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjddeccon');">DecServer连通性</a></li>
											<li id="txjdsynstate" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdsynstate');">通信基地TES网管同步状态</a></li>
											<li id="txjdmainstate" style="position: relation"><a
												id="queryButton" href="#tabs-1"
												onclick="change('txjdmainstate');">通信基地TES网管主备状态</a></li>
										</ul>
										<div>
											<!--添加按钮-->
											<div id="tabs-1"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['sat_check_day_tes_add']}">
													<div class="boxbtn">
														<a href="${rootUrl}/duty/satellite/day/tes/add.do"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
												<div id="info1" class="info" style="height: 50px">
													<!-- 根据optType选择显示相应的设备名称 -->
													<span>创建人：</span>
													<form:input path="operator" size="15" maxlength="50"
														cssStyle="width:190px" />
													审核人：
													<form:input path="auditer" size="15" maxlength="50"
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
	<input id="pro" value='satellite' style="display: none"></input>
	<input id="kind" value='tesday' style="display: none"></input>
	<input id="item" value='item_satellitedaytes' style="display: none"></input>
</body>
</html>