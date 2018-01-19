<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>KU室内设备检查--更新</dd>
	</dl>
</div>
<table width="100%" border="1">
	<tr>
		<th colspan="7" scope="col">Ku站室内检查</th>
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
		<td><form:input path="slot1" value="${vo.slot1 }" /></td>
		<td><form:input path="type1" value="${vo.type1 }" /></td>
		<td><form:input path="usepor1" value="${vo.usepor1 }" /></td>
		<td><form:input path="surpor1" value="${vo.surpor1 }" /></td>
		<td rowspan="4"><textarea id="subnet10Remark"
				name="subnet10Remark">${vo.subnet10Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td><form:input path="slot2" value="${vo.slot2 }" /></td>
		<td><form:input path="type2" value="${vo.type2 }" /></td>
		<td><form:input path="usepor2" value="${vo.usepor2 }" /></td>
		<td><form:input path="surpor2" value="${vo.surpor2 }" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td><form:input path="slot3" value="${vo.slot3 }" /></td>
		<td><form:input path="type3" value="${vo.type3 }" /></td>
		<td><form:input path="usepor3" value="${vo.usepor3 }" /></td>
		<td><form:input path="surpor3" value="${vo.surpor3 }" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td><form:input path="slot4" value="${vo.slot4 }" /></td>
		<td><form:input path="type4" value="${vo.type4 }" /></td>
		<td><form:input path="usepor4" value="${vo.usepor4 }" /></td>
		<td><form:input path="surpor4" value="${vo.surpor4 }" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td rowspan="4">子网11号节点</td>
		<td>0</td>
		<td><form:input path="type5" value="${vo.type5 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet11Remark"
				name="subnet11Remark">${vo.subnet11Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>1</td>
		<td><form:input path="type6" value="${vo.type6 }" /></td>
		<td><form:input path="usepor6" value="${vo.usepor6 }" /></td>
		<td><form:input path="surpor6" value="${vo.surpor6 }" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>2</td>
		<td><form:input path="type7" value="${vo.type7 }" /></td>
		<td><form:input path="usepor7" value="${vo.usepor7 }" /></td>
		<td><form:input path="surpor7" value="${vo.surpor7 }" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>3</td>
		<td><form:input path="type8" value="${vo.type8 }" /></td>
		<td><form:input path="usepor8" value="${vo.usepor8 }" /></td>
		<td><form:input path="surpor8" value="${vo.surpor8 }" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td rowspan="4">子网20号节点</td>
		<td>0</td>
		<td><form:input path="type9" value="${vo.type9 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet20Remark"
				name="subnet20Remark">${vo.subnet20Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td>1</td>
		<td><form:input path="type10" value="${vo.type10 }" /></td>
		<td><form:input path="usepor10" value="${vo.usepor10 }" /></td>
		<td><form:input path="surpor10" value="${vo.surpor10 }" /></td>
	</tr>
	<tr>
		<th scope="row">11</th>
		<td>2</td>
		<td><form:input path="type11" value="${vo.type11 }" /></td>
		<td><form:input path="usepor11" value="${vo.usepor11 }" /></td>
		<td><form:input path="surpor11" value="${vo.surpor11 }" /></td>
	</tr>
	<tr>
		<th scope="row">12</th>
		<td>3</td>
		<td><form:input path="type12" value="${vo.type12 }" /></td>
		<td><form:input path="usepor12" value="${vo.usepor12 }" /></td>
		<td><form:input path="surpor12" value="${vo.surpor12 }" /></td>
	</tr>
	<tr>
		<th scope="row">13</th>
		<td rowspan="4">子网21号节点</td>
		<td>0</td>
		<td><form:input path="type13" value="${vo.type13 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet21Remark"
				name="subnet21Remark">${vo.subnet21Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">14</th>
		<td>1</td>
		<td><form:input path="type14" value="${vo.type14 }" /></td>
		<td><form:input path="usepor14" value="${vo.usepor14 }" /></td>
		<td><form:input path="surpor14" value="${vo.surpor14 }" /></td>
	</tr>
	<tr>
		<th scope="row">15</th>
		<td>2</td>
		<td><form:input path="type15" value="${vo.type15 }" /></td>
		<td><form:input path="usepor15" value="${vo.usepor15 }" /></td>
		<td><form:input path="surpor15" value="${vo.surpor15 }" /></td>
	</tr>
	<tr>
		<th scope="row">16</th>
		<td>3</td>
		<td><form:input path="type16" value="${vo.type16 }" /></td>
		<td><form:input path="usepor16" value="${vo.usepor16 }" /></td>
		<td><form:input path="surpor16" value="${vo.surpor16 }" /></td>
	</tr>
	<tr>
		<th scope="row">17</th>
		<td rowspan="4">子网30号节点</td>
		<td>0</td>
		<td><form:input path="type17" value="${vo.type17 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet30Remark"
				name="subnet30Remark">${vo.subnet30Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">18</th>
		<td>1</td>
		<td><form:input path="type18" value="${vo.type18 }" /></td>
		<td><form:input path="usepor18" value="${vo.usepor18 }" /></td>
		<td><form:input path="surpor18" value="${vo.surpor18 }" /></td>
	</tr>
	<tr>
		<th scope="row">19</th>
		<td>2</td>
		<td><form:input path="type19" value="${vo.type19 }" /></td>
		<td><form:input path="usepor19" value="${vo.usepor19 }" /></td>
		<td><form:input path="surpor19" value="${vo.surpor19 }" /></td>
	</tr>
	<tr>
		<th scope="row">20</th>
		<td>3</td>
		<td><form:input path="type20" value="${vo.type20 }" /></td>
		<td><form:input path="usepor20" value="${vo.usepor20 }" /></td>
		<td><form:input path="surpor20" value="${vo.surpor20 }" /></td>
	</tr>
	<tr>
		<th scope="row">21</th>
		<td rowspan="4">子网31号节点</td>
		<td>0</td>
		<td><form:input path="type21" value="${vo.type21 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet31Remark"
				name="subnet31Remark">${vo.subnet31Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">22</th>
		<td>1</td>
		<td><form:input path="type22" value="${vo.type22 }" /></td>
		<td><form:input path="usepor22" value="${vo.usepor22 }" /></td>
		<td><form:input path="surpor22" value="${vo.surpor22 }" /></td>
	</tr>
	<tr>
		<th scope="row">23</th>
		<td>2</td>
		<td><form:input path="type23" value="${vo.type23 }" /></td>
		<td><form:input path="usepor23" value="${vo.usepor23 }" /></td>
		<td><form:input path="surpor23" value="${vo.surpor23 }" /></td>
	</tr>
	<tr>
		<th scope="row">24</th>
		<td>3</td>
		<td><form:input path="type24" value="${vo.type24 }" /></td>
		<td><form:input path="usepor24" value="${vo.usepor24 }" /></td>
		<td><form:input path="surpor24" value="${vo.surpor24 }" /></td>
	</tr>
	<tr>
		<th scope="row">25</th>
		<td rowspan="4">子网40号节点</td>
		<td>0</td>
		<td><form:input path="type25" value="${vo.type25 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet40Remark"
				name="subnet40Remark">${vo.subnet40Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">26</th>
		<td>1</td>
		<td><form:input path="type26" value="${vo.type26 }" /></td>
		<td><form:input path="usepor26" value="${vo.usepor26 }" /></td>
		<td><form:input path="surpor26" value="${vo.surpor26 }" /></td>
	</tr>
	<tr>
		<th scope="row">27</th>
		<td>2</td>
		<td><form:input path="type27" value="${vo.type27 }" /></td>
		<td><form:input path="usepor27" value="${vo.usepor27 }" /></td>
		<td><form:input path="surpor27" value="${vo.surpor27 }" /></td>
	</tr>
	<tr>
		<th scope="row">28</th>
		<td>3</td>
		<td><form:input path="type28" value="${vo.type28 }" /></td>
		<td><form:input path="usepor28" value="${vo.usepor28 }" /></td>
		<td><form:input path="surpor28" value="${vo.surpor28 }" /></td>
	</tr>
	<tr>
		<th scope="row">29</th>
		<td rowspan="4">子网41号节点</td>
		<td>0</td>
		<td><form:input path="type29" value="${vo.type29 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet41Remark"
				name="subnet41Remark">${vo.subnet41Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">30</th>
		<td>1</td>
		<td><form:input path="type30" value="${vo.type30 }" /></td>
		<td><form:input path="usepor30" value="${vo.usepor30 }" /></td>
		<td><form:input path="surpor30" value="${vo.surpor30 }" /></td>
	</tr>
	<tr>
		<th scope="row">31</th>
		<td>2</td>
		<td><form:input path="type31" value="${vo.type31 }" /></td>
		<td><form:input path="usepor31" value="${vo.usepor31 }" /></td>
		<td><form:input path="surpor31" value="${vo.surpor31 }" /></td>
	</tr>
	<tr>
		<th scope="row">32</th>
		<td>3</td>
		<td><form:input path="type32" value="${vo.type32 }" /></td>
		<td><form:input path="usepor32" value="${vo.usepor32 }" /></td>
		<td><form:input path="surpor32" value="${vo.surpor32 }" /></td>
	</tr>
	<tr>
		<th scope="row">33</th>
		<td rowspan="4">帧中继网0号节点</td>
		<td>0</td>
		<td><form:input path="type33" value="${vo.type33 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet0Remark" name="subnet0Remark">${vo.subnet0Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">34</th>
		<td>1</td>
		<td><form:input path="type34" value="${vo.type34 }" /></td>
		<td><form:input path="usepor34" value="${vo.usepor34 }" /></td>
		<td><form:input path="surpor34" value="${vo.surpor34 }" /></td>
	</tr>
	<tr>
		<th scope="row">35</th>
		<td>2</td>
		<td><form:input path="type35" value="${vo.type35 }" /></td>
		<td><form:input path="usepor35" value="${vo.usepor35 }" /></td>
		<td><form:input path="surpor35" value="${vo.surpor35 }" /></td>
	</tr>
	<tr>
		<th scope="row">36</th>
		<td>3</td>
		<td><form:input path="type36" value="${vo.type36 }" /></td>
		<td><form:input path="usepor36" value="${vo.usepor36 }" /></td>
		<td><form:input path="surpor36" value="${vo.surpor36 }" /></td>
	</tr>
	<tr>
		<th scope="row">37</th>
		<td rowspan="4">帧中继网1号节点</td>
		<td>0</td>
		<td><form:input path="type37" value="${vo.type37 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet1Remark" name="subnet1Remark">${vo.subnet1Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">38</th>
		<td>1</td>
		<td><form:input path="type38" value="${vo.type38 }" /></td>
		<td><form:input path="usepor38" value="${vo.usepor38 }" /></td>
		<td><form:input path="surpor38" value="${vo.surpor38 }" /></td>
	</tr>
	<tr>
		<th scope="row">39</th>
		<td>2</td>
		<td><form:input path="type39" value="${vo.type39 }" /></td>
		<td><form:input path="usepor39" value="${vo.usepor39 }" /></td>
		<td><form:input path="surpor39" value="${vo.surpor39 }" /></td>
	</tr>
	<tr>
		<th scope="row">40</th>
		<td>3</td>
		<td><form:input path="type40" value="${vo.type40 }" /></td>
		<td><form:input path="usepor40" value="${vo.usepor40 }" /></td>
		<td><form:input path="surpor40" value="${vo.surpor40 }" /></td>
	</tr>
	<tr>
		<th scope="row">41</th>
		<td rowspan="4">帧中继网7号节点</td>
		<td>0</td>
		<td><form:input path="type41" value="${vo.type41 }" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><textarea id="subnet7Remark" name="subnet7Remark">${vo.subnet7Remark }</textarea></td>
	</tr>
	<tr>
		<th scope="row">42</th>
		<td>1</td>
		<td><form:input path="type42" value="${vo.type42 }" /></td>
		<td><form:input path="usepor42" value="${vo.usepor42 }" /></td>
		<td><form:input path="surpor42" value="${vo.surpor42 }" /></td>
	</tr>
	<tr>
		<th scope="row">43</th>
		<td>2</td>
		<td><form:input path="type43" value="${vo.type43 }" /></td>
		<td><form:input path="usepor43" value="${vo.usepor43 }" /></td>
		<td><form:input path="surpor43" value="${vo.surpor43 }" /></td>
	</tr>
	<tr>
		<th scope="row">44</th>
		<td>3</td>
		<td><form:input path="type44" value="${vo.type44 }" /></td>
		<td><form:input path="usepor44" value="${vo.usepor44 }" /></td>
		<td><form:input path="surpor44" value="${vo.surpor44 }" /></td>
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
