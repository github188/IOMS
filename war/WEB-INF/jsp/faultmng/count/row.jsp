<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr onClick="changeshow(${vo.faultNumber})" style="font-weight: bold;">
	<!-- 工作流中使用 -->
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.taskName}"></c:set>
	<!-- 工作流中使用 -->
	<td id="faultManage-${vo.faultNumber }"><span class='folder'>
			<a href="${rootUrl }faultmng/fault/view.do?faultId=${vo.id}"
			class="my_view {boxwidth:750,boxheight:700}">${vo.faultNumber}</a>
	</span><input id="faultNumber" name="faultNumber" type="hidden"
		value="${vo.faultNumber}"> <c:if
			test="${!empty vo.faultInformations}">
			<img alt="展开子故障单" src="${rootUrl }images/btn/qxzd.gif" />
		</c:if></td>
	<%-- <td>${vo.contactsName}</td>
	<td>${vo.telephoneNumber}</td> --%>
	<td>${vo.currentHandleUser}</td>
	<%-- <td>${vo.stationPhone}</td> --%>
	<td><fmt:formatDate value="${vo.pickUpPhoneTime }" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.faultArea}</td>
	<td>${vo.eventType.value}</td>
	<td>${vo.faultLevel.value}</td>
	<%-- <td>${vo.source.value}</td>
	<td>${vo.remark}</td> --%>
	<td><c:if
			test="${vo.faultStatus ne 'SUCCESS' && vo.faultStatus ne 'DELETE' }">
			<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.taskName}</a>
		</c:if> <c:if test="${vo.faultStatus eq 'SUCCESS' }">
			<span>${vo.taskName}</span>
		</c:if> <c:if test="${vo.faultStatus eq 'DELETE' }">
			<span>${vo.faultStatus.value}</span>
		</c:if></td>
	<!-- 管理员操作 -->
	<c:if test="${currentUser.id eq 'admin'}">
		<td><c:if
				test="${vo.source ne 'OFFPOPUP' && vo.source ne 'KUALARM' && vo.faultStatus ne 'DELETE'  && vo.faultStatus ne 'SUCCESS'  }">
				<!-- 第一处理人和管理员可以修改故障单 -->
				<a href="${rootUrl }faultmng/fault/faultEdit.do?faultId=${vo.id}"
					class="my_edit {boxwidth:750,boxheight:500}">&nbsp;修改&nbsp;</a>
				<!-- 管理员（后期添加可删除故障单的角色）可以修改故障单 -->
				<c:if test="${vo.faultStatus ne 'WAIT'}">
					<a href="#" onclick="deleteFault('${vo.id}')">&nbsp;删除&nbsp;</a>
					<%-- 					<a href="${rootUrl }faultmng/fault/faultDel.do?faultId=${vo.id}"
						id="del" confirm_message="您确定删除该任务?"
						onclick="changeFault('${vo.id},del')" class="my_remove">&nbsp;删除&nbsp;</a> --%>
				</c:if>
			</c:if></td>
	</c:if>
