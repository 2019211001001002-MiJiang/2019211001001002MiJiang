
package main.java.com.MiJiang.week5;

import main.java.com.MiJiang.dao.UserDao;
import main.java.com.MiJiang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//
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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String UserName = request.getParameter("name");
        String PassWord = request.getParameter("password");
        PrintWriter out = response.getWriter();
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,UserName,PassWord);
            if (user != null) {
                String rememberMe=request.getParameter("remember");
                if("1".equals(rememberMe)&&rememberMe!=null){

                    Cookie passwordCookie=new Cookie("cPassword", URLEncoder.encode(user.getPassword(),"UTF-8"));
                    passwordCookie.setMaxAge(10*60);
                    response.addCookie(passwordCookie);
                    Cookie rememberMeCookie=new Cookie("cRememberMe", URLEncoder.encode(rememberMe,"UTF-8"));
                    rememberMeCookie.setMaxAge(10*60);
                    response.addCookie(rememberMeCookie);
                    Cookie usernameCookie=new Cookie("cUsername", URLEncoder.encode(user.getUsername(),"UTF-8"));
                    usernameCookie.setMaxAge(10*60);
                    response.addCookie(usernameCookie);
                }
                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "username or password error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /* try {
            String sql1 = "select * from utable3 WHERE username='" + UserName + "' AND password='" + PassWord + "';";
            ResultSet rs = con.createStatement().executeQuery(sql1);
            if (rs.next()) {
////                out.println("Login Success!!!");
////                out.println("Welcome "+UserName+".");
////                request.setAttribute("id",rs.getString("id"));
////                request.setAttribute("username",rs.getString("username"));
////                request.setAttribute("password",rs.getString("password"));
////                request.setAttribute("email",rs.getString("email"));
////                request.setAttribute("gender",rs.getString("gender"));
////                request.setAttribute("birthdate",rs.getString("birthdate"));
////                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            }else{
//                out.print("Username or Password Error!!!");
//                request.setAttribute("message","username or password error!");
//                request.getRequestDispatcher("Login.jsp").forward(request,response);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}

