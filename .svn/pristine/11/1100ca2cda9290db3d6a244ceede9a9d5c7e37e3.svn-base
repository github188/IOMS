<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES网管数据库状态--更新</dd>
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
					<c:when test="${datastate.datastate eq 'NORMAL'}">
						<label> <input type="radio" name="datastate"
							value="NORMAL" checked="checked" /> 正常
						</label>
						<label> <input type="radio" name="datastate"
							value="INNORMAL" /> 异常
						</label>
					</c:when>
					<c:otherwise>
						<label> <input type="radio" name="datastate"
							value="NORMAL" /> 正常
						</label>
						<label> <input type="radio" name="datastate"
							value="INNORMAL" checked="checked" /> 异常
						</label>
					</c:otherwise>
				</c:choose>
			</p></th>
		<th scope="col">数据库名称是否为Caac0831 如果是，表示数据库状态正常</th>
		<th scope="col">登陆TES网管工作站查看数据库名称</th>
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
