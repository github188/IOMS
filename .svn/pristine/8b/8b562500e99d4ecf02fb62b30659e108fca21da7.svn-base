<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	function ackdelete(tempcircuitid) {
		if (confirm("您确定撤销该电路？")) {
			var url = rootUrl + "tempcircuit/ackdelete.do";
			$.ajax({
				url : url,// 需要链接到服务器地址
				type : 'GET',
				data : {
					id : tempcircuitid
				},
				success : function(data) {
					var data = eval('(' + data + ')');
					if (data.success == true) {
						alert("确认完成！")
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				}
			});
		}
	};
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th>电路编号</th>
			<th>申请人</th>
			<th>申请单位</th>
			<th>开通日期</th>
			<th>到期日期</th>
			<th>电路类型</th>
			<th>当前状态</th>
			<th>更新时间</th>
			<th>查询</th>
			<th>操作</th>
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