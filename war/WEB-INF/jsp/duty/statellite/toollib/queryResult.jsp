<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	table th {
		white-space: nowrap;
	}
	table td{
		white-space: nowrap;
	}
	table{
		empty-cells: show;
		border-collapse: collapse;
		table-layout: auto;
	}
-->
</style>
<script type="text/javascript">
	/* $(function() {
		// 跟踪
		$('.trace').click(graphTrace);
	}); */
	var rootUrl = '${rootUrl }';
</script> 
<div style="width:100%; overflow: scroll;">
	<table id="dataTable"  border="0" cellspacing="0"
		cellpadding="2" class="tablesorter">
	<thead>
	<tr>
    <th width="30" rowspan="2" scope="col">巡检时间</th>
    <th width="20" rowspan="2" scope="col">设备名称</th>
    <th colspan="2" scope="col">1001</th>
    <th colspan="2" scope="col">1002</th>
    <th colspan="2" scope="col">1003</th>
    <th colspan="2" scope="col">1004</th>
    <th colspan="2" scope="col">1007</th>
    <th colspan="2" scope="col">1008</th>
    <th colspan="2" scope="col">10019</th>
    <th colspan="2" scope="col">100A</th>
    <th colspan="2" scope="col">100B</th>
    <th colspan="2" scope="col"><p>100C</p>    </th>
    <th colspan="2" scope="col"><p>100D</p></th>
    <th colspan="2" scope="col"><p>100E</p></th>
    <th colspan="2" scope="col"><p>100F</p></th>
    <th colspan="2" scope="col"><p>1010</p></th>
    <th colspan="2" scope="col"><p>1011</p></th>
    <th colspan="2" scope="col"><p>1012</p></th>
    <th width="42" rowspan="2" scope="col">操作人</th>
    <th width="52" rowspan="2" scope="col">操作</th>
  </tr>
  <tr>
    <th width="50" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="75" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="75" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="75" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="20" scope="col">机箱风扇运行情况看</th>
    <th width="31" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="21" scope="col">板卡数量</th>
    <th width="20" scope="col">机箱风扇运行情况看</th>
    <th width="34" scope="col">板卡数量</th>
    <th width="56" scope="col">机箱风扇运行情况看</th>
    <th width="51" scope="col">板卡数量</th>
    <th width="19" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
    <th width="19" scope="col">板卡数量</th>
    <th width="37" scope="col">机箱风扇运行情况看</th>
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
	<div class="pager" totalcount="${pagn.totalCount }" pagecount="${pagn.pageCount}"></div>
</div>