</tr>
<c:forEach items="${vo.faultInformations}" var="faultInfo">
	<!-- 页面展示控制 -->
	<input name="faultChildNumber${vo.faultNumber }"
		id="faultChildNumber${vo.faultNumber }"
		value="${faultInfo.faultChildNumber}" type="hidden" />
	<input name="changeshowtype${vo.faultNumber }"
		id="changeshowtype${vo.faultNumber }" value="0" type="hidden" />
	<!-- 页面展示控制 -->
	<!-- 工作流中使用 -->
	<c:set var="pi1" value="${faultInfo.processInstanceId}" />
	<c:set var="tn1" value="${faultInfo.taskName}"></c:set>
	<tr id="child-${vo.faultNumber }-${faultInfo.faultChildNumber}">
		<c:choose>
			<c:when test="${currentUser.id eq 'admin' }">
				<td colspan="13" align="center">
			</c:when>
			<c:otherwise>
				<td colspan="12" align="center">
			</c:otherwise>
		</c:choose>
		<table name="childTable" id="table-${faultInfo.faultNumber }"
			style="width: 95%" class="table table-bordered">
			<thead>
				<tr>
					<th>事件单编号</th>
					<th>申告人</th>
					<th>申告电话</th>
					<th>处理人</th>
					<th>坐席电话</th>
					<th>申告日期</th>
					<th>事件发生地址</th>
					<th>事件类别</th>
					<th>事件级别</th>
					<th>事件单来源</th>
					<th>备注</th>
					<th>当前状态</th>
					<c:if test="${currentUser.id eq 'admin' }">
						<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<tr id="childTableTr" name="childTableTr">
					<td><span class='folder'> <a
							href="${rootUrl }faultmng/fault/view.do?faultId=${faultInfo.id}"
							class="my_view {boxwidth:750,boxheight:500}">${faultInfo.faultNumber}</a>
					</span></td>
					<td>${faultInfo.contactsName}</td>
					<td>${faultInfo.telephoneNumber}</td>
					<td>${faultInfo.currentHandleUser}</td>
					<td>${faultInfo.stationPhone}</td>
					<td><fmt:formatDate value="${faultInfo.pickUpPhoneTime }"
							type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${faultInfo.faultArea}</td>
					<td>${faultInfo.eventType.value}</td>
					<td>${faultInfo.faultLevel.value}</td>
					<td>${faultInfo.source.value}</td>
					<td>${faultInfo.remark}</td>
					<td><c:if
							test="${faultInfo.faultStatus ne 'SUCCESS' && faultInfo.faultStatus ne 'DELETE' }">
							<a class="trace" href='#' pid="${pi1}" title="点击查看流程图">${faultInfo.taskName}</a>
						</c:if> <c:if test="${faultInfo.faultStatus eq 'SUCCESS' }">
							<span>${faultInfo.taskName}</span>
						</c:if> <c:if test="${faultInfo.faultStatus eq 'DELETE' }">
							<span>${faultInfo.faultStatus.value}</span>
						</c:if></td>
					<c:if test="${currentUser.id eq 'admin'}">
						<td><c:if
								test="${faultInfo.source ne 'OFFPOPUP' && vo.source ne 'KUALARM' && faultInfo.faultStatus ne 'DELETE' && faultInfo.faultStatus ne 'SUCCESS'  }">
								<!-- 第一处理人和管理员可以修改故障单 -->
								<a
									href="${rootUrl }faultmng/fault/faultEdit.do?faultId=${faultInfo.id}"
									class="my_edit {boxwidth:750,boxheight:500}">&nbsp;修改&nbsp;</a>
								<!-- 管理员（后期添加可删除故障单的角色）可以修改故障单 -->
								<c:if test="${faultInfo.faultStatus ne 'WAIT'}">
									<a href="#" onclick="deleteFault('${faultInfo.id}')">&nbsp;删除&nbsp;</a>
									<%-- 									<a
										href="${rootUrl }faultmng/fault/faultDel.do?faultId=${faultInfo.id}"
										id="del" confirm_message="您确定删除该任务?"
										onclick="changeFault('${faultInfo.id},del')" class="my_update">&nbsp;删除&nbsp;</a> --%>
								</c:if>
							</c:if></td>
					</c:if>
				</tr>
				<tr name="childTableTr"
					id="childhandle-${vo.faultNumber }-${faultInfo.faultChildNumber }">
					<c:if test="${currentUser.id eq 'admin' }">
						<td colspan="13" align="center">
							<table style="width: 100%;" class="table-left table-bordered">
								<thead style="text-align: center;">
									<tr>
										<th style="width: 15%">处理时间</th>
										<th style="width: 10%">操作</th>
										<th width="10%">处理人</th>
										<th width="10%">下一处理人</th>
										<th width="20%">事件描述</th>
										<th width="20%">处理过程</th>
										<th width="15%">备注</th>
									</tr>
								</thead>
								<tbody style="text-align: center;">
									<c:choose>
										<c:when test="${empty faultInfo.faultHandles }">
											<td name="childTableTr" colspan="7">尚未有处理记录！</td>
										</c:when>
										<c:otherwise>
											<c:forEach items="${faultInfo.faultHandles }" var="handle">
												<tr name="childTableTr">
													<td><fmt:formatDate value="${handle.operatTime }"
															type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td>${handle.handleType.value }</td>
													<td>${handle.operator.name }</td>
													<td>${handle.nextHanleUser }</td>
													<td>${handle.faultDesc }</td>
													<td>${handle.handleDesc }</td>
													<td>${handle.remark }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</td>
					</c:if>
					<c:if test="${currentUser.id ne 'admin' }">
						<td colspan="12" align="center">
							<table style="width: 100%" class="table-left table-bordered">
								<thead style="text-align: center;">
									<tr>
										<th style="width: 20%">处理时间</th>
										<th style="width: 10%">操作</th>
										<th width="10%">处理人</th>
										<th width="20%">事件描述</th>
										<th width="20%">处理过程</th>
										<th width="20%">备注</th>
									</tr>
								</thead>
								<tbody style="text-align: center;">
									<c:choose>
										<c:when test="${empty faultInfo.faultHandles }">
											<td name="childTableTr" colspan="6">尚未有处理记录！</td>
										</c:when>
										<c:otherwise>
											<c:forEach items="${faultInfo.faultHandles }" var="handle">
												<tr name="childTableTr">
													<td><fmt:formatDate value="${handle.operatTime }"
															type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td>${handle.handleType.value }</td>
													<td>${handle.operator.name }</td>
													<td>${handle.faultDesc }</td>
													<td>${handle.handleDesc }</td>
													<td>${handle.remark }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</td>
					</c:if>
				</tr>
			</tbody>
		</table>
		</td>
	</tr>
</c:forEach>
