<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>仪器仪表清查--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="4" scope="col">仪器仪表清查检查</th>
	</tr>
	<tr>
		<th width="25%" rowspan="130"><font color="red">(*)</font>巡检内容</th>
		<th width="25%" rowspan="3">频谱仪<br />Agilent E4440A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num1" id="num1"
			value="${vo.num1 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address1" id="address1">${vo.address1 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark1" id="remark1">${vo.remark1 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">频谱仪<br />HP8593E
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num2" id="num2"
			value="${vo.num2 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address2" id="address2">${vo.address2 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark2" id="remark2">${vo.remark2 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">频谱仪<br />HP8563E
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num3" id="num3"
			value="${vo.num3 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address3" id="address3">${vo.address3 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark3" id="remark3">${vo.remark3 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">便携频谱仪<br />Anritsu MS2724B
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num4" id="num4"
			value="${vo.num4 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address4" id="address4">${vo.address4 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark4" id="remark4">${vo.remark4 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">信号源<br />Agilent 4437B
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num5" id="num5"
			value="${vo.num5 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address5" id="address5">${vo.address5 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark5" id="remark5">${vo.remark5 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">信号源<br />Agilent 8251A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num6" id="num6"
			value="${vo.num6 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address6" id="address6">${vo.address6 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark6" id="remark6">${vo.remark6 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">网络分析仪 <br />Agilent 8720ES
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num7" id="num7"
			value="${vo.num7 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address7" id="address7">${vo.address7 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark7" id="remark7">${vo.remark7 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">噪声分析仪 <br />Agilent N8975A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num8" id="num8"
			value="${vo.num8 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address8" id="address8">${vo.address8 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark8" id="remark8">${vo.remark8 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">矢量分析仪 <br />Agilent 89441A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num9" id="num9"
			value="${vo.num9 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address9" id="address9">${vo.address9 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark9" id="remark9">${vo.remark9 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">功率计 <br />Agilent E4416A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num10" id="num10"
			value="${vo.num10 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address10"
				id="address10">${vo.address10 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark10" id="remark10">${vo.remark10 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">交换/控制器<br /> Agilent 3499A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num11" id="num11"
			value="${vo.num11 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address11"
				id="address11">${vo.address11 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark11" id="remark11">${vo.remark11 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">衰减/切换器 <br />11713B
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num12" id="num12"
			value="${vo.num12 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address12"
				id="address12">${vo.address12 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark12" id="remark12">${vo.remark12 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">LAN/GPIB <br />Gateway Agilent
			E5810A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num13" id="num13"
			value="${vo.num13 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address13"
				id="address13">${vo.address13 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark13" id="remark13">${vo.remark13 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">频率计<br />Anritsu MF2412C
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num14" id="num14"
			value="${vo.num14 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address14"
				id="address14">${vo.address14 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark14" id="remark14">${vo.remark14 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">模拟转发器 <br />TAMPA Microwave
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num15" id="num15"
			value="${vo.num15 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address15"
				id="address15">${vo.address15 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark15" id="remark15">${vo.remark15 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">宽带接收机<br /> HP70004
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num16" id="num16"
			value="${vo.num16 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address16"
				id="address16">${vo.address16 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark16" id="remark16">${vo.remark16 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">协议分析仪<br />CTC HCT7000
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num17" id="num17"
			value="${vo.num17 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address17"
				id="address17">${vo.address17 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark17" id="remark17">${vo.remark17 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">协议分析仪<br />CTC HCT6000
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num18" id="num18"
			value="${vo.num18 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address18"
				id="address18">${vo.address18 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark18" id="remark18">${vo.remark18 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">协议分析仪<br />ACTERNA E1&Data Tester
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num19" id="num19"
			value="${vo.num19 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address19"
				id="address19">${vo.address19 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark19" id="remark19">${vo.remark19 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">TA-VB02型<br />2M误码测试仪
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num20" id="num20"
			value="${vo.num20 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address20"
				id="address20">${vo.address20 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark20" id="remark20">${vo.remark20 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">示波器<br />Tektronix DPO7104
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num21" id="num21"
			value="${vo.num21 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address21"
				id="address21">${vo.address21 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark21" id="remark21">${vo.remark21 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">实时频谱仪 <br />Tektronix RSA6106A
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num22" id="num22"
			value="${vo.num22 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address22"
				id="address22">${vo.address22 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark22" id="remark22">${vo.remark22 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">频谱仪<br />Agilent 4407B
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num23" id="num23"
			value="${vo.num23 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address23"
				id="address23">${vo.address23 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark23" id="remark23">${vo.remark23 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">Ku网管软件<br />StreamView软件
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num24" id="num24"
			value="${vo.num24 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address24"
				id="address24">${vo.address24 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark24" id="remark24">${vo.remark24 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">Ku网管<br />Soloris操作系统光盘
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num25" id="num25"
			value="${vo.num25 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address25"
				id="address25">${vo.address25 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark25" id="remark25">${vo.remark25 }</textarea></th>
	</tr>

	<tr>
		<th width="25%" rowspan="3">TES系统网管<br />操作系统软件OpenVMS
		</th>
		<th width="25%">实际数量</th>
		<th width="25%"><input type="text" name="num26" id="num26"
			value="${vo.num26 }" /></th>
	</tr>
	<tr>
		<th width="25%">所在位置</th>
		<th width="25%"><textarea rows="2" name="address26"
				id="address26">${vo.address26 }</textarea></th>
	</tr>
	<tr>
		<th width="25%">备注</th>
		<th width="25%"><textarea rows="2" name="remark26" id="remark26">${vo.remark26 }</textarea></th>
	</tr>

	<tr>
		<th colspan="2">实际数量合计</th>
		<th colspan="2">${vo.total }<input type="hidden" name="total"
			id="total" value="${vo.total }"></th>
	</tr>
</table>


<div class="boxbtn">
	<c:if test="${!view}">
		<div class="btn">
			<a href="#none" id="submit">保存</a>
		</div>
	</c:if>
	<div class="btn">
		<a href="#none" class="close">取消</a>
	</div>
</div>
