package MT.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.dao.AddCartDao;
import MT.dao.FoodDao;
import MT.model.Cart;
import MT.model.Food;
import MT.model.User;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 先获取用户登录信息
        Object obj = req.getSession().getAttribute("user");
        if (obj != null) {
            try {
                User user = (User) obj;
                ArrayList<Food> al = new FoodDao().queryAll();
                ArrayList<Cart> arrCart = new AddCartDao().selectCart(user.getAccount());
                PrintWriter out = resp.getWriter();
                out.println("<html>\r\n" + "	<head>\r\n" + "		<title>美团外卖</title>\r\n"
                        + "		<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\r\n"
                        + "		<link type=\"text/css\" href=\"css/mt.css\" rel=\"stylesheet\" />\r\n"
                        + "		<script type=\"text/javascript\" src=\"js/jquery-1.8.1.min.js\"></script>\r\n"
                        + "		<script type=\"text/javascript\" src=\"js/mt.js\"></script>\r\n" + "		\r\n"
                        + "	</head>\r\n" + "	<body>\r\n" + "		<div id=\"header\"><!--美团头部-->\r\n"
                        + "			<img src=\"img/ceiling-logo2.png\" class=\"fl logo\"/>\r\n"
                        + "			<div class=\"search fl\">\r\n"
                        + "				<p class=\"ss\">搜索商家、美食<span>搜索</span></p>\r\n" + "			</div> \r\n"
                        + "			\r\n" + "		</div>\r\n" + "		\r\n" + "		<!--购物车-->\r\n"
                        + "		<p class=\"car\" onclick=\"showCar()\">我的购物车</p>\r\n");
                out.println("<form action=\"\" id=\"deleteForm\" name=\"hahaha\">"
                        + "		<div class=\"myCar\" id=\"myCar\">\r\n"
                        + "			<table class=\"carTab\" id=\"cartab\"  cellspacing=\"0\">\r\n"
                        + "				<tr bgcolor=\"lightblue\">\r\n"
                        + "					<th><input type=\"checkbox\" id=\"all\" onchange=\"checkall\" />全选</th>\r\n"
                        + "					<th>CardID</th>\r\n" + "					<th>菜品</th>\r\n"
                        + "					<th>价格(元/份)</th> \r\n" + "					<th>操作</th>\r\n"
                        + "				</tr>\r\n");
                for (Cart cart : arrCart) {
                    int cartid = cart.getCartid();
                    int foodid = cart.getFoodid();
                    ArrayList<Food> arr = new FoodDao().query(foodid);
                    String name = arr.get(0).getName();
                    double price = arr.get(0).getPrice();
                    out.println("<tr bgcolor=\"lightblue\">\r\n"
                            + "					<td><input type='checkbox' name='ch'  value='" + cartid + "'/></td>\r\n"
                            + "					<td>" + foodid + "</td>\r\n" + "					<td>" + name
                            + "</td>\r\n" + "					<td>" + price + "(元/份)</td> \r\n"
                            + "					<td><input type='button' value='删除' onclick='dlt(" + cartid
                            + ")'/></td>\r\n" + "				</tr>\r\n");
                }
                out.println("			</table>\r\n" + "		</div>");
                out.println("	<div class=\"dd\">\r\n"
                        + "				<input type=\"button\" value=\"删除选中\" onclick=\"dltAll()\"/>\r\n"
                        + "				<span>合计￥<span id=\"total\">0</span></span>\r\n"
                        + "				<input type=\"button\" value=\"结算\" onclick=\"buy()\"/>\r\n"
                        + "			</div>\r\n" + "</form>"
                        + "			<p class=\"toBuy\" onclick=\"showMain()\">返回购物界面</p>\r\n");

                out.println("	</body>\r\n" + "</html>");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
