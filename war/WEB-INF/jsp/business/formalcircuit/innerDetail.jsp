<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	.t_title{
		text-align: center;
	}
-->
</style>
<script type="text/javascript">
	$(function(){
		//正式电路ATM的业务类型枚举
		var AtmDatas = eval('${formalCircuitATMs}');
		$("select[name='ATMConfServiceType']").each(function(i){
			$(this).find("option").each(function(j){
				var $this = $(this);
				if($this.val() == AtmDatas[i].serviceType.name){
					$this.prop("selected",true);
				}
			});
		}); 
		//正式电路KU的通信方式枚举
		var KuDatas = eval('${formalCircuitKUs}');
		$("select[name='KUConfCommunicateWay']").each(function(i){
			$(this).find("option").each(function(j){
				var $this = $(this);
				if($this.val() == KuDatas[i].communicateWay.name){
					$this.prop("selected",true);
				}
			});
		}); 
		//正式电路TES的通信方式枚举
		var TesDatas = eval('${formalCircuitTESs}');
		$("select[name='TESConfCommunicateWay']").each(function(i){
			$(this).find("option").each(function(j){
				var $this = $(this);
				if($this.val() == TesDatas[i].communicateWay.name){
					$this.prop("selected",true);
				}
			});
		}); 
		//正式电路PES的通信方式枚举
		var PesDatas = eval('${formalCircuitPESs}');
		$("select[name='PESConfCommunicateWay']").each(function(i){
			$(this).find("option").each(function(j){
				var $this = $(this);
				if($this.val() == PesDatas[i].communicateWay.name){
					$this.prop("selected",true);
				}
			});
		}); 
	});
</script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>申请记录</dd>
	</dl>
