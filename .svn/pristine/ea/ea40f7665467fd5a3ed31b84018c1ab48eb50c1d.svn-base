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
                    <!-- 当前主用 -->
                    <tr>
                        <th width="50%" colspan="2">当前主用 </th>
                        <td>${pocc.cmuCheckResult.value }</td>
                        <td>${pocc.cmuRemarks }</td>
                    </tr>
                        <!-- A机主控板卡 -->
                    <tr>
                        <th width="25%" rowspan="13">前面板状态</th>
                        <th width="25%">A机主控板卡</th>
                        <td>${pocc.mcbaCheckResult.value }</td>
                        <td>${pocc.mcbaRemarks }</td>
                    </tr>
                    <!-- A机1号v.35板卡 -->
                    <tr>
                        <th width="25%">A机1号v.35板卡</th>
                        <td>${pocc.cba1CheckResult.value }</td>
                        <td>${pocc.cba1Remarks }</td>
                    </tr>
                    <!-- A机2号v.35板卡 -->
                    <tr>
                        <th width="25%">A机2号v.35板卡</th>
                        <td>${pocc.cba2CheckResult.value }</td>
                        <td>${pocc.cba2Remarks }</td>
                    </tr>
                    <!-- A机3号v.35板卡 -->
                    <tr>
                        <th width="25%">A机3号v.35板卡</th>
                        <td>${pocc.cba3CheckResult.value }</td>
                        <td>${pocc.cba3Remarks }</td>
                    </tr>
                    <!-- A机E1板卡 -->
                    <tr>
                        <th width="25%">A机E1板卡</th>
                        <td>${pocc.cbae1CheckResult.value }</td>
                        <td>${pocc.cbae1Remarks }</td>
                    </tr>
                    <!-- B机主控板卡 -->
                    <tr>
                        <th width="25%">B机主控板卡</th>
                        <td>${pocc.mcbbCheckResult.value }</td>
                        <td>${pocc.mcbbRemarks }</td>
                    </tr>
                    <!-- B机1号v.35板卡 -->
                    <tr>
                        <th width="25%">B机1号v.35板卡</th>
                        <td>${pocc.cbb1v35CheckResult.value }</td>
                        <td>${pocc.cbb1v35Remarks }</td>
                    </tr>
                    <!-- B机2号v.35板卡 -->
                    <tr>
                        <th width="25%">B机2号v.35板卡</th>
                        <td>${pocc.cbb2v35CheckResult.value }</td>
                        <td>${pocc.cbb2v35Remarks }</td>
                    </tr>
                    <!-- B机3号v.35板卡 -->
                    <tr>
                        <th width="25%">B机3号v.35板卡</th>
                        <td>${pocc.cbb3v35CheckResult.value }</td>
                        <td>${pocc.cbb3v35Remarks }</td>
                    </tr>
                    <!-- B机1号v.24板卡-->
                    <tr>
                        <th width="25%">B机1号v.24板卡</th>
                        <td>${pocc.cbb1v24CheckResult.value }</td>
                        <td>${pocc.cbb1v24Remarks }</td>
                    </tr>
                    <!-- B机2号v.24板卡 -->
                    <tr>
                        <th width="25%">B机2号v.24板卡</th>
                        <td>${pocc.cbb2v24CheckResult.value }</td>
                        <td>${pocc.cbb2v24Remarks }</td>
                    </tr>
                    <!-- B机3号v.24板卡 -->
                    <tr>
                        <th width="25%">B机3号v.24板卡</th>
                        <td>${pocc.cbb3v24CheckResult.value }</td>
                        <td>${pocc.cbb3v24Remarks }</td>
                    </tr>
                    <!-- B机E1板卡 -->
                    <tr>
                        <th width="25%">B机E1板卡 </th>
                        <td>${pocc.cbbe1CheckResult.value }</td>
                        <td>${pocc.cbbe1Remarks }</td>
                    </tr>
                    <!-- V.35接口连接 -->
                    <tr>
                        <th width="25%" rowspan="2"> 后面板状态</th>
                        <th width="25%">V.35接口连接</th>
                        <td>${pocc.v35icCheckResult.value }</td>
                        <td>${pocc.v35icRemarks }</td>
                    </tr>
                    <!-- V.24接口连接 -->
                    <tr>
                        <th width="25%">V.24接口连接 </th>
                        <td>${pocc.v24icCheckResult.value }</td>
                        <td>${pocc.v24icRemarks }</td>
                    </tr>
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