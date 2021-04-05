package main.java.com.MiJiang.week3;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/register")

public class RegisterServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {

        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id=request.getParameter("id");
//        String name=request.getParameter("name");
//        String pwd=request.getParameter("pwd");
//        String email=request.getParameter("email");
//        String sex=request.getParameter("sex");
//        String birth=request.getParameter("birth");



        String sql = "Insert into usertable(id,username,password,email,gender,birthdate) values(?,?,?,?,?,?)";
            try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,"");
            p.setString(2,"");
            p.setString(3,"");
            p.setString(4,"");
            p.setString(5,"");
            p.setString(6,"");
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html charset=utf-8");
        PrintWriter out=response.getWriter();
        String sql1 = "select * from usertable ";
        try {
            ResultSet re = con.createStatement().executeQuery(sql1);
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<td>"+"id"+"</td>");
            out.println("<td>"+"username"+"</td>");
            out.println("<td>"+"password"+"</td>");
            out.println("<td>"+"email"+"</td>");
            out.println("<td>"+"gender"+"</td>");
            out.println("<td>"+"birthdate"+"</td>");
            out.println("</tr>");
            while (re.next()) {

                out.println("<tr>");
                out.println("<td>"+re.getInt("id")+"</td>");
                out.println("<td>"+re.getString("username")+"</td>");
                out.println("<td>"+re.getString("password")+"</td>");
                out.println("<td>"+re.getString("email")+"</td>");
                out.println("<td>"+re.getString("gender")+"</td>");
                out.println("<td>"+re.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}