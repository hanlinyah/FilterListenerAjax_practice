package Servlet.Brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Brand;
import service.BrandService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet( "/Brand/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();
        System.out.println(jsonString);
        int id  = Integer.parseInt(jsonString);
        brandService.DeleteById(id);
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
