<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<table width="100%">
	<c:if test="${not empty signoutNet.applyBaseInfo.serialNumber}">
		<tr>
			<td width="100%" colspan="7" style="text-align: left;"><font
				style="font: bold; color: red;">${signoutNet.applyBaseInfo.serialNumber}</font>
			</td>
		</tr>
	</c:if>
	<tr>
		<td width="15%">申请单位：</td>
		<td width="40%" colspan="3">${signoutNet.applyBaseInfo.applyCom }</td>
		<td width="18%">联系人：</td>
		<td width="30%" colspan="2">${signoutNet.applyBaseInfo.applyLinkman}</td>
	</tr>
	<tr>
		<td width="15%">手机号码：</td>
		<td width="40%" colspan="3">${signoutNet.applyBaseInfo.applyPhone }</td>
		<td width="18%">邮箱：</td>
		<td width="30%" colspan="2">${signoutNet.applyBaseInfo.applyEmail}</td>
	</tr>
	<tr>
		<td width="20%">座机号码/传真：</td>
		<td width="30%" colspan="3">${signoutNet.applyBaseInfo.applyTelephone}/${signoutNet.applyBaseInfo.applyFax}</td>
		<td width="20%">申请单位签字/盖章：</td>
		<td width="30%" colspan="2">${signoutNet.applyComSign}</td>
	</tr>
	<c:choose>
		<c:when test="${signoutNet.dealType eq 'signoutnet_atm'}">
			<tr>
				<td width="20%" colspan="1">站点名称：</td>
				<td width="30%" colspan="3">${signoutNet.siteName}</td>
				<td width="20%" colspan="1">节点代码：</td>
				<td width="30%" colspan="2">${signoutNet.nodeCodes}</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td width="20%" colspan="1">站点所属系统：</td>
				<td width="30%" colspan="3">${signoutNet.siteSystem.value}</td>
				<td width="20%" colspan="1">子网类型：</td>
				<td width="30%" colspan="2">${signoutNet.subnetType.value}</td>
			</tr>
			<tr>
				<td width="20%" colspan="1">站点名称：</td>
				<td width="30%" colspan="3">${signoutNet.siteName}</td>
				<td width="20%" colspan="1">站点代码：</td>
				<td width="30%" colspan="2">${signoutNet.siteCode}</td>
			</tr>
			<tr>
				<td width="20%" colspan="1">机箱号：</td>
				<td width="30%" colspan="3">${signoutNet.caseNum}</td>
				<td width="20%" colspan="1">节点号：</td>
				<td width="30%" colspan="2">${signoutNet.nodeNum}</td>
			</tr>
		</c:otherwise>
	</c:choose>
	<tr>
		<td>退回设备<span style="color: red">*</span>：
		</td>
		<td colspan="6">${signoutNet.equip}</td>
	</tr>
	<tr>
		<td>退回原因<span style="color: red">*</span>：
		</td>
		<td colspan="6">${signoutNet.reason}</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>配置信息</dd>
	</dl>
</div>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty signoutNetConfig}">
				<tr>
					<th width="100%" style="text-align: left;" colspan="5"><span
						style="font-weight: bolder; font-size: 13px">&nbsp;配置人员:</span><span
						style="font-weight: bolder; color: red;">${signoutNetConfig.operEngineer}</span>
						<span style="font-weight: bolder; font-size: 13px">&nbsp;联系方式:</span>010-58729911/12/14/15
					</th>
				</tr>
				<c:choose>
					<c:when test="${signoutNet.dealType ne 'signoutnet_atm'}">
						<tr class="t_title">
							<td width="10%" class="t_key">节点号</td>
							<td width="20%" class="t_key">0号载波中频频点</td>
							<td width="12%" class="t_key">射频发射频率</td>
							<td width="14%" class="t_key">射频接收频率</td>
							<td width="14%" class="t_key">配置时间</td>
						</tr>
						<tr class="t_title">
							<td>${signoutNetConfig.node}</td>
							<td>${signoutNetConfig.mediumFrequency}</td>
							<td>${signoutNetConfig.emissionFrequency}</td>
							<td>${signoutNetConfig.receiveFrequency}</td>
							<td><fmt:formatDate value="${signoutNetConfig.operDate}"
									type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:when>
					<c:otherwise>
						<!-- 通信网退网配置 -->
						<tr class="t_title">
							<td width="40%" colspan="2">ATM地址/广域网地址</td>
							<td width="60%" colspan="3">${signoutNetConfig.placeATM}</td>
						</tr>
						<tr class="t_title">
							<td width="40%" colspan="2">ATM0地址/Loopback地址</td>
							<td width="60%" colspan="3">${signoutNetConfig.placeATMO}</td>
						</tr>
						<tr class="t_title">
							<td width="30%" colspan="1">中继连通性</td>
							<td width="30%" colspan="2"><c:choose>
									<c:when test="${signoutNetConfig.connectivity eq true}">
							正常
							</c:when>
									<c:otherwise>
							异常
							</c:otherwise>
								</c:choose>
							<td width="40%" colspan="2">ATM节点中继的Pn端口状态为twoWayInside或IP节点中继端口状态为UP，视为连通性正常</td>
						</tr>
						<tr class="t_title">
							<td width="30%" colspan="1">节点是否正常管理</td>
							<td width="30%" colspan="2"><c:choose>
									<c:when test="${signoutNetConfig.nodemng eq true}">
							正常
							</c:when>
									<c:otherwise>
							异常
							</c:otherwise>
								</c:choose></td>
							<td width="40%" colspan="2">通过网管软件或其他网内设备能teInet节点并可以进行访问控制，视为管理正常</td>
						</tr>
						<tr class="t_title">
							<td width="30%" colspan="1">配置备注：<span style="color: red">(*)</span></td>
							<td colspan="4"><textarea id="confRemark" name="confRemark"
									rows="4" style="width: 500px;" readonly="readonly">${signoutNetConfig.confRemark}</textarea></td>
						</tr>
						<!-- 通信网退网配置结束 -->
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有配置信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>审批过程</dd>
	</dl>
