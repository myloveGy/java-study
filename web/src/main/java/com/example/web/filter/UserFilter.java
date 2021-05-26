package com.example.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);filterConfig
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/web/user/login.jsp");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
