<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="formModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">事件单详情</h4>
			</div>
			<div class="modal-body" style="padding-left: 20px;">
				<table width="100%" class="table table-bordered">
					<tr>
						<th>事件单编号</th>
						<td colspan="3">${fault.faultNumber }</td>
					</tr>
					<tr>
						<th>申告电话</th>
						<td>${fault.telephoneNumber }</td>
						<th>申告联系人</th>
						<td>${fault.contactsName }</td>
					</tr>
					<tr>
						<th>所属单位</th>
						<td>${fault.faultCompany }</td>
						<th>事件类别</th>
						<td>${fault.eventType.value }</td>
					</tr>
					<c:if test="${fault.eventType.value ne 'ENVIRONMENT' and  fault.eventType.value ne 'OTHER'}">
					<tr>
						<th>是否有备份</th>
						<td>
							<c:if test="${fault.backups eq 'yes' }">
								是
							</c:if>
							<c:if test="${fault.backups eq 'no' }">
								否
							</c:if>
						</td>
						<th>是否需立即恢复</th>
						<td>
							<c:if test="${fault.renew eq 'yes' }">
								是
							</c:if>
							<c:if test="${fault.renew eq 'no' }">
								否
							</c:if>
						</td>
					</tr>
				</c:if>
				<c:if test="${fault.eventType.value eq 'ATM'}">
					<tr>
						<th>业务类型</th>
						<td>
							<c:if test="${fault.serviceType eq 'airControl' }">
								空管
							</c:if>
							<c:if test="${fault.serviceType eq 'officeWork' }">
								办公
							</c:if>
						</td>
						<th>&nbsp;</th>
						<td>&nbsp;</td>
					</tr>
				</c:if>
					<tr>
					<th>事件等级</th>
					<td>${fault.faultLevel }级</td>
						<th>事件发生时间</th>
						<td><fmt:formatDate value="${fault.faultTime }" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th>事件发生地址</th>
						<td>${fault.faultArea }</td>
						<th>事件单创建时间</th>
						<td><fmt:formatDate value="${fault.createTime }" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th>第一处理人</th>
						<td>${fault.firstHandelUser.name }</td>
						<th>坐席电话</th>
						<td>${fault.stationPhone }</td>
					</tr>
					
					<c:if test="${fault.faultArea eq '北京网控中心' }">
						<tr>
							<th>事件归类父类</th>
							<td>${fault.faultTypeId.typeName }</td>
							<th>事件归类子类</th>
							<td>${fault.faultTypeChildId.typeInfo }</td>
						</tr>
						<tr>
							<th>事件设备数量</th>
							<td>${fault.faultDeviceNumber }</td>
							<th>影响业务数量</th>
							<td>${fault.effectProfessionNumber }</td>
						</tr>
						<tr>
							<th>事件单来源</th>
							<td>${fault.source.value }</td>
							<th>&nbsp;</th>
							<td>&nbsp;</td>
						</tr>
					</c:if>
					<c:if test="${fault.faultArea ne '北京网控中心' }">
						<tr>
							<th>事件归类类型</th>
							<td>${fault.faultTypeId.typeName }</td>
							<th>事件单来源</th>
							<td>${fault.source.value }</td>
						</tr>
					</c:if>
				</table>
				<div style="color: color:#fff;">
					<h5>事件处理记录详情</h5>
				</div>
				<table width="100%" class="table table-bordered">
					<tr>
						<th style="width: 15%">提交时间</th>
						<th style="width: 10%">状态</th>
						<th width="10%">处理人</th>
						<th width="10%">下一个处理人</th>
						<th width="20%">事件描述</th>
						<th width="20%">处理过程</th>
						<th width="15%">备注</th>
					</tr>
					<c:forEach items="${faultHandles}" var="handles"
						varStatus="voStatus">
						<c:if test="${handles.handleType ne 'FAULTTEMPRARY' }">
							<tr>
								<td><fmt:formatDate value="${handles.operatTime }"
										type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${handles.handleType.value }</td>
								<td>${handles.operator.name }</td>
								<td>${handles.nextHanleUser }</td>
								<td>${handles.faultDesc }</td>
								<td>${handles.handleDesc }</td>
								<td>${handles.remark }</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div class="modal-footer">
		       <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close" style="height:30px;margin-left: 260px;">
			   关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- /.modal -->
<script>
	$(function() {		
		$('#formModal').modal({
			keyboard : true
		})
	});
</script>