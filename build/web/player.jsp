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
Music music = new Music("MU0000000000000001");
//music.fetchValuesFromDatabase(); // Fetch values from database

System.out.println(music.getMusicID() + "This is form me");
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
                <h1 class="music-title"></h1>
                <h3 class="artist-name"></h3>
             </div>

             <div class="row player-row">
                <div class="cover-image column">

                </div>
                 

                <div class="music-description column">
                    <label for="">Music Name:</label>
                    <h3>Despacito daddy yanki</h3>

                    <label for="">Artist</label>
                    <h3>Despacito daddy yanki</h3>
                </div>
                 
             </div>

            <div class="row music-controls">
                 <audio src="https://firebasestorage.googleapis.com/v0/b/beatboxify-rad.appspot.com/o/audio%2FAala%20Lawan%20%20%E0%B6%86%E0%B6%BD%20%E0%B6%BD%E0%B7%80%E0%B6%B1%E0%B7%8A%20-%20Sanjula%20Himala%20ft%20Dulan%20ARX%20(Official%20Music%C2%A0Video).mp3?alt=media&token=8f0998a6-28fa-45f6-a5d1-d37f4e24f0d0" autoplay="1" controls id="audio" style="visibility: hidden"></audio>
                
                 <input type="range" value="0" max="100" class="seek-bar" id="seek-bar">
                

                 <div class="controller">
                    <button class="control-btn"><img src="assets/icons/previous.png" alt="" width="50px"></button>
                    <button class="control-btn" id="play-pause"><img src="assets/icons/play.png" alt="" width="70px" id="play-icon"></button>
                    <button class="control-btn"><img src="assets/icons/next.png" alt="" width="50px"></button>
                 </div>
            </div>

        </div>
        
    </body>

    <script>

        document.addEventListener('DOMContentLoaded', () => {
            const audio = document.getElementById('audio')
            const seekBar = document.getElementById('seek-bar')


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

        
        })
    </script>
</html>
