<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
<td>${vo.maintainEquip.satelliteSite.bureau.value}</td>
<td>${vo.maintainEquip.satelliteSite.siteName}</td>
<td>${vo.maintainEquip.name}</td>
<td>${vo.maintainEquip.type.name}</td>
<td>${vo.equip.name }</td>
<td>
<fmt:formatDate value="${vo.createTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
</td> 

   <td><sec:authorize ifAnyGranted="${jspAuthorities['equipnode_del']}">
		<a href="${rootUrl }maintain/equipnode/del.do?id=${vo.id}"
			confirm_message="你确定要删除此已配置信息？" class="my_remove">删除</a>
	</sec:authorize></td>
</tr>
