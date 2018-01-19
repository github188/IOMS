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
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
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
		 jQuery.validator.addMethod("tesNodeCode", function(value, element) { var
				exp = /^[0-9A-Z]{4}$/; return this.optional(element) ||
				 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
					+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入4位数字0-9及大写英文字母");// 请输入4位数字0-9,大写英文
		
		 jQuery.validator.addMethod(
					"tesMemo",
					function(value, element) {					
						var exp = /^[0-9a-z_A-Z-`=\/\[\];',.\~!@#$%^&*()_+|{}:"<>?？。\u4e00-\u9fa5\uFE30-\uFFA0\s(\（|\）|\！|\，|\《|\》|\{|\}|\【|\】|\“|\”|\·|\、|\：|\；|\‘|\’|\……|\_|\-|\#|\@|\%|\^|\&|\*|\,|\.|\/|\\|\;|\'|\"|\:|\;|\[|\])+]+$/;
		
						return this.optional(element) || (exp.test(value));
					},
					"&nbsp;<img src='"
							+ baseUrl
							+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字,中文,英文,标点符号,空白符");

		 jQuery.validator.addMethod("cu", function(value, element) { var
				exp = /^([1-9]|1[0-4]|14)$/; return this.optional(element) ||
				 (exp.test(value)); }, "&nbsp;<img src='" + baseUrl
					+ "/images/validator/check_n.gif' width=16 height=16>&nbsp;请输入数字1-14,");
				 
		 
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				tesNodeCode : {
					tesNodeCode:true,
					required : true,
					/* digits : true,
					min : 0,
					max : 999, */	
					maxlength : 4,
					remote:'${rootUrl}basedata/checkTesNode.dox'
					
				},			
				siteCode : {
					required : true
				},
				
				info : {
					tesMemo : true,
					maxlength : 50
				},
				
				slotCU: {
					cu : true			
				},
				slotOCC: {
					digits : true,
					min : 1,
					max : 99
				},
				slotInfo : {
					tesMemo : true,
					maxlength : 50
				},				
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});

		$("#submit").click(function() {
			if ($("#siteId").val() == null
					|| $("#siteId").val() == "") {
				$("#siteCode").val("");
			}			
			
			//1.判断slotCU是否符合规则
			//2.判断slotCU是否有重复值
			var re = new RegExp("^([1-9]|1[0-4]|14)$");			
			var els = document.getElementsByName("slotCU");			
			for(var i=0;i<els.length;i++)					
			{
				if(!re.test(els[i].value))
				{ 
					alert("槽位号："+els[i].value+"不符合规则,请输入数字1-14");
					return;				
				}	
			for (var  j=i+1;j<els.length;j++)
			{
				if(els[i].value==els[j].value)
				{	
				alert("槽位号值重复:"+els[i].value);
				return;
				}		
			}							
			}	
			
			$("#addForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

		//卫星站自动填充
			$("#siteCode").autocomplete({
					minLength: 1, 
	                autoFocus: true, 
	                delay: 500 ,
	                source: function(request, response) {
	                    $.ajax({
	                        url: "${rootUrl}basedata/sitecode.dox",
	                        dataType: "json",
	                        data: {
	                        	term : request.term
	                        },
	                        success: function(data) {
	                        	if (data == null || data == [] || data == "") {
	                        		$("#sitecode").val("");
	    							$("#siteId").val("");
	    							return;
	    						}
	                            response($.map(data, function(item) {
	                                return { 
	                                	value : item.siteCode,
	    								name : item.id,
	    								
	                                }
	                            }));
	                        }
	                    });
	                },
	               change: function(event, ui) { 
	    				if (!ui.item) { 
	    					$("#sitecode").val("");
							$("#siteId").val("");
	    				} 
	              }, 
	　　　　　　　　　 select: function(event, ui) {
		 				//主动为出发城市及代码赋值
						$("#sitecode").val(ui.item.value);
						$("#siteId").val(ui.item.name);
						
	                }
	                
	            });
		
	});
	
	$(document).ready(function() {
		$('#addtr').click(function(){
		if (parseInt($(".tesSlot_form tbody tr").length) >= 1) $('#rmtr').show();
		$(".tesSlot_form tbody").
		append('<tr><td><input type="text" name="slotCU"/></td><td><input type="text" name="slotOCC"/></td><td><textarea name="slotInfo"/></td><td  onclick="deleteTr(this);"><a href="#" >删除</a></td></tr>');

		});
		/* $('#rmtr').click(function(){
		$(".tesSlot_form tbody tr:last").detach();
		}); */
	});
	//初始化记录slotCU所有值 
	 var kv={};
	 $(function () {
	     $('input[name="slotCU"]').each(function () {
	         if(kv[this.value])kv[this.value]++;
	        else kv[this.value]=1;
	     });  
	 }); 
	 
	 		
	$("input[name='slotCU']").live("change", function(event){
		if(event.which!=16) {	//16=shift		
		 if(kv[this.value])kv[this.value]--; }
	}); 	
	
	 //slotCU数据重复判断事件
	 $("input[name='slotCU']").live("change",function(event){ 
		  $(this).css("background","#fff");	  
		 if(event.which!=16) {	//16=shift
		 	 // 判断与其他 值是否重复					
			 if(kv[this.value])kv[this.value]++;
	          else kv[this.value]=1;
			 for(var k in kv)if(kv[k]>1) 
			 { 
			 kv[k]=1;		 
			 $(this).css("background","red");
			 $(this).val(k+'重复！');
			 }	 
		}});
	 
	 function deleteTr(currentTr)
	 {	
	 	var index= $(currentTr).parent().index();	 	
	    $(".tesSlot_form tbody tr:eq("+index+")").remove();	 
	 }
</script>

</head>
<body>
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }basedata/tes/node/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>数据管理--TES节点--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>TES节点信息</h1>
			<table style="margin: auto">
				<tr>
					<th width="20%"><font color="red">(*)</font>机箱号:</th>
					<td><form:input path="tesNodeCode" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>卫星站:</th>
					<td><form:input path="siteCode" />
						<input type="hidden" id="siteId" name="siteId" /></td>
				</tr>


				<tr>
					<th width="20%">备注:</th>
					<td><form:textarea path="info" cssStyle="width:135px" /></td>
				</tr>
			</table>
			<div class="mtab">
				<h1>TES槽位信息</h1>
				<table class="tesSlot_form" style="margin: auto">
					<thead>
						<tr>
							<th width="10%" >槽位号</th>
							<th width="10%" >OCC</th>
							<th width="70%">备注</th>
							<th width="10%" >操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tesSlot" items="${pageModel.tesSlotList}">
							<tr align="left">
								<td ><input type="text" name="slotCU" 
									value="${tesSlot.cu}"/></td>
								<td ><input type="text" name="slotOCC" 
									value="${tesSlot.occ}" /></td>
								<td ><input type="text" name="slotInfo" 
									value="${tesSlot.info}" /></td>
								<td  onclick="deleteTr(this);"><a href="#">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td align="left">
							<a href="#" id="addtr">添加</a>
							
								<!-- <button id="addtr" type="button">增加</button> 	 -->						
							</td>
						</tr>
					</tfoot>
				</table>

				<!-- <table style="width:100%;border:solid 1px #78b0dc;" class="dynamicCon">  
                               <tr>  
                                   <td colspan="3" align="left" style="color:#f00;">  
                                       注：字段名只能为汉字或数字或字母或下划线组成的字符串；权重只能为非负数！ 字段名为空时，将不进行添加！权重为空时默认为0。简易版无需填写权重信息！！  
                                   </td>  
                               </tr>  
                               <tr>  
                                   <td align="center" width="40%">字段名</td>  
                                   <td align="center" width="40%" class="trNoSimple">权重（单个积分）</td>  
                                   <td align="center" width="20%">操作</td>  
                               </tr>  
                                       <tr class="items">  
                                           <td align="center">  
                                               <input type="text" name="txtFieldName" value="222"/>  
                                               <input type="hidden" name="txtFieldId" value="333"/>  
                                           </td>  
                                           <td class="trNoSimple">  
                                               <input type="text" name="txtFieldPoint" value="777"/>  
                                           </td>  
                                           <td align="center"><a href="javascript:void(0);" class="addBtn">添加</a>  
                                             <a href="javascript:void(0);" class="delBtn">删除</a></td>  
                                       </tr>  
                               <tr class="temp">  
                                   <td align="center"><input type="text" name="txtFieldName"/></td>  
                                   <td class="trNoSimple"><input type="text" name="txtFieldPoint" value="0"/></td>  
                                   <td align="center"><a href="javascript:void(0);" class="addBtn">添加</a> 
                                      <a href="javascript:void(0);" class="delBtn">删除</a></td>  
                               </tr>  
                           </table>  
				 -->

			</div>
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>