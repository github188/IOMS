<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<table width="100%">
	<c:if test="${not empty teleGraphApplys[0].teleGraph.applyBaseInfo.serialNumber}">
		<tr>
			<td width="100%" colspan="7" style="text-align: left;">
				<font style="font: bold;color: red;">${teleGraphApplys[0].teleGraph.applyBaseInfo.serialNumber}</font>
			</td>
		</tr>
	</c:if>
	<tr>
		<td width="15%">申请单位：</td>
		<td width="30%" colspan="2">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyCom}</td>
		<td width="15%">联系人：</td>
		<td width="40%" colspan="3">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyLinkman}</td>
	</tr>
	<tr>
		<td width="15%">手机号码：</td>
		<td width="30%" colspan="2">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyPhone}</td>
		<td width="15%">座机号码：</td>
		<td width="40%" colspan="3">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyTelephone}</td>
	</tr>
	<tr>
		<td width="15%">传真：</td>
		<td width="30%" colspan="2">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyFax}</td>
		<td width="15%">邮箱：</td>
		<td width="40%" colspan="3">${teleGraphApplys[0].teleGraph.applyBaseInfo.applyEmail}</td>
	</tr>
	<tr>
		<td width="15%">申请类型：</td>
		<td width="30%" colspan="2">${teleGraphApplys[0].teleGraph.teleApplyType.value}</td>
		<td width="15%">申请单位签字/盖章：</td>
		<td width="40%" colspan="3">${teleGraphApplys[0].teleGraph.applyComSign}</td>
	</tr>
	<tr>
		<td width="15%">使用时限：</td>
		<td width="30%" colspan="2">${teleGraphApplys[0].teleGraph.usingPeriod.value}</td>
		<td width="15%">使用地区：</td>
		<td width="40%" colspan="3">${teleGraphApplys[0].teleGraph.usingArea.value}</td>
	</tr>
	<tr>
		<td width="15%">地址类型：</td>
		<td width="85%" colspan="6">${teleGraphApplys[0].teleGraph.addressType.value}</td>
	</tr>
	<tr>
		<td width="15%">序号：</td>
		<td width="10%">使用地点:</td>
		<td width="20%">申请时间：</td>
		<td width="15%">期望启用时间:</td>
		<c:choose>
			<c:when test="${teleGraphApplys[0].teleGraph.teleApplyType.value == '新增'}">
				<td width="15%">地址</td>
			</c:when>
			<c:otherwise>
				<td width="15%">原地址(变更/注销时填写)</td>
			</c:otherwise>
		</c:choose>
		<td width="15%">终端连接情况(本地空管/SITA/其他)</td>
		<td width="15%">申请用途</td>
	</tr>
	<c:forEach items="${teleGraphApplys}" var="t" varStatus="status">
		<tr>
			<td width="15%">${t.identify}</td>
			<td width="10%">${t.userArea}</td>
			<td width="20%"><fmt:formatDate	value="${t.applyTime}" type="date" pattern="yyyy-MM-dd" /></td>
			<td width="15%"><fmt:formatDate	value="${t.useTime}" type="date" pattern="yyyy-MM-dd" /></td>
			<c:choose>
				<c:when test="${teleGraphApplys[0].teleGraph.teleApplyType eq 'create' 
									and teleGraphApplys[0].teleGraph.addressType eq'E8X' }">
					<td width="15%">${t.allocatedAddr}</td>	
				</c:when>
				<c:otherwise>
					<td width="15%">${t.originalAddr}</td>		
				</c:otherwise>
			</c:choose>
			<td width="15%">${t.connection.value}</td>
			<td width="15%">${t.usage.value}</td>
		</tr>
	</c:forEach>
	<tr>
		<td width="15%">备注/其他要求</td>
		<td width="85%" colspan="6">${teleGraphApplys[0].teleGraph.remark}</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>附件信息</dd>
	</dl>
