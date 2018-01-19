<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>

 <td>
       <input type="checkbox"
		onclick="checkActiveSelect(this)" name="activeCheck"
		id="activeCheck_${vo.id}" value="${vo.id}"  />
 </td>
 <td>${vo.contactName}</td>
 <td>${vo.companyInfo}</td>
 <td>${vo.telNumber}</td>
 <td>${vo.contactPlace}</td>
 <td>
      <c:if test="${vo.contactStatus=='BLACK'}">
          <img src="${rootUrl }images/img/not_validated_icon.png"></img>
      </c:if>
      <c:if test="${vo.isDel=='DEL'}">
          <img src="${rootUrl }images/img/del.png"></img>
      </c:if>
      <c:if test="${vo.contactStatus=='WHITE' && vo.isDel=='NOTDEL'}">
          <img src="${rootUrl }images/img/contact_icon.png"></img>
      </c:if>
     
 </td>
 <td>
    ${vo.phoneType.value}
 </td>
 <td>
      <c:if test="${vo.contactStatus=='BLACK'}">
        <input id="contactsid_${vo.id}" name="contactsid" style="display:none" value="${vo.id}"></input>
      <!-- ${rootUrl }phonemng/contactsmng/white.do?id=${vo.id} -->
          <a href="#" confirm_message="您确定将此用户从黑名单中撤销吗？" 
          id="reback" onclick="onReback('${vo.id}','${vo.telNumber}')">撤销</a>
      </c:if>
      <c:if test="${vo.isDel=='DEL'}">
      <a href="#"
		confirm_message="您确定将此用户解冻吗？" onclick="onNotDel('${vo.id}')">解冻</a>
      </c:if>
      <c:if test="${vo.contactStatus=='WHITE' && vo.isDel=='NOTDEL'}">
  
	 	<a href="${rootUrl }phonemng/contactsmng/mod.do?id=${vo.id}"
			class="my_edit  {boxwidth:700,boxheight:350}">修改</a>
		<a href="#"
		confirm_message="你确定要冻结此用户？" onclick="onDel('${vo.id}')">冻结</a>
	
	  </c:if>
 </td>
</tr>

<script type="text/javascript">
//撤销黑名单    
function onReback(id,tel){

	$.ajax({
		type : "POST",
		url : "${rootUrl }phonemng/contactsmng/white.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			var obj = jQuery.parseJSON('{"Account":"N00000005689","PBX":"bj.ali.3.7","BlackNum":"'+tel+'","Type":"0"}');
			var url="http://112.124.23.131:3000/service?action=saveBlackList&json="+obj+"";
			$.get(url,function(data,status){  
		      
		    }); 
			
			alert(data.msg);
			
			$("action").attr("${rootUrl}phonemng/contactsmng/manage.do");
			$("#listForm").submit();
		}
	});
}
//解冻
function onNotDel(id){
	$.ajax({
		type : "POST",
		url : "${rootUrl }phonemng/contactsmng/notdel.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			alert(data.msg);
			$("action").attr("${rootUrl}phonemng/contactsmng/manage.do");
			$("#listForm").submit();
		}
	});
}
//冻结
function onDel(id){
	$.ajax({
		type : "POST",
		url : "${rootUrl }phonemng/contactsmng/del.do?id="+id+"",
		dataType : "json",
		success : function(data, status, xhr) {
			alert(data.msg);
			$("action").attr("${rootUrl}phonemng/contactsmng/manage.do");
			$("#listForm").submit();
		}
	});
}
</script>