</div>
<input type="hidden" id="applyOpttype" value="${m.formalCircuit.applyOpttype.value}"/>
<input type="hidden" id="applyType" value="${m.formalCircuit.applyBaseInfo.applyType.value}"/>
<table id="tb_desc" style="margin: 0px auto;">
	<c:if test="${not empty m.formalCircuit.applyBaseInfo.serialNumber}">
		<tr>
			<td width="100%" colspan="18" style="text-align: left;">
				<font style="font: bold;color: red;">${m.formalCircuit.applyBaseInfo.serialNumber}</font>
			</td>
		</tr>
	</c:if>
	<tr class="t_title">
		<td width="15%" colspan="3">申请单位：</td>
		<td width="30%" colspan="6">${m.formalCircuit.applyBaseInfo.applyCom}</td>
		<td width="15%" colspan="3">联系人：</td>
		<td width="40%" colspan="6">${m.formalCircuit.applyBaseInfo.applyLinkman}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">手机号码：</td>
		<td width="30%" colspan="6">${m.formalCircuit.applyBaseInfo.applyPhone}</td>
		<td width="15%" colspan="3">座机号码：</td>
		<td width="40%" colspan="6">${m.formalCircuit.applyBaseInfo.applyTelephone}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">传真：</td>
		<td width="30%" colspan="6">${m.formalCircuit.applyBaseInfo.applyFax}</td>
		<td width="15%" colspan="3">邮箱：</td>
		<td width="40%" colspan="6">${m.formalCircuit.applyBaseInfo.applyEmail}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">申请类型：</td>
		<td width="30%" colspan="6">${m.formalCircuit.applyOpttype.value}</td>
		<td width="15%" colspan="3">申请单位签字/盖章：</td>
		<td width="40%" colspan="6">${m.formalCircuit.applySign}</td>
	</tr>
	<tr class="t_title">
		<td width="15%" colspan="3">申请时间：</td>
		<td width="40%" colspan="6"><fmt:formatDate
				value="${m.formalCircuit.applyBaseInfo.applyTime.time}"
				type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td width="15%" colspan="3">电路类型：</td>
		<td width="30%" colspan="6">${m.formalCircuit.applyBaseInfo.applyType.value}</td>
	</tr>
	<c:choose>
		<c:when
			test="${not empty formalCircuitATMs && m.formalCircuit.applyBaseInfo.applyType.value =='ATM正式电路'}">
			<tr id="atm1" class="t_title">
				<td width="5%" rowspan="2">编号</td>
				<td width="7%" rowspan="2">业务名称</td>
				<td width="30%" colspan="5">本端参数</td>
				<td width="30%" colspan="5">对端参数</td>
				<td width="7%" rowspan="2">电路速率</td>
				<td width="7%" rowspan="2">服务类型</td>
				<td width="7%" rowspan="2" colspan="2">电路用途</td>
				<td width="7%" rowspan="2" colspan="2">开通时间</td>
			</tr>
			<tr id="atm2" class="t_title">
				<td width="5%">节点名称</td>
				<td width="5%">槽位号</td>
				<!-- <td width="5%">线路号</td> -->
				<td width="5%">端口号</td>
				<td width="5%">端口速率</td>
				<td width="5%">VPI.VCI或DLCI</td>
				<td width="5%">节点名称</td>
				<td width="5%">槽位号</td>
				<!-- <td width="5%">线路号</td> -->
				<td width="5%">端口号</td>
				<td width="5%">端口速率</td>
				<td width="5%">VPI.VCI或DLCI</td>
			</tr>
			<c:forEach items="${formalCircuitATMs}" var="formalCircuitATM">
				<tr class="t_title">
					<td width="5%">${formalCircuitATM.identifier}</td>
					<td width="7%">${formalCircuitATM.businessName}</td>
 					<c:choose>
						<c:when test="${(m.formalCircuit.approveStat eq 'engineer_config' or m.formalCircuit.approveStat eq 'engineer_transfer') and isVisable}">
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfTxNodeName" value="${formalCircuitATM.txNodeName}"/></td>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfTxSlodNum" value="${formalCircuitATM.txSlot}"/></td>
							<%-- <td width="5%"><input type="text" style="width: 50px" name="ATMConfTxLine" value="${formalCircuitATM.txLine}"/></td> --%>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfTxPort" value="${formalCircuitATM.txPort}"/></td>
							<td width="5%">${formalCircuitATM.txPortSpeed}</td>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfTxVpiDlci" value="${formalCircuitATM.txVpiDlci}"/></td>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfRxNodeName" value="${formalCircuitATM.rxNodeName}"/></td>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfRxSlodNum" value="${formalCircuitATM.rxSlot}"/></td>
							<%-- <td width="5%"><input type="text" style="width: 50px" name="ATMConfRxLine" value="${formalCircuitATM.rxLine}"/></td> --%>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfRxPort" value="${formalCircuitATM.rxPort}"/></td>
							<td width="5%">${formalCircuitATM.rxPortSpeed}</td>
							<td width="5%"><input type="text" style="width: 50px" name="ATMConfRxVpiDlci" value="${formalCircuitATM.rxVpiDlci}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="ATMConfSpeed" value="${formalCircuitATM.circuitSpeed}"/></td>
							<td width="7%"><select name='ATMConfServiceType'
								class='easyui-validatebox' style='width: 60px'>
									<option value='NRTVBR'>NRT-VBR</option>
									<option value='RTVBR'>RT-VBR</option>
									<option value='UBR'>UBR</option>
									<option value='CBR'>CBR</option>
									<option value='ABR'>ABR</option>
									<option value='OTHERS'>其他</option>
							</select></td>
							<td width="7%" colspan="2"><input type="text" style="width: 50px" name="ATMConfUsage" value="${formalCircuitATM.usage}"/></td>
						</c:when>
						<c:otherwise>
							<td width="5%">${formalCircuitATM.txNodeName}</td>
							<td width="5%">${formalCircuitATM.txSlot}</td>
							<%-- <td width="5%">${formalCircuitATM.txLine}</td> --%>
							<td width="5%">${formalCircuitATM.txPort}</td>
							<td width="5%">${formalCircuitATM.txPortSpeed}</td>
							<td width="5%">${formalCircuitATM.txVpiDlci}</td>
							<td width="5%">${formalCircuitATM.rxNodeName}</td>
							<td width="5%">${formalCircuitATM.rxSlot}</td>
							<%-- <td width="5%">${formalCircuitATM.rxLine}</td> --%>
							<td width="5%">${formalCircuitATM.rxPort}</td>
							<td width="5%">${formalCircuitATM.rxPortSpeed}</td>
							<td width="5%">${formalCircuitATM.rxVpiDlci}</td>
							<td width="7%">${formalCircuitATM.circuitSpeed}</td>
							<td width="7%">${formalCircuitATM.serviceType.value}</td>
							<td width="7%" colspan="2">${formalCircuitATM.usage}</td>
						</c:otherwise>
					</c:choose> 
					<td width="7%" colspan="2"><fmt:formatDate
							value="${formalCircuitATM.openTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when
			test="${not empty formalCircuitKUs && m.formalCircuit.applyBaseInfo.applyType.value =='KU正式电路'}">
			<tr id="ku1" class="t_title">
				<td width="5%" rowspan="2">编号</td>
				<td width="7%" rowspan="2" colspan="2">业务名称</td>
				<td width="28%" colspan="4">本端参数</td>
				<td width="28%" colspan="4">对端参数</td>
				<td width="7%" rowspan="2">电路速率</td>
				<td width="7%" rowspan="2" colspan="2">通信方式</td>
				<td width="8%" rowspan="2" colspan="2">电路用途</td>
				<td width="10%" rowspan="2" colspan="2">开通时间</td>
			</tr>
			<tr id="ku2" class="t_title">
				<td width="7%">站点名称</td>
				<td width="7%">节点号</td>
				<td width="7%">槽位号</td>
				<td width="7%">端口号</td>
				<td width="7%">站点名称</td>
				<td width="7%">节点号</td>
				<td width="7%">槽位号</td>
				<td width="7%">端口号</td>
			</tr>
			<c:forEach items="${formalCircuitKUs}" var="formalCircuitKU">
				<tr class="t_title">
					<td width="5%">${formalCircuitKU.identifier}</td>
					<td width="7%" colspan="2">${formalCircuitKU.businessName}</td>
					<c:choose>
						<c:when test="${(m.formalCircuit.approveStat eq 'engineer_config' or m.formalCircuit.approveStat eq 'engineer_transfer') and isVisable}">
							<td width="7%"><input type="text" style="width: 50px" name="KUConfTxSiteName" value="${formalCircuitKU.txSiteName}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfTxNode" value="${formalCircuitKU.txNodeNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfTxSlot" value="${formalCircuitKU.txSlotNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfTxPlot" value="${formalCircuitKU.txPortNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfRxSiteName" value="${formalCircuitKU.rxSiteName}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfRxNode" value="${formalCircuitKU.rxNodeNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfRxSlot" value="${formalCircuitKU.rxSlotNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfRxPlot" value="${formalCircuitKU.rxPortNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="KUConfSpeed" value="${formalCircuitKU.circuitSpeed}"/></td>
							<td width="7%" colspan="2"><select name='KUConfCommunicateWay'
								class='easyui-validatebox' style='width: 60px'>
									<option value='bothway'>双向</option>
									<option value='broadcast'>广播</option>
							</select></td>
							<td width="8%" colspan="2"><input type="text" style="width: 50px" name="KUConfUsage" value="${formalCircuitKU.usage}"/></td>
						</c:when>
						<c:otherwise>
							<td width="7%">${formalCircuitKU.txSiteName}</td>
							<td width="7%">${formalCircuitKU.txNodeNum}</td>
							<td width="7%">${formalCircuitKU.txSlotNum}</td>
							<td width="7%">${formalCircuitKU.txPortNum}</td>
							<td width="7%">${formalCircuitKU.rxSiteName}</td>
							<td width="7%">${formalCircuitKU.rxNodeNum}</td>
							<td width="7%">${formalCircuitKU.rxSlotNum}</td>
							<td width="7%">${formalCircuitKU.rxPortNum}</td>
							<td width="7%">${formalCircuitKU.circuitSpeed}</td>
							<td width="7%" colspan="2">${formalCircuitKU.communicateWay.value}</td>
							<td width="10%" colspan="2">${formalCircuitKU.usage}</td>
						</c:otherwise>
					</c:choose>
					<td width="10%" colspan="2"><fmt:formatDate
							value="${formalCircuitKU.openTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when
			test="${not empty formalCircuitTESs && m.formalCircuit.applyBaseInfo.applyType.value =='TES正式电路'}">
			<tr id="tes1" class="t_title">
				<td width="5%" rowspan="2">编号</td>
				<td width="7%" rowspan="2" colspan="2">业务名称</td>
				<td width="24%" colspan="3">本端参数</td>
				<td width="24%" colspan="3">对端参数</td>
				<td width="7%" rowspan="2">电路速率</td>
				<td width="7%" rowspan="2" colspan="2">通信方式</td>
				<td width="10%" rowspan="2" colspan="3">电路用途</td>
				<td width="16%" rowspan="2" colspan="3">开通时间</td>
			</tr>
			<tr id="tes2" class="t_title">
				<td width="8%">站点名</td>
				<td width="8%">机箱号</td>
				<td width="8%">槽位号</td>
				<td width="8%">站点名</td>
				<td width="8%">机箱号</td>
				<td width="8%">槽位号</td>
			</tr>
			<c:forEach items="${formalCircuitTESs}" var="formalCircuitTES">
				<tr class="t_title">
					<td width="5%">${formalCircuitTES.identifier}</td>
					<td width="7%" colspan="2">${formalCircuitTES.businessName}</td>
					<c:choose>
						<c:when test="${(m.formalCircuit.approveStat eq 'engineer_config' or m.formalCircuit.approveStat eq 'engineer_transfer') and isVisable}">
							<td width="8%"><input type="text" style="width: 50px" name="TESConfTxSiteName" value="${formalCircuitTES.txSiteName}"/></td>
							<td width="8%"><input type="text" style="width: 50px" name="TESConfTxCaseNum" value="${formalCircuitTES.txCaseNum}"/></td>
							<td width="8%"><input type="text" style="width: 50px" name="TESConfTxSlotNum" value="${formalCircuitTES.txSlotNum}"/></td>
							<td width="8%"><input type="text" style="width: 50px" name="TESConfRxSiteName" value="${formalCircuitTES.rxSiteName}"/></td>
							<td width="8%"><input type="text" style="width: 50px" name="TESConfRxCaseNum" value="${formalCircuitTES.rxCaseNum}"/></td>
							<td width="8%"><input type="text" style="width: 50px" name="TESConfRxSlotNum" value="${formalCircuitTES.rxSlotNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="TESConfSpeed" value="${formalCircuitTES.circuitSpeed}"/></td>
							<td width="7%" colspan="2"><select name='TESConfCommunicateWay' style='width: 60px'>
									<option value='synchronization'>同步</option>
									<option value='asynchronous'>异步</option>
									<option value='bothway'>双向</option>
									<option value='broadcast'>广播</option>
							</select></td>
							<td width="10%" colspan="3"><input type="text" style="width: 80px" name="TESConfUsage" value="${formalCircuitTES.usage}"/></td>
						</c:when>
						<c:otherwise>
							<td width="8%">${formalCircuitTES.txSiteName}</td>
							<td width="8%">${formalCircuitTES.txCaseNum}</td>
							<td width="8%">${formalCircuitTES.txSlotNum}</td>
							<td width="8%">${formalCircuitTES.rxSiteName}</td>
							<td width="8%">${formalCircuitTES.rxCaseNum}</td>
							<td width="8%">${formalCircuitTES.rxSlotNum}</td>
							<td width="7%">${formalCircuitTES.circuitSpeed}</td>
							<td width="7%" colspan="2">${formalCircuitTES.communicateWay.value}</td>
							<td width="10%" colspan="3">${formalCircuitTES.usage}</td>
						</c:otherwise>
					</c:choose>
					<td colspan="3"><fmt:formatDate
							value="${formalCircuitTES.openTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when
			test="${not empty formalCircuitPESs && m.formalCircuit.applyBaseInfo.applyType.value =='PES正式电路'}">
			<tr id="pes1" class="t_title">
				<td width="5%" rowspan="2">编号</td>
				<td width="7%" rowspan="2" colspan="2">业务名称</td>
				<td width="28%" colspan="4">本端参数</td>
				<td width="28%" colspan="4">对端参数</td>
				<td width="7%" rowspan="2">电路速率</td>
				<td width="7%" rowspan="2" colspan="2">通信方式</td>
				<td width="8%" rowspan="2" colspan="2">电路用途</td>
				<td width="10%" rowspan="2" colspan="2">开通时间</td>
			</tr>
			<tr id="pes2" class="t_title">
				<td width="7%">站点名</td>
				<td width="7%">机箱号</td>
				<td width="7%">槽位号</td>
				<td width="7%">端口号</td>
				<td width="7%">站点名</td>
				<td width="7%">机箱号</td>
				<td width="7%">槽位号</td>
				<td width="7%">端口号</td>
			</tr>
			<c:forEach items="${formalCircuitPESs}" var="formalCircuitPES">
				<tr class="t_title">
					<td width="5%">${formalCircuitPES.identifier}</td>
					<td width="7%" colspan="2">${formalCircuitPES.businessName}</td>
					<c:choose>
						<c:when test="${(m.formalCircuit.approveStat eq 'engineer_config' or m.formalCircuit.approveStat eq 'engineer_transfer') and isVisable}">
							<td width="7%"><input type="text" style="width: 50px" name="PESConfTxSiteName" value="${formalCircuitPES.txSiteName}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfTxCaseNum" value="${formalCircuitPES.txCaseNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfTxSlotNum" value="${formalCircuitPES.txSlotNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfTxPortNum" value="${formalCircuitPES.txPortNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfRxSiteName" value="${formalCircuitPES.rxSiteName}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfRxCaseNum" value="${formalCircuitPES.rxCaseNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfRxSlotNum" value="${formalCircuitPES.rxSlotNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfRxPortNum" value="${formalCircuitPES.rxPortNum}"/></td>
							<td width="7%"><input type="text" style="width: 50px" name="PESConfSpeed" value="${formalCircuitPES.circuitSpeed}"/></td>
							<td width="7%" colspan="2"><select name='PESConfCommunicateWay' id='PESConfCommunicateWay' style='width: 60px'>
									<option value='synchronization'>同步</option>
									<option value='asynchronous'>异步</option>
									<option value='bothway'>双向</option>
									<option value='broadcast'>广播</option>
							</select></td>
							<td width="8%" colspan="2"><input type="text" style="width: 80px" name="PESConfUsage" value="${formalCircuitPES.usage}"/></td>
						</c:when>
						<c:otherwise>
							<td width="7%">${formalCircuitPES.txSiteName}</td>
							<td width="7%">${formalCircuitPES.txCaseNum}</td>
							<td width="7%">${formalCircuitPES.txSlotNum}</td>
							<td width="7%">${formalCircuitPES.txPortNum}</td>
							<td width="7%">${formalCircuitPES.rxSiteName}</td>
							<td width="7%">${formalCircuitPES.rxCaseNum}</td>
							<td width="7%">${formalCircuitPES.rxSlotNum}</td>
							<td width="7%">${formalCircuitPES.rxPortNum}</td>
							<td width="7%">${formalCircuitPES.circuitSpeed}</td>
							<td width="7%" colspan="2">${formalCircuitPES.communicateWay.value}</td>
							<td width="8%" colspan="2">${formalCircuitPES.usage}</td>
						</c:otherwise>
					</c:choose>
					<td colspan="3"><fmt:formatDate
							value="${formalCircuitPES.openTime.time}" type="date"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	<tr>
		<td width="15%" colspan="2">申请备注：</td>
		<td width="85%" colspan="16">${m.formalCircuit.applyRemark}</td>
	</tr>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>附件信息</dd>
	</dl>
