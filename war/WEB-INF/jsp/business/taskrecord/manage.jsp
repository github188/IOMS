<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>申请记录查询</title>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jquery/themes/default/style.css" />

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
<!-- 工作流相关 -->
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/teleGraphWorkflow.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/dataComNetworkWorkflow.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/formalCircuitWorkflow.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/kuSatelliteWorkflow.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/transferNetWorkflow.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		$("#queryResult").manage({
			pageForm : '#listForm',
			pagerButton : '#queryButton',
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			operate : true,
			remove : true,
			view : true,
			sortable:true,//是否使用页面排序功能
			sortConfig:{  //页面排序的配置
				0: {sorter: "text"}, 
				6: {sorter: false}
			},
			boxwidth : "600",
			boxheight : "420"
		});
		/* $("#exportButton").click(function(){
			var url = "${rootUrl}taskrecord/batchExport.dox";
			window.location.href = url;
		}); */
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
						<span class="bold">申请记录查询</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div id="lmsx">
								<!-- 好像只是换行而已 -->
								<div class="bclear"></div>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}taskrecord/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info" style="height: 50px">
											申请人员：
											<form:input path="applyUserLike" size="15" maxlength="50" />
											申请单位：
											<form:input path="applyComLike" size="15" maxlength="50" />
											联系人：
											<form:input path="applyLinkmanLike" size="15" maxlength="50" />
											申请类型：
											<form:select path="applyType" cssStyle="width:100px">
												<form:option value="">请选择</form:option>
												<c:forEach items="${applyTypes }" var="vo">
													<form:option value="${vo.name()}">${vo.value }</form:option>
												</c:forEach>
											</form:select>
											<div class="bclear"></div>
											申请时间：
											<form:input cssStyle="width:120px" path="fromApplyTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('fromApplyTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'toApplyTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('fromApplyTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'toApplyTime\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:120px" path="toApplyTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('toApplyTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'fromApplyTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('toApplyTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'fromApplyTime\')}'});"
												style="cursor: pointer;" />
											参与人员：
											<form:input path="approveUser" size="15" maxlength="50" />
											区域：
											<form:select path="bureaus" cssStyle="width:100px">
												<form:option value="">请选择</form:option>
												<c:forEach items="${bureaus }" var="bureau">
													<form:option value="${bureau.name}">${bureau.value}</form:option>
												</c:forEach>
											</form:select>
											<%-- 审核状态：
											<form:select path="approveStatusValue" cssStyle="width:100px">
												<form:option value="">请选择</form:option>
												<c:forEach items="${approveStatusEnums }" var="approveStatus">
													<form:option value="${approveStatus.name()}">${approveStatus.value}</form:option>
												</c:forEach>
											</form:select>	 --%>
											<div class="bclear"></div>
										</div>
										<br /> <br /> <a href="#none" class="sbtn" id="queryButton">查询</a>
										<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
										<sec:authorize
											ifAnyGranted="${jspAuthorities['business_record_export']}">
											<a href="${rootUrl}taskrecord/batchExport.dox"
												class="sbtn my_operate" id="exportButton">批量导出</a>
										</sec:authorize>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->
									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />申请记录</td>
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