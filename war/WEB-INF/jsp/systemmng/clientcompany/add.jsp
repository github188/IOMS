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
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/randomPsw.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />
    <script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript">
	function ajaxLeader() {
		
    }
	
	 $(function() {
			$.ajaxSetup({
	            cache : false
	        });

	        $("#addForm").validate({
	            rules : {
	                bureau : {
	                    required : true
	                },
	                company : {
	                    required : true,
	                    maxlength : 50
	                },
	                address : {
	                    maxlength : 200
	                },
	                postcode : {
	                    zipcode : true
	                }
	            },
	            submitHandler : function(form) {
	                parent.addSubmit(form);
	            },
	            errorPlacement : function(error, element) {
	                error.appendTo(element.parent("td").next("td")[0]);
	            }
	        });

	        $(".close").click(function() {
	            parent.$.nyroModalRemove();
	        });

	        $("#submit").click(function() {
	        $("#addForm").attr("action", "${rootUrl}systemmng/clientcompany/add.do");
	        $("#addForm").trigger("submit");
	        });
	    });
	</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="addForm" name="addForm" action="${rootUrl }systemmng/clientcompany/add.do" method="post">
		<div class="window" style="height:240px">
			<dl class="title">
				<dd>单位--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>单位信息</h1>
			<center>
				<hr style="width: 80%" />
			</center>
			<table width="96%">
			    <tr></tr>
			    <tr></tr>
				<tr>
				    <td></td>
					<th width="15%"><font color="red">(*)</font>所属区域:</th>
					<td><form:select path="bureau">
							<form:option value="">-请选择-</form:option>
							<form:options items="${bureaus}" itemLabel="value" />
							</form:select></td>
					<td></td>
					<th width="20%"><font color="red">(*)</font>单位名称:</th>

					<td><form:input id="company" path="company" /></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>

					<td></td>
					<th width="15%">单位地址:</th>
					<td><form:input path="address"/></td>
					<td></td>
					<th width="20%">单位邮编:</th>
					<td><form:input path="postcode" /></td>
					<td></td>
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