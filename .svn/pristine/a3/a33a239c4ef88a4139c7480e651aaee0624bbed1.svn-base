<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户日志管理</title>

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
	$(function() {

		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : true,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				1 : {
					sorter : 'text',
				},
				2 : {
					sorter : 'text',
				},
				3 : {
					sorter : 'text',
				},
				4 : {
					sorter : 'text',
				},
				5 : {
					sorter : 'text',
				},
				6 : {
					sorter : 'text',
				},
				7 : {
					sorter : 'text',
				},
				8 : {
					sorter : 'text',
				}
			}
		});
	});

	function getSubMenu() {
		$.ajax({
			type : "get",
			url : "${rootUrl}acl/resource/getSubMenubyPid.dox",
			data : "pid=" + $("#parentMenu").val(),
			dataType : "json",
			cache : false,
			success : function(data) {
				$("#subMenu").empty();
				$("#subMenu").append("<option value=''>全部</option>");
				$.each(data, function(i, value) {
					$("#subMenu").append(
							"<option value=" + value.id + ">" + value.name
									+ "</option>");
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("系统错误");
			}
		});

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
						<span class="bold">用户日志管理</span>
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
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}systemmng/userlog/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											姓名：
											<form:input path="userNameLike" size="10" maxlength="50" />
											部门：
											<form:input path="dptLike" size="10" maxlength="50" />

											一级菜单：
											<form:select path="parentMenu" id="parentMenu"
												cssStyle="width:100px" onchange="getSubMenu()">
												<form:option value="">全部</form:option>
												<c:forEach items="${menus}" var="item">
													<option value="${item.id}">${item.name}</option>
												</c:forEach>
												<%-- 	<form:options items="${bureaus}" itemLabel="value" /> --%>
											</form:select>
											二级菜单: <select name="subMenu" id="subMenu"
												style="width: 100px">

											</select>

											<%-- 	一级菜单：
											<form:input path="menuLike" size="10" maxlength="50" />
											二级菜单：
											<form:input path="subMenuLike" size="10" maxlength="50" />
 --%>


											<%-- 		日期：		<form:input cssStyle="width:60px" path="startTime"
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
												style="cursor: pointer;" />  --%>
											 <div class="bclear"></div> 
											操作类型：
											<form:input path="optTypeLike" size="10" maxlength="50" />
											操作时间： <input readonly="true" id="startTime"
												style="width: 80px; height: 15px" name="startTime" size="15"
												maxlength="18" class='Wdate'
												onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" />-
											<input readonly="true" id="endTime" name="endTime" size="15"
												style="width: 80px; height: 15px" maxlength="18"
												class='Wdate'
												onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}'})" />
										
										
										</div>
											<a href="#none"  class="sbtn" id="queryButton">查询</a> <a
													href="#none"   class="sbtn" onclick="listForm.reset();">重置</a>
											
										
											
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