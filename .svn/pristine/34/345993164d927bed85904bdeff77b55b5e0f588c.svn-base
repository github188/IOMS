<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script type="text/javascript">
$("#tesNodeCode${voStatus.count}").autocomplete({
	minLength: 1, 
    autoFocus: true, 
    delay: 500 ,
    source: function(request, response) {
        $.ajax({
            url: "${rootUrl}operstat/tes/equipcode.dox",
            dataType: "json",
            data: {
            	code : request.term
            },
            success: function(data) {
            	if (data == null || data == [] || data == "") {
            		//$("#statid").val("");
            		$("#tesNodeCode${voStatus.count}").val("");
					return;
				}
                response($.map(data, function(item) {
                    return { 
                    	value : item.tesNodeCode,
						name : item.id,
						code:item.tesNodeCode
                    }
                }));
            }
        });
    },
    change : function(event, ui) {
    	$.ajax({
	            url: "${rootUrl}operstat/tes/nodecucode.dox",
	            dataType: "json",
	            data: {
	                code:'',
	            	tesnodecode:$("#tesNodeCode${voStatus.count}").val()+''
	            },
	            success: function(data) {
	            	$('#cuSelectCode${voStatus.count}').empty();
	            	if (data == null || data == [] || data == "") {
						return;
					}
	            	$('#cuSelectCode${voStatus.count}').append("<option value=''>请选择</option>");
	            	for(var i=0;i<data.length;i++){
				        $('#cuSelectCode${voStatus.count}').append("<option value='"+data[i].cu+"'>"+data[i].cu+"</option>");
	            	}
	            }
	        });
    },
    select : function(event, ui) {
    	$('#cuSelectCode${voStatus.count}').empty();
    	$('#cuSelectCode${voStatus.count}').html("");
        //主动为出发城市及代码赋值
        //$("#statid").val(ui.item.code);
		$("#tesNodeCode${voStatus.count}").val(ui.item.code);

        $.ajax({
            url: "${rootUrl}operstat/tes/nodecucode.dox",
            dataType: "json",
            data: {
                code:'',
            	tesnodecode:$("#tesNodeCode${voStatus.count}").val()+''
            },
            success: function(data) {
            	if (data == null || data == [] || data == "") {
					return;
				}
            	for(var i=0;i<data.length;i++){
            		if(data[i].cu!=cu){
    		      		$('#cuSelectCode${voStatus.count}').append("<option value='"+data[i].cu+"'>"+data[i].cu+"</option>");
            	    }else if(data[i].cu==cu){
        		        $('#cuSelectCode${voStatus.count}').append("<option selected=true value='"+cu+"'>"+cu+"</option>");
            	    }
            	}
            }
        });
    }

});
/* $("#cuCode${voStatus.count}").autocomplete({
	minLength: 2, 
    autoFocus: true, 
    delay: 500 ,
    source: function(request, response) {
        $.ajax({
            url: "${rootUrl}operstat/tes/nodecucode.dox",
            dataType: "json",
            data: {
            	code : request.term,
            	tesnodecode:$("#tesNodeCode${voStatus.count}").val()+''
            },
            success: function(data) {
            	if (data == null || data == [] || data == "") {
            		//$("#statid").val("");
            		$("#cuCode${voStatus.count}").val("");
					return;
				}
                response($.map(data, function(item) {
                    return { 
                    	value : item.cu,
						name : item.id,
						code:item.cu
                    }
                }));
            }
        });
    },
    change : function(event, ui) {
        if (!ui.item) {
            //$("#statid").val("");
    		$("#cuCode${voStatus.count}").val("");
        }
    },
    select : function(event, ui) {
        //主动为出发城市及代码赋值
        //$("#statid").val(ui.item.code);
		$("#cuCode${voStatus.count}").val(ui.item.code);
    }

}); */
$("#updateButton${voStatus.count}").click(function() {
    var nodecode = $("#tesNodeCode${voStatus.count}").val();
    var cucode = $("#cuSelectCode${voStatus.count}").val();
    if(nodecode==null || cucode==null){
        alert("请将信息填写完整！");
        return ;
    }if(nodecode=='' || cucode==''){
        alert("请将信息填写完整！");
        return ;
    }
    $.ajax({
        cache:true,
		type : "POST",
		url : "${rootUrl}operstat/tes/update.do",
		data:{
		    equip:$("#tesNodeCode${voStatus.count}").val(),
		    //nodecu:$("#cuCode${voStatus.count}").val(),
		    nodecu:$("#cuSelectCode${voStatus.count}").val(),
		    id:'${vo.id}'
		},
		success : function(result) {
		    alert(eval("("+result+")").msg);
		    /* var nodecu = eval("("+result+")").nodecu;
		    alert(nodecu);
			location.reload();
			alert($("option[value ='"+ nodecu+"']"));
			$("option[value ='"+ nodecu+"']").attr("selected",true); */
		}
	});
});
$("#saveButton${voStatus.count}").click(function() {
    var nodecode = $("#tesNodeCode${voStatus.count}").val();
    var cucode = $("#cuSelectCode${voStatus.count}").val();
    if(nodecode==null || cucode==null){
        alert("请将信息填写完整！");
        return ;
    }if(nodecode=='' || cucode==''){
        alert("请将信息填写完整！");
        return ;
    }
    $.ajax({
        cache:true,
		type : "POST",
		url : "${rootUrl}operstat/tes/update.do",
		data:{
		    equip:$("#tesNodeCode${voStatus.count}").val(),
		    //nodecu:$("#cuCode${voStatus.count}").val(),
		    nodecu:$("#cuSelectCode${voStatus.count}").val(),
		    id:'${vo.id}'
		},
		success : function(result) {
		    alert(eval("("+result+")").msg);
		    //var nodecu = eval("("+result+")").nodecu;
			//location.reload();
			/* alert($("option[value ='"+ nodecu+"']").attr("value"));
			$("option[value ='"+ nodecu+"']").attr("selected",true); */
		}
	});
});

