package main.java.com.MiJiang.controller;

import main.java.com.MiJiang.dao.ProductDao;
import main.java.com.MiJiang.model.Category;
import main.java.com.MiJiang.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ShopServlet", value ="/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList=category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        ProductDao productDao=new ProductDao();
        List<Product> productList=null;
        try {
            if(request.getParameter("categoryId")==null) {
                productList = productDao.findAll(con);
            }else {
                int categoryId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productList",productList);

        request.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(request,response);
    }
}