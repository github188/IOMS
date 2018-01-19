<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES网管连通性</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="4" scope="col">网管连通性</th>
		<th scope="col">10.34.64.3(%)</th>
		<th scope="col"><form:input path="con3" /></th>
		<th rowspan="4" scope="col">0%</th>
		<th rowspan="4" scope="col">UCX窗口Ping四台工作站10个</th>
	</tr>
	<tr>
		<th scope="col">10.34.64.4(%)</th>
		<th scope="col"><form:input path="con4" /></th>
	</tr>
	<tr>
		<th scope="col">10.34.64.5(%)</th>
		<th scope="col"><form:input path="con5" /></th>
	</tr>
	<tr>
		<th scope="col">10.34.64.6(%)</th>
		<th scope="col"><form:input path="con6" /></th>
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