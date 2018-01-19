<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河PES网管设备状态</dd>
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
		<th scope="col"><form:input path="dpc38" /></th>
		<th scope="col">DPC38</th>
		<th rowspan="6" scope="col">BBBB</th>
	</tr>
	<tr>
		<th scope="col">DPC组1备用</th>
		<th scope="col"><form:input path="dpc58" /></th>
		<th scope="col">DPC58</th>
	</tr>
	<tr>
		<th scope="col">NCC2（62）</th>
		<th scope="col"><p>
				<label> <input type="radio" name="NCC62" value="Online"
					checked="checked" /> online
				</label> <label> <input type="radio" name="NCC62" value="Offline" />
					offline
				</label> <br />
			</p></th>
		<th rowspan="2" scope="col">Online OR Offline</th>
	</tr>
	<tr>
		<th scope="col">NCC2（63）</th>
		<th scope="col"><label> <input type="radio" name="NCC63"
				value="Online" checked="checked" /> online
		</label> <label> <input type="radio" name="NCC63" value="Offline" />
				offline
		</label></th>
	</tr>
	<tr>
		<th scope="col">UMOD（上）</th>
		<th scope="col"><p>
				<label> <input type="radio" name="umodup" value="L"
					checked="checked" /> L
				</label> <label> <input type="radio" name="umodup" value="R" /> R
				</label> <br />
			</p></th>
		<th rowspan="2" scope="col">L（主用） OR R （备用）</th>
	</tr>
	<tr>
		<th scope="col">UMOD（下）</th>
		<th scope="col"><label> <input type="radio"
				name="umoddown" value="L" checked="checked" /> L
		</label> <label> <input type="radio" name="umoddown" value="R" /> R
		</label> <br /></th>
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