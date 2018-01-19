
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
.fontRed {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm" /></td>

	<td><c:choose>
			<c:when test="${vo.hostDmhsMonPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostDmhsMonPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostDmhsMonPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /库操作进程 -->
	<td><c:choose>
			<c:when test="${vo.hostDmhsAfsPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostDmhsAfsPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostDmhsAfsPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /双机进程 -->
	<td><c:choose>
			<c:when test="${vo.hostIPPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostIPPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostIPPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /IP进程 -->
    <td><c:choose>
			<c:when test="${vo.hostR25Pro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostR25Pro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostR25Pro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /R25进程 -->
	
	 <td><c:choose>
			<c:when test="${vo.hostAsynPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostAsynPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostAsynPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /异步进程 -->
	
	 <td><c:choose>
			<c:when test="${vo.hostFRPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostFRPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostFRPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /帧中继进程 -->
	
		 <td><c:choose>
			<c:when test="${vo.hostMATIPPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostMATIPPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostMATIPPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /matip进程 -->
			 <td><c:choose>
			<c:when test="${vo.hostDBPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostDBPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostDBPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /数据库进程 -->
 <td><c:choose>
			<c:when test="${vo.backupDmhsMonPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupDmhsMonPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupDmhsMonPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /库操作进程-->
	
	 <td><c:choose>
			<c:when test="${vo.backupDmhsAfsPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupDmhsAfsPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupDmhsAfsPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /双机进程-->
    <td><c:choose>
			<c:when test="${vo.backupDBPro eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupDBPro.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupDBPro.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /数据库进程-->
	    <td><c:choose>
			<c:when test="${vo.hostIProIpA eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostIProIpA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostIProIpA.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /IP连接进程-->
	 <td><c:choose>
			<c:when test="${vo.hostIProSerialPortA eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostIProSerialPortA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostIProSerialPortA.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /串口通信进程-->
	
		 <td><c:choose>
			<c:when test="${vo.hostIProIpB eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostIProIpB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostIProIpB.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /IP连接进程-->
	 <td><c:choose>
			<c:when test="${vo.hostIProSerialPortB eq 'ABNORMAL'}">
				<font class="fontRed">${vo.hostIProSerialPortB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.hostIProSerialPortB.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /串口通信进程-->
		 <td><c:choose>
			<c:when test="${vo.backupIProIpA eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupIProIpA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupIProIpA.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /IP连接进程-->
		 <td><c:choose>
			<c:when test="${vo.backupIProSerialPortA eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupIProSerialPortA.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupIProSerialPortA.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /串口通信进程-->
		 <td><c:choose>
			<c:when test="${vo.backupIProIpB eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupIProIpB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupIProIpB.value}
				</c:otherwise>
		</c:choose></td>
	<!-- /IP连接进程-->
			 <td><c:choose>
			<c:when test="${vo.backupIProSerialPortB eq 'ABNORMAL'}">
				<font class="fontRed">${vo.backupIProSerialPortB.value}</font>
			</c:when>
			<c:otherwise>
					${vo.backupIProSerialPortB.value}
				</c:otherwise>
		</c:choose></td>
		
	<!-- /串口通信进程-->
	
	<td>${vo.creater.name}<br></br> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.judgeUser.name}<br></br> <fmt:formatDate
			value="${vo.judgeTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>

	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_process_view']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/process/view.do?id=${vo.id}"
				id="viewRecord" class="my_edit {boxwidth:1000,boxheight:700}">查看</a>
		</sec:authorize> <c:if test="${vo.judgeState eq 'WAIT'}">
			<c:if test="${currentUser.name !=vo.creater.name}">
				<sec:authorize
					ifAnyGranted="${jspAuthorities['faxsystem_process_judge']}">
					<a href="${rootUrl}duty/fax/day/faxsystem/process/judge.do?id=${vo.id}"
						id="judgeRecord" class="my_edit {boxwidth:1200,boxheight:1000}">审核</a>
				</sec:authorize>
			</c:if>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_process_mod']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/process/mod.do?id=${vo.id}"
				id="modRecord" class="my_edit {boxwidth:1200,boxheight:1000}">修改</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['faxsystem_process_del']}">
			<a href="${rootUrl}duty/fax/day/faxsystem/process/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
