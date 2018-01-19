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
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>业务电路检查--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="1">
				<tr>
					<th colspan="4" scope="col">业务电路检查记录表</th>
				</tr>
				<tr>
					<th width="13%" scope="row">序号</th>
					<td width="24%">站点名称</td>
					<td width="38%">检查结果</td>
					<td width="25%">备注</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>北京网控中心TES站</td>
					<td>业务电路 ${vo.tesBusiness } 条<br /> 故障电路 ${vo.tesFault } 条
					</td>
					<td>${vo.tesRemark }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>北京网控中心PES站</td>
					<td>业务电路 ${vo.pesBusiness } 条 <br />故障电路 ${vo.pesFault } 条
					</td>
					<td>${vo.pesRemark }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>北京网控中心Ku子网1网管</td>
					<td>业务电路 ${vo.ku1Business } 条<br /> 故障电路 ${vo.ku1Fault } 条
					</td>
					<td>${vo.kuNet1Remark }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>北京网控中心Ku子网2网管</td>
					<td>业务电路 ${vo.ku2Business } 条<br /> 故障电路 ${vo.ku2Fault } 条
					</td>
					<td>${vo.kuNet2Remark }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>北京网控中心Ku子网3网管</td>
					<td>业务电路 ${vo.ku3Business } 条 <br />故障电路 ${vo.ku3Fault } 条
					</td>
					<td>${vo.kuNet3Remark }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>北京网控中心帧中继网Ku站</td>
					<td>业务电路 ${vo.kuBusiness } 条<br /> 故障电路 ${vo.kuFault } 条
					</td>
					<td>${vo.kuRemark }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>北京网控中心境外站（COMTECH）</td>
					<td>业务电路 ${vo.comBusiness } 条<br /> 故障电路 ${vo.comFault } 条
					</td>
					<td>${vo.comRemark }</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>十里河Ku站</td>
					<td>业务电路 ${vo.slhKuBusiness } 条 <br />故障电路 ${vo.slhKuFault }
						条
					</td>
					<td>${vo.slhKuRemark }</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>民航局TES站</td>
					<td>业务电路 ${vo.mhjTesBusiness } 条 <br />故障电路 ${vo.mhjTesFault }
						条
					</td>
					<td>${vo.mhjTesReamrk }</td>
				</tr>
				<tr>
					<th scope="row">10</th>
					<td>民航局Ku站</td>
					<td>业务电路 ${vo.mhjKuBusiness } 条 <br />故障电路 ${vo.mhjKuFault }
						条
					</td>
					<td>${vo.mhjKuRemark }</td>
				</tr>
				<tr>
					<th scope="row">11</th>
					<td>汇总</td>
					<td>电路合计 ${vo.sumBusiness } 条 <br />故障电路合计 ${vo.sumFault } 条
					</td>
					<td>${vo.sumRemark }</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>