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
			sortable : false,
			sortConfig : {
				0 : {
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
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));
	});
	var rootUrl = '${rootUrl }';
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
		if(confirm("确定删除?")) {
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
				error : function(xmlHttpRequest, error){
					alert("删除失败");
					window.top.location.reload();
				}
			});
		}
	}

	//全部展开或隐藏
	function showAllFault(data) {

		var childTableTrs = document.getElementsByName("childTableTr");
		for (var j = 0; j < childTableTrs.length; j++) {
			childTableTrs[j].style.background = "white";
		}

		var faultNumbers = document.getElementsByName("faultNumber");
		for (var i = 0; i < faultNumbers.length; i++) {
			var faultChildNumber = "faultChildNumber" + faultNumbers[i].value;
			var childNums = document.getElementsByName(faultChildNumber);
			var faultManageImg = "#faultManage-" + faultNumbers[i].value
					+ " img";
			var faultManage = "#faultManage-" + faultNumbers[i].value;
			$(faultManageImg).remove();
			if (data == "0") {
				for (var j = 0; j < childNums.length; j++) {
					var fault = "#child-" + faultNumbers[i].value + "-"
							+ childNums[j].value;
					$(fault).hide();
					$(handle).hide();
				}
				var htmImage = "<img alt='展开子故障单' src='${rootUrl }images/btn/qxzd.gif'/>";
			} else if (data == "1") {
				for (var j = 0; j < childNums.length; j++) {
					var fault = "#child-" + faultNumbers[i].value + "-"
							+ childNums[j].value;
					var handle = "#childhandle-" + faultNumbers[i].value + "-"
							+ childNums[j].value;
					$(fault).show();
					$(handle).show();
					var handle = "#childhandle-" + faultNumbers[i].value + "-"
							+ childNums[j].value;
				}
				var htmImage = "<img alt='隐藏子故障单' src='${rootUrl }images/btn/zd.gif'/>";
			}
			if (childNums.length != 0) {
				$(faultManage).append(htmImage);
			}
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
									name="listForm" action="${rootUrl}faultmng/count/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<div class="clear"></div>
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											事件单编号：<input id="faultNumber" name="faultNumber" type="text"
												value="" size="10" maxlength="10"
												onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')" />&nbsp;&nbsp;
											<!-- 申告人：<input id="contactsName" name="contactsName"
												type="text" value="" size="10" maxlength="20"
												onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />&nbsp;&nbsp; 
											申告电话：<input id="telephoneNumber" name="telephoneNumber"
												type="text" value="" size="10" maxlength="20"
												onkeyup="value=value.replace(/[^0-9\-]/g,'')"
												onpaste="value=value.replace(/[^0-9\-]/g,'')"
												oncontextmenu="value=value.replace(/[^0-9\-]/g,'')" />&nbsp;&nbsp; -->
											处理人：<input id="currentHandleUser" name="currentHandleUser"
												type="text" value="" size="10" maxlength="20"
												onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />&nbsp;&nbsp;
											 <!-- 坐席电话：<input id="stationPhone"
												name="stationPhone" type="text" value="" size="10"
												maxlength="20" onkeyup="value=value.replace(/[^0-9\-]/g,'')"
												onpaste="value=value.replace(/[^0-9\-]/g,'')"
												oncontextmenu="value=value.replace(/[^0-9\-]/g,'')" />
										</div>
										<div class="bclear"></div>
										<div> -->
											<%-- 事件类别：<select id="eventType" name="eventType"
												style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${eventTypes }" var="eventType">
													<option value="${eventType }">${eventType.value }</option>
												</c:forEach>
											</select>&nbsp;&nbsp;  --%>
											 <%-- 事件单来源：<select id="source" name="source"
												style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${sources }" var="source">
													<option value="${source }">${source.value }</option>
												</c:forEach>
											</select>&nbsp;&nbsp; --%>
											申告时间： <input readonly="true" id="startOptTime"
												name="startOptTime" size="15" maxlength="18" class="Wdate"
												onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endOptTime\')}'})" />至
											<input readonly="true" id="endOptTime" name="endOptTime"
												size="15" maxlength="18" class="Wdate"
												onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startOptTime\')}'})" />&nbsp;&nbsp;
											事件级别：<select id="faultLevel" name="faultLevel"
												style="width: 110px; height: 22px;">
												<option value="">请选择</option>
												<c:forEach items="${faultLevels }" var="faultLevel">
													<option value="${faultLevel }">${faultLevel.value }</option>
												</c:forEach>
											</select>&nbsp;&nbsp;
										</div>
										<div class="bclear"></div>
										<div>
											<a href="#none" class="btn" id="queryButton">查询</a> <a
												href="#none" class="btn" onclick="listForm.reset();">重置</a>
										</div>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->
									<div>
										<a href="#none" class="btn" onclick="showAllFault('1')">全部展开</a>&nbsp;&nbsp;
										<a href="#none" class="btn" onclick="showAllFault('0')">全部隐藏</a>
									</div>
									<div class="bclear"></div>
									<div id="tabs">
										<div id="queryResult"></div>
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