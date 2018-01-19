<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>角色管理</title>

<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
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

<script type="text/javascript">
	$(function() {

		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			remove : true,
			boxwidth : "500",
			boxheight : "250",
			sortable : true,
			sortConfig : {
				3 : {
					sorter : false,
				}
			}
		});
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

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">角色管理</span>
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
								<sec:authorize ifAnyGranted="${jspAuthorities['rolemng_add']}">
									<div class="boxbtn">
										<a href="${rootUrl }acl/role/add.do"
											class="my_add{boxwidth:500,boxheight:250} btn"><img
											src="${rootUrl}images/btn/new.gif" />添加</a>
									</div>
									<div class="bclear"></div>
								</sec:authorize>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}acl/role/manage.do"
									method="post">
									<input type="hidden" value="NoEmptyFormValue"
										id="NoEmptyFormValue" name="NoEmptyFormValue" />
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											角色名称：
											<form:input path="name" size="10" maxlength="50" />
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
												<td class="td1" style="width: 80px;"><img
													src="${rootUrl}images/pl1.gif" alt="" />角色列表</td>
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