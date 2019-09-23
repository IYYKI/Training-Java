// JavaScript Document

function showAll(){
	$("addNewDiv").style.display="none";
	$("modifyDiv").style.display="none";
	CategoryIdDao.getAll(showDate);
}
function showDate(date){
	if(date.length!=0){
		$("showAllDiv").style.display="block";
		var tbodyId="showAllTbody";
		 DWRUtil.removeAllRows(tbodyId);
   for(var i = 0; i < date.length ; i ++ )
   {
      var row = document.getElementById(tbodyId).insertRow(-1);
      row.setAttribute("align", "center");
     
      var cell = row.insertCell(0);
      cell.innerHTML = date[i].id ;
      
      cell = row.insertCell(1);
      cell.innerHTML = date[i].name ;
      
      cell = row.insertCell(2);
      cell.innerHTML = date[i].remark ;

      cell = row.insertCell(3);
      cell.innerHTML = "<input type='button' value='增加' onclick='addNew()'><input type='button' value='修改' onclick='modify(\""+date[i].id+"\",\""+date[i].name+"\",\""+date[i].remark+"\")'><input type='button' value='删除' onclick='deletex(\""+date[i].id+"\")'>" ;
   }
	}else{
		alert("没有数据！");
	}
}
function addNew(){
		CategoryIdDao.getlastCategoryId(showcaId);
}

function showcaId(date){
	$("modifyDiv").style.display="none";
	if(date!=null && date!=""){
		$("addNewDiv").style.display="block";
		$("caId").value=(parseInt(date)+1);
		$("name").value="";
		$("remark").value="";
	}else{
		alert("程序出错！请重试！");
	}
}
function addNewCateg(){
	if(confirm("确认增加吗？")){
	  var id=$("caId").value;
			if($("name").value!=null &&  $("name").value!="")
			{
			var namex=$("name").value;
			}else{
				return alert("名称不能为空！");
			}
			var ramark=$("remark").value;
	CategoryIdDao.addNewCategoryId(id,namex,ramark,reFresh);
}
}
function modify(id,namex,remark){
	$("addNewDiv").style.display="none";
	$("modifyDiv").style.display="block";
	$("mcaId").value=id;
		$("mname").value=namex;
			$("mremark").value=remark;
}
function modifyCateg(){
var	id=$("mcaId").value;
	var namex=$("mname").value;
	var remark=$("mremark").value;
	CategoryIdDao.modifyCategory(id,namex,remark,reFresh);
}
function deletex(id){
	if(confirm("确认删除吗？")){
		CategoryIdDao.deleteCategory(id,reFresh);
	}
}
function reFresh(boolean){
	if(boolean){
		showAll();
	}else{
		alert("操作失败！");
	}
}

