package main.java.com.MiJiang.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("username");

        String PassWord = request.getParameter("password");



        String sql = "Insert into Login(UserName,PassWord) values(?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,UserName);
            p.setString(2,PassWord );

            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        String sql1 = "SELECT * FROM Login WHERE UserName=? AND PassWord=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1,UserName);
            ps.setString(2,PassWord);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                out.println("Login Success!!!");
                out.println("Welcome "+UserName+".");
            }else{
                out.print("Username or Password Error!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
