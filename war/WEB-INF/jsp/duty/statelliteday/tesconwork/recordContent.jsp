<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px; padding: 0px">
	<dl class="title">
		<dd>通信基地TES控制信道工作情况</dd>
	</dl>
</div>
<table width="100%" border="0">
	<tr>
		<th colspan="2" scope="col">检查内容</th>
		<th scope="col">检查结果</th>
		<th scope="col">评判标准</th>
		<th scope="col">检查方法</th>
	</tr>
	<tr>
		<th rowspan="16" scope="col">控制信道工作情况</th>
		<th scope="col">100101</th>
		<th scope="col"><label></label><label></label> <label></label>
			<p>
				<label> <input type="radio" name="control100101"
					value="Active" checked="checked" /> Active
				</label> <label> <input type="radio" name="control100101"
					value="Failed" /> Failed
				</label>
			</p> <label></label></th>
		<th rowspan="16" scope="col">均为Active，不存在Failed状态。</th>
		<th rowspan="16" scope="col"><p>通过网管软件CCUSTATUS窗口进行</p></th>
	</tr>
	<tr>
		<th scope="col">100102</th>
		<th scope="col"><label></label><label> <input
				type="radio" name="control100102" value="Active" checked="checked" />
				Active
		</label> <label> <input type="radio" name="control100102"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100103</th>
		<th scope="col"><label> <input type="radio"
				name="control100103" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100103"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100104</th>
		<th scope="col"><label> <input type="radio"
				name="control100104" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100104"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100201</th>
		<th scope="col"><label> <input type="radio"
				name="control100201" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100201"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100202</th>
		<th scope="col"><label> <input type="radio"
				name="control100202" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100202"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100203</th>
		<th scope="col"><label> <input type="radio"
				name="control100203" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100203"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100204</th>
		<th scope="col"><label> <input type="radio"
				name="control100204" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100204"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100301</th>
		<th scope="col"><label> <input type="radio"
				name="control100301" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100301"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100302</th>
		<th scope="col"><label> <input type="radio"
				name="control100302" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100302"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100303</th>
		<th scope="col"><label> <input type="radio"
				name="control100303" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100303"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100304</th>
		<th scope="col"><label> <input type="radio"
				name="control100304" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100304"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100401</th>
		<th scope="col"><label> <input type="radio"
				name="control100401" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100401"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100402</th>
		<th scope="col"><label> <input type="radio"
				name="control100402" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100402"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100403</th>
		<th scope="col"><label> <input type="radio"
				name="control100403" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100403"
				value="Failed" /> Failed
		</label></th>
	</tr>
	<tr>
		<th scope="col">100404</th>
		<th scope="col"><label> <input type="radio"
				name="control100404" value="Active" checked="checked" /> Active
		</label> <label> <input type="radio" name="control100404"
				value="Failed" /> Failed
		</label></th>
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