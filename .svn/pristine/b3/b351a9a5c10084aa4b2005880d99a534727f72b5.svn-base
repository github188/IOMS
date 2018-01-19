<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>通知公告日志管理</title>
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
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true
		});
	});
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
						<span class="bold">通知公告日志</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<!--管理按钮-->
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}publicnotice/pnlog/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											标题：
											<form:input path="titleLike" size="10" maxlength="50" />
											栏目：
											<form:select path="pnNoticeColumnEnum">
												<form:option value="">-请选择-</form:option>
												<form:options items="${pnNoticeColumnEnum}"  itemLabel="value" />

											</form:select>
											<%-- 日期：
											<form:input cssStyle="width:60px" path="startTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd 00:00:00',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd 00:00:00',maxDate:'#F{$dp.$D(\'endTime\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:60px" path="endTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd 23:59:59',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd 23:59:59',minDate:'#F{$dp.$D(\'startTime\')}'});"
												style="cursor: pointer;" />  --%>
												用户：
									<form:input path="userNameLike" size="10" maxlength="50" />
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />通知公告列表</td>
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