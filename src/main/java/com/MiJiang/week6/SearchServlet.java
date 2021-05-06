package main.java.com.MiJiang.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet" ,value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String txt=request.getParameter("txt");

         String search=request.getParameter("search");

        if(txt==null){
            response.sendRedirect("index.jsp");
        }else {

            if("baidu".equals(search)){

                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if("bing".equals(search)){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if("google".equals(search)) {
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }
          }
    }
}
