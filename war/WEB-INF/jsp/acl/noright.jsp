<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<head>
<title>您无权访问</title>

<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css"/>
<link rel="stylesheet" href="${rootUrl}css/top_b.css" type="text/css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
</head>
<body>
	
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp" %>
	<!-- LOGO -->

<div id="boxmain">
	<!-- 左侧菜单 -->
	<%@ include file="/WEB-INF/jsp/left.jsp" %>
	<!-- 左侧菜单 -->

	<!-- 内容页 -->
<div id="boxright">
	<!--main-->
	<div id="main" style="text-align: center">
		<div style="font-size: 20px;font-weight: bold;padding-top: 120px;color: red;font-family: 黑体;">
			<img src="${rootUrl}images/warn.png" style="vertical-align: middle"/>
			对不起，您没有访问权限！
			<br/><br/><br/>
			<a href="#" onclick="history.go(-1);return false;" style="font-size: 20px;font-weight: bold;font-family: 黑体;">
			请点此返回上一页面
			</a>
			<br/><br/>
			<a href="${rootUrl}j_spring_security_logout"  style="font-size: 20px;font-weight: bold;font-family: 黑体;">
			请点此重新登录系统
			</a>
		</div>
		<div style="display: none">
		<form:form id="listForm" name="listForm">
			<input id="dn" name="dn" type="hidden"/>
		</form:form>
		</div>
	</div>
	<!-- 内容页 -->
</div>
</div>
	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp" %>
	<!-- 版权页 -->
</body>
</html>