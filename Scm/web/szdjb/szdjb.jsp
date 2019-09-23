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
		<title>My JSP 'szdjb.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/util.js"></script>
		<script type="text/javascript" src="dwr/interface/SomainDao.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/szdjb.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/common.js"></script>
	</head>
	<body>
		<H1> 
		收支登记报表 
		</H1>
		要查询的月份:从
		<input type="text" name="starttime">
		<a href="javascript:void(0)"
			onclick="gfPop.fPopCalendar(document.all.starttime);return false;"><img
				name="popcal" align="absmiddle"
				src="<%=basePath%>images/selectDate.gif" width="15" height="12"
				border="0" alt=""></a>到
		<input type="text" name="endtime">
		<a href="javascript:void(0)"
			onclick="gfPop.fPopCalendar(document.all.endtime);return false;"><img
				name="popcal" align="absmiddle"
				src="<%=basePath%>images/selectDate.gif" width="15" height="12"
				border="0" alt=""></a>
		<input type="radio" name="type" value="in" checked>
		收入报表
		<input type="radio" name="type" value="out">
		支出报表
		<input type="button" name="searchButton" value="查询" onclick="search()">
<div id="inDiv" style="display:none">
<table>
<tr>
<th>收款总金额</th>
<th>收款交易次数</th>
</tr>
<tbody id="inTbody"></tbody>
<tr>
<th>单据号</th>
<th>创建时间</th>
<th>总额</th>
<th>状态</th>
</tr>
<tbody id="inDetailTbody"></tbody>
</table>
<span id="inDetail">
</span>
</div>

<div id="outDiv" style="display:none">
<table>
<tr>
<th>付款总金额</th>
<th>付款交易次数</th>
<th>操作</th>
</tr>
<tbody id="outTbody"></tbody>
</table>
<span id="inDetail">

</span>
</div>


		<iframe width=174 height=189 name="gToday:normal:agenda.js"
			id="gToday:normal:agenda.js"
			src="<%=basePath%>common/calendar/ipopeng.htm" scrolling="no"
			frameborder="0"
			style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
	</body>
</html>
