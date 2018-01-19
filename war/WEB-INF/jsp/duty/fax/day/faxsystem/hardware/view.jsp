<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
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
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
<style>
</style>
</head>

<body>

	<div class="window">
		<dl class="title">
			<dd>转报系统硬件编辑</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>

		<div class="mtab" style="padding-right: 70px;">


			<form:form modelAttribute="pageModel" id="modForm" name="modForm"
				action="${rootUrl}duty/fax/day/faxsystem/view.do" method="post">
				<br></br>
				<input type="hidden" id="hardwareId" name="hardwareId"
					value="${faxdata.id }" />
				<!-- /.class="table table-bordered" -->
				<table style="width: 100%">
					<tr>
						<th colspan="23" style="font-size: 20px; text-align: left;">转报系统硬件检查</th>
					</tr>
					<tr>

						<th colspan="2">检查内容</th>
						<th colspan="2">检查结果</th>
					</tr>
					<tr>

						<th colspan="2">时间</th>
						<td colspan="2">自动生成系统时间</td>
					</tr>
					<tr>

						<th rowspan="4" style="width: 15%">转报主机状态</th>
						<th rowspan="2" style="width: 15%">A(192.168.11.1)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.hostReduncdancyStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.hostWorkStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.2)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.hostReduncdancyStatusB.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.hostWorkStatusB.value}</p>
						</td>
					</tr>
					<tr>

						<th rowspan="4">同步接入器状态</th>
						<th rowspan="2">A(192.168.11.8)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.synReduncdancyStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.synWorkStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.9)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.synReduncdancyStatusB.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.synWorkStatusB.value}</p>
						</td>
					</tr>
					<tr>

						<th rowspan="8">智能集中器状态</th>
						<th rowspan="2">A(192.168.11.11)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.iReduncdancyStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.iWorkStatusA.value}</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.12)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.iReduncdancyStatusB.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.iWorkStatusB.value}</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">C(192.168.11.13)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.iReduncdancyStatusC.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.iWorkStatusC.value}</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">D(192.168.11.14)</th>
						<td>冗余状态</td>
						<td>
							<p>${faxdata.iReduncdancyStatusD.value}</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>${faxdata.iWorkStatusD.value}</p>
						</td>
					</tr>
					<tr>

						<th rowspan="6" colspan="2">异步接入器状态</th>
						<td>接入器1</td>
						<td>
							<p>${faxdata.asynAccess1.value}</p>
						</td>
					</tr>
					<tr>
						<td>接入器2</td>
						<td>
							<p>${faxdata.asynAccess2.value}</p>
						</td>
					</tr>
					<tr>
						<td>接入器3</td>
						<td>
							<p>${faxdata.asynAccess3.value}</p>
						</td>
					</tr>
					<tr>
						<td>接入器4</td>
						<td>
							<p>${faxdata.asynAccess4.value}</p>
						</td>
					</tr>
					<tr>
						<td>接入器5</td>
						<td>
							<p>${faxdata.asynAccess5.value}</p>
						</td>
					</tr>
					<tr>
						<td>接入器6</td>
						<td>
							<p>${faxdata.asynAccess6.value}</p>
						</td>
					</tr>
					<tr>
						<th colspan="2">审核情况</th>
						<td colspan="2">
							<p>${faxdata.judgeUser.name}</p>
							<p><fmt:formatDate value="${faxdata.judgeTime}" type="both"
			                    pattern="yyyy-MM-dd HH:mm" /></p>
			                <p>${faxdata.judgeRemark}</p>
						</td>
					</tr>
				</table>

			</form:form>

			<div class="boxbtn">

				<div class="btn">
					<a href="#none" class="close">关闭</a>
				</div>
			</div>
		</div>

	</div>




</body>