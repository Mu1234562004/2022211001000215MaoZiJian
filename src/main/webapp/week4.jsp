<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>A Servlet</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
</style>
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthdate</th>
    </tr>
    <%
        String url = "jdbc:sqlserver://localhost;databaseName=userdb;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "maozijian2004";
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM usertable";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");
            String email1 = rs.getString("email");
            String gender1 = rs.getString("gender");
            Date birthdate1=rs.getDate("birthdate");
    %>
    <tr>
        <td><%= id %></td>
        <td><%= username1 %></td>
        <td><%= password1 %></td>
        <td><%= email1 %></td>
        <td><%= gender1 %></td>
        <td><%= birthdate1 %></td>
    </tr>
    <%
        }
        rs.close();
        stmt.close();
        conn.close();
    %>
</table>
</body>
</html>