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
			<dd>KU室内设备检查--查看</dd>
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
					<th colspan="7" scope="col">KU站室内检查</th>
				</tr>
				<tr>
					<th width="3%" rowspan="2" scope="row">序号</th>
					<td colspan="5">结果记录</td>
					<td width="13%" rowspan="2">备注</td>
				</tr>
				<tr>
					<td width="12%">机箱（节点号）</td>
					<td width="15%">槽位号</td>
					<td width="18%">板卡类型</td>
					<td width="20%">使用端口</td>
					<td width="19%">剩余端口</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td rowspan="4">子网10号节点</td>
					<td>${vo.slot1 }</td>
					<td>${vo.type1 }</td>
					<td>${vo.usepor1 }</td>
					<td>${vo.surpor1 }</td>
					<td rowspan="4">${vo.subnet10Remark }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>${vo.slot2 }</td>
					<td>${vo.type2 }</td>
					<td>${vo.usepor2 }</td>
					<td>${vo.surpor2 }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>${vo.slot3 }</td>
					<td>${vo.type3 }</td>
					<td>${vo.usepor3 }</td>
					<td>${vo.surpor3 }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>${vo.slot4 }</td>
					<td>${vo.type4 }</td>
					<td>${vo.usepor4 }</td>
					<td>${vo.surpor4 }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td rowspan="4">子网11号节点</td>
					<td>0</td>
					<td>${vo.type5 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet11Remark }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>1</td>
					<td>${vo.type6 }</td>
					<td>${vo.usepor6 }</td>
					<td>${vo.surpor6 }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>2</td>
					<td>${vo.type7 }</td>
					<td>${vo.usepor7 }</td>
					<td>${vo.surpor7 }</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>3</td>
					<td>${vo.type8 }</td>
					<td>${vo.usepor8 }</td>
					<td>${vo.surpor8 }</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td rowspan="4">子网20号节点</td>
					<td>0</td>
					<td>${vo.type9 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet20Remark }</td>
				</tr>
				<tr>
					<th scope="row">10</th>
					<td>1</td>
					<td>${vo.type10 }</td>
					<td>${vo.usepor10 }</td>
					<td>${vo.surpor10 }</td>
				</tr>
				<tr>
					<th scope="row">11</th>
					<td>2</td>
					<td>${vo.type11 }</td>
					<td>${vo.usepor11 }</td>
					<td>${vo.surpor11 }</td>
				</tr>
				<tr>
					<th scope="row">12</th>
					<td>3</td>
					<td>${vo.type12 }</td>
					<td>${vo.usepor12 }</td>
					<td>${vo.surpor12 }</td>
				</tr>
				<tr>
					<th scope="row">13</th>
					<td rowspan="4">子网21号节点</td>
					<td>0</td>
					<td>${vo.type13 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet21Remark }</td>
				</tr>
				<tr>
					<th scope="row">14</th>
					<td>1</td>
					<td>${vo.type14 }</td>
					<td>${vo.usepor14 }</td>
					<td>${vo.surpor14 }</td>
				</tr>
				<tr>
					<th scope="row">15</th>
					<td>2</td>
					<td>${vo.type15 }</td>
					<td>${vo.usepor15 }</td>
					<td>${vo.surpor15 }</td>
				</tr>
				<tr>
					<th scope="row">16</th>
					<td>3</td>
					<td>${vo.type16 }</td>
					<td>${vo.usepor16 }</td>
					<td>${vo.surpor16 }</td>
				</tr>
				<tr>
					<th scope="row">17</th>
					<td rowspan="4">子网30号节点</td>
					<td>0</td>
					<td>${vo.type17 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet30Remark }</td>
				</tr>
				<tr>
					<th scope="row">18</th>
					<td>1</td>
					<td>${vo.type18 }</td>
					<td>${vo.usepor18 }</td>
					<td>${vo.surpor18 }</td>
				</tr>
				<tr>
					<th scope="row">19</th>
					<td>2</td>
					<td>${vo.type19 }</td>
					<td>${vo.usepor19 }</td>
					<td>${vo.surpor19 }</td>
				</tr>
				<tr>
					<th scope="row">20</th>
					<td>3</td>
					<td>${vo.type20 }</td>
					<td>${vo.usepor20 }</td>
					<td>${vo.surpor20 }</td>
				</tr>
				<tr>
					<th scope="row">21</th>
					<td rowspan="4">子网31号节点</td>
					<td>0</td>
					<td>${vo.type21 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet31Remark }</td>
				</tr>
				<tr>
					<th scope="row">22</th>
					<td>1</td>
					<td>${vo.type22 }</td>
					<td>${vo.usepor22 }</td>
					<td>${vo.surpor22 }</td>
				</tr>
				<tr>
					<th scope="row">23</th>
					<td>2</td>
					<td>${vo.type23 }</td>
					<td>${vo.usepor23 }</td>
					<td>${vo.surpor23 }</td>
				</tr>
				<tr>
					<th scope="row">24</th>
					<td>3</td>
					<td>${vo.type24 }</td>
					<td>${vo.usepor24 }</td>
					<td>${vo.surpor24 }</td>
				</tr>
				<tr>
					<th scope="row">25</th>
					<td rowspan="4">子网40号节点</td>
					<td>0</td>
					<td>${vo.type25 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet40Remark }</td>
				</tr>
				<tr>
					<th scope="row">26</th>
					<td>1</td>
					<td>${vo.type26 }</td>
					<td>${vo.usepor26 }</td>
					<td>${vo.surpor26 }</td>
				</tr>
				<tr>
					<th scope="row">27</th>
					<td>2</td>
					<td>${vo.type27 }</td>
					<td>${vo.usepor27 }</td>
					<td>${vo.surpor27 }</td>
				</tr>
				<tr>
					<th scope="row">28</th>
					<td>3</td>
					<td>${vo.type28 }</td>
					<td>${vo.usepor28 }</td>
					<td>${vo.surpor28 }</td>
				</tr>
				<tr>
					<th scope="row">29</th>
					<td rowspan="4">子网41号节点</td>
					<td>0</td>
					<td>${vo.type29 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet41Remark }</td>
				</tr>
				<tr>
					<th scope="row">30</th>
					<td>1</td>
					<td>${vo.type30 }</td>
					<td>${vo.usepor30 }</td>
					<td>${vo.surpor30 }</td>
				</tr>
				<tr>
					<th scope="row">31</th>
					<td>2</td>
					<td>${vo.type31 }</td>
					<td>${vo.usepor31 }</td>
					<td>${vo.surpor31 }</td>
				</tr>
				<tr>
					<th scope="row">32</th>
					<td>3</td>
					<td>${vo.type32 }</td>
					<td>${vo.usepor32 }</td>
					<td>${vo.surpor32 }</td>
				</tr>
				<tr>
					<th scope="row">33</th>
					<td rowspan="4">帧中继网0号节点</td>
					<td>0</td>
					<td>${vo.type33 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet0Remark }</td>
				</tr>
				<tr>
					<th scope="row">34</th>
					<td>1</td>
					<td>${vo.type34 }</td>
					<td>${vo.usepor34 }</td>
					<td>${vo.surpor34 }</td>
				</tr>
				<tr>
					<th scope="row">35</th>
					<td>2</td>
					<td>${vo.type35 }</td>
					<td>${vo.usepor35 }</td>
					<td>${vo.surpor35 }</td>
				</tr>
				<tr>
					<th scope="row">36</th>
					<td>3</td>
					<td>${vo.type36 }</td>
					<td>${vo.usepor36 }</td>
					<td>${vo.surpor36 }</td>
				</tr>
				<tr>
					<th scope="row">37</th>
					<td rowspan="4">帧中继网1号节点</td>
					<td>0</td>
					<td>${vo.type37 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet1Remark }</td>
				</tr>
				<tr>
					<th scope="row">38</th>
					<td>1</td>
					<td>${vo.type38 }</td>
					<td>${vo.usepor38 }</td>
					<td>${vo.surpor38 }</td>
				</tr>
				<tr>
					<th scope="row">39</th>
					<td>2</td>
					<td>${vo.type39 }</td>
					<td>${vo.usepor39 }</td>
					<td>${vo.surpor39 }</td>
				</tr>
				<tr>
					<th scope="row">40</th>
					<td>3</td>
					<td>${vo.type40 }</td>
					<td>${vo.usepor40 }</td>
					<td>${vo.surpor40 }</td>
				</tr>
				<tr>
					<th scope="row">41</th>
					<td rowspan="4">帧中继网7号节点</td>
					<td>0</td>
					<td>${vo.type41 }</td>
					<td></td>
					<td></td>
					<td rowspan="4">${vo.subnet7Remark }</td>
				</tr>
				<tr>
					<th scope="row">42</th>
					<td>1</td>
					<td>${vo.type42 }</td>
					<td>${vo.usepor42 }</td>
					<td>${vo.surpor42 }</td>
				</tr>
				<tr>
					<th scope="row">43</th>
					<td>2</td>
					<td>${vo.type43 }</td>
					<td>${vo.usepor43 }</td>
					<td>${vo.surpor43 }</td>
				</tr>
				<tr>
					<th scope="row">44</th>
					<td>3</td>
					<td>${vo.type44 }</td>
					<td>${vo.usepor44 }</td>
					<td>${vo.surpor44 }</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>