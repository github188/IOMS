<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>技术咨询记录</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jquery/themes/default/style.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
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
					<div class="place">技术咨询记录</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="bclear"></div>
								<form:form modelAttribute="queryModel" id="listForm" name="listForm" action="${rootUrl}techsupport/consult/record/manage.do" method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info" style="height: 50px">
										咨询类型：<form:select path="faultType" cssStyle="width:100px">
										   <form:option value="">请选择</form:option>
												<c:forEach items="${faultType }" var="vo">
													<form:option value="${vo.name() }">${vo.name }</form:option>												
												</c:forEach>
											</form:select>

											咨询人员：
											<form:input path="optClientLike" size="15" maxlength="50" />
											  咨询时间：<form:input cssStyle="width:120px" path="fromConsultDate" cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('fromConsultDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'toConsultDate\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('fromConsultDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'toConsultDate\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:120px" path="toConsultDate"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('toConsultDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'fromConsultDate\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('toConsultDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'fromConsultDate\')}'});"
												style="cursor: pointer;" /> 
												<div class="bclear"></div>
							     		处理状态：<form:select path="status" cssStyle="width:100px">
											<form:option value="">请选择</form:option>
											<c:forEach items="${consultStatus }" var="vo">
												<form:option value="${vo.name() }">${vo.name }</form:option>												
											</c:forEach>
									    	</form:select>
												  处理时间：<form:input cssStyle="width:120px" path="fromOptDate" cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('fromOptDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'toOptDate\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('fromOptDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'toOptDate\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:120px" path="toOptDate"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('toOptDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'fromOptDate\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('toOptDate'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'fromOptDate\')}'});"
												style="cursor: pointer;" /> 
										</div>
										<br/><br/>
										<a href="#none" class="sbtn" id="queryButton">查询</a>
										<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"	alt="" />技术咨询记录</td>
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