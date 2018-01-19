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

	function mod() {
		if (confirm("您确定修改转报系统硬件记录吗？")) {
		$("#modForm").ajaxSubmit({
			dataType : "json",
			success : function(data, status, xhr) {
				if (data.success == true) {
					alert("修改成功");
					parent.$.nyroModalRemove();
					window.top.location.reload();
				} else {
					alert("修改失败");
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
			<dd>转报系统硬件编辑</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>

		<div class="mtab" style="padding-right: 70px;">


			<form:form modelAttribute="pageModel" id="modForm" name="modForm"
				action="${rootUrl}duty/fax/day/faxsystem/mod.do" method="post">
				<br></br>
				<input type="hidden" id="hardwareId" name="hardwareId" value="${faxdata.id }" />
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
								<c:choose>
									<c:when test="${faxdata.hostReduncdancyStatusA eq 'MAIN'}">
										主用<input type="radio" name="hostReduncdancyStatusA"
											value="MAIN" checked="checked" /> 备用<input type="radio"
											name="hostReduncdancyStatusA" value="SPARE" />
									</c:when>
									<c:otherwise>
										主用<input type="radio" name="hostReduncdancyStatusA"
											value="MAIN" /> 备用<input type="radio"
											name="hostReduncdancyStatusA" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>

							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.hostWorkStatusA eq 'OK'}">
										OK <input type="radio" name="hostWorkStatusA" value="OK"
											checked="checked" /> 
								NA <input type="radio" name="hostWorkStatusA" value="NA" />
									</c:when>
									<c:otherwise>
										OK <input type="radio" name="hostWorkStatusA" value="OK" /> 
								NA <input type="radio" name="hostWorkStatusA" value="NA"
											checked="checked" />
									</c:otherwise>
								</c:choose>

							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.2)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.hostReduncdancyStatusB eq 'MAIN'}">
									主用<input type="radio" name="hostReduncdancyStatusB"
											value="MAIN" checked="checked" /> 备用<input type="radio"
											name="hostReduncdancyStatusB" value="SPARE" />
									</c:when>
									<c:otherwise>
									主用<input type="radio" name="hostReduncdancyStatusB"
											value="MAIN" /> 备用<input type="radio"
											name="hostReduncdancyStatusB" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>


							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.hostWorkStatusB eq 'OK'}">
									OK<input type="radio" name="hostWorkStatusB" value="OK"
											checked="checked" />NA <input type="radio"
											name="hostWorkStatusB" value="NA" />
									</c:when>
									<c:otherwise>
									OK<input type="radio" name="hostWorkStatusB" value="OK" />NA <input
											type="radio" name="hostWorkStatusB" value="NA"
											checked="checked" />
									</c:otherwise>
								</c:choose>


							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="4">同步接入器状态</th>
						<th rowspan="2">A(192.168.11.8)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.synReduncdancyStatusA eq 'MAIN'}">
									主用<input type="radio" name="synReduncdancyStatusA" value="MAIN"
											checked="checked" />备用 <input type="radio"
											name="synReduncdancyStatusA" value="SPARE" />
									</c:when>
									<c:otherwise>
									主用<input type="radio" name="synReduncdancyStatusA" value="MAIN" />备用 <input
											type="radio" name="synReduncdancyStatusA" value="SPARE"
											checked="checked" />
									</c:otherwise>
								</c:choose>


							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.synWorkStatusA eq 'OK'}">
									OK<input type="radio" name="synWorkStatusA" value="OK"
											checked="checked" />NA <input type="radio"
											name="synWorkStatusA" value="NA" />
									</c:when>
									<c:otherwise>
								    OK<input type="radio" name="synWorkStatusA" value="OK" />NA <input
											type="radio" name="synWorkStatusA" value="NA"
											checked="checked" />
									</c:otherwise>
								</c:choose>


							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.9)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.synReduncdancyStatusB eq 'MAIN'}">
									主用<input type="radio" name="synReduncdancyStatusB" value="MAIN"
											checked="checked" /> 备用 <input type="radio"
											name="synReduncdancyStatusB" value="SPARE" />
									</c:when>
									<c:otherwise>
								    主用<input type="radio" name="synReduncdancyStatusB"
											value="MAIN" /> 备用 <input type="radio"
											name="synReduncdancyStatusB" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>


							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.synWorkStatusB eq 'OK'}">
									OK<input type="radio" name="synWorkStatusB" value="OK"
											checked="checked" /> NA<input type="radio"
											name="synWorkStatusB" value="NA" />
									</c:when>
									<c:otherwise>
								    OK<input type="radio" name="synWorkStatusB" value="OK" /> NA<input
											type="radio" name="synWorkStatusB" value="NA"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="8">智能集中器状态</th>
						<th rowspan="2">A(192.168.11.11)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iReduncdancyStatusA eq 'MAIN'}">
									主用<input type="radio" name="iReduncdancyStatusA" value="MAIN"
											checked="checked" /> 备用<input type="radio"
											name="iReduncdancyStatusA" value="SPARE" />
									</c:when>
									<c:otherwise>
								   主用<input type="radio" name="iReduncdancyStatusA" value="MAIN" /> 备用<input
											type="radio" name="iReduncdancyStatusA" value="SPARE"
											checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iWorkStatusA eq 'OK'}">
									OK<input type="radio" name="iWorkStatusA" value="OK"
											checked="checked" /> NA <input type="radio"
											name="iWorkStatusA" value="NA" />
									</c:when>
									<c:otherwise>
								   OK<input type="radio" name="iWorkStatusA" value="OK" /> NA <input
											type="radio" name="iWorkStatusA" value="NA" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">B(192.168.11.12)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iReduncdancyStatusB eq 'MAIN'}">
									主用<input type="radio" name="iReduncdancyStatusB" value="MAIN"
											checked="checked" /> 备用 <input type="radio"
											name="iReduncdancyStatusB" value="SPARE" />
									</c:when>
									<c:otherwise>
								   	主用<input type="radio" name="iReduncdancyStatusB"
											value="MAIN" /> 备用 <input type="radio"
											name="iReduncdancyStatusB" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iWorkStatusB eq 'OK'}">
									OK<input type="radio" name="iWorkStatusB" value="OK"
											checked="checked" /> NA<input type="radio"
											name="iWorkStatusB" value="NA" />
									</c:when>
									<c:otherwise>
								  	OK<input type="radio" name="iWorkStatusB" value="OK" /> NA<input
											type="radio" name="iWorkStatusB" value="NA" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">C(192.168.11.13)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iReduncdancyStatusC eq 'MAIN'}">
									主用<input type="radio" name="iReduncdancyStatusC" value="MAIN"
											checked="checked" /> 备用 <input type="radio"
											name="iReduncdancyStatusC" value="SPARE" />
									</c:when>
									<c:otherwise>
								          主用<input type="radio" name="iReduncdancyStatusC"
											value="MAIN" /> 备用 <input type="radio"
											name="iReduncdancyStatusC" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iWorkStatusC eq 'OK'}">
									OK<input type="radio" name="iWorkStatusC" value="OK"
											checked="checked" /> NA<input type="radio"
											name="iWorkStatusC" value="NA" />
									</c:when>
									<c:otherwise>
								         OK<input type="radio" name="iWorkStatusC" value="OK" /> NA<input
											type="radio" name="iWorkStatusC" value="NA" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<th rowspan="2">D(192.168.11.14)</th>
						<td>冗余状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iReduncdancyStatusD eq 'MAIN'}">
									主用<input type="radio" name="iReduncdancyStatusD" value="MAIN"
											checked="checked" /> 备用 <input type="radio"
											name="iReduncdancyStatusD" value="SPARE" />
									</c:when>
									<c:otherwise>
								        主用<input type="radio" name="iReduncdancyStatusD"
											value="MAIN" /> 备用 <input type="radio"
											name="iReduncdancyStatusD" value="SPARE" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>工作状态</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.iWorkStatusD eq 'OK'}">
									OK<input type="radio" name="iWorkStatusD" value="OK"
											checked="checked" /> NA <input type="radio"
											name="iWorkStatusD" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="iWorkStatusD" value="OK" /> NA <input
											type="radio" name="iWorkStatusD" value="NA" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>

						<th rowspan="6" colspan="2">异步接入器状态</th>
						<td>接入器1</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.asynAccess1 eq 'OK'}">
										OK<input type="radio" name="asynAccess1" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess1" value="NA" />
									</c:when>
									<c:otherwise>
									OK<input type="radio" name="asynAccess1" value="OK" /> NA<input
											type="radio" name="asynAccess1" checked="checked" value="NA" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器2</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.asynAccess2 eq 'OK'}">
										OK<input type="radio" name="asynAccess2" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess2" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="asynAccess2" value="OK" /> NA<input
											type="radio" name="asynAccess2" checked="checked" value="NA" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器3</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.asynAccess3 eq 'OK'}">
									OK<input type="radio" name="asynAccess3" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess3" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="asynAccess3" value="OK" /> NA<input
											type="radio" name="asynAccess3" checked="checked" value="NA" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器4</td>
						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.asynAccess4 eq 'OK'}">
									OK<input type="radio" name="asynAccess4" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess4" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="asynAccess4" value="OK" /> NA<input
											type="radio" name="asynAccess4" checked="checked" value="NA" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器5</td>
						<td>
							<p>
								<c:choose>
									<c:when test="${faxdata.asynAccess5 eq 'OK'}">
								OK<input type="radio" name="asynAccess5" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess5" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="asynAccess5" value="OK" /> NA<input
											type="radio" name="asynAccess5" value="NA" checked="checked" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
					<tr>
						<td>接入器6</td>
						<td>
							<p>

								<c:choose>
									<c:when test="${faxdata.asynAccess6 eq 'OK'}">
								OK<input type="radio" name="asynAccess6" value="OK"
											checked="checked" /> NA<input type="radio"
											name="asynAccess6" value="NA" />
									</c:when>
									<c:otherwise>
								OK<input type="radio" name="asynAccess6" value="OK" /> NA<input
											type="radio" name="asynAccess6" checked="checked" value="NA" />
									</c:otherwise>
								</c:choose>
							</p>
						</td>
					</tr>
				</table>

			</form:form>

			<div class="boxbtn">
				<div class="btn">
					<button class="btn" id="submit" onclick="mod()">提交</button>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
		</div>

	</div>




</body>