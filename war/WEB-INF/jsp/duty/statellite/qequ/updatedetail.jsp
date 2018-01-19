<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>运行设备检查--更新</dd>
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
		<td width="53%">机箱数量： <form:input path="indoorTesJx"
				value="${vo.indoorTesJx }" /> 台 正常：<form:input
				path="indoorTesNormal" value="${vo.indoorTesNormal }" /> 台 异常：<form:input
				path="indoorTesInnormal" value="${vo.indoorTesInnormal }" /> 台
		</td>
		<td><form:input path="indoorTesRemark"
				value="${vo.indoorTesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>机箱数量：<form:input path="indoorPesJx"
				value="${vo.indoorPesJx }" /> 台 正常：<form:input
				path="indoorPesNormal" value="${vo.indoorPesNormal }" /> 台 异常：<form:input
				path="indoorPesInnormal" value="${vo.indoorPesInnormal }" /> 台
		</td>
		<td><form:input path="indoorPesRemark"
				value="${vo.indoorPesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心子网1Ku站</td>
		<td>机箱数量：<form:input path="indoorKu1Jx"
				value="${vo.indoorKu1Jx }" /> 台 正常：<form:input
				path="indoorKu1Normal" value="${vo.indoorKu1Normal }" /> 台 异常：<form:input
				path="indoorKu1Innormal" value="${vo.indoorKu1Innormal }" /> 台
		</td>
		<td><form:input path="indoorKu1Remark"
				value="${vo.indoorKu1Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心子网2Ku站</td>
		<td>机箱数量：<form:input path="indoorKu2Jx"
				value="${vo.indoorKu2Jx }" /> 台 正常：<form:input
				path="indoorKu2Normal" value="${vo.indoorKu2Normal }" /> 台 异常：<form:input
				path="indoorKu2Innormal" value="${vo.indoorKu2Innormal }" /> 台
		</td>
		<td><form:input path="indoorKu2Remark"
				value="${vo.indoorKu2Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>北京网控中心子网3Ku站</td>
		<td>机箱数量：<form:input path="indoorKu3Jx"
				value="${vo.indoorKu3Jx }" /> 台 正常：<form:input
				path="indoorKu3Normal" value="${vo.indoorKu3Normal }" /> 台 异常：<form:input
				path="indoorKu3Innormal" value="${vo.indoorKu3Innormal }" /> 台
		</td>
		<td><form:input path="indoorKu3Remark"
				value="${vo.indoorKu3Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>北京网控中心子网4Ku站</td>
		<td>机箱数量：<form:input path="indoorKu4Jx"
				value="${vo.indoorKu4Jx }" /> 台 正常：<form:input path="indoorKu4Normal"
				value="${vo.indoorKu4Normal }" /> 台 异常：<form:input
				path="indoorKu4Innormal" value="${vo.indoorKu4Innormal }" /> 台
		</td>
		<td><form:input path="indoorKu4Remark"
				value="${vo.indoorKu4Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>北京网控中心帧中继网Ku站</td>
		<td>机箱数量：<form:input path="indoorKuJx" value="${vo.indoorKuJx }" />
			台 正常：<form:input path="indoorKuNormal" value="${vo.indoorKuNormal }" />
			台 异常：<form:input path="indoorKuInnormal"
				value="${vo.indoorKuInnormal }" /> 台
		</td>
		<td><form:input path="indoorRelayRemark"
				value="${vo.indoorRelayRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>北京网控中心境外站（COMTECH）</td>
		<td>机箱数量：<form:input path="indoorComJx"
				value="${vo.indoorComJx }" /> 台 正常：<form:input
				path="indoorComNormal" value="${vo.indoorComNormal }" /> 台 异常：<form:input
				path="indoorComInnormal" value="${vo.indoorComInnormal }" /> 台
		</td>
		<td><form:input path="indoorOutRemark"
				value="${vo.indoorOutRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td>十里河TES站</td>
		<td>机箱数量：<form:input path="slhTesJx" value="${vo.slhTesJx }" />
			台 正常：<form:input path="slhTesNormal" value="${vo.slhTesNormal }" />
			台 异常：<form:input path="slhTesInnormal" value="${vo.slhTesInnormal }" />
			台
		</td>
		<td><form:input path="indoorSlhTes" value="${vo.indoorSlhTes }" /></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td>民航局TES站</td>
		<td>机箱数量：<form:input path="mhjTesJx" value="${vo.mhjTesJx }" />
			台 正常：<form:input path="mhjTesNormal" value="${vo.mhjTesNormal }" />
			台 异常：<form:input path="mhjTesInnormal" value="${vo.mhjTesInnormal }" />
			台
		</td>
		<td><form:input path="indoorMhjTes" value="${vo.indoorMhjTes }" /></td>
	</tr>
	<tr>
		<th scope="row">11</th>
		<td>十里河Ku站</td>
		<td>机箱数量：<form:input path="slhKuJx" value="${vo.slhKuJx }" /> 台
			正常：<form:input path="slhKuNormal" value="${vo.slhKuNormal }" /> 台
			异常：<form:input path="slhKuInnormal" value="${vo.slhKuInnormal }" />
			台
		</td>
		<td><form:input path="indoorSlhKu" value="${vo.indoorSlhKu }" /></td>
	</tr>
	<tr>
		<th scope="row">12</th>
		<td>民航局Ku站</td>
		<td>机箱数量：<form:input path="mhjKuJx" value="${vo.mhjKuJx }" /> 台
			正常：<form:input path="mhjKuNormal" value="${vo.mhjKuNormal }" /> 台
			异常：<form:input path="mhjKuInnormal" value="${vo.mhjKuInnormal }" />
			台
		</td>
		<td><form:input path="indoorMhjKu" value="${vo.indoorMhjKu }" /></td>
	</tr>
	<tr>
		<th scope="row">13</th>
		<td>Ku测试站</td>
		<td>机箱数量：<form:input path="kuTestJx" value="${vo.kuTestJx }" />
			台 正常：<form:input path="kuTestNormal" value="${vo.kuTestNormal }" />
			台 异常：<form:input path="kuTestInnormal" value="${vo.kuTestInnormal }" />
			台
		</td>
		<td><form:input path="indoorKuTest" value="${vo.indoorKuTest }" /></td>
	</tr>
	<tr>
		<th colspan="4" scope="row">室外设备检查结果</th>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>北京网控中心TES站</td>
		<td>机箱数量：<form:input path="outdoorTesJx"
				value="${vo.outdoorTesJx }" /> 台 正常：<form:input
				path="outdoorTesNormal" value="${vo.outdoorTesNormal }" /> 台 异常：<form:input
				path="outdoorTesInnormal" value="${vo.outdoorTesInnormal }" /> 台
		</td>
		<td><form:input path="outdoorTesRemark"
				value="${vo.outdoorTesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>机箱数量：<form:input path="outdoorPesJx"
				value="${vo.outdoorPesJx }" /> 台 正常：<form:input
				path="outdoorPesNormal" value="${vo.outdoorPesNormal }" /> 台 异常：<form:input
				path="outdoorPesInnormal" value="${vo.outdoorPesInnormal }" /> 台
		</td>
		<td><form:input path="outdoorPesRemark"
				value="${vo.outdoorPesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心Ku站</td>
		<td>机箱数量：<form:input path="outdoorKuJx"
				value="${vo.outdoorKuJx }" /> 台 正常：<form:input
				path="outdoorKuNormal" value="${vo.outdoorKuNormal }" /> 台 异常：<form:input
				path="outdoorKuInnormal" value="${vo.outdoorKuInnormal }" /> 台
		</td>
		<td><form:input path="outdoorKuRemark"
				value="${vo.outdoorKuRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心境外站（COMTECH）</td>
		<td>机箱数量：<form:input path="outdoorComJx"
				value="${vo.outdoorComJx }" /> 台 正常：<form:input
				path="outdoorComNormal" value="${vo.outdoorComNormal }" /> 台 异常：<form:input
				path="outdoorComInnormal" value="${vo.outdoorComInnormal }" /> 台
		</td>
		<td><form:input path="outdoorOutRemark"
				value="${vo.outdoorOutRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>十里河TES站</td>
		<td>机箱数量：<form:input path="outdoorSlhtesJx"
				value="${vo.outdoorSlhtesJx }" /> 台 正常：<form:input
				path="outdoorSlhtesNormal" value="${vo.outdoorSlhtesNormal }" /> 台
			异常：<form:input path="outdoorSlhtesInnormal"
				value="${vo.outdoorSlhtesInnormal }" /> 台
		</td>
		<td><form:input path="outdoorSlhTes" value="${vo.outdoorSlhTes }" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>民航局TES站</td>
		<td>机箱数量：<form:input path="outdoorMhjtesJx"
				value="${vo.outdoorMhjtesJx }" /> 台 正常：<form:input
				path="outdoorMhjtesNormal" value="${vo.outdoorMhjtesNormal }" /> 台
			异常：<form:input path="outdoorMhjtesInnormal"
				value="${vo.outdoorMhjtesInnormal }" /> 台
		</td>
		<td><form:input path="outdoorMhjTes" value="${vo.outdoorMhjTes }" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>十里河Ku站</td>
		<td>机箱数量：<form:input path="outdoorSlhkuJx"
				value="${vo.outdoorSlhkuJx }" /> 台 正常：<form:input
				path="outdoorSlhkuNormal" value="${vo.outdoorSlhkuNormal }" /> 台
			异常：<form:input path="outdoorSlhkuInnormal"
				value="${vo.outdoorSlhkuInnormal }" /> 台
		</td>
		<td><form:input path="outdoorSlhKu" value="${vo.outdoorSlhKu }" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>民航局Ku站</td>
		<td>机箱数量：<form:input path="outdoorMhjkuJx"
				value="${vo.outdoorMhjkuJx }" /> 台 正常：<form:input
				path="outdoorMhjkuNormal" value="${vo.outdoorMhjkuNormal }" /> 台
			异常：<form:input path="outdoorMhjkuInnormal"
				value="${vo.outdoorMhjkuInnormal }" /> 台
		</td>
		<td><form:input path="outdoorMhjKu" value="${vo.outdoorMhjKu }" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td>Ku测试站</td>
		<td>机箱数量：<form:input path="outdoorKucsJx"
				value="${vo.outdoorKucsJx }" /> 台 正常：<form:input
				path="outdoorKucsNormal" value="${vo.outdoorKucsNormal }" /> 台 异常：<form:input
				path="outdoorKucsInnormal" value="${vo.outdoorKucsInnormal }" /> 台
		</td>
		<td><form:input path="outdoorKuTest" value="${vo.outdoorKuTest }" /></td>
	</tr>
	<tr>
		<th colspan="4" scope="row">网管工作站清查结果</th>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>北京网控中心TES站</td>
		<td>工作站数量：<form:input path="wgTesJx" value="${vo.wgTesJx }" /> 台
			正常：<form:input path="wgTesNormal" value="${vo.wgTesNormal }" /> 台
			异常：<form:input path="wgTesInnormal" value="${vo.wgTesInnormal }" />
			台
		</td>
		<td><form:input path="wgTesRemark" value="${vo.wgTesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>工作站数量：<form:input path="wgPesJx" value="${vo.wgPesJx }" /> 台
			正常：<form:input path="wgPesNormal" value="${vo.wgPesNormal }" /> 台
			异常：<form:input path="wgPesInnormal" value="${vo.wgPesInnormal }" />
			台
		</td>
		<td><form:input path="wgPesRemark" value="${vo.wgPesRemark }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心Ku子网1网管</td>
		<td>工作站数量：<form:input path="wgKu1Jx" value="${vo.wgKu1Jx }" /> 台
			正常：<form:input path="wgKu1Normal" value="${vo.wgKu1Normal }" /> 台
			异常：<form:input path="wgKu1Innormal" value="${vo.wgKu1Innormal }" />
			台
		</td>
		<td><form:input path="wgKu1Remark" value="${vo.wgKu1Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心Ku子网2网管</td>
		<td>工作站数量：<form:input path="wgKu2Jx" value="${vo.wgKu2Jx }" /> 台
			正常：<form:input path="wgKu2Normal" value="${vo.wgKu2Normal }" /> 台
			异常：<form:input path="wgKu2Innormal" value="${vo.wgKu2Innormal }" />
			台
		</td>
		<td><form:input path="wgKu2Remark" value="${vo.wgKu2Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>北京网控中心Ku子网3网管</td>
		<td>工作站数量：<form:input path="wgKu3Jx" value="${vo.wgKu3Jx }" /> 台
			正常：<form:input path="wgKu3Normal" value="${vo.wgKu3Normal }" /> 台
			异常：<form:input path="wgKu3Innormal" value="${vo.wgKu3Innormal }" />
			台
		</td>
		<td><form:input path="wgKu3Remark" value="${vo.wgKu3Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>北京网控中心Ku子网4网管</td>
		<td>工作站数量：<form:input path="wgKu4Jx" value="${vo.wgKu4Jx }" /> 台
			正常：<form:input path="wgKu4Normal" value="${vo.wgKu4Normal }" /> 台
			异常：<form:input path="wgKu4Innormal" value="${vo.wgKu4Innormal }" />
			台
		</td>
		<td><form:input path="wgKu4Remark" value="${vo.wgKu4Remark }" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>北京网控中心帧中继网Ku站</td>
		<td>工作站数量：<form:input path="wgKuJx" value="${vo.wgKuJx }" /> 台
			正常：<form:input path="wgKuNormal" value="${vo.wgKuNormal }" /> 台 异常：<form:input
				path="wgKuInnormal" value="${vo.wgKuInnormal }" /> 台
		</td>
		<td><form:input path="wgRelayKu" value="${vo.wgRelayKu }" /></td>
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
