package com.MaoZiJian.week3.dome;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.out;

@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    java.sql.Connection con = null;
    public void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder htmlBuilder = new StringBuilder();
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username1 = context.getInitParameter("username");
        String password1 = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username1, password1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        String sql = "INSERT INTO usertable (username, password,email,gender,birthdate) VALUES (?, ?,?,?,?)";
        try {

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, gender);
            statement.setString(5, birthdate);
            statement.executeUpdate();
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*Statement stmt = null;
        String query = "SELECT * FROM usertable";
        ResultSet rs;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        htmlBuilder.append("<html><body>");
        htmlBuilder.append("<table border='1'>");
        htmlBuilder.append("<tr>");
        htmlBuilder.append("<th>ID</th>");
        htmlBuilder.append("<th>username</th>");
        htmlBuilder.append("<th>password</th>");
        htmlBuilder.append("<th>email</th>");
        htmlBuilder.append("<th>gender</th>");
        htmlBuilder.append("<th>birthdate</th>");
        htmlBuilder.append("</tr>");
        while (true) {
            try {
                if (!rs.next())
                {
                    break;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int id;
            String username2;
            Date birthdate1;
            String gender1;
            String email1;
            String password2;
            try {
                id = rs.getInt("id");
                username2 = rs.getString("username");
                password2 = rs.getString("password");
                email1 = rs.getString("email");
                gender1 = rs.getString("gender");
                birthdate1 = rs.getDate("birthdate");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            htmlBuilder.append("<tr>");
            htmlBuilder.append("<td>").append(id).append("</td>");
            htmlBuilder.append("<td>").append(username2).append("</td>");
            htmlBuilder.append("<td>").append(password2).append("</td>");
            htmlBuilder.append("<td>").append(email1).append("</td>");
            htmlBuilder.append("<td>").append(gender1).append("</td>");
            htmlBuilder.append("<td>").append(birthdate1).append("</td>");
            htmlBuilder.append("</tr>");
            }
            htmlBuilder.append("</table>");
            htmlBuilder.append("</table>");
            htmlBuilder.append("</body></html>");
            String html = htmlBuilder.toString();
            out.println(html);

    }
        public void init () throws ServletException {
            ServletContext context = getServletContext();
            String driver = context.getInitParameter("driver");
            String url = context.getInitParameter("url");
            String username = context.getInitParameter("username");
            String password = context.getInitParameter("password");
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}

         */
    }}



