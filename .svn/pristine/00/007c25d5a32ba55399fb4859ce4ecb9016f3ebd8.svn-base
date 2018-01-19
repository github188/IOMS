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
		
		$("#equipManage").manage({
			pagerUrl : "${rootUrl}networkstat/atmEquip.dox",
			pagerUrl : true,
			view : true,
			boxwidth : "1500",
			boxheight : "600"
		});
	});
</script>
</head>
<body>
	<!-- LOGO -->
	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		method="post">
		<div class="windows">
				<div id="main">
					<div class="minfo"
						style="background: #F7FBFF; margin-left: 7px; min-height: 600px">
						<div class="bl">
							<div class="br">
								<div class="clear"></div>
								<div id="lmsx">
									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />ATM数据网全网设备统计</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
										<div id="equipManage"></div>
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