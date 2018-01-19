<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="refresh" content="5">
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

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<!-- 
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script> -->
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
<script type="text/javascript">
	$(function() {

		//呼叫中心控制左侧菜单栏隐藏
		$("#boxleft").attr("style", "display:none");

		$("#date1").hide();
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

	});
</script>

<style type="text/css">
#winpop {
	width: 200px;
	height: 0px;
	position: absolute;
	right: 0;
	bottom: 0;
	border: 1px solid #999999;
	margin: 0;
	padding: 1px;
	overflow: hidden;
	display: none;
	background: #FFFFFF
}

#winpop .title {
	width: 100%;
	height: 30px;
	line-height: 30px;
	background: #337ab7;
	font-weight: bold;
	text-align: center;
	font-size: 12px;
	color: #fff
}

#winpop .con {
	width: 100%;
	height: 80px;
	line-height: 80px;
	font-weight: bold;
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
	text-align: center
}

#silu {
	font-size: 13px;
	color: #999999;
	position: absolute;
	right: 0;
	text-align: right;
	text-decoration: underline;
	line-height: 22px;
}

.close {
	position: absolute;
	right: 4px;
	top: -1px;
	color: #FFFFFF;
	cursor: pointer
}
</style>
</head>
<body>
	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		action="${rootUrl}phonemng/callcenter/viewagent.do" method="post">
		<div class="panel panel-default">
			<div class="panel-heading text-left">
				坐席信息
			</div>
			<div class="panel-body">
				<c:forEach items="${agentMap}" var="first">
					<li class="media">
						<div class="media-left">
							<a href="#"> <img
								src="${rootUrl }images/img/Contacts_icon.png"></img>
							</a>
						</div>
						<div class="media-body text-left">
							<h5 class="media-heading">
                                <c:forEach items="${first.value}" var="agentstate">
                                     
                                     <c:if test="${agentstate=='离线' }">
                                        <font color="#7F7F7F" style="font-size:12pt;font-weight:bold">${agentstate}：</font>
                                        <img src="${rootUrl }images/img/notline.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                    
                                     <c:if test="${agentstate=='上线' || agentstate=='空闲'}">
                                       
                                        <font color="#76EE00" style="font-size:12pt;font-weight:bold">${agentstate}：</font>
                                        <img src="${rootUrl }images/img/online.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                     
                                      <c:if test="${agentstate=='忙碌' }">
                                        <font color="#EE7600" style="font-size:12pt;font-weight:bold">${agentstate}：</font>
                                        <img src="${rootUrl }images/img/busy.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                     <c:if test="${agentstate=='小休' }">
                                        <font color="#EEB422" style="font-size:12pt;font-weight:bold">${agentstate}：</font>
                                        <img src="${rootUrl }images/img/rest.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                     <c:if test="${agentstate=='通话中' }">
                                        <font color="#EE0000" style="font-size:12pt;font-weight:bold">${agentstate}：</font>
                                        <img src="${rootUrl }images/img/phone.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                     <c:if test="${agentstate!='通话中' && agentstate!='上线' && agentstate!='空闲' && agentstate!='小休' && agentstate!='离线'}">
                                         ${agentstate}
                                     </c:if>
                                    
                                     <c:if test="${first.key.username==''}">
                                       <font color="#7F7F7F" style="font-size:12pt;font-weight:bold">离线：</font>
                                        <img src="${rootUrl }images/img/notline.png"
										style="width: 24px; height: 24px; margin-left: -10px"></img>
                                     </c:if>
                                     
                                </c:forEach>
								
							</h5>
							<!-- 
							<p>
							       是否在岗：
								<c:if test="${first.key.agentState=='LOGIN'}">
									<img src="${rootUrl }images/img/on_line.png"
										style="width: 12px; height: 12px; margin-left: -10px"></img>
								</c:if>
								<c:if test="${first.key.agentState=='NOTLOGIN'}">
									<img src="${rootUrl }images/img/leave.png"
										style="width: 12px; height: 12px; margin-left: -10px"></img>
								</c:if>
							</p> -->
							<p>坐席号：${first.key.agentinfo}</p>
							<p>值班工程师：${first.key.username}</p>
						</div>
					</li>
				</c:forEach>
			</div>
	</form:form>
</body>
</html>