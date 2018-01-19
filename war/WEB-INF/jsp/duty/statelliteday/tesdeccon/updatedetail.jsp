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
		<th scope="col">08a</th>
		<th scope="col"><c:choose>
				<c:when test="${deccon.decservercon08a eq 'NORMAL'}">
					<label> <input type="radio" name="decservercon08a"
						value="NORMAL" checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08a"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="decservercon08a"
						value="NORMAL" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08a"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></th>
		<th rowspan="3" scope="col">Console connected</th>
		<th rowspan="3" scope="col"><p>DEC</p>
			<p>Term中使用 connect 命令</p></th>
	</tr>
	<tr>
		<th scope="col">08b</th>
		<th scope="col"><c:choose>
				<c:when test="${deccon.decservercon08b eq 'NORMAL'}">
					<label> <input type="radio" name="decservercon08b"
						value="NORMAL" checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08b"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="decservercon08b"
						value="NORMAL" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08b"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">08c</th>
		<th scope="col"><c:choose>
				<c:when test="${deccon.decservercon08c eq 'NORMAL'}">
					<label> <input type="radio" name="decservercon08c"
						value="NORMAL" checked="checked" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08c"
						value="INNORMAL" /> 异常
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="decservercon08c"
						value="NORMAL" /> 正常
					</label>
					<label> <input type="radio" name="decservercon08c"
						value="INNORMAL" checked="checked" /> 异常
					</label>
				</c:otherwise>
			</c:choose></th>
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
