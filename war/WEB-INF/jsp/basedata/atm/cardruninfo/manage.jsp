<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM板卡管理</title>
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
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.checkbox.js"
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
					sorter : 'text',
				},
				2 : {
					sorter : 'digit',
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
				},
				7 : {
					sorter : 'text',
				},				
				8 : {
					sorter : 'text',
				},
				9: {
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
						window.location.href = "${rootUrl }basedata/atm/cardruninfo/expexcel.do";
					}
			});
		
	});
	function ajaxNode(obj) {
        var node = [];
		$("#atmNodeCodeLike").val("");
		$("#aNode").val("");
		$("#cardTypeLike").val("");
		$("#zNode").val("");
		var atmBureau = obj.value;
		//alert(atmBureau);
		if(atmBureau==""){
			$("#atmNodeCodeLike").val("");
			$("#atmNodeCodeLike").unautocomplete();
			$("#cardTypeLike").val("");
			$("#cardTypeLike").unautocomplete();
		}
		if ("" != atmBureau) {
			var url = "${rootUrl}basedata/atmcard.dox?r=" + Math.random();
			$.ajax({
				url : url,
				type : "GET",//get请求
				data : "atmBureau=" + atmBureau,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						node[i] = {
							card : response[i].card,
							nodeCode : response[i].nodeCode,
							cardType : response[i].cardType,
							id : response[i].id
						}
					}
					$("#atmNodeCodeLike").unautocomplete();
					$("#atmNodeCodeLike").autocomplete(
							node,
							{
								minChars : 0,
								width : 200,
								matchContains : true,
								autoFill : false,
								max : 500,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.nodeCode;
								},
								formatMatch : function(row, i, max) {
									return row.nodeCode;
								},
								formatResult : function(row) {
									return row.nodeCode;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#aNode").val(row.id);
						}
					});
					$("#cardTypeLike").unautocomplete();
					$("#cardTypeLike").autocomplete(
							node,
							{
								minChars : 0,
								width : 200,
								matchContains : true,
								autoFill : false,
								max : 500,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.cardType;
								},
								formatMatch : function(row, i, max) {
									return row.cardType;
								},
								formatResult : function(row) {
									return row.cardType;
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
						<span class="bold">ATM板卡管理</span>
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
									<sec:authorize
										ifAnyGranted="${jspAuthorities['atmcardmng_expexcel']}">
										<a href="#" class="btn" id="expexcelBtn"><img
											src="${rootUrl}images/btn/qxzd.gif" />Excel导出</a>
									</sec:authorize>
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}basedata/atm/cardruninfo/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											区域：
											<form:select path="bureau" cssStyle="width:135px" onchange="ajaxNode(this)">
												<form:option value="">-请选择-</form:option>
												<form:options items="${bureaus}" itemLabel="value" />
											</form:select>
											节点代码:
											<form:input id="atmNodeCodeLike" path="atmNodeCodeLike" cssStyle="width:150px" />
											<form:hidden id="aNode" path="nodeCode"/>
											板卡类型：
											<form:input id="cardTypeLike" path="cardTypeLike" cssStyle="width:150px"  />
											<form:hidden id="zNode" path="cardType"/>
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
													alt="" />ATM板卡列表</td>
												<td class="td2" id="noteInfo"></td>
											</tr>
										</table>
										<!--查询结果-->
										<div id="queryResult" style="overflow:auto;border-right:1px solid #95BDD7;border-left:1px solid #95BDD7"></div>
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