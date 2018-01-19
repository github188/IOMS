<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES ODU状态巡检--更新</dd>
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
		<th width="25%"><c:choose>
				<c:when test="${vo.txaResult eq 'OK' }">
					<input type="radio" name="txaResult" id="txaResult" value="OK"
						checked="checked">正常
					<input type="radio" name="txaResult" id="txaResult" value="Alm">异常
				</c:when>
				<c:when test="${vo.txaResult eq 'Alm' }">
					<input type="radio" name="txaResult" id="txaResult" value="OK">正常
					<input type="radio" name="txaResult" id="txaResult" value="Alm"
						checked="checked">异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="txaResult" id="txaResult" value="OK">正常
					<input type="radio" name="txaResult" id="txaResult" value="Alm">异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="25%">rxa</th>
		<th width="25%">自检结果</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.rxaResult eq 'OK' }">
					<input type="radio" name="rxaResult" id="rxaResult" value="OK"
						checked="checked">正常
					<input type="radio" name="rxaResult" id="rxaResult" value="Alm">异常
				</c:when>
				<c:when test="${vo.rxaResult eq 'Alm' }">
					<input type="radio" name="rxaResult" id="rxaResult" value="OK">正常
					<input type="radio" name="rxaResult" id="rxaResult" value="Alm"
						checked="checked">异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="rxaResult" id="rxaResult" value="OK">正常
					<input type="radio" name="rxaResult" id="rxaResult" value="Alm">异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="25%">txb</th>
		<th width="25%">自检结果</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.txbResult eq 'OK' }">
					<input type="radio" name="txbResult" id="txbResult" value="OK"
						checked="checked">正常
					<input type="radio" name="txbResult" id="txbResult" value="Alm">异常
				</c:when>
				<c:when test="${vo.txbResult eq 'Alm' }">
					<input type="radio" name="txbResult" id="txbResult" value="OK">正常
					<input type="radio" name="txbResult" id="txbResult" value="Alm"
						checked="checked">异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="txbResult" id="txbResult" value="OK">正常
					<input type="radio" name="txbResult" id="txbResult" value="Alm">异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="25%">rxb</th>
		<th width="25%">自检结果</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.rxbResult eq 'OK' }">
					<input type="radio" name="rxbResult" id="rxbResult" value="OK"
						checked="checked">正常
					<input type="radio" name="rxbResult" id="rxbResult" value="Alm">异常
				</c:when>
				<c:when test="${vo.rxbResult eq 'Alm' }">
					<input type="radio" name="rxbResult" id="rxbResult" value="OK">正常
					<input type="radio" name="rxbResult" id="rxbResult" value="Alm"
						checked="checked">异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="rxbResult" id="rxbResult" value="OK">正常
					<input type="radio" name="rxbResult" id="rxbResult" value="Alm">异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="25%">TX Freq（A路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="txfreqAresult"
			id="txfreqAresult" value="${vo.txfreqAresult }" /></th>
	</tr>
	<tr>
		<th width="25%">RX Freq（A路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="rxfreqAresult"
			id="rxfreqAresult" value="${vo.rxfreqAresult }" /></th>
	</tr>
	<tr>
		<th width="25%">UC AT Level(A路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="usAresult"
			id="usAresult" value="${vo.usAresult }"></th>
	</tr>
	<tr>
		<th width="25%">DC AT Level(A路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="dcAresult"
			id="dcAresult" value="${vo.dcAresult }"></th>
	</tr>
	<tr>
		<th width="25%">TX Freq（B路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="txfreqBresult"
			id="txfreqBresult" value="${vo.txfreqBresult }" /></th>
	</tr>
	<tr>
		<th width="25%">RX Freq（B路）</th>
		<th width="25%">自检结果(MHz)</th>
		<th width="25%"><input type="text" name="rxfreqBresult"
			id="rxfreqBresult" value="${vo.rxfreqBresult }" /></th>
	</tr>
	<tr>
		<th width="25%">UC AT Level(B路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="usBresult"
			id="usBresult" value="${vo.usBresult }"></th>
	</tr>
	<tr>
		<th width="25%">DC AT Level(B路)</th>
		<th width="25%">自检结果</th>
		<th width="25%"><input type="text" name="dcBresult"
			id="dcBresult" value="${vo.dcBresult }" /></th>
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
