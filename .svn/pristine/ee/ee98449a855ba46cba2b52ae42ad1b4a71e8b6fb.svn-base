<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>呼叫中心</title>
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


<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<!-- 工作流相关 -->
<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/faultMngWorkflow.js"
	type="text/javascript"></script>
<!-- hty -->
<link rel="stylesheet" type="text/css"
	href="${rootUrl }css/missedcall/style.css" />
<script type="text/javascript" src="${rootUrl }js/missedcall/move.js"></script>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/bootstrap.css" />

<script type="text/javascript">

    
	$(function() {
		
		//alert(getCookie("type"));
		var typeStr=document.cookie.split(";")[0].split("=")[1];
		if(typeStr!="1"){
			//alert("进入页面不弹窗"+typeStr);
		}
		else{
			//alert("弹窗"+typeStr);
		}

		//document.getElementById('phoneIframe').contentWindow.location.reload(false);
		//呼叫中心控制左侧菜单栏隐藏
		$("#boxleft").attr("style", "display:none");

		$("#date1").hide();
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

		var judgestr=$("#callNo").val();
		
		if(judgestr!=""){
			 
				//document.getElementById('phoneIframe').contentWindow.location.reload(false);
				 if(confirm(judgestr+"来电，确认生成故障单？")){
			
					 $("#pickOpen").trigger("click");
		             $("#pickOpen").click();
		             
		             
		             
				 }
			 

		}
		else{
			//alert('123');
			//document.getElementById('phoneIframe').contentWindow.location.reload(true);
		}
		
	});
	
	function judgeInfo() {
		var agent = $("#inputAgent").val();
		if($("#judge_div").val()=="0"){
			$("#miaov_float_layer").hide();
			 
		}
		if (agent == null || agent == "") {
			/**************/
			//alert("请先登录呼叫中心!");
			//location.href="${rootUrl}turndutymng/change/manage.do";
			/**************/
		}
		else{
              
		}

	}
	
	function getCookie(name)
	{
		var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		if(arr=document.cookie.match(reg))
		return unescape(arr[2]);
		else
		return null;
	}
	function setCookie(name,value)
	{
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	}
	function delCookie(name)
	{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!=null)
	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
	}
</script>

<style type="text/css">
#winpop {
	width: 200px;
	height: 0px;
	position: absolute;
	right: 0;
	bottom: 0;
	border: 1px solid #999999;
	margin: 0;
	padding: 1px;
	overflow: hidden;
	display: none;
	background: #FFFFFF
}

#winpop .title {
	width: 100%;
	height: 30px;
	line-height: 30px;
	background: #337ab7;
	font-weight: bold;
	text-align: center;
	font-size: 12px;
	color: #fff
}

#winpop .con {
	width: 100%;
	height: 80px;
	line-height: 80px;
	font-weight: bold;
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
	text-align: center
}

#silu {
	font-size: 13px;
	color: #999999;
	position: absolute;
	right: 0;
	text-align: right;
	text-decoration: underline;
	line-height: 22px;
}

.close {
	position: absolute;
	right: 4px;
	top: -1px;
	color: #FFFFFF;
	cursor: pointer
}

/*CSS源代码*/
button{
  display:inline-block;
  padding:6px 12px;
  margin-bottom:0;
  line-height:1.4;
  text-align:center;
  cursor:pointer;
  border-radius:4px;
  border:1px solid transparent;
  color:#fff;
  background:#1aba9c;
}
#modal-overlay {
  display:none; 
  position: fixed;   /* 使用绝对定位或固定定位  */
  left: 0px;    
  top: 0px;
  width:100%;
  height:100%;
  text-align:center;
  z-index: 1000;
  background-color: #333; 
  /*opacity: 0.8;    背景半透明 */
}
#fromdiv{
  display:none; 
  position: fixed;   /* 使用绝对定位或固定定位  */
  left: 0px;    
  top: 0px;
  width:100%;
  height:100%;
  text-align:center;
  z-index: 1000;
  background-color: #333; 
  /*opacity: 0.8;    背景半透明 */
}
/* 模态框样式 */
.modal-data{
  position: relative;
  width:800px;
  height:700px;
  margin: 100px auto;
  background-color: #fff;
  border:1px solid #000;
  padding:15px;
  text-align:center;
  border-radius:4px;
}
#x{
   position: absolute;
   top: 0px;
   right:0px;
}


