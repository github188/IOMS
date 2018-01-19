<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES ODU状态巡检</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">通信基地TES ODU</th>
	</tr>
	<tr>
		<th width="25%" rowspan="12">巡检内容</th>
		<th width="25%">txa</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="radio" name="txaResult"
			id="txaResult" value="OK">正常 <input type="radio"
			name="txaResult" id="txaResult" value="Alm">异常</th>
	</tr>
	<tr>
		<th width="25%">rxa</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="radio" name="rxaResult"
			id="rxaResult" value="OK">正常 <input type="radio"
			name="rxaResult" id="rxaResult" value="Alm">异常</th>
	</tr>

	<tr>
		<th width="25%">txb</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="radio" name="txbResult"
			id="txbResult" value="OK">正常 <input type="radio"
			name="txbResult" id="txbResult" value="Alm">异常</th>
	</tr>

	<tr>
		<th width="25%">rxb</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="radio" name="rxbResult"
			id="rxbResult" value="OK">正常 <input type="radio"
			name="rxbResult" id="rxbResult" value="Alm">异常</th>
	</tr>
	<tr>
		<th width="25%">TX Freq（A路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="txfreqAresult"
			id="txfreqAresult" /></th>
	</tr>

	<tr>
		<th width="25%">RX Freq（A路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="rxfreqAresult"
			id="rxfreqAresult" /></th>
	</tr>

	<tr>
		<th width="25%">UC AT Level(A路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="usAresult"
			id="usAresult" /></th>
	</tr>

	<tr>
		<th width="25%">DC AT Level(A路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="dcAresult"
			id="dcAresult" /></th>
	</tr>

	<tr>
		<th width="25%">TX Freq（B路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="txfreqBresult"
			id="txfreqBresult" /></th>
	</tr>
	<tr>
		<th width="25%">RX Freq（B路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="rxfreqBresult"
			id="rxfreqBresult" /></th>
	</tr>
	<tr>
		<th width="25%">UC AT Level(B路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="usBresult"
			id="usBresult" /></th>
	</tr>
	<tr>
		<th width="25%">DC AT Level(B路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="dcBresult"
			id="dcBresult" /></th>
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