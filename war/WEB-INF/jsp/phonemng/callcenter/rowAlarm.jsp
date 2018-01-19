<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voAlarm.equip.name}</td>
	<td>${voAlarm.equip.type.name}</td>
	<td>${voAlarm.equip.satelliteSite.siteName}</td>
	<td>${voAlarm.equip.satelliteSite.bureau.value}</td>
	<td>${voAlarm.alarmInfo}</td>
	<td><fmt:formatDate value="${voAlarm.createTime}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td><a href="${rootUrl }faultmng/addFaultAlarm.do?id=${voAlarm.id}"
		class="my_add {boxwidth:750,boxheight:450}">确认任务</a></td>
</tr>
