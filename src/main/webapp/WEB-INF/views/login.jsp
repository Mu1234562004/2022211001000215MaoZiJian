<%@ page import="java.io.PrintWriter" %>
<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: 大剑
  Date: 2024/3/29
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<%@include file="header.jsp"%>
<%
    if(!(request.getAttribute("message")==null))
    {

        PrintWriter writer=response.getWriter();
        writer.println("<h3 style='margin-top: 20px;'>"+request.getAttribute("message")+"<h3>");


    }
%>
<%
    Cookie[] allCookies= request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null)
    {
        for(Cookie cookie:allCookies)
        {
            if(cookie.getName().equals("cUsername"))
            {
                username=cookie.getValue();
            }
            if(cookie.getName().equals("cPassword"))
            {
                password=cookie.getValue();
            }
            if(cookie.getName().equals("cRememberMe"))
            {
                rememberMeVale=cookie.getValue();
            }
        }
    }
%>



<h2>Login</h2>
<form action="http://localhost:8080/MaoZiJian2022211001000215_war/login" method="post">
    Username : <input type="text" id="username" name="username" value="<%=username%>" required><br/>
    Password : <input type="password" id="password" name="password" value="<%=password%>" required><br/>
    <input type="checkbox" id="rememberMe" name="rememberMe" value="1" <%= rememberMeVale.equals("1") ? "checked" : "" %> />RememberMe<br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
</html>