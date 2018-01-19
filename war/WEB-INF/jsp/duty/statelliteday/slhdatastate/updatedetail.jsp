<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES网管数据库状态--更新</dd>
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
		<th scope="col">在线数据库为ＡＴＭＢ</th>
		<th scope="col"><c:choose>
				<c:when test="${slhdatastate.atmb eq 'NORMAL'}">
					<label> <input type="radio" name="atmb" value="NORMAL"
						checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="atmb" value="INNORMAL" />
						异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="atmb" value="NORMAL" />
						正常
					</label>
					<label> <input type="radio" name="atmb" value="INNORMAL"
						checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></th>
		<th scope="col">数据库名称是否为ＡＴＭＢ如果是，表示数据库状态正常</th>
		<th scope="col"><p>登陆ＰＥＳ网管工作站查看数据库名称（每天三次）</p></th>
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
