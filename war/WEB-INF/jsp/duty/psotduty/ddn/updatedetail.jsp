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
    <!-- 当前主用-->
    <tr>
        <th width="50%" colspan="2">当前主用</th>
        <td>
            <select id="cmuCheckResult" name="cmuCheckResult">
                <option value="${pocc.cmuCheckResult }">${pocc.cmuCheckResult.value }</option>
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'AMACHINE' or vo eq 'BMACHINE' }">
                        <c:if test="${pocc.cmuCheckResult.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cmuRemarks" value="${pocc.cmuRemarks }"/></td>
    </tr>
    <!-- A机主控板卡 -->
    <tr>
        <th width="25%" rowspan="13">前面板状态</th>
        <th width="25%">A机主控板卡</th>
        <td>
            <select id="mcbaCheckResult" name="mcbaCheckResult">
                <option value="${pocc.mcbaCheckResult }">${pocc.mcbaCheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.mcbaCheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="mcbaRemarks" value="${pocc.mcbaRemarks }"/></td>
    </tr>
    <!-- A机1号v.35板卡 -->
    <tr>
        <th width="25%">A机1号v.35板卡</th>
        <td>
            <select id="cba1CheckResult" name="cba1CheckResult">
                <option value="${pocc.cba1CheckResult }">${pocc.cba1CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cba1CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba1Remarks" value="${pocc.cba1Remarks }"/></td>
    </tr>
    <!-- A机2号v.35板卡 -->
    <tr>
        <th width="25%">A机2号v.35板卡</th>
        <td>
            <select id="cba2CheckResult" name="cba2CheckResult">
                <option value="${pocc.cba2CheckResult }">${pocc.cba2CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cba2CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba2Remarks" value="${pocc.cba2Remarks }"/></td>
    </tr>
    <!-- A机3号v.35板卡 -->
    <tr>
        <th width="25%">A机3号v.35板卡</th>
        <td>
            <select id="cba3CheckResult" name="cba3CheckResult">
                <option value="${pocc.cba3CheckResult }">${pocc.cba3CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cba3CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba3Remarks" value="${pocc.cba3Remarks }"/></td>
    </tr>
    <!-- A机E1板卡 -->
    <tr>
        <th width="25%">A机E1板卡</th>
        <td>
            <select id="cbae1CheckResult" name="cbae1CheckResult">
                <option value="${pocc.cbae1CheckResult }">${pocc.cbae1CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbae1CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbae1Remarks" value="${pocc.cbae1Remarks }"/></td>
    </tr>
    <!-- B机主控板卡 -->
    <tr>
        <th width="25%">B机主控板卡</th>
        <td>
            <select id="mcbbCheckResult" name="mcbbCheckResult">
                <option value="${pocc.mcbbCheckResult }">${pocc.mcbbCheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.mcbbCheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="mcbbRemarks" value="${pocc.mcbbRemarks }"/></td>
    </tr>
    <!-- B机1号v.35板卡 -->
    <tr>
        <th width="25%">B机1号v.35板卡</th>
        <td>
            <select id="cbb1v35CheckResult" name="cbb1v35CheckResult">
                <option value="${pocc.cbb1v35CheckResult }">${pocc.cbb1v35CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb1v35CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb1v35Remarks" value="${pocc.cbb1v35Remarks }"/></td>
    </tr>
    <!-- B机2号v.35板卡 -->
    <tr>
        <th width="25%">B机2号v.35板卡</th>
        <td>
            <select id="cbb2v35CheckResult" name="cbb2v35CheckResult">
                <option value="${pocc.cbb2v35CheckResult }">${pocc.cbb2v35CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb2v35CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb2v35Remarks" value="${pocc.cbb2v35Remarks }"/></td>
    </tr>
    <!-- B机3号v.35板卡 -->
    <tr>
        <th width="25%">B机3号v.35板卡</th>
        <td>
            <select id="cbb3v35CheckResult" name="cbb3v35CheckResult">
                <option value="${pocc.cbb3v35CheckResult }">${pocc.cbb3v35CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb3v35CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb3v35Remarks" value="${pocc.cbb3v35Remarks }"/></td>
    </tr>
    <!-- B机1号v.24板卡-->
    <tr>
        <th width="25%">B机1号v.24板卡</th>
        <td>
            <select id="cbb1v24CheckResult" name="cbb1v24CheckResult">
                <option value="${pocc.cbb1v24CheckResult }">${pocc.cbb1v24CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb1v24CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb1v24Remarks" value="${pocc.cbb1v24Remarks }"/></td>
    </tr>
    <!-- B机2号v.24板卡 -->
    <tr>
        <th width="25%">B机2号v.24板卡</th>
        <td>
            <select id="cbb2v24CheckResult" name="cbb2v24CheckResult">
                <option value="${pocc.cbb2v24CheckResult }">${pocc.cbb2v24CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb2v24CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb2v24Remarks" value="${pocc.cbb2v24Remarks }"/></td>
    </tr>
    <!-- B机3号v.24板卡 -->
    <tr>
        <th width="25%">B机3号v.24板卡</th>
        <td>
            <select id="cbb3v24CheckResult" name="cbb3v24CheckResult">
                <option value="${pocc.cbb3v24CheckResult }">${pocc.cbb3v24CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbb3v24CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb3v24Remarks" value="${pocc.cbb3v24Remarks }"/></td>
    </tr>
    <!-- B机E1板卡 -->
    <tr>
        <th width="25%">B机E1板卡 </th>
        <td>
            <select id="cbbe1CheckResult" name="cbbe1CheckResult">
                <option value="${pocc.cbbe1CheckResult }">${pocc.cbbe1CheckResult.value }</option>
                <c:forEach items="${checkresult }" var="vo">
                    <c:if test="${pocc.cbbe1CheckResult.value != vo.value }">
                        <option value="${vo }">${vo.value }</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbbe1Remarks" value="${pocc.cbbe1Remarks }"/></td>
    </tr>
    <!-- V.35接口连接 -->
    <tr>
        <th width="25%" rowspan="2"> 后面板状态</th>
        <th width="25%">V.35接口连接</th>
        <td>
            <select id="v35icCheckResult" name="v35icCheckResult">
                <option value="${pocc.v35icCheckResult }">${pocc.v35icCheckResult.value }</option>
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <c:if test="${pocc.v35icCheckResult.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="v35icRemarks" value="${pocc.v35icRemarks }"/></td>
    </tr>
    <!-- V.24接口连接 -->
    <tr>
        <th width="25%">V.24接口连接 </th>
        <td>
            <select id="v24icCheckResult" name="v24icCheckResult">
                <option value="${pocc.v24icCheckResult }">${pocc.v24icCheckResult.value }</option>
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <c:if test="${pocc.v24icCheckResult.value != vo.value }">
                            <option value="${vo }">${vo.value }</option>
                        </c:if>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="v24icRemarks"  value="${pocc.v24icRemarks }"/></td>
    </tr>
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
