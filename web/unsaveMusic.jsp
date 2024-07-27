<%-- 
    Document   : unsaveMusic
    Created on : Jul 25, 2024, 10:24:34 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="java.sql.*"%>
<%@page import="app.classes.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        Connection conn = DbConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from play_list where music_ID = ? and user_ID = ?");
            stmt.setString(2, request.getParameter("userID"));
            stmt.setString(1, request.getParameter("musicID"));
            
            stmt.executeUpdate();
        } catch(Exception e) {
            
        }
        
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
