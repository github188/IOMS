<%@ page contentType="text/html;charset=utf-8"%>
<div id="footer">
	<p style="line-height:25px">版权所有：北京天航信民航通信网络发展有限公司   技术支持：somebody</p>
	<br />
	<p style="line-height:18px;color:#ccc">推荐浏览器：火狐  IE8以上 推荐分辨率：1024*768</p>
</div>
<script type="text/javascript">
$(function(){
	var hh = $("#boxleft").height();
	hh = hh+"px";
	$("#boxmain").css("height",hh);
	$("#boxmain").css("min-height",hh);
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		error: function (XMLHttpRequest, textStatus, errorThrown){
				if(XMLHttpRequest.status==403){
					alert('您没有权限访问此资源或进行此操作');
					return false;
				}
				//alert("jquery ajax全局请求error方法执行了！");
		},  
		complete : function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus，   
			var sessionstatus = XMLHttpRequest
					.getResponseHeader("sessionstatus");
			//alert(sessionstatus);
			if (sessionstatus == "sessionTimeOut") {
				var top = getTopWinow(); //获取当前页面的顶层窗口对象
				alert('登录超时, 请重新登录.'); 
				//alert("${rootUrl}");
				top.location.href="${rootUrl}";
			}
		}
	});

	/** 
	  * 在页面中任何嵌套层次的窗口中获取顶层窗口 
	  * @return 当前页面的顶层窗口对象 
	  */
	function getTopWinow(){  
	    var p = window;  
	    while(p != p.parent){  
	        p = p.parent;  
	    }  
	    return p;  
	}  
});
</script>