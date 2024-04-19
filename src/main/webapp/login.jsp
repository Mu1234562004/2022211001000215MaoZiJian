<%@ page import="java.io.PrintWriter" %><%--
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
        String errorMessage = (String) request.getAttribute("message");
%>
<script>
    alert("<%= errorMessage %>");
</script>
<%
    }
%>
<body>
<h2>Login</h2>
<form action="http://localhost:8080/MaoZiJian2022211001000215_war/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
</body>
</html>