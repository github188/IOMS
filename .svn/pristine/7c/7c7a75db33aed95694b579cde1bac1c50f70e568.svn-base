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
			<dd>东四民航局TES ODU状态自检详情</dd>
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
					<th colspan="1">设备名称</th>
					<th colspan="2">${checkData.equipName.value }</th>
				</tr>
				<tr>
					<th width="30%" rowspan="16">巡检内容</th>
					<th width="30%">主用侧(A/B)</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.masterAbResult ne 'A' }">
								<font color="red">${checkData.masterAbResult}</font>
							</c:when>
							<c:otherwise>
								${checkData.masterAbResult}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Receive Freq(MHz)</th>
					<th width="30%">${checkData.receiveResultShow}</th>
				</tr>
				<tr>
					<th width="30%">Transmit Freq(MHz)</th>
					<th width="30%">${checkData.transmitResultShow}</th>
				</tr>
				<tr>
					<th width="30%">Atten Down</th>
					<th width="30%">${checkData.attendownResult}</th>
				</tr>
				<tr>
					<th width="30%">Atten Up</th>
					<th width="30%">${checkData.attenupResult}</th>
				</tr>
				<tr>
					<th width="30%">Fixed Freq.PLL</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.fixedResult ne 'GOOD' }">
								<font color="red">${checkData.fixedResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.fixedResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Var Freq.pll</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.varResult ne 'GOOD' }">
								<font color="red">${checkData.varResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.varResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Ext PA Power</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.extpowerResult ne 'GOOD' }">
								<font color="red">${checkData.extpowerResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.extpowerResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Ext PA Temp</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.exttempResult ne 'GOOD' }">
								<font color="red">${checkData.exttempResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.exttempResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">LNA Current</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.lanResult ne 'GOOD' }">
								<font color="red">${checkData.lanResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.lanResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Summary Current</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.summaryResult ne 'GOOD' }">
								<font color="red">${checkData.summaryResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.summaryResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Ext 11V Supply</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.extResult ne 'GOOD' }">
								<font color="red">${checkData.extResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.extResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="30%">Redundant Status</th>
					<th width="30%"><c:choose>
							<c:when test="${checkData.redundantResult ne 'GOOD' }">
								<font color="red">${checkData.redundantResult.value}</font>
							</c:when>
							<c:otherwise>
								${checkData.redundantResult.value}
							</c:otherwise>
						</c:choose></th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>