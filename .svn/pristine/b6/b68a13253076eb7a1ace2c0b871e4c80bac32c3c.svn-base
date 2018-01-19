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
	
	 $(function() {
			$.ajaxSetup({
	            cache : false
	        });

			$("#modForm").validate({
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
						parent.editSubmit(form);
					},
		            errorPlacement : function(error, element) {
		                error.appendTo(element.parent("td").next("td")[0]);
		            } 
				});
			$(".close").click(function() {
		            parent.$.nyroModalRemove();
		    });
			$("#submit").click(function(){
				$("#modForm").validate();
				$("#modForm").attr("action", "${rootUrl }systemmng/clientcompany/mod.do");
				$("#modForm").trigger("submit");
				//alert("test");
			});
	    });
	</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm" action="${rootUrl }systemmng/clientcompany/mod.do" method="post">
	<form:hidden path="id" />
		<div class="window" style="height:240px">
			<dl class="title">
				<dd>单位--修改</dd>
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
					<th width="15%"><font color="red">(*)</font>所属区域:</th>
					<td width="20%" style="word-break:break-all;word-wrap:break-word;">
						<form:select id="bureau" path="bureau"
							style="width: 100%" >
								<form:options items="${bureaus}" /> 
						</form:select>
					</td>
					<td width="15%"></td>
					<th width="15%"><font color="red">(*)</font>单位名称：</th>
					<td width="20%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="company" style="width: 97%"></form:input></td>
					<td width="15%"></td>
				</tr>
				<tr>
					<th width="15%">单位地址:</th>
					<td width="20%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="address" style="width: 97%"></form:input></td>
					<td width="15%"></td>
					<th width="15%">单位邮编：</th>
					<td width="20%" style="word-break:break-all;word-wrap:break-word;"><form:input color="black" path="postcode" style="width: 97%"></form:input></td>
					<td width="15%"></td>
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