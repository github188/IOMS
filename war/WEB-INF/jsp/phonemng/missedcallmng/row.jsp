
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	
	 <td>
       <input type="checkbox"
		onclick="checkActiveSelect(this)" name="activeCheck"
		id="activeCheck_${vo.id}" value="${vo.id}"  />
     </td>
	<td>
		<c:if test="${vo.isDel=='DEL'}">
		   <span class="label label-danger">${vo.isDel.value}</span>
		</c:if>
		<c:if test="${vo.isDel=='NOTDEL'}">
		   ${vo.isDel.value}
		</c:if>
	</td>
	
	<td>${vo.contactName}</td>
	<td>${vo.companyInfo}</td>
	<td>${vo.contactArea}</td>
	
	<td>
		<fmt:formatDate value="${vo.ringingTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.callonNumber}</td>
	
	<td>${vo.callonProvince}-${vo.callonCity}</td>
	
	<td>${vo.userName}</td>
	
	<td>
	<a href="#"
		confirm_message="你确定要删除此记录？" onclick="onDel('${vo.id}')">删除</a>
	</td>
</tr>
<script type="text/javascript">

//删除
function onDel(id){
	$.ajax({
		type : "POST",
		url : "${rootUrl }phonemng/missedcallmng/del.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			alert(data.msg);
			$("action").attr("${rootUrl}phonemng/missedcallmng/manage.do");
			$("#listForm").submit();
		}
	});
}
</script>
