<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


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

<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#queryResult").manage({
			pagerUrl : true,
			view : true,
			add : true,
			edit : true,
			remove : true,
			boxwidth : "500",
			boxheight : "250",
			sortable : true,
			sortConfig : {
				3 : {
					sorter : false,
				}
			}
		});

	});
</script>

<style type="text/css">
body {
	background: #F7FBFF;
	padding-top: 2px;
}

.windows {
	width: 98%;
	border: 1px solid #C3CCD3;
	min-height: 220px;
	margin: 0px auto;
	background: #F7FBFF;
	filter: progid:DXImageTransform.Microsoft.Shadow(color=#E0F2FC,
		direction=120, strength=5 );
}
-->
</style>

</head>
<body>
	<div class="windows">
		<div class="mtab">
			<dl class="title">
				<dd>KU节点变更日志</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>


			<div id="main">
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<form:form modelAttribute="queryModel" id="listForm"
								name="listForm" action="${rootUrl}operstat/ku/log/manage.do"
								method="post">
								<div id="lmsx">
									<div class="clear"></div>
									<div>
										<div class="info" style="float: left;">
											日期：
											<form:input cssStyle="width:120px" path="startTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd H:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd H:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:120px" path="endTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd H:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd H:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
												style="cursor: pointer;" />
											<form:hidden path="kuNodeId" />
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title" style="margin-left: 2px">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />变更记录列表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
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
</body>
</html>