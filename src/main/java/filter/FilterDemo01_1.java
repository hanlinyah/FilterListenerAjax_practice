package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "FilterDemo01_1" ,value = "/*")
public class FilterDemo01_1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo01_1 init");
    }

    public void destroy() {
        System.out.println("FilterDemo01_1 destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo01_1 放行前");
                chain.doFilter(request, response);
        System.out.println("FilterDemo01_1 放行後");
    }
}
