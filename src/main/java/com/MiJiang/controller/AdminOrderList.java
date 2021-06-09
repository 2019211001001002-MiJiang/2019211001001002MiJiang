package main.java.com.MiJiang.controller;

import main.java.com.MiJiang.dao.OrderDao;
import main.java.com.MiJiang.model.Order;
import main.java.com.MiJiang.model.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderList",value = "/admin/orderList")
public class AdminOrderList extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        super.init();
        con=(Connection)getServletContext().getAttribute("con");
    }
    public void destroy(){
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypeList= Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/WEB-INF/views/admin/orderList.jsp").forward(request,response);
    }
}
