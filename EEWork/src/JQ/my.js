function test() {
    //获取span标记
    //js获取span
    var sp = document.getElementById("sp");
    //alert(sp);


    var sp2 = $("#sp");


    var arr = $("#sp,h2");
    arr.each(function () {
        alert($(this).text())
    })
    function q() {
        
    }
}