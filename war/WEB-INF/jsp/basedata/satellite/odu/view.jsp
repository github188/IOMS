<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />

<script>
	$(function() {
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body style="overflow-x: hidden">
	<div class="window">
		<dl class="title">
			<dd>ODU管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">ODU信息</th>
				</tr>
				<tr>
					<th width="20%">站点名称</th>
					<td width="30%">${pageModel.site.siteName}</td>
					<th width="20%">站点代码</th>
					<td width="30%">${pageModel.site.siteCode}</td>
				</tr>
				<tr>
					<th width="20%">区域</th>
					<td width="30%">${pageModel.site.bureau.value}</td>
					<th width="20%">站点类型</th>
					<td width="30%">${pageModel.site.type}</td>
				</tr>
				<%-- <tr>
					<th width="20%">天线代码</th>
					<td width="30%">${pageModel.antenna.antennaCode}</td>
					<th width="20%">ODU名称</th>
					<td width="30%">${pageModel.oduName}</td>
				</tr> --%>
				<tr>
					<th width="20%">ODU类型</th>
					<td width="30%">${pageModel.oduType}</td>
					<th width="20%">ODU功率</th>
					<td width="30%">${pageModel.oduPower}</td>
				</tr>


				<tr>
					<th width="20%">中频发射固定/可调衰减值</th>
					<td width="30%">${pageModel.lanchMidFreq}</td>
					<th width="20%">中频接收固定/可调衰减值</th>
					<td width="30%">${pageModel.receiveMidMinus}</td>
				</tr>
				<tr>
					<th width="20%">发射增益/衰减</th>
					<td width="30%">${pageModel.lanchPlusMinus}</td>
					<th width="20%">接收增益/衰减</th>
					<td width="30%">${pageModel.receivePlusMinus}</td>
				</tr>
				<tr>
					<th width="20%">修改人</th>
					<td width="30%">${pageModel.client.name}</td>
					<th width="20%">修改时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.clientOptTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>

				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.info}</td>
				</tr>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>