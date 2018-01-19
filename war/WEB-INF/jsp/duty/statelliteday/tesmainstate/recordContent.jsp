<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管工作站主备状态</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">巡检内容</th>
		<th scope="col">TES081</th>
		<th scope="col">TES281</th>
		<th scope="col">TES381</th>
		<th scope="col">TES481</th>
	</tr>
	<tr>
		<th scope="col">巡检记过</th>
		<th scope="col"><select name="tes081">
				<option value="ACT PRI">ACT PRI</option>
				<option value="ACT SEC">ACT SEC</option>
				<option value="STA PRI">STA PRI</option>
				<option value="STA SEC">STA SEC</option>
		</select></th>
		<th scope="col"><select name="tes281">
				<option value="ACT PRI">ACT PRI</option>
				<option value="ACT SEC">ACT SEC</option>
				<option value="STA PRI">STA PRI</option>
				<option value="STA SEC">STA SEC</option>
		</select></th>
		<th scope="col"><select name="tes381">
				<option value="ACT PRI">ACT PRI</option>
				<option value="ACT SEC">ACT SEC</option>
				<option value="STA PRI">STA PRI</option>
				<option value="STA SEC">STA SEC</option>
		</select></th>
		<th scope="col"><select name="tes481">
				<option value="ACT PRI">ACT PRI</option>
				<option value="ACT SEC">ACT SEC</option>
				<option value="STA PRI">STA PRI</option>
				<option value="STA SEC">STA SEC</option>
		</select></th>
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