</style>

</head>
<body onload="judgeInfo()">



	<!-- LOGO -->
	<%@ include file="/WEB-INF/jsp/top.jsp"%>
	<%@ include file="/WEB-INF/jsp/left.jsp"%>
	<!-- LOGO -->


	<form:form modelAttribute="queryModel" id="listForm" name="listForm"
		action="${rootUrl}phonemng/callcenter/manage.do" method="post">
        
        <input id="beginTime" value="${beginTime }" style="display:none"></input>
        <input id="endTime" value="${endTime }" style="display:none"></input>
        <input id="ringTime" value="${ringTime }" style="display:none"></input>
        <input id="callType" value="${callType }" style="display:none"></input>
        <input id="callsheetId" value="${callsheetId }" style="display:none"></input>
        
        <input id="agent" value="${agent }" style="display:none"></input>
        <input id="callNo" value="${callNo }" style="display:none"></input>
        <input id="calledNo" value="${calledNo }" style="display:none"></input>
        <input id="callerCity" value="${callerCity }" style="display:none"></input>
        <input id="callerProvince" value="${callerProvince }" style="display:none"></input>
        
        <button style="display:none"
			id="pickOpen" onclick="overlay()"> 123213
		</button>
        
		<div class="container-fluid">
		<input type="text" style="display:none" value="${loginname }" id="inputAgent" name="inputAgent"></input>
			<iframe id="phoneIframe"
				src="${rootUrl}js/edbbar/phoneBar/phonebar.html?loginName=${loginname }&password=${pwd }&loginType=${logintype }&agent=${agent}"
				height="280px" style="width: 100%" frameborder="0"></iframe>
			
			<!-- /.row -->
			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-heading text-left">
							待处理列表
						</div>
						<div class="panel-body">

							<div id="queryResult"></div>
						</div>
						<div class="panel-footer text-left">
							<p>
								关于来源： <img src="${rootUrl }images/img/phone_icon.png"></img>摘机添加 
								<img src="${rootUrl }images/img/Edit_icon.png"></img>手动添加 <img
									src="${rootUrl }images/img/Alarm_icon.png"></img>阈值告警
							</p>
							<p>
								关于级别： <span class="label label-danger">A级</span>：严重； <span
									class="label label-warning">B级</span>：警告； <span
									class="label label-info">C级</span>：一般；
							</p>
						</div>
					</div>


				</div>
				<!-- /.col-md-8 -->

				<div class="col-md-4">
				    <iframe src="${rootUrl }phonemng/callcenter/viewagent.do" width="100%" height="500px;" frameborder="0">
				    
				    </iframe>
				</div>
			</div>
			<!-- /.col-md-4 -->

		</div>
		<!-- /.row -->
		</div>
		<!-- /.container-fluid -->

	</form:form>

	<!-- 版权页 -->
	<%@ include file="/WEB-INF/jsp/bottom.jsp"%>

	<!-- 版权页 -->

	<!-- Modal 
<script src="${rootUrl }js/edbbar/js/myjs/jquery11.3.js" type="text/javascript"></script>
<script src="${rootUrl }js/edbbar/js/myjs/bootstrap.js" type="text/javascript"></script>
<div id="formDiv">
</div>-->
	<!--  
		<c:if test="${flag !=''}">
		    <script type="text/javascript">
		
			  $.ajax({
					url : '${rootUrl }phonemng/callcenter/faultmng/add.do?callNo=0&calledNo=0&callType=0&ringTime=0&agent=0&callsheetId=0&callerplace=&type=calling&callType=',
					type : 'GET',
					dataType : 'html',
					success : function(result) {
						//$("#formDiv").html(result);
					},
			        error: function(XMLHttpRequest, textStatus, errorThrown) {
			            alert(XMLHttpRequest.status);
			            alert(XMLHttpRequest.readyState);
			            alert(textStatus);
			            
			        }
				});
			</script>
		</c:if>
 -->
