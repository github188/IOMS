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
<script type="text/javascript">
	$(function() {
	});
</script>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.equipName.value }</td>

	<td>${vo.uctAtemp }</td>
	<td>${vo.dctAtemp }</td>
	<td>${vo.mctAtemp }</td>
	<td>${vo.uctBtemp }</td>
	<td>${vo.dctBtemp }</td>
	<td>${vo.mctBtemp }</td>
	<td>${vo.odutAucf }</td>
	<td>${vo.odutAuca }</td>
	<td>${vo.odutAdcf }</td>
	<td>${vo.odutAdca }</td>
	<td>${vo.odutBucf }</td>
	<td>${vo.odutBuca }</td>
	<td>${vo.odutBdcf }</td>
	<td>${vo.odutBdca }</td>
	<td><c:choose>
			<c:when test="${vo.odusAresult eq 'OK'}">
	${vo.odusAresult }
	</c:when>
			<c:otherwise>
				<font>${vo.odusAresult }</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.odusBresult eq 'OK'}">
	${vo.odusBresult }
	</c:when>
			<c:otherwise>
				<font>${vo.odusBresult }</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.net1Work eq 'OK'}">
	${vo.net1Work }
	</c:when>
			<c:otherwise>
				<font>${vo.net1Work }</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.net1Map }</td>
	<td><c:choose>
			<c:when test="${vo.net2Work eq 'OK'}">
	${vo.net2Work }
	</c:when>
			<c:otherwise>
				<font>${vo.net2Work }</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.net2Map }</td>
	<td><c:choose>
			<c:when test="${vo.net3Work eq 'OK'}">
	${vo.net3Work }
	</c:when>
			<c:otherwise>
				<font>${vo.net3Work }</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.net3Map }</td>
	<td><c:choose>
			<c:when test="${vo.net4Work eq 'OK'}">
	${vo.net4Work }
	</c:when>
			<c:otherwise>
				<font>${vo.net4Work }</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.net4Map }</td>
	<td><c:choose>
			<c:when test="${vo.netfrWork eq 'OK'}">
	${vo.netfrWork }
	</c:when>
			<c:otherwise>
				<font>${vo.netfrWork }</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.netfrMap }</td>
	<td>${vo.net10Rx0Show }</td>
	<td>${vo.net10Eb0Show }</td>
	<td>${vo.net10Rx1Show }</td>
	<td>${vo.net10Eb1Show }</td>
	<td>${vo.net10Rx130Show }</td>
	<td>${vo.net10Eb130Show }</td>
	<td>${vo.net10PeakShow }</td>
	<td>${vo.net10NoiseShow }</td>
	<td>${vo.net1Znum }</td>
	<td>${vo.net1Zweather }</td>
	<td>${vo.net1Zstate }</td>
	<td>${vo.net1ZrxShow }</td>
	<td>${vo.net1ZebShow }</td>
	<td>${vo.net1Bnum }</td>
	<td>${vo.net1Bweather }</td>
	<td>${vo.net1Bstate }</td>
	<td>${vo.net1BrxShow }</td>
	<td>${vo.net1BebShow }</td>
	<td>${vo.net20Rx0Show }</td>
	<td>${vo.net20Eb0Show }</td>
	<td>${vo.net20Rx1Show }</td>
	<td>${vo.net20Eb1Show }</td>
	<td>${vo.net20PeakShow }</td>
	<td>${vo.net20NoiseShow }</td>
	<td>${vo.net2Znum }</td>
	<td>${vo.net2Zweather }</td>
	<td>${vo.net2Zstate }</td>
	<td>${vo.net2ZrxShow }</td>
	<td>${vo.net2ZebShow }</td>
	<td>${vo.net2Bnum }</td>
	<td>${vo.net2Bweather }</td>
	<td>${vo.net2Bstate }</td>
	<td>${vo.net2BrxShow }</td>
	<td>${vo.net2BebShow }</td>
	<td>${vo.net30Rx0Show }</td>
	<td>${vo.net30Eb0Show }</td>
	<td>${vo.net30Rx1Show }</td>
	<td>${vo.net30Eb1Show }</td>
	<td>${vo.net30PeakShow }</td>
	<td>${vo.net30NoiseShow }</td>
	<td>${vo.net3Znum }</td>
	<td>${vo.net3Zweather }</td>
	<td>${vo.net3Zstate }</td>
	<td>${vo.net3ZrxShow }</td>
	<td>${vo.net3ZebShow }</td>
	<td>${vo.net3Bnum }</td>
	<td>${vo.net3Bweather }</td>
	<td>${vo.net3Bstate }</td>
	<td>${vo.net3BrxShow }</td>
	<td>${vo.net3BebShow }</td>
	<td>${vo.net40Rx0Show }</td>
	<td>${vo.net40Eb0Show }</td>
	<td>${vo.net40Rx1Show }</td>
	<td>${vo.net40Eb1Show }</td>
	<td>${vo.net40PeakShow }</td>
	<td>${vo.net40NoiseShow }</td>
	<td>${vo.net4Znum }</td>
	<td>${vo.net4Zweather }</td>
	<td>${vo.net4Zstate }</td>
	<td>${vo.net4ZrxShow }</td>
	<td>${vo.net4ZebShow }</td>
	<td>${vo.net4Bnum }</td>
	<td>${vo.net4Bweather }</td>
	<td>${vo.net4Bstate }</td>
	<td>${vo.net4BrxShow }</td>
	<td>${vo.net4BebShow }</td>
	<td>${vo.frPeakShow }</td>
	<td>${vo.frNoiseShow }</td>
	<td>${vo.netfrZnum }</td>
	<td>${vo.netfrZweather }</td>
	<td>${vo.netfrZstate }</td>
	<td>${vo.frZrxShow }</td>
	<td>${vo.frZebShow }</td>
	<td>${vo.netfrBnum }</td>
	<td>${vo.netfrBweather }</td>
	<td>${vo.netfrBstate }</td>
	<td>${vo.frBrxShow }</td>
	<td>${vo.frBebShow }</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_day_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:1000}"
				href="${rootUrl}duty/satellitedayauto/view.do?id=${vo.id}&optType=txjdKu">查看</a>
		</sec:authorize> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_auto_kuday_update']}">
				<a class="my_edit {boxwidth:1000,boxheight:1000}"
					href="${rootUrl}duty/satellitedayauto/kustate/update.do?id=${vo.id}&optType=txjdKu">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>