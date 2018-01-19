<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>资源管理</title>

<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#queryResult").manage({
			pagerUrl : true,
			remove : true,
			removeCallback : myRemove,
			add : true,
			addCallback : myAdd,
			edit : true,
			editCallback : myEdit,
			remove : true,
			boxwidth : "550",
			boxheight : "400",
			sortable : true,
			sortConfig:{
				5:{
					sorter : false,
				}
			}
		});

		$("select").change(function() {
			$("#queryButton").click();
		});

		function myAdd(data) {
			var result = $(data).find("#my_resultMessage");
			if ($(result).hasClass("my_success")) {
				var theId = $.trim($(data).find("#result_id").html());
				if (theId.indexOf("NOT_MENU_") >= 0) {
					return;
				}
				var theParentId = $.trim($(data).find("#result_menuId").html());
				var theName = $.trim($(data).find("#result_name").html());
				$.tree.focused().create({
					data : theName,
					attributes : {
						id : theId
					}
				}, "#" + theParentId);
			}
		}

		function myEdit(data) {
			var result = $(data).find("#my_resultMessage");
			if ($(result).hasClass("my_success")) {
				var theId = $.trim($(data).find("#result_id").html());
				var theName = $.trim($(data).find("#result_name").html());
				$.tree.focused().rename("#" + theId, theName);
			}
		}

		function myRemove(data) {
			var result = $(data).find("#my_resultMessage");
			if ($(result).hasClass("my_success")) {
				var id = $(data).find("#result_id").html();
				var theId = $.trim(id);
				$.tree.focused().remove("#" + theId);
			}
		}
	});
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
			<!-- 菜单 -->
			<%@ include file="tree.jsp"%>
			<!-- 机构菜单 -->
			<!-- 内容页 -->

			<div id="main">

				<!--当前位置-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">资源管理</span>
					</div>
				</div>
				<!--place-->

				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<!--管理按钮-->
								<div class="boxbtn" style="padding-top: 5px;">
									<sec:authorize
										ifAnyGranted="${jspAuthorities['resourcemng_add']}">
										<div class="btn" id="add_div" style="display: none">
											<a href="#" class="my_add btn" id="add_a"><img
												src="${rootUrl}images/btn/new.gif" /> <label
												id="addLinkName"></label> </a>
										</div>
										<div class="btn" id="add_no_div" style="display: none">
											<a href="#" class="my_add btn" id="add_n"><img
												src="${rootUrl}images/btn/new.gif" /> 添加页面元素</a>
										</div>
									</sec:authorize>
								</div>
								<!--管理按钮-->
								<div class="clear"></div>
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" method="post"
									action="${rootUrl}acl/resource/manage.do">
									<input type="hidden" id="pid" name="pid" value=""></input>
									<input type="hidden" id="pType" name="pType" value=""></input>
									<div class="boxbtn">
										<!--查询条件-->
										<div class="info">
											资源名称：
											<form:input path="name" size="15" />
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
										<!--查询条件-->
									</div>
									<div class="bclear"></div>
									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />资源列表</td>
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
