<%@ page import="main.java.com.MiJiang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Info</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=user.getBirthdate()%></td></tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>
