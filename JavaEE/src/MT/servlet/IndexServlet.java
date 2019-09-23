package MT.servlet;



import MT.dao.FoodDao;
import MT.model.Food;
import MT.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        //先获取用户登录信息
        Object obj = req.getSession().getAttribute("user");

        //查询food表中所有食品 动态生成首页
        try {
            ArrayList<Food> al = new FoodDao().queryAll();

            PrintWriter out = resp.getWriter();

            out.println("<html>\r\n" +
                    "	<head>\r\n" +
                    "		<title>美团外卖</title>\r\n" +
                    "		<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\r\n" +
                    "		<link type=\"text/css\" href=\"css/mt.css\" rel=\"stylesheet\" />\r\n" +
                    "		<script type=\"text/javascript\" src=\"js/mt.js\"></script>\r\n" +
                    "		\r\n" +
                    "	</head>\r\n" +
                    "	<body>\r\n" +
                    "		<div id=\"header\"><!--美团头部-->\r\n" +
                    "			<img src=\"img/ceiling-logo2.png\" class=\"fl logo\"/>\r\n" +
                    "			<div class=\"search fl\">\r\n" +
                    "				<p class=\"ss\">搜索商家、美食<span>搜索</span></p>\r\n" +
                    "			</div> \r\n" +
                    "			\r\n" +
                    "		</div>"+
                    "<p class=\"car\" onclick=\"showCar()\">我的购物车</p>"
            );

            //判断用户 有没有登录
            if(obj==null) {//未登录直接进入首页
                out.println("<a href='login.html'>亲，请登录</a>");
            }else {
                User u=(User)obj;
                out.println("欢迎您，"+u.getName()+" <a href='login.html'>退出</a>");
            }


            out.println("<div class=\"main\" id=\"main\">");
            //集合中有几个食品就生成几个div
            for(Food f:al) {
                out.println("<div class=\"food fl\">\r\n" +
                        "				<img src=\"WEB-INF/img/"+f.getPic()+"\"/>\r\n" +
                        "				<table align=\"center\" width=\"200px\">\r\n" +
                        "					<tr>\r\n" +
                        "						<td colspan=\"2\" align=\"left\">"+f.getName()+"</td>\r\n" +
                        "						<td align=\"right\">"+f.getPrice()+"元/份</td>\r\n" +
                        "					</tr>\r\n" +
                        "					<tr>\r\n" +
                        "						<td colspan=\"3\" align=\"right\" style=\"color:orange;font-size:14px\">月销售量4000</td>\r\n" +
                        "					</tr>\r\n" +
                        "					<tr style=\"color:#666;font-size:12px\">\r\n" +
                        "						<td>起送￥10</td>\r\n" +
                        "						<td>免配送费</td>\r\n" +
                        "						<td>45分钟</td>\r\n" +
                        "					</tr>\r\n" +
                        "					<tr>\r\n" +
                        "						<td colspan=\"3\" align=\"right\"><input type=\"button\" value=\"加入购物车\" onclick=\"addCar("+f.getFoodId()+")\"></td>\r\n" +
                        "					</tr>\r\n" +
                        "				</table>\r\n" +
                        "			</div>");
            }

            out.println("</div>\r\n" +
                    "		</div>\r\n" +
                    "	</body>\r\n" +
                    "</html>");


        } catch (SQLException e) {
            e.printStackTrace();
            //给客户端跳转
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
