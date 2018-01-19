<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>客户日志</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	$("#queryResult").manage({
		pagerUrl:true,
		add:true,
		edit:true,
		update:true,
		view:true,
		boxwidth:"550",
		boxheight:"560"
	});
});

function getSubMenu() {
	$("#subMenu").empty(); 
    $("#subMenu").append("<option value=''>全部</option>"); 
	switch($("#parentMenu").val()){
	case "Register":
		 $("#subMenu").append("<option value='Register'>注册</option>");
		break;
	case "Login":
		$("#subMenu").append("<option value='Login'>登录</option>");
		break;
	case "LogOut":
		$("#subMenu").append("<option value='LogOut'>登出</option>");
		break;
	case "RunStatus":
		$("#subMenu").append("<option value='AtmRunStat'>ATM运行统计</option>"
				+"<option value='KuRunStat'>KU运行统计</option>"
				+"<option value='TesRunStat'>TES运行状态</option>"
				+"<option value='NodeDetail'>节点详情</option>");
		break;
	case "TechSupport":
		$("#subMenu").append("<option value='FaultDeclareDeal'>故障申报处理</option>"
				+"<option value='FaultDeclareRecord'>故障申报记录</option>"
				+"<option value='TechConsultDeal'>技术咨询处理</option>"
				+"<option value='TechConsultRecord'>技术咨询记录</option>");
		break;
	case "DoBusiness":
		$("#subMenu").append("<option value='CircuitConfig'>电路配置</option>"
				+"<option value='TempCircuitDeal'>临时电路处理</option>"
				+"<option value='TempCircuitRecord'>临时电路记录</option>"
				+"<option value='FormalCircuitDeal'>正式电路办理</option>"
				+"<option value='FormalCircuitRecord'>正式电路记录</option>"
				+"<option value='FormalCircuitCandidate'>正式电路协同配置记录</option>"
				+"<option value='TelegraphDeal'>转报地址办理</option>"
				+"<option value='TelegraphRecord'>转报地址记录</option>"
				+"<option value='TelegraphCandidate'>转报地址协同配置记录</option>"
				+"<option value='TelegraphCircuitDeal'>转报电路办理</option>"
				+"<option value='TelegraphCircuitRecord'>转报电路记录</option>"
				+"<option value='TelegraphCircuitCandidate'>转报电路协同配置记录</option>"
				+"<option value='KuSatelliteDeal'>卫星地球站入网办理</option>"
				+"<option value='KuSatelliteRecord'>卫星地球站入网记录</option>"
				+"<option value='DataComNetworkDeal'>数据通信网入网处理</option>"
				+"<option value='DataComNetworkRecord'>数据通信网入网记录</option>"
				+"<option value='TransferNetDeal'>自动转报网入网处理</option>"
				+"<option value='TransferNetRecord'>自动转报网入网记录</option>");	
		break;
	}
    /* $.ajax({   
        type : "get",   
        url : "${rootUrl}acl/resource/getSubMenubyPid.dox",   
        data : "pid=" + $("#parentMenu").val(),   
        dataType : "json",   
        cache : false,   
        success : function(data) { 
             $("#subMenu").empty(); 
             $("#subMenu").append("<option value=''>全部</option>"); 
             $.each(data, function(i, value) {   
                $("#subMenu").append("<option value=" + value.id + ">" + value.name+ "</option>");   
            });    
        },   
        error : function(XMLHttpRequest, textStatus, errorThrown) {   
            alert("系统错误");   
        }   
    });    */
} 
</script>

</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<!-- LOGO -->

	<div id="boxmain">
		<!-- 左侧菜单 -->
		<%@ include file="/WEB-INF/jsp/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">操作日志</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<!--管理按钮-->
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}systemmng/clientlog/manage.do" method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											管局:
											<form:select path="bureau" id="bureau" cssStyle="width:135px">
												<form:option value="">全部</form:option>
												<c:forEach items="${bureaus}" var="item">
													<option value="${item}">${item.value}</option>
												</c:forEach>
												<%-- 	<form:options items="${bureaus}" itemLabel="value" /> --%>
											</form:select>
											姓名：
											<form:input path="clientName" size="10" maxlength="50" />
											操作类型：
											<form:select path="optType" id="optType">
												<form:option value="">全部</form:option>
												<c:forEach items="${logTypes}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>
											</form:select>
											操作日期：
											<form:input cssStyle="width:60px" path="startTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd 00:00:00',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd 00:00:00',maxDate:'#F{$dp.$D(\'endTime\')}'});"
												style="cursor: pointer;" /> 至
											<form:input cssStyle="width:60px" path="endTime"
												cssClass="inputDate" readonly="true"
												onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd 23:59:59',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
											<img src="${rootUrl}images/datePicker.gif"
												onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd 23:59:59',minDate:'#F{$dp.$D(\'startTime\')}'});"
												style="cursor: pointer;" />
											<%--  一级菜单：
											<form:input path="menuLike" size="10" maxlength="50" />
											二级菜单：
											<form:input path="subMenuLike" size="10" maxlength="50" /> --%>

											一级菜单：
											<form:select path="parentMenu" id="parentMenu"
												cssStyle="width:100px" onclick="getSubMenu()">
												<form:option value="">全部</form:option>
												<c:forEach items="${menus}" var="item">
													<option value="${item}">${item.value}</option>
												</c:forEach>
												<%-- 	<form:options items="${bureaus}" itemLabel="value" /> --%>
											</form:select>

											二级菜单:
											<form:select path="subMenu" id="subMenu" style="width: 100px">
											</form:select>

											<div class="bclear"></div>
										</div>

										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>

									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />日志列表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
										<!--查询结果-->
										<div id="queryResult"></div>
										<!--查询结果-->
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>