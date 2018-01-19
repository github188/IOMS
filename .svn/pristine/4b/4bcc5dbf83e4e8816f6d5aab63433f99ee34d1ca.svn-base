<%@ page contentType="text/html;charset=utf-8"%>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<td width="12%">申请单位<span style="color: red">*</span>：</td>
	<td width="40%"  colspan="2">${kuSatellite.applyBaseInfo.applyCom }</td>
	<td width="13%">联系人<span style="color: red">*</span>：</td>
	<td width="35%"  colspan="2">${kuSatellite.applyBaseInfo.applyLinkman}</td>
</tr>
<tr>
	<td width="20%">联系电话/传真<span style="color: red">*</span>：</td>
	<td width="30%"  colspan="2">${kuSatellite.applyBaseInfo.applyPhone}/${kuSatellite.applyFax}</td>
	<td width="20%">申请单位签字/盖章<span style="color: red">*</span>：</td>
	<td width="30%"  colspan="2">${kuSatellite.applyComSign}</td>
</tr>
<tr>
	<td>远端站名称<span style="color: red">*</span>：</td>
	<td colspan="2">${kuSatellite.txSiteName}</td>
	<td>远端站地址<span style="color: red">*</span>：</td>
	<td colspan="2">${kuSatellite.rxSiteAddress}</td>	
</tr>
<tr>
	<td rowspan="3">地理信息</td>
	<td>东经<span style="color: red"></span>：</td>
	<td>${kuSatellite.longitudeDeg}(度)${kuSatellite.longitudeMin}(分)${kuSatellite.longitudeSec}(秒)</td>
	<td rowspan="3">对星参数</td>
	<td>方位角<span style="color: red">*</span>：</td>
	<td>${kuSatellite.position}(度)</td>
</tr>
<tr>
	<td>北纬<span style="color: red"></span>：</td>
	<td>${kuSatellite.latitudeMin}(度)${kuSatellite.latitudeSec}(分)${kuSatellite.latitudeSec}(秒)</td>
	<td>俯仰角<span style="color: red">*</span>：</td>
	<td>${kuSatellite.pitching}(度)</td>
</tr>
<tr>
	<td>海拔高度<span style="color: red">*</span>：</td>
	<td>${kuSatellite.height}(米)</td>
	<td>极化角<span style="color: red">*</span>：</td>
	<td>${kuSatellite.polarization}(度)</td>
</tr>
<tr>
	<td rowspan="2">天线信息</td>
	<td>厂家及型号<span style="color: red">*</span>：</td>
	<td>${kuSatellite.antennaModel}</td>
	<td rowspan="2">室外单元信息</td>
	<td>厂家及型号<span style="color: red">*</span>：</td>
	<td>${kuSatellite.outdoorModel}</td>
</tr>
<tr>
	<td>口径<span style="color: red">*</span>：</td>
	<td>${kuSatellite.antennaDiameter}(米)</td>
	<td>发射功率<span style="color: red">*</span>：</td>
	<td>${kuSatellite.launchPower}(瓦)</td>
</tr>
<tr>
	<td rowspan="2">室内单元信息</td>
	<td>VSAT PlusII<span style="color: red">*</span>：</td>
	<td>${kuSatellite.vsatPlusllNum}(个)</td>
	<td rowspan="2">电缆信息</td>
	<td rowspan="2">长度<span style="color: red">*</span>：</td>
	<td rowspan="2">${kuSatellite.length}(米)</td>
</tr>
<tr>
	<td>VSAT PlusIIe<span style="color: red">*</span>：</td>
	<td>${kuSatellite.vsatPluslleNum}(个)</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>附件信息</dd>
	</dl>
</div>
<div style="margin: 0px 20px;padding:2px;background:#eff0f2; border: 1px solid #95bdd7;border-collapse: collapse;">
	<c:choose>
		<c:when test="${attaches.size()!=0}">
			<c:forEach items="${attaches}" var="vo" varStatus="voStatus">
				<c:choose>
					<c:when test="${vo.attachExt ne 'jpg' && vo.attachExt ne 'gif' && vo.attachExt ne 'png'}">
						<table  style="display: inline;margin: 3px 0px;border: 1px">
							<tr>
								<td style="text-align: center;">
									<img src="${vo.outlineAddress }" width="60px" height="55px" title="${vo.attachName}" alt="${vo.attachName}" />	
								</td>
							</tr>
							<tr>
								<td style="text-align: center;">
									<a href='${rootUrl }kusatellite/download.dox?id=${vo.id}' title='点击下载文档'><span style="color: blue">下载</span></a>		
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
					<table style="display: inline;margin:3px 0px;border: 1px">
							<tr>
								<td style="text-align: center;">
									<img src="${vo.attachAddress }" width="60px" height="55px" title="${vo.attachName}" alt="${vo.attachName}" />	
								</td>
							</tr>
							<tr>
								<td style="text-align: center;">
									<a href='${rootUrl }kusatellite/download.dox?id=${vo.id}' title='点击下载文档'><span style="color: blue">下载</span></a>		
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<%-- 上传时间：<fmt:formatDate value="${vo.uploadTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div style="text-align: center;color: #1f83b7;font-size: 13px;font-weight: normal;height: 20px;line-height: 20px">还没有上传任何附件！</div>
		</c:otherwise>
	</c:choose>
</div>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>审批过程</dd>
	</dl>
</div>
<table width="100%" style="margin:0px auto">
	<tbody>
		<c:choose>
			<c:when test="${approveInfos.size()!=0}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;">
							<fmt:formatDate	value="${vo.approveTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
							<span style="font-weight:bolder;font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }<span style="font-weight:bolder;font-size: 13px">&nbsp;操作人:</span>${vo.username }
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作类别:</span>
							<c:choose>
								<c:when test="${vo.approveType.name()=='reject' }">
									<span style="color:red">${vo.approveType.value}</span>
								</c:when>
								<c:otherwise>
									${vo.approveType.value}
								</c:otherwise>
							</c:choose>		
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
<c:if test="${kuSatellite.approveStat == 'evaluated' }">
	<div style="margin: 10px 20px 0px;padding:0px">
		<dl class="title">
			<dd>评价信息</dd>
		</dl>
	</div>
	<table width="100%" style="margin:0px auto">
		<tbody>
		<c:choose>
			<c:when test="${evaluateInfo!=null}">
				<table width="100%" style="margin:0px auto">
				<tbody>
					<tr>
						<th width="20%" align="right"><span style="font-size: 13px">服务评价<span style="color: red">*</span>：</span></th>
						<td width="80%">
							${evaluateInfo.grade.value}
						</td>
					</tr>
					<tr>
						<th width="20%" align="right"><span style="font-size: 13px;">备注<span style="color: red">*</span>：</span></th>
						<td width="80%">
							<div style="height: auto;text-align: left;word-break:break-all;text-indent:2em">
								${evaluateInfo.remark}
							</div>
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<tr>
					<th width="100%" style="text-align:center;">还没有评价信息！</th>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</c:if>