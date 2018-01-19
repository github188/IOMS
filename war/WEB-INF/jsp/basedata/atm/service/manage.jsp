<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM业务管理</title>
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
			sortable : true,
			sortConfig : {
				0 : {
					sorter : false,
				},
				1 : {
					sorter : false,
				},
				2 : {
					sorter :false,
				},
				3 : {
					sorter : false,
				},
				4 : {
					sorter : false,
				},
				5: {
					sorter : false,
				},
				6 : {
					sorter : false,
				},
				7 : {
					sorter : false,
				},
				8 : {
					sorter : false,
				},
				9 : {
					sorter : false,
				},
				10: {
					sorter : false,
				},
				11 : {
					sorter : false,
				},
				12 : {
					sorter : false,
				},
				13 : {
					sorter : false,
				}
			} 

		});
		
		$("#queryButton2")
		.click(
				function() {
					if($(".pager").attr('totalcount')=='0')
						{alert("记录为空");}
					else{
						window.location.href = "${rootUrl}basedata/atm/service/expexcel.dox";
					}
			});
		
		var node = [];
			$("#localNodeLike").val("");
			$("#remoteNodeLike").val("");
		var url = "${rootUrl}basedata/atmservice.dox?r=" + Math.random();
		$.ajax({
			url : url,
			type : "GET",//get请求
			//data : "serviceName=" + serviceName,
			async : false,//同步加载数据
			dataType : "json",//返回json格式
			success : function(response) {
				//alert(response.length);
				for (var i = 0; i < response.length; i++) {
					node[i] = {
						localNode : response[i].atmNodeCode,
						remoteNode : response[i].atmNodeCode,
						id : response[i].id
					}
				}
				//alert(node[10].localNode);
				$("#localNodeLike").unautocomplete();
				$("#localNodeLike").autocomplete(
						node,
						{
							minChars : 0,
							width : 180,
							matchContains : true,
							autoFill : false,
							max : 300,
							dataType : "json",
							//mustMatch : true,
							formatItem : function(row, i, max) {
								return i + "/" + max + ":" + row.localNode;
							},
							formatMatch : function(row, i, max) {
								return row.localNode;
							},
							formatResult : function(row) {
								return row.localNode;
							}
						}).result(function(e, row) {
					if (row != null) {
						//$("#").val(row.id);
					}
				});	
				$("#remoteNodeLike").unautocomplete();
				$("#remoteNodeLike").autocomplete(
						node,
						{
							minChars : 0,
							width : 180,
							matchContains : true,
							autoFill : false,
							max : 300,
							dataType : "json",
							//mustMatch : true,
							formatItem : function(row, i, max) {
								return i + "/" + max + ":" + row.remoteNode;
							},
							formatMatch : function(row, i, max) {
								return row.remoteNode;
							},
							formatResult : function(row) {
								return row.remoteNode;
							}
						}).result(function(e, row) {
					if (row != null) {
						//$("#").val(row.id);
					}
				});	
			}
		});
	
	});
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
						<span class="bold">ATM业务管理</span>
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
										ifAnyGranted="${jspAuthorities['atmservicemng_expexcel']}">
										<a href="#" class="btn" id="queryButton2"><img
											src="${rootUrl}images/btn/qxzd.gif" />Excel导出</a>
										</sec:authorize>
								</div>
								<div class="bclear"></div>




								<!--管理按钮-->
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm"
									action="${rootUrl}basedata/atm/service/manage.do" method="post">
									<!-- 查询条件 -->
									<div class="boxbtn">
										<div class="info">
											业务名称：
											<form:input id="serviceNameLike" path="serviceNameLike" size="10" maxlength="50" />
											本地节点代码：
											<form:input id="localNodeLike" path="localNodeLike"  cssStyle="width:100px" />
											远端节点代码：
											<form:input id="remoteNodeLike" path="remoteNodeLike"  cssStyle="width:100px"  />
											业务类型：
  			                                <form:select name="atmType" path="atmType.serviceType" cssStyle="width:80px" >
  			                                          <option value=" ">-请选择-</option>
								                  <c:forEach items="${serviceTypes}" var="vo">
									                  <option value="${vo.id}">${vo.serviceType}</option>
								                  </c:forEach> 
						                    </form:select>
											采集状态：
											<form:select path="serviceChangeType"  cssStyle="width:75px"  >
												<form:option value="">-请选择-</form:option>
												<form:options items="${serviceChangeTypes}" itemLabel="value" />
											</form:select>
											业务状态：
											<form:select path="isAlarm"  cssStyle="width:75px"  >
												<form:option value="">-请选择-</form:option>
												<form:option value="true">异常</form:option>
												<form:option value="false">正常</form:option>
											</form:select>

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
													alt="" />ATM业务列表</td>
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