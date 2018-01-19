<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>签到/离岗</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css"
	type="text/css" rel="stylesheet" />

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
<script src="${rootUrl }js/activiti/newsworkflow.js"
	type="text/javascript"></script>

<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<script type="text/javascript">
	$(function() {

		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			boxwidth : "600",
			boxheight : "600",
			sortable : true,//是否使用页面排序功能
			sortConfig : { //页面排序的配置
				0 : {
					sorter : "text"
				}
			}
		});
		$("#signinButton").click(function(){
			//window.location.href="${rootUrl }turndutymng/change/signin.do";
			$("#signinButton").attr('href','${rootUrl }turndutymng/change/signin.do');
		});
		
		$("#inphone").click(function(){
			//${rootUrl}turndutymng/change/inphone.do
			$.ajax({
				type : "POST",
				url : "${rootUrl}turndutymng/change/inphone.do",
				dataType : "json",
				success : function(data, status, xhr) {
					
					alert(data.msg);
					window.top.location.reload();
					$("action").attr("${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime=");
					$("#listForm").submit();
				}
			});
		});
		

	});

	var rootUrl = '${rootUrl }';

	//window.onload=function(){
	//alert("1111");
	//location.replace(location);
	//location.href="${rootUrl}turndutymng/change/manage.do";
	//}
</script>

<style>
td {
	word-break: break-all;
}
</style>
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
		<!-- 内容页 -->
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">签到/离岗</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<div class="clear"></div>
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}turndutymng/change/manage.do"
									method="post">
                                    <input style="display:none" id=agent value="${agent}" />
									<div class="boxbtn">
										<div class="info"></div>

										<c:if test="${isflag=='NO' }">
											<div
												style="margin-left: auto; margin-right: auto; width: 400px"
												id="signdiv">

												<a 
													class="my_add {boxwidth:800,boxheight:550}"
													id="signinButton"> <img
													src="${rootUrl }images/img/signin.png"></img>
												</a>
											</div>
											
										</c:if>
										<c:if test="${isflag=='ON' }">
											<a href="${rootUrl }turndutymng/change/add.do"
												class="my_add {boxwidth:700,boxheight:350} btn"
												id="addButton">添加交接班记录</a>
											<c:if test="${dutyStatu=='Agent'}">
												<a href="${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime="
													class="btn">进入呼叫中心</a>
											</c:if>
                                            <c:if test="${dutyPlace=='COMMUNICATION' and dutyStatu=='noAgent'}">
                                                <a href="#" id="inphone"
													class="btn">进入呼叫中心</a>
                                            </c:if>
										</c:if>

									</div>

									<div id="queryResult"></div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 内容页 -->
		<!-- 内容页 -->
	</div>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>

	<!-- 版权页 -->
</body>
</html>