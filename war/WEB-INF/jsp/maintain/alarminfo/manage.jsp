<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>告警信息</title>
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
	
	//点击某个Tab页时更新所有Tab页中的待处理条数
	function change(optType) {
		$("#optType").val(optType);
		if(optType == "FTPAM"){
			$(".boxbtn").hide();
		}else{
			$(".boxbtn").show();
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
						<span class="bold">告警信息</span>
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
									action="${rootUrl}maintain/alarminfo/manage.do"
									method="post">

									<!-- 查询条件 -->
									<form:hidden id="optType" path="optType"/>
									<form:hidden id="index" path="index"/>
									<div id="tabs" style="padding-bottom:23px">
										<ul>
												<li id="take1" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('LKAM');">链路告警 </a></li>
												<li id="take2" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('STAM');">状态告警</a></li>
												<li id="take3" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('FTPAM');">站点告警</a></li>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
										    <div class="info">
											区域：
											<form:select path="bureau">
												<form:option value="">-请选择-</form:option>
												<c:forEach items="${bureauList}" var="bureau">
													<form:option value="${bureau.name}">${bureau.value}</form:option>
												</c:forEach>
											</form:select>
											站点名称：
											<form:input path="stname" size="10" maxlength="30" />
											设备名称：
											<form:input path="eqname" size="10" maxlength="30" />
											链路状态：
											<form:select path="status">
												    <form:option value="">-请选择-</form:option>
													<form:option value="1">正常</form:option>
													<form:option value="0">异常</form:option>
											</form:select>
										    
										           采集时间：<form:input cssStyle="width:120px" path="startRecordTime" cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('startRecordTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endRecordTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('startRecordTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endRecordTime\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:120px" path="endRecordTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('endRecordTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startRecordTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('endRecordTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startRecordTime\')}'});"
												style="cursor: pointer;" />
											</div>
										    <a href="#none" class="sbtn" id="queryButton">查询</a> 
										    <a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
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