<input  style="display:none" id="judge_div" value="${missCount}"></input>
<div class="float_layer" id="miaov_float_layer" style="z-index:10001;">
	<div class="float_layer_bg">
		<b style="color:#fff">您有${missCount}条未接来电需要处理</b>
		<a id="btn_min" href="javascript:;" class="min"></a>
		<a id="btn_close" href="javascript:;" class="close"></a>
	</div>
	<div class="content2">
		<div class="wrap2">
			<ul>
				<c:forEach items="${missList}" var="vo">
				  <li>
				    <fmt:formatDate value="${vo.ringingTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />&nbsp;
				     ${vo.callonNumber}
				  </li>
				</c:forEach>
				
				  
				   
				
				
			</ul>
			 <table width="100%" align="right">
				     <tr>
				      <td class="text-left">
				      <a href="${rootUrl }phonemng/missedcallmng/manage.do" class="btn">查看更多</a>
				      </td>
				     </tr>
		    </table>
			
			
			
		</div>
	</div>
</div>

<div id="fromdiv">
 
</div>

<script type="text/javascript" src="${rootUrl }js/missedcall/cookie.js"></script>

<script type="text/javascript">
$(function (){
     
	if($("#judge_div").val()=="0"){
		$("#miaov_float_layer").hide();
	}
	else{
		if($.cookie("isClose") != 'yes')
	     {
	      TanChuang();
	      setTimeout("minTanChuang()",5000); //测试5秒自动关闭
	     }
	}
	
});   

function minTanChuang()
{
  $("#btn_min").click();
}

function TanChuang() {
    var oDiv = document.getElementById('miaov_float_layer');
    var oBtnMin = document.getElementById('btn_min');
    var oBtnClose = document.getElementById('btn_close');
    var oDivContent = oDiv.getElementsByTagName('div')[1];

    var iMaxHeight = 0;

    var isIE6 = window.navigator.userAgent.match(/MSIE 6/ig) && !window.navigator.userAgent.match(/MSIE 7|8/ig);

    oDiv.style.display = 'block';
    iMaxHeight = oDivContent.offsetHeight;

    if (isIE6) {
        oDiv.style.position = 'absolute';
        repositionAbsolute();
        miaovAddEvent(window, 'scroll', repositionAbsolute);
        miaovAddEvent(window, 'resize', repositionAbsolute);
    }
    else {
        oDiv.style.position = 'fixed';
        repositionFixed();
        miaovAddEvent(window, 'resize', repositionFixed);
    }

    oBtnMin.timer = null;
    oBtnMin.isMax = true;
    oBtnMin.onclick = function() {
        startMove
    (
      oDivContent, (this.isMax = !this.isMax) ? iMaxHeight : 0,
      function() {
          oBtnMin.className = oBtnMin.className == 'min' ? 'max' : 'min';
      }
    );
    };

    oBtnClose.onclick = function() {
        oDiv.style.display = 'none';
        oDiv.innerHTML = "";
    
    };
  
};
function overlay(){
	
    var e1 = document.getElementById('fromdiv');           
    //e1.style.display =  (e1.style.display == "block"  ) ? "none" : "block";
    var callNo=$("#callNo").val();
    var calledNo=$("#calledNo").val();
    var callType=$("#callType").val();
    var ringTime=$("#ringTime").val();
    var agent=$("#agent").val();
    var callsheetId=$("#callsheetId").val();
    var callsheetId=$("#callsheetId").val();
    var callerplace="";
    
    callerplace=$("#callerProvince").val()+$("#callerCity").val();
   

    if(e1.style.display=="none"){
    	 $.ajax({
    	    	url:'${rootUrl }phonemng/callcenter/faultmng/add.do?callNo='+callNo+'&calledNo='+calledNo+'&callType='+callType+'&ringTime='+ringTime+'&agent='+agent+'&callsheetId='+callsheetId+'&callerplace='+callerplace+'&type=&callType=',
    	    	type:'GET',
    	    	dataType:'html',
    	    	success:function(result){
    	    		$("#fromdiv").html(result);
    	    	}
    	   });
    	 e1.style.display="block";
    	 
    	
    }
    else{
    	 e1.style.display="none";
    }
   
}
function show(){
    var e1 = document.getElementById("ss"),
        e2 = document.getElementById('modal-data');
    e1.style.display ="block";
    e2.style.display ="none";
}
</script>

</body>
</html>


