// JavaScript Document
/////////////// util - start

String.prototype.Trim = function()
{
   return this.replace(/(^\s*)|(\s*$)/g, "");
}

String.prototype.LTrim = function()
{
   return this.replace(/(^\s*)/g, "");
}

String.prototype.RTrim = function()
{
   return this.replace(/(\s*$)/g, "");
}

function MyTrim(ss)
{
   return ss.replace(/(^\s*)|(\s*$)/g, "");
}

///////////// util - end



function init()
{
   $("errorAccount").style.visibility = "hidden";
   $("errorPassword").style.visibility = "hidden";
}

function showDiv(id)
{

   document.getElementById(id).style.display = "block";

}

function shutdownDiv(id)
{
   document.getElementById(id).style.display = "none";

}

function isSame()
{
   if($("password1").value != $("password2").value)
   {
      $("errorPassword").style.visibility = "visible";
      $("password1").value = '';
      $("password2").value = '';
   }
   else
   {
      $("errorPassword").style.visibility = "hidden";
   }
}

function modifyUser(row)
{
   showDiv('modifyDiv');
   shutdownDiv('DivAddNew');
   
   var account = row.cells[0].innerText;
   var password = row.cells[1].innerText;
   var namex = row.cells[2].innerText;
   var authority = row.cells[4].innerText;
   var statusx = row.cells[5].innerText;
   account = MyTrim(account);
   password = MyTrim(password);
   namex = MyTrim(namex);
   authority = MyTrim(authority);
   statusx = MyTrim(statusx);

   var s = authority.split(" ");

   if(s[0] != "")
   {
     reset("half");
      for( i = 0 ; i < s.length ; i ++ )
      {
      	 s[i]=MyTrim(s[i]);
      switch(s[i]){
      case "系统管理":$( "mAuthority01" ).checked=true;break;
      case "采购管理": $( "mAuthority02" ).checked=true;break;
      case "库存管理": $( "mAuthority03" ).checked=true;break;
      case "收支管理": $( "mAuthority04" ).checked=true;break;
      case "销售管理": $( "mAuthority05" ).checked=true;break;
      case "统计管理": $( "mAuthority06" ).checked=true;break;
      }}
   }else{
    reset("half");
   }
$("mmAccount").value = account;
   $("mAccount").value = account;
   $("mPassword1").value = password;
   $("mPassword2").value = password;
   $("mName").value = namex;
   $("mStatus").value = statusx;
     $('mmStatus').value=$('mStatus').value;
}

function showAddNewDiv()
{
   showDiv('DivAddNew');
   shutdownDiv('modifyDiv');
}

function isStatus()
{
   var temp = $('mStatus').value;
   temp = MyTrim(temp);
   if(temp == "启用中")
   {
      $("mStatus").value = "已停用";
   }
   else
   {
      $("mStatus").value = "启用中";
   }
   $('mmStatus').value=$('mStatus').value;

}

function reset(id){
	if(id=="half"){
	 $( "mAuthority01" ).checked=false;
   $( "mAuthority02" ).checked=false;
     $( "mAuthority03" ).checked=false;
       $( "mAuthority04" ).checked=false;
  $( "mAuthority05" ).checked=false;
     $( "mAuthority06" ).checked=false;
	}
if(id=="totle"){     
	$( "mAuthority01" ).checked=false;
   $( "mAuthority02" ).checked=false;
     $( "mAuthority03" ).checked=false;
       $( "mAuthority04" ).checked=false;
  $( "mAuthority05" ).checked=false;
     $( "mAuthority06" ).checked=false;
	
       $("mfAccount").value = "";
     $("mmAccount").value =  "";
   $("mAccount").value =  "";
   $("mPassword1").value =  "";
   $("mPassword2").value =  "";
   $("mName").value =  "";
   $("mStatus").value =  "";
}
}
//abandon
function deleteUser(row)
{
	
	reset("totle");
	 shutdownDiv('modifyDiv');
	   var account = row.cells[0].innerText;
	   $("mfAccount").value = account;
	window.location="../servlet/modifyUserServlet?mmAccount="+account; 
}

//////////////////
////// DWR - start


function show(boolean)
{
   if(boolean)
   {
      $("errorAccount").style.visibility = "visible";
      registForm.account.value = '';
   }
   else
   {
      $("errorAccount").style.visibility = "hidden";
   }
}
function validate()
{
   var account = registForm.account.value;
   UserDaoAjax.existAccount(account, show);
}


//////////////////
////// DWR - end
