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
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script>
	$(function() {
		//初始化级别定义
		var eventType = $("#eventType").val();
		if(eventType == 'ENVIRONMENT' || eventType == 'OTHER'){
			$("#faultLevel").val("C");
			$("#faultLevelShow").text("C级");
			$("#firstRaw").hide();
			$("#secondRaw").hide();
		}else if(eventType == 'SATELLITE' || eventType == 'TELEGRAPH'){
			$("#firstRaw").show();
			$("#secondRaw").hide();
		}else{
			$("#firstRaw").show();
			$("#secondRaw").show();
		}
		//预加载时间
		$("#faultTime").val(new Date().Format("yyyy-MM-dd HH:mm:ss"));
		var dateHtm = new Date().Format("yyyy-MM-dd HH:mm:ss");
		$("#pickUpPhoneTime").val(dateHtm);
		$.ajaxSetup({
			cache : false
		});
		//表单验证
		$("#addForm").validate({
			rules : {
				telephoneNumber : {
					required : true,
					phoneIOMS3 : true
				},
				contactsName : {
					required : true,
					maxlength : 10,
					description : true
				},
				faultCompany : {
					required : true,
					maxlength : 20
				},
				stationPhone : {
					phoneIOMS3 : true
				},
				faultArea : {
					required : true,
					maxlength : 50
				},
				remark : {
					maxlength : 500
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}/* ,
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
				//flag = true;
			} */
		});
		//防止重复提交
		var flag = true;
		$("#submit").click(function() {
			delCookie("type");
			var faultLevel = $("#faultLevel").val();
			if(faultLevel == '' || faultLevel == null){
				alert("重新选择事件类别和是否备份等条件，确定事件级别");
				return;
			}
			//获取延迟超时时间长度
			var timeOutSeconds = getTimeOutSeconds();
			var faultTime = $("#faultTime").val();
			if(faultTime == null || faultTime == ""){
				alert("时间发生时间不能为空");
			}
			if(flag == false){
				alert("正在提交，请稍后!");
				return;	
			}
			//非第一次咨询情况下，绑定父级故障单验证
			var firstOrNot = "";
			var firstOrNots = document.getElementsByName("firstOrNot");
			for(var i = 0 ; i < firstOrNots.length ; i++){
				if(firstOrNots[i].checked){
					firstOrNot = firstOrNots[i].value;
				}	
			}
			if(firstOrNot == "yes"){
				//表单验证
				var validStatus = $("#addForm").valid();
				//防止重复提交标志位
				if(validStatus == true){
					//表单验证通过，标志位设置为false，不允许再次提交
					flag = false;
					$('input,select,textarea',$('#addForm')).prop('readonly',true);
				}else{
					//表单验证未通过，标志位设置为true，不允许再次提交
					flag = true;
				}
				$("#addForm").ajaxSubmit({
					beforeSubmit : validateAddForm,
					dataType : "json",
					type : "GET",
					url : "${rootUrl }phonemng/add.dox",
					timeout : timeOutSeconds, 
					success : function(data, status, xhr) {
						
							alert(data.msg);
							//$("#callNo").val("");
							window.top.location.href="${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime=";
							parent.$.nyroModalRemove();
						
					},
					error: function (xmlHttpRequest, error) { 
						alert("请求超时");
						parent.$.nyroModalRemove();
						//window.top.location.reload();
                    } 
				})
			}else{
				var faultParentId = $("#faultParentId").val();
				if(faultParentId == "" || faultParentId == null){
					alert("未绑定父级事件单");
					return;
				}
				if(faultParentId != "" && faultParentId != null){
					//表单验证
					var validStatus = $("#addForm").valid();
					//防止重复提交标志位
					if(validStatus == true){
						flag = false;
						$('input,select,textarea',$('#addForm')).prop('readonly',true);
					}else{
						flag = true;
					}
					$("#addForm").ajaxSubmit({
						beforeSubmit : validateAddForm,
						dataType : "json",
						type : "GET",
						url : "${rootUrl }phonemng/add.dox",
						timeout : timeOutSeconds, 
						success : function(data, status, xhr) {
							
								alert(data.msg);
								
								window.top.location.href="${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime=";
								parent.$.nyroModalRemove();
								//window.top.location.reload();
							
						},
						error: function (xmlHttpRequest, error) { 
							alert("请求超时");
							parent.$.nyroModalRemove();
							//window.top.location.reload();
	                    } 
					})
				}
			}
		});
		//加载地区资源
		var availableTags = "";
		$.ajax({
			type : "GET",
			url : "${rootUrl}faultmng/getAreaData.dox",
			data : {},
			async : false, //同步,默认为true，异步
			dataType : "json",
			success : function(result) {
				for (var i = 0; i < result.length; i++) {
					if (i != result.length - 1) {
						availableTags += result[i].areaInfo + ",";
					} else {
						availableTags += result[i].areaInfo;
					}
				}
			}
		});
		var availableTag = availableTags.split(",");
		//加载数据
		$("#faultArea").autocomplete({
			source : availableTag
		});
		//刚开始隐藏表格的7,8,9,10行 
		//$("table").find("tr").eq(9).hide();
		//$("table").find("tr").eq(10).hide();
		//$("table").find("tr").eq(11).hide();
		//$("table").find("tr").eq(12).hide();
		//实现 点击“否” 显示隐藏的7,8,9,10行，点击“是” ，隐藏7,8,9,10行 
		
		$("#tr1").hide();
		$("#tr2").hide();
		$("#tr3").hide();
		$("#tr4").hide();
		$("input[type='radio']").click(function() {
			var id = $(this).attr("id");
			if (id == "no") {
				$("table").find("tr").show();
				if(eventType == 'ENVIRONMENT' || eventType == 'OTHER'){
					$("#firstRaw").hide();
					$("#secondRaw").hide();
				}else if(eventType == 'SATELLITE' || eventType == 'TELEGRAPH'){
					$("#firstRaw").show();
					$("#secondRaw").hide();
				}else{
					$("#firstRaw").show();
					$("#secondRaw").show();
				}
			}
			if (id == "yes") {
				//$("table").find("tr").eq(9).hide();
				//$("table").find("tr").eq(10).hide();
				//$("table").find("tr").eq(11).hide();
				//$("table").find("tr").eq(12).hide();
				$("#tr1").hide();
				$("#tr2").hide();
				$("#tr3").hide();
				$("#tr4").hide();
			}
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
	//模糊查询故障单列表
	function findFaultInfo() {
		var faultArea = $("#faultArea").val();
		var startOptTime = $("#startOptTime").val();
		var endOptTime = $("#endOptTime").val();
		if (faultArea == null || faultArea == "") {
			alert("请填写事件发生所在地!");
			return;
		}
		$.ajax({
			type : "GET",
			url : "${rootUrl}faultmng/getFaultInfo.dox?faultArea="
					+ encodeURI(encodeURI(faultArea)),
			data : {
				startOptTime : startOptTime,
				endOptTime : endOptTime
			},
			async : true, //同步,默认为true，异步
			dataType : "json",
			success : function(result) {
				$("#faultParentId option").remove();
				var htm = "";
				for (var i = 0; i < result.length; i++) {
					htm += "<option value=" + result[i].id + ">"
							+ result[i].faultNumber + "--"
							+ result[i].pickUpPhoneTime + "--"
							+ result[i].telephoneNumber + "--"
							+ result[i].contactsName + "</option>";
				}
				$("#faultParentId").append(htm);
				var faultInfoDesc = "";
				if (result.length != 0) {
					faultInfoDesc += "事件单编号：" + result[0].faultNumber
							+ "，申告时间：" + result[0].pickUpPhoneTime + "，申告电话："
							+ result[0].telephoneNumber + "，申告人："
							+ result[0].contactsName + "，事件发生时间："
							+ result[0].faultTime + "，事件类别："
							+ result[0].eventType;
				}
				$("#faultInfoDesc").html(faultInfoDesc);
			}
		});
	}
	//异步加载故障单信息概况
	function displayShow(faultId) {
		$.ajax({
			type : "GET",
			url : "${rootUrl}faultmng/getFaultInfo.dox?faultId=" + faultId,
			data : {},
			async : true, //同步,默认为true，异步
			dataType : "json",
			success : function(result) {
				var htm = "";
				if (result.length != 0) {
					htm += "事件单编号：" + result[0].faultNumber + "，申告时间："
							+ result[0].pickUpPhoneTime + "，申告电话："
							+ result[0].telephoneNumber + "，申告人："
							+ result[0].contactsName + "，事件发生时间："
							+ result[0].faultTime + "，事件类别："
							+ result[0].eventType;
				}
				$("#faultInfoDesc").html(htm);
			}
		});
	}
	
	//根据事件类型，改变显示内容
	function changeShow(eventType) {
		if(eventType == 'ENVIRONMENT' || eventType == 'OTHER'){
			$("#faultLevel").val("C");
			$("#faultLevelShow").text("C级");
			$("#firstRaw").hide();
			$("#secondRaw").hide();
		}else if(eventType == 'SATELLITE' || eventType == 'TELEGRAPH'){
			$("#firstRaw").show();
			$("#secondRaw").hide();
		}else{
			$("#firstRaw").show();
			$("#secondRaw").show();
		}
		choseLevel();
	}
	//根据事件类型和条件判断级别
	function choseLevel(){
		var eventType = $("#eventType").val();
		var backups = $("#backups").val();
		var renew = $("#renew").val();
		var serviceType = $("#serviceType").val();
		if(eventType == 'SATELLITE'){
			if(backups == 'no' && renew == 'yes'){
				$("#faultLevel").val("A");
				$("#faultLevelShow").text("A级");
			}else if((backups == 'yes' && renew == 'yes') || (backups == 'no' && renew == 'no')){
				$("#faultLevel").val("B");
				$("#faultLevelShow").text("B级");
			}else if(backups == 'yes' && renew == 'no'){
				$("#faultLevel").val("C");
				$("#faultLevelShow").text("C级");
			}
		}else if(eventType == 'TELEGRAPH'){
			if((backups == 'yes' && renew == 'yes') || (backups == 'no' && renew == 'yes')){
				$("#faultLevel").val("A");
				$("#faultLevelShow").text("A级");
			}else if((backups == 'yes' && renew == 'no') || (backups == 'no' && renew == 'no')){
				$("#faultLevel").val("B");
				$("#faultLevelShow").text("B级");
			}
		}else if(eventType == 'ATM'){
			if(backups == 'no' && renew == 'yes'){
				$("#faultLevel").val("A");
				$("#faultLevelShow").text("A级");
			}else if(backups == 'yes' && renew == 'no' && serviceType == 'officeWork'){
				$("#faultLevel").val("C");
				$("#faultLevelShow").text("C级");
			}else if(backups == '' || renew == '' || serviceType == ''){
				$("#faultLevel").val("");
			}else{
				$("#faultLevel").val("B");
				$("#faultLevelShow").text("B级");
			}
		}
	}
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
	word-break:break-all;
}
</style>
</head>
<body style="overflow-x: hidden">
	<div class="modal-data" id="modal-data">
	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px;">
		<dl class="title">
			<dd>摘机弹窗</dd>
			
		</dl>
			
	
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<div style="margin: 10px 20px 0px ; padding: 0px;width:710px;">
				<dl class="title">
					<dd>摘机弹窗</dd>
				</dl>
			</div>
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }phonemng/callcenter/faultmng/add.do" method="post">
				<input type="hidden" id="faultLevel" name="faultLevel"/>
				<input style="display:none;" type="text" id="callSheetId" name="callSheetId" value="${callId}"/>
				<table width="100%">
				<tr>
					<th>申告电话</th>
					<td><input type="text" id="telephoneNumber" name="telephoneNumber" value="${callNo}"/></td>
					<th>申告联系人</th>
					<td ><input type="text" id="contactsName" name="contactsName" value="${contactsName}"/></td>
				</tr>
				<tr>
					<th>事件发生时间</th>
					<td><input id="faultTime" name="faultTime" style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;" maxlength="25" class="Wdate"
						onfocus="WdatePicker({el:$dp.$('faultTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" /></td>
					<th>申告时间</th>
					<td><input type="text" style="border: 0px;" readonly="true" id="pickUpPhoneTime" name="pickUpPhoneTime" value="${pickUpPhoneTime}"/></td>
				</tr>
			    <tr>
					<th>申告所属单位</th>
					<td>
						<input type="text" id="faultCompany" name="faultCompany" value="${companyInfo}"/>
					</td>
					<th>事件类别</th>
					<td><select id="eventType" name="eventType" style="width: 150px;height:22px;" onchange="changeShow(this.value)">
							<c:forEach items="${eventTypes }" var="eventType">
								<option value="${eventType }">${eventType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr id="firstRaw">
					<th>是否有备份</th>
					<td>
						<select id="backups" name="backups" style="width: 150px;height:22px;" onchange="choseLevel()">
							<option value="">请选择</option>
							<option value="yes">是</option>
							<option value="no">否</option>
						</select>
					</td>
					<th>是否需立即恢复</th>
					<td>
						<select id="renew" name="renew" style="width: 150px;height:22px;" onchange="choseLevel()">
							<option value="">请选择</option>
							<option value="yes">是</option>
							<option value="no">否</option>
						</select>
					</td>
				</tr>
				<tr id="secondRaw">
					<th>业务类型</th>
					<td>
						<select id="serviceType" name="serviceType" style="width: 150px;height:22px;" onchange="choseLevel()">
							<option value="">请选择</option>
							<option value="airControl">空管</option>
							<option value="officeWork">办公</option>
						</select>
					</td>
					<th>&nbsp;</th>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th>事件级别(自动生成)</th>
					<td id="faultLevelShow">
					</td>
					<th>当前处理人</th>
					<td><input type="text" style="border: 0px;" readonly="true" id="currentHandleUser" name="currentHandleUser" value="${currentHandleUser}"/></td>
				</tr>
				<tr>
					<th>坐席电话</th>
					<td><input type="text" id="stationPhone" name="stationPhone" value="${calledNo}"/></td>
					<th><label for="tags">事件发生地址</label></th>
					<td><input type="text" id="faultArea" name="faultArea" value="${callerplace}"/></td>
				</tr>
				<tr>
					<th>是否正常咨询</th>
					<td colspan="3" style="text-align:left"><input type="radio"
						id="isRight" name="isRight" value="yes" checked="checked" />正常咨询
					<input type="radio" id="isRight" name="isRight" value="annoy" /><font color="red">非正常咨询(骚扰电话、音质模糊电话等)</font></td>
				</tr>
				<tr>
					<td style="border: none; width: 33%; text-align: center;"
						colspan="2">是否首次咨询：</td>
					<td style="border: none; width: 33%;"><input type="radio"
						id="yes" name="firstOrNot" value="yes" checked="checked" />是</td>
					<td style="border: none; width: 33%;"><input type="radio"
						id="no" name="firstOrNot" value="no" />否</td>
				</tr>
				<tr id="tr1">
					<td colspan="4"><span style="color: red;">请点击【事件发生时间范围】下方的【事件单查询】链接，查询可能存在的事件单</span></td>
				</tr>
				<tr id="tr2">
					<th>事件发生时间范围</th>
					<td><input readonly="true" id="startOptTime"
						name="startOptTime" maxlength="18" class='Wdate' style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;"
						onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endOptTime\')}'})" /></td>
					<th>至</th>
					<td><input readonly="true" id="endOptTime" name="endOptTime" 
						 maxlength="18" class='Wdate' style="padding:4px 2px 0px 2px; height:16px;border: 1px solid #B8B8B8;"
						onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startOptTime\')}'})" /></td>
				</tr>
				<tr id="tr3">
					<th><a href="#" style="color: purple; text-decoration: underline;" onclick="findFaultInfo()" >事件单查询</a></th>
					<td colspan="3" style="text-align: center;"><select id="faultParentId" name="faultParentId" style="width: 300px" onchange="displayShow(this.value)">
					</select></td>
				</tr>
				<tr id="tr4">
					<td style="text-align: center;" colspan="4"><textarea rows="3" readonly="readonly"
							cols="90" style="text-align: left;" id="faultInfoDesc" name ="faultInfoDesc"></textarea></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="4">事件描述</td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="4"><textarea id="remark" name="remark" rows="3"
							cols="90"></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="4" align="center" valign="middle"><span
						class="btn" id="btnSubmit" style="margin-left: 300px"> <a href="#none"
							id="submit">提交</a>
					</span> </td>
				</tr>
			</table>
		</form:form>
	</div>
	</div>
    </div>
</body>
</html>