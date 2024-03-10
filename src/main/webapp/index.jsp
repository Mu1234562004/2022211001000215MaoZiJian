<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div>
  <input type="radio" id="male" name="gender" value="male" required style="display: inline;">
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="female" style="display: inline;">
  <label for="female">Female</label>
</div>
</body>
</html>