<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>空管通信网络网控运维信息平台</title>
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/map/jquery-jvectormap-1.2.2.css" />
<script src="${rootUrl }js/map/jquery-jvectormap-1.2.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/map/jquery-jvectormap-cn-mill-en.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/highchart/highcharts.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var schedule = 120000;
	//每隔10秒执行一次reloadData操作，当有弹出页面时，此操作不会执行。
	setTimeout('window.location.reload()', schedule);//当查询失败时刷新页面
	$(function() {
		var map;

		$
				.ajax({

					url : "${rootUrl}alarmStat.dox",
					dataType : "json",
					success : function(dataStatus) {
						map = new jvm.WorldMap(
								{
									container : $('#container'),
									map : 'cn_mill_en',
									backgroundColor : "#EFF7FE", //地图颜色                
									onRegionLabelShow : function(event, label,
											code) {
										//动态显示内容         
										$
												.each(
														dataStatus.cityAlarmStatList,
														function(i, items) {

															if (code == items.cha) {
																label
																		.html("<table border='1'><tr><td colspan='2'>"
																				+ items.bureau
																				+ "</td></tr><tr><td>ATM</td><td>卫星</td></tr>"
																				+ "<tr><td><table><tr class='blue'><td width='50px'>严重</td><td width='20px'>"
																				+ items.atmCritical
																				+ "</td></tr><tr  class='red'><td>主要</td><td>"
																				+ items.atmMajor
																				+ "</td></tr><tr  class='yellow'><td>一般</td><td>"
																				+ items.atmMinor
																				+ "</td></tr></table></td>"
																				+ "<td><table><tr class='red'><td  width='70px'>TES</td><td width='20px'>"
																				+ items.tesAlarm
																				+ "</td></tr><tr  class='red'><td>KU Status</td><td>"
																				+ items.kuStatusAlarm
																				+ "</td></tr><tr  class='red'><td>KU Eb/No</td><td>"
																				+ items.kuEbNoAlarm
																				+ "</td></tr><tr  class='red'><td>KU RxLevel </td><td>"
																				+ items.kuRxLevelAlarm
																				+ "</td></tr></table></td></tr></table>");
															}
														});
									},
									onRegionClick : function(e, code) {
									},
									series : {
										regions : [ {
											scale : {
												'ZWWW' : '#FF69B4',
												'ZUUU' : '#4169E1',
												'ZLXY' : '#7169F1',
												'ZBAA' : '#0069B4',
												'ZYTX' : 'ORANGE',
												'ZSSS' : 'GREEN',
												'ZGGG' : 'YELLOW',
												'SELECTED' : 'RED'
											},
											attribute : 'fill',
											values : {//
												"XINJIANG" : 'ZWWW',
												"XIZANG" : 'ZUUU',
												'SICHUAN' : 'ZUUU',
												'CHONGQING' : 'ZUUU',
												'YUNNAN' : 'ZUUU',
												'GUIZHOU' : 'ZUUU',
												'QINGHAI' : 'ZLXY',
												'GANSU' : 'ZLXY',
												'SHAANXI' : 'ZLXY',
												'NINGXIA' : 'ZLXY',
												'BEIJING' : 'ZBAA',
												'NEIMENG' : 'ZBAA',
												'SHANXI' : 'ZBAA',
												'HEBEI' : 'ZBAA',
												'TIANJIN' : 'ZBAA',
												'LIAONING' : 'ZYTX',
												'JILIN' : 'ZYTX',
												'HEILONGJIANG' : 'ZYTX',
												'JIANGSU' : 'ZSSS',
												'ZHEJIANG' : 'ZSSS',
												'ANHUI' : 'ZSSS',
												'SHANGHAI' : 'ZSSS',
												'SHANDONG' : 'ZSSS',
												'JIANGXI' : 'ZSSS',
												'FUJIAN' : 'ZSSS',
												'HUBEI' : 'ZGGG',
												'HUNAN' : 'ZGGG',
												'HENAN' : 'ZGGG',
												'GUANGXI' : 'ZGGG',
												'GUANGDONG' : 'ZGGG',
												'HAINAN' : 'ZGGG',
											}

										} ]
									}

								});

						var piedatas = new Array();
						$.each(dataStatus.bureauAlarmStatList, function(key,
								val) {
							var count = val.atmCritical + val.atmMajor
									+ val.atmMinor + val.tesAlarm
									+ val.kuStatusAlarm + val.kuEbNoAlarm
									+ val.kuRxLevelAlarm;
							if (count > 0) {
								$("#statTable").append(
										"<tr><td width='50%'>" + val.bureau
												+ "</td><td>" + count
												+ "</td></tr>");
							}
							var piedata = new Array();
							if (count > 0) {
								piedata.push(val.bureau);
								piedata.push(count);
								piedatas.push(piedata);
							}
						});

						$('#pieContainer')
								.highcharts(
										{
											chart : {
												plotBorderWidth : 0,//主图表边框宽度
												shadow : true,
											},
											title : {
												text : ''
											},
											tooltip : {
												pointFormat : '{series.name}: <b>{point.y}个</b>'
											},
											plotOptions : {
												pie : {
													allowPointSelect : true,
													cursor : 'pointer',
													depth : 35,
													dataLabels : {
														enabled : true,
														color : '#000000',
														connectorColor : '#000000',
														format : '<b>{point.name}</b>: {point.percentage:.1f}%'
													}
												}
											},
											credits : {
												enabled : false
											},
											series : [ {
												type : 'pie',
												name : '告警',
												data : piedatas
											} ]
										});
					}

				});
		$("#serviceStat .a").hover(
		//mouseover
		function() {
			/* var divWidth = $(".a").width();
			var divHeight = $(".a").height();
			$(this).animate({
				width:divWidth + 5 + "px",height:divHeight}).animate({
					width:divWidth,height:divHeight}); */
			$(this).css("border", "1px solid #95BDD7");
		},
		//mouseout
		function() {
			/* var divWidth = $(".a").width();
			var divHeight = $(".a").height(); */
			$(".a").css("border", "none");
		});

	});
