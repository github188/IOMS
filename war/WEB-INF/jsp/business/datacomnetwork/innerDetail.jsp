<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	.t_title{
		text-align: center;
	}
-->
</style>
<script type="text/javascript">
	$(function(){
	});
</script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<input type="hidden" id="applyType" value="${m.dataComNetwork.applyBaseInfo.applyType.value}"/>
<table id="tb_desc" width="100%">
	<c:if test="${not empty m.dataComNetwork.applyBaseInfo.serialNumber}">
		<tr>
			<td width="100%" colspan="16" style="text-align: left;">
				<font style="font: bold;color: red;">${m.dataComNetwork.applyBaseInfo.serialNumber}</font>
			</td>
		</tr>
	</c:if>
	<tr class="t_title">
		<td width="15%" colspan="3">申请单位：</td>
		<td width="30%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyCom}</td>
		<td width="15%" colspan="3">联系人：</td>
		<td width="40%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyLinkman}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">手机号码：</td>
		<td width="30%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyPhone}</td>
		<td width="15%" colspan="3">座机号码：</td>
		<td width="40%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyTelephone}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">传真：</td>
		<td width="30%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyFax}</td>
		<td width="15%" colspan="3">邮箱：</td>
		<td width="40%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyEmail}</td>
	</tr>
	<tr class="t_title">
	    <td width="15%" colspan="3">电路类型：</td>
		<td width="30%" colspan="5">${m.dataComNetwork.applyBaseInfo.applyType.value}</td>
		<td width="15%" colspan="3">申请单位签字/盖章：</td>
		<td width="40%" colspan="5">${m.dataComNetwork.applySign}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">申请时间：</td>
		<td width="40%" colspan="5"><fmt:formatDate
				value="${m.dataComNetwork.applyBaseInfo.applyTime.time}"
				type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">民航数据通信网节点名称：</td>
		<td width="30%" colspan="5">${m.dataComNetwork.node}</td>
		<td width="15%" colspan="3">安装地点：</td>
		<td width="40%" colspan="5">${m.dataComNetwork.placeName}</td>
	</tr>
	<tr  class="t_title">
		<td width="25%" class="t_title" colspan="4">设备厂家：</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipfactory1}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipfactory2}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipfactory3}</td>
	</tr>
	<tr>
		<td width="25%" class="t_title" colspan="4">设备型号：</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipType1}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipType2}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipType3}</td>
	</tr>
	<tr>
		<td width="25%" class="t_title" colspan="4">设备数量(个)：</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipNum1}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipNum2}</td>
		<td width="25%" colspan="4">${m.dataComNetwork.equipNum3}</td>
	</tr>
	<tr>
		<td width="15%" colspan="2">申请备注：</td>
		<td width="85%" colspan="14">${m.dataComNetwork.remark}</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>附件信息</dd>
	</dl>
</div>
<c:choose>
			<c:when test="${not empty attaches}">
				<table width="100%" style="margin: 0px auto">
					<c:forEach var="type" items="${netWorkAttachTypeEnums}">
						<tr>
							<td align="right"  width="50%" class="t_key">${type.value}</td>	
							<td>
								<c:forEach var="attach" items="${attaches}">
									<c:if test="${type eq attach.attachType}">
										<sec:authorize ifAnyGranted="${jspAuthorities['datacomnetwork_download']}">
											<a href='${rootUrl}datacomnetwork/download.do?id=${attach.id}' title='点击下载文件'><span style="color: blue">${attach.attachName}</span></a>
										</sec:authorize>
									</c:if>
								</c:forEach>
							</td>					
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有任何附件！</div>
			</c:otherwise>
</c:choose>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>配置详情</dd>
	</dl>
</div>
<c:if test="${not empty dataComNetworkConfig && not empty dataComNetworkConfig.remark}">
<table width="100%" style="margin: 0px auto">
	<tbody>
<tr class="t_title">
	<th width="100%" style="text-align: left;">
	<span style="font-weight:bolder;font-size: 13px">&nbsp;配置时间:</span>
	<fmt:formatDate value="${dataComNetworkConfig.operateTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /> 
	<span style="font-weight:bolder;font-size: 13px">&nbsp;配置人:</span>${dataComNetworkConfig.operateUser}
	<span style="font-weight:bolder;font-size: 13px">&nbsp;联系方式:</span>010-58729911/12/14/15
	</th>
