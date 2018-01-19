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
			<dd>TES卫星电话--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;">
		</div>	
			<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">TES卫星电话信息</th>
				</tr>
				<tr>
					<th width="20%">电话号码</th>
					<td colspan="3">${pageModel.phoneNum}</td>
					<%-- 	<th width="20%">区域</th>
					<td width="30%">${pageModel.equip.bureau}</td>			 --%>
				</tr>
				<tr>
					<th width="20%">站点名称</th>
					<td width="30%">${pageModel.tesNode.equip.satellite.siteName}</td>
					<th width="20%">站点代码</th>
					<td width="30%">${pageModel.tesNode.equip.satellite.siteCode}</td>
				</tr>

				<tr>
					<th width="20%">机箱号</th>
					<td width="30%">${pageModel.tesNode.tesNodeCode}</td>
					<th width="20%">槽位号</th>
					<td width="30%">${pageModel.cu}</td>
				</tr>


				<tr>
					<th width="20%">修改人</th>
					<td width="30%">${pageModel.optUser.name}</td>
					<th width="20%">修改时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.optTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
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