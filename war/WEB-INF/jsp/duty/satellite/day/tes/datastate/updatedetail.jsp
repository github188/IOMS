<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>
			<c:choose>
				<c:when test="${optType eq 'txjddatastate' }">通信基地</c:when>
			</c:choose>
			TES网管数据库状态--更新
		</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th scope="col">网管系统在线数据库为Caac0831</th>
		<th scope="col"><p>
				<c:choose>
					<c:when test="${vo.dataState eq 'normal'}">
						<label> <input type="radio" name="dataState"
							id="dataState" value="normal" checked="checked" /> 正常
						</label>
						<label> <input type="radio" name="dataState"
							id="dataState" value="unnormal" /> 异常
						</label>
					</c:when>
					<c:otherwise>
						<label> <input type="radio" name="dataState"
							id="dataState" value="normal" /> 正常
						</label>
						<label> <input type="radio" name="dataState"
							id="dataState" value="unnormal" checked="checked" /> 异常
						</label>
					</c:otherwise>
				</c:choose>
			</p></th>
		<th scope="col">数据库名称是否为Caac0831 如果是，表示数据库状态正常</th>
		<th scope="col">登陆TES网管工作站查看数据库名称</th>
	</tr>
	<tr>
		<td>审核备注</td>
		<td colspan="3">${vo.auditRemark}</td>
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
