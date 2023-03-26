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

@WebServlet( "/Brand/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    private BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();
        System.out.println(jsonString);
        int id  = Integer.parseInt(jsonString);
        Brand brand=brandService.selectById(id);

        ObjectMapper objectMapper=new ObjectMapper();
        String brandtoJSON=objectMapper.writeValueAsString(brand);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(brandtoJSON);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
