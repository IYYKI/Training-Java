package com.aowin.servlet;

import com.aowin.dao.UserDao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UserManagementServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        doPost(request, response);
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String account = request.getParameter("inputAccount");
        UserDao userDao = new UserDao();
        List userList = userDao.getUsers(account);
        if (userList.isEmpty())
        {
            request.setAttribute("message", "没有记录！");
            this.getServletContext().getRequestDispatcher("/gztm/admin.jsp")
                    .forward(request, response);
        } else
        {
            request.getSession().setAttribute("userList", userList);
            this.getServletContext().getRequestDispatcher("/gztm/admin.jsp")
                    .forward(request, response);
        }
    }
}
