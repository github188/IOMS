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



<script>
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		
		var availableTags = [
		                     "北京市海淀区学院路",
		                     "北京市朝阳区",
		                     "北京天安门",		
		                     "北京网控中心",	
							"上海", 
							"上海人" ];

		$("#tags").autocomplete({
			source : availableTags
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

		//刚开始隐藏表格的5,6,7行 
		$("table").find("tr").eq(7).hide();
		$("table").find("tr").eq(8).hide();
		$("table").find("tr").eq(9).hide();
		//实现 点击“否” 显示隐藏的5,6,7行，点击“是” ，隐藏5,6,7行 
		$("input[type='radio']").click(function() {
			var id = $(this).attr("id");
			if (id == "no") {
				$("table").find("tr").show();
			}
			if (id == "yes") {
				$("table").find("tr").eq(7).hide();
				$("table").find("tr").eq(8).hide();
				$("table").find("tr").eq(9).hide();

			}
			
		});
		
	
	});
</script>
<style>
th {
	width: 25% ! important;
	background-color: #DDDDDD;
	text-align: center ! important;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}
td{
	width: 25% ! important;
}
</style>
</head>

<body style="overflow-x: hidden">

	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px;">
		<dl class="title">
			<dd>摘机弹窗</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">




			<div style="margin: 10px 20px 0px ; padding: 0px;width:710px;">
				<dl class="title">
					<dd>摘机弹窗</dd>
				</dl>
			</div>
			<table width="100%">
			<tr>
				<th>申告电话</th>
				<td><input value="13241666245"></input></td>
				<th>申告联系人</th>
				<td ><input value="李四"></input></td>
			</tr>
			<tr>
				<th>故障时间</th>
				<td><input readonly="true" id="startOptTime"
					name="startOptTime" style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;" maxlength="25" class="Wdate"
					onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endOptTime\')}'})" /></td>
				<th>申告时间</th>
				<td>2016-03-25 08:57</td>
			</tr>
		    	<tr>
				<th>所属单位</th>
				<td>
				<input value="XXXXXXX单位"></input>
				</td>
				<th>故障级别</th>
				<td>
				   <select id="statusEq" name="statusEq" style="width: 133px;height:22px;">
						<option value="">A级</option>
						<option value="">B级</option>
						<option value="">C级</option>
						
				</select>
				</td>
			</tr>
			<tr>
				<th>坐席电话</th>
				<td>010-8888888</td>
				<th>处理人</th>
				<td>localtest2</td>
			</tr>
			<tr class="ui-widget">
				<th><label for="tags">所在地址</label></th>
						<td><input style="width: 127px; text-align: left;" id="tags" /></td>
				<th>事件类别</th>
				<td><select id="statusEq" name="statusEq" style="width: 133px;height:22px;">
						<option value="">ATM</option>
						<option value="">卫星</option>
						<option value="">转报</option>
						<option value="">环境</option>
						<option value="">其他</option>
				</select></td>
			</tr>
			<tr>
				<th
					>是否正常：</th>
				<td colspan="3" style="text-align:left"><input type="radio"
					id="yes1" name="radio1" value="ok" checked="checked" />正常
				<input type="radio" id="no1" name="radio1" value="no" />不正常</td>
			</tr>
			<tr>
				<td style="border: none; width: 33%; text-align: center;"
					colspan="2">是否首次咨询：</td>
				<td style="border: none; width: 33%;"><input type="radio"
					id="yes" name="radio" value="yes" checked="checked" />是</td>
				<td style="border: none; width: 33%;"><input type="radio"
					id="no" name="radio" value="no" />否</td>
			</tr>
			
			<tr>
				<th>故障发生时间范围</th>
				<td><input readonly="true" id="startOptTime"
					name="startOptTime" maxlength="18" class='Wdate' style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;"
					onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endOptTime\')}'})" /></td>
				<th>至</th>
				<td><input readonly="true" id="endOptTime" name="endOptTime" 
					 maxlength="18" class='Wdate' style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;"
					onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startOptTime\')}'})" /></td>
			</tr>

			<tr>
				<th><a href="#"
					style="color: purple; text-decoration: underline;">故障单查询</a></th>
				<td colspan="3" style="text-align: center;"><select
					id="statusEq" name="statusEq" style="width: 300px">
						<option value="">请选择</option>
						<option value="">2016-03-25 06:57+13241666245+李四</option>
						<option value="">发生时间+申告电话+申告联系人</option>
						<option value="">发生时间+申告电话+申告联系人</option>
						<option value="">发生时间+申告电话+申告联系人</option>
				</select></td>
			</tr>

			<tr>
				<td style="text-align: center;" colspan="4"><textarea rows="3"
						cols="90" style="text-align: left;">故障发生时间:2016-03-25 06:57，申告电话：13241666245，申告联系人：李四</textarea></td>

			</tr>

			<tr>
				<td style="text-align: center;" colspan="4">备注</td>

			</tr>
			<tr>
				<td style="text-align: center;" colspan="4"><textarea rows="3"
						cols="90"></textarea></td>

			</tr>
			<tr align="center">
				<td colspan="4" align="center" valign="middle"><span
					class="btn" style="margin-left: 280px"> <a href="#none"
						id="submit">提交</a>
				</span> <span class="btn"> <a href="#none" id="goback"
						class="goback">取消</a>
				</span></td>
			</tr>
		</table>
	</div>
	</div>


</body>
</html>