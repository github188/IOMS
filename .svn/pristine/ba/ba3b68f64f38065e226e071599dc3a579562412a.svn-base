<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>传输设备与通讯线路检查</dd>
	</dl>
</div>
<table width="100%">
    <tr>
        <th width="50%" colspan="2">设备名称</th>
        <th width="50%" colspan="2">${psOtCheck.name }</th>
    </tr>
    <c:forEach items="${psOtCheck.psOtCheckContent }" var="pocc">
    <tr>
        <th width="50%" colspan="2">巡检内容</th>
        <th width="25%">结果记录</th>
        <th width="25%">备注</th>
    </tr>
    <!--风扇  -->
    <tr>
        <th width="25%" rowspan="3">设备运行环境</th>
        <th width="25%">风扇</th>
        <td>
            <select id="eoeFanCheckResult" name="eoeFanCheckResult">
                <option value="${pocc.eoeFanCheckResult }">${pocc.eoeFanCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.eoeFanCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="eoeFanRemarks" value="${pocc.eoeFanRemarks }"/></td>
    </tr>
    <!-- 温度 -->
    <tr>
        <th width="25%">温度</th>
        <td><form:input path="eoeTemCheckResult" value="${pocc.eoeTemCheckResult }"/></td>
        <td><form:input path="eoeTemRemarks" value="${pocc.eoeTemRemarks }"/></td>
    </tr>
    <!-- 湿度 -->
    <tr>
        <th width="25%">湿度</th>
        <td><form:input path="eoeHumCheckResult" value="${pocc.eoeHumCheckResult }"/></td>
        <td><form:input path="eoeHumRemarks" value="${pocc.eoeHumRemarks }"/></td>
    </tr>
    <!-- 显示屏 -->
    <tr>
        <th width="50%" colspan="2">显示屏</th>
        <td>
            <select id="screenCheckResult" name="screenCheckResult">
                <option value="${pocc.screenCheckResult }">${pocc.screenCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.screenCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="screenRemarks" value="${pocc.screenRemarks }"/></td>
    </tr>
    <!-- 设备指示灯状态 -->
    <tr>
        <th width="50%" colspan="2">设备指示灯状态</th>
        <td>
            <select id="disCheckResult" name="disCheckResult">
                <option value="${pocc.disCheckResult }">${pocc.disCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.disCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="disRemarks" value="${pocc.disRemarks }"/></td>
    </tr>
    <!-- 板卡运行状态 -->
    <tr>
        <th width="50%" colspan="2">板卡运行状态</th>
        <td>
            <select id="crsCheckResult" name="crsCheckResult">
                <option value="${pocc.crsCheckResult }">${pocc.crsCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.crsCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="crsRemarks" value="${pocc.crsRemarks }"/></td>
    </tr>
    <!-- 设备线缆连接 -->
    <tr>
        <th width="50%" colspan="2">设备线缆连接</th>
        <td>
            <select id="dlccCheckResult" name="dlccCheckResult">
                <option value="${pocc.dlccCheckResult }">${pocc.dlccCheckResult.value }</option>
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <c:if test="${pocc.dlccCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="dlccRemarks" value="${pocc.dlccRemarks }"/></td>
    </tr>
    <!-- 电源供电连接 -->
    <tr>
        <th width="50%" colspan="2">电源供电连接</th>
        <td>
            <select id="pscCheckResult" name="pscCheckResult">
                <option value="${pocc.pscCheckResult }">${pocc.pscCheckResult.value }</option>
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <c:if test="${pocc.pscCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="pscRemarks" value="${pocc.pscRemarks }"/></td>
    </tr>
    <!-- 交流电输入电压（V） -->
    <tr>
        <th width="50%" colspan="2">交流电输入电压（V）</th>
        <td><form:input path="acivCheckResult" value="${pocc.acivCheckResult }"/></td>
        <td><form:input path="acivRemarks" value="${pocc.acivRemarks }"/></td>
    </tr>
    <!-- 直流电输出电压（V） -->
    <tr>
        <th width="50%" colspan="2"> 直流电输出电压（V）</th>
        <td><form:input path="dcovCheckResult" value="${pocc.dcovCheckResult }"/></td>
        <td><form:input path="dcovRemarks" value="${pocc.dcovRemarks }"/></td>
    </tr>
    <!-- 蓄电池电压（V） -->
    <tr>
        <th width="50%" colspan="2"> 蓄电池电压（V）</th>
        <td><form:input path="bvCheckResult" value="${pocc.bvCheckResult }"/></td>
        <td><form:input path="bvRemarks" value="${pocc.bvRemarks }"/></td>
    </tr>
    <!-- 蓄电池内阻 -->
    <tr>
        <th width="50%" colspan="2">蓄电池内阻</th>
        <td>
            <select id="birCheckResult" name="birCheckResult">
                <option value="${pocc.birCheckResult }">${pocc.birCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.birCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="birRemarks" value="${pocc.birRemarks }"/></td>
    </tr>
    <c:if test="${psOtCheck.checkType eq 'QUARTER' or psOtCheck.checkType eq 'YEAR' }">
        <!-- 电池连接 -->
        <tr>
            <th width="50%" colspan="2">电池连接 </th>
            <td>
                <select id="batteryConnResult" name="batteryConnResult">
                    <option value="${pocc.batteryConnResult }">${pocc.batteryConnResult.value }</option>
                    <c:forEach items="${checkStatus}" var="vo">
                        <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                            <c:if test="${pocc.batteryConnResult.value != vo.value }">
                                <option value="${vo}">${vo.value}</option>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="batteryConnRemarks" value="${pocc.batteryConnRemarks }"/></td>
        </tr>
    </c:if>
    <!-- 逆变器 -->
    <tr>
        <th width="50%" colspan="2"> 逆变器 </th>
        <td>
            <select id="inverterCheckResult" name="inverterCheckResult">
                <option value="${pocc.inverterCheckResult }">${pocc.inverterCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.inverterCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="inverterRemarks" value="${pocc.inverterRemarks }"/></td>
    </tr>
    <c:if test="${psOtCheck.checkType eq 'QUARTER' or psOtCheck.checkType eq 'YEAR' }">
        <!-- 保险 -->
        <tr>
            <th width="50%" colspan="2">保险</th>
            <td>
                <select id="insuranceCheckResult" name="insuranceCheckResult">
                    <option value="${pocc.insuranceCheckResult }">${pocc.insuranceCheckResult.value }</option>
                    <c:forEach items="${checkresult}" var="vo">
                        <c:if test="${pocc.insuranceCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="insuranceRemarks"  value="${pocc.insuranceRemarks }"/></td>
        </tr>
        <!-- 设备清洁/除尘 -->
        <tr>
            <th width="50%" colspan="2">设备清洁/除尘</th>
            <td>
                <select id="ecCheckResult" name="ecCheckResult">
                    <option value="${pocc.ecCheckResult }">${pocc.ecCheckResult.value }</option>
                    <c:forEach items="${contentCheckResult}" var="vo">
                        <c:if test="${pocc.ecCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="ecRemarks" value="${pocc.ecRemarks }"/></td>
        </tr>
    </c:if>
    </c:forEach>
</table>
<div class="boxbtn">
	<div class="btn">
		<a href="#none" id="submit">保存</a>
	</div>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>
