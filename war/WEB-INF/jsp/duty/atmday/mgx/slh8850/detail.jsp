<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style>
<!--
	.tdWidth{
		width: 100%;
	}
-->
</style>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>十里河8850(${atmDayMgx.area.value})</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th width="10%" scope="col">序号</th>
		<th width="60%" colspan="2" scope="col">检查项目</th>
		<th width="30%" scope="col">状态结果</th>
	</tr>
	<tr>
		<th width="10%" rowspan="3" scope="row">1</th>
		<td rowspan="3">设备运行环境</td>
        <td width="10%" scope="row">风扇</td>
		<td><c:if test="${view eq 1 or audit eq 1}">
				${atmDayMgx.env_fan.value}
			</c:if> <c:if test="${view eq 0}">
				<select id="env_fan" name="env_fan">
					<option value="${atmDayMgx.env_fan }">${atmDayMgx.env_fan.value }</option>
					<c:forEach items="${statusResults}" var="vo">
						<c:if test="${atmDayMgx.env_fan.value != vo.value }">
							<option value="${vo}">${vo.value}</option>
						</c:if>
					</c:forEach>
				</select>
			</c:if></td>
	</tr>
    <tr>
         <td width="10%" scope="row">电源</td>
         <td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.env_power.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="env_power" name="env_power">
                    <option value="${atmDayMgx.env_power }">${atmDayMgx.env_power.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.env_power.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
    </tr>
    <tr>
         <td width="10%" scope="row">温度</td>
         <td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.env_temperatuer.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="env_temperatuer" name="env_temperatuer">
                    <option value="${atmDayMgx.env_temperatuer }">${atmDayMgx.env_temperatuer.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.env_temperatuer.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
    </tr>
	<tr>
		<th width="10%" scope="row">2</th>
        <td rowspan="4">与相邻节点连通性</td>
		<td>网控中心8830</td>
		<td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.wkzx8830_con.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="wkzx8830_con" name="wkzx8830_con">
                    <option value="${atmDayMgx.wkzx8830_con }">${atmDayMgx.wkzx8830_con.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.wkzx8830_con.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
	</tr>
    <tr>
        <th width="10%" scope="row">3</th>
        <td>通信基地8850</td>
        <td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.txjd8850_con.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="txjd8850_con" name="txjd8850_con">
                    <option value="${atmDayMgx.txjd8850_con }">${atmDayMgx.txjd8850_con.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.txjd8850_con.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
    </tr>
    <tr>
        <th width="10%" scope="row">3</th>
        <td>民航局空管局</td>
        <td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.mhj_con.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="mhj_con" name="mhj_con">
                    <option value="${atmDayMgx.mhj_con }">${atmDayMgx.mhj_con.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.mhj_con.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
    </tr>
    <tr>
        <th width="10%" scope="row">3</th>
        <td>首都机场</td>
        <td><c:if test="${view eq 1 or audit eq 1}">
                ${atmDayMgx.capital_con.value}
            </c:if> <c:if test="${view eq 0}">
                <select id="capital_con" name="capital_con">
                    <option value="${atmDayMgx.capital_con }">${atmDayMgx.capital_con.value }</option>
                    <c:forEach items="${statusResults}" var="vo">
                        <c:if test="${atmDayMgx.capital_con.value != vo.value }">
                            <option value="${vo}">${vo.value}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </c:if></td>
    </tr>
	<tr>
		<th scope="row">4</th>
		<td width="30%">备注</td>
		<td colspan="2"><c:if test="${view eq 1 or audit eq 1}">
				${atmDayMgx.remark}
			</c:if> <c:if test="${view eq 0}">
				<textarea id="slhbz" name="slhbz" rows="5" class="tdWidth" 
					placeholder="内容不能超过100个字">${atmDayMgx.remark}</textarea>
			</c:if></td>
	</tr>
	<c:if test="${view eq 1}">
		<tr>
			<th scope="row">5</th>
			<td width="30%">审核备注</td>
			<td colspan="2">${atmDayMgx.auditRemark}</td>

		</tr>
	</c:if>
	<c:if
		test="${vo.creater.name ne currentUser.name and empty vo.auditer and audit eq 1}">
		<tr>
			<th scope="row">5</th>
			<td width="30%">审核备注</td>
			<td colspan="2"><textarea id="auditRemark" name="auditRemark"
					rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>

		</tr>
	</c:if>
</table>
<div class="boxbtn">
	<c:if test="${view eq 0 or audit eq 1}">
		<div class="btn">
			<a href="#none" id="submit">保存</a>
		</div>
	</c:if>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>