package main.java.com.MiJiang.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
   public LifeCycleServlet(){
       System.out.println("I am in constructor -->LifeCycleServlet");
   }
   public void init(){
       System.out.println("I am in init()");
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in service() -->doGet()");
    }
    public void destroy(){
        System.out.println("I am in destroy()");
    }

}
