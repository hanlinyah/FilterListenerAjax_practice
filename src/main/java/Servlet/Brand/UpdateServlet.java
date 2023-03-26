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

@WebServlet("/Brand/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        ObjectMapper objectMapper=new ObjectMapper();
        Brand brand=objectMapper.readValue(jsonString,Brand.class);


        brandService.Update(brand);
        System.out.println(brand);
        response.getWriter().write("success");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}