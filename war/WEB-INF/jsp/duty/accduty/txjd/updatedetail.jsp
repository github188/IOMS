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
                <th width="5%" rowspan="8">通信基地精密空调</th>
                <th width="25%" colspan="2">主风机转动</th>
                <th width="25%">转动灵活无杂</th>
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
            <!--凝结水管  -->
            <tr>
                <th width="25%" colspan="2">凝结水管  </th>
                <th>凝结水管畅通</th>
                <td>
                    <select id="cpStatus" name="cpStatus">
                        <option value="${acc.cpStatus }">${acc.cpStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.cpStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="cpRemarks" value="${acc.cpRemarks }"/></td>
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
            <!-- 加湿罐 -->
            <tr>
                <th width="25%" colspan="2">加湿罐</th>
                <th>加湿罐内洁净</th>
                <td>
                    <select id="htStatus" name="htStatus">
                        <option value="${acc.htStatus }">${acc.htStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.htStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td><form:input path="htRemarks" value="${acc.htRemarks }"/></td>
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
                <th width="5%" rowspan="11">通信基地精密空调</th>
                <th width="5%" rowspan="3">制冷系统</th>
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
            <tr>
                <th width="20%">过滤网</th>
                <th width="25%">过滤网干净</th>
                <td width="25%">
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
            <!-- 加湿系统 -->
            <tr>
                <th width="5%" rowspan="2">加湿系统 </th>
                <th width="20%">加湿罐</th>
                <th width="25%">水位正常<br />加湿灌内洁净</th>
                <td width="25%">
                    <select id="htStatus" name="htStatus">
                        <option value="${acc.htStatus }">${acc.htStatus.value }</option>
                        <c:forEach items="${checkresult }" var="vo">
                            <c:if test="${acc.htStatus.value != vo.value }">
                                <option value="${vo }">${vo.value }</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%"><form:input path="htRemarks" value="${acc.htRemarks }"/></td>
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
        <!--压缩机电流  -->
        <tr>
            <th width="30%" colspan="3">压缩机电流</th>
            <td width="25%"><form:input path="ccValue" value="${adr.ccValue }"/></td>
            <td width="25%">
                <select id="ccStatus" name="ccStatus">
                     <option value="${adr.ccStatus }">${adr.ccStatus.value }</option>
                    <c:forEach items="${checkresult }" var="vo">
                        <c:if test="${adr.ccStatus.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="ccRemarks" value="${adr.ccRemarks }"/></td>
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
            <td width="20%"><form:input path="aowsRemarks" value="${adr.aowsRemarks }"/></td>
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
    <tr>
    <th width="30%" colspan="3">操作人：</th>
    <td width="25%">${accCheck.operator.name }</td>
    <th width="25%">巡检时间：</th>
    <td width="20%">
        <fmt:formatDate value="${accCheck.checkTime}" type="both" 
        pattern="yyyy-MM-dd HH:mm:ss" />
    </td>
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
