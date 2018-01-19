<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.equip.name}</td>
<%-- 	<td>${vo.equip.type.name}</td> --%>
	<td>${vo.satelliteSite.siteName}</td>
	<td>${vo.satelliteSite.bureau.value}</td>
	<td>${vo.alarmInfo}</td>
	<td><fmt:formatDate value="${vo.createTime}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.updateInfo}</td>
	<td><fmt:formatDate value="${vo.updateAlarmDate}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td><a href="${rootUrl }faultmng/addFaultAlarm.do?id=${vo.id}"
		class="my_add {boxwidth:750,boxheight:450}">确认任务</a></td>
</tr>
