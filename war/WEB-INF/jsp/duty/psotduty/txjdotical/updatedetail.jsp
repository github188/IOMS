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
    <c:if test="${psOtCheck.checkType eq 'QUARTER' }">
        <!-- 接地保护 -->
        <tr>
            <th width="50%" colspan="2">接地保护</th>
            <td>
                <select id="gpCheckResult" name="gpCheckResult">
                    <option value="${pocc.gpCheckResult }">${pocc.gpCheckResult.value }</option>
                    <c:forEach items="${checkresult}" var="vo">
                        <c:if test="${pocc.gpCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="gpRemarks"  value="${pocc.gpRemarks }"/></td>
        </tr>
        <!-- DDF、ODF架接头 -->
        <tr>
            <th width="50%" colspan="2">DDF、ODF架接头</th>
            <td>
                <select id="ddfOdfCheckResult" name="ddfOdfCheckResult">
                    <option value="${pocc.ddfOdfCheckResult }">${pocc.ddfOdfCheckResult.value }</option>
                    <c:forEach items="${checkStatus}" var="vo">
                        <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                            <c:if test="${pocc.ddfOdfCheckResult.value != vo.value }">
                                <option value="${vo}">${vo.value}</option>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="ddfOdfRemarks"  value="${pocc.ddfOdfRemarks }"/></td>
        </tr>
        <!-- 光缆使用情况 -->
        <tr>
            <th width="50%" colspan="2">光缆使用情况</th>
            <td>
                <select id="ocuCheckResult" name="ocuCheckResult">
                    <option value="${pocc.ocuCheckResult }">${pocc.ocuCheckResult.value }</option>
                    <c:forEach items="${checkStatus}" var="vo">
                        <c:if test="${vo eq 'FREE' or vo eq 'UNFREE' }">
                            <c:if test="${pocc.ocuCheckResult.value != vo.value }">
                                <option value="${vo}">${vo.value}</option>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="ocuRemarks"  value="${pocc.ocuRemarks }"/></td>
        </tr>
        <!-- 光纤标识 -->
        <tr>
            <th width="50%" colspan="2">光纤标识</th>
            <td>
                <select id="ofcCheckResult" name="ofcCheckResult">
                    <option value="${pocc.ofcCheckResult }">${pocc.ofcCheckResult.value }</option>
                    <c:forEach items="${checkStatus}" var="vo">
                        <c:if test="${vo eq 'COMPLETE' or vo eq 'UNPASTE' }">
                            <c:if test="${pocc.ofcCheckResult.value != vo.value }">
                                <option value="${vo}">${vo.value}</option>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="ofcRemarks"  value="${pocc.ofcRemarks }"/></td>
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
