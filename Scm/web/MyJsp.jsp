<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'MyJsp.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->


</head>

<body>


<input name="jzrq" type="text" size="15" readonly="true">
<span class="requred_symbol">*</span>
<a href="javascript:void(0)" onclick="gfPop.fPopCalendar(document.all.jzrq);return false;">
    <img name="popcal" align="absmiddle" src="<%=basePath%>images/selectDate.gif" width="15" height="12" border="0"
         alt=""></a>


<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js"
        src="<%=basePath%>common/calendar/ipopeng.htm" scrolling="no" frameborder="0"
        style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>

</body>
</html>
