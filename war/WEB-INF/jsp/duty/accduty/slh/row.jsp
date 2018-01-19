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
	<c:forEach items="${vo.accCheckContent }" var="acc">
        <c:if test="${vo.checkType eq 'MONTH' }">
            <!-- 主风机转动 -->
            <td>
                <c:choose>
                    <c:when test="${acc.mfrStatus eq 'INNORMAL'}">
                        <font>${acc.mfrStatus.value}</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.mfrStatus.value}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.mfrRemarks }</td>
            <!-- 过滤网 -->
            <td>
                <c:choose>
                    <c:when test="${acc.fsStatus eq 'INNORMAL'}">
                        <font>${acc.fsStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.fsStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.fsRemarks }</td>
            <!-- 凝结水盘和凝结水管 -->
            <td>
                <c:choose>
                    <c:when test="${acc.cwppStatus eq 'INNORMAL'}">
                        <font>${acc.cwppStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.cwppStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.cwppRemarks }</td>
            <!--蒸发器翅片  -->
            <td>
                <c:choose>
                    <c:when test="${acc.efStatus eq 'INNORMAL'}">
                        <font>${acc.efStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.efStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.efRemarks }</td>
            <!-- 设备内部、外部表面 -->
            <td>
                <c:choose>
                    <c:when test="${acc.esStatus eq 'INNORMAL'}">
                        <font>${acc.esStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.esStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.esRemarks }</td>
            <!-- 设备周围环境 -->
            <td>
                <c:choose>
                    <c:when test="${acc.eeStatus eq 'INNORMAL'}">
                        <font>${acc.eeStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.eeStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.eeRemarks }</td>
            <!-- 水盘 -->
            <td>
                <c:choose>
                    <c:when test="${acc.wpStatus eq 'INNORMAL'}">
                        <font>${acc.wpStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.wpStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.wpRemarks }</td>
            <!-- 上下排水管线路、水滤网 -->
            <td>
                <c:choose>
                    <c:when test="${acc.dplWfStatus eq 'INNORMAL'}">
                        <font>${acc.dplWfStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.dplWfStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.dplWfRemarks }</td>
            <!-- 加湿器水位和水漂 -->
            <td>
                <c:choose>
                    <c:when test="${acc.hwlwStatus eq 'INNORMAL'}">
                        <font>${acc.hwlwStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.hwlwStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.hwlwRemarks }</td>
            <!-- 空调出风口风速 -->
            <td>
                <c:choose>
                    <c:when test="${acc.acwsStatus eq 'INNORMAL'}">
                        <font>${acc.acwsStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.acwsStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.acwsRemarks }</td>
            <!-- 空调出风口温度 -->
            <td>
                <c:choose>
                    <c:when test="${acc.actStatus eq 'INNORMAL'}">
                        <font>${acc.actStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.actStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.actRemarks }</td>
            <!-- 空调总接线电压、电流空调内部压缩机、主风机、室外机电流             -->
            <td>
                <c:choose>
                    <c:when test="${acc.acvcStatus eq 'INNORMAL'}">
                        <font>${acc.acvcStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.acvcStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.acvcRemarks }</td>
        </c:if>
        <c:if test="${vo.checkType eq 'QUARTER' || vo.checkType eq 'YEAR' }">
            <!-- 视镜 -->
            <td>
                <c:choose>
                    <c:when test="${acc.mirrorStatus eq 'INNORMAL'}">
                        <font>${acc.mirrorStatus.value}</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.mirrorStatus.value}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.mirrorRemarks }</td>
            <!-- 吸排气压力 -->
            <td>
                <c:choose>
                    <c:when test="${acc.sepStatus eq 'INNORMAL'}">
                        <font>${acc.sepStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.sepStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.sepRemarks }</td>
            <!-- 制冷管 -->
            <td>
                <c:choose>
                    <c:when test="${acc.rpStatus eq 'INNORMAL'}">
                        <font>${acc.rpStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.rpStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.rpRemarks }</td>
            <!-- 压缩机工作电流 -->
            <td>
                <c:choose>
                    <c:when test="${acc.cocStatus eq 'INNORMAL'}">
                        <font>${acc.cocStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.cocStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.cocRemarks }</td>
            <!-- 室外空调机组内制冷剂压力 -->
            <td>
                <c:choose>
                    <c:when test="${acc.oacuprStatus eq 'INNORMAL'}">
                        <font>${acc.oacuprStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.oacuprStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.oacurpRemarks }</td>
            <!--电机轴承及风扇  -->
            <td>
                <c:choose>
                    <c:when test="${acc.mbfStatus eq 'INNORMAL'}">
                        <font>${acc.mbfStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.mbfStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.mbfRemarks }</td>
            <!-- 冷凝器散热翅片 -->
            <td>
                <c:choose>
                    <c:when test="${acc.chrfStatus eq 'INNORMAL'}">
                        <font>${acc.chrfStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.chrfStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.chrfRemarks }</td>
            <!--水盘  -->
            <td>
                <c:choose>
                    <c:when test="${acc.wpStatus eq 'INNORMAL'}">
                        <font>${acc.wpStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.wpStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.wpRemarks }</td>
            <!-- 储水盒、排水管 -->
            <td>
                <c:choose>
                    <c:when test="${acc.wsbDpStatus eq 'INNORMAL'}">
                        <font>${acc.wsbDpStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.wsbDpStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.wsbDpRemarks }</td>
            <!-- 水盘和水漂 -->
            <td>
                <c:choose>
                    <c:when test="${acc.wpbStatus eq 'INNORMAL'}">
                        <font>${acc.wpbStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.wpbStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.wpbRemarks }</td>
            <!--空调加湿情况  -->
            <td>
                <c:choose>
                    <c:when test="${acc.achStatus eq 'INNORMAL'}">
                        <font>${acc.achStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.achStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.achRemarks }</td>
            <!--加湿器工作电流  -->
            <td>
                <c:choose>
                    <c:when test="${acc.hwcStatus eq 'INNORMAL'}">
                        <font>${acc.hwcStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.hwcStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.hwcRemarks }</td>
            <!-- 供电电气线路 -->
            <td>
                <c:choose>
                    <c:when test="${acc.pslStatus eq 'INNORMAL'}">
                        <font>${acc.pslStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.pslStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.pslRemarks }</td>
            <!-- 接线 -->
            <td>
                <c:choose>
                    <c:when test="${acc.connStatus eq 'INNORMAL'}">
                        <font>${acc.connStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.connStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.connRemarks }</td>
            <!--电气控制部分  -->
            <td>
                <c:choose>
                    <c:when test="${acc.ecpStatus eq 'INNORMAL'}">
                        <font>${acc.ecpStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.ecpStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.ecpRemarks }</td>
            <!-- 所有继电器触点、电气元件 -->
            <td>
                <c:choose>
                    <c:when test="${acc.rcEcStatus eq 'INNORMAL'}">
                        <font>${acc.rcEcStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${acc.rcEcStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${acc.rcEcRemarks }</td>
        </c:if>
	</c:forEach>
    <c:forEach items="${vo.accDataRecord }" var="adr">
        <!-- 总电压 -->
        <td>${adr.tvValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.tvStatus eq 'INNORMAL'}">
                    <font>${adr.tvStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.tvStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.tvRemarks }</td>
        <!--总电流  -->
        <td>${adr.tcValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.tcStatus eq 'INNORMAL'}">
                    <font>${adr.tcStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.tcStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.tcRemarks }</td>
        <!-- 1号压缩机电流 -->
        <td>${adr.cconeValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.cconeStatus eq 'INNORMAL'}">
                    <font>${adr.cconeStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.cconeStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.cconeRemarks }</td>
        <!--2号压缩机电流  -->
        <td>${adr.cctwoValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.cctwoStatus eq 'INNORMAL'}">
                    <font>${adr.cctwoStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.cctwoStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.cctwoRemarks }</td>
        <!-- 主风机电流 -->
        <td>${adr.mfcValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.mfcStatus eq 'INNORMAL'}">
                    <font>${adr.mfcStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.mfcStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.mfcRemarks }</td>
        <!-- 室外机电流 -->
        <td>${adr.omcValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.omcStatus eq 'INNORMAL'}">
                    <font>${adr.omcStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.omcStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.omcRemarks }</td>
        <c:if test="${checkType eq 'MONTH' }">
            <!--加湿器电流  -->
            <td>${adr.hcValue }</td>
            <td>
                <c:choose>
                    <c:when test="${adr.hcStatus eq 'INNORMAL'}">
                        <font>${adr.hcStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${adr.hcStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${adr.hcRemarks }</td>
        </c:if>
        <!--出风口温湿度  -->
        <td>${adr.aothValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.aothStatus eq 'INNORMAL'}">
                    <font>${adr.aothStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.aothStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.aothRemarks }</td>
        <!--出风口风速  -->
        <td>${adr.aowsValue }</td>
        <td>
            <c:choose>
                <c:when test="${adr.aowsStatus eq 'INNORMAL'}">
                    <font>${adr.aowsStatus.value }</font>
                </c:when>
                <c:otherwise>
                    ${adr.aowsStatus.value }
                </c:otherwise>
            </c:choose>
        </td>
        <td>${adr.aowsRemarks }</td>
        <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
            <!--加湿器电流  a-->
            <td>${adr.hcaValue }</td>
            <td>
                <c:choose>
                    <c:when test="${adr.hcaStatus eq 'INNORMAL'}">
                        <font>${adr.hcaStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${adr.hcaStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${adr.hcaRemarks }</td>
            <!--加湿器电流b  -->
            <td>${adr.hcbValue }</td>
            <td>
                <c:choose>
                    <c:when test="${adr.hcbStatus eq 'INNORMAL'}">
                        <font>${adr.hcbStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${adr.hcbStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${adr.hcbRemarks }</td>
            <!-- 加湿器电流 c-->
            <td>${adr.hccValue }</td>
            <td>
                <c:choose>
                    <c:when test="${adr.hccStatus eq 'INNORMAL'}">
                        <font>${adr.hccStatus.value }</font>
                    </c:when>
                    <c:otherwise>
                        ${adr.hccStatus.value }
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${adr.hccRemarks }</td>
        </c:if>
    </c:forEach>
	<!-- 其他信息 -->
	<td>${vo.operator.name }</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['acc_check_slh_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}" 
			   href="${rootUrl}duty/accduty/slh/view.do?id=${vo.id}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['acc_check_slh_del']}">
			<a href="${rootUrl}duty/accduty/slh/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['acc_check_slh_update']}">
		<a href="${rootUrl}duty/accduty/slh/update.do?id=${vo.id}"
		   class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize>
	</td>
</tr>