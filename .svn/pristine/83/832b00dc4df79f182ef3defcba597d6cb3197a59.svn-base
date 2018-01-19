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
			<dd>天线管理--查看</dd>
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
						style="color: gray; width: 100%; text-align: center;">卫星天线信息</th>
				</tr>
				<tr>
					<th width="20%">站点名称</th>
					<td width="30%">${fn:escapeXml(pageModel.site.siteName)}</td>
					<th width="20%">站点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.site.siteCode)}</td>
				</tr>
				<tr>
					<th width="20%">区域</th>
					<td width="30%">${pageModel.site.bureau.value}</td>
					<th width="20%">站点类型</th>
					<td width="30%">${pageModel.site.type}</td>
				</tr>
			<%-- 	<tr>
					<th width="20%">天线代码</th>
					<td width="30%" colspan="3">${pageModel.antennaCode}</td>

				</tr> --%>

				<tr>
					<th width="20%">天线尺寸</th>
					<td width="30%">${pageModel.antennaSize}</td>
					<th width="20%">海拔</th>
					<td width="30%">${pageModel.elevation}</td>

				</tr>

				<tr>
					<th width="20%">站点纬度</th>
					<td width="30%">${pageModel.latitude}</td>
					<th width="20%">站点经度</th>
					<td width="30%">${pageModel.longitude}</td>
				</tr>
				<tr>
					<th width="20%">方位角(度)</th>
					<td width="30%">${pageModel.positionAngle}</td>
					<th width="20%">俯仰角（度）</th>
					<td width="30%">${pageModel.pitchingAngle}</td>
				</tr>

				<tr>
					<th width="20%">创建用户</th>
					<td width="30%">${pageModel.client.name}</td>
					<th width="20%">创建时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.recordTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>

				<tr>
					<th width="20%">网控用户</th>
					<td width="30%">${pageModel.optUser.name}</td>
					<th width="20%">修改时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.optTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th width="20%">备件情况</th>
					<td colspan="3">${pageModel.spare}</td>
				</tr>
				<tr>
					<th width="20%">天线情况</th>
					<td colspan="3">${pageModel.antennaDesc}</td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.info}</td>
				</tr>
			</table>
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>