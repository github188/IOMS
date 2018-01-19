<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
	<meta http-equiv="expires" content="0" />

	<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
	<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />
	<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
	<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
	<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
	<script src="${rootUrl }ueditor/ueditor.config.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/ueditor.all.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }ueditor/zh-cn.js" type="text/javascript" charset="utf-8" ></script>
	<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
	<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
	
	<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
<script>
$(function() {
	$.ajaxSetup({
		cache : false
	});


	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
	$("#goback").click(function() {
		parent.$.nyroModalRemove();
	});
	
    

});
</script>
<style>
		.bg{
			width:400px;
			height:480px;
			margin:0px auto;
			background-color:#ddd;
			position:relative;
			top:50px;
			
		}
		.bg .btn-primary{
			width:50px;
			height:50px;
			line-height:40px;
		}
		#btn_num1{
			position:absolute;
			top:80px;
			left:90px;
		}
		#btn_num2{
			position:absolute;
			top:80px;
			left:170px;
		}
		#btn_num3{
			position:absolute;
			top:80px;
			left:250px;
		}
		#btn_num4{
			position:absolute;
			top:160px;
			left:90px;
		}
		#btn_num5{
			position:absolute;
			top:160px;
			left:170px;
		}
		
		#btn_num6{
			position:absolute;
			top:160px;
			left:250px;
		}
		#btn_num7{
			position:absolute;
			top:240px;
			left:90px;
		}
		#btn_num8{
			position:absolute;
			top:240px;
			left:170px;
		}
		#btn_num9{
			position:absolute;
			top:240px;
			left:250px;
		}
		#btn_call{
			position:absolute;
			top:320px;
			left:250px;
		}
		#btn_num0{
			position:absolute;
			top:320px;
			left:90px;
		}
	</style>
</head>

<body style="overflow-x:hidden">
	
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			
		   <!--  
			<table style="width:710px;margin-left:10px" border="0"  >
				<tr>
					<th width="100px">请输入电话号码:</th>
					<td >
					   <input type="text"></input>
					</td>
				</tr>
				
				
				
				
				<tr align="center">
					<td colspan="2" align="center" valign="middle">
						<span class="btn" style="margin-left: 280px">
							<a href="${rootUrl }faultmng/createfault/popwindowother.do"
						class="my_add {boxwidth:750,boxheight:600 btn} id="submit">确定</a>
						</span>
						
						<span class="btn">
							<a href="#none" id="goback" class="goback">取消</a>
						</span>
					</td>
				</tr>
			</table>-->
			  <div class="bg">
			<div class="btn btn-primary" id="btn_num1">1</div>
			<div class="btn btn-primary" id="btn_num2">2</div>
			<div class="btn btn-primary" id="btn_num3">3</div>
			<div class="btn btn-primary" id="btn_num4">4</div>
			<div class="btn btn-primary" id="btn_num5">5</div>
			<div class="btn btn-primary" id="btn_num6">6</div>
			<div class="btn btn-primary" id="btn_num7">7</div>
			<div class="btn btn-primary" id="btn_num8">8</div>
			<div class="btn btn-primary" id="btn_num9">9</div>
			<div class="btn btn-primary" id="btn_num0">0</div>
				
				
			<div class="btn btn-success" id="btn_call" style="height:50px;width:50px;line-height:40px">
			<a href="${rootUrl }faultmng/createfault/popwindowother.do"
						class="my_add {boxwidth:750,boxheight:600}">拨打</a>
			</div>
		</div>
		
		  <div class="modal-footer" style="margin-top:90px;">
		<table width="100%">
		  <tr>
		     <td width="15%" class="text-right">
		                      <h4>联系人姓名：</h4>
		                      </td>
		     <td width="30%">
		         <input id="input_name" type="text" style="width:90%"/>
		     </td>
		     <td width="55%" align="right">
		      <button type="button" class="btn btn-success" style="height:30px">查询</button>
		     </td>
		  </tr>
		   <tr>
		     <td width="15%" class="text-right">
		         <h4>电话号：</h4></td>
		     <td width="30%">
		         <input id="input_num" type="text" style="width:90%"/>
		     </td>
		     <td width="55%" align="right">
		      <button type="button" class="btn btn-default" style="height:30px" >清空</button>
		     </td>
		  </tr>
		</table>
		
      </div>
		</div>

	
</body>
</html>
<script>
	$("#input_num").val("")
	$(".btn-primary").click(function(){
		$("#input_num").val($("#input_num").val()+$(this).text());
	})
	$(".btn-default").click(function(){
		$("#input_num").val("");
	})
</script>