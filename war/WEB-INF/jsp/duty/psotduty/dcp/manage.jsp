<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>转报巡检</title>
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
<script src="${rootUrl }js/left-tree-menu.js" type="text/javascript"></script>
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
              loadTask('dcpCheck');
              loadTask('oticalCheck');
              loadTask('zjOticalCheck');
              loadTask('txjdOticalCheck');
              loadTask('ddnCheck');
              loadTask('nccCheck');
              loadTask('slhPdsCheck');
              loadTask('txjdPdsCheck');
			}
		});
		//进入页面 统计不同Tab页待操作的记录条数
          loadTask('dcpCheck');
          loadTask('oticalCheck');
          loadTask('zjOticalCheck');
          loadTask('txjdOticalCheck');
          loadTask('ddnCheck');
          loadTask('nccCheck');
          loadTask('slhPdsCheck');
          loadTask('txjdPdsCheck'); 
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
		var checkType = $("#checkType").val();
		var equipType = $("#equipType").val();
		$.ajax({
					type : "GET",
					url : "${rootUrl}duty/psotduty/dcp/ajaxLoad.dox",
					dataType : "json",
					data : {
						optType : optType,
						checkType : checkType,
						equipType : equipType
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
		if(optType=='dcpCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
            loadTask('dcpCheck');
            loadTask('oticalCheck');
            loadTask('zjOticalCheck');
            loadTask('txjdOticalCheck');
            loadTask('ddnCheck');
            loadTask('nccCheck');
            loadTask('slhPdsCheck');
            loadTask('txjdPdsCheck'); 
		} else if(optType=='oticalCheck'){
			$.ajax({
				type : "GET",
				url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
            loadTask('dcpCheck');
            loadTask('oticalCheck');
            loadTask('zjOticalCheck');
            loadTask('txjdOticalCheck');
            loadTask('ddnCheck');
            loadTask('nccCheck');
            loadTask('slhPdsCheck');
            loadTask('txjdPdsCheck'); 
		}  else if(optType=='zjOticalCheck'){
	         $.ajax({
	                type : "GET",
	                url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
	            loadTask('dcpCheck');
	            loadTask('oticalCheck');
	            loadTask('zjOticalCheck');
	            loadTask('txjdOticalCheck');
	            loadTask('ddnCheck');
	            loadTask('nccCheck');
	            loadTask('slhPdsCheck');
	            loadTask('txjdPdsCheck');
		}else if(optType=='txjdOticalCheck'){
	          $.ajax({
                  type : "GET",
                  url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
              loadTask('dcpCheck');
              loadTask('oticalCheck');
              loadTask('zjOticalCheck');
              loadTask('txjdOticalCheck');
              loadTask('ddnCheck');
              loadTask('nccCheck');
              loadTask('slhPdsCheck');
              loadTask('txjdPdsCheck');
		}else if(optType=='ddnCheck'){
	           $.ajax({
                   type : "GET",
                   url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
               loadTask('dcpCheck');
               loadTask('oticalCheck');
               loadTask('zjOticalCheck');
               loadTask('txjdOticalCheck');
               loadTask('ddnCheck');
               loadTask('nccCheck');
               loadTask('slhPdsCheck');
               loadTask('txjdPdsCheck');
		}else if(optType=='nccCheck'){
	          $.ajax({
                  type : "GET",
                  url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
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
              loadTask('dcpCheck');
              loadTask('oticalCheck');
              loadTask('zjOticalCheck');
              loadTask('txjdOticalCheck');
              loadTask('ddnCheck');
              loadTask('nccCheck');
              loadTask('slhPdsCheck');
              loadTask('txjdPdsCheck');
		}else if(optType=='slhPdsCheck'){
	          $.ajax({
                  type : "GET",
                  url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
                  dataType : "json",
                  data : {
                      optType : optType
                  },
                  success : function(result) {
                      $("#name option").remove();
                      var selectHtm = "<option value=''>-请选择-</option>";
                      for(var i = 0 ; i < result.length ; i++){
                    	  if(result[i].value=='十里河楼内综合布线'){
                    		  selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
                    	  }
                      }
                      $("#name").append(selectHtm);
                  }
              }); 
              loadTask('dcpCheck');
              loadTask('oticalCheck');
              loadTask('zjOticalCheck');
              loadTask('txjdOticalCheck');
              loadTask('ddnCheck');
              loadTask('nccCheck');
              loadTask('slhPdsCheck');
              loadTask('txjdPdsCheck');
		}else if(optType=='txjdPdsCheck'){
	          $.ajax({
                  type : "GET",
                  url : "${rootUrl}duty/psotduty/dcp/ajaxEquip.dox",
                  dataType : "json",
                  data : {
                      optType : optType
                  },
                  success : function(result) {
                      $("#name option").remove();
                      var selectHtm = "<option value=''>-请选择-</option>";
                      for(var i = 0 ; i < result.length ; i++){
                    	  if(result[i].value=='通信基地楼内综合布线'){
                    		  selectHtm += "<option value='" +result[i].value +"'>"+result[i].value + "</option>";
                    	  }
                      }
                      $("#name").append(selectHtm);
                  }
              }); 
              loadTask('dcpCheck');
              loadTask('oticalCheck');
              loadTask('zjOticalCheck');
              loadTask('txjdOticalCheck');
              loadTask('ddnCheck');
              loadTask('nccCheck');
              loadTask('slhPdsCheck');
              loadTask('txjdPdsCheck');
		}  else {
            loadTask('dcpCheck');
            loadTask('oticalCheck');
            loadTask('zjOticalCheck');
            loadTask('txjdOticalCheck');
            loadTask('ddnCheck');
            loadTask('nccCheck');
            loadTask('slhPdsCheck');
            loadTask('txjdPdsCheck'); 
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
						<c:if test="${checkType eq 'MONTH' }">
							<span class="bold">传输设备与通讯线路月检</span>
						</c:if>
						<c:if test="${checkType eq 'QUARTER' }">
							<span class="bold">传输设备与通讯线路季检</span>
						</c:if>
						<c:if test="${checkType eq 'YEAR' }">
							<span class="bold">传输设备与通讯线路年检</span>
						</c:if>
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
									name="listForm" action="${rootUrl}duty/psotduty/dcp/manage.do"
									method="post">
									<!-- 保存所选TAB页 -->
									<form:hidden id="optType" path="optType" />
									<c:forEach items="${equipType }" var="et">
										<c:if test="${et eq 'TRANSEQUIP' }">
											<input type="hidden" id="equipType" name="equipType"
												value="${et }" />
										</c:if>
									</c:forEach>
									<input type="hidden" id="checkType" name="checkType"
										value="${checkType }" />
									<!-- 查询条件 -->
									<div id="tabs" style="padding-bottom: 23px">
										<ul>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['psot_check_tab']}">
												<li id="dcpCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('dcpCheck');"> 直流电源设备</a></li>
												<li id="oticalCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-2"
													onclick="change('oticalCheck');"> 光端机设备</a></li>
												<li id="zjOticalCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-3"
													onclick="change('zjOticalCheck');"> 东四总局155光端机</a></li>
												<li id="txjdOticalCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-4"
													onclick="change('txjdOticalCheck');">通信基地光端机设备</a></li>
												<li id="ddnCheck" style="position: relative;"><a
													id="queryButton" href="#tabs-5"
													onclick="change('ddnCheck');">DDN节点机</a></li>
												<c:if test="${checkType eq 'MONTH' }">
													<li id="nccCheck" style="position: relative;"><a
														id="queryButton" href="#tabs-6"
														onclick="change('nccCheck');">网控中心线路</a></li>
												</c:if>
												<c:if
													test="${checkType eq 'QUARTER' or checkType eq 'YEAR' }">
													<li id="slhPdsCheck" style="position: relative;"><a
														id="queryButton" href="#tabs-7"
														onclick="change('slhPdsCheck');">十里河楼内综合布线</a></li>
													<li id="txjdPdsCheck" style="position: relative;"><a
														id="queryButton" href="#tabs-8"
														onclick="change('txjdPdsCheck');">通信基地楼内综合布线</a></li>
												</c:if>
											</sec:authorize>
										</ul>
										<div>
											<!--添加按钮-->
											<div id="tabs-1"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['psot_check_dcp_add']}">
													<div class="boxbtn">
														<a
															href="${rootUrl}duty/psotduty/dcp/add.do?checkType=${checkType}"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<div id="tabs-2"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['psot_check_otical_add']}">
													<div class="boxbtn">
														<a
															href="${rootUrl}duty/psotduty/otical/add.do?checkType=${checkType}"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<div id="tabs-3"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['psot_check_zjotical_add']}">
													<div class="boxbtn">
														<a
															href="${rootUrl}duty/psotduty/zjotical/add.do?checkType=${checkType}"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<div id="tabs-4"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['psot_check_txjdotical_add']}">
													<div class="boxbtn">
														<a
															href="${rootUrl}duty/psotduty/txjdotical/add.do?checkType=${checkType}"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<div id="tabs-5"
												style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
												<sec:authorize
													ifAnyGranted="${jspAuthorities['psot_check_ddn_add']}">
													<div class="boxbtn">
														<a
															href="${rootUrl}duty/psotduty/ddn/add.do?checkType=${checkType}"
															class="my_add {boxwidth:1000,boxheight:700} btn"><img
															src="${rootUrl}images/btn/new.gif" />添加</a>
													</div>
													<div class="bclear"></div>
												</sec:authorize>
											</div>
											<c:if test="${checkType eq 'MONTH' }">
												<div id="tabs-6"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['psot_check_ncc_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/psotduty/ncc/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</div>
											</c:if>
											<c:if
												test="${checkType eq 'QUARTER' or checkType eq 'YEAR' }">
												<div id="tabs-7"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['psot_check_slhpds_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/psotduty/slhpds/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</div>
												<div id="tabs-8"
													style="padding-bottom: 0px; padding-left: 0px; margin: 0px">
													<sec:authorize
														ifAnyGranted="${jspAuthorities['psot_check_txjdpds_add']}">
														<div class="boxbtn">
															<a
																href="${rootUrl}duty/psotduty/txjdpds/add.do?checkType=${checkType}"
																class="my_add {boxwidth:1000,boxheight:700} btn"><img
																src="${rootUrl}images/btn/new.gif" />添加</a>
														</div>
														<div class="bclear"></div>
													</sec:authorize>
												</div>
											</c:if>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="boxbtn">
												<div id="info1" class="info" style="height: 50px">
													<!-- 根据optType选择显示相应的设备名称 -->
													操&nbsp&nbsp作&nbsp&nbsp人：
													<form:input path="operator" size="15" maxlength="50"
														cssStyle="width:190px" />
													设备名称： <select id="name" name="name"
														style="width: 195px; height: 22px">
														<option value="">-请选择-</option>
														<c:forEach items="${dcpName}" var="vo">
															<option value="${vo.value}">${vo.value}</option>
														</c:forEach>
													</select>
													<div class="bclear"></div>
													巡检时间：
													<form:input cssStyle="width:190px ; color:#000"
														path="startTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
														style="cursor: pointer;" />&nbsp&nbsp&nbsp&nbsp&nbsp至&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
													<form:input cssStyle="width:190px ; color:#000"
														path="endTime" cssClass="inputDate" readonly="true"
														onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
													<img src="${rootUrl}images/datePicker.gif"
														onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
														style="cursor: pointer;" />
												</div>
												<br /> <br />
												<a href="#none" class="sbtn" id="queryButton">查询</a> <a
													href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />空调设备巡检</td>
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
	<c:if test="${checkType eq 'MONTH' }">
		<input id="kind" value='month' style="display: none"></input>
	    <input id="item" value='psotdutymonth' style="display: none"></input>
	</c:if>
	<c:if test="${checkType eq 'QUARTER' }">
		<input id="kind" value='season' style="display: none"></input>
	    <input id="item" value='psotdutyquarter' style="display: none"></input>
	</c:if>
	<c:if test="${checkType eq 'YEAR' }">
		<input id="kind" value='year' style="display: none"></input>
	    <input id="item" value='psotdutyyear' style="display: none"></input>
	</c:if>
	<input id="pro" value='environment' style="display: none"></input>
	
</body>
</html>