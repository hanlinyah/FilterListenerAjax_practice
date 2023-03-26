package Servlet.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pojo.User;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/User/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=  UserService.login(username,password);

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer=resp.getWriter();

        if(user != null){
            String rememberme=req.getParameter("rememberme");
            if("1".equals(rememberme)){
                int maxage=60*60*24*7;
                Cookie cookie_username=new Cookie("username",username);
                cookie_username.setMaxAge(maxage);
                resp.addCookie(cookie_username);

                Cookie cookie_password=new Cookie("password",password);
                cookie_password.setMaxAge(maxage);
                resp.addCookie(cookie_password);

            }
            HttpSession httpsession=req.getSession();
            httpsession.setAttribute("user",user);
//            resp.sendRedirect("../Brand/selectAllServlet");
            resp.sendRedirect("../Brand/Brand.jsp");

        }else {
            req.setAttribute("loginmessage","用戶名稱或密碼錯誤");
            req.getRequestDispatcher("./login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
