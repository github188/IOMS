<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<!-- 工作流中使用 -->
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.taskName}"></c:set>
	<!-- 工作流中使用 -->
	<td>
	  
	     <c:if test="${vo.source.name eq 'KUALARM'}">
	        <img src="${rootUrl }images/img/Alarm_icon.png"></img>
	    </c:if>
	    <c:if test="${vo.source.name eq 'OFFPOPUP'}">
	        <img src="${rootUrl }images/img/phone_icon.png"></img>
	    </c:if>
	    <c:if test="${vo.source.name eq 'YUZHIALARM'}">
	        <img src="${rootUrl }images/img/Alarm_icon.png"></img>
	    </c:if>
	    <c:if test="${vo.source.name eq 'MANUALADD'}">
	        <img src="${rootUrl }images/img/Edit_icon.png"></img>
	    </c:if>
	</td>
	<td>
	   <c:if test="${vo.faultLevel.name eq 'A'}">
	    <span class="label label-danger">${vo.faultNumber}</span>
	   </c:if>
	   <c:if test="${vo.faultLevel.name eq 'B'}">
	    <span class="label label-warning">${vo.faultNumber}</span>
	   </c:if>
	   <c:if test="${vo.faultLevel.name eq 'C'}">
	   <span class="label label-info">${vo.faultNumber}</span>
	   </c:if>
	   <input type="hidden" name="faultId"
		value="${vo.id}" /></td>
	<td>${vo.contactsName}</td>
	<td><fmt:formatDate value="${vo.pickUpPhoneTime}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.telephoneNumber}</td>
	<td>${vo.faultArea}</td>
	<td>${currentHandleUser}</td>
	<td>${vo.eventType.value}</td>
	<td>${vo.faultLevel.value}</td>
	<td class="tdbtn">
		<c:if test="${vo.faultStatus ne 'SUCCESS' }">
			<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.taskName}</a>
		</c:if>
		<c:if test="${vo.faultStatus eq 'SUCCESS' }">
			<span>${vo.taskName}</span>
		</c:if>
		
	</td>
<c:if test="${currentHandleUser eq '管理员' || isflag eq 'yes' || currentHandleUser ne vo.firstHandelUser.name}">
		<td>
			<c:if test="${vo.faultStatus ne 'ASSIGNOK' || ( vo.faultStatus eq 'ASSIGNOK' && vo.hasHandleUser eq true )}">
				<c:if test="${vo.faultStatus eq 'HANGUP' }">
					<a href="${rootUrl }faultmng/fault/assign.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:500}">&nbsp;值班经理分配&nbsp;</a>
				</c:if> 
				
				<c:if test="${vo.faultStatus eq 'ASSIGN'}">
					<a href="${rootUrl }faultmng/fault/faultdept.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:700}">&nbsp;部门经理分配&nbsp;</a>
					<a href="${rootUrl }faultmng/fault/faultBack.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:500}">&nbsp;退回&nbsp;</a>
				</c:if> 
				
				<c:if test="${vo.faultStatus eq 'WAIT'}">
					<a href="${rootUrl }phonemng/callcenter/faulthandle.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:700}">&nbsp;第一处理人处理&nbsp;</a>
					<%-- <a href="${rootUrl }faultmng/faultTemporary.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:850}">&nbsp;暂存&nbsp;</a> --%>
				</c:if> 
				
				<c:if test="${vo.faultStatus eq 'HANDLE'}">
					<a href="${rootUrl }faultmng/fault/handle.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:850}">&nbsp;处理&nbsp;</a>
				</c:if>
				
				<c:if test="${vo.faultStatus eq 'ASSIGNOK'}">
					<a href="${rootUrl }faultmng/fault/handle.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:850}">&nbsp;待技术工程师处理&nbsp;</a>
				</c:if> 
				
				<c:if test="${vo.faultStatus eq 'CLASSIFY'}">
					<a href="${rootUrl }phonemng/callcenter/faultclassify.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:850}">&nbsp;归类&nbsp;</a>
				</c:if>
				
				<c:if test="${vo.firstHandelUser.name eq currentHandleUser && vo.faultStatus ne 'CLASSIFY' && vo.faultStatus ne 'HANGUP' && vo.faultStatus ne 'SUCCESS'}">
					<a href="${rootUrl }phonemng/callcenter/faulthangup.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:600}">&nbsp;挂起&nbsp;</a>
				</c:if>
				
				<c:if test="${vo.faultStatus eq 'SUCCESS'}">
					<a href="${rootUrl }faultmng/fault/view.do?faultId=${vo.id}"
						class="my_view {boxwidth:750,boxheight:850}">&nbsp;详情&nbsp;</a>
				</c:if>
				
				<c:if test="${vo.taskName eq '坐席值班员处理' }"><!-- ||  vo.taskName eq '其他部门处理' -->
					<a href="${rootUrl }faultmng/fault/faultBack.do?faultId=${vo.id}"
						class="my_edit {boxwidth:750,boxheight:500}">&nbsp;退回&nbsp;</a>
				</c:if>
				
				 <c:if test="${vo.source ne 'OFFPOPUP' && vo.faultStatus ne 'SUCCESS' }">
				 
					<!-- 第一处理人和管理员可以修改故障单 -->
					<c:if test="${(vo.firstHandelUser.name eq currentHandleUser || currentHandleUser eq '管理员') && vo.faultStatus ne 'DELETE'}">
						<a href="${rootUrl }faultmng/fault/faultEdit.do?faultId=${vo.id}"
							class="my_edit {boxwidth:750,boxheight:500}">&nbsp;修改&nbsp;</a>
					</c:if>
					
					<!-- 管理员（后期添加可删除故障单的角色）可以修改故障单 -->
					<c:if test="${currentHandleUser eq '管理员' && vo.faultStatus ne 'WAIT' && vo.faultStatus ne 'DELETE'}">
						<a href="#" onclick="deleteFault('${vo.id}')">&nbsp;删除&nbsp;</a>
<%-- 						<a href="${rootUrl }faultmng/fault/faultDel.do?faultId=${vo.id}" id="del" confirm_message="您确定删除该任务?" 
						onclick="changeFault('${vo.id},del')" class="my_remove" >&nbsp;删除&nbsp;</a> --%>
					</c:if>
				</c:if>
				
			</c:if>
			</td>
	</c:if>
	<c:if test="${currentHandleUser ne '管理员' && isflag eq 'no' && currentHandleUser eq vo.firstHandelUser.name}">
		<td>
			<a href="${rootUrl }faultmng/fault/view.do?faultId=${vo.id}"
				class="my_view {boxwidth:750,boxheight:600}">&nbsp;详情&nbsp;</a>
		</td>
	</c:if>
</tr>
