<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>卫星备件信息库</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="1">记录名称</th>
		<th colspan="2">卫星备件信息库</th>
	</tr>
	<tr>
		<th width="30%" rowspan="8">巡检内容</th>
		<th width="30%">所属系统</th>
		<th width="40%"><input id="system" name="system" type="text" /></th>
	</tr>
	<tr>
		<th width="30%">设备名称</th>
		<th width="40%"><input id="equipName" name="equipName"
			type="text" /></th>
	</tr>
	<tr>
		<th width="30%">序列号</th>
		<th width="40%"><input id="sn" name="sn" type="text" /></th>
	</tr>
	<tr>
		<th width="30%">存放位置</th>
		<th width="40%"><input id="address" name="address" type="text" /></th>
	</tr>
	<tr>
		<th width="30%">测试人</th>
		<th width="40%"><select name="tester" id="tester">
				<option value="">请选择</option>
				<c:forEach items="${users }" var="user">
					<option value="${user.id }">${user.name }</option>
				</c:forEach>
		</select></th>
	</tr>
	<tr>
		<th width="30%">测试时间</th>
		<th width="40%"><input id="testTimeWeb" name="testTimeWeb"
			style="padding: 4px 2px 0px 2px; height: 16px; border: 1px solid #B8B8B8;"
			maxlength="25" class="Wdate"
			onfocus="WdatePicker({el:$dp.$('testTimeWeb'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" /></th>
	</tr>
	<tr>
		<th width="30%">测试结果</th>
		<th width="40%"><input id="result" name="result" type="text" /></th>
	</tr>
	<tr>
		<th width="30%">备注</th>
		<th width="40%"><textarea id="remark" name="remark" rows="2"></textarea></th>
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