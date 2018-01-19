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
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>通信基地境外站主站CDM570状态自检详情</dd>
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
					<th width="25%" rowspan="8">巡检内容</th>
					<th width="25%" rowspan="4">主机</th>
					<th width="25%">Tx Traffic灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.masterTxResult eq 'on'}">
	${checkData.masterTxResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.masterTxResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">Rx Traffic灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.masterRxResult eq 'on'}">
	${checkData.masterRxResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.masterRxResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">OnLine灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.masterOnlineResult eq 'on'}">
	${checkData.masterOnlineResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.masterOnlineResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">Eb/No</th>
					<th width="25%">${checkData.masterEbResult}</th>
				</tr>
				<tr>
					<th width="25%" rowspan="4">备机</th>
					<th width="25%">Tx Traffic灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.slaveTxResult eq 'on'}">
	${checkData.slaveTxResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.slaveTxResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">Rx Traffic灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.slaveRxResult eq 'on'}">
	${checkData.slaveRxResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.slaveRxResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">OnLine灯</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.slaveOnlineResult eq 'on'}">
	${checkData.slaveOnlineResult.value}
	</c:when>
							<c:otherwise>
								<font>${checkData.slaveOnlineResult.value}</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">Eb/No</th>
					<th width="25%">${checkData.slaveEbResult }</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>