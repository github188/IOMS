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
<body style="overflow-x: hidden">
	<div class="window">
		<dl class="title">
			<dd>KU节点管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">KU节点详情</a></li>
				<li><a href="#tabs-2">KU电路配置</a></li>
				<li><a href="#tabs-3">定制用户</a></li>
			</ul>

			<!--begin 详情内容-->
			<div id="tabs-1">
				<div class="mtab">
					<table width="100%">
						<tr>
							<th colspan="4"
								style="color: gray; width: 100%; text-align: center;">KU节点信息</th>
						</tr>
						<tr>
							<th width="20%">子网类型</th>
							<td width="30%">${fn:escapeXml(pageModel.subnetType.value)}</td>
							<th width="20%">节点号</th>
							<td width="30%">${fn:escapeXml(pageModel.kuNodeNo)}</td>
						</tr>
						<tr>
							<th width="20%">节点ID</th>
							<td width="30%">${fn:escapeXml(pageModel.kuNodeCode)}</td>
							<th width="20%">区域</th>
							<td width="30%">${pageModel.equip.bureau.value}</td>
						</tr>
						<tr>
							<th width="20%">是否空管局</th>
							<td width="30%"><c:if test="${pageModel.caac==true}">是</c:if>
								<c:if test="${pageModel.caac==false}">否</c:if></td>
							<th width="20%">站点名称</th>
							<td width="30%">${pageModel.equip.satellite.siteName}</td>
						</tr>
						<tr>
							<th width="20%">站点代码</th>
							<td width="30%">${pageModel.equip.satellite.siteCode}</td>
							<th width="20%">机箱类型</th>
							<td width="30%">${pageModel.type}</td>
						</tr>
						<tr>
							<th width="20%">有无频谱仪</th>
							<td width="30%"><c:if test="${pageModel.instrument==true}">有</c:if>
								<c:if test="${pageModel.instrument==false}">无</c:if></td>
							<th width="20%">板卡总数</th>
							<td width="30%">${pageModel.cardCount}</td>
						</tr>
						<tr>
							<th width="20%">板卡配置</th>
							<td width="30%">${pageModel.cardConfig}</td>
							<th width="20%">修改人</th>
							<td width="30%">${pageModel.optUser.name}</td>
						</tr>
						<tr>
							<th width="20%">修改时间</th>
							<td width="30%"><fmt:formatDate
									value="${pageModel.optTime.time}" type="date"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<th width="20%">上线状态</th>
							<td width="30%">${pageModel.status}</td>
						</tr>
						<tr>
							<th width="20%">未上线原因</th>
							<td width="30%">${pageModel.statusInfo}</td>
							<th width="20%"></th>
							<td width="30%"></td>
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
					<table width="100%">
						<thead>
							<tr>
								<th width="5%" rowspan="2">所属地区</th>
								<th width="5%" rowspan="2">电路名</th>

								<th width="5%" rowspan="2">电路类型</th>
								<th width="5%" rowspan="2">电路速率</th>
								<th width="5%" rowspan="2">配置时间</th>
								
								<th width="30%" colspan="6">发端</th>
								<th width="45%" colspan="7">收端</th>
							</tr>
							<tr>
								<th width="5%">节点名</th>
								<th width="5%">站名</th>
								<th width="5%">子网类型</th>
								<th width="5%">节点号</th>
								<th width="5%">槽位号</th>
								<th width="5%">端口号</th>

								<th width="5%">节点名</th>
								<th width="5%">站名</th>
								<th width="5%">子网类型</th>
								<th width="5%">节点号</th>
								<th width="5%">槽位号</th>
								<th width="5%">端口号</th>
								<th width="15%">信息</th>
							</tr>
							
						</thead>
						<tbody>
							<c:forEach items="${serviceList}" var="vo" varStatus="voStatus">
								<tr>

									<td>${vo.bureau.value}</td>
									<td>${vo.code}</td>


									<td>${vo.circuitTypeDetail}</td>
									<td>${vo.rateType.value }</td>
									<td>${vo.configTime}</td>


									<td>${vo.txNode.kuNodeCode }</td>
									<td>${vo.txNode.equip.satellite.siteName }</td>
									<td>${vo.txNode.subnetType.value }</td>
									<td>${vo.txNode.kuNodeNo }</td>
									<td>${vo.txGib }</td>
									<td>${vo.txChan }</td>

									<td>${vo.rxNode.kuNodeCode }</td>
									<td>${vo.rxNode.equip.satellite.siteName }</td>
									<td>${vo.rxNode.subnetType.value }</td>
									<td>${vo.rxNode.kuNodeNo }</td>
									<td>${vo.rxGib }</td>
									<td>${vo.rxChan }</td>
									<td>${vo.memo }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div id="tabs-3">
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