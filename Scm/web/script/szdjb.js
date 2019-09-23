// JavaScript Document

function MyTrim(ss)
{
   return ss.replace(/(^\s*)|(\s*$)/g, "");
}
function search(){
var startTime=$("starttime").value;
var endttime=$("endtime").value;
var type="";
var rPort = document.getElementsByName("type");
for(var i = 0; i<rPort.length; i++){
if(rPort[i].checked){
type = rPort[i].value;
}
if(type=="in"){
SomainDao.getByCreatTime(startTime,endttime,showIn);
}
}
function showIn(date){
	if(date.length!=0){
	$("inDiv").style.display="block";
	$("outDiv").style.display="none";
	 DWRUtil.removeAllRows("inTbody");
	 var totleMoney=0;
	 var times=date.length;
	 for(var i = 0; i < date.length ; i ++ )
   {
      var row = document.getElementById("inDetailTbody").insertRow(-1);
      row.setAttribute("align", "center");
     
      var cell = row.insertCell(0);
      cell.innerHTML = date[i].soid ;
      
      cell = row.insertCell(1);
      cell.innerHTML = date[i].createTime ;
      
      cell = row.insertCell(2);
      cell.innerHTML = date[i].poTotal ;
      
      cell = row.insertCell(3);
      var statusx;
      var temps=MyTrim(date[i].statusx.toString());
      switch (temps){
      	case "1": statusx="新";break;
      		case "2": statusx="已付款";break;
      			case "3": statusx="已交货";break;
      				case "4": statusx="已了结";break;
      				case "5": statusx="已了结";break;
      }
     
      cell.innerHTML = statusx ;

totleMoney=totleMoney+date[i].poTotal;
   }
    var row = document.getElementById("inTbody").insertRow(-1);
      row.setAttribute("align", "center");
     
      var cell = row.insertCell(0);
      cell.innerHTML = totleMoney ;
      
      cell = row.insertCell(1);
      cell.innerHTML = times ;
   
   }
   else{
   	alert("没有数据！");
   }
}
}
