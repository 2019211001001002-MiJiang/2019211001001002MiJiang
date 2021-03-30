package main.java.com.MiJiang.week4;


//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;

import java.io.PrintWriter;
//import java.sql.ResultSet;
//import java.sql.SQLException;

@WebServlet(urlPatterns = {"/conig"},
        initParams={@WebInitParam(name="name",value = "MiJiang"),
                        @WebInitParam(name="StudentID",value ="2019211001001002" ),


},loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
   // Connection con = null;
   // public void init()throws ServletException{
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://127.0.0.1:1433; DatabaseName=userMJ";
//        String username = "sa";
//        String password = "123456wsl";
//        ServletConfig config=getServletConfig();
//        String driver=config.getInitParameter("driver");
//        String url=config.getInitParameter("url");
//        String username=config.getInitParameter("username");
//        String password=config.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            Connection con = DriverManager.getConnection(url, username, password);
//            System.out.println("init()-->" + con);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
  //  }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        String name=getServletConfig().getInitParameter("name");
        String StudentID=getServletConfig().getInitParameter("StudentID");
        writer.println("name:"+name+"</br>");
        writer.println("studentid:"+StudentID);



    }
}