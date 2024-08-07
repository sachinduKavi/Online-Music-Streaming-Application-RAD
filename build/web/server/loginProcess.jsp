<%-- 
    Document   : loginProcess
    Created on : Jul 29, 2024, 4:41:49 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="app.classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!String message; %> 
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    // Creating user instant
    if(email != null && password != null) {
        User user = new User(email, password);
        if(user.userAuthentication()) {
            // User authentication success
            message = "success";
            // Creating session 
            HttpSession sessionValue = request.getSession();
            sessionValue.setAttribute("user", user);
            
            // Creating a cookie if remember me option is enable
            System.out.println("Remember me function " + request.getParameter("remember"));
            if(request.getParameter("remember") != null) {
                // Setting up the token in the cookie
                String randomToken = User.generateRandomToken(128);
                // Making a cookie 
                Cookie cookie = new Cookie("user_token", randomToken);
                cookie.setMaxAge(2592000);
                cookie.setPath("/");
                response.addCookie(cookie); // Adding cookie 
                user.updateUserToken(randomToken); // Updating token in the database
            }
            
            response.sendRedirect("../player.jsp");
            // Redirecting to the dashboard
        } else {
            // User authentication faild 
            message = "Invalid user name or password";
            response.sendRedirect("../index.jsp?message=" + message.replace(" ", "+"));
        }
    } else {
        // Empty fields 
        message = "Empty fields";
        response.sendRedirect("../index.jsp?message=" + message.replace(" ", "+"));
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
