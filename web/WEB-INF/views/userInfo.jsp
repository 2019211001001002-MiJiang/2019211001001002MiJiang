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
<%User u=null;
    if(session.getAttribute("userInfo")!=null) {
    u = (User) session.getAttribute("userInfo");

    }
    if(session.getAttribute("userInfo")==null&&session.getAttribute("user")!=null) {
        u = (User) session.getAttribute("user");

    }
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u.getBirthdate()%></td></tr>
</table>
<a href="updateUser?id=<%=u.getId()%>">update</a>

</body>
<%@include file="footer.jsp"%>
</html>
