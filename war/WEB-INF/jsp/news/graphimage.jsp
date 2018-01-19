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
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
</head>
<body style="overflow-y:hidden;overflow-x:hidden;">
	<div class="window" style="margin-left:1px">
		<dl class="title">
			<dd>通知公告:流程查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<h1>通知公告</h1>${pageModel.status.value }
		<table style="width:650px;height:500px;margin-left:10px" border="0"  >
			<tr>
				<td align="left" valign="top">
				<img src="${rootUrl }news/graph.dox?id=${newsId}" alt="流程图" />
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
        $(function() {
    		$(".close").click(function() {
    			parent.$.nyroModalRemove();
    		});
        });
    </script>
</body>
</html>