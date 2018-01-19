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

	function Add() {
		if (confirm("您确定添加转报系统记录吗？")) {
		$("#addForm").ajaxSubmit({
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("添加成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("添加失败");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				}
			}
		})
		}
	}
</script>
<style>
</style>
</head>

<body>

	<div class="window">
		<dl class="title">
			<dd>转报系统巡检添加</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>

		<div class="mtab" style="padding-right:70px;">

         
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl}duty/fax/day/faxsystem/add.do" method="post">
                <br></br>
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
							<p>
								主用<input type="radio" name="hostReduncdancyStatusA" value="MAIN"
									checked="checked" /> 备用<input type="radio"
									name="hostReduncdancyStatusA" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK <input type="radio" name="hostWorkStatusA" value="OK"
									checked="checked" /> NA <input type="radio"
									name="hostWorkStatusA" value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.2)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="hostReduncdancyStatusB" value="MAIN"
									checked="checked" /> 备用<input type="radio"
									name="hostReduncdancyStatusB" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="hostWorkStatusB" value="OK"
									checked="checked" />NA <input type="radio"
									name="hostWorkStatusB" value="NA" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="4">同步接入器状态</th>
						<th rowspan="2">A(192.168.11.8)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="synReduncdancyStatusA" value="MAIN"
									checked="checked" />备用 <input type="radio"
									name="synReduncdancyStatusA" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="synWorkStatusA" value="OK"
									checked="checked" />NA <input type="radio"
									name="synWorkStatusA" value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.9)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="synReduncdancyStatusB" value="MAIN"
									checked="checked" /> 备用 <input type="radio"
									name="synReduncdancyStatusB" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="synWorkStatusB" value="OK"
									checked="checked" /> NA<input type="radio"
									name="synWorkStatusB" value="NA" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="8">智能集中器状态</th>
						<th rowspan="2">A(192.168.11.11)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="iReduncdancyStatusA" value="MAIN"
									checked="checked" /> 备用<input type="radio"
									name="iReduncdancyStatusA" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="iWorkStatusA" value="OK"
									checked="checked" /> NA <input type="radio"
									name="iWorkStatusA" value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.12)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="iReduncdancyStatusB" value="MAIN"
									checked="checked" /> 备用 <input type="radio"
									name="iReduncdancyStatusB" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="iWorkStatusB" value="OK"
									checked="checked" /> NA<input type="radio" name="iWorkStatusB"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">C(192.168.11.13)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="iReduncdancyStatusC" value="MAIN"
									checked="checked" /> 备用 <input type="radio"
									name="iReduncdancyStatusC" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="iWorkStatusC" value="OK"
									checked="checked" /> NA<input type="radio" name="iWorkStatusC"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">D(192.168.11.14)</th>
						<td>冗余状态</td>
						<td>
							<p>
								主用<input type="radio" name="iReduncdancyStatusD" value="MAIN"
									checked="checked" /> 备用 <input type="radio"
									name="iReduncdancyStatusD" value="SPARE" />
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								OK<input type="radio" name="iWorkStatusD" value="OK"
									checked="checked" /> NA <input type="radio"
									name="iWorkStatusD" value="NA" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="6" colspan="2">异步接入器状态</th>
						<td>接入器1</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess1" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess1"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器2</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess2" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess2"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器3</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess3" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess3"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器4</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess4" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess4"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器5</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess5" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess5"
									value="NA" />
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器6</td>
						<td>
							<p>
								OK<input type="radio" name="asynAccess6" value="OK"
									checked="checked" /> NA<input type="radio" name="asynAccess6"
									value="NA" />
							</p>
						</td>
					</tr>
				</table>
                <br></br>

				<!-- /.class="table table-bordered"  -->
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
								正常<input type="radio" name="hostDmhsMonPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostDmhsMonPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostDmhsAfsPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostDmhsAfsPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>IP进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostIPPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio" name="hostIPPro"
									value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>R25进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostR25Pro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio" name="hostR25Pro"
									value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>异步进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostAsynPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostAsynPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>帧中继进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostFRPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio" name="hostFRPro"
									value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>matip进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostMATIPPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostMATIPPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostDBPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio" name="hostDBPro"
									value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="3">转报系统备机</th>
						<th>库操作进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupDmhsMonPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="backupDmhsMonPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>双机进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupDmhsAfsPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="backupDmhsAfsPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>数据库进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupDBPro" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="backupDBPro" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostIProIpA" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostIProIpA" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostIProSerialPortA" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostIProSerialPortA" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">主用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostIProIpB" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostIProIpB" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>
								正常<input type="radio" name="hostIProSerialPortB" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="hostIProSerialPortB" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器A进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupIProIpA" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="backupIProIpA" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupIProSerialPortA"
									value="NORMAL" checked="checked" /> 不正常 <input type="radio"
									name="backupIProSerialPortA" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="2">备用智能集中器B进程检查</th>
						<th>IP连接进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupIProIpB" value="NORMAL"
									checked="checked" /> 不正常 <input type="radio"
									name="backupIProIpB" value="ABNORMAL" />
							</p>
						</td>
					</tr>
					<tr>
						<th>串口通信进程</th>

						<td>
							<p>
								正常<input type="radio" name="backupIProSerialPortB"
									value="NORMAL" checked="checked" /> 不正常 <input type="radio"
									name="backupIProSerialPortB" value="ABNORMAL" />
							</p>
						</td>
					</tr>
				</table>




			</form:form>

			<div class="boxbtn">
				<div class="btn">
					<button class="btn" id="submit" onclick="Add()">提交</button>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
		</div>

	</div>




</body>