package com.aowin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String Account = request.getParameter("account");
        String Password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.getUser(Account, Password);
        if (user.getAccount() != null)
        {
            user.setAuthorityList(userDao.getAuthorityByAccount(Account));// 设用户权限
            request.getSession().setAttribute("user", user);
            request.setAttribute("message", "登陆成功！");
            this.getServletContext().getRequestDispatcher("/Success.jsp")
                    .forward(request, response);
            // response.sendRedirect("index.htm");
        } else
        {
            request.setAttribute("error", "用户名密码错！");
            this.getServletContext().getRequestDispatcher("/fail.jsp").forward(
                    request, response);
            // response.sendRedirect("index.htm");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        doGet(request, response);

        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out
        // .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01
        // Transitional//EN\">");
        // out.println("<HTML>");
        // out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        // out.println(" <BODY>");
        // out.print(" This is ");
        // out.print(this.getClass());
        // out.println(", using the POST method");
        // out.println(" </BODY>");
        // out.println("</HTML>");
        // out.flush();
        // out.close();
    }

}
