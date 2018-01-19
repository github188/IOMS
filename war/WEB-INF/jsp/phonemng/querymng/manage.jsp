<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查询统计</title>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jquery/themes/default/style.css" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />

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

<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<script type="text/javascript">
	$(function() {
		$("#boxleft").attr("style", "display:none");
		$tabs = $("#tabs").tabs();

		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : true,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				1 : {
					sorter : 'text',
				},
				2 : {
					sorter : 'text',
				},
				3 : {
					sorter : 'text',
				},
				4 : {
					sorter : 'text',
				},
				5 : {
					sorter : 'text',
				},
				6 : {
					sorter : 'text',
				}
			}
		});
		$("#tabs").tabs({
			select : function(event, ui) {
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
		
		loadCount('CALL');
		loadCount('OUTBOUND');
		loadCount('TRANSFER');
		loadCount('OTHER');
		
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));

	});
	var rootUrl = '${rootUrl }';
	var callActiveSelectIds = new Array();
	var allSelect = new Array();
	function loadCount(optType) {
		$
				.ajax({
					optType : "GET",
					//url : "${rootUrl}tempcircuit/count.dox",
					data : {
						optType : optType
					},
					dataType : "json",
					success : function(result) {
						$("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result + "</div>");
					}
				});
	}
	function change(optType) {
		$("#optType").val(optType);
		loadCount('CALL');
		loadCount('OUTBOUND');
		loadCount('TRANSFER');
		loadCount('OTHER');
		

	}
	//全选、反选按钮
	function allSel() {

		if (allSelect.length > 0) {

			$("input[name=activeCheck]").each(function() {

				$(this).attr("checked", false);
			});
			allSelect = null;
			allSelect = new Array();
			$("#classifyBtn").hide();

		} else {

			$("input[name=activeCheck]").each(function() {
				$(this).attr("checked", true);
				//alert($(this).attr("value"));
				allSelect.push($(this).attr("value"));
			});

			if (allSelect.length <= 0) {
				$("#classifyBtn").hide();
			} else {
				$("#classifyBtn").show();
				$("#classifyBtn").attr(
						'href',
						'${rootUrl }phonemng/querymng/classify.do?ids='
								+ allSelect);
			}

		}
	}

	function checkActiveSelect(checkbox) {

		if ($(checkbox).attr("checked") == "checked") {

			callActiveSelectIds.push($(checkbox).attr("value"));
			if (callActiveSelectIds.length > 0) {
				$("#classifyBtn").show();
				$("#classifyBtn").attr(
						'href',
						'${rootUrl }phonemng/querymng/classify.do?ids='
								+ callActiveSelectIds);
			} else {
				$("#classifyBtn").hide();
			}
			return;
		}
		for (var i = 0; i < callActiveSelectIds.length; i++) {
			if (callActiveSelectIds[i] == $(checkbox).attr("value")) {
				callActiveSelectIds.splice(i, 1);

				if (callActiveSelectIds.length > 0) {
					$("#classifyBtn").show();
					$("#classifyBtn").attr(
							'href',
							'${rootUrl }phonemng/querymng/classify.do?ids='
									+ callActiveSelectIds);
				} else {
					$("#classifyBtn").hide();
				}

				return;
			}
		}

	}
</script>

</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<%@ include file="/WEB-INF/jsp/left.jsp"%>

	<!-- LOGO -->
	<div id="boxmain">
		<!-- 左侧菜单 -->

		<!-- 左侧菜单 -->

		<!-- 内容页 -->


		<div id="main">
			<!--place-->

			<div id="boxplace">
				<div class="place">
					<span class="bold">查询统计</span>
				</div>
			</div>
			<!--place-->
			<div class="minfo">
				<div class="bl">
					<div class="br">
						<div class="clear"></div>
						<div id="lmsx">
							<form:form modelAttribute="queryModel" id="listForm"
								name="listForm" action="${rootUrl}phonemng/querymng/manage.do"
								method="post">

								<form:hidden id="optType" path="optType" />
								<form:hidden id="index" path="index" />

								<div class="clear"></div>
								<!-- 查询条件 -->
								<div class="boxbtn">
									<div class="info">

										通话开始时间： <input readonly="true" id="ringingTime"
											name="ringingTime" size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'pickupTime\')}'})">至

											<input readonly="true" id="pickupTime" name="pickupTime"
											size="15" maxlength="18" class="Wdate"
											onfocus="WdatePicker({minDate:'#F{$dp.$D(\'ringingTime\')}'})">
												主叫电话： <form:input path="callonNumber" size="10"
													maxlength="30"
													onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
												被叫电话： <form:input path="calledNumber" size="10"
													maxlength="30"
													onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
												值班工程师： <form:input path="userName" size="10" maxlength="30"
													onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
													oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
									</div>
									<div>
										<a href="#none" class="sbtn" id="queryButton">查询</a>
									</div>
								</div>
								<div class="bclear"></div>
								<!-- 查询条件 -->
								<div id="tabs">
									<ul>
										<li id="CALL" style="position: relative;"><a
											id="queryButton" href="#tabs-1" onclick="change('CALL');">普通来电</a></li>
										<li id="OUTBOUND" style="position: relative;"><a
											id="queryButton" href="#tabs-1" onclick="change('OUTBOUND');">外呼</a></li>
										<li id="TRANSFER" style="position: relative;"><a
											id="queryButton" href="#tabs-1" onclick="change('TRANSFER');">转接</a></li>

										<li id="OTHER" style="position: relative;"><a
											id="queryButton" href="#tabs-1" onclick="change('OTHER');">其他</a></li>
									
										
                                         
									</ul>
									<div id="tabs-1">

										<div id="queryResult"></div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>