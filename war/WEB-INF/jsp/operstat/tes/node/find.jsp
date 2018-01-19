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
				<dd>节点变更历史</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<br />
			<!--place-->
			<div class="minfo">
				<div class="bl">
					<div class="br">
						<div class="clear"></div>
						<div id="lmsx">
							<div class="clear"></div>
							<form:form modelAttribute="queryModel" id="listForm" name="listForm" action="${rootUrl}operstat/tes/node/find.dox?tesnode=${tesnode}&tescu=${tescu}" method="post">
								<!-- 查询条件 -->
								<div id="searchTool" class="boxbtn" style="width: 100%">
									<div class="info">
										采集时间：
										<input readonly="true" id="startStatTime" name="startStatTime" size="19" maxlength="19" class='Wdate' onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endStatTime\')}'})"/>-
										<input readonly="true" id="endStatTime" name="endStatTime" size="19" maxlength="19" class='Wdate' onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startStatTime\')}'})" />
									</div>
									<a href="#none" class="sbtn" id="queryButton">查询</a> 
									<a href="#none" class="sbtn" id="queryReset">重置</a>
								</div> 
								<div class="bclear"></div>
								<!-- 查询条件 -->
								<div class="mtab">
									<!--查询结果-->
									<div id="queryResult"></div>
									<!--查询结果-->
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
	</div>

	<script type="text/javascript">
	    //实例化编辑器
        $(function() {
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
			$('#startStatTime').val('');
        	$('#endStatTime').val('');
		});
    	var rootUrl = '${rootUrl }';
    </script>
	
</body>
</html>