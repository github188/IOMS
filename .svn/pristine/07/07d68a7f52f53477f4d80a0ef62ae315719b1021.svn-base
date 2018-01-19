<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }ueditor/ueditor.config.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$.ajaxSetup({
			cache : false
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
		var faultEvaluate = $("#faultEvaluate").val();
		var evaluateHtm = "";
		if(faultEvaluate == "very_satisfied"){
			evaluateHtm += "<input type='radio' disabled checked/>非常满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>一般&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>不满意&nbsp;";
		}else if(faultEvaluate == "satisfied"){
			evaluateHtm += "<input type='radio' disabled/>非常满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled checked/>满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>一般&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>不满意&nbsp;";
		}else if(faultEvaluate == "soso"){
			evaluateHtm += "<input type='radio' disabled/>非常满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled checked/>一般&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>不满意&nbsp;";
		}else if(faultEvaluate == "very_soso"){
			evaluateHtm += "<input type='radio' disabled/>非常满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>满意&nbsp;";
			evaluateHtm += "<input type='radio' disabled/>一般&nbsp;";
			evaluateHtm += "<input type='radio' disabled checked/>不满意&nbsp;";
		}
		$("#evaluateTd").append(evaluateHtm);
	});
</script>
<style>
th {
	background-color: #DDDDDD;
	text-align: center ! important;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}

td {
	 word-break:break-all;
}
</style>
</head>

<body style="overflow-x: hidden">

	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px;">
		<dl class="title">
			<dd>事件单详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>事件单详情</dd>
				</dl>
			</div>
			<table width="100%">
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

			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>事件处理记录</dd>
				</dl>
			</div>
			<table width="100%" style="word-break:break-all">
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
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>事件单评价详情</dd>
				</dl>
			</div>
			<form:form id="addForm" name="addForm"
				action="${rootUrl }faultmng/fault/evaluate.do" method="post">
				<table width="100%">
					<c:if test="${faultEvaluate.evaluate eq null}">
						<tr>
							<td style="text-align: center;" colspan="4">尚未评价</td>
						</tr>
					</c:if>
					<c:if test="${faultEvaluate.evaluate ne null}">
						<tr>
							<td style="text-align: center;">事件处置满意度</td>
							<td style="text-align: center;" colspan="3" id="evaluateTd">
							<input type="hidden" name="faultEvaluate" id="faultEvaluate" value="${faultEvaluate.evaluate }"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;" colspan="4">备注</td>
						</tr>
						<tr>
							<td style="text-align: center;" colspan="4"><textarea
									id="remark" name="remark" rows="3" cols="90" readonly="readonly">${faultEvaluate.remark }</textarea></td>
						</tr>
					</c:if>
				</table>
			</form:form>
			<table width="100%">
				<tr align="center">
					<td colspan="4" align="center" valign="middle">
						<span class="btn" style="margin-left: 320px"> <a href="#none" id="goback" class="goback">关闭</a></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>