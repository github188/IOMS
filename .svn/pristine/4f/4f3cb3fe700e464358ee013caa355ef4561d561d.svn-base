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
	<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body style="overflow-x:hidden">
	<form:form modelAttribute="pageModel" id="approveNews" name="approveNews" action="#" method="post">
		<form:hidden path="id" />
		<form:hidden path="processInstanceId" /> 
		<div class="window" style="overflow-y:hidden;overflow-x:hidden;margin-left:1px">
			<dl class="title">
				<dd>通知公告:审批阶段</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<br />
			<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
			<div class="mtab">
				<table width="100%">
					<tr>
						<th colspan="6"
							style="color: gray; width: 100%; text-align: center;">通知公告信息</th>
					</tr>
					<tr>
						<th width="13%">栏目:</th>
						<td width="20%">${fn:escapeXml(pageModel.columns.value)}</td>
						<th width="13%">标题:</th>
						<td width="20%">${fn:escapeXml(pageModel.title)}</td>
						<th width="13%">提交人:</th>
						<td width="21%">${pageModel.createUser.name}-${pageModel.createUser.loginName}</td>
					</tr>
					<tr>
						<th width="13%">创建时间:</th>
						<td width="20%"><fmt:formatDate value="${pageModel.createTime}" type="date"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th width="13%">提交时间:</th>
						<td width="20%"><fmt:formatDate value="${pageModel.publishTime}" type="date"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<th width="13%"></th>
						<td width="21%"></td>
					</tr>
					<tr style="height: 345px">
						<th width="13%" valign="top">通知内容:</th>
						<td width="87%" colspan="5" align="left">
							<div style="width: 580px;height:345px;overflow: auto;">${pageModel.content}</div>
						</td>
					</tr>
					<tr>
						<th><font color="red">*</font>是否通过：</th>
						<td colspan="5"><input type=radio name="pass" 
							value="true" checked="checked">是</input>&nbsp;&nbsp;
							&nbsp;&nbsp;<input type=radio name="pass" 
							value="false" >否 </input></td>
					</tr>
					<tr>
						<th><font color="red">*</font>备注信息：</th>
						<td colspan="5"><textarea style="width:100%;height:30px" name="remark" id='remark'>通过！</textarea></td>
					</tr>
					<tr style="height: 60px" align="center">
						<th colspan="6" align="center" valign="middle">
							<span class="btn" style="margin-left: 280px">
								<a href="#none" id="submit">提交</a>
							</span>
							<span class="btn">
								<a href="#none" class="reset" onclick="approveNews.reset();">重置</a>
							</span>
						</th>
					</tr>
				</table>
			</div>
		</div>
	</form:form>
	<script type="text/javascript">
	    //实例化编辑器
	    /*var content = '${pageModel.content}';
        var ue = UE.getEditor('editor',{
			readonly:true
        });
         ue.addListener('ready',function(){
            ue.setContent(content);
        }) */
        $(function() {
            $.ajaxSetup({
                cache : false
            });
            $("#approveNews").validate({
    			rules : {
    			    pass:{
    					required : true
    			    },
    			    remark:{
    					required : true,
    					maxlength : 100
    			    }
    			},
    			submitHandler : function(form) {
    				parent.popupRemoveSubmit(form);
    			}
    		});
    		$(".close").click(function() {
    			parent.$.nyroModalRemove();
    		});
        	$("#submit").click(function() {
                //$("#content").attr("value", UE.getEditor('editor').getContent());//填充内容
               	$("#approveNews").attr("action", "${rootUrl }news/approve/approve.do");
                $("#approveNews").trigger("submit");
            });
        	

            $('input:radio[name="pass"]').click(function(){
                var check = $('input:radio[name="pass"]:checked').val();
                if(check==null){
                    
                }else if(check=='true'){
                    $('#remark').text("通过！");
                }else{
                    $('#remark').text("");
                }
            });
        });
    </script>
	
</body>
</html>