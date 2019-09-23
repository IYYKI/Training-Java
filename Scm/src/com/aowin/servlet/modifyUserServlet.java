package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.UserDao;

public class modifyUserServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        // response.setContentType("text/html;charset=gb2312");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        UserDao userDao = new UserDao();
        String account = request.getParameter("mmAccount");
        String password = request.getParameter("mPassword1");
        String name = request.getParameter("mName");
        String status = request.getParameter("mmStatus");
        boolean flag = false;
        if (!(account == null || account.equals("") || password == null
                || password.equals("") || name == null || name.equals("")
                || status == null || status.equals("")))
        {

            if ("启用中".equals(status.trim()))
            {
                status = "1";
            } else if ("已停用".equals(status.trim()))
            {
                status = "0";
            }

            String a[] = request.getParameterValues("mAuthority");
            ArrayList authorityList = new ArrayList();
            for (int i = 0; i < a.length; i++)
            {
                authorityList.add(a[i]);
            }

            flag = userDao.modifyUser(account, password, name, status,
                    authorityList);
            if (flag)
            {
                request.setAttribute("message", "修改成功！");
                this.getServletContext()
                        .getRequestDispatcher("/gztm/admin.jsp").forward(
                        request, response);
            } else
            {
                request.setAttribute("message", "修改失败！");
                this.getServletContext()
                        .getRequestDispatcher("/gztm/admin.jsp").forward(
                        request, response);
            }

        } else
        {
            request.setAttribute("message", "失败！");
            this.getServletContext().getRequestDispatcher("/gztm/admin.jsp")
                    .forward(request, response);
        }
    }

}
