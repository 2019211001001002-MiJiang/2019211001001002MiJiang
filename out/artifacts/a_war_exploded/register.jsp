<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/3/13
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<form method="post" action="register">
    New User Registration<br/><br/>
<%--    id<input type="text" name="id" required="true"><br/><br/>--%>
    username<input type="text" name="name" required="true"><br/><br/>
    password<input type="password" name="pwd" required="true"><br/><br/>
    email<input type="text" name="email" required="true"><br/><br/>
    gender
    Male<input type="radio" name="sex" value="male">
    Female<input type="radio" name="sex" value="female"><br/><br/>
    Date of birth(yyyy-mm-dd)<input type="text"  required="true" name="birth"><br/><br/>

    <input type="submit" value="Register">

    <form/>
<%@include file="footer.jsp"%>
</body>
</html>
