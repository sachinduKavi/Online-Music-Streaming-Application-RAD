<%-- 
    Document   : player
    Created on : Jul 18, 2024, 1:25:27 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="java.util.List"%>
<%@page import="app.classes.User"%>
<%@page import="app.classes.Music"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%   
    
// Load current user
String musicID = request.getParameter("musicID");
HttpSession sessionValue = request.getSession();

// Rediecting back to login page if session is not present
if(sessionValue.getAttribute("user") == null) {
    response.sendRedirect("index.jsp");
    return;
} 

// New user object
User user = (User)sessionValue.getAttribute("user");
user.fetchUserDetails();
    
// Load all favoutite music 
List<Music> musicList = Music.fetchFavouriteMusic(user.getUserID());

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/playlist.css">
        
    </head>
    <body>
        
        <div class="navigation-bar">
            <div class="min-container">
                <img src="assets/icons/logo.png" alt="logo-image" width="50%"/>
            
                <h2>MUSIC STREAMING</h2>
                <h4><%=user.getUserName() %></h4>
                <h3><%=user.getEmail() %></h3>
                <h5><%=user.getUserID() %></h5>

            </div>


            <div class="navigation-elements">
                <ul>
                    <li>Music Gallery</li>
                    <li><a href="playlist.jsp">My Playlist</a></li>
                    <li><a href="player.jsp">Music Player</a></li>
                    <li>About</li>
                </ul>
                    

            </div>


                <button class="logout-btn" onclick="logout()">LOGOUT</button>
            
        </div>

        <div class="container">
            <div class="inside-container">
                <h1>MY MUSIC PLAYLIST</h1>
                
                

                <div class="banner-container">
                    <%!int colorDec;%>
                    <%
                    colorDec = 1127013;
                    for(int i = 0; i < musicList.size(); i++) {
                        Music music = musicList.get(i);
                    %>
                    <div class="music-banner" style="background-color: #<%=Integer.toHexString(colorDec) %>">
                        
                        <div class="column cover-column">
                            <div class="cover-image"
                            style="background: url('<%= music.getCoverURL() %>'); background-position: center; background-size: cover;"
                            ></div>   
                        </div> 

                        <div class="column details-column" onclick="goToMusic('<%=music.getMusicID()%>')"  >
                            <h2><%=music.getMusicName() %></h2>
                            <h4><%=music.getArtistName() %></h4>
                        </div>

                        <div class="column more-details">
                            <h3><%=music.getLanguage()%></h3>
                        </div>

                        <div class="column more-details">
                            <h3><%=music.getRating() %></h3>
                        </div>

                        <div class="column end-column">
                            <button onclick="unSaveMusic('<%=music.getMusicID()%>')" style="background-color: transparent; border: 0">
                                <img src="assets/icons/remove.png" alt="remove-icon" width="40px">
                            </button>
                            
                        </div>

                    </div>
                     <%
                        colorDec += 250;
                        }
                        %>
                </div>
                    
                   


            </div>
           

        </div>
        
    </body>
    <script>
        function goToMusic(musicID) {
            console.log(musicID)
            window.location.href = `player.jsp?musicID=` + musicID
        }

        function unSaveMusic(musicID) {
            console.log('click on hello', musicID)
            fetch('unsaveMusic.jsp?musicID=' + musicID + '&userID=' + '<%=user.getUserID() %>').then(success => {
                window.location.href = 'playlist.jsp'
            })
        }
        
        function logout() {
            window.location.href = 'server/logout.jsp'
        }

    </script>
   
</html>
