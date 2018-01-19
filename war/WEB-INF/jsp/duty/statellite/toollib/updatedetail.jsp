<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
		<dd>通信基地-TES-室内设备--更新</dd>
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
    <td><form:input path="n1001" value="${vo.n1001 }"/></td>
    <td><form:input path="n1002" value="${vo.n1002 }"/></td>
    <td><form:input path="n1003" value="${vo.n1003 }"/></td>
    <td><form:input path="n1004" value="${vo.n1004 }"/></td>
    <td><form:input path="n1007" value="${vo.n1007 }"/></td>
    <td><form:input path="n1008" value="${vo.n1008 }"/></td>
    <td><form:input path="n1009" value="${vo.n1009 }"/></td>
    <td><form:input path="n100a" value="${vo.n100a }"/></td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
     <c:choose>
		    <c:when test="${vo.n1001 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1001" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1001" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1001" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1001" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1002 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1002" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1002" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1002" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1002" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1003 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1003" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1003" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1003" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1003" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1004 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1004" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1004" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1004" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1004" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1007 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1007" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1007" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1007" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1007" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1008 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1008" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1008" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1008" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1008" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
     <c:choose>
		    <c:when test="${vo.n1009 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1009" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1009" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1009" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1009" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td><td>
     <c:choose>
		    <c:when test="${vo.n100a eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100a" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100a" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100a" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100a" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
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
     <td><form:input path="n100b" value="${vo.n100b }"/></td>
    <td><form:input path="n100c" value="${vo.n100c }"/></td>
    <td><form:input path="n100d" value="${vo.n100d }"/></td>
    <td><form:input path="n100e" value="${vo.n100e }"/></td>
    <td><form:input path="n100f" value="${vo.n100f }"/></td>
    <td><form:input path="n1010" value="${vo.n1010 }"/></td>
    <td><form:input path="n1011" value="${vo.n1011 }"/></td>
    <td><form:input path="n1012" value="${vo.n1012 }"/></td>
  </tr>
  <tr>
    <th scope="row">机箱风扇运行情况</th>
    <td>
	    <c:choose>
		    <c:when test="${vo.n100b eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100b" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100b" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100b" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100b" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
    <c:choose>
		    <c:when test="${vo.n100c eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100c" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100c" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100c" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100c" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
    <c:choose>
		    <c:when test="${vo.n100b eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100d" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100d" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100d" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100d" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
    <c:choose>
		    <c:when test="${vo.n100e eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100e" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100e" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100e" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100e" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
    <c:choose>
		    <c:when test="${vo.n100f eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n100f" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100f" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n100f" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n100f" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
    <c:choose>
		    <c:when test="${vo.n1010 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1010" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1010" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1010" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1010" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td>
    <td>
   <c:choose>
		    <c:when test="${vo.n1011 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1011" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1011" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1011" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1011" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
    </td><td>
    <c:choose>
		    <c:when test="${vo.n1012 eq 'NORMAL'}">
				    <label>
				      <input type="radio" name="n1012" value="NORMAL" checked="checked"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1012" value="INNORMAL" />
				异常</label>
		   </c:when>
		   <c:otherwise>
		   		 <label>
				      <input type="radio" name="n1012" value="NORMAL"/>
				正常</label>
				      <label>
				      <input type="radio" name="n1012" value="INNORMAL" checked="checked"/>
				异常</label>
		   </c:otherwise>
	   </c:choose>
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
