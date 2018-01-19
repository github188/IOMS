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
        <th width="25%">设备名称</th>
        <th width="75%" colspan="3">${psOtCheck.name }</th>
    </tr>
    <c:forEach items="${psOtCheck.psOtCheckContent }" var="pocc">
        <tr>
            <th width="25%">本月线路运行情况</th>
            <th width="75%" colspan="3">
                <textarea id="monthLrs" name="monthLrs" cols="150">${pocc.monthLrs }</textarea>
            </th>
        </tr>
        <tr>
            <th width="25%">本月新增线路情况</th>
            <th width="75%" colspan="3">
                <textarea id="monthLas" name="monthLas" cols="150">${pocc.monthLas }</textarea>
            </th>
        </tr>
        <tr>
            <th width="25%">本月删减线路情况</th>
            <th width="75%" colspan="3">
                <textarea id="monthLcs" name="monthLcs" cols="150">${pocc.monthLcs }</textarea>
            </th>
        </tr>
        <tr>
            <th width="25%">本月线路故障情况</th>
            <th width="75%" colspan="3">
                <textarea id="monthLfs" name="monthLfs" cols="150">${pocc.monthLfs }</textarea>
            </th>
        </tr>
            <tr>
            <th width="25%">本月线路割接情况</th>
            <th width="75%" colspan="3">
                <textarea id="monthLcsc" name="monthLcsc" cols="150">${pocc.monthLcsc }</textarea>
            </th>
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
