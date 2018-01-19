<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES网管进程状态--更新</dd>
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
		<th scope="col">网管进程</th>
		<th scope="col"><c:choose>
				<c:when test="${prostate.process eq 'NORMAL'}">
					<label> <input type="radio" name="process" value="NORMAL"
						checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="process" value="INNORMAL" />
						异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="process" value="NORMAL" />
						正常
					</label>
					<label> <input type="radio" name="process" value="INNORMAL"
						checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></th>
		<th scope="col">ALL NCP PROCESSES ARE OPERATIONAL</th>
		<th scope="col">Check proc</th>
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
