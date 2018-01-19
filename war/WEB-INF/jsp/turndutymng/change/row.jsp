
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${vo.userinfo.name}</td>
	<td>${vo.dutyRole.value}</td>
	<td>${vo.dutyPlace.value}</td>
	<td>${vo.dutyStatus.value}</td>
	<td>
		<fmt:formatDate value="${vo.signTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	    <c:if test="${vo.leaveTime!=null}">
	        <fmt:formatDate value="${vo.leaveTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	    </c:if>
	</td>
	<td>
	    <c:if test="${vo.dutyStatus!='LEAVE' && vo.userinfo.name==username}">
        <a href="#"
		confirm_message="您确定要离岗么？" class="" id="leave" onclick="onLeave('${vo.id}')">离岗</a>
     </c:if>
	</td> 
</tr>
<script type="text/javascript">
function onLeave(id){
	var agentNo=$("#agent").val();
	if(agentNo!="0"){
		var url="http://120.27.133.149/app?Action=SignOut&Account=N00000005689&Exten="+agentNo+"&PBX=bj.ali.3.7";
	    $.get(url,function(data,status){  
	    
	    });
	}
	$.ajax({
		type : "POST",
		url : "${rootUrl }turndutymng/change/leave.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			
			alert(data.msg);
			window.top.location.reload();
			$("action").attr("${rootUrl}turndutymng/change/manage.do");
			$("#listForm").submit();
		}
	});
}
</script>