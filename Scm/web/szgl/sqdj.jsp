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
		<title>My JSP 'sqdj.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css">
		<link rel="stylesheet" href="<%=basePath%>css/tab.css" TYPE="text/css"
			MEDIA="screen">
		<link rel="stylesheet" href="<%=basePath%>css/tab-p.css"
			TYPE="text/css" MEDIA="print">
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/util.js"></script>
		<script type="text/javascript" src="dwr/interface/SomainDao.js"></script>
				<script type="text/javascript" src="dwr/interface/SoitemDao.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/prototype.js"></script>
		<script type="text/javascript" src="<%=basePath%>script/szgl.js"></script>
		<script type="text/javascript">

/* Optional: Temporarily hide the "tabber" class so it does not "flash"
   on the page as plain HTML. After tabber runs, the class is changed
   to "tabberlive" and it will appear.
*/
document.write('<style type="text/css">.tabber{display:none;}<\/style>');

var tabberOptions = {

  /* Optional: instead of letting tabber run during the onload event,
     we'll start it up manually. This can be useful because the onload
     even runs after all the images have finished loading, and we can
     run tabber at the bottom of our page to start it up faster. See the
     bottom of this page for more info. Note: this variable must be set
     BEFORE you include tabber.js.
  */
  'manualStartup':true,

  /* Optional: code to run after each tabber object has initialized */

  'onLoad': function(argsObj) {
    /* Display an alert only after tab2 
    if (argsObj.tabber.id == 'tab2') {
      alert('Finished loading tab2!');
    }*/
     showTabs(0);
  },

  /* Optional: code to run when the user clicks a tab. If this
     function returns boolean false then the tab will not be changed
     (the click is canceled). If you do not return a value or return
     something that is not boolean false, */

  'onClick': function(argsObj) {

    var t = argsObj.tabber; /* Tabber object */
    var id = t.id; /* ID of the main tabber DIV */
    var i = argsObj.index; /* Which tab was clicked (0 is the first tab) */
    var e = argsObj.event; /* Event object */

    if (id == 'tab2') {
       showTabs(i);
    }
  },

  /* Optional: set an ID for each tab navigation link */
  'addLinkId': true

};

</script>
		<script type="text/javascript" src="<%=basePath%>script/tabber.js"></script>
	</head>

	<body>
	<input type="hidden" name="hUserAccount" value="${user.account }">
		<input type="hidden" name="showTabId">
		<h1>
			收款登记
		</h1>
		<p>
			<font color="red">${message}</font>
		</p>
		<div class="tabber" id="tab2">

			<div class="tabbertab tabbertabdefault" title="货到付款">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				创建时间
				</th>
				<th>
					客户
				</th>
				<th>
				创建用户
				</th>
				<th>
					附加费用
				</th>
				<th>
					产品总价
				</th>
				<th>
					销售单总价格
				</th>
				<th>
					付款方式
				</th>
				<th>
					最低预付金额
				</th>
				<th>
					处理状态
				</th>
				<th>
					显示细节
				</th>
				<th>
					操作
				</th>
			</tr>
			<tbody id="hdfk"></tbody>
			</table>
		<span id="spanHdfk" style="display:none">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				产品编号
				</th>
				<th>
					产品数量单位 
				</th>
				<th>
			产品数量 
				</th>
				<th>
			销售单价
				</th>
				<th>
			产品明细总价
				</th>
			</tr>
			<tbody id="hdfkDitail"></tbody>
			</table>
			</span>
			</div>

			<div class="tabbertab" title="款到发货">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				创建时间
				</th>
				<th>
					客户
				</th>
				<th>
				创建用户
				</th>
				<th>
					附加费用
				</th>
				<th>
					产品总价
				</th>
				<th>
					销售单总价格
				</th>
				<th>
					付款方式
				</th>
				<th>
					最低预付金额
				</th>
				<th>
					处理状态
				</th><th>
					显示细节
				</th>
				<th>
					操作
				</th>
			</tr>
			<tbody id="kdfh"></tbody>
			</table>
			<span id="spanKdfh" style="display:none">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				产品编号
				</th>
				<th>
					产品数量单位 
				</th>
				<th>
			产品数量 
				</th>
				<th>
			销售单价
				</th>
				<th>
			产品明细总价
				</th>
			</tr>
			<tbody id="kdfhDitail"></tbody>
			</table>
			</span>
			</div>

			<div class="tabbertab" title="预付款到发货">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				创建时间
				</th>
				<th>
					客户
				</th>
				<th>
				创建用户
				</th>
				<th>
					附加费用
				</th>
				<th>
					产品总价
				</th>
				<th>
					销售单总价格
				</th>
				<th>
					付款方式
				</th>
				<th>
					最低预付金额
				</th>
				<th>
					处理状态
				</th><th>
					显示细节
				</th>
				<th>
					操作
				</th>
			</tr>
			<tbody id="yfkdfh"></tbody>
			</table>
			
			<span id="spanYfkdfh" style="display:none">
			<table>
			<tr>
			<th>
					销售单编号
				</th>
				<th>
				产品编号
				</th>
				<th>
					产品数量单位 
				</th>
				<th>
			产品数量 
				</th>
				<th>
			销售单价
				</th>
				<th>
			产品明细总价
				</th>
			</tr>
			<tbody id="yfkdfhDitail"></tbody>
			</table>
			</span>
			</div>
		</div>

<script type="text/javascript">
tabberAutomatic(tabberOptions);
</script>
	</body>
</html>
