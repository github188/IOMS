<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>维护总结--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th height="24" scope="col">问题处理过程及结果</th>
	</tr>
	<tr>
		<th height="107" scope="col"><textarea id="result" name="result"
				rows="3" cols="100">${vo.result }</textarea></th>
	</tr>
	<tr>
		<th height="41" scope="col">意见建议</th>
	</tr>
	<tr>
		<th height="163" scope="row"><textarea id="opinion"
				name="opinion" rows="3" cols="100">${vo.opinion }</textarea></th>
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
