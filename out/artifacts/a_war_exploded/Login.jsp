<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/2
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@include file="header.jsp"%>--%>
<%--<html>--%>
<%--<head>--%>

<%--</head>--%>
<%--<body>--%>
<%--<form method="post" action="Login">--%>
<%--    <h1>Login</h1><br/><br/>--%>
<%--&lt;%&ndash;    &lt;%&ndash;%>--%>
<%--&lt;%&ndash;        if(!(request.getAttribute("message")==null)){&ndash;%&gt;--%>
<%--&lt;%&ndash;            out.println("<h3>"+request.getAttribute("message")+"</h3>");&ndash;%&gt;--%>
<%--&lt;%&ndash;        }&ndash;%&gt;--%>
<%--&lt;%&ndash;    %>&ndash;%&gt;--%>
<%--    UserName<input type="text" name="username" required="true"><br/><br/>--%>
<%--    PassWord<input type="password" name="password" required="true" minlength="8"><br/><br/>--%>
<%--    <input type="submit" value="Login">--%>

<%--</form>--%>
<%--<%@include file="footer.jsp"%>--%>
<%--</body>--%>
<%--</html>--%>
<%@include file="header.jsp" %>
Login <br>
<%
    if(request.getAttribute("message") != null)
    {
        out.println("<h3 >"+request.getAttribute("message")+"</h3>");
    }
%>

<form method="post" action="Login">
    <p>Username:<input type="text" name="name"/></p>

    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>