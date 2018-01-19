<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
	<meta http-equiv="expires" content="0" />
	<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
	<script src="${rootUrl }ueditor/ueditor.config.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<script>
$(function() {
	$.ajaxSetup({
		cache : false
	});


	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#submit").click(function() {
		$("#modForm").trigger("submit");
		parent.$.nyroModalRemove();
	});


});
</script>
</head>

<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }turndutymng/signleavemng/viewrecord.do" method="post">
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>交接班记录查看</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			 
			<table style="margin-left:10px" border="0"  class="table table-bordered"  >
				<thead>
				<tr align="center">
					<th>值班人</th>
					<th>记录内容</th>
					<th>创建时间</th>
					<th>最后操作人</th>
					<th>最后操作时间</th>
				</tr>
                </thead>
				<c:forEach items="${listshift}" var="vo" >
				   <tr>
				        <td>${vo.creater.name}</td>
						<td>${vo.remark}</td>
						<td>
						  <fmt:formatDate value="${vo.creatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>${vo.operator.name}</td>
						<td>
						  <fmt:formatDate value="${vo.operatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
				   </tr>
				</c:forEach>
				<tr align="center">
					<td colspan="5" align="center" valign="middle">
						<span class="btn">
							<a href="#none" id="goback" class="goback">关闭</a>
						</span>
					</td>
				</tr>
			</table>
		</div>

</form:form>
	
</body>
</html>