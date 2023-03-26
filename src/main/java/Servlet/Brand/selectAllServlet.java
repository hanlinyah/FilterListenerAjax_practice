package Servlet.Brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Brand;
import service.BrandService;

import java.io.IOException;
import java.util.List;

@WebServlet( "/Brand/selectAllServlet")
public class selectAllServlet extends HttpServlet {
    private BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        List<Brand> brands=brandService.selectAll();
        String brandstoJSON=objectMapper.writeValueAsString(brands);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(brandstoJSON);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
