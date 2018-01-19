<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>东四民航局TES ODU状态巡检--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">东四民航局TES ODU状态</th>
	</tr>
	<tr>
		<th width="30%" rowspan="13">巡检内容</th>
		<th width="30%">主用侧（A/B）</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.masterAbResult eq 'A' }">
					<input type="radio" name="masterAbResult" id="masterAbResult"
						value="A" checked="checked" />A<input type="radio"
						name="masterAbResult" id="masterAbResult" value="B" />B
		</c:when>
				<c:when test="${vo.masterAbResult eq 'B' }">
					<input type="radio" name="masterAbResult" id="masterAbResult"
						value="A" />A<input type="radio" name="masterAbResult"
						id="masterAbResult" value="B" checked="checked" />B
		</c:when>
				<c:otherwise>
					<input type="radio" name="masterAbResult" id="masterAbResult"
						value="A" />A<input type="radio" name="masterAbResult"
						id="masterAbResult" value="B" />B
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Receive Freq(MHz)</th>
		<th width="30%"><input type="text" name="receiveResult"
			id="receiveResult" value="${vo.receiveResult }" /></th>
	</tr>
	<tr>
		<th width="30%">Transmit Freq(MHz)</th>
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
					<input type="radio" name="fixedResult" id="fixedResult"
						value="GOOD" checked="checked" />正常<input type="radio"
						name="fixedResult" id="fixedResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.fixedResult eq 'FAULT' }">
					<input type="radio" name="fixedResult" id="fixedResult"
						value="GOOD" />正常<input type="radio" name="fixedResult"
						id="fixedResult" value="FAULT" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="fixedResult" id="fixedResult"
						value="GOOD" />正常<input type="radio" name="fixedResult"
						id="fixedResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Var.Freq.pll</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.varResult eq 'GOOD' }">
					<input type="radio" name="varResult" id="varResult" value="GOOD"
						checked="checked" />正常<input type="radio" name="varResult"
						id="varResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.varResult eq 'FAULT' }">
					<input type="radio" name="varResult" id="varResult" value="GOOD" />正常<input
						type="radio" name="varResult" id="varResult" value="FAULT"
						checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="varResult" id="varResult" value="GOOD" />正常<input
						type="radio" name="varResult" id="varResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext PA Power</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.extpowerResult eq 'GOOD' }">
					<input type="radio" name="extpowerResult" id="extpowerResult"
						value="GOOD" checked="checked" />正常<input type="radio"
						name="extpowerResult" id="extpowerResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.extpowerResult eq 'FAULT' }">
					<input type="radio" name="extpowerResult" id="extpowerResult"
						value="GOOD" />正常<input type="radio" name="extpowerResult"
						id="extpowerResult" value="FAULT" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="extpowerResult" id="extpowerResult"
						value="GOOD" />正常<input type="radio" name="extpowerResult"
						id="extpowerResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext PA Temp</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.exttempResult eq 'GOOD' }">
					<input type="radio" name="exttempResult" id="exttempResult"
						value="GOOD" checked="checked" />正常<input type="radio"
						name="exttempResult" id="exttempResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.exttempResult eq 'FAULT' }">
					<input type="radio" name="exttempResult" id="exttempResult"
						value="GOOD" />正常<input type="radio" name="exttempResult"
						id="exttempResult" value="FAULT" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="exttempResult" id="exttempResult"
						value="GOOD" />正常<input type="radio" name="exttempResult"
						id="exttempResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">LNA Current</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.lanResult eq 'GOOD' }">
					<input type="radio" name="lanResult" id="lanResult" value="GOOD"
						checked="checked" />正常<input type="radio" name="lanResult"
						id="lanResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.lanResult eq 'FAULT' }">
					<input type="radio" name="lanResult" id="lanResult" value="GOOD" />正常<input
						type="radio" name="lanResult" id="lanResult" value="FAULT"
						checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="lanResult" id="lanResult" value="GOOD" />正常<input
						type="radio" name="lanResult" id="lanResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Summary Current</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.summaryResult eq 'GOOD' }">
					<input type="radio" name="summaryResult" id="summaryResult"
						value="GOOD" checked="checked" />正常<input type="radio"
						name="summaryResult" id="summaryResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.summaryResult eq 'FAULT' }">
					<input type="radio" name="summaryResult" id="summaryResult"
						value="GOOD" />正常<input type="radio" name="summaryResult"
						id="summaryResult" value="FAULT" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="summaryResult" id="summaryResult"
						value="GOOD" />正常<input type="radio" name="summaryResult"
						id="summaryResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Ext 11V Supply</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.extResult eq 'GOOD' }">
					<input type="radio" name="extResult" id="extResult" value="GOOD"
						checked="checked" />正常<input type="radio" name="extResult"
						id="extResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.extResult eq 'FAULT' }">
					<input type="radio" name="extResult" id="extResult" value="GOOD" />正常<input
						type="radio" name="extResult" id="extResult" value="FAULT"
						checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="extResult" id="extResult" value="GOOD" />正常<input
						type="radio" name="extResult" id="extResult" value="FAULT" />异常
		</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="30%">Redundant Status</th>
		<th width="30%"><c:choose>
				<c:when test="${vo.redundantResult eq 'GOOD' }">
					<input type="radio" name="redundantResult" id="redundantResult"
						value="GOOD" checked="checked" />正常<input type="radio"
						name="redundantResult" id="redundantResult" value="FAULT" />异常
		</c:when>
				<c:when test="${vo.redundantResult eq 'FAULT' }">
					<input type="radio" name="redundantResult" id="redundantResult"
						value="GOOD" />正常<input type="radio" name="redundantResult"
						id="redundantResult" value="FAULT" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="redundantResult" id="redundantResult"
						value="GOOD" />正常<input type="radio" name="redundantResult"
						id="redundantResult" value="FAULT" />异常
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
