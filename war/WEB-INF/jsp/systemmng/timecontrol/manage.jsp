<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>签到/离岗时间管理</title>
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
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
<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>
<style type="text/css">
.mtab table th {
	border: 1px solid #95BDD7;
	background: #EFF0F2;
	height: 25px;
	color: #1F83B7;
	text-align: right;
	font-size: 13px;
	font-weight: normal;
}

.mtab table td {
	border: 1px solid #95BDD7;
	color: #1F83B7;
	height: 25px;
	font-size: 13px;
	color: #000;
	padding-left: 2px;
	text-align: left;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		
		$.ajaxSetup({
			cache : false
		});
		$("#addForm")
		.validate(
				{
					rules : {
						
					},
					submitHandler : function(form) {
					
						parent.addSubmit(form);
					}
				});
		
		$("#submit").click(function() {
			$.ajax({
				type : "POST",
				url : "${rootUrl}systemmng/timecontrol/manage.do",
				dataType : "json",
				success : function(data, status, xhr) {
					
					alert(data.msg);
					window.top.location.reload();
					//$("action").attr("${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime=");
					$("#addForm").submit();
				}
			});
		});

	});
	
	var rootUrl = '${rootUrl }';
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
						<span class="bold">签到离岗时间管理</span>
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

                                <div class="mtab">
								<!--管理按钮-->
								<form:form modelAttribute="pageModel" id="addForm"
									name="addForm" action=""
									method="post">

									    <table width="100%">
									      <tbody>
									      <tr class="title">
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />时间管理</td>
												<td class="td2"><%@ include
														file="/WEB-INF/jsp/noteInfo.jsp"%></td>
										  </tr>
									      <tr>
												<th style="width:30%" align="right">签到时间：</th>
												<td>
												       小时：
												   <form:select path="amHour" style="width:60px">
														<c:forEach var="amhours" items="${amhours}"
															varStatus="loop">
															<option value="${amhours.value}"/>${amhours.value}
														</c:forEach>
													</form:select>
												      分钟：
												    <form:select path="amMin" style="width:60px">
														<option value="0"/>00
														
														<option value="1"/>01
														<option value="2"/>02
														<option value="3"/>03
														<option value="4"/>04
														<option value="5"/>05
														
														<option value="6"/>06
														<option value="7"/>07
														<option value="8"/>08
														<option value="9"/>09
														<option value="10"/>10
														
														<option value="11"/>11
														<option value="12"/>12
														<option value="13"/>13
														<option value="14"/>14
														<option value="15"/>15
														
														<option value="16"/>16
														<option value="17"/>17
														<option value="18"/>18
														<option value="19"/>19
														<option value="20"/>20
														
														<option value="21"/>21
														<option value="22"/>22
														<option value="23"/>23
														<option value="24"/>24
														<option value="25"/>25
														
														<option value="26"/>26
														<option value="27"/>27
														<option value="28"/>28
														<option value="29"/>29
														<option value="30"/>30
														
														<option value="31"/>31
														<option value="32"/>32
														<option value="33"/>33
														<option value="34"/>34
														<option value="35"/>35
														
														<option value="36"/>36
														<option value="37"/>37
														<option value="38"/>38
														<option value="39"/>39
														<option value="40"/>40
														
														<option value="41"/>41
														<option value="42"/>42
														<option value="43"/>43
														<option value="44"/>44
														<option value="45"/>45
														
														<option value="46"/>46
														<option value="47"/>47
														<option value="48"/>48
														<option value="49"/>49
														<option value="50"/>50
														
														<option value="51"/>51
														<option value="52"/>52
														<option value="53"/>53
														<option value="54"/>54
														<option value="55"/>55
														
														<option value="56"/>56
														<option value="57"/>57
														<option value="58"/>58
														<option value="59"/>59
														
													</form:select>
												</td>
											</tr>
											<tr>
										    <th>离岗时间：</th>
												<td >
												   小时：
												   <form:select path="pmHour" style="width:60px">
														<c:forEach var="pmhours" items="${pmhours}"
															varStatus="loop">
															<option value="${pmhours.value}"/>${pmhours.value}
														</c:forEach>
													</form:select>
												      分钟：
												    <form:select path="pmMin" style="width:60px">
														<option value="0"/>00
														
														<option value="1"/>01
														<option value="2"/>02
														<option value="3"/>03
														<option value="4"/>04
														<option value="5"/>05
														
														<option value="6"/>06
														<option value="7"/>07
														<option value="8"/>08
														<option value="9"/>09
														<option value="10"/>10
														
														<option value="11"/>11
														<option value="12"/>12
														<option value="13"/>13
														<option value="14"/>14
														<option value="15"/>15
														
														<option value="16"/>16
														<option value="17"/>17
														<option value="18"/>18
														<option value="19"/>19
														<option value="20"/>20
														
														<option value="21"/>21
														<option value="22"/>22
														<option value="23"/>23
														<option value="24"/>24
														<option value="25"/>25
														
														<option value="26"/>26
														<option value="27"/>27
														<option value="28"/>28
														<option value="29"/>29
														<option value="30"/>30
														
														<option value="31"/>31
														<option value="32"/>32
														<option value="33"/>33
														<option value="34"/>34
														<option value="35"/>35
														
														<option value="36"/>36
														<option value="37"/>37
														<option value="38"/>38
														<option value="39"/>39
														<option value="40"/>40
														
														<option value="41"/>41
														<option value="42"/>42
														<option value="43"/>43
														<option value="44"/>44
														<option value="45"/>45
														
														<option value="46"/>46
														<option value="47"/>47
														<option value="48"/>48
														<option value="49"/>49
														<option value="50"/>50
														
														<option value="51"/>51
														<option value="52"/>52
														<option value="53"/>53
														<option value="54"/>54
														<option value="55"/>55
														
														<option value="56"/>56
														<option value="57"/>57
														<option value="58"/>58
														<option value="59"/>59
													</form:select>
												
												</td>
											</tr>
											<tr>
										    <th>阈值时间（单位分钟）：</th>
												<td >
												  <form:input path="limitTime" id="limitTime" />
												</td>
											</tr>
											<tr align="center">
												<td colspan="2" align="center" valign="middle">
													<span class="btn" style="margin-left: 280px">
														<a href="#none" id="submit">更新</a>
													</span>

												</td>
											</tr>
											</tbody>
									    </table>
									    <div class="bclear"></div>
									  
										<table id="dataTable" width="100%" border="0" cellspacing="0"
											cellpadding="2" class="table table-bordered">
											<tr class="title">
												<td class="td1" colspan="3"><img src="${rootUrl}images/pl1.gif"
													alt="" />当前信息</td>
												
										      </tr>
										 		<tr>
													<td align="center">签到时间</td>
													<td>离岗时间</td>
													
													<td>阈值（分钟）</td>
												</tr>
							
											
												<c:forEach items="${timeControl}" var="vo" >
												       <td>
												          ${vo}
												       </td>
												</c:forEach>
											
										</table>
								</form:form>
								</div>
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