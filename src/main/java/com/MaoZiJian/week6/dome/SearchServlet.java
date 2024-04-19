package com.MaoZiJian.week6.dome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtValue = request.getParameter("txt");
        String searchValue = request.getParameter("search");
        if ("baidu".equals(searchValue)) {
            String encodedValue = URLEncoder.encode(txtValue, "UTF-8");
            response.sendRedirect("https://www.baidu.com/s?wd=" + encodedValue);
        } else if ("google".equals(searchValue)) {
            String encodedValue1 = URLEncoder.encode(txtValue, "UTF-8");
            response.sendRedirect("https://cn.bing.com/?form="+encodedValue1);
        } else if ("bing".equals(searchValue)) {
            String encodedValue3 = URLEncoder.encode(txtValue, "UTF-8");
            response.sendRedirect("https://www.bing.com/s?wd="+encodedValue3);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
