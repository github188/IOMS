<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<table width="100%">
	<c:if test="${not empty kuSatellite.applyBaseInfo.serialNumber}">
		<tr>
			<td width="100%" colspan="7" style="text-align: left;">
				<font style="font: bold;color: red;">${kuSatellite.applyBaseInfo.serialNumber}</font>
			</td>
		</tr>
	</c:if>
	<tr>
		<td width="15%">申请单位：</td>
		<td width="40%" colspan="3">${kuSatellite.applyBaseInfo.applyCom }</td>
		<td width="18%">联系人：</td>
		<td width="30%" colspan="2">${kuSatellite.applyBaseInfo.applyLinkman}</td>
	</tr>
	<tr>
		<td width="15%">手机号码：</td>
		<td width="40%" colspan="3">${kuSatellite.applyBaseInfo.applyPhone }</td>
		<td width="18%">邮箱：</td>
		<td width="30%" colspan="2">${kuSatellite.applyBaseInfo.applyEmail}</td>
	</tr>
	<tr>
		<td width="20%">座机号码/传真：</td>
		<td width="30%" colspan="3">${kuSatellite.applyBaseInfo.applyTelephone}/${kuSatellite.applyBaseInfo.applyFax}</td>
		<td width="20%">申请单位签字/盖章：</td>
		<td width="30%" colspan="2">${kuSatellite.applyComSign}</td>
	</tr>
	<tr>
		<td>地球站名称：</td>
		<td colspan="3">${kuSatellite.txSiteName}</td>
		<td>地球站安装地点：</td>
		<td colspan="2">${kuSatellite.rxSiteAddress}</td>	
	</tr>
	<tr>
		<td rowspan="3">地理信息(84坐标)</td>
		<td>东经<span style="color: red"></span>：</td>
		<td colspan="2">${kuSatellite.longitudeDeg}(度)${kuSatellite.longitudeMin}(分)${kuSatellite.longitudeSec}(秒)</td>
		<td rowspan="3">对星参数</td>
		<td>方位角：</td>
		<td>${kuSatellite.position}(度)</td>
	</tr>
	<tr>
		<td>北纬<span style="color: red"></span>：</td>
		<td colspan="2">${kuSatellite.latitudeDeg}(度)${kuSatellite.latitudeMin}(分)${kuSatellite.latitudeSec}(秒)</td>
		<td>俯仰角：</td>
		<td colspan="2">${kuSatellite.pitching}(度)</td>
	</tr>
	<tr>
		<td>海拔高度：</td>
		<td colspan="2">${kuSatellite.height}(米)</td>
		<td>极化角：</td>
		<td colspan="2">${kuSatellite.polarization}(度)</td>
	</tr>
	<tr>
		<td rowspan="2">天线</td>
		<td>厂家及型号：</td>
		<td colspan="2">${kuSatellite.antennaModel}</td>
		<td rowspan="2">室外单元</td>
		<td>厂家及型号：</td>
		<td colspan="2">${kuSatellite.outdoorModel}</td>
	</tr>
	<tr>
		<td>口径：</td>
		<td colspan="2">${kuSatellite.antennaDiameter}(米)</td>
		<td>发射功率：</td>
		<td colspan="2">${kuSatellite.launchPower}(瓦)</td>
	</tr>
	<tr>
		<td rowspan="2">室内单元</td>
		<td>VSAT PlusII：</td>
		<td colspan="2">${kuSatellite.vsatPlusllNum}(个)</td>
		<td>VSAT PlusIIe：</td>
		<td colspan="2">${kuSatellite.vsatPluslleNum}(个)</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>附件信息</dd>
	</dl>
</div>
<c:choose>
		<c:when test="${not empty attaches}">
				<table id="tb_desc">
					<c:forEach var="type" items="${kuSatelliteAttachEnums }">
						<tr>
							<td align="right"  width="50%" class="t_key">${type.value}</td>	
							<td>
								<c:forEach var="attach" items="${attaches}">
									<c:if test="${type eq attach.attachType}">
										<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_download']}">
											<a href='${rootUrl}kusatellite/download.do?id=${attach.id}' title='点击下载文件'><span style="color: blue">${attach.attachName}</span></a>
										</sec:authorize>
									</c:if>
								</c:forEach>
							</td>					
						</tr>
					</c:forEach>
				</table>
		</c:when> 
		<c:otherwise>
			<div class="message" style="text-align: center">还没有上传任何附件！</div>
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
				<c:when test="${not empty kuSatelliteConfig}">
				<tr>
					<th width="100%" style="text-align: left;" colspan="5">
					<span style="font-weight:bolder;font-size: 13px">&nbsp;配置人员:</span><span style="font-weight:bolder;color: red;">${kuSatelliteConfig.operEngineer}</span>
					<span style="font-weight:bolder;font-size: 13px">&nbsp;联系方式:</span>010-58729911/12/14/15
					</th>
				</tr>
				<tr class="t_title">
			       <td width="10%" class="t_key">节点号</td>
			       <td width="20%" class="t_key">0号载波中频频点</td>
			       <td width="12%" class="t_key">射频发射频率</td>
			       <td width="14%" class="t_key">射频接收频率</td>
				   <td width="14%" class="t_key">配置时间</td>
		         </tr>
			       <tr class="t_title">
				    <td>${kuSatelliteConfig.node}</td>
		            <td>${kuSatelliteConfig.mediumFrequency}</td>
		            <td>${kuSatelliteConfig.emissionFrequency}</td>
				    <td>${kuSatelliteConfig.receiveFrequency}</td>
				    <td><fmt:formatDate	value="${kuSatelliteConfig.operDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
			<c:when test="${approveInfos.size()!=0}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;"><fmt:formatDate
								value="${vo.approveTime.time}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /> <span
							style="font-weight: bolder; font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }<span
							style="font-weight: bolder; font-size: 13px">&nbsp;操作人:</span>${vo.username }
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
								<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_downloadreturned']}">
									<a href='${rootUrl}kusatellite/downloadReturnedReport.do?reportAddress=${vo.reportAddress}&outlineAddress=${vo.outlineAddress}' title='点击下载文件'><span style="color: blue">附件</span></a>
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