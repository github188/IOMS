<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES DecServer 连通性</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="3" scope="col">DECServer工作状态连通性</th>
		<th scope="col">08A</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08A eq 'normal'}">
					<input type="radio" name="decServerCon08A" value="normal"
						checked="checked" /> 正常
					 <input type="radio" name="decServerCon08A" value="unnormal" /> 异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="decServerCon08A" value="normal" /> 正常
					 <input type="radio" name="decServerCon08A" value="unnormal"
						checked="checked" /> 异常
				</c:otherwise>
			</c:choose></th>
		<th rowspan="3" scope="col">Console connected</th>
		<th rowspan="3" scope="col"><p>DEC</p>
			<p>Term中使用 connect 命令</p></th>
	</tr>
	<tr>
		<th scope="col">08B</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08B eq 'normal'}">
					<input type="radio" name="decServerCon08B" value="normal"
						checked="checked" /> 正常
					 <input type="radio" name="decServerCon08B" value="unnormal" /> 异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="decServerCon08B" value="normal" /> 正常
					 <input type="radio" name="decServerCon08B" value="unnormal"
						checked="checked" /> 异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">08C</th>
		<th scope="col"><c:choose>
				<c:when test="${vo.decServerCon08C eq 'normal'}">
					<input type="radio" name="decServerCon08C" value="normal"
						checked="checked" /> 正常
					 <input type="radio" name="decServerCon08C" value="unnormal" /> 异常
				</c:when>
				<c:otherwise>
					<input type="radio" name="decServerCon08C" value="normal" /> 正常
					 <input type="radio" name="decServerCon08C" value="unnormal"
						checked="checked" /> 异常
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<td>审核备注</td>
		<td colspan="4">${vo.auditRemark}</td>
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
