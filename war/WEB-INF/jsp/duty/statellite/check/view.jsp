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
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
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
			<dd>仪器仪表清查--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="1">
				<tr>
					<th colspan="4" scope="col">仪器仪表清查检查</th>
				</tr>
				<tr>
					<th width="25%" rowspan="130"><font color="red">(*)</font>巡检内容</th>
					<th width="25%" rowspan="3">频谱仪<br />Agilent E4440A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num1" id="num1" />${vo.num1 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address1"
							id="address1" readonly="readonly">${vo.address1 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark1" id="remark1"
							readonly="readonly">${vo.remark1 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">频谱仪<br />HP8593E
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num2" id="num2" />${vo.num2 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address2"
							id="address2" readonly="readonly">${vo.address2 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark2" id="remark2"
							readonly="readonly">${vo.remark2 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">频谱仪<br />HP8563E
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num3" id="num3" />${vo.num3 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address3"
							id="address3" readonly="readonly">${vo.address3 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark3" id="remark3"
							readonly="readonly">${vo.remark3 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">便携频谱仪<br />Anritsu MS2724B
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num4" id="num4" />${vo.num4 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address4"
							id="address4" readonly="readonly">${vo.address4 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark4" id="remark4"
							readonly="readonly">${vo.remark4 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">信号源<br />Agilent 4437B
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num5" id="num5" />${vo.num5 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address5"
							id="address5" readonly="readonly">${vo.address5 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark5" id="remark5"
							readonly="readonly">${vo.remark5 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">信号源<br />Agilent 8251A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num6" id="num6" />${vo.num6 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address6"
							id="address6" readonly="readonly">${vo.address6 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark6" id="remark6"
							readonly="readonly">${vo.remark6 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">网络分析仪 <br />Agilent 8720ES
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num7" id="num7" />${vo.num7 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address7"
							id="address7" readonly="readonly">${vo.address7 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark7" id="remark7"
							readonly="readonly">${vo.remark7 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">噪声分析仪 <br />Agilent N8975A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num8" id="num8" />${vo.num8 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address8"
							id="address8" readonly="readonly">${vo.address8 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark8" id="remark8"
							readonly="readonly">${vo.remark8 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">矢量分析仪 <br />Agilent 89441A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num9" id="num9" />${vo.num9 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address9"
							id="address9" readonly="readonly">${vo.address9 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark9" id="remark9"
							readonly="readonly">${vo.remark9 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">功率计 <br />Agilent E4416A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num10" id="num10" />${vo.num10 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address10"
							id="address10" readonly="readonly">${vo.address10 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark10"
							id="remark10" readonly="readonly">${vo.remark10 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">交换/控制器<br /> Agilent 3499A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num11" id="num11" />${vo.num11 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address11"
							id="address11" readonly="readonly">${vo.address11 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark11"
							id="remark11" readonly="readonly">${vo.remark11 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">衰减/切换器 <br />11713B
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num12" id="num12" />${vo.num12 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address12"
							id="address12" readonly="readonly">${vo.address12 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark12"
							id="remark12" readonly="readonly">${vo.remark12 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">LAN/GPIB <br />Gateway Agilent
						E5810A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num13" id="num13" />${vo.num13 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address13"
							id="address13" readonly="readonly">${vo.address13 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark13"
							id="remark13" readonly="readonly">${vo.remark13 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">频率计<br />Anritsu MF2412C
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num14" id="num14" />${vo.num14 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address14"
							id="address14" readonly="readonly">${vo.address14 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark14"
							id="remark14" readonly="readonly">${vo.remark14 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">模拟转发器 <br />TAMPA Microwave
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num15" id="num15" />${vo.num15 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address15"
							id="address15" readonly="readonly">${vo.address15 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark15"
							id="remark15" readonly="readonly">${vo.remark15 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">宽带接收机<br /> HP70004
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num16" id="num16" />${vo.num16 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address16"
							id="address16" readonly="readonly">${vo.address16 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark16"
							id="remark16" readonly="readonly">${vo.remark16 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">协议分析仪<br />CTC HCT7000
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num17" id="num17" />${vo.num17 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address17"
							id="address17" readonly="readonly">${vo.address17 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark17"
							id="remark17" readonly="readonly">${vo.remark17 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">协议分析仪<br />CTC HCT6000
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num18" id="num18" />${vo.num18 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address18"
							id="address18" readonly="readonly">${vo.address18 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark18"
							id="remark18" readonly="readonly">${vo.remark18 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">协议分析仪<br />ACTERNA E1&Data Tester
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num19" id="num19" />${vo.num19 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address19"
							id="address19" readonly="readonly">${vo.address19 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark19"
							id="remark19" readonly="readonly">${vo.remark19 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">TA-VB02型<br />2M误码测试仪
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num20" id="num20" />${vo.num20 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address20"
							id="address20" readonly="readonly">${vo.address20 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark20"
							id="remark20" readonly="readonly">${vo.remark20 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">示波器<br />Tektronix DPO7104
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num21" id="num21" />${vo.num21 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address21"
							id="address21" readonly="readonly">${vo.address21 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark21"
							id="remark21" readonly="readonly">${vo.remark21 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">实时频谱仪 <br />Tektronix RSA6106A
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num22" id="num22" />${vo.num22 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address22"
							id="address22" readonly="readonly">${vo.address22 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark22"
							id="remark22" readonly="readonly">${vo.remark22 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">频谱仪<br />Agilent 4407B
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num23" id="num23" />${vo.num23 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address23"
							id="address23" readonly="readonly">${vo.address23 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark23"
							id="remark23" readonly="readonly">${vo.remark23 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">Ku网管软件<br />StreamView软件
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num24" id="num24" />${vo.num24 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address24"
							id="address24" readonly="readonly">${vo.address24 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark24"
							id="remark24" readonly="readonly">${vo.remark24 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">Ku网管<br />Soloris操作系统光盘
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num25" id="num25" />${vo.num25 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address25"
							id="address25" readonly="readonly">${vo.address25 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark25"
							id="remark25" readonly="readonly">${vo.remark25 }</textarea></th>
				</tr>

				<tr>
					<th width="25%" rowspan="3">TES系统网管<br />操作系统软件OpenVMS
					</th>
					<th width="25%">实际数量</th>
					<th width="25%"><input type="hidden" name="num26" id="num26" />${vo.num26 }</th>
				</tr>
				<tr>
					<th width="25%">所在位置</th>
					<th width="25%"><textarea rows="2" name="address26"
							id="address26" readonly="readonly">${vo.address26 }</textarea></th>
				</tr>
				<tr>
					<th width="25%">备注</th>
					<th width="25%"><textarea rows="2" name="remark26"
							id="remark26" readonly="readonly">${vo.remark26 }</textarea></th>
				</tr>

				<tr>
					<th colspan="2">实际数量合计</th>
					<th colspan="2">${vo.total }</th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>