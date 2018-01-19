<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
    <td style="display:none"><input type="hidden" name="sid"
		value="${vo.id}" /></td>	
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.serviceType}</td>
	<td class="tdbtn">
		<sec:authorize
			ifAnyGranted="${jspAuthorities['atmtypemng_mod']}">
			<a href="${rootUrl }basedata/atm/type/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:330}">修改</a>
		</sec:authorize>
		<sec:authorize
			ifAnyGranted="${jspAuthorities['atmtypemng_del']}">
			<a href="${rootUrl }basedata/atm/type/del.do?id=${vo.id}" id="del"
		       onclick="changeEquip('${vo.id}')" class="my_remove">删除</a>
		</sec:authorize></td>
</tr>