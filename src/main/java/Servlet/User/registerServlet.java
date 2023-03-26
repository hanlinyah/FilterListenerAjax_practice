package Servlet.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/User/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputCode=req.getParameter("verifyCode");
        String verifyCode= req.getSession().getAttribute("verifyCode").toString();

        if(verifyCode.equalsIgnoreCase(inputCode)){
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            boolean registerstate=  service.UserService.register(username,password);

            PrintWriter writer=resp.getWriter();
            if(registerstate){
                req.setAttribute("registermessage","註冊成功，請登入");
                req.getRequestDispatcher("./login.jsp").forward(req,resp);
            }else{
                req.setAttribute("registermessage","用戶名稱已存在");
                req.getRequestDispatcher("./register.jsp").forward(req,resp);
            };

        }else {
            req.setAttribute("velifymessage","驗證碼輸入錯誤");
            req.getRequestDispatcher("./register.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
