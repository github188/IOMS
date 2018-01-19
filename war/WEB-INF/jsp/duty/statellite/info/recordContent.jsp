<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<c:if test="${outType eq 'tesequ' }">
				<dd>通信基地-TES-室内设备月检</dd>
			</c:if>
			<c:if test="${outType eq 'mhjtesequ' }">
				<dd>民航局-TES-室内设备月检</dd>
			</c:if>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<c:if test="${outType eq 'tesequ' }">
				<dd>通信基地-TES-室内设备季检</dd>
			</c:if>
			<c:if test="${outType eq 'mhjtesequ' }">
				<dd>民航局-TES-室内设备季检</dd>
			</c:if>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<c:if test="${outType eq 'tesequ' }">
				<dd>通信基地-TES-室内设备年检</dd>
			</c:if>
			<c:if test="${outType eq 'mhjtesequ' }">
				<dd>民航局-TES-室内设备年检</dd>
			</c:if>
		</c:if>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th width="5%">序号</th>
		<th width="10%">所属系统</th>
		<th width="10%">设备名称</th>
		<th width="10%">序列号</th>
		<th width="10%">存放位置</th>
		<th width="10%">测试结果</th>
		<th width="25%">测试时间</th>
		<th width="10%">备注</th>
		<th width="10%">测试人</th>
	</tr>
	<tr>
		<td>1</td>
		<td><form:input path="sys1" /></td>
		<td><form:input path="name1" /></td>
		<td><form:input path="sn1" /></td>
		<td><form:input path="address1" /></td>
		<td><form:input path="testresolt1" /></td>
		<td><form:input cssStyle="color:#000" path="testtime1"
				cssClass="inputDate" readonly="true"
				onfocus="WdatePicker({el:$dp.$('testtime1'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'testtime1\\')}'});" /></td>
		<td><form:input path="remark1" /></td>
		<td><form:input path="testp1" /></td>
	</tr>
	<tr>
		<td>2</td>
		<td><form:input path="sys2" /></td>
		<td><form:input path="name2" /></td>
		<td><form:input path="sn2" /></td>
		<td><form:input path="address2" /></td>
		<td><form:input path="testresolt2" /></td>
		<td><form:input cssStyle="color:#000" path="testtime2"
				cssClass="inputDate" readonly="true"
				onfocus="WdatePicker({el:$dp.$('testtime1'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'testtime1\\')}'});" /></td>
		<td><form:input path="remark2" /></td>
		<td><form:input path="testp2" /></td>
	</tr>
	<tr>
		<td>3</td>
		<td><form:input path="sys3" /></td>
		<td><form:input path="name3" /></td>
		<td><form:input path="sn3" /></td>
		<td><form:input path="address3" /></td>
		<td><form:input path="testresolt3" /></td>
		<td><form:input cssStyle="color:#000" path="testtime3"
				cssClass="inputDate" readonly="true"
				onfocus="WdatePicker({el:$dp.$('testtime1'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'testtime1\\')}'});" /></td>
		<td><form:input path="remark3" /></td>
		<td><form:input path="testp3" /></td>
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