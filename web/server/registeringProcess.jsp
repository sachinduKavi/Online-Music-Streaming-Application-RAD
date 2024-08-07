<%-- 
    Document   : registerProcess
    Created on : Jul 29, 2024, 5:08:58 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="app.classes.MD5"%>
<%@page import="app.classes.User"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! String message = "Database insertion failed";%>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");
    String password = request.getParameter("password");
    String rePassword = request.getParameter("repass");

    if(password.equals(rePassword)) {
        // Password matched
        User user = new User(name, email, MD5.getMd5(password), country);
        if(user.saveValues()) {
            
            // Database values saved successfully 
            message = "Insertion successful";
            response.sendRedirect("../index.jsp?message=" + message.replace(" ", "+"));
            return;
        } 
    } else {
        // Password does not match
        message = "Passwords do not match";
        response.sendRedirect("../registrationPage.jsp?message=" + message.replace(" ", "+"));
    }
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=message%></h1>
    </body>
</html>
