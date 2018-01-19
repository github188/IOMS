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
font {
	color: red;
	font-weight: bold;
}
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
			<dd>${checkData.equipName.value }自检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="2">设备名称</th>
					<th colspan="3">${checkData.equipName.value }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="104">巡检内容</th>

					<th width="20%" rowspan="6">ODU温度</th>
					<th width="40%" colspan="2">ODU_A-UCT</th>
					<th width="20%">${checkData.uctAtemp }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_A-DCT</th>
					<th width="20%">${checkData.dctAtemp }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_A-MCT</th>
					<th width="20%">${checkData.mctAtemp }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_B-UCT</th>
					<th width="20%">${checkData.uctBtemp }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_B-DCT</th>
					<th width="20%">${checkData.dctBtemp }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_B-MCT</th>
					<th width="20%">${checkData.mctBtemp }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="8">ODU参数</th>
					<th width="40%" colspan="2">UCF_A(MHz)</th>
					<th width="20%">${checkData.odutAucf }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">odutAuca(MHz)</th>
					<th width="20%">${checkData.odutAuca }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">DCF_A(MHz)</th>
					<th width="20%">${checkData.odutAdcf }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">DCA_A(dB)</th>
					<th width="20%">${checkData.odutAdca }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">UCF_B(MHz)</th>
					<th width="20%">${checkData.odutBucf }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">odutBuca(MHz)</th>
					<th width="20%">${checkData.odutBuca }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">DCF_B(MHz)</th>
					<th width="20%">${checkData.odutBdcf }</th>
				</tr>
				<tr>
					<th width="40%" colspan="2">DCA_B(dB)</th>
					<th width="20%">${checkData.odutBdca }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">ODU状态</th>
					<th width="40%" colspan="2">ODU_A</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.odusAresult eq 'OK'}">
	${checkData.odusAresult }
	</c:when>
							<c:otherwise>
								<font>${checkData.odusAresult }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="40%" colspan="2">ODU_B</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.odusBresult eq 'OK'}">
	${checkData.odusBresult }
	</c:when>
							<c:otherwise>
								<font>${checkData.odusBresult }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%" rowspan="10">KU网管工作站状态</th>
					<th width="20%" rowspan="2">子网1</th>
					<th width="20%">工作站状态</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.net1Work eq 'OK'}">
	${checkData.net1Work }
	</c:when>
							<c:otherwise>
								<font>${checkData.net1Work }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%">在线MAP图</th>
					<th width="20%">${checkData.net1Map }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">子网2</th>
					<th width="20%">工作站状态</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.net2Work eq 'OK'}">
	${checkData.net2Work }
	</c:when>
							<c:otherwise>
								<font>${checkData.net2Work }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%">在线MAP图</th>
					<th width="20%">${checkData.net2Map }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">子网3</th>
					<th width="20%">工作站状态</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.net3Work eq 'OK'}">
	${checkData.net3Work }
	</c:when>
							<c:otherwise>
								<font>${checkData.net3Work }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%">在线MAP图</th>
					<th width="20%">${checkData.net3Map }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">子网4</th>
					<th width="20%">工作站状态</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.net4Work eq 'OK'}">
	${checkData.net4Work }
	</c:when>
							<c:otherwise>
								<font>${checkData.net4Work }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%">在线MAP图</th>
					<th width="20%">${checkData.net4Map }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">FR小网</th>
					<th width="20%">工作站状态</th>
					<th width="20%"><c:choose>
							<c:when test="${checkData.netfrWork eq 'OK'}">
	${checkData.netfrWork }
	</c:when>
							<c:otherwise>
								<font>${checkData.netfrWork }</font>
							</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th width="20%">在线MAP图</th>
					<th width="20%">${checkData.netfrMap }</th>
				</tr>

				<!--------------------------------------------- 子网1的0号节点    开始------------------------------->
				<tr>
					<th width="20%" rowspan="8">子网1的0号节点</th>
					<th width="20%" rowspan="2">收0号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net10Rx0Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net10Eb0Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">收1号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net10Rx1Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net10Eb1Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">收民航局130号节点</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net10Rx130Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net10Eb130Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">载波频谱(dBm)</th>
					<th width="20%">峰值</th>
					<th width="20%">${checkData.net10PeakShow }</th>
				</tr>
				<tr>
					<th width="20%">底噪</th>
					<th width="20%">${checkData.net10NoiseShow }</th>
				</tr>

				<tr>
					<th width="20%" rowspan="10">子网1时钟参考节点</th>
					<th width="20%" rowspan="5">主时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net1Znum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net1Zweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net1Zstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net1ZrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net1ZebShow }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="5">备时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net1Bnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net1Bweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net1Bstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net1BrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net1BebShow }</th>
				</tr>
				<!--------------------------------------------- 子网1的0号节点    结束------------------------------->

				<!--------------------------------------------- 子网2的0号节点    开始------------------------------->
				<tr>
					<th width="20%" rowspan="6">子网2的0号节点</th>
					<th width="20%" rowspan="2">收0号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net20Rx0Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net20Eb0Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">收1号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net20Rx1Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net20Eb1Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">载波频谱(dBm)</th>
					<th width="20%">峰值</th>
					<th width="20%">${checkData.net20PeakShow }</th>
				</tr>
				<tr>
					<th width="20%">底噪</th>
					<th width="20%">${checkData.net20NoiseShow }</th>
				</tr>

				<tr>
					<th width="20%" rowspan="10">子网2时钟参考节点</th>
					<th width="20%" rowspan="5">主时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net2Znum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net2Zweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net2Zstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net2ZrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net2ZebShow }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="5">备时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net2Bnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net2Bweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net2Bstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net2BrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net2BebShow }</th>
				</tr>

				<!----------------------------- 子网2的0号节点    结束------------------------------------>

				<!----------------------------- 子网3的0号节点    开始------------------------------------->
				<tr>
					<th width="20%" rowspan="6">子网3的0号节点</th>
					<th width="20%" rowspan="2">收0号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net30Rx0Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net30Eb0Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">收1号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net30Rx1Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net30Eb1Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">载波频谱(dBm)</th>
					<th width="20%">峰值</th>
					<th width="20%">${checkData.net30PeakShow }</th>
				</tr>
				<tr>
					<th width="20%">底噪</th>
					<th width="20%">${checkData.net30NoiseShow }</th>
				</tr>

				<tr>
					<th width="20%" rowspan="10">子网3时钟参考节点</th>
					<th width="20%" rowspan="5">主时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net3Znum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net3Zweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net3Zstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net3ZrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net3ZebShow }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="5">备时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net3Bnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net3Bweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net3Bstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net3BrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net3BebShow }</th>
				</tr>
				<!----------------------------- 子网3的0号节点    结束------------------------------------->

				<!----------------------------- 子网4的0号节点    开始------------------------------------->
				<tr>
					<th width="20%" rowspan="6">子网4的0号节点</th>
					<th width="20%" rowspan="2">收0号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net40Rx0Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net40Eb0Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">收1号节点(dB)</th>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net40Rx1Show }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net40Eb1Show }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="2">载波频谱(dBm)</th>
					<th width="20%">峰值</th>
					<th width="20%">${checkData.net40PeakShow }</th>
				</tr>
				<tr>
					<th width="20%">底噪</th>
					<th width="20%">${checkData.net40NoiseShow }</th>
				</tr>

				<tr>
					<th width="20%" rowspan="10">子网4时钟参考节点</th>
					<th width="20%" rowspan="5">主时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net4Znum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net4Zweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net4Zstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net4ZrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net4ZebShow }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="5">备时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.net4Bnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.net4Bweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.net4Bstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.net4BrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.net4BebShow }</th>
				</tr>
				<!----------------------------- 子网4的0号节点    结束------------------------------------->

				<!----------------------------- FR小网的0号节点    开始------------------------------------->
				<tr>
					<th width="20%" rowspan="2">FR小网0号载波频谱</th>
					<th width="40%" colspan="2">峰值</th>
					<th width="20%">${checkData.frPeakShow }</th>
				</tr>
				<tr>
					<th width="20%" colspan="2">底噪</th>
					<th width="20%">${checkData.frNoiseShow }</th>
				</tr>

				<tr>
					<th width="20%" rowspan="10">FR小网时钟参考节点</th>
					<th width="20%" rowspan="5">主时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.netfrZnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.netfrZweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.netfrZstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.frZrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.frZebShow }</th>
				</tr>
				<tr>
					<th width="20%" rowspan="5">备时钟</th>
					<th width="20%">节点号</th>
					<th width="20%">${checkData.netfrBnum }</th>
				</tr>
				<tr>
					<th width="20%">天气</th>
					<th width="20%">${checkData.netfrBweather }</th>
				</tr>
				<tr>
					<th width="20%">状态</th>
					<th width="20%">${checkData.netfrBstate }</th>
				</tr>
				<tr>
					<th width="20%">RX LvL</th>
					<th width="20%">${checkData.frBrxShow }</th>
				</tr>
				<tr>
					<th width="20%">Eb/No</th>
					<th width="20%">${checkData.frBebShow }</th>
				</tr>
				<!-----------------------------  FR小网的0号节点    结束------------------------------------->
			</table>
		</div>
	</div>
</body>
</html>