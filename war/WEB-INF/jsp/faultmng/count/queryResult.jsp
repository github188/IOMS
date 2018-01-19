<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		// 跟踪
		$('.trace').click(graphTrace);
		
		//页面展示样式设置
		var faultNumbers = document.getElementsByName("faultNumber");
		for (var i = 0; i < faultNumbers.length; i++) {
			var faultChildNumber = "faultChildNumber" + faultNumbers[i].value;
			var childNums = document.getElementsByName(faultChildNumber);
			
			var changeshowtype = "#changeshowtype" + faultNumbers[i].value;
			var showtype = $(changeshowtype).val();

			if (showtype == "0") {
				for (var j = 0; j < childNums.length; j++) {
					var fault = "#child-" + faultNumbers[i].value + "-" + childNums[j].value;
					var handle = "#childhandle-" + faultNumbers[i].value + "-" + childNums[j].value;
					$(fault).hide();
					$(handle).hide();
				}
			} else if (showtype == "1") {
				for (var j = 0; j < childNums.length; j++) {
					var fault = "#child-" + faultNumbers[i].value + "-" + childNums[j].value;
					var handle = "#childhandle-" + faultNumbers[i].value + "-" + childNums[j].value;
					$(fault).show();
					$(handle).show();
				}
			}
		}
	});
	var rootUrl = '${rootUrl }';
	
	//页面展示样式动态变换
	function changeshow(data) {
		
		var childTableTrs = document.getElementsByName("childTableTr");
		for(var j = 0 ; j < childTableTrs.length ; j++){
			childTableTrs[j].style.background = "white";
		} 
		
		var faultChildNumber = "faultChildNumber" + data;
		var childNums = document.getElementsByName(faultChildNumber);

		var changeshowtype = "#changeshowtype" + data;
		var showtype = $(changeshowtype).val();

		var faultManageImg = "#faultManage-" + data + " img";		
		var faultManage = "#faultManage-" + data;		
		
		if (showtype == "1") {
			for (var i = 0; i < childNums.length; i++) {
				var fault = "#child-" + data + "-" + childNums[i].value;
				var handle = "#childhandle-" + data + "-" + childNums[i].value;
				$(fault).hide();
				$(handle).hide();
			}
			$(changeshowtype).val("0");
			$(faultManageImg).remove();
			var htmImage = "<img alt='展开子故障单' src='${rootUrl }images/btn/qxzd.gif'/>";
			$(faultManage).append(htmImage); 
		} else if (showtype == "0") {
			for (var i = 0; i < childNums.length; i++) {
				var fault = "#child-" + data + "-" + childNums[i].value;
				var handle = "#childhandle-" + data + "-" + childNums[i].value;
				$(fault).show();
				$(handle).show();
			}
			$(changeshowtype).val("1");
			$(faultManageImg).remove();
			var htmImage = "<img alt='隐藏子故障单' src='${rootUrl }images/btn/zd.gif'/>";
			$(faultManage).append(htmImage);
		}
	}
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="table table-bordered">
	<thead>
		<tr>
			
			<th>事件单编号</th>
			<!-- <th>申告人</th>
			<th>申告电话</th> -->
			<th>处理人</th>
			<!-- <th>坐席电话</th> -->
			<th>申告时间</th>
			<th>事件发生地址</th>
			<th>事件类别</th>
			<th>事件级别</th>
			<!-- <th>事件单来源</th>
			<th>事件描述</th> -->
			<th>当前状态</th>
			<c:if test="${currentUser.id eq 'admin' }">
				<th>操作</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
			<%@ include file="row.jsp"%>
		</c:forEach>
	</tbody>
</table>
<div class="pager" totalcount="${pagn.totalCount }"
	pagecount="${pagn.pageCount}"></div>