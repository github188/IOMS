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
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<script type="text/javascript">
//与当前时间的对比
jQuery.validator.addMethod(
		"compareDate",
		function(value, element,params) {
			var curDate = new Date();
			var dateStr = value.replace(/-/g,"/");
			var preDate = new Date(dateStr);
			return this.optional(element) || preDate>curDate;
		},"&nbsp;<img src='"
				+ baseUrl
				+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;预估确认时间不能小于当前时间");
				
	$(function() {
		$("#tabs").tabs();
		$.ajaxSetup({
			cache : false
		});
		$("#solveForm").validate({
			rules : {
				descInfo : {
					required : true,
					maxlength : 1000
				},
				engineer : {
					required : true
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
			}
		});

		$("#submit").click(function() {
			$("#confirmTime").parent().next().empty();
			var value1 = $("#descInfo").val();
			var value = $("#confirmTime").val();
			if(value==""){
				if(value1==""){
					$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");	
				}else{
					$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;必填项");
					return false;
				}
			}
			var curDate = new Date();
			var dateStr = value.replace(/-/g,"/");
			var preDate = new Date(dateStr);
			if(preDate<curDate){
				$("#confirmTime").parent().next().append("&nbsp;<img src='"+baseUrl+"/images/validator/check_n.gif' width=16 height=16>&nbsp;预估确认时间不能小于当前时间");
				return false;
			}
			$("#solveForm").trigger("submit");
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<%@include file="innerdetail.jsp" %>
	<form:form modelAttribute="pageModel" id="solveForm" name="solveForm"
		action="${rootUrl }techsupport/fault/deal/resolve.do" method="POST">
		<form:hidden path="id" />
		<form:hidden path="faultdeclarepi" />
		<div class="window">
			<dl class="title">
				<dd>故障申报解决</dd>
			</dl>
			<h1></h1>
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
				<table width="100%">
					<tr>
						<th width="20%" style="text-align: right;">处理：<span style="color: red">(*)</span></th>
						<td><form:textarea path="descInfo" rows="8"
								cssStyle="width:500px" /></td>
						<td style="text-align:center;" width="100px"></td>
					</tr>
					<c:if test="${faultDeclare.faultStatus=='RESOLVED_OPEN' }">
						<tr>
							<th width="23%" style="text-align: right;">请选择协助人：<span style="color: red">(*)</span></th>
							<td>
								<form:select path="engineer" cssStyle="width:35%">
									<form:option value="">请选择</form:option>
									<c:forEach var="e" items="${engineers}" varStatus="engineer">
										<form:option value="${e.id }">${e.name }</form:option>
									</c:forEach>
								</form:select>
							</td>
							<td style="text-align:center;" width="100px"></td>
						</tr>
					</c:if>
					<tr>
						<th width="23%" style="text-align: right;">预估用户确认时间：<span style="color: red">(*)</span></th>
						<td>
							<form:input id="confirmTime" cssStyle="width:400px" path="confirmTime"
									cssClass="inputDate" readonly="true"
									onfocus="WdatePicker({el:$dp.$('confirmTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								<img src="${rootUrl}images/datePicker.gif"
								onclick="WdatePicker({el:$dp.$('confirmTime'),dateFmt:'yyyy-MM-dd HH:mm:ss'});"
								style="cursor: pointer;" />
						</td>
						<td style="text-align:center;" width="100px"></td>
					</tr>
				</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">解决</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br /> <br />
		</div>
	</form:form>
</body>
</html>