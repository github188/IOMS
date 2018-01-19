<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<script type="text/javascript">
	/*
	 function doCount() {
	 var stime = $("#ringingTime1").val();
	 var etime = $("#pickupTime1").val();
	 var name = $('#optUser option:selected').val();
	 var type = $('#atnctype option:selected').val();
	 alert(name);
	 $.ajax({
	 url : "${rootUrl }phonemng/querymng/counttimes.do?starttime="
	 + stime + "&endtime=" + etime + "&username=" + name
	 + "&type=" + type,
	 type : "GET",//get请求
	 async : false,//同步加载数据
	 dataType : "",//返回json格式
	 success : function(data, status, xhr) {
	 alert("ok");
	 location.reload();
	 },
	 error : function(xmlHttpRequest, error) {
	 alert("失败");
	 }
	 });
	 }
	 */
</script>

<table width="100%" border="0" cellspacing="0"
	cellpadding="0" class="table table-bordered">
	<tr>
		
			<th width="25%">
			   工程师姓名
			</th>
		    <th width="25%">
			 通话时间（秒）
			</th>
		<th width="25%">
			 通话时间（分钟）
			</th>
			<th width="25%">
			 通话类别
			</th>
	</tr>
	<tr>
	   <td width="25%">
	    <table width="100%" >
	      <c:forEach items="${callMap}" var="map1" varStatus="idx">
              <c:if test="${idx.index==2 }">
                   <c:forEach items="${map1.value}" var="mapchild1">
                     <tr>
                       <td style="height:35px;font-size:16px;border-bottom: 1px solid #9c9c9c;">
                          ${mapchild1}
                       </td>
                     </tr>
                   </c:forEach>
              </c:if>
              
            
	      </c:forEach>
	     </table>
	   </td>
	   <td width="25%">
	   <table width="100%" >
	      <c:forEach items="${callMap}" var="map1" varStatus="idx">
              <c:if test="${idx.index==0 }">
                   <c:forEach items="${map1.value}" var="mapchild1">
                     <tr>
                       <td style="height:35px;font-size:16px;border-bottom: 1px solid #9c9c9c;">
                          ${mapchild1}
                       </td>
                     </tr>
                   </c:forEach>
              </c:if>
              
            
	      </c:forEach>
	     </table>
	   </td>
	    <td width="25%">
	     <table width="100%" >
	      <c:forEach items="${callMap}" var="map1" varStatus="idx">
              <c:if test="${idx.index==3 }">
                   <c:forEach items="${map1.value}" var="mapchild1">
                     <tr>
                       <td style="height:35px;font-size:15px;border-bottom: 1px solid #9c9c9c;">
                          ${mapchild1}
                       </td>
                     </tr>
                   </c:forEach>
              </c:if>
              
            
	      </c:forEach>
	     </table>
	   </td>
	    <td width="25%">
	     <table width="100%" >
	      <c:forEach items="${callMap}" var="map1" varStatus="idx">
              <c:if test="${idx.index==1 }">
                   <c:forEach items="${map1.value}" var="mapchild1">
                     <tr>
                       <td style="height:35px;font-size:15px;border-bottom: 1px solid #9c9c9c;">
                          <c:if test="${mapchild1=='FAULT'}">
                                                                       故障
                          </c:if>
                          <c:if test="${mapchild1=='CONSULT'}">
                                                                       咨询
                          </c:if>
                          <c:if test="${mapchild1=='INSIDE'}">
                                                                       内部
                          </c:if>
                          <c:if test="${mapchild1=='LOOKFOR'}">
                                                                      找人
                          </c:if>
                          <c:if test="${mapchild1=='OTHER'}">
                                                                      其他
                          </c:if>
                       </td>
                     </tr>
                   </c:forEach>
              </c:if>
              
            
	      </c:forEach>
	     </table>
	   </td>
	</tr>
	<tr>
	  <td align="left" colspan="4">
	         总和：
	         <c:forEach items="${listAll}" var="ListAll" varStatus="idx">
	             ${ListAll}&nbsp;
	         </c:forEach>
	  </td>
	</tr>

</table>
