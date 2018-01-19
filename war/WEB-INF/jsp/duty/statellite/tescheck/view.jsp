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
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>通信基地TES网管系统检查--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
		  
<table width="100%" border="1">
  <tr>
    <th colspan="4" scope="col">北京网控中心TES站网管系统检查</th>
  </tr>
  <tr>
    <th width="26%" scope="row">序号</th>
    <td width="29%">检查内容</td>
    <td width="20%">结果记录</td>
    <td width="25%">备注</td>
  </tr>
  <tr>
    <th scope="row">1</th>
    <td>主用网管工作站切换广州</td>
    <td>
    ${vo.recordGz.value}
    </td>
    <td>
    ${vo.recordGzBz }
    </td>
  </tr>
  <tr>
    <th scope="row">2</th>
    <td>网管工作站本地手动切换</td>
    <td>
    ${vo.recordManual.value}
    </td>
    <td>
    ${vo.recordManualBz }
    </td>
  </tr>
  <tr>
    <th scope="row">3</th>
    <td>网管工作站切回北京</td>
    <td>
    ${vo.recordBj.value}
    </td>
    <td>
    ${vo.recordBjBz }
    </td>
  </tr>
  <tr>
    <th scope="row">4</th>
    <td>网管工作站备份情况</td>
    <td>
    ${vo.recordBf }
    </td>
    <td>${vo.recordBfBz }</td>
  </tr>
</table>
		  
		</div>
	</div>
</body>
</html>