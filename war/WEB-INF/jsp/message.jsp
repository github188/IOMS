<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="nl" lang="nl">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<head>
<link rel="stylesheet" href="${rootUrl}css/msg.css" type="text/css" />
<script language="javascript">
	function call(string) {
		parent.location.href = string;
	}
</script>
</head>
<body id="msgBody">
	未处理消息提示：
	<c:if test="${res==null}">
	没有未处理消息
	</c:if>
	<c:if test="${res!=null}">
		<c:forEach items="${res}" var="msgModel" varStatus="index">
			<table>
				<tr>
					<td><div>
							<table style="width: 270px;" cellspacing="0" id="msgTable">
								<tr>
									<td class="menuName">${msgModel.name}:</td>
								</tr>
								<c:forEach items="${msgModel.resources}" var="resource"
									varStatus="i">
									<tr>
										<td><a class="columnName" href="#"
											onclick="call('${rootUrl}${resource.url}')">
												${resource.name}</a> 模块有<a style="font-weight: bold; cursor: pointer; color:blue;"
											onclick="call('${rootUrl}${resource.url}')">${resource.unsettledMsgNum}</a>条未处理信息.</td>
									</tr>
								</c:forEach>
							</table>
						</div></td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>