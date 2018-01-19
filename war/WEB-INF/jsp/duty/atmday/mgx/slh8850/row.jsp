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
    <!------------- 与网控中心8830节点的连通性------------>
    <td><c:choose>
            <c:when test="${vo.wkzx8830_con eq 'UNNORMAL'}">
                <font>${vo.wkzx8830_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.wkzx8830_con.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 通信基地8850------------->
    <td><c:choose>
            <c:when test="${vo.txjd8850_con eq 'UNNORMAL'}">
                <font>${vo.txjd8850_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.txjd8850_con.value}
                    </c:otherwise>
        </c:choose></td>
        <!-------------民航局空管局------------->
    <td><c:choose>
            <c:when test="${vo.mhj_con eq 'UNNORMAL'}">
                <font>${vo.mhj_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.mhj_con.value}
                    </c:otherwise>
        </c:choose></td>
        <!-------------首都机场------------->
    <td><c:choose>
            <c:when test="${vo.capital_con eq 'UNNORMAL'}">
                <font>${vo.capital_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.capital_con.value}
                    </c:otherwise>
        </c:choose></td>
             
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
            ifAnyGranted="${jspAuthorities['atm_check_slh_view']}">
            <a class="my_edit {boxwidth:1000,boxheight:700}"
                href="${rootUrl}duty/atmday/mgx/txjd8850/view.do?id=${vo.id}&tabType=SLH_8850">查看</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_slh_update']}">
            <a href="${rootUrl}duty/atmday/mgx/update.do?id=${vo.id}&tabType=SLH_8850"
                class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_slh_audit']}">
            <c:if
                test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
                <a class="my_edit {boxwidth:1000,boxheight:700}"
                    href="${rootUrl}duty/atmday/mgx/audit.do?id=${vo.id}&tabType=SLH_8850">审核</a>
            </c:if>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_slh_del']}">
            <a href="${rootUrl}duty/atmday/mgx/delete.do?id=${vo.id}&tabType=SLH_8850"
                id="removeRecord" confirm_message="你确定要删除此记录？"
                class="my_remove">删除</a>
        </sec:authorize></td>
</tr>