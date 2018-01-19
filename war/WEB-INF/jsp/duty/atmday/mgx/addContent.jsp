<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
    type="text/javascript"></script>
<style>
<!--
.tdWidth {
    width: 100%;
}
-->
</style>

<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>通信基地8850</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="10" scope="row">2</th>
        <td width="30%" rowspan="10"><p>连通性检查</p></td>
        <td width="30%">与十里河8850节点的连通性</td>
        <td><select id="slh8850_con" name="slh8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">与通信基地8830节点的连通性</td>
        <td><select id="txjd8830_con" name="txjd8830_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">民航局</td>
        <td><select id="mhj_con" name="mhj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">首都机场</td>
        <td><select id="capital_con" name="capital_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">西安</td>
        <td><select id="xian" name="xian">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">广州</td>
        <td><select id="guangzhou" name="guangzhou">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">成都</td>
        <td><select id="chengdu" name="chengdu">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">上海</td>
        <td><select id="shanghai" name="shanghai">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">沈阳</td>
        <td><select id="shenyang" name="shenyang">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">乌鲁木齐</td>
        <td><select id="wulumuqi" name="wulumuqi">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="txjdbz" name="txjdbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>通信基地8830</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="2" scope="row">2</th>
        <td width="30%" colspan="2">与通信基地8850节点的连通性</td>
        <td><select id="txjd8850_con" name="txjd8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
         <td width="30%" colspan="2">中继连通状态</td>
        <td><select id="zj_con" name="zj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="txjdsbz" name="txjdsbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>十里河8850</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="4" scope="row">2</th>
        <td width="30%" rowspan="4"><p>与相邻节点连通性</p></td>
        <td width="30%">网控中心8830</td>
        <td><select id="wkzx8830_con" name="wkzx8830_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
         <td width="30%">通信基地8850</td>
        <td><select id="txjd8850_con" name="txjd8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
     <tr>
         <td width="30%">民航局空管局</td>
        <td><select id="mhj_con" name="mhj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
     <tr>
         <td width="30%">首都机场</td>
        <td><select id="capital_con" name="capital_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="slhbz" name="slhbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>十里河8830</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="2" scope="row">2</th>
        <td width="30%" colspan="2">与网控中心8850节点的连通性</td>
        <td><select id="wkzx8850_con" name="wkzx8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
         <td width="30%" colspan="2">中继连通状态</td>
        <td><select id="zj_con" name="zj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="slhsbz" name="slhsbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>民航局8850</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="2" scope="row">2</th>
        <td width="30%" rowspan="2"><p>与相邻节点连通性</p></td>
        <td width="30%">十里河8850</td>
        <td><select id="slh8850_con" name="slh8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">民航局空管局</td>
        <td><select id="mhj_con" name="mhj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" scope="row">3</th>
        <td width="30%" colspan="2">中继连通状态</td>
        <td><select id="zj_con" name="zj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">4</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="mhjbz" name="mhjbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>民航局空管局8850</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="2" scope="row">2</th>
        <td width="30%" rowspan="2"><p>与相邻节点连通性</p></td>
        <td width="30%">十里河8850</td>
        <td><select id="slh8850_con" name="slh8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
     <tr>
        <td width="30%">民航局空管局</td>
        <td><select id="mhj_con" name="mhj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" scope="row">3</th>
        <td width="30%" colspan="2">中继连通状态</td>
        <td><select id="zj_con" name="zj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">4</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="kgjbz" name="kgjbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>
<div style="margin: 10px 20px 10px; padding: 0px"></div>
<div style="margin: 10px 20px 0px; padding: 0px">
    <dl class="title">
        <dd>财富中心8830</dd>
    </dl>
</div>
<table width="100%" border="1">
    <tr>
        <th width="10%" scope="col">序号</th>
        <th width="60%" colspan="2" scope="col">检查项目</th>
        <th width="30%" scope="col">状态结果</th>
    </tr>
    <tr>
        <th width="10%" rowspan="3" scope="row">1</th>
        <td width="30%" rowspan="3"><p>设备运行环境</p></td>
        <td width="30%">风扇</td>
        <td><select id="env_fan" name="env_fan">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">电源</td>
        <td><select id="env_power" name="env_power">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td width="30%">温度</td>
        <td><select id="env_temperatuer" name="env_temperatuer">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th width="10%" rowspan="2" scope="row">2</th>
        <td width="30%" colspan="2">与十里河8850节点的连通性</td>
        <td><select id="slh8850_con" name="slh8850_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
         <td width="30%" colspan="2">中继连通状态</td>
        <td><select id="zj_con" name="zj_con">
                <c:forEach items="${statusResults}" var="vo">
                    <option value="${vo}">${vo.value}</option>
                </c:forEach>
        </select></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td width="30%">备注</td>
        <td colspan="2"><textarea id="cfzxbz" name="cfzxbz"
                rows="5" class="tdWidth" placeholder="内容不能超过100个字"></textarea></td>
    </tr>
</table>



<div class="boxbtn">
    <div class="btn">
        <a href="#none" id="submit">保存</a>
    </div>
    <div class="btn">
        <a href="#none" class="close">取消</a>
    </div>
</div>