</tr></tbody></table>
</c:if>
<table width="100%">
	<tbody>
	    <c:choose>
			<c:when test="${not empty dataComNetworkConfig.remark}">
			<tr class="t_title">
<td width="40%" colspan="4">ATM地址/广域网地址</td>
<td width="60%" colspan="6">${dataComNetworkConfig.placeATM}</td>
</tr>
<tr class="t_title">
<td width="40%" colspan="4">ATM0地址/Loopback地址</td>
<td width="60%" colspan="6">${dataComNetworkConfig.placeATMO}</td>
</tr>
<tr class="t_title">
<td width="30%" colspan="2">中继连通性</td>
<td width="30%" colspan="3">
<c:choose>
<c:when test="${dataComNetworkConfig.connectivity}">正常</c:when>
<c:otherwise>异常</c:otherwise>
</c:choose></td>
<td width="40%" colspan="5">ATM节点中继的Pn端口状态为twoWayInside或IP节点中继端口状态为UP，视为连通性正常</td>
</tr>
<tr class="t_title">
<td width="30%" colspan="2">节点是否正常管理</td>
<td width="30%" colspan="3">
<c:choose>
<c:when test="${dataComNetworkConfig.nodemng}">正常</c:when>
<c:otherwise>异常</c:otherwise>
</c:choose></td>
<td width="40%" colspan="5">通过网管软件或其他网内设备能teInet节点并可以进行访问控制，视为管理正常</td>
</tr>
<tr class="config">
	<td width="30%" colspan="2">备注：<span style="color: red">(*)</span></td>
	<td colspan="8">${dataComNetworkConfig.remark}
	</td>
</tr>
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
			<c:when test="${not empty approveInfos}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;">
							<fmt:formatDate value="${vo.approveTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /> 
							<span style="font-weight:bolder;font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }<span style="font-weight:bolder;font-size: 13px">&nbsp;操作人:</span>${vo.username }
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作类别:</span>
							<span style="color:black">${vo.approveStatus.value}</span>
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作结果:</span>
							<c:choose>
								<c:when test="${vo.approveType.name() == 'reject' }">
									<span style="font-weight:bolder;color:red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'disconsent' }">
									<span style="font-weight:bolder;color:red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'consent' }">
									<span style="font-weight:bolder;color:#00db00">${vo.approveType.value}</span>
								</c:when>
								<c:otherwise>
									${vo.approveType.value}
								</c:otherwise>
							</c:choose>	
							<c:if test="${not empty vo.reportAddress}">
								<span style="font-weight:bolder;font-size: 13px">&nbsp;退回信息:</span>
								<sec:authorize ifAnyGranted="${jspAuthorities['datacomnetwork_downloadreturned']}">
									<a href='${rootUrl}datacomnetwork/downloadReturnedReport.do?reportAddress=${vo.reportAddress}&outlineAddress=${vo.outlineAddress}' title='点击下载文件'><span style="color: blue">附件</span></a>
								</sec:authorize>
							</c:if>
							</br>
							<c:if test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_seconddeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType eq 'transfer'))}">
							      <span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配置人员:</span>
							${vo.nextUserName}
							<span style="font-weight:bolder;font-size: 13px">&nbsp;配置人员联系方式:</span>
							${vo.nextUserTel}
							</c:if>
							<c:if test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_firstdeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType ne 'transfer') or  vo.approveStatus eq 'engineer_transfer')}">
							<span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核人员:</span>
							${vo.nextUserName}
							<span style="font-weight:bolder;font-size: 13px">&nbsp;审核人员联系方式:</span>
							${vo.nextUserTel}
							</c:if>
						</th>
					</tr>
					<tr>
						<td width="100%">
							<div style="height: auto; text-align: left; word-break: break-all; text-indent: 2em">${vo.approveRemark}</div>
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
					<td width="20%" align="right"><span style="font-size: 13px">服务评价<span style="color: red">*</span>：</span></td>
					<td width="80%">
						<input class="easyui-validatebox" type="radio" name="grade" checked="checked"/>${evaluateInfo.grade.value}
					</td>
				</tr>
				<tr>
					<td width="20%" align="right"><span style="font-size: 13px;">备注<span style="color: red">*</span>：</span></td>
					<td width="80%">
					<textarea id="evaluateRemark" name="evaluateRemark"  readonly="readonly" 
							rows="6" cols="60" class="easyui-validatebox" style="width:520px;resize:none;">${evaluateInfo.remark}</textarea>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有评价信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
