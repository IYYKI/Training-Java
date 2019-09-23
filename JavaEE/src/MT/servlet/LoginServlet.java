package MT.servlet;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.dao.UserDao;
import MT.model.User;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //获取账号密码
        String account = req.getParameter("account");
        String psw = req.getParameter("password");

        try {
            Object[] objects=	new UserDao().queryAll(account, psw);
            if ((boolean) objects[0]) {
                User u=new User(account,psw,objects[3].toString());
                //保存用户登录信息
                req.getSession().setAttribute("user", u);
                //跳转到美团首页（动态） 去到一个servlet
                resp.sendRedirect(req.getContextPath()+"/index");
            }else {
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
