/*
 * Copyright (c) 2020. Bruno Militzer
 */

package br.com.brunomilitzer.trainings.servlet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/FilterDemoServlet")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        out.println("Pre Servlet");
        chain.doFilter(request, response);
        out.println("Post Servlet");
    }

    @Override
    public void destroy() {

    }
}
