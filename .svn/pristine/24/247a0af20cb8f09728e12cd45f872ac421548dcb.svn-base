<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
#envTable{
	margin : 0px;
	padding : 0px;
	border : 1px solid #95BDD7;
	width: 100%; 
	height: 100%;
}
#envTable td{
	border : 1px solid #95BDD7;
	color: #1F83B7;
	text-align: center;
	padding : 0px;
}
#envTable td table th {
	border: 1px solid #95BDD7;
	background: #EFF0F2;
	height: 25px;
	color: #1F83B7;
	text-align: center;
	font-size: 13px;
	font-weight: normal;
}
</style>
	<table id="envTable">
		<tr>
			<td>
				<div id="goal-thermometer" style="height: 140px; opacity: 1;"></div>
			</td>
			<td style="display: none" id="8830pic">
					<img style="max-width: 190px; height: 100px; width: express(this.width &gt;   190 ?   190px px :   auto)"
						src="${rootUrl }images/Atm_8830.bmp" />
			</td>
			<td style="display: none" id="8850pic">
					<img style="max-width: 190px; height: 100px; width: express(this.width &gt;   190 ?   190 px :   auto)"
						src="${rootUrl }images/Atm_8850.png" />
			</td>
			<td id="8830fan" style="display: none;">
				<%@include file="fan8830.jsp"%>
			</td>
			<td id="8850fan" style="display: none;">
				<%@include file="fan8850.jsp"%>
			</td>
		</tr>
		<tr>
			<td colspan="3" id="8830dy" style="display: none">
				<div id="8830dianya"></div>
			</td>
			<td colspan="3" id="8850dy" style="display: none">
				<div id="8850dianya"></div>
			</td>
		</tr>
	</table>
