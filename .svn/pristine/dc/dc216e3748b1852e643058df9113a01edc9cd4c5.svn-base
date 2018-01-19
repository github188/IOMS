<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/left-tree-menu.css" />

<div id="boxleft">
	<div id="left-tree1">
		<div class="topbg"></div>
		<div id="menu1" style="padding-left: 2px;">
			<div class="button button-2" id="fax_title">转报</div>
			<div id="fax_div">
				<div class="button button-3" id="fax_div_day">日检</div>
				<div id="fax_div_day_div">
					<div class="button button-4" id="item_faxsystem">
						<sec:authorize ifAnyGranted="${jspAuthorities['fax_day'] }">
							<a class="tiny" href="${rootUrl}duty/fax/day/faxsystem/manage.do"
								id="psotdutymonth">转报系统</a>
						</sec:authorize>

					</div>
					<div class="button button-4">VG系统</div>
					<div class="button button-4">SITA业务</div>
					<div class="button button-4">同步异步</div>
					<div class="button button-4">军航</div>
					<div class="button button-4">路由器</div>
					<div class="button button-4">应急信道</div>
					<div class="button button-4">电报计费</div>
					<div class="button button-4">航信通</div>
					<div class="button button-4">ATN-AMSH</div>
				</div>
				<div class="button button-3" id="fax_div_month">月检</div>
				<div id="fax_div_month_div">
					<div class="button button-4">
						<a href="base-telegraph.html">基地转报系统</a>
					</div>
					<div class="button button-4">
						<a href="amhs.html">AMSH系统</a>
					</div>
					<div class="button button-4">
						<a href="army-telegraph.html">军航转报系统</a>
					</div>
					<div class="button button-4">
						<a href="insert.html">接入设备和产品安全</a>
					</div>
					<div class="button button-4">
						<a href="rest-telegraph.html">转报备件巡检</a>
					</div>
				</div>
				<div class="button button-3" id="fax_div_season">季检</div>
				<div id="fax_div_season_div">
					<div class="button button-4">
						<a href="base-telegraph.html">基地转报系统</a>
					</div>
					<div class="button button-4">
						<a href="amhs.html">AMSH系统</a>
					</div>
					<div class="button button-4">
						<a href="army-telegraph.html">军航转报系统</a>
					</div>
					<div class="button button-4">
						<a href="insert.html">接入设备和产品安全</a>
					</div>
					<div class="button button-4">
						<a href="rest-telegraph.html">转报备件巡检</a>
					</div>
				</div>
				<div class="button button-3" id="fax_div_year">年检</div>
				<div id="fax_div_year_div">
					<div class="button button-4">
						<a href="base-telegraph.html">基地转报系统</a>
					</div>
					<div class="button button-4">
						<a href="amhs.html">AMSH系统</a>
					</div>
					<div class="button button-4">
						<a href="army-telegraph.html">军航转报系统</a>
					</div>
					<div class="button button-4">
						<a href="insert.html">接入设备和产品安全</a>
					</div>
					<div class="button button-4">
						<a href="rest-telegraph.html">转报备件巡检</a>
					</div>
				</div>
			</div>
			<div class="button button-2" id="atm-title">ATM</div>
			<div id="atm_div">
				<div id="atm_div_day" class="button button-3">日检</div>
				<div id="atm_div_day_div">
					<div class="button button-4" id="item_router">
						<sec:authorize ifAnyGranted="${jspAuthorities['router']}">
							<a
								href="${rootUrl}duty/atmday/router/manage.do?atmType=ROUTER"
								id="router">业务路由器</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="item_mgx">
						<sec:authorize ifAnyGranted="${jspAuthorities['mgx']}">
							<a
								href="${rootUrl}duty/atmday/mgx/manage.do?atmType=MGX" id="mgx">MGX交换机</a>
							
						</sec:authorize>
					</div>
				</div>
				<div id="atm_div_month" class="button button-3">月检</div>
				<div id="atm_div_month_div">
					<div class="button button-4">人员分工</div>
					<div class="button button-4">工具借用</div>
					<div class="button button-4">板卡</div>
					<div class="button button-4">安全产品</div>
					<div class="button button-4">设备清查</div>
					<div class="button button-4">备品备件</div>
					<div class="button button-4">业务电路</div>
					<div class="button button-4">ZBBB-MGX</div>
					<div class="button button-4">ZBHQ-MGX</div>
					<div class="button button-4">工作站</div>
					<div class="button button-4">路由器</div>
					<div class="button button-4">以太网交换机</div>
				</div>
				<div class="button button-3">季检</div>
				<div class="button button-3">年检</div>
			</div>

			<div id="satellite-title" class="button button-2">卫星</div>
			<div id="satellite_div">
				<div id="satellite_div_tesday" class="button button-3">TES日检</div>
				<div id="satellite_div_tesday_div">
					<div class="button button-4" id="item_satellitedaytes">
					<sec:authorize ifAnyGranted="${jspAuthorities['satellitedaytes']}">
							<a
								href="${rootUrl}duty/satellite/day/tes/manage.do?optType=txjddatastate"
								id="satellitedaytes">TES网管系统</a>
						</sec:authorize>
					</div>
					<div class="button button-4">
						<a href="">TES控制信道</a>
					</div>
					<div class="button button-4">
						<a href="">TES链路工作状态</a>
					</div>
					<div class="button button-4">
						<a href="">基地雷达广播链路工作状态</a>
					</div>
					<div class="button button-4">
						<a href="">东四TES链路</a>
					</div>
				</div>
				<div id="satellite_div_pesday" class="button button-3">PES日检</div>
				<div id="satellite_div_pesday_div">
					<div class="button button-4">
						<a href="">PES主站ODU</a>
					</div>
					<div class="button button-4">
						<a href="">PES网管系统</a>
					</div>
					<div class="button button-4">
						<a href="">PES中频机架运行情况</a>
					</div>
					<div class="button button-4">
						<a href="">PES基带机架运行情况</a>
					</div>
				</div>
				<div id="satellite_div_kuday" class="button button-3">KU日检</div>
				<div class="button button-3" id="satellite_div_month">月检</div>
				<div id="satellite_div_month_div">
					<div class="button button-4">工具借用</div>
					<div class="button button-4">卫星转发器频带资源使用统计</div>
					<div class="button button-4">通信基地TES</div>
					<div class="button button-4">通信记得KU</div>
					<div class="button button-4">运行设备</div>
					<div class="button button-4">备品备件</div>
					<div class="button button-4">业务电路</div>
					<div class="button button-4">民航局TES</div>
					<div class="button button-4">民航局KU</div>
					<div class="button button-4">十里河KU</div>
				</div>
				<div class="button button-3" id="satellite_div_season">季检</div>
				<div class="button button-3" id="satellite_div_year">年检</div>
			</div>

			<div class="button button-2" id="environment-title">环境</div>
			<div id="environment_div">
				<div class="button button-3" id="environment_div_month">月检</div>
				<div id="environment_div_month_div">
					<div class="button button-4" id="column_upsdutymonth">
						<sec:authorize ifAnyGranted="${jspAuthorities['upsdutymonth']}">
							<a class="tiny"
								href="${rootUrl}duty/upsdutymonth/slhups/manage.do"
								id="upsdutymonth">ups设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="accdutymonth">

						<sec:authorize ifAnyGranted="${jspAuthorities['accduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/accduty/slh/manage.do?checkType=MONTH"
								id="accdutymonth">空调设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="dgdutymonth">
						<sec:authorize ifAnyGranted="${jspAuthorities['dgdutymonth'] }">
							<a class="tiny" href="${rootUrl}duty/dgdutymonth/manage.do"
								id="dgdutymonth">柴油发电机设备</a>

						</sec:authorize>
					</div>
					<div class="button button-4" id="psotdutymonth">
						<sec:authorize ifAnyGranted="${jspAuthorities['psotduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=MONTH"
								id="psotdutymonth">传输设备与通讯线路</a>
						</sec:authorize>
					</div>
				</div>
				<div class="button button-3" id="environment_div_season">季检</div>
				<div id="environment_div_season_div">
					<div class="button button-4" id="column_upsdutyquarter">

						<sec:authorize ifAnyGranted="${jspAuthorities['upsdutyquarter']}">
							<a class="tiny"
								href="${rootUrl}duty/upsdutyquarter/slhups/manage.do"
								id="upsdutyquarter">ups设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="accdutyquarter">
						<sec:authorize ifAnyGranted="${jspAuthorities['accduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/accduty/slh/manage.do?checkType=QUARTER"
								id="accdutyquarter">空调设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="dgdutyquarter">

						<sec:authorize ifAnyGranted="${jspAuthorities['dgdutyquarter'] }">
							<a class="tiny" href="${rootUrl}duty/dgdutyquarter/manage.do"
								id="dgdutyquarter">柴油发电机设备</a>

						</sec:authorize>
					</div>
					<div class="button button-4" id="psotdutyquarter">
						<sec:authorize ifAnyGranted="${jspAuthorities['psotduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=QUARTER"
								id="psotdutyquarter">传输设备与通讯线路</a>
						</sec:authorize>
					</div>
				</div>
				<div class="button button-3" id="environment_div_year">年检</div>
				<div id="environment_div_year_div">
					<div class="button button-4" id="column_upsdutyyear">
						<sec:authorize ifAnyGranted="${jspAuthorities['upsdutyyear']}">
							<a class="tiny"
								href="${rootUrl}duty/upsdutyyear/slhups/manage.do"
								id="upsdutyyear">ups设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="accdutyyear">
						<sec:authorize ifAnyGranted="${jspAuthorities['accduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/accduty/slh/manage.do?checkType=YEAR"
								id="accdutyyear">空调设备</a>
						</sec:authorize>
					</div>
					<div class="button button-4" id="dgdutyyear">
						<sec:authorize ifAnyGranted="${jspAuthorities['dgdutyyear'] }">
							<a class="tiny" href="${rootUrl}duty/dgdutyyear/manage.do"
								id="dgdutyyear">柴油发电机设备</a>

						</sec:authorize>
					</div>
					<div class="button button-4" id="psotdutyyear">
						<sec:authorize ifAnyGranted="${jspAuthorities['psotduty'] }">
							<a class="tiny"
								href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=YEAR"
								id="psotdutyyear">传输设备与通讯线路</a>

						</sec:authorize>
					</div>
				</div>
			</div>
		</div>
		<!--/.menu-->
	</div>
</div>