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
font {
	color: red;
	font-weight: bold;
}
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
			<dd>通信基地境外站主站华为路由器状态自检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="2">设备名称</th>
					<th colspan="2">${checkData.equipName.value }</th>
				</tr>
				<tr>
					<th width="25%" rowspan="9">巡检内容</th>
					<th width="25%" rowspan="3">AR2240设备状态</th>
					<th width="25%">CPU利用率</th>
					<th width="25%">${checkData.cpuResult }</th>
				</tr>

				<tr>
					<th width="25%">加德满都中继端口状态</th>
					<th><c:choose>
							<c:when test="${checkData.jdmdPortResult eq 'up'}">
	${checkData.jdmdPortResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.jdmdPortResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>

				<tr>
					<th width="25%">仰光中继端口状态</th>
					<th><c:choose>
							<c:when test="${checkData.ygPortResult eq 'up'}">
	${checkData.ygPortResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.ygPortResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>

				<tr>
					<th width="25%" rowspan="2">AR2240-异步转报TCP状态</th>
					<th width="25%">尼泊尔</th>
					<th><c:choose>
							<c:when test="${checkData.nbePortResult eq 'online'}">
	${checkData.nbePortResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.nbePortResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">仰光</th>
					<th><c:choose>
							<c:when test="${checkData.ygResult eq 'online'}">
	${checkData.ygResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.ygResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>

				<tr>
					<th width="25%" rowspan="4">AR2240-话音状态(LoopBack地址)</th>
					<th width="25%">加德满都</th>
					<th width="25%">${checkData.jdmdAddrResult }</th>
				</tr>
				<tr>
					<th width="25%">仰光</th>

					<th width="25%">${checkData.ygAddrResult }</th>
				</tr>
				<tr>
					<th width="25%">昆明</th>

					<th width="25%">${checkData.kmAddrResult }</th>
				</tr>
				<tr>
					<th width="25%">拉萨</th>

					<th width="25%">${checkData.laAddrResult }</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>