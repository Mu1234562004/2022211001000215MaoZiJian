<%--
  Created by IntelliJ IDEA.
  User: 大剑
  Date: 2024/3/10
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register.jsp</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"],

        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        small {
            color: #999;
        }
    </style>
</head>
<body>
<h1>User Registration</h1>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required minlength="8">
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="birthdate">Birthdate:</label>
        <input type="text" id="birthdate" name="birthdate" required pattern="\d{4}-\d{2}-\d{2}">
        <small>Format: yyyy-mm-dd</small>
    </div>
    <div>
        <input type="submit" value="Register">
    </div>

</body>
</html>