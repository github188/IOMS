<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<dd>维护总结月检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">
			<dd>维护总结季检--添加</dd>
		</c:if>
		<c:if test="${checkType eq 'YEAR' }">
			<dd>维护总结年检--添加</dd>
		</c:if>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th height="24" scope="col">问题处理过程及结果</th>
	</tr>
	<tr>
		<th height="107" scope="col"><form:textarea path="result"
				rows="3" cols="100" /></th>
	</tr>
	<tr>
		<th height="41" scope="col">意见建议</th>
	</tr>
	<tr>
		<th height="163" scope="row"><form:textarea path="opinion"
				rows="3" cols="100" /></th>
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