//弹出页面执行以下代码，初始化异常节点配置
var cu = '${fn:escapeXml(vo.tesSlot.cu)}';
if(cu){
    $.ajax({
        url: "${rootUrl}operstat/tes/nodecucode.dox",
        dataType: "json",
        data: {
            code:'',
        	tesnodecode:$("#tesNodeCode${voStatus.count}").val()+''
        },
        success: function(data) {
        	if (data == null || data == [] || data == "") {
				return;
			}
        	for(var i=0;i<data.length;i++){
        	    if(data[i].cu!=cu){
		      		$('#cuSelectCode${voStatus.count}').append("<option value='"+data[i].cu+"'>"+data[i].cu+"</option>");
        	    }else if(data[i].cu==cu){
    		        $('#cuSelectCode${voStatus.count}').append("<option selected=true value='"+cu+"'>"+cu+"</option>");
        	    }
        	}
        	var cu = '${fn:escapeXml(vo.tesSlot.cu)}';
        	if(cu){
        		$("#cuSelectCode${voStatus.count} option[value ='"+ cu +"']").attr("selected",true);	
        	}
        }
    });
}
</script>
<tr>
	<td>${fn:escapeXml(vo.power)}</td>
	<td>${fn:escapeXml(vo.freq)}</td>
	<td>
		<input type="hidden" id="cu"/>
		<c:if test="${vo.valid==false}">
		<input type="text" value="${fn:escapeXml(vo.tesSlot.tesNode.tesNodeCode)}" name="tesNodeCode${voStatus.count}" id="tesNodeCode${voStatus.count}" class="text ui-widget-content" disabled/>
	-
		 <select id="cuSelectCode${voStatus.count}" name="cuSelectCode${voStatus.count}" style="width: 100px" disabled></select>
		</c:if>
		<c:if test="${vo.valid==true}">
		<input type="text" value="${fn:escapeXml(vo.tesSlot.tesNode.tesNodeCode)}" name="tesNodeCode${voStatus.count}" id="tesNodeCode${voStatus.count}" class="text ui-widget-content"/>
	-
		 <select id="cuSelectCode${voStatus.count}" name="cuSelectCode${voStatus.count}" style="width: 100px"></select>
		 </c:if>
	</td>
	<td>${fn:escapeXml(vo.valid?'有效':'失效')}</td>
	<td class="tdbtn">
			<c:if test="${vo.optUser.loginName!=null && vo.valid==true}">
				<a href="#" id="updateButton${voStatus.count}">修改</a>
			</c:if>
			<c:if test="${vo.optUser.loginName==null && vo.valid==true}">
				<a href="#" id="saveButton${voStatus.count}">保存</a>
			</c:if>
		<!-- 
		<a href="${rootUrl }operstat/tes/remove.do?id=${vo.id}"
			confirm_message="你确定要删除此信息？" class="my_remove">删除</a> -->
	</td>
</tr>
