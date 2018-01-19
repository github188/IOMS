<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style>
<!--
	.t_title{
		text-align: center;
	}
-->
</style>
<script type="text/javascript">
$(function (){
	$(".config").hide();
	$(".config2").show();
})
</script>

<tr class="t_title config2">
<td width="40%" colspan="4">ATM地址/广域网地址</td>
<td width="60%" colspan="6">
<input type="text" name="placeATM"></td>
</tr>
<tr class="t_title config2">
<td width="40%" colspan="4">ATM0地址/Loopback地址</td>
<td width="60%" colspan="6">
<input type="text" name="placeATMO"></td>
</tr>
<tr class="t_title config2">
<td width="30%" colspan="2">中继连通性</td>
<td width="30%" colspan="3">
<input id="connectivity" name="connectivity" type="radio" value="1"
style="width: 30px;" checked="checked" />正常
<input id="connectivity" name="connectivity" value="0"
type="radio" style="width: 30px" />异常</td>
<td width="40%" colspan="5">ATM节点中继的Pn端口状态为twoWayInside或IP节点中继端口状态为UP，视为连通性正常</td>
</tr>
<tr class="t_title config2">
<td width="30%" colspan="2">节点是否正常管理</td>
<td width="30%" colspan="3">
<input id="nodemng" name="nodemng" type="radio" value="1"
style="width: 30px;" checked="checked" />正常
<input id="nodemng" name="nodemng" value="0"
type="radio" style="width: 30px" />异常</td>
<td width="40%" colspan="5">通过网管软件或其他网内设备能teInet节点并可以进行访问控制，视为管理正常</td>
</tr>
<tr class="config2">
	<td width="30%" colspan="2">备注：<span style="color: red">(*)</span></td>
	<td colspan="8">
		<textarea id="confRemark" name="confRemark" rows="8" style="width:500px;"></textarea>
	</td>
</tr>