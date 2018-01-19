<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>东四民航局TES链路状态--更新</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th rowspan="12" width="25%">检查内容</th>
		<th rowspan="4" width="25%">1101</th>
		<th width="25%">1</th>
		<th width="25%"><input type="text" name="link1001A"
			id="link1001A" value="${vo.link1001A }" /></th>
	</tr>
	<tr>
		<th>2</th>
		<th><input type="text" name="link1001B" id="link1001B"
			value="${vo.link1001B }" /></th>
	</tr>
	<tr>
		<th>3</th>
		<th><input type="text" name="link1001C" id="link1001C"
			value="${vo.link1001C }" /></th>
	</tr>
	<tr>
		<th>4</th>
		<th><input type="text" name="link1001D" id="link1001D"
			value="${vo.link1001D }" /></th>
	</tr>

	<tr>
		<th rowspan="4" width="25%">1102</th>
		<th width="25%">1</th>
		<th width="25%"><input type="text" name="link1002A"
			id="link1002A" value="${vo.link1002A }" /></th>
	</tr>
	<tr>
		<th>2</th>
		<th><input type="text" name="link1002B" id="link1002B"
			value="${vo.link1002B }" /></th>
	</tr>
	<tr>
		<th>3</th>
		<th><input type="text" name="link1002C" id="link1002C"
			value="${vo.link1002C }" /></th>
	</tr>
	<tr>
		<th>4</th>
		<th><input type="text" name="link1002D" id="link1002D"
			value="${vo.link1002D }" /></th>
	</tr>

	<tr>
		<th rowspan="4" width="25%">1103</th>
		<th width="25%">1</th>
		<th width="25%"><input type="text" name="link1003A"
			id="link1003A" value="${vo.link1003A }" /></th>
	</tr>
	<tr>
		<th>2</th>
		<th><input type="text" name="link1003B" id="link1003B"
			value="${vo.link1003B }" /></th>
	</tr>
	<tr>
		<th>3</th>
		<th><input type="text" name="link1003C" id="link1003C"
			value="${vo.link1003C }" /></th>
	</tr>
	<tr>
		<th>4</th>
		<th><input type="text" name="link1003D" id="link1003D"
			value="${vo.link1003D }" /></th>
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
