package ClassWorks.Servlet.Day_8_29_WorkOne.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassWorks.Servlet.Day_8_29_WorkOne.Dao.UserDao;
import ClassWorks.Servlet.Day_8_29_WorkOne.Model.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.selectByUserAndPwd(name, pwd);
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>\r\n" +
                "<meta charset=\"UTF-8\">\r\n" +
                "<title>Insert title here</title>\r\n" +
                "</head>\r\n" +
                "<body>");
        if(user!=null) {
            out.println("<h2 style='color:green'>success!</h2>");
            out.println(user);
        }else {
            out.println("<h2 style='color:red'>fail!</h2>");
        }

        out.println("</body></html>");

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
