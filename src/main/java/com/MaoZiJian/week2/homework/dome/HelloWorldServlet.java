package com.MaoZiJian.week2.homework.dome;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter writer=response.getWriter();
        writer.println("Name : MaoZiJian");
        writer.println("Id : 2022211001000215");
        Date currentDate = new Date();
        writer.println("Date and Time : " + currentDate.toString());
        writer.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {

    }

}
