<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
					<h2>Login to your account</h2>
 <%
    if(!(request.getAttribute("message")==null)){
    out.println("<h2>"+request.getAttribute("message")+"</h2>");
}%>
<%
                            Cookie allCookies[]=request.getCookies();
                            String username="";String password="";String rememberMe="";
                            if(allCookies!=null){
                                for(Cookie c:allCookies){
                                    if("cUsername".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                                        username= URLDecoder.decode(c.getValue(),"utf-8");
                                    }
                                    if("cPassword".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                                        password=URLDecoder.decode(c.getValue(),"utf-8");
                                    }
                                    if("cRememberMe".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                                        rememberMe=URLDecoder.decode(c.getValue(),"utf-8");
                                    }
                                }
                            }
 %>

<%--        <%--%>
<%--            basePath="WEB-INF/views";--%>
<%--        %>--%>


<form method="post" action="<%=request.getContextPath()+"/login"%>">
    <input type="text" name="name" placeholder="Username" value="<%=username%>"><br>
   <input type="password" name="password" placeholder="password" value="<%=password%>">
    <br/>
    <span>
		<input type="checkbox" class="checkbox" name="remember" value="1" <%="1".equals(rememberMe)? "checked":""%>/> Keep me signed in
   </span>
    <button type="submit" class="btn btn-default">Login</button>
</form>	
					</div><!--/login form-->
				</div>
				
				
			</div>
		</div>
	</section><!--/form-->
<%@include file="footer.jsp"%>
