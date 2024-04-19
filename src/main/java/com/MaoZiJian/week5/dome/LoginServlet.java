package com.MaoZiJian.week5.dome;

import com.MaoZiJian.dao.UserDao;
import com.MaoZiJian.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    java.sql.Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        /*ServletContext context = getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try{
            Class.forName(driver);
            con=  DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        UserDao userDao=new UserDao();
        try {
           User user= userDao.findByUsernamePassword(con,username,password);
           if(user!=null)
           {
               String rememberMe=request.getParameter("rememberMe");
               if(rememberMe!=null && rememberMe.equals("1"))
               {
                   Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                   Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                   Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                   usernameCookie.setMaxAge(5);
                   passwordCookie.setMaxAge(5);
                   rememberMeCookie.setMaxAge(5);
                   response.addCookie(usernameCookie);
                   response.addCookie(passwordCookie);
                   response.addCookie(rememberMeCookie);

               }
               Cookie cookie = new Cookie("sessionid",""+user.getId());
               cookie.setMaxAge(7*24*60*60);
               response.addCookie(cookie);
               HttpSession session=request.getSession();
               System.out.println("session id:"+session.getId());
               session.setMaxInactiveInterval(60);
               //session.invalidate();
               //request.setAttribute("user",user);
               session.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);



           }else {
               request.setAttribute("message","Username or Password Error");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






       /* String sql = "SELECT * FROM usertable WHERE username=? AND password=?";
        try {

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birthdate",resultSet.getString("birthdate"));
                //PrintWriter writer=response.getWriter();
                //writer.println("<b><font size=\"5\">Login Success!!!</font></b><br>");
               // writer.println("<b><font size=\"5\">Welcome, MaoZiJian</font></b>");
               // writer.close();
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else {
                request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/


    }

}
