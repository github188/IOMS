<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ATM日检</title>
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
<script src="${rootUrl }js/left-tree-menu.js" type="text/javascript">
</script>
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
			//loadTask('TXJD_8850');
			//loadTask('TXJD_8830');
			//loadTask('SLH_8850');
			//loadTask('SLH_8830');
			//loadTask('MHJ_8850');
			//loadTask('KGJ_8850');
			//loadTask('CFZX_8830');
		}
	});
	//进入页面 统计不同Tab页待操作的记录条数
	    	//loadTask('TXJD_8850');
			//loadTask('TXJD_8830');
			//loadTask('SLH_8850');
			//loadTask('SLH_8830');
			//loadTask('MHJ_8850');
			//loadTask('KGJ_8850');
			//loadTask('CFZX_8830');
	//页面内刷新之后, 依然显示当前Tab页,而不是跳转到第一个Tab页
	var index = $('#index').val();//取出点击该Tab页时保存的Tab页序号
	$tabs.tabs('select',parseInt(index));
	
	//通过事件绑定将当前tab页序号保存到页面input元素中,等待刷新页面的时候重新取出该值	
	$("#tabs").tabs({
		select:function(event,ui){
			var index = ui.index;
			$("#index").val(ui.index);
		}
	});
});

function loadTask(tabType) {
	$.ajax({
				type : "GET",
				url : "${rootUrl}duty/atmday/mgx/ajaxLoad.dox",
				dataType : "json",
				data : {
					tabType : tabType,
				},
				success : function(result) {
					$("#" + tabType)
							.append(
									"<div style='position:absolute; top:-13px;right:0px;width:22px;height:22px;background-image: url(${rootUrl}images/remind_bubble_red.png);text-align:center;line-height:21px;font-size:10px;color:yellow'>"
											+ result.totalCount + "</div>");
				}
			});  
}  
function change(tabType) {
	$("#tabType").val(tabType);
	if(tabType=='TXJD_8850'){
		$.ajax({
			type : "post",
			url : "${rootUrl}duty/atmday/mgx/manage.do",
			dataType : "json",
			data : {
				tabType : tabType
			}
		}); 
		//loadTask('TXJD_8850');
		//loadTask('TXJD_8830');
		//loadTask('SLH_8850');
		//loadTask('SLH_8830');
		//loadTask('MHJ_8850');
		//loadTask('KGJ_8850');
		//loadTask('CFZX_8830');
	} 
}
	/*    */
	
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
                        <c:if test="${atmType eq 'ROUTER' }">
                            <span class="bold">业务路由器</span>
                        </c:if>
                        <c:if test="${atmType eq 'MGX' }">
                            <span class="bold">MGX交换机日检</span>
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
                                <form:form modelAttribute="queryModel"
                                    id="listForm" name="listForm"
                                    action="${rootUrl}duty/atmday/mgx/manage.do"
                                    method="post">
                                    <!-- 保存所选TAB页 -->
                                    <form:hidden id="tabType"
                                        path="tabType" />
                                    <!-- 查询条件 -->
                                    <div id="tabs"
                                        style="padding-bottom: 23px">
                                        <ul>
                                            <sec:authorize
                                                ifAnyGranted="${jspAuthorities['atm_check_day_tab']}">
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="txjd8850"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('TXJD_8850');">
                                                                                                                                                                        通信基地 8850 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="txjd8830"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('TXJD_8830');">
                                                                                                                                                                        通信基地 8830 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="slh8850"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3"onclick="change('SLH_8850');">
                                                                                                                                                                        十里河8850 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="slh8830"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('SLH_8830');">
                                                                                                                                                                        十里河8830 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="mhj8850"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('MHJ_8850');">
                                                                                                                                                                        民航局8850 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="kgj8850"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('KGJ_8850');">
                                                                                                                                                                        民航局空管局8850 </a></li>
                                                </c:if>
                                                <c:if
                                                    test="${atmType eq 'MGX'}">
                                                    <li id="cfzx8830"
                                                        style="position: relative;"><a
                                                        id="queryButton" href="#tabs-3" onclick="change('CFZX_8830');">
                                                                                                                                                                        财富中心8830 </a></li>
                                                </c:if>
                                            </sec:authorize>
                                        </ul>
                                        <div>
                                            <c:if
                                                test="${atmType eq 'ROUTER' }">
                                                <!--添加按钮-->
                                                <div id="tabs-1"
                                                    style="padding-bottom: 0px; padding-left: 0px; margin: 0px; margin-top: 12px">
                                                    <sec:authorize
                                                        ifAnyGranted="${jspAuthorities['atm_check_router_add']}">
                                                        <div
                                                            class="boxbtn">
                                                            <a
                                                                href="${rootUrl}duty/atmday/router/add.do"
                                                                class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                                src="${rootUrl}images/btn/new.gif" />添加</a>
                                                        </div>
                                                        <div
                                                            class="bclear"></div>
                                                    </sec:authorize>
                                                </div>
                                            </c:if>
                                            <c:if
                                                test="${atmType eq 'MGX'}">
                                                <div id="tabs-3"
                                                    style="padding-bottom: 0px; padding-left: 0px; margin: 0px; margin-top: 12px">
                                                    <sec:authorize
                                                        ifAnyGranted="${jspAuthorities['txjd_check_mgx_add']}">
                                                        <div
                                                            class="boxbtn">
                                                            <a
                                                                href="${rootUrl}duty/atmday/mgx/add.do"
                                                                class="my_add {boxwidth:1000,boxheight:700} btn"><img
                                                                src="${rootUrl}images/btn/new.gif" />添加</a>
                                                        </div>
                                                        <div
                                                            class="bclear"></div>
                                                    </sec:authorize>
                                                </div>
                                            </c:if>
                                            <div class="bclear"></div>
                                            <!-- 查询条件 -->
                                            <div class="boxbtn">
                                                <div id="info1"
                                                    class="info"
                                                    style="height: 50px">
                                                    <!-- 根据optType选择显示相应的设备名称 -->
                                                                                                                                                                操作人：
                                                    <form:input
                                                        path="operator"
                                                        size="15"
                                                        maxlength="50"
                                                        cssStyle="width:190px" />
                                                    &nbsp;&nbsp; 审核人：
                                                    <form:input
                                                        path="auditor"
                                                        size="15"
                                                        maxlength="50"
                                                        cssStyle="width:190px" />
                                                    <div class="bclear"></div>
                                                                                                                                                            巡检时间：
                                                    <form:input
                                                        cssStyle="width:190px ; color:#000"
                                                        path="startTime"
                                                        cssClass="inputDate"
                                                        readonly="true"
                                                        onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\\'endTime\\')}'});" />
                                                    <img
                                                        src="${rootUrl}images/datePicker.gif"
                                                        onclick="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});"
                                                        style="cursor: pointer;" />&nbsp&nbsp&nbsp&nbsp&nbsp至&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                                    <form:input
                                                        cssStyle="width:190px ; color:#000"
                                                        path="endTime"
                                                        cssClass="inputDate"
                                                        readonly="true"
                                                        onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\\'startTime\\')}'});" />
                                                    <img
                                                        src="${rootUrl}images/datePicker.gif"
                                                        onclick="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
                                                        style="cursor: pointer;" />
                                                </div>
                                                <br /> <br /> <a
                                                    href="#none"
                                                    class="sbtn"
                                                    id="queryButton">查询</a>
                                                <a href="#none"
                                                    class="sbtn"
                                                    onclick="listForm.reset();">重置</a>
                                            </div>
                                            <div class="bclear"></div>
                                            <!-- 查询条件 -->
                                            <div class="mtab">
                                                <table width="100%"
                                                    border="0"
                                                    cellspacing="0"
                                                    cellpadding="0"
                                                    class="title">
                                                    <tr>
                                                        <td class="td1"><img
                                                            src="${rootUrl}images/pl1.gif"
                                                            alt="" />ATM设备巡检</td>
                                                        <td class="td2"
                                                            id="noteInfo"></td>
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
    <input id="pro" value='atm' style="display: none"></input>
    <input id="kind" value='day' style="display: none"></input>
    <input id="item" value='item_router' style="display: none"></input>
</body>
</html>