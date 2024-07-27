<%-- 
    Document   : changeSavedMusic
    Created on : Jul 25, 2024, 9:54:11 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="java.sql.*"%>
<%@page import="app.classes.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <%
        Connection conn = DbConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO play_list (user_ID, music_ID) VALUES (?, ?)");
            stmt.setString(1, request.getParameter("userID"));
            stmt.setString(2, request.getParameter("musicID"));
            
            stmt.executeUpdate();
        } catch(Exception e) {
            
        }
        
        %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    
    <script>
//        window.close()
    </script>
</html>
