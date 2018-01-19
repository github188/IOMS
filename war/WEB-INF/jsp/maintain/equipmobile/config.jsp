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
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});

		$("#submit").click(
				function() {
					//设备id
					var equipId = $("#equipId").val();
					//拼接绑定内容
					var info = "";
					var userMobileTrs = document
							.getElementsByName("userMobile");
					for (var i = 0; i < userMobileTrs.length; i++) {
						var inputs = $(userMobileTrs[i]).find("input");
						var name = $(inputs[0]).val();
						var mobile = $(inputs[1]).val();
						if (name == null || name == '' || mobile == null
								|| mobile == '') {
							alert("姓名和手机号不允许为空");
							return;
						}
						//是否发送短信的标记
						var sendmsgFlag = "no";
						if (inputs[2].checked) {
							sendmsgFlag = "yes";
						}
						info += name + "," + mobile + "," + sendmsgFlag;
						if (i != userMobileTrs.length - 1) {
							info += ";";
						}
					}
					$.ajax({
						type : "POST",
						url : "${rootUrl }maintain/equipmobile/config.do",
						dataType : "json",
						data : {
							equipId : equipId,
							infos : info
						},
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("添加成功!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("添加失败，请检查!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					});

				});
		$("#submitUser")
				.click(
						function() {
							var i = $("#num").val();
							var radioName = "sendFlag" + i;
							var trHtml = "<tr name='userMobile'>";
							trHtml += "<th width='25%'>用户名：<input type='text' name='userName' id='userName' /></th>";
							trHtml += "<th width='25%'>手机号：<input type='text' name='mobile' id='mobile' /></th>";
							trHtml += "<th width='30%'>是否发送短信：<input type='radio' value='yes' name='"+ radioName +"'id='"+ radioName +"' />是";
							trHtml += "<input type='radio' value='no' name='"+ radioName +"' id='"+ radioName +"' checked='checked'/>否</th>";
							trHtml += "<th width='20%'><a href='#' onclick='removeTr(this)'>删除</a></th></tr>";
							i++;
							$("#num").val(i)
							$("#resultTable").append(trHtml);
						});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	})
	function removeTr(nowTr) {
		$(nowTr).parent().parent().remove();
	}
</script>
<style>
table th {
	text-align: center;
}

table td {
	text-align: center;
}
</style>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/ku/mobile/config.do" method="post">
		<input type="hidden" name="equipId" id="equipId" value="${equipId }" />
		<input type="hidden" name="num" id="num" value="0" />
		<div>
			<dl class="title">
				<dd>KU设备绑定电话管理</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1 style="margin-bottom: 10px; margin-top: 10px;">KU节点信息</h1>

			<table width="96%" id="resultTable">
				<c:forEach items="${kuMobiles}" var="vo" varStatus="voStatus">
					<tr name="userMobile">
						<th width="25%">用户名：<input type="text" value="${vo.name }"
							name="userName" id="userName" /></th>
						<th width="25%">手机号：<input type="text" value="${vo.mobile }"
							name="mobile" id="mobile" /></th>
						<th width="30%">是否发送短信： <c:choose>
								<c:when test="${vo.sendmsgFlag eq 'yes' }">
									<input type="radio" value="yes" name="sendmsgFlag${voStatus.index}"
										id="sendmsgFlag${voStatus.index}" checked="checked" />是
									<input type="radio" value="no" name="sendmsgFlag${voStatus.index}"
										id="sendmsgFlag${voStatus.index}" />否
								</c:when>
								<c:otherwise>
									<input type="radio" value="yes" name="sendmsgFlag${voStatus.index}"
										id="sendmsgFlag${voStatus.index}" />是
									<input type="radio" value="no" name="sendmsgFlag${voStatus.index}"
										id="sendmsgFlag${voStatus.index}" checked="checked" />否
								</c:otherwise>
							</c:choose>
						</th>
						<th width="20%"><a href="#" onclick="removeTr(this)">删除</a></th>
					</tr>
				</c:forEach>
			</table>

			<div class="boxbtn" style="width: 190px;">
				<div class="btn">
					<a href="#none" id="submitUser">添加新用户</a>
				</div>
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>