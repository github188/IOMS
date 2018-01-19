<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />

<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false,
			async : false
		});
		

        $("#listForm").validate({
            rules : {},
            submitHandler : function(form) {
                parent.editSubmit(form);
            }
        });

    	$("#submit").click(function() {
    	    var equips = $("#equipForm input[name='equipID']");
   		
    		var equipParam = "";
            for ( var i = 0; i < equips.length; i++) {
                equipParam = equipParam + "&equipID=" + $(equips[i]).val();
            }

            var clientID = $("#clientID").val();
            var url = $("#equipForm").attr("action") + "?clientID=" + clientID;
            if ("" != equipParam) {
                url = url + equipParam;
            }
            
            $("#listForm").attr("action", url);
            $("#listForm").trigger("submit");
        });

    	$("#del").click(function(){
    		$(checkbox).prop("checked",false);
    		changeEquip(checkbox);
    	});
    	
        btnSubmit();//查询设备
        //	queryEquip();
        $(".close").click(function() {
            parent.$.nyroModalRemove();
        });

    });
    function queryEquip() {
        var equips = $("#equipForm input[name='equipID']");

        for ( var i = 0; i < equips.length; i++) {

            var id = $(equips[i]).val();
            var equip = $("#dataTable input[id='" + id + "']");
            if (equip) {
                var obj_input = equip.siblings()[0];

                $(obj_input).attr("checked", true);
            }

        }
    }
    /* function submit() {
        var equips = $("#equipForm input[name='equipID']");

        var equipParam = "";
        for ( var i = 0; i < equips.length; i++) {
            equipParam = equipParam + "&equipID=" + $(equips[i]).val();
        }

        var clientID = $("#clientID").val();
        var url = $("#equipForm").attr("action") + "?clientID=" + clientID;
        if ("" != equipParam) {
            url = url + equipParam;
        }

        $.post(url, function(response) {

            parent.$.nyroModalRemove();
        });
    } */

    function btnSubmit() {
        $("#listForm").ajaxSubmit({
            target : "#queryResult"
        });
        queryEquip();
    }
    function changeEquip1(id) {
		var checkbox = $("#dataTable").find("input[value='" + id + "']").prev();
		checkbox.removeAttr("checked");
		//alert(checkbox.attr("name"));
		var tr = $("#SelectEquipTable").find("input[value='" + id + "']").parent().parent();
        var array = $(tr).nextAll();
        for ( var i = 0; i < array.length; i++) {
            var count_td = $(array[i]).children()[1];
            $(count_td).html($(count_td).html() - 1);
        }
        tr.remove();
    }
    function changeEquip(checkbox) {
        var id = $(checkbox).next("input").val();
        if (checkbox.checked) {
            //移动到选中
            var name = $(checkbox).parent().next();
            var code = name.next();
            var model = code.next();
            var bureau = model.next();
            var netType = bureau.next();
            var id_td = "<td style='display:none'><input type='hidden' name='equipID' value='"+id+"' /></td>";
            var count_td = "<td>" + ($("#SelectEquipTable").find("tr").length - 1) + "</td>";
            var name_td = "<td>" + name.html() + "</td>";
            var code_td = "<td>" + code.html() + "</td>";
            var model_td = "<td>" + model.html() + "</td>";
            var bureau_td = "<td>" + bureau.html() + "</td>";
            var netType_td = "<td>" + netType.html() + "</td>";
            var del_td = "<td>" + "<div class='btn'>" +
			"<a href='#none' id='del' onclick='changeEquip1(\""+id+"\")'>删除</a>"
			+ "</div> " +  "</td>"
            $("#SelectEquipTable").append("<tr>" + id_td + count_td + name_td + code_td + model_td + bureau_td + netType_td + del_td +"</tr>");

        } else {
            //选中下方删掉
            var tr = $("#SelectEquipTable").find("input[value='" + id + "']").parent().parent();
            var array = $(tr).nextAll();
            for ( var i = 0; i < array.length; i++) {
                var count_td = $(array[i]).children()[1];
                $(count_td).html($(count_td).html() - 1);
            }
            tr.remove();
        }
    }
    function selectAll(){
    	var checkboxs = document.getElementsByName("equip");
    	//alert(checkboxs);
    	for(var i=0; i<checkboxs.length; i++){
    		var sel = checkboxs[i];
    		sel.checked =! sel.checked;
    		changeEquip(sel);
    	}
    	var se = $("p");
    	var re = $($(se.parent()).children()[0]).html();
    	if(re=="全选"){
    		 $("p").replaceWith("<p>反选</p>");
    	}else{
    		 $("p").replaceWith("<p>全选</p>");
    	}
		//checkboxs.removeAttr("checked");
    }
