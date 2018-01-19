<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地境外站主站华为路由器状态巡检--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="2">设备名称</th>
		<th colspan="2">通信基地境外站主站华为路由器</th>
	</tr>
	<tr>
		<th width="25%" rowspan="9">巡检内容</th>
		<th width="25%" rowspan="3">AR2240设备状态</th>
		<th width="25%">CPU利用率</th>
		<th width="25%"><input type="text" name="cpuResult"
			id="cpuResult" value="${vo.cpuResult }" /></th>
	</tr>

	<tr>
		<th width="25%">加德满都中继端口状态</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.jdmdPortResult eq 'up' }">
					<input type="radio" name="jdmdPortResult" id="jdmdPortResult"
						value="up" checked="checked" />正常 <input type="radio"
						name="jdmdPortResult" id="jdmdPortResult" value="down" />异常
		
		</c:when>
				<c:when test="${vo.jdmdPortResult eq 'down' }">
					<input type="radio" name="jdmdPortResult" id="jdmdPortResult"
						value="up" />正常 <input type="radio" name="jdmdPortResult"
						id="jdmdPortResult" value="down" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="jdmdPortResult" id="jdmdPortResult"
						value="up" />正常<input type="radio" name="jdmdPortResult"
						id="jdmdPortResult" value="down" />异常
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="25%">仰光中继端口状态</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.ygPortResult eq 'up' }">
					<input type="radio" name="ygPortResult" id="ygPortResult"
						value="up" checked="checked" />正常 <input type="radio"
						name="ygPortResult" id="ygPortResult" value="down" />异常
		
		</c:when>
				<c:when test="${vo.ygPortResult eq 'down' }">
					<input type="radio" name="ygPortResult" id="ygPortResult"
						value="up" />正常 <input type="radio" name="ygPortResult"
						id="ygPortResult" value="down" checked="checked" />异常
		</c:when>
				<c:otherwise>
					<input type="radio" name="ygPortResult" id="ygPortResult"
						value="up" />正常<input type="radio" name="ygPortResult"
						id="ygPortResult" value="down" />异常
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="25%" rowspan="2">AR2240-异步转报TCP状态</th>
		<th width="25%">尼泊尔</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.nbePortResult eq 'online' }">
					<input type="radio" name="nbePortResult" id="nbePortResult"
						value="online" checked="checked" />正常存在 <input type="radio"
						name="nbePortResult" id="nbePortResult" value="offline" />TCP连接消失
		
		</c:when>
				<c:when test="${vo.nbePortResult eq 'offline' }">
					<input type="radio" name="nbePortResult" id="nbePortResult"
						value="online" />正常存在 <input type="radio" name="nbePortResult"
						id="nbePortResult" value="offline" checked="checked" />TCP连接消失
		</c:when>
				<c:otherwise>
					<input type="radio" name="nbePortResult" id="nbePortResult"
						value="online" />正常存在<input type="radio" name="nbePortResult"
						id="nbePortResult" value="offline" />TCP连接消失
				</c:otherwise>
			</c:choose></th>
	</tr>
	<tr>
		<th width="25%">仰光</th>
		<th width="25%"><c:choose>
				<c:when test="${vo.ygResult eq 'online' }">
					<input type="radio" name="ygResult" id="ygResult" value="online"
						checked="checked" />正常存在 <input type="radio" name="ygResult"
						id="ygResult" value="offline" />TCP连接消失
		
		</c:when>
				<c:when test="${vo.ygResult eq 'offline' }">
					<input type="radio" name="ygResult" id="ygResult" value="online" />正常存在 <input
						type="radio" name="ygResult" id="ygResult" value="offline"
						checked="checked" />TCP连接消失
		</c:when>
				<c:otherwise>
					<input type="radio" name="ygResult" id="ygResult" value="online" />正常存在<input
						type="radio" name="ygResult" id="ygResult" value="offline" />TCP连接消失
				</c:otherwise>
			</c:choose></th>
	</tr>

	<tr>
		<th width="25%" rowspan="4">AR2240-话音状态(LoopBack地址)</th>
		<th width="25%">加德满都</th>
		<th width="25%"><input type="text" name="jdmdAddrResult"
			id="jdmdAddrResult" value="${vo.jdmdAddrResult }" /></th>
	</tr>
	<tr>
		<th width="25%">仰光</th>
		<th width="25%"><input type="text" name="ygAddrResult"
			id="ygAddrResult" value="${vo.ygAddrResult }" /></th>
	</tr>
	<tr>
		<th width="25%">昆明</th>
		<th width="25%"><input type="text" name="kmAddrResult"
			id="kmAddrResult" value="${vo.kmAddrResult }" /></th>
	</tr>
	<tr>
		<th width="25%">拉萨</th>
		<th width="25%"><input type="text" name="laAddrResult"
			id="laAddrResult" value="${vo.laAddrResult }" /></th>
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
