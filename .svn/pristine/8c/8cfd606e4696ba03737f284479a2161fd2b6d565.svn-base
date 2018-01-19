<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM节点管理</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

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
<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>

<script type="text/javascript">
	$(function() {
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : false/* ,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				1 : {
					sorter : 'digit',
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
				5: {
					sorter : false,
				}
			} */

		});
		
		$("#expexcelBtn")
		.click(
				function() {
					if($(".pager").attr('totalcount')=='0')
						{alert("记录为空！");}
					else{
						window.location.href = "${rootUrl }basedata/atm/node/expexcel.do";
					}
			});
	});
	function ajaxNode(obj) {
        var node = [];
		$("#atmNodeNameCnLike").val("");
		$("#aNode").val("");
		$("#atmNodeCodeLike").val("");
		$("#zNode").val("");
		var atmBureau = obj.value;
		//alert(atmBureau);
		if(atmBureau==""){
			$("#atmNodeCodeLike").val("");
			$("#atmNodeCodeLike").unautocomplete();
			$("#atmNodeNameCnLike").val("");
			$("#atmNodeNameCnLike").unautocomplete();
		}
		if ("" != atmBureau) {
			var url = "${rootUrl}basedata/atmnode.dox?r=" + Math.random();
			$.ajax({
				url : url,
				type : "GET",//get请求
				data : "atmBureau=" + atmBureau,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						node[i] = {
							atmNodeCode : response[i].atmNodeCode,
							atmNodeNameCn : response[i].atmNodeNameCn,
							id : response[i].id
						}
					}
					$("#atmNodeNameCnLike").unautocomplete();
					$("#atmNodeNameCnLike").autocomplete(
							node,
							{
								minChars : 0,
								width : 150,
								matchContains : true,
								autoFill : false,
								max : 500,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.atmNodeNameCn;
								},
								formatMatch : function(row, i, max) {
									return row.atmNodeNameCn;
								},
								formatResult : function(row) {
									return row.atmNodeNameCn;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#aNode").val(row.id);
						}
					});
					$("#atmNodeCodeLike").unautocomplete();
					$("#atmNodeCodeLike").autocomplete(
							node,
							{
								minChars : 0,
								width : 150,
								matchContains : true,
								autoFill : false,
								max : 500,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.atmNodeCode;
								},
								formatMatch : function(row, i, max) {
									return row.atmNodeCode;
								},
								formatResult : function(row) {
									return row.atmNodeCode;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#zNode").val(row.id);
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
						<span class="bold">ATM节点管理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<!--管理按钮-->

								<div class="boxbtn">
									<%-- <sec:authorize
										ifAnyGranted="${jspAuthorities['atmnodemng_add']}">
										<a href="${rootUrl }basedata/atm/node/add.do"
											class="my_add{boxwidth:550,boxheight:300} btn"><img
											src="${rootUrl}images/btn/new.gif" />添加</a>
									</sec:authorize>
									<sec:authorize
										ifAnyGranted="${jspAuthorities['atmnodemng_impexcel']}">
										<a href="${rootUrl }basedata/atm/node/impexcel.do"
											class="my_view {boxwidth:900,boxheight:650} btn"><img
											src="${rootUrl}images/btn/file.gif" />Excel导入 </a>
									</sec:authorize> --%>
									<sec:authorize
										ifAnyGranted="${jspAuthorities['atmnodemng_expexcel']}">
										<a href="#" class="btn" id="expexcelBtn"><img
											src="${rootUrl}images/btn/qxzd.gif" />Excel导出</a>
									</sec:authorize>
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}basedata/atm/node/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
										区域：
											<form:select path="bureau" cssStyle="width:135px"  onchange="ajaxNode(this)">
											    <form:option value="">-请选择-</form:option>
												<form:options items="${bureaus}" itemLabel="value" />
											</form:select>
											节点地点：
											<form:input id="atmNodeNameCnLike" path="atmNodeNameCnLike" cssStyle="width:100px"/>
											<form:hidden id="aNode" path="atmNodeNameCn" />
											节点代码：
											<form:input id="atmNodeCodeLike" path="atmNodeCodeLike" cssStyle="width:100px" />
                                            <form:hidden id="zNode" path="atmNodeCode" />
										</div>
										<a href="#none" class="sbtn" id="queryButton">查询</a> <a
											href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
									</div>
									<div class="bclear"></div>
									<!-- 查询条件 -->

									<div class="mtab">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="title">
											<tr>
												<td class="td1"><img src="${rootUrl}images/pl1.gif"
													alt="" />ATM节点列表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
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
		</div>
		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>