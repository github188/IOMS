<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>通知公告已审批记录</title>
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
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			boxwidth : "600",
			boxheight : "600"
		});
	});
	var rootUrl = '${rootUrl }';
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
						<span class="bold">通知公告已审批记录</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<!--管理按钮
								<sec:authorize
									ifAnyGranted="${jspAuthorities['usernews_add']}">
									<div class="boxbtn">
										<a href="${rootUrl }news/tempCircuitApply.do"
											class="my_add {boxwidth:500,boxheight:590} btn">添加</a>
									</div>
									<div class="bclear"></div>
								</sec:authorize>-->
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}news/log/already/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											状态：
											<form:select path="statusEq" cssStyle="width:90px" >
												<form:option value=""></form:option>
												<form:options items="${newsStatusEnum}" itemLabel="value"  />
											</form:select>
											开始时间：
											<form:input path="startOptTime" size="10" maxlength="18" onclick="WdatePicker()"/>
											结束时间：
											<form:input path="endOptTime" size="10" maxlength="18" onclick="WdatePicker()"/>
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> 
										<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />通知公告</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<!--查询结果-->
												<div id="queryResult"></div>
												<!--查询结果-->
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