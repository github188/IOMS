<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/window.css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.checkbox.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#tree").tree({
			ui : {
				theme_name : "checkbox"
			},
			plugins : {
				checkbox : {}
			}
		});
		$("#submit")
				.click(
						function() {
							var checkNodes = $.tree.plugins.checkbox
									.get_checked();
							if ($(checkNodes).length == 0) {
								alert("请至少选中一个权限");
								return false;
							}

							$(checkNodes)
									.each(
											function() {
												var id = $(this).attr("id");

												if (id
														&& id.indexOf("menu_") >= 0) {
													$(
															"<input type='hidden' name='menuResourceIds'/>")
															.val(
																	id
																			.replace(
																					"menu_",
																					""))
															.insertAfter(
																	"#roleId");
												}
												if (id
														&& id.indexOf("col_") >= 0) {
													$(
															"<input type='hidden' name='colResourceIds'/>")
															.val(
																	id
																			.replace(
																					"col_",
																					""))
															.insertAfter(
																	"#roleId");
												}
												if (id
														&& id.indexOf("tab_") >= 0) {
													$(
															"<input type='hidden' name='tabResourceIds'/>")
															.val(
																	id
																			.replace(
																					"tab_",
																					""))
															.insertAfter(
																	"#roleId");
												}
											});

							var undeterminded = $.tree.plugins.checkbox
									.get_undeterminded();
							$(undeterminded)
									.each(
											function() {
												var id = $(this).attr("id");
												if (id
														&& id.indexOf("menu_") >= 0) {
													$("<input type='hidden' name='menuResourceIds'/>")
															.val(id.replace("menu_","")).insertAfter("#roleId");
												};
												if (id&& id.indexOf("col_") >= 0) {
													$(
															"<input type='hidden' name='colResourceIds'/>")
															.val(
																	id
																			.replace(
																					"col_",
																					""))
															.insertAfter(
																	"#roleId");
												}
											});
							parent.editSubmit($("#confForm"));
						});
	});
	function setStyle(id, clickFlag, noClickFlag) {
		//alert("id"+id+" clickFlag"+clickFlag+"  noClickFlag"+noClickFlag);
		if (clickFlag == 0)
			return;
		if (noClickFlag == 0) {
			$("#" + id).removeClass("unchecked checked undetermined").addClass(
					"checked");
			return;
		}
		$("#" + id).removeClass("unchecked checked undetermined").addClass(
				"undetermined");
	}
</script>
</head>
<body>
	<form name="confForm" id="confForm"
		action="${rootUrl }acl/role/conf.do" method="post">
		<input type="hidden" id="roleId" name="roleId" value="${role.id }" />

		<div class="window" style="min-height: 578px">
			<dl class="title">
				<dd>角色管理--配置</dd>
				<dt>
					<a href="#" onclick="parent.$.nyroModalRemove();"><img
						src="${rootUrl }images/error_fuck.png" alt="关闭" /> </a>
				</dt>
			</dl>
			<h1>为&lt;${role.name }&gt;配置权限</h1>
			<table>
				<tr>
					<td>

						<div id="tree">
							<ul>

								<c:set var="lineNum" value="0"></c:set>
								<c:forEach items="${confMap}" var="entry" varStatus="entryStat">
									<c:set var="lineNum" value="${lineNum+1}"></c:set>
									<c:set value="0" var="clickFlag"></c:set>
									<c:set value="0" var="noClickFlag"></c:set>
									<li rel="file" class="open" style="text-align: left"
										id="menu_${entry.key.id}"><a id="lineNum${lineNum}"
										href="#"
										<c:if test="${entry.key.hasResource&&!entry.key.hasChild}">class="checked"</c:if>><ins>&nbsp;</ins>${entry.key.name}</a>
										<ul>
											<c:forEach items="${entry.value}" var="col">
												<c:set value="0" var="clickColFlag"></c:set>
												<c:set value="0" var="noClickColFlag"></c:set>
												<c:if test="${not col.hasTabMenu}">
													<li id="col_${col.columnResource.id }" rel="file"
														style="text-align: left"><a href="#"
														<c:if test="${col.hasColumnResource}">class="checked"<c:set value="1" var="clickFlag"></c:set><c:set value="1" var="clickColFlag"></c:set></c:if>
														<c:if test="${!col.hasColumnResource}"><c:set value="1" var="noClickFlag"></c:set> <c:set value="1" var="noClickColFlag"></c:set> </c:if>><ins>&nbsp;</ins>${col.columnResource.name
															}</a></li>
													<script>
														setStyle(
																"col_${col.columnResource.id }",
																"${clickColFlag}",
																"${noClickColFlag}");
													</script>
												</c:if>
												<c:if test="${col.hasTabMenu}">
													<li rel="folder" class="open" style="text-align: left"
														id="col_${col.columnResource.id }"><a
														id="cola_${col.columnResource.id }" href="#"><ins>&nbsp;</ins>${col.columnResource.name}</a>
														<ul>
															<c:forEach items="${col.tabResources}" var="tab">
																<li id="tab_${tab.id }" rel="file"
																	style="text-align: left"><a href="#"
																	<c:if test="${tab.hasResource}">class="checked"<c:set value="1" var="clickFlag"></c:set><c:set value="1" var="clickColFlag"></c:set></c:if>
																	<c:if test="${!tab.hasResource}"><c:set value="1" var="noClickFlag"></c:set><c:set value="1" var="noClickColFlag"></c:set></c:if>><ins>&nbsp;</ins>${tab.name
																		}</a></li>
															</c:forEach>
														</ul></li>
													<script>
														setStyle(
																"cola_${col.columnResource.id }",
																"${clickColFlag}",
																"${noClickColFlag}");
													</script>
												</c:if>

											</c:forEach>
										</ul></li>
									<script>
										setStyle("lineNum${lineNum}",
												"${clickFlag}",
												"${noClickFlag}");
									</script>
								</c:forEach>
							</ul>
						</div>
					</td>
				</tr>
			</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#" onclick="parent.$.nyroModalRemove();">取消</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>

