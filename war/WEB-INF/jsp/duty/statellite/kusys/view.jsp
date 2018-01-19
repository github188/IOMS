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
			<dd>通信基地KU网管系统维护</dd>
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
					<th colspan="4" scope="col">通信基地KU网管系统维护</th>
				</tr>
				<tr>
					<th width="17%" scope="row">序号</th>
					<td width="34%">检查内容</td>
					<td width="29%">结果记录</td>
					<td width="20%">备注</td>
				</tr>
				<tr>
					<th rowspan="5" scope="row">1</th>
					<td>子网1网管中作站状态</td>
					<td>${vo.net1Workstate.value}</td>
					<td rowspan="5">${vo.subnetWorkRemark }</td>
				</tr>
				<tr>
					<td>子网2网管中作站状态</td>
					<td>${vo.net2Workstate.value}</td>
				</tr>
				<tr>
					<td>子网3网管中作站状态</td>
					<td>${vo.net3Workstate.value}</td>
				</tr>
				<tr>
					<td>子网4网管中作站状态</td>
					<td>${vo.net4Workstate.value}</td>
				</tr>
				<tr>
					<td>帧中继网管中作站状态</td>
					<td>${vo.netzWorkstate.value}</td>
				</tr>
				<tr>
					<th rowspan="6" scope="row">2</th>
					<td>子网1网管工作站数据备份至磁盘</td>
					<td>${vo.net1WorkstateBf.value}</td>
					<td rowspan="5">${vo.subnetDataRemark }</td>
				</tr>
				<tr>
					<td>子网2网管工作站数据备份至磁盘</td>
					<td>${vo.net2WorkstateBf.value}</td>
				</tr>
				<tr>
					<td>子网3网管工作站数据备份至磁盘</td>
					<td>${vo.net3WorkstateBf.value}</td>
				</tr>
				<tr>
					<td>子网4网管工作站数据备份至磁盘</td>
					<td>${vo.net4WorkstateBf.value}</td>
				</tr>
				<tr>
					<td>帧中继网网管工作站数据备份至磁盘</td>
					<td>${vo.netzWorkstateBf.value}</td>
				</tr>
				<tr>
					<td>备份磁盘存放位置</td>
					<td>${vo.tapeLocate}</td>
					<td>${vo.tapeLocateRemark}</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>网管工作站除尘</td>
					<td><c:choose>
							<c:when test="${vo.workDust eq 'COMPLETE'}">
	                             完成		   </c:when>
							<c:otherwise>
		   		未完成		   </c:otherwise>
						</c:choose></td>
					<td>${vo.workDustRemark }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>转发器底噪电平（切空图查看）</td>
					<td>${vo.forward }</td>
					<td>${vo.forwardRemark }</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>