package com.aowin.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter
{

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain fChain) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        fChain.doFilter(request, response);
    }

    public void destroy()
    {
    }

    public void init(FilterConfig fConfig) throws ServletException
    {

    }

}
