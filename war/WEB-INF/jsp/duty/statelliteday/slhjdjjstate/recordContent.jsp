<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES基带机架运行情况</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">检查内容</th>
		<th scope="col">检查结果（必填）</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th scope="col">SIC</th>
		<th scope="col"><form:input path="sic" /></th>
		<th rowspan="15" scope="col">PES网管中查询</th>
	</tr>
	<tr>
		<th scope="col">备用SIC</th>
		<th scope="col"><form:input path="sicb" /></th>
	</tr>
	<tr>
		<th scope="col">NCC（上）</th>
		<th scope="col"><form:input path="ncc" /></th>
	</tr>
	<tr>
		<th scope="col">备用NCC（下）</th>
		<th scope="col"><form:input path="nccb" /></th>
	</tr>
	<tr>
		<th scope="col">DPC1</th>
		<th scope="col"><form:input path="dpc1" /></th>
	</tr>
	<tr>
		<th scope="col">DPC2</th>
		<th scope="col"><form:input path="dpc2" /></th>
	</tr>
	<tr>
		<th scope="col">DPC3</th>
		<th scope="col"><form:input path="dpc3" /></th>
	</tr>
	<tr>
		<th scope="col">备用DPC</th>
		<th scope="col"><form:input path="dpcb" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM1</th>
		<th scope="col"><form:input path="suplim1" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM2</th>
		<th scope="col"><form:input path="suplim2" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM3</th>
		<th scope="col"><form:input path="suplim3" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM4</th>
		<th scope="col"><form:input path="suplim4" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM5</th>
		<th scope="col"><form:input path="suplim5" /></th>
	</tr>
	<tr>
		<th scope="col">SUPLIM6</th>
		<th scope="col"><form:input path="suplim6" /></th>
	</tr>
	<tr>
		<th scope="col">备用SUPLIM</th>
		<th scope="col"><form:input path="suplimb" /></th>
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