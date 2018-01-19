<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>卫星转发器频带资源使用统计--更新</dd>
	</dl>
</div>

<table width="100%" border="1">
	<tr>
		<th height="33" colspan="8" scope="col">卫星转发器频带资源使用统计</th>
	</tr>
	<tr>
		<th width="4%" scope="row">序号</th>
		<td width="13%">转发器名称</td>
		<td width="12%">通信系统</td>
		<td width="12%">总宽带（MHz）</td>
		<td width="15%">已用宽带（MHz）</td>
		<td width="13%">剩余宽带（MHz）</td>
		<td width="15%">转发器底噪电平（dbm）</td>
		<td width="16%">转发器增益档（db）</td>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td><p>中星10号C-8B</p></td>
		<td>TES系统</td>
		<td><form:input path="tesSum" value="${vo.tesSum }" /></td>
		<td><form:input path="tesUse" value="${vo.tesUse }" /></td>
		<td><form:input path="tesSur" value="${vo.tesSur }" /></td>
		<td><form:input path="tesDbm" value="${vo.tesDbm }" /></td>
		<td><form:input path="tesDb" value="${vo.tesDb }" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>中星10号C-8B</td>
		<td>PES系统</td>
		<td><form:input path="pesSum" value="${vo.pesSum }" /></td>
		<td><form:input path="pesUse" value="${vo.pesUse }" /></td>
		<td><form:input path="pesSur" value="${vo.pesSur }" /></td>
		<td><form:input path="pesDbm" value="${vo.pesDbm }" /></td>
		<td><form:input path="pesDb" value="${vo.pesDb }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>亚洲 4 号 K-8V</td>
		<td>VsatPlusⅡ系统</td>
		<td><form:input path="vsatSum" value="${vo.vsatSum }" /></td>
		<td><form:input path="vsatUse" value="${vo.vsatUse }" /></td>
		<td><form:input path="vsatSur" value="${vo.vsatSur }" /></td>
		<td><form:input path="vsatDbm" value="${vo.vsatDbm }" /></td>
		<td><form:input path="vsatDb" value="${vo.vsatDb }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>中星10号C-8B</td>
		<td>COMTECH系统</td>
		<td><form:input path="comSum" value="${vo.comSum }" /></td>
		<td><form:input path="comUse" value="${vo.comUse }" /></td>
		<td><form:input path="comSur" value="${vo.comSur }" /></td>
		<td><form:input path="comDbm" value="${vo.comDbm }" /></td>
		<td><form:input path="comDb" value="${vo.comDb }" /></td>
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
