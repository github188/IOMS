<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/top_b.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/pager.css" type="text/css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		
		$("#detailManage").manage({
			pagerUrl : "${rootUrl}networkstat/bandDetail.dox",
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			operate : true,
			remove : true,
			view : true,
			boxwidth : "1000",
			boxheight : "500",
			sortable : false/* ,
			sortConfig : {
				3 : {
					sorter : false
				}
			} */
		});
	});
</script>
</head>
<body>
	<!-- LOGO -->
	<div class="windows">
		<dl class="title">
			<dd><img src="${rootUrl}images/pl1.gif"/>ATM数据网带宽统计详情</dd>
			<dt>
				<a href="#none" class="close"> <img
					src="${rootUrl }images/close.png" alt="关闭" />
				</a>
			</dt>
		</dl>
		<div id="main">
			<div class="minfo"
				style="background: #F7FBFF; margin-left: 7px; min-height: 480px">
				<div class="bl">
					<div class="br">
						<div class="clear"></div>
						<form:form modelAttribute="queryModel" id="listForm"
							name="listForm" method="post">
							<div id="lmsx">
								<div class="clear"></div>
								<div>
									<div class="info" style="float: left;margin-right:4px">
										本地节点：
										<form:input path="localNodeCode"  size="16"	maxlength="15" />
										对端节点：
										<form:input path="remoteNodeCode" size="16" maxlength="15" />
									</div>
									<a href="#none" class="sbtn" id="queryButton">查询</a> <a
										href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
								</div>
								<div class="bclear"></div>
								<div class="mtab">
									<div id="detailManage"></div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>