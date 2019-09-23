package com.aowin.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.UserDao;
@SuppressWarnings("serial")
public class RegistUserServlet extends HttpServlet
{

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String account = request.getParameter("account");
        String password = request.getParameter("password1");
        String name = request.getParameter("name");
        String a[] = request.getParameterValues("authority");
        ArrayList authorityList = new ArrayList();
        for (int i = 0; i < a.length; i++)
        {
            authorityList.add(a[i]);
        }
        UserDao userDao = new UserDao();
        boolean flag = false;
        flag = userDao.registUser(account, password, name, authorityList);
        if (flag)
        {
            request.setAttribute("message", "注册成功！");
            this.getServletContext().getRequestDispatcher("/gztm/admin.jsp")
                    .forward(request, response);
        } else
        {
            request.setAttribute("message", "注册失败！");
            this.getServletContext().getRequestDispatcher("/gztm/admin.jsp")
                    .forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        doGet(request, response);
    }

}
