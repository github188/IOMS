<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td> 
	
	<td>${vo.bureau.value}</td>
	<td>${fn:escapeXml(vo.siteName)}</td>
	<td>${fn:escapeXml(vo.siteCode)}</td>
	<td>${fn:escapeXml(vo.type)}</td>
	<td>${fn:escapeXml(vo.info)}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['satellitesitemng_mod']}">
			<a href="${rootUrl }basedata/satellite/site/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:330}">修改</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['satellitesitemng_del']}">
			<a href="${rootUrl }basedata/satellite/site/del.do?id=${vo.id}"
				confirm_message="你确定要删除此卫星站点？" class="my_remove">删除</a>
		</sec:authorize></td>





</tr>
