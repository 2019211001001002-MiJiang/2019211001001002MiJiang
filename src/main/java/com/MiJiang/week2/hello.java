package main.java.com.MiJiang.week2;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class hello extends HttpServlet {
    String name="MiJiang";
    String ID="2019211001001002";



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        Date date=new Date();
        writer.println("Name: "+name+"<br/>");
        writer.println("ID: "+ID+"<br/>");
        writer.println("Date and Time: "+date.toString()+"<br/>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
