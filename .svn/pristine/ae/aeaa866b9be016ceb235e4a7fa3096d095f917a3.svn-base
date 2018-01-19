<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
	<meta http-equiv="expires" content="0" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"/>
	<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css"/>
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
</head>
<body style="overflow-x:hidden;overflow-y:scroll;">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm">
		<div class="window">
			<dl class="title">
				<dd>通知公告:查看</dd>
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
							style="color: gray; width: 100%; text-align: center;">通知公告信息</th>
					</tr>
					<tr>
						<th width="13%">栏目:</th>
						<td width="20%">${fn:escapeXml(pageModel.columns.value)}</td>
						<th width="13%">标题:</th>
						<td width="20%">${fn:escapeXml(pageModel.title)}</td>
						<th width="13%">提交人:</th>
						<td width="21%">${pageModel.createUser.name}-${pageModel.createUser.loginName}</td>
					</tr>
					<tr>
						<th width="13%">提交时间:</th>
						<td width="20%"><fmt:formatDate value="${pageModel.createTime}" type="date"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th width="13%">处理时间:</th>
						<td width="20%"><fmt:formatDate value="${pageModel.publishTime}" type="date"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th width="13%">当前状态:</th>
						<td width="21%">${pageModel.status.value}</td>
					</tr>
					<tr style="height: 240px">
						<th width="13%" valign="top">通知内容:</th>
						<td width="87%" colspan="5">
							<div style="width:780px;height:240px;overflow: auto;border:1px;">${pageModel.content}</div></td>
					</tr>
				</table>
				<div id="tabs" style="margin: 10px 20px 0px;padding:0px">
					<ul>
						<li><a href="#tabs-1">处理日志</a></li>
						<li><a href="#tabs-2">处理详情</a></li>
						<!-- <li><a href="#tabs-3">流程图</a></li> -->
					</ul>
					<div id="tabs-1">
						<table id="dataTable"  width="100%" style="margin:0px auto">
							<thead>
								<tr>
									<th>处理人员</th>
									<th>处理类型 </th>
									<th>开始状态 </th>
									<th>结束状态 </th>
									<th>处理时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${newsOptlogs}" var="newsOptlog">
									<td width="10%">${newsOptlog.optUser.name }</td>
									<td width="20%">${newsOptlog.newsStatusEnum.value}</td>
									<td width="20%">${newsOptlog.inNewsStatusEnum.value }</td>
									<td width="20%">${newsOptlog.outNewsStatusEnum.value }</td>
									<td width="10%"><fmt:formatDate value="${newsOptlog.optTime }" type="date"
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
								<c:forEach items="${newsOptlogs}" var="vo"
									varStatus="voStatus">
									<c:choose>
										<c:when test="${vo.newsStatusEnum!='DELETED' && vo.newsStatusEnum!='DRAFT' && vo.newsStatusEnum!='SUBMITTED' && vo.newsStatusEnum!='MODIFIED'}">
											<tr>
												<th width="100%" style="text-align: left;"><fmt:formatDate
														value="${vo.optTime}" type="date"
														pattern="yyyy-MM-dd HH:mm:ss" /> ${vo.optUser.name }-${vo.optUser.loginName }:</th>
											</tr>
											<tr>
												<td width="100%" style="height: 60px; text-align: left;">
													${vo.info}</td>
											</tr>
											<c:set var="optType" value="${vo.newsStatusEnum }" scope="page"></c:set>
										</c:when>
									</c:choose>
								</c:forEach>
								<c:if test="${optType==''}">
									<tr>
										<th width="100%" style="text-align:center;">还没有处理详情信息！</th>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<script type="text/javascript">
	    //实例化编辑器
        $(function() {
			$("#tabs").tabs();
            $.ajaxSetup({
                cache : false
            });
            $("#findNews").validate({
    			rules : {
    			},
    			submitHandler : function(form) {
    				parent.editSubmit(form);
    			}
    		});
    		$(".close").click(function() {
    			parent.$.nyroModalRemove();
    		});
        	$("#submit").click(function() {
    			parent.$.nyroModalRemove();
            });
        });
    </script>
	
</body>
</html>