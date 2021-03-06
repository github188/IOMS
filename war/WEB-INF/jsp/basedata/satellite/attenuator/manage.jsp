<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>衰减器管理</title>
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
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : false/* ,
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
					sorter : 'digit',
				}, 
				4 : {
					sorter : 'digit',
				},
				5 : {
					sorter : false,
				}
			} */

		});
		$("#expexcelBtn")
				.click(
						function() {
							if ($(".pager").attr('totalcount') == '0') {
								alert("记录为空！");
								return;
							} else {
								window.location.href = "${rootUrl}basedata/satellite/attenuator/expexcel.do";
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
						<span class="bold">衰减器管理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">

								<div class="boxbtn">

									<%-- <sec:authorize
										ifAnyGranted="${jspAuthorities['odumng_expexcel']}">
										<a href="${rootUrl }basedata/satellite/attenuator/expexcel.do" class="btn"><img
											src="${rootUrl}images/btn/qxzd.gif" />Excel导出</a>
									</sec:authorize> --%>

									<sec:authorize
										ifAnyGranted="${jspAuthorities['attenuatormng_expexcel']}">
										<a href="#" id="expexcelBtn" class="btn"><img
											src="${rootUrl}images/btn/qxzd.gif" />Excel导出</a>
									</sec:authorize>

								</div>
								<div class="clear"></div>
								<!--管理按钮-->
								<%-- 	<sec:authorize ifAnyGranted="${jspAuthorities['kunodemng_add']}">
									<div class="boxbtn">
										<a href="${rootUrl }basedata/ku/node/add.do"
											class="my_add{boxwidth:550,boxheight:300} btn"><img
											src="${rootUrl}images/btn/new.gif" />添加</a>
									</div>
									<div class="bclear"></div>
								</sec:authorize> --%>
								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}/basedata/satellite/attenuator/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											区域：
											<form:select path="bureau">
												<form:option value="">-请选择-</form:option>
												<c:forEach items="${bureauList}" var="bo">
													<form:option value="${bo.name}">${bo.value}</form:option>
												</c:forEach>

											</form:select>
											站点中文名称：
											<form:input path="siteNameLike" size="10" maxlength="50" />
											站点代码：
											<form:input path="siteCodeLike" size="10" maxlength="50" />
											站点类型：
											<form:select path="networkType">
												<form:option value="">-请选择-</form:option>
												<form:option value="TES">TES</form:option>
												<form:option value="KU">KU</form:option>
											</form:select>

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
													alt="" />衰减器列表</td>
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