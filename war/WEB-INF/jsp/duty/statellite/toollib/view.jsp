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
			<dd>通信基地-TES-室内设备--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
		  
<table width="100%" border="1">
  <tr>
    <th colspan="9" scope="col">北京网控中心TES站室内检查</th>
  </tr>
  <tr>
    <th width="13%" scope="row">机箱号</th>
    <td width="10%">1001</td>
    <td width="12%">1002</td>
    <td width="11%">1003</td>
    <td width="11%">1004</td>
    <td width="11%">1007</td>
    <td width="10%">1008</td>
    <td width="10%">1009</td>
    <td width="12%">100A</td>
  </tr>
  <tr>
    <th scope="row">板卡数量</th>
    <td>${vo.n1001 }"</td>
    <td>${vo.n1002 }"</td>
    <td>${vo.n1003 }"</td>
    <td>${vo.n1004 }"</td>
    <td>${vo.n1007 }"</td>
    <td>${vo.n1008 }"</td>
    <td>${vo.n1009 }"</td>
    <td>${vo.n100a }"</td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
     ${vo.n1001.value}
    </td>
    <td>
    ${vo.n1002.value}
    </td>
    <td>
     ${vo.n1003.value}
    </td>
    <td>
    ${vo.n1004.value}
    </td>
    <td>
     ${vo.n1007.value}
    </td>
    <td>
     ${vo.n1008.value}
    </td>
    <td>
     ${vo.n1009.value}
    </td><td>
     ${vo.n100a.value}
    </td>
  </tr>
  <tr>
    <th scope="row">机箱号</th>
    <td>100B</td>
    <td>100C</td>
    <td>100D</td>
    <td>100E</td>
    <td>100F</td>
    <td>1010</td>
    <td>1011</td>
    <td>1012</td>
  </tr>
  <tr>
    <th scope="row">板卡数量</th>
     <td>${vo.n100b }</td>
    <td>${vo.n100c }</td>
    <td>${vo.n100d }</td>
    <td>${vo.n100e }</td>
    <td>${vo.n100f }</td>
    <td>${vo.n1010 }</td>
    <td>${vo.n1011 }</td>
    <td>${vo.n1012 }</td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
	    ${vo.n100b.value}
    </td>
    <td>
    ${vo.n100c.value}
    </td>
    <td>
    ${vo.n100b.value}
    </td>
    <td>
    ${vo.n100e.value}
    </td>
    <td>
    ${vo.n100f.value}
    </td>
    <td>
    ${vo.n1010.value}
    </td>
    <td>
   ${vo.n1011.value}
    </td><td>
   ${vo.n1012.value}
    </td>
  </tr>
</table>
		  
		</div>
	</div>
</body>
</html>