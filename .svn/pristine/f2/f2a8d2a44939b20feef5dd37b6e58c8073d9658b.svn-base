<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ups设备年检</title>
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
<script src="${rootUrl }js/left-tree-menu.js" 
type="text/javascript"></script>
<script type="text/javascript">
	var $tabs;
	$(function() {
		//Tab分页功能实现必须添加的部分
		$tabs = $("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable:true,//是否使用页面排序功能
			sortConfig:{  //页面排序的配置
				0: {sorter: "text"}, 
				6: {sorter: false},
				7: {sorter: false}
			},
			//Tab页内操作元素结束后的回调函数
			popupRemoveCallback:function(){
				loadTask('slhUpsCheck');
				loadTask('kuUpsCheck');
				loadTask('txjdUpsCheck');
				loadTask('zjUpsCheck');
			}
		});
		//进入页面 统计不同Tab页待操作的记录条数
		loadTask('slhUpsCheck');
		loadTask('kuUpsCheck');
		loadTask('txjdUpsCheck');
		loadTask('zjUpsCheck');
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select',parseInt(index));
		
		//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
		$("#tabs").tabs({
			select:function(event,ui){
	/* 			alert(ui.index);
				alert(ui.panel);
				alert(ui.tab); */
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
	});
	function loadTask(optType) {
		$.ajax({
					type : "GET",
					url : "${rootUrl}duty/upsdutyyear/slhups/ajaxLoad.dox",
					dataType : "json",
					data : {
						optType : optType
					},
					success : function(result) {
						$("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result.totalCount + "</div>");
					}
				}); 
	}
	
	
	//点击某个Tab页时更新所有Tab页中的待处理条数
	function change(optType) {
		$("#optType").val(optType);
		if(optType=='slhUpsCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/upsdutyyear/slhups/ajaxEquip.dox",
				dataType : "json",
				data : {
					optType : optType
				},
				success : function(result) {
					$("#name option").remove();
					var selectHtm = "<option value=''>-请选择-</option>";
					for(var i = 0 ; i < result.length ; i++){
						selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
					}
					$("#name").append(selectHtm);
				}
			}); 
		    loadTask('slhUpsCheck');
		    loadTask('kuUpsCheck');
		    loadTask('txjdUpsCheck');
		    loadTask('zjUpsCheck');
		} else if(optType=='kuUpsCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/upsdutyyear/slhups/ajaxEquip.dox",
				dataType : "json",
				data : {
					optType : optType
				},
				success : function(result) {
					$("#name option").remove();
					var selectHtm = "<option value=''>-请选择-</option>";
					for(var i = 0 ; i < result.length ; i++){
						selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
					}
					$("#name").append(selectHtm);
				}
			}); 
		    loadTask('kuUpsCheck');
			loadTask('slhUpsCheck');
			loadTask('txjdUpsCheck');
			loadTask('zjUpsCheck');
		} else if(optType=='txjdUpsCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/upsdutyyear/slhups/ajaxEquip.dox",
				dataType : "json",
				data : {
					optType : optType
				},
				success : function(result) {
					$("#name option").remove();
					var selectHtm = "<option value=''>-请选择-</option>";
					for(var i = 0 ; i < result.length ; i++){
						selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
					}
					$("#name").append(selectHtm);
				}
			}); 
		    loadTask('kuUpsCheck');
			loadTask('slhUpsCheck');
			loadTask('txjdUpsCheck');
			loadTask('zjUpsCheck');
		}else if(optType=='zjUpsCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/upsdutyyear/slhups/ajaxEquip.dox",
				dataType : "json",
				data : {
					optType : optType
				},
				success : function(result) {
					$("#name option").remove();
					var selectHtm = "<option value=''>-请选择-</option>";
					for(var i = 0 ; i < result.length ; i++){
						selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
					}
					$("#name").append(selectHtm);
				}
			}); 
		    loadTask('kuUpsCheck');
			loadTask('slhUpsCheck');
			loadTask('txjdUpsCheck');
			loadTask('zjUpsCheck');
		}else {
			loadTask('slhUpsCheck');
			loadTask('kuUpsCheck');
			loadTask('txjdUpsCheck');
			loadTask('zjUpsCheck');
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
		<%@ include file="/WEB-INF/jsp/duty/menu/left.jsp"%>
		<!-- 左侧菜单 -->

		<!-- 内容页 -->
		<div id="boxright">
			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">ups设备年检</span>
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
									name="listForm"
									action="${rootUrl}duty/upsdutyyear/slhups/manage.do"
									method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<c:forEach items="${equipType }" var="et">
										<c:if test="${et eq 'UPS' }">
											<input type="hidden" id="equipType" name="equipType" value="${et }"/>
										</c:if>
									</c:forEach>
									<c:forEach items="${checkType }" var="ct">
										<c:if test="${ct eq 'YEAR' }">
											<input type="hidden" id="checkType" name="checkType" value="${ct }"/>
										</c:if>
									</c:forEach>
									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['ups_check_quarter_tab']}">
												<li id="slhUpsCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('slhUpsCheck');">十里河/双井/财富ups设备巡检 </a></li>
												<li id="kuUpsCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-2"
													onclick="change('kuUpsCheck');">Ku/ATM/军航/网控/机房ups设备巡检</a>
												</li>
												<li id="txjdUpsCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-3"
													onclick="change('txjdUpsCheck');">通信基地ups设备巡检</a></li>
												<li id="zjUpsCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-4"
													onclick="change('zjUpsCheck');">总局ups设备巡检</a></li>
											</sec:authorize>
										</ul>
										<div>
                                            <!--添加按钮-->
                                            <div id="tabs-1" style="padding-bottom:0px ;padding-left:0px; margin: 0px">
                                                <sec:authorize
                                                    ifAnyGranted="${jspAuthorities['slhups_check_year_add']}">
                                                    <div class="boxbtn">
                                                        <a href="${rootUrl}duty/upsdutyyear/slhups/add.do"
                                                            class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                            src="${rootUrl}images/btn/new.gif" />添加</a>
                                                    </div>
                                                    <div class="bclear"></div>
                                                </sec:authorize>
                                            </div>
                                            <div id="tabs-2" style="padding-bottom:0px ;padding-left:0px; margin: 0px">
                                                <sec:authorize
                                                    ifAnyGranted="${jspAuthorities['kuups_check_year_add']}">
                                                    <div class="boxbtn">
                                                        <a href="${rootUrl}duty/upsdutyyear/kuups/add.do"
                                                            class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                            src="${rootUrl}images/btn/new.gif" />添加</a>
                                                    </div>
                                                    <div class="bclear"></div>
                                                </sec:authorize>
                                            </div>
                                            <div id="tabs-3" style="padding-bottom:0px ;padding-left:0px; margin: 0px">
                                                <sec:authorize
                                                    ifAnyGranted="${jspAuthorities['txjdups_check_year_add']}">
                                                    <div class="boxbtn">
                                                        <a href="${rootUrl}duty/upsdutyyear/txjdups/add.do"
                                                            class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                            src="${rootUrl}images/btn/new.gif" />添加</a>
                                                    </div>
                                                    <div class="bclear"></div>
                                                </sec:authorize>
                                            </div>
                                            <div id="tabs-4" style="padding-bottom:0px ;padding-left:0px; margin: 0px">
                                                <sec:authorize
                                                    ifAnyGranted="${jspAuthorities['zjups_check_year_add']}">
                                                    <div class="boxbtn">
                                                        <a href="${rootUrl}duty/upsdutyyear/zjups/add.do"
                                                            class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                            src="${rootUrl}images/btn/new.gif" />添加</a>
                                                    </div>
                                                    <div class="bclear"></div>
                                                </sec:authorize>
                                            </div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
												<div id="info1" class="info" style="height: 50px">
													<!-- 根据optType选择显示相应的设备名称 -->
													操&nbsp&nbsp作&nbsp&nbsp人：
													<form:input path="operator" size="15" maxlength="50" cssStyle="width:190px"/>
													设备名称：
												 	<select id="name" name="name" style="width: 195px;height: 22px">
														<option value="">-请选择-</option>
														<c:forEach items="${slhUpsName}" var="vo">
															<option value="${vo.value}">${vo.value}</option>
														</c:forEach>
													</select> 
													<div class="bclear"></div>
													巡检时间：
													<form:input cssStyle="width:190px ; color:#000" path="startTime"
														cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
														style="cursor: pointer;" />&nbsp&nbsp&nbsp&nbsp&nbsp至&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
													<form:input cssStyle="width:190px ; color:#000" path="endTime"
														cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
														style="cursor: pointer;" />
												</div>
												<br /> <br /><a href="#none" class="sbtn"
													id="queryButton">&nbsp&nbsp查询</a> <a href="#none" class="sbtn"
													onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />ups年检</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<!--查询结果-->
												<div id="queryResult"></div>
												<!--查询结果-->
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
	<input id="pro" value='environment' style="display:none"></input>
	<input id="kind" value='year' style="display:none"></input>
	<input id="item" value='column_upsdutyyear' style="display:none"></input>
</body>
</html>