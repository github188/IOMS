<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<c:if test="${checkType eq 'MONTH' }">
			<c:if test="${outType eq 'tesequ' }">
	            <dd>通信基地-TES-室内设备月检</dd>
	             </c:if>
             <c:if test="${outType eq 'mhjtesequ' }">
            <dd>民航局-TES-室内设备月检</dd>
             </c:if>
        </c:if>
        <c:if test="${checkType eq 'QUARTER' }">
	            <c:if test="${outType eq 'tesequ' }">
		            <dd>通信基地-TES-室内设备季检</dd>
		        </c:if>
	             <c:if test="${outType eq 'mhjtesequ' }">
	                 <dd>民航局-TES-室内设备季检</dd>
	             </c:if>
        </c:if>
        <c:if test="${checkType eq 'YEAR' }">
            <c:if test="${outType eq 'tesequ' }">
		            <dd>通信基地-TES-室内设备年检</dd>
		        </c:if>
	             <c:if test="${outType eq 'mhjtesequ' }">
	                 <dd>民航局-TES-室内设备年检</dd>
	             </c:if>
        </c:if>
	</dl>
</div>
<table width="100%" border="1">
  <tr>
    <th colspan="9" scope="col">北京网控中心TES站室内检查</th>
  </tr>
  <tr>
    <th width="13%" scope="row">机箱号</th>
    <td width="10%">1001</td>
    <td width="12%">1002</td>
    <td width="11%">1003</td>
    <td width="11%">1004</td>
    <td width="11%">1007</td>
    <td width="10%">1008</td>
    <td width="10%">1009</td>
    <td width="12%">100A</td>
  </tr>
  <tr>
    <th scope="row">板卡数量</th>
    <td><form:input path="n1001"/></td>
    <td><form:input path="n1002"/></td>
    <td><form:input path="n1003"/></td>
    <td><form:input path="n1004"/></td>
    <td><form:input path="n1007"/></td>
    <td><form:input path="n1008"/></td>
    <td><form:input path="n1009"/></td>
    <td><form:input path="n100a"/></td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
    <label>
      <input type="radio" name="n1001" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1001" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1002" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1002" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1003" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1003" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1004" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1004" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1007" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1007" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1008" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1008" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1009" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1009" value="INNORMAL" />
异常</label>
    </td><td>
    <label>
      <input type="radio" name="n100a" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100a" value="INNORMAL" />
异常</label>
    </td>
  </tr>
  <tr>
    <th scope="row">机箱号</th>
    <td>100B</td>
    <td>100C</td>
    <td>100D</td>
    <td>100E</td>
    <td>100F</td>
    <td>1010</td>
    <td>1011</td>
    <td>1012</td>
  </tr>
  <tr>
    <th scope="row">板卡数量</th>
     <td><form:input path="n100b"/></td>
    <td><form:input path="n100c"/></td>
    <td><form:input path="n100d"/></td>
    <td><form:input path="n100e"/></td>
    <td><form:input path="n100f"/></td>
    <td><form:input path="n1010"/></td>
    <td><form:input path="n1011"/></td>
    <td><form:input path="n1012"/></td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
    <label>
      <input type="radio" name="n100b" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100b" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n100c" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100c" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n100d" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100d" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n100e" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100e" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n100f" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n100f" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1010" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1010" value="INNORMAL" />
异常</label>
    </td>
    <td>
    <label>
      <input type="radio" name="n1011" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1011" value="INNORMAL" />
异常</label>
    </td><td>
    <label>
      <input type="radio" name="n1012" value="NORMAL" checked="checked"/>
正常</label>
      <label>
      <input type="radio" name="n1012" value="INNORMAL" />
异常</label>
    </td>
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