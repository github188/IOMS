<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#tempCircuit").validate({
			rules : {
				applyCompany : {
					required : true,
					maxlength : 50
				},
				linkMan : {
					required : true,
					maxlength : 10
				},
				circuitInfo : {
					required : true,
					maxlength : 1000
				},
				linkEmail : {
					required : true,
					email : true
				},
				linkPhone:{
					required : true,
					phoneAndMobile : true
				},
				circuitType : {
					required : true
				},
				aNodeView : {
					required : true
				},
				aEquipID : {
					required : true
				},
				planOpenTime : {
					required : true
				}
			}
		});
	});
	function validate(formData, jqForm, options) {
		url = "${rootUrl}tempcircuit/modApply.do";
		$("#tempCircuit").attr("action", url);
		return $("#tempCircuit").valid();
	}
	function zNodeAddData() {
		//var id = $("#zNodeView").next("input").val();
		var id_znode = $("#zNodeView").val();//数据
		var id = $("#zNode").val();//编号
		var node = [];
		var bureau;
		var name;
		var code;
		node = id_znode.split(" ");
		bureau = node[0];
		name = node[1];
		code = node[2];
		if (id_znode == 0 || id == 0 || bureau == undefined
				|| name == undefined || code == undefined) {
			alert("先选中对（收）端节点再添加！");
		} else {
			var equips = $("#yourTable input[name='zEquipIdSelect']");
			var flag = 1;
			for (var i = 0; i < equips.length; i++) {
				if (name == $(equips[i]).val())
					flag = 0;
			}
			var id_td = "<td style='display:none'><input type='hidden' name='zEquipIdSelect' value='"+name+"' /></td>";
			var show_td = "<td>" + id_znode + "</td>";
			var bureau_td = "<td>" + bureau + "</td>";
			var name_td = "<td style='width:50%;border:1px solid #cfcfcf'>"
					+ name + "</td>";
			var code_td = "<td>" + code + "</td>";
			var del_td = "<td style='width:50%;border:1px solid #cfcfcf'><input class='u-btn' style='cursor: pointer;width: 60px; text-align: center;'"
					+ "onclick='changeEquip1(\""
					+ name
					+ "\")'"
					+ "value='删除' /></td>"
			if (flag == 1) {
				$("#yourTable").append(
						"<tr>" + id_td + name_td + del_td + "</tr>");
			} else {
				alert("对(收)端节点:\n\n" + id_znode + "\n\n已经添加过了！");
			}
		}
		$("#zNodeView").val("");
		$("#zNode").val("");
	}
	function changeEquip1(id) {
		var tr = $("#yourTable").find("input[value='" + id + "']").parent()
				.parent();
		tr.remove();
	}
	function ajaxNode(obj) {
		var node = [];
		$("#aNodeView").val("");
		$("#zNodeView").val("");
		$("#aNode").val("");
		$("#zNode").val("");
		//$("#yourTable tr").remove();
		var circuitType = $("#circuitTypeMod").val();

		if (circuitType == 'MPLSVPN' || circuitType == 'TESVOICE') {
			$("#box").css("visibility", "hidden");
			$("#zNodeTdDiv").attr("style",
					"visibility:hidden;font-weight: bold; text-align: left;");
			$("#zNodeSelDiv").attr("style",
					"visibility:hidden;text-align: left;");
			$("#zNode").rules("remove");
			$("#zNodeView").rules("remove");
			$("#zNodeAdd").attr("style", "visibility:hidden;text-align: left;");
		} else {
			if (circuitType == 'TESBROADCAST' || circuitType == 'KUBROADCAST') {
				$("#box").css("visibility", "visible");
				$("#zNodeAdd")
						.attr("style",
								"cursor: pointer;visibility:visable;text-align: center;");
				$("#zNodeView").rules("remove");
			} else {
				$("#box").css("visibility", "hidden");
				$("#zNodeAdd").attr("style",
						"visibility:hidden;text-align: left;");
				$("#zNodeView").rules("add", {
					required : true
				});
			}
			$("#zNodeTdDiv").attr("style",
					"visibility:visable;font-weight: bold; text-align: left;");
			$("#zNodeSelDiv").attr("style",
					"visibility:visable;text-align: left;");
			$("#zNode").rules("add", {
				required : true
			});
		}
		if ("" != circuitType) {
			var url = "${rootUrl}basedata/equipnode.dox?r=" + Math.random();
			$.ajax({
				url : url,
				type : "GET",//get请求
				data : "circuitType=" + circuitType,
				async : false,//同步加载数据
				dataType : "json",//返回json格式
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						node[i] = {
							name : response[i].name,
							code : response[i].code,
							bureau : response[i].bureau,
							id : response[i].id
						}
					}
					$("#aNodeView").unautocomplete();
					$("#aNodeView").autocomplete(
							node,
							{
								minChars : 0,
								width : 400,
								matchContains : true,
								autoFill : false,
								max : 100,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.bureau
											+ "   " + row.name + "   "
											+ row.code;
								},
								formatMatch : function(row, i, max) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								},
								formatResult : function(row) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#aNode").val(row.id);
						}
					});
					$("#zNodeView").unautocomplete();
					$("#zNodeView").autocomplete(
							node,
							{
								minChars : 0,
								width : 400,
								matchContains : true,
								autoFill : false,
								max : 100,
								dataType : "json",
								mustMatch : true,
								formatItem : function(row, i, max) {
									return i + "/" + max + ":" + row.bureau
											+ "   " + row.name + "   "
											+ row.code;
								},
								formatMatch : function(row, i, max) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								},
								formatResult : function(row) {
									return row.bureau + " " + row.name + " "
											+ row.code;
								}
							}).result(function(e, row) {
						if (row != null) {
							$("#zNode").val(row.id);
						}
					});
				}
			});
		}
	}
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="tempCircuit"
		name="tempCircuit" action="${rootUrl}tempcircuit/modApply.do"
		method="post">
		<table>
			<form:hidden path="id" />
			<tr>
				<td width="20%" style="text-align: left; font-weight: bold">申请单位<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input type="text"
						path="applyCompany" style="width: 40%" value="${user.dept}"></form:input></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">联系人<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input type="text"
						path="linkMan" style="width: 40%" value="${user.name}"></form:input></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">联系方式<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input type="text"
						path="linkPhone" style="width: 40%" value="${user.mobilephone}"
						placeholder="输入正确手机/座机号码"></form:input></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">联系人Email<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input type="text"
						path="linkEmail" style="width: 40%" value="${user.email}"></form:input></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">计划开通时间<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input path="planOpenTime"
						onclick="WdatePicker()" style="width: 40%" /></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">电路类型<font
					color="red">(*)</font>：
				</td>
				<td style="text-align: left"><form:select id="circuitTypeMod"
						path="circuitType" onchange="ajaxNode(this)" style="width: 40%">
						<option value='' selected="selected">请选择</option>
						<form:options items="${circuitTypes}" itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">本端节点名称<font
					color="red">(*)</font>:
				</td>
				<td style="text-align: left"><form:input id="aNodeView"
						path="aNodeView" style="width: 40%" placeholder="请输入区域/名称/代码" />
					<form:hidden id="aNode" path="aEquipID" /></td>
			</tr>
			<tr>
				<td id="zNodeTdDiv" style="text-align: left; font-weight: bold">对端节点名称<font
					color="red">(*)</font>:
				</td>
				<td id="zNodeSelDiv" style="text-align: left"><form:input
						id="zNodeView" path="zNodeView" style="width: 40%"
						placeholder="请输入区域/名称/代码" /> <form:hidden id="zNode"
						path="zEquipID" /> <input class="u-btn" id="zNodeAdd"
					style="cursor: pointer; width: 85px; text-align: center; color: blue"
					onclick="zNodeAddData()" value="添加" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="box" rows="10"
						style="visibility: hidden; height: 96px; overflow: auto; border: 1px solid #cfcfcf">
						<table style="width: 60%">
							<tr align='center'>
								<th
									style="width: 50%; border: 1px solid #cfcfcf; font-weight: bold; text-align: center">节点代码</th>
								<th
									style="border: 1px solid #cfcfcf; font-weight: bold; text-align: center">操作</th>
							</tr>
						</table>
						<table id="yourTable" style="width: 60%">
							<c:forEach items="${tempCircuitTesKuBroad}" var="vo"
								varStatus="voStatus">
								<tr align='center'>
									<td style='display: none'><input type="hidden"
										name="zEquipIdSelect" value="${vo.node}" /></td>
									<%-- <td>${vo.tempCircuit.zEquip.bureau.value}</td> --%>
									<td style="width: 50%; border: 1px solid #cfcfcf">
										${vo.node}</td>
									<%-- <td>${vo.tempCircuit.zEquip.name}</td> --%>
									<td style="width: 50%; border: 1px solid #cfcfcf"><input
										class="u-btn"
										style="cursor: pointer; width: 60px; text-align: center;"
										onclick="changeEquip1('${vo.node}')" value="删除" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td style="text-align: left; font-weight: bold">备注信息<font
					color="red">(*):</font>：
				</td>
				<td style="text-align: left"><form:textarea path="circuitInfo"
						style="width: 40%" rows="10"
						placeholder="请填写临时电路所需配置详情:节点，槽位，端口，速率，信令等"></form:textarea></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
		ajaxNode($("#circuitTypeMod").val());
		$("#aNode").val('${pageModel.aEquip.id}');
		$("#zNode").val('${pageModel.zEquip.id}');
		$("#aNodeView").val('${pageModel.aEquip.code}');
		//$("#zNodeView").val('${pageModel.zEquip.code}');
	</script>
</body>
</html>
