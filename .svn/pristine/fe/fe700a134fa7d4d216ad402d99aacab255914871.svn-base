<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KU电路配置</title>
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
					sorter : 'digit',
				},
				5 : {
					sorter : 'text',
				},
				6 : {
					sorter : 'text',
				},
				7 : {
					sorter : 'digit',
				},
				8 : {
					sorter : 'digit',
				},
				9 : {
					sorter : 'digit',
				},
				10 : {
					sorter : 'text',
				},
				11 : {
					sorter : 'text',
				},
				12 : {
					sorter : 'digit',
				},
				13 : {
					sorter : 'digit',
				},
				14 : {
					sorter : 'digit',
				},
				15 : {
					sorter : 'text',
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
								window.location.href = "${rootUrl }basedata/ku/service/expexcel.do";
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
						<span class="bold">KU电路配置</span>
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

								<div class="boxbtn">
									<sec:authorize
										ifAnyGranted="${jspAuthorities['kucircuit_add']}">
										<a href="${rootUrl }maintain/kucircuit/add.do"
											class="my_add{boxwidth:800,boxheight:590} btn"><img
											src="${rootUrl}images/btn/new.gif" />添加</a>
									</sec:authorize>
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}maintain/kucircuit/manage.do" method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											电路名：
											<form:input path="codeLike" size="10" maxlength="50" />
											发端节点号：
											<form:input path="txNodeNoLike" size="10" maxlength="50" />
											收端节点号：
											<form:input path="rxNodeNoLike" size="10" maxlength="50" />
											<div class="clear"></div>
											电路速率：
											<form:select path="rateType" cssStyle="width:105px">
												<form:option value="">-请选择-</form:option>
												<form:options items="${kuServiceRateTypes}"
													itemLabel="value" />
											</form:select>
											完整：
											<form:select path="complete">
												<form:option value="">-请选择-</form:option>
												<form:option value="true">是</form:option>
												<form:option value="false">否</form:option>

											</form:select>
											收端信息：
											<form:input path="memoLike" size="10" maxlength="50" />
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
													alt="" />KU电路列表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
										<!--查询结果-->
										<div id="queryResult" style="overflow:auto;border-right:1px solid #95BDD7;border-left:1px solid #95BDD7"></div>
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