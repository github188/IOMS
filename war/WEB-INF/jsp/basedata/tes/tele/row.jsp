<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr><td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td> 
	
	<td>${vo.phoneNum}</td>	
	<td>${vo.tesNode.equip.satellite.siteName}</td>
	<td>${vo.tesNode.equip.satellite.siteCode}</td>	
	<td>${vo.tesNode.tesNodeCode}</td>		
	<td>${vo.cu}</td>
	<td>${vo.info}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['testelemng_view']}">
			<a href="${rootUrl}basedata/tes/tele/view.do?id=${vo.id}"
				class="my_view {boxwidth:850,boxheight:230}">查看</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['testelemng_mod']}">
			<a href="${rootUrl }basedata/tes/tele/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:550,boxheight:330}">修改</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['testelemng_del']}">
			<a href="${rootUrl }basedata/tes/tele/del.do?id=${vo.id}"
				confirm_message="你确定要删除此节点？" class="my_remove">删除</a>
		</sec:authorize></td>
</tr>
