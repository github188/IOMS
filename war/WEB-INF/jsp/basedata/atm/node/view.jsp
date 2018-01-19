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
			<dd>ATM节点管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->
	<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
	
	
	
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">ATM节点信息</th>
				</tr>
				<tr>
					<th width="20%">区域：</th>
					<td width="30%">${fn:escapeXml(pageModel.bureau.value)}</td>
					<th width="20%">区内序号：</th>
					<td width="30%">${fn:escapeXml(pageModel.atmNodeSeq)}</td>
				</tr>
				<tr>
					<th width="20%">节点地点：</th>
					<td width="30%">${pageModel.atmNodeNameCn}</td>
					<th width="20%">节点代码：</th>
					<td width="30%">${fn:escapeXml(pageModel.atmNodeCode)}</td>
				</tr>
				<tr>
					<th width="20%">ATM0地址：</th>
					<td colspan="3">${pageModel.atmNodeIp}</td>
				</tr>			
			</table>
			<br/>
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>