package main.java.com.MiJiang.week3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/register")

public class RegisterServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {

//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("init()-->" + con);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        con=(Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");



        try {
            response.setContentType("text/html charset=utf-8");

            String sql ="insert into utable3(username,password,email,gender,birthdate) values(?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(sql);
            //pstmt.setInt(1, id);
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            pstmt.setString(3, email);
            pstmt.setString(4, sex);
            pstmt.setString(5, birth);
            pstmt.executeUpdate();

           // PrintWriter out=response.getWriter();
//            String sql1 = "select * from utable3 ";
//            ResultSet re = createDbStatement.executeQuery(sql1);
//            out.println("<table border='1' align='center'>");
//            out.println("<tr>");
//            out.println("<td>"+"id"+"</td>");
//            out.println("<td>"+"username"+"</td>");
//            out.println("<td>"+"password"+"</td>");
//            out.println("<td>"+"email"+"</td>");
//            out.println("<td>"+"gender"+"</td>");
//            out.println("<td>"+"birthdate"+"</td>");
//            out.println("</tr>");
//            while (re.next()) {
//
//                out.println("<tr>");
//                out.println("<td>"+re.getString("id")+"</td>");
//                out.println("<td>"+re.getString("username")+"</td>");
//                out.println("<td>"+re.getString("password")+"</td>");
//                out.println("<td>"+re.getString("email")+"</td>");
//                out.println("<td>"+re.getString("gender")+"</td>");
//                out.println("<td>"+re.getString("birthdate")+"</td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    response.sendRedirect("login");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
        }

        }
