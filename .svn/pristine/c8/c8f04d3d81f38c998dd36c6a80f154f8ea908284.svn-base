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
                    <!-- 二楼电话线路、数据线路配线线架 -->
                    <tr>
                        <th width="50%" colspan="2">二楼电话线路、数据线路配线线架</th>
                        <td>${pocc.fsTlDlwrCheckResult.value }</td>
                        <td>${pocc.fsTlDlwrRemarks }</td>
                    </tr>
                    <!-- 3楼电话线路、数据线路配线线架 -->
                    <tr>
                        <th width="50%" colspan="2">三楼电话线路、数据线路配线线架</th>
                        <td>${pocc.ftTlDlwrCheckResult.value }</td>
                        <td>${pocc.ftTlDlwrRemarks }</td>
                    </tr>
                    <!-- 4楼电话线路、数据线路配线线架 -->
                    <tr>
                        <th width="50%" colspan="2">四楼电话线路、数据线路配线线架</th>
                        <td>${pocc.ffoTlDlwrCheckResult.value }</td>
                        <td>${pocc.ffoTlDlwrRemarks }</td>
                    </tr>
                    <!-- 五楼电话线路、数据线路配线线架 -->
                    <tr>
                        <th width="50%" colspan="2">五楼电话线路、数据线路配线线架</th>
                        <td>${pocc.ffiTlDlwrCheckResult.value }</td>
                        <td>${pocc.ffiTlDlwrRemarks }</td>
                    </tr>
                    <!-- 六楼电话线路、数据线路配线线架 -->
                    <tr>
                        <th width="50%" colspan="2">六楼电话线路、数据线路配线线架</th>
                        <td>${pocc.fsiTlDlwrCheckResult.value }</td>
                        <td>${pocc.fsiTlDlwrRemarks }</td>
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