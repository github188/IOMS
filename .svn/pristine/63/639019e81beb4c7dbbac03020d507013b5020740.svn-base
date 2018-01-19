<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>客户管理</title>
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
			sortable:true,
			sortConfig:{0:{sorter:"text"},
						1:{sorter:"text"},
						2:{sorter:"text"},	
						3:{sorter:"text"},
						4:{sorter:false},
						5:{sorter:"text"}
			}
			
		});
	});
	function ajaxNode(obj) {
        var node = [];
		$("#company").val("");
		var bureau = obj.value;
		if(bureau==""){
			$("#company").val("");
			$("#company").unautocomplete();
		}
		var url = "${rootUrl}systemmng/clientcompany/getCompany.dox?r=" + Math.random();
			//alert(bureau);
			$.ajax({
				url : url,
				type : "GET",//get请求
				data : "bureau=" + bureau,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						node[i] = {
							company : response[i].company,
							id : response[i].id
						}
					}
					$("#company").unautocomplete();
					$("#company").autocomplete(
							node,
							{
								minChars : 0,
								width : 160,
								matchContains : true,
								autoFill : false,
								max : 500,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.company;
								},
								formatMatch : function(row, i, max) {
									return row.company;
								},
								formatResult : function(row) {
									return row.company;
								}
							}).result(function(e, row) {
						if (row != null) {
							//$("#aNode").val(row.id);
						}
					});
				}
			}); 
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
						<span class="bold">客户管理</span>
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
										ifAnyGranted="${jspAuthorities['client_add']}">
										<a href="${rootUrl }systemmng/client/add.do"
											class="my_add{boxwidth:950,boxheight:520} btn"><img
											src="${rootUrl}images/btn/new.gif" />添加</a>
									</sec:authorize>
								
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}systemmng/client/manage.do"
									method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											所属区域：
											<form:select path="bureau" onchange="ajaxNode(this)">
												<form:option value="">-请选择-</form:option>
												<c:forEach items="${bureauList}" var="bureau">
													<form:option value="${bureau.name}">${bureau.value}</form:option>
												</c:forEach>
											</form:select>
											单位名称：
											<form:input path="company" cssStyle="width:160px" />
											角色：
											<form:select path="roleName">
											<form:option value="">所有 </form:option>
												<c:forEach items="${roleNames }" var="role">
													<form:option value="${role }">${role.name }</form:option>
												</c:forEach>
												
											</form:select>
											姓名：
											<form:input path="name" size="10" maxlength="50" />
											
											
											
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
													alt="" />客户列表</td>
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