<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<div style="margin: 10px 20px 0px;padding:0px">
	<dl class="title">
            <c:if test="${checkType eq 'MONTH' }">
            <dd>空调设备月检--添加</dd>
            </c:if>
            <c:if test="${checkType eq 'QUARTER' }">
            <dd>空调设备季检--添加</dd>
            </c:if>
            <c:if test="${checkType eq 'YEAR' }">
            <dd>空调设备年检--添加</dd>
            </c:if>
	</dl>
</div>
<table width="100%">
	<tr>
		<th width="55%" colspan="4">设备名称</th>
		<th width="45%" colspan="2">  
            <c:if test="${checkType eq 'MONTH' or checkType eq 'YEAR' }">
                <form:select path="name" cssStyle="width:200px">
                    <c:forEach items="${slhImosen}" var="vo">
                        <option value="${vo.value}">${vo.value}</option>
                    </c:forEach>
                </form:select>
            </c:if>
            <c:if test="${checkType eq 'QUARTER' }">
                <form:select path="name" cssStyle="width:200px">
                    <c:forEach items="${slhLbote}" var="vo">
                        <option value="${vo.value}">${vo.value}</option>
                    </c:forEach>
                </form:select>
            </c:if>
		</th>
	</tr>
    <!-- 当巡检类别为月检时生成的巡检内容  -->
    <c:if test="${checkType eq 'MONTH' }">
        <tr>
            <th width="5%">项目</th>
            <th width="25%" colspan="2">维护内容</th>
            <th width="25%">维护标准</th>
            <th width="25%">运行状态</th>
            <th width="20%">备注</th>
        </tr>
        <!-- 主风机转动 -->
        <tr>
            <th width="5%" rowspan="12">十里河精密空调</th>
            <th width="25%" colspan="2">主风机转动</th>
            <th width="25%">转动灵活、无杂音、皮带松紧适度</th>
            <td width="25%">
                <select id="mfrStatus" name="mfrStatus">
                    <c:forEach items="${checkresult}" var="vo">
                        <option value="${vo}">${vo.value}</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="mfrRemarks"/></td>
        </tr>
        <!-- 过滤网 -->
        <tr>
            <th width="25%" colspan="2">过滤网</th>
            <th>滤网干净,无尘,无堵塞现象</th>
            <td>
                <select id="fsStatus" name="fsStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="fsRemarks"/></td>
        </tr>
        <!--凝结水盘和凝结水管  -->
        <tr>
            <th width="25%" colspan="2">凝结水盘和凝结水管  </th>
            <th>水盘中无异物、凝结水管畅通</th>
            <td>
                <select id="cwppStatus" name="cwppStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="cwppRemarks"/></td>
        </tr>
        <!-- 蒸发器翅片 -->
        <tr>
            <th width="25%" colspan="2">蒸发器翅片</th>
            <th>洁净无倒扶</th>
            <td>
                <select id="efStatus" name="efStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="efRemarks"/></td>
        </tr>
        <!-- 设备内部、外部表面 -->
        <tr>
            <th width="25%" colspan="2">设备内部、外部表面</th>
            <th>洁净无灰尘</th>
            <td>
                <select id="esStatus" name="esStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="esRemarks"/></td>
        </tr>
        <!-- 设备周围环境 -->
        <tr>
            <th width="25%" colspan="2">设备周围环境</th>
            <th>洁净无杂物</th>
            <td>
                <select id="eeStatus" name="eeStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="eeRemarks"/></td>
        </tr>
        <!-- 水盘 -->
        <tr>
            <th width="25%" colspan="2">水盘</th>
            <th>洁净无垢、加湿罐内洁净</th>
            <td>
                <select id="wpStatus" name="wpStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="wpRemarks"/></td>
        </tr>
        <!-- 上下排水管线路、水滤网 -->
        <tr>
            <th width="25%" colspan="2">上下排水管线路、水滤网</th>
            <th>畅通无堵塞现象</th>
            <td>
                <select id="dplWfStatus" name="dplWfStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="dplWfRemarks"/></td>
        </tr>
        <!-- 加湿器水位和水漂 -->
        <tr>
            <th width="25%" colspan="2">加湿器水位和水漂</th>
            <th>水位正常、水漂正常</th>
            <td>
                <select id="hwlwStatus" name="hwlwStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="hwlwRemarks"/></td>
        </tr>
        <!-- 空调出风口风速 -->
        <tr>
            <th width="25%" colspan="2">空调出风口风速</th>
            <th>参数在正常值范围内</th>
            <td>
                <select id="acwsStatus" name="acwsStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="acwsRemarks"/></td>
        </tr>
        <!-- 空调出风口温度 -->
        <tr>
            <th width="25%" colspan="2">空调出风口温度</th>
            <th>参数在正常值范围内</th>
            <td>
                <select id="actStatus" name="actStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="actRemarks"/></td>
        </tr>
        <!-- 空调总接线电压、电流、空调内部压缩机、主风机、室外机电流 -->
        <tr>
            <th width="25%" colspan="2">空调总接线电压、电流、空调内部压缩机、主风机、室外机电流</th>
            <th>各项电流，电压数值正常</th>
            <td>
                <select id="acvcStatus" name="acvcStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="acvcRemarks"/></td>
        </tr>    
    </c:if>
    <!-- 当设备检查类型为季检与年检时，生成如下巡检内容 -->
    <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
        <tr>
            <th width="5%">项目</th>
            <th width="5%">维护<br>内容</th>
            <th width="20%">检查维护内容</th>
            <th width="25%">检查维护标准</th>
            <th width="25%">运行状态</th>
            <th width="20%">备注</th>
        </tr>
        <!-- 制冷系统 -->
        <tr>
            <th width="5%" rowspan="16">艾默生精密空调</th>
            <th width="5%" rowspan="5">制冷系统</th>
            <th width="25%">视镜</th>
            <th width="25%">视镜内无气泡<br>视镜内液体颜色为绿色或蓝色</th>
            <td width="25%">
                <select id="mirrorStatus" name="mirrorStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="mirrorRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">吸排气压力</th>
            <th width="25%">吸气压力应在70psi左右<br>排气压力应在250psi左右</th>
            <td width="25%">
                <select id="sepStatus" name="sepStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="sepRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">制冷管</th>
            <th width="25%">管线固定牢固<br>保温材料无破损</th>
            <td width="25%">
                <select id="rpStatus" name=rpStatus>
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="rpRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">压缩机工作电流</th>
            <th width="25%">工作电流在正常值内</th>
            <td width="25%">
                <select id="cocStatus" name="cocStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="cocRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">室外空调机组内制冷剂压力</th>
            <th width="25%">制冷剂压力在正常值内</th>
            <td width="25%">
                <select id="oacuprStatus" name="oacuprStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td><form:input path="oacurpRemarks"/></td>
        </tr>
        <!-- 室外冷凝设备 -->
        <tr>
            <th width="5%" rowspan="2">室外冷凝设备</th>
            <th width="20%">电机轴承及风扇</th>
            <th width="25%">风扇电机转动灵活，无抖动<br>无轴承摩擦杂音</th>
            <td width="25%">
                <select id="mbfStatus" name="mbfStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="mbfRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">冷凝器散热翅片</th>
            <th width="25%">无灰尘<br>翅片无倒浮现象</th>
            <td>
                <select id="chrfStatus" name="chrfStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="chrfRemarks"/></td>
        </tr>
        <!-- 除湿系统 -->
        <tr>
            <th width="5%" rowspan="2">除湿系统</th>
            <th width="20%">水盘</th>
            <th width="25%">洁净无垢</th>
            <td width="25%">
                <select id="wpStatus" name="wpStatus">
                     <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="wpRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">储水盒、排水管</th>
            <th width="25%">无积水<br>水管排水畅通</th>
            <td width="25%">
                <select id="wsbDpStatus" name="wsbDpStatus">
                     <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="wsbDpRemarks"/></td>
        </tr>
        <!-- 加湿系统 -->
        <tr>
            <th width="5%" rowspan="3">加湿系统 </th>
            <th width="20%">水盘和水漂</th>
            <th width="25%">水位正常、水漂无水垢<br>水盘内洁净无垢、加湿灌内洁净</th>
            <td width="25%">
                <select id="wpbStatus" name="wpbStatus">
                     <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="wpbRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">空调加湿情况</th>
            <th width="25%">加湿情况正常</th>
            <td width="25%">
                <select id="achStatus" name="achStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="achRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">加湿器工作电流</th>
            <th width="25%">加湿器电流在12A左右</th>
            <td width="25%">
                <select id="hwcStatus" name="hwcStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="hwcRemarks"/></td>
        </tr>
        <!-- 电气系统 -->
        <tr>
            <th width="5%" rowspan="4">电气系统</th>
            <th width="20%">供电电气线路</th>
            <th width="25%">供电电气线路无老化现象</th>
            <td width="25%">
                <select id="pslStatus" name="pslStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="pslRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">接线</th>
            <th width="25%">各接线柱无松动现象</th>
            <td width="25%">
                <select id="connStatus" name="connStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="connRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">电气控制部分</th>
            <th width="25%">室内外机电气控制盘内清洁无尘</th>
            <td width="25%">
                <select id="ecpStatus" name="ecpStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="ecpRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">所有继电器触点、电气元件</th>
            <th width="25%">所有继电器应按工作要求吸合、断开无杂音</th>
            <td width="25%">
                <select id="rcEcStatus" name="rcEcStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="rcEcRemarks"/></td>
        </tr>
    </c:if>
    <!-- 数据记录 -->
    <tr><th width="100%" colspan="6">数据记录</th></tr>
    <tr>
        <th width="30%" colspan="3">名称</th>
        <th width="25%">数值</th>
        <th width="25%">状态</th>
        <th width="20%">备注</th>
    </tr>
    <!-- 总电压 -->
    <tr>
        <th width="30%" colspan="3">总电压</th>
        <td width="25%"><form:input path="tvValue"/></td>
        <td width="25%">
            <select id="tvStatus" name="tvStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="tvRemarks"/></td>
    </tr>
    <!-- 总电流 -->
    <tr>
        <th width="30%" colspan="3">总电流</th>
        <td width="25%"><form:input path="tcValue"/></td>
        <td width="25%">
            <select id="tcStatus" name="tcStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="tcRemarks"/></td>
    </tr>
    <!--1号压缩机电流  -->
    <tr>
        <th width="30%" colspan="3">1号压缩机电流</th>
        <td width="25%"><form:input path="cconeValue"/></td>
        <td width="25%">
            <select id="cconeStatus" name="cconeStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <th width="20%"><form:input path="cconeRemarks"/></th>
    </tr>
    <!-- 2号压缩机电流 -->
    <tr>
        <th width="30%" colspan="3">2号压缩机电流</th>
        <td width="25%"><form:input path="cctwoValue"/></td>
        <td width="25%">
            <select id="cctwoStatus" name="cctwoStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="cctwoRemarks"/></td>
    </tr>
    <!-- 主风机电流 -->
    <tr>
        <th width="30%" colspan="3">主风机电流</th>
        <td width="25%"><form:input path="mfcValue"/></td>
        <td width="25%">
            <select id="mfcStatus" name="mfcStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="mfcRemarks"/></td>
    </tr>
    <!-- 室外机电流 -->
    <tr>
        <th width="30%" colspan="3">室外机电流</th>
        <td width="25%"><form:input path="omcValue"/></td>
        <td width="25%">
            <select id="omcStatus" name="omcStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="omcRemarks"/></td>
    </tr>
    <c:if test="${checkType eq 'MONTH' }">
        <!-- 加湿器电流 -->
        <tr>
            <th width="30%" colspan="3">加湿器电流</th>
            <td width="25%"><form:input path="hcValue"/></td>
            <td width="25%">
                <select id="hcStatus" name="hcStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="hcRemarks"/></td>
        </tr>
    </c:if>
    <!-- 出风口温湿度 -->
    <tr>
        <th width="30%" colspan="3">出风口温湿度</th>
        <td width="25%"><form:input path="aothValue"/></td>
        <td width="25%">
            <select id="aothStatus" name="aothStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <td width="20%"><form:input path="aothRemarks"/></td>
    </tr>
    <!-- 出风口风速-->
    <tr>
        <th width="30%" colspan="3">出风口风速</th>
        <td width="25%"><form:input path="aowsValue"/></td>
        <td width="25%">
            <select id="aowsStatus" name="aowsStatus">
                <c:forEach items="${checkresult }" var="vo">
                    <option value="${vo }">${vo.value }</option>
                </c:forEach>
            </select>
        </td>
        <th width="20%"><form:input path="aowsRemarks"/></th>
    </tr>
    <c:if test="${checkType eq 'QUARTER' || checkType eq 'YEAR' }">
        <tr>
            <th width="10%" rowspan="3" colspan="2">加湿器电流</th>
            <th width="20%">A</th>
            <td width="25%"><form:input path="hcaValue"/></td>
            <td width="25%">
                <select id="hcaStatus" name="hcaStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="hcaRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">B</th>
            <td width="25%"><form:input path="hcbValue"/></td>
            <td width="25%">
                <select id="hcbStatus" name="hcbStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="hcbRemarks"/></td>
        </tr>
        <tr>
            <th width="20%">C</th>
            <td width="25%"><form:input path="hccValue"/></td>
            <td width="25%">
                <select id="hccStatus" name="hccStatus">
                    <c:forEach items="${checkresult }" var="vo">
                        <option value="${vo }">${vo.value }</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20%"><form:input path="hccRemarks"/></td>
        </tr>
    </c:if>
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