</div>
<c:choose>
			<c:when test="${not empty attaches}">
				<table width="100%" style="margin: 0px auto">
					<c:forEach var="type" items="${formalCircuitAttachTypeEnum}">
						<tr>
							<td align="right"  width="50%" class="t_key">${type.value}</td>	
							<td>
								<c:forEach var="attach" items="${attaches}">
									<c:if test="${type eq attach.attachType}">
										<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_download']}">
											<a href='${rootUrl}formalcircuit/download.do?id=${attach.id}' title='点击下载文件'><span style="color: blue">${attach.attachName}</span></a>
										</sec:authorize>
									</c:if>
								</c:forEach>
							</td>					
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有任何附件！</div>
			</c:otherwise>
</c:choose>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>配置详情</dd>
	</dl>
</div>
<c:if test="${not empty formalCircuitConfig && not empty formalCircuitConfig.operateUser}">
<table width="100%" style="margin: 0px auto">
	<tbody>
<tr class="t_title">
	<th width="100%" style="text-align: left;">
	<span style="font-weight:bolder;font-size: 13px">&nbsp;配置时间:</span>
	<fmt:formatDate value="${formalCircuitConfig.configTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /> 
	<span style="font-weight:bolder;font-size: 13px">&nbsp;配置人:</span>${formalCircuitConfig.operateUser}
	<span style="font-weight:bolder;font-size: 13px">&nbsp;联系方式:</span>010-58729911/12/14/15
	</th>
