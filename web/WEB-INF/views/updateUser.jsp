<%@ page import="main.java.com.MiJiang.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/4/21
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>


<%User u=null;
    if(session.getAttribute("userInfo")!=null) {
        u = (User)session.getAttribute("userInfo");
        pageContext.setAttribute("userInfo",u);
    }
%>
<form method="post" action="updateUser">


    id<input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="name" required="true" value="<%=u.getUsername()%>"/><br/><br/>
    password<input type="password" name="pwd" required="true" value="<%=u.getPassword()%>"/><br/><br/>
    email<input type="text" name="email" required="true"value="<%=u.getEmail()%>"/><br/><br/>
    gender
    Male<input type="radio" name="sex" value="male" <%="male".equals(u.getGender())?"checked":""%>/>
    Female<input type="radio" name="sex" value="female"<%="female".equals(u.getGender())?"checked":""%>/><br/><br/>
    Date of birth(yyyy-mm-dd)<input type="text"  required="true" name="birth" value="<%=u.getBirthdate()%>"/><br/><br/>

    <input type="submit" value="Register"/>

    </form>
<body>
<%
     session.setAttribute("userInfo",u);
%>
<%@include file="footer.jsp"%>