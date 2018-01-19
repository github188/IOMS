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
				<c:forEach items="${pdsName}" var="vo">
                    <c:if test="${vo eq 'TXJDPDS' }">
					   <option value="${vo.value}">${vo.value}</option>
                    </c:if>
				</c:forEach>
			</form:select>
		</th>
	</tr>
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
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="underTlDlwrRemarks"/></td>
    </tr>
    <!-- 一楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">一楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ffTlDlwrCheckResult" name="ffTlDlwrCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ffTlDlwrRemarks"/></td>
    </tr>
    <!-- 二楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">二楼电话线路、数据线路配线线架</th>
        <td>
            <select id="fsTlDlwrCheckResult" name="fsTlDlwrCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="fsTlDlwrRemarks"/></td>
    </tr>
    <!-- 3楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">三楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ftTlDlwrCheckResult" name="ftTlDlwrCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ftTlDlwrRemarks"/></td>
    </tr>
    <!-- 4楼电话线路、数据线路配线线架 -->
    <tr>
        <th width="50%" colspan="2">四楼电话线路、数据线路配线线架</th>
        <td>
            <select id="ffoTlDlwrCheckResult" name="ffoTlDlwrCheckResult">
                <c:forEach items="${checkresult}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="ffoTlDlwrRemarks"/></td>
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