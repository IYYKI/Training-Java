package ClassWorks.Servlet.Day_8_29_WorkOne.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassWorks.Servlet.Day_8_29_WorkOne.Util.LifeUtil;

@WebServlet("/servlet") // This is the URL of the servlet.
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int year = Integer.parseInt(req.getParameter("year"));
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String birthday = year+"-"+month+"-"+day;
        //从出生到现在活了多少天
        int life = LifeUtil.life(birthday);
        //活到100岁，还有多少天可活
        String hundredLater = (year+100)+"-"+month+"-"+day;
        int lifeAfter = (LifeUtil.life(hundredLater))*-1;

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>\r\n" +
                "<meta charset=\"UTF-8\">\r\n" +
                "<title>Insert title here</title>\r\n" +
                "</head>\r\n" +
                "<body>");
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}

