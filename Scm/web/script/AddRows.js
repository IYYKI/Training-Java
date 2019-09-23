// JavaScript Document

function clearInput(){
document.getElementById("inputAccount").value="";
}
function findObj(theObj, theDoc)
{
    var p, i, foundObj;
    if(!theDoc) theDoc = document;
    if( (p = theObj.indexOf("?")) > 0 && parent.frames.length)
    {
        theDoc = parent.frames[theObj.substring(p+1)].document;
        theObj = theObj.substring(0,p);
    }
    if(!(foundObj = theDoc[theObj]) && theDoc.all)
    foundObj = theDoc.all[theObj];
    for (i=0; !foundObj && i < theDoc.forms.length; i++)
    foundObj = theDoc.forms[i][theObj];
    for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++)
    foundObj = findObj(theObj,theDoc.layers[i].document);
    if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);
    return foundObj;
}
function AddSignRow()
{
    var txtTRLastIndex = findObj("txtTRLastIndex",document);
    var rowID = parseInt(txtTRLastIndex.value);
    var signFrame = findObj("SignFrame",document);
    var newTR = signFrame.insertRow(signFrame.rows.length);
    newTR.id = "SignItem" + rowID;
    var newNameTD=newTR.insertCell(0);
    newNameTD.innerHTML = newTR.rowIndex.toString();
    var newNameTD=newTR.insertCell(1);
    newNameTD.innerHTML = "<input name='txtName" + rowID + "' id='txtName" + rowID + "' type='text' size='40' />";
    var newEmailTD=newTR.insertCell(2);
    newEmailTD.innerHTML = "<input name='txtEMail" + rowID + "' id='txtEmail" + rowID + "' type='text' size='40' />";
    var newTelTD=newTR.insertCell(3);
    newTelTD.innerHTML = "<input name='txtTel" + rowID + "' id='txtTel" + rowID + "' type='text' size='10' />";
    var newTypeTD=newTR.insertCell(4);
    newTypeTD.innerHTML = "<select name='txtMobile" + rowID + "' id='txtMobile" + rowID + "'><option value='证券'>证券</option><option value='新闻'>新闻</option><option value='体育'>体育</option></select>";   
    var newDeleteTD=newTR.insertCell(5);
    newDeleteTD.innerHTML = "<div align='center' style='width:40px'><a href='javascript:;' onclick=\"DeleteSignRow('SignItem" + rowID + "')\">Delete</a></div>";
    txtTRLastIndex.value = (rowID + 1).toString() ;
}
function DeleteSignRow(rowid)
{
    var signFrame = findObj("SignFrame",document);
    var signItem = findObj(rowid,document);
    var rowIndex = signItem.rowIndex;
    signFrame.deleteRow(rowIndex);
    for(i=rowIndex;i<signFrame.rows.length;i++)
    {
        signFrame.rows[i].cells[0].innerHTML = i.toString();
    }
}
function ClearAllSign()
{
    if(confirm('确认清空吗?'))
    {
        var signFrame = findObj("SignFrame",document);
        var rowscount = signFrame.rows.length;
        for(i=rowscount - 1;i > 0; i--)
        {
            signFrame.deleteRow(i);
        }
        var txtTRLastIndex = findObj("txtTRLastIndex",document);
        txtTRLastIndex.value = "1";
        AddSignRow();
    }
}
