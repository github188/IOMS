<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<c:if test="${optType eq 'kuequ' }">
				<dd>通讯基地KU室内设备月检--添加</dd>
			</c:if>
			<c:if test="${optType eq 'mhjkucheck' }">
				<dd>民航局KU室内设备月检--添加</dd>
			</c:if>

			<c:if test="${optType eq 'slhkucheck' }">
				<dd>十里河KU室内设备月检--添加</dd>
			</c:if>
		</c:if>
		<c:if test="${checkType eq 'QUARTER' }">

			<c:if test="${optType eq 'kuequ' }">
				<dd>通讯基地KU室内设备季检--添加</dd>
			</c:if>

			<c:if test="${optType eq 'mhjkucheck' }">
				<dd>民航局KU室内设备季检--添加</dd>
			</c:if>

			<c:if test="${optType eq 'slhkucheck' }">
				<dd>十里河KU室内设备季检--添加</dd>
			</c:if>

		</c:if>
		<c:if test="${checkType eq 'YEAR' }">

			<c:if test="${optType eq 'kuequ' }">
				<dd>通讯基地KU室内设备年检--添加</dd>
			</c:if>

			<c:if test="${optType eq 'mhjkucheck' }">
				<dd>民航局KU室内设备年检--添加</dd>
			</c:if>

			<c:if test="${optType eq 'slhkucheck' }">
				<dd>十里河KU室内设备年检--添加</dd>
			</c:if>
		</c:if>
	</dl>
