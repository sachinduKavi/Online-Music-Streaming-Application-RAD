<%-- 
    Document   : player
    Created on : Jul 18, 2024, 1:25:27 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="app.classes.User"%>
<%@page import="app.classes.Music"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
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


if(musicID == null) {
    if(sessionValue.getAttribute("current-music") != null) {
       musicID = (String)sessionValue.getAttribute("current-music");
    } else 
    musicID = "MU0000000000000001";
}
Music music = new Music(musicID);
music.fetchValuesFromDatabase(); // Fetch values from database

// Check whether music is fav
boolean favState = music.favCheck(user.getUserID());


// Set volume 
int volume = (request.getParameter("v") != null)? Integer.valueOf(request.getParameter("v")): 90;

// Update session current music ID
session.setAttribute("current-music", musicID);


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/player.css">
        
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
                    <li><a href="musicGallery.jsp">Music Gallery</a></li>
                    <li><a href="playlist.jsp">My Playlist</a></li>
                    <li><a href="player.jsp">Music Player</a></li>
                    <li>About</li>
                </ul>
                    

            </div>


                <button class="logout-btn" onclick="logout()">LOGOUT</button>
            
        </div>

        <div class="container">
             <div class="row">
                <h3>Now Playing....</h3>
                <h1 class="music-title"><%=music.getMusicName() %></h1>
                <h3 class="artist-name"><%=music.getArtistName() %></h3>
             </div>

             <div class="row player-row">
                <div class="cover-image column" style="background: url('<%=music.getCoverURL()%>'); background-size: cover; background-repeat: no-repeat; background-position: center">

                </div>
                 

                <div class="music-description column">
                    <label for="">Music Name:</label>
                    <h3><%=music.getMusicName() %></h3>

                    <label for="">Artist</label>
                    <h3><%=music.getArtistName() %></h3>

                    <label for="">Duration</label>
                    <h3 id="duration"></h3>
                    
                    <label for="">Rating</label>
                    <h3><%=music.getRating() %></h3>
                    
                    <label for="">Language</label>
                    <h3><%=music.getLanguage() %></h3>
                </div>
                 
             </div>

            <div class="row music-controls">
                 <audio src="<%=music.getSourceURL()%>" autoplay="1" controls id="audio" style="visibility: hidden"></audio>
                
                 <input type="range" value="0" max="100" class="seek-bar" id="seek-bar">
                

                 <div class="controller"> 


                    <div class="more-options left-contoler mini-controller">
                        <button class="control-btn" id='save-btn'><img src="assets/icons/like.png" alt="" width="30px" id='save-icon'></button>
                        <button class="control-btn" id="stop-btn"><img src="assets/icons/stop.png" alt="" width="30px"></button>
                        
                    </div>

                    <button class="control-btn" onclick="changePrev()"><img src="assets/icons/previous.png" alt="" width="50px"></button>
                    <button class="control-btn" id="play-pause"><img src="assets/icons/play.png" alt="" width="70px" id="play-icon"></button>
                    <button class="control-btn" onclick="changeNext()"><img src="assets/icons/next.png" alt="" width="50px"></button>
                    
                    <div class="volume-controller mini-controller">
                        <label for="">Volume</label>
                        <input type="range" id="volume-bar" max="100" value="<%=volume %>">
                    </div>
                 </div>
            </div>

        </div>
        
    </body>

    <script>
        
        function saveMusic() {
            console.log('music saved')
//            window.open('changeSavedMusic.jsp')
            fetch("changeSavedMusic.jsp?userID=<%=user.getUserID()%>&musicID=<%=music.getMusicID()%>").then(success => {
                console.log(success);
            }).catch(e => {
                console.log(e)
            })
        }
        
        
        function unsaveMusic() {
            console.log('unsave music')
            fetch("unsaveMusic.jsp?userID=<%=user.getUserID()%>&musicID=<%=music.getMusicID()%>").then(success => {
                console.log(success);
            }).catch(e => {
                console.log(e)
            })
        }
            
        
        function changeNext() {
            window.location.href = 'player.jsp?musicID=<%=music.getNextRecord() %>&v=' + document.getElementById('volume-bar').value
        }
        
        function changePrev() {
            window.location.href = 'player.jsp?musicID=<%=music.getPreviousRecord() %>&v=' + document.getElementById('volume-bar').value
        }
        

        document.addEventListener('DOMContentLoaded', () => {
            const audio = document.getElementById('audio')
            const seekBar = document.getElementById('seek-bar')
            const volumeBar = document.getElementById('volume-bar')
            
            const stopBtn = document.getElementById('stop-btn')
            const saveBtn = document.getElementById('save-btn')

            audio.volume = '<%=volume*0.01 %>'
            
            let saveState = <%=favState %>
            if(saveState) {
                document.getElementById('save-icon').src = 'assets/icons/heart.png'
            }
                
            saveBtn.addEventListener('click', () => {
                if(saveState){
                    saveState = false
                    unsaveMusic()
                    document.getElementById('save-icon').src = 'assets/icons/like.png'
                }else {
                    saveState = true
                    saveMusic()
                    document.getElementById('save-icon').src = 'assets/icons/heart.png'
               }
        })
            
            stopBtn.addEventListener('click', () => {
                audio.currentTime = 0
                document.getElementById('play-icon').src = 'assets/icons/play.png'
                audio.pause();
            })

            audio.addEventListener('canplay', () => {
                document.getElementById('duration').innerHTML = audio.duration.toFixed(2) + " sec"
                
                audio.play()
                document.getElementById('play-icon').src = 'assets/icons/paused.png'
            })

            audio.addEventListener('timeupdate', () => {
                seekBar.value = (audio.currentTime / audio.duration) * 100
                
            })

            volumeBar.addEventListener('input', () => {
                audio.volume = volumeBar.value * 0.01
            })

            seekBar.addEventListener('input', ()=> {
                audio.currentTime = (seekBar.value /100) * audio.duration
            })

            // Play pause the music
            document.getElementById('play-pause').addEventListener('click', () => {
                if(audio.paused) {
                    audio.play()
                    document.getElementById('play-icon').src = 'assets/icons/paused.png'
                } else {
                    audio.pause()
                    document.getElementById('play-icon').src = 'assets/icons/play.png'
                }
            })
            
            audio.onended = changeNext
        
        })
        
        function logout() {
            window.location.href = "server/logout.jsp"
        }
    </script>
</html>
