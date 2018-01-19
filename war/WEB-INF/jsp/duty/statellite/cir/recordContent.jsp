<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>业务电路月检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>业务电路季检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>业务电路年检--添加</dd>
		</c:if>
	</dl>
</div>
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
		<td>业务电路 <form:input path="tesBusiness" /> 条 <br />故障电路 <form:input
				path="tesFault" /> 条
		</td>
		<td><form:input path="tesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>北京网控中心PES站</td>
		<td>业务电路 <form:input path="pesBusiness" /> 条 <br />故障电路 <form:input
				path="pesFault" /> 条
		</td>
		<td><form:input path="pesRemark" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>北京网控中心Ku子网1网管</td>
		<td>业务电路 <form:input path="ku1Business" /> 条 <br />故障电路 <form:input
				path="ku1Fault" /> 条
		</td>
		<td><form:input path="kuNet1Remark" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>北京网控中心Ku子网2网管</td>
		<td>业务电路 <form:input path="ku2Business" /> 条 <br />故障电路 <form:input
				path="ku2Fault" /> 条
		</td>
		<td><form:input path="kuNet2Remark" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td>北京网控中心Ku子网3网管</td>
		<td>业务电路 <form:input path="ku3Business" /> 条 <br />故障电路 <form:input
				path="ku3Fault" /> 条
		</td>
		<td><form:input path="kuNet3Remark" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>北京网控中心帧中继网Ku站</td>
		<td>业务电路 <form:input path="kuBusiness" /> 条 <br />故障电路 <form:input
				path="kuFault" /> 条
		</td>
		<td><form:input path="kuRemark" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>北京网控中心境外站（COMTECH）</td>
		<td>业务电路 <form:input path="comBusiness" /> 条 <br />故障电路 <form:input
				path="comFault" /> 条
		</td>
		<td><form:input path="comRemark" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>十里河Ku站</td>
		<td>业务电路 <form:input path="slhKuBusiness" /> 条 <br />故障电路 <form:input
				path="slhKuFault" /> 条
		</td>
		<td><form:input path="slhKuRemark" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td>民航局TES站</td>
		<td>业务电路 <form:input path="mhjTesBusiness" /> 条 <br />故障电路 <form:input
				path="mhjTesFault" /> 条
		</td>
		<td><form:input path="mhjTesReamrk" /></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td>民航局Ku站</td>
		<td>业务电路 <form:input path="mhjKuBusiness" /> 条 <br />故障电路 <form:input
				path="mhjKuFault" /> 条
		</td>
		<td><form:input path="mhjKuRemark" /></td>
	</tr>
	<tr>
		<th scope="row">11</th>
		<td>汇总</td>
		<td>电路合计 <form:input path="sumBusiness" /> 条 <br />故障电路合计 <form:input
				path="sumFault" /> 条
		</td>
		<td><form:input path="sumRemark" /></td>
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