function addCar(fid) {
	// 加入购物车 将编号提交到对应 的servlet去处理

	// 1.通过隐藏域提交
	// 将食品编号放到隐藏域
	// $(":hidden").val(fid);
	// 提交隐藏域所在的表单
	// $("#fm").submit();//提交表单

	// 2.通过地址栏提交
	location = "http://localhost:8080/MT/addCart?foodid=" + fid;

}
function showCar() {
	// 加入购物车 将编号提交到对应 的servlet去处理

	// 1.通过隐藏域提交
	// 将食品编号放到隐藏域
	// $(":hidden").val(fid);
	// 提交隐藏域所在的表单
	// $("#fm").submit();//提交表单

	// 2.通过地址栏提交
	location = "http://localhost:8080/MT/cart";

}
function dlt(cartid) {
	location = "http://localhost:8080/MT/delete?cartid=" + cartid;
}

function dltAll() {
	var form = $("#deleteForm");
	form.attr("action", "delete");
	form.submit();
}
function buy() {
	var form = $("#deleteForm");
	form.attr("action", "settle");
	form.submit();
}
function checkall() {
	
}
function showMain() {
	// 加入购物车 将编号提交到对应 的servlet去处理

	// 1.通过隐藏域提交
	// 将食品编号放到隐藏域
	// $(":hidden").val(fid);
	// 提交隐藏域所在的表单
	// $("#fm").submit();//提交表单

	// 2.通过地址栏提交
	location = "http://localhost:8080/MT/index";

}