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
			<dd>通信基地TES ODU状态自检详情</dd>
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
					<th width="25%" rowspan="12">巡检内容</th>
					<th width="25%">txa</th>
					<th width="25%">自检结果</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.txaResult ne 'OK' }">
								<font color="red">${checkData.txaResult.value }</font>
							</c:when>
							<c:otherwise>
					${checkData.txaResult.value }
					</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">rxa</th>
					<th width="25%">自检结果</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.rxaResult ne 'OK' }">
								<font color="red">${checkData.rxaResult.value }</font>
							</c:when>
							<c:otherwise>
					${checkData.rxaResult.value }
					</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">txb</th>
					<th width="25%">自检结果</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.txbResult ne 'OK' }">
								<font color="red">${checkData.txbResult.value }</font>
							</c:when>
							<c:otherwise>
					${checkData.txbResult.value }
					</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">rxb</th>
					<th width="25%">自检结果</th>
					<th width="25%"><c:choose>
							<c:when test="${checkData.rxbResult ne 'OK' }">
								<font color="red">${checkData.rxbResult.value }</font>
							</c:when>
							<c:otherwise>
					${checkData.rxbResult.value }
					</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="25%">TX Freq（A路）</th>
					<th width="25%">自检结果(MHz)</th>
					<th width="25%">${checkData.txfreqA }</th>
				</tr>
				<tr>
					<th width="25%">RX Freq（A路）</th>
					<th width="25%">自检结果(MHz)</th>
					<th width="25%">${checkData.rxfreqA }</th>
				</tr>
				<tr>
					<th width="25%">UC AT Level(A路)</th>
					<th width="25%">自检结果</th>
					<th width="25%">${checkData.usAresult }</th>
				</tr>
				<tr>
					<th width="25%">DC AT Level(A路)</th>
					<th width="25%">自检结果</th>
					<th width="25%">${checkData.dcAresult }</th>
				</tr>
				<tr>
					<th width="25%">TX Freq（B路）</th>
					<th width="25%">自检结果(MHz)</th>
					<th width="25%">${checkData.txfreqB}</th>
				</tr>
				<tr>
					<th width="25%">RX Freq（B路）</th>
					<th width="25%">自检结果(MHz)</th>
					<th width="25%">${checkData.rxfreqB }</th>
				</tr>
				<tr>
					<th width="25%">UC AT Level(B路)</th>
					<th width="25%">自检结果</th>
					<th width="25%">${checkData.usBresult }</th>
				</tr>
				<tr>
					<th width="25%">DC AT Level(B路)</th>
					<th width="25%">自检结果</th>
					<th width="25%">${checkData.dcBresult }</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>