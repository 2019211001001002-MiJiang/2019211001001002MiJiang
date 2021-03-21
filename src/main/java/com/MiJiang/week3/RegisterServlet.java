package main.java.com.MiJiang.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");
        PrintWriter writer=response.getWriter();
        writer.println("name:"+name);
        writer.println("pwd:"+pwd);
        writer.println("email:"+email);
        writer.println("sex:"+sex);
        writer.println("birth:"+birth);
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
