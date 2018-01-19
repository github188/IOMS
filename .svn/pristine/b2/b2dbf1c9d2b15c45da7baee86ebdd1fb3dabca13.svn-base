<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
            <c:if test="${checkType eq 'MONTH' }">
            <dd>传输设备与通讯线路月检--添加</dd>
            </c:if>
            <c:if test="${checkType eq 'QUARTER' }">
            <dd>传输设备与通讯线路季检--添加</dd>
            </c:if>
            <c:if test="${checkType eq 'YEAR' }">
            <dd>传输设备与通讯线路年检--添加</dd>
            </c:if>
	</dl>
</div>
<table width="100%">
	<tr>
		<th width="50%" colspan="2">设备名称</th>
		<th width="50%" colspan="2">
			<form:select path="name" cssStyle="width:200px">
				<c:forEach items="${zjOticalName}" var="vo">
					<option value="${vo.value}">${vo.value}</option>
				</c:forEach>
			</form:select>
		</th>
	</tr>
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
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="eoeFanRemarks"/></td>
    </tr>
    <!-- 温度 -->
    <tr>
        <th width="25%">温度</th>
        <td><form:input path="eoeTemCheckResult"/></td>
        <td><form:input path="eoeTemRemarks"/></td>
    </tr>
    <!-- 湿度 -->
    <tr>
        <th width="25%">湿度</th>
        <td><form:input path="eoeHumCheckResult"/></td>
        <td><form:input path="eoeHumRemarks"/></td>
    </tr>
    <!-- 设备指示灯状态 -->
    <tr>
        <th width="50%" colspan="2">设备指示灯状态</th>
        <td>
            <select id="disCheckResult" name="disCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="disRemarks"/></td>
    </tr>
    <!-- 板卡运行状态 -->
    <tr>
        <th width="50%" colspan="2">板卡运行状态</th>
        <td>
            <select id="crsCheckResult" name="crsCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="crsRemarks"/></td>
    </tr>
    <!-- 设备线缆连接 -->
    <tr>
        <th width="50%" colspan="2">设备线缆连接</th>
        <td>
            <select id="dlccCheckResult" name="dlccCheckResult">
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="dlccRemarks"/></td>
    </tr>
    <!-- 电源供电连接 -->
    <tr>
        <th width="50%" colspan="2">电源供电连接</th>
        <td>
            <select id="pscCheckResult" name="pscCheckResult">
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="pscRemarks"/></td>
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