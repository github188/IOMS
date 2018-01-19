<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地境外站主站载波状态巡检--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">通信基地-境外站-境外站主站</th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">巡检内容</th>
		<th width="20%" rowspan="2">主站载波</th>
		<th width="20%" rowspan="1">峰值(dBm)</th>
		<th width="20%"><input type="text" name="carrierPeak"
			id="carrierPeak" value="${vo.carrierPeak }"/></th>
	</tr>
	<tr>
		<th width="20%" rowspan="1">底噪(dBm)</th>
		<th width="20%"><input type="text" name="carrierNoise"
			id="carrierNoise" value="${vo.carrierNoise }"/></th>
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