</script>
<style type="text/css">
#serviceStat {
	width: 95%;
	position: relative;
	margin: 20px 10px 10px 10px;
}

.a {
	width: 120px;
	float: left;
	color: black;
}

.a a {
	color: black;
}

#faultTd {
	width: 100%;
	height: 100px;
	margin: 0 auto;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	padding-top: 30px;
	background: url(${rootUrl}images/items/fault.png) no-repeat center top;
	position: relative;
}

#consultTd {
	width: 100%;
	height: 100px;
	margin: 0 auto;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	padding-top: 30px;
	background: url(${rootUrl}images/items/consult.png) no-repeat center top;
	position: relative;
}

#serviceTd {
	width: 100%;
	height: 100px;
	margin: 0 auto;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	padding-top: 30px;
	background: url(${rootUrl}images/items/tempservice.png) no-repeat center
		top;
	font-weight: bold;
	position: relative;
}

#noticeTd {
	width: 100%;
	height: 100px;
	margin: 0 auto;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	padding-top: 30px;
	background: url(${rootUrl}images/items/notice.png) no-repeat center top;
	font-weight: bold;
	position: relative;
}

#clientmngTd {
	width: 100%;
	height: 100px;
	margin: 0 auto;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	padding-top: 30px;
	background: url(${rootUrl}images/items/clientmng.png) no-repeat center
		top;
	font-weight: bold;
	position: relative;
}

.msgTip {
	background: url(${rootUrl}images/remind_bubble_red.png) no-repeat;
	text-align: center;
	line-height: 21px;
	font-size: 10px;
	color: yellow;
	position: absolute;
	top: -5px;
	left: 95px;
	right: 0px;
	width: 22px;
	height: 22px;
}

.totalNotice table th {
	border: 1px solid #95BDD7;
	background: #EFF0F2;
	height: 25px;
	color: #1F83B7;
	text-align: right;
	font-size: 13px;
	font-weight: normal;
}

.totalNotice table td {
	border: 1px solid #95BDD7;
	color: #1F83B7;
	height: 25px;
	font-size: 13px;
	color: #000;
	padding-left: 2px;
	text-align: left;
}

