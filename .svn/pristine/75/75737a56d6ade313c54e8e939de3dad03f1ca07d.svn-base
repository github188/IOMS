<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$("#tabs").tabs();
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>

</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>TES节点管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">TES节点信息</a></li>
				<li><a href="#tabs-2">TES槽位信息</a></li>
				<li><a href="#tabs-3">TES业务信息</a></li>
				<li><a href="#tabs-4">定制用户</a></li>
			</ul>


			<!--begin 详情内容-->
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;">
			</div>
			<div id="tabs-1">
				<div class="mtab">
					<table style="margin: 2px 5px">
						<tr>
							<th colspan="4"
								style="color: gray; width: 100%; text-align: center;">TES节点信息</th>
						</tr>
						<tr>
							<th width="20%">机箱号</th>
							<td width="30%">${pageModel.tesNodeCode}</td>
							<th width="20%">区域</th>
							<td width="30%">${pageModel.equip.satellite.bureau.value}</td>
						</tr>
						<tr>
							<th width="20%">站点名称</th>
							<td width="30%">${pageModel.equip.satellite.siteName}</td>
							<th width="20%">站点代码</th>
							<td width="30%">${pageModel.equip.satellite.siteCode}</td>
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
					<br />

				</div>
			</div>
			<div id="tabs-2">
				<div class="mtab">
					<table style="margin: 2px 5px">
						<tr>
							<th colspan="5"
								style="color: gray; width: 100%; text-align: center;">TES槽位信息</th>
						</tr>
						<tr>
							<th width="10%">槽位号</th>
							<th width="10%">OCC</th>
							<th width="30%">备注</th>
							<th width="20%">修改人</th>
							<th width="30%">修改时间</th>
						</tr>
						<c:forEach var="tesSlot" items="${pageModel.tesSlotList}">
							<tr>
								<td width="10%">${tesSlot.cu}</td>
								<td width="10%">${tesSlot.occ}</td>
								<td width="30%">${tesSlot.info}</td>
								<td width="20%">${tesSlot.optUser.name}</td>
								<td width="30%"><fmt:formatDate
										value="${tesSlot.optTime.time}" type="date"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>

					</table>
					<br />
				</div>
			</div>
			<div id="tabs-3">
				<div class="mtab">
					<table style="margin: 2px 5px">
						<tr>
							<th colspan="14"
								style="color: gray; width: 100%; text-align: center;">TES业务信息</th>
						</tr>
						<tr>
							<th>电路名</th>
							<th>主叫端站点名称</th>
							<th>主叫端站点代码</th>
							<th>主叫端机箱号</th>
							<th>主叫端槽位号</th>
							<th>被叫端站点名称</th>
							<th>被叫端站点代码</th>
							<th>被叫端机箱号</th>
							<th>被叫端槽位号</th>
							<th>同异步</th>
							<th>电路速率（kbps）</th>
							<th>频带池</th>
							<th>收端信息</th>
							<th>备注</th>
						</tr>

						<c:forEach items="${serviceList}" var="vo" varStatus="voStatus">
							<tr>
								<td>${vo.circuitName}</td>

								<td>${vo.activeNode.equip.satellite.siteName}</td>
								<td>${vo.activeNode.equip.satellite.siteCode}</td>
								<td>${vo.activeNode.tesNodeCode}</td>
								<td>${vo.activeSlot}</td>

								<td>${vo.passiveNode.equip.satellite.siteName}</td>
								<td>${vo.passiveNode.equip.satellite.siteCode}</td>
								<td>${vo.passiveNode.tesNodeCode}</td>
								<td>${vo.passiveSlot}</td>
								<td>${vo.sync}</td>
								<td>${vo.rate}</td>
								<td>${vo.bandWidthPool}</td>
								<td>${vo.serviceMemo}</td>

								<td>${vo.info}</td>
							</tr>
						</c:forEach>

					</table>

				</div>
				<br />
			</div>
			<div id="tabs-4">
				<div class="mtab">
					<table width="100%">
						<thead>
							<tr>
								<th style="width: 12%">区域</th>
								<th style="width: 12%">姓名</th>
								<th style="width: 12%">单位名称</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${clientList}" var="co" varStatus="coStatus">
								<tr>
									<td>${co.bureau.value}</td>
									<td>${co.name}</td>
									<td>${co.company}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- end 详情内容-->
		</div>
	</div>
</body>
</html>