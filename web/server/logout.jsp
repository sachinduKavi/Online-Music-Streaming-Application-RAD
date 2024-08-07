<%-- 
    Document   : logout
    Created on : Jul 29, 2024, 6:40:53 PM
    Author     : Sachindu Kavishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
HttpSession sessionValue = request.getSession();
sessionValue.invalidate();
// Removing cookie 
Cookie cookie = new Cookie("user_token", "");
cookie.setMaxAge(0);
cookie.setPath("/");

response.addCookie(cookie); // Distory the cookie
response.sendRedirect("../");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
