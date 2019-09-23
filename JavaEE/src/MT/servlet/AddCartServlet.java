package MT.servlet;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.dao.AddCartDao;
import MT.model.User;

public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Object obj = req.getSession().getAttribute("user");
        int id = 0;
        if (obj != null) {
            User user = (User) obj;

            String account = user.getAccount();


            id = Integer.valueOf(req.getParameter("foodid"));

            try {
                new AddCartDao().AddCart(account, id);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        resp.sendRedirect("index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }

}
