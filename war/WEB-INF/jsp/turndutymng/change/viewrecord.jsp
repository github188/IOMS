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
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }ueditor/ueditor.config.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$.ajaxSetup({
			cache : false
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#submit").click(function() {
			//$("#addForm").trigger("submit");
			parent.$.nyroModalRemove();
		});

	});
</script>
<style>
th {
	/*width: 25%;*/
	background-color: #DDDDDD;
	text-align: center ! important;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}
td{
	/*width: 25% ! important;*/
}
</style>
</head>

<body style="overflow-x: hidden">

	<div class="window">
		<dl class="title">
			<dd>交接班记录</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">




			<div style="margin: 10px 20px 0px ; padding: 0px;width:660px;">
				<dl class="title">
					<dd>交接班记录</dd>
				</dl>
			</div>
			
		<table id="dataTable" width="600px" border="0" cellspacing="0" class="table table-bordered"
		cellpadding="2">
		<thead>
			<tr>
				<th style="width:5%">序号</th>
				<th style="width:10%">值班人</th>
				<th style="width:10%">值班角色</th>
				<th style="width:10%">值班地点</th>
				<th style="width:50%">记录内容</th>
				<th style="width:15%">创建情况</th>
				
			</tr>
		</thead>
		<tbody>
		   <tr>
		       <td>1</td>
		       <td>值班员1</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXXXXXXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员1</p> 
		            <p>2016-04-01 12:23</p>
		       </td>
		   </tr>
		    <tr>
		       <td>1</td>
		       <td>值班员1</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXXXXXXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员1</p> 
		            <p>2016-04-01 12:23</p>
		       </td>
		   </tr>
		  
		</tbody>
		</table>
			



		</div>

		<br><br>
	</div>
</body>
</html>