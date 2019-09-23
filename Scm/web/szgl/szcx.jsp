<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'szcx.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/util.js"></script>
		<script type="text/javascript" src="dwr/interface/SzcxDao.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/szgl_szcx.js"></script>
	<script type="text/javascript" src="<%=basePath%>script/common.js"></script>
	</head>

	<body>
		收支查询
		<form action="#" id="rearchForm">
			<pre>	
开始日期：<input type="text" name="startTime"><a href="javascript:void(0)" onclick="gfPop.fPopCalendar(document.all.startTime);return false;"><img name="popcal" align="absmiddle" src="<%=basePath%>images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
截止日期：<input type="text" name="endTime"><a href="javascript:void(0)" onclick="gfPop.fPopCalendar(document.all.endTime);return false;"><img name="popcal" align="absmiddle" src="<%=basePath%>images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
收支类型：<input type="radio" name="inputType" value="in" checked="true">收入<input
					type="radio" name="inputType" value="out">支出
单据付款方式：<select id="payType" name="payType">
<option>--请选择付款方式--</option>
<option value="货到付款">货到付款</option>
<option value="款到发货">款到发货</option>
<option value="预付款到发货">	预付款到发货	</option>
</select>
相关单据号：<input type="text" name="id">	
<input type="button" value="查询" onClick="search()">
</pre>
		</form>
		
		<div id="showDiv" style="display:none">
		<table>
			<tr>
				<th>
					收/付款日期
				</th>
				<th>
					单据号
				</th>
				<th>
					收/付金额
				</th>
				<th>
					经手人
				</th>
				<th>
					单据付款方式
				</th>
			</tr>
			<tbody id="showResultTbody"></tbody>
		</table>
		</div>
		<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="<%=basePath%>common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
 
	</body>
</html>
