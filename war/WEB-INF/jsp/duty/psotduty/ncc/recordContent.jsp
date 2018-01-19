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
		<th width="25%">设备名称</th>
		<th width="75%" colspan="3">
			<form:select path="name" cssStyle="width:200px">
				<c:forEach items="${nccName}" var="vo">
					<option value="${vo.value}">${vo.value}</option>
				</c:forEach>
			</form:select>
		</th>
	</tr>
    <tr>
        <th width="25%">本月线路运行情况</th>
        <th width="75%" colspan="3">
            <textarea id="monthLrs" name="monthLrs" cols="150"></textarea>
        </th>
    </tr>
    <tr>
        <th width="25%">本月新增线路情况</th>
        <th width="75%" colspan="3">
            <textarea id="monthLas" name="monthLas" cols="150"></textarea>
        </th>
    </tr>
    <tr>
        <th width="25%">本月删减线路情况</th>
        <th width="75%" colspan="3">
            <textarea id="monthLcs" name="monthLcs" cols="150"></textarea>
        </th>
    </tr>
    <tr>
        <th width="25%">本月线路故障情况</th>
        <th width="75%" colspan="3">
            <textarea id="monthLfs" name="monthLfs" cols="150"></textarea>
        </th>
    </tr>
        <tr>
        <th width="25%">本月线路割接情况</th>
        <th width="75%" colspan="3">
            <textarea id="monthLcsc" name="monthLcsc" cols="150"></textarea>
        </th>
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