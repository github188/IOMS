<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#boxleft a")
				.click(
						function() {
							$("#boxright")
									.html(
											'<div  style="padding:20px;text-align: center;"><img src="${rootUrl}images/loading.gif" style="vertical-align: middle;"/>数据加载中……</div>');
							window.location = this.href;
							return false;
						});
	});
</script>

<div id="boxleft">
	<div class="topbg"></div>

	<ul id="ul_aclmng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['rolemng']}">
			<li id="column_rolemng"><a href="${rootUrl}acl/role/manage.do"
				id="rolemng">角色管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['usermng']}">
			<li id="column_usermng"><a href="${rootUrl}acl/user/manage.do"
				id="usermng">用户管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['resourcemng']}">
			<li id="column_resourcemng"><a
				href="${rootUrl}acl/resource/manage.do" id="ResourceMng">资源管理</a></li>
		</sec:authorize>
	</ul>
	<!-- 丹丹新加的 交接班管理-->
	<ul id="ul_turndutymng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['changemng']}">

			<li id="column_changemng"><a id="changemng"
				href="${rootUrl}turndutymng/change/manage.do">签到/离岗</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['ondutymng']}">
			<li id="column_ondutymng"><a
				href="${rootUrl}turndutymng/manage.do" id="ondutymng">值班管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['duty_recycle']}">
			<li id="column_duty_recycle"><a
				href="${rootUrl}turndutymng/recycle.do" id="duty_recycle">回收站</a></li>
		</sec:authorize>
	</ul>

	<!-- 丹丹新加的 交接班管理-->
	<ul id="ul_fault_mng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['fault_handle']}">
			<li id="column_fault_handle"><a
				href="${rootUrl}faultmng/manage.do" id="fault_handle">事件处置</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['fault_query']}">
			<li id="column_fault_query"><a
				href="${rootUrl}faultmng/count/manage.do" id="fault_query">查询统计</a></li>
		</sec:authorize>

		<!--  <li id="column_count">
    <a href="#" id="count">历史数据</a></li> -->
	</ul>
	<!-- 丹丹新加的 故障处理-->
	<!-- <ul id="ul_faultmng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['createfaultmng']}">	
		<li id="column_createfaultmng"><a id="createfaultmng" 
				href="${rootUrl}faultmng/createfault/manage.do">生成故障单</a></li>
    </sec:authorize>
		
	</ul> -->
	<!-- 丹丹新加的 故障处理-->
	<ul id="ul_runmng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['atmnetworkstat']}">
			<li id="column_atmnetworkstat"><a
				href="${rootUrl}networkstat/manage.do" id="atmnetworkstat">ATM全网统计</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['atmnodedetail']}">
			<li id="column_atmnodedetail"><a
				href="${rootUrl}atmnodedetail/manage.do" id="atmnodedetail">ATM节点详情</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['tesnetworktab']}">
			<li id="column_tesnetworktab"><a
				href="${rootUrl}operstat/tes/stat/manage.do" id="tesnetworktab">TES全网统计</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['kunodestatusstat']}">
			<li id="column_kunodestatusstat"><a
				href="${rootUrl}operstat/ku/stat/manage.do" id="kunodestatusstat">KU网运行统计</a></li>
		</sec:authorize>
	</ul>

	<ul id="ul_basedatamng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['atmnodemng']}">
			<li id="column_atmnodemng"><a
				href="${rootUrl}basedata/atm/node/manage.do" id="atmnodemng">ATM节点管理</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['atmservicemng']}">
			<li id="column_atmservicemng"><a
				href="${rootUrl}basedata/atm/service/manage.do" id="atmservicemng">ATM业务管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['atmtypemng']}">
			<li id="column_atmtypemng"><a
				href="${rootUrl}basedata/atm/type/manage.do" id="atmtypemng">ATM业务类型管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['atmcardmng']}">
			<li id="column_atmcardmng"><a
				href="${rootUrl}basedata/atm/cardruninfo/manage.do" id="atmcardmng">ATM板卡管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['satellitesitemng']}">
			<li id="column_satellitesitemng"><a
				href="${rootUrl}/basedata/satellite/site/manage.do"
				id="attenuatormng">卫星站点管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kunodemng']}">
			<li id="column_kunodemng"><a
				href="${rootUrl}basedata/ku/node/manage.do" id="kunodemng">KU节点管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kuservicemng']}">
			<li id="column_kuservicemng"><a
				href="${rootUrl}basedata/ku/service/manage.do" id="kuservicemng">KU业务管理</a></li>
		</sec:authorize>



		<sec:authorize ifAnyGranted="${jspAuthorities['tesnodemng']}">
			<li id="column_tesnodemng"><a
				href="${rootUrl}basedata/tes/node/manage.do" id="tesnodemng">TES节点管理</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['tesservicemng']}">
			<li id="column_tesservicemng"><a
				href="${rootUrl}basedata/tes/service/manage.do" id="tesnodemng">TES业务管理</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['testelemng']}">
			<li id="column_testelemng"><a
				href="${rootUrl}basedata/tes/tele/manage.do" id="testelemng">TES电话管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['antennamng']}">
			<li id="column_antennamng"><a
				href="${rootUrl}basedata/satellite/antenna/manage.do"
				id="antennamng">天线管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['odumng']}">
			<li id="column_odumng"><a
				href="${rootUrl}basedata/satellite/odu/manage.do" id="odumng">ODU管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['attenuatormng']}">
			<li id="column_attenuatormng"><a
				href="${rootUrl}basedata/satellite/attenuator/manage.do"
				id="attenuatormng">衰减器管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['standardconfig']}">
			<li id="column_standardconfig"><a
				href="${rootUrl}basedata/param/config.do" id="standardconfig">卫星采集参数配置</a></li>
		</sec:authorize>
	</ul>

	<ul id="ul_sysmng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['systemparamconfig']}">
			<li id="column_systemparamconfig"><a
				href="${rootUrl}systemmng/systemparam/config.do"
				id="systemparamconfig">系统参数配置</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['userlogmng']}">
			<li id="column_userlogmng"><a
				href="${rootUrl}systemmng/userlog/manage.do" id="userlogmng">用户日志</a></li>
		</sec:authorize>


		<sec:authorize ifAnyGranted="${jspAuthorities['clientmng']}">

			<li id="column_clientmng"><a
				href="${rootUrl }systemmng/client/manage.do">客户管理</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['clientcompanymng']}">

			<li id="column_clientcompanymng"><a
				href="${rootUrl }systemmng/clientcompany/manage.do">客户单位管理</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['clientlogmng']}">
			<li id="column_clientlogmng"><a
				href="${rootUrl }systemmng/clientlog/manage.do">客户日志</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['clientnoticemng']}">
			<li id="column_clientnoticemng"><a
				href="${rootUrl }systemmng/clientnotice/manage.do">客户通知日志</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['smssend']}">
			<li id="column_smssend"><a
				href="${rootUrl }systemmng/sms/send.do">短信发送</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['sys_deptmng']}">
			<li id="column_sys_deptmng"><a
				href="${rootUrl }systemmng/deptinfomng/manage.do">用户部门管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['sys_callcontrol']}">
			<li id="column_sys_callcontrol"><a
				href="${rootUrl }phonemng/callcontrol/manage.do">呼叫中心监控</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['exportcallrecord']}">
			<li id="column_exportcallrecord"><a
				href="${rootUrl }phonemng/exportcall.do">通话记录</a></li>
		</sec:authorize>
	</ul>

	<ul id="ul_techsupport" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['declaredeal']}">
			<li id="column_declaredeal"><a
				href="${rootUrl}techsupport/fault/deal/manage.do" id="declaredeal">故障申报处理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['declarerecord']}">
			<li id="column_declarerecord"><a
				href="${rootUrl}techsupport/fault/record/manage.do"
				id="declarerecord">故障申报记录</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['consultdeal']}">
			<li id="column_consultdeal"><a
				href="${rootUrl}techsupport/consult/deal/manage.do" id="consultdeal">技术咨询处理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['consultrecord']}">
			<li id="column_consultrecord"><a
				href="${rootUrl}techsupport/consult/record/manage.do"
				id="consultrecord">技术咨询记录</a></li>
		</sec:authorize>
	</ul>
	<ul id="ul_tempcircuit" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['tempcircuittask']}">
			<li id="column_tempcircuittask"><a
				href="${rootUrl}tempcircuit/tasklist.do" id="tempcircuittask">临时电路处理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['tempcircuitmng']}">
			<li id="column_tempcircuitmng"><a
				href="${rootUrl}tempcircuit/manage.do" id="tempcircuitmng">临时电路记录</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuitmng']}">
			<li id="column_formalcircuitmng"><a
				href="${rootUrl}formalcircuit/tasklist.do" id="formalcircuitmng">数据网正式电路</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['telegraphmng']}">
			<li id="column_telegraphmng"><a
				href="${rootUrl}telegraph/tasklist.do" id="telegraphmng">转报网路由地址</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['telegraphcircuitmng']}">
			<li id="column_telegraphcircuitmng"><a
				href="${rootUrl}telegraphcircuit/tasklist.do" id="telegraphmng">转报网电路</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kusatellitemng']}">
			<li id="column_kusatellitemng"><a
				href="${rootUrl}kusatellite/tasklist.do" id="kusatellitemng">卫星通信网地球站入网</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['datacomnetworkmng']}">
			<li id="column_datacomnetworkmng"><a
				href="${rootUrl}datacomnetwork/tasklist.do" id="datacomnetworkmng">数据通信网节点入网</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['transfernetmng']}">
			<li id="column_transfernetmng"><a
				href="${rootUrl}transfernet/tasklist.do" id="transfernetmng">自动转报网节点入网</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['signoutnetmng']}">
			<li id="column_signoutnetmng"><a
				href="${rootUrl}signoutnet/tasklist.do" id="signoutnetmng">通信网退网</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['taskrecordmng']}">
			<li id="column_taskrecordmng"><a
				href="${rootUrl}taskrecord/manage.do" id="taskrecordmng">申请记录查询</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['roletransfer']}">
			<li id="column_roletransfer"><a
				href="${rootUrl}roletransfer/manage.do" id="roletransfer">代理人管理</a></li>
		</sec:authorize>
	</ul>
	<ul id="ul_duty" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['telegraphduty']}">
			<li id="column_telegraphduty"><a
				href="${rootUrl}duty/telegraphduty/manage.do" id="telegraphduty">转报巡检</a></li>
		</sec:authorize>

		<sec:authorize ifAnyGranted="${jspAuthorities['router']}">
			<li id="column_router"><a
				href="${rootUrl}duty/atmday/router/manage.do?atmType=ROUTER"
				id="router">业务路由器</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['mgx']}">
			<li id="column_mgx"><a
				href="${rootUrl}duty/atmday/mgx/manage.do?atmType=MGX" id="mgx">MGX交换机</a>
			</li>
		</sec:authorize>

		<!-- renyujuan add 20160712 ups设备巡检-->
		<sec:authorize ifAnyGranted="${jspAuthorities['upsdutymonth']}">
			<li id="column_upsdutymonth"><a
				href="${rootUrl}duty/upsdutymonth/slhups/manage.do"
				id="upsdutymonth">ups设备月检</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['upsdutyquarter']}">
			<li id="column_upsdutyquarter"><a
				href="${rootUrl}duty/upsdutyquarter/slhups/manage.do"
				id="upsdutyquarter">ups设备季检</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['upsdutyyear']}">
			<li id="column_upsdutyyear"><a
				href="${rootUrl}duty/upsdutyyear/slhups/manage.do" id="upsdutyyear">ups设备年检</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['dgdutymonth'] }">
			<li id="dgdutymonth"><a
				href="${rootUrl}duty/dgdutymonth/manage.do" id="dgdutymonth">柴油发电机设备月检</a>
			</li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['dgdutyquarter'] }">
			<li id="dgdutyquarter"><a
				href="${rootUrl}duty/dgdutyquarter/manage.do" id="dgdutyquarter">柴油发电机设备季检</a>
			</li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['dgdutyyear'] }">
			<li id="dgdutyyear"><a
				href="${rootUrl}duty/dgdutyyear/manage.do" id="dgdutyyear">柴油发电机设备年检</a>
			</li>
		</sec:authorize>
		<!--空调设备巡检  -->
		<sec:authorize ifAnyGranted="${jspAuthorities['accduty'] }">
			<li id="accdutymonth"><a
				href="${rootUrl}duty/accduty/slh/manage.do?checkType=MONTH"
				id="accdutymonth">空调设备月检</a></li>
			<li id="accdutyquarter"><a
				href="${rootUrl}duty/accduty/slh/manage.do?checkType=QUARTER"
				id="accdutyquarter">空调设备季检</a></li>
			<li id="accdutyyear"><a
				href="${rootUrl}duty/accduty/slh/manage.do?checkType=YEAR"
				id="accdutyyear">空调设备年检</a></li>
		</sec:authorize>
		<!-- 传输设备与通信线路巡检 -->
		<sec:authorize ifAnyGranted="${jspAuthorities['psotduty'] }">
			<li id="psotdutymonth"><a
				href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=MONTH"
				id="psotdutymonth">传输设备与通讯线路月检</a></li>
			<li id="psotdutyquarter"><a
				href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=QUARTER"
				id="psotdutyquarter">传输设备与通讯线路季检</a></li>
			<li id="psotdutyyear"><a
				href="${rootUrl}duty/psotduty/dcp/manage.do?checkType=YEAR"
				id="psotdutyyear">传输设备与通讯线路年检</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['satellitedaytes'] }">
			<li id="column_satellite"><a
				href="${rootUrl}duty/satellite/day/tes/manage.do?optType=txjddatastate"
				id="satellite">卫星日检</a></li>
		</sec:authorize>

		<!-- 段衍林  卫星自检日检 2016-11-10 start -->
		<sec:authorize ifAnyGranted="${jspAuthorities['satellitedayauto']}">
			<li id="column_satellitedayauto"><a
				href="${rootUrl}duty/satellitedayauto/manage.do"
				id="satellitedayauto">卫星日检（自检）</a></li>
		</sec:authorize>
		<!-- 段衍林  卫星自检日检 2016-11-16  end -->

		<sec:authorize ifAnyGranted="${jspAuthorities['satellitemqy'] }">
			<li id="column_satellitmonth"><a
				href="${rootUrl}duty/statellite/tool/manage.do?checkType=MONTH"
				id="satellitmonth">卫星月检</a></li>
			<li id="column_satellitquarter"><a
				href="${rootUrl}duty/statellite/tool/manage.do?checkType=QUARTER"
				id="satellitquarter">卫星季检</a></li>
			<li id="column_satellityear"><a
				href="${rootUrl}duty/statellite/tool/manage.do?checkType=YEAR"
				id="satellityear">卫星年检</a></li>
		</sec:authorize>
		<!-- 段衍林  卫星自检日检 2016-11-28 start -->
		<sec:authorize ifAnyGranted="${jspAuthorities['satelliteinfo']}">
			<li id="column_satelliteinfo"><a
				href="${rootUrl}duty/satelliteinfo/manage.do" id="satelliteinfo">卫星备件信息库</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['satellitetool']}">
			<li id="column_satellitetool"><a
				href="${rootUrl}duty/satellitetool/manage.do" id="satellitetool">卫星工具库</a></li>
		</sec:authorize>
		<!-- 段衍林  卫星自检日检 2016-11-29  end -->
		<!-- <li id="column_count"><a href="#" id="count">历史数据</a></li> -->
	</ul>
	<ul id="ul_publicnoticemng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnotice']}">
			<li id="column_publicnotice"><a
				href="${rootUrl}publicnotice/pn/manage.do" id="publicnotice">通知公告管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnoticeapp']}">
			<li id="column_publicnoticeapp"><a
				href="${rootUrl}publicnotice/pn/approval.do" id="publicnoticeapp">通知公告审批</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnoticepress']}">
			<li id="column_publicnoticepress"><a
				href="${rootUrl}publicnotice/pn/press.do" id="publicnoticepress">通知公告发布</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['pnnoticelog']}">
			<li id="column_pnnoticelog"><a
				href="${rootUrl}publicnotice/pnlog/manage.do" id="pnnoticelog">通知公告日志管理</a></li>
		</sec:authorize>
	</ul>


	<ul id="ul_news" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['newsdeal']}">
			<li id="column_newsdeal"><a href="${rootUrl}news/tab/manage.do"
				id="newsdeal">通知公告处理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['newsrecord']}">
			<li id="column_newsrecord"><a
				href="${rootUrl}news/browse/manage.do" id="newsrecord">通知公告记录</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['newslog']}">
			<li id="column_newslog"><a href="${rootUrl}news/log/manage.do"
				id=newslog>通知公告日志</a></li>
		</sec:authorize>
	</ul>

	<ul id="ul_maintain" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['alarminfo']}">
			<li id="column_alarminfo"><a
				href="${rootUrl}maintain/alarminfo/manage.do" id="alarminfo">告警信息</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['pollinginfo']}">
			<li id="column_pollinginfo"><a
				href="${rootUrl}maintain/pollinginfo/manage.do" id="pollinginfo">轮询信息</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['kucircuit']}">
			<li id="column_kucircuit"><a
				href="${rootUrl}maintain/kucircuit/manage.do" id="kucircuit">KU电路配置</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['equipnode']}">
			<li id="column_equipnode"><a
				href="${rootUrl}maintain/equipnode/manage.do" id="equipnode">设备节点配置</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['satellitereport']}">
			<li id="column_satellitereport"><a
				href="${rootUrl}maintain/satellite/manage.do" id="satellitereport">卫星站点信息</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['equipmobile']}">
			<li id="column_equipmobile"><a
				href="${rootUrl}maintain/equipmobile/manage.do" id="equipmobile">设备绑定手机配置</a></li>
		</sec:authorize>
	</ul>

	<ul id="ul_phonemng" style="display: none">
		<sec:authorize ifAnyGranted="${jspAuthorities['callcenter']}">
			<li id="column_callcenter"><a
				href="${rootUrl}phonemng/callcenter/manage.do?CallState=&Begin=&End=&RecordFile=&Ring=&CallType=&CallSheetID=&Agent=&CallNo=&CalledNo=&District=&Province=&FileServer="
				id="callcenter">呼叫中心</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['missedcallmng']}">
			<li id="column_missedcallmng"><a
				href="${rootUrl}phonemng/missedcallmng/manage.do" id="missedcallmng">未接来电</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['contactsmng']}">
			<li id="column_contactsmng"><a
				href="${rootUrl}phonemng/contactsmng/manage.do" id="contactsmng">联系人管理</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['query_count']}">
			<li id="column_query_count"><a
				href="${rootUrl}phonemng/querymng/manage.do" id="query_count">查询统计</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['equipmobile']}">
			<li id="column_equipmobile"><a
				href="${rootUrl}maintain/equipmobile/manage.do" id="equipmobile">设备绑定手机配置</a></li>
		</sec:authorize>
	</ul>

</div>
