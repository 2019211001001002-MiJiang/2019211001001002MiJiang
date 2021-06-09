package main.java.com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MiJiangFilter")
public class MiJiangFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("MiJiangFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("MiJiangFilter -- after chain");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
