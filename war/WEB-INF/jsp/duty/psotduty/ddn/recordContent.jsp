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
				<c:forEach items="${ddnName}" var="vo">
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
    <!-- 当前主用-->
    <tr>
        <th width="50%" colspan="2">当前主用</th>
        <td>
            <select id="cmuCheckResult" name="cmuCheckResult">
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'AMACHINE' or vo eq 'BMACHINE' }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cmuRemarks"/></td>
    </tr>
    <!-- A机主控板卡 -->
    <tr>
        <th width="25%" rowspan="13">前面板状态</th>
        <th width="25%">A机主控板卡</th>
        <td>
            <select id="mcbaCheckResult" name="mcbaCheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="mcbaRemarks"/></td>
    </tr>
    <!-- A机1号v.35板卡 -->
    <tr>
        <th width="25%">A机1号v.35板卡</th>
        <td>
            <select id="cba1CheckResult" name="cba1CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba1Remarks"/></td>
    </tr>
    <!-- A机2号v.35板卡 -->
    <tr>
        <th width="25%">A机2号v.35板卡</th>
        <td>
            <select id="cba2CheckResult" name="cba2CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba2Remarks"/></td>
    </tr>
    <!-- A机3号v.35板卡 -->
    <tr>
        <th width="25%">A机3号v.35板卡</th>
        <td>
            <select id="cba3CheckResult" name="cba3CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cba3Remarks"/></td>
    </tr>
    <!-- A机E1板卡 -->
    <tr>
        <th width="25%">A机E1板卡</th>
        <td>
            <select id="cbae1CheckResult" name="cbae1CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbae1Remarks"/></td>
    </tr>
    <!-- B机主控板卡 -->
    <tr>
        <th width="25%">B机主控板卡</th>
        <td>
            <select id="mcbbCheckResult" name="mcbbCheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="mcbbRemarks"/></td>
    </tr>
    <!-- B机1号v.35板卡 -->
    <tr>
        <th width="25%">B机1号v.35板卡</th>
        <td>
            <select id="cbb1v35CheckResult" name="cbb1v35CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb1v35Remarks"/></td>
    </tr>
    <!-- B机2号v.35板卡 -->
    <tr>
        <th width="25%">B机2号v.35板卡</th>
        <td>
            <select id="cbb2v35CheckResult" name="cbb2v35CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb2v35Remarks"/></td>
    </tr>
    <!-- B机3号v.35板卡 -->
    <tr>
        <th width="25%">B机3号v.35板卡</th>
        <td>
            <select id="cbb3v35CheckResult" name="cbb3v35CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb3v35Remarks"/></td>
    </tr>
    <!-- B机1号v.24板卡-->
    <tr>
        <th width="25%">B机1号v.24板卡</th>
        <td>
            <select id="cbb1v24CheckResult" name="cbb1v24CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb1v24Remarks"/></td>
    </tr>
    <!-- B机2号v.24板卡 -->
    <tr>
        <th width="25%">B机2号v.24板卡</th>
        <td>
            <select id="cbb2v24CheckResult" name="cbb2v24CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb2v24Remarks"/></td>
    </tr>
    <!-- B机3号v.24板卡 -->
    <tr>
        <th width="25%">B机3号v.24板卡</th>
        <td>
            <select id="cbb3v24CheckResult" name="cbb3v24CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbb3v24Remarks"/></td>
    </tr>
    <!-- B机E1板卡 -->
    <tr>
        <th width="25%">B机E1板卡 </th>
        <td>
            <select id="cbbe1CheckResult" name="cbbe1CheckResult">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="cbbe1Remarks"/></td>
    </tr>
    <!-- V.35接口连接 -->
    <tr>
        <th width="25%" rowspan="2"> 后面板状态</th>
        <th width="25%">V.35接口连接</th>
        <td>
            <select id="v35icCheckResult" name="v35icCheckResult">
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="v35icRemarks"/></td>
    </tr>
    <!-- V.24接口连接 -->
    <tr>
        <th width="25%">V.24接口连接 </th>
        <td>
            <select id="v24icCheckResult" name="v24icCheckResult">
                <c:forEach items="${checkStatus}" var="vo">
                    <c:if test="${vo eq 'SOLID' or vo eq 'LOOSE' }">
                        <option value="${vo}">${vo.value}</option>
                    </c:if>
                </c:forEach>
            </select>
        </td>
        <td><form:input path="v24icRemarks"/></td>
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