</script>
</head>
<body>

	<div class="window" style="overflow: visible;">
		<!-- 内容页 -->


		<div id="main">
			<!--place-->
			<dl class="title">
				<dd>配置卫星</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>

			<!--place-->
			<div class="minfo" style="overflow: visible;">
				<div class="bl">
					<div class="br">
						<div class="clear"></div>
						<div id="lmsx">
							<!--管理按钮-->
							<form:form modelAttribute="queryModel" id="listForm"
								name="listForm"
								action="${rootUrl}systemmng/client/querySatellite.dox" method="post">
								<!-- 查询条件 -->
								<div class="boxbtn" style="width: 90%; margin-left: 20px">
									<div class="info">
										区域：
										<form:select path="bureau" 
											cssStyle="width:100px;margin-right:20px;">
											<form:option value="">-请选择-</form:option>
											<c:forEach items="${bureauList}" var="bureau">
												<form:option value="${bureau.name}">${bureau.value}</form:option>
											</c:forEach>
										</form:select>
										设备号：
										<form:input path="nameLike" size="10" maxlength="50"
											cssStyle="width:100px;margin-right:20px;" />
										网络类型：
										<form:select path="type"
											cssStyle="width:100px;margin-right:20px;">
											<form:option value="">-请选择-</form:option>
											<form:option value="KU">KU</form:option>
											<form:option value="TES">TES</form:option>
										</form:select>

									</div>
									<a href="#none" class="sbtn" id="queryButton"
										onclick="btnSubmit()">查询</a> <a href="#none" class="sbtn"
										onclick="listForm.reset();">重置</a>
										<a href="#none" class="sbtn" id="selectButton"
										onclick="selectAll()"><p>全选</p></a> 
								</div>
								<div class="bclear"></div>
								<!-- 查询条件 -->
							</form:form>
							<div class="mtab">
								<table border="0" cellspacing="0" cellpadding="0" class="title"
									style="width: 98%; margin-left: 10px">
									<tr>
										<td class="td1"><img src="${rootUrl}images/pl1.gif"
											alt="" />设备列表</td>

									</tr>
								</table>
								<!--查询结果-->
								<div id="queryResult"
									style="width: 98%; margin-left: 10px; overflow-y: scroll; overflow-x: hidden; height: 200px"></div>
								<!--查询结果-->
								<div class="clear"></div>
							</div>

							<div id="pic" style="margin-left: 10px; width: 98%;">
								<center>
									<img src="${rootUrl }images/arrowhead.png" alt="" />
								</center>
							</div>
							<div id="selectDiv"
								style="margin-left: 10px; width: 98% ；height:200px">
								<form id="equipForm"
									action="${rootUrl }systemmng/client/equipConfig.do"
									method="post">
								<div class="mtab">
									<table border="0" cellspacing="0" cellpadding="0" class="title"
										style="width: 100%; margin-left: 0px" id="SelectEquipTable">
										<tr>
											<td colspan="7" class="td1"><img src="${rootUrl}images/pl1.gif"
												alt="" />选中设备</td>

										</tr>
										<tr>


											<th style="display: none">id</th>
											<th style="width: 5%">序号</th>
											<th style="width: 15%">区域</th>
											<th style="width: 20%">设备号</th>
											<th style="width: 15%;">型号</th>
											<th style="width: 15%">站点名称</th>
											<th style="width: 15%">网络类型</th>
											<th style="width: 15%">操作</th>
										</tr>
										<c:forEach items="${equips}" var="vo" varStatus="voStatus">
											<tr>
												<c:choose>
													<c:when test="${vo.type.name eq 'TES' }">
														<td style="display:none"><input type="hidden" name="equipID"
															value="${vo.id}" /></td>
														<td>${voStatus.count}</td>
														<td>${vo.bureau.value}</td>
														<td>${vo.name}</td>
														<td>${vo.model}</td>
														<td>${vo.satellite.siteName}</td>
														<td>${vo.type.name}</td>
														<td><div class="btn">
															<a href="#none" onclick="changeEquip1('${vo.id}')" id="del">删除</a>
														</div></td>
													</c:when>
													<c:when test="${vo.type.name eq 'KU' }">
														<td style="display:none"><input type="hidden" name="equipID"
															value="${vo.id}" /></td>
														<td>${voStatus.count}</td>
														<td>${vo.bureau.value}</td>
														<td>${vo.name}</td>
														<td>${vo.model}</td>
														<td>${vo.satellite.siteName}</td>
														<td>${vo.type.name}</td>
														<td><div class="btn">
															<a href="#none" onclick="changeEquip1('${vo.id}')" id="del">删除</a>
														</div></td>
													</c:when>
													<c:otherwise>
														<tr style="display:none">
															<td style="display:none"><input type="hidden" name="equipID"
																value="${vo.id}" /></td>
															<td>${voStatus.count}</td>
															<td>${vo.bureau.value}</td>
															<td>${vo.name}</td>
															<td>${vo.model}</td>
															<td>${vo.code}</td>
															<td><div class="btn">
																<a href="#none" onclick="changeEquip1('${vo.id}')" id="del">删除</a>
															</div></td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tr>
											
										</c:forEach>
									</table>
								</div>
								
									<input type="hidden" id="clientID" name="clientID"
										value="${userID }" />
									<div class="boxbtn">
										<div class="btn">
											<a href="#none" id="submit">保存</a>
										</div>
										<div class="btn">
											<a href="#none" class="close">取消</a>
										</div>
									</div>
									<div class="clear"></div>
								</form>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<br />



</body>
</html>