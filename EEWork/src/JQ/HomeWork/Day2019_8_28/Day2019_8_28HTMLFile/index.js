var id = 0;
//给按钮绑定事件--在加载 完成就绑定事件
$(function () {
    // 新增绑定
    $("#addBtn").click(function () {
        id++;
        $("table").append("<tr>" +
            "<td>" + id + "</td>" +
            "<td>鬼子进村</td>" +
            "<td>啊！花姑娘！</td>" +
            "<td>yyk</td>" +
            "<td>搞怪</td>" +
            "<td><input type='button' class='CG' value='修改' onclick='updTr(this)'>" +
            "&nbsp;"+
                "<input type='button' value='删除' onclick='dltTr(this)'>" +
            "</td>" +
            "</tr>")
        $(".CG").click(function(e) {
            if( $(".abc").hasClass("show") ){
                // 执行隐藏
                $(".abc").hide().removeClass("show");
                // 其他
            }else{
                // 显示
                $(".abc").show().addClass("show");
            }
        });
    })


})
$(document).ready(function(e) {
    $(".btn").click(function(e) {
        if( $(".abc").hasClass("show") ){
            // 执行隐藏
            $(".abc").hide().removeClass("show");
            // 其他
        }else{
            // 显示
            $(".abc").show().addClass("show");
        }
    });
    $(".Btn").click(function(e) {
        if( $(".abc").hasClass("show") ){
            // 执行隐藏
            $(".abc").hide().removeClass("show");
            // 其他
        }else{
            // 显示
            $(".abc").show().addClass("show");
        }
    });
});

//删除
function dltTr(dltBtn) {
    //获得按钮的父元素
    var tr = $(dltBtn).parent().parent();
    tr.remove();
}

//修改
var trLine = 0;

function updTr(updBtn) {
    $("#sel").val($(updBtn).parent().prevAll().eq(0).text());
    $("#author").val($(updBtn).parent().prevAll().eq(1).text());
    $("#remark").val($(updBtn).parent().prevAll().eq(2).text());
    $("#title").val($(updBtn).parent().prevAll().eq(3).text());
    trLine = $(updBtn).parent().parent("tr").prevAll().length;
}

//保存
function savTr() {
    $("table tr").eq(trLine).find("td").eq(1).html($("#title").val());
    $("table tr").eq(trLine).find("td").eq(2).html($("#remark").val());
    $("table tr").eq(trLine).find("td").eq(3).html($("#author").val());
    $("table tr").eq(trLine).find("td").eq(4).html($("#sel").val());
}

//重置
function reSet() {
    $("#sel").val("");
    $("#author").val("");
    $("#remark").val("");
    $("#title").val("");
}