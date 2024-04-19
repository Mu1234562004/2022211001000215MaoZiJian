<%@ page import="com.MaoZiJian.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 大剑
  Date: 2024/4/7
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>
    User Info
</h1>
<%
    User user=(User) session.getAttribute("user");
%>
<table>
    <tr><td>Id:</td><td><%=user.getId()%></td></tr>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=user.getBirthdate()%></td></tr>
    <tr><a href="updateUser">Update User</a> </tr>
</table>
<%@include file="footer.jsp"%>