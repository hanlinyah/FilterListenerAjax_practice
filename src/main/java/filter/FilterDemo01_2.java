package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "FilterDemo01_2" ,value = "/*")
public class FilterDemo01_2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo01_2 init");
    }

    public void destroy() {
        System.out.println("FilterDemo01_2 destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo01_2 放行前");
                chain.doFilter(request, response);
        System.out.println("FilterDemo01_2 放行後");
    }
}
