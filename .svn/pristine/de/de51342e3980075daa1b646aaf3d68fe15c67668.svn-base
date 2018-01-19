<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
</script>

<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>卫星工具</dd>
	</dl>
</div>
<table width="100%" border="1">
	<!-- <tr>
		<th colspan="2">记录名称</th>
		<th colspan="2">卫星工具</th>
	</tr> -->
	<tr>
		<th width="25%">工具名称</th>
		<th width="25%"><input id="name" name="name" type="text" /></th>
		<th width="25%">存放位置</th>
		<th width="25%"><input id="address" name="address" type="text" /></th>
	</tr>
	<tr>
		<th width="25%">数量</th>
		<th width="25%"><input id="num" name="num" type="text" /></th>
		<th width="25%">保管人</th>
		<th width="25%"><select id="keeper" name="keeper">
				<option value="">请选择</option>
				<c:forEach items="${engineers}" var="keep">
					<option value="${keep.id }">${keep.name }</option>
				</c:forEach>
		</select></th>
	</tr>
	<tr>
		<th colspan="4">备注</th>
	</tr>
	<tr>
		<th colspan="4"><textarea id="remark" name="remark" rows="2"
				style="width: 80%; height: 40px;"></textarea></th>
	</tr>

	<tr>
		<th width="25%">入库时间</th>
		<th width="25%"><input id="storeTimeWeb" name="storeTimeWeb"
			style="padding: 4px 2px 0px 2px; height: 16px; border: 1px solid #B8B8B8;"
			maxlength="25" class="Wdate"
			onfocus="WdatePicker({el:$dp.$('storeTimeWeb'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" />
		</th>
		<th width="25%">借出状态</th>
		<th width="25%"><select id="lendStatus" name="lendStatus">
				<option value="">请选择</option>
				<c:forEach items="${lendStatuss }" var="sta">
					<option value="${sta }">${sta.value }</option>
				</c:forEach>
		</select></th>
	</tr>
	<tr>
		<th width="25%">借用人</th>
		<th width="25%"><select id="borrower" name="borrower">
				<option value="">请选择</option>
				<c:forEach items="${engineers}" var="borrow">
					<option value="${borrow.id }">${borrow.name }</option>
				</c:forEach>
		</select></th>
		<th width="25%">借出时间</th>
		<th width="25%"><input id="lendTimeWeb" name="lendTimeWeb"
			style="padding: 4px 2px 0px 2px; height: 16px; border: 1px solid #B8B8B8;"
			maxlength="25" class="Wdate"
			onfocus="WdatePicker({el:$dp.$('lendTimeWeb'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" />
		</th>
	</tr>
	<tr>
		<th width="25%">归还时间</th>
		<th width="25%"><input id="backTimeWeb" name="backTimeWeb"
			style="padding: 4px 2px 0px 2px; height: 16px; border: 1px solid #B8B8B8;"
			maxlength="25" class="Wdate"
			onfocus="WdatePicker({el:$dp.$('backTimeWeb'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d',readOnly:true})" />
		</th>
		<th width="25%"></th>
		<th width="25%"></th>
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