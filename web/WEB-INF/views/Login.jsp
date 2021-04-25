<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/2
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>




<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
Login <br>
<%
    if(request.getAttribute("message") != null)
    {
        out.println("<h3 >"+request.getAttribute("message")+"</h3>");
    }
%>
<%
    Cookie allCookies[]=request.getCookies();
    String username="";String password="";String rememberMeval="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if("cUsername".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                username=URLDecoder.decode(c.getValue(),"utf-8");

            }
            if("cPassword".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                password=URLDecoder.decode(c.getValue(),"utf-8");
            }
            if("cRememberMe".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                rememberMeval=URLDecoder.decode(c.getValue(),"utf-8");
            }
        }
    }
%>
<form method="post" action="Login">
    <p>Username:<input type="text" name="name" value="<%=username%>"/></p>
    <p>Password:<input type="password" name="password" value="<%=password%>"/></p>
    <p><input type="checkbox" name="rememberMe" value="1" <%="1".equals(rememberMeval)?"checked":""%>/>RememberMe</p>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
