<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#checkAllService").click(function() {
			$('input[name="checkSerive"]').attr("checked", this.checked);
		});
		var $subBox = $("input[name='checkSerive']");
		$subBox
				.click(function() {

					$("#checkAllService")
							.attr(
									"checked",
									$subBox.length == $("input[name='checkSerive']:checked").length ? true
											: false);

				});
	});
</script>
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" 
	style="table-layout: fixed; word-warp: break-word; word-break: break-all; overflow: auto;">
	<thead>
		<tr>
			<th style="width:30px">全选<input type="checkbox" id="checkAllService"
				onclick="checkAllService()" />
			</th>
			<th style="width:50px">所属地区</th>
			<th style="width:70px">电路名</th>

			<th style="width:60px">电路类型</th>
			<th style="width:150px">电路速率</th>
			<th style="width:80px">配置时间</th>

			<th style="width:80px">发端节点名</th>
			<th style="width:100px">发端站名</th>
			<th style="width:30px">发端节点号</th>
			<th style="width:30px">发端槽位号</th>
			<th style="width:30px">发端端口号</th>

			<th style="width:80px">收端节点名</th>
			<th style="width:100px">收端站名</th>
			<th style="width:30px">收端节点号</th>
			<th style="width:30px">收端槽位号</th>
			<th style="width:30px">收端端口号</th>
			<th style="width:80px">收端信息</th>
			<th style="width:50px">采集状态</th>
			<th style="width:120px">采集时间</th>
			<th style="width:40px">操作</th>
			
			<!-- 
			<th width="5%">电路情况</th>
			<th width="5%">业务类型</th>
			<th width="5%">CRM情况</th>
			<th width="5%">电路使用情况</th>
			<th width="5%">备注</th> 
			-->
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
