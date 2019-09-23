// JavaScript Document

function search(){
	var startTime=$("startTime").value;
	var endTime=$("endTime").value;
	
	var inOrOut="";
	var rPort = document.getElementsByName("inputType");
		for(i=0;i<rPort.length;i++){
			if(rPort[i].checked){
			inOrOut = rPort[i].value;
			}
		}
		var payType = $("payType").value;
		var id = $("id").value;
		SzcxDao.serch(startTime,endTime,inOrOut,payType,id,showTesult);
	}

function showResult(date){
	 document.getElementById("showDiv").style.display = "block";
	  DWRUtil.removeAllRows("showResultTbody");
	if(date.length!=0){
	 for(var i = 0; i < date.length ; i ++ )
   {
      var row = document.getElementById("showResultTbody").insertRow(-1);
      row.setAttribute("align", "center");
     
      var cell = row.insertCell(0);
      cell.innerHTML = date[i].time ;
      
      cell = row.insertCell(1);
      cell.innerHTML = date[i].id ;
      
      cell = row.insertCell(2);
      cell.innerHTML = date[i].momey ;
      
      cell = row.insertCell(3);
      cell.innerHTML = date[i].user ;

      cell = row.insertCell(4);
      cell.innerHTML = date[i].payType ;
   }
   }else{
   	alert("没有数据！");
   }
}