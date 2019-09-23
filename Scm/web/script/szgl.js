// JavaScript Document
function MyTrim(ss)
{
   return ss.replace(/(^\s*)|(\s*$)/g, "");
}


//请注意 showTab 方法有一个是SomainDao 的，一个是自己写的js函数
function showTabs(id){
	var t;
	if(id==0){t="货到付款";}else if(id==1){t="款到发货";}else{t="预付款到发货";}
	SomainDao.showTab(t,showTab);
}
function showTab(data)
{
	var tbodyId;
	
	
	if(data.length!=0){
		switch(data[0].payType)
         {
            case "货到付款" :
               tbodyId = "hdfk";
               break;
            case "款到发货" :
               tbodyId = "kdfh";
               break;
            case "预付款到发货" :
               tbodyId = "yfkdfh";
               break;
         } 
		
		 DWRUtil.removeAllRows(tbodyId);
		 $("showTabId").value=tbodyId;
   for(var i = 0; i < data.length ; i ++ )
   {
      var row = document.getElementById(tbodyId).insertRow(-1);
      row.setAttribute("align", "center");
     
      var cell = row.insertCell(0);
      cell.innerHTML = data[i].soid ;
      
      cell = row.insertCell(1);
      cell.innerHTML = data[i].createTime ;
      
      cell = row.insertCell(2);
      cell.innerHTML = data[i].customerCode ;
      
      cell = row.insertCell(3);
      cell.innerHTML = data[i].stockUser ;

      cell = row.insertCell(4);
      cell.innerHTML = data[i].tipFee ;
      
      cell = row.insertCell(5);
      cell.innerHTML = data[i].productTotal ;
      
      cell = row.insertCell(6);
      cell.innerHTML = data[i].poTotal ;

    		cell=row.insertCell(7);
    		cell.innerHTML=data[i].payType;

      cell = row.insertCell(8);
      cell.innerHTML = data[i].prePayFee ;

      var payType = data[i].payType ;
      payType = MyTrim(payType);
       var s;
      var d=data[i].statusx;
      d=d.toString();
      if(payType == "货到付款")
      {
         switch(d)
         {
            case "1" :
               s = "新";
               break;
            case "2" :
               s = "已出库";
               break;
            case "3" :
               s = "已付款";
               break;
            case "4" :
               s = "已了结";
               break;
         } 
      }
      else if(payType == "款到发货")
      {
      	switch(d)
         {
            case "1" :
            s = "新";
            break;
            case "2" :
            s = "已付款";
            break;
            case "3" :
            s = "已出库";
            break;
            case "4" :
            s = "已了结";
            break;
         } 
      }else{
      	switch(d)
         {
            case "1" :
            s = "新";
            break;
            case "2" :
            s = "已预付";
            break;
            case "3" :
            s = "已出库";
            break;
            case "4" :
            s = "已付款";
            case "5" :
            s = "已了结";
            break;
         } 
      }
      cell = row.insertCell(9);
      cell.innerHTML = s ;
      var account=$("hUserAccount").value;
      cell = row.insertCell(10);
      cell.innerHTML = "<input type='button' value='详细显示' onclick='showDitail("+data[i].soid+")'>" ;
      cell = row.insertCell(11);
      
      if(payType!="预付款到发货"){
      cell.innerHTML = "<input type='button' value='收款' onclick='getInMoney("+data[i].soid+",\""+account+"\",\""+payType+"\")'>" ;
      }else{
      	 cell.innerHTML = "<input type='button' value='预收款' onclick='getPreInMoney("+data[i].soid+",\""+account+"\")'>" +
      	 		"<input type='button' value='收款' onclick='getInMoney("+data[i].soid+",\""+account+"\",\""+payType+"\")'>" ;
      }
      
   }
	}else{
		 DWRUtil.removeAllRows($("showTabId").value);
	}
	
  
}

function getInMoney(soid,account,payType)
{
	if (confirm("确定编号为："+soid+"  的销售单收款吗？")) 
	{
   SomainDao.getInMoney(soid,account,payType,reShowTab);
   }
}
function getPreInMoney(soid,account){
		if (confirm("确定编号为："+soid+"  的销售单预收款吗？")) 
	{
   SomainDao.getInPreMoney(soid,account,reShowTab);
   }
	
}
function showDitail(id){
      SoitemDao.getSoitemBySoid(id,showDitailOneRow);
}

function showDitailOneRow(data){
	var div;
	switch ($("showTabId").value){
		case "hdfk" : div="spanHdfk";break;
		case "kdfh" : div="spanKdfh";break;
		case "yfkdfh" : div="spanYfkdfh";break;
	}
	if(	$(div).style.display == "none"){
			$(div).style.display = "block";
	}
	var showTabId=$("showTabId").value+"Ditail";
	DWRUtil.removeAllRows(showTabId);
	    var row = document.getElementById(showTabId).insertRow(-1);
      if(data!=null){
      	var cell = row.insertCell(0);
      cell.innerHTML = data.soid ;
       cell = row.insertCell(1);
      cell.innerHTML = data.productCode ;
       cell = row.insertCell(2);
      cell.innerHTML = data.unitPrice ;
       cell = row.insertCell(3);
      cell.innerHTML = data.num ;
       cell = row.insertCell(4);
      cell.innerHTML = data.unitName ;
       cell = row.insertCell(5);
      cell.innerHTML = data.itemPrice ;
   }else{
   	alert("没有数据，请重试！");
   	}
   	}
   
   
   
function reShowTab(boolean){
	if(boolean){
		var t= $("showTabId").value;
		var payType;
		if(t=="hdfk"){
			payType="货到付款";
		}else if(t=="kdfh"){
			payType="款到发货";
		}else{
			payType="预付款到发货";
		}
		SomainDao.showTab(payType,showTab);
	}else{
		alert("修改失败，请重试！");
	}
}




