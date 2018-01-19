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
	$(function() {
		
		$.ajaxSetup({
			cache : false
		});
		$("#solveForm").validate({
			rules : {
				approveRemark : {
					required : true,
					maxlength : 300
				}
			},
			submitHandler : function(form) {
				parent.popupRemoveSubmit(form);
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td"));
			}
		});
		
		$("#submit").click(function() {
			$("#solveForm").trigger("submit");
		});
		
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
			
	});
</script>
</head>
<body>
	<div class="window">
			<dl class="title">
				<dd>卫星通信网地球站入网处理</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
				<%@include file="innerDetail.jsp"%>
				<form:form modelAttribute="pageModel" id="solveForm" name="solveForm"
					action="${rootUrl }kusatellite/draft.do" method="post">
					<form:hidden path="id"/>
					<form:hidden path="pid" />
					<div style="margin: 10px 20px 0px;padding:0px">
					<dl class="title">
						<dd>工作进展信息</dd>
					</dl>
					</div>
					<table width="96%">
						<tr class="config">
							<th width="20%" align="right">工作进展信息：<span style="color: red">(*)</span></th>
							<td colspan="5">
								<form:textarea path="approveRemark" rows="8" style="width:500px;resize:none;"/>
							</td>
						</tr>
					</table>
					<div class="boxbtn">
						<div class="btn">
							<a href="#none" id="submit">暂存</a>
						</div>
						<div class="btn">
							<a href="#none" class="close">取消</a>
						</div>
					</div>
					<br></br>
			</form:form>
		</div>
	</div>
</body>
</html>