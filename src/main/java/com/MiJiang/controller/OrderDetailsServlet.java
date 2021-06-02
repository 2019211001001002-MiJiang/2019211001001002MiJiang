package main.java.com.MiJiang.controller;

import main.java.com.MiJiang.dao.OrderDao;
import main.java.com.MiJiang.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        super.init();
        con=(Connection)getServletContext().getAttribute("con");
    }
    public void destroy(){
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int orderId=request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item=new Item();
        OrderDao dao=new OrderDao();
        List<Item> items=dao.findItemsByOrderId(con,orderId);
        request.setAttribute("itemList",items);
        request.getRequestDispatcher("orderDetails.jsp").forward(request,response);
    }
}
