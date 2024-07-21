<%-- 
    Document   : player
    Created on : Jul 18, 2024, 1:25:27 PM
    Author     : Sachindu Kavishka
--%>

<%@page import="app.classes.Music"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String musicID = request.getParameter("musicID");
if(musicID == null) {
    musicID = "MU0000000000000001";
}
Music music = new Music(musicID);
music.fetchValuesFromDatabase(); // Fetch values from database


music.getNextRecord();
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
                <h3>Sachindu Kavishka</h3>
                <h4>US0000000000001</h4>

            </div>


            <div class="navigation-elements">
                <ul>
                    <li>App Gallery</li>
                    <li>Play List</li>
                    <li>About</li>
                </ul>
                    

            </div>


            <button class="logout-btn">LOGOUT</button>
            
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
                    <button class="control-btn" onclick="changePrev()"><img src="assets/icons/previous.png" alt="" width="50px"></button>
                    <button class="control-btn" id="play-pause"><img src="assets/icons/play.png" alt="" width="70px" id="play-icon"></button>
                    <button class="control-btn" onclick="changeNext()"><img src="assets/icons/next.png" alt="" width="50px"></button>
                 </div>
            </div>

        </div>
        
    </body>

    <script>
        function changeNext() {
            window.location.href = 'player.jsp?musicID=<%=music.getNextRecord() %>'
        }
        
        function changePrev() {
            window.location.href = 'player.jsp?musicID=<%=music.getPreviousRecord() %>'
        }
        

        document.addEventListener('DOMContentLoaded', () => {
            const audio = document.getElementById('audio')
            const seekBar = document.getElementById('seek-bar')

            

            audio.addEventListener('canplay', () => {
                document.getElementById('duration').innerHTML = audio.duration.toFixed(2) + " sec"
                audio.play()
                document.getElementById('play-icon').src = 'assets/icons/paused.png'
            })

            audio.addEventListener('timeupdate', () => {
                seekBar.value = (audio.currentTime / audio.duration) * 100
                
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
    </script>
</html>
