<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>卫星工具--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="1">
				<!-- <tr>
					<th colspan="2">记录名称</th>
					<th colspan="2">卫星工具</th>
				</tr> -->
				<tr>
					<th width="25%">工具名称</th>
					<th width="25%"><input id="name" name="name" type="text"
						value="${vo.name }" readonly="readonly" /></th>
					<th width="25%">存放位置</th>
					<th width="25%"><input id="address" name="address" type="text"
						value="${vo.address }" readonly="readonly" /></th>
				</tr>
				<tr>
					<th width="25%">数量</th>
					<th width="25%"><input id="num" name="num" type="text"
						value="${vo.num }" readonly="readonly" /></th>
					<th width="25%">保管人</th>
					<th width="25%">${vo.keeper.name}</th>
				</tr>
				<tr>
					<th colspan="4">备注</th>
				</tr>
				<tr>
					<th colspan="4"><textarea id="remark" name="remark" rows="2"
							readonly="readonly" style="width: 80%; height: 40px;">${vo.remark }</textarea></th>
				</tr>

				<tr>
					<th width="25%">入库时间</th>
					<th width="25%"><fmt:formatDate value="${vo.storeTime}"
							type="both" pattern="yyyy-MM-dd HH:mm:ss" /></th>
					<th width="25%">借出状态</th>
					<th width="25%">${vo.lendStatus.value}</th>
				</tr>
				<tr>
					<th width="25%">借用人</th>
					<th width="25%">${vo.borrower.name}</th>
					<th width="25%">借出时间</th>
					<th width="25%"><fmt:formatDate value="${vo.lendTime}"
							type="both" pattern="yyyy-MM-dd HH:mm:ss" /></th>
				</tr>
				<tr>
					<th width="25%">归还时间</th>
					<th width="25%"><fmt:formatDate value="${vo.backTime}"
							type="both" pattern="yyyy-MM-dd HH:mm:ss" /></th>
					<th width="25%"></th>
					<th width="25%"></th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>