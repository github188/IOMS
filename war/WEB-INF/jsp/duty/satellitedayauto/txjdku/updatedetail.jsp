<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>${checkData.equipName.value }--更新</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="3">${checkData.equipName.value }<input type="hidden"
			name="equipName" id="equipName" value="${checkData.equipName }" />
		</th>
	</tr>
	<tr>
		<th width="20%" rowspan="104">巡检内容</th>

		<th width="20%" rowspan="6">ODU温度</th>
		<th width="40%" colspan="2">ODU_A-UCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAuct eq '0' }">
					<input type="hidden" name="odutAuct" id="odutAuct"
						value="${checkData.odutAuct }" />${checkData.odutAuct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAuct" id="odutAuct"
						value="${checkData.odutAuct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_A-DCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAdct eq '0' }">
					<input type="hidden" name="odutAdct" id="odutAdct"
						value="${checkData.odutAdct }" />${checkData.odutAdct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAdct" id="odutAdct"
						value="${checkData.odutAdct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_A-MCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAmct eq '0' }">
					<input type="hidden" name="odutAmct" id="odutAmct"
						value="${checkData.odutAmct }" />${checkData.odutAmct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAmct" id="odutAmct"
						value="${checkData.odutAmct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_B-UCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBuct eq '0' }">
					<input type="hidden" name="odutBuct" id="odutBuct"
						value="${checkData.odutBuct }" />${checkData.odutBuct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBuct" id="odutBuct"
						value="${checkData.odutBuct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_B-DCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBdct eq '0' }">
					<input type="hidden" name="odutBdct" id="odutBdct"
						value="${checkData.odutBdct }" />${checkData.odutBdct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBdct" id="odutBdct"
						value="${checkData.odutBdct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_B-MCT</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBmct eq '0' }">
					<input type="hidden" name="odutBmct" id="odutBmct"
						value="${checkData.odutBmct }" />${checkData.odutBmct }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBmct" id="odutBmct"
						value="${checkData.odutBmct }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="8">ODU参数</th>
		<th width="40%" colspan="2">UCF_A(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAucf eq '0' }">
					<input type="hidden" name="odutAucf" id="odutAucf"
						value="${checkData.odutAucf }" />${checkData.odutAucf }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAucf" id="odutAucf"
						value="${checkData.odutAucf }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">odutAuca(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAuca eq '0' }">
					<input type="hidden" name="odutAuca" id="odutAuca"
						value="${checkData.odutAuca }" />${checkData.odutAuca }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAuca" id="odutAuca"
						value="${checkData.odutAuca }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">DCF_A(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAdcf eq '0' }">
					<input type="hidden" name="odutAdcf" id="odutAdcf"
						value="${checkData.odutAdcf }" />${checkData.odutAdcf }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAdcf" id="odutAdcf"
						value="${checkData.odutAdcf }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">DCA_A(dB)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutAdca eq '0' }">
					<input type="hidden" name="odutAdca" id="odutAdca"
						value="${checkData.odutAdca }" />${checkData.odutAdca }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutAdca" id="odutAdca"
						value="${checkData.odutAdca }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">UCF_B(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBucf eq '0' }">
					<input type="hidden" name="odutBucf" id="odutBucf"
						value="${checkData.odutBucf }" />${checkData.odutBucf }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBucf" id="odutBucf"
						value="${checkData.odutBucf }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">odutBuca(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBuca eq '0' }">
					<input type="hidden" name="odutBuca" id="odutBuca"
						value="${checkData.odutBuca }" />${checkData.odutBuca }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBuca" id="odutBuca"
						value="${checkData.odutBuca }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">DCF_B(MHz)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBdcf eq '0' }">
					<input type="hidden" name="odutBdcf" id="odutBdcf"
						value="${checkData.odutBdcf }" />${checkData.odutBdcf }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBdcf" id="odutBdcf"
						value="${checkData.odutBdcf }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">DCA_B(dB)</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odutBdca eq '0' }">
					<input type="hidden" name="odutBdca" id="odutBdca"
						value="${checkData.odutBdca }" />${checkData.odutBdca }
		</c:when>
				<c:otherwise>
					<input type="text" name="odutBdca" id="odutBdca"
						value="${checkData.odutBdca }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">ODU状态</th>
		<th width="40%" colspan="2">ODU_A</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odusAresult eq '0' }">
					<input type="hidden" name="odusAresult" id="odusAresult"
						value="${checkData.odusAresult }" />${checkData.odusAresult }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.odusAresult eq 'OK'}">
							<input type="radio" name="odusAresult" id="odusAresult"
								value="OK" checked="checked" />OK
							<input type="radio" name="odusAresult" id="odusAresult"
								value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.odusAresult eq 'Alarm'}">
							<input type="radio" name="odusAresult" id="odusAresult"
								value="OK" />OK
							<input type="radio" name="odusAresult" id="odusAresult"
								value="Alarm" checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="odusAresult" id="odusAresult"
								value="OK" />OK
							<input type="radio" name="odusAresult" id="odusAresult"
								value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="40%" colspan="2">ODU_B</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.odusBresult eq '0' }">
					<input type="hidden" name="odusBresult" id="odusBresult"
						value="${checkData.odusBresult }" />${checkData.odusBresult }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.odusBresult eq 'OK'}">
							<input type="radio" name="odusBresult" id="odusBresult"
								value="OK" checked="checked" />OK
							<input type="radio" name="odusBresult" id="odusBresult"
								value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.odusBresult eq 'Alarm'}">
							<input type="radio" name="odusBresult" id="odusBresult"
								value="OK" />OK
							<input type="radio" name="odusBresult" id="odusBresult"
								value="Alarm" checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="odusBresult" id="odusBresult"
								value="OK" />OK
							<input type="radio" name="odusBresult" id="odusBresult"
								value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="10">KU网管工作站状态</th>
		<th width="20%" rowspan="2">子网1</th>
		<th width="20%">工作站状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Work eq '0' }">
					<input type="hidden" name="net1Work" id="net1Work"
						value="${checkData.net1Work }" />${checkData.net1Work }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.net1Work eq 'OK'}">
							<input type="radio" name="net1Work" id="net1Work" value="OK"
								checked="checked" />OK
							<input type="radio" name="net1Work" id="net1Work" value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.net1Work eq 'Alarm'}">
							<input type="radio" name="net1Work" id="net1Work" value="OK" />OK
							<input type="radio" name="net1Work" id="net1Work" value="Alarm"
								checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="net1Work" id="net1Work" value="OK" />OK
							<input type="radio" name="net1Work" id="net1Work" value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">在线MAP图</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Map eq '0' }">
					<input type="hidden" name="net1Map" id="net1Map"
						value="${checkData.net1Map }" />${checkData.net1Map }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Map" id="net1Map"
						value="${checkData.net1Map }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">子网2</th>
		<th width="20%">工作站状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Work eq '0' }">
					<input type="hidden" name="net2Work" id="net2Work"
						value="${checkData.net2Work }" />${checkData.net2Work }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.net2Work eq 'OK'}">
							<input type="radio" name="net2Work" id="net2Work" value="OK"
								checked="checked" />OK
							<input type="radio" name="net2Work" id="net2Work" value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.net2Work eq 'Alarm'}">
							<input type="radio" name="net2Work" id="net2Work" value="OK" />OK
							<input type="radio" name="net2Work" id="net2Work" value="Alarm"
								checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="net2Work" id="net2Work" value="OK" />OK
							<input type="radio" name="net2Work" id="net2Work" value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">在线MAP图</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Map eq '0' }">
					<input type="hidden" name="net2Map" id="net2Map"
						value="${checkData.net2Map }" />${checkData.net2Map }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Map" id="net2Map"
						value="${checkData.net2Map }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">子网3</th>
		<th width="20%">工作站状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Work eq '0' }">
					<input type="hidden" name="net3Work" id="net3Work"
						value="${checkData.net3Work }" />${checkData.net3Work }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.net3Work eq 'OK'}">
							<input type="radio" name="net3Work" id="net3Work" value="OK"
								checked="checked" />OK
							<input type="radio" name="net3Work" id="net3Work" value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.net3Work eq 'Alarm'}">
							<input type="radio" name="net3Work" id="net3Work" value="OK" />OK
							<input type="radio" name="net3Work" id="net3Work" value="Alarm"
								checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="net3Work" id="net3Work" value="OK" />OK
							<input type="radio" name="net3Work" id="net3Work" value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">在线MAP图</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Map eq '0' }">
					<input type="hidden" name="net3Map" id="net3Map"
						value="${checkData.net3Map }" />${checkData.net3Map }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Map" id="net3Map"
						value="${checkData.net3Map }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">子网4</th>
		<th width="20%">工作站状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Work eq '0' }">
					<input type="hidden" name="net4Work" id="net4Work"
						value="${checkData.net4Work }" />${checkData.net4Work }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.net4Work eq 'OK'}">
							<input type="radio" name="net4Work" id="net4Work" value="OK"
								checked="checked" />OK
							<input type="radio" name="net4Work" id="net4Work" value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.net4Work eq 'Alarm'}">
							<input type="radio" name="net4Work" id="net4Work" value="OK" />OK
							<input type="radio" name="net4Work" id="net4Work" value="Alarm"
								checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="net4Work" id="net4Work" value="OK" />OK
							<input type="radio" name="net4Work" id="net4Work" value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">在线MAP图</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Map eq '0' }">
					<input type="hidden" name="net4Map" id="net4Map"
						value="${checkData.net4Map }" />${checkData.net4Map }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Map" id="net4Map"
						value="${checkData.net4Map }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">FR小网</th>
		<th width="20%">工作站状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrWork eq '0' }">
					<input type="hidden" name="netfrWork" id="netfrWork"
						value="${checkData.netfrWork }" />${checkData.netfrWork }
		</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${checkData.netfrWork eq 'OK'}">
							<input type="radio" name="netfrWork" id="netfrWork" value="OK"
								checked="checked" />OK
							<input type="radio" name="netfrWork" id="netfrWork" value="Alarm" />Alarm
						</c:when>
						<c:when test="${checkData.netfrWork eq 'Alarm'}">
							<input type="radio" name="netfrWork" id="netfrWork" value="OK" />OK
							<input type="radio" name="netfrWork" id="netfrWork" value="Alarm"
								checked="checked" />Alarm
						</c:when>
						<c:otherwise>
							<input type="radio" name="netfrWork" id="netfrWork" value="OK" />OK
							<input type="radio" name="netfrWork" id="netfrWork" value="Alarm" />Alarm
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">在线MAP图</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrMap eq '0' }">
					<input type="hidden" name="netfrMap" id="netfrMap"
						value="${checkData.netfrMap }" />${checkData.netfrMap }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrMap" id="netfrMap"
						value="${checkData.netfrMap }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<!--------------------------------------------- 子网1的0号节点    开始------------------------------->
	<tr>
		<th width="20%" rowspan="8">子网1的0号节点</th>
		<th width="20%" rowspan="2">收0号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Rx0 eq '0' }">
					<input type="hidden" name="net10Rx0" id="net10Rx0"
						value="${checkData.net10Rx0 }" />${checkData.net10Rx0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Rx0" id="net10Rx0"
						value="${checkData.net10Rx0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Eb0 eq '0' }">
					<input type="hidden" name="net10Eb0" id="net10Eb0"
						value="${checkData.net10Eb0 }" />${checkData.net10Eb0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Eb0" id="net10Eb0"
						value="${checkData.net10Eb0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">收1号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Rx1 eq '0' }">
					<input type="hidden" name="net10Rx1" id="net10Rx1"
						value="${checkData.net10Rx1 }" />${checkData.net10Rx1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Rx1" id="net10Rx1"
						value="${checkData.net10Rx1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Eb1 eq '0' }">
					<input type="hidden" name="net10Eb1" id="net10Eb1"
						value="${checkData.net10Eb1 }" />${checkData.net10Eb1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Eb1" id="net10Eb1"
						value="${checkData.net10Eb1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">收民航局130号节点</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Rx130 eq '0' }">
					<input type="hidden" name="net10Rx130" id="net10Rx130"
						value="${checkData.net10Rx130 }" />${checkData.net10Rx130 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Rx130" id="net10Rx130"
						value="${checkData.net10Rx130 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Eb130 eq '0' }">
					<input type="hidden" name="net10Eb130" id="net10Eb130"
						value="${checkData.net10Eb130 }" />${checkData.net10Eb130 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Eb130" id="net10Eb130"
						value="${checkData.net10Eb130 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">载波频谱(dBm)</th>
		<th width="20%">峰值</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Peak eq '0' }">
					<input type="hidden" name="net10Peak" id="net10Peak"
						value="${checkData.net10Peak }" />${checkData.net10Peak }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Peak" id="net10Peak"
						value="${checkData.net10Peak }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">底噪</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net10Noise eq '0' }">
					<input type="hidden" name="net10Noise" id="net10Noise"
						value="${checkData.net10Noise }" />${checkData.net10Noise }
		</c:when>
				<c:otherwise>
					<input type="text" name="net10Noise" id="net10Noise"
						value="${checkData.net10Noise }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="20%" rowspan="10">子网1时钟参考节点</th>
		<th width="20%" rowspan="5">主时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Znum eq '0' }">
					<input type="hidden" name="net1Znum" id="net1Znum"
						value="${checkData.net1Znum }" />${checkData.net1Znum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Znum" id="net1Znum"
						value="${checkData.net1Znum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Zweather eq '0' }">
					<input type="hidden" name="net1Zweather" id="net1Zweather"
						value="${checkData.net1Zweather }" />${checkData.net1Zweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Zweather" id="net1Zweather"
						value="${checkData.net1Zweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Zstate eq '0' }">
					<input type="hidden" name="net1Zstate" id="net1Zstate"
						value="${checkData.net1Zstate }" />${checkData.net1Zstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Zstate" id="net1Zstate"
						value="${checkData.net1Zstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Zrx eq '0' }">
					<input type="hidden" name="net1Zrx" id="net1Zrx"
						value="${checkData.net1Zrx }" />${checkData.net1Zrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Zrx" id="net1Zrx"
						value="${checkData.net1Zrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Zeb eq '0' }">
					<input type="hidden" name="net1Zeb" id="net1Zeb"
						value="${checkData.net1Zeb }" />${checkData.net1Zeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Zeb" id="net1Zeb"
						value="${checkData.net1Zeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="5">备时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Bnum eq '0' }">
					<input type="hidden" name="net1Bnum" id="net1Bnum"
						value="${checkData.net1Bnum }" />${checkData.net1Bnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Bnum" id="net1Bnum"
						value="${checkData.net1Bnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Bweather eq '0' }">
					<input type="hidden" name="net1Bweather" id="net1Bweather"
						value="${checkData.net1Bweather }" />${checkData.net1Bweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Bweather" id="net1Bweather"
						value="${checkData.net1Bweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Bstate eq '0' }">
					<input type="hidden" name="net1Bstate" id="net1Bstate"
						value="${checkData.net1Bstate }" />${checkData.net1Bstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Bstate" id="net1Bstate"
						value="${checkData.net1Bstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Brx eq '0'}">
					<input type="hidden" name="net1Brx" id="net1Brx"
						value="${checkData.net1Brx }" />${checkData.net1Brx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Brx" id="net1Brx"
						value="${checkData.net1Brx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net1Beb eq '0'}">
					<input type="hidden" name="net1Beb" id="net1Beb"
						value="${checkData.net1Beb }" />${checkData.net1Beb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net1Beb" id="net1Beb"
						value="${checkData.net1Beb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<!--------------------------------------------- 子网1的0号节点    结束------------------------------->

	<!--------------------------------------------- 子网2的0号节点    开始------------------------------->

	<tr>
		<th width="20%" rowspan="6">子网2的0号节点</th>
		<th width="20%" rowspan="2">收0号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Rx0 eq '0' }">
					<input type="hidden" name="net20Rx0" id="net20Rx0"
						value="${checkData.net20Rx0 }" />${checkData.net20Rx0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Rx0" id="net20Rx0"
						value="${checkData.net20Rx0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Eb0 eq '0' }">
					<input type="hidden" name="net20Eb0" id="net20Eb0"
						value="${checkData.net20Eb0 }" />${checkData.net20Eb0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Eb0" id="net20Eb0"
						value="${checkData.net20Eb0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">收1号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Rx1 eq '0' }">
					<input type="hidden" name="net20Rx1" id="net20Rx1"
						value="${checkData.net20Rx1 }" />${checkData.net20Rx1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Rx1" id="net20Rx1"
						value="${checkData.net20Rx1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Eb1 eq '0' }">
					<input type="hidden" name="net20Eb1" id="net20Eb1"
						value="${checkData.net20Eb1 }" />${checkData.net20Eb1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Eb1" id="net20Eb1"
						value="${checkData.net20Eb1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">载波频谱(dBm)</th>
		<th width="20%">峰值</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Peak eq '0' }">
					<input type="hidden" name="net20Peak" id="net20Peak"
						value="${checkData.net20Peak }" />${checkData.net20Peak }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Peak" id="net20Peak"
						value="${checkData.net20Peak }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">底噪</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net20Noise eq '0' }">
					<input type="hidden" name="net20Noise" id="net20Noise"
						value="${checkData.net20Noise }" />${checkData.net20Noise }
		</c:when>
				<c:otherwise>
					<input type="text" name="net20Noise" id="net20Noise"
						value="${checkData.net20Noise }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="20%" rowspan="10">子网2时钟参考节点</th>
		<th width="20%" rowspan="5">主时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Znum eq '0' }">
					<input type="hidden" name="net2Znum" id="net2Znum"
						value="${checkData.net2Znum }" />${checkData.net2Znum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Znum" id="net2Znum"
						value="${checkData.net2Znum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Zweather eq '0' }">
					<input type="hidden" name="net2Zweather" id="net2Zweather"
						value="${checkData.net2Zweather }" />${checkData.net2Zweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Zweather" id="net2Zweather"
						value="${checkData.net2Zweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Zstate eq '0' }">
					<input type="hidden" name="net2Zstate" id="net2Zstate"
						value="${checkData.net2Zstate }" />${checkData.net2Zstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Zstate" id="net2Zstate"
						value="${checkData.net2Zstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Zrx eq '0' }">
					<input type="hidden" name="net2Zrx" id="net2Zrx"
						value="${checkData.net2Zrx }" />${checkData.net2Zrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Zrx" id="net2Zrx"
						value="${checkData.net2Zrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Zeb eq '0' }">
					<input type="hidden" name="net2Zeb" id="net2Zeb"
						value="${checkData.net2Zeb }" />${checkData.net2Zeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Zeb" id="net2Zeb"
						value="${checkData.net2Zeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="5">备时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Bnum eq '0' }">
					<input type="hidden" name="net2Bnum" id="net2Bnum"
						value="${checkData.net2Bnum }" />${checkData.net2Bnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Bnum" id="net2Bnum"
						value="${checkData.net2Bnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Bweather eq '0' }">
					<input type="hidden" name="net2Bweather" id="net2Bweather"
						value="${checkData.net2Bweather }" />${checkData.net2Bweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Bweather" id="net2Bweather"
						value="${checkData.net2Bweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Bstate eq '0' }">
					<input type="hidden" name="net2Bstate" id="net2Bstate"
						value="${checkData.net2Bstate }" />${checkData.net2Bstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Bstate" id="net2Bstate"
						value="${checkData.net2Bstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Brx eq '0'}">
					<input type="hidden" name="net2Brx" id="net2Brx"
						value="${checkData.net2Brx }" />${checkData.net2Brx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Brx" id="net2Brx"
						value="${checkData.net2Brx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net2Beb eq '0'}">
					<input type="hidden" name="net2Beb" id="net2Beb"
						value="${checkData.net2Beb }" />${checkData.net2Beb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net2Beb" id="net2Beb"
						value="${checkData.net2Beb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<!----------------------------- 子网2的0号节点    结束------------------------------------>

	<!----------------------------- 子网3的0号节点    开始------------------------------------->
	<tr>
		<th width="20%" rowspan="6">子网3的0号节点</th>
		<th width="20%" rowspan="2">收0号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Rx0 eq '0' }">
					<input type="hidden" name="net30Rx0" id="net30Rx0"
						value="${checkData.net30Rx0 }" />${checkData.net30Rx0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Rx0" id="net30Rx0"
						value="${checkData.net30Rx0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Eb0 eq '0' }">
					<input type="hidden" name="net30Eb0" id="net30Eb0"
						value="${checkData.net30Eb0 }" />${checkData.net30Eb0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Eb0" id="net30Eb0"
						value="${checkData.net30Eb0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">收1号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Rx1 eq '0' }">
					<input type="hidden" name="net30Rx1" id="net30Rx1"
						value="${checkData.net30Rx1 }" />${checkData.net30Rx1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Rx1" id="net30Rx1"
						value="${checkData.net30Rx1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Eb1 eq '0' }">
					<input type="hidden" name="net30Eb1" id="net30Eb1"
						value="${checkData.net30Eb1 }" />${checkData.net30Eb1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Eb1" id="net30Eb1"
						value="${checkData.net30Eb1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">载波频谱(dBm)</th>
		<th width="20%">峰值</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Peak eq '0' }">
					<input type="hidden" name="net30Peak" id="net30Peak"
						value="${checkData.net30Peak }" />${checkData.net30Peak }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Peak" id="net30Peak"
						value="${checkData.net30Peak }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">底噪</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net30Noise eq '0' }">
					<input type="hidden" name="net30Noise" id="net30Noise"
						value="${checkData.net30Noise }" />${checkData.net30Noise }
		</c:when>
				<c:otherwise>
					<input type="text" name="net30Noise" id="net30Noise"
						value="${checkData.net30Noise }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="20%" rowspan="10">子网3时钟参考节点</th>
		<th width="20%" rowspan="5">主时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Znum eq '0' }">
					<input type="hidden" name="net3Znum" id="net3Znum"
						value="${checkData.net3Znum }" />${checkData.net3Znum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Znum" id="net3Znum"
						value="${checkData.net3Znum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Zweather eq '0' }">
					<input type="hidden" name="net3Zweather" id="net3Zweather"
						value="${checkData.net3Zweather }" />${checkData.net3Zweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Zweather" id="net3Zweather"
						value="${checkData.net3Zweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Zstate eq '0' }">
					<input type="hidden" name="net3Zstate" id="net3Zstate"
						value="${checkData.net3Zstate }" />${checkData.net3Zstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Zstate" id="net3Zstate"
						value="${checkData.net3Zstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Zrx eq '0' }">
					<input type="hidden" name="net3Zrx" id="net3Zrx"
						value="${checkData.net3Zrx }" />${checkData.net3Zrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Zrx" id="net3Zrx"
						value="${checkData.net3Zrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Zeb eq '0' }">
					<input type="hidden" name="net3Zeb" id="net3Zeb"
						value="${checkData.net3Zeb }" />${checkData.net3Zeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Zeb" id="net3Zeb"
						value="${checkData.net3Zeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="5">备时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Bnum eq '0' }">
					<input type="hidden" name="net3Bnum" id="net3Bnum"
						value="${checkData.net3Bnum }" />${checkData.net3Bnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Bnum" id="net3Bnum"
						value="${checkData.net3Bnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Bweather eq '0' }">
					<input type="hidden" name="net3Bweather" id="net3Bweather"
						value="${checkData.net3Bweather }" />${checkData.net3Bweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Bweather" id="net3Bweather"
						value="${checkData.net3Bweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Bstate eq '0' }">
					<input type="hidden" name="net3Bstate" id="net3Bstate"
						value="${checkData.net3Bstate }" />${checkData.net3Bstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Bstate" id="net3Bstate"
						value="${checkData.net3Bstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Brx eq '0'}">
					<input type="hidden" name="net3Brx" id="net3Brx"
						value="${checkData.net3Brx }" />${checkData.net3Brx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Brx" id="net3Brx"
						value="${checkData.net3Brx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net3Beb eq '0'}">
					<input type="hidden" name="net3Beb" id="net3Beb"
						value="${checkData.net3Beb }" />${checkData.net3Beb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net3Beb" id="net3Beb"
						value="${checkData.net3Beb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<!----------------------------- 子网3的0号节点    结束------------------------------------->

	<!----------------------------- 子网4的0号节点    开始------------------------------------->
	<tr>
		<th width="20%" rowspan="6">子网4的0号节点</th>
		<th width="20%" rowspan="2">收0号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Rx0 eq '0' }">
					<input type="hidden" name="net40Rx0" id="net40Rx0"
						value="${checkData.net40Rx0 }" />${checkData.net40Rx0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Rx0" id="net40Rx0"
						value="${checkData.net40Rx0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Eb0 eq '0' }">
					<input type="hidden" name="net40Eb0" id="net40Eb0"
						value="${checkData.net40Eb0 }" />${checkData.net40Eb0 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Eb0" id="net40Eb0"
						value="${checkData.net40Eb0 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">收1号节点(dB)</th>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Rx1 eq '0' }">
					<input type="hidden" name="net40Rx1" id="net40Rx1"
						value="${checkData.net40Rx1 }" />${checkData.net40Rx1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Rx1" id="net40Rx1"
						value="${checkData.net40Rx1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Eb1 eq '0' }">
					<input type="hidden" name="net40Eb1" id="net40Eb1"
						value="${checkData.net40Eb1 }" />${checkData.net40Eb1 }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Eb1" id="net40Eb1"
						value="${checkData.net40Eb1 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="2">载波频谱(dBm)</th>
		<th width="20%">峰值</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Peak eq '0' }">
					<input type="hidden" name="net40Peak" id="net40Peak"
						value="${checkData.net40Peak }" />${checkData.net40Peak }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Peak" id="net40Peak"
						value="${checkData.net40Peak }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">底噪</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net40Noise eq '0' }">
					<input type="hidden" name="net40Noise" id="net40Noise"
						value="${checkData.net40Noise }" />${checkData.net40Noise }
		</c:when>
				<c:otherwise>
					<input type="text" name="net40Noise" id="net40Noise"
						value="${checkData.net40Noise }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="20%" rowspan="10">子网4时钟参考节点</th>
		<th width="20%" rowspan="5">主时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Znum eq '0' }">
					<input type="hidden" name="net4Znum" id="net4Znum"
						value="${checkData.net4Znum }" />${checkData.net4Znum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Znum" id="net4Znum"
						value="${checkData.net4Znum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Zweather eq '0' }">
					<input type="hidden" name="net4Zweather" id="net4Zweather"
						value="${checkData.net4Zweather }" />${checkData.net4Zweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Zweather" id="net4Zweather"
						value="${checkData.net4Zweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Zstate eq '0' }">
					<input type="hidden" name="net4Zstate" id="net4Zstate"
						value="${checkData.net4Zstate }" />${checkData.net4Zstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Zstate" id="net4Zstate"
						value="${checkData.net4Zstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Zrx eq '0' }">
					<input type="hidden" name="net4Zrx" id="net4Zrx"
						value="${checkData.net4Zrx }" />${checkData.net4Zrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Zrx" id="net4Zrx"
						value="${checkData.net4Zrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Zeb eq '0' }">
					<input type="hidden" name="net4Zeb" id="net4Zeb"
						value="${checkData.net4Zeb }" />${checkData.net4Zeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Zeb" id="net4Zeb"
						value="${checkData.net4Zeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="5">备时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Bnum eq '0' }">
					<input type="hidden" name="net4Bnum" id="net4Bnum"
						value="${checkData.net4Bnum }" />${checkData.net4Bnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Bnum" id="net4Bnum"
						value="${checkData.net4Bnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Bweather eq '0' }">
					<input type="hidden" name="net4Bweather" id="net4Bweather"
						value="${checkData.net4Bweather }" />${checkData.net4Bweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Bweather" id="net4Bweather"
						value="${checkData.net4Bweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Bstate eq '0' }">
					<input type="hidden" name="net4Bstate" id="net4Bstate"
						value="${checkData.net4Bstate }" />${checkData.net4Bstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Bstate" id="net4Bstate"
						value="${checkData.net4Bstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Brx eq '0'}">
					<input type="hidden" name="net4Brx" id="net4Brx"
						value="${checkData.net4Brx }" />${checkData.net4Brx }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Brx" id="net4Brx"
						value="${checkData.net4Brx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.net4Beb eq '0'}">
					<input type="hidden" name="net4Beb" id="net4Beb"
						value="${checkData.net4Beb }" />${checkData.net4Beb }
		</c:when>
				<c:otherwise>
					<input type="text" name="net4Beb" id="net4Beb"
						value="${checkData.net4Beb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<!----------------------------- 子网4的0号节点    结束------------------------------------->

	<!----------------------------- FR小网的0号节点    开始------------------------------------->
	<tr>
		<th width="20%" rowspan="2" colspan="2">FR小网0号载波频谱</th>
		<th width="20%">峰值</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrPeak eq '0' }">
					<input type="hidden" name="netfrPeak" id="netfrPeak"
						value="${checkData.netfrPeak }" />${checkData.netfrPeak }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrPeak" id="netfrPeak"
						value="${checkData.netfrPeak }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">底噪</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrNoise eq '0' }">
					<input type="hidden" name="netfrNoise" id="netfrNoise"
						value="${checkData.netfrNoise	 }" />${checkData.netfrNoise }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrNoise" id="netfrNoise"
						value="${checkData.netfrNoise	 }" />
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="20%" rowspan="10">FR小网时钟参考节点</th>
		<th width="20%" rowspan="5">主时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrZnum eq '0' }">
					<input type="hidden" name="netfrZnum" id="netfrZnum"
						value="${checkData.netfrZnum }" />${checkData.netfrZnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrZnum" id="netfrZnum"
						value="${checkData.netfrZnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrZweather eq '0' }">
					<input type="hidden" name="netfrZweather" id="netfrZweather"
						value="${checkData.netfrZweather }" />${checkData.netfrZweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrZweather" id="netfrZweather"
						value="${checkData.netfrZweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrZstate eq '0' }">
					<input type="hidden" name="netfrZstate" id="netfrZstate"
						value="${checkData.netfrZstate }" />${checkData.netfrZstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrZstate" id="netfrZstate"
						value="${checkData.netfrZstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrZrx eq '0' }">
					<input type="hidden" name="netfrZrx" id="netfrZrx"
						value="${checkData.netfrZrx }" />${checkData.netfrZrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrZrx" id="netfrZrx"
						value="${checkData.netfrZrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrZeb eq '0' }">
					<input type="hidden" name="netfrZeb" id="netfrZeb"
						value="${checkData.netfrZeb }" />${checkData.netfrZeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrZeb" id="netfrZeb"
						value="${checkData.netfrZeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%" rowspan="5">备时钟</th>
		<th width="20%">节点号</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrBnum eq '0' }">
					<input type="hidden" name="netfrBnum" id="netfrBnum"
						value="${checkData.netfrBnum }" />${checkData.netfrBnum }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrBnum" id="netfrBnum"
						value="${checkData.netfrBnum }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">天气</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrBweather eq '0' }">
					<input type="hidden" name="netfrBweather" id="netfrBweather"
						value="${checkData.netfrBweather }" />${checkData.netfrBweather }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrBweather" id="netfrBweather"
						value="${checkData.netfrBweather }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">状态</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrBstate eq '0' }">
					<input type="hidden" name="netfrBstate" id="netfrBstate"
						value="${checkData.netfrBstate }" />${checkData.netfrBstate }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrBstate" id="netfrBstate"
						value="${checkData.netfrBstate }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">RX LvL</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrBrx eq '0'}">
					<input type="hidden" name="netfrBrx" id="netfrBrx"
						value="${checkData.netfrBrx }" />${checkData.netfrBrx }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrBrx" id="netfrBrx"
						value="${checkData.netfrBrx }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="20%">Eb/No</th>
		<th width="20%"><c:choose>
				<c:when test="${flag.netfrBeb eq '0'}">
					<input type="hidden" name="netfrBeb" id="netfrBeb"
						value="${checkData.netfrBeb }" />${checkData.netfrBeb }
		</c:when>
				<c:otherwise>
					<input type="text" name="netfrBeb" id="netfrBeb"
						value="${checkData.netfrBeb }" />
				</c:otherwise>
			</c:choose></th>
	</tr>
	<!-----------------------------  FR小网的0号节点    结束------------------------------------->
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
