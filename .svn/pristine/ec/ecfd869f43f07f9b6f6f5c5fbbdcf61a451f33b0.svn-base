<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>事件处置</title>
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
<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />

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

<%-- <script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script> --%>
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>

<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />

<!-- 工作流相关 -->
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/faultMngWorkflow.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$tabs = $("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : true,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				2 : {
					sorter : 'text',
				}
			},
		});
		$("#tabs").tabs({
			select : function(event, ui) {
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
		loadCount('DEPTFAULT');
		loadCount('EVALUATE');
		loadCount('ASSIGNFAULT');
		loadCount('HANDLEFAULT');
		loadCount('COMPLETEFAULT');
		loadCount('FAULTALARM');
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));
	});
	var rootUrl = '${rootUrl }';
	//冒泡查询任务数量
	function loadCount(optType) {
		$
				.ajax({
					optType : "GET",
					url : "${rootUrl}faultmng/count.dox",
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
		$(".info").show();
		$(".info_unalarm").show();
		// 事件类别
		$(".info_type").hide();
		$("#eventType").hide();
		// 事件级别
		$(".info_level").hide();
		$("#faultLevel").hide();
		// 事件单来源
		$(".info_source").hide();
		$("#source").hide();
		loadCount('DEPTFAULT');
		loadCount('EVALUATE');
		loadCount('ASSIGNFAULT');
		loadCount('HANDLEFAULT');
		loadCount('COMPLETEFAULT');
		loadCount('FAULTALARM');
		if (optType == 'FAULTALARM') {
			$(".info").hide();
			$(".info_unalarm").hide();
			$(".info_complete").hide();
		}
		if (optType == 'COMPLETEFAULT') {
			// 事件类别
			$(".info_type").show();
			$("#eventType").show();
			// 事件级别
			$(".info_level").show();
			$("#faultLevel").show();
			// 事件单来源
			$(".info_source").show();
			$("#source").show();
		}
	}

	//判断故障单是否存在
	function changeFault(type) {
		var types = type.split(",");
		var id = types[0];
		var type = types[1];
		var tx = true;
		$.ajax({
			url : url = "${rootUrl}faultmng/check.dox?r=" + Math.random(),
			type : "GET",//get请求
			data : {
				id : id,
				type : type
			},
			async : false,//同步加载数据
			dataType : "json",//返回json格式
			success : function(response) {
				tx = response;
			}
		});
		window.top.location.reload();
	}

	//判断故障单是否存在
	function deleteFault(id) {
		if (confirm("确定删除?")) {
			$.ajax({
				url : "${rootUrl }faultmng/fault/faultDel.do",
				type : "POST",//get请求
				data : {
					id : id
				},
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("删除成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("删除失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				},
				error : function(xmlHttpRequest, error) {
					alert("删除失败");
					window.top.location.reload();
				}
			});
		}
	}
</script>
<style>
td {
	word-break: break-all;
}
</style>
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
						<span class="bold">事件管理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}faultmng/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<div class="clear"></div>
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											申告人： <input id="contactsName" name="contactsName" type="text"
												value="" size="10" maxlength="20"
												onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
											<span class="info_type">事件类别：</span> <select id="eventType"
												name="eventType" style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${eventTypes }" var="eventType">
													<option value="${eventType }">${eventType.value }</option>
												</c:forEach>
											</select> <span class="info_level">事件级别：</span><select id="faultLevel"
												name="faultLevel" style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${faultLevels }" var="faultLevel">
													<option value="${faultLevel }">${faultLevel.value }</option>
												</c:forEach>
											</select> <span class="info_source">事件单来源：</span><select id="source"
												name="source" style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${sources }" var="source">
													<option value="${source }">${source.value }</option>
												</c:forEach>
											</select>
										</div>
										<div class="info_unalarm">
											<a href="#none" class="btn" id="queryButton">查询</a> <a
												href="#none" class="btn" onclick="listForm.reset();">重置</a>
											<%-- <c:if test="${currentHandleUser eq '管理员' || isflag eq 'yes'}"> --%>
											<c:if test="${isflag eq 'yes'}">
												<a href="${rootUrl }faultmng/add.do"
													class="my_add {boxwidth:750,boxheight:550} btn"
													id="popWindowOtherButton">添加</a>
											</c:if>
										</div>
										<div class="bclear"></div>
										<div>
											<c:if test="${isDeptMangerByUser1 eq true}">
												<!--设置代理人功能-->
												<sec:authorize
													ifAnyGranted="${jspAuthorities['roletransfer_add']}">
													<div class="boxbtn">
														<a href="${rootUrl}roletransfer/manage.do" class="btn">设置代理人</a>
													</div>
												</sec:authorize>
											</c:if>
										</div>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->
									<div id="tabs">
										<ul>
											<li id="HANDLEFAULT" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('HANDLEFAULT');">待处理事件</a></li>
											<c:if test="${isDeptMangerByUser}">
												<li id="DEPTFAULT" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('DEPTFAULT');">待部门经理分配的事件</a></li>
												<li id="EVALUATE" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('EVALUATE');">待部门经理评价的事件</a></li>
											</c:if>
											<c:if test="${isMangerByUser}">
												<li id="ASSIGNFAULT" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('ASSIGNFAULT');">待值班经理分配的事件</a></li>
											</c:if>
											<li id="COMPLETEFAULT" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('COMPLETEFAULT');">已完成</a></li>
											<c:if test="${isflag eq 'yes'}">
												<li id="FAULTALARM" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('FAULTALARM');">告警任务</a></li>
											</c:if>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<div id="queryResult"></div>
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