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
		ChangeDutyPlace();
		$.ajaxSetup({
			cache : false
			
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
		//防止重复提交
	
		$("#submit").click(function() {
			
			//值班信息
			var dutyPlace = $("#dutyPlace").val();
			var dutyRole = $("#dutyRole").val();
			//防止重复提交标志位
			 $("#addForm").ajaxSubmit({
				    dataType : "json",
					success : function(data, status, xhr) {
						if (data.success == true) {
							alert("签到成功");
							parent.$.nyroModalRemove();
							if(dutyPlace == 'COMMUNICATION' && dutyRole == 'DUTYENGINEER'){
								window.top.location.href="${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime=";
							}else{
								window.top.location.reload();
							}
							//var url1="${rootUrl }phonemng/callcenter/manage.do";
							var Width1="700";
							var Height1="700";
                            //window.open(url1,"","width=" + Width1 + "px,height=" + Height1 + "px,resizable=1,scrollbars=1"); 
							//${rootUrl }phonemng/callcenter/manage.do
							//location.href="${rootUrl }phonemng/callcenter/manage.do";
						} else {
							alert("签到失败");
							parent.$.nyroModalRemove();
							window.top.location.reload();
						}
					},
					error: function (xmlHttpRequest, error) { 
						alert(error);
						parent.$.nyroModalRemove();
						window.top.location.reload();
                    } 
				})
			
		});

	});

	var initializationTime = (new Date()).getTime();
	function showLeftTime() {
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getMonth() + 1;
		var day = now.getDate();
		var hours = now.getHours();
		var minutes = now.getMinutes();
		var seconds = now.getSeconds();
		var signTime = "" + year + "-" + month + "-" + day + " " + hours + ":"
				+ minutes + ":" + seconds + "";
		$("#signTime").val(signTime);
		document.all.signTime1.innerHTML = "" + year + "-" + month + "-" + day
				+ " " + hours + ":" + minutes + ":" + seconds + "";
		//一秒刷新一次显示时间
		var timeID = setTimeout(showLeftTime, 1000);
	}
	window.onload = function() {
		showLeftTime();

	}
	
	function ChangeDutyPlace(){
		
		$.ajax({
			type : "GET",
			url : "${rootUrl}turndutymng/change/getShiftRecord.dox?dutyplace=" + $("#dutyPlace").val(),
			data : {},
			async : true, //同步,默认为true，异步
			dataType : "json",
			success : function(result) {
				var htm = "";
				if (result.length != 0) {
					for(var i=0;i<result.length;i++){
						
							htm+="<tr><td>"+result[i].creater.name+"</td><td>"
							    +result[i].dutyRoles.value+"</td><td>"
							    +result[i].dutyPlaces.value+"</td><td>"
							    +result[i].remark+"</td></tr>";

					}
					
				}
				$("#content").html(htm);
			}
		});
	}
</script>
</head>

<body style="overflow-x: hidden" onload="showLeftTime()">

      
 
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }turndutymng/change/signin.do" method="post">
		<form:hidden path="signTime" id="signTime" />
		<div class="window"
			style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px">
			<dl class="title">
				<dd>签到</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
<table id="dataTable" width="800px" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
		   <td colspan="7">
		           交接班日志
		   </td>
		</tr>
		<tr>
			<td width="10%">值班人</td>
			<td width="10%">值班角色</td>
			<td width="10%">值班地点</td>
			
			<td width="30%">记录内容</td>
	
		
		</tr>
	</thead>
	<tbody id="content">
		<!--<c:forEach items="${shiftRecordList}" var="vo" varStatus="voStatus">
			<tr align="center">
				<td>${vo.creater.name}</td>
				<td>${vo.dutyRoles.value}</td>
				<td>${vo.dutyPlaces.value}</td>
			
				<td>${vo.remark}</td>
				<td>
					<fmt:formatDate value="${vo.creatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				
				<td>${vo.operator.name}</td>
				<td>
				    <fmt:formatDate value="${vo.operatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				
			</tr>
		</c:forEach>-->
	</tbody>
</table>
			<table style="width: 850px; margin-left: 10px" border="0">
				<tr>
					<th width="70px">工程师姓名:</th>
					<td>${loginUser}</td>
				</tr>
				<tr>
					<th width="70px">值班角色：</th>
					<td><form:select path="dutyRole">
							<c:forEach var="dutyroles" items="${roles}" varStatus="loop">
								<option value="${dutyroles}" />${dutyroles.value}
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<th width="70px">值班地点：</th>
					<td><form:select path="dutyPlace" onChange="ChangeDutyPlace()">
							<c:forEach var="dutyplaces" items="${places}" varStatus="loop">
								<option value="${dutyplaces}" />${dutyplaces.value}
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<th width="70px">签到时间:</th>
					<td id="signTime1" name="signTime1"></td>
					</td>
				</tr>

				<tr align="center">
					<td colspan="2" align="center" valign="middle"><span
						class="btn" style="margin-left: 280px"> <a href="#none"
							id="submit">提交</a>
					</span> <span class="btn"> <a href="#none" id="goback"
							class="goback">取消</a>
					</span></td>
				</tr>
			</table>
		
	</form:form>
</div>
</body>
</html>