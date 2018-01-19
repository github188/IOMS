<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css"/>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
	
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		$.ajaxSetup({
			cache : false
		});
		
		$(".close").click(function(){
			parent.$.nyroModalRemove();
		});
		
		$("#atm1").hide();
		$("#atm2").hide();
		$("#atm3").hide();
		$("#atm4").hide();
		$("#ku1").hide();
		$("#ku2").hide();
		$("#ku3").hide();
		$("#ku4").hide();
		$("#tes1").hide();
		$("#tes2").hide();
		$("#tes3").hide();
	    $("#tes4").hide();
		$("#pes1").hide();
		$("#pes2").hide();
		$("#pes3").hide();
	    $("#pes4").hide();
		var applyOpttype = $("#applyOpttype").val();
		var applyType = $("#applyType").val();
		if(applyType == "ATM正式电路"){
			$("#atm1").show();
			$("#atm2").show();
			$("#atm3").show();
			if(applyOpttype == "变更"){
				$("#atm4").show();
			}
		}
		if(applyType == "KU正式电路"){
			$("#ku1").show();
			$("#ku2").show();
			$("#ku3").show();
			if(applyOpttype == "变更"){
				$("#ku4").show();
			}
		}
		if(applyType == "TES正式电路"){
			$("#tes1").show();
			$("#tes2").show();
			$("#tes3").show();
			if(applyOpttype == "变更"){
				$("#tes4").show();
			}
		}
		if(applyType == "PES正式电路"){
			$("#pes1").show();
			$("#pes2").show();
			$("#pes3").show();
			if(applyOpttype == "变更"){
				$("#pes4").show();
			}
		}
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>正式电路申请详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<%@include file="../formalcircuit/innerDetail.jsp"%>
		</div>
			<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="close">关闭</a>
			</div>
		</div>
		<br></br>
	</div>
</body>
</html>