.totalNotice .title {
	width: 100%;
	background: url(${rootUrl}images/placebg.jpg) repeat-x center bottom;
	border: 1px solid #95BDD7;
	border-bottom: 0px;
	border-collapse: collapse;
}

.totalNotice .title .td1 {
	font-weight: bold;
	padding-top: 0px;
	width: auto;
	text-align: left;
	border-bottom: 0px;
	border-right: 0px;
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
		<div id="boxright">
			<div id="main">
				<div class="minfo">
					<table style="width: 100%;">
						<tr>
							<td width="30%"><div class="totalNotice">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="title"><img
												src="${rootUrl}images/btn/notice.png" height="25" width="25" />提醒</td>
										</tr>


										<tr>
											<td><div>
													<c:if test="${!emailStatus }">
												[客户通报]<font color="red">邮件发送状态异常</font>
														<div class="clear"></div>
													</c:if>
													<c:if test="${emailStatus }">
												[客户通报]<font color="green">邮件发送状态正常</font>
														<div class="clear"></div>
													</c:if>
													<c:choose>
														<c:when test="${smsStatus!='STARTED' }">
												[客户通报]<font color="red">短信猫连接异常</font>
															<div class="clear"></div>
														</c:when>
														<c:otherwise>
												[客户通报]<font color="green">短信猫连接正常</font>
															<div class="clear"></div>
														</c:otherwise>
													</c:choose>
												</div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div>
												<div class="clear"></div></td>
										</tr>
									</table>
								</div></td>
							<td width="70%"><div class="totalNotice">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="title" colspan="2"><img
												src="${rootUrl}images/btn/notice.png" height="25" width="25" />待办事项（<a style="color: red;">提示：点击下方链接直接进入相应办理栏目</a>）</td>
										</tr>
										<tr>
											<td>
												<div>
													<c:forEach items="${indexnotice}" var="indexnotice">
														<c:if test="${indexnotice.sonMenuType eq 'telegraph'}">
															<span style="width: 120px">[${indexnotice.sonMenuType.name}]：</span>
															<a href="${rootUrl}${indexnotice.url}">有<font
																color="red"><b>${indexnotice.num}</b></font>条申请需要处理！
															</a>
															<div class="clear"></div>
														</c:if>
														<c:if
															test="${indexnotice.sonMenuType eq 'formalcircuit' or indexnotice.sonMenuType eq 'tempcircuit'}">
															<span style="width: 120px">[${indexnotice.sonMenuType.name}]：</span>
															<a href="${rootUrl}${indexnotice.url}">有<font
																color="red"><b>${indexnotice.num}</b></font>条申请需要处理！
															</a>
															<div class="clear"></div>
														</c:if>
														<c:if
															test="${indexnotice.sonMenuType eq 'telegraphcircuit'}">
															<span style="width: 120px">[${indexnotice.sonMenuType.name}]：</span>
											         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											         <a href="${rootUrl}${indexnotice.url}">有<font
																color="red"><b>${indexnotice.num}</b></font>条申请需要处理！
															</a>
															<div class="clear"></div>
														</c:if>
													</c:forEach>
												</div>
											</td>
											<td>
												<div>
													<c:forEach items="${indexnotice}" var="indexnotice">
														<c:if
															test="${indexnotice.sonMenuType eq 'datacomnetwork' or indexnotice.sonMenuType eq 'transfernet' or indexnotice.sonMenuType eq 'kusatellite' or indexnotice.sonMenuType eq 'signoutnet'}">
															<span style="width: 120px">[${indexnotice.sonMenuType.name}]：</span>
															<a href="${rootUrl}${indexnotice.url}">有<font
																color="red"><b>${indexnotice.num}</b></font>条申请需要处理！
															</a>
															<div class="clear"></div>
														</c:if>
													</c:forEach>
												</div>
											</td>
											</tr>
											<c:forEach items="${indexnotice}" var="indexnotice">
												<c:if
													test="${indexnotice.sonMenuType eq 'tempUserRegister'}">
												<tr>
												<td colspan="2">
													<div>
														<span style="width: 120px">[${indexnotice.sonMenuType.name}]：</span>
														<a href="${rootUrl}${indexnotice.url}">有<font
															color="red"><b>${indexnotice.num}</b></font>条申请需要处理！
														</a>
													</div>
												</td>
												</tr>
												<div class="clear"></div>
												</c:if>
											</c:forEach>
									</table>
								</div></td>
						</tr>
						<%-- <tr>
							<td colspan="2"><div class="totalNotice">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="title"><img
												src="${rootUrl}images/btn/notice.png" height="25" width="25" />待办事项</td>
										</tr>
										<tr>
											<td>
											    <div>
											    <c:forEach items="${indexnotice}" var="indexnotice">
											         <span style="width:120px">[${indexnotice.sonMenuType.name}]：</span>
											         <c:if test="${indexnotice.sonMenuType.name eq '正式电路' or indexnotice.sonMenuType.name eq '临时电路'}">
											         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
											         <c:if test="${indexnotice.sonMenuType.name eq '转报网电路'}">
											         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
											         <a href="${rootUrl}${indexnotice.url}">${indexnotice.sonMenuType.name}中有${indexnotice.num}条申请需要处理！</a>
											         <div class="clear"></div>
											    </c:forEach>
												</div>
											</td>
										</tr>
									</table>
								</div></td>
						</tr> --%>
						<tr>
							<td colspan="2">
								<div class="mtab">
									<table style="width: 100%" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td colspan="2" class="title">全国告警统计</td>
										</tr>
										<tr>
											<td><div id="container"
													style="padding-top: 10px; padding-left: 10px; width: 450px; height: 470px;">
												</div></td>
											<td><div class="mtab">
													<table width="95%" border="0" cellspacing="0"
														cellpadding="0" id="statTable">
														<tr class="title">
															<td width="50%">管局</td>
															<td width="50%">告警总数</td>
														</tr>


													</table>
												</div>
												<div id="pieContainer"
													style="min-width: 270px; height: 250px; padding-top: 10px; text-align: center;">
												</div></td>
										</tr>

									</table>

								</div>

							</td>
						</tr>
					</table>
					<div id="serviceStat">
						<div class="a">
							<sec:authorize ifAnyGranted="${jspAuthorities['declaredeal']}">
								<a id="faultNum"
									href="${rootUrl}techsupport/fault/deal/manage.do">
									<div id="faultTd">
										故障申报
										<div class="msgTip">${serviceNotice.faultCount }</div>
									</div>
								</a>
							</sec:authorize>
						</div>
						<div class="a">
							<sec:authorize ifAnyGranted="${jspAuthorities['consultdeal']}">
								<a id="faultNum"
									href="${rootUrl}techsupport/consult/deal/manage.do">
									<div id="consultTd">
										技术支持
										<div class="msgTip">${serviceNotice.techCount }</div>
									</div>
								</a>
							</sec:authorize>
						</div>
						<div class="a">
							<sec:authorize
								ifAnyGranted="${jspAuthorities['tempcircuittask']}">
								<a id="serviceNum" href="${rootUrl}tempcircuit/tasklist.do">
									<div id="serviceTd">
										业务开通
										<div class="msgTip">${serviceNotice.circuitCount }</div>
									</div>
								</a>
							</sec:authorize>
						</div>
						<div class="a">
							<sec:authorize ifAnyGranted="${jspAuthorities['newsdeal']}">
								<a id="noticeNum" href="${rootUrl}news/tab/manage.do">
									<div id="noticeTd">
										通知公告
										<div class="msgTip">${serviceNotice.noticeCount }</div>
									</div>
								</a>
							</sec:authorize>
						</div>
						<div class="a">
							<sec:authorize ifAnyGranted="${jspAuthorities['clientmng']}">
								<a id="clientNum" href="${rootUrl }systemmng/client/manage.do">
									<div id="clientmngTd">
										客户管理
										<div class="msgTip">${serviceNotice.clientCount }</div>
									</div>
								</a>
							</sec:authorize>
						</div>
					</div>

					<!-- 内容页 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>
	<!-- 版权页 -->
</body>
</html>