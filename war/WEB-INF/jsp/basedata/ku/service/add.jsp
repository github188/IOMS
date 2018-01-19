<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				txNodeNo : {
					required : true,
					digits : true,
					min : 0,
					max : 999
				},
				rxNodeNo : {
					required : true,
					digits : true,
					min : 0,
					max : 999
				},
				txGib : {
					required : true,
					digits : true,
					min : 1,
					max : 99
				},
				rxGib : {
					required : true,
					digits : true,
					min : 1,
					max : 99
				},
				txChan : {
					required : true,
					digits : true,
					min : 0,
					max : 99
				},
				rxChan : {
					required : true,
					digits : true,
					min : 0,
					max : 99
				},
				cxr : {
					digits : true,
					min : 0,
					max : 31
				},
				start : {
					digits : true,
					min : 0,
					max : 36960
				},
				serviceType : {
					maxlength : 10
				},
				code : {
					required : true,
					maxlength : 20,
					kuServiceCode : true
				//remote : '${rootUrl}basedata/checkKuService.dox'
				},
				rateType : {
					required : true
				},
				circuitInfo : {
					maxlength : 50
				},
				usage : {
					maxlength : 50
				},
				crm : {
					maxlength : 50
				},
				info : {
					maxlength : 50
				},
				memo : {
					maxlength : 500
				}

			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		$("#submit")
				.click(
						function() {
							if ($("#txNodeNo").val() != "") {

								$
										.ajax({
											url : "${rootUrl}basedata/kuNodeExist.dox?kuNodeNo="
													+ $("#txNodeNo").val()
													+ "&subnetType="
													+ $("#subnetTypeTx").val(),
											async : false,
											success : function(result) {
												$("label[for='txNodeNo']")
														.remove();
												if (result.indexOf("false") >= 0) {
													$("#txNodeNo")
															.after(
																	"<label class='error' for='txNodeNo' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 节点不存在!</label>");
												}
											}
										});
							}
							if ($("#rxNodeNo").val() != "") {
								$
										.ajax({
											url : "${rootUrl}basedata/kuNodeExist.dox?kuNodeNo="
													+ $("#rxNodeNo").val()
													+ "&subnetType="
													+ $("#subnetTypeRx").val(),
											async : false,
											success : function(result) {
												$("label[for='rxNodeNo']")
														.remove();
												if (result.indexOf("false") >= 0) {
													$("#rxNodeNo")
															.after(
																	"<label class='error' for='rxNodeNo' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 节点不存在!</label>");
												}
											}
										});
							}
							if ($("label[for='txNodeNo']").length > 0) {
								return;
							}
							if ($("label[for='rxNodeNo']").length > 0) {
								return;
							}
							if ($("#bureau").val() == "") {
								$("label[for='bureau']").remove();
								$("#bureau")
										.after(
												"<label class='error' for='bureau' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 必填项</label>");
							} else {
								$("label[for='bureau']").remove();
							}
							if ($("label[for='bureau']").length > 0) {
								return;
							}
							if ($("#configTime").val() == "") {
								$("label[for='configTime']").remove();
								$("#configTime")
										.after(
												"<label class='error' for='configTime' >&nbsp;<img src='${rootUrl}/images/validator/check_n.gif' width=16 height=16>&nbsp; 必填项</label>");
							} else {
								$("label[for='configTime']").remove();
							}
							if ($("label[for='configTime']").length > 0) {
								return;
							}
							$("#addForm").trigger("submit");

						});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/ku/service/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>数据管理--KU业务--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>KU业务信息</h1>
			<table width="96%">
				<tr>
					<th width="20%"><font color="red">(*)</font>发端子网类型:</th>
					<td><form:select path="subnetTypeTx" cssStyle="width:135px">
							<option value="">--请选择--</option>
							<form:options items="${subnetTypes}" itemLabel="value" />
						</form:select></td>
					<th width="20%"><font color="red">(*)</font>发端节点号:</th>
					<td><form:input path="txNodeNo" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>收端子网类型:</th>
					<td><form:select path="subnetTypeRx" cssStyle="width:135px">
							<option value="">--请选择--</option>
							<form:options items="${subnetTypes}" itemLabel="value" />
						</form:select></td>
					<th width="20%"><font color="red">(*)</font>收端节点号:</th>
					<td><form:input path="rxNodeNo" class="text ui-widget-content"
							cssStyle="width:100px" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>发端槽号:</th>
					<td><form:input path="txGib" cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>收端槽号:</th>
					<td><form:input path="rxGib" cssStyle="width:100px" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>发端端口:</th>
					<td><form:input path="txChan" cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>收端端口:</th>
					<td><form:input path="rxChan" cssStyle="width:100px" /></td>
				</tr>

				<tr>
					<th width="20%"><font color="red">(*)</font>纠错</th>
					<td width="30%"><form:select path="fec" cssStyle="width:105px">
							<form:option value="1/2">1/2</form:option>
							<form:option value="3/4">3/4</form:option>
							<form:option value="7/8">7/8</form:option>
						</form:select></td>
					<th width="20%"><font color="red">(*)</font>电路速率</th>
					<td width="30%"><form:select path="rateType"
							cssStyle="width:105px">
							<form:options items="${kuServiceRateTypes}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>PAMA/DAMA</th>
					<td width="30%"><form:select path="circuitType"
							cssStyle="width:105px">
							<form:option value="PAMA">PAMA</form:option>
							<form:option value="DAMA">DAMA</form:option>
						</form:select></td>
					<th width="20%"><font color="red">(*)</font>电路类型</th>
					<td width="30%"><form:select path="circuitTypeDetail"
							cssStyle="width:105px">
							<form:option value="Multi">Multi</form:option>
							<form:option value="Duplex">Duplex</form:option>
							<form:option value="Simplex">Simplex</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th width="20%">业务类型</th>
					<td width="30%"><form:input path="serviceType"
							cssStyle="width:100px" /></td>
					<th width="20%"><font color="red">(*)</font>区域</th>
					<td width="30%"><form:select path="bureau"
							cssStyle="width:105px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>电路名</th>
					<td width="30%"><form:input path="code" cssStyle="width:100px" /></td>
					<th width="20%">起始点</th>
					<td width="30%"><form:input path="start"
							cssStyle="width:100px" /></td>
				</tr>
				<tr>
					<th width="20%">载波</th>
					<td width="30%"><form:input path="cxr" cssStyle="width:100px" /></td>
				</tr>
				<tr>
					<th width="20%">电路情况</th>
					<td colspan="3"><form:input path="circuitInfo"
							cssStyle="width:470px" /></td>
				</tr>
				<tr>
					<th width="20%">使用情况</th>
					<td colspan="3"><form:input path="usage"
							cssStyle="width:470px" /></td>
				</tr>
				<tr>
					<th width="20%">CRM情况</th>
					<td colspan="3"><form:input path="crm" cssStyle="width:470px" /></td>
				</tr>
				<tr>
					<th width="20%">收端信息</th>
					<td colspan="3"><form:input path="memo" cssStyle="width:470px" /></td>
				</tr>
				<tr>
					<th width="20%">备注</th>
					<td colspan="3"><form:input path="info" cssStyle="width:470px" /></td>
				</tr>
			</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>