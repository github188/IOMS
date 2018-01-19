<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES网管设备状态--更新</dd>
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
		<th scope="col">DPC组1备用</th>
		<th scope="col"><form:input path="dpc38"
				value="${slhequstate.dpc38 }" /></th>
		<th scope="col">DPC38</th>
		<th rowspan="6" scope="col">BBBB</th>
	</tr>
	<tr>
		<th scope="col">DPC组1备用</th>
		<th scope="col"><form:input path="dpc58"
				value="${slhequstate.dpc58 }" /></th>
		<th scope="col">DPC58</th>
	</tr>
	<tr>
		<th scope="col">NCC2（62）</th>
		<th scope="col"><c:choose>
				<c:when test="${slhequstate.NCC62 eq 'Online'}">
					<label> <input type="radio" name="NCC62" value="Online"
						checked="checked" /> online
					</label>

					<label> <input type="radio" name="NCC62" value="Offline" />
						offline
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="NCC62" value="Online" />
						online
					</label>

					<label> <input type="radio" name="NCC62" value="Offline"
						checked="checked" /> offline
					</label>
				</c:otherwise>
			</c:choose></th>
		<th rowspan="2" scope="col">Online OR Offline</th>
	</tr>
	<tr>
		<th scope="col">NCC2（63）</th>
		<th scope="col"><c:choose>
				<c:when test="${slhequstate.NCC63 eq 'Online'}">
					<label> <input type="radio" name="NCC63" value="Online"
						checked="checked" /> online
					</label>

					<label> <input type="radio" name="NCC63" value="Offline" />
						offline
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="NCC63" value="Online" />
						online
					</label>

					<label> <input type="radio" name="NCC63" value="Offline"
						checked="checked" /> offline
					</label>
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th scope="col">UMOD（上）</th>
		<th scope="col"><c:choose>
				<c:when test="${slhequstate.umodup eq 'L'}">
					<label> <input type="radio" name="umodup" value="L"
						checked="checked" /> L
					</label>

					<label> <input type="radio" name="umodup" value="R" />
						R
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="umodup" value="L" />
						L
					</label>

					<label> <input type="radio" name="umodup" value="R"
						checked="checked" /> R
					</label>
				</c:otherwise>
			</c:choose></th>
		<th rowspan="2" scope="col">L（主用） OR R （备用）</th>
	</tr>
	<tr>
		<th scope="col">UMOD（下）</th>
		<th scope="col"><c:choose>
				<c:when test="${slhequstate.umoddown eq 'L'}">
					<label> <input type="radio" name="umoddown" value="L"
						checked="checked" /> L
					</label>

					<label> <input type="radio" name="umoddown" value="R" />
						R
					</label>
				</c:when>
				<c:otherwise>
					<label> <input type="radio" name="umoddown" value="L" />
						L
					</label>

					<label> <input type="radio" name="umoddown" value="R"
						checked="checked" /> R
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
