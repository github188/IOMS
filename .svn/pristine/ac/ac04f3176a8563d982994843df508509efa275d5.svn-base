<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>通知公告处理</title>
<link href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jquery/themes/default/style.css" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css" type="text/css" rel="stylesheet" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>

<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js" type="text/javascript"></script>
<script src="${rootUrl }js/activiti/newsworkflow.js" type="text/javascript"></script>

<script type="text/javascript">
	var sType = '${optType}';
	$(function() {
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
				
				6: {sorter: false}
			}, 
			popupRemoveCallback:function(){
				loadTask2();
				loadTask3();
				loadTask4();
				tooldef(sType);
			},
			addCallback:function(){
			    loadTask2();
				loadTask3();
				loadTask4();
				tooldef(sType);
			},
			editCallback:function(){
			    loadTask2();
				loadTask3();
				loadTask4();
				tooldef(sType);
			},
			delCallback:function(){
			    loadTask2();
				loadTask3();
				loadTask4();
				tooldef(sType);
			},
			removeCallback:function(){
			    loadTask2();
				loadTask3();
				loadTask4();
				tooldef(sType);
			}
		});
		loadTask2();
		loadTask3();
		loadTask4();
		tooldef(sType);
		
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select',parseInt(index));
		$("#tabs").tabs({
			select:function(event,ui){
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
	});
	
	function loadTask2() {
		$.ajax({
			type : "GET",
			url : "${rootUrl}news/ajaxLoad.dox?r=" + Math.random(),
			data : {
				type : 'SPONSOR'
			},
			dataType : "json",
			success : function(result) {
				$("#take2").append(
					"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
						+ result.totalCount + "</div>");
			}
		});
	}
	function loadTask3(){
		$.ajax({
			type : "GET",
			url : "${rootUrl}news/ajaxLoad.dox?r=" + Math.random(),
			data : {
				type : 'APPROVE'
			},
			dataType : "json",
			success : function(result) {
				$("#take3").append(
					"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
					+ result.totalCount + "</div>");
			}
		});
	}
	function loadTask4(){
		$.ajax({
			type : "GET",
			url : "${rootUrl}news/ajaxLoad.dox?r=" + Math.random(),
			data : {
				type : 'PUBLISH'
			},
			dataType : "json",
			success : function(result) {
				$("#take4").append(
					"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
					+ result.totalCount + "</div>");
			}
		});
	}
	function tooldef(optType){
	    if(optType == 'SPONSOR'){
		    $('#addButton').show();
	    }else{
		    $('#addButton').hide();
	    }}
	function change(optType) {
		$("#optType").val(optType);
		var q = $("#queryResult");
		/* debugger;
		if(optType=='APPROVE'||optType=='PUBLISH'){
		    $("#queryResult").sortConfig({
					5: {sorter: false},
					6: {sorter: false}
		    });
		} */
		tooldef(optType);
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
						<span class="bold">通知公告处理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}news/tab/manage.do"
									method="post">
								<form:hidden id="optType" path="optType" />
								<div class="clear"></div>
									<div id="tabs">
										<ul >
											<!--<sec:authorize ifAnyGranted="${jspAuthorities['newsbrowse']}">
												<li id="take1" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('BROWSE');">通知公告 </a></li>
											</sec:authorize>-->
											<sec:authorize ifAnyGranted="${jspAuthorities['newssponsor']}">
												<li id="take2" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('SPONSOR');" >通知发起</a>
												</li>
											</sec:authorize>
											<sec:authorize ifAnyGranted="${jspAuthorities['newsapprove']}">
												<li id="take3" style="position: relative;"><a
													id="queryButton" href="#tabs-1" 
													onclick="change('APPROVE');" >待批通知</a>
												</li>
											</sec:authorize>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['newspublish']}">
												<li id="take4" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('PUBLISH');" >待发布通知</a>
												</li>
											</sec:authorize>
											<sec:authorize
												ifAnyGranted="${jspAuthorities['newsmanage']}">
												<li id="take5" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('MANAGE');" >通知删除</a>
												</li>
											</sec:authorize>
											<!--<sec:authorize ifAnyGranted="${jspAuthorities['newsfinish']}">
												<li id="take5" style="position: relative;"><a
													id="queryButton" href="#tabs-1"
													onclick="change('FINISH');">结束</a></li>
											</sec:authorize>-->
										</ul>
										<div id="tabs-1">
											<div class="bclear"></div>
											<!-- 查询条件 -->
											
											<!-- 查询条件 -->
											<div id="searchTool" class="boxbtn" >
												<div id="addButton" >
												<sec:authorize ifAnyGranted="${jspAuthorities['news_add']}">
													<a href="${rootUrl }news/add.do" 
														class="my_add {boxwidth:700,boxheight:610} btn">添加通知公告</a>
												</sec:authorize>
												<br />
												<br />
												</div>
												<div class="info">
													<form:hidden id="index" path="index"/>
													栏目：
													<form:select path="columnEq" cssStyle="width:90px">
														<form:option value=""></form:option>
														<form:options items="${newsColumnEnum}" itemLabel="value" />
													</form:select>
													标题：
													<form:input path="titleLike" size="10" maxlength="30" />
													状态：
													<form:select path="statusSearchEq" cssStyle="width:90px" >
														<form:option value=""></form:option>
														<form:options items="${newsStatusSearchEnum}" itemLabel="value"  />
													</form:select>
													提交时间：
													<input readonly="true" id="startCreateTime" name="startCreateTime" size="15" maxlength="18" class='Wdate' onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endCreateTime\')}'})"/>-
													<input readonly="true" id="endCreateTime" name="endCreateTime" size="15" maxlength="18" class='Wdate' onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startCreateTime\')}'})" />
												</div>
												<a href="#none" class="sbtn" id="queryButton">查询</a> 
												<a href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
											</div>
											<div class="bclear"></div>
											<!-- 查询条件 -->
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" />通知公告处理信息</td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>
												<div id="queryResult"></div>
											</div>
											<br/>
											<br/>
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
</body>
</html>