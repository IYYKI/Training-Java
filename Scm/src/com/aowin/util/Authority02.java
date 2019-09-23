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

@SuppressWarnings("serial")
public class Authority02 extends HttpServlet implements Filter
{

    @SuppressWarnings("unchecked")
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
        if (user != null)// 用户登陆以后session里面才有user
        {
            List AuthorityList = user.getAuthorityList();
            for (int i = 0; i < AuthorityList.size(); i++)
            {
                String s = AuthorityList.get(i).toString();
                if ("采购管理".equals(s))
                {
                    flag = true;
                    break;
                }
            }

            if (flag)
            {
                fChain.doFilter(request, response);
            } else
            {
                req.getSession().setAttribute("error", "权限不够!您不能操作这个模块！");
                res.sendRedirect(basePath + "fail.jsp");
            }

        } else
        {
            req.getSession().setAttribute("error", "请您先登陆，才能继续下面的操作！");
            res.sendRedirect(basePath + "fail.jsp");
        }

    }

    public void init(FilterConfig arg0) throws ServletException
    {

    }

}
