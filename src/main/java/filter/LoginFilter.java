package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter" ,value="/Brand/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter過濾未登入用戶執行前");
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        String[] uris={"/img","/css","/js","/User","/index.jsp"};
        String requri=httpServletRequest.getRequestURI();
        System.out.println(requri);
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getServletPath());
        for(String uri:uris ){
            if(requri.contains(uri)){
                chain.doFilter(request, response);
                System.out.println("filter過濾未登入用戶執行後(預設放行)");
                return;
            }
        }

            HttpSession httpSession=httpServletRequest.getSession();
            Object user= httpSession.getAttribute("user");
            if(user!=null){
                chain.doFilter(request, response);
            }else{
                httpServletRequest.setAttribute("loginmessage","您尚未登入");
                httpServletRequest.getRequestDispatcher("/User/login.jsp").forward(httpServletRequest,response);
                System.out.println("filter過濾未登入用戶執行後");
            }

    }
}
