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
			pagerUrl : "${rootUrl}networkstat/detail.dox",
			pagerUrl : true,
			view : true,
			add : true,
			edit : true,
			remove : true,
			boxwidth : "1850",
			boxheight : "600",
			sortable : true,
			sortConfig : {
				3 : {
					sorter : false,
				}
			}
		});
	});
</script>
</head>
<body>
	<!-- LOGO -->
	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		method="post">
		<div class="windows">
				<dl class="title">
					<dd><img src="${rootUrl}images/pl1.gif"/>ATM数据网业务详情</dd>
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
								<div id="lmsx">
									<div class="clear"></div>
									<div>
										<div class="info" style="float: left;margin-right:4px">
											本地节点名称：
											<form:input path="localNodeName" id="localNodeName" size="10"
												maxlength="50" />
											远端节点名称：
											<form:input path="remoteNodeName" id="remoteNodeName"
												size="10" maxlength="50" />
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<div class="mtab">
										<div id="detailManage"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</form:form>
</body>
</html>