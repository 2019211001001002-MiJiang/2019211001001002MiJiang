<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/2
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form method="post" action="Login">

    <%@include file="header.jsp"%>


    <h1>Login</h1><br/><br/>
    UserName<input type="text" name="username" required="true"><br/><br/>
    PassWord<input type="password" name="password" required="true" minlength="8"><br/><br/>
    <input type="submit" value="Login">
    <%@include file="footer.jsp"%>
</form>
</body>
</html>
