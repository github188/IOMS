<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM业务类型管理</title>
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
			sortable : false,
			sortConfig : {
				
			}

		});
		
		
	});
	function changeEquip(id) {
		//alert(id);
		var url = "${rootUrl}basedata/atm/type/check.dox?r=" + Math.random();
		var tx = true;
		$.ajax({
				url : url,
				type : "GET",//get请求
				data : "id=" + id,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					tx = response
					}
		});
		//alert(id);
		if(tx == true){
			var tr = $("#dataTable").find("input[value='" + id + "']").parent().parent();
	        var array = $(tr).nextAll();
	        //alert(array.length);
	        for ( var i = 0; i < array.length; i++) {
	            var count_td = $(array[i]).children()[1];
	            $(count_td).html($(count_td).html() - 1);
	        }
		}
    }
	function changeEquipx() {
		var tr = null;
	    tr = $("#dataTable").find(":input").parent().parent().parent();
	    var array = $(tr).children();
	    for ( var i = 0; i < array.length; i++) {
	        var count_td = $(array[i]).children()[1];
	        $(count_td).html(parseInt($(count_td).html()) + 1);
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
						<span class="bold">ATM业务类型管理</span>
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
										ifAnyGranted="${jspAuthorities['atmtypemng_add']}">
										<a href="${rootUrl }basedata/atm/type/add.do"
											class="my_add{boxwidth:550,boxheight:330} btn" ><img
											src="${rootUrl}images/btn/new.gif"/>添加</a>
									</sec:authorize>
								
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}basedata/atm/type/manage.do" method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											业务类型：
											<form:input path="serviceTypeLike" size="10" maxlength="50" />
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
													alt="" />ATM业务类型列表</td>
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