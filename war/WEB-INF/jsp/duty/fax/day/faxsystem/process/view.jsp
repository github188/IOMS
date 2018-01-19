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
				action="${rootUrl}duty/fax/day/faxsystem/process/view.do"
				method="post">
				<br></br>
				<input type="hidden" id="proId" name="proId" value="${faxdata.id }" />
				<!-- /.class="table table-bordered" -->
				<table style="width: 100%">
					<tr>
						<th colspan="18" style="font-size: 20px; text-align: left;">转报系统进程检查</th>
					</tr>
					<tr>

						<th>设备名称</th>
						<th>巡检内容</th>

						<th>检查结果</th>
					</tr>
					<tr>

						<th rowspan="8">转报系统主机</th>
						<th>库操作进程</th>

						<td>
							<p>${faxdata.hostDmhsMonPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>${faxdata.hostDmhsAfsPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>IP进程</th>

						<td>
							<p>${faxdata.hostIPPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>R25进程</th>

						<td>
							<p>${faxdata.hostR25Pro.value }</p>
						</td>
					</tr>
					<tr>
						<th>异步进程</th>

						<td>
							<p>${faxdata.hostAsynPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>帧中继进程</th>

						<td>
							<p>${faxdata.hostFRPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>matip进程</th>

						<td>
							<p>${faxdata.hostMATIPPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>${faxdata.hostDBPro.value }</p>
						</td>
					</tr>
					<tr>

						<th rowspan="3">转报系统备机</th>
						<th>库操作进程</th>

						<td>
							<p>${faxdata.backupDmhsMonPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>${faxdata.backupDmhsAfsPro.value }</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>${faxdata.backupDBPro.value }</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>${faxdata.hostIProIpA.value }</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>${faxdata.hostIProSerialPortA.value }</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>${faxdata.hostIProIpB.value }</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>${faxdata.hostIProSerialPortB.value }</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>${faxdata.backupIProIpA.value }</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>${faxdata.backupIProSerialPortA.value }</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>${faxdata.backupIProIpB.value }</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>${faxdata.backupIProSerialPortB.value }</p>
						</td>
					</tr>

					<tr>
						<td colspan="1">审核：</td>
						<td colspan="2"
							style="text-align: left; padding-top: 5px; padding-bottom: 5px">
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
					<a href="#none" class="close">取消</a>
				</div>
			</div>
		</div>

	</div>




</body>