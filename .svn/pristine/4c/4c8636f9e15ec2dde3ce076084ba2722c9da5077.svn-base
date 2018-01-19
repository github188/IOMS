<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
table th {
	white-space: nowrap;
}

table td {
	white-space: nowrap;
}

table {
	empty-cells: show;
	border-collapse: collapse;
	table-layout: auto;
}
</style>
<script type="text/javascript">
	/* $(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	}); */
	var rootUrl = '${rootUrl }';
</script>
<div style="width: 100%; overflow: scroll;">
	<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
		class="tablesorter">
		<thead>
			<tr>
				<th width="34" rowspan="3" scope="col">巡检时间</th>
				<th width="19" rowspan="3" scope="col">巡检内容</th>
				<th colspan="52" scope="col">室内设备检查结果</th>
				<th colspan="36" scope="col">室外设备检查结果</th>
				<th colspan="28" scope="col">网管工作站清查结果</th>
				<th width="19" rowspan="3" scope="col">操作人</th>
				<th width="19" rowspan="3" scope="col">操作</th>
			</tr>
			<tr>
				<th width="595" colspan="4" scope="col">北京网控中心TES站</th>
				<th width="595" colspan="4" scope="col">北京网控中心PES站</th>
				<th width="595" colspan="4" scope="col">北京网控中心子网1ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心子网2ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心子网3ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心子网4ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心帧中继网ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心境外站</th>
				<th width="595" colspan="4" scope="col">十里河TES站</th>
				<th width="595" colspan="4" scope="col">民航局TES站</th>
				<th width="595" colspan="4" scope="col">十里河ku站</th>
				<th width="595" colspan="4" scope="col">民航局ku站</th>
				<th width="595" colspan="4" scope="col">ku测试站</th>
				<th width="595" colspan="4" scope="col">北京网控中心TES站</th>
				<th width="595" colspan="4" scope="col">北京网控中心PES站</th>
				<th width="595" colspan="4" scope="col">北京网控中心ku站</th>
				<th width="595" colspan="4" scope="col">北京网控中心境外站</th>
				<th width="595" colspan="4" scope="col">十里河TES站</th>
				<th width="595" colspan="4" scope="col">民航局TES站</th>
				<th width="595" colspan="4" scope="col">十里河ku站</th>
				<th width="296" colspan="4" scope="col">民航局ku站</th>
				<th width="297" colspan="4" scope="col">ku测试站</th>
				<th colspan="4" scope="col">北京网控中心TES站</th>
				<th colspan="4" scope="col">北京网控中心PES站</th>
				<th colspan="4" scope="col">北京网控中心ku子网1网管</th>
				<th colspan="4" scope="col">北京网控中心ku子网2网管</th>
				<th colspan="4" scope="col">北京网控中心ku子网3网管</th>
				<th colspan="4" scope="col">北京网控中心ku子网4网管</th>
				<th colspan="4" scope="col">北京网控中心帧中继网ku站</th>
			</tr>
			<tr>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">机箱数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
				<th scope="col">工作站数量</th>
				<th scope="col">正常</th>
				<th scope="col">异常</th>
				<th scope="col">备注</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${pagn.totalCount==0}">
				<td colspan="29">记录为空！</td>
			</c:if>
			<c:forEach items="${pagn.result}" var="vo" varStatus="voStatus">
				<%@ include file="row.jsp"%>
			</c:forEach>
		</tbody>
	</table>
	<div class="pager" totalcount="${pagn.totalCount }"
		pagecount="${pagn.pageCount}"></div>
</div>

