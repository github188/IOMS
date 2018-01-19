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
			<dd>通信基地-TES 网管进程状态</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="1">
				<tr>
					<th height="33" colspan="8" scope="col">卫星转发器频带资源使用统计</th>
				</tr>
				<tr>
					<th width="4%" scope="row">序号</th>
					<td width="13%">转发器名称</td>
					<td width="12%">通信系统</td>
					<td width="12%">总宽带（MHz）</td>
					<td width="15%">已用宽带（MHz）</td>
					<td width="13%">剩余宽带（MHz）</td>
					<td width="15%">转发器底噪电平（dbm）</td>
					<td width="16%">转发器增益档（db）</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td><p>中星10号C-8B</p></td>
					<td>TES系统</td>
					<td>${vo.tesSum }</td>
					<td>${vo.tesUse }</td>
					<td>${vo.tesSur }</td>
					<td>${vo.tesDbm }</td>
					<td>${vo.tesDb }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>中星10号C-8B</td>
					<td>PES系统</td>
					<td>${vo.pesSum }</td>
					<td>${vo.pesUse }</td>
					<td>${vo.pesSur }</td>
					<td>${vo.pesDbm }</td>
					<td>${vo.pesDb }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>亚洲 4 号 K-8V</td>
					<td>VsatPlusⅡ系统</td>
					<td>${vo.vsatSum }</td>
					<td>${vo.vsatUse }</td>
					<td>${vo.vsatSur }</td>
					<td>${vo.vsatDbm }</td>
					<td>${vo.vsatDb }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>中星10号C-8B</td>
					<td>COMTECH系统</td>
					<td>${vo.comSum }</td>
					<td>${vo.comUse }</td>
					<td>${vo.comSur }</td>
					<td>${vo.comDbm }</td>
					<td>${vo.comDb }</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>