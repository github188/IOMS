<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>未接电话管理</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
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
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
<script type="text/javascript">
	$(function() {
		$("#boxleft").attr("style","display:none");
		$("#date1").hide();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			boxwidth : "600",
			boxheight : "600",
			sortable : true,//是否使用页面排序功能
			sortConfig : { //页面排序的配置
				0 : {
					sorter : "text"
				}
			}
		});
		$("#leave").click(function() {
			$("#date1").show();
			$("#leave").hide();
		});
		$("#btn_select").click(function() {
			$("input[name=activeCheck]").each(function() {
				$(this).attr("checked", true);
			});
		});
		$("#btn_selected").click(function() {
			$("input[name=activeCheck]").each(function() {
				if ($(this).attr("checked")) {
					$(this).attr("checked", false);
				} else {
					$(this).attr("checked", true);
				}

			});
		});
	});
	var rootUrl = '${rootUrl }';
	
	var progressActiveSelectIds = new Array();
	function checkActiveSelect(checkbox) {
		if ($(checkbox).attr("checked") == "checked") {
			
			progressActiveSelectIds.push($(checkbox).attr("value"));
			return;
		}
		for (var i = 0; i < progressActiveSelectIds.length; i++) {
			if (progressActiveSelectIds[i] == $(checkbox).attr("value")) {
				progressActiveSelectIds.splice(i, 1);
				return;
			}
		}

	}
	
	function doMerge() {

		$.ajax({
			type : "GET",
			url : "${rootUrl }phonemng/missedcallmng/dellist.do?idlist="
					+ progressActiveSelectIds,
			dataType : "json",
			success : function(data, status, xhr) {
					 alert(data.msg);
			}
			
		});
	}
</script>


</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<%@ include file="/WEB-INF/jsp/left.jsp"%>
	<!-- LOGO -->




	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		action="${rootUrl}phonemng/missedcallmng/manage.do" method="post">
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading text-left">
							<div class="navbar-form">
								<img src="${rootUrl }images/img/missedcall_icon.png"></img>
								未接电话列表
							</div>
						</div>

						<div class="panel-body">
							<div class="navbar-form text-left">
								<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											
											打入时间： 
											  <input readonly="true" id="ringingTime"
											name="ringingTime" size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'pickupTime\')}'})">至
											
											<input readonly="true" id="pickupTime" name="pickupTime"
											size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({minDate:'#F{$dp.$D(\'ringingTime\')}'})">
											未接电话：
											<form:input path="callonNumber" size="10" maxlength="30" 
											onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
											/>
											<!-- 
											被叫电话：
											<form:input path="calledNumber" size="10" maxlength="30" /> -->
											值班工程师：
											<form:input path="userName" size="10" maxlength="30" value="${username}" 
											onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
											/>
											状态：
											  <form:select path="isDel" id="isDel" cssStyle="width:90px" >
													<form:option value=""></form:option>
													<form:options items="${isdel}" itemLabel="value" />
												</form:select>
										</div>
										<div>
											<a href="#none" class="sbtn" id="queryButton">查询</a> 	
										</div>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->
							</div>
							<br />

							<div class="form-group text-left">
								<div class="btn-group">
									<!-- <button type="button" class="btn btn-flat primary"
										style="height: 30px" id="btn_select">全选</button>
									<button type="button" class="btn btn-flat white"
										style="height: 30px" id="btn_selected">反选</button>
									<button type="button" class="btn btn-flat gray"
										style="height: 30px" OnClick="return confirm('您确认删除该记录吗?');">删除</button>
										 -->
										<a href="#" class="btn btn-flat primary" id="btn_select"
												style="width: 60px;">全选</a>
									<a href="#" class="btn btn-flat white" id="btn_selected"
												style="width: 60px;">反选</a>
									
									<a href="${rootUrl}phonemng/missedcallmng/manage.do" class="btn btn-flat danger" onclick="doMerge()"
												style="width: 60px;">删除</a>
								</div>
							</div>
							<div id="queryResult"></div>
						</div>
					</div>
				</div>

			</div>
			<!-- /.row -->


		</div>
		<!-- /.container-fluid -->
	</form:form>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>

	<!-- 版权页 -->
</body>
</html>