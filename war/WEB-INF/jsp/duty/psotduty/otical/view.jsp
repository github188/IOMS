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
			<dd>传输设备与通讯线路巡检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th width="50%" colspan="2">设备名称</th>
					<th width="50%" colspan="2">${psOtCheck.name }</th>
				</tr>
                <tr>
                    <th width="50%" colspan="2">巡检内容</th>
                    <th width="25%">结果记录</th>
                    <th width="25%">备注</th>
                </tr>
                <!-- 传输设备与通讯线路巡检内容 -->
                <c:forEach items="${psOtCheck.psOtCheckContent }" var="pocc">
                    <!--风扇  -->
                    <tr>
                        <th width="25%" rowspan="3">设备运行环境</th>
                        <th width="25%">风扇</th>
                        <td>${pocc.eoeFanCheckResult.value }</td>
                        <td>${pocc.eoeFanRemarks }</td>
                    </tr>
                    <!-- 温度 -->
                    <tr>
                        <th width="25%">温度</th>
                        <td>${pocc.eoeTemCheckResult }</td>
                        <td>${pocc.eoeTemRemarks }</td>
                    </tr>
                    <!-- 湿度 -->
                    <tr>
                        <th width="25%">湿度</th>
                        <td>${pocc.eoeHumCheckResult }</td>
                        <td>${pocc.eoeHumRemarks }</td>
                    </tr>
                    <!-- 设备指示灯状态 -->
                    <tr>
                        <th width="50%" colspan="2">设备指示灯状态</th>
                        <td>${pocc.disCheckResult.value }</td>
                        <td>${pocc.disRemarks }</td>
                    </tr>
                    <!-- 板卡运行状态 -->
                    <tr>
                        <th width="50%" colspan="2">板卡运行状态</th>
                        <td>${pocc.crsCheckResult.value }</td>
                        <td>${pocc.crsRemarks }</td>
                    </tr>
                    <!-- 设备线缆连接 -->
                    <tr>
                        <th width="50%" colspan="2">设备线缆连接</th>
                        <td>${pocc.dlccCheckResult.value }</td>
                        <td>${pocc.dlccRemarks }</td>
                    </tr>
                    <!-- 电源供电连接 -->
                    <tr>
                        <th width="50%" colspan="2">电源供电连接</th>
                        <td>${pocc.pscCheckResult.value }</td>
                        <td>${pocc.pscRemarks }</td>
                    </tr>
                    <c:if test="${psOtCheck.checkType eq 'QUARTER' or psOtCheck.checkType eq 'YEAR' }">
                        <!-- 接地保护 -->
                        <tr>
                            <th width="50%" colspan="2">接地保护</th>
                            <td>${pocc.gpCheckResult.value }</td>
                            <td>${pocc.gpRemarks }</td>
                        </tr>
                        <!-- DDF、ODF架接头 -->
                        <tr>
                            <th width="50%" colspan="2">DDF、ODF架接头</th>
                            <td>${pocc.ddfOdfCheckResult.value }</td>
                            <td>${pocc.ddfOdfRemarks }</td>
                        </tr>
                        <!-- 光缆使用情况 -->
                        <tr>
                            <th width="50%" colspan="2">光缆使用情况</th>
                            <td>${pocc.ocuCheckResult.value }</td>
                            <td>${pocc.ocuRemarks }</td>
                        </tr>
                        <!-- 光纤标识 -->
                        <tr>
                            <th width="50%" colspan="2">光纤标识</th>
                            <td>${pocc.ofcCheckResult.value }</td>
                            <td>${pocc.ofcRemarks }</td>
                        </tr>
                        <!-- 设备清洁/除尘 -->
                        <tr>
                            <th width="50%" colspan="2">设备清洁/除尘</th>
                            <td>${pocc.ecCheckResult.value }</td>
                            <td>${pocc.ecRemarks }</td>
                        </tr>
                    </c:if>
                </c:forEach>
				<tr>
					<th width="25%">操作人：</th>
					<td width="25%">${psOtCheck.operator.name }</td>
					<th width="25%">巡检时间：</th>
					<td width="25%">
						<fmt:formatDate value="${psOtCheck.checkTime}" type="both" 
						pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr> 
			</table>
		</div>
	</div>
</body>
</html>