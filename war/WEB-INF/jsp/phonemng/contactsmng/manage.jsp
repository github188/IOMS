<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>联系人管理</title>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link href="${rootUrl }js/plugins/qtip/jquery.qtip.min.css"
	type="text/css" rel="stylesheet" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>

<!-- hty -->
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/bootstrap.css" />
<script type="text/javascript">
	$(function() {
		$("#boxleft").attr("style","display:none");
		$("#queryResult").manage({
			pagerUrl : true,
			add : true,
			edit : true,
			update : true,
			view : true,
			remove : true,
			boxwidth : "600",
			boxheight : "600",
			sortable : true,//是否使用页面排序功能
			sortConfig : { //页面排序的配置
				0 : {
					sorter : "text"
				}
			}
		});

		
		
		
		$("#btn_select").click(function() {
				
				$("input[name=activeCheck]").each(function() {
					$(this).attr("checked", true);
				});
		});
			$("#btn_selected").click(function() {
				$("input[name=activeCheck]").each(function() {
					if ($(this).attr("checked")) {
						$(this).attr("checked", false);
					} else {
						$(this).attr("checked", true);
					}

				});
			});
			
			
	});
	
  
	
	var progressActiveSelectIds = new Array();
	var contactIds = new Array();
	function checkActiveSelect(checkbox) {
		if ($(checkbox).attr("checked") == "checked") {
			
			progressActiveSelectIds.push($(checkbox).attr("value"));
			return;
		}
		for (var i = 0; i < progressActiveSelectIds.length; i++) {
			if (progressActiveSelectIds[i] == $(checkbox).attr("value")) {
				progressActiveSelectIds.splice(i, 1);
				return;
			}
		}

	}
	var rootUrl = '${rootUrl }';
	
function doMerge() {
		$.ajax({
			type : "POST",
			url : "${rootUrl }phonemng/contactsmng/black.do?idlist="
					+ progressActiveSelectIds,
			dataType : "json",
			success : function(data, status, xhr) {
				
				
				contactIds=data;
				for(var j=0;j<contactIds.length+1;j++){
					alert("black");
					var obj = jQuery.parseJSON('{"Account":"N00000005689","PBX":"bj.ali.3.7","BlackNum":"'+contactIds[j]+'","Type":"1"}');
					var url1="http://112.124.23.131:3000/service?action=saveBlackList&json="+obj+"";
					
					$.ajax({
						type:"GET",
						url:url1,
						success : function(data, status, xhr) {
							
						},
						error: function (xmlHttpRequest, error){
							//alert(error);
						}
					});
					//$.get(url,function(data,status){  
				      //alert(status+"1");
				    //}); 
					//alert();
				}
				
				//alert("1");
				//$("action").attr("${rootUrl}phonemng/contactsmng/manage.do");
				for (var i = 0; i < progressActiveSelectIds.length + 1; i++) {
					progressActiveSelectIds.splice(i,1);
				}
				progressActiveSelectIds=null;
				progressActiveSelectIds= new Array();
				$("#listForm").submit();
				
			
				
			}
			
		});
	}
	

	
</script>


</head>
<body>


	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>

	<%@ include file="/WEB-INF/jsp/left.jsp"%>
	<!-- LOGO -->
		
			<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading text-left">
							<div class="navbar-form">
								<img src="${rootUrl }images/img/linkman_icon.png"></img> 联系人管理
							</div>
						</div>

						<div class="panel-body">
    <div class="minfo">
					<div class="bl">
						<div class="br">
							<div class="clear"></div>
							<div id="lmsx">
	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		action="${rootUrl}phonemng/contactsmng/manage.do" method="post">




       
							
							<div class="boxbtn" >
							  <div class="info">
							          所属区域： 
								<form:input path="contactPlace" size="10" maxlength="30"
								onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
								 />
								联系人姓名： 
								<form:input path="contactName" size="10" maxlength="30"
								onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
												oncontextmenu="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\_]/g,'')"
								 />
								
								联系人状态：
							    <form:select path="contactStatus" id="contactStatus" cssStyle="width:120px" >
									<form:option value=""></form:option>
									<form:options items="${statusList}" itemLabel="value" />
								</form:select>
							  </div>
							  <a href="#none" class="btn-flat primary" id="queryButton">查询</a> 
							 <a href="#none" class="btn-flat white" onclick="listForm.reset();">重置</a>
							 </div>
							<br />

                            
							<div class="form-group text-left">
								<a style="font-color: #ffffff"
									href="${rootUrl }phonemng/contactsmng/add.do"
									class="my_add {boxwidth:750,boxheight:340} btn">添加</a>

								<div class="btn-group">
									<!-- <button type="button" class="btn btn-flat primary"
										style="height: 30px" id="btn_select">全选</button>
									<button type="button" class="btn btn-flat white"
										style="height: 30px" id="btn_selected">反选</button> -->
									<a href="#" class="btn btn-flat primary" id="btn_select"
												style="width: 60px;">全选</a>
									<a href="#" class="btn btn-flat white" id="btn_selected"
												style="width: 60px;">反选</a>
									
									<a href="#" class="btn btn-flat danger" onclick="doMerge()"
												style="width: 60px;">拉黑</a>
								</div>

							</div>
							<div class="mtab">
					            <table width="100%" border="0" cellspacing="0"
									cellpadding="0" class="title">
									<tr>
										<td class="td1"><img src="${rootUrl}images/pl1.gif"
											alt="" /></td>
										<td class="td2" id="noteInfo"></td>
									</tr>
								</table>
								
							</div>
							<div id="queryResult"></div>
						<!--  </div>
					</div>
				</div>

			</div>
			
            

		</div>-->
		<!-- /.container-fluid -->
	</form:form>
     </div>
     </div>
     </div>
     </div>
   
    </div>
    </div>
    </div>
    </div>
    </div>
		
	

  
     
	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>

	<!-- 版权页 -->
</body>
</html>