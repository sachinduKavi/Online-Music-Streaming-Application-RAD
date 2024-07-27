<%-- 
    Document   : inputMusicData
    Created on : Jul 21, 2024, 12:46:07 PM
    Author     : Sachindu Kavishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BeatBox</title>
       <link rel="stylesheet" href="css/common.css">
       <link rel="stylesheet" href="css/new-music.css">
    </head>
    <body>


        <div class="container">
            <h1>Add New Music Data</h1>
        <form method="post" action="processAddMusic">
        <table cellpadding="5">
         
            <tbody>
                <tr>
                    <th>Music Name</th>
                    <th>: <input type="text" name="music-name"/></th>
                </tr>
                <tr>
                     <th>Artist Name</th>
                    <th>: <input type="text" name="artist-name"/></th>
                </tr>
                <tr>
                     <th>Rating </th>
                    <th>: <input type="text" name="rating"/></th>
                </tr>
                <tr>
                     <th>Source URL</th>
                    <th>: <input type="text" name="source-url"/></th>
                </tr>
                <tr>
                     <th>Cover Image URL</th>
                    <th>: <input type="text" name="cover-url"/></th>
                </tr>
                <tr>
                     <th>Language</th>
                    <th>: <input type="text" name="language"/></th>
                </tr>
       
            </tbody>
        </table>
            
            <button type="submit" class="submit-btn">Create new record</button>
    </form>
        </div>
        
    </body>
</html>
