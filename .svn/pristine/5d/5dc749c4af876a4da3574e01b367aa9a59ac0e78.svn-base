<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>空调设备巡检</dd>
	</dl>
</div>
<table width="100%">
    <tr>
        <th width="55%" colspan="4">设备名称</th>
        <th width="45%" colspan="2">${accCheck.name }</th>
    </tr>
    <c:forEach items="${accCheck.accCheckContent }" var="acc">
        <c:if test="${accCheck.checkType eq 'MONTH' }">
            <tr>
                <th width="5%">项目</th>
                <th width="25%" colspan="2">维护内容</th>
                <th width="25%">维护标准</th>
                <th width="25%">运行状态</th>
                <th width="20%">备注</th>
            </tr>
            <!-- 主风机转动 -->
            <tr>
                <th width="5%" rowspan="12">艾默生精密空调</th>
                <th width="25%" colspan="2">主风机转动</th>
                <th width="25%">转动灵活、无杂音、皮带松紧适度</th>
                <td width="25%">
                    <select id="mfrStatus" name="mfrStatus">
                        <option value="${acc.mfrStatus }">${acc.mfrStatus.value }</option>
                        <c:forEach items="${checkresult}" var="vo">
                            <c:if test="${acc.mfrStatus.value != vo.value }">
                                <option value="${vo}">${vo.value}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="mfrRemarks" value="${acc.mfrRemarks }"/></td>
            </tr>
            <!-- 过滤网 -->
            <tr>
                <th width="25%" colspan="2">过滤网</th>
                <th>滤网干净,无尘,无堵塞现象</th>
                <td>
                    <select id="fsStatus" name="fsStatus">
                        <option value="${acc.fsStatus }">${acc.fsStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.fsStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="fsRemarks" value="${acc.fsRemarks }"/></td>
            </tr>
            <!--凝结水盘和凝结水管  -->
            <tr>
                <th width="25%" colspan="2">凝结水盘和凝结水管  </th>
                <th>水盘中无异物、凝结水管畅通</th>
                <td>
                    <select id="cwppStatus" name="cwppStatus">
                        <option value="${acc.cwppStatus }">${acc.cwppStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.cwppStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="cwppRemarks" value="${acc.cwppRemarks }"/></td>
            </tr>
            <!-- 蒸发器翅片 -->
            <tr>
                <th width="25%" colspan="2">蒸发器翅片</th>
                <th>洁净无倒扶</th>
                <td>
                    <select id="efStatus" name="efStatus">
                        <option value="${acc.efStatus }">${acc.efStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.efStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="efRemarks" value="${acc.efRemarks }"/></td>
            </tr>
            <!-- 设备内部、外部表面 -->
            <tr>
                <th width="25%" colspan="2">设备内部、外部表面</th>
                <th>洁净无灰尘</th>
                <td>
                    <select id="esStatus" name="esStatus">
                        <option value="${acc.esStatus }">${acc.esStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.esStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="esRemarks" value="${acc.esRemarks }"/></td>
            </tr>
            <!-- 设备周围环境 -->
            <tr>
                <th width="25%" colspan="2">设备周围环境</th>
                <th>洁净无杂物</th>
                <td>
                    <select id="eeStatus" name="eeStatus">
                        <option value="${acc.eeStatus }">${acc.eeStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.eeStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="eeRemarks" value="${acc.eeRemarks }"/></td>
            </tr>
            <!-- 水盘 -->
            <tr>
                <th width="25%" colspan="2">水盘</th>
                <th>洁净无垢、加湿罐内洁净</th>
                <td>
                    <select id="wpStatus" name="wpStatus">
                        <option value="${acc.wpStatus }">${acc.wpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.wpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="wpRemarks" value="${acc.wpRemarks }"/></td>
            </tr>
            <!-- 上下排水管线路、水滤网 -->
            <tr>
                <th width="25%" colspan="2">上下排水管线路、水滤网</th>
                <th>畅通无堵塞现象</th>
                <td>
                    <select id="dplWfStatus" name="dplWfStatus">
                        <option value="${acc.dplWfStatus }">${acc.dplWfStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.dplWfStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="dplWfRemarks" value="${acc.dplWfRemarks }"/></td>
            </tr>
            <!-- 加湿器水位和水漂 -->
            <tr>
                <th width="25%" colspan="2">加湿器水位和水漂</th>
                <th>水位正常、水漂正常</th>
                <td>
                    <select id="hwlwStatus" name="hwlwStatus">
                        <option value="${acc.hwlwStatus }">${acc.hwlwStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.hwlwStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="hwlwRemarks" value="${acc.hwlwRemarks }"/></td>
            </tr>
            <!-- 空调出风口风速 -->
            <tr>
                <th width="25%" colspan="2">空调出风口风速</th>
                <th>参数在正常值范围内</th>
                <td>
                    <select id="acwsStatus" name="acwsStatus">
                        <option value="${acc.acwsStatus }">${acc.acwsStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.acwsStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="acwsRemarks"  value="${acc.acwsRemarks }"/></td>
            </tr>
            <!-- 空调出风口温度 -->
            <tr>
                <th width="25%" colspan="2">空调出风口温度</th>
                <th>参数在正常值范围内</th>
                <td>
                    <select id="actStatus" name="actStatus">
                        <option value="${acc.actStatus }">${acc.actStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.actStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="actRemarks" value="${acc.actRemarks }"/></td>
            </tr>
            <!-- 空调总接线电压、电流、空调内部压缩机、主风机、室外机电流 -->
            <tr>
                <th width="25%" colspan="2">空调总接线电压、电流、空调内部压缩机、主风机、室外机电流</th>
                <th>各项电流，电压数值正常</th>
                <td>
                    <select id="acvcStatus" name="acvcStatus">
                        <option value="${acc.acvcStatus }">${acc.acvcStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.acvcStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="acvcRemarks" value="${acc.acvcRemarks }"/></td>
            </tr>    
        </c:if>
        <c:if test="${accCheck.checkType eq 'QUARTER' or accCheck.checkType eq 'YEAR' }">
            <tr>
                <th width="5%">项目</th>
                <th width="5%">维护<br>内容</th>
                <th width="20%">检查维护内容</th>
                <th width="25%">检查维护标准</th>
                <th width="25%">运行状态</th>
                <th width="20%">备注</th>
            </tr>
            <!-- 制冷系统 -->
            <tr>
                <th width="5%" rowspan="16">艾默生精密空调</th>
                <th width="5%" rowspan="5">制冷系统</th>
                <th width="25%">视镜</th>
                <th width="25%">视镜内无气泡<br>视镜内液体颜色为绿色或蓝色</th>
                <td width="25%">
                    <select id="mirrorStatus" name="mirrorStatus">
                        <option value="${acc.mirrorStatus }">${acc.mirrorStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.mirrorStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="mirrorRemarks" value="${acc.mirrorRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">吸排气压力</th>
                <th width="25%">吸气压力应在70psi左右<br>排气压力应在250psi左右</th>
                <td width="25%">
                    <select id="sepStatus" name="sepStatus">
                        <option value="${acc.sepStatus }">${acc.sepStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.sepStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="sepRemarks" value="${acc.sepRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">制冷管</th>
                <th width="25%">管线固定牢固<br>保温材料无破损</th>
                <td width="25%">
                    <select id="rpStatus" name=rpStatus>
                        <option value="${acc.rpStatus }">${acc.rpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.rpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="rpRemarks" value="${acc.rpRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">压缩机工作电流</th>
                <th width="25%">工作电流在正常值内</th>
                <td width="25%">
                    <select id="cocStatus" name="cocStatus">
                        <option value="${acc.cocStatus }">${acc.cocStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.cocStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="cocRemarks" value="${acc.cocRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">室外空调机组内制冷剂压力</th>
                <th width="25%">制冷剂压力在正常值内</th>
                <td width="25%">
                    <select id="oacuprStatus" name="oacuprStatus">
                        <option value="${acc.oacuprStatus }">${acc.oacuprStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.oacuprStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="oacurpRemarks" value="${acc.oacurpRemarks }"/></td>
            </tr>
            <!-- 室外冷凝设备 -->
            <tr>
                <th width="5%" rowspan="2">室外冷凝设备</th>
                <th width="20%">电机轴承及风扇</th>
                <th width="25%">风扇电机转动灵活，无抖动<br>无轴承摩擦杂音</th>
                <td width="25%">
                    <select id="mbfStatus" name="mbfStatus">
                        <option value="${acc.mbfStatus }">${acc.mbfStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.mbfStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="mbfRemarks" value="${acc.mbfRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">冷凝器散热翅片</th>
                <th width="25%">无灰尘<br>翅片无倒浮现象</th>
                <td>
                    <select id="chrfStatus" name="chrfStatus">
                        <option value="${acc.chrfStatus }">${acc.chrfStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.chrfStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="chrfRemarks" value="${acc.chrfRemarks }"/></td>
            </tr>
            <!-- 除湿系统 -->
            <tr>
                <th width="5%" rowspan="2">除湿系统</th>
                <th width="20%">水盘</th>
                <th width="25%">洁净无垢</th>
                <td width="25%">
                    <select id="wpStatus" name="wpStatus">
                        <option value="${acc.wpStatus }">${acc.wpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.wpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="wpRemarks" value="${acc.wpRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">储水盒、排水管</th>
                <th width="25%">无积水<br>水管排水畅通</th>
                <td width="25%">
                    <select id="wsbDpStatus" name="wsbDpStatus">
                        <option value="${acc.wsbDpStatus }">${acc.wsbDpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.wsbDpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="wsbDpRemarks" value="${acc.wsbDpRemarks }"/></td>
            </tr>
            <!-- 加湿系统 -->
            <tr>
                <th width="5%" rowspan="3">加湿系统 </th>
                <th width="20%">水盘和水漂</th>
                <th width="25%">水位正常、水漂无水垢<br>水盘内洁净无垢、加湿灌内洁净</th>
                <td width="25%">
                    <select id="wpbStatus" name="wpbStatus">
                        <option value="${acc.wpbStatus }">${acc.wpbStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.wpbStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="wpbRemarks" value="${acc.wpbRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">空调加湿情况</th>
                <th width="25%">加湿情况正常</th>
                <td width="25%">
                    <select id="achStatus" name="achStatus">
                        <option value="${acc.achStatus }">${acc.achStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.achStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="achRemarks" value="${acc.achRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">加湿器工作电流</th>
                <th width="25%">加湿器电流在12A左右</th>
                <td width="25%">
                    <select id="hwcStatus" name="hwcStatus">
                        <option value="${acc.hwcStatus }">${acc.hwcStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.hwcStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="hwcRemarks" value="${acc.hwcRemarks }"/></td>
            </tr>
            <!-- 电气系统 -->
            <tr>
                <th width="5%" rowspan="4">电气系统</th>
                <th width="20%">供电电气线路</th>
                <th width="25%">供电电气线路无老化现象</th>
                <td width="25%">
                    <select id="pslStatus" name="pslStatus">
                        <option value="${acc.pslStatus }">${acc.pslStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.pslStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="pslRemarks" value="${acc.pslRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">接线</th>
                <th width="25%">各接线柱无松动现象</th>
                <td width="25%">
                    <select id="connStatus" name="connStatus">
                        <option value="${acc.connStatus }">${acc.connStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.connStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="connRemarks" value="${acc.connRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">电气控制部分</th>
                <th width="25%">室内外机电气控制盘内清洁无尘</th>
                <td width="25%">
                    <select id="ecpStatus" name="ecpStatus">
                        <option value="${acc.ecpStatus }">${acc.ecpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.ecpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="ecpRemarks" value="${acc.ecpRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">所有继电器触点、电气元件</th>
                <th width="25%">所有继电器应按工作要求吸合、断开无杂音</th>
                <td width="25%">
                    <select id="rcEcStatus" name="rcEcStatus">
                        <option value="${acc.rcEcStatus }">${acc.rcEcStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.rcEcStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="rcEcRemarks" value="${acc.rcEcRemarks }"/></td>
            </tr>
        </c:if>
    </c:forEach>
    <c:forEach items="${accCheck.accDataRecord }" var="adr">
        <tr><th width="100%" colspan="6">数据记录</th></tr>
        <tr>
            <th width="30%" colspan="3">名称</th>
            <th width="25%">数值</th>
            <th width="25%">状态</th>
            <th width="20%">备注</th>
        </tr>
        <!-- 总电压 -->
        <tr>
            <th width="30%" colspan="3">总电压</th>
            <td width="25%"><form:input path="tvValue" value="${adr.tvValue }"/></td>
            <td width="25%">
                <select id="tvStatus" name="tvStatus">
                    <option value="${adr.tvStatus }">${adr.tvStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.tvStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="tvRemarks" value="${adr.tvRemarks }"/></td>
        </tr>
        <!-- 总电流 -->
        <tr>
            <th width="30%" colspan="3">总电流</th>
            <td width="25%"><form:input path="tcValue" value="${adr.tcValue }"/></td>
            <td width="25%">
                <select id="tcStatus" name="tcStatus">
                    <option value="${adr.tcStatus }">${adr.tcStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.tcStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="tcRemarks" value="${adr.tcRemarks }"/></td>
        </tr>
        <!--1号压缩机电流  -->
        <tr>
            <th width="30%" colspan="3">1号压缩机电流</th>
            <td width="25%"><form:input path="cconeValue" value="${adr.cconeValue }"/></td>
            <td width="25%">
                <select id="cconeStatus" name="cconeStatus">
                     <option value="${adr.cconeStatus }">${adr.cconeStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.cconeStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <th width="20%"><form:input path="cconeRemarks" value="${adr.cconeRemarks }"/></th>
        </tr>
        <!-- 2号压缩机电流 -->
        <tr>
            <th width="30%" colspan="3">2号压缩机电流</th>
            <td width="25%"><form:input path="cctwoValue" value="${adr.cctwoValue }"/></td>
            <td width="25%">
                <select id="cctwoStatus" name="cctwoStatus">
                    <option value="${adr.cctwoStatus }">${adr.cctwoStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.cctwoStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="cctwoRemarks" value="${adr.cctwoRemarks }"/></td>
        </tr>
        <!-- 主风机电流 -->
        <tr>
            <th width="30%" colspan="3">主风机电流</th>
            <td width="25%"><form:input path="mfcValue" value="${adr.mfcValue }"/></td>
            <td width="25%">
                <select id="mfcStatus" name="mfcStatus">
                    <option value="${adr.mfcStatus }">${adr.mfcStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.mfcStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="mfcRemarks" value="${adr.mfcRemarks }"/></td>
        </tr>
        <!-- 室外机电流 -->
        <tr>
            <th width="30%" colspan="3">室外机电流</th>
            <td width="25%"><form:input path="omcValue" value="${adr.omcValue }"/></td>
            <td width="25%">
                <select id="omcStatus" name="omcStatus">
                    <option value="${adr.omcStatus }">${adr.omcStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.omcStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="omcRemarks" value="${adr.omcRemarks }"/></td>
        </tr>
        <c:if test="${accCheck.checkType eq 'MONTH' }">
            <!-- 加湿器电流 -->
            <tr>
                <th width="30%" colspan="3">加湿器电流</th>
                <td width="25%"><form:input path="hcValue" value="${adr.hcValue }"/></td>
                <td width="25%">
                    <select id="hcStatus" name="hcStatus">
                     <option value="${adr.hcStatus }">${adr.hcStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.hcStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="hcRemarks" value="${adr.hcRemarks }"/></td>
            </tr>
        </c:if>
        <!-- 出风口温湿度 -->
        <tr>
            <th width="30%" colspan="3">出风口温湿度</th>
            <td width="25%"><form:input path="aothValue" value="${adr.aothValue }"/></td>
            <td width="25%">
                <select id="aothStatus" name="aothStatus">
                     <option value="${adr.aothStatus }">${adr.aothStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.aothStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="aothRemarks" value="${adr.aothRemarks }"/></td>
        </tr>
        <!-- 出风口风速-->
        <tr>
            <th width="30%" colspan="3">出风口风速</th>
            <td width="25%"><form:input path="aowsValue" value="${adr.aowsValue }"/></td>
            <td width="25%">
                <select id="aowsStatus" name="aowsStatus">
                    <option value="${adr.aowsStatus }">${adr.aowsStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.aowsStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <th width="20%"><form:input path="aowsRemarks" value="${adr.aowsRemarks }"/></th>
        </tr>
        <c:if test="${accCheck.checkType eq 'QUARTER' || accCheck.checkType eq 'YEAR' }">
            <tr>
                <th width="10%" rowspan="3" colspan="2">加湿器电流</th>
                <th width="20%">A</th>
                <td width="25%"><form:input path="hcaValue" value="${adr.hcaValue }"/></td>
                <td width="25%">
                    <select id="hcaStatus" name="hcaStatus">
                     <option value="${adr.hcaStatus }">${adr.hcaStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.hcaStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="hcaRemarks" value="${adr.hcaRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">B</th>
                <td width="25%"><form:input path="hcbValue" value="${adr.hcbValue }"/></td>
                <td width="25%">
                    <select id="hcbStatus" name="hcbStatus">
                     <option value="${adr.hcbStatus }">${adr.hcbStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.hcbStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="hcbRemarks" value="${adr.hcbRemarks }"/></td>
            </tr>
            <tr>
                <th width="20%">C</th>
                <td width="25%"><form:input path="hccValue" value="${adr.hccValue }"/></td>
                <td width="25%">
                    <select id="hccStatus" name="hccStatus">
                     <option value="${adr.hccStatus }">${adr.hccStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.hccStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="hccRemarks" value="${adr.hccRemarks }"/></td>
            </tr>
        </c:if>
    </c:forEach>
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
