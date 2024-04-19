<%--
  Created by IntelliJ IDEA.
  User: 大剑
  Date: 2024/4/17
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
    }

    h1 {
        text-align: center;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
    }

    label {
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    input[type="radio"] {
        display: inline;
    }

    input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
</style>
<%
    User user=(User) session.getAttribute("user");
%>
<form action="http://localhost:8080/MaoZiJian2022211001000215_war/updateUser" method="post" >
    <input type="hidden" name="id" value="<%=user.getId()%>">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="<%=user.getUsername()%>"required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="<%=user.getPassword()%>"required minlength="8"><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%=user.getEmail()%>"required><br>
    <div>
        <input type="radio" id="male" name="gender" value="male" <%="male".equals(user.getGender())?"checked":""%>required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="female"<%="female".equals(user.getGender())?"checked":""%>>
        <label for="female">Female</label>
    </div>
    <label for="birthdate">Birthdate:</label>
    <input type="text" id="birthdate" name="birthdate" value="<%=user.getBirthdate()%>"required pattern="\d{4}-\d{2}-\d{2}"><br>
    <input type="submit" value="Save Change">
</form>
<%@include file="footer.jsp"%>
