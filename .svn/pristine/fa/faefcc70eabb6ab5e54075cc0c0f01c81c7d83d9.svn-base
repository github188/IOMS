<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<link rel="shortcut icon" href="${rootUrl }images/index/shortcut.gif" />
<script language="javascript">
	$(document).ready(
			function() {
				//  nav-li hover e
				var num;
				$("#menu_phonemng").hover(function() {
					$('#box-1').slideDown(300);
				}, function() {

					/*下拉框消失*/
					$('#box-1').hide();
				});
				//  hidden-box hover e
				$('.hidden-box').hover(
						function() {
							$(this).show();
						},
						function() {
							$(this).slideUp(200);
							$('#menu_phonemng').children().removeClass()
									.addClass('hover-down');
						});
			});

	var isout = true;//鼠标是否在div内
	var columnNum = 0;
	$(function() {

		$("body").click(function() {
			hideMessage();
		});
		var theA = $("#boxleft a[class$='${param.myMenuId}']");
		if (theA && theA.length > 0) {
			$("#boxleft ul").hide();
			var theId = $(theA).parents("li").addClass("lion").end().parents(
					"ul").show().attr("id").substring(2);
			$("#menu" + theId).addClass("menuon");
		}
		$(".boxbon").click(function() {
			if ($("#boxleft").is(":hidden")) {
				$("#boxleft").animate({
					width : 120
				}, 'fast', 'swing', function() {
					$('#boxright').css("margin-left", "120");
				});
			} else {
				$("#boxleft").animate({
					width : 0,
					opacity : 'hide'
				}, "fast", 'swing', function() {
					$('#boxright').css("margin-left", "0");
				});
			}
		});
		$(".modPass").nyroModal({
			forceType : "iframe",
			minWidth : 500,
			minHeight : 300,
			closeButton : null
		});
		$(".modMyself").nyroModal({
			forceType : "iframe",
			minWidth : 500,
			minHeight : 450,
			closeButton : null
		});
		changeMenu($("#menuId").val());

	});
	function clickMenu(id) {
		changeMenu(id);
		if (id == "index") {
			window.location = "${rootUrl}index.do";
		} else if (id == "phonemng") {
			window.location = "${rootUrl}phonemng/callcenter/manage.do";
		} else {
			window.location = $("#ul_" + id).find("li > a ").attr("href");
		}
	}

	function hideMessage() {

	}

	function changeMenu(id) {
		if (id == "" || id == null) {
			id = "index";
		}
		$("#menu a").removeClass("menuon");
		$("#menu_" + id).addClass("menuon");
		if (id != "index" && id != "phonemng") {
			$("#boxleft ul").hide();
			$("#ul_" + id).show();
			$("#menuId").val(id);
			changeColumn($("#columnId").val());
		}
	}

	function changeColumn(id) {
		if (id == null || id == "") {
			return;
		}
		var checkType = $("#checkType").val();
		//卫星月检、季检、年检强制选中特效   dyl添加
		if (id == "satellitemqy") {
			if (checkType == "MONTH") {
				$("#column_satellitmonth").addClass("columnon");
			} else if (checkType == "QUARTER") {
				$("#column_satellitquarter").addClass("columnon");
			} else if (checkType == "YEAR") {
				$("#column_satellityear").addClass("columnon");
			}
		} else {
			$("#column_" + id).addClass("columnon");
		}
		//window.location = $("#column_" + id).find("li > a ").attr("href");
	}
	function logout() {
		top.location = "${rootUrl}j_spring_security_logout";
		return false;
	}

	function changeColumnMenu(theA) {
		window.location = theA.href;
	}
</script>
<style>
/*隐藏盒子设置*/
div.hidden-box {
	width: 150px;
	border: 1px solid #7295A7;
	border-top: 0;
	position: absolute;
	display: none;
	background: #fff;
	top: 130px;
	left: 70%;
	z-index: 9999;
}

.hidden-box>ul {
	list-style-type: none;
	color: #643519;
	cursor: pointer;
}

.hidden-box li:hover {
	background: #7295A7;
	color: #fff;
}
/*隐藏盒子位置设置*/
.hidden-loc-index {
	left: 50%;
}

.hidden-loc-us {
	left: 220px;
}

.hidden-loc-info {
	left: 330px;
}

