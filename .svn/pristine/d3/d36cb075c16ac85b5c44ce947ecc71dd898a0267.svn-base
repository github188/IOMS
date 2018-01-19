<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>运行设备检查月检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>运行设备检查季检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>运行设备检查年检--添加</dd>
		</c:if>
	</dl>
</div>
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
		<td width="53%">机箱数量： <form:input path="indoorTesJx" /> 台 正常：<form:input
				path="indoorTesNormal" /> 台 异常：<form:input path="indoorTesInnormal" />
			台
		</td>
		<td><form:input path="indoorTesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>机箱数量：<form:input path="indoorPesJx" /> 台 正常：<form:input
				path="indoorPesNormal" /> 台 异常：<form:input path="indoorPesInnormal" />
			台
		</td>
		<td><form:input path="indoorPesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心子网1Ku站</td>
		<td>机箱数量：<form:input path="indoorKu1Jx" /> 台 正常：<form:input
				path="indoorKu1Normal" /> 台 异常：<form:input path="indoorKu1Innormal" />
			台
		</td>
		<td><form:input path="indoorKu1Remark" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心子网2Ku站</td>
		<td>机箱数量：<form:input path="indoorKu2Jx" /> 台 正常：<form:input
				path="indoorKu2Normal" /> 台 异常：<form:input path="indoorKu2Innormal" />
			台
		</td>
		<td><form:input path="indoorKu2Remark" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>北京网控中心子网3Ku站</td>
		<td>机箱数量： <form:input path="indoorKu3Jx" /> 台 正常：<form:input
				path="indoorKu3Normal" /> 台 异常：<form:input path="indoorKu3Innormal" />
			台
		</td>
		<td><form:input path="indoorKu3Remark" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>北京网控中心子网4Ku站</td>
		<td>机箱数量：<form:input path="indoorKu4Jx" /> 台 正常：<form:input
				path="indoorKu4Normal" /> 台 异常：<form:input path="indoorKu4Innormal" />
			台
		</td>
		<td><form:input path="indoorKu4Remark" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>北京网控中心帧中继网Ku站</td>
		<td>机箱数量：<form:input path="indoorKuJx" /> 台 正常：<form:input
				path="indoorKuNormal" /> 台 异常：<form:input path="indoorKuInnormal" />
			台
		</td>
		<td><form:input path="indoorRelayRemark" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>北京网控中心境外站（COMTECH）</td>
		<td>机箱数量：<form:input path="indoorComJx" /> 台 正常：<form:input
				path="indoorComNormal" /> 台 异常：<form:input path="indoorComInnormal" />
			台
		</td>
		<td><form:input path="indoorOutRemark" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td>十里河TES站</td>
		<td>机箱数量：<form:input path="slhTesJx" /> 台 正常：<form:input
				path="slhTesNormal" /> 台 异常：<form:input path="slhTesInnormal" /> 台
		</td>
		<td><form:input path="indoorSlhTes" /></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td>民航局TES站</td>
		<td>机箱数量：<form:input path="mhjTesJx" /> 台 正常：<form:input
				path="mhjTesNormal" /> 台 异常：<form:input path="mhjTesInnormal" /> 台
		</td>
		<td><form:input path="indoorMhjTes" /></td>
	</tr>
	<tr>
		<th scope="row">11</th>
		<td>十里河Ku站</td>
		<td>机箱数量：<form:input path="slhKuJx" /> 台 正常：<form:input
				path="slhKuNormal" /> 台 异常：<form:input path="slhKuInnormal" /> 台
		</td>
		<td><form:input path="indoorSlhKu" /></td>
	</tr>
	<tr>
		<th scope="row">12</th>
		<td>民航局Ku站</td>
		<td>机箱数量：<form:input path="mhjKuJx" /> 台 正常：<form:input
				path="mhjKuNormal" /> 台 异常：<form:input path="mhjKuInnormal" /> 台
		</td>
		<td><form:input path="indoorMhjKu" /></td>
	</tr>
	<tr>
		<th scope="row">13</th>
		<td>Ku测试站</td>
		<td>机箱数量：<form:input path="kuTestJx" /> 台 正常：<form:input
				path="kuTestNormal" /> 台 异常：<form:input path="kuTestInnormal" /> 台
		</td>
		<td><form:input path="indoorKuTest" /></td>
	</tr>
	<tr>
		<th colspan="4" scope="row">室外设备检查结果</th>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>北京网控中心TES站</td>
		<td>机箱数量：<form:input path="outdoorTesJx" /> 台 正常：<form:input
				path="outdoorTesNormal" /> 台 异常：<form:input
				path="outdoorTesInnormal" /> 台
		</td>
		<td><form:input path="outdoorTesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>机箱数量：<form:input path="outdoorPesJx" /> 台 正常：<form:input
				path="outdoorPesNormal" /> 台 异常：<form:input
				path="outdoorPesInnormal" /> 台
		</td>
		<td><form:input path="outdoorPesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心Ku站</td>
		<td>机箱数量：<form:input path="outdoorKuJx" /> 台 正常：<form:input
				path="outdoorKuNormal" /> 台 异常：<form:input path="outdoorKuInnormal" />
			台
		</td>
		<td><form:input path="outdoorKuRemark" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心境外站（COMTECH）</td>
		<td>机箱数量：<form:input path="outdoorComJx" /> 台 正常：<form:input
				path="outdoorComNormal" /> 台 异常：<form:input
				path="outdoorComInnormal" /> 台
		</td>
		<td><form:input path="outdoorOutRemark" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>十里河TES站</td>
		<td>机箱数量：<form:input path="outdoorSlhtesJx" /> 台 正常：<form:input
				path="outdoorSlhtesNormal" /> 台 异常：<form:input
				path="outdoorSlhtesInnormal" /> 台
		</td>
		<td><form:input path="outdoorSlhTes" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>民航局TES站</td>
		<td>机箱数量：<form:input path="outdoorMhjtesJx" /> 台 正常：<form:input
				path="outdoorMhjtesNormal" /> 台 异常：<form:input
				path="outdoorMhjtesInnormal" /> 台
		</td>
		<td><form:input path="outdoorMhjTes" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>十里河Ku站</td>
		<td>机箱数量：<form:input path="outdoorSlhkuJx" /> 台 正常：<form:input
				path="outdoorSlhkuNormal" /> 台 异常：<form:input
				path="outdoorSlhkuInnormal" /> 台
		</td>
		<td><form:input path="outdoorSlhKu" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>民航局Ku站</td>
		<td>机箱数量：<form:input path="outdoorMhjkuJx" /> 台 正常：<form:input
				path="outdoorMhjkuNormal" /> 台 异常：<form:input
				path="outdoorMhjkuInnormal" /> 台
		</td>
		<td><form:input path="outdoorMhjKu" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td>Ku测试站</td>
		<td>机箱数量：<form:input path="outdoorKucsJx" /> 台 正常：<form:input
				path="outdoorKucsNormal" /> 台 异常：<form:input
				path="outdoorKucsInnormal" /> 台
		</td>
		<td><form:input path="outdoorKuTest" /></td>
	</tr>
	<tr>
		<th colspan="4" scope="row">网管工作站清查结果</th>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>北京网控中心TES站</td>
		<td>工作站数量：<form:input path="wgTesJx" /> 台 正常：<form:input
				path="wgTesNormal" /> 台 异常：<form:input path="wgTesInnormal" /> 台
		</td>
		<td><form:input path="wgTesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>工作站数量：<form:input path="wgPesJx" /> 台 正常：<form:input
				path="wgPesNormal" /> 台 异常：<form:input path="wgPesInnormal" /> 台
		</td>
		<td><form:input path="wgPesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心Ku子网1网管</td>
		<td>工作站数量：<form:input path="wgKu1Jx" /> 台 正常：<form:input
				path="wgKu1Normal" /> 台 异常：<form:input path="wgKu1Innormal" /> 台
		</td>
		<td><form:input path="wgKu1Remark" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心Ku子网2网管</td>
		<td>工作站数量：<form:input path="wgKu2Jx" /> 台 正常：<form:input
				path="wgKu2Normal" /> 台 异常：<form:input path="wgKu2Innormal" /> 台
		</td>
		<td><form:input path="wgKu2Remark" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>北京网控中心Ku子网3网管</td>
		<td>工作站数量：<form:input path="wgKu3Jx" /> 台 正常：<form:input
				path="wgKu3Normal" /> 台 异常：<form:input path="wgKu3Innormal" /> 台
		</td>
		<td><form:input path="wgKu3Remark" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>北京网控中心Ku子网4网管</td>
		<td>工作站数量：<form:input path="wgKu4Jx" /> 台 正常：<form:input
				path="wgKu4Normal" /> 台 异常：<form:input path="wgKu4Innormal" /> 台
		</td>
		<td><form:input path="wgKu4Remark" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>北京网控中心帧中继网Ku站</td>
		<td>工作站数量：<form:input path="wgKuJx" /> 台 正常：<form:input
				path="wgKuNormal" /> 台 异常：<form:input path="wgKuInnormal" /> 台
		</td>
		<td><form:input path="wgRelayKu" /></td>
	</tr>
</table>


<div class="boxbtn">
	<c:if test="${!view}">
		<div class="btn">
			<a href="#none" id="submit">保存</a>
		</div>
	</c:if>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>