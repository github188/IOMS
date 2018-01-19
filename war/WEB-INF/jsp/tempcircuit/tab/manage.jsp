<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>临时电路记录</title>
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

<script type="text/javascript">
	$(function() {
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
		loadCount('MNGALL');
		loadCount('MNGAUDIT');
		loadCount('MNGUPCOMING');
		loadCount('MNGEXPIRE');
		loadCount('MNGACKDELETE');
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));
	});
	var rootUrl = '${rootUrl }';
	function loadCount(optType) {
		$
				.ajax({
					optType : "GET",
					url : "${rootUrl}tempcircuit/count.dox",
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
		loadCount('MNGALL');
		loadCount('MNGAUDIT');
		loadCount('MNGUPCOMING');
		loadCount('MNGEXPIRE');
		loadCount('MNGACKDELETE');
	}
	function resetForm() {
		$("#number").val("");
		$("#applyUserLoginName").val("");
		$("#applyCompany").val("");
		$("#circuitType").val("");
		$("#circuitStatus").val("");
		$("#circuitCancelType").val("");
		$("#engineerName").val("");
		$("#nodeView").val("");
		$("#node").val("");
	}
	function ajaxNode(obj) {
		var node = [];
		$("#nodeView").val("");
		var circuitType = obj.value;
		if(circuitType==""){
			$("#nodeView").val("");
			$("#nodeView").unautocomplete();
		}
		if ("" != circuitType) {
			var url = "${rootUrl}basedata/equipnode.dox?r=" + Math.random();
			$.ajax({
				url : url,
				type : "GET",//get请求
				data : "circuitType=" + circuitType,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						node[i] = {
							name : response[i].name,
							code : response[i].code,
							bureau : response[i].bureau,
							id : response[i].id
						}
					}
					$("#nodeView").unautocomplete();
					$("#nodeView").autocomplete(
							node,
							{
								minChars : 0,
								width : 400,
								matchContains : true,
								autoFill : false,
								max : 300,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.bureau
											+ "   " + row.name + "   "
											+ row.code;
								},
								formatMatch : function(row, i, max) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								},
								formatResult : function(row) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#node").val(row.id);
						}
					});
				}
			});
		}
	}
</script>

</head>
<body>
	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<!-- LOGO -->
	<div id="boxmain">
		<!-- 左侧菜单 -->
		<%@ include file="/WEB-INF/jsp/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">临时电路记录</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}tempcircuit/manage.do"
									method="post">
									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
									<div class="clear"></div>
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											电路编号：
											<form:input path="number" id="number" style="width: 120px" placeholder="请输入编号"/>
											申请人：
											<form:input path="applyUserLoginName" id="applyUserLoginName"
												size="10" maxlength="50" placeholder="请输入申请人"/>
											申请单位：
											<form:input path="applyCompany" id="applyCompany" size="10"
												maxlength="50" placeholder="请输入单位"/>
											电路类型：
											<form:select path="circuitType" id="circuitType"
												cssStyle="width:90px" onchange="ajaxNode(this)">
												<form:option value="">-请选择-</form:option>
												<form:options items="${circuitType}" itemLabel="name" />
											</form:select>
											电路：
											<form:input id="nodeView" path="nodeView"
												style="width: 230px" value="请输入区域/节点/名称/代码" />
											<form:hidden id="node" path="equipID" />
											<br></br> 电路状态： <form:select path="circuitStatus"
														id="circuitStatus" cssStyle="width:90px">
														<form:option value="">-请选择-</form:option>
														<form:options items="${circuitStatus}" itemLabel="name" />
													</form:select> 配置工程师： <form:select path="engineerName" id="engineerName"
														cssStyle="width:90px">
														<form:option value="">-请选择-</form:option>
														<form:options items="${engineers}" itemValue="loginName"
															itemLabel="name" />
													</form:select>
										</div>
										<div>
											<a href="#none" class="sbtn" id="queryButton">查询</a> <a
												href="#none" class="sbtn" onclick="resetForm();">重置</a>
										</div>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->
									<div id="tabs">
										<ul>
											<li id="MNGALL" style="position: relative;"><a
												id="queryButton" href="#tabs-1" 
												onclick="change('MNGALL');">全部电路查询</a></li>
											<li id="MNGAUDIT" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('MNGAUDIT');">审批中电路查询</a></li>
											<li id="MNGUPCOMING" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('MNGUPCOMING');">即将到期电路查询</a></li>
											<li id="MNGEXPIRE" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('MNGEXPIRE');">已到期电路查询</a></li>
											<li id="MNGACKDELETE" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('MNGACKDELETE');">完结电路查询</a></li>
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<div id="queryResult"></div>
												<!-- <iframe id="queryResult" style="border: 0;width:100%;height:500px"></iframe> -->
											</div>
										</div>
									</div>
								</form:form>
							</div>
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