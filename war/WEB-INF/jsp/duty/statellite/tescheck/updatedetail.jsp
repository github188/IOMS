<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管系统检查--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="4" scope="col">北京网控中心TES站网管系统检查</th>
	</tr>
	<tr>
		<th width="26%" scope="row">序号</th>
		<td width="29%">检查内容</td>
		<td width="20%">结果记录</td>
		<td width="25%">备注</td>
	</tr>
	<tr>
		<th scope="row">1</th>
		<td>主用网管工作站切换广州</td>
		<td><c:choose>
				<c:when test="${vo.recordGz eq 'NORMAL'}">
					<label> <input type="radio" name="recordGz" value="NORMAL"
						checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="recordGz"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="recordGz" value="NORMAL" />
						正常
					</label>
					<label> <input type="radio" name="recordGz"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></td>
		<td><form:input path="recordGzBz" value="${vo.recordGzBz }" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td>网管工作站本地手动切换</td>
		<td><c:choose>
				<c:when test="${vo.recordManual eq 'NORMAL'}">
					<label> <input type="radio" name="recordManual"
						value="NORMAL" checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="recordManual"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="recordManual"
						value="NORMAL" /> 正常
					</label>
					<label> <input type="radio" name="recordManual"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></td>
		<td><form:input path="recordManualBz"
				value="${vo.recordManualBz }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td>网管工作站切回北京</td>
		<td><c:choose>
				<c:when test="${vo.recordBj eq 'NORMAL'}">
					<label> <input type="radio" name="recordBj" value="NORMAL"
						checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="recordBj"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="recordBj" value="NORMAL" />
						正常
					</label>
					<label> <input type="radio" name="recordBj"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></td>
		<td><form:input path="recordBjBz" value="${vo.recordBjBz }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td>网管工作站备份情况</td>
		<td><form:input path="recordBf" value="${vo.recordBf }" /></td>
		<td><form:input path="recordBfBz" value="${vo.recordBfBz }" /></td>
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