</div>
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
		<td rowspan="4">子网1<br>0号节点
		</td>
		<td><form:input path="slot1" /></td>
		<td><form:input path="type1" /></td>
		<td><form:input path="usepor1" /></td>
		<td><form:input path="surpor1" /></td>
		<td rowspan="4"><form:textarea path="subnet10Remark" /></td>
	</tr>
	<tr>
		<th scope="row">2</th>
		<td><form:input path="slot2" /></td>
		<td><form:input path="type2" /></td>
		<td><form:input path="usepor2" /></td>
		<td><form:input path="surpor2" /></td>
	</tr>
	<tr>
		<th scope="row">3</th>
		<td><form:input path="slot3" /></td>
		<td><form:input path="type3" /></td>
		<td><form:input path="usepor3" /></td>
		<td><form:input path="surpor3" /></td>
	</tr>
	<tr>
		<th scope="row">4</th>
		<td><form:input path="slot4" /></td>
		<td><form:input path="type4" /></td>
		<td><form:input path="usepor4" /></td>
		<td><form:input path="surpor4" /></td>
	</tr>
	<tr>
		<th scope="row">5</th>
		<td rowspan="4">子网1<br>1号节点
		</td>
		<td>0</td>
		<td><form:input path="type5" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:input path="subnet11Remark" /></td>
	</tr>
	<tr>
		<th scope="row">6</th>
		<td>1</td>
		<td><form:input path="type6" /></td>
		<td><form:input path="usepor6" /></td>
		<td><form:input path="surpor6" /></td>
	</tr>
	<tr>
		<th scope="row">7</th>
		<td>2</td>
		<td><form:input path="type7" /></td>
		<td><form:input path="usepor7" /></td>
		<td><form:input path="surpor7" /></td>
	</tr>
	<tr>
		<th scope="row">8</th>
		<td>3</td>
		<td><form:input path="type8" /></td>
		<td><form:input path="usepor8" /></td>
		<td><form:input path="surpor8" /></td>
	</tr>
	<tr>
		<th scope="row">9</th>
		<td rowspan="4">子网2<br>0号节点
		</td>
		<td>0</td>
		<td><form:input path="type9" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet20Remark" /></td>
	</tr>
	<tr>
		<th scope="row">10</th>
		<td>1</td>
		<td><form:input path="type10" /></td>
		<td><form:input path="usepor10" /></td>
		<td><form:input path="surpor10" /></td>
	</tr>
	<tr>
		<th scope="row">11</th>
		<td>2</td>
		<td><form:input path="type11" /></td>
		<td><form:input path="usepor11" /></td>
		<td><form:input path="surpor11" /></td>
	</tr>
	<tr>
		<th scope="row">12</th>
		<td>3</td>
		<td><form:input path="type12" /></td>
		<td><form:input path="usepor12" /></td>
		<td><form:input path="surpor12" /></td>
	</tr>
	<tr>
		<th scope="row">13</th>
		<td rowspan="4">子网2<br>1号节点
		</td>
		<td>0</td>
		<td><form:input path="type13" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet21Remark" /></td>
	</tr>
	<tr>
		<th scope="row">14</th>
		<td>1</td>
		<td><form:input path="type14" /></td>
		<td><form:input path="usepor14" /></td>
		<td><form:input path="surpor14" /></td>
	</tr>
	<tr>
		<th scope="row">15</th>
		<td>2</td>
		<td><form:input path="type15" /></td>
		<td><form:input path="usepor15" /></td>
		<td><form:input path="surpor15" /></td>
	</tr>
	<tr>
		<th scope="row">16</th>
		<td>3</td>
		<td><form:input path="type16" /></td>
		<td><form:input path="usepor16" /></td>
		<td><form:input path="surpor16" /></td>
	</tr>
	<tr>
		<th scope="row">17</th>
		<td rowspan="4">子网3<br>0号节点
		</td>
		<td>0</td>
		<td><form:input path="type17" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet30Remark" /></td>
	</tr>
	<tr>
		<th scope="row">18</th>
		<td>1</td>
		<td><form:input path="type18" /></td>
		<td><form:input path="usepor18" /></td>
		<td><form:input path="surpor18" /></td>
	</tr>
	<tr>
		<th scope="row">19</th>
		<td>2</td>
		<td><form:input path="type19" /></td>
		<td><form:input path="usepor19" /></td>
		<td><form:input path="surpor19" /></td>
	</tr>
	<tr>
		<th scope="row">20</th>
		<td>3</td>
		<td><form:input path="type20" /></td>
		<td><form:input path="usepor20" /></td>
		<td><form:input path="surpor20" /></td>
	</tr>
	<tr>
		<th scope="row">21</th>
		<td rowspan="4">子网3<br>1号节点
		</td>
		<td>0</td>
		<td><form:input path="type21" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet31Remark" /></td>
	</tr>
	<tr>
		<th scope="row">22</th>
		<td>1</td>
		<td><form:input path="type22" /></td>
		<td><form:input path="usepor22" /></td>
		<td><form:input path="surpor22" /></td>
	</tr>
	<tr>
		<th scope="row">23</th>
		<td>2</td>
		<td><form:input path="type23" /></td>
		<td><form:input path="usepor23" /></td>
		<td><form:input path="surpor23" /></td>
	</tr>
	<tr>
		<th scope="row">24</th>
		<td>3</td>
		<td><form:input path="type24" /></td>
		<td><form:input path="usepor24" /></td>
		<td><form:input path="surpor24" /></td>
	</tr>
	<tr>
		<th scope="row">25</th>
		<td rowspan="4">子网4<br>0号节点
		</td>
		<td>0</td>
		<td><form:input path="type25" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet40Remark" /></td>
	</tr>
	<tr>
		<th scope="row">26</th>
		<td>1</td>
		<td><form:input path="type26" /></td>
		<td><form:input path="usepor26" /></td>
		<td><form:input path="surpor26" /></td>
	</tr>
	<tr>
		<th scope="row">27</th>
		<td>2</td>
		<td><form:input path="type27" /></td>
		<td><form:input path="usepor27" /></td>
		<td><form:input path="surpor27" /></td>
	</tr>
	<tr>
		<th scope="row">28</th>
		<td>3</td>
		<td><form:input path="type28" /></td>
		<td><form:input path="usepor28" /></td>
		<td><form:input path="surpor28" /></td>
	</tr>
	<tr>
		<th scope="row">29</th>
		<td rowspan="4">子网4<br>1号节点
		</td>
		<td>0</td>
		<td><form:input path="type29" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet41Remark" /></td>
	</tr>
	<tr>
		<th scope="row">30</th>
		<td>1</td>
		<td><form:input path="type30" /></td>
		<td><form:input path="usepor30" /></td>
		<td><form:input path="surpor30" /></td>
	</tr>
	<tr>
		<th scope="row">31</th>
		<td>2</td>
		<td><form:input path="type31" /></td>
		<td><form:input path="usepor31" /></td>
		<td><form:input path="surpor31" /></td>
	</tr>
	<tr>
		<th scope="row">32</th>
		<td>3</td>
		<td><form:input path="type32" /></td>
		<td><form:input path="usepor32" /></td>
		<td><form:input path="surpor32" /></td>
	</tr>
	<tr>
		<th scope="row">33</th>
		<td rowspan="4">帧中继网<br>0号节点
		</td>
		<td>0</td>
		<td><form:input path="type33" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet0Remark" /></td>
	</tr>
	<tr>
		<th scope="row">34</th>
		<td>1</td>
		<td><form:input path="type34" /></td>
		<td><form:input path="usepor34" /></td>
		<td><form:input path="surpor34" /></td>
	</tr>
	<tr>
		<th scope="row">35</th>
		<td>2</td>
		<td><form:input path="type35" /></td>
		<td><form:input path="usepor35" /></td>
		<td><form:input path="surpor35" /></td>
	</tr>
	<tr>
		<th scope="row">36</th>
		<td>3</td>
		<td><form:input path="type36" /></td>
		<td><form:input path="usepor36" /></td>
		<td><form:input path="surpor36" /></td>
	</tr>
	<tr>
		<th scope="row">37</th>
		<td rowspan="4">帧中继网<br>1号节点
		</td>
		<td>0</td>
		<td><form:input path="type37" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet1Remark" /></td>
	</tr>
	<tr>
		<th scope="row">38</th>
		<td>1</td>
		<td><form:input path="type38" /></td>
		<td><form:input path="usepor38" /></td>
		<td><form:input path="surpor38" /></td>
	</tr>
	<tr>
		<th scope="row">39</th>
		<td>2</td>
		<td><form:input path="type39" /></td>
		<td><form:input path="usepor39" /></td>
		<td><form:input path="surpor39" /></td>
	</tr>
	<tr>
		<th scope="row">40</th>
		<td>3</td>
		<td><form:input path="type40" /></td>
		<td><form:input path="usepor40" /></td>
		<td><form:input path="surpor40" /></td>
	</tr>
	<tr>
		<th scope="row">41</th>
		<td rowspan="4">帧中继网<br>7号节点
		</td>
		<td>0</td>
		<td><form:input path="type41" /></td>
		<td></td>
		<td></td>
		<td rowspan="4"><form:textarea path="subnet7Remark" /></td>
	</tr>
	<tr>
		<th scope="row">42</th>
		<td>1</td>
		<td><form:input path="type42" /></td>
		<td><form:input path="usepor42" /></td>
		<td><form:input path="surpor42" /></td>
	</tr>
	<tr>
		<th scope="row">43</th>
		<td>2</td>
		<td><form:input path="type43" /></td>
		<td><form:input path="usepor43" /></td>
		<td><form:input path="surpor43" /></td>
	</tr>
	<tr>
		<th scope="row">44</th>
		<td>3</td>
		<td><form:input path="type44" /></td>
		<td><form:input path="usepor44" /></td>
		<td><form:input path="surpor44" /></td>
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