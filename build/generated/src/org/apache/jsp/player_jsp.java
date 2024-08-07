package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import app.classes.User;
import app.classes.Music;

public final class player_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    
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



      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/common.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/player.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"navigation-bar\">\n");
      out.write("            <div class=\"min-container\">\n");
      out.write("                <img src=\"assets/icons/logo.png\" alt=\"logo-image\" width=\"50%\"/>\n");
      out.write("            \n");
      out.write("                <h2>MUSIC STREAMING</h2>\n");
      out.write("                <h4>");
      out.print(user.getUserName() );
      out.write("</h4>\n");
      out.write("                <h3>");
      out.print(user.getEmail() );
      out.write("</h3>\n");
      out.write("                <h5>");
      out.print(user.getUserID() );
      out.write("</h5>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"navigation-elements\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>Music Gallery</li>\n");
      out.write("                    <li><a href=\"playlist.jsp\">My Playlist</a></li>\n");
      out.write("                    <li><a href=\"player.jsp\">Music Player</a></li>\n");
      out.write("                    <li>About</li>\n");
      out.write("                </ul>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button class=\"logout-btn\" onclick=\"logout()\">LOGOUT</button>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("             <div class=\"row\">\n");
      out.write("                <h3>Now Playing....</h3>\n");
      out.write("                <h1 class=\"music-title\">");
      out.print(music.getMusicName() );
      out.write("</h1>\n");
      out.write("                <h3 class=\"artist-name\">");
      out.print(music.getArtistName() );
      out.write("</h3>\n");
      out.write("             </div>\n");
      out.write("\n");
      out.write("             <div class=\"row player-row\">\n");
      out.write("                <div class=\"cover-image column\" style=\"background: url('");
      out.print(music.getCoverURL());
      out.write("'); background-size: cover; background-repeat: no-repeat; background-position: center\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("\n");
      out.write("                <div class=\"music-description column\">\n");
      out.write("                    <label for=\"\">Music Name:</label>\n");
      out.write("                    <h3>");
      out.print(music.getMusicName() );
      out.write("</h3>\n");
      out.write("\n");
      out.write("                    <label for=\"\">Artist</label>\n");
      out.write("                    <h3>");
      out.print(music.getArtistName() );
      out.write("</h3>\n");
      out.write("\n");
      out.write("                    <label for=\"\">Duration</label>\n");
      out.write("                    <h3 id=\"duration\"></h3>\n");
      out.write("                    \n");
      out.write("                    <label for=\"\">Rating</label>\n");
      out.write("                    <h3>");
      out.print(music.getRating() );
      out.write("</h3>\n");
      out.write("                    \n");
      out.write("                    <label for=\"\">Language</label>\n");
      out.write("                    <h3>");
      out.print(music.getLanguage() );
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("             </div>\n");
      out.write("\n");
      out.write("            <div class=\"row music-controls\">\n");
      out.write("                 <audio src=\"");
      out.print(music.getSourceURL());
      out.write("\" autoplay=\"1\" controls id=\"audio\" style=\"visibility: hidden\"></audio>\n");
      out.write("                \n");
      out.write("                 <input type=\"range\" value=\"0\" max=\"100\" class=\"seek-bar\" id=\"seek-bar\">\n");
      out.write("                \n");
      out.write("\n");
      out.write("                 <div class=\"controller\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"more-options left-contoler mini-controller\">\n");
      out.write("                        <button class=\"control-btn\" id='save-btn'><img src=\"assets/icons/like.png\" alt=\"\" width=\"30px\" id='save-icon'></button>\n");
      out.write("                        <button class=\"control-btn\" id=\"stop-btn\"><img src=\"assets/icons/stop.png\" alt=\"\" width=\"30px\"></button>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button class=\"control-btn\" onclick=\"changePrev()\"><img src=\"assets/icons/previous.png\" alt=\"\" width=\"50px\"></button>\n");
      out.write("                    <button class=\"control-btn\" id=\"play-pause\"><img src=\"assets/icons/play.png\" alt=\"\" width=\"70px\" id=\"play-icon\"></button>\n");
      out.write("                    <button class=\"control-btn\" onclick=\"changeNext()\"><img src=\"assets/icons/next.png\" alt=\"\" width=\"50px\"></button>\n");
      out.write("                    \n");
      out.write("                    <div class=\"volume-controller mini-controller\">\n");
      out.write("                        <label for=\"\">Volume</label>\n");
      out.write("                        <input type=\"range\" id=\"volume-bar\" max=\"100\" value=\"");
      out.print(volume );
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        \n");
      out.write("        function saveMusic() {\n");
      out.write("            console.log('music saved')\n");
      out.write("//            window.open('changeSavedMusic.jsp')\n");
      out.write("            fetch(\"changeSavedMusic.jsp?userID=");
      out.print(user.getUserID());
      out.write("&musicID=");
      out.print(music.getMusicID());
      out.write("\").then(success => {\n");
      out.write("                console.log(success);\n");
      out.write("            }).catch(e => {\n");
      out.write("                console.log(e)\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        function unsaveMusic() {\n");
      out.write("            console.log('unsave music')\n");
      out.write("            fetch(\"unsaveMusic.jsp?userID=");
      out.print(user.getUserID());
      out.write("&musicID=");
      out.print(music.getMusicID());
      out.write("\").then(success => {\n");
      out.write("                console.log(success);\n");
      out.write("            }).catch(e => {\n");
      out.write("                console.log(e)\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        function changeNext() {\n");
      out.write("            window.location.href = 'player.jsp?musicID=");
      out.print(music.getNextRecord() );
      out.write("&v=' + document.getElementById('volume-bar').value\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function changePrev() {\n");
      out.write("            window.location.href = 'player.jsp?musicID=");
      out.print(music.getPreviousRecord() );
      out.write("&v=' + document.getElementById('volume-bar').value\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("\n");
      out.write("        document.addEventListener('DOMContentLoaded', () => {\n");
      out.write("            const audio = document.getElementById('audio')\n");
      out.write("            const seekBar = document.getElementById('seek-bar')\n");
      out.write("            const volumeBar = document.getElementById('volume-bar')\n");
      out.write("            \n");
      out.write("            const stopBtn = document.getElementById('stop-btn')\n");
      out.write("            const saveBtn = document.getElementById('save-btn')\n");
      out.write("\n");
      out.write("            audio.volume = '");
      out.print(volume*0.01 );
      out.write("'\n");
      out.write("            \n");
      out.write("            let saveState = ");
      out.print(favState );
      out.write("\n");
      out.write("            if(saveState) {\n");
      out.write("                document.getElementById('save-icon').src = 'assets/icons/heart.png'\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            saveBtn.addEventListener('click', () => {\n");
      out.write("                if(saveState){\n");
      out.write("                    saveState = false\n");
      out.write("                    unsaveMusic()\n");
      out.write("                    document.getElementById('save-icon').src = 'assets/icons/like.png'\n");
      out.write("                }else {\n");
      out.write("                    saveState = true\n");
      out.write("                    saveMusic()\n");
      out.write("                    document.getElementById('save-icon').src = 'assets/icons/heart.png'\n");
      out.write("               }\n");
      out.write("        })\n");
      out.write("            \n");
      out.write("            stopBtn.addEventListener('click', () => {\n");
      out.write("                audio.currentTime = 0\n");
      out.write("                document.getElementById('play-icon').src = 'assets/icons/play.png'\n");
      out.write("                audio.pause();\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            audio.addEventListener('canplay', () => {\n");
      out.write("                document.getElementById('duration').innerHTML = audio.duration.toFixed(2) + \" sec\"\n");
      out.write("                \n");
      out.write("                audio.play()\n");
      out.write("                document.getElementById('play-icon').src = 'assets/icons/paused.png'\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            audio.addEventListener('timeupdate', () => {\n");
      out.write("                seekBar.value = (audio.currentTime / audio.duration) * 100\n");
      out.write("                \n");
      out.write("            })\n");
      out.write("\n");
      out.write("            volumeBar.addEventListener('input', () => {\n");
      out.write("                audio.volume = volumeBar.value * 0.01\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            seekBar.addEventListener('input', ()=> {\n");
      out.write("                audio.currentTime = (seekBar.value /100) * audio.duration\n");
      out.write("            })\n");
      out.write("\n");
      out.write("            // Play pause the music\n");
      out.write("            document.getElementById('play-pause').addEventListener('click', () => {\n");
      out.write("                if(audio.paused) {\n");
      out.write("                    audio.play()\n");
      out.write("                    document.getElementById('play-icon').src = 'assets/icons/paused.png'\n");
      out.write("                } else {\n");
      out.write("                    audio.pause()\n");
      out.write("                    document.getElementById('play-icon').src = 'assets/icons/play.png'\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("            \n");
      out.write("            audio.onended = changeNext\n");
      out.write("        \n");
      out.write("        })\n");
      out.write("        \n");
      out.write("        function logout() {\n");
      out.write("            window.location.href = \"server/logout.jsp\"\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