</tr></tbody></table>
</c:if>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty formalCircuitATMs && not empty formalCircuitATMs[0].confTxNodeName}">
				<tr id="atm1" class="t_title">
					<td width="5%" rowspan="2">序号</td>
					<td width="30%" colspan="5">本端参数</td>
					<td width="30%" colspan="5">对端参数</td>
					<td width="8%" rowspan="2" colspan="2">用途</td>
					<!-- <td width="7%" rowspan="2">服务类型</td> -->
					<td width="8%" rowspan="2">速率（K）</td>
					<td width="8%" rowspan="2" colspan="2">电路编号</td>
				</tr>
				<tr id="atm2" class="t_title">
					<td width="5%">节点名称</td>
					<td width="5%">槽位号</td>
					<!-- <td width="5%">线路号</td> -->
					<td width="5%">端口号</td>
					<td width="5%">信令类型</td>
					<td width="5%">VPI.VCI或DLCI</td>
					<td width="5%">节点名称</td>
					<td width="5%">槽位号</td>
					<!-- <td width="5%">线路号</td> -->
					<td width="5%">端口号</td>
					<td width="5%">信令类型</td>
					<td width="5%">VPI.VCI或DLCI</td>
				</tr>
				<c:forEach items="${formalCircuitATMs}" var="formalCircuitATM">
					<tr class="t_title">
						<td width="5%">${formalCircuitATM.identifier}</td>
						<td width="5%">${formalCircuitATM.confTxNodeName}</td>
						<td width="5%">${formalCircuitATM.confTxSlodNum}</td>
						<%-- <td width="5%">${formalCircuitATM.confTxLine}</td> --%>
						<td width="5%">${formalCircuitATM.confTxPort}</td>
						<td width="5%">${formalCircuitATM.confTxSignal.value}</td>
						<td width="5%">${formalCircuitATM.confTxVpiDlci}</td>
						<td width="5%">${formalCircuitATM.confRxNodeName}</td>
						<td width="5%">${formalCircuitATM.confRxSlodNum}</td>
						<%-- <td width="5%">${formalCircuitATM.confRxLine}</td> --%>
						<td width="5%">${formalCircuitATM.confRxPort}</td>
						<td width="5%">${formalCircuitATM.confRxSignal.value}</td>
						<td width="5%">${formalCircuitATM.confRxVpiDlci}</td>
						<td width="8%" colspan="2">${formalCircuitATM.usage}</td>
						<%-- <td width="7%">${formalCircuitATM.serviceType}</td> --%>
						<td width="8%">${formalCircuitATM.confSpeed}</td>
						<td width="8%" colspan="2">${formalCircuitATM.confNo}</td>
					</tr>
				</c:forEach>
				<tr class="t_title">
					<td width="5%">备注</td>
					<td width="95%" colspan="15">${formalCircuitATMs[0].formalCircuit.formalCircuitConfig.remark}</td>
				</tr>
			</c:when>
			<c:when test="${not empty formalCircuitKUs && not empty formalCircuitKUs[0].confTxSiteName}">
				<tr id="ku1" class="t_title">
					<td width="5%" rowspan="2">序号</td>
					<td width="30%" colspan="6">本端参数</td>
					<td width="30%" colspan="6">对端参数</td>
					<td width="7%" rowspan="2">电路名称</td>
					<td width="7%" rowspan="2">速率(Kb/s)</td>
					<td width="7%" rowspan="2">通信方式</td>
					<td width="7%" rowspan="2">电路用途</td>
					<td width="7%" rowspan="2">电路编号</td>
				</tr>
				<tr id="ku2" class="t_title">
					<td width="5%">站点名称</td>
					<td width="5%">节点号</td>
					<td width="5%">卡类型</td>
					<td width="5%">槽位号</td>
					<td width="5%">端口号</td>
					<td width="5%">接口类型</td>
					<td width="5%">站点名称</td>
					<td width="5%">节点号</td>
					<td width="5%">卡类型</td>
					<td width="5%">槽位号</td>
					<td width="5%">端口号</td>
					<td width="5%">接口类型</td>
				</tr>
				<c:forEach items="${formalCircuitKUs}" var="formalCircuitKU">
					<tr class="t_title">
						<td width="5%">${formalCircuitKU.identifier}</td>
						<td width="5%">${formalCircuitKU.confTxSiteName}</td>
						<td width="5%">${formalCircuitKU.confTxNode}</td>
						<td width="5%">${formalCircuitKU.confTxCard.value}</td>
						<td width="5%">${formalCircuitKU.confTxSlot}</td>
						<td width="5%">${formalCircuitKU.confTxPlot}</td>
						<td width="5%">${formalCircuitKU.confTxInterface}</td>
						<td width="5%">${formalCircuitKU.confRxSiteName}</td>
						<td width="5%">${formalCircuitKU.confRxNode}</td>
						<td width="5%">${formalCircuitKU.confRxCard.value}</td>
						<td width="5%">${formalCircuitKU.confRxSlot}</td>
						<td width="5%">${formalCircuitKU.confRxPlot}</td>
						<td width="5%">${formalCircuitKU.confRxInterface}</td>
						<td width="7%">${formalCircuitKU.confCircuitName}</td>
						<td width="7%">${formalCircuitKU.confSpeed}</td>
						<td width="7%">${formalCircuitKU.confCommunicateWay.value}</td>
						<td width="7%">${formalCircuitKU.confUsage}</td>
						<td width="7%">${formalCircuitKU.confNo}</td>
					</tr>
				</c:forEach>
				<tr class="t_title">
					<td width="5%">备注</td>
					<td width="95%" colspan="17">${formalCircuitKUs[0].formalCircuit.formalCircuitConfig.remark}</td>
				</tr>
			</c:when>
			<c:when test="${not empty formalCircuitTESs && not empty formalCircuitTESs[0].confTxSiteName}">
				<tr id="tes1" class="t_title">
					<td width="4%" rowspan="2">序号</td>
					<td width="24%" colspan="4">本端参数</td>
					<td width="24%" colspan="4">对端参数</td>
					<td width="8%" rowspan="2">电路名称</td>
					<td width="8%" rowspan="2">速率(Kb/s)</td>
					<td width="8%" rowspan="2">通信方式</td>
					<td width="8%" rowspan="2">时钟方式</td>
					<td width="8%" rowspan="2">电路编号</td>
					<td width="8%" rowspan="2">电路用途</td>
				</tr>
				<tr id="tes2" class="t_title">
					<td width="6%">站点名称</td>
					<td width="6%">机箱号</td>
					<td width="6%">槽位号</td>
					<td width="6%">接口类型</td>
					<td width="6%">站点名</td>
					<td width="6%">机箱号</td>
					<td width="6%">槽位号</td>
					<td width="6%">接口类型</td>
				</tr>
				<c:forEach items="${formalCircuitTESs}" var="formalCircuitTES">
					<tr class="t_title">
						<td width="4%">${formalCircuitTES.identifier}</td>
						<td width="6%">${formalCircuitTES.confTxSiteName}</td>
						<td width="6%">${formalCircuitTES.confTxCaseNum}</td>
						<td width="6%">${formalCircuitTES.confTxSlotNum}</td>
						<td width="6%">${formalCircuitTES.confTxInterface}</td>
						<td width="6%">${formalCircuitTES.confRxSiteName}</td>
						<td width="6%">${formalCircuitTES.confRxCaseNum}</td>
						<td width="6%">${formalCircuitTES.confRxSlotNum}</td>
						<td width="6%">${formalCircuitTES.confRxInterface}</td>
						<td width="8%">${formalCircuitTES.confCircuitName}</td>
						<td width="8%">${formalCircuitTES.confSpeed}</td>
						<td width="8%">${formalCircuitTES.confCommunicateWay.value}</td>
						<td width="8%">${formalCircuitTES.confClock}</td>
						<td width="8%">${formalCircuitTES.confNo}</td>
						<td width="8%" colspan="2">${formalCircuitTES.confUsage}</td>
					</tr>
				</c:forEach>
				<tr class="t_title">
					<td width="4%">备注</td>
					<td width="96%" colspan="14">${formalCircuitTESs[0].formalCircuit.formalCircuitConfig.remark}</td>
				</tr>
			</c:when>
			<c:when test="${not empty formalCircuitPESs && not empty formalCircuitPESs[0].confTxSiteName}">
				<tr id="pes1" class="t_title">
					<td width="4%" rowspan="2">序号</td>
					<td width="30%" colspan="5">本端参数</td>
					<td width="30%" colspan="5">对端参数</td>
					<td width="6%" rowspan="2">电路名称</td>
					<td width="6%" rowspan="2">速率(Kb/s)</td>
					<td width="6%" rowspan="2">通信方式</td>
					<td width="6%" rowspan="2">电路编号</td>
					<td width="6%" rowspan="2">电路用途</td>
				</tr>
				<tr id="pes2" class="t_title">
					<td width="6%">站点名称</td>
					<td width="6%">机箱号</td>
					<td width="6%">槽位号</td>
					<td width="6%">端口号</td>
					<td width="6%">接口类型</td>
					<td width="6%">站点名</td>
					<td width="6%">机箱号</td>
					<td width="6%">槽位号</td>
					<td width="6%">端口号</td>
					<td width="6%">接口类型</td>
				</tr>
				<c:forEach items="${formalCircuitPESs}" var="formalCircuitPES">
					<tr class="t_title">
						<td width="4%">${formalCircuitPES.identifier}</td>
						<td width="6%">${formalCircuitPES.confTxSiteName}</td>
						<td width="6%">${formalCircuitPES.confTxCaseNum}</td>
						<td width="6%">${formalCircuitPES.confTxSlotNum}</td>
						<td width="6%">${formalCircuitPES.confTxPortNum}</td>
						<td width="6%">${formalCircuitPES.confTxInterface}</td>
						<td width="6%">${formalCircuitPES.confRxSiteName}</td>
						<td width="6%">${formalCircuitPES.confRxCaseNum}</td>
						<td width="6%">${formalCircuitPES.confRxSlotNum}</td>
						<td width="6%">${formalCircuitPES.confRxPortNum}</td>
						<td width="6%">${formalCircuitPES.confRxInterface}</td>
						<td width="8%">${formalCircuitPES.confCircuitName}</td>
						<td width="8%">${formalCircuitPES.confSpeed}</td>
						<td width="8%">${formalCircuitPES.confCommunicateWay.value}</td>
						<td width="8%">${formalCircuitPES.confNo}</td>
						<td width="8%" colspan="2">${formalCircuitPES.confUsage}</td>
					</tr>
				</c:forEach>
				<tr class="t_title">
					<td width="4%">备注</td>
					<td width="96%" colspan="15">${formalCircuitPESs[0].formalCircuit.formalCircuitConfig.remark}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有配置信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>审批过程</dd>
	</dl>