</div>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${approveInfos.size()!=0}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;"><fmt:formatDate
								value="${vo.approveTime.time}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /> <span
							style="font-weight: bolder; font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }<span
							style="font-weight: bolder; font-size: 13px">&nbsp;操作人:</span>${vo.username }
							<span style="font-weight: bolder; font-size: 13px">&nbsp;操作类别:</span>
							<span style="color: black">${vo.approveStatus.value}</span> <span
							style="font-weight: bolder; font-size: 13px">&nbsp;操作结果:</span> <c:choose>
								<c:when test="${vo.approveType.name() == 'reject' }">
									<span style="font-weight: bolder; color: red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'disconsent' }">
									<span style="font-weight: bolder; color: red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'consent' }">
									<span style="font-weight: bolder; color: #00db00">${vo.approveType.value}</span>
								</c:when>
								<c:otherwise>
									${vo.approveType.value}
								</c:otherwise>
							</c:choose> <c:if test="${not empty vo.reportAddress}">
								<span style="font-weight: bolder; font-size: 13px">&nbsp;退回信息:</span>
								<sec:authorize
									ifAnyGranted="${jspAuthorities['kusatellite_downloadreturned']}">
									<a
										href='${rootUrl}kusatellite/downloadReturnedReport.do?reportAddress=${vo.reportAddress}&outlineAddress=${vo.outlineAddress}'
										title='点击下载文件'><span style="color: blue">附件</span></a>
								</sec:authorize>
							</c:if> </br> <c:if
								test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_seconddeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType eq 'transfer'))}">
								<span style="font-weight: bolder; font-size: 13px">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配置人员:</span>
							${vo.nextUserName}
							<span style="font-weight: bolder; font-size: 13px">&nbsp;配置人员联系方式:</span>
							${vo.nextUserTel}
							</c:if> <c:if
								test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_firstdeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType ne 'transfer') or  vo.approveStatus eq 'engineer_transfer')}">
								<span style="font-weight: bolder; font-size: 13px">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核人员:</span>
							${vo.nextUserName}
							<span style="font-weight: bolder; font-size: 13px">&nbsp;审核人员联系方式:</span>
							${vo.nextUserTel}
							</c:if></th>
					</tr>
					<tr>
						<td width="100%">
							<div
								style="height: auto; text-align: left; word-break: break-all; text-indent: 2em">
								${vo.approveRemark}</div>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th width="100%" style="text-align: center;">还没有审批信息！</th>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>评价详情</dd>
	</dl>
</div>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty evaluateInfo}">
				<tr>
					<td width="20%" align="right"><span style="font-size: 13px">服务评价<span
							style="color: red">*</span>：
					</span></td>
					<td width="80%"><input class="easyui-validatebox" type="radio"
						name="grade" checked="checked" />${evaluateInfo.grade.value}</td>
				</tr>
				<tr>
					<td width="20%" align="right"><span style="font-size: 13px;">备注<span
							style="color: red">*</span>：
					</span></td>
					<td width="80%"><textarea id="evaluateRemark"
							name="evaluateRemark" readonly="readonly" rows="6" cols="60"
							class="easyui-validatebox" style="width: 520px; resize: none;">${evaluateInfo.remark}</textarea>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有评价信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>