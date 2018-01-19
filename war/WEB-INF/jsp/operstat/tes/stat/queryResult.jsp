<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<script type="text/javascript">
	function createChart(){
		var yCatigories = [];
		var datas1 = [];
		$("#queryResult tbody tr").each(function(){
			yCatigories.push($(this).find("td").eq(0).html());
			datas1.push(parseInt($(this).find("td").eq(1).html()));
		});
		var r_yCatigories = [];
		var r_datas1 = [];
		for(var i=yCatigories.length-1;i>=0;i--){
			r_yCatigories.push(yCatigories[i]);
			r_datas1.push(datas1[i]);
		}
	$(function () {
        $('#container').highcharts({
            title: {
                text: '',
                x: -20 //center
            },
            credits:{
              enabled:true,
              href:"",
              text:""
            },
            subtitle: {
                text: '',
                x: -20
            },
            /* scrollbar:{
             	enabled:true  
            }, */
            xAxis: {
                categories: r_yCatigories,
				labels : {
					allowPointSelect : true,
					rotation : -45,
					aligh : 'center',
					y : 15,
					x : 10
				}/* ,
				max:9,
				min:0 */
            },
            yAxis: {
				min : 0,	//不显示负数
                allowDecimals:false,
                title: {
                    text: '超限频点个数'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                    var s;
                    if (this.point.name) { // the pie chart
                        s = ''+
                            this.point.name +
                            '<br />' +
                            '超频点'+ this.y +' 个';
                    } else {
                        s = ''+
                            this.x  +
                            '<br />' +
                            '超频点'+ this.y+'个';
                    }
                    return s;
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '异常',
                data: r_datas1
            }]
        });
    });
	}
</script>
											
<table id="dataTable" width="100%" border="0" cellspacing="0"
	cellpadding="2" class="tablesorter">
	<thead>
		<tr>
			<th colspan="5">
			<div style="width: 100%;">TES网络异常状态统计</div>
			<div id="container" style="float:left;width: 100%; height: 400px; margin: 0 auto;"></div>
			</th>
		</tr>
		<tr>
			<th>采集时间</th>
			<th>超限频点总数</th>
			<th>正常频点总数</th>
			<th>标准值</th>
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