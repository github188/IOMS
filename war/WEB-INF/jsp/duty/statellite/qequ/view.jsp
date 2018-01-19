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
			<dd>运行设备检查--查看</dd>
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
					<th colspan="4" scope="col">运行设备检查</th>
				</tr>
				<tr>
					<th width="12%" scope="row">序号</th>
					<td colspan="2">检查结果</td>
					<td width="11%">备注</td>
				</tr>
				<tr>
					<th colspan="4" scope="row">室内设备检查结果</th>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td width="24%">北京网控中心TES站</td>
					<td width="53%">机箱数量： ${vo.indoorTesJx } 台
						正常：${vo.indoorTesNormal } 台 异常：${vo.indoorTesInnormal } 台</td>
					<td>${vo.indoorTesRemark }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>北京网控中心PES站</td>
					<td>机箱数量：${vo.indoorPesJx } 台 正常：${vo.indoorPesNormal } 台
						异常：${vo.indoorPesInnormal } 台</td>
					<td>${vo.indoorPesRemark }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>北京网控中心子网1Ku站</td>
					<td>机箱数量：${vo.indoorKu1Jx } 台 正常：${vo.indoorKu1Normal } 台
						异常：${vo.indoorKu1Innormal } 台</td>
					<td>${vo.indoorKu1Remark }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>北京网控中心子网2Ku站</td>
					<td>机箱数量：${vo.indoorKu2Jx } 台 正常：${vo.indoorKu2Normal } 台
						异常：${vo.indoorKu2Innormal } 台</td>
					<td>${vo.indoorKu2Remark }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>北京网控中心子网3Ku站</td>
					<td>机箱数量：${vo.indoorKu3Jx } 台 正常：${vo.indoorKu3Normal } 台
						异常：${vo.indoorKu3Innormal } 台</td>
					<td>${vo.indoorKu3Remark }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>北京网控中心子网4Ku站</td>
					<td>机箱数量：${vo.indoorKu4Jx } 台 正常：${vo.indoorKu4Normal } 台
						异常：${vo.indoorKu4Innormal } 台</td>
					<td>${vo.indoorKu4Remark }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>北京网控中心帧中继网Ku站</td>
					<td>机箱数量：${vo.indoorKuJx } 台 正常：${vo.indoorKuNormal } 台
						异常：${vo.indoorKuInnormal } 台</td>
					<td>${vo.indoorRelayRemark }</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>北京网控中心境外站（COMTECH）</td>
					<td>机箱数量：${vo.indoorComJx } 台 正常：${vo.indoorComNormal } 台
						异常：${vo.indoorComInnormal } 台</td>
					<td>${vo.indoorOutRemark }</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>十里河TES站</td>
					<td>机箱数量：${vo.slhTesJx } 台 正常：${vo.slhTesNormal } 台
						异常：${vo.slhTesInnormal } 台</td>
					<td>${vo.indoorSlhTes }</td>
				</tr>
				<tr>
					<th scope="row">10</th>
					<td>民航局TES站</td>
					<td>机箱数量：${vo.mhjTesJx } 台 正常：${vo.mhjTesNormal } 台
						异常：${vo.mhjTesInnormal } 台</td>
					<td>${vo.indoorMhjTes }</td>
				</tr>
				<tr>
					<th scope="row">11</th>
					<td>十里河Ku站</td>
					<td>机箱数量：${vo.slhKuJx } 台 正常：${vo.slhKuNormal } 台
						异常：${vo.slhKuInnormal } 台</td>
					<td>${vo.indoorSlhKu }</td>
				</tr>
				<tr>
					<th scope="row">12</th>
					<td>民航局Ku站</td>
					<td>机箱数量：${vo.mhjKuJx } 台 正常：${vo.mhjKuNormal } 台
						异常：${vo.mhjKuInnormal } 台</td>
					<td>${vo.indoorMhjKu }</td>
				</tr>
				<tr>
					<th scope="row">13</th>
					<td>Ku测试站</td>
					<td>机箱数量：${vo.kuTestJx } 台 正常：${vo.kuTestNormal } 台
						异常：${vo.kuTestInnormal } 台</td>
					<td>${vo.indoorKuTest }</td>
				</tr>
				<tr>
					<th colspan="4" scope="row">室外设备检查结果</th>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>北京网控中心TES站</td>
					<td>机箱数量：${vo.outdoorTesJx } 台 正常：${vo.outdoorTesNormal } 台
						异常：${vo.outdoorTesInnormal } 台</td>
					<td>${vo.outdoorTesRemark }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>北京网控中心PES站</td>
					<td>机箱数量：${vo.outdoorPesJx } 台 正常：${vo.outdoorPesNormal } 台
						异常：${vo.outdoorPesInnormal } 台</td>
					<td>${vo.outdoorPesRemark }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>北京网控中心Ku站</td>
					<td>机箱数量：${vo.outdoorKuJx } 台 正常：${vo.outdoorKuNormal } 台
						异常：${vo.outdoorKuInnormal } 台</td>
					<td>${vo.outdoorKuRemark }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>北京网控中心境外站（COMTECH）</td>
					<td>机箱数量：${vo.outdoorComJx } 台 正常：${vo.outdoorComNormal } 台
						异常：${vo.outdoorComInnormal } 台</td>
					<td>${vo.outdoorOutRemark }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>十里河TES站</td>
					<td>机箱数量：${vo.outdoorSlhtesJx } 台 正常：${vo.outdoorSlhtesNormal }
						台 异常：${vo.outdoorSlhtesInnormal } 台</td>
					<td>${vo.outdoorSlhTes }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>民航局TES站</td>
					<td>机箱数量：${vo.outdoorMhjtesJx } 台 正常：${vo.outdoorMhjtesNormal }
						台 异常：${vo.outdoorMhjtesInnormal } 台</td>
					<td>${vo.outdoorMhjTes }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>十里河Ku站</td>
					<td>机箱数量：${vo.outdoorSlhkuJx } 台 正常：${vo.outdoorSlhkuNormal }
						台 异常：${vo.outdoorSlhkuInnormal } 台</td>
					<td>${vo.outdoorSlhKu }</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>民航局Ku站</td>
					<td>机箱数量：${vo.outdoorMhjkuJx } 台 正常：${vo.outdoorMhjkuNormal }
						台 异常：${vo.outdoorMhjkuInnormal } 台</td>
					<td>${vo.outdoorMhjKu }</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>Ku测试站</td>
					<td>机箱数量：${vo.outdoorKucsJx } 台 正常：${vo.outdoorKucsNormal } 台
						异常：${vo.outdoorKucsInnormal } 台</td>
					<td>${vo.outdoorKuTest }</td>
				</tr>
				<tr>
					<th colspan="4" scope="row">网管工作站清查结果</th>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>北京网控中心TES站</td>
					<td>工作站数量：${vo.wgTesJx } 台 正常：${vo.wgTesNormal } 台
						异常：${vo.wgTesInnormal } 台</td>
					<td>${vo.wgTesRemark }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>北京网控中心PES站</td>
					<td>工作站数量：${vo.wgPesJx } 台 正常：${vo.wgPesNormal } 台
						异常：${vo.wgPesInnormal } 台</td>
					<td>${vo.wgPesRemark }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>北京网控中心Ku子网1网管</td>
					<td>工作站数量：${vo.wgKu1Jx } 台 正常：${vo.wgKu1Normal } 台
						异常：${vo.wgKu1Innormal } 台</td>
					<td>${vo.wgKu1Remark }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>北京网控中心Ku子网2网管</td>
					<td>工作站数量：${vo.wgKu2Jx } 台 正常：${vo.wgKu2Normal } 台
						异常：${vo.wgKu2Innormal } 台</td>
					<td>${vo.wgKu2Remark }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>北京网控中心Ku子网3网管</td>
					<td>工作站数量：${vo.wgKu3Jx } 台 正常：${vo.wgKu3Normal } 台
						异常：${vo.wgKu3Innormal } 台</td>
					<td>${vo.wgKu3Remark }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>北京网控中心Ku子网4网管</td>
					<td>工作站数量：${vo.wgKu4Jx } 台 正常：${vo.wgKu4Normal } 台
						异常：${vo.wgKu4Innormal } 台</td>
					<td>${vo.wgKu4Remark }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>北京网控中心帧中继网Ku站</td>
					<td>工作站数量：${vo.wgKuJx } 台 正常：${vo.wgKuNormal } 台
						异常：${vo.wgKuInnormal } 台</td>
					<td>${vo.wgRelayKu }</td>
				</tr>
			</table>





		</div>
	</div>
</body>
</html>