.box04 {
	left: 30%;
}
</style>
<!--head-->
<div id="head">
	<dl>
		<dd>
			<img src="${rootUrl }images/logo.png" alt="LOGO" />
		</dd>
		<dt>
			<div class="userinfo">
				<div class="bleft">
					<div class="bright">
						<div id="msg" style="height: 20px; float: left;">
							欢迎您：
							<sec:authentication property="name" />


						</div>
						| <a href="${rootUrl }modPasswd.dox" class="modPass">修改密码</a>| <a
							href="#" onclick="logout();">退出登录</a>| <a
							href="http://132.133.10.193/forum" target="view_window">技术园地</a>
						| <a href="${rootUrl }userManual.dox">用户手册</a>
					</div>
				</div>
			</div>
		</dt>
	</dl>
</div>
<!--head end-->

<!--menu-->



<dl id="menu">
	<dd>
		<input type="hidden" id="menuId" value="${menuId}" /> <input
			type="hidden" id="columnId" value="${columnId}" /><input
			type="hidden" id="checkType" value="${checkType}" />
		<sec:authorize ifAnyGranted="${jspAuthorities['index']}">
			<a href="${rootUrl}index.do" id="menu_index"
				onclick="clickMenu('index')"><img
				src="${rootUrl }images/home.png" width="15px" height="15px"
				align="top" />首页</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['runmng']}">
			<a href="${rootUrl }networkstat/manage.do" id="menu_runmng"
				onclick="clickMenu('runmng')">运行统计</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['techsupport'] }">
			<a href="${rootUrl }techsupport/fault/deal/manage.do"
				id="menu_techsupport" onclick="clickMenu('techsupport')">技术支持</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['tempcircuit'] }">
			<a href="${rootUrl }tempcircuit/tasklist.do" id="menu_tempcircuit"
				onclick="clickMenu('tempcircuit')">业务开通</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['basedatamng']}">
			<a href="${rootUrl }basedata/atm/node/manage.do"
				id="menu_basedatamng" onclick="clickMenu('basedatamng')">数据管理</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['duty']}">
			<a href="${rootUrl }duty/telegraphduty/manage.do" id="menu_duty"
				onclick="clickMenu('duty')">值班巡检</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['news'] }">
			<a href="${rootUrl }news/tab/manage.do" id="menu_news"
				onclick="clickMenu('news')">通知公告</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['maintain'] }">
			<a href="#none" id="menu_maintain" onclick="clickMenu('maintain')">KU维保</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['aclmng']}">
			<a href="${rootUrl }acl/role/manage.do" id="menu_aclmng"
				onclick="clickMenu('aclmng')">访问控制</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['sysmng'] }">
			<a href="${rootUrl }systemmng/systemparam/config.do" id="menu_sysmng"
				onclick="clickMenu('sysmng')">系统管理</a>
			<span class="line"></span>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['turndutymng'] }">
			<a href="${rootUrl }turndutymng/change/manage.do"
				id="menu_turndutymng" onclick="clickMenu('turndutymng')">值班管理</a>
			<span class="line"></span>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['fault_mng'] }">
			<a href="${rootUrl }faultmng/manage.do" id="menu_fault_mng"
				onclick="clickMenu('fault_mng')"> 事件管理</a>
			<span class="line"></span>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['callcenter'] }">
			<a
				href="${rootUrl}phonemng/callcenter/manage.do?callNo=&calledNo=&callType=&ringTime=&agent=&callsheetId=&callerCity=&callerProvince=&type=&callType=&beginTime=&endTime="
				id="menu_phonemng" onclick="clickMenu('phonemng')" class="menuon">呼叫中心</a>


			<%-- <a href="${rootUrl}phonemng/callcenter/manage.do" id="li-1">呼叫中心</a> --%>
			<span class="line"></span>


			<div id="box-1" class="hidden-box hidden-loc-index">
				<ul>

					<li><a href="${rootUrl}phonemng/missedcallmng/manage.do"
						style="width: 120px">未接来电管理</a></li>
					<li><a href="${rootUrl}phonemng/contactsmng/manage.do"
						style="width: 120px">联系人管理</a></li>
					<li><a href="${rootUrl}phonemng/querymng/manage.do"
						style="width: 120px">通话记录</a></li>

					<sec:authorize ifAnyGranted="${jspAuthorities['countmng_call'] }">

						<li><a href="${rootUrl}phonemng/countmng/manage.do"
							style="width: 120px">统计</a></li>
					</sec:authorize>
				</ul>
			</div>
		</sec:authorize>
	</dd>
</dl>
<!--menu end-->