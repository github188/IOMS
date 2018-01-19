<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
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
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>通信基地雷达广播TES链路工作状态</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%" border="0">
				<tr>
					<th scope="col" rowspan="16">检查内容</th>
					<th scope="col" rowspan="4">100C</th>
					<th>1</th>
					<th scope="col">上海雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateSHA ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateSHA.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateSHA.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>2</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>3</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>4</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th scope="col" rowspan="4">100D</th>
					<th>1</th>
					<th scope="col">首都机场雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStatePEK ne 'NORMAL'}">
								<font color="red"> ${vo.linkStatePEK.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStatePEK.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>2</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>3</th>
					<th scope="col">沈阳雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateSHE ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateSHE.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateSHE.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>4</th>
					<th scope="col">西安雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateSIA ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateSIA.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateSIA.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>

				<tr>
					<th scope="col" rowspan="4">100E</th>
					<th>1</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>2</th>
					<th scope="col">广州雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateCAN ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateCAN.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateCAN.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>3</th>
					<th scope="col">乌鲁木齐雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateURC ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateURC.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateURC.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>4</th>
					<th scope="col">海口雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateHAK ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateHAK.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateHAK.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>

				<tr>
					<th scope="col" rowspan="4">1010</th>
					<th>1</th>
					<th scope="col">成都雷达引接</th>
					<th scope="col"><c:choose>
							<c:when test="${vo.linkStateCTU ne 'NORMAL'}">
								<font color="red"> ${vo.linkStateCTU.value }</font>
							</c:when>
							<c:otherwise>
				    	 ${vo.linkStateCTU.value }
				    	</c:otherwise>
						</c:choose></th>
				</tr>
				<tr>
					<th>2</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>3</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>4</th>
					<th></th>
					<th></th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>