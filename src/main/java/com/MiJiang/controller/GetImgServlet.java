package main.java.com.MiJiang.controller;

import main.java.com.MiJiang.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(value = "/getImg" )
public class GetImgServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        super.init();
        con=(Connection)getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDao dao=new ProductDao();
        int id=0;
        if(request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }

            try {
                byte[] imgByte=new byte[0];
                imgByte=dao.getPictureById(id,con);
                if(imgByte!=null){
                    response.setContentType("image/gif");
                    OutputStream os=response.getOutputStream();
                    os.write(imgByte);
                    os.flush();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
}
