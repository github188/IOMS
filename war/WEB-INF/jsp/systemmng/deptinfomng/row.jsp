
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.deptNumberOa}</td>
	<td>${vo.deptName}</td>
	
	<td>
	
	 	<a href="${rootUrl }systemmng/deptinfomng/mod.do?id=${vo.id}"
			class="my_edit  {boxwidth:700,boxheight:350}">修改</a>
		<a href="${rootUrl }systemmng/deptinfomng/del.do?id=${vo.id}"
		confirm_message="你确定要删除此用户？" class="my_remove">删除</a>
	  
	</td>
</tr>
