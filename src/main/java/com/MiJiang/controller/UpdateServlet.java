package main.java.com.MiJiang.controller;

import main.java.com.MiJiang.dao.UserDao;
import main.java.com.MiJiang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet" ,value="/updateUser")
public class UpdateServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();

        con=(Connection)getServletContext().getAttribute("con");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("id"));
        String UserName = request.getParameter("name");
        String PassWord = request.getParameter("pwd");
        String Email = request.getParameter("email");
        String Sex = request.getParameter("sex");
        Date Birth = Date.valueOf(request.getParameter("birth"));
        User user=new User(Id,UserName,PassWord,Email,Sex,Birth);
        /*request.setAttribute("id",user.getId());
        request.setAttribute("username",user.getUsername());
        request.setAttribute("password",user.getPassword());
        request.setAttribute("email",user.getEmail());
        request.setAttribute("gender",user.getGender());
        request.setAttribute("birthdate",user.getBirthdate());
        */
        UserDao userDao=new UserDao();

        try {
           int n= userDao.updateUser(con,user);
            if(n==1) {
                HttpSession session=request.getSession();
                session.setAttribute("userInfo", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            }else {
                System.out.println("update error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));


            UserDao UserDao = new UserDao();
            try {
                User u = UserDao.findById(con,id);
                HttpSession session=request.getSession();
                session.setAttribute("userInfo", u);
                //request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
                request.getRequestDispatcher("accountDetails").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();

        }








    }
}
