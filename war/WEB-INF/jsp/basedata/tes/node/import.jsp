<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>


<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>

<script>
	$(function() {
		$('.close').click(function() {
			parent.$.nyroModalRemove();
			$("#upImp").removeAttr("disabled");
			$("#upRtn").removeAttr("disabled");
		});
	});

	function doImpExcelSubmit(rootUrl) {
		$("#my_resultMessage").html("");
		var filePath = $("#localFilePath").val()
		if (filePath == "") {
			alert("请选择要导入的excel文件");
			return;
		}
		if (!/^.+\.xls[x]?$/.test(filePath)) {
			alert("上传文件应为后缀名为.xls的Excel文件。");
			return;
		}
		$("#startImportWait").show();
		$("#upImp").attr("disabled", "disabled");
		$("#upRtn").attr("disabled", "disabled");
		$("#upRtn").css("display", "");
		$("#myForm").trigger("submit");
	}
	
	function doImpExcelSubmitSlot(rootUrl) {
		$("#my_resultMessage").html("");
		var filePath = $("#localFilePathSlot").val()
		filePath = filePath.trim();
		if (filePath == "") {
			alert("请选择要导入的excel文件");
			return;
		}
		if (!/^.+\.xls[x]?$/.test(filePath)) {
			alert("上传文件应为后缀名为.xls的Excel文件。");
			return;
		}
		$("#startImportWait").show();
		$("#upImp").attr("disabled", "disabled");
		$("#upRtn").attr("disabled", "disabled");
		$("#upRtn").css("display", "");
		$("#myFormSlot").trigger("submit");
	}
	
</script>
</head>
<body>
	<div class="window" style="min-height: 620px;">
		<dl class="title">
			<dd>数据管理--TES节点--Excel导入</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->

		<%@ include file="/WEB-INF/jsp/noteInfo.jsp"%>
		<br />
		<div id="startImportWait" style="display: none" class="my_success">
			<img src="${rootUrl}images/doing.gif" width="32" height="32" />正在执行Excel导入，请稍候！
		</div>
		<div>
			<form:form name="myForm" method="post" enctype="multipart/form-data"
				modelAttribute="fileModel"
				action="${rootUrl}basedata/tes/node/impexcel.do" id="myForm">
				<c:if test="${empty failedData}">
					<table width="96%">
						<tr>
							<td align="center"><font color="red">*</font>TES节点信息文件路径:</td>
							<td align="left""><input class="a-upload" type="file" id="localFilePath"
								name="localFilePath" style="width: 500px"
								onkeydown="return false" /></td>
							<td><a href="#" id="upImp" class="btn" name="upImp"
								onclick="doImpExcelSubmit('${rootUrl }');"><img
									src="${rootUrl}images/btn/bc.gif" />导入</a></td>

						</tr>
					</table>
				</c:if>
			</form:form>
		</div>
		<%-- <div>
			<form:form name="myFormSlot" method="post" enctype="multipart/form-data"
				modelAttribute="fileModel"
				action="${rootUrl}basedata/tes/node/slot/impexcelSlot.do" id="myFormSlot">
				<c:if test="${empty failedData}">
					<table width="96%">
						<tr>
							<td align="center"><font color="red">*</font>CU信息文件路径:</td>
							<td align="left""><input type="file" id="localFilePathSlot"
								name="localFilePathSlot" style="width: 500px"
								onkeydown="return false" /></td>
							<td><a href="#" id="upImpSlot" class="btn" name="upImpSlot"
								onclick="doImpExcelSubmitSlot('${rootUrl }');"><img
									src="${rootUrl}images/btn/bc.gif" />导入</a></td>

						</tr>
					</table>
				</c:if>
			</form:form>
		</div> --%>
		<c:if test="${not empty failedData}">
			<div class="mtab">
				<h1>导入失败记录</h1>
				<table width="96%" border="0" cellpadding="0" cellspacing="0">
					<c:forEach items="${failedData}" var="data" varStatus="index">
						<c:choose>
							<c:when test="${index.count ==1}">
								<tr class="mainTitle">
									<c:forEach items="${data}" var="oneData" varStatus="index">
										<th align="center">${oneData}</th>
									</c:forEach>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="info_in">
									<c:forEach items="${data}" var="oneData" varStatus="dataIndex">
										<td class="right_td">${oneData}&nbsp;</td>
									</c:forEach>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
			</div>

			<div class="boxbtn">
				<a href="#" id="upRtn" name="upRtn" class="btn"
					onclick="javascript:window.location.href='${rootUrl }basedata/tes/node/impexcel.do'">返回</a>
			</div>
		</c:if>
		<br />
	</div>
</body>
</html>