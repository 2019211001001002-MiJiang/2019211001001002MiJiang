package main.java.com.MiJiang.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}
)
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("i am in HelloFilter -->destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am HelloFilter -->doFilter()-before servlet-(request come here)");
        chain.doFilter(req, resp);
        System.out.println("i am HelloFilter -->doFilter()-after servlet-(request come here)");

    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("i am in HelloFilter -->init()");
    }

}
