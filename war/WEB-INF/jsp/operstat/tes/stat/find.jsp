<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
	<meta http-equiv="expires" content="0" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.min.css"/>
	<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css"/>
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
	
	<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>

	<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
</head>

<body style="overflow-x:hidden">
	<div class="window">
			<dl class="title">
				<dd>TES频率节点列表</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<br />
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<form:form modelAttribute="queryModel" id="listForm" name="listForm" action="${rootUrl}operstat/tes/power/manage.dox?statid=${pageModel.id}" method="post">
			<form:hidden id="optType" path="optType" />
			<div class="mtab">
				<table width="100%">
					<tr>
						<th colspan="6"
							style="color: gray; width: 100%; text-align: center;">TES频率节点列表</th>
					</tr>
					<tr>
						<th width="15%">超限频点总数:</th>
						<td width="20%">${fn:escapeXml(pageModel.over)}</td>
						<th width="15%">正常频点总数:</th>
						<td width="20%">${fn:escapeXml(pageModel.normal)}</td>
						<th width="15%">标准值:</th>
						<td width="20%">${pageModel.standard}</td>
					</tr>
					<tr>
						<th width="15%">采集时间:</th>
						<td width="20%"><fmt:formatDate value="${pageModel.statDate.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th></th>
						<td></td>
						<th></th>
						<td></td>
					</tr>
				</table>
				<div id="tabs" style="margin: 10px 20px 0px;padding:0px">
					<ul>
						<li><a id="queryButton" href="#tabs-1" onclick="change('POWER');">异常节点配置</a></li>
						<li><a id="queryButton" href="#tabs-1" onclick="change('NODE');">节点状态表</a></li>
					</ul>
					<div id="tabs-1">
						<!-- 查询条件-->
						<div id="searchTool" class="boxbtn" style="width: 100%">
							<div class="info">
								机箱槽位号：
								<input type="text" name="tesNode" id="tesNode" class="text ui-widget-content" />-
								<select id="tesSlot" name="tesSlot" style="width: 100px">
								</select>
								记录数：
								<select name="pageSize">
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option>
								</select>
							</div>
							<a href="#none" class="sbtn" id="queryButton">查询</a> 
							<a href="#none" class="sbtn" id="queryReset">重置</a>
						</div> 
						<div class="bclear"></div>
						<!-- 查询条件 -->
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="title" style="margin-left: 2px">
							<tr>
								<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />信息记录</td>
								<td class="td2" id="noteInfo"></td>
							</tr>
						</table>
						<div id="queryResult"></div>
						<br />
						<br />
					</div>
				</div>
			</div>
			</form:form>
	</div>

	<script type="text/javascript">
	    //实例化编辑器
        $(function() {
			$("#tabs").tabs();
            $.ajaxSetup({
                cache : false
            });
    		$(".close").click(function() {
    			parent.$.nyroModalRemove();
    		});
    		

    		$("#queryResult").manage({
    			pageForm : '#listForm',
    			pagerButton : '#queryButton',
    			pagerUrl : true,
    			add : true,
    			edit : true,
    			update : true,
    			view : true,
    			remove : true,
    			boxwidth : "600",
    			boxheight : "600"
    		});
        });
        
		$("#queryReset").click(function() {
			$('#tesNode').val('');
        	$('#tesSlot').empty();
		});
	    
		function change(optType) {
			$("#optType").val(optType);
	        $("#tesNode").val("");
        	$('#tesSlot').empty();
		}
    	var rootUrl = '${rootUrl }';
    	
    	$("#tesNode").autocomplete({
    		minLength: 1, 
    	    autoFocus: true, 
    	    delay: 100 ,
    	    source: function(request, response) {
    	        $.ajax({
    	            url: "${rootUrl}operstat/tes/equipcode.dox",
    	            dataType: "json",
    	            data: {
    	            	code : request.term
    	            },
    	            success: function(data) {
    	            	/* if (data == null || data == [] || data == "") {
    	            		//$("#statid").val("");
    	            		$("#tesNode").val("");
    						return;
    					} */
    	                response($.map(data, function(item) {
    	                    return { 
    	                    	value : item.tesNodeCode,
    							name : item.id,
    							code:item.tesNodeCode
    	                    }
    	                }));
    	            }
    	        });
    	    },
    	    change : function(event, ui) {
    	    	 $.ajax({
     	            url: "${rootUrl}operstat/tes/nodecucode.dox",
     	            dataType: "json",
     	            data: {
     	                code:'',
     	            	tesnodecode:$("#tesNode").val()+''
     	            },
     	            success: function(data) {
     	            	$('#tesSlot').empty();
     	            	if (data == null || data == [] || data == "") {
     						return;
     					}
     	            	$('#tesSlot').append("<option value=''>请选择</option>");
     	            	for(var i=0;i<data.length;i++){
     				        $('#tesSlot').append("<option value='"+data[i].cu+"'>"+data[i].cu+"</option>");
     	            	}
     	            }
     	        });
    	    },
    	    select : function(event, ui) {
    	        //主动为出发城市及代码赋值
    	        //$("#statid").val(ui.item.code);
    			$("#tesNode").val(ui.item.code);
    	
    	        $.ajax({
    	            url: "${rootUrl}operstat/tes/nodecucode.dox",
    	            dataType: "json",
    	            data: {
    	                code:'',
    	            	tesnodecode:$("#tesNode").val()+''
    	            },
    	            success: function(data) {
    	            	if (data == null || data == [] || data == "") {
    						return;
    					}
    	            	$('#tesSlot').empty();
    	            	$('#tesSlot').append("<option value=''>请选择</option>");
    	            	for(var i=0;i<data.length;i++){
    				        $('#tesSlot').append("<option value='"+data[i].cu+"'>"+data[i].cu+"</option>");
    	            	}
    	            }
    	        });
    	    }
    	
    	});
    </script>
	
</body>
</html>