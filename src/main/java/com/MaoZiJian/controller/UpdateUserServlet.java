package com.MaoZiJian.controller;

import com.MaoZiJian.dao.UserDao;
import com.MaoZiJian.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet",value ="/updateUser" )

public class UpdateUserServlet extends HttpServlet {
    java.sql.Connection con=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        int id= Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("birthdate");

        // 2. 创建一个用户模型
        User user = new User();

        // 3. 将参数值设置到用户模型中
        user.setEmail(email);
        user.setGender(gender);
        user.setPassword(password);
        user.setBirthdate(birthdate);
        user.setId(id);
        user.setUsername(username);

        // 4. 创建一个UserDao对象
        UserDao userDao = new UserDao();

        try {
            userDao.updateUser(con,user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        HttpSession session=req.getSession();
        session.setMaxInactiveInterval(60);
        session.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);
    }
}
