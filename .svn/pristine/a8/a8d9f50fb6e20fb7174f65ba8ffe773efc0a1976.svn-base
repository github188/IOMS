<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>空调设备巡检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th width="55%" colspan="4">设备名称</th>
					<th width="45%" colspan="2">${accCheck.name }</th>
				</tr>
                <!-- 空调设备巡检内容 -->
                <c:forEach items="${accCheck.accCheckContent }" var="acc">
                    <c:if test="${accCheck.checkType eq 'MONTH' }">
                        <tr>
                            <th width="5%">项目</th>
                            <th width="25%" colspan="2">维护内容</th>
                            <th width="25%">维护标准</th>
                            <th width="25%">运行状态</th>
                            <th width="20%">备注</th>
                        </tr>
                        <!-- 主风机转动 -->
                        <tr>
                            <th width="5%" rowspan="12">艾默生精密空调</th>
                            <th width="25%" colspan="2">主风机转动</th>
                            <th width="25%">转动灵活、无杂音、皮带松紧适度</th>
                            <td width="25%">${acc.mfrStatus.value }</td>
                            <td width="20%">${acc.mfrRemarks }</td>
                        </tr>
                        <!-- 过滤网 -->
                        <tr>
                            <th width="25%" colspan="2">过滤网</th>
                            <th>滤网干净,无尘,无堵塞现象</th>
                            <td>${acc.fsStatus.value }</td>
                            <td>${acc.fsRemarks }</td>
                        </tr>
                        <!--凝结水盘和凝结水管  -->
                        <tr>
                            <th width="25%" colspan="2">凝结水盘和凝结水管  </th>
                            <th>水盘中无异物、凝结水管畅通</th>
                            <td>${acc.cwppStatus.value }</td>
                            <td>${acc.cwppRemarks }</td>
                        </tr>
                        <!-- 蒸发器翅片 -->
                        <tr>
                            <th width="25%" colspan="2">蒸发器翅片</th>
                            <th>洁净无倒扶</th>
                            <td>${acc.efStatus.value }</td>
                            <td>${acc.efRemarks }</td>
                        </tr>
                        <!-- 设备内部、外部表面 -->
                        <tr>
                            <th width="25%" colspan="2">设备内部、外部表面</th>
                            <th>洁净无灰尘</th>
                            <td>${acc.esStatus.value }</td>
                            <td>${acc.esRemarks }</td>
                        </tr>
                        <!-- 设备周围环境 -->
                        <tr>
                            <th width="25%" colspan="2">设备周围环境</th>
                            <th>洁净无杂物</th>
                            <td>${acc.eeStatus.value }</td>
                            <td>${acc.eeRemarks }</td>
                        </tr>
                        <!-- 水盘 -->
                        <tr>
                            <th width="25%" colspan="2">水盘</th>
                            <th>洁净无垢、加湿罐内洁净</th>
                            <td>${acc.wpStatus.value }</td>
                            <td>${acc.wpRemarks }</td>
                        </tr>
                        <!-- 上下排水管线路、水滤网 -->
                        <tr>
                            <th width="25%" colspan="2">上下排水管线路、水滤网</th>
                            <th>畅通无堵塞现象</th>
                            <td>${acc.dplWfStatus.value }</td>
                            <td>${acc.dplWfRemarks }</td>
                        </tr>
                        <!-- 加湿器水位和水漂 -->
                        <tr>
                            <th width="25%" colspan="2">加湿器水位和水漂</th>
                            <th>水位正常、水漂正常</th>
                            <td>${acc.hwlwStatus.value }</td>
                            <td>${acc.hwlwRemarks }</td>
                        </tr>
                        <!-- 空调出风口风速 -->
                        <tr>
                            <th width="25%" colspan="2">空调出风口风速</th>
                            <th>参数在正常值范围内</th>
                            <td>${acc.acwsStatus.value }</td>
                            <td>${acc.acwsRemarks }</td>
                        </tr>
                        <!-- 空调出风口温度 -->
                        <tr>
                            <th width="25%" colspan="2">空调出风口温度</th>
                            <th>参数在正常值范围内</th>
                            <td>${acc.actStatus.value }</td>
                            <td>${acc.actRemarks }</td>
                        </tr>
                        <!-- 空调总接线电压、电流、空调内部压缩机、主风机、室外机电流 -->
                        <tr>
                            <th width="25%" colspan="2">空调总接线电压、电流、空调内部压缩机、主风机、室外机电流</th>
                            <th>各项电流，电压数值正常</th>
                            <td>${acc.acvcStatus.value }</td>
                            <td>${acc.acvcRemarks }</td>
                        </tr>    
                    </c:if>
                    <c:if test="${accCheck.checkType eq 'QUARTER' or accCheck.checkType eq 'YEAR' }">
                        <tr>
                            <th width="5%">项目</th>
                            <th width="5%">维护<br />内容</th>
                            <th width="20%">检查维护内容</th>
                            <th width="25%">检查维护标准</th>
                            <th width="25%">运行状态</th>
                            <th width="20%">备注</th>
                        </tr>
                        <!-- 制冷系统 -->
                        <tr>
                            <th width="5%" rowspan="16">艾默生精密空调</th>
                            <th width="5%" rowspan="5">制冷系统</th>
                            <th width="25%">视镜</th>
                            <th width="25%">视镜内无气泡<br />视镜内液体颜色为绿色或蓝色</th>
                            <td width="25%">${acc.mirrorStatus.value }</td>
                            <td>${acc.mirrorRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">吸排气压力</th>
                            <th width="25%">吸气压力应在70psi左右<br/>排气压力应在250psi左右</th>
                            <td width="25%">${acc.sepStatus.value }</td>
                            <td>${acc.sepRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">制冷管</th>
                            <th width="25%">管线固定牢固<br />保温材料无破损</th>
                            <td width="25%">${acc.rpStatus.value }</td>
                            <td>${acc.rpRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">压缩机工作电流</th>
                            <th width="25%">工作电流在正常值内</th>
                            <td width="25%">${acc.cocStatus.value }</td>
                            <td>${acc.cocRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">室外空调机组内制冷剂压力</th>
                            <th width="25%">制冷剂压力在正常值内</th>
                            <td width="25%">${acc.oacuprStatus.value }</td>
                            <td>${acc.oacurpRemarks }</td>
                        </tr>
                        <!-- 室外冷凝设备 -->
                        <tr>
                            <th width="5%" rowspan="2">室外冷凝设备</th>
                            <th width="20%">电机轴承及风扇</th>
                            <th width="25%">风扇电机转动灵活，无抖动<br />无轴承摩擦杂音</th>
                            <td width="25%">${acc.mbfStatus.value }</td>
                            <td>${acc.mbfRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">冷凝器散热翅片</th>
                            <th width="25%">无灰尘<br />翅片无倒浮现象</th>
                            <td width="25%">${acc.chrfStatus.value }</td>
                            <td>${acc.chrfRemarks }</td>
                        </tr>
                        <!-- 除湿系统 -->
                        <tr>
                            <th width="5%" rowspan="2">除湿系统</th>
                            <th width="20%">水盘</th>
                            <th width="25%">洁净无垢</th>
                            <td width="25%">${acc.wpStatus.value }</td>
                            <td>${acc.wpRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">储水盒、排水管</th>
                            <th width="25%">无积水<br />水管排水畅通</th>
                            <td width="25%">${acc.wsbDpStatus.value }</td>
                            <td>${acc.wsbDpRemarks }</td>
                        </tr>
                        <!-- 加湿系统 -->
                        <tr>
                            <th width="5%" rowspan="3">加湿系统 </th>
                            <th width="20%">水盘和水漂</th>
                            <th width="25%">水位正常、水漂无水垢<br />水盘内洁净无垢、加湿灌内洁净</th>
                            <td width="25%">${acc.wpbStatus.value }</td>
                            <td>${acc.wpbRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">空调加湿情况</th>
                            <th width="25%">加湿情况正常</th>
                            <td width="25%">${acc.achStatus.value }</td>
                            <td>${acc.achRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">加湿器工作电流</th>
                            <th width="25%">加湿器电流在12A左右</th>
                            <td width="25%">${acc.hwcStatus.value }</td>
                            <td>${acc.hwcRemarks }</td>
                        </tr>
                        <!-- 电气系统 -->
                        <tr>
                            <th width="5%" rowspan="4">电气系统</th>
                            <th width="20%">供电电气线路</th>
                            <th width="25%">供电电气线路无老化现象</th>
                            <td width="25%">${acc.pslStatus.value }</td>
                            <td>${acc.pslRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">接线</th>
                            <th width="25%">各接线柱无松动现象</th>
                            <td width="25%">${acc.connStatus.value }</td>
                            <td>${acc.connRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">电气控制部分</th>
                            <th width="25%">室内外机电气控制盘内清洁无尘</th>
                            <td width="25%">${acc.ecpStatus.value }</td>
                            <td>${acc.ecpRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">所有继电器触点、电气元件</th>
                            <th width="25%">所有继电器应按工作要求吸合、断开无杂音</th>
                            <td width="25%">${acc.rcEcStatus.value }</td>
                            <td>${acc.rcEcRemarks }</td>
                        </tr>
                    </c:if>
                </c:forEach>
                <!-- 空调设备数据记录 -->
                <c:forEach items="${accCheck.accDataRecord }" var="adr">
                        <tr><th width="100%" colspan="6">数据记录</th></tr>
                    <tr>
                        <th width="30%" colspan="3">名称</th>
                        <th width="25%">数值</th>
                        <th width="25%">状态</th>
                        <th width="20%">备注</th>
                    </tr>
                    <!-- 总电压 -->
                    <tr>
                        <th width="30%" colspan="3">总电压</th>
                        <td width="25%">${adr.tvValue }</td>
                        <td width="25%">${adr.tvStatus.value }</td>
                        <td width="20%">${adr.tvRemarks }</td>
                    </tr>
                    <!-- 总电流 -->
                    <tr>
                        <th width="30%" colspan="3">总电流</th>
                        <td width="25%">${adr.tcValue }</td>
                        <td width="25%">${adr.tcStatus.value }</td>
                        <td width="20%">${adr.tcRemarks }</td>
                    </tr>
                    <!--1号压缩机电流  -->
                    <tr>
                        <th width="30%" colspan="3">1号压缩机电流</th>
                        <td width="25%">${adr.cconeValue }</td>
                        <td width="25%">${adr.cconeStatus.value }</td>
                        <td width="20%">${adr.cconeRemarks }</td>
                    </tr>
                    <!-- 2号压缩机电流 -->
                    <tr>
                        <th width="30%" colspan="3">2号压缩机电流</th>
                        <td width="25%">${adr.cctwoValue }</td>
                        <td width="25%">${adr.cctwoStatus.value }</td>
                        <td width="20%">${adr.cctwoRemarks }</td>
                    </tr>
                    <!-- 主风机电流 -->
                    <tr>
                        <th width="30%" colspan="3">主风机电流</th>
                        <td width="25%">${adr.mfcValue }</td>
                        <td width="25%">${adr.mfcStatus.value }</td>
                        <td width="20%">${adr.mfcRemarks }</td>
                    </tr>
                    <!-- 室外机电流 -->
                    <tr>
                        <th width="30%" colspan="3">室外机电流</th>
                        <td width="25%">${adr.omcValue }</td>
                        <td width="25%">${adr.omcStatus.value }</td>
                        <td width="20%">${adr.omcRemarks }</td>
                    </tr>
                    <c:if test="${checkType eq 'MONTH' }">
                        <!-- 加湿器电流 -->
                        <tr>
                            <th width="30%" colspan="3">加湿器电流</th>
                            <td width="25%">${adr.hcValue }</td>
                            <td width="25%">${adr.hcStatus.value }</td>
                            <td width="20%">${adr.hcRemarks }</td>
                        </tr>
                    </c:if>
                    <!-- 出风口温湿度 -->
                    <tr>
                        <th width="30%" colspan="3">出风口温湿度</th>
                        <td width="25%">${adr.aothValue }</td>
                        <td width="25%">${adr.aothStatus.value }</td>
                        <td width="20%">${adr.aothRemarks }</td>
                    </tr>
                    <!-- 出风口风速-->
                    <tr>
                        <th width="30%" colspan="3">出风口风速</th>
                        <td width="25%">${adr.aowsValue }</td>
                        <td width="25%">${adr.aowsStatus.value }</td>
                        <td width="20%">${adr.aowsRemarks }</td>
                    </tr>
                    <c:if test="${accCheck.checkType eq 'QUARTER' || accCheck.checkType eq 'YEAR' }">
                        <tr>
                            <th width="10%" rowspan="3" colspan="2">加湿器电流</th>
                            <th width="20%">A</th>
                            <td width="25%">${adr.hcaValue }</td>
                            <td width="25%">${adr.hcaStatus.value }</td>
                            <td width="20%">${adr.hcaRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">B</th>
                            <td width="25%">${adr.hcbValue }</td>
                            <td width="25%">${adr.hcbStatus.value }</td>
                            <td width="20%">${adr.hcbRemarks }</td>
                        </tr>
                        <tr>
                            <th width="20%">C</th>
                            <td width="25%">${adr.hccValue }</td>
                            <td width="25%">${adr.hccStatus.value }</td>
                            <td width="20%">${adr.hccRemarks }</td>
                        </tr>
                    </c:if>
                </c:forEach>
				<tr>
					<th width="30%" colspan="3">操作人：</th>
					<td width="25%">${accCheck.operator.name }</td>
					<th width="25%">巡检时间：</th>
					<td width="20%">
						<fmt:formatDate value="${accCheck.checkTime}" type="both" 
						pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr> 
			</table>
		</div>
	</div>
</body>
</html>