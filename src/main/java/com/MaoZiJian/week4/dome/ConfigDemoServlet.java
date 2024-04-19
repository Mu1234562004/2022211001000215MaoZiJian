package com.MaoZiJian.week4.dome;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        name = "ConfigDemoServlet",
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name1",value = "MaoZiJian"),
                @WebInitParam(name="studentId1",value = "2022211001000215")
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();

        String name = config.getInitParameter("name");
        String studentId = config.getInitParameter("studentId");
        String name1 = getServletConfig().getInitParameter("name1");
        String studentId1 = getServletConfig().getInitParameter("studentId1");

        PrintWriter writer=response.getWriter();
        writer.println("<h1><strong>Task 1-Get init parameters from web.xml</strong></h1>");
        writer.println("<br>name :"+name);
        writer.println("<br>studentId :"+studentId);
        writer.println("<h1><strong>Task 2-Get init parameters from @WebServlet</strong></h1>");
        writer.println("<br>name :"+name1);
        writer.println("<br>studentId :"+studentId1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
