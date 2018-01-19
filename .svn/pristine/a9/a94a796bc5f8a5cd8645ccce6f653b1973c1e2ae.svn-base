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
    <!-- 地下一层电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">地下一层电话线路、数据线路配线线架</th>
        <td>
            <select id="underTlDlwrCheckResult" name="underTlDlwrCheckResult">
                <option value="${pocc.underTlDlwrCheckResult }">${pocc.underTlDlwrCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.underTlDlwrCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="underTlDlwrRemarks" value="${pocc.underTlDlwrRemarks }"/></td>
    </tr>
    <!-- 一楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">一楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ffTlDlwrCheckResult" name="ffTlDlwrCheckResult">
                <option value="${pocc.ffTlDlwrCheckResult }">${pocc.ffTlDlwrCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.ffTlDlwrCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ffTlDlwrRemarks" value="${pocc.ffTlDlwrRemarks }"/></td>
    </tr>
    <!-- 二楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">二楼电话线路、数据线路配线线架</th>
        <td>
            <select id="fsTlDlwrCheckResult" name="fsTlDlwrCheckResult">
                <option value="${pocc.fsTlDlwrCheckResult }">${pocc.fsTlDlwrCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.fsTlDlwrCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="fsTlDlwrRemarks" value="${pocc.fsTlDlwrRemarks }"/></td>
    </tr>
    <!-- 3楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">三楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ftTlDlwrCheckResult" name="ftTlDlwrCheckResult">
                <option value="${pocc.ftTlDlwrCheckResult }">${pocc.ftTlDlwrCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.ftTlDlwrCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ftTlDlwrRemarks" value="${pocc.ftTlDlwrRemarks }"/></td>
    </tr>
    <!-- 4楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">四楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ffoTlDlwrCheckResult" name="ffoTlDlwrCheckResult">
                <option value="${pocc.ffoTlDlwrCheckResult }">${pocc.ffoTlDlwrCheckResult.value }</option>
                <c:forEach items="${checkresult}" var="vo">
                    <c:if test="${pocc.ffoTlDlwrCheckResult.value != vo.value }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ffoTlDlwrRemarks" value="${pocc.ffoTlDlwrRemarks }"/></td>
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
