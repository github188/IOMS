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
    <!-------------与十里河8850节点的连通性------------>
    <td><c:choose>
            <c:when test="${vo.slh8850_con eq 'UNNORMAL'}">
                <font>${vo.slh8850_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.slh8850_con.value}
                    </c:otherwise>
        </c:choose></td>
    <!------------- 中继连通状态 ------------->
    <td><c:choose>
            <c:when test="${vo.zj_con eq 'UNNORMAL'}">
                <font>${vo.zj_con.value}</font>
            </c:when>
            <c:otherwise>
                        ${vo.zj_con.value}
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
            ifAnyGranted="${jspAuthorities['atm_check_cf_view']}">
            <a class="my_edit {boxwidth:1000,boxheight:700}"
                href="${rootUrl}duty/atmday/mgx/txjd8850/view.do?id=${vo.id}&tabType=CFZX_8830">查看</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_cf_update']}">
            <a href="${rootUrl}duty/atmday/mgx/update.do?id=${vo.id}&tabType=CFZX_8830"
                class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_cf_audit']}">
            <c:if
                test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
                <a class="my_edit {boxwidth:1000,boxheight:700}"
                    href="${rootUrl}duty/atmday/mgx/audit.do?id=${vo.id}&tabType=CFZX_8830">审核</a>
            </c:if>
        </sec:authorize> <sec:authorize
            ifAnyGranted="${jspAuthorities['atm_check_cf_del']}">
            <a href="${rootUrl}duty/atmday/mgx/delete.do?id=${vo.id}&tabType=CFZX_8830"
                id="removeRecord" confirm_message="你确定要删除此记录？"
                class="my_remove">删除</a>
        </sec:authorize></td>
</tr>