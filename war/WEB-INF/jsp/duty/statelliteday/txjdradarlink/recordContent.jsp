<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地雷达广播TES链路工作状态</dd>
	</dl>
</div>
<table width="100%" border="0">

	<tr>
		<th rowspan="16">检查内容</th>
		<th rowspan="4">100C</th>
		<th>1</th>
		<th>上海雷达引接</th>
		<th><label><input type="radio" name="linkStateSHA"
				id="linkStateSHA" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateSHA" id="linkStateSHA" value="INNORMAL" />异常</label>
		</th>
	</tr>
	<tr>
		<th>2</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>3</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>4</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>

	<tr>
		<th rowspan="4">100D</th>
		<th>1</th>
		<th>首都机场雷达引接</th>
		<th><label><input type="radio" name="linkStatePEK"
				id="linkStatePEK" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStatePEK" id="linkStatePEK" value="INNORMAL" />异常</label>
		</th>
	</tr>
	<tr>
		<th>2</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>3</th>
		<th>沈阳雷达引接</th>
		<th><label><input type="radio" name="linkStateSHE"
				id="linkStateSHE" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateSHE" id="linkStateSHE" value="INNORMAL" />异常</label></th>
	</tr>
	<tr>
		<th>4</th>
		<th>西安雷达引接</th>
		<th><label><input type="radio" name="linkStateSIA"
				id="linkStateSIA" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateSIA" id="linkStateSIA" value="INNORMAL" />异常</label></th>
	</tr>

	<tr>
		<th rowspan="4">100E</th>
		<th>1</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>2</th>
		<th>广州雷达引接</th>
		<th><label><input type="radio" name="linkStateCAN"
				id="linkStateCAN" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateCAN" id="linkStateCAN" value="INNORMAL" />异常</label></th>
	</tr>
	<tr>
		<th>3</th>
		<th>乌鲁木齐雷达引接</th>
		<th><label><input type="radio" name="linkStateURC"
				id="linkStateURC" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateURC" id="linkStateURC" value="INNORMAL" />异常</label></th>
	</tr>
	<tr>
		<th>4</th>
		<th>海口雷达引接</th>
		<th><label><input type="radio" name="linkStateHAK"
				id="linkStateHAK" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateHAK" id="linkStateHAK" value="INNORMAL" />异常</label></th>
	</tr>

	<tr>
		<th rowspan="4">1010</th>
		<th>1</th>
		<th>成都雷达引接</th>
		<th><label><input type="radio" name="linkStateCTU"
				id="linkStateCTU" value="NORMAL" checked="checked" />正常 </label> <label><input
				type="radio" name="linkStateCTU" id="linkStateCTU" value="INNORMAL" />异常</label></th>
	</tr>
	<tr>
		<th>2</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>3</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
	</tr>
	<tr>
		<th>4</th>
		<th></th>
		<th><label><input type="radio" name="" id=""
				value="NORMAL" checked="checked" readonly="readonly" />正常 </label> <label><input
				type="radio" name="" id="" value="INNORMAL" readonly="readonly" />异常</label></th>
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