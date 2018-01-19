<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
<!--
font {
    color: red;
    font-weight: bold;
}
-->
</style>
<tr>
    <td><fmt:formatDate value="${vo.recordTime}" type="both"
            pattern="yyyy-MM-dd HH:mm" /></td>
    <!-------------设备运行环境 ------------>
    <!------------- 风扇 ------------>
    <td><c:choose>
            <c:when test="${vo.env_fan eq 'UNNORMAL'}">
                <font>${vo.env_fan.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.env_fan.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 电源 ------------>
    <td><c:choose>
            <c:when test="${vo.env_power eq 'UNNORMAL'}">
                <font>${vo.env_power.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.env_power.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 温度 ------------>
    <td><c:choose>
            <c:when test="${vo.env_temperatuer eq 'UNNORMAL'}">
                <font>${vo.env_temperatuer.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.env_temperatuer.value}
                    </c:otherwise>
        </c:choose></td>

    <!-- 连通性检查-->
    <!------------- 与十里河8850节点的连通性------------>
    <td><c:choose>
            <c:when test="${vo.slh8850_con eq 'UNNORMAL'}">
                <font>${vo.slh8850_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.slh8850_con.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 与通信基地8830节点的连通性源 ------------->
    <td><c:choose>
            <c:when test="${vo.txjd8830_con eq 'UNNORMAL'}">
                <font>${vo.txjd8830_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.txjd8830_con.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 民航局空管局连通性 ------------>
    <td><c:choose>
            <c:when test="${vo.mhj_con eq 'UNNORMAL'}">
                <font>${vo.mhj_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.mhj_con.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 首都机场连通性 ------------->
    <td><c:choose>
            <c:when test="${vo.capital_con eq 'UNNORMAL'}">
                <font>${vo.capital_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.capital_con.value}
                    </c:otherwise>
        </c:choose></td>

    <!-------------城市------------->
    <c:forEach items="${vo.atmDaySons}" var="atmDaySon">
        <td><c:choose>
                <c:when test="${atmDaySon.conResult eq 'UNNORMAL'}">
                    <font>${atmDaySon.conResult.value }</font>
                </c:when>
                <c:otherwise>
                        ${atmDaySon.conResult.value }
                    </c:otherwise>
            </c:choose></td>
    </c:forEach>

    <!------------- 操作人及时间 ------------>
    <td>${vo.creater.name }<br /> <fmt:formatDate
            value="${vo.recordTime}" type="both"
            pattern="yyyy-MM-dd HH:mm" />
    </td>
    <td>${vo.auditer.name }<br /> <fmt:formatDate
            value="${vo.auditTime}" type="both"
            pattern="yyyy-MM-dd HH:mm" /></td>
    <!-- 其他信息 -->
    <td><sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_mgx_view']}">
            <a class="my_edit {boxwidth:1000,boxheight:700}"
                href="${rootUrl}duty/atmday/mgx/txjd8850/view.do?id=${vo.id}&tabType=TXJD_8850">查看</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_mgx_update']}">
            <a href="${rootUrl}duty/atmday/mgx/update.do?id=${vo.id}&tabType=TXJD_8850"
                class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_mgx_audit']}">
            <c:if
                test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
                <a class="my_edit {boxwidth:1000,boxheight:700}"
                    href="${rootUrl}duty/atmday/mgx/audit.do?id=${vo.id}&tabType=TXJD_8850">审核</a>
            </c:if>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_mgx_del']}">
            <a href="${rootUrl}duty/atmday/mgx/delete.do?id=${vo.id}&tabType=TXJD_8850"
                id="removeRecord" confirm_message="你确定要删除此记录？"
                class="my_remove">删除</a>
        </sec:authorize></td>
</tr>