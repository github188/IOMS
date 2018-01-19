<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>交接班记录</title>
<link
	href="${rootUrl }js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jquery/themes/default/style.css" />
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

<script src="${rootUrl }js/plugins/jui/jquery-ui-1.9.2.min.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/qtip/jquery.qtip.pack.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/plugins/html/jquery.outerhtml.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/activiti/workflow.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/mystyle.css" />


</head>
<body>

 <table id="dataTable" width="100%" border="0" cellspacing="0" class="table table-bordered"
		cellpadding="2">
		<thead>
			<tr>
				<th style="width:5%">序号</th>
				<th style="width:10%">值班人</th>
				<th style="width:10%">值班角色</th>
				<th style="width:10%">值班地点</th>
				<th style="width:50%">记录内容</th>
				<th style="width:15%">创建情况</th>
				
			</tr>
		</thead>
		<tbody>
		   <tr>
		       <td>1</td>
		       <td>值班员1</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXXXXXXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员1</p> 
		            <p>2016-04-01 12:23</p>
		       </td>
		   </tr>
		   <tr>
		       <td>2</td>
		       <td>值班员1</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员1</p> 
		            <p>2016-04-01 14:20</p>
		       </td>
		   </tr>
		   <tr>
		       <td>3</td>
		       <td>值班员2</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员2</p> 
		            <p>2016-04-01 15:04</p>
		       </td>
		   </tr>
		   <tr>
		       <td>4</td>
		       <td>值班员3</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXX,XXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员3</p> 
		            <p>2016-04-01 16:03</p>
		       </td>
		   </tr>
		   <tr>
		       <td>5</td>
		       <td>值班员1</td>
		       <td>值班工程师</td>
		       <td>通讯基地</td>
		       <td>交接班记录XX,XXXXXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员1</p> 
		            <p>2016-04-01 16:16</p>
		       </td>
		   </tr>
		   <tr>
		       <td>6</td>
		       <td>值班员4</td>
		       <td>值班工程师</td>
		       <td>十里河</td>
		       <td>交接班记录XX，XXXXXXXXXXXXXXX</td>
		       <td>
		            <p>值班员4</p> 
		            <p>2016-04-01 18:44</p>
		       </td>
		   </tr>
		   <tr>
		       <td>7</td>
		       <td>值班员5</td>
		       <td>值班经理</td>
		       <td>通讯基地</td>
		       <td>交接班记录XXXXXX。XXXXXXXXXX</td>
		       <td>
		            <p>值班员5</p> 
		            <p>2016-04-02 07:01</p>
		       </td>
		   </tr>
		</tbody>
		</table>
</body>
</html>