</div>
<c:choose>
	<c:when test="${not empty teleAttachTypeEnums}">
		<table width="100%" style="margin: 0px auto">
			<c:forEach var="type" items="${teleAttachTypeEnums}">
				<tr>
					<td align="right" width="50%" class="t_key">${type.value}</td>	
					<td>
						<c:forEach var="attach" items="${attaches}">
							<c:if test="${type eq attach.attachType}">
								<sec:authorize ifAnyGranted="${jspAuthorities['telegraph_download']}">
									<a href='${rootUrl}telegraph/download.do?id=${attach.id}' title='点击下载文件'><span style="color: blue">${attach.attachName}</span></a>
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
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>配置信息</dd>
	</dl>
</div>
<table width="100%" style="margin:0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty teleGraphConfigs}">
				<c:if test="${not empty teleGraphApplys and not empty teleGraphApplys[0].allocatedAddr}">
					<th style="text-align: left;">
						<span style="font-weight: bolder; font-size: 13px">&nbsp;配置人员:</span><span
							style="font-weight: bolder; color: red;">${teleGraphApplys[0].operPeople}</span>
						<span style="font-weight: bolder; font-size: 13px">&nbsp;联系方式:</span>010-58729911/12/14/15
					</th>
				</c:if>
				<table id="tb_desc">
						<tr class="t_title">
							<td width="6%" class="t_key">序号</td>
							<td width="10%" class="t_key">使用地点</td>
							<td width="12%" class="t_key">申请用途</td>
							<td width="12%" class="t_key">天航信配置地址</td>
							<td width="12%" class="t_key">天航信配置人员</td>
							<td width="12%" class="t_key">地区协助配置地址</td>
							<td width="12%" class="t_key">地区协助配置人员</td>
							<td width="12%" class="t_key">最终配置地址</td>
							<td width="12%" class="t_key">最终配置时间</td>
						</tr>
						<c:forEach items="${teleGraphConfigs}" var="vo" varStatus="status">
							<tr class="t_title">
									<td>${vo.identifier}</td>
									<td>${teleGraphApplys[status.index].userArea}</td>
									<td>${teleGraphApplys[status.index].usage.value}</td>
									<td>${vo.atncRountAddr}</td>
									<td>${vo.atncConfigPeople }</td>
									<td>${vo.areaRouteAddr }</td>
									<td>${vo.areaConfigPeople }</td>
									<c:choose>
										<c:when test="${teleGraphApplys[0].teleGraph.approveStat eq 'local_evaluate' 
												or teleGraphApplys[0].teleGraph.approveStat eq 'evaluated' }">
											<td>${teleGraphApplys[status.index].allocatedAddr }</td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
									</c:choose>
									<td><fmt:formatDate value="${teleGraphApplys[status.index].operTime}" type="date"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>
					</table>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有配置信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>审批过程</dd>
	</dl>
</div>
<table width="100%" style="margin:0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty approveInfos}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;">
							<fmt:formatDate	value="${vo.approveTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
							<span style="font-weight:bolder;font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作人:</span>${vo.username }
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
								<sec:authorize ifAnyGranted="${jspAuthorities['telegraph_downloadreturned']}">
									<a href='${rootUrl}telegraph/downloadReturnedReport.do?reportAddress=${vo.reportAddress}&outlineAddress=${vo.outlineAddress}' title='点击下载文件'><span style="color: blue">附件</span></a>
								</sec:authorize>
							</c:if>
							</br>
							<c:if test="${not empty vo.applyBaseInfo.candidate and vo.approveStatus eq 'csstaff_deal'}">
							      <span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分配协助配置地区:</span>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZWWW')}">新疆</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZLXY')}">西北</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZUUU')}">西南</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZBAA')}">华北</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZSSS')}">华东</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZGGG')}">中南</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZYTX')}">东北</c:if>
							</c:if>
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
						<td width="100%" >
							<div style="height: auto;text-align: left;word-break:break-all;text-indent:2em">
								${vo.approveRemark}
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th width="100%" style="text-align:center;">还没有审批信息！</th>
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
