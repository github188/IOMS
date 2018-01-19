<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		$.ajaxSetup({
			cache : false
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm">
		<div class="window">
			<dl class="title">
				<dd>技术咨询详情</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<br />
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
				<table width="100%">
					<tr>
						<th colspan="6"
							style="color: gray; width: 100%; text-align: center;">技术咨询描述</th>
					</tr>
					<tr>
						<th width="13%">咨询类型:</th>
						<td width="20%">${pageModel.faultType.name}</td>
						<th width="13%">填报人员:</th>
						<td width="20%">${pageModel.client.name}</td>
						<th width="13%">咨询时间:</th>
						<td width="21%"><fmt:formatDate
								value="${pageModel.faultTime}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th width="13%">处理人员:</th>
						<td width="20%">${pageModel.operUser}</td>
						<th width="13%">处理状态:</th>
						<td width="20%">${pageModel.faultStatus.name}</td>
						<th width="13%">处理时间:</th>
						<td width="21%"><fmt:formatDate
								value="${pageModel.updateTime}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th width="13%">咨询摘要:</th>
						<td width="20%">${pageModel.faultKey}</td>
						<th width="13%">咨询人员:</th>
						<td width="20%">${pageModel.contactPerson}</td>
						<th width="13%">联系方式:</th>
						<td width="21%">${pageModel.contactNumber}</td>
					</tr>
					<tr style="height: 60px">
						<th width="13%">咨询描述:</th>
						<td colspan="5"><div style="height:150px;overflow: auto">${pageModel.faultDesc}</div></td>
					</tr>
				</table>
				<div id="tabs" style="margin: 10px 20px 0px;padding:0px">
					<ul>
						<li><a href="#tabs-2">处理详情</a></li>
						<li><a href="#tabs-1">处理日志</a></li>
					</ul>
					<div id="tabs-1">
						<table width="100%" style="margin:0px auto">
							<thead>
								<tr>
									<th data-options="10%">处理人员</th>
									<th data-options="20%">处理类型</th>
									<th data-options="10%">开始状态</th>
									<th data-options="20%">结束状态</th>
									<th data-options="20%">处理时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${faultDeclareOptLogs}" var="vo"
									varStatus="voStatus">
									<tr>
										<td>${vo.optUserName }</td>
										<td>${vo.optType.name }</td>
										<td>${vo.fromStatus.name }</td>
										<td>${vo.toStatus.name }</td>
										<td><fmt:formatDate value="${vo.optTime}" type="date"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="tabs-2">
						<table width="100%" style="margin:0px auto">
							<tbody>
								<c:set var="optType" value="" scope="page"></c:set>
								<c:forEach items="${faultDeclareOptLogs}" var="vo"
									varStatus="voStatus">
									<c:choose>
										<c:when
											test="${vo.optType!='ADD' && vo.optType!='MODIFY' && vo.optType!='SUBMIT'}">
											<tr>
												<th width="100%" style="text-align: left;"><fmt:formatDate
														value="${vo.optTime}" type="date"
														pattern="yyyy-MM-dd HH:mm:ss" /> 
													<span style="font-weight:bolder;font-size: 13px">&nbsp;部门:</span>${vo.optUserDepartment }<span style="font-weight:bolder;font-size: 13px">&nbsp;操作员:</span>${vo.optUserName }
												</th>
											</tr>
											<tr>
												<td width="100%" style="height: 60px; text-align: left;">
													${vo.descInfo}</td>
											</tr>
											<c:set var="optType" value="${vo.optType }" scope="page"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>
								<c:if test="${optType==''}">
									<tr>
										<th width="100%" style="text-align: center;">还没有处理详情信息！</th>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>