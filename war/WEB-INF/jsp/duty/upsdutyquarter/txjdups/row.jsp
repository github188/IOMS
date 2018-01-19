<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
<!--
	font {
		color: red;
		font-weight: bold;
	}
-->
</style>
<tr>
	<c:forEach items="${vo.upsContentCheck }" var="ucc">
		<td>
			<fmt:formatDate value="${vo.checkTime}" type="both" 
							pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
		<td>${vo.name }</td>
		<td>
			<c:choose>
				<c:when test="${ucc.atIsAdjustable eq 'INNORMAL'}">
					<font>${ucc.atIsAdjustable.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.atIsAdjustable.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.temperature }</td>
		<td>${ucc.humidity }</td>
		<td>
			<c:choose>
				<c:when test="${ucc.eaIsIntact eq 'INNORMAL'}">
					<font>${ucc.eaIsIntact.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.eaIsIntact.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.radiateIsNormal eq 'INNORMAL'}">
					<font>${ucc.radiateIsNormal.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.radiateIsNormal.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.esGroundVoltage eq 'INNORMAL'}">
					<font>${ucc.esGroundVoltage.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.esGroundVoltage.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.upsRvIsNormal eq 'INNORMAL'}">
					<font>${ucc.upsRvIsNormal.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.upsRvIsNormal.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.upsUidisIsNormal eq 'INNORMAL'}">
					<font>${ucc.upsUidisIsNormal.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.upsUidisIsNormal.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.raIsFlow eq 'INNORMAL'}">
					<font>${ucc.raIsFlow.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.raIsFlow.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.batLeakage eq 'INNORMAL'}">
					<font>${ucc.batLeakage.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.batLeakage.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.upsOutletIsClean eq 'INNORMAL'}">
					<font>${ucc.upsOutletIsClean.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.upsOutletIsClean.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.batSurfaceIsClean eq 'INNORMAL'}">
					<font>${ucc.batSurfaceIsClean.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.batSurfaceIsClean.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.connCo eq 'INNORMAL'}">
					<font>${ucc.connCo.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.connCo.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.upsCurFAlarm eq 'INNORMAL'}">
					<font>${ucc.upsCurFAlarm.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.upsCurFAlarm.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${ucc.upsHisFAlarm eq 'INNORMAL'}">
					<font>${ucc.upsHisFAlarm.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.upsHisFAlarm.value}
				</c:otherwise>
			</c:choose>
		</td>
	</c:forEach>
	<!-- 系统测量 -->
	<c:forEach items="${vo.systemMeasure }" var="sm">
		<td>${sm.pvANDisOutValue }</td>
		<td>${sm.pvANMeaInValue}</td>
		<td>${sm.pvANMeaOutValue}</td>
		<td>${sm.pvANRemark}</td>
		<td>${sm.pvBNDisOutValue}</td>
		<td>${sm.pvBNMeaInValue}</td>
		<td>${sm.pvBNMeaOutValue}</td>
		<td>${sm.pvBNRemark}</td>
		<td>${sm.pvCNDisOutValue}</td>
		<td>${sm.pvCNMeaInValue}</td>
		<td>${sm.pvCNMeaOutValue}</td>
		<td>${sm.pvCNRemark}</td>
		<td>${sm.lvABDisOutValue}</td>
		<td>${sm.lvABMeaInValue}</td>
		<td>${sm.lvABMeaOutValue}</td>
		<td>${sm.lvABRemark}</td>
		<td>${sm.lvACDisOutValue}</td>
		<td>${sm.lvACMeaInValue}</td>
		<td>${sm.lvACMeaOutValue}</td>
		<td>${sm.lvACRemark}</td>
		<td>${sm.lvBCDisOutValue}</td>
		<td>${sm.lvBCMeaInValue}</td>
		<td>${sm.lvBCMeaOutValue}</td>
		<td>${sm.lvBCRemark}</td>
		<td>${sm.pcADisOutValue}</td>
		<td>${sm.pcAMeaInValue}</td>
		<td>${sm.pcAMeaOutValue}</td>
		<td>${sm.pcARemark}</td>
		<td>${sm.pcBDisOutValue}</td>
		<td>${sm.pcBMeaInValue}</td>
		<td>${sm.pcBMeaOutValue}</td>
		<td>${sm.pcBRemark}</td>
		<td>${sm.pcCDisOutValue}</td>
		<td>${sm.pcCMeaInValue}</td>
		<td>${sm.pcCMeaOutValue}</td>	
		<td>${sm.pcCRemark}</td>
		<td>${sm.ppADisOutValue}</td>
		<td>${sm.ppAMeaCalValue}</td>
		<td>${sm.ppARemark}</td>
		<td>${sm.ppBDisOutValue}</td>
		<td>${sm.ppBMeaCalValue}</td>
		<td>${sm.ppBRemark}</td>
		<td>${sm.ppCDisOutValue}</td>
		<td>${sm.ppCMeaCalValue}</td>
		<td>${sm.ppCRemark}</td>
	</c:forEach>
	<!-- 零地电压及零线电流测量 -->
	<c:forEach items="${vo.zgvZlcMeasure }" var="zzm">
		<td>${zzm.zgvInputResult }</td>
		<td>${zzm.zgvInputRemark }</td>
		<td>${zzm.zgvOutputResult }</td>
		<td>${zzm.zgvOutputRemark }</td>
		<td>${zzm.zlcInputResult }</td>
		<td>${zzm.zlcInputRemark }</td>
		<td>${zzm.zlcOutputResult }</td>
		<td>${zzm.zlcOutputRemark }</td>
	</c:forEach>
	<!-- 系统连接检查 -->
	<c:forEach items="${vo.systemConnMeasure }" var="scm">
		<td>${scm.upsIcTr }</td>
		<td>${scm.upsIcRemark }</td>
		<td>${scm.upsFRunTr }</td>
		<td>${scm.upsFRunRemark }</td>
		<td>${scm.upsIbFirmTr }</td>
		<td>${scm.upsIbFirmRemark }</td>
		<td>${scm.upsCwOhTr }</td>
		<td>${scm.upsCwOhRemark }</td>
		<td>${scm.upsRvTr }</td>
		<td>${scm.upsRvRemark }</td>
		<td>${scm.batCTr }</td>
		<td>${scm.batCRemark }</td>
		<td>${scm.upsPdcIowTr }</td>
		<td>${scm.upsPdcIowRemark }</td>
		<td>${scm.bpdbTr }</td>
		<td>${scm.bpdbRemark }</td>
		<td>${scm.pdcCTr }</td>
		<td>${scm.pdcCRemark }</td>
		<td>${scm.pdcMIlTr }</td>
		<td>${scm.pdcMIlRemark }</td>
		<td>${scm.bfnTr }</td>
		<td>${scm.bfnRemark }</td>
		<td>${scm.ltCwFTr }</td>
		<td>${scm.ltCwFRemark }</td>
		<td>${scm.ltLcTr }</td>
		<td>${scm.ltLcRemark }</td>
		<td>${scm.ltSTr }</td>
		<td>${scm.ltSRemark }</td>
	</c:forEach>
	<!-- 放电测试 -->
	<c:forEach items="${vo.dischargeTest }" var="dt">
		<td>${dt.startTime }</td>
		<td>${dt.endTime }</td>
		<td>${dt.durationTime }</td>
		<td>${dt.preTotalV }</td>
		<td>${dt.endTotalV }</td>
		<td>${dt.batChargingC }</td>
		<c:forEach items="${dt.dischargeProcess }" var="dp">
			<td>${dp.dsTime }</td>
			<td>${dp.batTotalV }</td>
			<td>${dp.dsCurrent }</td>
			<td>${dp.singleMaxV }</td>
			<td>${dp.singleMinV }</td>
			<td>${dp.remark }</td>
		</c:forEach>
	</c:forEach>
	<!-- 电池测量 -->
	<%-- <c:set var="num" value="${0 }"></c:set> --%>
	<c:forEach items="${vo.batteryMeasure }" var="bm">
		<td>${bm.number }</td>
		<%-- <c:set var="num" value="${num+1 }"></c:set> --%>
		<td>${bm.termialV }</td>
		<td>${bm.interR }</td>
		<td>${bm.remarks}</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.problem }</td>
	<td>${vo.suggestion }</td>
	<td>${vo.result }</td>
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['txjdups_check_quarter_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/upsdutyquarter/txjdups/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['txjdups_check_quarter_del']}">
			<a href="${rootUrl}duty/upsdutyquarter/txjdups/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['txjdups_check_quarter_update']}">
		<a href="${rootUrl}duty/upsdutyquarter/txjdups/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>