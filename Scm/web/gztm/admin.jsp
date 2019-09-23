<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

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
    <title>用户管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
    <script type="text/javascript" src="dwr/interface/UserDaoAjax.js"></script>
    <script language="javascript" type="text/javascript" src="<%=basePath%>script/AddRows.js"></script>
    <script type="text/javascript" src="<%=basePath%>script/util.js"></script>
</head>
<body onload="init()">
<p>
    ${message}
</p>
<input name="addNew" id="addNew" type="button" value="添加用户" onClick="showAddNewDiv()"/>
<%-- style="display:none"
确认密码：<input type="password" name="password" >
--%>
<form action="servlet/UserManagementServlet" id="adminForm">
    用户查询：
    <input name="inputAccount" type="text" onFocus="clearInput()"
           value="${empty param.inputAccount? " 输入账号查询": param.inputAccount}"/>
    <input type="submit" name="bSubmit" id="bSubmit" value="提交">
</form>


<form action="#" id="disForm" name="disForm">
    <input type="hidden" name="mfAccount">
    <c:if test="${!empty userList}">
        <c:if test="${empty message}">

            <display:table name="${sessionScope['userList']}" id="user" pagesize="8" defaultsort="1" export="true">
                <display:setProperty name="sort.amount" value="list"/>    <%-- 默认对所有页进行排序 否则只对当前页进行排序  --%>

                <display:column property="account" title="帐户"/>
                <display:column property="password" title="密码"/>
                <display:column property="name" title="姓名"/>
                <display:column property="createDate" title="创建日期"/>
                <display:column title="用户权限">
                    <c:forEach items="${user.authorityList}" var="list" varStatus="i">
                        <c:out value="${list}"></c:out>
                    </c:forEach>
                </display:column>
                <display:column title="使用状态">
                    <c:if test="${user.status==1}">启用中</c:if> <c:if test="${user.status==0}"><font
                        color="red">已停用</font></c:if>
                </display:column>
                <display:column title="操作">
                    <input type="button" value="修改" name="bModify" onclick="modifyUser(this.parentNode.parentNode)">
                </display:column>
            </display:table>

        </c:if>
    </c:if>
</form>
<%--
<table>
<tr><th>帐户</th><th>密码	</th><th>姓名</th><th>创建日期</th>	<th>	用户权限</th><th>使用状态</th><th>操作</th></tr>
    <c:forEach items="${userList}" var="user">
    <tr>
    <td><c:out value="${user.account}"></c:out></td>
        <td><c:out value="${user.password}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td>									<c:out value="${user.createDate}"></c:out>								</td>
        <td>
                <c:forEach items="${user.authorityList}" var="list" varStatus="i">
                <c:out value="${list}"></c:out>

                <%--
                <c:if test="${i.index%2!=0}">
                    <br>
                </c:if>
         //
            </c:forEach>
        </td>
            <td><c:if test="${user.status==1}">启用中</c:if>	<c:if test="${user.status==0}"><font color="red">已停用</font></c:if>		</td>
        <td>
            <input type="button" value="修改" name="bModify" onclick="modifyUser(this.parentNode.parentNode)">
        </td>
    </tr>
</c:forEach>
</table>

--%>


<div id="modifyDiv" style="display:none">
    <form action="servlet/modifyUserServlet" id="mForm" name="mForm">
        <pre>
            <input type="hidden" name="mmAccount">
            账号：<input type="text" name="mAccount" disabled="disabled">
            密码：<input type="password" name="mPassword1">
            确认密码：<input type="password" name="mPassword2">
            姓名：<input type="text" name="mName">
            用户权限：
<input name="mAuthority" type="checkbox" id="mAuthority01" value="01">系统管理<input name="mAuthority" type="checkbox"
                                                                                 id="mAuthority02" value="02">采购管理<input
                        name="mAuthority" type="checkbox" id="mAuthority03" value="03">库存管理
<input name="mAuthority" type="checkbox" id="mAuthority04" value="04">收支管理<input name="mAuthority" type="checkbox"
                                                                                 id="mAuthority05" value="05">销售管理<input
                        name="mAuthority" type="checkbox" id="mAuthority06" value="06">统计管理
使用状态：<input type="button" name="mStatus" onClick="isStatus()"><input type="hidden" name="mmStatus">
<input type="submit" value="修改"><input type="reset" value="重填">
 </pre>
    </form>
</div>
<div id="DivAddNew" style="display:none">
    <form action="servlet/RegistUserServlet" id="registForm" name="registForm">
				<pre>
账号：<input type="text" name="account" onblur="validate()">	<span id="errorAccount"><font
                        color="red">用户名已被注册</font></span>
密码：<input type="password" name="password1">
确认密码：<input type="password" name="password2" onblur="isSame()"><span id="errorPassword"><font color="red">密码必须一致</font>	</span>
姓名：<input type="text" name="name">
权限：
<input name="authority" type="checkbox" id="authority01" value="01">系统管理<input
                        name="authority" type="checkbox" id="authority02" value="02">采购管理
<input name="authority" type="checkbox" id="authority03" value="03">库存管理<input
                        name="authority" type="checkbox" id="authority04" value="04">收支管理
<input name="authority" type="checkbox" id="authority05" value="05">销售管理<input
                        name="authority" type="checkbox" id="authority06" value="06">统计管理
<input type="submit" value="注册"><input type="reset" value="重填">
</pre>
    </form>
</div>
</body>
</html>
