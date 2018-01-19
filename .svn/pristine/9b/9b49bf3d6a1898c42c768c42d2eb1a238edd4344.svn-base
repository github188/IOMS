<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>转报系统检查</dd>
	</dl>
</div>
<table width="100%">
	<tr>
		<th width="20%" rowspan="4"><font color="red">(*)</font>转报主机状态</th>
		<th width="20%" rowspan="2">A(192.168.11.1)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.hostAReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="hostAReduncdancy" name="hostAReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.hostAWork.value}
				</c:when>
				<c:otherwise>
					<select id="hostAWork" name="hostAWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="2">B(192.168.11.2)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.hostBReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="hostBReduncdancy" name="hostBReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.hostBWork.value}
				</c:when>
				<c:otherwise>
					<select id="hostBWork" name="hostBWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="5"><font color="red">(*)</font>同步接入器状态</th>
		<th width="20%" rowspan="2">A(192.168.11.8)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.synapAReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="synapAReduncdancy" name="synapAReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.synapAWork.value}
				</c:when>
				<c:otherwise>
					<select id="synapAWork" name="synapAWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="2">B(192.168.11.9)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.synapBReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="synapBReduncdancy" name="synapBReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.synapBWork.value}
				</c:when>
				<c:otherwise>
					<select id="synapBWork" name="synapBWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">同步进程(17个)</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.synProcess.value}
				</c:when>
				<c:otherwise>
					<select id="synProcess" name="synProcess">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="8"><font color="red">(*)</font>智能集中器状态</th>
		<th width="20%" rowspan="2">A(192.168.11.11)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collAReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="collAReduncdancy" name="collAReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collAWork.value}
				</c:when>
				<c:otherwise>
					<select id="collAWork" name="collAWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="2">B(192.168.11.12)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collBReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="collBReduncdancy" name="collBReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collBWork.value}
				</c:when>
				<c:otherwise>
					<select id="collBWork" name="collBWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="2">B(192.168.11.13)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collCReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="collCReduncdancy" name="collCReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collCWork.value}
				</c:when>
				<c:otherwise>
					<select id="collCWork" name="collCWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="2">B(192.168.11.14)</th>
		<th width="20%">冗余状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collDReduncdancy.value}
				</c:when>
				<c:otherwise>
					<select id="collDReduncdancy" name="collDReduncdancy">
						<c:forEach items="${reduncdancyStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%">工作状态</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.collDWork.value}
				</c:when>
				<c:otherwise>
					<select id="collDWork" name="collDWork">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="20%" rowspan="8"><font color="red">(*)</font>异步接入器状态</th>
		<th width="40%" colspan="2">接入器1</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp1.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp1" name="asyapAp1">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">接入器2</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp2.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp2" name="asyapAp2">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">接入器3</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp3.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp3" name="asyapAp3">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">接入器4</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp4.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp4" name="asyapAp4">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">接入器5</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp5.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp5" name="asyapAp5">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">接入器6</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapAp6.value}
				</c:when>
				<c:otherwise>
					<select id="asyapAp6" name="asyapAp6">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">串口通信进程(2个)</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapSpProcess.value}
				</c:when>
				<c:otherwise>
					<select id="asyapSpProcess" name="asyapSpProcess">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th width="40%" colspan="2">IP联接进程(1个)</th>
		<td width="30%">
			<c:choose>
				<c:when test="${not empty teleGraphSystem}">
					${teleGraphSystem.asyapIpProcess.value}
				</c:when>
				<c:otherwise>
					<select id="asyapIpProcess" name="asyapIpProcess">
						<c:forEach items="${workStatus}" var="vo">
							<option value="${vo}">${vo.value}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<c:if test="${not empty teleGraphSystem}">
		<tr>
			<th width="20%" rowspan="5"><font color="red">(*)</font>备注</th>
			<td colspan="3">
				<c:choose>
					<c:when test="${view}">
						${teleGraphSystem.remark}						
					</c:when>			
					<c:otherwise>
						<textarea id="remark" name="remark" rows="5" 
						style="width: 750px;" 
						placeholder="内容不能超过100个字"></textarea>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:if>
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