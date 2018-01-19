<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/top_b.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/pager.css" type="text/css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
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
		$("#roleSelete").manage({
			pagerUrl : "${rootUrl}acl/user/roleSelect.dox",
			view : true,
			boxwidth : "600",
			boxheight : "800",
			sortConfig : {
				0 : {
					sorter : "digit"
				},
				5 : {
					sorter : false
				}
			}
		});

		$("#selectAll").live('click', function() {
			if ($(this).attr("checked")) {
				$("input[name='roleId']").attr("checked", "checked");
			} else {
				$("input[name='roleId']").removeAttr("checked");
			}
		});

		$("#save").click(function() {
			if ($("#accountTd").find("input").length < 1) {
				alert("请选择角色！");
				return;
			}
			$("#accountTd").find("input").each(function() {
				var value = $(this).val().split("、");
				var id = value[0];
				var name = value[1];
				parent.setRoleInfo(id, name, null);
			});
			$("#closeSelect").trigger("click");
		});

		$("#select").click(function() {
			var s = $("#accountTd").html();
			$("input[name='roleId']:checked").each(function() {
				var id = $(this).val();
				var name = $("#roleName" + $(this).val()).val();
				var divStr = getDivStr(id, name);
				if (s.search(id) < 0) {
					s = s + " " + divStr;
				}
			});
			$("#accountTd").html(s);
			return false;
		});

	});

	function getDivStr(id, name) {
		var value = id + "、" + name;
		var div = "<span id="+id+">"
				+ "<input type=\"hidden\" id=\"ids\" name=\"ids\" value=\""+value+"\"/>"
				+ name
				+ "<img src=\"${rootUrl}images/btn/del.gif\" onclick=\"delAccount('"
				+ id + "')\"/>,</span>";
		return div;
	}

	function delAccount(id) {
		$("#" + id).remove();
	}
</script>

</head>
<body>
	<!-- LOGO -->
	<!-- LOGO -->
	<div id="main">
		<div class="minfo"
			style="background: #F7FBFF; margin-left: 7px; min-height: 480px">
			<div class="bl">
				<div class="br">
					<div class="clear"></div>
					<form:form modelAttribute="queryModel" id="listForm"
						name="listForm" method="post">
						<div id="lmsx">
							<div class="clear"></div>
							<div class="boxbtn">
								<div class="info">
									角色：
									<form:input path="name" id="name" size="10" maxlength="50" />
								</div>
								<a href="#none" class="sbtn" id="queryButton">查询</a> <a
									href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
							</div>
							<div class="bclear"></div>
							<div class="mtab">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									class="title">
									<tr>
										<td class="td1"><img src="${rootUrl}images/pl1.gif"
											alt="" />角色列表</td>
										<td class="td2" id="noteInfo"></td>
									</tr>
								</table>
								<div id="roleSelete"></div>
								<div class="boxbtn">
									<a id="select" class="btn" href="#">选择</a>
								</div>


								<table id="dataTable" width="100%" border="0" cellspacing="0"
									cellpadding="2">
									<thead>
										<tr>
											<th class="td1">选中角色列表</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td id="accountTd"></td>
										</tr>
									</tbody>
								</table>
								<div class="boxbtn" style="margin:0 auto;align:center;">
									<a id="save" class="btn" href="#">提交</a> <a href="#"
										class="btn" id="closeSelect"
										onclick="parent.$.nyroModalRemove();">关闭</a>
								</div>
							</div>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>