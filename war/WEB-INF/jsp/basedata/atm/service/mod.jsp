<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
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
<script>
	$(function() {
		$("option[value = "+ $("#serviceType1").val() +"]").attr("selected","selected");
		$.ajaxSetup({
			cache : false
		});
		$("#modForm").validate({
		rules : {
			serviceName : {
				required: true,
				maxlength : 35
			},
			localConnEquip : {
				maxlength : 35
			},
			remoteConnEquip : {
				maxlength : 35
			}
			},
			
			submitHandler : function(form) {
				parent.editSubmit(form);
			} 
		});
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
		function validate(formData, jqForm, options) {
			return $("#modForm").valid();
		}
		$("#submit").click(function(){
			$("#modForm").validate();
			//$("#modForm").trigger("submit");
			//window.parent.location.reload();
			$("#modForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				//timeout : timeOutSeconds, 
				success : function(data, status, xhr) {
					if (data.success == true) {
						//alert("操作成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						//alert("分配失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				},
				error: function (xmlHttpRequest, error) { 
					alert("请求超时");
					parent.$.nyroModalRemove();
					window.top.location.reload();
                } 
			})
		});
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#modForm").valid();
	}
</script>
</head>
<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }basedata/atm/service/mod.do" method="post">
		<form:hidden path="id" />
		<dl class="title">
			<dd>ATM业务管理--修改</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->		

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
				  <th colspan="4"
						style="color: gray; width: 100%; text-align: center;">ATM业务信息</th>
  </tr>
				<tr>
				  <th colspan="2">业务名称：<form:input color="black" path="serviceName"></form:input></th>
  			      <th colspan="1">业务类型：</th>
  			     <form:hidden id="serviceType1" path="atmType.id" />
  			     <td><form:select id="atmType" path="atmType"
							style="width: 100%" >
								<c:forEach items="${serviceTypes }" var="vo">
									<option id="serviceType" value="${vo.id }">${vo.serviceType}</option>
								</c:forEach> 
						</form:select></td>
  </tr>
				<tr>
				  <th colspan="2">本地节点</th>
				  <th colspan="2">远端节点</th>
  </tr>
				<tr>
					<th width="20%">节点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.localNode.atmNodeCode)}</td>
					<th width="20%">节点代码</th>
					<td width="30%">${fn:escapeXml(pageModel.remoteNode.atmNodeCode)}</td>
				</tr>
				<tr>
					<th width="20%">端口号</th>
					<td width="30%">${pageModel.localPort}</td>
					<th width="20%">端口号</th>
					<td width="30%">${pageModel.remotePort}</td>
				</tr>
				<tr>
					<th width="20%">端口速率（kbps）</th>
					<td width="30%">${pageModel.localPortCir}</td>
					<th width="20%">端口速率（kbps）</th>
					<td width="30%">${pageModel.remotePortCir}</td>
				</tr>

				<tr>
					<th width="20%">端口时钟类型</th>
					<td width="30%">${pageModel.localPortClockType}</td>
					<th width="20%">端口时钟类型</th>
					<td width="30%">${pageModel.remotePortClockType}</td>
				</tr>
				<tr>
					<th width="20%">dlci/ vpi.vci</th>
					<td width="30%">${pageModel.localPortDLCIVPIVCI}</td>
					<th width="20%">dlci/ vpi.vci</th>
					<td width="30%">${pageModel.remotePortDLCIVPIVCI}</td>
				</tr>
				<tr>
					<th width="20%">接入设备</th>
					
					<td width="30%"><form:input color="black" path="localConnEquip"></form:input></td>
					<th width="20%">接入设备</th>
					<td width="30%"><form:input color="black" path="remoteConnEquip"></form:input></td>
				</tr>
				<%-- <tr>
					<th width="20%">主备叫关系</th>
					<td width="30%">${pageModel.localPortClockType}</td>
					<th width="20%">主备叫关系</th>
					<td width="30%">${pageModel.remotePortClockType}</td>
				</tr> --%>
				<tr>
					<th width="20%">速率（kbps）</th>
					<td colspan="1">${pageModel.serviceCir}</td>
					<th width="20%">采集状态</th>
					<td colspan="1">${pageModel.serviceChangeType.value}</td>
				</tr>
				<tr>
					<th width="20%">服务级别</th>
					<td colspan="3">${pageModel.serviceClass}</td>
				</tr>
				<tr>
					<th width="20%">有/无备用</th>
					<td colspan="3"><form:input color="black" path="serviceStandbyInfo"></form:input></td>
				</tr>
				<tr>
					<th width="20%">电路主备关系说明</th>
					<td colspan="3">${pageModel.serviceMsInfo}</td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3"><form:input color="black" path="serviceRemark"></form:input></td>
				</tr>
			</table>
			
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="closeButton">取消</a>
				</div>
			</div>
			<br />
		</div>
		<!-- end 详情内容-->
	</form:form>
</body>
</html>