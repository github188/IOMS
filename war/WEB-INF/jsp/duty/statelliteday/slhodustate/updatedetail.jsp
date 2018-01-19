<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES主站ODU状态--更新</dd>
	</dl>
</div>
<table width="100%" border="0">

	<tr>
		<th width="30%" rowspan="16"><font color="red">(*)</font>巡检内容</th>
		<th width="30%">主用侧(A/B)</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.masterAbResult eq 'A' }">
					<label><input type="radio" name="masterAbResult"
						id="masterAbResult" value="A" checked="checked" />A</label>
					<label><input type="radio" name="masterAbResult"
						id="masterAbResult" value="B" />B</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="masterAbResult"
						id="masterAbResult" value="A" />A</label>
					<label><input type="radio" name="masterAbResult"
						id="masterAbResult" value="B" checked="checked" />B</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Receive Freq</th>
		<th width="30%"><input type="text" name="receiveResult"
			id="receiveResult" value="${vo.receiveResult }" /></th>
	</tr>
	<tr>
		<th width="30%">Transmit Freq</th>
		<th width="30%"><input type="text" name="transmitResult"
			id="transmitResult" value="${vo.transmitResult }" /></th>
	</tr>
	<tr>
		<th width="30%">Atten Down</th>
		<th width="30%"><input type="text" name="attendownResult"
			id="attendownResult" value="${vo.attendownResult }" /></th>
	</tr>
	<tr>
		<th width="30%">Atten Up</th>
		<th width="30%"><input type="text" name="attenupResult"
			id="attenupResult" value="${vo.attenupResult }" /></th>
	</tr>
	<tr>
		<th width="30%">Fixed Freq.PLL</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.fixedResult eq 'GOOD' }">
					<label><input type="radio" name="fixedResult"
						id="fixedResult" value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="fixedResult"
						id="fixedResult" value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="fixedResult"
						id="fixedResult" value="GOOD" />GOOD </label>
					<label><input type="radio" name="fixedResult"
						id="fixedResult" value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Var Freq.pll</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.varResult eq 'GOOD' }">
					<label><input type="radio" name="varResult" id="varResult"
						value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="varResult" id="varResult"
						value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="varResult" id="varResult"
						value="GOOD" />GOOD</label>
					<label><input type="radio" name="varResult" id="varResult"
						value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext PA Power</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.extpowerResult eq 'GOOD' }">
					<label><input type="radio" name="extpowerResult"
						id="extpowerResult" value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="extpowerResult"
						id="extpowerResult" value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="extpowerResult"
						id="extpowerResult" value="GOOD" />GOOD </label>
					<label><input type="radio" name="extpowerResult"
						id="extpowerResult" value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext PA Temp</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.exttempResult eq 'GOOD' }">
					<label><input type="radio" name="exttempResult"
						id="exttempResult" value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="exttempResult"
						id="exttempResult" value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="exttempResult"
						id="exttempResult" value="GOOD" />GOOD </label>
					<label><input type="radio" name="exttempResult"
						id="exttempResult" value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">LNA Current</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.lanResult eq 'GOOD' }">
					<label><input type="radio" name="lanResult" id="lanResult"
						value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="lanResult" id="lanResult"
						value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="lanResult" id="lanResult"
						value="GOOD" />GOOD </label>
					<label><input type="radio" name="lanResult" id="lanResult"
						value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Summary Current</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.summaryResult eq 'GOOD' }">
					<label><input type="radio" name="summaryResult"
						id="summaryResult" value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="summaryResult"
						id="summaryResult" value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="summaryResult"
						id="summaryResult" value="GOOD" />GOOD </label>
					<label><input type="radio" name="summaryResult"
						id="summaryResult" value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext 11V Supply</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.extResult eq 'GOOD' }">
					<label><input type="radio" name="extResult" id="extResult"
						value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="extResult" id="extResult"
						value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="extResult" id="extResult"
						value="GOOD" />GOOD </label>
					<label><input type="radio" name="extResult" id="extResult"
						value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Redundant Status</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.redundantResult eq 'GOOD' }">
					<label><input type="radio" name="redundantResult"
						id="redundantResult" value="GOOD" checked="checked" />GOOD </label>
					<label><input type="radio" name="redundantResult"
						id="redundantResult" value="FAULT" />FAULT</label>
				</c:when>
				<c:otherwise>
					<label><input type="radio" name="redundantResult"
						id="redundantResult" value="GOOD" />GOOD </label>
					<label><input type="radio" name="redundantResult"
						id="redundantResult" value="FAULT" checked="checked" />FAULT</label>
				</c:otherwise>
			</c:choose></th>
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
