<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%= "Weclome to my home page" %></h1>
<h1>All Cookie</h1>
<%
    Cookie[] allCookie=request.getCookies();
    if(allCookie!=null) {

        for (Cookie cookie : allCookie) {
            String cName = cookie.getName();
            String cValue = cookie.getValue();
            out.println("<br>" + cName + "----" + cValue);
        }
    }
%>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size=30>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login">login-week5</a>
<br/>
<%@include file="footer.jsp"%>
