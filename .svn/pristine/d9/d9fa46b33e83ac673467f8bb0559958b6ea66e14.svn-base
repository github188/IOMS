
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${fn:escapeXml(vo.userinfo.name)}</td>
	<td>${vo.dutyRole.value}</td>
	<td>${vo.dutyPlace.value}</td>
	<td>${vo.dutyStatus.value}</td>
	<c:if test="${vo.spare3 =='LATE' }">
	   <td style="background-color:#be5051;color:#fff">
	   <fmt:formatDate value="${vo.signTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	   <span style="color:#ccc">+${vo.lateTime}</span>
	</c:if>
	<c:if test="${vo.spare3 !='LATE' }">
	   <td>
	   <fmt:formatDate value="${vo.signTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</c:if>
		
	</td>
	<td>
	    <c:if test="${vo.leaveTime!=null}">
	        <fmt:formatDate value="${vo.leaveTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	    </c:if>
	</td>
	<td>
	  <a href="${rootUrl }turndutymng/signleavemng/viewrecord.do?id=${vo.id}"
		class="my_edit  {boxwidth:700,boxheight:500}">交接班记录</a>
     <c:if test="${vo.dutyStatus!='LEAVE' && vo.userinfo.name==username}">
        <a href="#"
		confirm_message="您确定要离岗么？"  id="leave" onclick="onSignLeave('${vo.id}')">离岗</a>
     </c:if>
     <c:if test="${vo.dutyStatus!='LEAVE'}">
	     <c:if test="${ (isManager eq 'yes' and dutyplace eq vo.dutyPlace and vo.dutyRole ne 'DUTYMANAGER')}">
	       <a href="${rootUrl }turndutymng/change/mngleave.do?id=${vo.id}"
				class="my_edit  {boxwidth:700,boxheight:450}"
			confirm_message="您确定要离岗么？"  id="mngleave" >代离岗</a>
		 </c:if>
	 </c:if>
	 </td> 
	
</tr>
<script type="text/javascript">
function onSignLeave(id){
	
	var agentNo=$("#agent").val();
	if(agentNo!="0"){
		var url="http://120.27.133.149/app?Action=SignOut&Account=N00000005689&Exten="+agentNo+"&PBX=bj.ali.3.7";
	    $.get(url,function(data,status){  
	    
	    });
	}
	
	$.ajax({
		type : "POST",
		url : "${rootUrl }turndutymng/signleavemng/leave.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			alert(data.msg);
			$("action").attr("${rootUrl}turndutymng/manage.do");
			$("#listForm").submit();
			window.top.location.reload();
		}
	});s
}

</script>
