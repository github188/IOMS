<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>统计</title>

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

<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>


<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
	
<script type="text/javascript">
	$(function() {
		$("#boxleft").attr("style", "display:none");

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

	});
	var rootUrl = '${rootUrl }';
</script>

</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<%@ include file="/WEB-INF/jsp/left.jsp"%>

	<!-- LOGO -->
			<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading text-left">
							<div class="navbar-form">
								统计
							</div>
						</div>

						<div class="panel-body">
    <div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
							<form:form modelAttribute="queryModel" id="listForm"
								name="listForm" action="${rootUrl}phonemng/countmng/manage.do"
								method="post">

								<form:hidden id="optType" path="optType" />
								<form:hidden id="index" path="index" />

								<div class="clear"></div>
								<!-- 查询条件 -->
								<div class="boxbtn">
									<div class="info">

										通话开始时间： <input readonly="true" id="ringingTime"
											name="ringingTime" size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'pickupTime\')}'})">至

										<input readonly="true" id="pickupTime" name="pickupTime"
											size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({minDate:'#F{$dp.$D(\'ringingTime\')}'})">

											值班工程师： <form:select path="userName"
												onChange="ChangeDutyPlace()">
												<option />
												<c:forEach var="vo" items="${names}" varStatus="loop">
													<option />${vo}
												</c:forEach>
											</form:select> 类别： <form:select path="atncType">
												<option />
												<c:forEach var="vo" items="${typeList}" varStatus="loop">
													<option value="${vo.name()}" />${vo.value}
												</c:forEach>
											</form:select>
									</div>
									<div>
										<a href="#none" class="btn btn-primary" id="queryButton">查询</a>
									</div>




								</div>
								<br />
								<br />
							

								<!-- 查询条件 -->
								<div id="queryResult"></div>
							</form:form>
						</div>
     </div>
     </div>
     </div>
   
    </div>
    </div>
    </div>
    </div>
    </div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>