<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/2
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>




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