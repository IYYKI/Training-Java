package MT.servlet;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.dao.AddCartDao;
import MT.model.User;

public class DeleteServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // 先获取用户登录信息
        Object obj = req.getSession().getAttribute("user");
        User user = (User) obj;
        String account = user.getAccount();
        String[] array = req.getParameterValues("ch");

        String arr = req.getParameter("cartid");
        if (arr != null) {

            int cartid = Integer.valueOf(arr);
            try {
                new AddCartDao().deleteCart(account, cartid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                try {
                    new AddCartDao().deleteCart(account, Integer.valueOf(array[i]));
                } catch (NumberFormatException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        resp.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