</div>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty approveInfos}">
				<c:forEach items="${approveInfos}" var="vo" varStatus="voStatus">
					<tr>
						<th width="100%" style="text-align: left;">
							<fmt:formatDate value="${vo.approveTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /> 
							<span style="font-weight:bolder;font-size: 13px">&nbsp;单位:</span>${vo.company==null?'无':vo.company }<span style="font-weight:bolder;font-size: 13px">&nbsp;操作人:</span>${vo.username }
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作类别:</span>
							<span style="color:black">${vo.approveStatus.value}</span>
							<span style="font-weight:bolder;font-size: 13px">&nbsp;操作结果:</span>
							<c:choose>
								<c:when test="${vo.approveType.name() == 'reject' }">
									<span style="font-weight:bolder;color:red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'disconsent' }">
									<span style="font-weight:bolder;color:red">${vo.approveType.value}</span>
								</c:when>
								<c:when test="${vo.approveType.name() == 'consent' }">
									<span style="font-weight:bolder;color:#00db00">${vo.approveType.value}</span>
								</c:when>
								<c:otherwise>
									${vo.approveType.value}
								</c:otherwise>
							</c:choose>	
							<c:if test="${not empty vo.reportAddress}">
								<span style="font-weight:bolder;font-size: 13px">&nbsp;退回信息:</span>
								<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_downloadreturned']}">
									<a href='${rootUrl}formalcircuit/downloadReturnedReport.do?reportAddress=${vo.reportAddress}&outlineAddress=${vo.outlineAddress}' title='点击下载文件'><span style="color: blue">附件</span></a>
								</sec:authorize>
							</c:if>
							</br>
							<c:if test="${not empty vo.applyBaseInfo.candidate and vo.approveStatus eq 'csstaff_deal'}">
							      <span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分配协助配置地区:</span>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZWWW')}">新疆</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZLXY')}">西北</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZUUU')}">西南</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZBAA')}">华北</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZSSS')}">华东</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZGGG')}">中南</c:if>
							<c:if test="${fn:contains(vo.applyBaseInfo.candidate, 'ZYTX')}">东北</c:if>
							</c:if>
							<c:if test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_seconddeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType eq 'transfer'))}">
							      <span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配置人员:</span>
							${vo.nextUserName}
							<span style="font-weight:bolder;font-size: 13px">&nbsp;配置人员联系方式:</span>
							${vo.nextUserTel}
							</c:if>
							<c:if test="${not empty vo.nextUserName and (vo.approveStatus eq 'atncleader_firstdeal' or
							      (vo.approveStatus eq 'engineer_config' and vo.approveType ne 'transfer') or  vo.approveStatus eq 'engineer_transfer')}">
							<span style="font-weight:bolder;font-size: 13px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核人员:</span>
							${vo.nextUserName}
							<span style="font-weight:bolder;font-size: 13px">&nbsp;审核人员联系方式:</span>
							${vo.nextUserTel}
							</c:if>
						</th>
					</tr>
					<tr>
						<td width="100%">
							<div style="height: auto; text-align: left; word-break: break-all; text-indent: 2em">${vo.approveRemark}</div>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th width="100%" style="text-align: center;">还没有审批信息！</th>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>评价详情</dd>
	</dl>
</div>
<table width="100%" style="margin: 0px auto">
	<tbody>
		<c:choose>
			<c:when test="${not empty evaluateInfo}">
				<tr>
					<td width="20%" align="right"><span style="font-size: 13px">服务评价<span style="color: red">*</span>：</span></td>
					<td width="80%">
						<input class="easyui-validatebox" type="radio" name="grade" checked="checked"/>${evaluateInfo.grade.value}
					</td>
				</tr>
				<tr>
					<td width="20%" align="right"><span style="font-size: 13px;">备注<span style="color: red">*</span>：</span></td>
					<td width="80%">
					<textarea id="evaluateRemark" name="evaluateRemark"  readonly="readonly" 
							rows="6" cols="60" class="easyui-validatebox" style="width:520px;resize:none;">${evaluateInfo.remark}</textarea>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<div class="message" style="text-align: center">还没有评价信息！</div>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
