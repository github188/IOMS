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
<script src="${rootUrl }js/randomPsw.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		//生成6位随机密码
		var rc = "";
		rc = rc + getRandomChar();
		for (var idx = 1; idx < 6; ++idx) {
			rc = rc + getRandomChar();
		}
		//展示到密码框中
		$("#password").val(rc);

		$.ajaxSetup({
			cache : false
		});
		function judgeStatus(){
			var statuses = document.getElementsByName("status");
			if(statuses[0].checked){
				$("#modForm").validate({
					rules:{
						auditReason:{
							maxlength:1000
						}
					},
					submitHandler : function(form) {
						parent.editSubmit(form);
					}
				});
				$("#modForm").trigger("submit");
			}else if(statuses[1].checked){
				$("#modForm").validate({
					rules:{
						auditReason:{
							required : true,
							maxlength:1000
						}
					},
					submitHandler : function(form) {
						parent.editSubmit(form);
					}
				});
				$("#modForm").trigger("submit");
			}
		}
		$("#submit").click(function() {
			judgeStatus();
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
	//通过刷新清楚已提交的验证规则（审核理由必填）
	function getRadio(evt){
	    var evt=evt || window.event;   
	    var e =evt.srcElement || evt.target;
	    if(e.value == 'PASSED'){
	    	window.location.reload();
		}else if(e.value == 'DENIED'){
		}
	 }

</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }systemmng/client/audit.do" method="post">
		<form:hidden path="id" />
		<form:hidden path="password" id="password" />
		<div class="window">
			<dl class="title">
				<dd>客户信息--审核</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<!--begin 详情内容-->
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
				<table width="950px">
					<tr>
						<th colspan="4"
							style="color: gray; width: 100%; text-align: center;">客户信息</th>
					</tr>
					<tr>
						<th width="20%">姓名:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${fn:escapeXml(pageModel.name)}</td>
						<th width="20%">性别:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.sex.name}</td>
					</tr>
					<tr>
						<th width="20%">年龄:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.age}</td>
						<th width="20%">角色:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.role.info}</td>
					</tr>
					<tr>
						<th width="20%">所属管局:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.bureau.value}</td>
						<th width="20%">单位名称：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.newCompany.company}</td>
					</tr>
					<tr>
						<th width="20%">单位地址:</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.newCompany.address}</td>
						<th width="20%">单位邮编：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.newCompany.postcode}</td>
					</tr>
					<tr>
						<th width="20%">登录名：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.loginName}</td>
						<th width="20%">部门：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.branch}</td>
					</tr>
					<tr>
						<th width="20%">职务：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.job}</td>
						<th width="20%">传真：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.fax}</td>
					</tr>
					<tr>
						<th width="20%">手机号码：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.mobilephone}</td>
						<th width="20%">座机号码：</th>
						<td width="30%"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.phone}</td>
					</tr>
					<tr>
						<th width="20%">个人邮箱：</th>
						<td width="30%" colspan="3"
							style="word-break: break-all; word-wrap: break-word;">${pageModel.email}</td>
					</tr>
					<tr style="height: 50px">
						<th width="20%">备注：</th>
						<td colspan="3">${pageModel.info}</td>

					</tr>
				</table>
				<br />
			</div>
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 2px;"></div>
			<div class="mtab">
				<table width="950px">
					<tr>
						<th colspan="4"
							style="color: gray; width: 100%; text-align: center;">注册答题信息</th>
					</tr>
					<c:if test="${questionModel.size == 3}">
						<tr>
							<th width="20%">问题一：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description1 }</td>
						</tr>
						<tr>
							<th width="20%">回答一：</th>
							<td colspan="3" style="text-align: left;">
								${questionModel.answer1 }</td>
						</tr>
						<tr>
							<th width="20%">问题二：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description2 }</td>
						</tr>
						<tr>
							<th width="20%">回答二：</th>
							<td colspan="3" style="text-align: left;">${questionModel.answer2 }</td>
						</tr>
						<tr>
							<th width="20%">问题三：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description3 }</td>
						</tr>
						<tr>
							<th width="20%">回答三：</th>
							<td colspan="3" style="text-align: left;">${questionModel.answer3 }</td>
						</tr>
					</c:if>
					<c:if test="${questionModel.size == 0}">
						<tr>
							<td colspan="4" style="width: 100%; text-align: center;">暂无信息！</td>
						</tr>
					</c:if>
				</table>
				<br />
			</div>
			<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 2px;"></div>
			<div class="mtab">
				<table width="950px">
					<tr>
						<th colspan="4"
							style="color: gray; width: 100%; text-align: center;">信息审批</th>
					</tr>
					<tr>
						<th width="20%">审批：</th>
						<td colspan="3"><input type="radio" name="status" id="status" onclick="getRadio()"
							value="PASSED" checked="checked" />审核通过&nbsp;&nbsp;&nbsp; <input
							type="radio" id="status" name="status" onclick="getRadio()" value="DENIED" />审核未通过</td>
					</tr>
					<tr style="height: 50px">
						<th width="20%">审批理由：</th>
						<td colspan="3"><form:textarea path="auditReason" rows="5" id="auditReason"
								cssStyle="width:100%" /></td>
					</tr>
				</table>
				<br />
			</div>
			<!-- end 详情内容-->
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">确定</a>
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