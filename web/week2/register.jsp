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
<form>
    New User Registration<br/><br/>
    Username<input type="text" name="name" required="true"><br/><br/>
    Password<input type="password" name="pwd" required="true" minlength="8"><br/><br/>
    email<input type="email" name="email" required="true"><br/><br/>
    Gender
    Male<input type="radio">
    Female<input type="radio"><br/><br/>
    Date of birth(yyyy-mm-dd)<input type="date" pattern="yyyy-mm-dd" required="true"><br/><br/>

    <input type="submit" value="Register">
</form>
</body>
</html>

