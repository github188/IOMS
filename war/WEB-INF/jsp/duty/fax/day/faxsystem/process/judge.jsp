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

	function judge() {

		$("#modForm").ajaxSubmit({
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("审核成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("审核失败");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				}
			}
		})
	}
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
				action="${rootUrl}duty/fax/day/faxsystem/process/judge.do"
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
							<p>
								<c:choose>
									<c:when test="${faxdata.hostDmhsMonPro eq 'NORMAL'}">
								正常<input type="radio" name="hostDmhsMonPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostDmhsMonPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostDmhsMonPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostDmhsMonPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>


								<c:choose>
									<c:when test="${faxdata.hostDmhsAfsPro eq 'NORMAL'}">
								正常<input type="radio" name="hostDmhsAfsPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostDmhsAfsPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostDmhsAfsPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostDmhsAfsPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>IP进程</th>

						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.hostIPPro eq 'NORMAL'}">
								正常<input type="radio" name="hostIPPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostIPPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostIPPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostIPPro" checked="checked"
											value="ABNORMAL" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>R25进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostR25Pro eq 'NORMAL'}">
								正常<input type="radio" name="hostR25Pro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostR25Pro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostR25Pro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostR25Pro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>异步进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostAsynPro eq 'NORMAL'}">
								正常<input type="radio" name="hostAsynPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostAsynPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostAsynPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostAsynPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>帧中继进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostFRPro eq 'NORMAL'}">
								正常<input type="radio" name="hostFRPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostFRPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostFRPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostFRPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>matip进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostMATIPPro eq 'NORMAL'}">
								正常<input type="radio" name="hostMATIPPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostMATIPPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostMATIPPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostMATIPPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostDBPro eq 'NORMAL'}">
								正常<input type="radio" name="hostDBPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostDBPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="hostDBPro" value="NORMAL" /> 不正常 <input
											type="radio" name="hostDBPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="3">转报系统备机</th>
						<th>库操作进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupDmhsMonPro eq 'NORMAL'}">
								正常<input type="radio" name="backupDmhsMonPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="backupDmhsMonPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="backupDmhsMonPro" value="NORMAL" /> 不正常 <input
											type="radio" name="backupDmhsMonPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupDmhsAfsPro eq 'NORMAL'}">
								正常<input type="radio" name="backupDmhsAfsPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="backupDmhsAfsPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="backupDmhsAfsPro" value="NORMAL" /> 不正常 <input
											type="radio" name="backupDmhsAfsPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupDBPro eq 'NORMAL'}">
								正常<input type="radio" name="backupDBPro" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="backupDBPro" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
								正常<input type="radio" name="backupDBPro" value="NORMAL" /> 不正常 <input
											type="radio" name="backupDBPro" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostIProIpA eq 'NORMAL'}">
								正常<input type="radio" name="hostIProIpA" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostIProIpA" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							         正常<input type="radio" name="hostIProIpA" value="NORMAL" /> 不正常 <input
											type="radio" name="hostIProIpA" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostIProSerialPortA eq 'NORMAL'}">
								正常<input type="radio" name="hostIProSerialPortA" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostIProSerialPortA" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							         正常<input type="radio" name="hostIProSerialPortA"
											value="NORMAL" /> 不正常 <input type="radio"
											name="hostIProSerialPortA" value="ABNORMAL" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostIProIpB eq 'NORMAL'}">
								正常<input type="radio" name="hostIProIpB" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostIProIpB" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							         正常<input type="radio" name="hostIProIpB" value="NORMAL" /> 不正常 <input
											type="radio" name="hostIProIpB" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.hostIProSerialPortB eq 'NORMAL'}">
								正常<input type="radio" name="hostIProSerialPortB" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="hostIProSerialPortB" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							        正常<input type="radio" name="hostIProSerialPortB"
											value="NORMAL" /> 不正常 <input type="radio"
											name="hostIProSerialPortB" value="ABNORMAL" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupIProIpA eq 'NORMAL'}">
								正常<input type="radio" name="backupIProIpA" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="backupIProIpA" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							        正常<input type="radio" name="backupIProIpA" value="NORMAL" /> 不正常 <input
											type="radio" name="backupIProIpA" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupIProSerialPortA eq 'NORMAL'}">
								正常<input type="radio" name="backupIProSerialPortA"
											value="NORMAL" checked="checked" /> 不正常 <input type="radio"
											name="backupIProSerialPortA" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							     正常<input type="radio" name="backupIProSerialPortA"
											value="NORMAL" /> 不正常 <input type="radio"
											name="backupIProSerialPortA" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupIProIpB eq 'NORMAL'}">
								正常<input type="radio" name="backupIProIpB" value="NORMAL"
											checked="checked" /> 不正常 <input type="radio"
											name="backupIProIpB" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							         正常<input type="radio" name="backupIProIpB"
											value="NORMAL" /> 不正常 <input type="radio"
											name="backupIProIpB" value="ABNORMAL" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.backupIProSerialPortB eq 'NORMAL'}">
								正常<input type="radio" name="backupIProSerialPortB"
											value="NORMAL" checked="checked" /> 不正常 <input type="radio"
											name="backupIProSerialPortB" value="ABNORMAL" />
									</c:when>
									<c:otherwise>
							      正常<input type="radio" name="backupIProSerialPortB"
											value="NORMAL" /> 不正常 <input type="radio"
											name="backupIProSerialPortB" value="ABNORMAL"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					
					<tr>
						<td colspan="1">审核：</td>
						<td colspan="2" style="text-align:left;padding-top:5px;padding-bottom:5px">
							<p>
								<textarea id="judgeRemark" name="judgeRemark" rows="5" style="width:500px"
									placeholder="内容不能超过100个字"></textarea>
							</p>
						</td>
					</tr>
				</table>

			</form:form>

			<div class="boxbtn">
				<div class="btn">
					<button class="btn" id="submit" onclick="judge()">提交</button>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
		</div>

	</div>




</body>