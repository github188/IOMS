<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="${rootUrl}css/login.css" type="text/css" />
<title>登录</title>
<script src="${rootUrl}js/cookie.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#username").focus();

		$("#loginForm").validate({
			rules : {
				username : {
					required : true
				},
				password : {
					required : true
				}
			}
		});
	});

	function checkNoCn(str) {
		if (str == "")
			return false;
		for (i = 0; i < str.length; i++) {
			var c = str.substr(i, 1);
			var ts = escape(c);
			if (ts.substring(0, 2) == "%u")
				return false;
		}
		return true;
	}

	function clearall() {
		$("#username").val("");
		$("#password").val("");
	}

	function check() {
		var fileter = /^[a-z0-9]+$/;
		var checkFlag = true;
		var info = "";
		var username = document.getElementById('username').value;
		if (checkFlag == true && username.length == 0) {
			info = "请输入用户名";
			document.getElementById('username').focus();
			checkFlag = false;
		}
		if (checkFlag == true && !checkNoCn(username)) {
			info = "用户名不能包含汉字";
			document.getElementById('username').focus();
			checkFlag = false;
		}
		if (checkFlag == true
				&& document.getElementById('password').value.length == 0) {
			info = "请输入密码";
			document.getElementById('password').focus();
			checkFlag = false;
		}
		if (checkFlag == true && !fileter.test(username)) {
			info = "用户名只能由小写字母和数字组成";
			document.getElementById('username').focus();
			checkFlag = false;
		}
		if (checkFlag == true) {
			//SetCookie('mycookieuser', document.loginForm.username.value);
			//if (document.loginForm.savepass.checked)
			//	SetCookie('mycookiepass', document.loginForm.password.value);
			//else {
			//	cookie = getCookie('mycookiepass');
			//	if (cookie != null && cookie != "") {
			//		SetCookie('mycookiepass', '');
			//		}
			//	}
			//提交表单
			$("#loginForm").submit();
			return true;
		}
		document.getElementById('loginInfo').innerHTML = '<img src="${rootUrl}images/login/note_no.gif" style="vertical-align: middle;"/>  '
				+ info;
		return false;
	}
</script>

</head>

<body>
	<div id="box">
		<h2>空管网络网控运维平台</h2>
		<div class="cont">
			<h3>后台管理系统</h3>
			<form:form id="loginForm" name="loginForm"
				action="${rootUrl }j_spring_security_check" method="post">
				<div class="user">
					<span class="text">用户名：</span> <input type="text" id="username"
						name="j_username" value="${SPRING_SECURITY_LAST_USERNAME}"
						class="login_img" tabindex="1" />
				</div>
				<div class="user1">
					<span class="text">密码：</span> <input type="password" id="password"
						type="password" name="j_password"
						onkeydown="javascript:if(event.keyCode==13) check();"
						class="login_img" tabindex="1" />
				</div>
				<div class="login">
					<a href="#" onclick="check();">登录</a><span class=""></span>
				</div>
				<div class="prompt" id="loginInfo">
					<c:if test="${not empty errorMsg}">
						<img src="${rootUrl}images/login/note_no.gif"
							style="vertical-align: middle;" />  ${errorMsg}	 </c:if>
				</div>

			</form:form>
		</div>
	</div>

</body>
</html>