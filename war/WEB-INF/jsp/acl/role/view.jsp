<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${rootUrl }admin/style/window.css"  />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tree.checkbox.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("#tree").tree({
		ui:{ 
			theme_name : "checkbox"
		}
	});
});
</script>
</head>
	<body>
<div class="window" style="min-height: 300px">
	<dl class="title">
		<dd>角色权限配置--查看</dd>
		<dt><a href="#" onclick="parent.$.nyroModalRemove();"><img src="${rootUrl }images/close.png" alt="关闭"/></a></dt>
	</dl>
	<h1>&lt;${role.name }&gt;的配置信息</h1>
	<div id="tree">
		<ul>
		<c:forEach items="${confMap}" var="entry" varStatus="entryStat"> 
			<li id="${entry.key}" rel="folder" class="closed" style="text-align:left"><a href="#">${entry.key.value}</a>
				<ul>
					<c:forEach items="${entry.value}" var="vo">
						<li id="${vo.id }" rel="file" style="text-align: left"><a href="#" 
							<c:if test="${vo.hasResource}">class="checked"</c:if>
						><ins>&nbsp;</ins>${fn:escapeXml(vo.name) }</a></li>			
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
		</ul>
		</div>
</div>	
	</body>
</html>

