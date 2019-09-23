package com.aowin.util;

import com.aowin.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityFilter extends HttpServlet implements Filter
{
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain fChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getContextPath();
        String basePath = req.getScheme() + "://" + req.getServerName() + ":"
                + req.getServerPort() + path + "/";

        User user = (User) req.getSession().getAttribute("user");
        boolean flag = false;
        if (user == null)// 用户登陆以后session里面才有user
        {
            req.getSession().setAttribute("error", "请您先登陆，才能继续下面的操作！");
            res.sendRedirect(basePath + "fail.jsp");

        } else
        {
            fChain.doFilter(request, response);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

}
