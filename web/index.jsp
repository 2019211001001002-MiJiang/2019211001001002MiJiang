<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/3/13
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%@include file="header.jsp"%>
<%--  <h1><%="Welcome to my home page." %></h1><br/>--%>


<%--  <br/>--%>
<%--  <a href="hello-servlet">hello servelt-week1</a>--%>
<%--  <br/>--%>
<%--  <a href="hello">Student info Servelt-week2</a>--%>
<%--  <br/>--%>
<%--  <a href="Life">Life Cycle Servelt-week3</a>--%>
<%--  <br/>--%>
<%--  <a href="register.jsp">Register-getParameter-week3</a>--%>
<%--  <br/>--%>
<%--  <a href="config">Config parameter-week4</a>--%>
<%--  <br/>--%>
<%--  <a href="register.jsp">Register JDBC-week4</a>--%>
<%--  <br/>--%>
<%--  <a href="index.jsp">include-week5</a>--%>
<%--  <br/>--%>
<%--  <a href="login.jsp">Login-week5</a>--%>
<%--  <br/>--%>
  <h2>welcome to my online shop home page.</h2>
  <form method="get" target="_blank" action="Search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
      <option value="baidu">Baidu</option>
      <option value="bing">Bing</option>
      <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
  </form>
  <%@include file="footer.jsp"%>
  </body>
</html>
