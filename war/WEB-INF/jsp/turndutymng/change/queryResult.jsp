<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>


<div class="bclear"></div>
<div class="mtab">
<c:if test="${isflag=='ON' }">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="title" id="title1">
		<tr>
			<td class="td1"><img src="${rootUrl}images/pl1.gif"
				alt="" />签到/离岗
				[<fmt:formatDate value="${startdate}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />至
				 <fmt:formatDate value="${enddate}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />]</td>
			<td class="td2" id="noteInfo"></td>
		</tr>
	</table>
	</c:if>
</div>
 <c:if test="${isflag=='ON' }">

   <table id="dataTable2" width="100%" border="0" cellspacing="0" style="word-break:break-all; word-wrap:break-word;"
	cellpadding="2" class="table table-bordered">
	<thead>
	<tr>
												
		<th width="12%">值班人</th>
		<th width="12%">值班角色</th>
		<th width="12%">值班地点</th>
		<th width="20%">状态</th>
		<th width="15%">签到时间</th>
		<th width="15%">离岗时间</th>
		<th width="14%">操作</th>
	</tr>
    </thead>
	<tbody>
		<c:forEach items="${lists}" var="vo" >
		  <%@ include file="row.jsp"%>
		
		</c:forEach>
	</tbody>
</table>
</c:if>	

<div class="bclear"></div>
<div class="mtab">
<c:if test="${isflag=='ON' }">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="title" id="title2">
		<tr>
			<td class="td1"><img src="${rootUrl}images/pl1.gif"
				alt="" />交接班记录</td>
			<td class="td2" id="noteInfo1"></td>
		</tr>
	</table>

</c:if>	
	
</div>
<c:if test="${isflag=='ON' }">
<table id="dataTable" width="100%" border="0" cellspacing="0" style="word-break:break-all; word-wrap:break-word;"
	cellpadding="2" class="table table-bordered">
	<thead>
    <tr>
		
		<th width="12%">值班人</th>
		<th width="12%">值班角色</th>
		<th width="12%">值班地点</th>
		<th width="35%">记录内容</th>
		<th width="15%">创建时间</th>
		<th width="14%">操作</th>
	</tr>
    </thead>
	<tbody>
		<c:forEach items="${listshift}" var="svo"  >
		  <%@ include file="shift/row.jsp"%>
		</c:forEach>
	</tbody>
</table>
</c:if>	


