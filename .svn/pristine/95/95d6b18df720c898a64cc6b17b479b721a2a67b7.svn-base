<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>值班管理</title>
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
<script src="${rootUrl }js/activiti/newsworkflow.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/bootstrap.css" />
<script type="text/javascript">
	$(function() {
		$tabs = $("#tabs").tabs();
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			sortable : false,
			sortConfig : {
				0 : {
					sorter : 'text',
				},
				1 : {
					sorter : 'text',
				},
				2 : {
					sorter : 'text',
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
				}
			}
		});
		$("#tabs").tabs({
			select : function(event, ui) {
				var index = ui.index;
				$("#index").val(ui.index);
			}
		});
		loadCount('ONDUTYMNG');
		loadCount('CHANGEMNG');
		loadCount('DUTYCOUNTMNG');
		//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
		var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
		$tabs.tabs('select', parseInt(index));
	});
	var rootUrl = '${rootUrl }';
	function loadCount(optType) {
		$.ajax({
					optType : "GET",
					//url : "${rootUrl}tempcircuit/count.dox",
					data : {
						optType : optType
					},
					dataType : "json",
					success : function(result) {
						$("#" + optType)
								.append(
										"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
												+ result + "</div>");
					}
				});
	}
	function change(optType) {
		$("#optType").val(optType);
		loadCount('ONDUTYMNG');
		loadCount('CHANGEMNG');
		loadCount('DUTYCOUNTMNG');
		var q = $("#queryResult");
		//页面查询条件控制
		if (optType == "ONDUTYMNG") {
			//交接班记录
			$("#dutyPlaceTab").show();
			$("#dutyRoleTab").show();
			$("#timeTab1").show();
			$("#timeTab2").hide();
			$("#timeTab3").hide();
			$("#remark").show();
			$("#titleremark").show();
		} else if (optType == "CHANGEMNG") {
			//签到离岗记录
			$("#dutyPlaceTab").show();
			$("#dutyRoleTab").show();
			$("#timeTab1").hide();
			$("#timeTab2").show();
			$("#timeTab3").hide();
			$("#remark").hide();
			$("#titleremark").hide();
		} else if (optType == "DUTYCOUNTMNG") {
			//值班时长统计
			$("#dutyPlaceTab").hide();
			$("#dutyRoleTab").hide();
			$("#timeTab1").hide();
			$("#timeTab2").hide();
			$("#timeTab3").show();
			$("#remark").hide();
			$("#titleremark").hide();
		}
	}

	function onLeave(){
		//${rootUrl }turndutymng/change/leave.do
		
		var name=$("#name").val();
		var agentNo=$("#agent").val();
		if(agentNo!="0"){
			var url="http://120.27.133.149/app?Action=SignOut&Account=N00000005689&Exten="+agentNo+"&PBX=bj.ali.3.7";
		    $.get(url,function(data,status){  
		    
		    });
		}
		if(confirm("确定离岗?")) {
			$.ajax({
				type : "GET",
				url : "${rootUrl }turndutymng/leave.dox?name="+name+"",
				dataType : "json",
				success : function(data, status, xhr) {
					alert(data.msg);
					$("action").attr("${rootUrl}turndutymng/manage.do");
					$("#listForm").submit();
					window.top.location.reload();
				}
			});
		}
	}
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
		<div id="boxright">

			<div id="main">
				<!--place-->
				<div id="boxplace">
					<div class="place">
						<span class="bold">值班管理</span>
					</div>
				</div>
				<!--place-->
				<div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
								<form:form modelAttribute="queryModel" id="listForm"
									name="listForm" action="${rootUrl}turndutymng/manage.do"
									method="post">

									<form:hidden id="optType" path="optType" />
									<form:hidden id="index" path="index" />
                                    <input style="display:none" id=name value="${userid}" />
                                    <input style="display:none" id=agent value="${agent}" />
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                         
                                              <c:if test="${signtime !=''}">
                                                <span class="label label-success" style="font-size:10pt;height:20px;">签到时间：${signtime}</span>
                                              </c:if>
                                              <c:if test="${leavetime !=''}">
                                                <span class="label label-info" style="font-size:10pt;height:20px;">离岗时间：${leavetime}</span>
                                              </c:if>
                                              <c:if test="${engstatus !=''}">
                                                 <span class="label label-info" style="font-size:10pt;height:20px;">当前状态：${engstatus}</span>
                                              </c:if>
                                              <c:if test="${isflag=='ON'}">
                                                 <a href="#" class="btn" onclick="onLeave()" style="height:20px;">离岗</a>
                                              </c:if>                                                                                                                     
                                         
                                        </div>
                                    </div>
									<div id="tabs">
										<ul>
											<li id="ONDUTYMNG" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('ONDUTYMNG');">交接班记录</a></li>
											<li id="CHANGEMNG" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('CHANGEMNG');">签到/离岗记录</a></li>
											<li id="DUTYCOUNTMNG" style="position: relative;"><a
												id="queryButton" href="#tabs-1"
												onclick="change('DUTYCOUNTMNG');">值班时长统计</a></li>

										</ul>
										<div id="tabs-1">
											<div class="boxbtn">
												<div class="info">
													<span id="dutyPlaceTab"> 值班地点： <form:select
															path="dutyPlace" id="dutyPlace" cssStyle="width:90px">
															<form:option value=""></form:option>
															<form:options items="${places}" itemLabel="value" />
														</form:select>
													</span> <span id="dutyRoleTab"> 值班角色： <form:select
															path="dutyRole" id="dutyRole" cssStyle="width:90px">
															<form:option value=""></form:option>
															<form:options items="${roles}" itemLabel="value" />
														</form:select>
													</span> 值班人：
													<input id="creater" type="text" name="creater" size="10" maxlength="20" value=""
														onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
														onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
														oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
													<span id="titleremark">内容：</span>
													<input id="remark" type="text" name="remark" size="10" maxlength="20" value=""
														onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
														onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
														oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')" />
													<span id="timeTab1"> 创建日期：</span> <span id="timeTab2">
														签到日期：</span> <span id="timeTab3"> 查询日期范围：</span> <input
														readonly="true" id="startOptTime" name="startOptTime"
														size="15" maxlength="18" class='Wdate'
														onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endOptTime\')}'})" />-
													<input readonly="true" id="endOptTime" name="endOptTime"
														size="15" maxlength="18" class='Wdate'
														onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startOptTime\')}'})" />
												</div>
												<a href="#none" class="sbtn" id="queryButton">查询</a> <a
													href="#none" class="sbtn" onclick="listForm.reset();">重置</a>
											</div>
											<div class="clear"></div>
											<div class="mtab">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0" class="title">
													<tr>
														<td class="td1"><img src="${rootUrl}images/pl1.gif"
															alt="" /></td>
														<td class="td2" id="noteInfo"></td>
													</tr>
												</table>

											</div>
											<div id="queryResult"></div>
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