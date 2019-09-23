<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'cpflgl.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/util.js"></script>
		<script type="text/javascript" src="dwr/interface/CategoryIdDao.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/cpflgl.js"></script>

	</head>

	<body onload="showAll();">
		<h1>
			产品分类管理
		</h1>
		
<div id="showAllDiv" style="display:none">
<table>
<tr>
<th>分类序列号</th>
<th>名称</th>
<th>描述</th>
<th>操作</th>
</tr>
<tbody id="showAllTbody"></tbody>
</table>
</div>

<div id="addNewDiv" style="display:none">
<table>
<tr>
<th>分类序列号<br></th>
<th>名称<br></th>
<th>描述<br></th>
<th>操作<br></th>
</tr>
<tr>
<td><input type="text" name="caId" readonly><br></td>
<td><input type="text" name="name" ><br></td>
<td><input type="text" name="remark" ><br></td>
<td><input type="button" name="AddNewButton" value="增加" onClick="addNewCateg()"><br></td>
</tr>
</table>
</div>


<div id="modifyDiv" style="display:none">
<table>
<tr>
<th>分类序列号<br></th>
<th>名称<br></th>
<th>描述<br></th>
<th>操作<br></th>
</tr>
<tr>
<td><input type="text" name="mcaId" readonly><br></td>
<td><input type="text" name="mname" ><br></td>
<td><input type="text" name="mremark" ><br></td>
<td><input type="button" name="AddNewButton" value="修改" onClick="modifyCateg()"><br></td>
</tr>
</table>
</div>

	</body>
</html>
