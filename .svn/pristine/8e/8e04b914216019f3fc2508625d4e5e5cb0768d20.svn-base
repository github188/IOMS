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
	<td>
		<fmt:formatDate value="${vo.checkTime}" type="both" 
						pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.name }</td>
	<c:forEach items="${vo.dgCheckContent }" var="ucc">
		<!-- 环境 -->
		<td>
			<c:choose>
				<c:when test="${ucc.enCheckResult eq 'INNORMAL'}">
					<font>${ucc.enCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.enCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.enRemarks }</td>
		<!-- 机体加热 -->
		<td>
			<c:choose>
				<c:when test="${ucc.bhCheckResult eq 'INNORMAL'}">
					<font>${ucc.bhCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.bhCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.bhRemarks }</td>
		<!--发动机控制板指示灯检查结果  -->
		<td>
			<c:choose>
				<c:when test="${ucc.ecpiCheckResult eq 'INNORMAL'}">
					<font>${ucc.ecpiCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.ecpiCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.ecpiRemarks }</td>
		<!-- 机房温湿度 -->
		<td>
			<c:choose>
				<c:when test="${ucc.rmhCheckResult eq 'INNORMAL'}">
					<font>${ucc.rmhCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.rmhCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.rmhRemarks }</td>
		<!-- 发动机运转 -->
		<td>
			<c:choose>
				<c:when test="${ucc.ercCheckResult eq 'INNORMAL'}">
					<font>${ucc.ercCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.ercCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.ercRemarks }</td>
		<!-- 润滑压力 -->
		<td>
			<c:choose>
				<c:when test="${ucc.lpCheckResult eq 'INNORMAL'}">
					<font>${ucc.lpCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.lpCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.lpRemarks }</td>
		<!-- 燃油压力 -->
		<td>
			<c:choose>
				<c:when test="${ucc.fpCheckResult eq 'INNORMAL'}">
					<font>${ucc.fpCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.fpCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.fpRemarks }</td>
		<!-- 机油系统 -->
		<td>
			<c:choose>
				<c:when test="${ucc.osCheckResult eq 'INNORMAL'}">
					<font>${ucc.osCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.osCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.osRemarks }</td>
		<!-- 冷却系统 -->
		<td>
			<c:choose>
				<c:when test="${ucc.csCheckResult eq 'INNORMAL'}">
					<font>${ucc.csCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.csCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.csRemarks }</td>
		<!--燃料系统  -->
		<td>
			<c:choose>
				<c:when test="${ucc.fsCheckResult eq 'INNORMAL'}">
					<font>${ucc.fsCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.fsCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.fsRemarks }</td>
		<!--蓄电池液  -->
		<td>
			<c:choose>
				<c:when test="${ucc.blCheckResult eq 'INNORMAL'}">
					<font>${ucc.blCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.blCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.blRemarks }</td>
		<!--各个皮带  -->
		<td>
			<c:choose>
				<c:when test="${ucc.ebCheckResult eq 'INNORMAL'}">
					<font>${ucc.ebCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.ebCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.ebRemarks }</td>
		<!-- 空气系统 -->
		<td>
			<c:choose>
				<c:when test="${ucc.asCheckResult eq 'INNORMAL'}">
					<font>${ucc.asCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.asCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.asRemarks }</td>
		<!--散热器百叶窗  -->
		<td>
			<c:choose>
				<c:when test="${ucc.rsCheckResult eq 'INNORMAL'}">
					<font>${ucc.rsCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.rsCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.rsRemarks }</td>
		<!-- 自动开关 -->
		<td>
			<c:choose>
				<c:when test="${ucc.autosCheckResult eq 'INNORMAL'}">
					<font>${ucc.autosCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.autosCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.autosRemarks }</td>
<%-- 	<!--1号ATS检查结果与备注  -->
		<td>
			<c:choose>
				<c:when test="${ucc.atsNumoneCheckResult eq 'INNORMAL'}">
					<font>${ucc.atsNumoneCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.atsNumoneCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.atsNumoneRemarks }</td>
		<!-- 2号ATS检查结果与备注 -->
		<td>
			<c:choose>
				<c:when test="${ucc.atsNumtwoCheckResult eq 'INNORMAL'}">
					<font>${ucc.atsNumtwoCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.atsNumtwoCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.atsNumtwoRemarks }</td>
		<!-- 各单位切换护头 -->
		<td>
			<c:choose>
				<c:when test="${ucc.ushCheckResult eq 'INNORMAL'}">
					<font>${ucc.ushCheckResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.ushCheckResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.ushRemarks }</td>
		<!--电缆检测  -->
		<td>
			<c:choose>
				<c:when test="${ucc.cableTestResult eq 'INNORMAL'}">
					<font>${ucc.cableTestResult.value}</font>
				</c:when>
				<c:otherwise>
					${ucc.cableTestResult.value}
				</c:otherwise>
			</c:choose>
		</td>
		<td>${ucc.cableTestRemarks }</td> --%>
		<td>${ucc.sbvCheckResult }</td>
		<td>${ucc.sbvRemarks }</td>
		<td>${ucc.dopCheckResult }</td>
		<td>${ucc.dopRemarks }</td>
		<td>${ucc.opCheckResult }</td>
		<td>${ucc.opRemarks }</td>
		<td>${ucc.pfCheckResult }</td>
		<td>${ucc.pfRemarks }</td>
		<td>${ucc.epCheckResult }</td>
		<td>${ucc.epRemarks }</td>
		<td>${ucc.ewtCheckResult }</td>
		<td>${ucc.ewtRemarks }</td>
		<td>${ucc.pvANCheckResult }</td>
		<td>${ucc.pvANRemarks }</td>
		<td>${ucc.pvBNCheckResult }</td>
		<td>${ucc.pvBNRemarks }</td>
		<td>${ucc.pvCNCheckResult }</td>
		<td>${ucc.pvCNRemarks }</td>
		<td>${ucc.lvABCheckResult }</td>
		<td>${ucc.lvABRemarks }</td>
		<td>${ucc.lvACCheckResult }</td>
		<td>${ucc.lvACRemarks }</td>
		<td>${ucc.lvBCCheckResult }</td>
		<td>${ucc.lvBCRemarks }</td>
		<td>${ucc.caCheckResult }</td>
		<td>${ucc.caRemarks }</td>
		<td>${ucc.cbCheckResult }</td>
		<td>${ucc.cbRemarks }</td>
		<td>${ucc.ccCheckResult }</td>
		<td>${ucc.ccRemarks }</td>
		<td>${ucc.paCheckResult }</td>
		<td>${ucc.paRemarks }</td>
		<td>${ucc.pbCheckResult }</td>
		<td>${ucc.pbRemarks }</td>
		<td>${ucc.pcCheckResult }</td>
		<td>${ucc.pcRemarks }</td>
	</c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['dg_check_month_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/dgdutymonth/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['dg_check_month_del']}">
			<a href="${rootUrl}duty/dgdutymonth/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['dg_check_month_update']}">
		<a href="${rootUrl}duty/dgdutymonth/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>